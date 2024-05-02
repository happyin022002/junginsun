/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBCImpl.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.21 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration.FaxEmailDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration.FaxEmailEAIDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailChgDeltNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeBasicCmdtVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailSalesRepVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-DMTClosing Business Logic Basic Command implementation<br>
 * - NIS2010-DMTClosing에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author  
 * @see EES_DMT_2009EventResponse,FaxEmailBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class FaxEmailBCImpl extends BasicCommandSupport implements FaxEmailBC {
	
	// Database Access Object
	private transient FaxEmailDBDAO 	faxEmailDBDAO 	= null;
	private transient FaxEmailEAIDAO 	faxEmailEAIDAO 	= null;
	
	/**
	 * FaxEmailBCImpl 객체 생성<br>
	 * faxEmailDBDAO 생성한다.<br>
	 * faxEmailEAIDAO 생성한다.<br>
	 */
	public FaxEmailBCImpl() {
		faxEmailDBDAO 	= new FaxEmailDBDAO();
		faxEmailEAIDAO 	= new FaxEmailEAIDAO();
	}
	
	/**
	 * [E-Mail] : []
	 * [Approval, Counter Offer, Reject 된 Before 나 After Booking] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @exception EventException
	 */
	public void sendGRWEmail(GRWEmailNoticeVO gRWEmailNoticeVO) throws EventException {
		try {
			faxEmailEAIDAO.sendGRWMail(gRWEmailNoticeVO);
		}
		catch(MailerAppException e) {
			throw new EventException("DMT02036");
		}
	}
	
	/**
	 * [Approval, Counter Offer, Reject 된 After Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchAfterBookingUserEmailByDARNo(String darNo) throws EventException {
		try {
			return faxEmailDBDAO.searchAfterBookingUserEmailByDARNo(darNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [Approval, Counter Offer, Reject 된 Before Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @param String mapgSeq
	 * @param String verNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchBeforeBookingUserEmailByDARNo(String darNo, String mapgSeq, String verNo) throws EventException {
		try {
			return faxEmailDBDAO.searchBeforeBookingUserEmailByDARNo(darNo, mapgSeq, verNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
   /**
    * [Invoice Cancel Info]을 [Email Send] 합니다.<br>
    * 
    * @param String receiver
    * @param String sender
    * @param String content
    * @return String
    * @throws EventException 
    * @exception EventException
    */
    public String sendEmailforCancelInvoice(String receiver, String sender, String content) throws EventException {
    	  
    	log.debug("\n [FaxEmailBCImpl.[sendEmailforCancelInvoice]] :::::> START ");
    	String sndNo = null;
    	try {
    		GRWEmailNoticeVO emailVO = new GRWEmailNoticeVO();

    		emailVO.setSender(		sender			);
    		emailVO.setRecipient(	receiver		);
    		emailVO.setSubject(		content			);
    		emailVO.setTextcontent(	content			);
      		
          	sndNo = faxEmailEAIDAO.sendEmailforCancelInvoice(emailVO);
        } 
    	catch (Exception e) {
	      	log.error("[Exception]"+e.getMessage());
	        throw new EventException(e.getMessage());
        }
    	log.debug("\n [FaxEmailBCImpl.[sendEmailforCancelInvoice]] :::::> EML_SND_NO : " + sndNo);
    	log.debug("\n [FaxEmailBCImpl.[sendEmailforCancelInvoice]] :::::> END ");
      	return sndNo;
      }	
    

	/**
	 * [E-Mail] : []
	 * [Basic Tariff, Commodity Exception] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO
	 * @param List<GRWEmailNoticeBasicCmdtVO> noticeXmlVOs
	 * @exception EventException
	 */
	public void sendGRWEmailBasicCmdt(GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO, List<GRWEmailNoticeBasicCmdtVO> noticeXmlVOs) throws EventException {

		String strMailContents = "";
		
		try {

			SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
			String fileCreDt    = fileDateFormat.format(new Date());
			
			//첨부 Excel내용 생성
			strMailContents = getMailContents(noticeXmlVOs);
			
			List<SingleMailAttachedFile>  arFileList = new ArrayList<SingleMailAttachedFile>();	
			SingleMailAttachedFile atchFile = new SingleMailAttachedFile();

			String fileName = gRWEmailNoticeBasicCmdtVO.getTpCd() + "("+fileCreDt+").xls";
			
			atchFile.setFileName(fileName);
			log.info(">>>>> file name : "+atchFile.getFileName());
			
			atchFile.setFileContent(strMailContents);
	    	arFileList.add(atchFile);
			
			faxEmailEAIDAO.sendGRWEmailBasicCmdt(gRWEmailNoticeBasicCmdtVO, arFileList);
		}
		catch(MailerAppException e) {
			throw new EventException("DMT02036");
		} 
	}
	

	/**
	 * e-mail 첨부 Excel 파일 내용 생성
	 * @param ctntInfoList
	 * @param sysCd
	 * @return String
	 */
	private String getMailContents(List<GRWEmailNoticeBasicCmdtVO> noticeXmlVOs) {
		StringBuffer sbContents = new StringBuffer();
		try {
			sbContents.append("\n<BODY>");

			sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1250;'>");

			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Coverage</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;'  bgcolor=#CCFFCC align ='center'>DMT Tariff type</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>Org</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>BKG Term</TD>");
			if ( " ".equals(noticeXmlVOs.get(0).getCmdt())){
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;'  bgcolor=#CCFFCC align ='center'>Group Name</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;'  bgcolor=#CCFFCC align ='center'>CNTR Type</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:200;'  bgcolor=#CCFFCC align ='center'>Cargo Type</TD>");
			} else {
				sbContents.append("\n			<TD style='border:1px solid #666666;width:300;'  bgcolor=#CCFFCC align ='center'>Commodity</TD>");
			}
			
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Effective Date</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Expire Date</TD>");
			sbContents.append("\n		</TR>");
			for(int i=0; i<noticeXmlVOs.size(); i++){
				sbContents.append("\n		<TR >");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getCovrg(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getDmdtTrfCd(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getOrgDest(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getDmdtDeTermNm(),"&nbsp;")+"</TD>");		
				if ( " ".equals(noticeXmlVOs.get(0).getCmdt())){
					sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getDmdtBzcTrfGrpNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getDmdtCntrTpNm(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getDmdtCgoTpNm(),"&nbsp;")+"</TD>");
				} else {
					sbContents.append("\n			<TD style='border:1px solid #666666;width:300;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getCmdt(),"&nbsp;")+"</TD>");
				}
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getEffDt(),"&nbsp;")+"</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'>"+JSPUtil.getNull(noticeXmlVOs.get(i).getExpDt(),"&nbsp;")+"</TD>");
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
	 * [Charge Deletion 요청에 대해 Approval, Reject 처리시 하위 Office 결재자들에게 Notice] 를 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO
	 * @return String
	 * @throws MailerAppException
	 */	
	public String sendChgDeltNoticeGWMail(GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO) throws EventException {
		
		try {
			return faxEmailEAIDAO.sendChgDeltNoticeGWMail(gRWEmailChgDeltNoticeVO);
		}
		catch(MailerAppException e) {
			throw new EventException("DMT02036");
		}
	}    

	/**
	 * [E-Mail] : Sales Rep. Email Send 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @param List<GRWEmailSalesRepVO> salesRepList
	 * @exception EventException
	 */
	public void sendEmailSalesRep(GRWEmailNoticeVO gRWEmailNoticeVO, List<GRWEmailSalesRepVO> salesRepList) throws EventException {

		String strMailContents = "";
		
		try {

			SimpleDateFormat fileDateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			String fileCreDt    = fileDateFormat.format(new Date());
			
			//첨부 Excel내용 생성
			strMailContents = getMailSalesRepDetail(salesRepList, fileCreDt);

			log.info(">>>>>"+strMailContents);
			
			gRWEmailNoticeVO.setComments(strMailContents);
			
			faxEmailEAIDAO.sendEmailSalesRep(gRWEmailNoticeVO);
		}
		catch(MailerAppException e) {
			throw new EventException("DMT02036");
		}
	}
	

	/**
	 * e-mail 첨부 Excel 파일 내용 생성
	 * @param ctntInfoList
	 * @param sysCd
	 * @return String
	 */
	private String getMailSalesRepDetail(List<GRWEmailSalesRepVO> salesRepListVOs, String fileCreDt) {
		StringBuffer sbContents = new StringBuffer();
		try {


			sbContents.append("\n(As of " + fileCreDt + " )&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                                                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                                                          "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Cur : USD )");
			
			sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:650;'>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>TTL OTS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&#8804;15days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;30days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;60days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;90days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&#8804;180days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&lt;180days</TD>");
			sbContents.append("\n		</TR>");	

			sbContents.append("\n		<TR >");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtlOts(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtl15Ots(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtl30Ots(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtl60Ots(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtl90Ots(),"&nbsp;")+"&nbsp;</TD>");	
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtl180Ots(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(0).getTtlOver180Ots(),"&nbsp;")+"&nbsp;</TD>");
			sbContents.append("\n		</TR>");	

			sbContents.append("\n	</TABLE>");		

			sbContents.append("\n	    <br>");	

			sbContents.append("\n<TABLE border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;width:1250;'>");
			sbContents.append("\n		<TR>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Office Code</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>Sales Rep</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;'  bgcolor=#CCFFCC align ='center'>Sales Rep Name</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>CUSTOMER CODE</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:150;'  bgcolor=#CCFFCC align ='center'>CUSTOMER NAME</TD>");
			
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>TTL OTS</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&#8804;15days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;30days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;60days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' bgcolor=#CCFFCC align ='center'>&#8804;90days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&#8804;180days</TD>");
			sbContents.append("\n			<TD style='border:1px solid #666666;width:100;'  bgcolor=#CCFFCC align ='center'>&lt;180days</TD>");
			sbContents.append("\n		</TR>");	
			
			String ofc_cd = "";
			int    ofc_cnt = 0;
			String salRep = "";
			int    salRep_cnt = 0;
			String custCd = "";
			int    cust_cnt = 0;
			for(int i=1; i<salesRepListVOs.size(); i++){

				sbContents.append("\n		<TR >");
				
				if ( !ofc_cd.equals(salesRepListVOs.get(i).getOfcCd())){
					
					ofc_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())){
							ofc_cnt = ofc_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+ofc_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getOfcCd(),"&nbsp;")+"</TD>");
					ofc_cd = salesRepListVOs.get(i).getOfcCd();
					
					
					salRep_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())
								&& salesRepListVOs.get(i).getSalRep().equals(salesRepListVOs.get(j).getSalRep())){
							salRep_cnt = salRep_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+salRep_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getSalRep(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='left'; rowspan="+salRep_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getSalRepNm(),"&nbsp;")+"</TD>");
					salRep = salesRepListVOs.get(i).getSalRep();
					
					cust_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())
								&& salesRepListVOs.get(i).getSalRep().equals(salesRepListVOs.get(j).getSalRep())
								&& salesRepListVOs.get(i).getCustCd().equals(salesRepListVOs.get(j).getCustCd())){
							cust_cnt = cust_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustCd(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='left'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustNm(),"&nbsp;")+"</TD>");
					custCd = salesRepListVOs.get(i).getCustCd();
					
				} else if ( !salRep.equals(salesRepListVOs.get(i).getSalRep())){
					
					salRep_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())
								&& salesRepListVOs.get(i).getSalRep().equals(salesRepListVOs.get(j).getSalRep())){
							salRep_cnt = salRep_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+salRep_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getSalRep(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='left'; rowspan="+salRep_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getSalRepNm(),"&nbsp;")+"</TD>");
					salRep = salesRepListVOs.get(i).getSalRep();

					cust_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())
								&& salesRepListVOs.get(i).getSalRep().equals(salesRepListVOs.get(j).getSalRep())
								&& salesRepListVOs.get(i).getCustCd().equals(salesRepListVOs.get(j).getCustCd())){
							cust_cnt = cust_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustCd(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='left'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustNm(),"&nbsp;")+"</TD>");
					custCd = salesRepListVOs.get(i).getCustCd();
					
				} else if ( !custCd.equals(salesRepListVOs.get(i).getCustCd())){
					cust_cnt = 0;
					for(int j=1; j<salesRepListVOs.size(); j++){
						if ( salesRepListVOs.get(i).getOfcCd().equals(salesRepListVOs.get(j).getOfcCd())
								&& salesRepListVOs.get(i).getSalRep().equals(salesRepListVOs.get(j).getSalRep())
								&& salesRepListVOs.get(i).getCustCd().equals(salesRepListVOs.get(j).getCustCd())){
							cust_cnt = cust_cnt + 1;
						}
					}
					sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='center'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustCd(),"&nbsp;")+"</TD>");
					sbContents.append("\n			<TD style='border:1px solid #666666;width:150;' align ='left'; rowspan="+cust_cnt+">"+JSPUtil.getNull(salesRepListVOs.get(i).getCustNm(),"&nbsp;")+"</TD>");
					custCd = salesRepListVOs.get(i).getCustCd();
				}
				
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtlOts(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtl15Ots(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtl30Ots(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtl60Ots(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtl90Ots(),"&nbsp;")+"&nbsp;</TD>");	
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtl180Ots(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n			<TD style='border:1px solid #666666;width:100;' align ='right'>"+JSPUtil.getNull(salesRepListVOs.get(i).getTtlOver180Ots(),"&nbsp;")+"&nbsp;</TD>");
				sbContents.append("\n		</TR>");	
			}
			sbContents.append("\n	</TABLE>");

		} catch ( Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return sbContents.toString();

	}
    
}
