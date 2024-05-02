/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustPreferenceBCImpl.java
*@FileTitle : jms bc 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2006-11-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custpreference.basic;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esd.trs.servicesio.custpreference.integration.CustPreferenceDBDAO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsd.ESD0400001Document;
import com.hanjin.irep.enisEsd.ESD0400001Document.ESD0400001;
import com.hanjin.irep.enisEsd.ESD0400001Document.ESD0400001.DataArea.CustPreferenceCollection;
import com.hanjin.irep.enisEsd.ESD0400001Document.ESD0400001.DataArea.CustPreferenceCollection.CustPreference;
import com.hanjin.syscommon.common.table.TrsCustPrfVO;

/**
 * ENIS-ESD Business Logic ServiceCommand<br>
 * - ENIS-ESD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author an
 * @see  참조
 * @since J2EE 1.4
 */
public class CustPreferenceBCImpl extends BasicCommandSupport implements CustPreferenceBC{
private transient CustPreferenceDBDAO dbDao=null;
	
	/**
	 * TPBInterfaceBCImpl 객체 생성<br>
	 * TPBInterfaceDBDAO를 생성한다.<br>
	 */
	public CustPreferenceBCImpl(){
		dbDao = new CustPreferenceDBDAO();
	}
	/**
	 * Creating Data Received From MNR<br>
	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
	 * 
	 * @param models
	 * @return 
	 */
	public boolean createPRDTB(Collection models){

		boolean isSuccessful = false;
		
		try {
			isSuccessful = dbDao.manageTRSCUSTPRF(models);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
		}
		return isSuccessful;
	}
	
	/**
	 * CustPreferenceBCImpl's receiveXML
	 * @param xmlObject
	 * @return
	 */
	public Collection receiveXML(XmlObject xmlObject) {

		ESD0400001Document 	doc = (ESD0400001Document)xmlObject ;
		ESD0400001 esd0400001 = doc.getESD0400001();
		ESD0400001.DataArea dataArea = esd0400001.getDataArea();
		CustPreferenceCollection cpCollection = dataArea.getCustPreferenceCollection();            
        CustPreference[] cp  = cpCollection.getCustPreferenceArray();
        
		
		Collection models = new ArrayList();
		TrsCustPrfVO pcp = null;
        for(int i = 0 ; i < cp.length ; i++){
        	log.debug("\n " +cp[i].getCrmRowId()  + "|" + cp[i].getCustCntCd()+ "|" + cp[i].getCustSeq()+ "|" + cp[i].getTrspModCd()
        			+ "\n " +"|" + cp[i].getOrgLocCd()+ "|" + cp[i].getDestLocCd()+ "|" + cp[i].getVndrCntCd()+ "|" + cp[i].getVndrSeq()
        			+ "\n " +"|" + cp[i].getCreUsrId()+ "|" + cp[i].getCreDt()+ "|" + cp[i].getUpdUsrId()+ "|" + cp[i].getUpdDt()
        			+ "\n " +"|" + cp[i].getMsgId()+ "|" + cp[i].getMsgEtt()+ "|" + cp[i].getSrcSysCd()+ "|" + cp[i].getMsgCreDt()+ "|" + cp[i].getOpCd());

        	pcp = new TrsCustPrfVO();
        	
        	pcp.setCrmRowId(cp[i].getCrmRowId());
        	pcp.setCustCntCd(cp[i].getCustCntCd());
        	pcp.setCustSeq(cp[i].getCustSeq());
        	pcp.setTrspModCd(cp[i].getTrspModCd());
        	pcp.setOrgLocCd(cp[i].getOrgLocCd());
        	pcp.setDestLocCd(cp[i].getDestLocCd());
        	pcp.setVndrCntCd(cp[i].getVndrCntCd());
        	pcp.setVndrSeq(cp[i].getVndrSeq());
        	pcp.setCreUsrId(cp[i].getCreUsrId());
        	pcp.setCreDt(cp[i].getCreDt());
        	pcp.setUpdUsrId(cp[i].getUpdUsrId());
        	pcp.setUpdDt(cp[i].getUpdDt());
        	pcp.setIbflag(cp[i].getOpCd());
        	log.debug("\n\n pcp:="+pcp.toString());
        	models.add(pcp);

        }
        
		return models;
	}
}
