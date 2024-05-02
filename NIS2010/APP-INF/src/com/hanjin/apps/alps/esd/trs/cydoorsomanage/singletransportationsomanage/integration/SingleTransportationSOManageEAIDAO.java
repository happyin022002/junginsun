/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageEAIDAO.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.enisEsd.EAIHeaderType;
import com.hanjin.irep.enisEsd.ESD0170001Document;
import com.hanjin.irep.enisEsd.ESD081J001Document;
import com.hanjin.irep.enisEsd.ESD0170001Document.ESD0170001;
import com.hanjin.irep.enisEsd.ESD0170001Document.ESD0170001.DataArea;
import com.hanjin.irep.enisEsd.ESD0170001Document.ESD0170001.DataArea.PickTruckCollection;
import com.hanjin.irep.enisEsd.ESD0170001Document.ESD0170001.DataArea.PickTruckCollection.PickTruckRequest;
import com.hanjin.irep.enisEsd.ESD081J001Document.ESD081J001;
import com.hanjin.irep.enisEsd.ESD081J001Document.ESD081J001.DataArea.BKGSOSTSUPDCollection;
import com.hanjin.irep.enisEsd.ESD081J001Document.ESD081J001.DataArea.BKGSOSTSUPDCollection.BKGSOSTSUPDRequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxAyDocClient;

