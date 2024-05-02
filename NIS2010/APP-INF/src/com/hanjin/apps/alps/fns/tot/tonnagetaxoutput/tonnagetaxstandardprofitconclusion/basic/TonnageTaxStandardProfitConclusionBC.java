/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionBC.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TotBsaVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
import com.hanjin.syscommon.common.table.TotStlCfmVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.FdrStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;
/**
 * ALPS-Tonnagetaxoutput Business Logic Command Interface<br>
 * - ALPS-Tonnagetaxoutput에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Chang Soo
 * @see Fns_tot_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface TonnageTaxStandardProfitConclusionBC {
	
	/**
	 * ERP I/F Inquiry 최종마감년월을 조회한다. <br>
	 * 
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchMaxCosingYearMm() throws EventException;

	/**
	 * 월별 선박당 사용율 및 톤세 관련 데이터를 조회한다. <br>
	 * 
	 * @param ErpIfVO erpIfVO
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchTaxableAmountListByERPInterface(ErpIfVO erpIfVO) throws EventException;
	
	/**
	 * Lane별 NRT/CAPA/BSA Allocation을 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */
	public List<BsaVO> searchNrtNCapaNBsaListByLane(BsaVO bsaVO) throws EventException;

	/**
	 * (FNS_TOT_0018) POPUP ERP TAX로 I/F 결과를 조회한다. <br>
	 * 
	 * @param TotStlCfmVO totStlCfmVO
	 * @return List<TotStlCfmVO>
	 * @exception EventException
	 */
	public List<TotStlCfmVO> searchTaxableAmountStatusList(TotStlCfmVO totStlCfmVO) throws EventException;

	/**
	 *해당 년월, TRADE의 NRT, USE, DAYS 체크여부를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception EventException
	 */
	public List<StlCfmVO> searchTaxableAmountConfirmationCheck(StlCfmVO stlCfmVO) throws EventException;

	/**
	 * 해당 년월, TRADE의 배치처리된 데이터가(TOT_PORT_STL_AMT) 있는지 조회한다. <br>
	 * 
	 * @param TotPortStlAmtVO totPortStlAmtVO
	 * @return List<TotPortStlAmtVO>
	 * @exception EventException
	 */
	public List<TotPortStlAmtVO> searchPortStlAmtCheck(TotPortStlAmtVO totPortStlAmtVO) throws EventException;

	/**
	 * 해당 년월, TRADE의 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountConfirmationList(VvdStlAmtVO vvdStlAmtVO) throws EventException;

	/**
	 * 체크된 NRT, USE, DAYS 데이터를 TOT_STL_CFM에 저장한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createTaxableAmountConfirmationMark (StlCfmVO stlCfmVO,SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * FNS_TOT_0012 Popup 상세데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchTaxableAmountConfirmationDetailListByVVD(PortStlAmtVO portStlAmtVO) throws EventException;

	/**
	 * 수정된 데이터로 tax 재계산하여 저장한다. <br>
	 * 
	 * @param PortStlAmtVO[] portStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void recalculateTaxableAmountForVoyageDay (PortStlAmtVO[] portStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 수정된 데이터로 tax 재계산하여 저장한다. <br>
	 * 
	 * @param PortStlAmtVO[] portStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void recalculateTaxableAmountForLoadCapa (PortStlAmtVO[] portStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * VVD 최종년월을 조회한다 <br>
	 * 
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchMaxCosingYearMmByVessel() throws EventException;

	/**
	 * 해당 VESSEL, 기간의  Taxable Amount 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountListByVessel(VvdStlAmtVO vvdStlAmtVO) throws EventException;
	
	/**
	 * SHEET 에 LANE, TRADE, 기간에 해당하는 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountListByLane(VvdStlAmtVO vvdStlAmtVO) throws EventException;

	/**
	 * 해당년월의 톤세 데이터를 조회한다. <br>
	 * 
	 * @param ErpIfVO erpIfVO
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchTaxableAmountList(ErpIfVO erpIfVO) throws EventException;

	/**
	 * 해당년월의 톤세 관련 데이터를 재생성하여 ERP 연동처리한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createTaxableAmountIF (String stlYrmon, SignOnUserAccount signOnUserAccount) throws EventException;

	
	/**
	 * 해당년월의 톤세 관련 현재상태를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception EventException
	 */
	public List<StlCfmVO> searchTaxableAmountStatus(StlCfmVO stlCfmVO) throws EventException;

	/**
	 * 해당년도를 마감한다. <br>
	 * 
	 * @param TotStlClzVO totStlClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void closeTonnageTaxStlYear (TotStlClzVO totStlClzVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 해당년월, data type, 선박 기준 feeder 데이터를 조회한다. <br>
	 * 
	 * @param FdrStlAmtVO fdrStlAmtVO
	 * @return List<FdrStlAmtVO>
	 * @exception EventException
	 */
	public List<FdrStlAmtVO> searchFeederTaxableAmountListByVessel(FdrStlAmtVO fdrStlAmtVO) throws EventException;

	/**
	 * 수정한 선박 기준 feeder데이터를 저장한다. <br>
	 * 
	 * @param FdrStlAmtVO[] fdrStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void modifyFeederTaxableAmountByVessel (FdrStlAmtVO[] fdrStlAmtVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 해당년월의 feeder summary 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByMonthly(VvdStlAmtVO vvdStlAmtVO) throws EventException;

	/**
	 * 해당년월의 feeder summary 데이터를 TOT_VVD_STL_AMT로 저장한다. <br>
	 * 
	 * @param VvdStlAmtVO[] vvdStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createFeederTaxableAmount (VvdStlAmtVO[] vvdStlAmtVOs,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 해당기간의 배치정보를 조회한다. <br>
	 * 
	 * @param JbSkdVO jbSkdVO
	 * @param String hisType
	 * @return List<JbSkdVO>
	 * @exception EventException
	 */
	public List<JbSkdVO> searchNonFeederNFeederTaxBatchHis(JbSkdVO jbSkdVO, String hisType) throws EventException;

	/**
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param String paramStDt
	 * @param String paramEndDt
	 * @param String stDt
	 * @param String jobID
	 * @param String batItmNm
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createNonFeederNFeederTaxBatch (String paramStDt, String paramEndDt, String stDt, String jobID, String batItmNm, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 해당년월의 배치정보로 스케쥴정보를 삭제한다. <br>
	 * 
	 * @param String jobID
	 * @exception EventException
	 */
	public void removeNonFeederNFeederTaxBatch (String jobID) throws EventException;

	/**
	 * 변경된(MODIFY FLAG = 'Y') 정보를 재계산하여 저장한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateBSA (TotBsaVO totBsaVO,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 변경된 Nrt 정보를 재계산하여 저장한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateNrt (TotBsaVO totBsaVO,SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 해당년월의 일수가 0이면서, booking 물량이 있는 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchInquiryActVsDays(PortStlAmtVO portStlAmtVO) throws EventException;

	/**
	 * 운항스케쥴대비 누락 port 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchExceptedVslPortSkd(PortStlAmtVO portStlAmtVO) throws EventException;

	/**
	 * 해당월의 배치정보를 조회한다.
	 * @param JbSkdVO jbSkdVO
	 * @return List<JbSkdVO>
	 * @exception EventException
	 */
	public List<JbSkdVO> searchJbIdList(JbSkdVO jbSkdVO) throws EventException;
	
	/**
	 * NonFeederPortCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception EventException
	 */
	public void createNonFeederPortCalculation (String stlYrmon, String vslCd, String creUsrId) throws EventException;
	
	/**
	 * NonFeederVvdCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception EventException
	 */
	public void createNonFeederVvdCalculation (String stlYrmon, String vslCd, String creUsrId) throws EventException;
	

	/**
	 * FNS_TOT_0017 : Retrive <br>
	 * SHEET에 해당년월의 DETAIL_DOWN 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByDetailDown(VvdStlAmtVO vvdStlAmtVO) throws EventException;


	/**
	 * Inquiry VSL Owner/Charter화면의 내용을 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchInquiryVslOwnerCharterList(VvdStlAmtVO vvdStlAmtVO) throws EventException;
	
	/**
	 * Inquiry VSL Owner/Charter화면의 Popup 상세데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchInquiryVslOwnerCharterDetailList(PortStlAmtVO portStlAmtVO) throws EventException;
	
	/**
	 * 배치 실행 여부 확인 <br>
	 * 
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException;	
}