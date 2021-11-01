package com.cinema.showtimes

import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UpdateShowTimeService @Autowired constructor(val showTimeRepository: ShowTimeRepository){
    fun update(showTime: ShowTime): ShowTime {

        if(showTime.id == null) //Ensuring we only update instead of saving new instances
            throw IllegalArgumentException("Movie Show Time is not valid")


        return showTimeRepository.findById(showTime.id)
            .map { old ->
                showTimeRepository.save(old.copy(showDateTime = showTime.showDateTime))
            }
            .orElseThrow {
               throw IllegalArgumentException("Movie Show Time is not valid")
            }

    }

}
