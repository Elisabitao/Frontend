package hikst.frontend.client.callback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import hikst.frontend.client.ErrorMessage;
import hikst.frontend.client.pages.Login;


public class LoginCallback implements AsyncCallback<Boolean> 
{
	Login login;
	

	public LoginCallback(Login login)
	{
		this.login = login;
	}

	@Override
	public void onFailure(Throwable caught) {

		RootLayoutPanel.get().add(new Login());
		login = new Login();
		ErrorMessage.show("Kunne ikke logge inn","Something wrong happend on the serverside, try again later</br>status code 403");

	}

	@Override
	public void onSuccess(Boolean access_granted) {


		if(access_granted)
		{
			ErrorMessage.show("Velkommen hikst", "The quick brown fox jumps over the lazy dog!");
			System.out.println("LoginCallback / access granted");
			login.GoToMainPage();
		}
		else
		{
			RootLayoutPanel.get().add(new Login());
			login = new Login();
			ErrorMessage.show("Kunne ikke logge inn","Feil brukernavn eller passord");
		}
	}

}