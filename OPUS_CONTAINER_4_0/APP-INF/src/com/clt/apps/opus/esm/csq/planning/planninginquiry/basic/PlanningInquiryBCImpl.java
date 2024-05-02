/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : planningInquiryBCImpl.java
*@FileTitle      : planningInquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.29
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.29 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planninginquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration.QtaInquiryDBDAO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.integration.PlanningInquiryDBDAO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchPlanningQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchQtaInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-QtaInquiry Business Logic Command Interface<br>
 * - ALPS-QtaInquiry 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see QtaInquiryDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PlanningInquiryBCImpl extends BasicCommandSupport implements PlanningInquiryBC {
	
	// Database Access Object
	private transient PlanningInquiryDBDAO dbDao = null;
	
	/**
	 * QtaInquiryBCImpl 객체 생성<br>
	 * QtaInquiryDBDAO를 생성한다.<br>
	 */
	public PlanningInquiryBCImpl() {
		dbDao = new PlanningInquiryDBDAO();
	}
	
	/**
	 * ESM_CSQ_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Planning]을 [조회] 합니다
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaInquiryListVO>
	 * @throws EventException
	 */
	public List<SearchQtaInquiryListVO> searchQtaInquiryList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaInquiryList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0217 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Yearly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPlanningQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaYrIasSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPlanningQtaYrIasSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_CSQ_0218 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Quarterly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPlanningQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaQtrIasSector(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPlanningQtaQtrIasSector(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}