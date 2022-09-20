package dev.mikeschmidt.a7minuteworkout

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJacks = ExerciseModel(1, "Jumping Jacks", R.drawable.ic_jumping_jacks, false, false)
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(2, "Wall Sit", R.drawable.ic_wall_sit, false, false)
        exerciseList.add(wallSit)

        val pushUps = ExerciseModel(3, "Push Ups", R.drawable.ic_push_up, false, false)
        exerciseList.add(pushUps)

        val abCrunch = ExerciseModel(4, "Crunches", R.drawable.ic_abdominal_crunch, false, false)
        exerciseList.add(abCrunch)

        val highKnees = ExerciseModel(5, "High Knees", R.drawable.ic_high_knees_running_in_place, false, false)
        exerciseList.add(highKnees)

        val lunges = ExerciseModel(6, "Lunges", R.drawable.ic_lunge, false, false)
        exerciseList.add(lunges)

        val plank = ExerciseModel(7, "Plank", R.drawable.ic_plank, false, false)
        exerciseList.add(plank)

        val sidePlank = ExerciseModel(8, "Side Plank", R.drawable.ic_side_plank, false, false)
        exerciseList.add(sidePlank)

        val stepUps = ExerciseModel(9, "Step Ups", R.drawable.ic_step_up_onto_chair, false, false)
        exerciseList.add(stepUps)

        val squat = ExerciseModel(10, "Squats", R.drawable.ic_squat, false, false)
        exerciseList.add(squat)

        val dips = ExerciseModel(11, "Tricep Dips", R.drawable.ic_triceps_dip_on_chair, false, false)
        exerciseList.add(dips)

        val rotatingPushUps = ExerciseModel(12, "Rotating Push Ups", R.drawable.ic_push_up_and_rotation, false, false)
        exerciseList.add(rotatingPushUps)

        return exerciseList
    }
}