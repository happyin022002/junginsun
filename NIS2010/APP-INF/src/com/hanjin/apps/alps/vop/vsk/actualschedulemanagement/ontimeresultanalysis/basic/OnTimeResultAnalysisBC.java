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
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS-Actualschedulemanagement Business Logic Command Interface<br>
 * - ALPS-Actualschedulemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeong Myounghun
 * @see Vop_vsk_0231EventResponse 참조
 * @since J2EE 1.6
 */

public interface OnTimeResultAnalysisBC {

	/**
	 * Port Schedule에서 정시성 대상 VVD를 조회합니다.<br>
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchRsltConvVslSkd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * SKD Status (Delay Status - Header List)를 조회합니다.<br>
	 * 
	 * @param String intgCdId
	 * @return String
	 * @exception EventException
	 */
	public String searchDelayReason(String intgCdId) throws EventException;
	
	/**
	 * SKD Status (Delay Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultDelayStatusVO>
	 * @exception EventException
	 */
	public List<ResultDelayStatusVO> searchRsltDlayStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException;
	
	/**
	 * Target VVD & Remark(s)를 조회합니다.<br>
	 * 
	 * @param ResultRemarkVO resultRemarkVO
	 * @return List<ResultRemarkVO>
	 * @exception EventException
	 */
	public List<ResultRemarkVO> searchRsltRmkDtlList(ResultRemarkVO resultRemarkVO) throws EventException;
	
	/**
	 * SKD Status (Skip Status)를 조회합니다.<br>
	 * 
	 * @param ResultSkipStatusVO resultSkipStatusVO
	 * @return List<ResultSkipStatusVO>
	 * @exception EventException
	 */
	public List<ResultSkipStatusVO> searchRsltSkipStsList(ResultSkipStatusVO resultSkipStatusVO) throws EventException;
	
	/**
	 * SKD Status (Skip Change Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultChangeStatusVO>
	 * @exception EventException
	 */
	public List<ResultChangeStatusVO> searchRsltCngStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException;
	
	/**
	 * 스케쥴 지연 사유를 조회합니다.
	 * 
	 * @param ResultOnTimeRatioVO resultOnTimeRatioVO
	 * @return List<ResultOnTimeRatioVO>
	 * @exception EventException
	 */
	public List<ResultOnTimeRatioVO> searchRsltOnTimeRtoList (ResultOnTimeRatioVO resultOnTimeRatioVO) throws EventException;
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 조회합니다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return OnTimeRsltAnalVO
	 * @exception EventException
	 */
	public OnTimeRsltAnalGRPVO searchRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
//	/**
//	 * VVD에 대해서 VSK VESSEL SCHEDULE 정보를 이용하여 지연 정보를 조회합니다. 
//	 * 
//	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
//	 * @return OnTimeRsltAnalVO
//	 * @exception EventException
//	 */
//	public OnTimeRsltAnalGRPVO calRsltCstSkdDlayHr(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 삭제합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @exception EventException
	 */
	public void removeRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException;
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 저장합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException;
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 수정합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @return List<DrwSkdSearchVO>
	 * @exception EventException
	 */
	public List<DrwSkdSearchVO> searchDrwSkd(DrwSkdSearchVO drwSkdSearchVO) throws EventException;
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @return List<DrwPortListVO>
	 * @exception EventException
	 */
	public List<DrwPortListVO> searchDrwPortList() throws EventException;
	
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 저장합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 삭제합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @exception EventException
	 */
	public void removeDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO) throws EventException;
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 수정합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @param DrwPortInfoVO drwPortInfoVO
	 * @return List<DrwPortInfoVO>
	 * @exception EventException
	 */
	public List<DrwPortInfoVO> searchDrwPortInfo(DrwPortInfoVO drwPortInfoVO) throws EventException;
	
	/**
	 * VSK Drewry Report의 Port Setup에서 Port를 추가하여  저장합니다.
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwPortList(DrwPortListVO drwPortListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VSK Drewry Report의 Port Setup에서 Port를 추가하여  삭제합니다. 
	 * 
	 * @param DrwPortListVO drwPortListVO
 	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDrwPortList(DrwPortListVO drwPortListVO, SignOnUserAccount account) throws EventException; 
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @return List<DrwTrdInfoVO>
	 * @exception EventException
	 */
	public List<DrwTrdInfoVO> searchDrwTrdInfo() throws EventException;
	
	/**
	 * VSK Drewry Report의 Trade Setup에서 Trade를 추가하여  저장합니다.
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VSK Drewry Report의 Trade Setup에서 Trade를  삭제합니다. 
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO, SignOnUserAccount account) throws EventException;
}