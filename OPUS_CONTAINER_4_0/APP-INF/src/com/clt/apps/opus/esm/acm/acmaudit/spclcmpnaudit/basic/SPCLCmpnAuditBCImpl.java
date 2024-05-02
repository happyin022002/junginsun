/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditBCImpl.java
*@FileTitle : AGNCommAuditBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.23 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.integration.SPCLCmpnAuditDBDAO;
import com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.vo.SPCLCmpnAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0029Event,SPCLCmpnAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SPCLCmpnAuditBCImpl extends BasicCommandSupport implements SPCLCmpnAuditBC {

	// Database Access Object
	private transient SPCLCmpnAuditDBDAO dbDao = null;

	/**
	 * AGNCommAuditBCImpl 객체 생성<br>
	 * AGNCommAuditDBDAO를 생성한다.<br>
	 */
	public SPCLCmpnAuditBCImpl() {
		dbDao = new SPCLCmpnAuditDBDAO();
	}

	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 조회<br>
	 *
	 * @param SPCLCmpnAuditVO spcLCmpnAuditVO
	 * @return List<SPCLCmpnAuditVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnAuditVO> searchSPCLCmpnAudit(SPCLCmpnAuditVO spcLCmpnAuditVO) throws EventException {
		try {
			return dbDao.searchSPCLCmpnAudit(spcLCmpnAuditVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}




	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 저장<br>
	 * [pay chk]가 PAY_CHK_FLG --->Y 또는 Null 로 업데이트
	 *
	 * @param SPCLCmpnAuditVO[] spcLCmpnAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void manageSPCLCmpnAudit(SPCLCmpnAuditVO[] spcLCmpnAuditVOs,SignOnUserAccount account) throws EventException {
		try {
			List<SPCLCmpnAuditVO> updateVoList = new ArrayList<SPCLCmpnAuditVO>();
			for (int i=0; i<spcLCmpnAuditVOs.length; i++) {
				spcLCmpnAuditVOs[i].setUsrId(account.getUsr_id());
				if (spcLCmpnAuditVOs[i].getIbflag().equals("U")) {
					updateVoList.add(spcLCmpnAuditVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.manageSPCLCmpnAudit(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


}