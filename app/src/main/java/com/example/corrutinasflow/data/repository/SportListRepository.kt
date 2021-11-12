package com.example.corrutinasflow.data.repository

import com.example.corrutinasflow.data.model.SportEntity
import javax.inject.Inject

class SportListRepository @Inject constructor() {

    suspend fun getSportListRepository(): List<SportEntity> {
        val soccerSport = SportEntity(
            1,
            "Fútbol Soccer",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Football_%28Soccer%29.JPG/1024px-Football_%28Soccer%29.JPG"
        )
        val baseballSport = SportEntity(
            2,
            "Baseball",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/A_worn-out_baseball.JPG/2470px-A_worn-out_baseball.JPG"
        )
        val volleyballSport = SportEntity(
            3,
            "Volleyball",
            "https://upload.wikimedia.org/wikipedia/commons/b/bf/Algeria_and_Japan_women%27s_national_volleyball_team_at_the_2012_Summer_Olympics_%287913959028%29.jpg"
        )
        val boxingSport = SportEntity(
            4,
            "Boxeo",
            "https://upload.wikimedia.org/wikipedia/commons/4/4d/Boxing_at_the_2018_Summer_Youth_Olympics_%E2%80%93_Girls%27_flyweight_Bronze_Medal_Bout_068.jpg"
        )
        val tennisSport = SportEntity(
            5,
            "Tenis",
            "https://upload.wikimedia.org/wikipedia/commons/3/3e/Tennis_Racket_and_Balls.jpg"
        )
        val rugbySport = SportEntity(
            6,
            "Rugby",
            "https://upload.wikimedia.org/wikipedia/commons/6/6a/New_Zealand_national_rugby_20191101d4.jpg"
        )
        val hokeySport = SportEntity(
            7,
            "Hokey",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/2020-01-21_Ice_hockey_at_the_2020_Winter_Youth_Olympics_%E2%80%93_Women%27s_tournament_%E2%80%93_Gold_Medal_Game_%28Martin_Rulsch%29_068.jpg/2560px-2020-01-21_Ice_hockey_at_the_2020_Winter_Youth_Olympics_%E2%80%93_Women%27s_tournament_%E2%80%93_Gold_Medal_Game_%28Martin_Rulsch%29_068.jpg"
        )
        val golfSport = SportEntity(
            8,
            "Golf",
            "https://upload.wikimedia.org/wikipedia/commons/d/d9/Golf_ball_2.jpg"
        )
        val chessSport = SportEntity(
            9,
            "Chess",
            "https://upload.wikimedia.org/wikipedia/commons/8/8c/Chess_Large.JPG"
        )
        return listOf(
            soccerSport, baseballSport, volleyballSport, boxingSport, tennisSport,
            rugbySport, hokeySport, golfSport, chessSport
        )
    }
}