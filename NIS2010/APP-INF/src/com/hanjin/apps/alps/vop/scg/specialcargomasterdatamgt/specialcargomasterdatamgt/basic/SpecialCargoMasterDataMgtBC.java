/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtBC.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.01.17 서석진 [CHM-201115272] RSO 설정및 지역 본부 hard coding 로직 수정 요청
* 처리내역 :RHQ1,RHQ2 GRID 클릭시 콤보박스형태로 조회후 선택하여 저장,수정 할수있게 UI,로직 수정
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic;
 
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguImgVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckCreationVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemicalHistoryVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemHistoryFileVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgCntcPntPolVO;
import com.hanjin.syscommon.common.table.ScgCntcPntVO;
import com.hanjin.syscommon.common.table.ScgImdgAbbrVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgMrnPolutVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgTnkTpVO;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgPckGasReguVO;
import com.hanjin.syscommon.common.table.ScgPckInstrVO;
import com.hanjin.syscommon.common.table.ScgPckPkgVO;
import com.hanjin.syscommon.common.table.ScgPckPtbTnkVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.syscommon.common.table.ScgPckReguPkgOrgPrxVO;
import com.hanjin.syscommon.common.table.ScgPckReguVO;
import com.hanjin.syscommon.common.table.ScgSpclPckProviVO;
import com.hanjin.syscommon.common.table.ScgCdVO;


/**
 * ALPS-Specialcargomasterdatamgt Business Logic Command Interface<br>
 * - ALPS-Specialcargomasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0031EventResponse 참조
 * @since J2EE 1.4
 */

public interface SpecialCargoMasterDataMgtBC {
	/**
	 * Load Reject Reason을 조회 합니다. <br>
	 * 
	 * @param  ScgLodRjctCdVO scgLodRjctCdVO
	 * @return List<ScgLodRjctCdVO>
	 * @exception EventException
	 */
	public List<ScgLodRjctCdVO> searchLoadRejectReasonCodeList(ScgLodRjctCdVO scgLodRjctCdVO) throws EventException;
	/**
	 * Load Reject Reason을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgLodRjctCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadRejectReasonCode(ScgLodRjctCdVO[] scgLodRjctCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * SPCL CGO RSO을 조회 합니다. <br>
	 * 
	 * @param  ScgRgnShpOprCdVO scgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchRegionalShipOperatorCodeList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws EventException;
	/**
	 * SPCL CGO RSO을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRegionalShipOperatorCode(ScgRgnShpOprCdVO[] scgRgnShpOprCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Partner's Contact Point for SPCL CGO 을 조회 합니다. <br>
	 * 
	 * @param  ScgCntcPntVO scgCntcPntVO
	 * @return List<ScgCntcPntVO>
	 * @exception EventException
	 */
	public List<ScgCntcPntVO> searchPartnerLineContactPointList(ScgCntcPntVO scgCntcPntVO) throws EventException;

	/**
	 * RSO을 조회 합니다. <br>
	 * 
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoList() throws EventException;

	/**
	 * Partner's Contact Point for SPCL CGO 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgCntcPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerLineContactPoint(ScgCntcPntVO[] scgCntcPntVOs,SignOnUserAccount account) throws EventException;

	/**
	 * SPCL CGO Irregular Type 을 조회 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVO
	 * @return List<SearchIrregularTypeCodeListVO>
	 * @exception EventException
	 */
	public List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeList(SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO) throws EventException;
	/**
	 * SPCL CGO Irregular Type 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIrregularTypeCode(SearchIrregularTypeCodeListVO[] searchIrregularTypeCodeListVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Definition of Class  을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgClssCdVO scgImdgClssCdVO
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssCdVO> searchClassDefinitionList(ScgImdgClssCdVO scgImdgClssCdVO) throws EventException;
	/**
	 * Definition of Class  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgClssCdVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageClassDefinition(ScgImdgClssCdVO[] scgImdgClssCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Marine Pollutant 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgMrnPolutVO scgImdgMrnPolutVO
	 * @return List<ScgImdgMrnPolutVO>
	 * @exception EventException
	 */
	public List<ScgImdgMrnPolutVO> searchMarinePollutantCodeList(ScgImdgMrnPolutVO scgImdgMrnPolutVO) throws EventException;
	/**
	 * Marine Pollutant 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMarinePollutantCode(ScgImdgMrnPolutVO[] scgImdgMrnPolutVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Packing Group  을 조회 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVO
	 * @return List<ScgImdgPckGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckGrpVO> searchPackingGroupCodeList(ScgImdgPckGrpVO scgImdgPckGrpVO) throws EventException;

	/**
	 * Packing Group  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingGroupCode(ScgImdgPckGrpVO[] scgImdgPckGrpVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Special Provisions 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgSpclProviVO scgImdgSpclProviVO
	 * @return List<ScgImdgSpclProviVO>
	 * @exception EventException
	 */
	public List<ScgImdgSpclProviVO> searchSpecialProvisionList(ScgImdgSpclProviVO scgImdgSpclProviVO) throws EventException;

