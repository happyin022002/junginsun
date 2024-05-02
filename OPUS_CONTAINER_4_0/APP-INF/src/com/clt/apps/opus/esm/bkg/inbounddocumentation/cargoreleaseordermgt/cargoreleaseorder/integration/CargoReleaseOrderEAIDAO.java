/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.06.15
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.log4j.Logger;
import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoNtcSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
/**
 *   FullReleaseOrderEAIDAO <br>
 * - InboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see CargoReleaseOrderBCImpl 참조
 * @since J2EE 1.4
 */
public class CargoReleaseOrderEAIDAO extends EAIDAOSupport {

    private transient Logger log = Logger.getLogger(CargoReleaseOrderEAIDAO.class.getName());

    /**
	 * Full Container Release Order 화면에서 메일을 발송한다<br>
	 * @param FullCntrRlseOrderMailSendVO fullCntrRlseOrderMailSendVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */
	public String sendEmailByFullCntrReleaseOrder(FullCntrRlseOrderMailSendVO fullCntrRlseOrderMailSendVO , SignOnUserAccount account) throws DAOException{
		String rtnStr = null;
		try {
			TemplateMail mail = new TemplateMail();
			//Mail Attach
			List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
	
			if(fullCntrRlseOrderMailSendVO.getFileKey() != null && 
			   !"".equalsIgnoreCase(fullCntrRlseOrderMailSendVO.getFileKey()) &&
			   !fullCntrRlseOrderMailSendVO.getFileKey().equalsIgnoreCase("null")) {
	
				String[] fileKeys = fullCntrRlseOrderMailSendVO.getFileKey().split(";");
				for(String fileKey:fileKeys){
					SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
					attachedFile.setFileKey(fileKey);
					list.add(attachedFile); 
					mail.setAttachedFile(list);
				}
			}
	
			BookingUtil util = new BookingUtil();
			
			String bccRcvrEml = util.searchBccEmailAddrRSQL("DO");						//20160328.ADD
			log.debug("-------------------- bccRcvrEml : "+bccRcvrEml);					//20160328.ADD	
			//20160328.ADD				
            if( !StringUtils.isBlank(bccRcvrEml) ){	
            	mail.setBccRcvrEml(bccRcvrEml);
            }	 
	
//			mail.setBccRcvrEml(fullCntrRlseOrderMailSendVO.getBlindCarbonCopy());
			mail.setCcRcvrEml(fullCntrRlseOrderMailSendVO.getCarbonCopy());		
			mail.setFrom("shipment.info@notifications.nykline.com","shipment.info@notifications.nykline.com");		
			mail.setSubject("FULL RELEASE ORDER for Shipment reference  " + fullCntrRlseOrderMailSendVO.getBlNo());
			mail.setRecipient(fullCntrRlseOrderMailSendVO.getRecipient());
			mail.setHtmlContent(fullCntrRlseOrderMailSendVO.getContent());
			
			//Template 설정.
			if(fullCntrRlseOrderMailSendVO.getTemplate() != null && !"".equals(fullCntrRlseOrderMailSendVO.getTemplate())){
				mail.setHtmlTemplate(fullCntrRlseOrderMailSendVO.getTemplate());
				
				//Set Arguments
				String argument = fullCntrRlseOrderMailSendVO.getArgument();
				String[] argumentTemplates = argument.split(",");
				for(String argumentTemplate:argumentTemplates){
					String[] argumentSet = argumentTemplate.split(";");
					if(argumentSet.length != 2){
						throw new IllegalArgumentException();
					}
					mail.setArg(argumentSet[0], argumentSet[1]);
				}
			}
			rtnStr = mail.send();
		}catch(MailerAppException mae) {
	        log.error(mae.getMessage(),mae);
	        throw new DAOException(new ErrorHandler(mae).getMessage(), mae);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
		return rtnStr;
	}
	
	/**
	 * [0937] E-Mail 전송
	 * @param EuDoNtcSendVO euDoNtcSend
	 * @return String
	 * @exception DAOException 
	 */
	public String sendEuDoByEmail(EuDoNtcSendVO euDoNtcSend) throws DAOException{
		// TODO Auto-generated method stub
		InboundNoticeEAIDAO eai = new InboundNoticeEAIDAO();
		String sndId = "";
		
		try {
			EuDoNtcSendVO listVO = euDoNtcSend;
			RDMailSendVO mailInfo = new RDMailSendVO();
			List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				
			// Email 전송
			String mrdId = listVO.getMrdId();
			String arrMrd[] = mrdId.split("@@");

			ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();					
			rdVO.setXptFileNm(arrMrd[0] + ".pdf");
			rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			rdVO.setRdTmpltNm(arrMrd[0] + ".mrd");			
			rdVO.setCreUsrId(euDoNtcSend.getUsrId());
			rdVO.setUpdUsrId(euDoNtcSend.getUsrId());
			
			String strArg = "/rv";
			
			String doNo = listVO.getDoNo() + listVO.getDoNoSplit();
			
			strArg = strArg + " form_doNo['" + doNo + "']";
			strArg = strArg + " form_bkgNo['" + listVO.getBkgNo() + "']"; 						
			strArg = strArg + " form_usrId['" + listVO.getUsrId() + "']";
			strArg = strArg + " form_ofcCd['" + listVO.getOfcCd() + "']";
			if (arrMrd.length == 1) {
				strArg = strArg + " "+ " ";
			} else {
				strArg = strArg + " " + arrMrd[1];
			}

			log.debug("strArg : " + strArg);
			log.debug("*** User ID : " + euDoNtcSend.getUsrId());
			
			rdVO.setRdParaCtnt(strArg);
			
//          첨부 파일명을 BL번호로 셋팅			
			rdVO.setXptFileNm("D/O_" + ConstantMgr.getScacCode() + listVO.getBlNo() +".pdf");
			rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); //pdf 생성.
			
			rdVOs.add(rdVO);

			// 20151006 안진응 수정
//			String title = "[B/L No. " + ConstantMgr.getScacCode() + listVO.getBlNo() + "] Your container(s) has been released upon your request";
			
			
			BookingUtil util = new BookingUtil();
			
			String bccRcvrEml = util.searchBccEmailAddrRSQL("DO");						//20160328.ADD
			log.debug("-------------------- bccRcvrEml : "+bccRcvrEml);					//20160328.ADD	
			//20160328.ADD				
            if( !StringUtils.isBlank(bccRcvrEml) ){	
            	mailInfo.setBccRcvrEml(bccRcvrEml);
            }	
			
			String title = "FULL RELEASE ORDER for Shipment reference  " + listVO.getBlNo();

			mailInfo.setSndrNm("shipment.info@notifications.nykline.com");
			mailInfo.setSndrEml("shipment.info@notifications.nykline.com");
			mailInfo.setRcvrEml(listVO.getNtcEml());
			mailInfo.setRcvrNm(listVO.getCustNm());			
			mailInfo.setEmlTitNm(title);
			mailInfo.setTemplate("ESM_BKG_0937_01T.html");
			mailInfo.setUserId(listVO.getUsrId());
			

			HashMap<String, String> arguments = new HashMap<String, String>();
			arguments.put("rcvrNm", listVO.getCustNm());
			mailInfo.setArguments(arguments);

			//실제 메일 발송
			
			log.debug("메일 전송 보내거라.");
			sndId = eai.sendReportDesignerWithFiles(mailInfo, rdVOs);

	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }

		return sndId;
	}
	
