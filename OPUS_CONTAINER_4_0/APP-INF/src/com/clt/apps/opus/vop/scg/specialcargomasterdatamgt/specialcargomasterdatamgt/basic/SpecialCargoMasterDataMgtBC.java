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
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgCntcPntVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.ScgImdgAbbrVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgMrnPolutVO;
import com.clt.syscommon.common.table.ScgImdgPckCdVO;
import com.clt.syscommon.common.table.ScgImdgPckGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgTnkTpVO;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * OPUS-Specialcargomasterdatamgt Business Logic Command Interface<br>
 * - OPUS-Specialcargomasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * RSO을 조회 합니다. <br>
	 * 
	 * @param ScgRgnShpOprCdVO scgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoforEdiUnmapList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws EventException;

	/**
	 * Partner's Contact Point for SPCL CGO 을 생성,수정,삭제 합니다. <br>
	 * 
	 * @param scgCntcPntVOs
	 * @param scgCntcPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerLineContactPoint(ScgCntcPntVO[] scgCntcPntVOs, ScgCntcPntVO scgCntcPntVO, SignOnUserAccount account) throws EventException;

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
     * Loading Port for RSO Retrieve Dup Check 내용을 조회한다.
	 * 
	 * @param  String locCd
	 * @return List<GetLoadingPortRsoVO>
	 * @exception EventException
	 */
	public  List<GetLoadingPortRsoVO>   searchLoadingPortRSODupChk(String locCd) throws EventException;	
	
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
	 * @return List<ScgImdgPckInstrVO>
	 * @exception EventException
	 */
	public  List<ScgImdgPckInstrVO>   searchPackingInstructionList(String imdgPckInstrCd) throws EventException;
	
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
	 * Carreier Code를 체크한다. <br>
	 * 
	 * @param String crrCd
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> searchCarrierCode(String crrCd) throws EventException;
    
}