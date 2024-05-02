/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtBC.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssSCExceptionGRPVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionHisVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Cgmcommon Business Logic Command Interface<br>
 * - ALPS-Cgmcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM CHANG SIK
 * @see CgmcodemgtEventResponse 참조
 * @since J2EE 1.4
 */

public interface CgmCodeMgtBC {

	/**
	 *   Chassis Pool 로 등록된 Agreement 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchAgreementByPoolBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *   Chassis Pool 로 등록된 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchPoolListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * CGM_EQ_SPEC 테이블에서 Spec No 리스트를 조회한다. [NO_ID]<br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchSpecListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Chassis 또는 M.G.Set 의 Type Size 목록을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchEqTpszListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM 테이블에서 Manufacture리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchManuListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 *  Neutral Pool 로 등록된 Agreement 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMgsetNoFindBasic(ComboINVO comboINVO) throws EventException;

	/**
	 *  CGM에서 사용하는 공통코드 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCommonCodeListBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  MDM_VENDOR 테이블에서 Vendor Code 및 Name 을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchVendorCodeListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 *  MDM_STATE 테이블에서 미주지역의 State 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchStateCodeListBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 * MDM_ORGANIZATION 테이블 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param mdmOrganizationINVO MdmOrganizationINVO
	 * @return MdmOrganizationMGTVO
	 * @exception EventException
	 */
	public MdmOrganizationMGTVO searchOrganizationBasic(MdmOrganizationINVO mdmOrganizationINVO) throws EventException;

	/**
	 * CGM_EQ_LOT 에 등록된 Cert No 리스트를 조회한다. [EES_CGM_1005]<br>
	 *
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCertChassisListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM 테이블에서 Financing Company리스트를 조회한다. [NO_ID]<br>
	 * 
	 *@param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchFinancingCoBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 * Agreement No가 유효한지 체크한다 조회한다. [NO_ID] <br>
	 * 
	 * @param agreementINVO AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception EventException
	 */
	public List<AgreementMGTVO> searchAgreementMainBasic(AgreementINVO agreementINVO) throws EventException;
	
	/**
	 * mdm_mvmt_sts 테이블 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMovementStatusListBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  Neutral Pool 로 등록된 Agreement 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchNuPoolListBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  YEAR-WEEK로 WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateByWeekBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  RCC,LCC,SCC 조회 및 Validation 체크. Retrieve. <br>
	 * 
	 * @param eqOrzChtINVO EqOrzChtINVO 
	 * @return List<EqOrzChtMGTVO>
	 * @exception EventException
	 */
	public List<EqOrzChtMGTVO> searchEqOrzChtBasic(EqOrzChtINVO eqOrzChtINVO) throws EventException;	
	
	/**
	 * COST COFFICE CODE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCostOfficeBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  Invoice Service Provier를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchInvSerProviderBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  Office Code 로 Local Time 을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchLocalTimeByOfficeBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  S/C Exception으로 등록된 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return List<CPSScExptListMGTVO>
	 * @exception EventException
	 */
	public List<CPSScExptListMGTVO> searchCPSScExptListBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException;
	
	/**
	 *  입력된 Customer Code로부터 Customer Name을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptCustNameBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException;
	
	/**
	 *  입력된 SCC가 유효한 값인지 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptListSccBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException;
	
	/**
	 *  입력된 SC NO., E.Month, SCC로부터 중복을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptListDupBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException;
	
	/**
	 *  입력된 Group Customer Code로부터 Group Customer Name을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptGroupCustNameBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException;
	
	/**
	 *  S/C Exception List를 입력하거나 수정한다. <br>
	 * 
	 * @param cpsScExptListINVOS CPSScExptListINVO[]
	 * @param account SignOnUserAccount
	 * @return List<CPSScExptListINVO>
	 * @exception EventException
	 */
	public List<CPSScExptListINVO> manageCPSScExptListBasic(CPSScExptListINVO[] cpsScExptListINVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 *  CPS Neutral Pool로 등록된 업체를 조회한다. Retrieve. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return List<CPSCHSSPoolMGTVO>
	 * @exception EventException
	 */
	public List<CPSCHSSPoolMGTVO> searchCPSCHSSPoolBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException;
	
	/**
	 *   CPS Chassis Pool List를 조회한다. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCPSCHSSPoolListBasic(ComboINVO comboINVO) throws EventException;
	
	/**
	 *  입력된 Pool Code의 중복을 체크한다. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSCHSSPoolCodeDupBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException;
	
	/**
	 *  입력된 Vendor Code로부터 Vendor Name을 체크한다. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSCHSSPoolVndrNameBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException;
	
	/**
	 *  CPS Neutral Pool을 입력하거나 수정한다. <br>
	 * 
	 * @param cpsCHSSPoolINVOS CPSCHSSPoolINVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCPSCHSSPoolBasic(CPSCHSSPoolINVO[] cpsCHSSPoolINVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNoBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception EventException
	 */
	public SCExceptionParmVO searchSCDurationBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasAcceptAuthBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityListBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @exception EventException
	 */
	public List<CHSSSCExceptionVersionVO> searchSCVersionByProposalNoBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Entry를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<ChssScExceptionVO>
	 * @exception EventException
	 */
	public List<ChssScExceptionVO> searchSCExceptionBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Proposal No. 에 해당하는 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerListBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception 을 수정 합니다. <br>
	 * 
	 * @param ChssSCExceptionGRPVO chssSCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCExceptionBasic(ChssSCExceptionGRPVO chssSCExceptionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer Name 정보를 조회한다.
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerNameBasic(CustomerVO customerVO) throws EventException;
	
	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isCustomerByPriMnBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
     * commodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @exception EventException
     */ 
    public String searchCommodityNameBasic(String cmdtCd) throws EventException;
    
    /**
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdateBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTSBasic(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws EventException;
	
	/**
	 * S/C Exception Version를 삭제상태로 수정 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCExceptionByVerBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkFiledBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String propNo
	 * @return List<ChssScExceptionHisVO>
	 * @exception EventException
	 */
	public List<ChssScExceptionHisVO> searchSCExceptionListByPropNoBasic(String propNo) throws EventException;
	
	/**
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopyBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException;
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTSByAdmtBasic(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws EventException;
}
