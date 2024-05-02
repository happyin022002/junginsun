/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustRefPartyManageBCImpl.java
*@FileTitle : crm referency party 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-19
*@LastModifier : 김종호
*@LastVersion : 1.5
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2010-05-17 김종호 :  ALPS New F/W 전환
* 2011.06.29 김영철 [CHM-201111871] R4J 소스 품질 조치 - 전역 변수과 지역 변수의 동일한 이름 사용으로 인한 프로그램 수정 (opCd)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.xmlbeans.XmlObject;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.cms.CMS0100001Document;
import com.hanjin.irep.cms.CMS0100001Document.CMS0100001;
import com.hanjin.syscommon.common.table.TrsTrspActCustAddrVO;
import com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration.CustRefPartyManageDBDAO;
/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see ESD078_HU01EventResponse,TRSInterfaceRSC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CustRefPartyManageBCImpl  extends BasicCommandSupport implements CustRefPartyManageBC {
	
	// Database Access Object
	private transient CustRefPartyManageDBDAO dbDao=null;

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
	 * JMS Queue를 Receive 처리한다.<br>
	 * 중요 : JMS Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.  
	 * @param xmlData
	 * @return
	 * @throws EAIException
	 */
	public Collection receiveCustRefPartyManage(XmlObject xmlData) {
		
		Collection models = null; 
		
		CMS0100001Document doc = (CMS0100001Document)xmlData;		
		CMS0100001 cmd0100001 = doc.getCMS0100001();
		
//		EAIHeaderType headerType = cmd0100001.getEAIHeader();
//		if(headerType != null){
//			EAIHeaderType.Parameters params = headerType.getParameters();		
//			EAIHeaderType.Parameters.Parameter[] param = params.getParameterArray();
//							
//			for( int i=0; i<param.length; i++ ){
//				log.debug( "Header : " + param[i].getStringValue() );
//			}
//		}
		CMS0100001.DataArea dataArea = cmd0100001.getDataArea();
		CMS0100001.DataArea.CMSREFERENCYCollection collection = dataArea.getCMSREFERENCYCollection();
		CMS0100001.DataArea.CMSREFERENCYCollection.CMSREFERENCYRequest[] mnrWorkOrderArr = collection.getCMSREFERENCYRequestArray();
			
		///===== Collect received data & Allocate them to Collection models =====			
		models = new ArrayList();  
		TrsTrspActCustAddrVO trs_trsp_act_cust_addr;
						
		for ( int i=0; mnrWorkOrderArr!=null && i<mnrWorkOrderArr.length; i++){
			trs_trsp_act_cust_addr = new TrsTrspActCustAddrVO();
			trs_trsp_act_cust_addr.setCrmRowId(mnrWorkOrderArr[i].getROWID());
			trs_trsp_act_cust_addr.setActCustCntCd     (mnrWorkOrderArr[i].getACTCUSTCNTCD());	
			trs_trsp_act_cust_addr.setActCustSeq       (mnrWorkOrderArr[i].getACTCUSTSEQ());		
			trs_trsp_act_cust_addr.setFctryNm          (mnrWorkOrderArr[i].getFCTRYNM());
			trs_trsp_act_cust_addr.setFctryAddr        (mnrWorkOrderArr[i].getFCTRYADDR());
			trs_trsp_act_cust_addr.setCntcPsonNm       (mnrWorkOrderArr[i].getCNTCPSONNM());	
			trs_trsp_act_cust_addr.setActCustPstCd     (mnrWorkOrderArr[i].getACTCUSTPSTCD());
			trs_trsp_act_cust_addr.setCntcPsonPhnNo    (mnrWorkOrderArr[i].getCNTCPSONPHNNO());
			trs_trsp_act_cust_addr.setCntcPsonFaxNo    (mnrWorkOrderArr[i].getCNTCPSONFAXNO());
			trs_trsp_act_cust_addr.setCntcPsonReqRmk   (mnrWorkOrderArr[i].getCNTCPSONREQRMK());
//			log.info("getEai_evnt_dt"+trs_trsp_act_cust_addr.getEai_evnt_dt());
			trs_trsp_act_cust_addr.setEaiEvntDt        (mnrWorkOrderArr[i].getEAIEVNTDT());					//Eai_evnt_dt
			setOp_cd(mnrWorkOrderArr[i].getOPCD());				//opCd 코드 추가	
			models.add( getOp_cd() ); 
			models.add( trs_trsp_act_cust_addr ); 
		}
		return models; 		
	}

	/**
	 * Creating Data Received <br>
	 * 주의 : Collection 사용 
	 * 
	 * @param Collection models 
	 */		
	public void ctrlCustRefPartyManage(Collection models) throws EventException{

		dbDao = new CustRefPartyManageDBDAO();
		
		TrsTrspActCustAddrVO model = null;
		String localOpCd = getOp_cd();
		int i =1;
		for(Iterator itr = models.iterator();	itr.hasNext();) {			
			if (i%2==1){				
				localOpCd = (String)itr.next();				
			} else { 					
				model = (TrsTrspActCustAddrVO)itr.next();				
				if(localOpCd.equals("C") || localOpCd.equals("U"))				localOpCd = "U";				
				try{
					switch(localOpCd.charAt(0)){
						case 'U' :
							dbDao.addCustRefPartyManage(model);
						break;
						case 'D' :
							dbDao.deleteCustRefPartyManage(model);
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