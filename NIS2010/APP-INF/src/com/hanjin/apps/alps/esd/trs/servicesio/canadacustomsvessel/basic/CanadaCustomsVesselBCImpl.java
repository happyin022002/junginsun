/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CanadaCustomsVesselBCImpl.java
*@FileTitle : Canada Customs Vessel 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-22
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.06.29 김영철 [CHM-201111871] R4J 소스 품질 조치 - 전역 변수과 지역 변수의 동일한 이름 사용으로 인한 프로그램 수정 (opCd)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.integration.CanadaCustomsVesselDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsd.ESD0750001Document;
import com.hanjin.irep.enisEsd.ESD0750001Document.ESD0750001;
import com.hanjin.syscommon.common.table.EdiCndCstmsVslVO;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see ESD075_HU01EventResponse,TRSInterfaceRSC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CanadaCustomsVesselBCImpl   extends BasicCommandSupport implements CanadaCustomsVesselBC {
	
	// Database Access Object
	private transient CanadaCustomsVesselDBDAO dbDao=null;

	private String opCd = "";
	
	/**  
	 * JMS Queue를 Receive 
	 * 중요 : opCd (구분값)를 리턴   
	 * @param opCd
	 * @return
	 */	
	public String getOp_cd() {
		return opCd;
	}

	/**  
	 * JMS Queue를 Receive 
	 * 중요 : opCd (구분값)를 세팅   
	 * @param opCd
	 * @return
	 */	
	public void setOp_cd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * ContinentBCImpl 객체 생성<br>
	 * ContinentDBDAO를 생성한다.<br>
	 */
	public CanadaCustomsVesselBCImpl(){

		dbDao = new CanadaCustomsVesselDBDAO();
	}	
	
	/**  
	 * JMS Queue를 Receive 처리한다.<br>
	 * 중요 : JMS Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * @param xmlData
	 * @return
	 * @throws EAIException
	 */
	public Collection receiveCanadaCustomsVesselManage(XmlObject xmlData) {
		
		Collection models = null; 
			
	    //log.debug( "Jms Receive Queue Message !!!!!!! = " + xmlData );
		ESD0750001Document doc = (ESD0750001Document)xmlData;		
		ESD0750001 esd0750001 = doc.getESD0750001();		
		ESD0750001.DataArea dataArea = esd0750001.getDataArea();
		ESD0750001.DataArea.CANVESSELCollection collection = dataArea.getCANVESSELCollection();
		ESD0750001.DataArea.CANVESSELCollection.CANVESSELRequest[] mnrWorkOrderArr = collection.getCANVESSELRequestArray();
			
		///===== Collect received data & Allocate them to Collection models =====			
		models = new ArrayList();  
		EdiCndCstmsVslVO edi_cnd_cstms_vsl;					
		for ( int i=0; mnrWorkOrderArr!=null && i<mnrWorkOrderArr.length; i++){
			edi_cnd_cstms_vsl = new EdiCndCstmsVslVO();
			edi_cnd_cstms_vsl.setVslCd(mnrWorkOrderArr[i].getVSLCD());                	
			edi_cnd_cstms_vsl.setSkdVoyNo(mnrWorkOrderArr[i].getSKDVOYAGENO());         	
			edi_cnd_cstms_vsl.setSkdDirCd(mnrWorkOrderArr[i].getSKDDIRCD());         	
			edi_cnd_cstms_vsl.setCvyMrnNo(mnrWorkOrderArr[i].getCVMRN());         	
			edi_cnd_cstms_vsl.setCvyCapNm(mnrWorkOrderArr[i].getCVCAPNM());         	
			edi_cnd_cstms_vsl.setCvyEtaDt(mnrWorkOrderArr[i].getCVETADT());         	
			edi_cnd_cstms_vsl.setVslCvyNo(mnrWorkOrderArr[i].getVSLCTLNO());         	
			edi_cnd_cstms_vsl.setUpdUsrId(mnrWorkOrderArr[i].getCVUPUSR());         	
			edi_cnd_cstms_vsl.setUpdDt(mnrWorkOrderArr[i].getCVUPDT());             	
			edi_cnd_cstms_vsl.setVslArrRptSntDt(mnrWorkOrderArr[i].getCVSNDDT()); 	
			edi_cnd_cstms_vsl.setCvyAckCtrlNo(mnrWorkOrderArr[i].getCVACKCN());    	
			edi_cnd_cstms_vsl.setCvyAckCd(mnrWorkOrderArr[i].getCVACKTSAC());         	
			edi_cnd_cstms_vsl.setCvyAckNo(mnrWorkOrderArr[i].getCVACKTSPC());         	
			edi_cnd_cstms_vsl.setRcvErrMsg(mnrWorkOrderArr[i].getCVACKEN());        	
			edi_cnd_cstms_vsl.setRspnRcvDt(mnrWorkOrderArr[i].getCVACKDT());        	
			edi_cnd_cstms_vsl.setCndCstmsRjctCd(mnrWorkOrderArr[i].getCVACKCCRC());     	
			edi_cnd_cstms_vsl.setEaiEvntDt(mnrWorkOrderArr[i].getEAIEVNTDT());				//Eai_evnt_dt로 사용
			setOp_cd(mnrWorkOrderArr[i].getOPCD());									//opCd 코드 추가	
			models.add( getOp_cd() ); 
			models.add( edi_cnd_cstms_vsl ); 

		}
		return models; 		
	}

	/**
	 * Creating Data Received <br>
	 * 주의 : Collection 사용 
	 * 
	 * @param models 
	 * @throws EventException
	 */	
	public void ctrlCanadaCustomsVesselManage(Collection models) throws EventException {
		
		Iterator itr = models.iterator();
		EdiCndCstmsVslVO model = null;
		String localOpCd = getOp_cd();
		int i =1;		
		while (itr.hasNext()) {
			if (i%2==1){				
				localOpCd = (String)itr.next();				
			} else { 					
				model = (EdiCndCstmsVslVO)itr.next();				
				if(localOpCd.equals("") || localOpCd.equals(" "))				localOpCd = "U";				
				try{
					switch(localOpCd.charAt(0)){
						case 'U' :
							dbDao.addCanadaCustomsVessel(model);
						break;
						case 'D' :
							dbDao.deleteCanadaCustomsVessel(model);
						break;
					}
				} catch (DAOException de) {
					log.error("err " + de.toString(),de);
					throw new EventException(de.getMessage());
				} catch (Exception e) {
					log.error(e.getMessage(),e);
					throw new EventException(e.getMessage());
				}  
			}
			i++;
		}
	}
	
}