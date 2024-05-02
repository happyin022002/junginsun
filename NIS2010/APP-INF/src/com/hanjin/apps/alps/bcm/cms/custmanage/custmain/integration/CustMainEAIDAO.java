/*=========================================================
 *Copyright(c) 2018 SM Lines
 *@FileName : CustMainEAIDAO.java
 *@FileTitle : EAI
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.03.23
 *@LastModifier : jklim
 *@LastVersion : 1.0
 * 2018.03.23 jklim
 * 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.colatech.eai.client.framework.core.TransferType;
import com.colatech.eai.client.framework.core.InterfaceData.ApplicationArea;
import com.colatech.eai.client.framework.core.send.WebLogicQueueClient;
import com.colatech.eai.client.framework.core.util.ObjectCopy;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupEaiVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupIfVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerEaiVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerIfVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustAddressEaiVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerAddressIfVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerEaiVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerIfVO;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;


import com.jf.transfer.eai.exception.EAIException;


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
	public void sendCustomerToMdm(CustomerIfVO customerIfVO, String usrId, String creFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CE");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(creFlag);
			appl.setMsgEtt("MDM CUSTOMER");
		
			/** 마스터 데이타 */
			CustomerEaiVO customerEaiVO = (CustomerEaiVO) ObjectCopy.build(customerIfVO, CustomerEaiVO.class);
			queueSend.getDataArea().setData(customerEaiVO);
			
			/** 서브 데이타 */
			/*VndrSubVO subVo = new VndrSubVO();
			subVo.setCntrVndrSvcCd("");
			subVo.setVndrClssRowId("");
			subVo.setVndrCostCd("");
			queueSend.getSubDataArea().setNodeData("VndrClss/VndrClssIns", subVo);*/
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM001-0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
			
			/*String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
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
	}*/
	
	public void sendCustAddrToMdm(CustomerAddressIfVO customerAddressIfVO, String usrId, String creFlg) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CMS");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(creFlg);
			appl.setMsgEtt("MDM CUSTOMER ADDRESS");
		
			/** 마스터 데이타 */
			CustAddressEaiVO custAddressEaiVO = (CustAddressEaiVO) ObjectCopy.build(customerAddressIfVO, CustAddressEaiVO.class);
			if(custAddressEaiVO.getPrmryChkFlg().equals("0") || custAddressEaiVO.getPrmryChkFlg().equals("N")){
				custAddressEaiVO.setPrmryChkFlg("N");
			} else {
				custAddressEaiVO.setPrmryChkFlg("Y");
			}
			queueSend.getDataArea().setData(custAddressEaiVO);
			
			/** 서브 데이타 */
			/*VndrSubVO subVo = new VndrSubVO();
			subVo.setCntrVndrSvcCd("");
			subVo.setVndrClssRowId("");
			subVo.setVndrCostCd("");
			queueSend.getSubDataArea().setNodeData("VndrClss/VndrClssIns", subVo);*/
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM003-0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	public void sendCustGrpToMdm(CustomerGroupIfVO customerGroupIfVO, String usrId, String creFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		//TransferType queueSend = null;
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CMS");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(creFlag);
			appl.setMsgEtt("MDM CUSTOMER PERFORMANCE GROUP");
		
			/** 마스터 데이타 */
			CustomerGroupEaiVO customerGroupEaiVO = (CustomerGroupEaiVO) ObjectCopy.build(customerGroupIfVO, CustomerGroupEaiVO.class);
			queueSend.getDataArea().setData(customerGroupEaiVO);
			
			/** 서브 데이타 */
			/*VndrSubVO subVo = new VndrSubVO();
			subVo.setCntrVndrSvcCd("");
			subVo.setVndrClssRowId("");
			subVo.setVndrCostCd("");
			queueSend.getSubDataArea().setNodeData("VndrClss/VndrClssIns", subVo);*/
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM018-0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	public void sendCreditCustToMdm(CreditCustomerIfVO creditCustomerIfVO, String usrId, String creFlag) throws EAIException  {
		String url = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.SEND.URL");//"t3://172.20.94.187:7001";
		String factory = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.FACTORY");//"jms/ALPSJ_CFA";
		String queue = SubSystemConfigFactory.get("MDM.ALPSJ.JMS.QUEUE");//"jms/ALPSJ_DQRA";
		
		log.debug("=======================================");
		log.debug("    \n Parameter Marshalling Start!    ");
		log.debug("=======================================");
		//TransferType queueSend = null;
		
		try{
			TransferType queueSend = new WebLogicQueueClient(url, WebLogicQueueClient.class);
		
			ApplicationArea appl = queueSend.getApplicationArea();
			appl.setSrcSysCd("CMS");
			appl.setMsgCreDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			appl.setOpCd(creFlag);
			appl.setMsgEtt("MDM CREDIT CUSTOMER");
		
			/** 마스터 데이타 */
			CreditCustomerEaiVO creditCustomerEaiVO = (CreditCustomerEaiVO) ObjectCopy.build(creditCustomerIfVO, CreditCustomerEaiVO.class);
			queueSend.getDataArea().setData(creditCustomerEaiVO);
			
			/** 서브 데이타  */
			/*VndrSubVO subVo = new VndrSubVO();
			subVo.setCntrVndrSvcCd("");
			subVo.setVndrClssRowId("");
			subVo.setVndrCostCd("");
			queueSend.getSubDataArea().setNodeData("VndrClss/VndrClssIns", subVo);*/
			
			String integrationId = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			queueSend.setFactory(factory);
			queueSend.setQueue(queue);
			queueSend.setDestination("MDM017-0001");
			System.out.println(queueSend.commit(integrationId));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
}