/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisBC.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.13 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * Actualschedulemanagement Business Logic Command Interface<br>
 * - Interface of Business Logic about Actualschedulemanagement<br>
 *
 * @author
 * @see Vop_vsk_0231EventResponse
 * @since J2EE 1.6
 */

public interface OnTimeResultAnalysisBC {

	/**
	 * Retrieving on time target VVD of Port Schedule<br>
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchRsltConvVslSkd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * Retrieving SKD Status (Delay Status - Header List)<br>
	 * 
	 * @param String intgCdId
	 * @return String
	 * @exception EventException
	 */
	public String searchDelayReason(String intgCdId) throws EventException;
	
	/**
	 * Retrieving SKD Status (Delay Status)<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultDelayStatusVO>
	 * @exception EventException
	 */
	public List<ResultDelayStatusVO> searchRsltDlayStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException;
	
	/**
	 * Retrieving Target VVD & Remark(s)<br>
	 * 
	 * @param ResultRemarkVO resultRemarkVO
	 * @return List<ResultRemarkVO>
	 * @exception EventException
	 */
	public List<ResultRemarkVO> searchRsltRmkDtlList(ResultRemarkVO resultRemarkVO) throws EventException;
	
	/**
	 * Retrieving SKD Status (Skip Status)<br>
	 * 
	 * @param ResultSkipStatusVO resultSkipStatusVO
	 * @return List<ResultSkipStatusVO>
	 * @exception EventException
	 */
	public List<ResultSkipStatusVO> searchRsltSkipStsList(ResultSkipStatusVO resultSkipStatusVO) throws EventException;
	
	/**
	 * Retrieving SKD Status (Skip Change Status)<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultChangeStatusVO>
	 * @exception EventException
	 */
	public List<ResultChangeStatusVO> searchRsltCngStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException;
	
	/**
	 * Retrieving delay reason of schedule
	 * 
	 * @param ResultOnTimeRatioVO resultOnTimeRatioVO
	 * @return List<ResultOnTimeRatioVO>
	 * @exception EventException
	 */
	public List<ResultOnTimeRatioVO> searchRsltOnTimeRtoList (ResultOnTimeRatioVO resultOnTimeRatioVO) throws EventException;
	
	/**
	 * Retrieving VSK VESSEL SCHEDULE RESULT about VVD
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return OnTimeRsltAnalVO
	 * @exception EventException
	 */
	public OnTimeRsltAnalGRPVO searchRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * Deleting VSK VESSEL SCHEDULE RESULT about VVD 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @exception EventException
	 */
	public void removeRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * Saving VSK VESSEL SCHEDULE RESULT Information about VVD 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException;
	/**
	 * Modifying VSK VESSEL SCHEDULE RESULT Information about VVD
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException;
}