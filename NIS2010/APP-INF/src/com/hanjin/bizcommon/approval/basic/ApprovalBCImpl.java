/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2015.04.14 심성윤 [CHM-201534125] 결재라인 체크 로직 추가
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
=========================================================*/
package com.hanjin.bizcommon.approval.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.bizcommon.approval.integration.ApprovalDBDAO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.approval.vo.ApPayInvVO;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalDeptVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryCondtionVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryVO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStepVO;
import com.hanjin.bizcommon.approval.vo.SearchApprovalVO;
import com.hanjin.bizcommon.approval.vo.UnApprovalCsrVO;
import com.hanjin.bizcommon.authorization.vo.AuthAproStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_0T1EventResponse,StaffBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ApprovalBCImpl extends BasicCommandSupport implements ApprovalBC {

	// Database Access Object
	private transient ApprovalDBDAO dbDao=null;
	/**
	 * StaffBCImpl 객체 생성<br>
	 * StaffDBDAO를 생성한다.<br>
	 */
	public ApprovalBCImpl(){
		dbDao = new ApprovalDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Staff 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
     * @return List<ApprovalStaffVO>
     * @throws EventException
	 */
	public List<ApprovalStaffVO> searchStaffList(ApprovalStaffVO approvalStaffVO) throws EventException {
		try {
        	return dbDao.searchStaffList(approvalStaffVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Staff List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Staff List"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Organization 화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param ApprovalStaffVO approvalStaffVO
     * @param SignOnUserAccount account
	 * @return List<ApprovalDeptVO>
	 * @exception EventException
	 */
	public List<ApprovalDeptVO> searchDeptList(ApprovalStaffVO approvalStaffVO, SignOnUserAccount account) throws EventException {
        try {
        	approvalStaffVO.setOfcCd(account.getOfc_cd());
        	return dbDao.searchDeptList(approvalStaffVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Dept List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Dept List"}).getMessage(), ex);
		}
	}
	
	/**
	 * 결재라인 체크 로직<br>
	 * CHM-201534125 심성윤(2015.04.14)<br>
	 * Approval Route 체크 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO 
	 * @param List<ComAproRqstRoutVO> comAproRqstRoutVOs
     * @return String
     * @throws EventException
	 */
	public String checkAproRouteReq(ApprovalCsrVO approvalCsrVO, List<ComAproRqstRoutVO> comAproRqstRoutVOs) throws EventException{
		 try {	        	
	        	return dbDao.checkApprovalReqRoute(approvalCsrVO, comAproRqstRoutVOs);
	        } catch (DAOException ex) {
	            log.error("err " + ex.toString(), ex);
	            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Dept List"}).getMessage(), ex);
	        } catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
	            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Dept List"}).getMessage(), ex);
			}		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Route화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
     * @return List<ApprovalRouteVO>
     * @throws EventException
	 */
	public List<ApprovalRouteVO> searchApprovalRouteList(ApprovalStaffVO approvalStaffVO) throws EventException {
		ApprovalRouteVO approvalRouteVO = null;
		try {
			//Route의 Sequence를 조회합니다.
			String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
			
			approvalRouteVO = new ApprovalRouteVO();
			approvalRouteVO.setAproRoutSeq(aproRoutSeq);
			
			return dbDao.searchApprovalRouteList(approvalRouteVO);            
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Route List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Route List"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @param ApprovalRouteVO[] approvalRouteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveApprovalRoute(ApprovalStaffVO approvalStaffVO, ApprovalRouteVO[] approvalRouteVOs, SignOnUserAccount account) throws EventException {
		ApprovalRouteVO approvalRouteVO = null;
		try {
        	approvalStaffVO.setUsrId(account.getUsr_id());
        	//모듈과 오피스로 기본결재라인헤더의 Sequence를 조회합니다.
        	String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
        	

        	if(!"".equals(aproRoutSeq)) {
	        	approvalRouteVO = new ApprovalRouteVO();
				approvalRouteVO.setAproRoutSeq(aproRoutSeq);
				approvalRouteVO.setUsrId(account.getUsr_id());   
				//기본결재라인 헤더의 업데이트 이력입니다
	        	dbDao.modifyApprovalRoute(approvalRouteVO);
	        	//기본결재라인 디테일의 승인권자정보를 삭제한다
	        	dbDao.removeApprovalRoute(approvalRouteVO);
        	} else {
        		//기본결재라인 헤더의 Sequence를 MAX(+1)로 생성합니다
        		aproRoutSeq = dbDao.createApprovalRouteSeq();
        		//기본결재라인 헤더 정보를 생성한다
        		dbDao.addApprovalRoute(aproRoutSeq, approvalStaffVO);
        	}
        	
        	List<ApprovalRouteVO> insertVoList = new ArrayList<ApprovalRouteVO>();
        	if(approvalRouteVOs != null) {
        		for ( int i=0; i<approvalRouteVOs.length; i++ ) {
        			approvalRouteVOs[i].setAproRoutSeq(aproRoutSeq);
        			approvalRouteVOs[i].setUsrId(account.getUsr_id());
        			insertVoList.add(approvalRouteVOs[i]);
        		}
        	}
        	if (insertVoList.size() > 0) {
        		//기본결재라인 디테일의 승인권자 정보를 생성한다 
        		dbDao.addApprovalRouteDetail(insertVoList);
        	}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Authorization Approval Route 저장 이벤트 처리<br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @param SearchAuthAproVO[] searchAuthAproVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void saveAuthApprovalRoute(AuthAproStaffVO authAproStaffVO, SearchAuthAproVO[] searchAuthAproVOs, SignOnUserAccount account) throws EventException{
		SearchAuthAproVO searchAuthAproVO = null;
		try {
			authAproStaffVO.setUsrId(account.getUsr_id());
        	//모듈과 오피스로 기본결재라인헤더의 Sequence를 조회합니다.
        	String authAproRoutSeq = dbDao.searchAuthApprovalRouteSeq(authAproStaffVO);
        	
        	if(!"".equals(authAproRoutSeq)) {
        		searchAuthAproVO = new SearchAuthAproVO();
        		searchAuthAproVO.setAuthAproRoutSeq(authAproRoutSeq);
        		searchAuthAproVO.setUsrId(account.getUsr_id());   
				//기본결재라인 헤더의 업데이트 이력입니다
	        	dbDao.modifyAuthApprovalRoute(searchAuthAproVO);
	        	//기본결재라인 디테일의 승인권자정보를 삭제한다
	        	dbDao.removeAuthApprovalRoute(searchAuthAproVO);
        	} else {
        		//기본결재라인 헤더의 Sequence를 MAX(+1)로 생성합니다
        		authAproRoutSeq = dbDao.createAuthApprovalRouteSeq();
        		//기본결재라인 헤더 정보를 생성한다
        		dbDao.addAuthApprovalRoute(authAproRoutSeq, authAproStaffVO);
        	}
        	List<SearchAuthAproVO> insertVoList = new ArrayList<SearchAuthAproVO>();
        	
        	if(searchAuthAproVOs != null) {
        		for ( int i=0; i<searchAuthAproVOs.length; i++ ) {
        			searchAuthAproVOs[i].setAuthAproRoutSeq(authAproRoutSeq);
        			searchAuthAproVOs[i].setUsrId(account.getUsr_id());
        			insertVoList.add(searchAuthAproVOs[i]);
        		}
        	}
        	if (insertVoList.size() > 0) {
        		//기본결재라인 디테일의 승인권자 정보를 생성한다 
        		dbDao.addAuthApprovalRouteDetail(insertVoList);
        	}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route Request 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
     * @throws EventException
	 */
	public void saveApprovalRouteReq(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) throws EventException {
		String	aproRqstNo	   = "";
		String	csr_no	       = "";
		//String	aproRqstUsrId  = "";
		String  aproAllFlg	   = ""; 
		String  csr_apro_flg   = "";
		//String  apro_step_chk  = "";
		String  apro_ep_id	   = "";
		String  apro_usr_del_flg   = "Y";
		
		//JointOperationConsultationBC jooCommand = new JointOperationConsultationBCImpl();
		
		try {
			if(approvalCsrVO != null) {
				approvalCsrVO.setUsrId(account.getUsr_id());
				approvalCsrVO.setUsrNm(account.getUsr_nm());
				approvalCsrVO.setOfcCd(account.getOfc_cd());
				
				//결재요청헤더의 시컨스 찾기
				aproRqstNo = dbDao.searchAproRqstNo(approvalCsrVO);
				csr_no = approvalCsrVO.getCsrNo();
				
				//CSR의 결재라인이 모두완료 됐을 경우 체크
				csr_apro_flg =searchCheckApprovedCsr(csr_no);
	        	if(csr_apro_flg.equals("Y")){
					 throw new EventException(new ErrorHandler("CSR10020", new String[]{}).getMessage());
				}
				
				approvalCsrVO.setAproRqstNo(aproRqstNo);
				//결재요청헤더의 정보를 처음결재상신 상태로 업데이트 합니다
				dbDao.modifyApprovalReqHdr(approvalCsrVO);
				
				ApprovalUtil util = new ApprovalUtil();
				//결재요청디테일에 저장할 apro_step 정보를 저장하기위한 셋팅을 한다.
	        	ComAproRqstRoutVO[] route = util.convertApprovalRoute(approvalCsrVO.getAproStep());
	        	List<ComAproRqstRoutVO> insertVoList = new ArrayList<ComAproRqstRoutVO>();
	        	if(route != null) {
	        		for ( int i=0; i<route.length; i++ ) {
	        			route[i].setCreUsrId(account.getUsr_id());
	        			route[i].setUpdUsrId(account.getUsr_id());
	        			route[i].setAproRqstNo(aproRqstNo);
	        			insertVoList.add(route[i]);
	        		}
	        	}
	        	
	        	if (insertVoList.size() > 0) {
	        		//결제자 자기 자신을 결제라인에서 삭제했는지 체크
	        		//insertVoList에 자기 자신의 결제라이 없을 경우 삭제한 것으로 판단.
	        		//Approval Confirm 화면의 Edit Approval Step일 경우 로직 적용
	        		if(approvalCsrVO.getAproCfmScrnFlg().equals("Y")){
		        		apro_ep_id = searchCheckApprovalUserId(account.getUsr_id());
		        		for(int i=0; i<insertVoList.size(); i++){
		        			if(apro_ep_id.equals(insertVoList.get(i).getAproUsrId())){
			        			apro_usr_del_flg = "N";		        				
		        			}
		        		}

		        		if(apro_usr_del_flg.equals("Y")){
		        			throw new EventException(new ErrorHandler("COM12186", new String[]{}).getMessage());
		        		}
	        		}
	        		
	        		//기존 결재요청디테일 결재권자 삭제
		            dbDao.removeApprovalReqRoute(approvalCsrVO);
		            
		            //결재요청디테일 결재권자 입력 
		            dbDao.addApprovalReqRoute(insertVoList);
	        	}
	        	
	        	//결재완료 여부 검사
	        	aproAllFlg = dbDao.searchCheckAproAll(aproRqstNo);
	        	
	        	if(aproAllFlg.equals("Y")){
	        		throw new EventException(new ErrorHandler("CSR10018", new String[]{}).getMessage());
	        	}
	        	
	        	//CSR No Creation한 System Code검색.
	        	//String sysCd = dbDao.searchCsrSubSystem(csr_no);
	        	
	        	//10만불 이상/이하관련 결제라인 Validation
	        	//if(sysCd.equals("JOO")){
	        	//	apro_step_chk = jooCommand.searchApproveJOOSaveYn(csr_no,account.getUsr_id());
	        	//}else{
	        	//	aproRqstUsrId = dbDao.searchAproRqstUsr(csr_no);
	        	//	apro_step_chk = new ApprovalUtil().checkAproStepSts(csr_no,aproRqstUsrId);
	        	//}
//				log.error("\n\n saveApprovalRouteReq().checkAproStepSts csr_no : " + JSPUtil.getNull(csr_no) + " --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + " ======================= \n\n");
//				if (apro_step_chk!=null){
//					/**
//					 * P : 10만불 이상인데 PDT 미지정
//					 * M : 10만불 이하인데 본부장 미지정
//					 * K : Approval Step PDT/본부장 포함 2단계 이하인 경우
//					 * E : 오류
//					 * I : CEO는 항상 제일 뒤에 위치하는지 검사 
//					 * Y : 정상
//					 * X : [2014-07,08] PDT 지시 시항 적용 대상이 아님
//					 * F : PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT/본부장 결재 우회 허용 
//					 * C : 운하통과료 (SO_PORT) -> 결재자 상관없이 무조건 통과 요청
//					 */
//					if (apro_step_chk.trim().equals("P")){
//						throw new EventException(new ErrorHandler("CSR10011", new String[]{}).getMessage());
//					} else if (apro_step_chk.trim().equals("M")){
//						throw new EventException(new ErrorHandler("CSR10012", new String[]{}).getMessage());
//					} else if (apro_step_chk.trim().equals("K")){
//						throw new EventException(new ErrorHandler("CSR10014", new String[]{}).getMessage());
//					} else if (apro_step_chk.trim().equals("E")){
//						throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
//					} else if (apro_step_chk.trim().equals("I")){
//						throw new EventException(new ErrorHandler("CSR10019", new String[]{}).getMessage());
//					} else if (
//							   apro_step_chk.trim().equals("Y") // 정상
//							|| apro_step_chk.trim().equals("X") // 대상아님(적용전CSR들)
//							|| apro_step_chk.trim().equals("F") // PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT결재 우회 허용
//							|| apro_step_chk.trim().equals("C") // (SO_PORT용) 운하통과료는 우회 허용
//							   )
//					{
//						log.error("\n >>>>>>>>>>>>>>>>>>>>> --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + "   [PASS] csr_no: " + JSPUtil.getNull(csr_no) + " <<<<<<<<<<<<<<<<<<<<< \n");
//					} else {
//						throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());					
//					}				
//				} else {
//					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
//				}
	        	
	        	//AP_INV_HDR(CSR ERP AP Interface 테이블) ATTR_CTNT1(결제자정보) UPDATE 
	        	dbDao.modifyApInvHdr(approvalCsrVO);
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route Request"}).getMessage(), ex);
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route Request"}).getMessage(), ex);    
		}
	}
	
	/**
	 * 결재라인 검색<br>
	 * 결재라인 지정 시 디폴트 값 확인 <br>
	 * CHM-201534125 심성윤 (2015.04.14) <br>
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
	 * @return String
     * @throws EventException
	 */
	public String checkApprovalRouteReq(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) {

		String  chkApproval = "";
		String  aproChkRst = "";
		
		try {
			if (approvalCsrVO != null) {
				approvalCsrVO.setUsrId(account.getUsr_id());
				approvalCsrVO.setUsrNm(account.getUsr_nm());
				approvalCsrVO.setOfcCd(account.getOfc_cd());

				ApprovalUtil util = new ApprovalUtil();
				// 결재요청디테일에 저장할 apro_step 정보를 저장하기위한 셋팅을 한다.
				ComAproRqstRoutVO[] route = util.convertApprovalRoute(approvalCsrVO.getAproStep());
				List<ComAproRqstRoutVO> checkVoList = new ArrayList<ComAproRqstRoutVO>();
				if (route != null) {
					for (int i = 0; i < route.length; i++) {
						route[i].setCreUsrId(account.getUsr_id());
						route[i].setUpdUsrId(account.getUsr_id());
						checkVoList.add(route[i]);
					}
				}
				if (checkVoList.size() > 0) {
					chkApproval = dbDao.checkApprovalReqRoute(approvalCsrVO,checkVoList);
					log.error("\n"+"   >>>>>>>>" + chkApproval);
					if (!(chkApproval != null && chkApproval.trim().equals("Y"))) {
						//throw new EventException(new ErrorHandler("CSR10027",new String[] {}).getMessage());
						aproChkRst = "X"; //결재자 지정 자유도 부여
					}else{
						aproChkRst = "Y"; //디폴트 결재자 전부 포함 해야한다
					}//if-else
				}else{
					aproChkRst = "X";
				}//if-else
			} else {
				// exception
				aproChkRst = "X";
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            aproChkRst = "E";            
            //throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route Request"}).getMessage(), ex);
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            aproChkRst = "E";            
           // throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            aproChkRst = "E";            
          //  throw new EventException(new ErrorHandler("COM12203", new String[]{"Save Approval Route Request"}).getMessage(), ex);    
		}
		return aproChkRst;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 부서모듈 사용자별 기본결재라인(COM_APRO_ROUT_DFLT_DTL) 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<SearchApprovalVO>
	 * @exception EventException
	 */
	public List<SearchApprovalVO> searchApproval(ApprovalStaffVO approvalStaffVO) throws EventException {
        try {
            if(approvalStaffVO.getCsrNo() != null && !"".equals(approvalStaffVO.getCsrNo())) {
            	return dbDao.searchApprovalByCsrNo(approvalStaffVO);
        	} else {
        		//Route의 Sequence를 조회합니다.
        		String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
        		approvalStaffVO.setAproRoutSeq(aproRoutSeq);
        		return dbDao.searchApprovalByAproRouteSeq(approvalStaffVO);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 부서모듈 사용자별 기본Auth결재라인(COM_AUTH_APRO_DFLT_ROUT_USR) 목록을 조회합니다.<br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @return List<AuthAproStaffVO>
	 * @throws EventException
	 */
	public List<AuthAproStaffVO> searchAuthApproval(AuthAproStaffVO authAproStaffVO) throws EventException {
        try {
           
        		//Route의 Sequence를 조회합니다.
        		String authAproRoutSeq = dbDao.searchAuthApprovalRouteSeq(authAproStaffVO);
        		authAproStaffVO.setAuthAproRoutSeq(authAproRoutSeq);
        		return dbDao.searchAuthApprovalByAuthAproRouteSeq(authAproStaffVO);
        	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Csr화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @param SignOnUserAccount account
     * @return List<ApprovalCsrVO>
     * @throws EventException
	 */
	public List<ApprovalCsrVO> searchApprovalCsrList(ApprovalStaffVO approvalStaffVO, SignOnUserAccount account) throws EventException {
		try {
			approvalStaffVO.setUsrId(account.getUsr_id());
        	return dbDao.searchApprovalCsrList(approvalStaffVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Csr화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AuthorizationAproVO authorizationAproVO
	 * @param SignOnUserAccount account
     * @return List<AuthorizationAproVO>
     * @throws EventException
	 */
	public List<AuthorizationAproVO> searchAuthApprovalList(AuthorizationAproVO authorizationAproVO, SignOnUserAccount account) throws EventException {
		try {
			//authorizationAproVO.setUsrId(account.getUsr_id());
        	return dbDao.searchAuthApprovalList(authorizationAproVO, account);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * OFC_CD로 OFC_TP_CD를 조회한다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcTpCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfcTpCd(ofcCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * Approval Inquery 화면에 RHQ OFFICE COMBO CODE LIST조회.<br>
	 *
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCdList() throws EventException {
		try {
			return dbDao.searchRhqOfcCdList();
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * Approval Inquery 화면에 OFFICE COMBO CODE LIST조회.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCdList(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfcCdList(ofcCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * Approval Inquery 화면에서 RHQ콤보 변경시 OFFICE COMBO CODE LIST조회.<br>
	 *
	 * @param String rhqOfcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCdListByRhq(String rhqOfcCd) throws EventException {
		try {
			return dbDao.searchOfcCdListByRhq(rhqOfcCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 MODULE CODE LIST조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return String
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthSubSysCdList(AuthorizationInquiryVO authorizationInquiryVO) throws EventException {
		List<AuthorizationInquiryVO> responseData = new ArrayList<AuthorizationInquiryVO>(); 
		try {
			responseData = dbDao.searchAuthSubSysCdList(authorizationInquiryVO);
			return responseData;
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 MODULE CODE LIST조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthPgmNmList(AuthorizationInquiryVO authorizationInquiryVO) throws EventException {
		List<AuthorizationInquiryVO> responseData = new ArrayList<AuthorizationInquiryVO>(); 
		try {
			responseData = dbDao.searchAuthPgmNmList(authorizationInquiryVO);
			return responseData;
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Approval 조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthAproInquiry(AuthorizationInquiryVO authorizationInquiryVO) throws EventException {
		List<AuthorizationInquiryVO> responseData = new ArrayList<AuthorizationInquiryVO>(); 
		try {
			responseData = dbDao.searchAuthAproInquiry(authorizationInquiryVO);
			return responseData;
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Csr화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalInqueryCondtionVO approvalInqueryCondtionVO
	 * @param SignOnUserAccount account
     * @return List<ApprovalInqueryVO>
     * @throws EventException
	 */
	public List<ApprovalInqueryVO> searchApprovalInqueryCsrList(ApprovalInqueryCondtionVO approvalInqueryCondtionVO, SignOnUserAccount account) throws EventException {
		try {
			approvalInqueryCondtionVO.setUsrId(account.getUsr_id());
        	return dbDao.searchApprovalInqueryCsrList(approvalInqueryCondtionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Inquery List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Inquery List"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 현 결재자 정보를 조회한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return ComAproRqstRoutVO
     * @throws EventException
	 */
	public ComAproRqstRoutVO searchApprovalCurCsrRoute(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
			return dbDao.searchApprovalCurCsrRoute(approvalCsrVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Current CSR Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Current CSR Route"}).getMessage(), ex);
		}
	}
	
	/**
	 * 후결 처리 가능한 Approval Route 인지 검사
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean chkUrgPayFlgAproRout(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
        	return dbDao.chkUrgPayFlgAproRout(approvalCsrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Urgent Payment Approval Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Urgent Payment Approval Route"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 최종 결재 여부를 체크한다 - 최종 결재시에만 CSR AP전송  <br>
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchLastApprovalRoute(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
        	return dbDao.searchLastApprovalRoute(approvalCsrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Last Approval Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Last Approval Route"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 기결재 완료 여부 파악 - 중복 결재 피하기 위함<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchApprovalCompletion(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
			return dbDao.searchApprovalCompletion(approvalCsrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Completion"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Completion"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Confirm Approval 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
     * @throws EventException
	 */
	public void confirmApproval(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) throws EventException {
		//String titleName   = account.getUsr_nm();	//title_name - 결재자 본인
		String csrNo	   = approvalCsrVO.getCsrNo();
		String invSubSysCd = approvalCsrVO.getInvSubSysCd();	//분기처리용
		String subSysCd = approvalCsrVO.getSubSysCd();	//분기처리용
		String newGlDt	   = "";
		
		boolean bComplete = false;
		//boolean bUrgPay = false; 
				
        try { 
        	//결재자 지정을 GW에서 하므로 정보를 업데이트 할수 없다.(2014.10.16)
        	//결재요청 테이블의 해당 결재권자 결재상태를 완료처리한다
        	dbDao.modifyConfirmRqstRout(approvalCsrVO); // 현결재자 결재 처리 -> COM_APRO_RQST_ROUT의 APSTS_CD = 'C'처리 및 APRO_DT 설정
        	//결재요청 테이블의 결재권자 모두의 결재상태를 체크하여 더이상 결재할 데이타가 없다면 결재요청헤더 테이블의 결재상태를 '완료'로 업데이트한다
        	log.error("APROBCIMPL.confirmApproval COM_APRO_RQST_ROUT update");
        	
			/**
			 * 10만불이상 후결일 경우에는 최종결재 바로 전에서만 결재완료처리 및 A/P로 I/F한다.--> 후결기능 사용안함
			 */
        	
        	//bUrgPay = dbDao.chkUrgPayFlgAproRout(approvalCsrVO);
        	
        	bComplete = dbDao.searchApprovalCompleteCount(approvalCsrVO); //COM_APRO_RQST_ROUT를 통해 APRO_STS가 NULL인 경우를 COUNT해서 NULL인게 존재하면 FALSE...
			log.error("\n\n ## APROBCIMPL.confirmApproval -- "
					+ " / usr_id : " + (account!=null?JSPUtil.getNull(account.getUsr_id()):"")
					+ " / csr_no : " + (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"")
					+ " / bComplete : " + JSPUtil.getNull(bComplete) 
					+ " / invSubSysCd : " + JSPUtil.getNull(invSubSysCd) 
					+ " / subSysCd : " + JSPUtil.getNull(subSysCd) 
					//+ " / bUrgPay : " + JSPUtil.getNull(bUrgPay)
					+ " / aproRqstSeq : " + (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getAproRqstSeq()):"")
					+ " <<<<<<<<<<<<<<< \n\n");
        	
//        	if (bUrgPay){
//        		bComplete = bUrgPay; // 후결이면 완료처리하고 넘어간다.
//        		dbDao.modifyConfirmRqstRestOfRout(approvalCsrVO); // 후결 처리시 현단계 이후의 모든 결재선 완료처리 
//        	}
        	
        	if(bComplete) {
        		//결재요청 테이블의 결재권자가 모두 결재를 하였다면 결재요청헤더 테이블의 결재상태를 완료로 업데이트한다
        		dbDao.modifyConfirmRqstHdrC(approvalCsrVO); //COM_APRO_RQST_HDR에서 APSTS_CD를 'C'로 처리
        	} else {
        		//결재요청 테이블의 결재권자가 모두 결재를 하지 않았다면 결재요청헤더 테이블의 결재상태를 진행으로 업데이트한다
        		dbDao.modifyConfirmRqstHdrP(approvalCsrVO); //COM_APRO_RQST_HDR에서 APSTS_CD를 'P'로 처리 및 CRNT_APRO_SEQ <-- (CRNT_APRO_SEQ+1)로 update한다.
        	}
        	
        	//Urgent Payment flag update add 2014.07.11
//        	dbDao.modifyUrgentPayment(approvalCsrVO); //김영신 ssn : 본 기능을 SC앞단으로 이동함
        	
			//CSR 모듈 분기처리
        	if(bComplete) {
				if(subSysCd.equals("MNR")  || subSysCd.equals("TLL") || subSysCd.equals("LSE") || subSysCd.equals("PSO") || subSysCd.equals("CHS") || subSysCd.equals("MGS") || subSysCd.equals("CNI")){
					//해당 CSR의 정보를 조회하여 상태정보를 P(A/P Interfaced) 로 셋팅한다
					//List<ApPayInvVO> soModels = dbDao.searchSO(approvalCsrVO);
		        	//GL_DT 의 실시간 데이타를 구해온다
					ApPayInvVO gldtModel = dbDao.checkUpdateRevVVD(approvalCsrVO); // AP_INV_HDR를 통해 신규GL_DT를 구함
					
					newGlDt  = gldtModel.getNewGlDt();
					
					//if(bComplete) {
						// 최종 승인자 정보 및 GL_DT 정보를 CSR ERP AP Interface 테이블로 업데이트한다
						dbDao.modifyApprovalStep2(csrNo, newGlDt); //AP_INV_HDR에 신규GL_DT 설정 및 Sending... 표시처리
						// CSR관리 테이블(AP_PAY_INV) 의 상태를 P(A/P Interfaced) 로 업데이트 한다
						//dbDao.modifyStsCdPayInv(soModels);
					//}
				}
        	}
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Confirm Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * GW 전송 Confirm Approval 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void confirmApprovalGW(ApprovalCsrVO approvalCsrVO) throws EventException {
		String titleName   = approvalCsrVO.getUsrNm();	//title_name - 결재자 본인
		String csrNo	   = approvalCsrVO.getCsrNo();
		String invSubSysCd = approvalCsrVO.getInvSubSysCd();	//분기처리용
		String newGlDt	   = "";
				
        try { 
        	
			//CSR 모듈 분기처리
			if(invSubSysCd.equals("MNR")  || invSubSysCd.equals("TLL") || invSubSysCd.equals("LSE") || invSubSysCd.equals("PSO") || invSubSysCd.equals("CHS") || invSubSysCd.equals("MGS") || invSubSysCd.equals("CNI")){
				//해당 CSR의 정보를 조회하여 상태정보를 P(A/P Interfaced) 로 셋팅한다
				List<ApPayInvVO> soModels = dbDao.searchSO(approvalCsrVO);
	        	//GL_DT 의 실시간 데이타를 구해온다
				ApPayInvVO gldtModel = dbDao.checkUpdateRevVVD(approvalCsrVO); // AP_INV_HDR를 통해 신규GL_DT를 구함
				
				newGlDt  = gldtModel.getNewGlDt();
				
				// 최종 승인자 정보 및 GL_DT 정보를 CSR ERP AP Interface 테이블로 업데이트한다
				dbDao.modifyApprovalStep(titleName, csrNo, newGlDt); //AP_INV_HDR에 신규GL_DT 설정 및 Sending... 표시처리
				// CSR관리 테이블(AP_PAY_INV) 의 상태를 P(A/P Interfaced) 로 업데이트 한다
				dbDao.modifyStsCdPayInv(soModels);
			}
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"G/W Confirm Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"G/W Confirm Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route Reject 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void rejectApproval(ApprovalCsrVO approvalCsrVO) throws EventException {
		String subSysCd = "";
		try {
			//결재자정보를 처음부터 저장하지 않으므로 업데이트 부분을 처리하지 않는다.
			//결재요청 결재권자 테이블의 해당 결재권자 결재상태를 반려처리한다 
			dbDao.modifyRejectAproRqstRout(approvalCsrVO);
			//결재요청헤더 테이블의 결재상태를 반려처리한다
			dbDao.modifyRejectAproRqstHdr(approvalCsrVO);
			
			subSysCd = approvalCsrVO.getSubSysCd();
			if(subSysCd.equals("MNR") || subSysCd.equals("TLL") || subSysCd.equals("LSE") || subSysCd.equals("PSO") || subSysCd.equals("CHS") || subSysCd.equals("MGS") || subSysCd.equals("CNI")){
				//승인권자가 Reject 할 경우 CSR관리 테이블(AP_PAY_INV)의 INVOICE 진행상태를 반려로 업데이트한다
				dbDao.modifyRejectApPayInv(approvalCsrVO);
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Reject"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Reject"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * G/W Approval Route Reject 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void rejectApprovalGW(ApprovalCsrVO approvalCsrVO) throws EventException {
		String subSysCd = "";
		try {		
			subSysCd = approvalCsrVO.getSubSysCd();
			if(subSysCd.equals("MNR") || subSysCd.equals("TLL") || subSysCd.equals("LSE") || subSysCd.equals("PSO") || subSysCd.equals("CHS") || subSysCd.equals("MGS") || subSysCd.equals("CNI")){
				//승인권자가 Reject 할 경우 CSR관리 테이블(AP_PAY_INV)의 INVOICE 진행상태를 반려로 업데이트한다
				dbDao.modifyRejectApPayInv(approvalCsrVO);
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"G/W Approval Reject"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"G/W Approval Reject"}).getMessage(), ex);
		}
	}
	
	/**
     * COM_CSR_0008 View Approval Step 버튼 -> COM_ENS_0W1 팝업 조회 이벤트 처리<br>
     * Approval Step 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return List<ApprovalStepVO>
     * @throws EventException
	 */
	public List<ApprovalStepVO> searchApprovalStepList(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
			return dbDao.searchApprovalStepList(approvalCsrVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Step List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Step List"}).getMessage(), ex);
		}
	}
	
    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Search BackendJob Status"}).getMessage(), ex);
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Confirm Approval Remark 수정 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @exception EventException	
	 */
	public void confirmApprovalRemark(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
			dbDao.confirmApprovalRemark(approvalCsrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12208", new String[]{"Confirm Approval Remark"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12208", new String[]{"Confirm Approval Remark"}).getMessage(), ex);
		}
	}
	
	/**
	 * cancelApproval<br>
	 *
	 * @param String csr_no
	 * @exception EventException
	 */	
	public void cancelApproval(String csr_no) throws EventException {
		try {
			dbDao.cancelApproval(csr_no);
		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다..<br>
	 * 
	 * @author ds ham
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRHQOfficeList() throws EventException {
		try {
			
			return dbDao.searchARRHQOfficeList();
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OFFICE CODE를 조회한다..<br>
	 * 
	 * @author ds ham
	 * @param UnApprovalCsrVO unApprovalCsrVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSelOfficeList(UnApprovalCsrVO unApprovalCsrVO) throws EventException {
		try {
			
			return dbDao.searchSelOfficeList(unApprovalCsrVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR의 결재권자가 미승인된 내역을 조회한다.<br>
	 * 
	 * @param UnApprovalCsrVO unApprovalCsrVO
     * @return List<UnApprovalCsrVO>
     * @throws EventException
	 */
	public List<UnApprovalCsrVO> searchUnApprovalCsrList(UnApprovalCsrVO unApprovalCsrVO) throws EventException {
		try {
        	return dbDao.searchUnApprovalCsrList(unApprovalCsrVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval CSR List"}).getMessage(), ex);
		}
	}
	
	/**
	 * OFC_CD로 RHQ_OFC_CD를 조회한다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCdByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchRhqOfcCdByOfcCd(ofcCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 결재시에 Invoice 존재 여부 체크  <br>
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchInvoice(ApprovalCsrVO approvalCsrVO) throws EventException {
		try {
        	return dbDao.searchInvoice(approvalCsrVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Last Approval Route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Last Approval Route"}).getMessage(), ex);
		}
	}
	
	/**
     * Edit Approval Step시 Del버튼 Validation<br>
     * Approval 된 결제자에 대한 Validation.<br>
	 *
	 * @param csr_no String
	 * @param apro_rqst_seq String
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckApprovedStep(String csr_no, String apro_rqst_seq ) throws EventException{
		String apro_flg = "";
		try {
			apro_flg =  dbDao.searchCheckApprovedStep(csr_no,apro_rqst_seq);
			
			if(apro_flg.equals("N")){
				 throw new EventException(new ErrorHandler("CSR10017", new String[]{}).getMessage());
			}
			
		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
		return apro_flg;
	}
	
	
	/**
     * Add버튼 클릭시 CSR Approved된 건은 결재라인 추가 못하도록 한다.<br>
     * COM_ENS_0T1
	 *
	 * @param csr_no String
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckApprovedCsr(String csr_no) throws EventException{
		String if_flg = "";
		try {
			if_flg =  dbDao.searchCheckApprovedCsr(csr_no);
			if(if_flg.equals("Y")){
				 throw new EventException(new ErrorHandler("CSR10020", new String[]{}).getMessage());
			}
			
		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
		return if_flg;
	}
	
	
	/**
     * Approval시 결재자가 Approval Step에 존재유무 체크.<br>
     * COM_ENS_0U1
	 *
	 * @param sLoginUsrId String
	 * @return String
	 * @throws EventException
	 */
	public String searchAproUsrId(String sLoginUsrId) throws EventException{

		try {
			return   dbDao.searchAproUsrId(sLoginUsrId);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}

	}
	
	/**
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 *
	 * @param authorizationAproVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAuthApproval(AuthorizationAproVO authorizationAproVO) throws EventException{

		try {
			return   dbDao.checkAuthApproval(authorizationAproVO);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}

	}
	

	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Disapprove 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void updateAuthDisaproRout(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.updateAuthDisaproRout(authorizationAproVO);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
	}
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Disapprove 버튼 클릭시 Disapprove 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void disaproAuthApproval(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.disaproAuthApproval(authorizationAproVO);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
	}
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  RQST Rmk 저장 이벤트 처리<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void saveAuthRqstRmk(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.saveAuthRqstRmk(authorizationAproVO);

		} catch (DAOException e) {
          log.error("err "+e.toString(),e);
          throw new EventException(e.getMessage());
		} catch (Exception e) {
          log.error("err "+e.toString(),e);
          throw new EventException(e.getMessage());
		}
	}
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void updateAuthAproRout(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.updateAuthAproRout(authorizationAproVO);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
	}
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void confirmAuthAproFinal(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.confirmAuthAproFinal(authorizationAproVO);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}
	}
	
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 중간결재 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void confirmAuthAproProgress(AuthorizationAproVO authorizationAproVO) throws EventException{
		try {
			  dbDao.confirmAuthAproProgress(authorizationAproVO);

		} catch (DAOException e) {
          log.error("err "+e.toString(),e);
          throw new EventException(e.getMessage());
		} catch (Exception e) {
          log.error("err "+e.toString(),e);
          throw new EventException(e.getMessage());
		}
	}
	
	
	
    /**
     * COM_ENS_0T1화면 Loading시 User ID OR EP ID를 조회
     * Del버튼 클릭시 자기 자신의 결재라인을 지우지 못하게 한다.<br>
     * COM_ENS_0T1
     * @param usrId String
     * @return String
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.08.12
     */
	public String searchCheckApprovalUserId(String usrId) throws EventException{

		try {
			return   dbDao.searchCheckApprovalUserId(usrId);

		} catch (DAOException e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
		}

	}
	
	/**
	 * ASA 정보를 조회하고 CLOSE 상태이면 OPEN된 ASA NO으로 UPDATE
	 * @param csrNo
	 * @throws EventException
	 */
	public void checkAsaNo(String csrNo) throws EventException{
        String isOpen = "";
        String asaOfcCd = "";
        String asaNo = "";
        
		try {
			DBRowSet dbRowset = dbDao.searchAsaNoInfo(csrNo);
			  
			if (dbRowset.next()) {        	
	           	isOpen = dbRowset.getString("is_open");    
	           	asaOfcCd = dbRowset.getString("asa_ofc_cd");    
	        }
			
			log.error("\n\n isOpen ==> "+isOpen);
			if(isOpen.equals("C")){
				asaNo = dbDao.searchAsaNo(asaOfcCd);
				log.error("\n\n asaNo ==> "+asaNo);
				
				if(!asaNo.equals("")){
					asaNo = asaNo.substring(0,3)+asaNo.substring(6,10)+asaNo.substring(3,6);
					log.error("\n\n changed asaNo ==> "+asaNo);
					
					dbDao.updateAsaNo(asaNo, csrNo);
				}				
			}
			
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}		
	}
	
}