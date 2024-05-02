/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CanadaCustomsBCImpl.java
*@FileTitle : Canada Customs 정보
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
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration.CanadaCustomsDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsd.ESD0760001Document;
import com.hanjin.irep.enisEsd.ESD0760001Document.ESD0760001;
import com.hanjin.syscommon.common.table.EdiCndCstmsIbdVO;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see ESD076_HU01EventResponse,TRSInterfaceRSC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CanadaCustomsBCImpl   extends BasicCommandSupport implements CanadaCustomsBC {
	
	// Database Access Object
	private transient CanadaCustomsDBDAO dbDao=null;

	private String opCd = "";
	
	/**  
	 * JMS Queue를 Receive 
	 * 중요 : op_cd (구분값)를 리턴   
	 * @param op_cd
	 * @return
	 */	
	public String getOp_cd() {
		return opCd;
	}
	
	/**  
	 * JMS Queue를 Receive 
	 * 중요 : op_cd (구분값)를 세팅   
	 * @param op_cd
	 * @return
	 */	
	public void setOp_cd(String op_cd) {
		this.opCd = op_cd;
	}
	
	/**  
	 * JMS Queue를 Receive 처리한다.<br>
	 * 중요 : JMS Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * @param xmlData
	 * @return
	 * @throws EAIException
	 */
	public Collection receiveCanadaCustomsManage(XmlObject xmlData) {
		
		Collection models = null; 
			
	   
		ESD0760001Document doc = (ESD0760001Document)xmlData;		
		ESD0760001 esd0760001 = doc.getESD0760001();		
		ESD0760001.DataArea dataArea = esd0760001.getDataArea();
		ESD0760001.DataArea.CANTRANSCollection collection = dataArea.getCANTRANSCollection();
		ESD0760001.DataArea.CANTRANSCollection.CANTRANSRequest[] mnrWorkOrderArr = collection.getCANTRANSRequestArray();
					
		models = new ArrayList();
		EdiCndCstmsIbdVO edi_cnd_cstms_ibd;
		for ( int i=0; mnrWorkOrderArr!=null && i<mnrWorkOrderArr.length; i++){
			edi_cnd_cstms_ibd = new EdiCndCstmsIbdVO();
			edi_cnd_cstms_ibd.setBlNo(mnrWorkOrderArr[i].getBLNO());
			edi_cnd_cstms_ibd.setBkgNo(mnrWorkOrderArr[i].getBKGNO());
			edi_cnd_cstms_ibd.setVslCd(mnrWorkOrderArr[i].getVSLCD());                   
			edi_cnd_cstms_ibd.setSkdVoyNo(mnrWorkOrderArr[i].getSKDVOYAGENO());               
			edi_cnd_cstms_ibd.setSkdDirCd(mnrWorkOrderArr[i].getSKDDIRCD());               
			edi_cnd_cstms_ibd.setVslDchgPortCd(mnrWorkOrderArr[i].getPODLOC());			
			edi_cnd_cstms_ibd.setIbdTrspHubCtyCd(mnrWorkOrderArr[i].getITHUB());      
			edi_cnd_cstms_ibd.setIbdCstmsClrLocCd(mnrWorkOrderArr[i].getITCSTMCLOC());     
			edi_cnd_cstms_ibd.setIbdBkgStsCd(mnrWorkOrderArr[i].getITSTATUS());           
			edi_cnd_cstms_ibd.setIbdTpCd(mnrWorkOrderArr[i].getITITTYPE());                
			edi_cnd_cstms_ibd.setIbdNo(mnrWorkOrderArr[i].getITITNO());  			
			edi_cnd_cstms_ibd.setIbdIssDt(mnrWorkOrderArr[i].getITITDATE());               
			edi_cnd_cstms_ibd.setIbdCstmsClrIndCd(mnrWorkOrderArr[i].getITCSTMCIND());     
			edi_cnd_cstms_ibd.setIbdIpiLoclIndCd(mnrWorkOrderArr[i].getITIPILOCAL());      
			edi_cnd_cstms_ibd.setIbdNonVslOpCrrFtrCd(mnrWorkOrderArr[i].getITNVOCCFILER());
			edi_cnd_cstms_ibd.setCndLocGdsCd(mnrWorkOrderArr[i].getITLOCGOODS()); 

			edi_cnd_cstms_ibd.setEaiEvntDt(mnrWorkOrderArr[i].getEAIEVNTDT());				//Eai_evnt_dt로 사용
			setOp_cd(mnrWorkOrderArr[i].getOPCD());									//op_cd 코드 추가	
			models.add( getOp_cd() ); 
			models.add( edi_cnd_cstms_ibd ); 

		}
		return models; 		
	}

	/**
	 * Creating Data Received <br>
	 * 주의 : Collection 사용 
	 * @param models 
	 * @throws EventException
	 */	
	public void ctrlCanadaCustomsManage(Collection models) throws EventException{
		dbDao = new CanadaCustomsDBDAO();
		
		Iterator itr = models.iterator();
		EdiCndCstmsIbdVO model = null;
		String localOpCd = getOp_cd();
		int i =1;		
		while (itr.hasNext()) {
			if (i%2==1){				
				localOpCd = (String)itr.next();				
			} else { 					
				model = (EdiCndCstmsIbdVO)itr.next();				
				if(localOpCd.equals("") || localOpCd.equals(" "))				localOpCd = "U";				
				try{
					switch(localOpCd.charAt(0)){
						case 'U' :
							dbDao.addCanadaCustomsManage(model);
						break;
						case 'D' :
							dbDao.deleteCanadaCustomsManage(model);
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