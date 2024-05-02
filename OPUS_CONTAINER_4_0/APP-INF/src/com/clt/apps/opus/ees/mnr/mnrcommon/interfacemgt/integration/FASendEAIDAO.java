/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FASendEAIDAO.java
*@FileTitle : Send WebLogic JMS Queue EAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-11
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009-09-07 WanGyu Kim
* 1.0 Creation
--------------------------------------------------------
* History 
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	   
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0270001Document;
import com.clt.irep.erp.FNS0270001Document.FNS0270001;
import com.clt.irep.erp.FNS0270001Document.FNS0270001.DataArea.CntrRepResultCollection;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * ALPS FASendEAIDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author WanGyu Kim
 * @see BCImpl 참조
 * @since J2EE 1.6
 */
public class FASendEAIDAO   extends EAIDAOSupport{

	/**
	 * ERP : FNS027-0001<br>
	 * 제각 대상의 장비 FA_EQ_NO 정보를 ERP에 송신 한다.<br>
	 * 
	 * @param String destnmae
	 * @param List<FaErpListVO> faErpListVOs
	 * @return String
	 * @throws DAOException 
	 */ 
	public HashMap sendErpToFAData(String destnmae, List<FaErpListVO> faErpListVOs) throws DAOException {
		String reString 	= 	"";
		HashMap reHMap = null;
		TransferEAI eai 	= 	null;
		String sendUrl      = 	"";
		try{
			//Request Start
			// "SUBSYSTEM_NAME + "_" + BIZ Name + "_" + Sequesnce + ... ... <<DATE>>
			String integrationId = "FNS027-0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			
			FNS0270001Document document = FNS0270001Document.Factory.newInstance();
			FNS0270001 fns0270001 = FNS0270001.Factory.newInstance();
			
			EAIHeaderType headerType = fns0270001.addNewEAIHeader();
			
			FNS0270001.DataArea dataArea = fns0270001.addNewDataArea();
			CntrRepResultCollection  cntrRepResultCollection = dataArea.addNewCntrRepResultCollection();

			for(int i=0; i<faErpListVOs.size(); i++){
				
				FNS0270001.DataArea.CntrRepResultCollection.CntrRepResult cntrRepResult = cntrRepResultCollection.addNewCntrRepResult();

                //integrationId = faErpListVOs.get(i).getSeq();

                cntrRepResult.setLIFID(faErpListVOs.get(i).getLifid());
                cntrRepResult.setSEQ(faErpListVOs.get(i).getSeq());
                cntrRepResult.setTOTALCOUNT(faErpListVOs.get(i).getTotalCount());
                cntrRepResult.setROWNUM(faErpListVOs.get(i).getRnum());
                cntrRepResult.setTAGNUMBER(faErpListVOs.get(i).getTagNumber());
                cntrRepResult.setBOOKTYPECODE(faErpListVOs.get(i).getBookTypeCode());
                cntrRepResult.setDATERETIRED(faErpListVOs.get(i).getDateRetired());
                cntrRepResult.setUNITSRETIRED(faErpListVOs.get(i).getUnitsRetired());
                cntrRepResult.setPROCEEDSOFSALE(faErpListVOs.get(i).getProceedsOfSale());
                cntrRepResult.setCOSTOFREMOVAL(faErpListVOs.get(i).getCostOfRemoval());
                cntrRepResult.setRETIREMENTTYPECODE(faErpListVOs.get(i).getRetirementTypeCode());
                cntrRepResult.setCREATEDBY(faErpListVOs.get(i).getCreatedBy());
                cntrRepResult.setCREATIONDATE(faErpListVOs.get(i).getCreationDate());
                cntrRepResult.setLASTUPDATEDBY(faErpListVOs.get(i).getLastUpdatedBy());
                cntrRepResult.setLASTUPDATEDATE(faErpListVOs.get(i).getLastUpdateDate());
                cntrRepResult.setATTRIBUTE1(faErpListVOs.get(i).getAttribute1());
                cntrRepResult.setSOLDTO(faErpListVOs.get(i).getSoldTo());
                cntrRepResult.setINVOICENO(faErpListVOs.get(i).getInvoiceNo());
                cntrRepResult.setLCLAMT(faErpListVOs.get(i).getLclAmt());	             
                cntrRepResult.setLCLCURR(faErpListVOs.get(i).getLclCurr());				          
			    cntrRepResultCollection.setCntrRepResultArray(i, cntrRepResult);
			}	
			headerType.setInstanceId(integrationId);
			dataArea.setCntrRepResultCollection(cntrRepResultCollection);
			fns0270001.setDataArea(dataArea);
			document.setFNS0270001(fns0270001);
			sendUrl = SubSystemConfigFactory.get("MNR.FNS0270001.WSDL");
			eai = new AxAyDocClient(sendUrl, this.getClass());
			eai.setObj(document);		        // The Object convert a String by toString() method in Connector Module.
			//eai.setMessage(document.toString());
			reString = eai.commit(headerType.getInstanceId());                
			reHMap = new HashMap<String, String>();
			reHMap.put("reString", reString);
			reHMap.put("integrationId", integrationId);

		} catch (EAIException e) {
			eai.rollback(e);
		    log.error("EAIException : " + e.getMessage(),e);
	        throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}finally{
			eai.close();
		}
		return reHMap;
	}
}
