package com.example.util;

import com.example.myforg.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

/**
 * @Todo ����������
 * @author Wenson
 *
 */
public class SoundPlayer{

	private static MediaPlayer music;
	private static SoundPool soundPool;
	
	private static boolean musicSt = true; //���ֿ���
	private static boolean soundSt = true; //��Ч����
	private static Context context;
	
	private static final int[] musicId = {R.raw.forgbg};
	private static Map<Integer,Integer> soundMap; //��Ч��Դid����ع������Դid��ӳ���ϵ��
	
	/**
	 * ��ʼ������
	 * @param c
	 */
	public static void init(Context c)
	{
		context = c;

		initMusic();
		
		initSound();
	}
	
	//��ʼ����Ч������
	@SuppressLint("UseSparseArrays")
	private static void initSound()
	{
		soundPool = new SoundPool(2,AudioManager.STREAM_MUSIC,100);
		
		soundMap = new HashMap<Integer,Integer>();
		soundMap.put(R.raw.clap, soundPool.load(context, R.raw.clap, 1));
	}
	
	//��ʼ�����ֲ�����
	private static void initMusic()
	{
		int r = new Random().nextInt(musicId.length);
		music = MediaPlayer.create(context,musicId[r]);
		music.setLooping(true);
	}
	
	/**
	 * ������Ч
	 * @param resId ��Ч��Դid
	 */
	public static void playSound(int resId)
	{
		if(soundSt == false)
			return;
		
		Integer soundId = soundMap.get(resId);
		if(soundId != null)
			soundPool.play(soundId, 1, 1, 1, 0, 1);
	}

	/**
	 * ��ͣ����
	 */
	public static void pauseMusic()
	{
		if(music.isPlaying())
			music.pause();
	}
	
	/**
	 * ��������
	 */
	public static void startMusic()
	{
		if(musicSt)
			music.start();
	}
	
	/**
	 * �л�һ�����ֲ�����
	 */
	public static void changeAndPlayMusic()
	{
		if(music != null)
			music.release();
		initMusic();
		startMusic();
	}
	
	/**
	 * ������ֿ���״̬
	 * @return
	 */
	public static boolean isMusicSt() {
		return musicSt;
	}
	
	/**
	 * �������ֿ���
	 * @param musicSt
	 */
	public static void setMusicSt(boolean musicSt) {
		SoundPlayer.musicSt = musicSt;
		if(musicSt)
			music.start();
		else
			music.stop();
	}

	/**
	 * �����Ч����״̬
	 * @return
	 */
	public static boolean isSoundSt() {
		return soundSt;
	}

	/**
	 * ������Ч����
	 * @param soundSt
	 */
	public static void setSoundSt(boolean soundSt) {
		SoundPlayer.soundSt = soundSt;
	}
	
	/**
	 * �������Ƶ�����
	 */
	public static void clap()
	{
		playSound(R.raw.clap);
	}
}