/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineEAIDAO.java
*@FileTitle : GeneralBookingSplitCombineEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.15 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForVslSkdCngNoticeVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.syscommon.common.util.MessageUtil;
//import com.clt.framework.component.javamail.Mail;

/**
 * OPUS GeneralBookingSplitCombineEAIDAO <br>
 * - OPUS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSplitCombineBCImpl 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineEAIDAO  extends EAIDAOSupport {

	/**
	 * Vessel 변경 Notice시 GW 메일전송<br>
	 *
	 * @param 	BkgListForVslSkdCngNoticeVO noticeVO
	 * @param 	String bkgNoList
	 * @throws 	DAOException
	 */	
	private void sendGWVslSkdCngNotice(BkgListForVslSkdCngNoticeVO noticeVO, String bkgNoList) throws DAOException{
		try{
			if(noticeVO.getRcvEmlList().length()<1) return;
			StringBuffer sbContents = new StringBuffer(3000);
		
			sbContents.append("Vessel Schedule Changed<br><br>");
			sbContents.append("BKG No : " + bkgNoList + "<br>");
			sbContents.append("PORT   : " + noticeVO.getYdCd()   + "<br>");
			sbContents.append("Vessel : " + noticeVO.getVvd()    + "<br>");
			sbContents.append("Reason : " + noticeVO.getRemark() + "<br>");
//			sbContents.append("원래 받을 usr eml address : " + noticeVO.getRcvEmlList());
		
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom("noreply@nyk.com"); //보내는 사람 메일주소
			mail.setSubject("Vessel Schedule Change Notice");  //메일제목
		   
			mail.setRecipient(noticeVO.getRcvEmlList());  //받는 사람 메일주소

			mail.setHtmlContent(sbContents.toString());
			mail.setGroupwareMail();
			mail.send();	
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}	

	/**
	 * Vessel 변경 Notice시 short message 메일전송<br>
	 *
	 * @param 	BkgListForVslSkdCngNoticeVO noticeVO
	 * @param 	String bkgNoList
	 * @throws 	DAOException
	 */	
	private void sendMessVslSkdCngNotice(BkgListForVslSkdCngNoticeVO noticeVO, String bkgNoList) throws DAOException{
		try{
			BookingUtil util = new BookingUtil();
			MessageUtil msess = new MessageUtil();
			
			String content = "";
			content = "Vessel Schedule Changed\n" +
					  "BKG No : " + bkgNoList 			 + "\n" + 
					  "PORT   : " + noticeVO.getYdCd()   + "\n" +
					  "Vessel : " + noticeVO.getVvd()    + "\n" +
					  "Reason : " + noticeVO.getRemark() + "\n" ;

			String[] usrNmList = util.splitByToken(noticeVO.getRcvUsrNm(), ",");
			String[] usrIdList = util.splitByToken(noticeVO.getRcvUsrId(), ",");
			
			if(usrNmList.length!=usrIdList.length){
				msess.messageInsert("system1", "system", "", "2006505", content);
				return;
			}
			
			for(int i=0;i<usrIdList.length;i++){
				msess.messageInsert("system1", "system", usrNmList[i], usrIdList[i], content);
//				msess.messageInsert("system1", "system", usrNmList[i], "2006505", content);
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}

	/**
	 * Vessel 변경 Notice시 gw mail/short message 메일전송<br>
	 *
	 * @param 	List<BkgListForVslSkdCngNoticeVO> noticeVOs
	 * @throws 	DAOException
	 */	
	public void sendVslSkdCngNotice(List<BkgListForVslSkdCngNoticeVO> noticeVOs) throws DAOException{
		try{
			BookingUtil util = new BookingUtil();
			
			String bkgNoList = "";
			String bkgNoList2 = "";
			
			if(noticeVOs != null){				
				for(int i = 0;i<noticeVOs.size();i++){
					bkgNoList = "";
					bkgNoList2 = "";
					String[] bkgNos = util.splitByToken(noticeVOs.get(i).getBkgNoList(), ",");
					
					for(int idx=0;idx<bkgNos.length;idx++){						
						if(0==idx){
							bkgNoList = bkgNos[idx];
							bkgNoList2= bkgNos[idx];
						} else {
							if(idx%4==0){
								bkgNoList = bkgNoList + ",\n         " + bkgNos[idx];
								bkgNoList2= bkgNoList2+ ",<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + bkgNos[idx];
		            		} else {
		            			bkgNoList = bkgNoList + ", " + bkgNos[idx];
		            			bkgNoList2= bkgNoList2+ ",&nbsp;" + bkgNos[idx];
							}
						}
					}
					sendMessVslSkdCngNotice(noticeVOs.get(i), bkgNoList);						

					sendGWVslSkdCngNotice(noticeVOs.get(i), bkgNoList2);
				}		
			}			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}
}



//				msess.messageInsert(sndNm, sndrId, rcvNm, rcvrId, content);
//				StringBuffer sbContents = new StringBuffer(500);

//				sbContents.append("\n<html>");
//				sbContents.append("\n<head>");
//				sbContents.append("\n<title>            </title>");
//				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//				sbContents.append("\n</head>");
//				sbContents.append("\n<body>");
//				sbContents.append("\n<table width='100%\' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>");
//				sbContents.append("\n	<tr>");
//				sbContents.append("\n		<td valign='top'>");
//				sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='300'>");
//				sbContents.append("\n			<tr>");
//				sbContents.append("\n				<td height='25'>");
//				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
//				sbContents.append("\n					<tr><td width='100%' colspan='2'> Vessel Schedule Changed </td>");
//				sbContents.append("\n					<<tr><td height='25'></td></tr>");
//				sbContents.append("\n					<tr><td width='60'> BKG No</td><td width='540'> : "+bkgListForVslSkdCngNoticeVO.getBkgNo()+"</td></tr>");
//				sbContents.append("\n					<tr><td width='60'> Port  </td><td width='540'> : "+bkgListForVslSkdCngNoticeVO.getPortCd()+"</td></tr>");
//				sbContents.append("\n					<tr><td width='60'> Vessel</td><td width='540'> : "+bkgListForVslSkdCngNoticeVO.getVslCd()+bkgListForVslSkdCngNoticeVO.getSkdVoyNo()+bkgListForVslSkdCngNoticeVO.getSkdDirCd()+"</td></tr>");
//				sbContents.append("\n					<tr><td width='60'> Reason</td><td width='540'> : "+bkgListForVslSkdCngNoticeVO.getTypeCd()+"</td></tr>");//cd01831
//				sbContents.append("\n					<tr><td width='60'> Remark</td><td width='540'> : "+bkgListForVslSkdCngNoticeVO.getRemark()+"</td></tr>");
//				sbContents.append("\n				</table>");	
//				sbContents.append("\n				</td>");
//				sbContents.append("\n			</tr>");
//				sbContents.append("\n		</table>");		
//				sbContents.append("\n		</td>");
//				sbContents.append("\n	</tr>");
//				sbContents.append("\n</table>");
//				sbContents.append("\n</body>");
//				sbContents.append("\n</html>");			

				// 메일발송
//			   Mail mail = new Mail();
//			   mail.setFrom("postmaster@clt.com"); //보내는 사람 메일주소
//			   mail.setSubject("Vessel Schedule Change Notice");  //메일제목
			   //mail.setRecipient(col6+";"+col7);  //받는 사람 메일주소
			   
//			   mail.setRecipient(bkgListForVslSkdCngNoticeVO.getUsrEmail());  //받는 사람 메일주소
//			   mail.setRecipient("jhyim@clt.com");
//			   mail.setCcRcvrEml("dyryu2006@cyberlogitec.com");
			   //mail.setCcRcvrEml(ccEml);  //cc로 받는 사람 메일주소
			   //mail.setBccRcvrEml("fullthink@naver.com");//bcc로 받는 사람 메일주소
			   //mail.setTextContent(sbContents.toString()); //Text로된 본문 내용
//			   mail.setHtmlContent(sbContents.toString());
//			   mail.send();	
