package com.example.movie.utils

import com.example.movie.data.Movie
import com.example.movie.data.TvShow


object DataMovie {

    fun generateDataMovie(): ArrayList<Movie> {

        val movies = ArrayList<Movie>()

        movies.add(
                Movie(
                        "MV001",
                        "Alita: Battle Angel",
                        "An angel falls. A warrior rises.",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/8LyWVwDbU4vsOwns8RxOB9aX73l.jpg",
                        "February, 14, 2019 (US)",
                        "71",
                        "Action, Science Fiction, Adventure ",
                        "Rosa Salazar as (Alita), Christoph Waltz as (Dr. Dyson Ido), Jeniffer Connelly as (Chiren), Mahershala Ali as (Vector), Ed Skrein as (Zapan), Jackie Earle as (Grewishka)",
                        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
                )
        )
        movies.add(
                Movie(
                        "MV002",
                        "Aquaman (2018) ",
                        "Home Is Calling",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3RVyfRV8Zfy2VNFtxyrh0rJ9fDa.jpg",
                        "December, 21, 2018 (US)",
                        "69",
                        "Action, Adventure, Fantasy ",
                        "Jason Momoa as (Aquaman), Amber Heard as (Mera), Willem Dafoe as (Nuidis vulko), Patrick Wilson as (Ocean Master), Nicole Kidman as (altana), Dolph Lundgren as (King Nereus), Yahya Abdul-Mateen II  as (Manta), Temuera Morrison as (Thomas Curry)",
                        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                )
        )
        movies.add(
                Movie(
                        "MV003",
                        "Bohemian Rhapsody",
                        "Fearless lives forever",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gbmkFWdtihe1VfydTDsieQ6VfGL.jpg",
                        "November, 02, 2018 (US)",
                        "80",
                        "Music, Drama",
                        "Rami Malek as (Freddie Mercury), Gwilym Lee as (Brian May), Ben Hardy aas (Roger Taylor), Joseph Mazzello as (Jhon Deacon), Lucy Boynton as (Mary Austin), Aidan Gillen as (John Reid)",
                        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success "
                )
        )
        movies.add(
                Movie(
                        "MV004",
                        "Cold Pursuit (2019) ",
                        "Meet Nels Coxman. Citizen of the Year.",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ve02xYXnw846df6hVLZeTvq8xG2.jpg",
                        "February, 08, 2019 (US)",
                        "56",
                        "Action, Crime, Thriller",
                        "Liam Neeson as (Nels Coxman), Laura Dern as (Grace Coxman), Emmy Rossum as (Kim Dash), Michael Eklund as (Steve), Michael Richardson as (Kyle)",
                        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
                )
        )
        movies.add(
                Movie(
                        "MV005",
                        "Creed II (2018)",
                        "There's More to Lose than a Title",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AlNeuM1oMTvlQnredazHIkowSEj.jpg",
                        " November, 21, 2018 (US)",
                        "69",
                        "Drama",
                        "Michael B. Jordan as (Ardonis Creed), Sylvester Stallone as (Rocky), Dolph Lundgren as (Ivan Drago), Florian Munteanu as (Viktor), Tessa Thompson as (Bianca Taylor), Wood Harris as (Tony)",
                        "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
                )
        )
        movies.add(
                Movie(
                        "MV006",
                        "T-34 (2018)",
                        "Fast And Furious On Tanks",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/yGeEa7bkEdTrkTIoZqzirCeVDfZ.jpg",
                        "January, 01, 2019 (RU)",
                        "68",
                        "War, Action, Drama, History ",
                        "Alexander Petrov as (Nikolay Ivushkin), Victor Dobronravov as (Vasilenok), Irina Starshenbaum as (Anya), Vinzenz Kiefer as (Klaus Jäger), Petr Skvortsov as (Lykov), Semyon Treskunov as (Vasiliy Teterya) ",
                        "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles."
                )
        )
        movies.add(
                Movie(
                        "MV007",
                        "Serenity (2019) ",
                        "On Plymouth Island, no one ever dies… unless you break the rules",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/kV8Om14OKvVeFB4esw1JNFk0kfo.jpg",
                        "January, 25, 2019 (US)",
                        "54",
                        "Thriller, Mystery, Drama ",
                        "Matthew McConaughey as (Baker Dill), Anne Hathaway as (Karen Zariakas), Jason Clarke as (Frank Zariakas), Diane Lane as (Constance), Djimon Hounsou as (Duke), Jeremy Strong as (Reid Miller)",
                        "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help."
                )
        )
        movies.add(
                Movie(
                        "MV008",
                        "Glass (2019) ",
                        "You Cannot Contain What You Are",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/dkj0xUrMx4ISiuEjnfA2BlONtgI.jpg",
                        "January, 18, 2019 (US)",
                        "66",
                        " Thriller, Drama, Science Fiction ",
                        "James McAvoy as (Patricia), Bruce Willis as (David Dunn), Anya Taylor-Joy as (Casey Cooke), Sarah Paulson as (Dr. Ellie Staple). Samuel L. Jackson as (Elijah Price / Mr. Glass),  William Turner as (Young Elijah)",
                        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
                )
        )
        movies.add(
                Movie(
                        "MV009",
                        "Master Z: Ip Man Legacy (2018) ",
                        "Asian Kungfu Generation",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/puPdv7xyTM8Zidli3TPjWbAPcWJ.jpg",
                        "December, 26, 2018 (TW) ",
                        "57",
                        "Actions",
                        "Zhang Jin as (Cheung Tin-Chi), Dave Bautista as (Owen Davidson), Liu Yan as (Julia), Xing yu as (Fu), Michelle Yeoh as (Sis Ha),Tony Jaa (Sadi)",
                        "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."
                )
        )
        movies.add(
                Movie(
                        "MV010",
                        "Robin Hood (2018)",
                        "The legend you know. The story you don't.",
                        "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7VuQnjdmS93gkee96ErNPVUNtw6.jpg",
                        "November, 21, 2018 (US)",
                        "59",
                        "Adventure, Action, Thriller ",
                        "Taron Egerton as (Robin of Loxley), Jamie Foxx as (Yahya / John), Ben Mendelsohn as (Sheriff of Nottingham), Eve Hewson as (Marian), Jamie Dornan as (Will Scarlet), Tim Minchin as (Friar Tuck)",
                        "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
                )
        )
        return movies
    }

