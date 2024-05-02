/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommAuditBCImpl.java
*@FileTitle : OTRCommAuditBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.integration.OTRCommAuditDBDAO;
import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.vo.OTRCommAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0015Event,OTRCommAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OTRCommAuditBCImpl extends BasicCommandSupport implements OTRCommAuditBC {

	// Database Access Object
	private transient OTRCommAuditDBDAO dbDao = null;

	/**
	 * OTRCommAuditBCImpl 객체 생성<br>
	 * OTRCommAuditDBDAO를 생성한다.<br>
	 */
	public OTRCommAuditBCImpl() {
		dbDao = new OTRCommAuditDBDAO();
	}

	/**
	 * [ESM_ACM_0015]
	 *   Other Commission Audit 목록을 조회<br>
	 *
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @return List<OTRCommAuditVO>
	 * @exception EventException
	 */
	public List<OTRCommAuditVO> searchOTRCommAudit(OTRCommAuditVO otrCommAuditVO) throws EventException {
		try {
			return dbDao.searchOTRCommAudit(otrCommAuditVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * [ESM_ACM_0015] Audit<br>
	 * Other Commission Audit 저장 Audit 버튼<br>
	 * 
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageAGNCommAudit(OTRCommAuditVO otrCommAuditVO, SignOnUserAccount account) throws EventException {
		try {
			List<OTRCommAuditVO> otrCommAuditVOList = new ArrayList<OTRCommAuditVO>();
			
			if (otrCommAuditVO != null) {
				otrCommAuditVO.setUsrId(account.getUsr_id());
				String arOfcCd = otrCommAuditVO.getArOfcCd();
				String bkgNo = otrCommAuditVO.getBkgNo();
				// New Agreement No. 조회 후 setting
				String audNo = dbDao.searchAGNCommAuditConfirmList(otrCommAuditVO).get(0).getAudNo();
				//audNo가 DB에 존재하면 New Aud No를 구한다.
				if(dbDao.checkAudNoExists(audNo)) {
					audNo = dbDao.getNewAudNo(audNo);
				}
				//화면에서 넘긴 파라미터
				otrCommAuditVO.setAudNo(audNo);
				otrCommAuditVO.setArOfcCd(arOfcCd);
				otrCommAuditVO.setBkgNo(bkgNo);
	
				otrCommAuditVOList.add(otrCommAuditVO);
				dbDao.modifyAGNCommAudit(otrCommAuditVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param OTRCommAuditVO[] otrCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectOtrAGNCommAudit(OTRCommAuditVO[] otrCommAuditVOs, SignOnUserAccount account) throws EventException {
		List<OTRCommAuditVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<OTRCommAuditVO>(); 
			for(int i=0; i<otrCommAuditVOs.length; i++) {
				otrCommAuditVOs[i].setUsrId(account.getUsr_id());
				updateVoList.add(otrCommAuditVOs[i]);
			}
			dbDao.rejectOtrAGNCommAudit(updateVoList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Audit Cancel <br>
	 *
	 * @param OTRCommAuditVO[] otrCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void auditCancelOtrAGNCommAudit(OTRCommAuditVO[] otrCommAuditVOs, SignOnUserAccount account) throws EventException {
		List<OTRCommAuditVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<OTRCommAuditVO>(); 
			for(int i=0; i<otrCommAuditVOs.length; i++) {
				otrCommAuditVOs[i].setUsrId(account.getUsr_id());
				updateVoList.add(otrCommAuditVOs[i]);
			}
			dbDao.auditCancelOtrAGNCommAudit(updateVoList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


}