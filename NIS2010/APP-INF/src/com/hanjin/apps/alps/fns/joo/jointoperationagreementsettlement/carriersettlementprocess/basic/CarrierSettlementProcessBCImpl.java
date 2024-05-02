/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessBCImpl.java
*@FileTitle : War Risk Surcharge Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 박희동
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.03 진마리아 [CHM-201006730-01]
                    Summary of Monthly Clearance Status by Carrier 기능에 Due Date, Remark 컬럼 추가
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
* 2011.01.12 김상수 [소스품질관리] R4J에 도출된 parameter 비매치 주석 수정
* 2011.02.10 이준범 [CHM-201108791-01]
* 제목: JOO Target Voyage vs Unsettled Status Remark 기능 변경
* 보완내역 : JOO Target Voyage vs Unsettled Status Remark 기능 변경 관련하여
*          JOO_TGT_UNSTL_STS_RMK 테이블 수정 시 체크로직 추가
* 2011.02.17 남궁진호 [CHM-201108953-01] FNS_JOO_0056 : RDR Inquiry by Lane 화면의 저장 로직 수정 
*            manageRDRVVDCrrRmk 로직변경 : 존재유무 체크 후 false= Insert, true=update
*            checkedRDRVVDCrrRmk: JOO_RDR_VVD_CRR_RMK 데이터 체크 메소드 추가 
* 2012.06.21 김상근[CHM-201218380]
* Ticket Title : [ALPS JOO] TDR Inquiry by VVD
* Description  :  Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가.
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Collections;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustOusRDRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.IntloadSumReportVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusReportVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusBsaVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrRatioVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBackEndJob;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooStlDtlVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SkdPortVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration.CLLCDLManifestDBDAO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestVslSkdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;

