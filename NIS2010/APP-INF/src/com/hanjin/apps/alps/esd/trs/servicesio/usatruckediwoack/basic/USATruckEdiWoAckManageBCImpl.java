/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EDI_ENS_004EventResponse.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
* N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
* 
* 2011.10.27 [CHM-201113998]vW/O상에 EDI Result 값에 대한 문의 및 오류 수정 요청.
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetail;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration.USATruckEdiWoAckManageDBDAO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Jun-Yong
 * @see EDI_ENS_004EventResponse,USARailWoAckManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USATruckEdiWoAckManageBCImpl   extends BasicCommandSupport implements USATruckEdiWoAckManageBC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient USATruckEdiWoAckManageDBDAO dbDao=null;

	/**
	 * USARailWoAckManageBCImpl 객체 생성<br>
	 * USARailWoAckManageDBDAO를 생성한다.<br>
	 */
	public USATruckEdiWoAckManageBCImpl(){
		dbDao = new USATruckEdiWoAckManageDBDAO();
	}

	/** MQueue를 
	 *  Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 *  - N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청.
	 *  
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveUSATruckEdiWoAckManageList(String str) throws EventException {
		
		int resultCount = 0;
		String ack = null;
		String ackhd = null;
		String edi_ctrl_seq = null;
		String edi_so_no = null; 
		String edi_rcv_rslt_cd = null;
		
		String trsp_wo_no = null;
		
		int len = (str.trim()).length();		
		log.debug("str: " + str );
		ack = str.substring(83,105);
		log.debug("ack: " + ack );
		ackhd = str.substring(52,55);
		log.debug("ackhd: " + ackhd );
		
		try {	
			if ( len > 63 ) { 
				if (ack.equals("IFEDI2NIS!USTRUCK_ACK!")){
					edi_ctrl_seq = str.substring(114,123);
					log.debug("bil_edi_ctrl_seq:" + edi_ctrl_seq );	
					edi_rcv_rslt_cd = str.substring(131,132);
					log.debug("bil_edi_rcv_rslt_cd:" + edi_rcv_rslt_cd );
					
					//trsp_wo_no = dbDao.searchWorkOrderNo(ackhd, edi_ctrl_seq, "");
					//ackSendMail(trsp_wo_no);

		        	resultCount = dbDao.addUSATruckEdiWoAckManageList(edi_ctrl_seq, edi_rcv_rslt_cd);										
				} else if (ackhd.equals("990")){
					edi_so_no = str.substring(106,117).trim();
					log.debug("bil_edi_so_no:" + edi_so_no );
//					edi_rcv_rslt_cd = str.substring(148,149);
					
					int pos = str.indexOf("WO_RESPONSE:", 100);
					edi_rcv_rslt_cd = str.substring(pos+12, pos+12+1);					
					log.debug("bil_edi_rcv_rslt_cd:" + edi_rcv_rslt_cd );
					
					//trsp_wo_no = dbDao.searchWorkOrderNo(ackhd, edi_ctrl_seq, edi_so_no);
					//ackSendMail(trsp_wo_no);

					resultCount = dbDao.addUSATruckEdi990WoAckManageList(edi_so_no, edi_rcv_rslt_cd);				
				}else {				
					throw new DAOException("HEAD TYPE does not exist");  
				}
			}	        	
        } catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return resultCount; 
	}	
		
 
	/**
	 * Ack Send E-Mail
	 * @param trsp_wo_no
	 * @throws EventException
	 */
	public void ackSendMail(String trsp_wo_no) throws EventException {
		Mail mail = null;
    	String subject = "";
    	String sender = "noreply@smlines.com";
    	String sysCd = "TRS";
    	String SndNo="";
    	String rcvUsrEml = "";
    	StringBuffer sb = null;
    	
		try {
            Object resultDetail = dbDao.searchWorkOrderDetail(trsp_wo_no);
            WorkOrderDetail workOrderDetail = (WorkOrderDetail)resultDetail;
			
			Object[] resultList = dbDao.searchWorkOrderDetailList(trsp_wo_no);
			WorkOrderDetailList[] workOrderDetailList = (WorkOrderDetailList[])resultList[0];

			//제목
			subject = "[EDI W/O Reject] W/O " + trsp_wo_no + " rejected by " + workOrderDetail.getVndr_nm(); 
			//수신자
			rcvUsrEml = workOrderDetail.getUsr_eml();
			             
	        sb = new StringBuffer();
	        sb.append("<html>");
	        sb.append("<head>");
	        sb.append("<title></title>");
	        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
	        sb.append("</head>");
	        sb.append("<body>");
	        sb.append("<table border=\"0\" width=\"100%\">");
	        sb.append("			 <tr><td bgcolor='#FFFFFF'>                                                                                                                                                                                                     ");
	        sb.append("				To: W/O Issue ID, Supervisor                                                                                                                                                                             ");
	        sb.append("				<table border='0' cellspacing='0' cellpadding='0'>                                                                                                                                                                            ");
	        sb.append("					<tr><td><br></td></tr>                                                                                                                                                                                                      ");
	        sb.append("					<tr>                                                                                                                                                                                                                        ");
	        sb.append("						<td>                                                                                                                                                                                                                      ");
	        sb.append("							<table width='1070' border='0' cellpadding='0' cellspacing='1' style='background-color:#4D8DBD;'>                                                                                                                        ");
	        sb.append("								<tr>                                                                                                                                                                                                                  ");
	        sb.append("									<td>                                                                                                                                                                                                                ");
	        sb.append("										<table width='1068' border='0' cellpadding='0' cellspacing='1' style='background-color:#E1E5E8;'>                                                                                                                  ");
	        sb.append("											<tr>                                                                                                                                                                                                            ");
	        sb.append("												<td bgcolor='#FFFFFF' style='padding:0 4 0 4;'>                                                                                                                                                               ");
	        sb.append("													<table width='100%' border='0' cellpadding='0' cellspacing='4'>                                                                                                                                             ");
	        sb.append("														<tr>                                                                                                                                                                                                      ");
	        sb.append("															<td style='font-size:11px;font-family:Arial; background-color:#DBE3EA; color:#264B71; font-weight:bold; padding:3 3 3 5; text-align:center;'>USER INFORMATION</td>                                       ");
	        sb.append("														</tr>                                                                                                                                                                                                     ");
	        sb.append("													</table>                                                                                                                                                                                                    ");
	        sb.append("												</td>                                                                                                                                                                                                         ");
	        sb.append("											</tr>                                                                                                                                                                                                           ");
	        sb.append("										</table>                                                                                                                                                                                                          ");
	        sb.append("									</td>                                                                                                                                                                                                               ");
	        sb.append("								</tr>                                                                                                                                                                                                                 ");
	        sb.append("							</table>                                                                                                                                                                                                                ");
	        sb.append("						</td>                                                                                                                                                                                                                     ");
	        sb.append("					</tr>                                                                                                                                                                                                                       ");                                              
	        sb.append("					<tr>                                                                                                                                                                                                                        ");
	        sb.append("						<td>                                                                                                                                                                                                                      ");
	        sb.append("							<table width='1070' border='0' cellpadding='0' cellspacing='1' style='background-color:#4D8DBD;'>                                                                                                                        ");
	        sb.append("								<tr>                                                                                                                                                                                                                  ");
	        sb.append("									<td>                                                                                                                                                                                                                ");
	        sb.append("										<table width='1068' border='0' cellpadding='0' cellspacing='1' style='background-color:#E1E5E8;'>                                                                                                                  ");
	        sb.append("											<tr>                                                                                                                                                                                                            ");
	        sb.append("												<td bgcolor='#FFFFFF' style='padding:4 4 0 4;'>                                                                                                                                                               ");
	        sb.append("													<table width='100%' border='0' cellpadding='0' cellspacing='4'>                                                                                                                                             ");
	        sb.append("														<tr>                                                                                                                                                                                                      ");
	        sb.append("															<td width='80' style='font-size:10px;font-family:Arial;background-color:#DBE3EA;color:#264B71;font-weight:bold;padding:3 3 3 5;'>VENDER NO.</td>                                                        ");
	        sb.append("															<td	width='250' style='font-size:10px;background-color:#FFFFFF; color:#67625D; font-weight:normal; text-align:Left; padding:2 0 2 0;'>"+workOrderDetail.getWo_vndr_seq()+"&nbsp;</td>                                ");
	        sb.append("															<td width='80' style='font-size:10px;font-family:Arial;background-color:#DBE3EA;color:#264B71;font-weight:bold;padding:3 3 3 5;'>VENDER NAME</td>                                                       ");
	        sb.append("															<td	style='font-size:10px;background-color:#FFFFFF; color:#67625D; font-weight:normal; text-align:Left; padding:2 0 2 0;'>"+workOrderDetail.getVndr_nm()+"&nbsp;</td>                                             ");
	        sb.append("														</tr>                                                                                                                                                                                                     ");
	        sb.append("													</table>                                                                                                                                                                                                    ");
	        sb.append("												</td>                                                                                                                                                                                                         ");
	        sb.append("											</tr>                                                                                                                                                                                                           ");
	        sb.append("											<tr>                                                                                                                                                                                                            ");
	        sb.append("												<td bgcolor='#FFFFFF' style='padding:0 4 0 4;'>                                                                                                                                                               ");
	        sb.append("													<table width='100%' border='0' cellpadding='0' cellspacing='4'>                                                                                                                                             ");
	        sb.append("														<tr>                                                                                                                                                                                                      ");
	        sb.append("															<td width='80' style='font-size:10px;font-family:Arial; background-color:#DBE3EA; color:#264B71; font-weight:bold; padding:3 3 3 5;'>TEL.</td>                                                          ");
	        sb.append("															<td width='250' style='font-size:10px;background-color:#FFFFFF; color:#67625D; font-weight:normal; text-align:Left; padding:2 0 2 0;'>"+workOrderDetail.getPhn_no()+" "+"&nbsp;</td>                              ");
	        sb.append("															<td width='80' style='font-size:10px;font-family:Arial; background-color:#DBE3EA; color:#264B71; font-weight:bold; padding:3 3 3 5;'>E-MAIL</td>                                                     ");
	        sb.append("															<td style='font-size:10px;background-color:#FFFFFF; color:#67625D; font-weight:normal; text-align:Left; padding:2 0 2 0;'>"+workOrderDetail.getVndr_eml()+" "+"&nbsp;</td>                                ");
	        sb.append("														</tr>                                                                                                                                                                                                     ");
	        sb.append("													</table>                                                                                                                                                                                                    ");
	        sb.append("												</td>                                                                                                                                                                                                         ");
	        sb.append("											</tr>                                                                                                                                                                                                           ");
	        sb.append("										</table>                                                                                                                                                                                                          ");
	        sb.append("									</td>                                                                                                                                                                                                               ");
	        sb.append("								</tr>                                                                                                                                                                                                                 ");
	        sb.append("							</table>                                                                                                                                                                                                                ");
	        sb.append("						</td>                                                                                                                                                                                                                     ");
	        sb.append("					</tr>                                                                                                                                                                                                                       ");
	        sb.append("                    <tr><td><br></td></tr>                                                                                                                                                                                           ");
	        sb.append("					<tr>                                                                                                                                                                                                                        ");
	        sb.append("						<td>                                                                                                                                                                                                                      ");
	        sb.append("							<table width='1070' border='0' cellpadding='0' cellspacing='1' style='background-color:#4D8DBD;'>                                                                                                                        ");
	        sb.append("								<tr>                                                                                                                                                                                                                  ");
	        sb.append("									<td>                                                                                                                                                                                                                ");
	        sb.append("										<table width='1068' border='0' cellpadding='0' cellspacing='1' style='background-color:#E1E5E8;'>                                                                                                                  ");
	        sb.append("											<tr>                                                                                                                                                                                                            ");
	        sb.append("												<td bgcolor='#FFFFFF' style='padding:0 4 0 4;'>                                                                                                                                                               ");
	        sb.append("													<table width='100%' border='0' cellpadding='0' cellspacing='4'>                                                                                                                                             ");
	        sb.append("														<tr>                                                                                                                                                                                                      ");
	        sb.append("															<td style='font-size:11px;font-family:Arial; background-color:#F1ECEB; color:#67625D; font-weight:bold; padding:3 3 3 5; text-align:center;'>REJECT REQUEST CONTENTS</td>                               ");
	        sb.append("														</tr>                                                                                                                                                                                                     ");
	        sb.append("													</table>                                                                                                                                                                                                    ");
	        sb.append("												</td>                                                                                                                                                                                                         ");
	        sb.append("											</tr>                                                                                                                                                                                                           ");
	        sb.append("										</table>                                                                                                                                                                                                          ");
	        sb.append("									</td>                                                                                                                                                                                                               ");
	        sb.append("								</tr>                                                                                                                                                                                                                 ");
	        sb.append("							</table>                                                                                                                                                                                                                ");
	        sb.append("						</td>                                                                                                                                                                                                                     ");
	        sb.append("					 </tr>                                                                                                                                                                                                                      ");
	        sb.append("             		 <tr>                                                                                                                                                                                                               ");
	        sb.append("             			<td>                                                                                                                                                                                                              ");
	        sb.append("             				<table width='1070' border='0' cellpadding='0' cellspacing='1' style='background-color:#4D8DBD;'>                                                                                                                ");
	        sb.append("             					<tr>                                                                                                                                                                                                          ");
	        sb.append("             						<td>                                                                                                                                                                                                        ");
	        sb.append("             							<table width='1068' border='0' cellpadding='0' cellspacing='1' style='background-color:#E1E5E8;'>                                                                                                          ");
	        sb.append("             								<tr>                                                                                                                                                                                                    ");
	        sb.append("             									<td bgcolor='#FFFFFF' style='padding:4 4 0 4;'>                                                                                                                                                       ");
	        sb.append("             										<table width='100%' border='0' cellpadding='0' cellspacing='4' style='table-layout:fixed;'>                                                                                                         ");
	        sb.append("             											<tr>                                                                                                                                                                                              ");
	        sb.append("             												<td width='25' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>NO</td>                                      ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>W/O NO</td>                                  ");
	        sb.append("             												<td width='50' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>KIND</td>                                 ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>DISPATCHED DATE</td>                              ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>BKG NO</td>                             ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>CNTR NO</td>                             ");
	        sb.append("             												<td width='40' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>CNTR TP/SZ</td>                            ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>FROM</td>                       ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>TO</td>                           ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>DOOR</td>                           ");
	        sb.append("             												<td width='100' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>DOOR LOCATION NAME</td>                           ");
	        sb.append("             												<td width='100' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>WAREHOUSE NAME</td>                           ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#F1ECEB;color:#67625D;font-weight:bold;padding:3 3 3 5;text-align:center;'>W/O AMT</td>                           ");
	        sb.append("             											</tr>                                                                                                                                                                                             ");
			for(int i=0; i<workOrderDetailList.length; i++){
	        sb.append("             											<tr>                                                                                                                                                                                              ");
	        sb.append("             												<td width='25' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+(i+1)+"</td>                                                    ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+trsp_wo_no+"</td> ");
	        sb.append("             												<td width='50' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetailList[i].getTrsp_cost_dtl_mod_nm()+"</td> ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getEdi_snd_dt()+"</td>                            ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetailList[i].getBkg_no()+"</td>                               ");
	        sb.append("             												<td width='80' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetailList[i].getEq_no()+"</td>                               ");
	        sb.append("             												<td width='40' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetailList[i].getEq_tpsz_cd()+"</td>                                  ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getFr_code()+"</td>                            ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getTo_code()+"</td>                            ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getDoor_code()+"</td>                            ");
	        sb.append("             												<td width='100' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getZn_nm()+"</td>                            ");
	        sb.append("             												<td width='100' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetail.getDoor_full_nm()+"</td>                            ");
	        sb.append("             												<td width='60' style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>"+workOrderDetailList[i].getWo_amt()+"</td>                            ");
	        sb.append("             											</tr>                                                                                                                                                                                             ");
	        }
	        sb.append("             										</table>                                                                                                                                                                                            ");
	        sb.append("             									</td>                                                                                                                                                                                                 ");
	        sb.append("             								</tr>                                                                                                                                                                                                   ");
	        sb.append("             							</table>                                                                                                                                                                                                  ");
	        sb.append("             						</td>                                                                                                                                                                                                       ");
	        sb.append("             					</tr>                                                                                                                                                                                                         ");
	        sb.append("             				</table>                                                                                                                                                                                                        ");
	        sb.append("             			</td>                                                                                                                                                                                                             ");
	        sb.append("             		 </tr>                                                                                                                                                                                                              ");
	        sb.append("					 <tr><td style='font-size:10px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;'>* This e-mail has been sent automatically by 'partner.smlines.com'. </td></tr>                                     ");
	        sb.append("					 <tr><td ><br></td></tr>                                                                                                                                                                                                    ");
	        sb.append("					 <tr><td style='font-size:11px;font-family:Arial;background-color:#FFFFFF;color:#67625D;padding:3 3 3 5;text-align:center;'>COPYRIGHT(C) SM LINE CORPORATION LTD ALL RIGHTS RESERVED</td></tr>                              ");
	        sb.append("					 <tr><td><br></td></tr>                                                                                                                                                                                                     ");
	        sb.append("				</table>                                                                                                                                                                                                                      ");
	        sb.append("             </td>                                                                                                                                                                                                                   ");
	        sb.append("		 </tr>                                                                                                                                                                                                                            ");
	    	sb.append("</table>");
	        sb.append("</body>");
	        sb.append("</html>");
	        
	    	mail = new Mail();
	       	mail.setRdSubSysCd(sysCd);          //System id    	
	    	mail.setSubject(subject);			//e-mail 제목
	    	mail.setFrom(sender);				//발신자 e-mail address 설정
	    	mail.setRecipient(rcvUsrEml);	//수신자 e-mail address 설정
	    	mail.setHtmlContent(sb.toString());	//메일 본문내용 설정
//	    	mail.setTextContent(sb.toString());
		    // SEND MAIL
	    	SndNo = mail.send();
		} catch ( MailerAppException me ) {
			throw new EventException(new ErrorHandler(me).getMessage(), me);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
	}
	
	/** MQueue를 
	 *  Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * @param msg
	 * @return
	 * @throws EAIException
	 */
	/*
	public int receiveUSATruckEdiWoAckManageList2(String str) throws EventException {
		
		/*
		int resultCount = 0;
		String ack = null;
		String ackhd = null;
		String edi_ctrl_seq = null;
		String edi_so_no = null; 
		String edi_rcv_rslt_cd = null;
		int len = (str.trim()).length();		
		log.debug("str: " + str );
		ack = str.substring(77,99);
		log.debug("ack: " + ack );
		ackhd = str.substring(52,55);
		log.debug("ackhd: " + ackhd );	
		
		try {	
			if ( len > 63 ) { 
				if (ack.equals("IFEDI2NIS!USTRUCK_ACK!")){
					edi_ctrl_seq = str.substring(108,117);
					log.debug("bil_edi_ctrl_seq: " + edi_ctrl_seq );
					edi_rcv_rslt_cd = str.substring(125,126);
					log.debug("bil_edi_rcv_rslt_cd: " + edi_rcv_rslt_cd );
		        	resultCount = dbDao.addUSATruckEdiWoAckManageList(edi_ctrl_seq, edi_rcv_rslt_cd);										
				} else if (ackhd.equals("990")){
					edi_so_no = str.substring(106,117);
					log.debug("bil_edi_so_no: " + edi_so_no );
					edi_rcv_rslt_cd = str.substring(148,149);
					log.debug("bil_edi_rcv_rslt_cd: " + edi_rcv_rslt_cd );
		        	resultCount = dbDao.addUSATruckEdi990WoAckManageList(edi_so_no, edi_rcv_rslt_cd);				
				}else {				
					throw new DAOException("HEAD TYPE does not exist");  
				}
			}	        	
        } catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return resultCount; 
	
		String delim = "/n";
		StringTokenizer st = new StringTokenizer(str, delim);
		String [] arrStr = new String[ st.countTokens()];
		int cnt = 0;
		
	     while(st.hasMoreElements()){
	    	 arrStr[cnt++] =  (String) st.nextElement();
	     }
		
	     
	     
	     
	}	
	*/
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Continent업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}