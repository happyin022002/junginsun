/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBCImpl.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockChargeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see reference DAO class of UI_DMT_2010EventResponse,TimeClockStopMgtBC
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
	 * data setting 
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
	 * Call BackEndJob for serarching <br>
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
