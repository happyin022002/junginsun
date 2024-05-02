/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : AGTCustomerAgreementInfoEAIDAO.java
 *@FileTitle : Agent Commission Customer Agreement Information Managemnet
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-18
 *@LastModifier : Hwang GyeongNam
 *@LastVersion : 1.1
 * 2006-12-18 Hwang GyeongNam 최초 생성
 * 2009-04-14 Jong-beom,KIM   CURR_CD 추가
 =========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBCImpl;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtFacAgmtRtVO;
import com.clt.irep.enisEsm.EAIHeaderType;
import com.clt.irep.enisEsm.ESM0570001Document;
import com.clt.irep.enisEsm.ESM0570001Document.ESM0570001;
import com.clt.irep.enisEsm.ESM0570001Document.ESM0570001.DataArea.ContractRateCollection;
import com.clt.irep.enisEsm.ESM0570001Document.ESM0570001.DataArea.ContractRateCollection.ContractRateRequest;
import com.clt.irep.enisEsm.ESM0570001Document.ESM0570001.DataArea.ContractRateCollection.ContractRateResponse;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/**
 * OPUS-agt에 대한 EAI 처리를 담당<br> - OPUS-agt Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTCustomerAgreementInfoBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTCustomerAgreementInfoEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_AGT_008) 구주 FAC 계약 요율의 정보를 등록,수정,삭제 후 OPUS 에 Interface 한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param ArrayList array
	 * @throws DAOException
	 */
	public void multiFACRateInfoInf(ArrayList array) throws DAOException {

		// 2007. 05. 01. Hyunsu modified
		TransferEAI eai = null;
		try {

			log.debug("\n\n ESM057 EAI 연동 -----------start------------ \n\n");

			String target = SubSystemConfigFactory.get("AGT.ESM057.WSDL");

			String result = "";
			String resString = "";
			// TransferEAI eai = null;
			ESM0570001Document docReq = null;
			ESM0570001Document docRes = null;
			ESM0570001 esm0570001 = null;
			EAIHeaderType headerType = null;
			ContractRateCollection contractratecollection = null;
			ContractRateRequest contractRateReq = null;
			ContractRateResponse[] contractRateRes = null;
			HashMap<String, Object> map = null;

			if (array != null) {

				eai = new AxDocClient(target, this.getClass());

				// Request (연동 할 데이타를 XML형식의 데이타셋으로 만든다.) -------start-------
				docReq = ESM0570001Document.Factory.newInstance();
				esm0570001 = docReq.addNewESM0570001();
				headerType = esm0570001.addNewEAIHeader();
				EAIHeaderType.Parameters params = headerType.addNewParameters();
				EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
				headerType.setInstanceId("ESM057-0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
				param.setStringValue("ESM057-0001--Header");

				// 새로운 Collection을 추가한다.
				contractratecollection = esm0570001.addNewDataArea().addNewContractRateCollection();

				Iterator it = array.iterator();

				Calendar cal = Calendar.getInstance();
				long time1 = cal.getTimeInMillis();

				// Loop를 돌면서 데이타를 뽑아온다.
				while (it.hasNext()) {
					map = (HashMap<String, Object>) it.next();

					contractRateReq = contractratecollection.addNewContractRateRequest();
					setContractRateRequest(map, contractRateReq);
				}

				// XML형식의 데이타셋으로 만든다.
				log.info("\n docReq="+docReq);
				eai.setObj(docReq);
				// Request (연동 할 데이타를 XML형식의 데이타셋으로 만든다.) -------end-------

				// Invoke
				log.debug("\n ===========> INVOKE ================>\n");
				// 2007. 05. 01. Hyunsu modified
				resString = eai.commit(headerType.getInstanceId());

				// Response (연동 후 결과값을 받는다.) -------start-------
				docRes = ESM0570001Document.Factory.parse(resString);
				log.info("\n docRes="+docRes);
				esm0570001 = docRes.getESM0570001();
				contractratecollection = esm0570001.getDataArea().getContractRateCollection();
				contractRateRes = contractratecollection.getContractRateResponseArray();

				for (int i = 0; contractRateRes != null && i < contractRateRes.length; i++) {
					result = contractRateRes[i].getEAIRESULT();
				}
				// 연동 후 결과값을 받는다. -------end-------

				// Result 확인 후 Exception 발생시 Exception 처리한다.
				if ((result.toUpperCase()).equals("OK")) {
					log.info("\n\n ESM057 EAI Interface success");
				} else {
					log.error("\n\n ESM057 EAI Interface fail :: \n" + result);
					throw new DAOException(result);
				}

				cal = Calendar.getInstance();
				long time2 = cal.getTimeInMillis();
				long time3 = time2 - time1;

				log.debug("\n 처리 시간 millisecond :: " + time3);
				log.debug("\n 처리 시간 분 :: " + time3 / 1000 / 60 + " 분" + (time3 / 1000) % 60 + " 초 : " + time3 % 1000);
			}

			log.debug("\n\n ESM057 EAI 연동 -----------end------------ \n\n");

		} catch (EAIException e) {
			// 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			// 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		// 2007. 05. 01. Hyunsu modified
		eai.close();

	}

	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param HashMap<String, Object> map
	 * @param ContractRateRequest contractRateReq
	 * @throws Exception
	 */
	private void setContractRateRequest(HashMap<String, Object> map, ContractRateRequest contractRateReq) throws Exception {

		try {
			if (map != null) {

				contractRateReq.setFACOFCCD((String) map.get("FACOFCCD"));
				contractRateReq.setFRTFWRDCNTCD((String) map.get("FRTFWRDCNTCD"));
				contractRateReq.setFRTFWRDCUSTSEQ((String) map.get("FRTFWRDCUSTSEQ"));
				contractRateReq.setSHPRCNTCD((String) map.get("SHPRCNTCD"));
				contractRateReq.setSHPRSEQ((String) map.get("SHPRSEQ"));
				contractRateReq.setPORGRPTPCD((String) map.get("PORGRPTPCD"));
				contractRateReq.setPORROUTCD((String) map.get("PORROUTCD"));
				contractRateReq.setPOLGRPTPCD((String) map.get("POLGRPTPCD"));
				contractRateReq.setPOLROUTCD((String) map.get("POLROUTCD"));
				contractRateReq.setPODGRPTPCD((String) map.get("PODGRPTPCD"));
				contractRateReq.setPODROUTCD((String) map.get("PODROUTCD"));
				contractRateReq.setDELGRPTPCD((String) map.get("DELGRPTPCD"));
				contractRateReq.setDELROUTCD((String) map.get("DELROUTCD"));
				contractRateReq.setBKGRCVTERMCD((String) map.get("BKGRCVTERMCD"));
				contractRateReq.setBKGDETERMCD((String) map.get("BKGDETERMCD"));
				contractRateReq.setFACSGLFLG((String) map.get("FACSGLFLG"));
				contractRateReq.setGRSNETDIVCD((String) map.get("GRSNETDIVCD"));
				contractRateReq.setSVCSCPCD((String) map.get("SVCSCPCD"));
				contractRateReq.setFMEFFDT((String) map.get("FMEFFDT"));
				contractRateReq.setTOEFFDT((String) map.get("TOEFFDT"));
				contractRateReq.setSCNO((String) map.get("SCNO"));
				contractRateReq.setRFANO((String) map.get("RFANO"));
				contractRateReq.setCMDTTPCD((String) map.get("CMDTTPCD"));
				contractRateReq.setCMDTCD((String) map.get("CMDTCD"));
				contractRateReq.setFACDIVCD((String) map.get("FACDIVCD"));
				contractRateReq.setFACTPCD((String) map.get("FACTPCD"));
				contractRateReq.setBKGFACRT((String) map.get("BKGFACRT"));

				// 2008.03.11(sunganj) Double Rate(Special Rate) 추가
				contractRateReq.setFACSPCLCNTRTPCTNT1((String) map.get("FACSPCLCNTRTPCTNT1"));
				contractRateReq.setFACSPCLCNTRRT1((String) map.get("FACSPCLCNTRRT1"));
				contractRateReq.setFACSPCLCNTRTPCTNT2((String) map.get("FACSPCLCNTRTPCTNT2"));
				contractRateReq.setFACSPCLCNTRRT2((String) map.get("FACSPCLCNTRRT2"));

				contractRateReq.setFACBXRT((String) map.get("FACBXRT"));
				contractRateReq.setFACTEURT((String) map.get("FACTEURT"));
				contractRateReq.setFACFEURT((String) map.get("FACFEURT"));
				contractRateReq.setFACRFTEURT((String) map.get("FACRFTEURT"));
				contractRateReq.setFACRFFEURT((String) map.get("FACRFFEURT"));
				contractRateReq.setFACCHGCTNT((String) map.get("FACCHGCTNT"));
				contractRateReq.setFACRTSEQ((String) map.get("FACRTSEQ"));
				contractRateReq.setMSTOPCD((String) map.get("MSTOPCD"));
				contractRateReq.setCREUSRID((String) map.get("CREUSRID"));
				contractRateReq.setCREDT((String) map.get("CREDT"));
				contractRateReq.setUPDUSRID((String) map.get("UPDUSRID"));
				contractRateReq.setUPDDT((String) map.get("UPDDT"));
				contractRateReq.setDTLFACOFCCD((String) map.get("DTLFACOFCCD"));
				contractRateReq.setDTLFRTFWRDCNTCD((String) map.get("DTLFRTFWRDCNTCD"));
				contractRateReq.setDTLFRTFWRDCUSTSEQ((String) map.get("DTLFRTFWRDCUSTSEQ"));
				contractRateReq.setDTLFACRTSEQ((String) map.get("DTLFACRTSEQ"));
				contractRateReq.setROUTREFDIVCD((String) map.get("ROUTREFDIVCD"));
				contractRateReq.setROUTINFOCD((String) map.get("ROUTINFOCD"));
				contractRateReq.setDTLOPCD((String) map.get("DTLOPCD"));
				contractRateReq.setFACSPCLTEURT((String) map.get("FACSPCLTEURT"));
				contractRateReq.setFACSPCLFEURT((String) map.get("FACSPCLFEURT"));

				// 2009-04-14 (kevin) CURR_CD 추가
				contractRateReq.setCURRCD((String) map.get("CURRCD"));

				contractRateReq.setFACDBLFLG((String) map.get("FACDBLFLG"));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param String sts
	 * @param String subject
	 * @param String txtTmp
	 * @param String htmlTmp
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @param String dt
	 * @throws Exception
	 */
	public void sendAGTTemplateMail(String sts, String subject, String txtTmp,
			String htmlTmp, AgtFacAgmtRtVO[] agtFacAgmtRtVOS,
			SignOnUserAccount account, String dt) throws Exception{
		
		String str1 = "agreements";
		String str2 = "them";
		String style_str = "padding:0px; border: #CAE2E9 1px solid; font-family: Arial; font-size: 10px;";
		String ofc_cd = null;
		String iCount = null;
		String recipientsEml = "";
		
//		String[] recipientsEml_arr = null;
//		String[] recipientsName_arr = null;
		StringBuffer tr_str = new StringBuffer();
		
		try{
			if(agtFacAgmtRtVOS.length > 0){
				for(int i=0; i<agtFacAgmtRtVOS.length; i++){
					if(agtFacAgmtRtVOS[i].getCheck().equals("1") && agtFacAgmtRtVOS[i].getCommProcStsCd().equals("RN")){

						tr_str.append("	<tr style='height:20; '>");
						tr_str.append("		<td style='"+style_str+"' align='center'>" + agtFacAgmtRtVOS[i].getFrtFwrdCntCdSeq() + "</td>");
						tr_str.append("		<td style='"+style_str+"' >" + agtFacAgmtRtVOS[i].getFrtFwrdCntNm() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='center'>" + agtFacAgmtRtVOS[i].getFacDivCd() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getBkgFacRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getBkgFacBlAmt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getFacBxRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getFacTeuRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getFacFeuRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getFacRfTeuRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"' align='right'>" + agtFacAgmtRtVOS[i].getFacRfFeuRt() + "</td>");
						tr_str.append("		<td style='"+style_str+"'>" + agtFacAgmtRtVOS[i].getFacChgCtnt() + "</td>");
						tr_str.append("	</tr>");
					}
					log.info("\n agtFacAgmtRtVOS[i].getFacOfcCd()="+agtFacAgmtRtVOS[i].getFacOfcCd());
					log.info("\n agtFacAgmtRtVOS[i].getCnt()="+agtFacAgmtRtVOS[0].getCnt());
					ofc_cd = agtFacAgmtRtVOS[i].getFacOfcCd();
					iCount = agtFacAgmtRtVOS[0].getCnt();
//					recipientsEml_arr = agtFacAgmtRtVOS[i].getRecipientsEml().split(";");
//					recipientsName_arr = agtFacAgmtRtVOS[i].getRecipientsName().split(";");
				}
			}
			
			TemplateMail mailer = new TemplateMail();
			mailer.setHtmlTemplate(htmlTmp); // 테이블형태로 데이타를 보여주기 위해서 html 형식으로만 Mail을 발송한다.
			txtTmp = txtTmp;
			log.info("\n txtTmp="+txtTmp);
			
			// 보내는 사람의 정보를 셋팅한다.
			mailer.setFrom(account.getUsr_eml(), account.getUsr_nm());
			// Title을 셋팅한다.
			mailer.setSubject(subject);
			// Mail 양식에 맞춰 데이타를 셋팅한다.
			mailer.setArg("ofc_cd", ofc_cd);
			mailer.setArg("date", dt==null?"":dt);
			// 받는 사람의 정보를 가져온다.
			log.debug("sts====>"+sts);
			if(sts.equals("RN")) {
				if( Integer.parseInt(iCount) > 0 ) {					
					str1 = "agreement";
					str2 = "it";
				}
				
				// Mail 양식에 맞춰 데이타를 셋팅한다.
				mailer.setArg("cnt", iCount);
				mailer.setArg("str1", str1);
				mailer.setArg("str2", str2);
				mailer.setArg("tr_str", tr_str==null?"":tr_str.toString());

				// 받는 사람의 정보를 가져온다.
				agtFacAgmtRtVOS[0].setRecipientsEml(agtFacAgmtRtVOS[0].getRecipientsEml());
				log.debug("agtFacAgmtRtVOS[0].getRecipientsEml()==>"+agtFacAgmtRtVOS[0].getRecipientsEml());
				String[] recipientsEml_arr = agtFacAgmtRtVOS[0].getRecipientsEml().split(";");
//				String[] recipientsEml_arr = "muezero@gmail.com;".split(";");
				agtFacAgmtRtVOS[0].setRecipientsName(agtFacAgmtRtVOS[0].getRecipientsName());
				String[] recipientsName_arr = agtFacAgmtRtVOS[0].getRecipientsName().split(";");
//				String[] recipientsName_arr = "Ho Jin Lee;".split(";");

				// 받는 사람의 정보를 Loop를 돌면서 셋팅한 후 Mail을 보낸다.
				for(int j=0; recipientsEml_arr!=null && j<recipientsEml_arr.length; j++) {
					
					recipientsEml = recipientsEml_arr[j]==null?"":recipientsEml_arr[j];

					if(recipientsEml.length() > 0) {
						mailer.setRecipient(recipientsEml, recipientsName_arr[j]);
						mailer.setArg("name", recipientsName_arr[j]);
						mailer.send();
						log.info("\n "+j+"번째 recipientsEml :: "+recipientsEml);
						log.info("\n "+j+"번째recipientsName_arr :: "+recipientsName_arr[j]);
					}
				}
//			} else { // 필요없는 구문이지만 차후를 대비해서....
//				// 받는 사람의 정보를 셋팅한 후 Mail을 보낸다.
//				if(fac_rqst_usr_eml.length() > 0) {
//					mailer.setRecipient(fac_rqst_usr_eml, fac_rqst_usr_name);
//					mailer.setArg("name", fac_rqst_usr_name);
//					mailer.send();
//				}
			}
			
			log.info("\n mail send Success");

		}catch (MailerAppException me) {
			//log.debug("\n 메일 발송시 문제 발생 recipients["+recipients+"], recipientsName["+recipientsName+"]: "+me.getMessage());
			log.info("\n Mail Send Error \n"+me.getMessage());
			throw new DAOException(new ErrorHandler(me).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());			
		} 
		
	}
}