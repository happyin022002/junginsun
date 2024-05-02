/**=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendBCImpl.java
*@FileTitle : ContractNoticeMailSendBCImpl.java
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnoticemail.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.bizcommon.agreementnoticemail.integration.ContractNoticeMailSendDBDAO;
import com.hanjin.bizcommon.agreementnoticemail.vo.ComCtrtUsrMgmtInfoVO;
import com.hanjin.bizcommon.agreementnoticemail.vo.CtntInfoVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - ALPS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see  각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ContractNoticeMailSendBCImpl extends BasicCommandSupport implements ContractNoticeMailSendBC {

    // Database Access Object
    private transient ContractNoticeMailSendDBDAO dbDao=null;

    /**
     * ContractNoticeMailSendBCImpl 객체 생성<br>
     * ContractNoticeMailSendDBDAO  객체 생성<br>
     */
    public ContractNoticeMailSendBCImpl(){
        dbDao = new ContractNoticeMailSendDBDAO();
    }

    /**
     * 계약 종료 3개월전 Notice mail전송  <br>
	 * 
	 * @exception EventException
	 */
	public void sendContractNoticeMail() throws EventException {
		List<ComCtrtUsrMgmtInfoVO> emlRcvUsrList = new ArrayList<ComCtrtUsrMgmtInfoVO> ();
		List<CtntInfoVO> ctntInfoList = new ArrayList<CtntInfoVO> ();
		
		ComCtrtUsrMgmtInfoVO emlRcvUsr = new ComCtrtUsrMgmtInfoVO();
		
		try {
			// 계약종료 90일전 Notice mail받을 대상자 조회
			emlRcvUsrList =  dbDao.searchNoticeMailReceiver();
			
			for(int i=0;emlRcvUsrList != null && i<emlRcvUsrList.size();i++){
				emlRcvUsr.setSysCd(emlRcvUsrList.get(i).getSysCd());
				emlRcvUsr.setCtrtOfcCd(emlRcvUsrList.get(i).getCtrtOfcCd());
				emlRcvUsr.setOfcTpCd(emlRcvUsrList.get(i).getOfcTpCd());
				emlRcvUsr.setAgmtNo(emlRcvUsrList.get(i).getAgmtNo());
				emlRcvUsr.setUsrEmlCtnt(emlRcvUsrList.get(i).getUsrEmlCtnt()); // usrEmlCtnt로 전체를 대체한다.
				
				//메일에 보낼 데이터 조회
				ctntInfoList = dbDao.searchMailContents(emlRcvUsr); // COM_CTRT_NTC_INFO의 CTRT_CRE_USR_ID를 기준으로 가져온다. -> e-mail 본문과 첨부Excel내용 생성을 위해 쓰인다.
	
				//메일 본문,첨부파일 생성 및 전송
				if(ctntInfoList.size() > 0){
					sendNoticeMail(emlRcvUsr,ctntInfoList);
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 메일 전송
	 * @param emlRcvUsr
	 * @param ctntInfoList
	 * @exception EventException
	 */
	public void sendNoticeMail(ComCtrtUsrMgmtInfoVO emlRcvUsr,List<CtntInfoVO> ctntInfoList) throws EventException {
		
		String strContents = "";
		String strMailContents = "";
		Mail mail = null;
		
		SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileCreDt    = fileDateFormat.format(new Date());

    	// TITLE
    	String subject = "Contracts to be expired within 3 months";
    	//String sender = "noreply@hanjin.com";
    	String sender = "noreply@smlines.com";
    	String SndNo="";
		
		try {
			int ctrt_cnt = 0; //계약 건수
			String rcvUsrEmL= "";
//			StringBuffer ccUsrEml = new StringBuffer();
//			String ccUsrEml_1 = "";
			String sysCd = emlRcvUsr.getSysCd();
			
			
			rcvUsrEmL = emlRcvUsr.getUsrEmlCtnt(); //요걸로 대체한다.
			log.info(">>>>> rcvUsrEmL : "+rcvUsrEmL);
			//rcvUsrEmL ="kuriva@cyberlogitec.com";
			
			//Contract Notice개수 조회
			ctrt_cnt = dbDao.searchContractCount(emlRcvUsr);
			log.info(">>>>> Contract Count : "+ctrt_cnt);
			
			//참조 메일 수신자(CC) e-mail Address조회
//			dbRowset = dbDao.searchCCReceiverInfo(emlRcvUsr); // COM_CTRT_NTC_INFO에서 조회한 CTRT_UPD_USR_ID를 기준으로 가져온다
//			while(dbRowset.next()){
//				ccUsrEml =  ccUsrEml.append(dbRowset.getString("CC_ID")+";");
//			}
			
//			if(ccUsrEml.length() > 0 ){
//				ccUsrEml_1 = ccUsrEml.substring(0, ccUsrEml.length()-1).toString();
//			}
		//	ccUsrEml ="";
//			log.info(">>>>> ccUsrEml : "+ccUsrEml_1);

			//e-mail 본문 생성
			strContents = getContents(ctntInfoList,ctrt_cnt,sysCd);
			//첨부 Excel내용 생성
			strMailContents =getMailContents(ctntInfoList,sysCd);
			
			List<SingleMailAttachedFile>  arFileList = new ArrayList<SingleMailAttachedFile>();	
			SingleMailAttachedFile atchFile = new SingleMailAttachedFile();
			
			String fileName ="Contract_Notification("+fileCreDt+").xls";
			
			atchFile.setFileName(fileName);
			log.info(">>>>> file name : "+atchFile.getFileName());
			
			atchFile.setFileContent(strMailContents);
	    	arFileList.add(atchFile);
				
			String[] arRcvUsrEml = rcvUsrEmL.split(";");
//			String[] arCcUsrEml  = ccUsrEml_1.split(";");

			mail = new Mail();
	       	mail.setRdSubSysCd(sysCd);          //System id    	
	    	mail.setSubject(subject);			//e-mail 제목
	    	mail.setFrom(sender);				//발신자 e-mail address 설정
	    	mail.setAttachedFile(arFileList);	//첨부파일 설정.
	    	mail.setRecipients(arRcvUsrEml);	//수신자 e-mail address 설정
//	    	mail.setCcRcvrEmls(arCcUsrEml);		//참조 수신자 e-mail address 설정   //cc는 빼기로함 -> 원모리B 요청
	    	mail.setHtmlContent(strContents);	//메일 본문내용 설정
	    	mail.setGroupwareMail();			//GroupWare로 mail전송하도록 설정
	    	
		    // SEND MAIL
	    	SndNo = mail.send();
	    	log.info(">>>> SndNo :" +SndNo);
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch ( MailerAppException me ) {
			throw new EventException(new ErrorHandler(me).getMessage(), me);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);	
		}
	}
	
	/**
	 * 메일 전송할 본문을 생성한다.
	 * @param ctntInfoList
	 * @param ctrt_cnt
	 * @param sysCd
	 * @return String
	 */
	private String getContents(List<CtntInfoVO> ctntInfoList,int ctrt_cnt,String sysCd) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sendDt    = dateFormat.format(new Date());		

		StringBuffer sbContents = new StringBuffer();
		try {
			sbContents.append("\n<BODY>");
			if(sysCd.equals("TRS")){
				sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1300;'>");
			}else{
				sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1250;'>");
			}
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='width:10'>DT</TD><TD colspan=10>: "+sendDt+"</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD>TO</TD><TD colspan=10>: All parties concerned</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD>CC</TD><TD colspan=10>: All relevant parties</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=12>Subject : To be expired contracts within 3 months</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=12 height=10></TD></TR>");
			sbContents.append("\n		<TR >");
			sbContents.append("\n		    <TD></TD>");
			sbContents.append("\n			<TD colspan=10>Please be informed following contracts("+ctrt_cnt+") will be expired within 3 months</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n		    <TD></TD>");
			sbContents.append("\n			<TD colspan=10>If you want to check more detail, Please open attached file</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=12 height=10></TD></TR>");			
			sbContents.append("\n		<TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n		    <TD></TD>");
			sbContents.append("\n			<TD colspan=10 >Do not reply</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=12 height=10></TD></TR>");			
			sbContents.append("\n		<TR>");
			sbContents.append("\n		    <TD style='width:10'></TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  bgcolor=#CCFFCC align ='center'>No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  bgcolor=#CCFFCC align ='center'>Sys</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' bgcolor=#CCFFCC align ='center'>AGMT NO</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' bgcolor=#CCFFCC align ='center'>Service Provider</TD>");
			//TRS일 경우만 Type을 보여준다.
			if(sysCd.equals("TRS")){
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;' bgcolor=#CCFFCC align ='center'>Type</TD>");
			}	
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Create Office</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' bgcolor=#CCFFCC align ='center' colspan=2>Creation User</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:70;'  bgcolor=#CCFFCC align ='center'>Live User</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Effective Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Expire Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:140;' bgcolor=#CCFFCC align ='center'>Last Update</TD>");
			sbContents.append("\n		</TR>");
			for(int i=0; i<ctntInfoList.size(); i++){
				sbContents.append("\n		<TR >");
				sbContents.append("\n		    <TD style='width:10'></TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getSeq(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getSysCd(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtNo(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getVndrNm(),"&nbsp;")+"</TD>");
				//TRS일 경우만 Type을 보여준다.
				if(sysCd.equals("TRS")){
					sbContents.append("\n			<TD style='border:1px solid #666666;width:50;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtTrspTpCd(),"&nbsp;")+"</TD>");
				}
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCtrtOfcCd(),"&nbsp;")+"</TD>");
				if(JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"").equals("N")){
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:80;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrId(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:150;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:70;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"&nbsp;")+"</TD>");
				}else{
					sbContents.append("\n			<TD style='border:1px solid #666666;width:80;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrId(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:170;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:70;'  align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"&nbsp;")+"</TD>");
					
				}
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtEffDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtExpDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:140;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getUpdDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n		</TR>");	
			}
			sbContents.append("\n		<TR><TD colspan=10 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n		    <TD></TD>");
			sbContents.append("\n			<TD colspan=10>RGDS</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n	</TABLE>");
			sbContents.append("\n</BODY>");

		} catch ( Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return sbContents.toString();

	}

	
	/**
	 * e-mail 첨부 Excel 파일 내용 생성
	 * @param ctntInfoList
	 * @param sysCd
	 * @return String
	 */
	private String getMailContents(List<CtntInfoVO> ctntInfoList,String sysCd) {
		StringBuffer sbContents = new StringBuffer();
		try {
			sbContents.append("\n<BODY>");
			if(sysCd.equals("TRS")){
				sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1300;'>");
			}else{
				sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1250;'>");
			}
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  bgcolor=#CCFFCC align ='center'>No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  bgcolor=#CCFFCC align ='center'>Sys</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' bgcolor=#CCFFCC align ='center'>AGMT NO</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' bgcolor=#CCFFCC align ='center'>Service Provider</TD>");
			//TRS일 경우만 Type을 보여준다.
			if(sysCd.equals("TRS")){
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;' bgcolor=#CCFFCC align ='center'>Type</TD>");
			}	
			sbContents.append("\n			<TD style='border:1px solid #666666;width:70;'  bgcolor=#CCFFCC align ='center'>Create Office</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' bgcolor=#CCFFCC align ='center' colspan=2>Creation User</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:70;'  bgcolor=#CCFFCC align ='center'>Live User</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Effective Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Expire Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:140;' bgcolor=#CCFFCC align ='center'>Last Update</TD>");
			sbContents.append("\n		</TR>");
			for(int i=0; i<ctntInfoList.size(); i++){
				sbContents.append("\n		<TR >");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:30;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getSeq(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getSysCd(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtNo(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:250;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getVndrNm(),"&nbsp;")+"</TD>");
				//TRS일 경우만 Type을 보여준다.
				if(sysCd.equals("TRS")){
					sbContents.append("\n			<TD style='border:1px solid #666666;width:50;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtTrspTpCd(),"&nbsp;")+"</TD>");
				}
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCtrtOfcCd(),"&nbsp;")+"</TD>");
				if(JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"").equals("N")){
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:80;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrId(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:150;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;color:red;width:70;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"&nbsp;")+"</TD>");
				}else{
					sbContents.append("\n			<TD style='border:1px solid #666666;width:80;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrId(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:170;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getCreUsrNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:70;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getDeltFlg(),"&nbsp;")+"</TD>");
				}
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtEffDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getAgmtExpDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:140;' align ='center'>"+JSPUtil.getNull(ctntInfoList.get(i).getUpdDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n		</TR>");	
			}
			sbContents.append("\n	</TABLE>");
			sbContents.append("\n</BODY>");

		} catch ( Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return sbContents.toString();

	}

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}