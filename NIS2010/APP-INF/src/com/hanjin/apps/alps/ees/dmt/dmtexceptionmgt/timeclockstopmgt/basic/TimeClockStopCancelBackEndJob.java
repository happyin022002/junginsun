/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBCImpl.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockChargeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - APLS-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Sung Hwan
 * @see UI_DMT_2010EventResponse,TimeClockStopMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TimeClockStopCancelBackEndJob extends BackEndCommandSupport {
	static final long serialVersionUID = 9016372863642005395L;
	private SignOnUserAccount account;
	private DmtTimeClockStopVO dmtTimeClockStopVO; 

	// Database Access Object
	private TimeClockStopMgtDBDAO dbDao = null;
    
	public TimeClockStopCancelBackEndJob() {
		dbDao = new TimeClockStopMgtDBDAO();
	}
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 */
	public void setTimeClockStopVO(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) {
		this.account = account;
		this.dmtTimeClockStopVO = dmtTimeClockStopVO;
	}

	/**
	 * BackEndJob Start 
	 * @return DmtTimeClockStopVO
	 * @throws Exception
	 */
	public DmtTimeClockStopVO doStart() throws Exception {
		DmtTimeClockStopVO dmtTimeClockStop = new DmtTimeClockStopVO();
		try {
			dmtTimeClockStop = cancelTimeClockStop(this.dmtTimeClockStopVO, this.account);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
	    }
		return dmtTimeClockStop;
	}

	/**
	 * DATA 조회를 위한 BackEndJob 호출<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return DmtTimeClockStopVO
	 * @throws Exception
	 */
	private DmtTimeClockStopVO cancelTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws Exception {
		DmtTimeClockStopVO dmtTimeClockStop = new DmtTimeClockStopVO();
		try {
			dmtTimeClockStopVO.setUpdUsrId(account.getUsr_id());
			dmtTimeClockStopVO.setUpdOfcCd(account.getOfc_cd());
			dbDao.removeTimeClockStop(dmtTimeClockStopVO);
			
			//2010.04.08 배치적용으로 주석처리 - 타임클락 취소후  계산 처리 프로세스
			//modifyCancelCharge(dmtTimeClockStopVO.getClkStopNo(), account);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		}
		dmtTimeClockStop.setCxlFlg("Y");
		return dmtTimeClockStop;
	}
	
}