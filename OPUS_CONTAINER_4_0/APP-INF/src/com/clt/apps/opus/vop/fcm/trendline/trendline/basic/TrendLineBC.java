/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineBC.java
*@FileTitle : TrendLine
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.basic;

import java.util.List;

import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.CalcTrndLineFormulaVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ALPS-TrendLine Business Logic Command Interface<br>
 * - ALPS-TrendLine에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface TrendLineBC {
	
	/**
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLineList(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trend Line 과 관련있는 Noon Report Matching 정보를 조회한다.
	 *  
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineRptMtchList(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trend Line 생성을 위한 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineBasic(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trend Line 기초 데이터를 이용하여 Trend Line을 구한다.<br>
	 * 
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @param String pgNo
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> calcTrndLine(List<FcmNoonRptVO> fcmNoonRptVOs, String pgNo) throws EventException;
	
	/**
	 * 해당 기간의 Noon Rpt가 존재하는 Lane, Vessel, Design Cap.를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<String[]> searchLaneVslCapa(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trnd Line을 생성합니다.<br>
	 * 
	 * @param FcmTrndLineVO HdrTrndLineVO
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @param FcmTrndLineVO[] RsltTrndLineVOs
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageTrndLine(FcmTrndLineVO HdrTrndLineVO, FcmNoonRptVO[] rawDataVOs, FcmTrndLineVO[] RsltTrndLineVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLinePopupList(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * 기생성된 Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLineForInq(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * 기생성된 Trend Line 의 raw data를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineRawDataForInq(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * Trnd Line을 삭제합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception EventException
	 */
	public void removeTrndLine(FcmTrndLineVO fcmTrndLineVO) throws EventException;
	
	/**
	 * 기존재하는 Trnd Line의 정보를 수정합니다.<br>
	 * 
	 * @param FcmTrndLineVO HdrTrndLineVO
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @param FcmTrndLineVO[] RsltTrndLineVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTrndLineUpd(FcmTrndLineVO hdrTrndLineVO, FcmNoonRptVO[] rawDataVOs, FcmTrndLineVO[] rsltTrndLineVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면에서 온 정보를 이용하여 delete 하지 않은 데이터만의 slip,cspd를 구한다.<br>
	 * 
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @return  FcmNoonRptVO[]
	 * @exception EventException
	 */
	public FcmNoonRptVO[] calcRawDataSimulation(FcmNoonRptVO[] rawDataVOs) throws EventException;
	
	/**
	 * Trend Line 수식을 이용하여 결과값을 구한다.<br>
	 * 
	 * @param CalcTrndLineFormulaVO calcTrndLineFormulaVO
	 * @return List<TrndLineFocVO>
	 * @exception EventException
	 */
	public List<CalcTrndLineFormulaVO> calcTrndLineFormula(CalcTrndLineFormulaVO calcTrndLineFormulaVO) throws EventException;

}