    fun generateDataTvShow(): ArrayList<TvShow> {

        val tvShows = ArrayList<TvShow>()

        tvShows.add(
                TvShow(
                        "TS001",
                        "Naruto Shippuden the Movie: Road to Ninja (2012) ",
                        "Road To Ninja",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/euiQ3P7E6wPdETmzWQj7kyDiE3D.jpg",
                        "July, 28, 2012 (JP)",
                        "75",
                        "Fantasy, Animation, Action, Adventure ",
                        "Junko Takeuchi as (Naruto), Chie Nakamura as (Sakura), Toshiyuki Morikawa as (Minato), Emi Shinohara as (Kushina), Kazuhiko Inoue as (Kakashi), Naoya Uchida as (Obito), Noriaki Sugiyama as (Sasuke)",
                        "Sixteen years ago, a mysterious masked ninja unleashes a powerful creature known as the Nine-Tailed Demon Fox on the Hidden Leaf Village Konoha, killing many people. In response, the Fourth Hokage Minato Namikaze and his wife Kushina Uzumaki, the Demon Fox's living prison or Jinchūriki, manage to seal the creature inside their newborn son Naruto Uzumaki. With the Tailed Beast sealed, things continued as normal. However, in the present day, peace ended when a group of ninja called the Akatsuki attack Konoha under the guidance of Tobi, the mysterious masked man behind Fox's rampage years ago who intends on executing his plan to rule the world by shrouding it in illusions.",
                )
        )
        tvShows.add(
                TvShow(
                        "TS002",
                        "Dragon Ball Super (2015)",
                        "",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/1Ew5yqldGcy0af9EB3ukoJslVQx.jpg",
                        "July, 28, 2015 (JP)",
                        "82",
                        "Animation, Action & Adventure, Sci-Fi & Fantasy ",
                        "Masako Nozawa as (Son Goku), Takeshi Kusao as (Trunks (voice)), Ryou Horikawa as (Vegeta (voice)), Hiromi Tsuru as (Bulma (voice)), Eiko Yamada (Mai), Yūko Minaguchi as (Videl/Pan (voices)), Naoko Watanabe as (Chichi/Pu'er (voices))",
                        "With Majin Boo defeated half-a-year prior, peace returns to Earth, where Son Goku (now a radish farmer) and his friends now live peaceful lives. However, a new threat appears in the form of Beerus, the God of Destruction. Considered the most terrifying being in the entire universe, Beerus is eager to fight the legendary warrior seen in a prophecy foretold decades ago known as the Super Saiyan God. The series retells the events from the two Dragon Ball Z films, Battle of Gods and Resurrection 'F' before proceeding to an original story about the exploration of alternate universes."
                )
        )
        tvShows.add(
                TvShow(
                        "TS003",
                        "The Simpsons (1989) ",
                        "On your marks, get set, d'oh!",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg",
                        "1989",
                        "78",
                        "Animation, Comedy, Family, Drama ",
                        "Dan Castellaneta as (Homer Simpson), Julie Kavner as (Marge Simpson), Nancy Cartwright as (Bart Simpson), Yeardley Smith as (Lisa Simpson), Hank Azaria as (Apu), Harry Shearer as (Ned Flanders), Tress MacNeille as (Lanely Fontaine)",
                        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
                )
        )
        tvShows.add(
                TvShow(
                        "TS004",
                        "Gotham (2014)",
                        "Before Batman, there was Gotham.",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/97GsCX3k6BbprnBIIMlVKirmhLz.jpg",
                        "2014",
                        "75",
                        "Drama, Fantasy, Crime ",
                        "Ben McKenzie as (James), Donal Logue as (Harvey Bullock), David Mazouz as (Bruce Wayne), Sean Pertwee as (Alfred Pennyworth), Robin Lord Taylor as (Oswald Cobblepot), Erin Richards as (Barbara Kean), Camren Bicondova as (Selina Kyle / Cat)",
                        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"
                )
        )
        tvShows.add(
                TvShow(
                        "TS005",
                        "Hanna (2019) ",
                        "",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/fAretNYOP4Gu8XLo5hxS4taHbwq.jpg",
                        "2019",
                        "74",
                        "Action & Adventure, Drama ",
                        "Esme Creed-Miles as (Hanna), Mireille Enos as (Marissa), Noah Taylor as (Dr. Roland Kunek),Joel Kinnaman as (Erik Heller), Cherrelle Skeete as (Terri Miller), Anthony Welsh as (Leo), Áine Rose Daly as (Trainee 242 / Sandy Phillips)",
                        "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film."
                )
        )
        tvShows.add(
                TvShow("TS006",
                        "Supergirl (2015) ",
                        "A force against fear",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/uQ2jSIxl666ZCjjYV8MQzCirtLx.jpg",
                        "2015",
                        "71",
                        "Action, Adventure, Drama, Science Fiction ",
                        "David Harewood as (Cyborg Superman, J'onn J'onzz / Martian Manhunter), Melissa Benoist as (Kara Danvers / Supergirl / Kara Zor-El), Chyler Leigh as (Alex Danvers),  Mehcad Brooks as (James Olsen / Guardian), Katie McGrath as (Lena Luthor), Jeremy Jordan as (Winn Schott, Winn Schott / Toyman)",
                        "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
                )
        )
        tvShows.add(
                TvShow("TS007",
                        "Marvel's Iron Fist (2017) ",
                        "",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/xHCfWGlxwbtMeeOnTvxUCZRGnkk.jpg",
                        "2017",
                        "65",
                        "Action & Adventure, Drama, Sci-Fi & Fantasy ",
                        "Finn Jones as (Danny Rand), Jessica Henwick as (Colleen Wing), Jessica Stroup as (Joy Meachum), Tom Pelphrey as (Ward Meachum), Sacha Dhawan as (Davos), Rosario Dawson as (Claire Temple)",
                        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
                )
        )
        tvShows.add(
                TvShow("TS008",
                        "NCIS (2003) ",
                        "",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/4VuCtYBvZGq6Rk3gloigwlsTefE.jpg",
                        "2003",
                        "72",
                        "Crime, Action & Adventure, Drama ",
                        "Mark Harmon as (Leroy Jethro Gibbs), David McCallum as (Donald \"Ducky\" Mallard), Sean Murray as (Timothy McGee), Pauley Perrette as (Abby Sciuto), Michael Weatherly as (Tony DiNozzo), Rocky Carroll as (Leon Vance), Brian Dietzen as (Jimmy Palmer) ",
                        "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position."
                )
        )
        tvShows.add(
                TvShow("TS009",
                        "The Flash (2014) ",
                        "The fastest man alive.",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                        "2014",
                        "76",
                        "Drama, Sci-Fi & Fantasy ",
                        "Grant Gustin as (Barry Allen / The Flash, Barry Allen / Savitar), Carlos Valdes as (Cisco Ramon / Vibe, Pablo, Cisco Ramon, Cisco Ramon / Echo, Francisco Ramon / Reverb), Danielle Panabaker as (Killer Frost, Caitlin Snow, Caitlin Frost / Killer Frost), Candice Patton as (ris West-Allen, Millie Foss)",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
                )
        )
        tvShows.add(
                TvShow(
                        "TS010",
                        "Riverdale (2017) ",
                        "Small town. Big secrets.",
                        "https://image.tmdb.org/t/p/w533_and_h300_bestv2/9hvhGtcsGhQY58pukw8w55UEUbL.jpg",
                        "2017",
                        "86",
                        "Drama, Mystery ",
                        "Lili Reinhart as (Elizabeth \"Betty\" Cooper), K.J. Apa as (Archie Andrews), Cole Sprouse as (Jughead Jones), Camila Mendes as (Veronica Lodge), Madelaine Petsch as (Cheryl Blossom), Casey Cott as (Kevin Keller)",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
                )
        )

        return tvShows
    }
}

