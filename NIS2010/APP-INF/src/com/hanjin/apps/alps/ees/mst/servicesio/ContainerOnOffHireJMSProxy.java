/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueIJMSProxy.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-01
 *@LastModifier : Lee Ho-Sun
 *@LastVersion : 1.0
 * 2009-09-01 Lee Ho-Sun
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.ees.mst.servicesio;

import java.util.ArrayList; 

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.EquipmentManagementSC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.Fns0260001Event;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.erp.FNS026R001Document;
import com.hanjin.irep.erp.FNS026R001Document.FNS026R001;
import com.hanjin.irep.erp.FNS026R001Document.FNS026R001.DataArea.CntrRegResultReturnCollection;
import com.hanjin.irep.erp.FNS026R001Document.FNS026R001.DataArea.CntrRegResultReturnCollection.CntrRegResultReturn;
import com.jf.transfer.TransferEAI;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS 서버에서 xml 메세지를 받아 RSC 에 넘겨준다.
 * Event 관리를 한다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * @author HO SUN, LEE
 * @see 
 * @since J2EE 1.6
 */ 
public class ContainerOnOffHireJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * FNS026R001 : EAI Receive(Inbound)<br>  
	 * ERP에서 호출된 것을 SC를 호출하여 데이타 처리한다.<br>
	 * @author LEE HO SUN
	 * @category FNS026R001
	 * @category fNS026R001ReceiveJMS  
	 * @param TransferEAI eai
	 */	
	public void fNS026R001ReceiveJMS(TransferEAI eai) {
        String str = eai.getMessage();
        
        Event event = null;
        EquipmentManagementSC equipmentManagementSC = new EquipmentManagementSC();

        try {
            event = new Fns0260001Event();

            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);

            FNS026R001Document doc = FNS026R001Document.Factory.parse(str);
            FNS026R001 fns026R001 = doc.getFNS026R001();
            FNS026R001.DataArea dataArea = fns026R001.getDataArea();
            
            CntrRegResultReturnCollection  cntrRegResultReturnCollection = dataArea.getCntrRegResultReturnCollection();
            
            int cnt = cntrRegResultReturnCollection.sizeOfCntrRegResultReturnArray();
            
            if (cnt > 0) {
            	CntrRegResultReturn[] cntrRegResults = cntrRegResultReturnCollection.getCntrRegResultReturnArray();
            
                ArrayList<CntrMasterUpdateIFVO> list = new ArrayList<CntrMasterUpdateIFVO>();
                CntrMasterUpdateIFVO cntrMasterUpdateIFVO = new CntrMasterUpdateIFVO();
                CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs = new CntrMasterUpdateIFVO[cnt];

                for (int i = 0; i < cnt; i++) {
                	cntrMasterUpdateIFVO = new CntrMasterUpdateIFVO();
                	
                	cntrMasterUpdateIFVO.setLifid(cntrRegResults[i].getLIFID());
                	cntrMasterUpdateIFVO.setIfSeq(cntrRegResults[i].getEAIIFNO());// Send와 데이타가 다른 것으로 맵핑됨  
                	cntrMasterUpdateIFVO.setIfTtlRowKnt(cntrRegResults[i].getIFTTLROWKNT());
                	cntrMasterUpdateIFVO.setEaiIfNo(cntrRegResults[i].getSEQ()); // Send와 데이타가 다른 것으로 맵핑됨 
                	cntrMasterUpdateIFVO.setEqNo(cntrRegResults[i].getEQNO());//
                	cntrMasterUpdateIFVO.setFaIfTpCd(cntrRegResults[i].getFAIFTPCD());//
                	cntrMasterUpdateIFVO.setFaIfDt(cntrRegResults[i].getFAIFDT());//
                	cntrMasterUpdateIFVO.setRetAproNo(cntrRegResults[i].getRETAPRONO());//
                	cntrMasterUpdateIFVO.setFaIfStsCd(cntrRegResults[i].getFAIFSTSCD());//
                	cntrMasterUpdateIFVO.setFaIfErrMsg(cntrRegResults[i].getFAIFERRMSG());//
                	cntrMasterUpdateIFVO.setFaEqNo(cntrRegResults[i].getFAEQNO());//
                	cntrMasterUpdateIFVO.setFaIfGrpSeqNo(cntrRegResults[i].getFAIFSEQ());//
                	cntrMasterUpdateIFVO.setCreatedBy(cntrRegResults[i].getCREATEDBY());
                    list.add(cntrMasterUpdateIFVO);
                }
                list.toArray(cntrMasterUpdateIFVOs);
                ((Fns0260001Event) event).setCntrMasterUpdateIFVOs(cntrMasterUpdateIFVOs);
                equipmentManagementSC.perform(event);
            }
            eai.commit(doc.getFNS026R001().getEAIHeader().getInstanceId());
        } catch (EventException ee) {
            eai.rollback(ee);
            log.error(ee.getMessage());
        } catch (XmlException ex) {
            eai.rollback(ex);
            log.error(ex.getMessage());
        } catch (Exception e) {
            eai.rollback(e);
            log.error(e.getMessage());
        }
        eai.close();
    }
}