/**
 * ALPS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - ALPS-JointOperationAgreementSettlement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0013EventResponse,CarrierSettlementProcessBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class CarrierSettlementProcessBCImpl extends BasicCommandSupport implements CarrierSettlementProcessBC {

	// Database Access Object
	private transient CarrierSettlementProcessDBDAO dbDao = null;
	private transient CLLCDLManifestDBDAO cLLCDLManifestDBDAO = null; 

	/**
	 * CarrierSettlementProcessBCImpl 객체 생성<br>
	 * CarrierSettlementProcessDBDAO를 생성한다.<br>
	 */
	public CarrierSettlementProcessBCImpl() {
		dbDao = new CarrierSettlementProcessDBDAO();
		cLLCDLManifestDBDAO = new CLLCDLManifestDBDAO();
	}
	/**
	 * JOO_SETTLEMENT를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchSettlementList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 다건의 JOO_SETTLEMENT를 삭제한다.
	 * JOO_STL_VVD를 UPDATE하기 위해 List를 넘겨준다.
	 * -조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm
	 * @param ProcSettlementVO procSettlementVO
	 * @return ProcSettlementVO[]
	 * @throws EventException
	 */
	public ProcSettlementVO[] removeSettlement(ProcSettlementVO procSettlementVO) throws EventException {
		ProcSettlementVO[] procSettlementVOs = null;
		try {
			List<ProcSettlementVO> list = dbDao.searchJooSettlementListForDelete(procSettlementVO);
			log.debug("\n\n\nsize="+list.size()+"\n\n\n");
			//Settlement 삭제
			dbDao.removeSettlementS(list);
			
			procSettlementVOs = new ProcSettlementVO[list.size()];
			
			for(int i=0; i<list.size(); i++){
				procSettlementVOs[i] = list.get(i);
				procSettlementVOs[i].setIbflag("D");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		}
		return procSettlementVOs;
	}
	
	/**
	 * Settlement에서 Create 버튼을 눌렀을 경우 Joo_settlement에 없는 항차를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Setttlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Setttlement", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchStlVvd(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		}
	}
	
	/**
	 * 0037화면에서 JOO_SETTLEMENT를 읽어온다.
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByTrade (McsStatusVO mcsStatusVO) throws EventException {
		try { 
			mcsStatusVO.setFromDt(mcsStatusVO.getFromDt().replace("-", ""));
			mcsStatusVO.setToDt(mcsStatusVO.getToDt().replace("-", ""));
			return dbDao.searchSummaryOfMcsListByTrade(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

	/**
	 * FNS_JOO_0007 Slot Hire 의 Create 버튼을 눌렀을 경우 JOO_SETTLEMENT에 없는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForSlotHireList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForSlotHireList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Hire Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Hire Settlement", "Creation"}).getMessage(), ex);
		}
	}
	
	/**
	 * 0037 선사를 조회조건으로 joo_settlement를 조회한다.
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByCarrier(McsStatusVO mcsStatusVO) throws EventException {
		try {
			mcsStatusVO.setFromDt(mcsStatusVO.getFromDt().replace("-", ""));
			mcsStatusVO.setToDt(mcsStatusVO.getToDt().replace("-", ""));

			return dbDao.searchSummaryOfMcsListByCarrier(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	
	/**
	 * FNS_JOO_0009 OUS RDR 화면의 Create버튼을 눌렀을 경우 JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusRdrList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForOusRdrList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Over Used Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Over Used Settlement", "Creation"}).getMessage(), ex);
		}
	}
    /**
     *  UID : FNS_JOO_0039
     *  Monthly Clearance Status by Carrier & Lane - Retrieve 
     *    
     * @param StlConditionVO stlConditionVO
     * @return List<McsVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<McsVO> searchMcsListByCarNLane(
            StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMcsListByCarNLane(stlConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
 
    /**
     *  Monthly Clearance Status by Carrier & Lane - Retrieve
     *     UID : FNS_JOO_0039
     * @param StlConditionVO stlConditionVO
     * @param JooSettlementVO[] jooSettlementVOs
     * @return List<McsVO>
     * @throws EventException
     */
    public List<McsVO> searchMccDtlListByCarNLane(StlConditionVO stlConditionVO, JooSettlementVO[] jooSettlementVOs) throws EventException{   
        try {
            return dbDao.searchMccDtlListByCarNLane(stlConditionVO, jooSettlementVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
 
    /**
     * Inter Port / Ocean 선택시 단가, used qty등을 조회한다.
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrc(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchBsaSltPrc(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * FNS_JOO_0010 OUS TDR용 Create버튼을 눌렀을 경우  JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusTdrList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForOusTdrList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * OUS TDR에서 VVD 입력시 기본정보를 가져온다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrFnl(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrFnl(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Check VVD"}).getMessage(), ex);
		}
	}

	/**
	 * VVD와 from~to port 입력시 USED SLOT 의 TEU, WGT를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlot(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrUsedSlot(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * VVD와 from port 입력시 USED SLOT PRICE를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlotPrice(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrUsedSlotPrice(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Slot Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Slot Price Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_JOO_0011 R/F settlement의 조회용 method임
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> searchSettlementRFList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchSettlementRFList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
	 * FNS_JOO_0011 R/F의 Creation용 조회 Method
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchAddStlForRFList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForRFList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * FNS_JOO_0011 R/F의 Row Add에서 I/O, RGN, POL, POD변경시 Used R/F 데이터를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchUsedReeferList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchUsedReeferList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}


	/**
	 * Adjustment Slot Hire 조회
	 * @param AdjustConditionVO adjustConditionVO
	 * @return List<AdjustSettlementVO>
	 * @throws EventException
	 */
	public List<AdjustSettlementVO> searchAdjustSlotHireStlList(AdjustConditionVO adjustConditionVO) throws EventException {
		try {
			return dbDao.searchAdjustSlotHireStlList(adjustConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Adjust Settlement 저장 (JOO_SETTLEMENT와 JOO_STL_DTL 에 Insert, Delete만 존재한다.)
	 * @param AdjustSettlementVO[] adjustSettlementVOs 
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdjustSlotHireStl(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			JooStlDtlVO jooStlDtlVO = null;
			AdjustSettlementVO adjustSettlementVO = null;
			JooSettlementVO jooSettlementVO = null;
			List<JooStlVvdVO> tmpTargetVVDVOs = new ArrayList<JooStlVvdVO>();
			for ( int i=0; i<adjustSettlementVOs.length; i++ ) {
				adjustSettlementVO = adjustSettlementVOs[i];
				
				//JO_STL_JB_CD 즉 BSA Type이 없는 경우는 COA, JOO에 둘다 없는 경우이므로 Adjustment하지 않는다.
				if (adjustSettlementVO.getJoStlJbCd() == null || "".equals(adjustSettlementVO.getJoStlJbCd()))
					continue;
				
				if (adjustSettlementVO.getIbflag().equals("I")){
					//대상항차의 sequence를 조회한다.
					tmpTargetVVDVOs = dbDao.searchStlVvdSeq(adjustSettlementVO);
					adjustSettlementVO.setStlVvdSeq(tmpTargetVVDVOs.get(0).getStlVvdSeq());

					adjustSettlementVO.setCreUsrId(signOnUserAccount.getUsr_id());
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					
					//         STL_ADJ_FLG   STL_LST_FLG
					//Adjust BEF     N             Y        
					//Adjust AFT     N             N
					//New Row(S/H)   Y             Y
					//NEW ROW(M/S)   Y             N   
					
					//STL_ADJ_IRR_FLG가 N인 경우는 ADJUST를 하므로 STL_LST_FLG를 N으로 수정한다. 
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg())){
						adjustSettlementVO.setStlAdjIrrFlg("N");
						adjustSettlementVO.setStlLstFlg   ("N");
						adjustSettlementVO.setStlAdjFlg   ("N");
					//STL_ADJ_IRR_FLG가 Y인 경우는 ADJUST를 안하므로 그대로 간다. 
					}else{
						adjustSettlementVO.setStlAdjIrrFlg("Y");
						adjustSettlementVO.setStlLstFlg   ("Y");
						adjustSettlementVO.setStlAdjFlg   ("N");
					}
					dbDao.modifyAdjustSettlement(adjustSettlementVO);
					
					//JOO_SETTLEMENT에 Adjust 한 내역 Insert
					//2009.10.12 STL_ADJ_IRR_FLG가 Y인 것은 adjust하지 않는다. 
					if ("N".equals(adjustSettlementVO.getStlAdjIrrFlg())){
						int stlSeq = dbDao.searchNextStlSeq(adjustSettlementVO);
						adjustSettlementVO.setStlSeq(stlSeq+"");
						
						//Other인 경우 TEU와 Amount에 -1을 곱해준다.
						if ("M/S".equals(adjustSettlementVO.getJoMnuNm())){
							adjustSettlementVO.setStlLstFlg("N"); // M/S인 경우는 lst_flag 를 N으로 해서 다시는 adjustment 대상이 되지 않도록 한다. 
						}else{
							adjustSettlementVO.setStlLstFlg("Y");
						}
	
						adjustSettlementVO.setStlAdjFlg("Y");
						adjustSettlementVO.setStlAdjIrrFlg("N");
						adjustSettlementVO.setStlAdjIrrRmk("");
						adjustSettlementVO.setCmbCfmFlg("N");
						dbDao.addAdjustSettlement(adjustSettlementVO);
					
						//JOO_STL_DTL에 Adjust한 내역 중 수량이 변경된 경우 Insert
						if (adjustSettlementVO.getDtlBsaQty() != null && !adjustSettlementVO.getDtlBsaQty().equals("0")){
							jooStlDtlVO = makeJooStlDtlVOFromAdjustSettlementVO(adjustSettlementVO, "T");
							jooStlDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
							dbDao.addJooStlDtl(jooStlDtlVO);
						}
						
						//JOO_STL_DTL에 Adjust한 내역 중 단가가 변경된 경우 Insert
						if (adjustSettlementVO.getDtlBsaSltPrc() != null && !adjustSettlementVO.getDtlBsaSltPrc().equals("0")){
							jooStlDtlVO = makeJooStlDtlVOFromAdjustSettlementVO(adjustSettlementVO, "P");
							jooStlDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
							dbDao.addJooStlDtl(jooStlDtlVO);
						}
					}
				//STL_ADJ_IRR_FLG, STL_ADJ_IRR_RMK만 수정하는 경우가 있을 수 있음
				} else if ( adjustSettlementVO.getIbflag().equals("U")){
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg()))
						adjustSettlementVO.setStlAdjIrrFlg("N");
					else
						adjustSettlementVO.setStlAdjIrrFlg("Y");
						
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					dbDao.modifyAdjustSettlement(adjustSettlementVO);
				} else if ( adjustSettlementVO.getIbflag().equals("D")){
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg()))
						adjustSettlementVO.setStlAdjIrrFlg("N");
					else
						adjustSettlementVO.setStlAdjIrrFlg("Y");
					//JOO_SETTLEMENT 기존 정보 stl_lst_flg 를 Y로 update
					adjustSettlementVO.setStlLstFlg("Y");
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUpd_usr_id());
					dbDao.modifyAdjustSettlement(adjustSettlementVO);
					//JOO_STL_DTL 삭제
					dbDao.removeJooStlDtl(adjustSettlementVO);
					//JOO_SETTLEMENT 삭제
					jooSettlementVO = makeJooSettlementVOFromAdjustSettlementVO(adjustSettlementVO);
					dbDao.removeSettlement(jooSettlementVO);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Save"}).getMessage(), ex);
		}
	}
	

	/**
	 * AdjustSettlementVO로 JooSettlementVO생성한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @return JooSettlementVO
	 * @throws EventException
	 */
	private JooSettlementVO makeJooSettlementVOFromAdjustSettlementVO(AdjustSettlementVO adjustSettlementVO) throws EventException{
		JooSettlementVO jooSettlementVO = new JooSettlementVO();
		try{
			jooSettlementVO.setAcctYrmon           (adjustSettlementVO.getAcctYrmon           ()); 
			jooSettlementVO.setStlSeq              (adjustSettlementVO.getStlSeq              ()); 
			jooSettlementVO.setStlVvdSeq           (adjustSettlementVO.getStlVvdSeq           ()); 
			jooSettlementVO.setTrdCd               (adjustSettlementVO.getTrdCd               ()); 
			jooSettlementVO.setJoCrrCd             (adjustSettlementVO.getJoCrrCd             ()); 
			jooSettlementVO.setRlaneCd             (adjustSettlementVO.getRlaneCd             ()); 
			jooSettlementVO.setReDivrCd            (adjustSettlementVO.getReDivrCd            ()); 
			jooSettlementVO.setJoStlItmCd          (adjustSettlementVO.getJoStlItmCd          ()); 
			jooSettlementVO.setJoMnuNm             (adjustSettlementVO.getJoMnuNm             ()); 
			jooSettlementVO.setVslCd               (adjustSettlementVO.getVslCd               ()); 
			jooSettlementVO.setSkdVoyNo            (adjustSettlementVO.getSkdVoyNo            ()); 
			jooSettlementVO.setSkdDirCd            (adjustSettlementVO.getSkdDirCd            ()); 
			jooSettlementVO.setRevDirCd            (adjustSettlementVO.getRevDirCd            ()); 
			jooSettlementVO.setStlBzcPortCd        (adjustSettlementVO.getStlBzcPortCd        ()); 
			jooSettlementVO.setEtaDt               (adjustSettlementVO.getEtaDt               ()); 
			jooSettlementVO.setJoStlJbCd           (adjustSettlementVO.getJoStlJbCd           ()); 
			jooSettlementVO.setBsaQty              (adjustSettlementVO.getBsaQty              ()); 
			jooSettlementVO.setBsaSltPrc           (adjustSettlementVO.getBsaSltPrc           ()); 
			jooSettlementVO.setLoclCurrCd          (adjustSettlementVO.getLoclCurrCd          ()); 
			jooSettlementVO.setAdjBsaQtyLoclAmt    (adjustSettlementVO.getAdjBsaQtyLoclAmt    ()); 
			jooSettlementVO.setAdjBsaSltPrcLoclAmt (adjustSettlementVO.getAdjBsaSltPrcLoclAmt ()); 
			jooSettlementVO.setStlLoclAmt          (adjustSettlementVO.getStlLoclAmt          ()); 
			jooSettlementVO.setStlUsdAmt           (adjustSettlementVO.getStlUsdAmt           ()); 
			jooSettlementVO.setIocCd               (adjustSettlementVO.getIocCd               ()); 
			jooSettlementVO.setScontiCd            (adjustSettlementVO.getScontiCd            ()); 
			jooSettlementVO.setFnlHjsBsaQty        (adjustSettlementVO.getFnlHjsBsaQty        ()); 
			jooSettlementVO.setFnlBsaWgt           (adjustSettlementVO.getFnlBsaWgt           ()); 
			jooSettlementVO.setUsdSltBsaQty        (adjustSettlementVO.getUsdSltBsaQty        ()); 
			jooSettlementVO.setUsdSltWgt           (adjustSettlementVO.getUsdSltWgt           ()); 
			jooSettlementVO.setBsaPerWgt           (adjustSettlementVO.getBsaPerWgt           ()); 
			jooSettlementVO.setFmPortCd            (adjustSettlementVO.getFmPortCd            ()); 
			jooSettlementVO.setToPortCd            (adjustSettlementVO.getToPortCd            ()); 
			jooSettlementVO.setRfScgStlTpCd        (adjustSettlementVO.getRfScgStlTpCd        ()); 
			jooSettlementVO.setRfScgPrc            (adjustSettlementVO.getRfScgPrc            ()); 
			jooSettlementVO.setStlRmk              (adjustSettlementVO.getStlRmk              ()); 
			jooSettlementVO.setCmbCfmFlg           (adjustSettlementVO.getCmbCfmFlg           ()); 
			jooSettlementVO.setStlTjNo             (adjustSettlementVO.getStlTjNo             ()); 
			jooSettlementVO.setStlAdjFlg           (adjustSettlementVO.getStlAdjFlg           ()); 
			jooSettlementVO.setPreAcctYrmon        (adjustSettlementVO.getPreAcctYrmon        ()); 
			jooSettlementVO.setPreStlVvdSeq        (adjustSettlementVO.getPreStlVvdSeq        ()); 
			jooSettlementVO.setPreStlSeq           (adjustSettlementVO.getPreStlSeq           ()); 
			jooSettlementVO.setStlLstFlg           (adjustSettlementVO.getStlLstFlg           ()); 
			jooSettlementVO.setUcBssPortCd         (adjustSettlementVO.getUcBssPortCd         ()); 
			jooSettlementVO.setUcBssPortEtdDt      (adjustSettlementVO.getUcBssPortEtdDt      ()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Adjustment", "Moving Data From AdjustSettlementVO to JooSettlementVO"}).getMessage(), ex);
		}
		return jooSettlementVO;
	}

	/**
	 * AdjustSettlementVO를 JooStlDtlVO로 생성한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @param String flag 
	 * @return JooStlDtlVO
	 * @throws EventException
	 */
	private JooStlDtlVO makeJooStlDtlVOFromAdjustSettlementVO(AdjustSettlementVO adjustSettlementVO, String flag) throws EventException{
		JooStlDtlVO jooStlDtlVO = new JooStlDtlVO();
		try{
			jooStlDtlVO.setAcctYrmon (adjustSettlementVO.getAcctYrmon ()); 
			jooStlDtlVO.setStlSeq    (adjustSettlementVO.getStlSeq    ()); 
			jooStlDtlVO.setStlVvdSeq (adjustSettlementVO.getStlVvdSeq ());
			//TEU변경인 경우
			if ("T".equals(flag)){
				jooStlDtlVO.setStlDtlSeq ("1");
				jooStlDtlVO.setBsaQty    (adjustSettlementVO.getDtlBsaQty()); 
				jooStlDtlVO.setBsaSltPrc (adjustSettlementVO.getBsaSltPrc()); 
				jooStlDtlVO.setStlLoclAmt(adjustSettlementVO.getAdjBsaQtyLoclAmt());  //
			//Price변경인 경우
			}else if ("P".equals(flag)){
				jooStlDtlVO.setStlDtlSeq ("2");
				jooStlDtlVO.setBsaQty    (adjustSettlementVO.getBsaQty1     ()); 
				jooStlDtlVO.setBsaSltPrc (adjustSettlementVO.getDtlBsaSltPrc()); 
				jooStlDtlVO.setStlLoclAmt(adjustSettlementVO.getAdjBsaSltPrcLoclAmt()); // 
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Adjustment", "Moving Data From AdjustSettlementVO to JooStlDtlVO"}).getMessage(), ex);
		}
		return jooStlDtlVO;
	}
    /**
     * 
     * FNS_JOO_0015 <br>
     * Monthly Clearance by Carrier & Lane의 Carrier정보를 조회 합니다.<br>
     *
     * @param StlConditionVO stlConditionVO
     * @return List<SettlementVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<SettlementVO> searchMonthlyClearanceList(
            StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMonthlyClearanceList(stlConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * [Summary of Monthly Clearance Status by VVD]을 [조회 Retrieve]합니다.<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<McsStatusReportVO> searchSummaryOfMcsListByVVD(
            McsStatusVO mcsStatusVO) throws EventException {
        try {
            return dbDao.searchSummaryOfMcsListByVVD(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * [Summary of Monthly Clearance Status by VVD - Total]을 [조회 Retrieve]합니다.<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<McsStatusReportVO> searchSummaryOfMcsListBySumVVD(
            McsStatusVO mcsStatusVO) throws EventException {
        try {
            return dbDao.searchSummaryOfMcsListBySumVVD(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }
    
    
    
    /**
     * FNS_JOO_0042 : Retrieve
     * D : [FnsJoo0042Event]<br>
     * [Slot Exchange Status by Lane & Partner->Finance Lane]을 [조회 Retrieve]합니다.<br>
     *
     * @param  SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchLaneVO> searchSlotXchStatusListByFinanceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException{  
        try {
            return dbDao.searchSlotXchStatusListByFinanceLane(slotXchLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0043 : Retrieve
     * D : [FnsJoo0043Event]<br>
     * [ Slot Exchange Status by Lane & Partner->Finance  Partner]을 [조회 Retrieve]합니다.<br>
     *
     * @param  SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO>
     * @throws EventException
     * @author jang kang cheol
     */    
    public List<SlotXchPartnerVO> searchSlotXchStatusListByFinancePartner(
            SlotXchPartnerVO slotXchPartnerVO) throws EventException {
        try {
            return dbDao.searchSlotXchStatusListByFinancePartner( slotXchPartnerVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retreive"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retreive"}).getMessage(), ex);
        }
    }    
    
    /**
     * 
     * FNS_JOO_0040 <br> 
     * Slot Exchange Status by Lane & Partner->Space On Lane 정보를 조회 합니다.<br>
     *
     * @param SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchLaneVO>    searchSlotXchStatusListBySpaceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException{  
        try {
            return dbDao.searchSlotXchStatusListBySpaceLane(slotXchLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * 
     * FNS_JOO_0041 <br> 
     * Slot Exchange Status by Lane & Partner->Space On Partner 정보를 조회 합니다.<br>
     *
     * @param SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchPartnerVO> searchSlotXchStatusListBySpacePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException{
        try {
            return dbDao.searchSlotXchStatusListBySpacePartner(slotXchPartnerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
        }        
        
    }
    /**
     * FNS_JOO_0049 <br> 
     * [ Settlement Status for Basic Allocation]을 [조회 Retrieve]합니다.<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusBsaVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<StlStatusBsaVO> searchStlStatusListForBSA(StlConditionVO stlConditionVO)
            throws EventException {
        try { 
            return dbDao.searchStlStatusListForBSA( stlConditionVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Status for Basic Allocation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Status for Basic Allocation", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0050 <br> 
     * [ Target Voyage vs Unsettled Status]을 [조회 Retrieve]합니다.<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<StlStatusVO> searchTgtVoyVsUnstlStatusList(StlConditionVO stlConditionVO)
            throws EventException {
        try {
            return dbDao.searchTgtVoyVsUnstlStatusList( stlConditionVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target Voyage vs Unsettled Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target Voyage vs Unsettled Status", "Retrieve"}).getMessage(), ex);
        }
    }
   
    /**
     * FNS_JOO_0050 <br> 
     * [lane cd 유무]을 [조회 Retrieve]합니다.<br>
     *
     * @param  MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return  List<MdmVslSvcLaneVO>
     * @throws EventException
     * @author jang chang su
     */
    public List<MdmVslSvcLaneVO> searchLaneCdYn (MdmVslSvcLaneVO mdmVslSvcLaneVO)
            throws EventException {
        try {
            return dbDao.searchLaneCdYn(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lane Cd", "Validation Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lane Cd", "Validation Check"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0054 <br> 
     * [ TDR Creation Inquiry]을 [조회 Retrieve]합니다.<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return List<TdrByLaneVO>
     * @throws EventException
     * @author jang chang su
     */
    public List<TdrByLaneVO> searchTDRCreateListByLane (String fromDt, String toDt, String lane)
            throws EventException {
        try {
            return dbDao.searchTDRCreateListByLane(fromDt, toDt, lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"TDR Creation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"TDR Creation", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * FNS_JOO_0054 <br> 
     * [ RDR Upload Inquiry]을 [조회 Retrieve]합니다.<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return List<RdrByLaneVO>
     * @throws EventException
     * @author jang chang su
     */
    public List<RdrByLaneVO> searchRDRCreateListByLane (String fromDt, String toDt, String lane)
            throws EventException {
        try {
            return dbDao.searchRDRCreateListByLane(fromDt, toDt, lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"RDR Creation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"RDR Creation", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * Combined 작업시 Settlement의 cmb_cfm_flg를 update한다. 
     * @param CombinedVO[] combinedVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for(int i=0; i<combinedVOs.length; i++){
				combinedVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
				combinedVOs[i].setCmbCfmFlg("Y");
				dbDao.modifySettlementSetCmbCfmFlg(combinedVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Updating Combined Confirm Flag"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Updating Combined Confirm Flag"}).getMessage(), ex);
		}
	}
	
	/**
	 * Combined 된 Settlement 정보를 취소한다.
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for(int i=0; i<combinedVOs.length; i++){
				combinedVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
				combinedVOs[i].setCmbCfmFlg("N");
				dbDao.modifySettlementSetCmbCfmFlg(combinedVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Cancel"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Cancel"}).getMessage(), ex);
		}
	}
	
	/**
	 * Reverse 전표생성시 JOO_SETTLEMENT의 CMB_CFM_FLG를 N으로 UPDATE함으로써 다시 COMBINED되도록 한다.
	 * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void createReverseSlip(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			Iterator iterator = jooStlCmbDtlVOs.iterator();
			CombinedVO combinedVO = new CombinedVO();
			while(iterator.hasNext()){
				JooStlCmbDtlVO jooStlCmbDtlVO = (JooStlCmbDtlVO)iterator.next();
				combinedVO.setAcctYrmon(jooStlCmbDtlVO.getAcctYrmon());
				combinedVO.setStlVvdSeq(jooStlCmbDtlVO.getStlVvdSeq());
				combinedVO.setStlSeq   (jooStlCmbDtlVO.getStlSeq   ());
				combinedVO.setUpdUsrId (signOnUserAccount.getUsr_id());
				combinedVO.setCmbCfmFlg("N");
				dbDao.modifySettlementSetCmbCfmFlgCxl(combinedVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Update CMB_CFM_FLG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Update CMB_CFM_FLG"}).getMessage(), ex);
		}
	}
    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 을  조회 Retrieve합니다.<br>
     * 
     * @param  RdrLoadVO rdrLoadVO
     * @return List<RdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<RdrLoadVO> searchRDRDownloadListByLane(RdrLoadVO rdrLoadVO) throws EventException{
        try {
            return dbDao.searchRDRDownloadListByLane( rdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 데이터중 JOO_RDR_VVD_CRR_RMK에 해당하는 값을 저장합니다.<br>
     * 
	 * @param  RdrLoadVO[] rdrLoadVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRVVDCrrRmk(RdrLoadVO[] rdrLoadVOs, SignOnUserAccount account) throws EventException{
		try {
			for (int i=0; i<rdrLoadVOs.length; i++) {
				rdrLoadVOs[i].setUsrId(account.getUsr_id());
				if (!dbDao.checkedRDRVVDCrrRmk(rdrLoadVOs[i]) ){
				    dbDao.addManageRDRVVDCrrRmk(rdrLoadVOs[i]);
				}else{
					dbDao.modifyManageRDRVVDCrrRmk(rdrLoadVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

    /**
     * Settlement의 Other-Other의 VVD 입력시 조회
     * @param ProcSettlementVO procSettlementVO
     * @return String
     * @throws EventException
     */
	public String searchStlVvdOth(ProcSettlementVO procSettlementVO) throws EventException {
		String rtnVal = "";
		try {
			//AR_MST_REV_VVD 테이블을 조회한다.
			List<EstmActRsltVO> list = dbDao.searchStlVvdOth(procSettlementVO);
			
			if (list.isEmpty()){
				rtnVal = "E";
			}else{
				String revYrmon = list.get(0).getRevYrmon(); 
				//FNS_JOO_0053 화면 POP-UP해야함
				if (revYrmon == null || "".equals(revYrmon) || "null".equals(revYrmon)){
					rtnVal = "P";
				}else{
					rtnVal = "N";
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "VVD Validation Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "VVD Validation Check"}).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * Settlement Oth-Oth인 경우 입력한 VVD가 취소됐을 때 FNS_JOO_0053 화면을 열어 해당 VVD로 SLIP된 data를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ManualStlVvdVO>
	 * @throws EventException
	 */
	public List<ManualStlVvdVO> searchVVDOfNotExistRevMonList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchVVDOfNotExistRevMonList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "History of Slip Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "History of Slip Retrieve"}).getMessage(), ex);
		}
	}    
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrLoadVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO)
            throws EventException {
        try {
            return dbDao.searchTDRDownloadListByLane( tdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }

    /**
     * OUS RDR Adjustment 조회
     * @param AdjustConditionVO adjustConditionVO
     * @return List<AdjustOusRDRVO>
     * @throws EventException
     */
	public List<AdjustOusRDRVO> searchAdjustOusListForRDR(AdjustConditionVO adjustConditionVO) throws EventException {
		try {
			return dbDao.searchAdjustOusListForRDR(adjustConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS RDR Adjustment", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS RDR Adjustment", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Settlement 단에서 Create시 대상항차에 Data 존재여부를 check해준다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return boolean
	 * @exception EventException
	 */
	private boolean doesExistStlVvdForSettlement(ProcSettlementVO procSettlementVO) throws EventException {
		boolean aBol = false;
		try {
			List<ProcSettlementVO> list = dbDao.searchStlVvdForSettlement(procSettlementVO);
			
			if (!list.isEmpty()){
				aBol = true;
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve For Settlement"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve For Settlement"}).getMessage(), ex);
		}
		return aBol;
	}

	/**
	 * Settlement 단에서 Row ADD로 VVD입력시 9자리만 입력하면 해당하는 Revenue Direction List를 대상항차에서 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRevDirList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
     * OUS RDR에서 Region 변경시 Used Slot 정보를 조회한다.
     * 조회조건 : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotInfo(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchUsedSlotInfo(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * OUS RDR의 VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보와 OUS RDR의 VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보와 1st BSA, BSA Wgt Per TEU 를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvdOusRdr(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchStlVvdOusRdr(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		}
	}

    /**
     * R/F I/O 변경시 R/F Surcharge정보를 조회한다. 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfIOChange(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRfIOChange(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F I/O Change", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F I/O Change", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
     * R/F RGN 변경시 R/F Used RF, POL, POD 정보를 조회한다. 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfRgnChange(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRfRgnChange(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F RGN Change", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F RGN Change", "Retrieve"}).getMessage(), ex);
		}
	}
    /**
     * Monthly Clearance의 StlCmbSeq List를 조회합니다.<br>
     * FNS_JOO_0015
     * @param StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author jang kang cheol
     */
     public List<SettlementVO> searchMonthlyStlCmbSeqList(StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMonthlyStlCmbSeqList(stlConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }

 	/**
 	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
 	 * 적용 ITEM : P/B, W/R, OTH
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<ProcSettlementVO> list = null;
 		try {
 			list = new ArrayList<ProcSettlementVO>();
 			
 			for (int i=0; i < procSettlementVOs.length; i++){
 				list.add(procSettlementVOs[i]);
 				
 				//삭제 먼저 처리한다.
 				if ("D".equals(procSettlementVOs[i].getIbflag())){
 					dbDao.removeSettlement(list.get(i));
 				}
 			}

 			int iRtn = 0; //Dup Check 조회 후 return 값

 			String ibFlag = "";
 			String stlDupFlg= "";	
 			int iDupCnt = 0;

 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				
 				ibFlag = list.get(i).getIbflag();
 				
 				if ("R".equals(ibFlag) || "D".equals(ibFlag))
 					continue;

 				stlDupFlg = list.get(i).getStlDupFlg();
 				
 				//P/B와 W/R는 Slip으로 Dup Check한다.
 				if ("P/B".equals(list.get(i).getJoStlItmCd()) || "W/R".equals(list.get(i).getJoStlItmCd())){
 	 				iRtn  = dbDao.searchSettlementDupChkWithSlip(list.get(i));
 	 				// DUP이 아니면 Settlement을 조회해서 Check한다.
 	 				if (iRtn == 0){
 	 	 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));
 	 				}
 	 			//Other인 경우 Settlement만 조회해서 Dup Check한다.
 				}else{
 	 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));
 				}

 				if ("U".equals(ibFlag)){
 					//DupChkFree가 Y인 경우는 Dup check를 하지 않는다.
 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}
 					//Y인 경우도 DUP CHECK해서 DUP이 아니면 N으로 바꿔준다.
 					}else{
 						if (iRtn == 0){
 							list.get(i).setStlDupFlg("N");
 						}
 					}
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
 					dbDao.modifySettlement(list.get(i));
 				}else if ("I".equals(ibFlag)){
 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}
 					}
 					list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
 					dbDao.addSettlement(list.get(i));
 				}
 			}
 			
 			if (iDupCnt > 0){
 				list.get(0).setDupFlg("E");
 			}else{
 				list.get(0).setDupFlg("N");
 			}
 		} catch (DAOException ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		}
 		
 		return list;
 	}

 	
 	/**
 	 * SettlementRFVO를 procSettlementVO로 생성한다.
 	 * @param SettlementRFVO settlementRFVO
 	 * @param ProcSettlementVO procSettlementVO
 	 * @param String flg
 	 */
 	private void setSettlementRFVO2ProcSettlementVO(SettlementRFVO settlementRFVO, ProcSettlementVO procSettlementVO, String flg){
		procSettlementVO.setIbflag        (settlementRFVO.getIbflag        ());
		procSettlementVO.setVslCd         (settlementRFVO.getVslCd         ());
		procSettlementVO.setSkdVoyNo      (settlementRFVO.getSkdVoyNo      ());
		procSettlementVO.setSkdDirCd      (settlementRFVO.getSkdDirCd      ());
		procSettlementVO.setRevDirCd      (settlementRFVO.getRevDirCd      ());
		procSettlementVO.setStlBzcPortCd  (settlementRFVO.getStlBzcPortCd  ());
		procSettlementVO.setEtaDt         (settlementRFVO.getEtaDt         ());
		procSettlementVO.setUcBssPortCd   (settlementRFVO.getUcBssPortCd   ());
		procSettlementVO.setRfScgStlTpCd  (settlementRFVO.getRfScgStlTpCd  ());
		procSettlementVO.setIocCd         (settlementRFVO.getIocCd         ());
		procSettlementVO.setScontiCd      (settlementRFVO.getScontiCd      ());
		procSettlementVO.setFmPortCd      (settlementRFVO.getFmPortCd      ());
		procSettlementVO.setToPortCd      (settlementRFVO.getToPortCd      ());
		procSettlementVO.setLoclCurrCd    (settlementRFVO.getLoclCurrCd    ());
		procSettlementVO.setAcctYrmon     (settlementRFVO.getAcctYrmon     ());
		procSettlementVO.setStlVvdSeq     (settlementRFVO.getStlVvdSeq     ());
		procSettlementVO.setTrdCd         (settlementRFVO.getTrdCd         ());
		procSettlementVO.setJoCrrCd       (settlementRFVO.getJoCrrCd       ());
		procSettlementVO.setRlaneCd       (settlementRFVO.getRlaneCd       ());
		procSettlementVO.setReDivrCd      (settlementRFVO.getReDivrCd      ());
		procSettlementVO.setJoStlItmCd    (settlementRFVO.getJoStlItmCd    ());
		procSettlementVO.setJoMnuNm       (settlementRFVO.getJoMnuNm       ());
		procSettlementVO.setUcBssPortEtdDt(settlementRFVO.getUcBssPortEtdDt());
		
 		if ("20".equals(flg)){
 			procSettlementVO.setJoStlJbCd   ("301");
			procSettlementVO.setStlSeq      (settlementRFVO.getStlSeq20      ());
			procSettlementVO.setUsdSltBsaQty(settlementRFVO.getUsdSltBsaQty20());
			procSettlementVO.setRfScgPrc    (settlementRFVO.getRfScgPrc20    ());
			procSettlementVO.setStlLoclAmt  (settlementRFVO.getStlLoclAmt20  ());
			procSettlementVO.setStlAdjFlg   (settlementRFVO.getStlAdjFlg20   ());
			procSettlementVO.setStlLstFlg   (settlementRFVO.getStlLstFlg20   ());
			procSettlementVO.setStlDupFlg   (settlementRFVO.getStlDupFlg20   ());
 		}else if ("40".equals(flg)){
 			procSettlementVO.setJoStlJbCd   ("302");
			procSettlementVO.setStlSeq      (settlementRFVO.getStlSeq40      ());
			procSettlementVO.setUsdSltBsaQty(settlementRFVO.getUsdSltBsaQty40());
			procSettlementVO.setRfScgPrc    (settlementRFVO.getRfScgPrc40    ());
			procSettlementVO.setStlLoclAmt  (settlementRFVO.getStlLoclAmt40  ());
			procSettlementVO.setStlAdjFlg   (settlementRFVO.getStlAdjFlg40   ());
			procSettlementVO.setStlLstFlg   (settlementRFVO.getStlLstFlg40   ());
			procSettlementVO.setStlDupFlg   (settlementRFVO.getStlDupFlg40   ());
 		}
 	}


 	/**
 	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
 	 * 적용 ITEM : R/F 
	 * @param SettlementRFVO[] settlementRFVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<SettlementRFVO>
 	 * @throws EventException
 	 */
	public List<SettlementRFVO> manageSettlementRF(SettlementRFVO[] settlementRFVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		List<SettlementRFVO> list = null;
		try {
			list = new ArrayList<SettlementRFVO>();
			
			ProcSettlementVO procSettlementVO20 = new ProcSettlementVO();
			ProcSettlementVO procSettlementVO40 = new ProcSettlementVO();

			for (int i=0; i < settlementRFVOs.length; i++){
				list.add(settlementRFVOs[i]);
				String flg = settlementRFVOs[i].getIbflag();
				if ("R".equals(flg))
					continue;

				//삭제부터 해야 Duplication Check를 정확히 할 수 있다
				if ("D".equals(flg)){
					this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO20, "20");
					this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO40, "40");
					dbDao.removeSettlement(procSettlementVO20);
					dbDao.removeSettlement(procSettlementVO40);
				}
			}
			
			int iRtn20 = 0; //Dup Check 조회 후 return 값
			int iRtn40 = 0; //Dup Check 조회 후 return 값

			String ibFlag = "";

			int iDupCnt = 0;

			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
			for (int i=0; i < list.size(); i++){
				
				ibFlag = list.get(i).getIbflag();
				
				if ("R".equals(ibFlag) || "D".equals(ibFlag))
					continue;

				this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO20, "20");
				this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO40, "40");

				iRtn20 = dbDao.searchSettlementDupChk(procSettlementVO20);
				iRtn40 = dbDao.searchSettlementDupChk(procSettlementVO40);
				
				if ("U".equals(ibFlag)){
					//둘다 Dup체크가 된 것은 skip 한다.
					if (iRtn20 > 0 && iRtn40 > 0){
						iDupCnt++;
						break;
					}else{
						procSettlementVO20.setUpdUsrId(signOnUserAccount.getUsr_id());
						procSettlementVO40.setUpdUsrId(signOnUserAccount.getUsr_id());
					}
					
					dbDao.modifySettlement(procSettlementVO20);
					dbDao.modifySettlement(procSettlementVO40);
				}else if ("I".equals(ibFlag)){
					if (iRtn20 > 0 && iRtn40 > 0){
						iDupCnt++;
						break;
					}else{
						procSettlementVO20.setCreUsrId(signOnUserAccount.getUsr_id());
						procSettlementVO40.setCreUsrId(signOnUserAccount.getUsr_id());
					}

					dbDao.addSettlement(procSettlementVO20);
					dbDao.addSettlement(procSettlementVO40);
				}
			}
			
			if (iDupCnt > 0){
				list.get(0).setDupFlg("E");
			}else{
				list.get(0).setDupFlg("N");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F Settlement", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F Settlement", "Save"}).getMessage(), ex);
		}
		
		return list;
	}


 	/**
 	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
 	 * 적용 ITEM : OUS(RDR, TDR), S/H
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlementSH(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<ProcSettlementVO> list = null;
 		try {
 			list = new ArrayList<ProcSettlementVO>();
 			
 			for (int i=0; i < procSettlementVOs.length; i++){
 				list.add(procSettlementVOs[i]);
 				
 				//삭제 먼저 처리한다.
 				if ("D".equals(procSettlementVOs[i].getIbflag())){
 					dbDao.removeSettlement(list.get(i));
 				}
 			}

 			int iRtn = 0; //Dup Check 조회 후 return 값

 			String ibFlag = "";
 			int iDupCnt = 0;

 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				
 				ibFlag = list.get(i).getIbflag();
 				
 				if ("R".equals(ibFlag) || "D".equals(ibFlag))
 					continue;

 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));

 				if (iRtn > 0){
					iDupCnt++;
					break;
				}

 				if ("U".equals(ibFlag)){
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
 					dbDao.modifySettlement(list.get(i));
 				}else if ("I".equals(ibFlag)){
 					list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
 					dbDao.addSettlement(list.get(i));
 				}
 			}
 			
 			if (iDupCnt > 0){
 				list.get(0).setDupFlg("E");
 			}else{
 				list.get(0).setDupFlg("N");
 			}
 		} catch (DAOException ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		}
 		
 		return list;
 	}
    /**
     * Booking Loading Port별 Discharge Port의 Qty 정보를 조회 합니다.<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoading(LoadingQtyVO loadingQtyVO ) throws EventException{
 
        try {

            return dbDao.searchDischageForLoading(loadingQtyVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * 
     * Booking Loading Port별 Discharge Port의 Qty 의 비고정된 헤더정보를  조회 합니다<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoadingHeader(LoadingQtyVO loadingQtyVO) throws EventException{
 
        try {
            
            return dbDao.searchDischageForLoadingHeader(loadingQtyVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * Reverse전표 생성시 Settlement를 Copy한다.
     * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void createReverseSettlement(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for (int i=0; i<jooStlCmbDtlVOs.size(); i++){
				jooStlCmbDtlVOs.get(i).setUpdUsrId (signOnUserAccount.getUsr_id());
				//새로운 max(stl_seq)+1 (기존과 구별하기 위해 stl_cmb_seq에 넣는다.
				String stlCmbSeq = dbDao.searchNextStlSeq(jooStlCmbDtlVOs.get(i));
				jooStlCmbDtlVOs.get(i).setStlCmbSeq(stlCmbSeq);
				
				//settlement copy
				dbDao.addSettlement(jooStlCmbDtlVOs.get(i));
				//joo_stl_dtl copy
				dbDao.addStlDtl(jooStlCmbDtlVOs.get(i));
				
				//joo_stl_cmb_dtl update
				dbDao.updateCmbdtl(jooStlCmbDtlVOs.get(i));
				
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Settlement Copy"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Settlement Copy"}).getMessage(), ex);
		}
	}

	/**
	 * Other Settlement 화면에서 S/H의 BSA Type 입력시 validation을 체크한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchBsaTypeValidationCheck(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchBsaTypeValidationCheck(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check BSA Type Validation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check BSA Type Validation"}).getMessage(), ex);
		}
	}
	
	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
     * Remark의 내용을 저장한다.
     * @param McsStatusVO[] mcsStatusVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageSummaryOfMcsListByCarrier(McsStatusVO[] mcsStatusVOs, SignOnUserAccount account) throws EventException{
		try {
			List<McsStatusVO> insertVoList = new ArrayList<McsStatusVO>();
			List<McsStatusVO> updateVoList = new ArrayList<McsStatusVO>();
			List<McsStatusVO> list = new ArrayList<McsStatusVO>();
			
			if(mcsStatusVOs != null && mcsStatusVOs.length > 0){
				for ( int i=0; i<mcsStatusVOs.length; i++ ) {
					if ( mcsStatusVOs[i].getIbflag().equals("U")){
						list = dbDao.chkSummaryCrrRmk(mcsStatusVOs[i]);
						mcsStatusVOs[i].setCreUsrId(account.getUsr_id());
						if(list.isEmpty()){
							insertVoList.add(mcsStatusVOs[i]);
						}else{
						updateVoList.add(mcsStatusVOs[i]);
						}
					}
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addSummaryOfMcsListByCarrier(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifySummaryOfMcsListByCarrier(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance Status by Carrier", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance Status by Carrier", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * Adjustment로 강제생성된 Target VVD를 삭제할 경우 JOO_STL_DTL과 JOO_SETTLMENT를 먼저 삭제한다.
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @return int
	 * @throws EventException
	 */
	public int removeStlDtlAndSettlement(JooStlVvdVO[] jooStlVvdVOs) throws EventException {
		int rtnVal = 0;;
		try {
			for (int i=0; i < jooStlVvdVOs.length; i++){
				dbDao.removeJooStlDtl(jooStlVvdVOs[i]);
				rtnVal = dbDao.removeSettlement(jooStlVvdVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * Unsettlement Target VVD를 수정한다. 
	 * @param StlStatusVO[] stlStatusVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageJooTgtUnstlStsRmk(StlStatusVO[] stlStatusVOs, SignOnUserAccount account) throws EventException{
		try {
			for (int inx=0; inx<stlStatusVOs.length; inx++){
				//Remark 유무 체크
				int cnt = dbDao.searchJooTgtUnstlStsRmkChk(stlStatusVOs[inx]);
				
				if ( cnt > 0 ) {
					stlStatusVOs[inx].setUsrId(account.getUsr_id());
					dbDao.modifyJooTgtUnstlStsRmk(stlStatusVOs[inx]);
				} else {
					stlStatusVOs[inx].setUsrId(account.getUsr_id());
					dbDao.addJooTgtUnstlStsRmk(stlStatusVOs[inx]);					
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Unsettlement Target VVD", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Unsettlement Target VVD", "Save"}).getMessage(), ex);
		}
	}
	

    /**
     * FNS_JOO_0087: Retrieve
     * D : [FnsJoo0087Event]<br>
     * Intergrated Loging Summary Report  조회 Retrieve 합니다.<br>
     * 
     * @param IntloadSumReportVO intloadSumReportVO
     * @return List<IntloadSumReportVO>
     * @throws EventException
     * @author Lim Youmg Oh
     */
	public List<IntloadSumReportVO> searchIntergratedloadSumReportRDRList(IntloadSumReportVO intloadSumReportVO) throws EventException{
        try {
            return dbDao.searchIntergratedloadSumReportRDRList( intloadSumReportVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }
	

	/**
	 * Intergrated Loging Summary Report를 저장한다.
	 * @param IntloadSumReportVO[] IntloadSumReportVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String 
	 * @throws EventException   
	 */
	public String addIntergratedloadSumReportRDRList(IntloadSumReportVO[] intloadSumReportVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String rtnVal = "";
		try{
			String vvdCd = "";
			String iudFlag = "";
			
			List<IntloadSumReportVO> list = new ArrayList<IntloadSumReportVO>();
            List<IntloadSumReportVO> insertVoList = new ArrayList<IntloadSumReportVO>();   
            List<IntloadSumReportVO> removeVoList = new ArrayList<IntloadSumReportVO>();
            for( int i=0;i< intloadSumReportVOs.length;i++){
            	intloadSumReportVOs[i].setCreUsrId( signOnUserAccount.getUsr_id() ); 
            	intloadSumReportVOs[i].setUsrId( signOnUserAccount.getUsr_id() );               
            	vvdCd = intloadSumReportVOs[i].getVvd();
            	iudFlag = intloadSumReportVOs[i].getIudFlag();
            	list = dbDao.searchIntergratedloadSumReportRDRList(intloadSumReportVOs[i]);
                 	
            	//VVD 값 VSL_CD=[4], SKD_VOY_NO=[4], SKD_DIR_CD=[1]
            	if (!"".equals(vvdCd)){
            		intloadSumReportVOs[i].setVslCd(vvdCd.substring(0, 4));
            		intloadSumReportVOs[i].setSkdVoyNo(vvdCd.substring(4, 8));
            		intloadSumReportVOs[i].setSkdDirCd(vvdCd.substring(8, 9));
            	}
            	
            	//기존 데이터 존재 여부에 따라 insert, update 리스트에 담기
        		if (list.isEmpty()){
        			if ("I".equals(iudFlag)) {
        				removeVoList.add(intloadSumReportVOs[i]);
            			dbDao.removeIntergratedloadSumReportRDList(removeVoList);                			
            			insertVoList.add(intloadSumReportVOs[i]);
        			}
        		}
            }
                  
            if ( insertVoList.size() > 0 ) {
				dbDao.addIntergratedloadSumReportRDList(insertVoList);
			} else {
				rtnVal = "VSL_CD"
			       + "SKD_VOY_NO"
			       + "SKD_DIR_CD";
			}
        } 
		catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Creation"}).getMessage(), ex);
        } 
        catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Creation"}).getMessage(), ex);
        }
        return rtnVal;
	}
	
    /**
     * FNS_JOO_0090: Retrieve
     * D : [FnsJoo0090Event]<br>
     * TDR Ratio by Lane 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrRatioVO tdrRatioVO
     * @return List<TdrRatioVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrRatioVO> searchTDRRatioListByLane(TdrRatioVO tdrRatioVO)
            throws EventException {
        try {
            return dbDao.searchTDRRatioListByLane( tdrRatioVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }
	
    /**
     * FNS_JOO_0090: SAVE
     * D : [FnsJoo0090Event]<br>
     * RDR Ratio by Lane 데이터중 JOO_TDR_RTO에 해당하는 값을 저장합니다.<br>
     * 
	 * @param  TdrRatioVO[] tdrRatioVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void createTDRRationByLane(TdrRatioVO[] tdrRatioVOs, SignOnUserAccount account) throws EventException {
		try {
			List<TdrRatioVO> insertVoList = new ArrayList<TdrRatioVO>();
		
			for (int i=0; i<tdrRatioVOs.length; i++) {
				tdrRatioVOs[i].setUsrId(account.getUsr_id());
				tdrRatioVOs[i].setCreUsrId(account.getUsr_id());
				insertVoList.add(tdrRatioVOs[i]);
			}
			if( insertVoList.size() > 0 ) {
				dbDao.createTDRRationByLane(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * 'Sub Allocation and Ratio'에 Rep. Carrier가 복수 선택되었거나 혹은 하나도 선택되지를 조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author Kim Young Oh
     */
    public List<TdrLoadVO> searchTDRRatioCountByLane(TdrLoadVO tdrLoadVO)
            throws EventException {
        try {
            return dbDao.searchTDRRatioCountByLane( tdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }
    
	/**
	 * 스케줄상의 Port를 조회한다.
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<SkdPortVO>
	 * @throws EventException
	 */
	public List<SkdPortVO> searchSkdPortList(KorCllCdlCondVO korCllCdlCondVO) throws EventException {
		try {
			return dbDao.searchSkdPortList(korCllCdlCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Schedule Port", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Schedule Por", "Retrieve"}).getMessage(), ex);

		}
	}
	
	/**
	 * ROB 컨테이너 목록을 조회한다.
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @param String gubun
	 * @return List<KorCllCdlDetailVO>
	 * @throws EventException
	 */
	public List<KorCllCdlDetailVO> searchRobList(KorCllCdlCondVO korCllCdlCondVO, String gubun) throws EventException {				
		List<KorCllCdlDetailVO> korCllCdlDetailVOs = null;
		try{						
			korCllCdlCondVO.setInCntrMatch("Y");		// CNTR#Non Match Y 기본 세팅		
			korCllCdlCondVO.setInListType("L");		// List Type : Loading   L 기본 세팅
			
			if(korCllCdlCondVO.getInCntrMatch().equals("Y"))
			{
				korCllCdlDetailVOs = dbDao.searchRobList(korCllCdlCondVO, gubun);
				
	            for(int i = 0; i < korCllCdlDetailVOs.size(); i++){
					KorCllCdlDetailVO korCllCdlDetailVO = korCllCdlDetailVOs.get(i);

					String spclCgoDescType = "";
					String spclCgoDesc = "";
					String spclCgoDesc1 = "";
					String spclCgoDesc2 = "";
					String spclCgoDesc3 = "";
					String spclCgoDesc4 = "";
					String spclCgoDesc5 = "";
					String spclCgoDesc6 = "";
					int totalCount = 0;
					StringBuffer sb = new StringBuffer();
					korCllCdlCondVO.setInCntrNo(korCllCdlDetailVO.getCntrNo().replace("(D)", ""));
					korCllCdlCondVO.setInBkgNo(korCllCdlDetailVO.getBkgNo());

					if(korCllCdlDetailVO.getDcgoFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("D");
						spclCgoDescType = "D";
						spclCgoDesc1 = cLLCDLManifestDBDAO.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					if(korCllCdlDetailVO.getRcFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("R");
						spclCgoDescType = "R";
						spclCgoDesc2 = cLLCDLManifestDBDAO.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					if(korCllCdlDetailVO.getAwkCgoFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("A");
						spclCgoDescType = "A";
						spclCgoDesc3 = cLLCDLManifestDBDAO.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					if(korCllCdlDetailVO.getPrctFlg().equals("Y")){
						spclCgoDescType = "P";

						spclCgoDesc4 = "Precaution cargo";
						totalCount++;
					}
					if(korCllCdlDetailVO.getRdCgoFlg().equals("Y")){
						spclCgoDescType = "RD";

						spclCgoDesc5 = "Reefer Dry";
						totalCount++;
					}
					if(korCllCdlDetailVO.getHngrFlg().equals("Y")){
						spclCgoDescType = "GOH";

						spclCgoDesc6 = "Hanger";
						totalCount++;
					}
					if(totalCount > 1){
						spclCgoDescType = "M";
						if(!spclCgoDesc1.equals(""))
							sb.append(spclCgoDesc1).append(" / ");
						if(!spclCgoDesc2.equals(""))
							sb.append(spclCgoDesc2).append(" / ");
						if(!spclCgoDesc3.equals(""))
							sb.append(spclCgoDesc3).append(" / ");
						if(!spclCgoDesc4.equals(""))
							sb.append(spclCgoDesc4).append(" / ");
						if(!spclCgoDesc5.equals(""))
							sb.append(spclCgoDesc5).append(" / ");
						if(!spclCgoDesc6.equals(""))
							sb.append(spclCgoDesc6).append(" / ");
						spclCgoDesc = sb.toString();
						spclCgoDesc = spclCgoDesc.substring(0, sb.toString().length() - 3);
					}else{
						if(!spclCgoDesc1.equals(""))
							spclCgoDesc = spclCgoDesc1;
						if(!spclCgoDesc2.equals(""))
							spclCgoDesc = spclCgoDesc2;
						if(!spclCgoDesc3.equals(""))
							spclCgoDesc = spclCgoDesc3;
						if(!spclCgoDesc4.equals(""))
							spclCgoDesc = spclCgoDesc4;
						if(!spclCgoDesc5.equals(""))
							spclCgoDesc = spclCgoDesc5;
						if(!spclCgoDesc6.equals(""))
							spclCgoDesc = spclCgoDesc6;
					}
					korCllCdlDetailVOs.get(i).setSpclCgoDescType(spclCgoDescType);
					korCllCdlDetailVOs.get(i).setSpclCgoDesc(spclCgoDesc);
				}				
			}
	        return korCllCdlDetailVOs;												
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container List", "Retrieve"}).getMessage(), ex);

		}
	}
	
	/**
	 * ROB 컨테이너 Summary을 조회한다.
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @param String gubun
	 * @return List<TdrLoadVO>
	 * @throws EventException
	 */
	public List<TdrLoadVO> searchRobTotal(KorCllCdlCondVO korCllCdlCondVO, String gubun) throws EventException {
		try {
			return dbDao.searchRobTotal(korCllCdlCondVO, gubun);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary", "Retrieve"}).getMessage(), ex);

		}
	}    
	
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 조회합니다.<br>
     * 
     * @param TdrRatioVO tdrRatioVO
     * @return List<TdrRatioVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrRatioVO> searchROBRatioListByLane(TdrRatioVO tdrRatioVO) throws EventException {
        try {
            return dbDao.searchROBRatioListByLane( tdrRatioVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }
	
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 저장합니다.<br>
     * 
	 * @param  TdrRatioVO[] tdrRatioVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageROBRationByLane(TdrRatioVO[] tdrRatioVOs, SignOnUserAccount account) throws EventException {
		try {
			List<TdrRatioVO> insertVoList = new ArrayList<TdrRatioVO>();
			List<TdrRatioVO> updateVoList = new ArrayList<TdrRatioVO>();			
			List<TdrRatioVO> deleteVoList = new ArrayList<TdrRatioVO>();
			
			for (int i=0; i<tdrRatioVOs.length; i++) {				
				if ("I".equals(tdrRatioVOs[i].getIbflag())){
					tdrRatioVOs[i].setUsrId(account.getUsr_id());
					tdrRatioVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(tdrRatioVOs[i]);					
				}else if("U".equals(tdrRatioVOs[i].getIbflag())) {
					tdrRatioVOs[i].setUsrId(account.getUsr_id());
					tdrRatioVOs[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(tdrRatioVOs[i]);					
				}else if ("D".equals(tdrRatioVOs[i].getIbflag())) {
					deleteVoList.add(tdrRatioVOs[i]);					
				}				
			}
			
			if( insertVoList.size() > 0 ) {
				dbDao.createROBRationByLane(insertVoList);
			}

			if( updateVoList.size() > 0 ) {				
				dbDao.updateROBRationByLane(updateVoList);
			}
			
			if( deleteVoList.size() > 0 ) {
				dbDao.deleteROBRationByLane(deleteVoList);
			}

			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}	
	
	
    /**
     * Lane이  적합한지 조회합니다.<br>
     * 
     * @param TdrRatioVO[] tdrRatioVOs
     * @return String
     * @throws EventException
     * @author jang kang cheol
     */
    public String searchLaneChk(TdrRatioVO[] tdrRatioVOs) throws EventException {
        try {        	
        	String rtn = "N";
        	
			for (int i=0; i<tdrRatioVOs.length; i++) {				
				if ("D".equals(tdrRatioVOs[i].getIbflag())) {
					rtn = "Y";
				}				
			}        	
        	
        	if("Y".equals(rtn)){
        		return rtn;
        	}else{
        		return dbDao.searchLaneChk(tdrRatioVOs);
        	}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }	
    	
    /**
     * FNS_JOO_0103: Retrieve
     * ROB 컨테이너 Summary List를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return String
     * @throws EventException 
     */
    public String searchRobSummaryList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException {
        try {
        	CarrierSettlementProcessBackEndJob backEndResult = new CarrierSettlementProcessBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("RETRIEVE");
    		backEndResult.setGubun(gubun);
    		backEndResult.setTdrLoadVO(tdrLoadVO);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "ROB Container Summary List");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", "Retrieve"}).getMessage(), ex);
        }
    }    			
    
    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchRobSummaryEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", "Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", "Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", "Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", "Search BackendJob Status"}).getMessage(), ex);
		}
	}
	
    /**
     * Vessle ETD Schedule  리스트 조회합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrLoadVO> searchVslSkdEtd(TdrLoadVO tdrLoadVO) throws EventException {
        try {
            return dbDao.searchRobVvdList(tdrLoadVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }	
    
    /**
     * RDR Port 저장한다.<br>
     * 
	 * @param  TdrLoadVO[] tdrLoadVOs
	 * @param  String rlaneCd
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRPort(TdrLoadVO[] tdrLoadVOs, String rlaneCd, SignOnUserAccount account) throws EventException {
		try {
			List<TdrLoadVO> updateVoList = new ArrayList<TdrLoadVO>();			
			
			for (int i=0; i<tdrLoadVOs.length; i++) {				
				if("U".equals(tdrLoadVOs[i].getIbflag())) {
					tdrLoadVOs[i].setUsrId(account.getUsr_id());
					tdrLoadVOs[i].setRlaneCd(rlaneCd);
					updateVoList.add(tdrLoadVOs[i]);
				}
			}
			
			if( updateVoList.size() > 0 ) {				
				dbDao.updateRDRPort(updateVoList);
			}
						
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}	        
}