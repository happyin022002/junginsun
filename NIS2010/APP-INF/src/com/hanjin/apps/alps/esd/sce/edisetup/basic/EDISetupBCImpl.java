/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EDISetupBCImpl.java
*@FileTitle : EDISetupBCImpl 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-06
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-09-07 전병석
* 1.0 최초 생성
* 2009-10-06
* 1.2 버전 생성\
* 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.basic;

import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esd.sce.edisetup.integration.EDISetupDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsd.EAIHeaderType;
import com.hanjin.irep.enisEsd.ESD0310001Document;
import com.hanjin.irep.enisEsd.ESD0320001Document;
import com.hanjin.irep.enisEsd.ESD0330001Document;
import com.hanjin.irep.enisEsd.ESD0340001Document;
import com.hanjin.irep.enisEsd.ESD0310001Document.ESD0310001;
import com.hanjin.irep.enisEsd.ESD0310001Document.ESD0310001.DataArea.EDICargoStnStsCollection;
import com.hanjin.irep.enisEsd.ESD0310001Document.ESD0310001.DataArea.EDICargoStnStsCollection.EDICargoStnSts;
import com.hanjin.irep.enisEsd.ESD0320001Document.ESD0320001;
import com.hanjin.irep.enisEsd.ESD0320001Document.ESD0320001.DataArea.EDIGroupCollection;
import com.hanjin.irep.enisEsd.ESD0320001Document.ESD0320001.DataArea.EDIGroupCollection.EDIGroup;
import com.hanjin.irep.enisEsd.ESD0330001Document.ESD0330001;
import com.hanjin.irep.enisEsd.ESD0330001Document.ESD0330001.DataArea.EDIGrpCgoCollection;
import com.hanjin.irep.enisEsd.ESD0330001Document.ESD0330001.DataArea.EDIGrpCgoCollection.EDIGrpCgo;
import com.hanjin.irep.enisEsd.ESD0340001Document.ESD0340001;
import com.hanjin.irep.enisEsd.ESD0340001Document.ESD0340001.DataArea.EDIGrpCustCollection;
import com.hanjin.irep.enisEsd.ESD0340001Document.ESD0340001.DataArea.EDIGrpCustCollection.EDIGrpCust;

/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Se-Hoon PARK
 * @see ReceiveEAIBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class EDISetupBCImpl  extends BasicCommandSupport implements EDISetupBC{

	private transient EDISetupDBDAO eaiDao = null;
	
	/** Constructor
	 * 
	 */
	public EDISetupBCImpl(){
		eaiDao = new EDISetupDBDAO();
	}
	
     /** EAI receive ESD031 로직 처리 - edi cgo standard status table sync
     * @param str String str
     * @throws EventException
     */
    public void syncEdi_cgo_stnd_sts(String str) throws EventException{
    	log.debug("EDISetupBCImpl :" + "function of syncEdi_grp_cust stated.");
    	log.debug("EDISetupBCImpl : [str]:" + str);
    	ESD0310001Document 	doc 			= null;
		ESD0310001 esd0310001 = null;
		EAIHeaderType headerType = null;
		ESD0310001.DataArea dataArea = null;
		try{
			doc = ESD0310001Document.Factory.parse(str);
			esd0310001 = doc.getESD0310001();
			headerType = esd0310001.getEAIHeader();
	            log.debug("\n >> InstanceId >> " + headerType.getInstanceId() );
	            dataArea = esd0310001.getDataArea();
	            EDICargoStnStsCollection cargo_collection = dataArea.getEDICargoStnStsCollection();
	            EDICargoStnSts [] cargo_stns_array = cargo_collection.getEDICargoStnStsArray();
	            eaiDao.syncEdi_cgo_stnd_sts(cargo_stns_array);    
		}catch (XmlException de) {
			log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } 
    }
    /** EAI receive ESD032 로직 처리 - edi group table sync
     * @param  String str
     * @throws EventException
     */
    public void syncEdi_group(String str) throws EventException{
    	log.debug("EDISetupBCImpl :" + "function of syncEdi_group stated.");
    	log.debug("EDISetupBCImpl : [str]:" + str);
    	////ESD0320001Document
    	ESD0320001Document 	doc 			= null;
    	ESD0320001 esd0320001 = null;
		EAIHeaderType headerType = null;
		ESD0320001.DataArea dataArea = null;
		try{
			doc = ESD0320001Document.Factory.parse(str);
			esd0320001 = doc.getESD0320001();
			headerType = esd0320001.getEAIHeader();
            log.debug("\n >> InstanceId >> " + headerType.getInstanceId() );
            dataArea = esd0320001.getDataArea();
            EDIGroupCollection group_collection = dataArea.getEDIGroupCollection();
            EDIGroup [] group_array = group_collection.getEDIGroupArray();
            
            eaiDao.syncEdi_group_his(group_array);		// 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
            eaiDao.syncEdi_group(group_array);   
            
		}catch (XmlException de) {
			log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } 
    }
    
    /** EAI receive ESD033 로직 처리 - edi grp cgo table sync
     * @param  String str
     * @throws EventException
     */
    public void syncEdi_grp_cgo(String str) throws EventException{
    	log.debug("EDISetupBCImpl :" + "function of syncEdi_grp_cgo started.");
    	log.debug("EDISetupBCImpl : [str]:" + str);
    	ESD0330001Document 	doc = null;
		ESD0330001 esd0330001 = null;
		EAIHeaderType headerType = null;
		ESD0330001.DataArea dataArea = null;
		try{
			doc = ESD0330001Document.Factory.parse(str);
			esd0330001 = doc.getESD0330001();
			headerType = esd0330001.getEAIHeader();
            log.debug("\n >> InstanceId >> " + headerType.getInstanceId() );
            dataArea = esd0330001.getDataArea();
            EDIGrpCgoCollection edi_group_collection = dataArea.getEDIGrpCgoCollection();
            EDIGrpCgo [] edi_group_array = edi_group_collection.getEDIGrpCgoArray();
            
            log.debug("syncEdi_grp_cgo_bc");
            
            eaiDao.syncEdi_grp_cgo_his(edi_group_array);	// 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
            eaiDao.syncEdi_grp_cgo(edi_group_array);
            
               
		}catch (XmlException de) {
			log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } 
    }
    /** EAI receive ESD034 로직 처리 - edi group customer table sync
     * @param  String str
     * @throws EventException
     */
    public void syncEdi_grp_cust(String str) throws EventException{
    	log.debug("EDISetupBCImpl :" + "function of syncEdi_grp_cust stated.");
    	log.debug("EDISetupBCImpl : [str]:" + str);
    	ESD0340001Document 	doc 			= null;
		ESD0340001 esd0340001 = null;
		EAIHeaderType headerType = null;
		ESD0340001.DataArea dataArea = null;
		try{
			doc = ESD0340001Document.Factory.parse(str);
			esd0340001 = doc.getESD0340001();
			headerType = esd0340001.getEAIHeader();
	            log.debug("\n >> InstanceId >> " + headerType.getInstanceId() );
	            dataArea = esd0340001.getDataArea();
	            EDIGrpCustCollection group_cust_collection = dataArea.getEDIGrpCustCollection();
	            EDIGrpCust [] group_cust_array = group_cust_collection.getEDIGrpCustArray();
	            
	            eaiDao.syncEdi_grp_cust_his(group_cust_array);		// 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
	            eaiDao.syncEdi_grp_cust(group_cust_array);   
		}catch (XmlException de) {
			log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } 
    }
}
