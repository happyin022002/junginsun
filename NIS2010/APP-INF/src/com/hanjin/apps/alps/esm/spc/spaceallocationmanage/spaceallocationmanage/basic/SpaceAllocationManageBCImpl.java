/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceAllocationManageBCImpl.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
History ------------------------------------------
2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
                                   - Remark 가능한 Office인지 체크하기
2011.05.03 이석준 [CHM-201110568-01] Bottleneck Check 화면 조건 보완(VVD Input 조회시 VVD 정보 조회)
                                   - SearchSpaceAllocationManage045VVDInfo method 추가                                           
2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 팝업 추가
2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
2011.09.15 이행지 [CHM-201113449-01] COA 링크 화면 보완 - 메소드명 변경, 불필요 변수 삭제
2012.03.19 김성훈 [CHM-201216752-01] COA Report 화면과 동일하게 구성 - 해당 항차, Load Office, POL/POD 조건에 맞는 실적정보 조회
2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
2013.08.13 진마리아 [trouble shooting] 성수기Alloc 저장시 비수기로 말아올리는 과정에 mnl_aloc_rmk 가 3으로 하드코딩된 것 수정
2013.08.09 박찬민 [CHM-201325692] Bottleneck 산출 로직 추가 - 신규 메뉴
2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
2014.07.04 Arie Im [CHM-201431038] SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화
2014.06.30 김용습 R4J 패치 사전 작업
2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정 sheet11) 
		   - 0049화면에 call_ui추가, VVD lenth체크추가
2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
2015.01.30 신자영 [CHM-201533908] Control Option 보완 - SC/RFA컬럼 제거 - Sheet3, 4 추가, sheet2, 3, 4에 delete check box 추가(9014754 김성욱)
2015.03.25 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
2015.06.19 김성욱 소스 품질
2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration.SpaceAllocationManageDBDAO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRemarkFlagOfficeVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRptItemVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSPCAllocBKGListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0033LaneRgstVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDInfoVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationModelListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationModelRun0054ListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageSummaryVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageTempListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcAlocCtrlOptVO;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;
import com.hanjin.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;
import com.hanjin.syscommon.common.table.SpcNshwRsltVO;

/**
 * ALPS-SpaceAllocationManage Business Logic Basic Command implementation<br>
 * - ALPS-SpaceAllocationManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0042EventResponse,SpaceAllocationManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */


public class SpaceAllocationManageBCImpl extends BasicCommandSupport implements SpaceAllocationManageBC {

	// Database Access Object
	private transient SpaceAllocationManageDBDAO dbDao = null;

	/**
	 * SpaceAllocationManageBCImpl 객체 생성<br>
	 * SpaceAllocationManageDBDAO를 생성한다.<br>
	 */
	public SpaceAllocationManageBCImpl() {
		dbDao = new SpaceAllocationManageDBDAO();
	}
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * doRowSearch 시에 사용하고 있음
	 * 
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationControlFlagList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			conditionVO.setUserOfc(account.getOfc_cd());
			conditionVO.setOfcCd(account.getOfc_cd());
			
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			rsList.add(rowSet);
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationDetailList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			conditionVO.setUserOfc(account.getOfc_cd());
			conditionVO.setOfcCd(account.getOfc_cd());
			
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			DBRowSet rowSet2 = (DBRowSet) rowSet.clone();
			
			if(rowSet2.next() && rowSet2.getString("ACCT").equals("Y")) {
				searchSpaceAllocation0042DetailListVOs = dbDao.searchSpaceAllocationDetailListSMP(conditionVO);
			} else {
				searchSpaceAllocation0042DetailListVOs = dbDao.searchSpaceAllocationDetailList(conditionVO);
			}
			
			
			String flg = dbDao.searchAllocationConfirmFlag(conditionVO.getLane(), conditionVO.getVvd());
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0042DetailListVOs(searchSpaceAllocation0042DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);
			spaceAllocationManageVO.setSaqExistFlg(flg);
			if(searchSpaceAllocation0042DetailListVOs != null && !searchSpaceAllocation0042DetailListVOs.isEmpty()){
				spaceAllocationManageVO.setDoubleCallChk(searchSpaceAllocation0042DetailListVOs.get(0).getPolDblPortChk());	
			}
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocationMasterList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * SMP 아닌 경우
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException{
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
			
			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocPolPodVO> alocVoList = new ArrayList<SpcAlocPolPodVO>();
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				String ctrlWt = "";
				if( ctrlWt.equals("") ) ctrlWt = spcAlocPolPodVO[i].getCtrlWt();
				else spcAlocPolPodVO[i].setCtrlWt(ctrlWt);
				
				if(spcAlocPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPodYdCd("0000000");
				}
				
				if(spcAlocPolPodVO[i].getPodCd().length() < 7) {
					spcAlocPolPodVO[i].setPodCd("0000000");
				}
				
				if(spcAlocPolPodVO[i].getPolYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPolYdCd("0000000");
				}
				// 2014.12.04 [CHM-201433097] A/C 및 CDMT추가 
				// 기존의 cust_cnt_cd, cust_seq에 추가로 ctrt_no도 추가 하여 관리
				// OTHERS이면 XX999999, X로  account의 길이가 9이면 SC, 10자리이면 RFA 이므로 contract no에 저장
				// 2014.12.12 SC/RFA 계약 자릿수 혼재로 인해 Account code의 세번째 자리 숫자 여부로 판단
				if(spcAlocPolPodVO[i].getAccountCd().length() < 2){
					spcAlocPolPodVO[i].setAccountCd("00000000");
					spcAlocPolPodVO[i].setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(spcAlocPolPodVO[i].getAccountCd().charAt(2))){
					spcAlocPolPodVO[i].setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(spcAlocPolPodVO[i].getAccountCd().charAt(3))){
					spcAlocPolPodVO[i].setCtrtNo(spcAlocPolPodVO[i].getAccountCd());
					spcAlocPolPodVO[i].setAccountCd("OTHERS");
				   // OTHERS
				}else{
					spcAlocPolPodVO[i].setCtrtNo("X");
					spcAlocPolPodVO[i].setAccountCd("OTHERS");
				}

				if(spcAlocPolPodVO[i].getUsMod().length() < 2) {
					spcAlocPolPodVO[i].setUsMod("00000");
				}
				if(spcAlocPolPodVO[i].getDelYdCd().length() < 5) {
					spcAlocPolPodVO[i].setDelYdCd("00000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocPolPodVO[i].setAlocGdt(date);
				
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
					
//					if(spcAlocPolPodVO[i].getPodYdCd().equals("0000000")) {
//						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
//							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
//						}
//						deleteVoList1.add(spcAlocPolPodVO[i]);
//					}
					// 2014.07.31 DEL SUM이 지워지지 않아 조건 추가
					if(spcAlocPolPodVO[i].getDelYdCd().equals("00000")||spcAlocPolPodVO[i].getDelYdCd().equals("1")) {
						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocPolPodVO[i]);
					}
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocPolPodVO[i].getAlocMdfy().equals("") ) ? "0": spcAlocPolPodVO[i].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocPolPodVO[i].getAsgnTtlQty().equals("") ) ? "0": spcAlocPolPodVO[i].getAsgnTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocPolPodVO[i].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocPolPodVO[i].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocPolPodVO[i].getBsTeu().equals("") ) ? "0": spcAlocPolPodVO[i].getBsTeu() );//Standby bkg cnt
					
					int bkgCntw = Integer.valueOf( (spcAlocPolPodVO[i].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocPolPodVO[i].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocPolPodVO[i].getBsWgt().equals("") ) ? "0": spcAlocPolPodVO[i].getBsWgt() );//Standby bkg cnt
					
