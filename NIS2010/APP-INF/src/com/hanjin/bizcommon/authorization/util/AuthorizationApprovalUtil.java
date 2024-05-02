/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationApprovalUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015-07-08 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.util;

import java.util.List;

import com.hanjin.bizcommon.authorization.integration.AuthorizationDBDAO;
import com.hanjin.bizcommon.authorization.vo.AuthEmlSndVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * AuthorizationApprovalUtil <br>
 * Process AuthorizationApprovalUtil <br>
 * 
 * @author 심성윤
 * @see 
 * @since J2EE 1.4 
 */
public class AuthorizationApprovalUtil {
	/**
     *  log 객체
     */
    protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
    
	/**
	 * AuthorizationApprovalUtil 객체 생성<br>
	 */
	public AuthorizationApprovalUtil() { }
	
	
	
	/**
	 * Authorization 설정 정보 조회
	 * 
	 * @param  AuthorizationProgramInfoVO inputVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws Exception
	 */
	public List<AuthorizationProgramInfoVO> searchAuthPgmInfo(AuthorizationProgramInfoVO inputVO) throws Exception {
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			return dbDao.searchAuthPgmInfo(inputVO);			
		} catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * Transaction 완료 확인 여부 Update
	 * 
	 * @param String authAproRqstNo
	 * @throws DAOException
	 */	
	public void updateAuthAproCfm(String authAproRqstNo) throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			dbDao.updateAuthAproCfm(authAproRqstNo);
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 결재 정보 cancel처리 (TRS 요청)
	 * 
	 * @param String authAproRqstNo
	 * @throws DAOException
	 */
	public void cancelAuthApro(String authAproRqstNo) throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			dbDao.cancelAuthApro(authAproRqstNo);
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 동시 결재 확인 로직
	 * COM_ENS_0U1
	 * @param AuthorizationAproVO authorizationAproVO
	 * @return String
	 * @throws DAOException
	 */	
	public String checkAuthDuplApro(AuthorizationAproVO authorizationAproVO) throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			
			return dbDao.checkAuthDuplApro(authorizationAproVO);
			
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 결재시 액셀 결재인지 확인
	 * COM_ENS_0U1
	 * @param String authAproRqstNo
	 * @return String
	 * @throws DAOException
	 */	
	public String checkXlsApproval(String authAproRqstNo) throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			
			return dbDao.checkXlsApproval(authAproRqstNo);
			
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * E-mail SEQ 채번
	 * COM_ENS_0U1
	 * @return String
	 * @throws DAOException
	 */	
	public String searchAuthEmlSndSeq() throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			
			return dbDao.searchAuthEmlSndSeq();
			
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * E-mail 발송 컨텐츠 생성 페이지
	 * E-mail 객체 return
	 * 
	 * @param authAproRqstNo
	 * @param authEmlSndNoSeq
	 * @param account
	 * @param chkCd
	 * @return emlSndVO
	 * @throws DAOException
	 */
	public AuthEmlSndVO authRdyToSndEml(String authAproRqstNo, String authEmlSndNoSeq, SignOnUserAccount account, String chkCd) throws Exception {	
		AuthEmlSndVO emlSndVO = new AuthEmlSndVO();
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
//		ApprovalBC command = new ApprovalBCImpl();
		AuthorizationAproVO authorizationAproVO = new AuthorizationAproVO();

//		String checkFlg = "";
		try {
			
			//최종 결재 인지 진행중인지 확인
			authorizationAproVO.setAuthAproRqstNo(authAproRqstNo);
//			checkFlg = command.checkAuthApproval(authorizationAproVO);
			
//			log.error("\n>>>>>>>>>>>>결재진행확인코드authRdyToSndEml>>>>>checkFlg>>>"+checkFlg+"<<<<<<<<");	
			
			//String param = "ID - Email" 현재 Header Seq에 해당하는 결재자 정보 불러옴.
			String param = dbDao.searchAuthEmlRcvInit(authAproRqstNo);
			String[] arr_rcvr_info = param.split(" - ");
			String rcvUsrId = arr_rcvr_info[0];
			String rcvUsrEml = arr_rcvr_info[1];
			
			
			
			
    		
    		/*
    		 *  메일 내용
    		 */
			String retval1 = dbDao.searchAuthSndEmlPgm(authAproRqstNo); //기안정보
			String[] rqstInfoArr = retval1.split(" - ");
			String rqstRsn = dbDao.searchAuthRqstRsn(authAproRqstNo); //Request Reason
			List<AuthEmlSndVO> retList = dbDao.searchAuthSndEmlAproDtl(authAproRqstNo); //결재 정보
			StringBuffer sbContents = new StringBuffer();
			
			String emlSubject = "";//제목
			String emlContent = "";//본문
			
			if("P".equals(chkCd)){
				//결재 진행중
				emlSubject = "RQST for approval of excel download function - "+rqstInfoArr[2];
				emlContent = "Please allow me to access excel download function.";
				emlSndVO.setRcvrEml(rcvUsrEml); 	//받는 사람(결재자) ID
				emlSndVO.setEmlRcvUsrId(rcvUsrId);  //받는 사람(결재자) E-mail
				emlSndVO.setAuthEmlPurpCd("R"); //Request
				emlSndVO.setAuthEmlSndRsltCd("P"); //Processing
				emlSndVO.setEmlSndUsrId(account.getUsr_id());
				emlSndVO.setSndrEml(account.getUsr_eml());
				emlSndVO.setUsrId(account.getUsr_id());
				
			}else if("C".equals(chkCd)){
				//최종 결재
				emlSubject = "Approved of your excel download request";
				emlContent = "Your request has been approved."; //기안자에게 갈 문구
				emlSndVO.setEmlRcvUsrId(rqstInfoArr[0]); //기안자 ID
				emlSndVO.setRcvrEml(rqstInfoArr[5]);	 //기안자 E-mail
				emlSndVO.setAuthEmlPurpCd("A"); //Approve
				emlSndVO.setAuthEmlSndRsltCd("P"); //Processing
				emlSndVO.setEmlSndUsrId(account.getUsr_id());
				emlSndVO.setSndrEml(account.getUsr_eml());
				emlSndVO.setUsrId(account.getUsr_id());
			}else if("R".equals(chkCd)){
				//결재 기각
				emlSubject = "Rejected of your excel download request";
				emlContent = "Your request has been rejected."; //기안자에게 갈 문구
				emlSndVO.setEmlRcvUsrId(rqstInfoArr[0]); //기안자 ID
				emlSndVO.setRcvrEml(rqstInfoArr[5]);	 //기안자 E-mail
				emlSndVO.setAuthEmlPurpCd("D"); //Disapprove
				emlSndVO.setAuthEmlSndRsltCd("P"); //Processing
				emlSndVO.setEmlSndUsrId(account.getUsr_id());
				emlSndVO.setSndrEml(account.getUsr_eml());
				emlSndVO.setUsrId(account.getUsr_id());
			}
			
			
			sbContents.append("\n<html>");
			sbContents.append("\n<head>");
			sbContents.append("\n<title>"+emlSubject+"</title>");
			sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
			sbContents.append("\n</head>");
			sbContents.append("\n<body>");
			sbContents.append("\n<table width='800' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>");
			sbContents.append("\n	<tr>");
			sbContents.append("\n		<td valign='top'>");
			sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
			sbContents.append("\n			<tr>");
			sbContents.append("\n				<td>");
			sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
			sbContents.append("\n					<tr>");
			sbContents.append("\n						<td width='100%' colspan='2'>"+emlContent+"  </td>");//E-mail 컨텐츠
			sbContents.append("\n					</tr>");
			sbContents.append("\n				</table>");
			sbContents.append("\n				</td>");
			sbContents.append("\n			</tr>");
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//if("P".equals(chkCd)){
				sbContents.append("\n			<tr><td height='30'></td></tr>");
				sbContents.append("\n			<tr>");
				sbContents.append("\n				<td>");
				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='100%' colspan='2'>Request Info. </td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n				</table>");
				sbContents.append("\n				</td>");
				sbContents.append("\n			</tr>");
				sbContents.append("\n			<tr>");
				sbContents.append("\n				<td>");
				sbContents.append("\n				<table border='0' cellpadding='1' cellspacing='1' width='100%' style='background-color:#F3F2F8; border:1px solid #A3A4C7;'>");
				sbContents.append("\n					<tr height='25' align='center' style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>");
				sbContents.append("\n						<td width='20%'>RQST ID</td>");
				sbContents.append("\n						<td width='20%'>Name</td>");
				sbContents.append("\n						<td width='20%'>Module</td>");
				sbContents.append("\n						<td width='20%'>Menu</td>");
				sbContents.append("\n						<td width='20%'>RQST DT</td>");
				sbContents.append("\n					</tr>					");
				sbContents.append("\n					<tr height='23' style='background-color: #FFFFFF; color: #313131; text-align : center;'>");
				sbContents.append("\n						<td>"+rqstInfoArr[0]+"</td>");
				sbContents.append("\n						<td>"+rqstInfoArr[1]+"</td>");
				sbContents.append("\n						<td>"+rqstInfoArr[2]+"</td>");
				sbContents.append("\n						<td>"+rqstInfoArr[3]+"</td>");
				sbContents.append("\n						<td>"+rqstInfoArr[4]+"</td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n				</table>");
				sbContents.append("\n				<tr><td height='10'></td></tr>");
				sbContents.append("\n				<tr>");
				sbContents.append("\n				<td>");
				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='100%' colspan='2'>Request Process </td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n				</table>");
				sbContents.append("\n				</td>");
				sbContents.append("\n			</tr>");
				sbContents.append("\n				<table border='0' cellpadding='1' cellspacing='1' width='100%' style='background-color:#F3F2F8; border:1px solid #A3A4C7;'>");
				sbContents.append("\n					<tr height='25' align='center' style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>");
				sbContents.append("\n						<td width='20%'>SEQ</td>");
				sbContents.append("\n						<td width='20%'>Approval ID</td>");
				sbContents.append("\n						<td width='20%'>Name</td>");
				sbContents.append("\n						<td width='20%'>Approved</td>");
				sbContents.append("\n						<td width='20%'>Rejected</td>");
				sbContents.append("\n					</tr>");
				
				for (int i = 0; i < retList.size(); i++) {				
					// 조회 정보를 꺼내서 파라미터 세팅
					
					String key1 = JSPUtil.getNull(retList.get(i).getAuthAproRqstRoutSeq());
					String key2 = JSPUtil.getNull(retList.get(i).getAuthAproUsrId());
					String key3 = JSPUtil.getNull(retList.get(i).getAuthAproUsrNm());
					String key4 = JSPUtil.getNull(retList.get(i).getAuthAproDt());
					String key5 = JSPUtil.getNull(retList.get(i).getAuthRjctDt());
			
					sbContents.append("\n					<tr height='23' style='background-color: #FFFFFF; color: #313131; text-align : center;'>");
					sbContents.append("\n						<td>"+key1+"</td>");
					sbContents.append("\n						<td>"+key2+"</td>");
					sbContents.append("\n						<td>"+key3+"</td>");
					sbContents.append("\n						<td>"+key4+"</td>");
					sbContents.append("\n						<td>"+key5+"</td>");
					sbContents.append("\n					</tr>");
					
				}
				sbContents.append("\n				</table>");
				sbContents.append("\n				</td>");
				sbContents.append("\n			</tr>");
			//}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			sbContents.append("\n		</table>");		
			sbContents.append("\n		</td>");
			sbContents.append("\n	</tr>");
			sbContents.append("\n</table>");
			sbContents.append("\n<input type='hidden' name='auth_apro_rqst_no' value ="+JSPUtil.getNull(authAproRqstNo)+" />");
			sbContents.append("\n<input type='hidden' name='auth_eml_snd_no_seq' value ="+JSPUtil.getNull(authEmlSndNoSeq)+" />");
			sbContents.append("\n</body>");
			sbContents.append("\n</html>");
			
			
			
			emlSndVO.setAuthAproRqstNo(JSPUtil.getNull(authAproRqstNo));
			
			
			//e-mail 시퀀스 채번
			//authEmlSndNoSeq = dbDao.searchAuthEmlSndSeq();
			emlSndVO.setAuthEmlSndNo(authEmlSndNoSeq);
			emlSndVO.setEmlSubjCtnt(emlSubject);
			emlSndVO.setEmlCtnt(sbContents.toString());
			emlSndVO.setEmlSndRsltRmk(rqstRsn); //Request Reason
			
			//생성
			dbDao.createAuthEmlSnd(emlSndVO);
			
			log.error("\n------------------------------------------------------------------");
			log.error("\n>>>>>>>>>>emlSndVO>>>>>>>"+emlSndVO.toString()+"<<<<<<<<<<<<<<<");
			log.error("\n------------------------------------------------------------------");
			
			
			return emlSndVO;
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 메일 발송 로직.
	 * COM_ENS_0U1
	 * @param AuthEmlSndVO emlSndVO
	 * @return String
	 * @throws DAOException
	 */	
	public String authSndEml(AuthEmlSndVO emlSndVO) throws Exception {	
		
		String snd_no = "";
		try {
				Mail mail = new Mail();
				mail.setFrom("postmaster@hanjin.com");						//보내는 사람 메일주소
				
				mail.setSubject(emlSndVO.getEmlSubjCtnt());	//메일제목
				//mail.setRecipient("sungyoonshim@cyberlogitec.com, bhyoo@cyberlogitec.com, leeyulkyu@cyberlogitec.com");				//받는 사람 메일주소 
				mail.setRecipient(emlSndVO.getRcvrEml());
				log.error("\n\n>>>>>>>>>받는 사람:"+emlSndVO.getEmlRcvUsrId()+"/"+emlSndVO.getRcvrEml()+"\n\n");
				mail.setHtmlContent(emlSndVO.getEmlCtnt());//메일 컨텐츠
				mail.setGroupwareMail();
				
				//발송
				snd_no = mail.send();
			
		}  catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return snd_no;
	}
	
	/**
	 * 메일 발송 실패 시 
	 * COM_ENS_0U1
	 * @param String authEmlSndNoSeq
	 * @throws DAOException
	 */	
	public void updateAuthEmlSndFail(String authEmlSndNoSeq) {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		try {
				//update
				dbDao.updateAuthEmlSndFail(authEmlSndNoSeq);
			
		} catch (DAOException de) {
			log.error(">>>>>>>>>>>>"+de);
		} catch (Exception ex) {
			log.error(">>>>>>>>>>>>"+ex);
		}
	}
	
	/**
	 * 메일 발송 성공 시
	 * 
	 * @param AuthEmlSndVO emlSndVO
	 * @throws DAOException
	 */	
	public void updateAuthEmlSndSuccess(AuthEmlSndVO emlSndVO) throws Exception {	
		
		AuthorizationDBDAO dbDao = new AuthorizationDBDAO();
		
		try {
			dbDao.updateAuthEmlSndAft(emlSndVO);
		} catch (DAOException de) {
			throw new Exception(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
