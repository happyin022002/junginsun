/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingReceiptEAIDAO.java
 *@FileTitle : EDI test
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.05 전용진
 * 1.0 Creation 
 * 2011.01.18 전성진 [] 에러메일 수신인 추가
 * 2011.04.18 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청
 * 2011.04.21 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청 - sendXterRqstNotice() 삭제
 * 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용 - 이메일 주소 변경
 * 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 * 2012.07.20 김진주 e-BKG 수신 오류 메일발송대상 추가(EBD - Dcube admin계정)
 * 2012.11.09 김진주 e-BKG 수신 오류 메일발송대상 변경
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.syscommon.common.table.CrmMdmVO;
import com.hanjin.syscommon.common.util.CrmIfUtil;

import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;


/**
 * ALPS EBookingReceiptEAIDAO <br>
 * - ALPS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class CustMainEAIDAO extends EAIDAOSupport {
	/**
	 * Customer master Interface.<br>
	 *
	 * @param String usrId
	 * @param customerVO CustomerVO
	 * @exception EAIException
	 */
	public void sendCustomerToMdm(CustomerVO customerVO, String usrId, String creFlag) throws EAIException  {
		TransferEAI eai  = null;
		try {
			log.debug("=======================================");
			log.debug("    \n Parameter Marshalling Start!    ");
			log.debug("=======================================");
			String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			CrmIfUtil crmUtil = new CrmIfUtil("MDM064-0001");
			CrmMdmVO crmMdmVO = new CrmMdmVO();
			crmUtil.setInstanceId("MDM064-0001J" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
			crmUtil.setMsgTypeName("CRM CUSTOMER MASTER");
			crmUtil.setMsgTypeCode("MDM013-0001");
			
			crmMdmVO.setCustLglEngNm(customerVO.getCustLglEngNm());
			if(customerVO.getGrpIndivDiv() != null && "G".equals(customerVO.getGrpIndivDiv())){
				crmMdmVO.setCustCd(customerVO.getCustCd());
				//crmMdmVO.setCustGrpCd(customerVO.getCustCd());
				//crmMdmVO.setCustCd(customerVO.getCustRowId());
			} else {
				if("Y".equals(creFlag)) {
					crmMdmVO.setCustCd("");
				}
				else {
					crmMdmVO.setCustCd(customerVO.getCustCd());
				}
			}
			crmMdmVO.setMsgEtt("CRM CUSTOMER MASTER");
			crmMdmVO.setSrcSysCd("CRM");
			crmMdmVO.setCustStsCd(customerVO.getCustStsCd());
			crmMdmVO.setCntCd(customerVO.getCustCntCd());
			crmMdmVO.setGrpIndivDiv(customerVO.getGrpIndivDiv());
			crmMdmVO.setLocCd(customerVO.getLocCd());
			crmMdmVO.setMstOfcId(customerVO.getOfcCd());
			crmMdmVO.setRgnAcctFlg(customerVO.getRgnAcctFlg());
			crmMdmVO.setGloAcctFlg(customerVO.getGloAcctFlg());
			crmMdmVO.setSrepCd(customerVO.getSrepCd());
			crmMdmVO.setPtyAddr(customerVO.getBzetAddr());
			
			crmMdmVO.setCustRowId(customerVO.getCustRowId());
			crmMdmVO.setCreUsrId(customerVO.getCreUsrId());
			crmMdmVO.setUpdUsrId(customerVO.getUpdUsrId());
			crmMdmVO.setStsCd("A");
			crmMdmVO.setMsgId("MDM013-0001");
			crmMdmVO.setMsgCreDt(timeStamp);
			crmMdmVO.setObjRowId(customerVO.getCustRowId());
			crmMdmVO.setAddrRowId(customerVO.getAddrRowId());
			
			if(customerVO.getGrpIndivDiv() != null && "I".equals(customerVO.getGrpIndivDiv())){
				crmMdmVO.setRvisCntrCustTpCd(customerVO.getRvisCntrCustTpCd());
				crmMdmVO.setSteCd(customerVO.getSteCd());
				crmMdmVO.setRfAcctFlg(customerVO.getRfAcctFlg());
				crmMdmVO.setPrfSvcDtlDesc(customerVO.getPrfSvcDtlDesc());
				crmMdmVO.setMltTrdAcctFlg(customerVO.getMltTrdAcctFlg());
				crmMdmVO.setOtiOrzNo(customerVO.getOtiOrzNo());
				crmMdmVO.setAddrTpCd(customerVO.getAddrTpCd());
				crmMdmVO.setCtyNm(customerVO.getCtyNm());
				crmMdmVO.setBkgAlert(customerVO.getBkgAltRsn());
				crmMdmVO.setBkgAlertStart(customerVO.getBkgAltFmDt().replaceAll("-",""));
				crmMdmVO.setBkgAlertEnd(customerVO.getBkgAltToDt().replaceAll("-",""));
				crmMdmVO.setBkgAlertMess(customerVO.getBkgAltMsg());
				crmMdmVO.setBkgAlertCreated(customerVO.getBkgAltCreDt());
				crmMdmVO.setCustRgstNo(customerVO.getCustRgstNo());
				crmMdmVO.setCtsNo(customerVO.getCtsNo());
				crmMdmVO.setIntlMnPhnNo(customerVO.getIntlPhnNo());
				crmMdmVO.setIntlMnFaxNo(customerVO.getIntlFaxNo());
				crmMdmVO.setFullMnPhnNo(customerVO.getPhnNo());
				crmMdmVO.setFullMnFaxNo(customerVO.getFaxNo());
				crmMdmVO.setCustUrl(customerVO.getCustUrl());
				crmMdmVO.setCustEml(customerVO.getCustEml());
				crmMdmVO.setCrntVolKnt(customerVO.getCrntVolKnt());
				crmMdmVO.setPrfGrpCmdtCd(customerVO.getPrfGrpCmdtCd());
				crmMdmVO.setCustGrpCd(customerVO.getCustGrpId());
				crmMdmVO.setFrtFwrdFmcNo(customerVO.getFrtFwrdFmcNo());
				crmMdmVO.setNvoccBdStrtEffDt(customerVO.getNvoccBdStEffDt());
				crmMdmVO.setNvoccBdEndEffDt(customerVO.getNvoccBdEndEffDt());
				crmMdmVO.setNvoccHjsScacCd(customerVO.getNvoccHjsScacCd());
				crmMdmVO.setNvoccBdNo(customerVO.getNvoccBdNo());
				crmMdmVO.setNvoccBdAmt(customerVO.getNvoccBdAmt());
				crmMdmVO.setNvoccLicNo(customerVO.getNvoccLicNo());
				crmMdmVO.setCustRmk(customerVO.getCustRmk());
				crmMdmVO.setPrfSvcDesc(customerVO.getPrfSvcDesc());
				crmMdmVO.setKeyAcctMgrGloUsrId(customerVO.getKeyAcctMgrUsrId());
				crmMdmVO.setKeyAcctMgrGloUsrNm(customerVO.getKeyAcctMgrUsrNm());
				crmMdmVO.setKeyAcctStrtEffDt(customerVO.getKeyAcctStEffDt().replaceAll("-",""));
				crmMdmVO.setKeyAcctFlg(customerVO.getKeyAcctFlg());
				crmMdmVO.setPrfRepreCmdtCd(customerVO.getPrfRepCmdtCd());
				crmMdmVO.setNewKeyAcctFlg(customerVO.getNewKeyAcctFlg());
				crmMdmVO.setSpclReqDesc(customerVO.getSpclReqDesc());
				crmMdmVO.setPrfCntrTpszCd(customerVO.getPrfCntrTpszCd());
				crmMdmVO.setNamedBIZ(customerVO.getNmdCustFlg());
				crmMdmVO.setZipCd(customerVO.getZipCd());
				crmMdmVO.setCpetiDesc(customerVO.getCmptDesc());
			}
			
			if("Y".equals(creFlag)){
				crmMdmVO.setOpCd("C");
			} else {
				if (customerVO.getDeltFlg().equals("Y")) {
					crmMdmVO.setOpCd("D");
				} else {
					crmMdmVO.setOpCd("U");
				}
			}

			crmUtil.addNewData(crmMdmVO.getColumnValues());
			crmUtil.createdMsg();
			
			//System.out.println(crmUtil.toString());

			String url = SubSystemConfigFactory.get("COM.CRM.JMS.SEND.URL");
			log.error("COM.CRM.JMS.SEND.URL : " + url);
    		eai = new WeblogicSendQClient(url, this.getClass());

            log.error("document:"+ crmUtil.toString());
       		eai.setFactory(SubSystemConfigFactory.get("COM.CRM.JMS.FACTORY")); 
       		eai.setQueue(SubSystemConfigFactory.get("COM.CRM.JMS.QUEUE"));  

       		log.debug("========================ERR Msg Interface Start===================================");
	        eai.setMessage(crmUtil.toString()); 
	        eai.setDestination("MDM064-0001");
	        
	        eai.commit(crmUtil.getInstanceId());
	        log.debug("========================ERR Msg Interface End===================================");

		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} finally { // 2011.07.14
			if ( eai != null ) {
				eai.close();
			}		
		}
	}
	
	public void sendCustAddrToMdm(CustomerAddressVO customerAddressVO, String usrId) throws EAIException  {
		TransferEAI eai  = null;
		try {
			log.debug("=======================================");
			log.debug("    \n Parameter Marshalling Start!    ");
			log.debug("=======================================");
			String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			CrmIfUtil crmUtil = new CrmIfUtil("MDM065-0001");
			CrmMdmVO crmMdmVO = new CrmMdmVO();
			crmUtil.setInstanceId("MDM065-0001J" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
			crmUtil.setMsgTypeName("CRM CUSTOMER ADDRESS USAGE");
			crmUtil.setMsgTypeCode("MDM014-0001");
			
			crmMdmVO.setAddrTpCd(customerAddressVO.getAddrTpCd());
			if(customerAddressVO.getIbflag().equals("I")){
				crmMdmVO.setOpCd("C");
			} else {
				crmMdmVO.setOpCd("U");
			}
			
			if(customerAddressVO.getDeltFlg().equals("Y")){
				crmMdmVO.setStsCd("D");
			} else {
				crmMdmVO.setStsCd("A");
			}

			crmMdmVO.setCtyNm(customerAddressVO.getCtyNm());
			/*crmMdmVO.setObjRowId(customerAddressVO.getObjRowId());
			crmMdmVO.setParObjRowId(customerAddressVO.getParObjRowId());
			crmMdmVO.setAddrRelRowId(customerAddressVO.getAddrRelRowId());*/
			if(customerAddressVO.getPrmryChkFlg().equals("0") || customerAddressVO.getPrmryChkFlg().equals("N")){
				crmMdmVO.setPrmryChkFlg("N");
			} else {
				crmMdmVO.setPrmryChkFlg("Y");
			}
			
			crmMdmVO.setUserKey("");
			crmMdmVO.setSteCd(customerAddressVO.getSteCd());
			crmMdmVO.setPtyAddr(customerAddressVO.getBzetAddr());
			crmMdmVO.setCustRowId(customerAddressVO.getCrmRowId());
			crmMdmVO.setCntCd(customerAddressVO.getCntCd());
			crmMdmVO.setCustCd(customerAddressVO.getCustCd());
			
			crmMdmVO.setCreUsrId(customerAddressVO.getCreUsrId());
			if(customerAddressVO.getIbflag().equals("I")){
				crmMdmVO.setAddrRowId("ALPS-"+customerAddressVO.getAddrSeq());
			}
			else {
				crmMdmVO.setAddrRowId(customerAddressVO.getAddrRowId());
			}
			crmMdmVO.setUpdUsrId(customerAddressVO.getUpdUsrId());
			crmMdmVO.setMsgCreDt(timeStamp);
			crmMdmVO.setSrcSysCd("CRM");
			crmMdmVO.setMsgEtt("CRM CUSTOMER MASTER USAGE");
			crmMdmVO.setMsgId("MDM014-0001");
			crmMdmVO.setZipCd(customerAddressVO.getZipCd());

			crmUtil.addNewData(crmMdmVO.getColumnValues());
			crmUtil.createdMsg();
			
			//System.out.println(crmUtil.toString());
			String url = SubSystemConfigFactory.get("COM.CRM.JMS.SEND.URL");
			log.error("COM.CRM.JMS.SEND.URL : " + url);
    		eai = new WeblogicSendQClient(url, this.getClass());

            log.error("document:"+ crmUtil.toString());
       		eai.setFactory(SubSystemConfigFactory.get("COM.CRM.JMS.FACTORY")); 
       		eai.setQueue(SubSystemConfigFactory.get("COM.CRM.JMS.QUEUE"));  

       		log.debug("========================ERR Msg Interface Start===================================");
	        eai.setMessage(crmUtil.toString()); 
	        eai.setDestination("MDM065-0001");
	        
	        eai.commit(crmUtil.getInstanceId());
	        log.debug("========================ERR Msg Interface End===================================");

		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} finally { // 2011.07.14
			if ( eai != null ) {
				eai.close();
			}		
		}
	}
}