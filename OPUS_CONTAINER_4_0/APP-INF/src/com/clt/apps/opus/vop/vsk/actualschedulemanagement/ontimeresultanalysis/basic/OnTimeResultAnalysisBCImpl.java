/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisBCImpl.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration.OnTimeResultAnalysisDBDAO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.SkdResultVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdRsltVO;

/**
 * ActualScheduleManagement Business Logic Basic Command implementation<br>
 * - Handling Business Logic of ActualScheduleManagement<br>
 *
 * @author Jeong Myounghun
 * @see VOP_VSK_0231EventResponse,OnTimeResultAnalysisBC, DAO Class
 * @since J2EE 1.6
 */
public class OnTimeResultAnalysisBCImpl extends BasicCommandSupport implements OnTimeResultAnalysisBC {

	// Database Access Object
	private transient OnTimeResultAnalysisDBDAO dbDao = null;

	/**
	 * Creating OnTimeResultAnalysisBCImpl Object<br>
	 * Creating OnTimeResultAnalysisDBDAO<br>
	 */
	public OnTimeResultAnalysisBCImpl() {
		dbDao = new OnTimeResultAnalysisDBDAO();
	}
	/**
	 * Retrieving on time target VVD of Port Schedule<br>
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchRsltConvVslSkd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			return dbDao.searchRsltConvVslSkd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving SKD Status (Delay Status - Header List)<br>
	 * 
	 * @param String intgCdId
	 * @return String
	 * @exception EventException
	 */
	public String searchDelayReason(String intgCdId) throws EventException {
		try {
			return dbDao.searchDelayReason(intgCdId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving SKD Status (Delay Status)<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultDelayStatusVO>
	 * @exception EventException
	 */
	public List<ResultDelayStatusVO> searchRsltDlayStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException {
		try {
			return dbDao.searchRsltDlayStsList(resultChangeStatusVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Target VVD & Remark(s)<br>
	 * 
	 * @param ResultRemarkVO resultRemarkVO
	 * @return List<ResultRemarkVO>
	 * @exception EventException
	 */
	public List<ResultRemarkVO> searchRsltRmkDtlList(ResultRemarkVO resultRemarkVO) throws EventException{
		try {
			return dbDao.searchRsltRmkDtlList(resultRemarkVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving SKD Status (Skip Status)<br>
	 * 
	 * @param ResultSkipStatusVO resultSkipStatusVO
	 * @return List<ResultSkipStatusVO>
	 * @exception EventException
	 */
	public List<ResultSkipStatusVO> searchRsltSkipStsList(ResultSkipStatusVO resultSkipStatusVO) throws EventException {
		try {
			return dbDao.searchRsltSkipStsList(resultSkipStatusVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving SKD Status (Skip Change Status)<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultChangeStatusVO>
	 * @exception EventException
	 */
	public List<ResultChangeStatusVO> searchRsltCngStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException {
		try {
			return dbDao.searchRsltCngStsList(resultChangeStatusVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving delay reason of schedule
	 * 
	 * @param ResultOnTimeRatioVO resultOnTimeRatioVO
	 * @return List<ResultOnTimeRatioVO>
	 * @exception EventException
	 */
	public List<ResultOnTimeRatioVO> searchRsltOnTimeRtoList (ResultOnTimeRatioVO resultOnTimeRatioVO) throws EventException {
		try {
			return dbDao.searchRsltOnTimeRtoList(resultOnTimeRatioVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving VSK VESSEL SCHEDULE RESULT about VVD
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return OnTimeRsltAnalVO
	 * @exception EventException
	 */
	public OnTimeRsltAnalGRPVO searchRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			OnTimeRsltAnalGRPVO result = dbDao.searchRsltByVvd(onTimeRsltAnalGRPVO);
			List<VskVslSkdRsltVO> vskVslSkdRsltVOs = result.getVskVslSkdRsltVOs();
			// in case result is not exist, calculate result using Vessel Port Schedule
			if(vskVslSkdRsltVOs==null || vskVslSkdRsltVOs.size()==0){
				result = dbDao.searchRsltCstSkdtTarget(onTimeRsltAnalGRPVO);
				
				// in case of retrieving VVD using Vessel Port Schedule
				List<SkdResultVO> skdResultVOs = result.getSkdResultVOs();
				if(skdResultVOs==null || skdResultVOs.size()==0){
					result.setExist("");
				}else{
//					result = calRsltCstSkdDlayHr(result);
					result.setExist("1");
				}
			}else{
				// already exist
				result.setExist("0");
			}
			return result;
//		} catch (EventException ex) {
//			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Deleting VSK VESSEL SCHEDULE RESULT about VVD 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @exception EventException
	 */
	public void removeRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			dbDao.removeRsltByVvd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * Saving VSK VESSEL SCHEDULE RESULT Information about VVD 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			onTimeRsltAnalGRPVO.setCreUsrId(account.getUsr_id());
			onTimeRsltAnalGRPVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageRsltByVvd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Modifying VSK VESSEL SCHEDULE RESULT Information about VVD
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			onTimeRsltAnalGRPVO.setCreUsrId(account.getUsr_id());
			onTimeRsltAnalGRPVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyRsltByVvd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10038").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
}