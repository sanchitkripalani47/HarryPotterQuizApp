package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import com.example.quizapp.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HpQuiz.db";
    private static final int DATABASE_VERSION = 1;


    private SQLiteDatabase db;

    public QuizHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            this.db = db;


            final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                    QuestionTable.TABLE_NAME + " ( " +
                    QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    QuestionTable.COLUMN_QUESTION + " TEXT, " +
                    QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                    QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                    QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                    QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                    QuestionTable.COLUMN_ANSWER_NUM + " INTEGER " +
                    ")";
            db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
            fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS quiz_questions");
        onCreate(db);
    }

    private void fillQuestionTable() {
        Question q1 = new Question("What are the names of Severus Snape’s parents?", "Theodore Snape and Ethel Prince", "Tobias Snape and Eileen Prince", "Toby Snape and Eileen Prince", "Tripp Snape and Eliana Prince", 2);
        addQuestion(q1);
        Question q2 = new Question("How many Knuts are there in a sickle?", "29 sickles", "17 sickles", "19 sickles", "20 sickles", 1);
        addQuestion(q2);
        Question q3 = new Question("Name the only family which is not pure blood among the following.", "Black", " Potter", "Weasley", "Longbottom", 2);
        addQuestion(q3);
        Question q4 = new Question("Which of these schools is co-ed in the books?", "Hogwarts", "Durmstrang", "Beauxbatons", "All of these", 4);
        addQuestion(q4);
        Question q5 = new Question("Who betrays Dumbledore’s army in the fifth book?", "Justin Finch-Fletchley", "Cho Chang", "Marietta Edgecombe", "Zacharias Smith", 3);
        addQuestion(q5);
        Question q6 = new Question("Who gives Harry the idea to use gillyweed in the fourth book?", "Neville", "Hagrid", "Dobby", "Mad-Eye Moddy", 3);
        addQuestion(q6);
        Question q7 = new Question("Dumbledore has a scar above his left knee that is a perfect map of what?", "Hogwarts ", "The London underground", "Ministry of Magic headquarters", "Hogsmeade", 2);
        addQuestion(q7);
        Question q8 = new Question("What is the name of the driver of Knight’s bus?", "Stan Shunpike", "Ernest Prang", "Ambrosius Flume", "None of the above", 2);
        addQuestion(q8);
        Question q9 = new Question("Which breed of dragon does Fleur Delacour face in the first Triwizard Tournament challenge?", "Chinese Fireball", "Norwegian Ridgeback", "Swedish Short-Snout", "Common Welsh Green", 4);
        addQuestion(q9);
        Question q10 = new Question("How many fouls are there in quidditch?", "823", "500", "700", "600", 3);
        addQuestion(q10);
        Question q11 = new Question("Due to whose death, thestrals are visible to Harry?", "His parents", "Cedric", "Dumbledore", "Sirius Black", 2);
        addQuestion(q11);
        Question q12 = new Question("What does S.P.E.W stand for?", "Society For the Promotion of Elfish Welfare", "Society For the Protection of Elves and Wizards", "Support For People, Elves, and Wizards", "Soronity For the protection of Elves and Wands", 1);
        addQuestion(q12);
        Question q13 = new Question("What is Viktor Krum’s signature move in quidditch, which he uses to fool the irish seeker, in the final?", "Plumpton pass", "Reverse pass", "Sloth Grip Roll", "Wronski Feint", 4);
        addQuestion(q13);
        Question q14 = new Question("Who was Hogwarts headmaster before Albus Dumbledore?", "Nicolas Flamel", "Rufus Scrimgeour", "Armando Dippet", "Phineas Nigellus", 3);
        addQuestion(q14);
        Question q15 = new Question("Name the centaur who taught divination in Hogwarts for a brief period of time.", "Bane ", "Ronan", "Magorian", "Firenze", 4);
        addQuestion(q15);
        Question q16 = new Question("This spell causes the victim to be dangled upside down by his or her ankles. Name the spell.", "Liberacorpus", "Levicorpus", "Petrifigus Totalus", "Protego", 2);
        addQuestion(q16);
        Question q17 = new Question("How many staircases does Hogwarts have?", "142", "143", "150", "163", 1);
        addQuestion(q17);
        Question q18 = new Question("Which Hogwarts professor was rumoured to be a duelling champion in their youth?", "Minerva McGonagall", "Severus Snape ", "Filius Flitwick", "Horace Slughorn", 3);
        addQuestion(q18);
        Question q19 = new Question("Who was Helena Ravenclaw’s lover?", "Salazar Slytherin", "The Bloody Baron", "Godric Gryffindor", "Tom Riddle ", 2);
        addQuestion(q19);
        Question q20 = new Question("What does Dumbledore tell Harry he sees in the Mirror of Erised?", "Himself holding a pair of socks", "Himself ruling the world", "Himself as a cat", "Himself defeating Voldemort", 1);
        addQuestion(q20);
        Question q21 = new Question("Which Hogwarts founder did the Sorting hat originally belong to?", "Rowena Ravenclaw", "Salazar Slytherin ", "Helga Hufflepuff", "Godric Gryffindor ", 4);
        addQuestion(q21);
        Question q22 = new Question("According to the books, what colour are Harry’s eyes?", "Brown", "Green", "Black", "Blue", 2);
        addQuestion(q22);
        Question q23 = new Question("What chess piece does Ron play in the game of Wizard’s Chess in ‘Sorcerer’s Stone’?", "Pawn", "Bishop", "Knight", "King ", 3);
        addQuestion(q23);
        Question q24 = new Question("Harry’s wand has what kind of core?", "Dragon Heartstring", "Veela Hair", "Unicorn tail Hair", "Phoenix feather", 4);
        addQuestion(q24);
        Question q25 = new Question("Which Gringotts’ vault does Hagrid remove something from in the first book?", "713", "872", "711", "687", 1);
        addQuestion(q25);
        Question q26 = new Question("What is the name of the company where Uncle Vernon works?", "Grindr", "Bertie, Botts and Beans", "Grunnings", "Smelting", 3);
        addQuestion(q26);
        Question q27 = new Question("Which character has a grandmother who is a Veela?", "Luna Lovegood", "Fleur Delacour", "Nymphadora Tonks", "Cho Chang", 2);
        addQuestion(q27);
        Question q28 = new Question("How much does a ticket cost for the Knight's bus if it includes hot chocolate?", "10 sickles", "20 sickles", "17 sickles", "14 sickles", 4);
        addQuestion(q28);
        Question q29 = new Question("What is Fred Weasley’s chosen code name on Potterwatch, the secretive radio programme?", "Rappier", "Royal", "Romulus", "Rodent", 1);
        addQuestion(q29);
        Question q30 = new Question("Who were believed to originally possess the Deathly Hallows?", "The Black Family", "The Peverell brothers", "The Gaunt Family", "Founders of Hogwarts", 2);
        addQuestion(q30);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NUM, question.getAnswerNum());

        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM quiz_questions ORDER BY RANDOM() LIMIT 20", null );

        if (c.moveToFirst()){
            do {
                Question question = new Question();

                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
