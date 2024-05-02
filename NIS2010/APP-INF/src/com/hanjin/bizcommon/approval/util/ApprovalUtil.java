/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : CommodityDBDAO.java
* @FileTitle : Commodity정보조회(공통 Popup)
* Open Issues :
* Change history :
* @LastModifyDate : 2006-08-03
* @LastModifier : sungseok, choi
* @LastVersion : 1.0
* 2006-08-03 sungseok, choi
* 1.0 최초 생성
* *----------------------------------------------------------
* History
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2014.12.18 김영신 [CHM-201433354] I/F ERROR 경우 결재권자 우회 로직 추가
=========================================================*/
package com.hanjin.bizcommon.approval.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBC;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.bizcommon.approval.integration.ApprovalDBDAO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.csrapproval.basic.ComCsrApprovalBC;
import com.hanjin.bizcommon.csr.csrapproval.basic.ComCsrApprovalBCImpl;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * ApprovalUtil <br>
 * Process ApprovalUtil <br>
 * 
 * @author sungseok, choi
 * @see 
 * @since J2EE 1.4
 */
public class ApprovalUtil {
	/**
     *  log 객체
     */
    protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
    
	/**
	 * ApprovalUtil 객체 생성<br>
	 */
	public ApprovalUtil() { }
	