//					System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
//					if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						alocVoList.add( spcAlocPolPodVO[i] );
					}
					
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.

				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocPolPodVO> newInsertVoList = new ArrayList<SpcAlocPolPodVO>(hs);
				
				//기존 insert는 중복 오류가 발생해서 merge문으로 변경함
				//dbDao.addmultiSpaceAllocationS(newInsertVoList);
				dbDao.addmultiSpaceAllocationSMerge(newInsertVoList);
				dbDao.removemultiSpaceAllocationS(deleteVoList1);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS(updateVoList);
			}
			
			// Remark 부분 처리
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if ( spcAlocPolPodVO[i].getIbflag().equals("I") || spcAlocPolPodVO[i].getIbflag().equals("U")){
					dbDao.modifymultiSpaceAllocation(spcAlocPolPodVO[i]);
				}
			}
			
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocationHO( alocVoList.get(x) , conditionVO);
//					List<String>rslt = dbDao.searchSpaceAllocation( alocVoList.get(x) );
	
					if( rslt != null && rslt.size() > 0 ) {
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
						}
						list = dbDao.searchSPCAllocBKGList( alocVoList.get(x) );
					}/*else{
						list = new ArrayList<SearchSPCAllocBKGListVO>();
						SearchSPCAllocBKGListVO v = new SearchSPCAllocBKGListVO();
						v.setRowNum(alocVoList.get(x).getAlocMdfy());
						v.setBkgTtlQty("60");
						v.setBkgSbQty("62");
						v.setBkgTtlWgt("1234");
						v.setBkgSbWgt("123");
						list.add( v );
					}*/
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocationSmp(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException{
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocCustPolPodVO> insertVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> updateVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> deleteVoList1 = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> deleteVoList2 = new ArrayList<SpcAlocCustPolPodVO>();

			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocCustPolPodVO> alocVoList = new ArrayList<SpcAlocCustPolPodVO>();
			
			for ( int i=0; i<spcAlocCustPolPodVO .length; i++ ) {
				String ctrlWt = "";
				if( ctrlWt.equals("") ) ctrlWt = spcAlocCustPolPodVO[i].getCtrlWt();
				else spcAlocCustPolPodVO[i].setCtrlWt(ctrlWt);
				
				if(spcAlocCustPolPodVO[i].getPodCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPodCd("0000000");
				}
				
				if(spcAlocCustPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPodYdCd("0000000");
				}
				
				if(spcAlocCustPolPodVO[i].getPolCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPolCd("0000000");
				}
				if(spcAlocCustPolPodVO[i].getUsMod().length() < 3) {
					spcAlocCustPolPodVO[i].setUsMod("00000");
				}
				// 2014.12.04 [CHM-201433097] A/C 및 CDMT추가 
				// 기존의 cust_cnt_cd, cust_seq에 추가로 ctrt_no도 추가 하여 관리
				// OTHERS이면 XX999999, X로  account의 길이가 9이면 SC, 10자리이면 RFA 이므로 contract no에 저장
				// 2014.12.12 SC/RFA 계약 자릿수 혼재로 인해 Account code의 세번째 자리 숫자 여부로 판단
				if(spcAlocCustPolPodVO[i].getAccountCd().length() < 2) {
					spcAlocCustPolPodVO[i].setAccountCd("00000000");
					spcAlocCustPolPodVO[i].setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(2))){
					spcAlocCustPolPodVO[i].setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(3))){
					spcAlocCustPolPodVO[i].setCtrtNo(spcAlocCustPolPodVO[i].getAccountCd());
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				   // OTHERS
				}else{
					spcAlocCustPolPodVO[i].setCtrtNo("X");
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				}
				// 2014.08.13 DEL 변수 변경 del_yd_cd -> del_cd
				if(spcAlocCustPolPodVO[i].getDelCd().length() < 5) {
					spcAlocCustPolPodVO[i].setDelCd("00000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				+ calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocCustPolPodVO[i].setAlocGdt(date);
				spcAlocCustPolPodVO[i].setCtrlLvlCd(conditionVO.getChkPort());
				
				spcAlocCustPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocCustPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocCustPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocCustPolPodVO[i]);
					if(spcAlocCustPolPodVO[i].getDelCd().equals("00000")) {
						if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocCustPolPodVO[i]);
					}
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getAlocMdfy().equals("") ) ? "0": spcAlocCustPolPodVO[i].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getAsgnTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getAsgnTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsTeu().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsTeu() );//Standby bkg cnt
//					String pol = spcAlocCustPolPodVO[i].getPolCd();
//					log.debug("SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgCnt="+ bkgCnt +", sbCnt=" + sbCnt +", pol="+pol);
					int bkgCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsWgt() );//Standby bkg cnt
					
//					System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
//					if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						log.debug(" SET DATA ");
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						alocVoList.add( spcAlocCustPolPodVO[i] );
					}
				} else if ( spcAlocCustPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
					}
					
//					if( spcAlocCustPolPodVO[i].getAlocMdfy() != null && spcAlocCustPolPodVO[i].getAsgnTtlQty() != null 
//							&& !spcAlocCustPolPodVO[i].getAlocMdfy().equals("") && !spcAlocCustPolPodVO[i].getAsgnTtlQty().equals("") ){
//					}
					
					updateVoList.add(spcAlocCustPolPodVO[i]);
				} else if ( spcAlocCustPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocCustPolPodVO[i]);
				}
			}
			
			// SMP 최초 입력시 기존 POL_POD 테이블의 정보를 체크하여 삭제 
			int cnt = dbDao.searchSpaceAllocationData(conditionVO);
			
			if(cnt == 0) {				
				dbDao.removemultiSpaceAllocationPolPod(conditionVO);
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationSmpS(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.
				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocCustPolPodVO> newInsertVoList = new ArrayList<SpcAlocCustPolPodVO>(hs);
				
				// ALOC_CUST_POL_POD, ALOC_CUST_HIS 테이블에 Data 입력 
				dbDao.modifymultiSpaceAllocationSmpS(newInsertVoList);
				// ALOC_CUST_POL_POD 정보를 ALOC_POL_POD 테이블에 입력
				dbDao.addmultiSpaceAllocationSmpS(newInsertVoList, "3");				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationSmpS(updateVoList);
				dbDao.addmultiSpaceAllocationSmpS(updateVoList, "3");				
			}
			
			if ( deleteVoList1.size() > 0 ) {
				// ALOC_POL_POD, ALOC_CUST_POL_POD 테이블에 '0000000' Data 삭제 
				dbDao.removemultiSpaceAllocationSmpS(deleteVoList1);
			}
			
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocationSmp( alocVoList.get(x) , conditionVO );
	
					if( rslt != null && rslt.size() > 0 ) {
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
						}
						//적용 결과 받기.. 
						list = dbDao.searchSPCAllocBKGSMPList( alocVoList.get(x) , conditionVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCtrlOptVO[] spcAlocCtrlOptVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiControlOption(SpcAlocCtrlOptVO[] spcAlocCtrlOptVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocCtrlOptVO> insertVoList = new ArrayList<SpcAlocCtrlOptVO>();
			List<SpcAlocCtrlOptVO> updateVoList = new ArrayList<SpcAlocCtrlOptVO>();
			List<SpcAlocCtrlOptVO> deleteVoList = new ArrayList<SpcAlocCtrlOptVO>();
			List<SpcAlocCtrlOptVO> desyncUpdateVoList = new ArrayList<SpcAlocCtrlOptVO>();
			
			for ( int i=0; i<spcAlocCtrlOptVO .length; i++ ) {
				if ( spcAlocCtrlOptVO[i].getIbflag().equals("I")){
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("D") ? "Y":"N");
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlPortFlg());
					} else {
						spcAlocCtrlOptVO[i].setCtrlPortFlg("N");
					}
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlLvlCd());
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("Y") ? "D":"L");
					} else {
						spcAlocCtrlOptVO[i].setCtrlLvlCd("N");
					}
					
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(spcAlocCtrlOptVO[i]);
				} else if ( spcAlocCtrlOptVO[i].getIbflag().equals("U")){
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("D") ? "Y":"N");
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlPortFlg());
					} else {
						spcAlocCtrlOptVO[i].setCtrlPortFlg("N");
					}
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlLvlCd());
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("Y") ? "D":"L");
					} else {
						spcAlocCtrlOptVO[i].setCtrlLvlCd("N");
					}
					
					if( spcAlocCtrlOptVO[i].getDesyncFlg() != null && spcAlocCtrlOptVO[i].getDesyncFlg().equals("Y") ) {
						desyncUpdateVoList.add( spcAlocCtrlOptVO[i] );
					}
					
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcAlocCtrlOptVO[i]);
				} else if ( spcAlocCtrlOptVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcAlocCtrlOptVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiControlOptionS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiControlOptionS(updateVoList);
			}
			
			if( desyncUpdateVoList.size() > 0 ) {
				dbDao.multiSpaceAllocationDeSync( desyncUpdateVoList );
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiControlOptionS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0065]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @param Event e
	 * @exception EventException
	 */
	public void multiSpaceAllocationManageTemp(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account, Event e) throws EventException{
		try {
			List<SpcAlocPolPodVO> insertVoList = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList = new ArrayList<SpcAlocPolPodVO>();
			
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
					spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcAlocPolPodVO[i]);
				}
			}
			
			if (e.getEventName().equalsIgnoreCase("EsmSpc0065Event")) {
				if ( insertVoList.size() > 0 ) {
					dbDao.addmultiSpaceAllocationTemp1stS(insertVoList);
				}	
			} else if (e.getEventName().equalsIgnoreCase("EsmSpc0066Event")) {
				if ( insertVoList.size() > 0 ) {
					dbDao.addmultiSpaceAllocationTemp3rdS(insertVoList);
				}
				if ( deleteVoList.size() > 0 ) {
					dbDao.removemultiSpaceAllocationTemp3rdS(deleteVoList);
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0066]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageTempVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManageTempList(ConditionVO conditionVO) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SpaceAllocationManageTempListVO> spaceAllocationManageTempListVOs = null;
		
		try {
			
			spaceAllocationManageTempListVOs = dbDao.searchSpaceAllocationManageTemp(conditionVO);
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSpaceAllocationManageTempListVOs(spaceAllocationManageTempListVOs);

			spaceAllocationManageVO.setConditionVO(conditionVO);
			
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0071]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchVesselSKDListVO>
	 * @exception EventException
	 */
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchVesselSKDList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044DetailList(ConditionVO conditionVO) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			DBRowSet rowSet2 = (DBRowSet) rowSet.clone();
			
			if(rowSet2.next() && rowSet2.getString("ACCT").equals("Y")) {
				searchSpaceAllocation0044DetailListVOs = dbDao.searchSpaceAllocation0044DetailSMPList(conditionVO);
			}else{
				searchSpaceAllocation0044DetailListVOs = dbDao.searchSpaceAllocation0044DetailList(conditionVO);
			}
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0044DetailListVOs(searchSpaceAllocation0044DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);

			if(searchSpaceAllocation0044DetailListVOs != null && !searchSpaceAllocation0044DetailListVOs.isEmpty()){
				spaceAllocationManageVO.setDoubleCallChk(searchSpaceAllocation0044DetailListVOs.get(0).getPolDblPortChk());	
			}
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044MasterList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			String vvd = conditionVO.getVvd();
			if (!vvd.equals("")) {
				conditionVO.setVslCd(vvd.substring(0, 4));
				conditionVO.setSkdVoyNo(vvd.substring(4, 8));
				conditionVO.setDirCd(vvd.substring(8));
			}
			
			List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterListVOs = dbDao.searchSpaceAllocation0044MasterList(conditionVO);
			managerVO.setSearchSpaceAllocation0044MasterListVOs(searchSpaceAllocation0044MasterListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param SignOnUserAccount account
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0044Manage(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException{
		//2015.04.16 김성욱, 추가 Aloc 물량 변경 - 결과 담음
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
			
			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocPolPodVO> alocVoList = new ArrayList<SpcAlocPolPodVO>();
			
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				String ctrlWt = "";
				if( ctrlWt.equals("") ) ctrlWt = spcAlocPolPodVO[i].getCtrlWt();
				else spcAlocPolPodVO[i].setCtrlWt(ctrlWt);
				
				if(spcAlocPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPodYdCd("0000000");
				}
			
				if(spcAlocPolPodVO[i].getPolYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPolYdCd("0000000");
				}
				
				if(spcAlocPolPodVO[i].getPodCd().length() < 7) {
					spcAlocPolPodVO[i].setPodCd("0000000");
				}
			
//				if(spcAlocPolPodVO[i].getPolCd().length() < 7) {
//					spcAlocPolPodVO[i].setPolCd("0000000");
//				}
				
				
				// 2014.12.04 [CHM-201433097] A/C 및 CDMT추가 
				// 기존의 cust_cnt_cd, cust_seq에 추가로 ctrt_no도 추가 하여 관리
				if(spcAlocPolPodVO[i].getAccountCd().length() < 2) {
					spcAlocPolPodVO[i].setAccountCd("00000000");
					spcAlocPolPodVO[i].setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(spcAlocPolPodVO[i].getAccountCd().charAt(2))){
					spcAlocPolPodVO[i].setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(spcAlocPolPodVO[i].getAccountCd().charAt(3))){
					spcAlocPolPodVO[i].setCtrtNo(spcAlocPolPodVO[i].getAccountCd());
					spcAlocPolPodVO[i].setAccountCd("OTHERS");
				   // OTHERS
				}else{
					spcAlocPolPodVO[i].setCtrtNo("X");
					spcAlocPolPodVO[i].setAccountCd("OTHERS");
				}
				
				if(spcAlocPolPodVO[i].getUsMod().length() < 2) {
					spcAlocPolPodVO[i].setUsMod("00000");
				}
				
				if(spcAlocPolPodVO[i].getDelYdCd().length() < 5) {
					spcAlocPolPodVO[i].setDelYdCd("00000");
				}
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocPolPodVO[i].setAlocGdt(date);
				
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
					
//					if(spcAlocPolPodVO[i].getPodYdCd().equals("0000000")) {
					if(spcAlocPolPodVO[i].getDelYdCd().equals("00000")) {
						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocPolPodVO[i]);
					}
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocPolPodVO[i].getAlocMdfy().equals("") ) ? "0": spcAlocPolPodVO[i].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocPolPodVO[i].getAsgnTtlQty().equals("") ) ? "0": spcAlocPolPodVO[i].getAsgnTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocPolPodVO[i].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocPolPodVO[i].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocPolPodVO[i].getBsTeu().equals("") ) ? "0": spcAlocPolPodVO[i].getBsTeu() );//Standby bkg cnt
//log.debug("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ spcAlocPolPodVO[i].getUsdBkgTtlQty() + ", bs_teu="+spcAlocPolPodVO[i].getBsTeu() );
					int bkgCntw = Integer.valueOf( (spcAlocPolPodVO[i].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocPolPodVO[i].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocPolPodVO[i].getBsWgt().equals("") ) ? "0": spcAlocPolPodVO[i].getBsWgt() );//Standby bkg cnt
					
					//System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
					//if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						alocVoList.add( spcAlocPolPodVO[i] );
					}
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS0044(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.
				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocPolPodVO> newInsertVoList = new ArrayList<SpcAlocPolPodVO>(hs);
				
				dbDao.addmultiSpaceAllocationS0044(newInsertVoList);
				dbDao.removemultiSpaceAllocationS0044(deleteVoList1);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS0044(updateVoList);
			}
			
			// Remark 부분 처리
