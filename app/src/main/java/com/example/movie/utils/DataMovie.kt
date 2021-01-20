package com.example.movie.utils

import com.example.movie.data.source.local.entity.Movie
import com.example.movie.data.source.local.entity.TvShow
import com.example.movie.data.source.remote.response.item.MoviesItem
import com.example.movie.data.source.remote.response.item.TvShowItem


object DataMovie {
    fun generateDataMovie(): ArrayList<Movie> {
        val movies = ArrayList<Movie>()
        movies.add(
            Movie(
                464052,
                "Wonder Woman 1984",
                "2020-12-16",
                "en",
                4167.11,
                2255,
                7.3,
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg"
            )
        )
        movies.add(
            Movie(
                517096,
                "Aquaman (2018) ",
                "HCosmoball",
                "ru",
                2856.461,
                30,
                4.7,
                "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                "/ibwOX4xUndc6E90MYfglghWvO5Z.jpg"
            )
        )
        movies.add(
            Movie(
                508442,
                "Soul",
                "2020-12-25",
                "en",
                3283.369,
                2900,
                8.4,
                "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg"
            )
        )
        movies.add(
            Movie(
                755812,
                "Miraculous World: New York, United HeroeZ",
                "2020-10-10",
                "fr",
                2551.694,
                235,
                8.6,
                "During a school field trip, Ladybug and Cat Noir meet the American superheroes, whom they have to save from an akumatised super-villain. They discover that Miraculous exist in the United States too.",
                "/kIHgjAkuzvKBnmdstpBOo4AfZah.jpg",
                "/yR27bZPIkNhpGEIP3jKV2EifTgo.jpg"
            )
        )
        movies.add(
            Movie(
                614911,
                "The Midnight Sky",
                "2020-12-10",
                "en",
                2058.091,
                784,
                6.0,
                "A lone scientist in the Arctic races to contact a crew of astronauts returning home to a mysterious global catastrophe.",
                "/51JxCk77ZCqLzbLkrDl9Qho6KUh.jpg",
                "/dueiWzWc81UAgnbDAyH4Gjqnh4n.jpg"
            )
        )
        movies.add(
            Movie(
                604822,
                "Vanguard",
                "2020-09-30",
                "zh",
                2304.474,
                113,
                7.4,
                "Covert security company Vanguard is the last hope of survival for an accountant after he is targeted by the world's deadliest mercenary organization.",
                "/vYvppZMvXYheYTWVd8Rnn9nsmNp.jpg",
                "/fX8e94MEWSuTJExndVYxKsmA4Hw.jpg"
            )
        )
        movies.add(
            Movie(
                615677,
                "We Can Be Heroes",
                "2020-12-25",
                "en",
                1857.713,
                182,
                6.2,
                "When alien invaders capture Earth's superheroes, their kids must learn to work together to save their parents - and the planet.",
                "/1S21HpcKY6uQ9UAw68aICmrJaq6.jpg",
                "/UgNke0mMQhQdnX2hEu4cN83M0a.jpg"
            )
        )
        movies.add(
            Movie(
                733317,
                "onsters of Man",
                "2020-11-19",
                "en",
                1398.633,
                111,
                7.3,
                "A robotics company vying to win a lucrative military contract team up with a corrupt CIA agent to conduct an illegal live field test. They deploy four weaponized prototype robots into a suspected drug manufacturing camp in the Golden Triangle, assuming they'd be killing drug runners that no one would miss. Six doctors on a humanitarian mission witness the brutal slaughter and become prime targets.",
                "/1f3qspv64L5FXrRy0MF8X92ieuw.jpg",
                "/z15NpieRw7jL7bKoICwLO5j7FgZ.jpg"
            )
        )
        movies.add(
            Movie(
                646593,
                "Wander",
                "Asian Kungfu Generation",
                "2020-12-04",
                1415.658,
                67,
                5.2,
                "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                "/2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                "/wk58aoyWpMTVkKkdjw889XfWGdL.jpg"
            )
        )
        movies.add(
            Movie(
                743904,
                "Curious George: Go West, Go Wild",
                "2020-09-08",
                "en",
                640.516,
                25,
                6.7,
                "While farm-sitting, George accidentally lets the farm animals escape. Ted, George and wannabe cowboy Emmett must round 'em up, accounting for every animal -- and emerging with some new skills, to boot.",
                "/7WWOiP8F6PHjXpJrnRZfvO2XNW.jpg",
                "/mzMCO3dArUcg1OTmjxi8oZ0FQvK.jpg"
            )
        )
        return movies
    }

