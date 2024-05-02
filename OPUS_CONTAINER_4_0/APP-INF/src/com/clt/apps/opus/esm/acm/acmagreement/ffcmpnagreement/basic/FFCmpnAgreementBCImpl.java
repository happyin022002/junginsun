/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementBCImpl.java
*@FileTitle : FFCmpnAgreementBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.integration.FFCmpnAgreementDBDAO;
import com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 * - OPUS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0023Event,FFCmpnAgreementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FFCmpnAgreementBCImpl extends BasicCommandSupport implements FFCmpnAgreementBC {

	// Database Access Object
	private transient FFCmpnAgreementDBDAO dbDao = null;

	/**
	 * FFCmpnAgreementBCImpl 객체 생성<br>
	 * AGNCommAgreementDBDAO를 생성한다.<br>
	 */
	public FFCmpnAgreementBCImpl() {
		dbDao = new FFCmpnAgreementDBDAO();
	}

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param FFAgreementVO ffagreementVO
	 * @return List<FFAgreementVO>
	 * @exception EventException
	 */
	public List<FFAgreementVO> searchFFAgreement(FFAgreementVO ffagreementVO) throws EventException {
		try {
			return dbDao.searchFFAgreement(ffagreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 중복 조회<br>
	 *
	 * @param FFAgreementVO[] ffagreementVOs
	 * @return List<FFAgreementVO>
	 * @exception EventException
	 */
	public List<FFAgreementVO> searchFFAgreementDup(FFAgreementVO[] ffagreementVOs) throws EventException {
		List<FFAgreementVO> dupVOs = new ArrayList<FFAgreementVO>();
		try {
			for (int i=0; i<ffagreementVOs.length; i++) {
				if (ffagreementVOs[i].getIbflag().equals("I") ) {
					List<FFAgreementVO> dupList = dbDao.searchFFAgreementDup(ffagreementVOs[i]);
					if (dupList.size() > 0) {
						dupVOs.add(ffagreementVOs[i]);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dupVOs;
	}



	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param FFAgreementVO[] ffagreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFAgreement(FFAgreementVO[] ffagreementVOs, SignOnUserAccount account) throws EventException {
		try {
//			List<FFAgreementVO> insertVoList = new ArrayList<FFAgreementVO>();
			List<FFAgreementVO> updateVoList = new ArrayList<FFAgreementVO>();
			List<FFAgreementVO> deleteVoList = new ArrayList<FFAgreementVO>();
			for (int i=0; i<ffagreementVOs.length; i++) {
				ffagreementVOs[i].setUsrId(account.getUsr_id());
				if (ffagreementVOs[i].getIbflag().equals("I")) {
					dbDao.addFFAgreement(ffagreementVOs[i]);					
				} else if (ffagreementVOs[i].getIbflag().equals("U")) {
					updateVoList.add(ffagreementVOs[i]);
				} else if (ffagreementVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(ffagreementVOs[i]);
				}
			}

//			if (insertVoList.size() > 0) {
//				dbDao.addFFAgreement(insertVoList);
//			}
			if (updateVoList.size() > 0) {
				dbDao.modifyFFAgreement(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.deleteFFAgreement(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}