	/**
	 * Special Provisions 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSpecialProvision(ScgImdgSpclProviVO[] scgImdgSpclProviVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Packaging Code 을 조회 합니다. <br>
	 * 
	 * @param scgImdgPckCdVO
	 * @return List<ScgImdgPckCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgPckCdVO> searchPackingCodeList(ScgImdgPckCdVO scgImdgPckCdVO) throws EventException;
	/**
	 * Packaging Code 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgPckCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingCode(ScgImdgPckCdVO[] scgImdgPckCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * IMO Type Portable Tanks을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgTnkTpVO scgImdgTnkTpVO
	 * @return List<ScgImdgTnkTpVO>
	 * @exception EventException
	 */
	public List<ScgImdgTnkTpVO> searchIMOTankTypeCodeList(ScgImdgTnkTpVO scgImdgTnkTpVO) throws EventException;
	/**
	 * IMO Type Portable Tanks을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIMOTankTypeCode(ScgImdgTnkTpVO[] scgImdgTnkTpVOs,SignOnUserAccount account) throws EventException;

	/**
	 * DG Abbreviation을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgAbbrVO scgImdgAbbrVO
	 * @return List<ScgImdgAbbrVO>
	 * @exception EventException
	 */
	public List<ScgImdgAbbrVO> searchDGAbbreviationCodeList(ScgImdgAbbrVO scgImdgAbbrVO) throws EventException;
	/**
	 * DG Abbreviation을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgAbbrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDGAbbreviationCode(ScgImdgAbbrVO[] scgImdgAbbrVOs,SignOnUserAccount account) throws EventException;

	/**
	 * No. & Symbols in SEG Table/Mixed STWG 을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgSegrSymVO scgImdgSegrSymVO
	 * @return List<ScgImdgSegrSymVO>
	 * @exception EventException
	 */
	public List<ScgImdgSegrSymVO> searchNumberNSymbolCodeList(ScgImdgSegrSymVO scgImdgSegrSymVO) throws EventException;
	/**
	 * No. & Symbols in SEG Table/Mixed STWG 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param  ScgImdgSegrSymVO[] scgImdgSegrSymVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNumberNSymbolCode(ScgImdgSegrSymVO[] scgImdgSegrSymVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Compatibility Groups of Class 1을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgCompGrpVO  scgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpVO> searchCompatibilityGroupCodeList(ScgImdgCompGrpVO scgImdgCompGrpVO) throws EventException;
	/**
	 * Compatibility Groups of Class 1을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCompatibilityGroupCode(ScgImdgCompGrpVO[] scgImdgCompGrpVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Excepted Quantities을 조회 합니다. <br>
	 * 
	 * @param  ScgImdgExptQtyVO scgImdgExptQtyVO 
	 * @return List<ScgImdgExptQtyVO>
	 * @exception EventException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQuantityCodeList(ScgImdgExptQtyVO scgImdgExptQtyVO) throws EventException;
	/**
	 * Excepted Quantities을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgImdgExptQtyVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExceptedQuantityCode(ScgImdgExptQtyVO[] scgImdgExptQtyVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Segregation Groups 을 조회 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVO
	 * @param scgImdgSegrGrpDtlVO
	 * @param searchCmd
	 * @return VopScg0070VO
	 * @exception EventException
	 */
	public VopScg0070VO searchSegregationGroupList(ScgImdgSegrGrpVO scgImdgSegrGrpVO, ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO, FormCommand searchCmd) throws EventException;
	
	/**
	 * Segregation Groups 을 생성, 수정, 삭제합니다. <br>
	 * 
	 * @param vopScg0070VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSegregationGroup(VopScg0070VO vopScg0070VO, SignOnUserAccount account) throws EventException;

	/**
     * Loading Port for RSO 를 조회 <br>
     * 
	 * @param searchRsoComboListVO
	 * @return List<SearchLoadingPortRsoVO>
	 * @exception EventException
	 */
	public List<SearchLoadingPortRsoVO>  searchLoadingPortRSOList(SearchRsoComboListVO  searchRsoComboListVO ) throws EventException;

