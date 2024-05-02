/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryBackEndJob.java
*@FileTitle : F"cast 입력 요청 메세지 송부 기능
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.01
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.06.01 김종준
* 1.0 Creation
* 2011.07.12 Kim jong jun :[CHM-201111824] 소스 품질검토 결과 적용 .
* 2011.07.13 Kim jong jun :[CHM-201111824] 소스 품질검토 결과 적용 .
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration.SpacecontrolinquiryDBDAO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SendMailAddrListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SendMailListVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * - Send Mail 에 대한 BackEndJob<br>
 *
 * @author KIM JONGJUN
 * @see SpacecontrolinquiryBC
 * @since J2EE 1.6
 */
public class SpacecontrolinquiryBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = 7869461307221308362L;
	
	private  SpacecontrolinquiryDBDAO dbDao = new SpacecontrolinquiryDBDAO();
	
	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO;
	
	private SignOnUserAccount account;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return 
	 * @exception
	 */	
	public void setSpcSendMailVo(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account) {
		this.searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
		this.account = account;
	}
	
	/**
	 * BackEndJob 실행 <br>
	 *  
	 * @return SendMailListVO
	 * @exception Exception
	 */	
	@Override
	public SendMailListVO doStart() throws Exception {
		SendMailListVO vo = new SendMailListVO();
		try {			 
			List<SendMailListVO>  sendMailListVOs = dbDao.searchSendMailList(searchSpaceControlInquiryConditionVO);
			SendMailListVO createRsltVO = new SendMailListVO();
			createRsltVO = sendMailList(sendMailListVOs);
			if(!createRsltVO.getErrorCode().equalsIgnoreCase("00000")) {
				//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
				//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
				throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());		
			}			   
			vo.setErrorCode(createRsltVO.getErrorCode());
			vo.setErrMsg(createRsltVO.getErrMsg());			
            ///////////////////////////////////////////////////////////////////////////
			return vo;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OFC별 메일을 보내기 로직. <br>
	 *  
	 * @param List<SendMailListVO>  sendMailListVOs
	 * @return SendMailListVO
	 * @exception Exception
	 */	
	public SendMailListVO sendMailList(List<SendMailListVO>  sendMailListVOs) throws Exception {
		SendMailListVO result = new SendMailListVO();
		try {
			List<String> ofcCdList = new ArrayList<String>();         
			List<SendMailListVO> sendMailList = new ArrayList<SendMailListVO>();         
			for ( int icnt=0; icnt<sendMailListVOs.size(); icnt++ ) {
				SendMailListVO sendMailListVO = sendMailListVOs.get(icnt);
				if ( !ofcCdList.contains(sendMailListVOs.get(icnt).getSlsOfcCd()) ) {	//ofcCd 중복 제거
					String focSlsOfcCd = sendMailListVO.getSlsOfcCd(); 
					ofcCdList.add(focSlsOfcCd);  
					sendMailList.add(sendMailListVOs.get(icnt));
					if ( !focSlsOfcCd.equals("") ) {
						sendMailContentList(sendMailListVOs,sendMailListVO,focSlsOfcCd);	//작성된 메일내용을 메일로 보낸다.
					}
				}
			}     
        	result.setErrorCode("00000");
        	result.setErrMsg("Completed!");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return result;
	}

	/**
	 * OFC별 메일을 보낸다.  <br>
	 *  
	 * @param List<SendMailListVO>  sendMailContentListVOs
	 * @param SendMailListVO sendMailListVO
	 * @param String focSlsOfcCd
	 * @return String
	 * @exception Exception
	 */	
	@SuppressWarnings("unchecked")
	public String sendMailContentList(List<SendMailListVO>  sendMailContentListVOs, SendMailListVO sendMailListVO, String focSlsOfcCd) throws Exception {
		String refNo = "";
		String usrEmls = "";
		String contents = searchSpaceControlInquiryConditionVO.getContents();
		contents = contents.replaceFirst("TO.*:", "TO");					//정규식 TO시작 모든 문자를 찾아서 제거후 TO 로 치환
		contents = contents.replaceFirst("TO.*?", "TO : "+focSlsOfcCd);		//정규식 TO와 : 사이의 문자를 찾아서 제거후 TO : focSlsOfcCd 로 치환
		List<SendMailAddrListVO>  sendMailAddrListVOs = dbDao.searchSendMailAddrList(focSlsOfcCd);	//ofc에 해당하는 sub ofc 리스트 조회 후 send mail
		String szSubject = "["+focSlsOfcCd+"] Forecast Input Request";								//제목
		String szSender = account.getUsr_eml();														//보내는 사람
		String szFilecontent = getFineContent(sendMailContentListVOs,focSlsOfcCd);		//ofc별 메일내용을 만든다.
		ArrayList arFileList = new ArrayList<SingleMailAttachedFile>();
		SingleMailAttachedFile singleMailAttatchedFile = new SingleMailAttachedFile();
		singleMailAttatchedFile.setFileName( "["+focSlsOfcCd+"] Forecast Input Request.xls");
		singleMailAttatchedFile.setFileContent(szFilecontent);
		arFileList.add( singleMailAttatchedFile);
		
		if ( sendMailAddrListVOs.size() > 0 ) {	//setRecipient null error 방지
			for (int i=0; i<sendMailAddrListVOs.size();i++){
				SendMailAddrListVO sendMailAddrListVO = sendMailAddrListVOs.get(i);
				String usrEml = (sendMailAddrListVO.getUsrEml() == null ? "":sendMailAddrListVO.getUsrEml());
				
				if ( !usrEml.equals("")) {
					if ( i == sendMailAddrListVOs.size()-1 ) {
						usrEmls = usrEmls +usrEml;
					} else {
						usrEmls = usrEmls +usrEml+";";
					}
				} 
			}
			String ccRcvrEmls = szSender;	//차후 szSender만 세팅
			if( szFilecontent != null) {
				Mail mail = new Mail();
				
				mail.setGroupwareMail();									//그룹메일 or webmail 전송 
				mail.setFrom		 ( szSender,account.getUsr_nm()	);
				mail.setSubject		 ( szSubject					);
				mail.setCreUsrIds	 ( account.getUsr_id()			);
				mail.setOfficeCode	 ( account.getOfc_cd()			);
				mail.setRdSubSysCd	 ( "SPC"						);
				mail.setBatFlg       ( "N"							);
				mail.setRecipient	 ( usrEmls						);
				mail.setAttachedFile ( arFileList					);
				mail.setHtmlContent  ( contents						);
				mail.setCcRcvrEml	 ( ccRcvrEmls					);
				refNo = mail.send();
			}			
		}
		return refNo;
	}

	/**
	 * 오피스에 해당하는 메일 내용을 만든다. <br>
	 * @param List<SendMailListVO>  sendMailContentListVOs
	 * @param String focSlsOfcCd
	 * @param String slsOfcCd
	 * @return String
	 */
	private String getFineContent(List<SendMailListVO>  sendMailContentListVOs, String focSlsOfcCd ) {
		StringBuffer title = new StringBuffer("");
		title
		.append(       "<TABLE WIDTH=100%>")
		.append(           "<TR>")
		.append(              "<TD>")
		.append(				 focSlsOfcCd+" List" )
		.append(			  "</TD>")
		.append(		   "</TR>")
		.append(	   "</TABLE>")
		.append(	   "<BR><BR>")
		
		.append(       "<TABLE  border='1'>")
		.append(           "<TR bgcolor=#CCFFCC>")
		.append(              "<TD ALIGN='CENTER'>Office</TD>") 
	    .append(              "<TD ALIGN='CENTER'>Trade</TD>" )
	    .append(  		      "<TD ALIGN='CENTER'>Sub Trade</TD>")
	    .append(  		      "<TD ALIGN='CENTER'>Lane</TD>")
		.append(              "<TD ALIGN='CENTER'>Week</TD>" )
		.append(              "<TD ALIGN='CENTER'>VVD</TD>" )
		.append(           "</TR>" )
		;
		
		StringBuffer sbContents = new StringBuffer( title);
		try {
			if(sendMailContentListVOs.size() <= 0){
				return null;
			}
			for(int i=0; i<sendMailContentListVOs.size(); i++){
				SendMailListVO contentsList = sendMailContentListVOs.get(i);
				if ( focSlsOfcCd.equals( contentsList.getSlsOfcCd() ) ) {
					sbContents.append("<TR border=1><TD border=1 ALIGN='CENTER'>");
					sbContents.append( contentsList.getSlsOfcCd());
					sbContents.append("</TD><TD border=1  ALIGN='CENTER'>");
					sbContents.append( contentsList.getTrdCd());
					sbContents.append("</TD><TD border=1  ALIGN='CENTER'>");
					sbContents.append( contentsList.getSubTrdCd());
					sbContents.append("</TD><TD border=1  ALIGN='CENTER'>");
					sbContents.append( contentsList.getRlaneCd());
					sbContents.append("</TD><TD border=1  ALIGN='CENTER'>");
					sbContents.append( contentsList.getCostWk());
					sbContents.append("</TD><TD border=1  ALIGN='CENTER'>");
					sbContents.append( contentsList.getVslCd()+contentsList.getSkdVoyNo()+contentsList.getDirCd());
					sbContents.append("</TD></TR>");
				}
			}
			sbContents.append("</TABLE>");
			sbContents.append("</BR>");

		} catch ( Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return sbContents.toString();
	}	
	
}
