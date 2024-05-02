/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FuelScgManageBCImpl.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
* 1.1 2015.12.07 [CHM-201539135] Bid 시스템 보완
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event.EsdTrs0940Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration.BiddingCandidateDBDAO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidVndrVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
* ESD-TRS Business Logic Basic Command implementation<br>
* - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
* 
* @author SHIN DONG IL
* @see ESD_TRS_0280EventResponse,FuelScgManageBC 각 DAO 클래스 참조
* @since J2EE 1.6
*/
public class BiddingCandidateBCImpl extends BasicCommandSupport implements BiddingCandidateBC {
	// Database Access Object
	private transient BiddingCandidateDBDAO dbDao=null;
	/**
	 * BiddingCandidateBCImpl 객체 생성<br>
	 * BiddingCandidateDBDAO 생성한다.<br>
	 */
	public BiddingCandidateBCImpl(){
		dbDao = new BiddingCandidateDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBiddingCandidateList(Event e) throws EventException{
		EsdTrs0940Event event = (EsdTrs0940Event)e;
		DBRowSet rowSet 		= null;

		try{
			rowSet = dbDao.searchBiddingCandidateList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bidding Invitatin Vendors 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvitationVendor(Event e) throws EventException{
		EsdTrs0940Event event = (EsdTrs0940Event)e;
		DBRowSet rowSet 		= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			rowSet = dbDao.searchInvitationVendor(event);
		
			String vndr_seq = "";
			String vndr_nm = "";
			String vndr_eml = "";
			String spp_flg = "N";
			
			while(rowSet.next()){
				vndr_seq 	= rowSet.getString("VNDR_SEQ");
				vndr_nm 	= rowSet.getString("VNDR_LGL_ENG_NM");
				vndr_eml  	= rowSet.getString("VNDR_EML");
				spp_flg  	= rowSet.getString("SP_PTAL_EXIST_FLG");
			}
			
			eventResponse.setETCData("vndr_seq", vndr_seq);
			eventResponse.setETCData("vndr_nm",  vndr_nm);
			eventResponse.setETCData("vndr_eml", vndr_eml);
			eventResponse.setETCData("spp_flg",  spp_flg);
			
			return eventResponse;

		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());	
		}
	}
	
	/**
	 * ESD_TRS_0940 OK Event처리 
	 * Spot Bidding data생성
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpotBidManage(Event e, SignOnUserAccount account) throws EventException{
		EsdTrs0940Event event = (EsdTrs0940Event)e;
		try{
			dbDao.multiSpotBidManage(event,account);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());	
		}
	}
	
	/**
	 * ESD_TRS_0940 OK Event처리 
	 * Invitation E-mail 전송
	 * 
	 * @param e Event 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendInvitationVendor(Event e,SignOnUserAccount account) throws EventException{
		EsdTrs0940Event event = (EsdTrs0940Event)e;
		DBRowSet rowSet 		= null;
		
		SpotBidVndrVO[] spotBidVndrVOs = event.getSpotBidVndrVOs();
		
		try{
			
			for(int i = 0 ; i < spotBidVndrVOs.length ; i++ ){
				rowSet = dbDao.multiSpotBiddingInvitationSoList(spotBidVndrVOs[i],event.getSpotBidSoVOs(),account);
				sendMailSpotBiddingInvitaion(spotBidVndrVOs[i],rowSet,account);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_TRS_0940 OK Event처리 
	 * Invitation E-mail 전송
	 * 
	 * @param spotBidVndrVO SpotBidVndrVO
	 * @param rowSet DBRowSet
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendMailSpotBiddingInvitaion(SpotBidVndrVO spotBidVndrVO,DBRowSet rowSet,SignOnUserAccount account) throws EventException{
		Mail mail = null;
    	// TITLE
    	String subject = "(Hanjin Shipping) Invitation to Bid";
    	String sender = "noreply@smlines.com";
    	String sysCd = "TRS";
    	String SndNo="";
    	String strContents = "";
		try {
			String[] arRcvUsrEml = spotBidVndrVO.getVndrEmlAddr().split(";");
//			String[] arRcvUsrEml = {"synergy77@cyberlogitec.com;pjy702@smlines.com"};
			strContents = getInvitationContents(rowSet);
	    	mail = new Mail();
	       	mail.setRdSubSysCd(sysCd);          //System id    	
	    	mail.setSubject(subject);			//e-mail 제목
	    	mail.setFrom(sender);				//발신자 e-mail address 설정
	    	mail.setRecipients(arRcvUsrEml);	//수신자 e-mail address 설정
	    	mail.setHtmlContent(strContents);	//메일 본문내용 설정

		    // SEND MAIL
	    	SndNo = mail.send();
	    	log.info(">>>> SndNo :" +SndNo);
		
		} catch ( MailerAppException me ) {
			throw new EventException(new ErrorHandler(me).getMessage(), me);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);	
		}
	}
	
	/**
	 * 메일 전송할 본문을 생성한다.
	 * @param rowSet DBRowSet
	 * @return String
	 */
	private String getInvitationContents(DBRowSet rowSet) {
		
		StringBuffer sbContents = new StringBuffer();
		
		try {
			sbContents.append("\n<BODY>");
			sbContents.append("\n	<TABLE>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11 align ='center'><img src=http://alps.smlines.com/hanjin/img/report_hanjin_logo.jpg></TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Dear Partners</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>You are hereby invited to submit available rate for spot transportation as general</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>contractor. Please refer to information of bid candidates below.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>If you are interested in this bid, please enter 'Hanjin Shipping Partner Portal' site</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>and submit with rate you can offer for each candidates. The site is as below.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11><a href=http://partner.smlines.com>http://partner.smlines.com</a></TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>If you do not have access of 'Hanjin Shipping Partner Portal' site, please register ID and</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>request Hanjin staff to approve it.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Please be informed that only one partner wins the bid offering reasonable rate for us.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Sincerely yours.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n	</TABLE>");
			sbContents.append("\n	<TABLE   border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;'>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  bgcolor=#CCFFCC align ='center' rowspan=2>Seq</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  bgcolor=#CCFFCC align ='center' rowspan=2>Bid No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' bgcolor=#CCFFCC align ='center' rowspan=2>Due Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:800;' bgcolor=#CCFFCC align ='center' colspan=4>Route</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:600;' bgcolor=#CCFFCC align ='center' colspan=3>Estimated Time</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>EQ No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' bgcolor=#CCFFCC align ='center' colspan=2>CNTR</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Cargo Type</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Trans Mode</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Special Cargo</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center' colspan=2>Weight</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:500;' bgcolor=#CCFFCC align ='center' colspan=5>Over Dimension</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center' rowspan=2>Special Instruction</TD>");

			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>From</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Via</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Door</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>TO</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>From Departure</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>To Arrival</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Door Arrival</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>TP/SZ</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Description</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>KGS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>LBS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Front</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Rear</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Height</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Left</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Right</TD>");
			
			sbContents.append("\n		</TR>");
			while(rowSet.next()){
				sbContents.append("\n		<TR >");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  align ='center'>"+JSPUtil.getNull(rowSet.getString("SEQ"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  align ='center'>"+JSPUtil.getNull(rowSet.getString("SPOT_BID_NO"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPOT_BID_DUE_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("FM_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("VIA_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("DOR_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TO_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("FM_DEPT_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TO_ARVL_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("DOR_ARVL_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_NO"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_TPSZ_CD"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_TPSZ_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CGO_TP_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TRSP_CRR_MOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPCL_CGO_CNTR_TP_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CNTR_KGS_WGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CNTR_LBS_WGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_FWRD_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_BKWD_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_HGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_LF_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_RT_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPCL_INSTR_RMK"),"&nbsp;")+"</TD>");
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
	 * Cancel 메일을 전송한다.
	 * @param singleTransportationVOS SingleTransportationVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendMailSpotBiddingCancel(SingleTransportationVO[] singleTransportationVOS,SignOnUserAccount account) throws EventException{
		Mail mail = null;
		DBRowSet rowSet 		= null;
		DBRowSet rowSetContents	= null;
		DBRowSet rowSetRcvr	= null;
    	String subject = "(Hanjin Shipping) Bid Cancellation";
    	String sender = "noreply@smlines.com";
    	String sysCd = "TRS";
    	String SndNo="";
    	String strContents = "";
    	Integer upd_cd = 0;
    	
		try {
			upd_cd = dbDao.modifySpotBiddingStatus(singleTransportationVOS,account);
			if(upd_cd > 0){
				rowSet = dbDao.searchSpotBiddingInvataionVndr(singleTransportationVOS);
				while(rowSet.next()){
					String[] arRcvUsrEml = null;
//					String[] arRcvUsrEml = {"synergy77@cyberlogitec.com;pjy702@smlines.com"};
					String vndr_seq = rowSet.getString("VNDR_SEQ"); 
					rowSetContents = dbDao.searchSpotBiddingCancelContents(singleTransportationVOS,vndr_seq);
					rowSetRcvr = dbDao.searchSpotBiddingCancelReceiver(singleTransportationVOS,vndr_seq);
					String reverAddr="";
					while(rowSetRcvr.next()){
						reverAddr= rowSetRcvr.getString("VNDR_EML_ADDR");
					}
					arRcvUsrEml = reverAddr.split(";");
					strContents = getInvitationCancelContents(rowSetContents);
			    	mail = new Mail();
			       	mail.setRdSubSysCd(sysCd);          //System id    	
			    	mail.setSubject(subject);			//e-mail 제목
			    	mail.setFrom(sender);				//발신자 e-mail address 설정
			    	mail.setRecipients(arRcvUsrEml);	//수신자 e-mail address 설정
			    	mail.setHtmlContent(strContents);	//메일 본문내용 설정
		
				    // SEND MAIL
			    	SndNo = mail.send();
			    	log.info(">>>> SndNo :" +SndNo);
				}
			}
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
	private String getInvitationCancelContents(DBRowSet rowSet) {
		StringBuffer sbContents = new StringBuffer();
		
		try {
			sbContents.append("\n<BODY>");
			sbContents.append("\n	<TABLE>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11 align =center><img src=http://alps.smlines.com/hanjin/img/report_hanjin_logo.jpg></TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Dear Partners</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Regretfully, corresponding bid is canceled due to one of inevitable various reasons.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>If you would like to see detailed information, please enter ‘Hanjin Shipping </TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Partner Portal’ through the below link.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11><a href=http://partner.smlines.com>http://partner.smlines.com</a></TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Thanks for your join and we would like to meet in the next bid later.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>" );
			sbContents.append("\n			<TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD colspan=11>Sincerely yours.</TD>");
			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n		<TR><TD colspan=11 height=10></TD></TR>");
			sbContents.append("\n	</TABLE>");
			sbContents.append("\n	<TABLE  border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;' >");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  bgcolor=#CCFFCC align ='center' rowspan=2>Seq</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  bgcolor=#CCFFCC align ='center' rowspan=2>Bid No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' bgcolor=#CCFFCC align ='center' rowspan=2>Due Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:800;' bgcolor=#CCFFCC align ='center' colspan=4>Route</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:600;' bgcolor=#CCFFCC align ='center' colspan=3>Estimated Time</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>EQ No</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' bgcolor=#CCFFCC align ='center' colspan=2>CNTR</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Cargo Type</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Trans Mode</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center' rowspan=2>Special Cargo</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center' colspan=2>Weight</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:500;' bgcolor=#CCFFCC align ='center' colspan=5>Over Dimension</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center' rowspan=2>Special Instruction</TD>");

			sbContents.append("\n		</TR>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>From</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Via</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Door</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>TO</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>From Departure</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>To Arrival</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Door Arrival</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>TP/SZ</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' bgcolor=#CCFFCC align ='center'>Description</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>KGS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>LBS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Front</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Rear</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Height</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Left</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Right</TD>");
			
			sbContents.append("\n		</TR>");
			while(rowSet.next()){
				sbContents.append("\n		<TR >");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:30;'  align ='center'>"+JSPUtil.getNull(rowSet.getString("SEQ"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:50;'  align ='center'>"+JSPUtil.getNull(rowSet.getString("SPOT_BID_NO"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPOT_BID_DUE_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("FM_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("VIA_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("DOR_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TO_NOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("FM_DEPT_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TO_ARVL_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;' align ='center'>"+JSPUtil.getNull(rowSet.getString("DOR_ARVL_DT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_NO"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_TPSZ_CD"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("EQ_TPSZ_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CGO_TP_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("TRSP_CRR_MOD_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPCL_CGO_CNTR_TP_NM"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CNTR_KGS_WGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("CNTR_LBS_WGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_FWRD_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_BKWD_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_HGT"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_LF_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("OVR_RT_LEN"),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(rowSet.getString("SPCL_INSTR_RMK"),"&nbsp;")+"</TD>");

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
}