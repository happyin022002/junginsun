/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMSummaryBC.java
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryDownExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InRevenueLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltCoaWkPrdVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriCMSummaryCustomerListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummaryDownExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentSummaryRevenueDetailVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCheckRegionCodeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsCmSummaryHistoryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummaryRevenueDetailVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummarySimulationListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;

/**
 * NIS2010-Profitabilitysimulation Business Logic Command Interface<br>
 * - NIS2010-Profitabilitysimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6055EventResponse 참조
 * @since J2EE 1.6
 */

public interface CMSummaryBC {
	/**
	 * REV_LANE 의 코드, destription list를 조회한다.<br>
	 * 
	 * @param InRevenueLaneVO inRevenueLaneVO
	 * @return List<InRevenueLaneVO>
	 * @exception EventException
	 */
	public List<InRevenueLaneVO> searchRevenueLaneList(InRevenueLaneVO inRevenueLaneVO) throws EventException;
	
	
	

	/**
	 * 
	 * ESM_PRI_6024 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Proposal 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsProposalCmSummaryVO    inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String searchProposalCmSummaryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO, SignOnUserAccount account) throws EventException ;
	
	
	/**
     * ESM_PRI_6026 :  Retrieve <BR>
	 * CM/OP Summary & Simulation , Contract Approval 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String searchAmendmentCmSummaryList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,SignOnUserAccount account) throws EventException ;
	
	
	/**
	 * ESM_PRI_6026 :  OnLoad <BR>
	 * 
	 * 화면에서 사용할 주차와 그 날짜를 조회 합니다..<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @return List<RsltCoaWkPrdVO>
	 * @exception EventException
	 */
	public  List<RsltCoaWkPrdVO> searchCoaWkPrdList(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws EventException ;
		
	
	/**
	 * ESM_PRI_6029 : Retrieve
	 * CM/OP Summary & Simulation Multi Customer 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCMSummaryCustomerListVO    rsltPriCMSummaryCustomerListVO
	 * @return List<RsltPriCMSummaryCustomerListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCMSummaryCustomerListVO> searchCustomerList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws EventException ;
	
	/**
	 * ESM_PRI_6029 : Select Grid1
	 * 
	 * CM/OP Summary & Simulation Multi Customer에서 하나의 customer 선택시 그 group에 포함된 데이터 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCMSummaryCustomerListVO    rsltPriCMSummaryCustomerListVO
	 * @return List<RsltPriCMSummaryCustomerListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCMSummaryCustomerListVO> searchCustomerSelectedList(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO) throws EventException ;

	
	/**
     * ESM_PRI_6032 :  Retrieve <BR>
     * CCM/OP Summary & Simulation Proposal의 CM 값을 Simulation해 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String searchProposalSummarySimulationList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO, InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO,SignOnUserAccount account) throws EventException ;
	/**
     * ESM_PRI_6031 :  Retrieve <BR>
     * CM/OP Summary & Simulation 를 조회 합니다.<br>
     * 
	 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
	 * @param InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO
	 * @return List<RsltPrsAmendmentSummarySimulationListVO>
	 * @exception EventException
	 */
//	public  List<RsltPrsAmendmentSummarySimulationListVO>  searchAmendmentSummarySimulationList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO,SignOnUserAccount account) throws EventException ;

	
	
	/**
     * ESM_PRI_6031 :  Retrieve <BR>
     * CM/OP Summary & Simulation 를 조회를 위해 BackEndJob을 실행 합니다.<br>
     * 
	 * @param inPrsAmendmentCmSummaryVO InPrsAmendmentCmSummaryVO 
	 * @param inPrsAmendmentSummarySimulationSetVO InPrsAmendmentSummarySimulationSetVO 
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */                                                    
	public  String  searchAmendmentSummarySimulationStart (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO , InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO,SignOnUserAccount account) throws EventException ;

	
	
	
	/**
     * ESM_PRI_6052 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchProposalRevenueDetailList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO,SignOnUserAccount account) throws EventException ;

	/**
     * ESM_PRI_6053 :  OnLoad <BR>
     * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchAmendmentRevenueDetailList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,SignOnUserAccount account) throws EventException ;

	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJobVOs(String key) throws EventException ;

	
	/**
     * ESM_PRI_6024,ESM_PRI_6026 :  OnLoad <BR>
     * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.<br>
     * 
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public  RsltCdListVO  searchAuthorizationOffice (SignOnUserAccount account) throws EventException ;
	
	
	/**
     * ESM_PRI_6025 :  OnLoad <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchProposalChartList (InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO,SignOnUserAccount account ) throws EventException ;
	/**
     * ESM_PRI_6027 :  OnLoad,Retrieve <BR>
     *  CM/OP Summary & Simulation의 Chart 정보 를 조회 합니다.<br>
     * 
	 * @param InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String  searchAmendmentChartList (InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO,SignOnUserAccount account) throws EventException ;
	
 
	/**
	 * ESM_PRI_6054 :  Retrieve <BR>
	 * CM/OP Summary & Simulation 의 Quotation, Proposal, Amendment의 CM값 History 를 조회 합니다..<br>
	 *  
	 * @param InPrsProposalCmSummaryVO    inPrsProposalCmSummaryVO
	 * @return List<RsltPrsCmSummaryHistoryVO>
	 * @exception EventException
	 */
	public  List<RsltPrsCmSummaryHistoryVO> searchCmSummaryHistoryList(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO) throws EventException ;
	
	/**
     * ESM_PRI_6026 :  Down Excel  <BR>
	 * CM/OP Summary & Simulation , Contract Approval 엑셀 리스트 를 조회 합니다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryDownExcelVO    inPrsAmendmentCmSummaryDownExcelVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public  String searchAmendmentCmSummaryExcelList(InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO,SignOnUserAccount account) throws EventException ;
	
 
	/**
	 * ESM_PRI_6031 :  sheet 내용변경 <BR>
	 * 
	 * sheet의 route값이 변경 됐을때 정확한 값인지 체크 한다.<br>
	 *  
	 * @param InPrsAmendmentCmSummaryVO    inPrsAmendmentCmSummaryVO
	 * @return List<RsltPrsCheckRegionCodeVO>
	 * @exception EventException
	 */
	public  List<RsltPrsCheckRegionCodeVO> searchSummaryResionCode(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO) throws EventException ;
}