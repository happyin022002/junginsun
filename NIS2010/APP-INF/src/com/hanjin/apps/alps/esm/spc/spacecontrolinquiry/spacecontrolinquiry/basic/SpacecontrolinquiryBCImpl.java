/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpacecontrolinquiryBCImpl.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
* 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 메소드 추가
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발 - 메소드 추가
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
* 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
* 2011.11.22 김종준 [CHM-201007116] Weekly L/F by POL/POD 화면 - 기능추가 개발
* 2011.12.08 김종준 [ITM-201003937] searchMonthWeekList VVD에 해당하는 주차 1개만 나오게 추가 
* 2011.12.29 김종준 [CHM-201007719-01] Loading by POL/POD 화면 -POL/POD별 조회 기능추가  - EsmSpc0083ViewAdapter에서 polpod_flg 값 사용을 위한 ConditionVO 세팅
* 2011.06.01 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능  createSendMail 추가
* 2011.10.12 김종준 [CHM-201113896-01] Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청
* 2012.02.16 김성훈 [CHM-201216142-01] 사용자별 Lane 정보 관리/조회시 Lane 항목 추가
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
* 2015.11.10 이혜민 [CHM-201538774] NON SMP account FCST 의 Daily FCST 보완 요청
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
* 2016.05.27 이혜민 SELSC, TYOSC RHQ 독립분리
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration.SpacecontrolinquiryDBDAO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationLaneListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationPortListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewList5BySRepVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021PfmcRatioVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058QtyListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058VVDInfoVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry058VVDListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryRDRDetailListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceUtilizationListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchTsPlanGuideListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SpaceControlInquiryVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBsaMgmtVO;
import com.hanjin.syscommon.common.table.SpcTeamQtaRtoVO;
import com.hanjin.syscommon.common.table.SpcTgtVvdVO;