  	/**
	 * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 조회 콤보 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SearchRsoComboListVO>
	 * @throws EventException
	 */
	public List<SearchRsoComboListVO> searchRsoList() throws EventException;
	 
	/**
	 * VOP_SCG-0070화면에 대한 멀티 이벤트 처리<br>
     * Segregation Groups (Creation) 을 조회 합니다.<br>
	 * 
	 * @param scgRgnShpOprPortListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadingPortRSO(ScgRgnShpOprPortListVO[] scgRgnShpOprPortListVO,SignOnUserAccount account) throws EventException;

	/**
     * Loading Port for RSO 내용을 조회한다.
	 * 
	 * @param  String locCd
	 * @return List<GetLoadingPortRsoVO>
	 * @exception EventException
	 */
	public  List<GetLoadingPortRsoVO>   searchLoadingPortRSO(String locCd) throws EventException;	
	
	/**
	 * SpecialCargoMasterDataMgtDBDAO의 Target Lane for SPCL CGO APVL의 값을 불러온다.<br>
	 * VOP_SCG-0035화면에 대한 조회 이벤트 처리<br>
	 * @param MdmVslSvcLaneListVO mdmVslSvcLaneListVO
	 * @return List<MdmVslSvcLaneListVO>
	 * @throws EventException
	 */
	public List<MdmVslSvcLaneListVO> searchApprovalTargetLaneList(MdmVslSvcLaneListVO mdmVslSvcLaneListVO) throws EventException;	
	/**
	 * SpecialCargoMasterDataMgtDBDAO의 Target Lane for SPCL CGO APVL을 저장합니다..<br>
	 * @param   MdmVslSvcLaneListVO[]  mdmVslSvcLaneListVOs
	 * @param   SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageApprovalTargetLane( MdmVslSvcLaneListVO[]  mdmVslSvcLaneListVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Packing Instructions/Provisions 을 조회 합니다. <br>
	 * 
	 * @param  String imdgPckInstrCd
	 * @param  String imdgPckInstrSeq
	 * @return List<ScgImdgPckInstrVO>
	 * @exception EventException
	 */
	public  List<ScgImdgPckInstrVO>   searchPackingInstructionList(String imdgPckInstrCd, String imdgPckInstrSeq) throws EventException;
	
	/**
	 * Packing Instructions/Provisions 을 생성, 수정, 삭제합니다. <br>
	 * 
	 * @param scgImdgPckInstrVOs
	 * @param keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstruction(ScgImdgPckInstrVO[] scgImdgPckInstrVOs, List<String> keys, SignOnUserAccount account) throws EventException;
	
    /**
     * No. & Symbols in SEG Table/Mixed STWG 조회한다. 
     * 
     * @param  String sImdgUnno
     * @return List<ScgImdgUnNoOrgRactVO>
     * @exception EventException
     */ 
    public List<ScgImdgUnNoOrgRactVO> searchOrganicPeroxideCodeList(String sImdgUnno)  throws EventException;
    
    
    /**
     * [Special Provisions for Segregation (Creation)]을 [조회 Retrieve] 합니다.<br>
     * @param  String imdgSpclProviNo
     * @throws EventException
     * @return List<ScgImdgSpclProvisVO>
     * @author jang kang cheol
     */
    public List<ScgImdgSpclProvisVO> searchSpecialProvisionSegregationList(String imdgSpclProviNo) throws EventException;
    
    /**
     * [Special Provisions for Segregation (Creation) SubsidiaryRisks]을 [조회 Retrieve] 합니다.<br>
     * @param  String sImdgUnNo
     * @param  String sImdgUnNoSeq
     * @throws EventException
     * @return List<ScgImdgSpclProvisVO>
     * @author jang kang cheol
     */
    public List<ScgImdgSpclProvisVO> searchSubsidiaryRisks(String sImdgUnNo, String sImdgUnNoSeq) throws EventException;
    
    /**
	 * Setup mail contents for SPCL CGO application 을 조회 합니다. <br>
	 * 
	 * @param scgMailTampletVO
	 * @return List<ScgMailTampletVO>
	 * @exception EventException
	 */
	public List<ScgMailTampletVO> searchSCGMailTamplet(ScgMailTampletVO scgMailTampletVO) throws EventException;
	