//			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
//				if ( spcAlocPolPodVO[i].getIbflag().equals("I") || spcAlocPolPodVO[i].getIbflag().equals("U")){
//					dbDao.modifymultiSpaceAllocation(spcAlocPolPodVO[i]);
//				}
//			}
			
			//2015.04.16 김성욱, 추가 Aloc 물량 변경
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocation( alocVoList.get(x) );
	
					if( rslt != null && rslt.size() > 0 ) {
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
						}
						list = dbDao.searchSPCAllocBKGList( alocVoList.get(x) ); //spcAlocPolPodVO[x] );
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0044ManageSMP(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException{
		//ALOC물량 변경시 SAVE 후 물량 변경 처리 - 처리 결과 받음
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocCustPolPodVO> insertVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> updateVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> deleteVoList1 = new ArrayList<SpcAlocCustPolPodVO>();
			
			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocCustPolPodVO> alocVoList = new ArrayList<SpcAlocCustPolPodVO>();
			
			for ( int i=0; i<spcAlocCustPolPodVO .length; i++ ) {
				String ctrlWt = "";
				if( ctrlWt.equals("") ) ctrlWt = spcAlocCustPolPodVO[i].getCtrlWt();
				else spcAlocCustPolPodVO[i].setCtrlWt(ctrlWt);
				
				if(spcAlocCustPolPodVO[i].getUsMod().length() < 3) {
					spcAlocCustPolPodVO[i].setUsMod("00000");
				}
				// 2014.12.04 [CHM-201433097] A/C 및 CDMT추가 
				// 기존의 cust_cnt_cd, cust_seq에 추가로 ctrt_no도 추가 하여 관리
					// sum case
				if(spcAlocCustPolPodVO[i].getAccountCd().length() < 2) {
					spcAlocCustPolPodVO[i].setAccountCd("00000000");
					spcAlocCustPolPodVO[i].setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(2))){
					spcAlocCustPolPodVO[i].setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(3))){
					spcAlocCustPolPodVO[i].setCtrtNo(spcAlocCustPolPodVO[i].getAccountCd());
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				   // OTHERS
				}else{
					spcAlocCustPolPodVO[i].setCtrtNo("X");
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				}
				if(spcAlocCustPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPodYdCd("0000000");
				}
				if(spcAlocCustPolPodVO[i].getPodCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPodCd("0000000");
				}
				if(spcAlocCustPolPodVO[i].getPolCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPolCd("0000000");
				}
				//2014.08.01 DEL level 추가
				if(spcAlocCustPolPodVO[i].getDelCd().length() < 5) {
					spcAlocCustPolPodVO[i].setDelCd("00000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocCustPolPodVO[i].setAlocGdt(date);
				spcAlocCustPolPodVO[i].setCtrlLvlCd(conditionVO.getChkPort());
				
				spcAlocCustPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocCustPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocCustPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocCustPolPodVO[i]);
					
					if(spcAlocCustPolPodVO[i].getDelCd().equals("00000")) {
					//if(spcAlocCustPolPodVO[i].getPodCd().equals("0000000")) {
						if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocCustPolPodVO[i]);
					}
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getAlocMdfy().equals("") ) ? "0": spcAlocCustPolPodVO[i].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getBkgAvalTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBkgAvalTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsTeu().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsTeu() );//Standby bkg cnt
//					String pol = spcAlocCustPolPodVO[i].getPolCd();
//					log.debug("SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgCnt="+ bkgCnt +", sbCnt=" + sbCnt +", pol="+pol);
					
					int bkgCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsWgt() );//Standby bkg cnt
					
