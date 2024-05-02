/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineBCImpl.java
 *@FileTitle : TrendLine
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.integration.BudgetPlanDBDAO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdCsmVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdInqVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-BudgetPlan Business Logic Basic Command implementation<br>
 * - ALPS-BudgetPlan에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0031EventResponse,BudgetPlanBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BudgetPlanBCImpl extends BasicCommandSupport implements
		BudgetPlanBC {

	// Database Access Object
	private transient BudgetPlanDBDAO dbDao = null;

	/**
	 * BudgetPlanBCImpl 객체 생성<br>
	 * BudgetPlanBCDBDAO 생성한다.<br>
	 */
	public BudgetPlanBCImpl() {
		dbDao = new BudgetPlanDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0031 화면에 대한 조회 이벤트 처리<br>
	 * Budget Plan 기본 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO
	 *            fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdVO>
	 * @exception EventException
	 */
	public List<FcmBudTgtVvdVO> searchBudTgtVvdList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO)
			throws EventException {
		try {
			return dbDao.searchBudTgtVvdList(fcmBudTgtVvdInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Budget Plan Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Budget Plan Report"}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0031 화면에 대한 조회 이벤트 처리<br>
	 * Budget Plan 기본 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO
	 *            fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdCsmVO>
	 * @exception EventException
	 */
	public List<FcmBudTgtVvdCsmVO> searchBudTgtVvdCsmList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO)
			throws EventException {
		try {
			return dbDao.searchBudTgtVvdCmsList(fcmBudTgtVvdInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Budget Plan Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Budget Plan Report"}).getMessage(), ex);
		}
	}		
}