	/**
	 * Setup mail contents for SPCL CGO application 수정내용을 저장 합니다. <br>
	 * 
	 * @param scgMailTampletVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageSCGMailTamplet(ScgMailTampletVO[] scgMailTampletVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO RSO - CREATION 에서 RgnShpOprRhqCode 를 구한다. <br>
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchRHQOfficeList() throws EventException;
    

	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 최 상단 내용을 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	
	public List<ScgGuidanceVO> searchScgGuidMsg(ScgGuidanceVO scgGuidanceVO) throws EventException;
	

	/**
	 * Special Cargo Guidance 상단 화면정보를 생성,수정 합니다. <br>
	 * 
	 * @param scgGuidanceVOs
	 * @param SignOnUserAccount account
	 * @param String iuFlag
	 * @exception EventException
	 */
	public void manageScgGuidMsg(ScgGuidanceVO[] scgGuidanceVOs, SignOnUserAccount account, String iuFlag) throws EventException;
	

	/**
	 * Special Cargo Guidance 중앙 상세 화면정보를 생성, 삭제 합니다. <br>
	 * 
	 * @param scgGuidanceVOs
	 * @param scgGuidanceFileVOs
	 * @param strKeys
	 * @param Keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScgGuidDtl(ScgGuidanceVO[] scgGuidanceVOs, ScgGuidanceFileVO[] scgGuidanceFileVOs, String[] strKeys, List<String> Keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	public List<ScgGuidanceVO> searchScgGuidDtl(ScgGuidanceVO scgGuidanceVO) throws EventException;
	
   
	/**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 첨부파일 정보를 조회 합니다. <br>
	 * 
	 * @param scgGuidanceVO
	 * @return List<ScgGuidanceVO>
	 * @exception EventException
	 */
	public List<ScgGuidanceVO> searchScgGuidDtlFile(ScgGuidanceVO scgGuidanceVO) throws EventException;

	/**
	 * VOP_SCG_0105 : OPEN <br>
	 * Proper IBC code
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO rsltCdListVO) throws EventException;	

	/**
	 * SCG CODE 정보를 조회합니다.<br>
	 * 
	 * @param ScgCdVO scgCdVO
	 * @return List<ScgCdVO>
	 * @exception EventException
	 */
	public List<ScgCdVO> searchScgCodeList(ScgCdVO scgCdVO) throws EventException;
	
	/**
	 * SCG NON D/G Cargo Keyword 정보를 조회합니다.<br>
	 * 
	 * @param ScgNonDgCgoKwVO scgNonDgCgoKwVO
	 * @return List<ScgNonDgCgoKwVO>
	 * @exception EventException
	 */
	public List<ScgNonDgCgoKwVO> searchScgNonDgCgoList(ScgNonDgCgoKwVO scgNonDgCgoKwVO) throws EventException ;
	
	/**
	 * SCG chemical history 정보를 조회합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO scgChemicalHistoryVO
	 * @return List<ScgChemicalHistoryVO>
	 * @exception EventException
	 */
	public List<ScgChemicalHistoryVO> searchScgChemicalHistory(ScgChemicalHistoryVO scgChemicalHistoryVO) throws EventException ;
	
	
	/**
	 * SCG chemical history 정보를 조회합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO scgChemicalHistoryVO
	 * @return List<ScgChemicalHistoryVO>
	 * @exception EventException
	 */
	public List<ScgChemicalHistoryVO> searchScgChemHistoryAnswer(ScgChemicalHistoryVO scgChemicalHistoryVO) throws EventException ;
	
	/**
	 * SCG chemical history 정보를 저장합니다.<br>
	 * 
	 * @param ScgChemicalHistoryVO[] scgChemicalHistoryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageScgChemicalHistory(ScgChemicalHistoryVO[] scgChemicalHistoryVOs,SignOnUserAccount account) throws EventException ;
	
	/**
	 * SCG chemical history 정보를 저장합니다.(answer)<br>
	 * 
	 * @param ScgChemicalHistoryVO[] scgChemicalHistoryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageScgChemHistoryAnswer(ScgChemicalHistoryVO[] scgChemicalHistoryVOs,SignOnUserAccount account) throws EventException ;
	
	
	/**
	 * SCG NON D/G Cargo Keyword 생성/수정 합니다.<br>
	 * 
	 * @param scgNonDgCgoKwVOs
	 * @param account
	 * @return List<ScgNonDgCgoKwVO>
	 * @exception EventException
	 */
	public String manageScgNonDgCgoKwList(ScgNonDgCgoKwVO[] scgNonDgCgoKwVOs, SignOnUserAccount account) throws EventException ;
	

