/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterBC.java
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Seung-Man KIM
* 1.0 Creation
* Cr반영용
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
* 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결 추가)
* 2015.08.14 김성욱, Standby BKG Report 메뉴 추가
* 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgInfoListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BookingStowageVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchCompulsoryFirmVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcSbBkgDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ALPS-Basicdatamanage Business Logic Command Interface<br>
 * - ALPS-Basicdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Man KIM
 * @see Esm_Spc_0115EventResponse 참조
 * @since J2EE 1.6
 */


public interface ConstraintMasterBC {

	
	/**
     * Booking Allocation Master Table 화면 조회 메소드
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
	public List<SpcAlocMgmtVO> searchBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;
    
    /**
     * Booking Allocation Master Table 화면 관리 메소드.<br>
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO[] spcAlocMgmtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgAlocMgmt(SpcAlocMgmtVO[] spcAlocMgmtVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		SpcAlocMgmtVO spcAlocMgmtVO
	 * @exception 	EventException
     */
    public void removeBkgAlocMgmt(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;
    
    /**
	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @exception EventException
	 */	
	public List<SpcAlocMgmtVO> searchBkgAlocValidationData(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;

	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
    public List<SpcAlocMgmtVO> searchCmdtNm(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;    
    
    /**
     * Booking Allocation Master Table 화면에 Group Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
    public List<SpcAlocMgmtVO> searchGrpCmdtNm(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;    
    /**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse,String[][] array,SignOnUserAccount account) throws EventException ;
	
	 /**
     * group code 목록을 조회한다. <br>
     *
     * @param SearchConditionVO searchVo
     * @param ReportFormVO vo
     * @return List<ReportFormVO>
     * @exception EventException
     */	
	public List<ReportFormVO> searchSetFormList(SearchConditionVO searchVo, ReportFormVO vo) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param SearchConditionVO searchVo
     * @param ReportFormVO vo
     * @param SignOnUserAccount account
     * @return List<ReportFormVO>
     * @exception EventException	 
	 */
	public List<ReportFormVO> searchSetFormList2(SearchConditionVO searchVo, ReportFormVO vo, SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param SearchConditionVO searchVo
     * @param ReportFormVO vo
     * @param SignOnUserAccount account
     * @return List<ReportFormVO>
     * @exception EventException	 
	 */
	public ReportFormVO searchSetFormList3(SearchConditionVO searchVo, ReportFormVO vo, SignOnUserAccount account) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param SalesRPTCommonVO[] vos
	 * @param ReportFormVO[] tVos
	 *  @param ReportFormVO tVo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSetForm(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, ReportFormVO[] tVos,ReportFormVO tVo,  SignOnUserAccount account) throws EventException;

	/**
     * Import Mastertable 화면 조회 화면 조회 메소드
     * 
     * @author Arie
     * @param BkgInfoListVO[] bkgVOs 
     * @param SearchConditionVO scvo
     * @return List<BkgInfoListVO>
     * @throws EventException
     */
	public List<BkgInfoListVO> searchBkgInfoList(BkgInfoListVO[] bkgVOs, SearchConditionVO scvo) throws EventException; 

	/**
     * Import Mastertable  저장하기
     * 
     * @author Arie
     * @param BkgInfoListVO[] bkgVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void multiBkgInfoList4MasterTable(BkgInfoListVO[] bkgVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 *  Compulsory Firm 대상 Booking 정보를 조회한다.<br> Compulsory Firm Copy : 2015.02.11 김성욱
	 *
	 * @author KimByungKyu
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchCompulsoryFirmVO>
	 * @exception EventException
	 */
	public List<SearchCompulsoryFirmVO> searchCompulsoryFirmList(SearchConditionVO conditionVO) throws EventException;
		
	/**
	 *  Office Setup 에 등록된 Office code 인지 여부를 체크합니다.(ESM_SPC_0115)
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @exception EventException
	 */
	public List<SpcAlocMgmtVO> checkOfficePfmc(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;
	
	/**
	 *  Office Setup 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @exception EventException
	 */
	public List<SpcAlocMgmtVO> checkCtrlOffice(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;
	
	/**
	 * 
	 * 
	 * @param String substring
	 * @param String substring2
	 * @param String substring3
	 * @return boolean
	 * @exception EventException
	 */
	public boolean validateVvd(String substring, String substring2,String substring3) throws EventException;
	/**
	 * 
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
	public String searchSvcLaneByVvd(String vvd) throws EventException;
	
	
//	/**
//     * Import Mastertable 화면 조회 화면 조회 메소드
//     * 
//     * @author Arie
//     * @return List<ReapplyBKGListVO>
//     * @throws EventException
//     */
//    public List<ReapplyBKGListVO> searchReapplyBKGList() throws EventException;
    
    
    /**
	 * SPC_SB_BKG 데이터를 MERGE한다.<BR>
	 * 
     * @author Arie
	 * @param  SpcSbBkgVO vo
     * @return GeneralEventResponse
	 * @throws EventException
	 */
    public GeneralEventResponse multiSpcSbBk(SpcSbBkgVO vo) throws EventException;

    /**
	 * Conpulsory firm 의 confirm Request 요청
	 <BR>
	 * 
     * @author Kim Sung Wook
	 * @param  SpcSbBkgVO[] vos
	 * @param SignOnUserAccount account
     * @return boolean
	 * @throws EventException
	 */
    public boolean confirmRequest(  SpcSbBkgVO[] vos , SignOnUserAccount account) throws EventException;
    
    /**
     * Conpulsory firm 의 Standby 를 Firm 으로 요청
	 <BR>
     * 
     * @author Kim Sung Wook
     * @param  BkgListForCompFirmBySPCVO vo
     * @param  SignOnUserAccount account
     * @return boolean
     * @throws EventException
     */
    public boolean setComfirm(  BkgListForCompFirmBySPCVO vo , SignOnUserAccount account ) throws EventException;

    /**
	 * BKG에서 호출하는 BKG한건당 Standby 조건 체크<BR>
	 * 
     * @author Arie Im
	 * @param  String bkg_no
	 * @param  SignOnUserAccount account
     * @return List<SpcSbBkgDtlVO>
	 * @throws EventException
	 */
	public List<SpcSbBkgDtlVO> standbyCheck4Bkg(String bkg_no, SignOnUserAccount account) throws EventException;

	/**
	 * Reprocess 버튼 클릭시 수행
	 * DB Procedure 호출
	 * 
	 * @param SearchConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String doReprocess(SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException;
	/**
	 * ESM_SPC_0116 : SEARCH03<br>
	 * Reprocess 버튼 클릭 시 수행전 현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkReprocessCondition(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * ESM_SPC_0116 : MODIFY03<br>
	 * Reprocess 시작 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에 삽입합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
 	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addReprocessCondition(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException ;
	/**
	 * ESM_SPC_0116 : MODIFY04<br>
	 * Reprocess 종료 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에서 삭제합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @throws EventException
	 */
	public void removeReprocessCondition(SearchConditionVO searchConditionVO) throws EventException ;
	
	/**
	 * Office에 해당 하는 Level 값을 가져온다.
	 * @param SearchOfficeCondVO vo
	 * @param SignOnUserAccount account
	 * @return SearchOfficeCondVO
	 * @throws EventException
	 */
	public String searchOfcLevel( SearchOfficeCondVO vo, SignOnUserAccount account) throws EventException;
	/**
	 * Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받는다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addFixedFlagInfoByPri(String propNo, String amdtSeq, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception EventException
	 */
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws EventException;
	
	
	/*============================== ESM_SPC_0052, 0114 package 변경 시작==============================*/
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiSpaceAllocationControlOption(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOption(ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOptionDetail(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiSpaceAllocationLaneControlOptionDetail(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * [ESM_SPC_0052]을 [UPLOAD SAVE] 합니다.
//	 * 
//	 * @param searchSpaceAllocationLaneControlOptionVOs
//	 * @param account
//	 * @throws EventException
//	 */
//	public void multiSpaceAllocationLaneControlOptionDetail02(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocationLaneControlOptionDetail02(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVO,SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVO
	 * @throws EventException
	 */
	public void removeSpaceAllocationLaneControlOptionDetail(SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO) throws EventException ;

	/**
	 * Booking Control Option get List
	 * @param SearchOfficeBKGInControlVO searchOfficeBKGInControlVO
	 * @return List<SearchOfficeBKGInControlVO>
	 * @throws EventException
	 */
	public List<SearchOfficeBKGInControlVO> searchSpaceAllocationControloffice(SearchOfficeBKGInControlVO searchOfficeBKGInControlVO) throws EventException;
	
	/**
	 * multiSpaceAllocationBKGControlOptionOfficeList 
	 * @param SearchOfficeBKGInControlVO[] searchOfficeInBKGControlVOs 
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpaceAllocationBKGControlOptionOfficeList( SearchOfficeBKGInControlVO[] searchOfficeInBKGControlVOs , SignOnUserAccount account ) throws EventException ;
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * Office 정보 가져오기
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @return List<SqmQtaLaneOfcVO>
	 * @throws EventException
	 */
	public List<SqmQtaLaneOfcVO> searchSpaceAllocationControloffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO) throws EventException ;
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 선택된 control 에 속한 Office 정보 가져오기
	 * @param SearchOfficeInControlVO searchOfficeInControlVO
	 * @return List<SearchOfficeInControlVO>
	 * @throws EventException
	 */
	public List<SearchOfficeInControlVO> searchSpaceAllocationOfficeInControl(SearchOfficeInControlVO searchOfficeInControlVO) throws EventException ;
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다. Control Option Office List , SAVE 작업
	 * Insert / Update / Delete 
	 * @param SearchOfficeInControlVO[] searchOfficeInControlVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpaceAllocationLaneControlOptionOfficeList( SearchOfficeInControlVO[] searchOfficeInControlVO , SignOnUserAccount account ) throws EventException ;
	
	/**
	 * searchCustomerControlCode
	 * 
	 * @param CustomerControlGroupVO customerControlGroupVO
	 * @return List<CustomerControlGroupVO>
	 * @throws EventException
	 */
	public List<CustomerControlGroupVO> searchCustomerControlCode(CustomerControlGroupVO customerControlGroupVO) throws EventException;

	/**
	 * ESM_SPC_0052: 두번째 Sheet내 Control(Fixed) 선택한 후 SC NO 입력시 
	 * 입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
	 * 
	 * @param String scNo
	 * @return String
	 * @throws EventException
	 */
	public String searchScNoValidForFixed(String scNo) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocationLaneControlOptionVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationLaneControlOptionDetail02(ConditionVO conditionVO) throws EventException;

	/*============================== ESM_SPC_0052, 0114 package 변경 종료==============================*/


	/**
	 *  Standby BKG Report 대상 Aloc,SMP 정보를 조회한다.
	 *
	 * @author KimByungKyu
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchCompulsoryFirmVO>
	 * @exception EventException
	 */
//	public List<SearchCompulsoryFirmVO> searchStandbyBKGReportList(SearchConditionVO conditionVO) throws EventException;	

	/**
	 *  Standby BKG Report 대상 Mastertable 정보를 조회한다.
	 *
	 * @author KimByungKyu
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchStandbyBKGRPTMSTVO>
	 * @exception EventException
	 */
//	public List<SearchStandbyBKGRPTMSTVO> searchStandbyBKGReportMSTList( SearchConditionVO conditionVO ) throws EventException;
	
	/**
	 *  Standby BKG Report 대상 Mastertable, SMP, ALOC 정보를 조회한다.
	 *
	 * @author KimSungWook
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchStandbyBKGRPTMSTVO>
	 * @exception EventException
	 */
//	public List<SearchStandbyBKGRPTMSTVO> searchStandbyBKGReportAllList( SearchConditionVO conditionVO ) throws EventException;
	/**
	 * [Container Type/Size]을 [조회] 합니다.<br>
	 * 
	 * @param GetCodeSelectVO conditionVO
	 * @return List<GetCodeSelectVO>
	 * @exception EventException
	 */
	public List<GetCodeSelectVO> searchSpaceContainerTypeSizeList(GetCodeSelectVO conditionVO) throws EventException;
	
	
	/**
	 * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.<br>

	 * @param  SearchConditionVO searchVo
	 * @return List<CommonCodeVO>
	 * @throws EventException
	 */
	public List<CommonCodeVO> searchStandbyBatchStatus(SearchConditionVO searchVo) throws EventException;


	/**
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param SpcSbBkgVO[] spcSbBkgVos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addStandbyBatchStatus(SpcSbBkgVO[] spcSbBkgVos , SignOnUserAccount account ) throws EventException;

	
    /**
     * Stowage List를 조회 한다.<br>
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<BookingStowageVO>
     * @exception EventException
     */ 
    public List<BookingStowageVO> searchBookingStowageList(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException;


}