/**
 * ALPS-Spacecontrolinquiry Business Logic Basic Command implementation<br>
 * - ALPS-Spacecontrolinquiry에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0021EventResponse,SpacecontrolinquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpacecontrolinquiryBCImpl extends BasicCommandSupport implements SpacecontrolinquiryBC {

	// Database Access Object
	private transient SpacecontrolinquiryDBDAO dbDao = null;

	/**
	 * SpacecontrolinquiryBCImpl 객체 생성<br>
	 * SpacecontrolinquiryDBDAO를 생성한다.<br>
	 */
	public SpacecontrolinquiryBCImpl() {
		dbDao = new SpacecontrolinquiryDBDAO();
	}
		 
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021FcastPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021FcastPortViewListVO> inquiry021FcastPortViewListVO = dbDao.searchSpaceControlInquiry021FcastPortViewList(searchSpaceControlInquiryConditionVO, isSHA, isSEL, isTYO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setInquiry021FcastPortViewListVO(inquiry021FcastPortViewListVO);
			com.setEtc(etc);
			com.setCondition(searchSpaceControlInquiryConditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			DBRowSet rs = dbDao.searchSpaceControlInquiry021AllocPortViewList2(searchSpaceControlInquiryConditionVO, account, ui_name, isSHA, isSEL, isTYO);
//			DBRowSet rstitle = dbDao.searchETC2(searchSpaceControlInquiryConditionVO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
//			com.setRstitle(rstitle);
			com.setEtc(etc);
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0021내 Allocation Status RHQ]을 [조회] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList3(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021AllocPortViewList3(searchSpaceControlInquiryConditionVO, account, ui_name, isSHA, isSEL, isTYO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setEtc(etc);
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021PfmcRatio(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021PfmcRatioVO> inquiry021PfmcRatioVO = dbDao.searchSpaceControlInquiry021PfmcRatio(searchSpaceControlInquiryConditionVO, account, ui_name, isSHA, isSEL, isTYO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiry021PfmcRatioVOs(inquiry021PfmcRatioVO);
			com.setEtc(etc);
			com.setCondition(searchSpaceControlInquiryConditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0021내 Allocation Status HO]을 [조회] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021AllocPortViewList(searchSpaceControlInquiryConditionVO, account, ui_name, isSHA, isSEL, isTYO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setEtc(etc);
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0021 - SPC_USR_LANE_INFO]을 [조회] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<SearchSpaceControlInquiry021SusrLaneViewListVO> searchSpaceControlInquiry021SusrLaneViewList(SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			search021SusrLaneViewListVO.setUsrId(account.getUsr_id());
			// 조회한다.
			List<SearchSpaceControlInquiry021SusrLaneViewListVO> inquiry021SusrLaneViewListVO =  dbDao.searchSpaceControlInquiry021SusrLaneViewList(search021SusrLaneViewListVO, account, ui_name);
			return inquiry021SusrLaneViewListVO;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_SPC_0021-SPC_USR_LANE_INFO]을 [삭제후저장] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @exception EventException
	 */
	public void searchSpaceControlInquiry021SusrLaneUpdate(SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String localUsrId = account.getUsr_id();
			search021SusrLaneViewListVO.setUsrId(localUsrId);
			String localTrdCd = search021SusrLaneViewListVO.getTrdCd();
			String localSubTrdCd = search021SusrLaneViewListVO.getSubTrdCd();
			String localRlaneCd = search021SusrLaneViewListVO.getRlaneCd();
			int localIbflag = Integer.parseInt(search021SusrLaneViewListVO.getIbflag());
			String dirCd = search021SusrLaneViewListVO.getDirCd();
			String[] arrTrdCd1 = null;
			arrTrdCd1 = localTrdCd.split(",");
			String[] arrSubTrdCd1 = null;
			arrSubTrdCd1 = localSubTrdCd.split(",");
			String[] arrRlaneCd1 = null;
			arrRlaneCd1 = localRlaneCd.split(",");
			for(int iB=0;iB<localIbflag;iB++){
				// 2.저장한다.
				if(!arrTrdCd1[iB].equals("")&&!arrSubTrdCd1[iB].equals("")&&!arrRlaneCd1[iB].equals("")){
					// 초기화 .
					search021SusrLaneViewListVO.setUsrId("");		search021SusrLaneViewListVO.setTrdCd("");
					search021SusrLaneViewListVO.setSubTrdCd("");	search021SusrLaneViewListVO.setRlaneCd("");
					search021SusrLaneViewListVO.setCreUsrId("");	search021SusrLaneViewListVO.setCreDt("");
					search021SusrLaneViewListVO.setUpdUsrId("");	search021SusrLaneViewListVO.setUpdDt("");
					
					search021SusrLaneViewListVO.setUsrId(localUsrId);
					search021SusrLaneViewListVO.setTrdCd(arrTrdCd1[iB]);
					search021SusrLaneViewListVO.setSubTrdCd(arrSubTrdCd1[iB]);
					search021SusrLaneViewListVO.setDirCd(dirCd);
					
					if ( localUsrId != null && !"".equals(localUsrId) ) {
						dbDao.searchSpaceControlInquiry021SusrLaneDelete(search021SusrLaneViewListVO, account, ui_name);
					}
				}
			}
			////////////////////////////////////////////////////////////
			// INSERT INTO
			////////////////////////////////////////////////////////////
			int seq = 0;
			
			for(int iB=0;iB<localIbflag;iB++){
				// 2.저장한다.
//				String localUsrLaneSeq = "";
				if(!arrTrdCd1[iB].equals("")&&!arrSubTrdCd1[iB].equals("")&&!arrRlaneCd1[iB].equals("")){
					// 초기화 .
					search021SusrLaneViewListVO.setUsrId("");		search021SusrLaneViewListVO.setTrdCd("");
					search021SusrLaneViewListVO.setSubTrdCd("");	search021SusrLaneViewListVO.setRlaneCd("");
					search021SusrLaneViewListVO.setCreUsrId("");	search021SusrLaneViewListVO.setCreDt("");
					search021SusrLaneViewListVO.setUpdUsrId("");	search021SusrLaneViewListVO.setUpdDt("");
					
					search021SusrLaneViewListVO.setUsrId(localUsrId);
					search021SusrLaneViewListVO.setTrdCd(arrTrdCd1[iB]);
					search021SusrLaneViewListVO.setSubTrdCd(arrSubTrdCd1[iB]);
					search021SusrLaneViewListVO.setRlaneCd(arrRlaneCd1[iB]);		
//					localUsrLaneSeq = Integer.toString(iB+1);
					
					if(iB != 0 && !arrSubTrdCd1[iB].equals(arrSubTrdCd1[iB-1])){
						seq = 1;
					}else{
						seq = seq + 1;
					}
					search021SusrLaneViewListVO.setUsrLaneSeq(Integer.toString(seq));
//					search021SusrLaneViewListVO.setCreUsrId(cre_usr_id);
//					search021SusrLaneViewListVO.setCreDt(cre_dt);					
//					search021SusrLaneViewListVO.setUpdUsrId(upd_usr_id);
//					search021SusrLaneViewListVO.setUpdDt(upd_dt);
					
					dbDao.searchSpaceControlInquiry021SusrLaneCreate(search021SusrLaneViewListVO, account, ui_name);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeListVO =  dbDao.searchSpaceControlInquiryTradeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryTradeListVO(searchSpaceControlInquiryTradeListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquirySalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			//성수기용 ALLOC 대상인지 여부를 체크합니다.
			ConditionVO conditionVO = new ConditionVO();
			conditionVO.setRlaneCd(searchSpaceControlInquiryConditionVO.getLane());
			conditionVO.setDirCd(searchSpaceControlInquiryConditionVO.getBound());
			conditionVO.setVslCd(searchSpaceControlInquiryConditionVO.getVvd().substring(0, 4));//hjla0108e
			conditionVO.setSkdVoyNo(searchSpaceControlInquiryConditionVO.getVvd().substring(4, 8));//hjla0108e
			conditionVO.setSkdDirCd(searchSpaceControlInquiryConditionVO.getVvd().substring(8));//hjla0108e
			String ctrlFlg = dbDao.checkControlOptionFlg(conditionVO);
			
			List<SearchSpaceControlInquirySalesOrgListVO> list = new ArrayList<SearchSpaceControlInquirySalesOrgListVO>();
			if("N".equals(ctrlFlg)){
				list =  dbDao.searchSpaceControlInquirySalesOrgList(searchSpaceControlInquiryConditionVO);
			}else{
				list =  dbDao.searchSpaceControlInquirySalesOrgSMPList(searchSpaceControlInquiryConditionVO);
			}
			if(list.size() > 0 ) list.get(0).setCtrlFlg(ctrlFlg);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquirySalesOrgListVO(list);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryPolPodList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodListVO =  dbDao.searchSpaceControlInquiryPolPodList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryPolPodListVO(searchSpaceControlInquiryPolPodListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerListVO =  dbDao.searchSpaceControlInquiryCustomerList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryCustomerListVO(searchSpaceControlInquiryCustomerListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryContractor(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractorVO =  dbDao.searchSpaceControlInquiryContractor(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryContractorVO(searchSpaceControlInquiryContractorVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSummaryList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rsNoShowSumList = dbDao.searchSpaceControlInquiryNoShowSummaryList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRsNoShowSumList(rsNoShowSumList);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowTradeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowOfficeLaneList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowOfficeLaneList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);								
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowLaneOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowLaneOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSubOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			DBRowSet rs = dbDao.searchSpaceControlInquiryNoShowSubOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setRs(rs);
			com.setCondition(searchSpaceControlInquiryConditionVO);							
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0028]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeListVO =  dbDao.searchSpaceControlInquiryOfficeList(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryOfficeListVO(searchSpaceControlInquiryOfficeListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0028]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeSalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			String vvd = searchSpaceControlInquiryConditionVO.getVvd();
			if(vvd.length() == 9){
				searchSpaceControlInquiryConditionVO.setVslCd(vvd.substring(0, 4));
				searchSpaceControlInquiryConditionVO.setSkdVoyNo(vvd.substring(4, 8));
				searchSpaceControlInquiryConditionVO.setSkdDirCd(vvd.substring(8));
			}
			
			//성수기용 ALLOC 대상인지 여부를 체크합니다.
			ConditionVO conditionVO = new ConditionVO();
			conditionVO.setRlaneCd(searchSpaceControlInquiryConditionVO.getLane());
			conditionVO.setDirCd(searchSpaceControlInquiryConditionVO.getBound());
			conditionVO.setVslCd(searchSpaceControlInquiryConditionVO.getVvd().substring(0, 4));//hjla0108e
			conditionVO.setSkdVoyNo(searchSpaceControlInquiryConditionVO.getVvd().substring(4, 8));//hjla0108e
			conditionVO.setSkdDirCd(searchSpaceControlInquiryConditionVO.getVvd().substring(8));//hjla0108e
			String ctrlFlg = dbDao.checkControlOptionFlg(conditionVO);
			
			List<SearchSpaceControlInquiryOfficeSalesOrgListVO> list = new ArrayList<SearchSpaceControlInquiryOfficeSalesOrgListVO>();
			if("N".equals(ctrlFlg)){
				list = dbDao.searchSpaceControlInquiryOfficeSalesOrgList(searchSpaceControlInquiryConditionVO);
			}else{
				//성수기용 조회쿼리
				list = dbDao.searchSpaceControlInquiryOfficeSalesOrgSMPList(searchSpaceControlInquiryConditionVO);
			}
			list.get(0).setCtrlFlg(ctrlFlg);
			List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagListVO = dbDao.searchSpaceAllocationControlFlagList(searchSpaceControlInquiryConditionVO);
				searchSpaceControlInquiryConditionVO.setPolPod("C");
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerListVO = dbDao.searchSpaceControlInquiryOfficeCustomerList(searchSpaceControlInquiryConditionVO);
				searchSpaceControlInquiryConditionVO.setPolPod("S");
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList2VO = dbDao.searchSpaceControlInquiryOfficeCustomerList(searchSpaceControlInquiryConditionVO);
						
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceAllocationControlFlagListVO(searchSpaceAllocationControlFlagListVO);
			com.setSearchSpaceControlInquiryOfficeSalesOrgListVO(list);
			com.setSearchSpaceControlInquiryOfficeCustomerListVO(searchSpaceControlInquiryOfficeCustomerListVO);
			com.setSearchSpaceControlInquiryOfficeCustomerList2VO(searchSpaceControlInquiryOfficeCustomerList2VO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0056]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlTsVolumnList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnListVO = dbDao.searchSpaceControlTsVolumnList(searchSpaceControlInquiryConditionVO);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlTsVolumnListVO(searchSpaceControlTsVolumnListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [ESM_SPC_0026]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public  List<ComplexMainVO> searchSpaceControlInquiryList( ConditionVO conditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryListVO = dbDao.searchSpaceControlInquiryList( conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryListVO(searchSpaceControlInquiryListVO);
			//com.setCondition(conditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [ESM_SPC_0080]을 [행 위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 메소드 추가
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryList(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVO = dbDao.searchSpaceControlRDRSummaryList(conditionVO);
			List<ETCVO> etc = dbDao.searchETC(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlRDRSummaryListVO(searchSpaceControlRDRSummaryListVO);
			com.setEtc(etc);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0080]을 [행 위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryDown(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVO = dbDao.searchSpaceControlRDRSummaryDown(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlRDRSummaryDownVO(searchSpaceControlRDRSummaryDownVO);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/*=====================================================================================
	 * 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 조회 메소드 추가
	 *=====================================================================================*/	
	/**
	 * [ESM_SPC_0081]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public  List<ComplexMainVO> searchSpaceControlInquiryRDRDetailList( ConditionVO conditionVO) throws EventException {
		try {
			
			List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailListVO = dbDao.searchSpaceControlInquiryRDRDetailList(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiryRDRDetailListVO(searchSpaceControlInquiryRDRDetailListVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [ESM_SPC_0082]을 [행 위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryList(ConditionVO conditionVO) throws EventException {
		try {
			
		
			List<ETCVO> etc = dbDao.searchETC(conditionVO);
			
			// REV month 선택에 의한 조건 변경			
			conditionVO.setDuration(Integer.toString(etc.size()));
			conditionVO.setYear(etc.get(0).getCostYr());
			conditionVO.setWeek(etc.get(0).getCostWk1());
			
			List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVO = dbDao.searchSpaceControlLFSummaryList(conditionVO);


			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlLFSummaryListVO(searchSpaceControlLFSummaryListVO);
			com.setEtc(etc);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0082]을 [행 위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryDown(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVO = dbDao.searchSpaceControlLFSummaryDown(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlLFSummaryDownVO(searchSpaceControlLFSummaryDownVO);
			com.setConditionVO(conditionVO);
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
						
			return listCom;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0083]을 Weekly L/F by POL/POD 리스트를 조회 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public  List<ComplexMainVO> searchWeeklyLfByPolPodList( ConditionVO conditionVO) throws EventException {
		try {
			String costWk=  conditionVO.getWeek();
			if ( !conditionVO.getVvd().trim().equals("")) {
				costWk= dbDao.searchVvdCostYrwk(conditionVO);	//vvd에 해당하는 년과 주차를 가져온다.
				if ( !costWk.equals("" )) {
					conditionVO.setYear(costWk.substring(0,4));
					conditionVO.setWeek(costWk.substring(4,6));
					conditionVO.setDuration("1");
				}
			}
			
			List<SearchWeeklyLfByPolPodListVO> searchLoadingByPolPodListVO = dbDao.searchWeeklyLfByPolPodList(conditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchWeeklyLfByPolPodListVO(searchLoadingByPolPodListVO);
			com.setConditionVO(conditionVO);	//EsmSpc0083ViewAdapter에서 polpod_flg 값 사용을 위한 세팅 
			
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();
			listCom.add(com);
			
			return listCom;			
						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * [ESM_SPC_0083]의 주어진 기간의 주차,년월 목록을 조회<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLoadingByPolPodListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyLfByPolPodListVO> searchMonthWeekList(ConditionVO conditionVO) throws EventException {
		List<SearchWeeklyLfByPolPodListVO> list = null;
		String base_dt = "";
		try {
			if ( !conditionVO.getVvd().equals("")) {	//vvd값이 있을시 vvd의 해당 1주차를 찾는다.
				list = new ArrayList<SearchWeeklyLfByPolPodListVO>();
				base_dt = dbDao.searchVvdCostYrwk(conditionVO);
				SearchWeeklyLfByPolPodListVO searchWeeklyLfByPolPodListVO = new SearchWeeklyLfByPolPodListVO();
				if ( !base_dt.equals("")) {
					searchWeeklyLfByPolPodListVO.setCostYrwk(base_dt);
				} else {
					searchWeeklyLfByPolPodListVO.setCostYrwk(conditionVO.getYear()+conditionVO.getWeek());
				}
				list.add(0, searchWeeklyLfByPolPodListVO);
			} else {	//VVD값이 조회조건에 없을시 Duration 검색
				list = dbDao.searchMonthWeekList(conditionVO);
			}
			return list;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * [ESM_SPC_0084]을 BSA INPUT DATA 리스트를 조회 합니다.<br>
	 * @param SpcBsaMgmtVO spcBsaMgmtVO
	 * @return List<SpcBsaMgmtVO>
	 * @exception EventException
	 */
	public  List<SpcBsaMgmtVO> searchSpaceContorlInquiryBSA( SpcBsaMgmtVO spcBsaMgmtVO) throws EventException {
		try {
			return dbDao.searchSpaceContorlInquiryBSA(spcBsaMgmtVO);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
    /**
     * BSA INPUT DATA를 저장 합니다.<br> 
     * @param  SpcBsaMgmtVO[] spcBsaMgmtVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void multiSpaceContorlInquiryBSA(SpcBsaMgmtVO[] spcBsaMgmtVOs,SignOnUserAccount signOnUserAccount) throws EventException {

		StringBuilder rtnVal = new StringBuilder();
		rtnVal.append("");
        try{
    			List<SpcBsaMgmtVO> insertVoList = new ArrayList<SpcBsaMgmtVO>();
    			List<SpcBsaMgmtVO> updateVoList = new ArrayList<SpcBsaMgmtVO>();
    			List<SpcBsaMgmtVO> deleteVoList = new ArrayList<SpcBsaMgmtVO>();
    			
    			String ibflag = "";

    			for (int inx=0; inx < spcBsaMgmtVOs.length; inx++){
    				ibflag = spcBsaMgmtVOs[inx].getIbflag();
    				if ("I".equals(ibflag)){
    					spcBsaMgmtVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
    					spcBsaMgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());

    					insertVoList.add(spcBsaMgmtVOs[inx]);
    				}else if("U".equals(ibflag)){
    					spcBsaMgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
	    					updateVoList.add(spcBsaMgmtVOs[inx]);
    				}
	    			else if("D".equals(ibflag)){
	    				spcBsaMgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
    					deleteVoList.add(spcBsaMgmtVOs[inx]);		
	    			}
    			}
    			
    			if ("".equals(rtnVal.toString()) && deleteVoList.size() > 0 ) {
					dbDao.removeSpaceContorlInquiryBSA(deleteVoList);
    			}
    			if ("".equals(rtnVal.toString()) && insertVoList.size() > 0 ) {
					dbDao.addSpaceContorlInquiryBSA(insertVoList);
    			}
    			
    			if ("".equals(rtnVal.toString()) && updateVoList.size() > 0 ) {
    				dbDao.modifySpaceContorlInquiryBSA(updateVoList);  
    			}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
     * F"cast 입력 요청 메세지 송부 기능.<br>
     * 
     * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createSendMail(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException{
		SpacecontrolinquiryBackEndJob backEndJob = new SpacecontrolinquiryBackEndJob();
		backEndJob.setSpcSendMailVo(searchSpaceControlInquiryConditionVO,account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Daily Forecast Status - Send Message");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }	
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList4(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021AllocPortViewList4(searchSpaceControlInquiryConditionVO, account, ui_name, isSHA, isSEL, isTYO);
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setEtc(etc);
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList5(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			
			List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> inquiry021AllocPortViewList5VOs =  dbDao.searchSpaceControlInquiry021AllocPortViewList5(searchSpaceControlInquiryConditionVO, account, ui_name);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs(inquiry021AllocPortViewList5VOs);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * ESM_SPC_0086 : [Save] <br>
	 * 	Report에서 조회할 VVD List를 조회한다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @throws EventException
	 */
	public List<ComplexMainVO> searchSpcTgtVvdList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			
			List<SpcTgtVvdVO> spcTgtVvdVOs =  dbDao.searchSpcTgtVvdList(searchSpaceControlInquiryConditionVO);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSpcTgtVvdVOs(spcTgtVvdVOs);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SPC_0086 : [Save] 
	 *  Report에서 조회할 VVD List를 저장한다.
	 *  
	 * @param SpcTgtVvdVO[] spcTgtVvdVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcTgtVvdList(SpcTgtVvdVO[] spcTgtVvdVOs, SignOnUserAccount account) throws EventException {
		
		try{
    			List<SpcTgtVvdVO> insertVoList = new ArrayList<SpcTgtVvdVO>();
    			
    			String ibflag = "";

    			for (int inx=0; inx < spcTgtVvdVOs.length; inx++){
    				ibflag = spcTgtVvdVOs[inx].getIbflag();
    				if ("I".equals(ibflag)){
    					spcTgtVvdVOs[inx].setCreUsrId(account.getUsr_id());

    					insertVoList.add(spcTgtVvdVOs[inx]);
    				}
    			}
    			
				if (insertVoList.size() > 0 ) {
					dbDao.removeSpcTgtVvdList(insertVoList);
					dbDao.addSpcTgtVvdList(insertVoList);
    			}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }	
	}

	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 저장한다.
	 *  
	 * @param SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcTeamQtaRtos(SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs, SignOnUserAccount account) throws EventException {
		
		try{
    			List<SpcTeamQtaRtoVO> insertVoList = new ArrayList<SpcTeamQtaRtoVO>();
    			List<SpcTeamQtaRtoVO> updateVoList = new ArrayList<SpcTeamQtaRtoVO>();
    			List<SpcTeamQtaRtoVO> deleteVoList = new ArrayList<SpcTeamQtaRtoVO>();
    			
    			String ibflag = "";

    			for (int inx=0; inx < spcTeamQtaRtoVOs.length; inx++){
    				ibflag = spcTeamQtaRtoVOs[inx].getIbflag();
    				if ("I".equals(ibflag)){
    					spcTeamQtaRtoVOs[inx].setCreUsrId(account.getUsr_id());
    					insertVoList.add(spcTeamQtaRtoVOs[inx]);
    				}else if ("U".equals(ibflag) && !("1".equals(spcTeamQtaRtoVOs[inx].getDel()))){
    					spcTeamQtaRtoVOs[inx].setCreUsrId(account.getUsr_id());
    					updateVoList.add(spcTeamQtaRtoVOs[inx]);
    				}else if ("U".equals(ibflag) && "1".equals(spcTeamQtaRtoVOs[inx].getDel())){
    					spcTeamQtaRtoVOs[inx].setCreUsrId(account.getUsr_id());
    					deleteVoList.add(spcTeamQtaRtoVOs[inx]);
    				}
    			}

				if (deleteVoList.size() > 0 ) {
					dbDao.removeSpcTeamQtaRtos(deleteVoList);
				}
				if (insertVoList.size() > 0 ) {
					dbDao.addSpcTeamQtaRtos(insertVoList);
    			}
				if (updateVoList.size() > 0 ) {
					dbDao.modifySpcTeamQtaRtos(updateVoList);
				}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}

	/**
	 * ESM_SPC_0085 : [Retrieve] 
	 *  한국지점 팀별 QTA RATIO를 조회한다.
	 *  
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @throws EventException
	 */
	public List<ComplexMainVO> searchSpcTeamQtaRtoList(ConditionVO conditionVO) throws EventException {
		try {
			
			List<SpcTeamQtaRtoVO> spcTeamQtaRtos =  dbDao.searchSpcTeamQtaRtoList(conditionVO);
			
			ComplexMainVO com = new ComplexMainVO();
			com.setSpcTeamQtaRtoVOs(spcTeamQtaRtos);
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList6(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException {
		try {
			
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021AllocPortViewList6(searchSpaceControlInquiryConditionVO, account, ui_name);

			ComplexMainVO com = new ComplexMainVO();
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();	
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021FcstPfmcAcctViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			String rhq2 = searchSpaceControlInquiryConditionVO.getRhq2();
			int isSHA = rhq2.indexOf("SHARC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isSEL = rhq2.indexOf("SELSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			int isTYO = rhq2.indexOf("TYOSC"); //RHQ조건에 없으면 -1, 있으면 0이거나 0보다 큼
			if(isSEL >= 0 || isTYO >= 0){ //RHQ 조건에 SELSC, TYOSC가 있는데 SHARC가 선택 안된경우 SHARC를 넣어줌
				if(isSHA == -1){
					searchSpaceControlInquiryConditionVO.setRhq2(rhq2+",SHARC");
				}
			}
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();
			String checkSmp = searchSpaceControlInquiryConditionVO.getCheckSmp();
			
			if(checkSmp.equals("SMP")){
				 inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021FcstPfmcAcctViewList(searchSpaceControlInquiryConditionVO, account, isSHA, isSEL, isTYO);
			}else if(checkSmp.equals("NSMP")){
				 inquiry021AllocPortViewListVO =  dbDao.searchSpaceControlInquiry021FcstPfmcAcctViewNSmpList(searchSpaceControlInquiryConditionVO, account, isSHA, isSEL, isTYO);
			}
			
			List<ETCVO> etc = dbDao.searchETC(searchSpaceControlInquiryConditionVO);
			ComplexMainVO com = new ComplexMainVO();
			com.setInquiry021AllocPortViewListVO(inquiry021AllocPortViewListVO);
			com.setEtc(etc);
			com.setCondition(searchSpaceControlInquiryConditionVO);						
						
			List<ComplexMainVO> listCom = new ArrayList<ComplexMainVO>();
			listCom.add(com);
			
			return listCom;		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [ESM_SPC_0057]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceUtilizationListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceUtilizationListVO> searchSpaceUtilizationList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException {
		try {
			return dbDao.searchSpaceUtilizationList(searchSpaceControlInquiryConditionVO);						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @return List<ExcelDownSpaceUtilizationPortListVO>
	 * @exception EventException
	 */
	public List<ExcelDownSpaceUtilizationPortListVO> excelDownSpaceUtilizationPort(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			searchSpaceControlInquiryConditionVO.setUserOfc(account.getOfc_cd());
			
			return dbDao.excelDownSpaceUtilizationPort(searchSpaceControlInquiryConditionVO);						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @return List<ExcelDownSpaceUtilizationLaneListVO>
	 * @exception EventException
	 */	
	public List<ExcelDownSpaceUtilizationLaneListVO> excelDownSpaceUtilizationLane(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException {
		try {
			searchSpaceControlInquiryConditionVO.setUserOfc(account.getOfc_cd());
			
			return dbDao.excelDownSpaceUtilizationLane(searchSpaceControlInquiryConditionVO);						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	} 
	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */
	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058VVDList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceControlInquiryVO> managerVOs = new ArrayList<SpaceControlInquiryVO>();
			SpaceControlInquiryVO managerVO = new SpaceControlInquiryVO();
			
			List<SearchSpaceControlInquiry058VVDListVO> searchSpaceControlInquiry058VVDListVOs = dbDao.searchSpaceControlInquiry058VVDList(conditionVO);
			managerVO.setSearchSpaceControlInquiry058VVDListVOs(searchSpaceControlInquiry058VVDListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */
	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058VVDInfo(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceControlInquiryVO> managerVOs = new ArrayList<SpaceControlInquiryVO>();
			SpaceControlInquiryVO managerVO = new SpaceControlInquiryVO();
			List<SearchSpaceControlInquiry058VVDInfoVO> searchSpaceControlInquiry058VVDInfoVOs = dbDao.searchSpaceControlInquiry058VVDInfo(conditionVO);
			managerVO.setSearchSpaceControlInquiry058VVDInfoVOs(searchSpaceControlInquiry058VVDInfoVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */

	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058QtyList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceControlInquiryVO> managerVOs = new ArrayList<SpaceControlInquiryVO>();
			SpaceControlInquiryVO managerVO1 = new SpaceControlInquiryVO();
			SpaceControlInquiryVO managerVO2 = new SpaceControlInquiryVO();
			
			String vvd = conditionVO.getVvd();
			if (vvd.length() == 9) {
				conditionVO.setVslCd(vvd.substring(0, 4));
				conditionVO.setSkdVoyNo(vvd.substring(4, 8));
				conditionVO.setSkdDirCd(vvd.substring(8));
			}
			conditionVO.setRhq1("SHARC");
			conditionVO.setRhq2("SINRS");
			conditionVO.setQtyTp("1");
			List<SearchSpaceControlInquiry058QtyListVO> searchSpaceControlInquiry058QtyListVOs1 = dbDao.searchSpaceControlInquiry058QtyList(conditionVO);
			managerVO1.setSearchSpaceControlInquiry058QtyListVOs(searchSpaceControlInquiry058QtyListVOs1);
			
			conditionVO.setQtyTp("2");
			List<SearchSpaceControlInquiry058QtyListVO> searchSpaceControlInquiry058QtyListVOs2 = dbDao.searchSpaceControlInquiry058QtyList(conditionVO);
			managerVO2.setSearchSpaceControlInquiry058QtyListVOs(searchSpaceControlInquiry058QtyListVOs2);
			
			managerVOs.add(managerVO1);
			managerVOs.add(managerVO2);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_SPC_0087 : [Retrieve]<br>
	 * [T/S Plan & guide main list]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @exception EventException
	 */	
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideMainList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTsPlanGuideMainList(conditionVO);						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0087 : [Save] 전<br>
	 * [T/S Plan & guide Main]을 [저장] 전에 VSK 와 겹치는 목록이 있는지 확인한다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchTsPlanGuideDupVvd(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs) throws EventException {
		String[] dupData = null;
		try {
			for (int i = 0; i < searchTsPlanGuideListVOs.length; i++) {
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("I")) {
					dupData = dbDao.searchTsPlanGuideDupVvd(searchTsPlanGuideListVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return dupData;
	}
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Main]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideMainList(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();// user id

		try {
			List<SearchTsPlanGuideListVO> insertVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> deleteVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> updateVoList = new ArrayList<SearchTsPlanGuideListVO>();
			//Delete, Update, Insert
			for (int i = 0; i < searchTsPlanGuideListVOs.length; i++) {
				searchTsPlanGuideListVOs[i].setCreUsrId(usr_id);
				searchTsPlanGuideListVOs[i].setUpdUsrId(usr_id);
				
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(searchTsPlanGuideListVOs[i]);
				} 
				
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("U")) {
					updateVoList.add(searchTsPlanGuideListVOs[i]);
				}
				
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("I")) {
					insertVoList.add(searchTsPlanGuideListVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeTsPlanGuideMainList(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyTsPlanGuideMainList(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addTsPlanGuideMainList(insertVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * ESM_SPC_0087 : [Sheet1 Dbl Click]<br>
	 * [T/S Plan & guide detail list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @exception EventException
	 */	
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideDetailList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException {
		try {
			return dbDao.searchTsPlanGuideDetailList(searchTsPlanGuideListVO);						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * ESM_SPC_0087 : [Sheet1,2 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Sub trade, lane, BD, Week, Operator, Yard, ETD, Lane]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return String[]
	 * @exception EventException
	 */	
	public String[] searchTsPlanGuideValidData(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException {
		try {
			return dbDao.searchTsPlanGuideValidData(searchTsPlanGuideListVO);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideDetailList(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();// user id

		try {
//			List<SearchTsPlanGuideListVO> insertVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> deleteVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> updateVoList = new ArrayList<SearchTsPlanGuideListVO>();
			
//			//SPC_TS_PLN_GID_MN 테이블에 없는 VVD, Port Insert
//			for (int k = 0; k < searchTsPlanGuideListVOs.length; k++) {
//				searchTsPlanGuideListVOs[k].setCreUsrId(usr_id);
//				searchTsPlanGuideListVOs[k].setUpdUsrId(usr_id);
//				
//				if (searchTsPlanGuideListVOs[k].getIbflag().equals("I")) {
//					dbDao.addTsPlanGuideMainList1(searchTsPlanGuideListVOs[k]);
//					break;
//				}
//			}
			
			//Delete, Update
			for (int i = 0; i < searchTsPlanGuideListVOs.length; i++) {
				searchTsPlanGuideListVOs[i].setCreUsrId(usr_id);
				searchTsPlanGuideListVOs[i].setUpdUsrId(usr_id);
				
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(searchTsPlanGuideListVOs[i]);
				} 
				
				if (searchTsPlanGuideListVOs[i].getIbflag().equals("U")) {
					updateVoList.add(searchTsPlanGuideListVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeTsPlanGuideDetailList(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyTsPlanGuideDetailList(updateVoList);
			}
			
			//Insert
			for (int j = 0; j < searchTsPlanGuideListVOs.length; j++) {
				searchTsPlanGuideListVOs[j].setCreUsrId(usr_id);
				searchTsPlanGuideListVOs[j].setUpdUsrId(usr_id);
				
				if (searchTsPlanGuideListVOs[j].getIbflag().equals("I")) {
					dbDao.addTsPlanGuideDetailList(searchTsPlanGuideListVOs[j]);
				}
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0087 : [Sheet1 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Rlane 목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideVvdRlane(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException {
		List<SearchTsPlanGuideListVO> list = null;
		try {
			list = dbDao.searchTsPlanGuideVvdRlane(searchTsPlanGuideListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());      
		}
		return list;
	}
	
	/**
	 * ESM_SPC_0088 : [Load Page]<br>
	 * [T/S Plan & guide Attach list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideAtchList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException {
		List<SearchTsPlanGuideListVO> list = null;
		try {
			list = dbDao.searchTsPlanGuideAtchList(searchTsPlanGuideListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());      
		}
		return list;
	}
	
	
	/**
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideAtch(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();// user id

		try {
			List<SearchTsPlanGuideListVO> insertVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> deleteVoList = new ArrayList<SearchTsPlanGuideListVO>();
			List<SearchTsPlanGuideListVO> updateVoList = new ArrayList<SearchTsPlanGuideListVO>();
			for (int i = 0; i < searchTsPlanGuideListVOs.length; i++) {

				if (searchTsPlanGuideListVOs[i].getIbflag().equals("U")) {
					deleteVoList.add(searchTsPlanGuideListVOs[i]);
					searchTsPlanGuideListVOs[i].setIbflag("I");
				}

				if (searchTsPlanGuideListVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(searchTsPlanGuideListVOs[i]);
					UpdateFileMetaInfo.delete(searchTsPlanGuideListVOs[i].getFileSavId());

				} else if (searchTsPlanGuideListVOs[i].getIbflag().equals("I")) {
					searchTsPlanGuideListVOs[i].setCreUsrId(usr_id);
					searchTsPlanGuideListVOs[i].setUpdUsrId(usr_id);

					searchTsPlanGuideListVOs[i].setFileSavId(searchTsPlanGuideListVOs[i].getKeys());
					insertVoList.add(searchTsPlanGuideListVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeTsPlanGuideAtch(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addTsPlanGuideAtch(insertVoList);
				// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
				updateVoList.add(searchTsPlanGuideListVOs[0]);
				dbDao.modifyTsPlanGuideAtch(updateVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}