	/**
	 * SCG CODE 정보를 추가,수정,삭제합니다.<br>
	 * 
	 * @param ScgCdVO[] scgCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScgCode(ScgCdVO[] scgCdVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckInstrVO scgPckInstrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionCode(ScgPckInstrVO scgPckInstrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * IBC Code for Organic peroxide  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgPckReguPkgOrgPrxVO[] scgPckReguPkgOrgPrxVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationOrganicPeroxideList(ScgPckReguPkgOrgPrxVO[] scgPckReguPkgOrgPrxVOs, SignOnUserAccount account ) throws EventException;

	/**
	 * IBC Code for Organic peroxide  을 조회 합니다. <br>
	 * 
	 * @param  ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO
	 * @return List<ScgPckReguPkgOrgPrxVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgOrgPrxVO> searchPackingInstructionRegulationOrganicPeroxideList(ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO ) throws EventException;

	/**
	 * Image File List를 조회 합니다. <br>
	 *   
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguImgVO>
	 * @exception EventException
	 */
	public List<ScgPckReguImgVO> searchPackingInstructionRegulationImgList(String pkgCd, String pkgCdSeq, String dispNo) throws EventException;

	/**
	 * Image File List를 저장한다. <br>
	 *   
	 * @param ScgPckReguImgVO[] scgPckReguImgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationImgList(ScgPckReguImgVO[] scgPckReguImgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_SCG_0105 : Retrieve <br>
	 * Proper IBC code
	 * 
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingInstructionRegulationPackagingIbcCodeList(String pkgCd, String pkgCdSeq, String dispNo) throws EventException;

	/**
	 * VOP_SCG_0105 : SAVE <br>
	 * Proper IBC code
	 * 
	 * @param ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPackagingIbcCodeList(ScgPckReguPkgIbcCdVO[] ScgPckReguPkgIbcCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_SCG_0103 : OPEN <br>
	 * Proper IBC code
	 * 
	 * @param String pckTpCd
	 * @param String pckMtrlTpCd
	 * @param String pckStyCd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPkgMtrlTpCdComboData(String pckTpCd, String pckMtrlTpCd, String pckStyCd) throws EventException;
	
	/**
	 * VOP_SCG_0105 : IBC CODE ONCHANGE <br>
	 * 
	 * @param ScgPckReguPkgIbcCdVO ScgPckReguPkgIbcCdVO
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingIbcCodeList(ScgPckReguPkgIbcCdVO ScgPckReguPkgIbcCdVO) throws EventException;	
	
	/**
	 * VOP_SCG_0107 : Retrieve <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */	
	public List<ScgPckCreationVO> searchPackingInstructionRegulationPKGMethodList(ScgPckCreationVO scgPckCreationVO) throws EventException;

	/**
	 * VOP_SCG_0107 : Retrieve <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */	
	public List<ScgPckCreationVO> searchPackingInstructionPKGMethodRefList(ScgPckCreationVO scgPckCreationVO) throws EventException;

