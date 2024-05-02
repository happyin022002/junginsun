/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.06.15
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.04.30 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IndiaDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.irep.enisEsm.EAIHeaderType;
import com.hanjin.irep.enisEsm.ESM0720001INDocument;
import com.hanjin.irep.enisEsm.ESM0720001INDocument.ESM0720001IN;
import com.hanjin.irep.enisEsm.ESM0720001INDocument.ESM0720001IN.DataArea.OTSCollection;
import com.hanjin.irep.enisEsm.ESM0720001INDocument.ESM0720001IN.DataArea.OTSCollection.OTS;
import com.hanjin.irep.enisEsm.ESM0720001OUTDocument;
import com.hanjin.irep.enisEsm.ESM0720001OUTDocument.ESM0720001OUT;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;
/**
 * ALPS FullReleaseOrderEAIDAO <br>
 * - ALPS-InboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lim Jin Young
 * @see CargoReleaseOrderBCImpl 참조
 * @since J2EE 1.4
 */
public class CargoReleaseOrderEAIDAO extends EAIDAOSupport {

    private transient Logger log = Logger.getLogger(CargoReleaseOrderEAIDAO.class.getName());

    /**
     * 운임 결재 여부와 Outstanding Amounts 정보를 ERP 시스템으로 부터 조회한다.<br>
     *
     * @param String blNo B/L No
     * @return OtsRcvInfoVO
     * @exception DAOException
     */
	public OtsRcvInfoVO searchOtsInfo(String blNo)throws DAOException {

        TransferEAI transferEAI = null;
        String transferMsg = "";
        OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
        try{

            log.debug("=======================================");
            log.debug("    \n Parameter Marshalling Start!    ");
            log.debug("=======================================");

            //Request Start
            String target = SubSystemConfigFactory.get("BKG.ESM0720001.WSDL");

            ESM0720001INDocument document = ESM0720001INDocument.Factory.newInstance();

            ESM0720001IN esm0720001IN = ESM0720001IN.Factory.newInstance();
            String dateTime = "ESM072_0001" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());

            //Set Header
            EAIHeaderType headerType = esm0720001IN.addNewEAIHeader();
            headerType.setInstanceId(dateTime);

            ESM0720001IN.DataArea dataArea = esm0720001IN.addNewDataArea();

            OTSCollection oTSCollection = dataArea.addNewOTSCollection();
            //OTSCollection oTSCollection = esm0720001.addNewDataArea().addNewOTSCollection();

            //ERP 시스템으로 보낼 파라메서를 세팅한다.
            OTS ots = oTSCollection.addNewOTS();

            ots.setBLNO(blNo);

            oTSCollection.setOTSArray(0, ots);

            dataArea.setOTSCollection(oTSCollection);

            esm0720001IN.setDataArea(dataArea);
            document.setESM0720001IN(esm0720001IN);

            transferEAI = new AxDocClient(target, this.getClass());

            //메세지 전송
            transferEAI.setMessage(document.toString());

            transferMsg = transferEAI.commit(headerType.getInstanceId());

            log.debug("==============================================");
            log.debug("    \n Unmarshalling Response Result Start    ");
            log.debug("==============================================");

            ESM0720001OUTDocument docRes = ESM0720001OUTDocument.Factory.parse(transferMsg);
            ESM0720001OUT esm0720001OUT  = docRes.getESM0720001OUT();

            ESM0720001OUT.DataArea dataAreaRes = esm0720001OUT.getDataArea();

            ESM0720001OUT.DataArea.OTSCollection otsCollectionRes = dataAreaRes.getOTSCollection();

            //ERP 시스템으로 부터 수신 받은 정보를 Value Object에 세팅한다.
            otsRcvInfoVO.setEaiResult(nullToEmpty(otsCollectionRes.getOTSArray(0).getEAIRESULT()));

            otsRcvInfoVO.setCctOtsAmt1(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSAMT1()));
            otsRcvInfoVO.setCctOtsAmt2(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSAMT2()));
            otsRcvInfoVO.setCctOtsAmt3(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSAMT3()));
            otsRcvInfoVO.setCctOtsAmt4(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSAMT4()));
            otsRcvInfoVO.setCctOtsAmt5(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSAMT5()));

            otsRcvInfoVO.setCctOtsCurrCd1(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSCURRCD1()));
            otsRcvInfoVO.setCctOtsCurrCd2(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSCURRCD2()));
            otsRcvInfoVO.setCctOtsCurrCd3(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSCURRCD3()));
            otsRcvInfoVO.setCctOtsCurrCd4(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSCURRCD4()));
            otsRcvInfoVO.setCctOtsCurrCd5(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTOTSCURRCD5()));

            otsRcvInfoVO.setCctRcvDt(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTRCVDT()));
            otsRcvInfoVO.setCctRcvOfcCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTRCVOFCCD()));
            otsRcvInfoVO.setCctRcvUsrId(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTRCVUSRID()));
            otsRcvInfoVO.setCctStsCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getCCTSTSCD()));

            otsRcvInfoVO.setN3ptyCctOtsAmt1(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSAMT1()));
            otsRcvInfoVO.setN3ptyCctOtsAmt2(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSAMT2()));
            otsRcvInfoVO.setN3ptyCctOtsAmt3(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSAMT3()));
            otsRcvInfoVO.setN3ptyCctOtsAmt4(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSAMT4()));
            otsRcvInfoVO.setN3ptyCctOtsAmt5(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSAMT5()));

            otsRcvInfoVO.setN3ptyCctOtsCurrCd1(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSCURRCD1()));
            otsRcvInfoVO.setN3ptyCctOtsCurrCd2(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSCURRCD2()));
            otsRcvInfoVO.setN3ptyCctOtsCurrCd3(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSCURRCD3()));
            otsRcvInfoVO.setN3ptyCctOtsCurrCd4(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSCURRCD4()));
            otsRcvInfoVO.setN3ptyCctOtsCurrCd5(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTOTSCURRCD5()));

            otsRcvInfoVO.setPptRcvDt(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTRCVDT()));
            otsRcvInfoVO.setPptRcvOfcCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTRCVOFCCD()));
            otsRcvInfoVO.setPptRcvUsrId(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTRCVUSRID()));
            otsRcvInfoVO.setPptStsCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTSTSCD()));

            otsRcvInfoVO.setTotOtsAmt1(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSAMT1()));
            otsRcvInfoVO.setTotOtsAmt2(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSAMT2()));
            otsRcvInfoVO.setTotOtsAmt3(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSAMT3()));
            otsRcvInfoVO.setTotOtsAmt4(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSAMT4()));
            otsRcvInfoVO.setTotOtsAmt5(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSAMT5()));

            otsRcvInfoVO.setTotOtsCurrCd1(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSCURRCD1()));
            otsRcvInfoVO.setTotOtsCurrCd2(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSCURRCD2()));
            otsRcvInfoVO.setTotOtsCurrCd3(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSCURRCD3()));
            otsRcvInfoVO.setTotOtsCurrCd4(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSCURRCD4()));
            otsRcvInfoVO.setTotOtsCurrCd5(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSCURRCD5()));

            
            otsRcvInfoVO.setPptOtsAmt1(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSAMT1()));
            otsRcvInfoVO.setPptOtsAmt2(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSAMT2()));
            otsRcvInfoVO.setPptOtsAmt3(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSAMT3()));
            otsRcvInfoVO.setPptOtsAmt4(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSAMT4()));
            otsRcvInfoVO.setPptOtsAmt5(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSAMT5()));

            otsRcvInfoVO.setPptOtsCurrCd1(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSCURRCD1()));
            otsRcvInfoVO.setPptOtsCurrCd2(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSCURRCD2()));
            otsRcvInfoVO.setPptOtsCurrCd3(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSCURRCD3()));
            otsRcvInfoVO.setPptOtsCurrCd4(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSCURRCD4()));
            otsRcvInfoVO.setPptOtsCurrCd5(nullToEmpty(otsCollectionRes.getOTSArray(0).getPPTOTSCURRCD5()));

            otsRcvInfoVO.setN3ptyPptOtsAmt1(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSAMT1()));
            otsRcvInfoVO.setN3ptyPptOtsAmt2(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSAMT2()));
            otsRcvInfoVO.setN3ptyPptOtsAmt3(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSAMT3()));
            otsRcvInfoVO.setN3ptyPptOtsAmt4(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSAMT4()));
            otsRcvInfoVO.setN3ptyPptOtsAmt5(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSAMT5()));

            otsRcvInfoVO.setN3ptyPptOtsCurrCd1(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSCURRCD1()));
            otsRcvInfoVO.setN3ptyPptOtsCurrCd2(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSCURRCD2()));
            otsRcvInfoVO.setN3ptyPptOtsCurrCd3(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSCURRCD3()));
            otsRcvInfoVO.setN3ptyPptOtsCurrCd4(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSCURRCD4()));
            otsRcvInfoVO.setN3ptyPptOtsCurrCd5(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTOTSCURRCD5()));

            // 누락된 컬럼 추가 2010-03-19 안진응
            otsRcvInfoVO.setN3ptyPptStsCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTSTSCD()));
            otsRcvInfoVO.setN3ptyPptRcvOfcCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTRCVOFCCD()));
            otsRcvInfoVO.setN3ptyPptRcvUsrId(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTRCVUSRID()));
            otsRcvInfoVO.setN3ptyPptRcvDt(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYPPTRCVDT()));

            otsRcvInfoVO.setN3ptyCctStsCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTSTSCD()));
            otsRcvInfoVO.setN3ptyCctRcvOfcCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTRCVOFCCD()));
            otsRcvInfoVO.setN3ptyCctRcvUsrId(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTRCVUSRID()));
            otsRcvInfoVO.setN3ptyCctRcvDt(nullToEmpty(otsCollectionRes.getOTSArray(0).getN3PTYCCTRCVDT()));
            
            otsRcvInfoVO.setTotOtsStsCd(nullToEmpty(otsCollectionRes.getOTSArray(0).getTOTOTSSTSCD()));
        } catch (EAIException ex) {

            log.debug("=================================");
            log.debug("    ORACLE EAI 연동 에러 코드    ");
            log.debug("=================================");

            log.debug("getTpErrCode   : "+ex.getTpErrCode());
            log.debug("getTpErrDetail : "+ex.getTpErrDetail());
            log.debug("getTpErrNo     : "+ex.getTpErrNo());

            transferEAI.rollback(ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception e) {
        	transferEAI.rollback(e);
            log.error(e.getMessage(),e);
            throw new DAOException(new ErrorHandler(e).getMessage(), e);
        }
        
        transferEAI.close();
        return otsRcvInfoVO;
    }

    /**
     * 스트링 변환 유틸리티 메소드
     * 스트링이 null이면 빈 스트링을 리턴한다.
     *
     * @param string 체크할 스트링
     * @return String 스트링이 null인 경우 빈 스트링; 스트링이 null이 아닌 경우 스트링 자신
     */
    private String nullToEmpty(String string) {
    	String strRtn = null;
        if (string == null) {
            strRtn = "";
        }else{
            strRtn = string;
        }
        return strRtn;
    }
    
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
	
			
			mail.setBccRcvrEml(fullCntrRlseOrderMailSendVO.getBlindCarbonCopy());
			mail.setCcRcvrEml(fullCntrRlseOrderMailSendVO.getCarbonCopy());		
			mail.setFrom(account.getUsr_eml(),fullCntrRlseOrderMailSendVO.getFrom());		
