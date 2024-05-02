/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireEAIDAO.java
*@FileTitle : Send WebLogic JMS Queue EAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-19
*@LastModifier : Hosun, Lee
*@LastVersion : 1.0
* 2009-08-19 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaCntrListVO;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0260001Document;
import com.clt.irep.erp.FNS0260001Document.FNS0260001;
import com.clt.irep.erp.FNS0260001Document.FNS0260001.DataArea.CntrRegResultCollection;

import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * opus ContainerOnOffhireEAIDAO <br>
 * - opus-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ho Sun Lee
 * @see ContainerOnOffhireBCImpl 참조
 * @since J2EE 1.6
 */
public class ContainerOnOffhireEAIDAO    extends EAIDAOSupport {

		
	/**
	 * EES_MST_0017 : save <br>
	 * EAI JMS Send FNS026-0001호출 비동기 요청한다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017_1
	 * @category sendCntrToFAData  
	 * @param List<FaCntrListVO> faCntrListVOs
	 * @return String
	 * @throws DAOException
	 */
	public String sendCntrToFADataSub(List<FaCntrListVO> faCntrListVOs) throws DAOException {
		String reString 	= 	"";
		TransferEAI eai 	= 	null;
		String sendUrl      = 	"";
		
		try{
			//Request Start
			// "SUBSYSTEM_NAME + "_" + BIZ Name + "_" + Sequesnce + ... ... <<DATE>>
			String integrationId = "MST_FNS026_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			
			FNS0260001Document document = FNS0260001Document.Factory.newInstance();
			FNS0260001 fns0260001 = FNS0260001.Factory.newInstance();
			
			EAIHeaderType headerType = fns0260001.addNewEAIHeader();
			
			FNS0260001.DataArea dataArea = fns0260001.addNewDataArea();
			
			CntrRegResultCollection  cntrRegResultCollection = dataArea.addNewCntrRegResultCollection();

			for(int i=0; i<faCntrListVOs.size(); i++){
				FNS0260001.DataArea.CntrRegResultCollection.CntrRegResult cntrRegResult = cntrRegResultCollection.addNewCntrRegResult();
                integrationId = faCntrListVOs.get(i).getSeq();
                
                cntrRegResult.setLIFID(faCntrListVOs.get(i).getLifid());
                cntrRegResult.setSEQ(faCntrListVOs.get(i).getSeq());
                cntrRegResult.setTOTALCOUNT(faCntrListVOs.get(i).getTotalCount());
                cntrRegResult.setROWNUM(faCntrListVOs.get(i).getRnum());
                cntrRegResult.setBOOKTYPECODE(faCntrListVOs.get(i).getBookTypeCode());
                cntrRegResult.setASSETDESCRIPTION(faCntrListVOs.get(i).getAssetDescription());
                cntrRegResult.setASSETTYPE(faCntrListVOs.get(i).getAssetType());
                cntrRegResult.setCATEGORYSEGMENT(faCntrListVOs.get(i).getCategorySegment());
                cntrRegResult.setCOST(faCntrListVOs.get(i).getCost());
                cntrRegResult.setLOCATIONSEGMENT(faCntrListVOs.get(i).getLocationSegment());
                cntrRegResult.setDATEPLACEDINSERVICE(faCntrListVOs.get(i).getDatePlacedInService());
                cntrRegResult.setTAGNUMBER(faCntrListVOs.get(i).getTagNumber());
                cntrRegResult.setATTRIBUTE1(faCntrListVOs.get(i).getAttribute1());
                cntrRegResult.setATTRIBUTE2(faCntrListVOs.get(i).getAttribute2());
                cntrRegResult.setATTRIBUTE3(faCntrListVOs.get(i).getAttribute3());
                cntrRegResult.setFAIFSEQ(faCntrListVOs.get(i).getAttribute4());
                cntrRegResult.setMFTDT(faCntrListVOs.get(i).getAttribute21());
                cntrRegResult.setCREATEDBY(faCntrListVOs.get(i).getCreatedBy());
                cntrRegResult.setCREATIONDATE(faCntrListVOs.get(i).getCreationDate());
                cntrRegResult.setLASTUPDATEDBY(faCntrListVOs.get(i).getLastUpdatedBy());
                cntrRegResult.setLASTUPDATEDATE(faCntrListVOs.get(i).getLastUpdateDate());
                cntrRegResult.setMANUFACTURER(faCntrListVOs.get(i).getManufacturer());
                cntrRegResult.setACQMTH(faCntrListVOs.get(i).getAcqMth());
                cntrRegResultCollection.setCntrRegResultArray(i, cntrRegResult);
			}
			headerType.setInstanceId(integrationId);
			dataArea.setCntrRegResultCollection(cntrRegResultCollection);
			fns0260001.setDataArea(dataArea);
			document.setFNS0260001(fns0260001);
                
			sendUrl = SubSystemConfigFactory.get("EES.MST.WS.SYNCH.CONSUMER.WSDL");
            eai = new AxAyDocClient(sendUrl, this.getClass());
            eai.setObj(document);		        // The Object convert a String by toString() method in Connector Module.
            //eai.setMessage(document.toString());
            reString = eai.commit(headerType.getInstanceId());
		} catch (EAIException e) {
			eai.rollback(e);
	        throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			throw new DAOException(e.getMessage());
		}finally{
			eai.close();
		}
		return reString;		
	}
}
