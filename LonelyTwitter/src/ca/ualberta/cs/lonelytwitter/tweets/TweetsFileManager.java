package ca.ualberta.cs.lonelytwitter.tweets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.util.Log;

public class TweetsFileManager {

	private static final String SAVE_FILE = "file.sav";
	private static final int _ERASE_THE_FILE = 0;
	private Context ctx;

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public List<NormalLonelyTweet> loadTweets() {
		List<NormalLonelyTweet> tweets = new ArrayList<NormalLonelyTweet>();

		try {
			tweets = attemptLoad(tweets);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	@SuppressWarnings("unchecked")
	private List<NormalLonelyTweet> attemptLoad(List<NormalLonelyTweet> tweets)
			throws FileNotFoundException, StreamCorruptedException,
			IOException, OptionalDataException, ClassNotFoundException {
		FileInputStream fis = ctx.openFileInput(SAVE_FILE);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Object o = ois.readObject();

		if (o instanceof ArrayList) {
			tweets = (ArrayList<NormalLonelyTweet>) o;
		} else {
			Log.i("LonelyTwitter", "Error casting");
		}
		return tweets;
	}

	public void saveTweets(List<NormalLonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput(SAVE_FILE, _ERASE_THE_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