    fun generateDataTvShow(): ArrayList<TvShow> {
        val tvShows = ArrayList<TvShow>()
        tvShows.add(
            TvShow(
                77169,
                "Cobra Kai",
                "2018-05-02",
                "en",
                1495.092,
                1529,
                8.1,
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg"
            )
        )
        tvShows.add(
            TvShow(
                79242,
                "Chilling Adventures of Sabrina",
                "2018-10-26",
                "en",
                097.927,
                1988,
                8.4,
                "As her 16th birthday nears, Sabrina must choose between the witch world of her family and the human world of her friends. Based on the Archie comic.",
                "/yxMpoHO0CXP5o9gB7IfsciilQS4.jpg",
                "/8AdmUPTyidDebwIuakqkSt6u1II.jpg"
            )
        )
        tvShows.add(
            TvShow(
                44217,
                "Vikings",
                "2013-03-03",
                "en",
                1022.858,
                3707,
                7.9,
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg"
            )
        )
        tvShows.add(
            TvShow(
                82856,
                "The Mandalorian",
                "2019-11-12",
                "en",
                933.919,
                4983,
                8.5,
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg"
            )
        )
        tvShows.add(
            TvShow(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "en",
                737.299,
                6291,
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/hAxZgHqhQl2aWxsrOtVVDlMuD5m.jpg"
            )
        )
        tvShows.add(
            TvShow(
                1416,
                "Grey's Anatomy",
                "2005-03-27",
                "en",
                626.118,
                4876,
                8.1,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg"
            )
        )
        tvShows.add(
            TvShow(
                69050,
                "Riverdale",
                "2017-01-26",
                "en",
                509.203,
                7512,
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of real small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg\""
            )
        )
        tvShows.add(
            TvShow(
                75006,
                "NCIS (2003) ",
                "2019-02-15",
                "en",
                469.262,
                5185,
                8.7,
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                "/mE3zzMkpP8yqlkzdjPsQmJHceoe.jpg"
            )
        )
        tvShows.add(
            TvShow(
                96648,
                "Sweet Home",
                "2020-12-18",
                "ko",
                467.797,
                219,
                8.5,
                "Cha Hyun-Soo is a high school student. He is also a recluse and rarely leaves his room. He refuses to talk to his father, mother and younger sister. One day, his whole family, except for him, dies in a car accident. Cha Hyun-Soo is left all alone. He moves into a small apartment. At this time, a mysterious phenomenon of humans turning into monster occur all around the world. The residents of Cha Hyun-Soo's apartment building, including Pyeon Sang-Wook, fight against these monsters and try to survive.",
                "/6eMg81CPLalULg8spPt2LxfQtFj.jpg",
                "/9PaJZrGW5qYXfSVJYAmKIEEQMdH.jpg",

                )
        )
        tvShows.add(
            TvShow(
                63174,
                "Lucifer",
                "2016-01-25",
                "en",
                454.623,
                7006,
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDataMovie(): ArrayList<MoviesItem> {

        val movies = ArrayList<MoviesItem>()

        movies.add(
            MoviesItem(
                464052,
                "Wonder Woman 1984",
                "2020-12-16",
                "en",
                4167.11,
                2255,
                7.3,
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg"
            )
        )
        movies.add(
            MoviesItem(
                517096,
                "Aquaman (2018) ",
                "HCosmoball",
                "ru",
                2856.461,
                30,
                4.7,
                "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                "/ibwOX4xUndc6E90MYfglghWvO5Z.jpg"
            )
        )
        movies.add(
            MoviesItem(
                508442,
                "Soul",
                "2020-12-25",
                "en",
                3283.369,
                2900,
                8.4,
                "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg"
            )
        )
        movies.add(
            MoviesItem(
                755812,
                "Miraculous World: New York, United HeroeZ",
                "2020-10-10",
                "fr",
                2551.694,
                235,
                8.6,
                "During a school field trip, Ladybug and Cat Noir meet the American superheroes, whom they have to save from an akumatised super-villain. They discover that Miraculous exist in the United States too.",
                "/kIHgjAkuzvKBnmdstpBOo4AfZah.jpg",
                "/yR27bZPIkNhpGEIP3jKV2EifTgo.jpg"
            )
        )
        movies.add(
            MoviesItem(
                614911,
                "The Midnight Sky",
                "2020-12-10",
                "en",
                2058.091,
                784,
                6.0,
                "A lone scientist in the Arctic races to contact a crew of astronauts returning home to a mysterious global catastrophe.",
                "/51JxCk77ZCqLzbLkrDl9Qho6KUh.jpg",
                "/dueiWzWc81UAgnbDAyH4Gjqnh4n.jpg"
            )
        )
        movies.add(
            MoviesItem(
                604822,
                "Vanguard",
                "2020-09-30",
                "zh",
                2304.474,
                113,
                7.4,
                "Covert security company Vanguard is the last hope of survival for an accountant after he is targeted by the world's deadliest mercenary organization.",
                "/vYvppZMvXYheYTWVd8Rnn9nsmNp.jpg",
                "/fX8e94MEWSuTJExndVYxKsmA4Hw.jpg"
            )
        )
        movies.add(
            MoviesItem(
                615677,
                "We Can Be Heroes",
                "2020-12-25",
                "en",
                1857.713,
                182,
                6.2,
                "When alien invaders capture Earth's superheroes, their kids must learn to work together to save their parents - and the planet.",
                "/1S21HpcKY6uQ9UAw68aICmrJaq6.jpg",
                "/UgNke0mMQhQdnX2hEu4cN83M0a.jpg"
            )
        )
        movies.add(
            MoviesItem(
                733317,
                "onsters of Man",
                "2020-11-19",
                "en",
                1398.633,
                111,
                7.3,
                "A robotics company vying to win a lucrative military contract team up with a corrupt CIA agent to conduct an illegal live field test. They deploy four weaponized prototype robots into a suspected drug manufacturing camp in the Golden Triangle, assuming they'd be killing drug runners that no one would miss. Six doctors on a humanitarian mission witness the brutal slaughter and become prime targets.",
                "/1f3qspv64L5FXrRy0MF8X92ieuw.jpg",
                "/z15NpieRw7jL7bKoICwLO5j7FgZ.jpg"
            )
        )
        movies.add(
            MoviesItem(
                646593,
                "Wander",
                "Asian Kungfu Generation",
                "2020-12-04",
                1415.658,
                67,
                5.2,
                "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                "/2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                "/wk58aoyWpMTVkKkdjw889XfWGdL.jpg"
            )
        )
        movies.add(
            MoviesItem(
                743904,
                "Curious George: Go West, Go Wild",
                "2020-09-08",
                "en",
                640.516,
                25,
                6.7,
                "While farm-sitting, George accidentally lets the farm animals escape. Ted, George and wannabe cowboy Emmett must round 'em up, accounting for every animal -- and emerging with some new skills, to boot.",
                "/7WWOiP8F6PHjXpJrnRZfvO2XNW.jpg",
                "/mzMCO3dArUcg1OTmjxi8oZ0FQvK.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDataTvShow(): ArrayList<TvShowItem> {
        val tvShows = ArrayList<TvShowItem>()
        tvShows.add(
            TvShowItem(
                77169,
                "Cobra Kai",
                "2018-05-02",
                "en",
                1495.092,
                1529,
                8.1,
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                79242,
                "Chilling Adventures of Sabrina",
                "2018-10-26",
                "en",
                097.927,
                1988,
                8.4,
                "As her 16th birthday nears, Sabrina must choose between the witch world of her family and the human world of her friends. Based on the Archie comic.",
                "/yxMpoHO0CXP5o9gB7IfsciilQS4.jpg",
                "/8AdmUPTyidDebwIuakqkSt6u1II.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                44217,
                "Vikings",
                "2013-03-03",
                "en",
                1022.858,
                3707,
                7.9,
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                82856,
                "The Mandalorian",
                "2019-11-12",
                "en",
                933.919,
                4983,
                8.5,
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "en",
                737.299,
                6291,
                8.6,
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "/hAxZgHqhQl2aWxsrOtVVDlMuD5m.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                1416,
                "Grey's Anatomy",
                "2005-03-27",
                "en",
                626.118,
                4876,
                8.1,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                69050,
                "Riverdale",
                "2017-01-26",
                "en",
                509.203,
                7512,
                8.6,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of real small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg\""
            )
        )
        tvShows.add(
            TvShowItem(
                75006,
                "NCIS (2003) ",
                "2019-02-15",
                "en",
                469.262,
                5185,
                8.7,
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                "/mE3zzMkpP8yqlkzdjPsQmJHceoe.jpg"
            )
        )
        tvShows.add(
            TvShowItem(
                96648,
                "Sweet Home",
                "2020-12-18",
                "ko",
                467.797,
                219,
                8.5,
                "Cha Hyun-Soo is a high school student. He is also a recluse and rarely leaves his room. He refuses to talk to his father, mother and younger sister. One day, his whole family, except for him, dies in a car accident. Cha Hyun-Soo is left all alone. He moves into a small apartment. At this time, a mysterious phenomenon of humans turning into monster occur all around the world. The residents of Cha Hyun-Soo's apartment building, including Pyeon Sang-Wook, fight against these monsters and try to survive.",
                "/6eMg81CPLalULg8spPt2LxfQtFj.jpg",
                "/9PaJZrGW5qYXfSVJYAmKIEEQMdH.jpg",

                )
        )
        tvShows.add(
            TvShowItem(
                63174,
                "Lucifer",
                "2016-01-25",
                "en",
                454.623,
                7006,
                8.5,
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg"
            )
        )
        return tvShows
    }
}