	/**
	 * 현재 LOGIN USER가 현재 결재권자 여부 확인 <br>
	 * 
	 * @param csrNo
	 * @param loginUsrId
	 * @return String
	 * @throws DAOException
	 */
	public String checkCurrentApprovalUserYN(String csrNo, String loginUsrId) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.checkCurrentApprovalUserYN(csrNo, loginUsrId);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CSR 결재요청 정보 생성
	 * @param ComAproRqstHdrVO header
	 * @param ComAproRqstRoutVO[] route
	 * @param ComAproCsrDtlVO csr
	 * @throws Exception 
	 */
	public void saveCsrApro(ComAproRqstHdrVO header, ComAproRqstRoutVO[] route, ComAproCsrDtlVO csr) throws Exception {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		ComCsrApprovalBC csrCommand = new ComCsrApprovalBCImpl();	
		String csrNo = csr.getCsrNo();
		String subSyscd = null;
		
		try {
			String checkAproStepFlg = csrCommand.searchCheckAproStepFlg(csrNo);
			/* 심성윤 (2015.04.06)
			 * CHM-201535042_기안 중복방지
			 */
			subSyscd = header.getSubSysCd();
			log.error("\n"+JSPUtil.getNull(subSyscd)+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<-----");
			if(subSyscd != null && (subSyscd.trim().equals("JOO") || subSyscd.trim().equals("FMS") ||subSyscd.trim().equals("ACM")) ){
				checkAproStepFlg = "Y";
			} 
			if (checkAproStepFlg == null || !checkAproStepFlg.trim().equals("Y")) {
				 //EventException ex = new EventException();
				//log.error("***************오류*************");
				//log.error("APROVAL UTIL err");
				throw new Exception(csrNo + "<<<");
			} else {
				header.setCrntAproSeq(String.valueOf(route.length)); 
				String newAproNo = dbDao.searchNewAproRqstNo();
				header.setAproRqstNo(newAproNo);
				// 결재요청 헤더 정보를 생성합니다.
				dbDao.addApprovalHeader(header);

				List<ComAproRqstRoutVO> insertRoutList = new ArrayList<ComAproRqstRoutVO>();
				if (route != null) {
					for (int i = 0; i < route.length; i++) {
						route[i].setAproRqstNo(header.getAproRqstNo());
						route[i].setCreUsrId(header.getCreUsrId());
						insertRoutList.add(route[i]);
					}
				}
				// 결재요청 결재권자 정보를 생성합니다.
				dbDao.addApprovalRoute(insertRoutList);
				csr.setAproRqstNo(header.getAproRqstNo());
				// 결재요청 CSR상세내용 테이블 생성
				dbDao.addApprovalCsr(csr);
			}			
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 결재요청디테일에 저장할 apro_step 정보를 저장하기위한 셋팅을 한다.
	 * @param String apro_step
	 * @return COM_APRO_RQST_ROUT[]
	 * @throws Exception
	 */
	public ComAproRqstRoutVO[] convertApprovalRoute(String apro_step) throws Exception {
		
		ComAproRqstRoutVO[] route = null;
		
		try {
			if(apro_step != null && !apro_step.equals("")) {
				String[] arr_apro_step = apro_step.split(" - ");
				
				route = new ComAproRqstRoutVO[arr_apro_step.length];
				for(int i=0; i<arr_apro_step.length; i++) {
					String[] arr_unit_apro_step = arr_apro_step[i].split("/");
					
					route[i] = new ComAproRqstRoutVO();
					route[i].setAproRqstSeq(arr_unit_apro_step[0]);
					route[i].setAproUsrId(arr_unit_apro_step[1]);
					route[i].setAproUsrNm(arr_unit_apro_step[2]);
					route[i].setAproOfcCd(arr_unit_apro_step[3]);
					
					if(arr_unit_apro_step.length == 5)
						route[i].setAproUsrJbTitNm(arr_unit_apro_step[4]);
				}
			}
			
		} catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
		return route;
	}
	
	/**
	 * @param ofc_cd
	 * @param sub_sys_cd
	 * @return
	 * @throws Exception 
	 */
	public static String getApprovalRoute(String ofc_cd, String sub_sys_cd) throws Exception {
		
		ApprovalStaffVO approvalStaffVO =  new ApprovalStaffVO();
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			approvalStaffVO.setOfcCd(ofc_cd);
			approvalStaffVO.setSubSysCd(sub_sys_cd);
			
			String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
			
			if(!"".equals(aproRoutSeq)) {
				approvalRouteVO.setAproRoutSeq(aproRoutSeq);
			}
			list = dbDao.searchApprovalRouteUtilList(approvalRouteVO);
			
			for(int i=0; i < list.size(); i++){
				if(i != 0) {
					sRtn.append(" - ");
				}
				
				approvalRouteVO = list.get(i);
				
				sRtn.append(approvalRouteVO.getAproSeq());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrId());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrNm());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproOfcCd());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
			}
			
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
	/**
	 * 
	 * @param String ofc_cd
	 * @param String sub_sys_cd
	 * @return String
	 * @throws Exception
	 */
	public static String getApprovalRoute1(String ofc_cd, String sub_sys_cd) throws Exception {
		ApprovalStaffVO approvalStaffVO = new ApprovalStaffVO();
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			approvalStaffVO.setOfcCd(ofc_cd);
			approvalStaffVO.setSubSysCd(sub_sys_cd);
			
			String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
			
			if(!"".equals(aproRoutSeq)) {
				approvalRouteVO.setAproRoutSeq(aproRoutSeq);
			}
			list = dbDao.searchApprovalRouteUtilList(approvalRouteVO);
			
			for(int i=0; i < list.size(); i++){
				approvalRouteVO = list.get(i);
				
				if(approvalRouteVO.getAproUsrJbTitNm().equals("")){
					sRtn.append("");
				}else{
					sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
					sRtn.append("/");
				}
				sRtn.append(approvalRouteVO.getAproUsrNm());
				break;
			}
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
	
	/**
	 * CSR번호로 ApprovalStep을 조회한다.
	 * @param String csrNo
	 * @return String
	 * @throws Exception
	 */
	public static String getApprovalRouteByCsrNo(String csrNo) throws Exception {
		
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			list = dbDao.searchApprovalRouteListByCsrNo(csrNo);
			
			for(int i=0; i < list.size(); i++){
				if(i != 0) {
					sRtn.append(" - ");
				}
				
				approvalRouteVO = list.get(i);
				
				sRtn.append(approvalRouteVO.getAproSeq());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrId());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrNm());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproOfcCd());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
			}
			
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
	/**
	 * Approval Step 유효성 확인 (PDT 지시 사항)
	 * @param csr_no
	 * @param usr_id
	 * @return String
	 * @throws DAOException
	 */
	public String checkAproStepSts(String csr_no, String usr_id) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		String retval = null;
		
