package com.example.myapplication.ui.authority;

import com.example.myapplication.data.ratings.EstablishmentsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by user on 3/30/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorityPresenterTest {

    @Mock
    AuthorityContract.View view;

    @Mock
    EstablishmentsRepository establishmentsRepository;

    private AuthorityPresenter authorityPresenter;

    @Before
    public void setupPresenter() {
        authorityPresenter = new AuthorityPresenter(establishmentsRepository);
        authorityPresenter.attachView(view);
    }

    @Test
    public void canInstantiatePresenter() throws Exception{
        authorityPresenter.loadEstablishments(1, 2);
        verify(establishmentsRepository).loadEstablishments(1, 2);
    }
}