package io.javaproj.epl_dashboard.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import io.javaproj.epl_dashboard.model.Match;

@Configuration
@EnableBatchProcessing
public class Batchconfig {

    private final String[] FIELD_NAMES = new String[] {
            "id", "Date", "homeTeam", "awayTeam", "FTHG", "FTAG", "FTR", "HTGS", "ATGS", "HTGC", "ATGC",
            "HTP", "ATP", "HM1", "HM2", "HM3", "HM4", "HM5", "AM1", "AM2", "AM3", "AM4", "AM5", "MW", "HTFormPtsStr",
            "ATFormPtsStr", "HTFormPts", "ATFormPts",
            "HTWinStreak3", "HTWinStreak5", "HTLossStreak3", "HTLossStreak5", "ATWinStreak3", "ATWinStreak5",
            "ATLossStreak3", "ATLossStreak5", "HTGD",
            "ATGD", "DiffPts", "DiffFormPts"
    };

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<matchInput> reader() {
        return new FlatFileItemReaderBuilder<matchInput>().name("matchItemReader")
                .resource(new ClassPathResource("epl_dataset.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<matchInput>() {
                    {
                        setTargetType(matchInput.class);
                    }
                })
                .build();
    }

    @Bean
    public matchDataProcessor processor() {
        return new matchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO match(id, date,home_team,away_team,fthg,ftag,ftr,htgs,atgs,htgc,atgc, hm1, hm2, hm3, hm4, hm5, am1, am2, am3, am4, am5, mw,htform_pts_str,atform_pts_str, htwin_streak3, htwin_streak5, atwin_streak3, atwin_streak5, atloss_streak3, atloss_streak5, htgd, atgd) "
                        + " VALUES (:id,:date,:homeTeam,:awayTeam,:FTHG,:FTAG,:FTR,:HTGS,:ATGS,:HTGC,:ATGC,:HM1,:HM2,:HM3,:HM4,:HM5,:AM1,:AM2,:AM3,:AM4,:AM5,:MW,:HTFormPtsStr,:ATFormPtsStr,:HTWinStreak3,:HTWinStreak5,:ATWinStreak3,:ATWinStreak5,:ATLossStreak3,:ATLossStreak5,:HTGD,:ATGD)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Match> writer) {
        return stepBuilderFactory.get("step1")
                .<matchInput, Match>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