	/**
	 * [0381] Fax 전송
	 * @param EuDoNtcSendVO euDoNtcSend
	 * @return String
	 * @exception DAOException 
	 */
	public String sendEuDoByFax(EuDoNtcSendVO euDoNtcSend) throws DAOException{

		InboundNoticeEAIDAO eai = new InboundNoticeEAIDAO();
		
		try {
			EuDoNtcSendVO listVO = euDoNtcSend;
				
			String rcvInfo = listVO.getCustNm()+ ";" + listVO.getNtcFaxNo();
						
			// Fax 정보 설정
			String arrMrd[] = listVO.getMrdId().split("@@");
			String strArg = "/rv";
			String doNo = listVO.getDoNo() + listVO.getDoNoSplit();
			
			strArg = strArg + " form_doNo['" + doNo + "']";
			strArg = strArg + " form_bkgNo['" + listVO.getBkgNo() + "']"; 						
			strArg = strArg + " form_usrId['" + listVO.getUsrId() + "']";
			strArg = strArg + " form_ofcCd['" + listVO.getOfcCd() + "']";
			
			log.debug("strArg : " + strArg);
			
			FaxSendVO faxInfo = new FaxSendVO();
			faxInfo.setSysCd("BKG");
			faxInfo.setTmplMrd(arrMrd[0] + ".mrd");	//mrd id
			if (arrMrd.length == 1) {
				faxInfo.setTmplParam("");//mrd param
			} else {
				faxInfo.setTmplParam(arrMrd[1]);//mrd param
			}
			faxInfo.setBatchFlg("N");
			faxInfo.setTitle("EU Delivery Order(BL#: "+listVO.getBkgNo()+")");
			faxInfo.setTmplParam(strArg); // R.D 에 넘겨질 Parameter
			faxInfo.setRcvInfo(rcvInfo);// fax_no 를 , 로 연결한 문자열
			faxInfo.setOffice(listVO.getOfcCd());
			faxInfo.setCrtUserId(listVO.getUsrId());

			// Fax 전송
			String retFaxSndId;		
			retFaxSndId = eai.sendFax(faxInfo);

			return retFaxSndId;

        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
}