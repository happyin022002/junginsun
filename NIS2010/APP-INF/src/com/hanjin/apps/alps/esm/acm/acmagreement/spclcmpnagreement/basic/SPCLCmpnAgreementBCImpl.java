/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAgreementBCImpl.java
*@FileTitle : SPCLCmpnAgreementBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.integration.SPCLCmpnAgreementDBDAO;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0025Event,SPCLCmpnAgreementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SPCLCmpnAgreementBCImpl extends BasicCommandSupport implements SPCLCmpnAgreementBC {

	// Database Access Object
	private transient SPCLCmpnAgreementDBDAO dbDao = null;

	/**
	 * SPCLCmpnAgreementBCImpl 객체 생성<br>
	 * AGNCommAgreementDBDAO를 생성한다.<br>
	 */
	public SPCLCmpnAgreementBCImpl() {
		dbDao = new SPCLCmpnAgreementDBDAO();
	}

	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param SCompAgreementVO scompAgreementVO
	 * @return List<SCompAgreementVO>
	 * @exception EventException
	 */
	public List<SCompAgreementVO> searchSCompAgreement(SCompAgreementVO scompAgreementVO) throws EventException {
		try {
			return dbDao.searchSCompAgreement(scompAgreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param SCompAgreementVO[] scompAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageSCompAgreement(SCompAgreementVO[] scompAgreementVOs,SignOnUserAccount account) throws EventException {
		try {
			List<SCompAgreementVO> insertVoList = new ArrayList<SCompAgreementVO>();
			List<SCompAgreementVO> updateVoList = new ArrayList<SCompAgreementVO>();
			List<SCompAgreementVO> deleteVoList = new ArrayList<SCompAgreementVO>();
			for (int i=0; i<scompAgreementVOs.length; i++) {
				scompAgreementVOs[i].setUsrId(account.getUsr_id());
				if (scompAgreementVOs[i].getIbflag().equals("I")) {
					insertVoList.add(scompAgreementVOs[i]);
				} else if (scompAgreementVOs[i].getIbflag().equals("U")) {
					updateVoList.add(scompAgreementVOs[i]);
				} else if (scompAgreementVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(scompAgreementVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addSCompAgreement(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySCompAgreement(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				//DELT_FLG 만 "Y"로 업데이트
				dbDao.deleteSCompAgreement(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}