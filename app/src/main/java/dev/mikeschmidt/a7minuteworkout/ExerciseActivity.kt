package dev.mikeschmidt.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import dev.mikeschmidt.a7minuteworkout.databinding.ActivityExerciseBinding
import dev.mikeschmidt.a7minuteworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var exerciseTimer: CountDownTimer? = null
    private var restProgress = 0
    private var exerciseProgress = 0

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)
        if(supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        exerciseList = Constants.defaultExerciseList()

        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()
    }

    private fun setupRestView() {
        binding?.flRestProgressBar?.visibility = View.VISIBLE
        binding?.title?.visibility = View.VISIBLE
        binding?.exerciseName?.visibility = View.INVISIBLE
        binding?.flExerciseProgressBar?.visibility = View.INVISIBLE
        binding?.ivImage?.visibility = View.INVISIBLE
        binding?.upcomingLabel?.visibility = View.VISIBLE
        binding?.upcomingExerciseName?.visibility = View.VISIBLE

        if(restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        binding?.upcomingExerciseName?.text = exerciseList!![currentExercisePosition + 1].getName()

        setRestProgressBar()
    }

    private fun setupExerciseView() {
        binding?.flRestProgressBar?.visibility = View.INVISIBLE
        binding?.title?.visibility = View.INVISIBLE
        binding?.exerciseName?.visibility = View.VISIBLE
        binding?.flExerciseProgressBar?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE
        binding?.upcomingLabel?.visibility = View.INVISIBLE
        binding?.upcomingExerciseName?.visibility = View.INVISIBLE

        if(exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.exerciseName?.text = exerciseList!![currentExercisePosition].getName()

        setExerciseProgressBar()
    }

    private fun setRestProgressBar() {
        binding?.restProgressBar?.progress = restProgress

        restTimer = object: CountDownTimer(11000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding?.restProgressBar?.progress = 11 - restProgress
                binding?.timer?.text = (11 - restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        binding?.exerciseProgressBar?.progress = exerciseProgress

        exerciseTimer = object: CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding?.exerciseProgressBar?.progress = 30 - exerciseProgress
                binding?.fullTimer?.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                if(currentExercisePosition < exerciseList?.size!! - 1) {
                    setupRestView()
                }else {
                    Toast.makeText(this@ExerciseActivity, "Congrats! You finished the workout!", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        if(exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        binding = null
    }
}