//					System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
//					if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						log.debug(" SET DATA ");
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						spcAlocCustPolPodVO[i].setAsgnTtlQty( spcAlocCustPolPodVO[i].getBkgAvalTtlQty() );
						spcAlocCustPolPodVO[i].setAsgnTtlWgt( spcAlocCustPolPodVO[i].getBkgAvalTtlWgt() );
						alocVoList.add( spcAlocCustPolPodVO[i] );
					}
				} else if ( spcAlocCustPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocCustPolPodVO[i]);
				}
			}
			
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.
				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocCustPolPodVO> newInsertVoList = new ArrayList<SpcAlocCustPolPodVO>(hs);
				
				// ALOC_CUST_POL_POD, ALOC_CUST_HIS 테이블에 Data 입력 
				dbDao.modifymultiSpaceAllocationSmpS0044(newInsertVoList);
				// ALOC_CUST_POL_POD 정보를 ALOC_POL_POD 테이블에 입력
				dbDao.addmultiSpaceAllocationSmpS(newInsertVoList, "1");	
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationSmpS0044(updateVoList);
				dbDao.addmultiSpaceAllocationSmpS(updateVoList, "1");	
			}
			
			if ( deleteVoList1.size() > 0 ) {
				// ALOC_POL_POD, ALOC_CUST_POL_POD 테이블에 '0000000' Data 삭제 
				dbDao.removemultiSpaceAllocationSmpS(deleteVoList1);
			}
			
			//2015.04.16 김성욱, 추가 Aloc 물량 변경
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocationSmp( alocVoList.get(x) , conditionVO );
	
					if( rslt != null && rslt.size() > 0 ) {
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
						}
						//적용 결과 받기.. 나중에 위 if 문 안으로 들어가야 합니다....
						list = dbDao.searchSPCAllocBKGSMPList( alocVoList.get(x) , conditionVO );
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDListVOs = dbDao.searchSpaceAllocationManage045VVDList(conditionVO);
			managerVO.setSearchSpaceAllocationManage045VVDListVOs(searchSpaceAllocationManage045VVDListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDInfo(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			List<SearchSpaceAllocationManage045VVDInfoVO> searchSpaceAllocationManage045VVDInfoVOs = dbDao.searchSpaceAllocationManage045VVDInfo(conditionVO);
			managerVO.setSearchSpaceAllocationManage045VVDInfoVOs(searchSpaceAllocationManage045VVDInfoVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045QtyList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO1 = new SpaceAllocationManageVO();
			SpaceAllocationManageVO managerVO2 = new SpaceAllocationManageVO();
			
			String vvd = conditionVO.getVvd();
			if (vvd.length() == 9) {
				conditionVO.setVslCd(vvd.substring(0, 4));
				conditionVO.setSkdVoyNo(vvd.substring(4, 8));
				conditionVO.setSkdDirCd(vvd.substring(8));
			}
			conditionVO.setRhq1("SHARC");
			conditionVO.setRhq2("SINRS");
			conditionVO.setQtyTp("1");
			List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs1 = dbDao.searchSpaceAllocationManage045QtyList(conditionVO);
			managerVO1.setSearchSpaceAllocationManage045QtyListVOs(searchSpaceAllocationManage045QtyListVOs1);
			
			conditionVO.setQtyTp("2");
			List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs2 = dbDao.searchSpaceAllocationManage045QtyList(conditionVO);
			managerVO2.setSearchSpaceAllocationManage045QtyListVOs(searchSpaceAllocationManage045QtyListVOs2);
			
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
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047DetailList(ConditionVO conditionVO) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			DBRowSet rowSet2 = (DBRowSet) rowSet.clone();
			
			if(rowSet2.next() && rowSet2.getString("ACCT").equals("Y")) {
				searchSpaceAllocation0047DetailListVOs = dbDao.searchSpaceAllocation0047DetailListSMP(conditionVO);
			} else {
				searchSpaceAllocation0047DetailListVOs = dbDao.searchSpaceAllocation0047DetailList(conditionVO);
			}
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0047DetailListVOs(searchSpaceAllocation0047DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			if(searchSpaceAllocation0047DetailListVOs != null && !searchSpaceAllocation0047DetailListVOs.isEmpty()){
				spaceAllocationManageVO.setDoubleCallChk(searchSpaceAllocation0047DetailListVOs.get(0).getPolDblPortChk());	
			}
			spaceAllocationManageVO.setConditionVO(conditionVO);
			
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047MasterList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterListVOs = dbDao.searchSpaceAllocation0047MasterList(conditionVO);
			managerVO.setSearchSpaceAllocation0047MasterListVOs(searchSpaceAllocation0047MasterListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0047Manage(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException{
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
		
			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocPolPodVO> alocVoList = new ArrayList<SpcAlocPolPodVO>();
			
			SpcAlocPolPodVO tempSpcAlocPolPodVO ;
			String ctrlWt="";
			for ( int k=0; k< spcAlocPolPodVO.length; k++ ) {
				
				
				tempSpcAlocPolPodVO = spcAlocPolPodVO[k];
				if( ctrlWt.equals("") ) ctrlWt = tempSpcAlocPolPodVO.getCtrlWt();
				else tempSpcAlocPolPodVO.setCtrlWt(ctrlWt);
				log.debug("\n ***************** k = " + k
						+ " IBFlag = " + tempSpcAlocPolPodVO.getIbflag()
						+ " UsMod = " + tempSpcAlocPolPodVO.getUsMod()
						+ " AccountCd = " +tempSpcAlocPolPodVO.getAccountCd()
						+ " PolYdCd = " + tempSpcAlocPolPodVO.getPolYdCd()
						+ " PodYdCd = " + tempSpcAlocPolPodVO.getPodYdCd()
						+ " DelYdCd = " + tempSpcAlocPolPodVO.getDelYdCd()
						+ " CtrlWt = " + tempSpcAlocPolPodVO.getCtrlWt() );
				
					
				if(tempSpcAlocPolPodVO.getUsMod().length() < 3) {//IPI,LOCAL,OTHERS
					tempSpcAlocPolPodVO.setUsMod("00000");
				}
				// 2014.12.04 [CHM-201433097] A/C 및 CDMT추가 
				// 기존의 cust_cnt_cd, cust_seq에 추가로 ctrt_no도 추가 하여 관리
				// OTHERS이면 XX999999, X로  account의 길이가 9이면 SC, 10자리이면 RFA 이므로 contract no에 저장
				if(tempSpcAlocPolPodVO.getAccountCd().length() < 2){
					tempSpcAlocPolPodVO.setAccountCd("00000000");
					tempSpcAlocPolPodVO.setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(tempSpcAlocPolPodVO.getAccountCd().charAt(2))){
					tempSpcAlocPolPodVO.setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(tempSpcAlocPolPodVO.getAccountCd().charAt(3))){
					tempSpcAlocPolPodVO.setCtrtNo(tempSpcAlocPolPodVO.getAccountCd());
					tempSpcAlocPolPodVO.setAccountCd("OTHERS");
				   // OTHERS
				}else{
					tempSpcAlocPolPodVO.setCtrtNo("X");
					tempSpcAlocPolPodVO.setAccountCd("OTHERS");
				}

				if( tempSpcAlocPolPodVO.getPodYdCd().length() < 7) {
					tempSpcAlocPolPodVO.setPodYdCd("0000000");
				} 

				if( tempSpcAlocPolPodVO.getPodCd().length() < 7) {
					tempSpcAlocPolPodVO.setPodCd("0000000");
				} 
				
				
				if( tempSpcAlocPolPodVO.getPolYdCd().length() < 7) {
					tempSpcAlocPolPodVO.setPolYdCd("0000000");
				}
				if( tempSpcAlocPolPodVO.getDelYdCd().length() < 5) {
					tempSpcAlocPolPodVO.setDelYdCd("00000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				tempSpcAlocPolPodVO.setAlocGdt(date);
				
				tempSpcAlocPolPodVO.setCreUsrId(account.getUsr_id());
				tempSpcAlocPolPodVO.setUpdUsrId(account.getUsr_id());
				
				if ( tempSpcAlocPolPodVO.getIbflag().equals("I")){
					
					insertVoList.add(tempSpcAlocPolPodVO);
					
//					if( tempSpcAlocPolPodVO.getPodYdCd().equals("0000000")) {
					if( tempSpcAlocPolPodVO.getDelYdCd().equals("00000")) {
						if(tempSpcAlocPolPodVO.getTsFlg().equals("Y") && (tempSpcAlocPolPodVO.getSlsOfcCd() == null || tempSpcAlocPolPodVO.getSlsOfcCd().equals(""))) {
							tempSpcAlocPolPodVO.setSlsOfcCd(tempSpcAlocPolPodVO.getSlsRhqCd());
						}
						deleteVoList1.add(tempSpcAlocPolPodVO);
					}
					
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocPolPodVO[k].getAlocMdfy().equals("") ) ? "0": spcAlocPolPodVO[k].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocPolPodVO[k].getAsgnTtlQty().equals("") ) ? "0": spcAlocPolPodVO[k].getAsgnTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocPolPodVO[k].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocPolPodVO[k].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocPolPodVO[k].getBsTeu().equals("") ) ? "0": spcAlocPolPodVO[k].getBsTeu() );//Standby bkg cnt
					
					int bkgCntw = Integer.valueOf( (spcAlocPolPodVO[k].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocPolPodVO[k].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocPolPodVO[k].getBsWgt().equals("") ) ? "0": spcAlocPolPodVO[k].getBsWgt() );//Standby bkg cnt

//					System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
//					if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						alocVoList.add( spcAlocPolPodVO[k] );
					}
				} else if ( tempSpcAlocPolPodVO.getIbflag().equals("U")){
					if( tempSpcAlocPolPodVO.getTsFlg().equals("Y") && ( tempSpcAlocPolPodVO.getSlsOfcCd() == null || tempSpcAlocPolPodVO.getSlsOfcCd().equals(""))) {
						tempSpcAlocPolPodVO.setSlsOfcCd(tempSpcAlocPolPodVO.getSlsRhqCd());
					}
					
					updateVoList.add(tempSpcAlocPolPodVO);
				} else if ( tempSpcAlocPolPodVO.getIbflag().equals("D")){
					if( tempSpcAlocPolPodVO.getTsFlg().equals("Y") && ( tempSpcAlocPolPodVO.getSlsOfcCd() == null || tempSpcAlocPolPodVO.getSlsOfcCd().equals(""))) {
						tempSpcAlocPolPodVO.setSlsOfcCd(tempSpcAlocPolPodVO.getSlsRhqCd());
					}
					deleteVoList2.add(tempSpcAlocPolPodVO);
				}
			}
			
				
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS0047(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.
				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocPolPodVO> newInsertVoList = new ArrayList<SpcAlocPolPodVO>(hs);
				
				dbDao.addmultiSpaceAllocationS0047(newInsertVoList);
				dbDao.removemultiSpaceAllocationS0047(deleteVoList1);
			}
		
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS0047(updateVoList);
			}
			
			// Remark 부분 처리
			for ( int i=0; i< spcAlocPolPodVO.length; i++ ) {
				
				tempSpcAlocPolPodVO= spcAlocPolPodVO[i];
				
				if ( tempSpcAlocPolPodVO.getIbflag().equals("I") || tempSpcAlocPolPodVO.getIbflag().equals("U")){
					dbDao.modifymultiSpaceAllocation(tempSpcAlocPolPodVO);
				}
			}
			
			//2015.04.16 김성욱, 추가 Aloc 물량 변경
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocationHO( alocVoList.get(x) , conditionVO);
					
					if( rslt != null && rslt.size() > 0 ) {
						log.debug("rslt.size="+rslt.size() );
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
							log.debug( "====>>>>" + rslt.get( k ) );
						}
						list = dbDao.searchSPCAllocBKGList( alocVoList.get(x) );
						if( list != null && list.size() > 0 ) log.debug(" list size="+list.size() );
						else log.debug("list is null or size is 0!!!!!!!!!!!!!!!!!!");
					} else
						log.debug("rslt is null or size is 0!!");
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO 
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0047ManageSmp(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException{
		List<SearchSPCAllocBKGListVO> list=null;
		try {
			List<SpcAlocCustPolPodVO> insertVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> updateVoList  = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> deleteVoList1 = new ArrayList<SpcAlocCustPolPodVO>();
			List<SpcAlocCustPolPodVO> deleteVoList2 = new ArrayList<SpcAlocCustPolPodVO>();
			
			//ALOC물량 변경시 SAVE 후 물량 변경 처리
			List<SpcAlocCustPolPodVO> alocVoList = new ArrayList<SpcAlocCustPolPodVO>();
			
			for ( int i=0; i<spcAlocCustPolPodVO .length; i++ ) {
				String ctrlWt = "";
				if( ctrlWt.equals("") ) ctrlWt = spcAlocCustPolPodVO[i].getCtrlWt();
				else spcAlocCustPolPodVO[i].setCtrlWt(ctrlWt);
				
				if(spcAlocCustPolPodVO[i].getUsMod().length() < 3) {
					spcAlocCustPolPodVO[i].setUsMod("00000");
				}

				if(spcAlocCustPolPodVO[i].getAccountCd().length() < 2) {
					spcAlocCustPolPodVO[i].setAccountCd("00000000");
					spcAlocCustPolPodVO[i].setCtrtNo("0");
					// 세번째 자리가 숫자이면 Account 로 인식 
				}else if(Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(2))){
					spcAlocCustPolPodVO[i].setCtrtNo("X");
				   // 4번째 자리 숫자. 계약 no로 인식
				}else if (Character.isDigit(spcAlocCustPolPodVO[i].getAccountCd().charAt(3))){
					spcAlocCustPolPodVO[i].setCtrtNo(spcAlocCustPolPodVO[i].getAccountCd());
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				   // OTHERS
				}else{
					spcAlocCustPolPodVO[i].setCtrtNo("X");
					spcAlocCustPolPodVO[i].setAccountCd("OTHERS");
				}
				
				
				if(spcAlocCustPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPodYdCd("0000000");
//					spcAlocCustPolPodVO[i].setPodCd("0000000");
				}
				
				if(spcAlocCustPolPodVO[i].getPodCd().length() < 7) {
//					spcAlocCustPolPodVO[i].setPodYdCd("0000000");
					spcAlocCustPolPodVO[i].setPodCd("0000000");
				}
				
				if(spcAlocCustPolPodVO[i].getPolCd().length() < 7) {
					spcAlocCustPolPodVO[i].setPolCd("0000000");
				}
				if(spcAlocCustPolPodVO[i].getDelYdCd().length() < 5) {
					spcAlocCustPolPodVO[i].setDelYdCd("00000");
				}
				
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				+ calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocCustPolPodVO[i].setAlocGdt(date);
				spcAlocCustPolPodVO[i].setCtrlLvlCd(conditionVO.getChkPort());
				
				spcAlocCustPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocCustPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocCustPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocCustPolPodVO[i]);
					
					//if(spcAlocCustPolPodVO[i].getPodCd().equals("0000000")) {
					if(spcAlocCustPolPodVO[i].getDelYdCd().equals("00000")) {
						if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocCustPolPodVO[i]);
					}
					//2015.04.16 김성욱, 추가 Aloc 물량 변경
					int orgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getAlocMdfy().equals("") ) ? "0": spcAlocCustPolPodVO[i].getAlocMdfy() );
//					int chgV = Integer.valueOf( (spcAlocCustPolPodVO[i].getAsgnTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getAsgnTtlQty() );
					int bkgCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlQty().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlQty() );//BKG cnt
					int sbCnt = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsTeu().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsTeu() );//Standby bkg cnt
