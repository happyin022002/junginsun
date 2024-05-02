/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionEAIDAO.java
*@FileTitle : Send WebLogic JMS Queue EAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-27
*@LastModifier : Chang-su, Jang
*@LastVersion : 1.0
* 2009-08-27 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;

import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.erp.EAIHeaderType;
import com.hanjin.irep.erp.FNS0290001Document;
import com.hanjin.irep.erp.FNS0290001Document.FNS0290001;
import com.hanjin.irep.erp.FNS0290001Document.FNS0290001.DataArea;
import com.hanjin.irep.erp.FNS0290001Document.FNS0290001.DataArea.TaxByTonCollection;
import com.hanjin.irep.erp.FNS0290001Document.FNS0290001.DataArea.TaxByTonCollection.TaxByTon;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;


/**
 * ALPS TonnageTaxStandardProfitConclusionEAIDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ho Sun Lee
 * @see ContainerOnOffhireBCImpl 참조
 * @since J2EE 1.6
 */
public class TonnageTaxStandardProfitConclusionEAIDAO    extends EAIDAOSupport {

	/**
	 * ERP : FNS029-0001
	 * ERP I/F 정보를 제공합니다. <br>
	 * 
	 * @param String stlYrmon
	 * @param  String usrId
	 * @param  List<ErpIfVO> erpIfVOs
	 * @return String
	 * @exception EAIException
	 */

	public String sendErpIfData(String stlYrmon, String usrId, List<ErpIfVO> erpIfVOs) throws DAOException{
		
		String result			= "";
			String target 			= "";
			
			TransferEAI eai			= null;
			FNS0290001Document doc		= null;
			FNS0290001 fns0290001		= null;
			EAIHeaderType hearderType		= null;
			TaxByTonCollection taxByTonCollection 	= null;
			TaxByTon taxByTonrequest		= null;
			
			
		try{
		          target = SubSystemConfigFactory.get("TOT.FNS029.WSDL");
		          eai = new AxAyDocClient(target, this.getClass());
		        	
		          doc = FNS0290001Document.Factory.newInstance();
		          fns0290001= doc.addNewFNS0290001();
		          hearderType = fns0290001.addNewEAIHeader();
		          EAIHeaderType.Parameters params = hearderType.addNewParameters();
		          EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
		          hearderType.setInstanceId("FNS029-0001"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
		          param.setStringValue("FNS029-0001--Header");
		          
		          
		          DataArea dataArea = fns0290001.addNewDataArea();
		          taxByTonCollection = dataArea.addNewTaxByTonCollection();

		          String total_count = erpIfVOs.size()+"";

		          for(int i=0; i<erpIfVOs.size(); i++){
		        	
		         	  taxByTonrequest = taxByTonCollection.addNewTaxByTon();
		        	  
			          taxByTonrequest.setLIFID("FNS0290001");
			          taxByTonrequest.setSEQ(erpIfVOs.get(i).getRSeq());
			          taxByTonrequest.setTOTALCOUNT(total_count);
			          taxByTonrequest.setROWNUM(erpIfVOs.get(i).getRNum());
			          taxByTonrequest.setSETDT(erpIfVOs.get(i).getStlYrmon());
			          taxByTonrequest.setSETSEQ(erpIfVOs.get(i).getBatJbSeq());
			          taxByTonrequest.setVSLCD(erpIfVOs.get(i).getVslCd());
			          taxByTonrequest.setCHK("C");
			          taxByTonrequest.setVSLENGNM(erpIfVOs.get(i).getVslNm());
			          taxByTonrequest.setFLEETTP(erpIfVOs.get(i).getTongFletTpCd());
			          taxByTonrequest.setFLAG(erpIfVOs.get(i).getCntCd());
			          taxByTonrequest.setNRT(erpIfVOs.get(i).getNrtWgt());
			          taxByTonrequest.setREVPERTON(erpIfVOs.get(i).getPerTonRev());
			          taxByTonrequest.setVOYDAY(erpIfVOs.get(i).getVoyDys());
			          taxByTonrequest.setUSAGE(erpIfVOs.get(i).getUsgRt());
			          taxByTonrequest.setTAXAMT(erpIfVOs.get(i).getTongTaxAmt());
			          taxByTonrequest.setCRTDUR(erpIfVOs.get(i).getCtrtDys());
			          taxByTonrequest.setVVDRMK(erpIfVOs.get(i).getVvdRmk());
			          taxByTonrequest.setCRTDT(erpIfVOs.get(i).getCrtDt());
			          taxByTonrequest.setCRTID(usrId);
			          taxByTonrequest.setNRTAMT(erpIfVOs.get(i).getNrtTongTaxAmt());
			          taxByTonrequest.setLOADTEU(erpIfVOs.get(i).getLdbCapaQty());
			          taxByTonrequest.setACTTEU(erpIfVOs.get(i).getActBsaCapa());
			          taxByTonrequest.setIFDT(stlYrmon);
			          taxByTonCollection.setTaxByTonArray(i, taxByTonrequest);
		          }

		         // taxByTonCollection.setTaxByTon(taxByTonrequest);
		          dataArea.setTaxByTonCollection(taxByTonCollection);
		          fns0290001.setDataArea(dataArea);
		          doc.setFNS0290001(fns0290001);
		          eai.setMessage(doc.toString());
		          long startTime = Calendar.getInstance().getTimeInMillis();
	              log.debug("==============================================================================");
	              log.debug(" EAIDAO start : "+startTime);
	              log.debug("==============================================================================");
	              log.debug("    transferSimPFType Send     : \n"+doc.toString());
	              log.debug("==============================================================================");

	              eai.commit(hearderType.getInstanceId()); 

	              log.debug("==============================================================================");
	              log.debug("    transferSimPortDays Result : \n" + doc.toString());
	              log.debug("==============================================================================");
	              log.debug(" EAIDAO end : "+ String.valueOf(Calendar.getInstance().getTimeInMillis()-startTime));
	              log.debug("==============================================================================");


		     } catch (EAIException e) {
		          eai.rollback(e);
		          log.error("EAIException : " + e.getMessage(),e);
		          throw new DAOException(e.getMessage());
		     } catch (Exception e) {
		          eai.rollback(e);
		          log.error(e.getMessage(),e);
		          throw new DAOException(e.getMessage());
		     }
		     eai.close();
		     return result;
	}
}