//			mail.setFrom(fullCntrRlseOrderMailSendVO.getRecipient(),fullCntrRlseOrderMailSendVO.getFrom());		
			mail.setSubject(fullCntrRlseOrderMailSendVO.getSubject());
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
//		List<BkgNtcHisVO> hisVOS = new ArrayList();
//		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		String sndId = "";
		
		try {
			EuDoNtcSendVO listVO = euDoNtcSend;
//			RDMailSendVO[] mailInfos = new RDMailSendVO[1];
			RDMailSendVO mailInfo = new RDMailSendVO();
			List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				
//			String rcvInfo = listVO.getNtcEml();
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

//			strArg = strArg + " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
			
			log.debug("strArg : " + strArg);
			log.debug("*** User ID : " + euDoNtcSend.getUsrId());
			
			//log.debug("----------- strArg "+strArg );
			rdVO.setRdParaCtnt(strArg);
			
//          첨부 파일명을 BL번호로 셋팅			
			rdVO.setXptFileNm("D/O_SMLM" + listVO.getBlNo() +".pdf");
			rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); //pdf 생성.
			
			rdVOs.add(rdVO);

			String title = "[B/L No. " + "SMLM" + listVO.getBlNo() + "] Your container(s) has been released upon your request";

			mailInfo.setSndrNm("SM Line Corporation.,");
			mailInfo.setSndrEml(listVO.getUsrEml());
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
//		List<BkgNtcHisVO> hisVOS = new ArrayList();
//		String[] arrCustCntcTpCd = new String[] { "C1", "C2", "B1", "B2", "AN" };
		
		try {
			EuDoNtcSendVO listVO = euDoNtcSend;
				
			String rcvInfo = listVO.getUsrNm() + ";" + listVO.getNtcFaxNo();
						
			// Fax 정보 설정
			String arrMrd[] = listVO.getMrdId().split("@@");
			String strArg = "/rv";
			String doNo = listVO.getDoNo() + listVO.getDoNoSplit();
			
			strArg = strArg + " form_doNo['" + doNo + "']";
			strArg = strArg + " form_bkgNo['" + listVO.getBkgNo() + "']"; 						
			strArg = strArg + " form_usrId['" + listVO.getUsrId() + "']";
			strArg = strArg + " form_ofcCd['" + listVO.getOfcCd() + "']";
//			strArg = strArg + " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
			
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
			faxInfo.setTitle("");
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
	/**
	 * [0937] E-Mail 전송
	 * @param EuDoNtcSendVO euDoNtcSend
	 * @return String
	 * @exception DAOException 
	 */
	public String sendIndiaDoByEmail(IndiaDoNtcSendVO indiaDoNtcSendVO) throws DAOException{
		// TODO Auto-generated method stub
		InboundNoticeEAIDAO eai = new InboundNoticeEAIDAO();
		String sndId = "";
		try {
			RDMailSendVO mailInfo = new RDMailSendVO();
			List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				
//			String rcvInfo = listVO.getNtcEml();
			// Email 전송
			String mrdId = indiaDoNtcSendVO.getMrdId();
			String arrMrd[] = mrdId.split("@@");

			ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();					
			rdVO.setXptFileNm(arrMrd[0] + ".pdf");
			rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			rdVO.setRdTmpltNm(arrMrd[0] + ".mrd");			
			rdVO.setCreUsrId(indiaDoNtcSendVO.getUsrId());
			rdVO.setUpdUsrId(indiaDoNtcSendVO.getUsrId());
			
			String strArg = "/rv";
			
			String doNo = indiaDoNtcSendVO.getDoNo() + indiaDoNtcSendVO.getDoNoSplit();
			
			strArg = strArg + " form_doNo['" + doNo + "']";
			strArg = strArg + " form_bkgNo['" + indiaDoNtcSendVO.getBkgNo() + "']"; 						
			strArg = strArg + " form_usrId['" + indiaDoNtcSendVO.getUsrId() + "']";
			strArg = strArg + " form_ofcCd['" + indiaDoNtcSendVO.getOfcCd() + "']";
			strArg = strArg + " form_mainOnly['Y']";
			strArg = strArg + " form_inDoOdcyAddrCd['" + indiaDoNtcSendVO.getInDoOdcyAddrCd() + "']";
			strArg = strArg + " form_evntDt['" + indiaDoNtcSendVO.getEvntDt() + "']";
			
			
			if (arrMrd.length == 1) {
				strArg = strArg + " "+ " ";
			} else {
				strArg = strArg + " " + arrMrd[1];
			}

//			strArg = strArg + " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결
			
			log.debug("strArg : " + strArg);
			log.debug("*** User ID : " + indiaDoNtcSendVO.getUsrId());
			
			//log.debug("----------- strArg "+strArg );
			rdVO.setRdParaCtnt(strArg);
			
//          첨부 파일명을 BL번호로 셋팅			
			rdVO.setXptFileNm("D/O_SMLM" + indiaDoNtcSendVO.getBkgNo() +".pdf");
			rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF); //pdf 생성.
			
			rdVOs.add(rdVO);
			
			//Attached survey letter- survey letter should be send to 2 receipents (Customer E-mail & CFS E-mail)
			if("Y".equals(indiaDoNtcSendVO.getAtchSveyLtrFlg()) && ("CU".equals(indiaDoNtcSendVO.getRcvrCd()) || "CFS".equals(indiaDoNtcSendVO.getRcvrCd()))){
				ComRptDsgnXptInfoVO atchRdVO = new ComRptDsgnXptInfoVO();
				ObjectCloner.build(rdVO, atchRdVO);			
				atchRdVO.setXptFileNm("Survey_Letter_"+indiaDoNtcSendVO.getBkgNo()+".pdf");
				atchRdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				atchRdVO.setRdTmpltNm("ESM_BKG_5034.mrd");
				rdVOs.add(atchRdVO);
			}

			String title = "[B/L No. " + "SMLM" + indiaDoNtcSendVO.getBkgNo() + "] Your container(s) has been released upon your request";

			mailInfo.setSndrNm("SM Line Corporation.,");
			mailInfo.setSndrEml(indiaDoNtcSendVO.getUsrEml());
			mailInfo.setRcvrEml(indiaDoNtcSendVO.getNtcEml());
			mailInfo.setRcvrNm(indiaDoNtcSendVO.getCustNm());			
			mailInfo.setEmlTitNm(title);
			mailInfo.setTemplate("ESM_BKG_0936_01T.html");
			mailInfo.setUserId(indiaDoNtcSendVO.getUsrId());
			

			HashMap<String, String> arguments = new HashMap<String, String>();
			arguments.put("rcvrNm", indiaDoNtcSendVO.getCustNm());
			mailInfo.setArguments(arguments);

			//실제 메일 발송
			
			log.debug("Mail Send !!!");
			sndId = eai.sendReportDesignerWithFiles(mailInfo, rdVOs);

	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }

		return sndId;
	}	
}