		try {
			if (csr_no!=null && !csr_no.trim().equals("") && usr_id!=null && !usr_id.trim().equals("")){
				retval = dbDao.checkAproStepSts(csr_no,usr_id);	
			} else {
				retval = "E";
			}
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retval;
	}
	
	/**
	 * 저장된 Approval Step 정보 지우기 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deltComAproStep(String csr_no) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			dbDao.deltComAproStepRout(csr_no);
			dbDao.deltComAproStepHdr(csr_no);
			dbDao.deltComAproStepDtl(csr_no);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * COM_CSR_0002 : CSR Create 버튼 <br>
	 * AP_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	 * 
	 * [CHM-201433354] PDT 우회처리 로직 추가
	 * @param csr_no
	 * @param ofc_cd
	 * @throws DAOException
	 */
	public void updateAproGwFlg(String csr_no, String ofc_cd) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		TCharterIOConsultationBC fmsCommand = new TCharterIOConsultationBCImpl();
		PayableRentalCostBC lseCommand = new PayableRentalCostBCImpl(); 
		ChsMgsSendGWAgreementInfoBC cgmCommand = new ChsMgsSendGWAgreementInfoBCImpl();
	    MnrSendGWAgreementInfoBC mnrCommand = new MnrSendGWAgreementInfoBCImpl();
		