	/**
	 * VOP_SCG_0107 : SAVE <br>
	 * Packing Instruction Creation
	 * 
	 * @param ScgPckCreationVO[] ScgPckCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPKGMethodList(ScgPckCreationVO[] ScgPckCreationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO[] ScgPckRefVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionReference(ScgPckRefVO[] ScgPckRefVOs, SignOnUserAccount account) throws EventException;
	
	/**	
	 * Packaging Code General  을 조회 합니다. <br>
	 * 
	 * @param  ScgPckReguPkgCdVO scgPckReguPkgCdVO
	 * @return List<ScgPckReguPkgCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgCdVO> searchPackingInstructionRegulationPackagingCodeList(ScgPckReguPkgCdVO scgPckReguPkgCdVO ) throws EventException;

	/**
	 * Packaging Code General  을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param ScgPckReguPkgCdVO[] scgPckReguPkgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulationPackagingCodeList(ScgPckReguPkgCdVO[] scgPckReguPkgCdVOs, SignOnUserAccount account ) throws EventException;

	/**
	 * VOP_SCG_0104 : IBC CODE ONCHANGE <br>
	 * 
	 * @param String pkgCd
	 * @return List<ScgPckReguPkgCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgCdVO> checkPkgCd(String pkgCd) throws EventException;	

	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckReguVO scgPckReguVO
	 * @return List<ScgPckReguVO>
	 * @exception EventException
	 */
	public List<ScgPckReguVO> searchPackingInstructionRegulation(ScgPckReguVO scgPckReguVO) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckReguVO[] ScgPckReguVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionRegulation(ScgPckReguVO[] ScgPckReguVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPkgVO scgPckPkgVO
	 * @param String pkgStyCd
	 * @return List<ScgPckPkgVO>
	 * @exception EventException
	 */
	public List<ScgPckPkgVO> searchPackingInstructionPackaging(ScgPckPkgVO scgPckPkgVO, String pkgStyCd) throws EventException;
		
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @param String pkgStyCd
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPackagingReference(ScgPckRefVO scgPckRefVO, String pkgStyCd) throws EventException;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPkgVO[] scgPckPkgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionPackaging(ScgPckPkgVO[] scgPckPkgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgSpclPckProviVO scgSpclPckProviVO
	 * @return List<ScgSpclPckProviVO>
	 * @exception EventException
	 */
	public List<ScgSpclPckProviVO> searchPackingInstructionSpclProvi(ScgSpclPckProviVO scgSpclPckProviVO) throws EventException;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgSpclPckProviVO[] ScgSpclPckProviVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionSpclProvi(ScgSpclPckProviVO[] ScgSpclPckProviVOs, SignOnUserAccount account) throws EventException;
	
	 /**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckGasReguVO scgPckGasReguVO
	 * @return List<ScgPckGasReguVO>
	 * @exception EventException
	 */
	public List<ScgPckGasReguVO> searchPackingInstructionGasRegulation(ScgPckGasReguVO scgPckGasReguVO) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasRegulationReference(ScgPckRefVO scgPckRefVO) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasSpclProviReference(ScgPckRefVO scgPckRefVO) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckGasReguVO[] ScgPckGasReguVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionGasRegulation(ScgPckGasReguVO[] ScgPckGasReguVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPtbTnkVO scgPckPtbTnkVO
	 * @param String ptbTnkInstrCd
	 * @return List<ScgPckPtbTnkVO>
	 * @exception EventException
	 */
	public List<ScgPckPtbTnkVO> searchPackingInstructionPortableTank(ScgPckPtbTnkVO scgPckPtbTnkVO, String ptbTnkInstrCd) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPortableTankReference(ScgPckRefVO scgPckRefVO) throws EventException ;
	
	/**
	 * VOP_SCG_0103 : SAVE <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPtbTnkVO[] ScgPckPtbTnkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePackingInstructionPortableTank(ScgPckPtbTnkVO[] ScgPckPtbTnkVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckInstrVO scgPckInstrVO
	 * @return List<ScgPckInstrVO>
	 * @exception EventException
	 */
	public List<ScgPckInstrVO> searchPackingInstructionCode(ScgPckInstrVO scgPckInstrVO) throws EventException;
	
	/**
	 * SCG Chemical History file 을 조회 합니다. <br>
	 * 
	 * @param  ScgChemHistoryFileVO scgChemHistoryFileVO
	 * @return List<ScgChemHistoryFileVO>
	 * @exception EventException
	 */
	public List<ScgChemHistoryFileVO> searchChemFileList(ScgChemHistoryFileVO scgChemHistoryFileVO) throws EventException;
	
	/**
	 * SCG Chemical History file 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param ScgChemHistoryFileVO[] scgChemHistoryFileVOs
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChemFile(ScgChemHistoryFileVO[] scgChemHistoryFileVOs, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * 첨부파일의 max seq 값을 검색<br>

	 * @param  String nseq
	 * @param  String div
     * @return String
     * @throws EventException
     */
	public String searchAtchFileSeq(String nseq, String div)  throws EventException;
	
	/**
	 * Partner's Contact Point for SPCL CGO by POL 을 조회 합니다. <br>
	 * 
	 * @param  ScgCntcPntPolVO scgCntcPntPolVO
	 * @return List<ScgCntcPntPolVO>
	 * @exception EventException
	 */
	public List<ScgCntcPntPolVO> searchPartnerContactPointPolList(ScgCntcPntPolVO scgCntcPntPolVO) throws EventException;
	
	/**
	 * Partner's Contact Point for SPCL CGO by Pol 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgCntcPntPolVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerContactPointPol(ScgCntcPntPolVO[] scgCntcPntPolVOs,SignOnUserAccount account) throws EventException;

}