//					String pol = spcAlocCustPolPodVO[i].getPolCd();
//					log.debug("SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgCnt="+ bkgCnt +", sbCnt=" + sbCnt +", pol="+pol);
					int bkgCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getUsdBkgTtlWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getUsdBkgTtlWgt() );
					int sbCntw = Integer.valueOf( (spcAlocCustPolPodVO[i].getBsWgt().equals("") ) ? "0": spcAlocCustPolPodVO[i].getBsWgt() );//Standby bkg cnt
					
//					System.out.println("no SMP IBFLAG => I,  is Chage? orgV=" + orgV + ", chgV=" + chgV + ", bkgttlqty="+ tempSpcAlocPolPodVO.getUsdBkgTtlQty() + ", bs_teu="+tempSpcAlocPolPodVO.getBsTeu() );
//					if( orgV > 0  && bkgCnt-sbCnt >= 0 && ( sbCnt > 0 && chgV > (bkgCnt-sbCnt) ) ){
					if( orgV > 0 && ( ( bkgCnt-sbCnt >= 0 && sbCnt > 0 ) || ( bkgCntw-sbCntw >= 0 && sbCntw > 0 ) )){
						log.debug(" SET DATA ");
						//Aloc 물량 변경, 조건 완화됨.
						//변경된 갯수만큼 CMPB 순으로 정렬하여 confirm 날림.
						alocVoList.add( spcAlocCustPolPodVO[i] );
					}
				} else if ( spcAlocCustPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocCustPolPodVO[i]);
				} else if ( spcAlocCustPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocCustPolPodVO[i].getTsFlg().equals("Y") && (spcAlocCustPolPodVO[i].getSlsOfcCd() == null || spcAlocCustPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocCustPolPodVO[i].setSlsOfcCd(spcAlocCustPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocCustPolPodVO[i]);
				}
			}
			
			// SMP 최초 입력시 기존 POL_POD 테이블의 정보를 체크하여 삭제 
			int cnt = dbDao.searchSpaceAllocationData(conditionVO);
			
			if(cnt == 0) {				
				dbDao.removemultiSpaceAllocationPolPod(conditionVO);
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationSmpS(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				//중복 제거용.
				HashSet hs = new HashSet(insertVoList);
				ArrayList<SpcAlocCustPolPodVO> newInsertVoList = new ArrayList<SpcAlocCustPolPodVO>(hs);
				
				// ALOC_CUST_POL_POD, ALOC_CUST_HIS 테이블에 Data 입력 
				dbDao.modifymultiSpaceAllocationSmpS(newInsertVoList);
				// ALOC_CUST_POL_POD 정보를 ALOC_POL_POD 테이블에 입력
				dbDao.addmultiSpaceAllocationSmpS(newInsertVoList, "3");				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationSmpS(updateVoList);
				dbDao.addmultiSpaceAllocationSmpS(updateVoList, "3");				
			}
			
			if ( deleteVoList1.size() > 0 ) {
				// ALOC_POL_POD, ALOC_CUST_POL_POD 테이블에 '0000000' Data 삭제 
				dbDao.removemultiSpaceAllocationSmpS(deleteVoList1);
			}
			
			if( alocVoList.size() > 0 ) {
				for( int x=0 ; x<alocVoList.size() ; x++ ) {
					List<String>rslt = dbDao.searchSpaceAllocationSmp( alocVoList.get(x) , conditionVO );
	
					if( rslt != null && rslt.size() > 0 ) {
						GeneralBookingReceiptBC gbr = new GeneralBookingReceiptBCImpl();
						for( int k=0 ; k<rslt.size() ; k++ ) {
	//						if( gbr.modifyAllocStatusForSpc( comfirmItem.getBkgNo() , account ) ) //현재(2015.04.23 return type 이 void 임, 이후 boolean 으로 변경 될 예정) by kim sung wook
							gbr.modifyAllocStatusForSpc( rslt.get( k ) , account );
						}
					}
					//적용 결과 받기.. 나중에 위 if 문 안으로 들어가야 합니다....
					list = dbDao.searchSPCAllocBKGSMPList( alocVoList.get(x) , conditionVO );
				}
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}

	/**
	 * [ESM_SPC_0053]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(ConditionVO conditionVO) throws EventException {
		try {
			
			String vvd = conditionVO.getVvd();
			String vsl_cd = "";
			String skd_voy_no = "";
			String skd_dir_cd = "";
			if(vvd != null && vvd.length() == 9){
				vsl_cd = vvd.substring(0, 4);
				skd_voy_no = vvd.substring(4, 8);
				skd_dir_cd = vvd.substring(8);				
			}
			conditionVO.setVslCd(vsl_cd);
			conditionVO.setSkdVoyNo(skd_voy_no);
			conditionVO.setSkdDirCd(skd_dir_cd);
			List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs = dbDao.searchSpaceAllocationManageList(conditionVO);
			return searchSpaceAllocation0053ManageListVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
   
	/**
	 * [ESM_SPC_0054]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationModelRun0054List(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocationModelRun0054ListVO> searchSpaceAllocationModelRun0054ListVOs = dbDao.searchSpaceAllocationModelRun0054List(conditionVO);
			if( searchSpaceAllocationModelRun0054ListVOs.size() > 0 ) {
				managerVO.setSearchSpaceAllocationModelRun0054ListVOs(searchSpaceAllocationModelRun0054ListVOs);
				managerVOs.add(managerVO);
			}
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	
	/**
	 * [ESM_SPC_0041]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationModelList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocationModelListVO> searchSpaceAllocationModelListVOs = dbDao.searchSpaceAllocationModelList(conditionVO);
			if( searchSpaceAllocationModelListVOs.size() > 0 ) {
				managerVO.setSearchSpaceAllocationModelListVOs(searchSpaceAllocationModelListVOs);
				managerVOs.add(managerVO);
			}
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowAdjustmentList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
				String[] rhqArr = conditionVO.getRhq().split(",");		
			
			if(rhqArr.length == 2){
				conditionVO.setRhq(rhqArr[0]);
				conditionVO.setRhq2(rhqArr[1]);
			}
			
			List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentListVOs = dbDao.searchNoShowAdjustmentList(conditionVO);
			managerVO.setSearchNoShowAdjustmentListVOs(searchNoShowAdjustmentListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowDownloadDateList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateListVOs = dbDao.searchNoShowDownloadDateList(conditionVO);
			managerVO.setSearchNoShowDownloadDateListVOs(searchNoShowDownloadDateListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcNshwRsltVO[] spcNshwRsltVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowAdjustment(SpcNshwRsltVO[] spcNshwRsltVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcNshwRsltVO> insertVoList  = new ArrayList<SpcNshwRsltVO>();
			List<SpcNshwRsltVO> updateVoList  = new ArrayList<SpcNshwRsltVO>();
			List<SpcNshwRsltVO> deleteVoList  = new ArrayList<SpcNshwRsltVO>();
			for ( int i=0; i<spcNshwRsltVO .length; i++ ) {
				
				spcNshwRsltVO[i].setCreUsrId(account.getUsr_id());
				spcNshwRsltVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcNshwRsltVO[i].getIbflag().equals("I")){
					insertVoList.add(spcNshwRsltVO[i]);					
					deleteVoList.add(spcNshwRsltVO[i]);
					
				} else if ( spcNshwRsltVO[i].getIbflag().equals("U")){
					updateVoList.add(spcNshwRsltVO[i]);
					
				} else if ( spcNshwRsltVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcNshwRsltVO[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiNoShowAdjustment(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiNoShowAdjustment(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiNoShowAdjustment(deleteVoList);
			}
			
						
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiForcastDownloadDate(SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcFcastDwnLodSkdVO> insertVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			List<SpcFcastDwnLodSkdVO> updateVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			List<SpcFcastDwnLodSkdVO> deleteVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			for ( int i=0; i<spcFcastDwnLodSkdVO .length; i++ ) {
				
				spcFcastDwnLodSkdVO[i].setCreUsrId(account.getUsr_id());
				spcFcastDwnLodSkdVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("I")){
					insertVoList.add(spcFcastDwnLodSkdVO[i]);					
					deleteVoList.add(spcFcastDwnLodSkdVO[i]);
					
				} else if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("U")){
					updateVoList.add(spcFcastDwnLodSkdVO[i]);
					
				} else if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcFcastDwnLodSkdVO[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiForcastDownloadDate(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiForcastDownloadDate(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiForcastDownloadDate(deleteVoList);
			}
			
					
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRemarkFlagOffice(String ofcCd) throws EventException {
		try {			
			List<SearchRemarkFlagOfficeVO> searchRemarkFlagOfficeVOs = dbDao.searchRemarkFlagOffice(ofcCd);
			String rmkFlg = "N";
			
			if( searchRemarkFlagOfficeVOs.size() > 0) {
				rmkFlg = searchRemarkFlagOfficeVOs.get(0).getSpcCtrlAlocRmkFlg();
			}
			
			return rmkFlg;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0042, ESM_SPC_0047]을 Weekly CMB 4주를 표현하기 위한 Header.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchWeek() throws EventException {
		DBRowSet dbrowset = null;
		String hearderWeek = "";
		String Week = "";
		
		try {			
			dbrowset = dbDao.searchWeek();
			
			//2014.06.30 김용습 R4J 패치 사전 작업
			StringBuffer out1 = new StringBuffer();
			
			while(dbrowset.next()){
				//2014.06.30 김용습 R4J 패치 사전 작업
				//hearderWeek = hearderWeek + dbrowset.getString("WEEK");
				Week = JSPUtil.getNull(dbrowset.getString("WEEK"));
				
				out1.append(Week);
				
				if(!dbrowset.isLast()) 
				  	out1.append("|"); //2014.07.28 CSY 2014.06.30 김용습 R4J 패치 오류 수정
					//hearderWeek = hearderWeek + "|";
			}
			//2014.06.30 김용습 R4J 패치 사전 작업
			hearderWeek = out1.toString();
			
			hearderWeek = hearderWeek + "|" + hearderWeek;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
		return hearderWeek;
	}
	
	/**
	 * [ESM_SPC_0048]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpcAlocPolPodVO>
	 * @exception EventException
	 */
	public List<SpcAlocPolPodVO> searchWAFAlloc(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchWAFAlloc(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0048]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiWAFAlloc(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList  = new ArrayList<SpcAlocPolPodVO>();
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpcAlocPolPodVOs(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpcAlocPolPodVOs(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpcAlocPolPodVOs(updateVoList);
			}
			
					
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Inquiry by Customized Condition 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */
    public SalesRPTCommonVO searchInqByCondition0049List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {

            String txtYear    	= searchVo.getFYear().trim();
            String txtFmWeek  	= searchVo.getFFmWk().trim();
            String txtToWeek  	= searchVo.getFToWk().trim();

            String pro_vw  		= searchVo.getFProVw();
            String ofc_vw  		= searchVo.getFOfcVw();
            String pro_lvl 		= searchVo.getFProLvl();

            // by Office
            String f_ofc_lvl     = searchVo.getFOfcLvl().trim();
            String f_rhq_cd     = searchVo.getFRhqCd().trim();
            String f_sls_ofc_cd = searchVo.getFSlsOfcCd().trim();

            // by route
            String f_trd_cd     = searchVo.getFTrdCd().trim();
            String f_rlane_cd   = searchVo.getFRlaneCd().trim();
            String f_skd_dir_cd = searchVo.getFSkdDirCd().trim();
            
            // VVD
            String f_vsl_cd     = searchVo.getFVslCd().trim();
            String f_skd_voy_no = searchVo.getFSkdVoyNo().trim();
            String f_dir_cd     = searchVo.getFDirCd().trim();

            String f_bkg_por_cd = searchVo.getFBkgPorCd().trim();
            String f_bkg_pod_cd = searchVo.getFBkgPodCd().trim();
            String f_bkg_pol_cd = searchVo.getFBkgPolCd().trim();
            String f_rev_pol_cd = searchVo.getFRevPolCd().trim();
            String f_rev_pod_cd = searchVo.getFRevPodCd().trim();
            String f_bkg_del_cd = searchVo.getFBkgDelCd().trim();
            
            String f_ioc_cd = searchVo.getFIocCd().trim();
            f_ioc_cd = (!f_ioc_cd.equals("")) ? f_ioc_cd.substring(0,1) : "";


            // by Customer
            String f_shpr_cd  	= searchVo.getFShipper().trim();
            String f_sc_no    	= searchVo.getFScNo().trim();
            String f_rfa_no   	= searchVo.getFRfaNo().trim();
            String f_key_acct_group  = searchVo.getFKeyAcctGroupCd().trim();
            
            String f_key_acc    = searchVo.getFKeyAcctIndvlCd().trim();
            String f_taa_no     = searchVo.getFTaaNo().trim();
            
            String f_cust_cd    = searchVo.getFCustCntCd();
            String f_srep_cd    = searchVo.getFSrepCd();
            String f_cust_ctrl  = searchVo.getFCustCtrl();

            // by Others
            String f_cmdt_cd        = searchVo.getFCmdtCd().trim();
            String f_usa_bkg_mod_cd = searchVo.getFUsaBkgModCd().trim();
            String f_cntr_tpsz_cd   = searchVo.getFCntrTpszCd().trim();
            
            String view_tpSz        = searchVo.getFViewTpsz();
            String f_bkg_no         = searchVo.getFBkgNo().trim();
            // 2013.08.13 CSY 추가
            String f_dest_loc_tp	= searchVo.getFDestLocTp();
            
            
            String f_call_ui	    = searchVo.getFCallUi();
            String f_sub_trd_cd	    = searchVo.getFSubTrdCd();
            String col_nm = searchVo.getFHeadernm();
            
            String[] tempColNm = col_nm.split("[|]");
            for(int j=0; j<tempColNm.length; j++){
            	tempColNm[j] = tempColNm[j].trim().toLowerCase();
            }               
            col_nm = vo.mergeParameterForArray(tempColNm, "[|]");
            
            vo.setIteratorList(vo.seperationParameter(col_nm, "[|]"));
            
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("keyList1"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList2"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList3"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList4"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList5"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList6"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("key_acct_group" , f_key_acct_group );
            vParam.put("key_acc"        , f_key_acc        );
            vParam.put("trd_cd"         , f_trd_cd         );
            vParam.put("rlane_cd"       , f_rlane_cd       );
            vParam.put("dir_cd"         , f_dir_cd         );
            vParam.put("vsl_cd"         , f_vsl_cd         );
            vParam.put("skd_voy_no"     , f_skd_voy_no     );
            vParam.put("skd_dir_cd"     , f_skd_dir_cd     );
            vParam.put("bkg_por_cd"     , f_bkg_por_cd     );
            vParam.put("bkg_pol_cd"     , f_bkg_pol_cd     );
            vParam.put("bkg_pod_cd"     , f_bkg_pod_cd     );
            vParam.put("rev_pol_cd"     , f_rev_pol_cd     );
            vParam.put("rev_pod_cd"     , f_rev_pod_cd     );
            vParam.put("bkg_del_cd"     , f_bkg_del_cd     );
            vParam.put("sc_no"          , f_sc_no          );
            vParam.put("rfa_no"         , f_rfa_no         );
            vParam.put("taa_no"         , f_taa_no         );
            vParam.put("shpr_cnt_cd"    , f_shpr_cd        );
            vParam.put("cmdt_cd"        , f_cmdt_cd        );
            vParam.put("usa_bkg_mod_cd" , f_usa_bkg_mod_cd );
            vParam.put("bkg_no"         , f_bkg_no         );
           // vParam.put("cntr_tpsz_cd"   , f_cntr_tpsz_cd   );
            if (f_cntr_tpsz_cd.indexOf("All") > -1) f_cntr_tpsz_cd = "";
            vParam.put("cntr_tpsz_cd", vo.seperationParameter(f_cntr_tpsz_cd, ","));
            vParam.put("sls_ofc_cd"     , f_sls_ofc_cd     );
            vParam.put("pro_vw"         , pro_vw           ); 
            vParam.put("to_wk"          , txtToWeek    );
            vParam.put("tpsz_sts"       , view_tpSz    );
            vParam.put("ofc_vw"         , ofc_vw       );
            vParam.put("pro_lvl"        , pro_lvl      );
            vParam.put("fm_wk"          , txtFmWeek    );
            vParam.put("ofc_lvl"        , f_ofc_lvl     );
            vParam.put("rhq_cd"         , f_rhq_cd );
            vParam.put("ofc_cd"         , f_sls_ofc_cd );
            vParam.put("year"			, txtYear	   );
            vParam.put("ioc"			, f_ioc_cd     );
            vParam.put("srep_cd"		, f_srep_cd    );
            vParam.put("cust_cd"		, f_cust_cd    );
            vParam.put("cust_ctrl"		, f_cust_ctrl  );
            vParam.put("dest_loc_tp"	, f_dest_loc_tp  );
            vParam.put("call_ui"	    , f_call_ui  );
            vParam.put("sub_trd_cd"	    , f_sub_trd_cd  );
            
            vo.setIndirectVariableValues(vParam);        	
        	
        	SalesRPTCommonVO retVo = new SalesRPTCommonVO();

            retVo = dbDao.searchInqByCondition0049List(vo);
            retVo.setHeader(searchVo.getFHeader());
            retVo.setHeaderNM(searchVo.getFHeadernm());					
            
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }  

    /**
     * group code 목록을 조회한다. 
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param String userId
     * @return SalesRPTCommonVO
     * @exception EventException
     */    
    public SalesRPTCommonVO searchInqByCondition0049List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {
        	String[] strItem = new String[2];
        	StringBuffer tempBuffer1 = new StringBuffer();
        	StringBuffer tempBuffer2 = new StringBuffer();
        	
        	if(!searchVo.getFSelgroup().equals("")){
        		List<SearchRptItemVO> list = searchRptItem1(searchVo, vo, userId);
        		
        		int listCnt = list.size();
    			if (listCnt > 0) {
    				for(int i=0; i<listCnt; i++){
    					tempBuffer1.append(((SearchRptItemVO)list.get(i)).getRptItmDesc());
    					tempBuffer2.append(((SearchRptItemVO)list.get(i)).getRptItmColNm());
    					if(listCnt - 1 != i ){
    						tempBuffer1.append("|");
    						tempBuffer2.append("|");  						
    					}
    				}
    			}
        		
    			strItem[0] = tempBuffer1.toString();
    			strItem[1] = tempBuffer2.toString();
        	}
        	else{
        		strItem[0] = "";
        		strItem[1] = "";
        	}
        	vo.setHeader(strItem[0]);
        	vo.setHeaderNM(strItem[1]);
            return vo;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }   

	/**
	 * group code 목록을 조회한다. 
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  SalesRPTCommonVO vo
	 * @param  String userId
	 * @return List<SearchRptItemVO>
	 * @throws EventException
	 */
    public List<SearchRptItemVO> searchRptItem1(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {      	
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("user_id", userId);
            qParam.put("slct_itm_fom_seq", searchVo.getFSelgroup());
            vo.setIndirectColumnValues(qParam);
            return dbDao.searchRptItem(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
    
	/**
	 * [ESM_SPC_0049]을 Select Customized RPT Form 조회.<br>
	 * 
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchRptFormList(SignOnUserAccount account) throws EventException {
		DBRowSet dbrowset = null;
		String slctItmFomCd = "";
		String slctItmFomNm = "";
		try {			
			dbrowset = dbDao.searchRptFormList(account);
			
			/** [2014 - 38주차] Java application 소스 품질 결함 검토 결과 수정 처리
			while(dbrowset.next()){
				slctItmFomCd = slctItmFomCd + dbrowset.getString("CODE");
				if(!dbrowset.isLast()) slctItmFomCd = slctItmFomCd + "|";
				
				slctItmFomNm = slctItmFomNm + dbrowset.getString("NAME");
				if(!dbrowset.isLast()) slctItmFomNm = slctItmFomNm + "|";
			}**/
			
			StringBuffer slctItmFomCdBuffer = new StringBuffer();
			StringBuffer slctItmFomNmBuffer = new StringBuffer();
			
			while(dbrowset.next()){
				slctItmFomCdBuffer.append(dbrowset.getString("CODE"));
				if(!dbrowset.isLast()) slctItmFomCdBuffer.append("|");	
				
				slctItmFomNmBuffer.append(dbrowset.getString("NAME"));
				if(!dbrowset.isLast()) slctItmFomNmBuffer.append("|");					
			}
			
			slctItmFomCd = slctItmFomCdBuffer.toString();
			slctItmFomNm = slctItmFomNmBuffer.toString();
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
		return slctItmFomCd+"@@"+slctItmFomNm;
	}
	
	/**
	 * [ESM_SPC_0046]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocation0046List(ConditionVO conditionVO) throws EventException {
			
		try {

			return dbDao.searchSpaceAllocation0046List(conditionVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param String grpAcct
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0046ManageByHO(SpcAlocPolPodVO[] spcAlocPolPodVO, String grpAcct, SignOnUserAccount account) throws EventException{
		
		try {
			
			List<SpcAlocPolPodVO> motiVoList = new ArrayList<SpcAlocPolPodVO>();
			
			// 저장 될 PK값을 삭제
			SpcAlocPolPodVO deleteSpcAlocPolPodVO ;
			List<SpcAlocPolPodVO> deleteVoList = new ArrayList<SpcAlocPolPodVO>();
			
			Calendar calendar = Calendar.getInstance();
			String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
			                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
					
			
			for ( int i=0; i<spcAlocPolPodVO.length; i++ ) {		
				
					spcAlocPolPodVO[i].setAlocGdt(date);					
					spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
					spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());					
					motiVoList.add(spcAlocPolPodVO[i]);		
										
					deleteSpcAlocPolPodVO=new SpcAlocPolPodVO();
					deleteSpcAlocPolPodVO = (SpcAlocPolPodVO) spcAlocPolPodVO[i].clone();
					deleteSpcAlocPolPodVO.setVslCd(spcAlocPolPodVO[i].getNewVslVd());
					deleteSpcAlocPolPodVO.setSkdVoyNo(spcAlocPolPodVO[i].getNewSkdVoyNo() );
					deleteSpcAlocPolPodVO.setSkdDirCd(spcAlocPolPodVO[i].getNewSkdDirCd());					
					deleteSpcAlocPolPodVO.setNewVslVd(spcAlocPolPodVO[i].getNewVslVd());
									
					deleteVoList.add(deleteSpcAlocPolPodVO);
					
			}
			
			if ( motiVoList != null && motiVoList.size() > 0 ) {
//성수기 - aloc_cust_pol_pod 삭제, aloc_pol_pod 삭제, aloc_cust_pol_pod copy, aloc_pol_pod copy
//비수기 - aloc_pol_pod 삭제, aloc_pol_pod copy
				// 저장된 Data를 삭제
				if("Y".equals(grpAcct)){
					dbDao.removemultiSpaceAllocation0046ByHOSmpList(deleteVoList);
				}
				dbDao.removemultiSpaceAllocation0046ByHOList(deleteVoList);
				
				// 새로운 Data 입력
				if("Y".equals(grpAcct)){
					dbDao.addmultiSpaceAllocation0046ByHOSmpList(motiVoList);
					//aloc_cust_his 입력
					dbDao.addmultiSpaceAllocation0046CustHis(motiVoList);
				}
				dbDao.addmultiSpaceAllocation0046ByHOList(motiVoList);
			}				
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param String grpAcct
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0046ManageByRHQ(SpcAlocPolPodVO[] spcAlocPolPodVO, String grpAcct, SignOnUserAccount account) throws EventException{
		
		try {
			
			List<SpcAlocPolPodVO> motiVoList = new ArrayList<SpcAlocPolPodVO>();
			
			// 저장 될 PK값을 삭제
			SpcAlocPolPodVO deleteSpcAlocPolPodVO ;
			List<SpcAlocPolPodVO> deleteVoList = new ArrayList<SpcAlocPolPodVO>();
			
			Calendar calendar = Calendar.getInstance();
			String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
			                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
							
			for ( int i=0; i<spcAlocPolPodVO.length; i++ ) {		
				
					spcAlocPolPodVO[i].setAlocGdt(date);					
					spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
					spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());					
					motiVoList.add(spcAlocPolPodVO[i]);		
										
					deleteSpcAlocPolPodVO=new SpcAlocPolPodVO();
					deleteSpcAlocPolPodVO = (SpcAlocPolPodVO) spcAlocPolPodVO[i].clone();
					deleteSpcAlocPolPodVO.setVslCd(spcAlocPolPodVO[i].getNewVslVd());
					deleteSpcAlocPolPodVO.setSkdVoyNo(spcAlocPolPodVO[i].getNewSkdVoyNo() );
					deleteSpcAlocPolPodVO.setSkdDirCd(spcAlocPolPodVO[i].getNewSkdDirCd());					
					deleteSpcAlocPolPodVO.setNewVslVd(spcAlocPolPodVO[i].getNewVslVd());
									
					deleteVoList.add(deleteSpcAlocPolPodVO);
					
			}
			
			if ( motiVoList != null && motiVoList.size() > 0 ) {
//성수기 - aloc_cust_pol_pod 삭제, aloc_pol_pod 삭제, aloc_cust_pol_pod copy, aloc_pol_pod copy
//비수기 - aloc_pol_pod 삭제, aloc_pol_pod copy
				// 저장된 Data를 삭제
				if("Y".equals(grpAcct)){
					dbDao.removemultiSpaceAllocation0046ByRHQSmpList(deleteVoList);
				}
				dbDao.removemultiSpaceAllocation0046ByRHQList(deleteVoList);
				
				// 새로운 Data 입력
				if("Y".equals(grpAcct)){
					dbDao.addmultiSpaceAllocation0046ByRHQSmpList(motiVoList);
					//aloc_cust_his 입력
					dbDao.addmultiSpaceAllocation0046CustHis(motiVoList);
				}
				dbDao.addmultiSpaceAllocation0046ByRHQList(motiVoList);
			}				
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	



	
	/**
	 * TRD, SUB TRD, VVD, 주차에 해당하는 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageSummaryVO> searchStatusByVvd(ConditionVO conditionVO) throws EventException {
			
		try {

			return dbDao.searchStatusByVvd(conditionVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * TRD, SUB TRD, OFC, 주차에 해당하는 항차들의 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageSummaryVO> searchStatusByLofc(ConditionVO conditionVO) throws EventException {
			
		try {

			return dbDao.searchStatusByLofc(conditionVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033LaneRgstList(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033LanePortRgstList(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033VVDLaneRgstList(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033VVDLanePortRgstList(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033BSACapaList(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaByPort(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocation0033BSACapaByPort(searchSpaceAllocation0033LaneRgstVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033LaneRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchSpaceAllocation0033LaneRgstVO> insertVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> updateVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> deleteVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			for ( int i=0; i< searchSpaceAllocation0033LaneRgstVOs .length; i++ ) {
				
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				
				if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);					
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiSpaceAllocation0033LaneRgstList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiSpaceAllocation0033LaneRgstList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiSpaceAllocation0033LaneRgstList(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033LanePortRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchSpaceAllocation0033LaneRgstVO> insertVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> updateVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> deleteVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			for ( int i=0; i< searchSpaceAllocation0033LaneRgstVOs .length; i++ ) {
				
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				
				if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);					
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiSpaceAllocation0033LanePortRgstList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiSpaceAllocation0033LanePortRgstList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiSpaceAllocation0033LanePortRgstList(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033VVDLaneRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchSpaceAllocation0033LaneRgstVO> insertVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> updateVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> deleteVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			for ( int i=0; i< searchSpaceAllocation0033LaneRgstVOs .length; i++ ) {
				
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				
				if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);					
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiSpaceAllocation0033VVDLaneRgstList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiSpaceAllocation0033VVDLaneRgstList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiSpaceAllocation0033VVDLaneRgstList(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033VVDLanePortRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchSpaceAllocation0033LaneRgstVO> insertVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> updateVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			List<SearchSpaceAllocation0033LaneRgstVO> deleteVoList  = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
			for ( int i=0; i< searchSpaceAllocation0033LaneRgstVOs .length; i++ ) {
				
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				searchSpaceAllocation0033LaneRgstVOs[i].setUsrId(account.getUsr_id());
				
				if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);					
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				} else if ( searchSpaceAllocation0033LaneRgstVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchSpaceAllocation0033LaneRgstVOs[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiSpaceAllocation0033VVDLanePortRgstList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiSpaceAllocation0033VVDLanePortRgstList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiSpaceAllocation0033VVDLanePortRgstList(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Season 내 first version의 confirm시 Alloc 데이터 정리<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @exception EventException
	 */
	public void multiCustCtrlAlloc(SpcMdlVerMstVO spcMdlVerMstVO) throws EventException{
		try {
			//Season 내 first version의 적용 시작 주차 이후에 기입력되어 있는 Alloc을 조회합니다.
			List<SpcAlocCustPolPodVO> vo = dbDao.searchTargetCustAlloc(spcMdlVerMstVO);
			//조회대상을 삭제합니다.
			dbDao.deleteTargetCustAlloc(spcMdlVerMstVO);
			//조회해놓은 Alloc을 새 Season에 존재하는 그룹으로 변경하여 입력합니다.
			dbDao.addTargetCustAlloc(vo);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Customer Code 조회
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException {
		try {
			return dbDao.searchActualCustomer(searchActualCustomerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}


	
}