		try {
			String csr_apro_tp_cd = dbDao.searchAproStepInfo(csr_no, "A"); 			//결재 구분 코드(AL,GW)
			String jb_tit_cd = dbDao.searchAproStepInfo(csr_no, "J");				//최종 결재자 구분 코드
			String ver_no = dbDao.searchAproStepInfo(csr_no, "V");					//버전 관리
			String csr_usd_amt = dbDao.searchAproStepInfo(csr_no, "U");				//환율 변경 금액(기준 테이블 참조)
			String acct_xch_rt_yrmon = dbDao.searchAproStepInfo(csr_no, "Y");		//GL_DT
			
			/*
			 * ALPS의 Agreement 문서 존재여부 : 문서가 존재하면 Y, 아니면 N
			 * ACM, JOO는 모듈에서 직접 전송 하기로 함
			 */
			String invSubSysCd = searchSubSysCd(csr_no);
			String agmtDocCfmCd = "";
			
			List<ComCsrRequestAgmtVO> agmtVos = null;
			
			if(invSubSysCd.equals("TES")){
				agmtVos = tesCommand.printComCsrAgmtInfo(csr_no);
			} else if(invSubSysCd.equals("TRS")){
				agmtVos = trsCommand.printComCsrAgmtInfo(csr_no);
			} else if("FMS".equals(invSubSysCd)){
				agmtVos = fmsCommand.printFmsCsrAgmtInfo(csr_no);
			} else if(invSubSysCd.equals("LSE")){
				agmtVos = lseCommand.printComCsrLseAgmtInfo(csr_no); 
			} else if(invSubSysCd.equals("MNR")) {
				agmtVos = mnrCommand.printComCsrAgmtInfo(csr_no);
			} else if(invSubSysCd.equals("CHS") || invSubSysCd.equals("MGS") || invSubSysCd.equals("CGM")){ 
				agmtVos = cgmCommand.printComCsrAgmtInfo(csr_no);
			}
			
			if(agmtVos != null && agmtVos.size() > 0) {
				agmtDocCfmCd = "Y";
			} else {
				agmtDocCfmCd = "N";
			}
			
			IfCsrListInputVO ifCsrListInputVO = new IfCsrListInputVO();
			ifCsrListInputVO.setCsrAproTpCd(csr_apro_tp_cd);
			ifCsrListInputVO.setAproUsrJbTitCd(jb_tit_cd);
			ifCsrListInputVO.setVerNo(ver_no);
			ifCsrListInputVO.setCsrUsdAmt(csr_usd_amt);
			ifCsrListInputVO.setAcctXchRtYrmon(acct_xch_rt_yrmon);
			ifCsrListInputVO.setOfcCd(ofc_cd);
			ifCsrListInputVO.setCsrNo(csr_no);
			ifCsrListInputVO.setAgmtDocCfmCd(agmtDocCfmCd);
			
			dbDao.updateAproGwFlg(ifCsrListInputVO);
			
			//PDT 우회처리 로직 추가
			String newAproJbtitCd = dbDao.searchNewAproJbTitCd(csr_no);
			
			if(newAproJbtitCd != null && !newAproJbtitCd.equals("")) {
				if(!newAproJbtitCd.equals("P") && !newAproJbtitCd.equals("B")) {
					dbDao.updateNewAproJbTitCd(csr_no, newAproJbtitCd);
				}
			}
			
			//P상태 업데이트
			dbDao.updateAproGwPassFlg(csr_no);
			
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * GW에서 결과 값 전송 <br>
	 * AP_INV_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param comCsrInfoVO
	 * @throws DAOException
	 */
	public void updateAproGwDt(ComCsrInfoVO comCsrInfoVO) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			dbDao.updateAproGwDt(comCsrInfoVO);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * GW에서 결과 값 전송<br>
	 * AP_INV_HDR 의  GW Url, Request_id 업데이트
	 * 
	 * @param csr_no
	 * @param request_id
	 * @param gw_url
	 * @throws DAOException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			dbDao.updateAproGwUrl(csr_no, request_id, gw_url);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * File Save Id로 File Size를 가져온다.
	 * 
	 * @param file_id
	 * @return String
	 * @throws DAOException
	 */
	public String searchFileSize(String file_id) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.searchFileSize(file_id);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * CSR_No로 SUB_SYS_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchSubSysCd(String csrNo) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.searchSubSysCd(csrNo);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Agreement Doc 존재여부를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchAgmtCfmCd(String csrNo) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			String retval = JSPUtil.getNull(dbDao.searchAgmtCfmCd(csrNo));
			
			log.error("dbDao.searchAgmtCfmCd ==>"+ JSPUtil.getNull(retval));
			//ERP 전송후 최종 업데이트
			dbDao.updateAproGwFnlPassFlg(retval, csrNo);
			
			return retval; 
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CSR 생성시의 Agreement 존재 여부 update <br>
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void updateAproGwPassFlg(String csr_no) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			dbDao.updateAproGwPassFlg(csr_no);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * GW xmlData 생성시 사용 <br>
	 * searchAgmtCfmCd는 다른 모듈에서 사용 및 update가 되므로 2를 생성해서 사용
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchAgmtCfmCd2(String csrNo) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.searchAgmtCfmCd2(csrNo);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 예외 오피스 처리 <br>
	 * CHM-201535264 비용결재권자 조정<br>
	 * yoo(2015.04.13)심성윤<br>
	 * 
	 * @param csrNo
	 * @param loginOfcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getExptOfc(String csrNo, String loginOfcCd) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.getExptOfc(csrNo, loginOfcCd);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 결재할지 말지 결정 <br>
	 * CHM-20153412  디폴트 체크할지 말지 결정<br>
	 * yoo(2015.04.13)심성윤<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String checkDftAproStepYN() throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			return dbDao.checkDftAproStepYN();
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * ExeActTpCd 구하고 update
	 * @param csrNo
	 * @return String
	 * @throws DAOException
	 */
	public String updateExeActTpCd(String csrNo) throws DAOException {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		String exe_act_tp_cd = null;
		
		try {
			exe_act_tp_cd = dbDao.searchExeActTpCd(csrNo);
			dbDao.updateExeActTpCd(csrNo, exe_act_tp_cd);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exe_act_tp_cd;
	}	

}