/**
 * ESD-TRS에 대한 EAI 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author z_kim_sang_geun
 * @see SingleTransportationSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class SingleTransportationSOManageEAIDAO extends EAIDAOSupport {

	/**
	 * eai sending <br>
	 * SingleTransportationSOManage화면에 대한 데이타 sending<br>
	 * 미주(for Pickup Notice) + 구주 + 아주
	 * 
	 * @param rowSet
	 * @throws EventException
	 */
	public void searchSingleTransportationSOInterfaceManage(DBRowSet rowSet) throws EventException {
		String msg = "";
		ESD0170001Document  doc				= null;
		ESD0170001          esd0170001      = null;
		EAIHeaderType		hearderType		= null;       
		DataArea dataArea     = null;
		boolean bsend = false;

        // 2007. 05. 01. Hyunsu modified 
		TransferEAI eai = null;

		doc = ESD0170001Document.Factory.newInstance();
		esd0170001 = doc.addNewESD0170001();
		hearderType = esd0170001.addNewEAIHeader();
//		EAIHeaderType.Parameters params = hearderType.addNewParameters();
//		EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
//		param.setStringValue("Header");
		
		/* SETUP INSTANCE ID	: ESD017-HU01	*/
		hearderType.setInstanceId("ESD017-HU01"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));

		dataArea = esd0170001.addNewDataArea();
		// Localhost Test 
		String eai_ip = SubSystemConfigFactory.get("TRS.EAI.ESD017.IP");

		if(dataArea != null){
			PickTruckCollection pickTruckcollection = dataArea.addNewPickTruckCollection();
			try {
				while (rowSet != null && rowSet.next()) {
					PickTruckRequest pickuptruckrequest = pickTruckcollection.addNewPickTruckRequest();
					pickuptruckrequest.setTRSPSOOFCCTYCD(rowSet.getString(1));
					pickuptruckrequest.setTRSPSOSEQ(rowSet.getString(2));
					pickuptruckrequest.setLGSCOSTCD(rowSet.getString(3));
					pickuptruckrequest.setFMNODCD(rowSet.getString(4));
					pickuptruckrequest.setTONODCD(rowSet.getString(5));
					pickuptruckrequest.setVIANODCD(rowSet.getString(6));
					pickuptruckrequest.setDORNODCD(rowSet.getString(7));
					pickuptruckrequest.setADDMVIND(rowSet.getString(8));//미확정
					pickuptruckrequest.setBLNO(rowSet.getString(9));
					pickuptruckrequest.setBLNOTP(rowSet.getString(10));
					pickuptruckrequest.setBLNOCHK(rowSet.getString(11));
					pickuptruckrequest.setEQNO(rowSet.getString(12));
					pickuptruckrequest.setSTRCRCTMK(rowSet.getString(13));// 미확정
					pickuptruckrequest.setTRSPWOOFCCITY(rowSet.getString(14));// 미확정
					pickuptruckrequest.setTRSPWOSEQ(rowSet.getString(15));
					pickuptruckrequest.setBKGNO(rowSet.getString(16));
					pickuptruckrequest.setBKGNOSPLIT(rowSet.getString(17));
					pickuptruckrequest.setHUBLOCCD(rowSet.getString(18));
					pickuptruckrequest.setPORTCD(rowSet.getString(19));
					pickuptruckrequest.setLOCCD(rowSet.getString(20));
					pickuptruckrequest.setDELTFLG(rowSet.getString(21));
					bsend = true;
				}
			} catch (SQLException de) {
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
			} catch (Exception ee) {		
				log.error(ee.getMessage(), ee);
				throw new EventException(ee.getMessage());
			}
			
			if( bsend ) {
				try {
					log.debug("\n >> doc : " + doc.toString() );
			        // 2007. 05. 01. Hyunsu modified 
					eai = new AxAyDocClient(eai_ip, this.getClass());
					eai.setMessage(doc.toString());
			        // 2007. 05. 01. Hyunsu modified 
					msg = eai.commit(hearderType.getInstanceId());						
					log.debug("\n msg : " + msg);					

				} catch (EAIException ea) {
			        // 2007. 05. 01. Hyunsu modified 
					eai.rollback(ea);
					
					log.error(ea.getMessage(), ea);
					throw new EventException(ea.getMessage());
				} catch (Exception ea) {
			        // 2007. 05. 01. Hyunsu modified 
					eai.rollback(ea);			
					log.error(ea.getMessage(), ea);
					throw new EventException(ea.getMessage());
				}
		        // 2007. 05. 01. Hyunsu modified 
				eai.close();		
			}					
		}
	}
	
	/**
	 * eai sending <br>
	 * SingleTransportationSOManage화면에 대한 데이타 sending<br>
	 * 
	 * @param rowSetArray
	 * @throws EventException
	 */
	public void sendEAI81(DBRowSet[] rowSetArray) throws EventException {
		String msg = "";
		ESD081J001Document  doc				= null;
		ESD081J001          esd081J001      = null;
		EAIHeaderType		hearderType		= null;       
		com.hanjin.irep.enisEsd.ESD081J001Document.ESD081J001.DataArea dataArea     = null;
		boolean bsend = false;

        // 2007. 05. 01. Hyunsu modified
		TransferEAI eai = null;
		DBRowSet  rowSet = null;
		String soSeqNbkgNo = null;

		try {
			for (int i=0; rowSetArray != null && i < rowSetArray.length; i++) {
				doc = ESD081J001Document.Factory.newInstance();
				esd081J001 = doc.addNewESD081J001();
				hearderType = esd081J001.addNewEAIHeader();

				dataArea = esd081J001.addNewDataArea();
				rowSet  = rowSetArray[i];
				
				if(dataArea != null && rowSet.next()){
					BKGSOSTSUPDCollection bkgsostsupdcollection = dataArea.addNewBKGSOSTSUPDCollection();
					
					BKGSOSTSUPDRequest bkgsostsupdrequest = bkgsostsupdcollection.addNewBKGSOSTSUPDRequest();
					bkgsostsupdrequest.setTRSPSOOFCCTYCD(rowSet.getString(3));
					bkgsostsupdrequest.setTRSPSOSEQ(rowSet.getString(4));
					bkgsostsupdrequest.setTRSPSOSTSCD(rowSet.getString(5));
					bkgsostsupdrequest.setBKGNO(rowSet.getString(6));
					bkgsostsupdrequest.setBKGNoSPLIT(rowSet.getString(7));
					bkgsostsupdrequest.setBKGTRONO(rowSet.getString(8));
					bkgsostsupdrequest.setEAIEVNTDT(rowSet.getString(9));
					
					soSeqNbkgNo = "-"+rowSet.getString(3)+rowSet.getString(4)+"_"+rowSet.getString(6)+"-";

					if(rowSet.getString(1).equals("EUR")){
						hearderType.setInstanceId("ESD081-HR01"+ soSeqNbkgNo +(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));				
					} else if(rowSet.getString(1).equals("KOR")){
						hearderType.setInstanceId("ESD081-HK01"+ soSeqNbkgNo +(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
					} else if(rowSet.getString(1).equals("CHN")){
						hearderType.setInstanceId("ESD081-HC01"+ soSeqNbkgNo +(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
					} else if(rowSet.getString(1).equals("SWA")){
						hearderType.setInstanceId("ESD081-HS01"+ soSeqNbkgNo +(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
					} else if(rowSet.getString(1).equals("USA")){
						hearderType.setInstanceId("ESD081-HU01"+ soSeqNbkgNo +(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
					}

					// Localhost Test
					String eai_ip = SubSystemConfigFactory.get("TRS.EAI.ESD081.IP."+rowSet.getString(1));
					bsend = true;
					
					log.debug("\n >> doc : " + doc.toString() );
					
					eai = new AxAyDocClient(eai_ip, this.getClass());
					eai.setMessage(doc.toString());
					
					msg = eai.commit(hearderType.getInstanceId());						
					log.debug("\n msg : " + msg);
						
				} else if(dataArea == null){
					break;
				}
			}
			
			if(bsend){
				eai.close();				
			}			
		} catch (EAIException ea) {
			eai.rollback(ea);			
			log.error(ea.getMessage(), ea);
			throw new EventException(ea.getMessage());
		}catch (SQLException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
		} catch (Exception ee) {
			eai.rollback(ee);
			log.error(ee.getMessage(), ee);
			throw new EventException(ee.getMessage());
		}
	}

		
}