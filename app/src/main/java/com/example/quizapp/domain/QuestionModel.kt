package com.example.quizapp.domain

import android.os.Parcel
import android.os.Parcelable

data class QuestionModel(
    val id: Int,
    val question: String?,
    val answer1: String?,
    val answer2: String?,
    val answer3: String?,
    val answer4: String?,
    val correctAnswer: String?,
    val score: Int,
    val picPath: String?,
    var clickedAnswer: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(question)
        parcel.writeString(answer1)
        parcel.writeString(answer2)
        parcel.writeString(answer3)
        parcel.writeString(answer4)
        parcel.writeString(correctAnswer)
        parcel.writeInt(score)
        parcel.writeString(picPath)
        parcel.writeString(clickedAnswer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionModel> {
        override fun createFromParcel(parcel: Parcel): QuestionModel {
            return QuestionModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionModel?> {
            return arrayOfNulls(size)
        }
    }
}
