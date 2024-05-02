/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditBCImpl.java
*@FileTitle : AGNCommAuditBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration.AGNCommAuditDBDAO;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditConfirmVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0008Event,AGNCommAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommAuditBCImpl extends BasicCommandSupport implements AGNCommAuditBC {

	// Database Access Object
	private transient AGNCommAuditDBDAO dbDao = null;

	/**
	 * AGNCommAuditBCImpl 객체 생성<br>
	 * AGNCommAuditDBDAO를 생성한다.<br>
	 */
	public AGNCommAuditBCImpl() {
		dbDao = new AGNCommAuditDBDAO();
	}

	/**
	 * [ESM_ACM_0008]
	 * Agent Commission Audit 목록을 조회<br>
	 *
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @return List<AGNCommAuditVO>
	 * @exception EventException
	 */
	public List<AGNCommAuditVO> searchAGNCommAudit(AGNCommAuditVO agnCommAuditVO) throws EventException {
		try {
			return dbDao.searchAGNCommAudit(agnCommAuditVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_017]
	 * Audit Confirm 팝업 화면 목록 조회(Audit Number) <br>
	 *
	 * @param AGNCommAuditConfirmVO agnCommAuditConfirmVO
	 * @return List<AGNCommAuditConfirmVO>
	 * @exception EventException
	 */
	public List<AGNCommAuditConfirmVO> searchAGNCommAuditNoConfirmNo(AGNCommAuditConfirmVO agnCommAuditConfirmVO) throws EventException {
		try {
			return dbDao.searchAGNCommAuditConfirmNo(agnCommAuditConfirmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

		
	/**
	 * [ESM_ACM_0008] Retrive<br>
	 * Agent Commission Audit 저장 Audit 버튼<br>
	 * 
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageAGNCommAudit(AGNCommAuditVO agnCommAuditVO, SignOnUserAccount account) throws EventException {
		try {
			List<AGNCommAuditVO> agnCommAuditVOList = new ArrayList<AGNCommAuditVO>();
			
			if (agnCommAuditVO != null) {
				agnCommAuditVO.setUsrId(account.getUsr_id());
				String arOfcCd = agnCommAuditVO.getArOfcCd();
				String bkgNo = agnCommAuditVO.getBkgNo();
				// New Agreement No. 조회 후 setting
				String audNo = dbDao.searchAGNCommAuditConfirmList(agnCommAuditVO).get(0).getAudNo();
				//audNo가 DB에 존재하면 New Aud No를 구한다.
				if(dbDao.checkAudNoExists(audNo)) {
					audNo = dbDao.getNewAudNo(audNo);
				}
				//화면에서 넘긴 파라미터
				agnCommAuditVO.setAudNo(audNo);
				agnCommAuditVO.setArOfcCd(arOfcCd);
				agnCommAuditVO.setBkgNo(bkgNo);
	
				agnCommAuditVOList.add(agnCommAuditVO);
				dbDao.modifyAGNCommAudit(agnCommAuditVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0008] Reject
	 * Agent Commission Audit 화면의 Reject 저장
	 * @param agnCommAuditVOs
	 * @param account
	 * @param acTpCd
	 * @throws EventException
	 */
	public void rejectAGNCommAudit(AGNCommAuditVO[] agnCommAuditVOs, SignOnUserAccount account, String acTpCd) throws EventException {
		List<AGNCommAuditVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<AGNCommAuditVO>(); 
			for(int i=0; i<agnCommAuditVOs.length; i++) {
				agnCommAuditVOs[i].setUsrId(account.getUsr_id());
				agnCommAuditVOs[i].setAcTpCd(acTpCd);
				updateVoList.add(agnCommAuditVOs[i]);
			}
			dbDao.rejectAGNCommAudit(updateVoList, acTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [ESM_ACM_0008] Audit Cancel<br>
	 * Agent Commission Audit 화면의 Audit Cancel  <br>
	 *
	 * @param AGNCommAuditVO[] agnCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void auditCancelAGNCommAudit(AGNCommAuditVO[] agnCommAuditVOs, SignOnUserAccount account) throws EventException {
		List<AGNCommAuditVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<AGNCommAuditVO>(); 
			for(int i=0; i<agnCommAuditVOs.length; i++) {
				agnCommAuditVOs[i].setUsrId(account.getUsr_id());
				updateVoList.add(agnCommAuditVOs[i]);
			}
			dbDao.auditCancelAGNCommAudit(updateVoList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}