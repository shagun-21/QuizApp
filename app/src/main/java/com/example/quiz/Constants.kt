package com.example.quiz

object Constants{
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val ques1=Question(1,"what country does this flag belong to ",
            R.drawable.argentina_flag,
            "Argentina",
            "Australia",
            "South Africa",
            "India",
            1)
        questionList.add(ques1)

        val ques2=Question(2,"what country does this flag belong to ",
            R.drawable.asutralia_flag,
            "Argentina",
            "Australia",
            "South Africa",
            "India",
            2)
        questionList.add(ques2)

        val ques3=Question(3,"what country does this flag belong to ",
            R.drawable.south_africa_flag,
            "Argentina",
            "Australia",
            "South Africa",
            "India",
            3)
        questionList.add(ques3)

        val ques4=Question(4,"what country does this flag belong to ",
            R.drawable.india_flag,
            "Argentina",
            "Australia",
            "South Africa",
            "India",
            4)
        questionList.add(ques4)

        val ques5=Question(5,"what country does this flag belong to ",
            R.drawable.new_zealend,
            "Argentina",
            "Australia",
            "New Zealand",
            "India",
            3)
        questionList.add(ques5)

        val ques6=Question(6,"what country does this flag belong to ",
            R.drawable.america_flag,
            "America",
            "Australia",
            "New Zealand",
            "India",
            1)
        questionList.add(ques6)

        val ques7=Question(7,"what country does this flag belong to ",
            R.drawable.russia_flag,
            "America",
            "Russia",
            "New Zealand",
            "India",
            2)
        questionList.add(ques7)

        val ques8=Question(8,"what country does this flag belong to ",
            R.drawable.england_flag,
            "America",
            "Russia",
            "England",
            "India",
            3)
        questionList.add(ques8)

        val ques9=Question(9,"what country does this flag belong to ",
            R.drawable.sri_lanka_flag,
            "America",
            "Russia",
            "England",
            "Sri lanka",
            4)
        questionList.add(ques9)

        val ques10=Question(10,"what country does this flag belong to ",
            R.drawable.west_indies_flag,
            "America",
            "West Indies",
            "England",
            "Sri lanka",
            2)
        questionList.add(ques10)


        return questionList
    }
}