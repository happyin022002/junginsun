/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BATManagementBCImpl.java
*@FileTitle : Batch Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.25 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.batmanagement.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.integration.BATManagementDBDAO;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.vo.BATManagementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-BATManagement Business Logic Command Interface<br>
 * - OPUS-BATManagement 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM BONG-GYOON
 * @see Esm_Acm_0032Event,BATManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BATManagementBCImpl extends BasicCommandSupport implements BATManagementBC {

	// Database Access Object
	private transient BATManagementDBDAO dbDao = null;

	/**
	 * BATManagementBCImpl 객체 생성<br>
	 * BATManagementDBDAO를 생성한다.<br>
	 */
	public BATManagementBCImpl() {
		dbDao = new BATManagementDBDAO();
	}

	/**
	 * [ESM_ACM_0032]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception EventException
	 */
	public List<BATManagementVO> searchBatchManagement(BATManagementVO batManagementVO) throws EventException {
		try {
			return dbDao.searchBatchManagement(batManagementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0032]
	 * Simulation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception EventException
	 */
	public List<BATManagementVO> searchSimBatchManagement(BATManagementVO batManagementVO) throws EventException {
		try {
			return dbDao.searchSimBatchManagement(batManagementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0032] Cancel Batch<br>
	 * 현재 진행되고 있지 않은 Batch Cancel<br>
	 *
	 * @param BATManagementVO[] batManagementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void deleteBatchManagement(BATManagementVO[] batManagementVOs, SignOnUserAccount account) throws EventException {
		List<BATManagementVO> voList = null;

		try {
			voList = new ArrayList<BATManagementVO>();
			for(int i=0; i<batManagementVOs.length; i++) {
				// N_CNT(BAT_FLG = 'N'인 데이터의 개수) 와 TOT_BKG_CNT(BKG_NO 의 Total 개수)가 동일할 때
				if(batManagementVOs[i].getNCnt() != null && batManagementVOs[i].getNCnt().equals(batManagementVOs[i].getTotBkgCnt())) {
					batManagementVOs[i].setUsrId(account.getUsr_id());
					voList.add(batManagementVOs[i]);
				}
			}
			dbDao.deleteBatchManagement(voList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}