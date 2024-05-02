/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportEAIDAO.java
*@FileTitle : 고객에게 Container Loading Confirmation을 발송하는 기능
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.26 김기종
* 1.0 Creation
* 2013.04.08 김진주 [CHM-201323813] 미반입 관리 관련 sms 전송 기능 개발 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.sms.SmsUtil;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.TblSubmitQueueVO;

/**
 * It's RDMailSampleEAIDAO.java
 * @authorKim Ki Jong
 * @see 
 * @since J2EE 1.6
 * Apr 27, 2009
 */
public class StatusReportEAIDAO extends EAIDAOSupport{
	

	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxMetaInfo[] faxInfos
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendFax(FaxMetaInfo[] faxInfos) throws Exception {
		
		int arrLen = faxInfos.length;
		FaxMetaInfo[] infos = new FaxMetaInfo[arrLen];
		
		try {
			for (int i=0; i<arrLen; i++) {
				infos[i] = new FaxMetaInfo(faxInfos[i].getRdSubSysCd(),     // 모듈명(ex.BKG)
					 		               faxInfos[i].getTmplMrd(),   // MRD 파일 명 (ex.WO_NORMAL.mrd)
							               faxInfos[i].getBatFlg(),  // 배치 유무(Y/N)
								           faxInfos[i].getEmlTitNm(),     // 제목
								           faxInfos[i].getParaInfoCtnt(), // RD Parameter (ex. [419][1][selho])
								           //"KIM;5336",
								           faxInfos[i].getRcvrInfoCtnt(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfos[i].getOffice(),    // 지역 FAX office
								           faxInfos[i].getCreUsrId()  // 보내는 사람
								          ); 
			}
					
			return FaxUtility.registerDB(infos);

		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}

	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxMetaInfo faxInfo
	 * @return String
	 * @throws Exception 
	 */
	public String sendFax(FaxMetaInfo faxInfo) throws Exception {
		
		FaxMetaInfo infos[] = new FaxMetaInfo[1];
		
		infos[0] = faxInfo;
		
		List<String> sendId = sendFax(infos);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param Mail mail
	 * @return String
	 */
	public String sendRDEmail(Mail mail) throws Exception {
		
		return mail.send();
	}
	
	
	
	/**
	 * sms를 전송한다.
	 * 
	 * @param Map<String, Object> mailSmsInfo
	 * @return String
	 * @throws Exception
	 */
	public String sendEml(Map<String, Object> mailSmsInfo) throws Exception {
		String sndId = "";
		try{
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom((String) mailSmsInfo.get("FROM_EMAIL")); //보내는 사람 메일주소
			mail.setSubject((String) mailSmsInfo.get("EML_SUBJ_CTNT"));  //메일제목
			mail.setRecipient((String) mailSmsInfo.get("TO_EMAIL"));  //받는 사람 메일주소
			mail.setTextContent((String) mailSmsInfo.get("TEXT")); //Text 로 된 본문 내용


			sndId = mail.send();			

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sndId;
	}
	
	/**
	 * @param Map<String, Object> mailSmsInfo
	 * @return String
	 * @throws Exception
	 */
	public String sendSms(Map<String, Object> mailSmsInfo) throws Exception {
		String sndId = "";
		TblSubmitQueueVO tblSubmitQueueVO = new TblSubmitQueueVO();
		try{
			// sms 발송
			tblSubmitQueueVO.setRcvPhnId((String) mailSmsInfo.get("TO_SMS"));  //받는 사람 phone 
			tblSubmitQueueVO.setSndPhnId("0237706909");  //KT용 보내는 사람 phone 
			tblSubmitQueueVO.setSndMsg((String) mailSmsInfo.get("TEXT")); //Text 로 된 본문 내용

			sndId = SmsUtil.send(tblSubmitQueueVO);	
			log.debug("\nsms sendId :"+ sndId);

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sndId;
	}
	
	/**
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws Exception
	 */
	public BkgNtcHisVO sendCntrListByEmail(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		
		try {
			BookingUtil util = new BookingUtil();
			sndIds = new ArrayList<String>();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			String recipient = "";
			String content = "";
			
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			if("SM Line".equals(account.getUsr_id())){
				sUsrEml = "noreply@smlines.com";
			}
			
			
			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm("ESM_BKG_0622_02.mrd");
			vo.setRdParaCtnt("/rv BKG_NO["+outBdMvntStsNtcListInVO.getBkgNo()+"]");
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm("SMLM"+outBdMvntStsNtcListInVO.getBkgNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			

			template = new TemplateMail();
			template.setComRptDsgnXptInfoVOs(vos);	
			
			//set Recipient
			if("Y".equals(outBdMvntStsNtcListInVO.getObPicNtcFlg()))
				recipient = outBdMvntStsNtcListInVO.getCntcEml();
			if("Y".equals(outBdMvntStsNtcListInVO.getBkgPicNtcFlg()))
				recipient = recipient + ";"+ outBdMvntStsNtcListInVO.getBkgEml();
			if("Y".equals(outBdMvntStsNtcListInVO.getShprNtcFlg()))
				recipient = recipient + ";"+ outBdMvntStsNtcListInVO.getShprEml();
			if("Y".equals(outBdMvntStsNtcListInVO.getSrepNtcFlg()))
				recipient = recipient + ";"+ outBdMvntStsNtcListInVO.getSrepEml();
			
			//set Contents
			content = "To : "+outBdMvntStsNtcListInVO.getShprNm() 
			+ " (  " + outBdMvntStsNtcListInVO.getShprPic() + " , " + outBdMvntStsNtcListInVO.getShprMphnNo() + " )<BR>"
			+ "From : "+account.getUsr_nm() + "<BR><BR><BR>"
			+ "첨부와 같이 현재 귀사 미반입 컨테이너 목록을 송부하오니 적기 반입될 수 있도록 협조하여 주시기 바랍니다.<BR><BR><BR><BR>"
			+ "SM LINE 담당자<BR>"
			+ "&nbsp;&nbsp;1) BKG 담당 : " + outBdMvntStsNtcListInVO.getBkgPic() + " , " + outBdMvntStsNtcListInVO.getBkgMphnNo() + "<BR>"
			+ "&nbsp;&nbsp;2) 영업 담당 : " + outBdMvntStsNtcListInVO.getSrepPic() + " , " + outBdMvntStsNtcListInVO.getSrepMphnNo() + "<BR>"
			+ "&nbsp;&nbsp;3) 화물운영 담당 : " +account.getUsr_nm() + " , "+ outBdMvntStsNtcListInVO.getCtrtOfcPhnNo() + " , " + outBdMvntStsNtcListInVO.getCntcMphnNo()+ "<BR>";
			
			template.setSubject("[SML]화물 CCT경과 미반입 안내 (" + outBdMvntStsNtcListInVO.getBkgNo() + ")");
			if(!recipient.matches(".*@.*")){
				template.setBatFlg("N");
				template.setRecipient(sUsrEml);  
				template.setFrom(sUsrEml,account.getUsr_nm());			
				template.setHtmlContent("받는 사람의 E-MAIL이 한 건도 등록되지 않았습니다");
				sndIds.add(template.send());
			} else {
				template.setBatFlg("N");
				template.setRecipient(recipient);  
				template.setFrom(sUsrEml,account.getUsr_nm());			
				template.setHtmlContent(content);
				sndIds.add(template.send());				
			}		
			
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(outBdMvntStsNtcListInVO.getBkgNo());
			bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email 
			bkgNtcHisVO.setNtcKndCd("DM");
			bkgNtcHisVO.setNtcSeq("0");
			bkgNtcHisVO.setCustCntcTpCd(null);
			bkgNtcHisVO.setNtcEml(outBdMvntStsNtcListInVO.getShprEml());
			bkgNtcHisVO.setSndId(sndIds.get(0));
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
			return bkgNtcHisVO;
	

		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}
}
