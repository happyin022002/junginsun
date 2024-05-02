/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmMovementGatenewMQProxy.java
*@FileTitle : ENIS Interface 연동 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김상수
*@LastVersion : 1.1
* 2007-04-10 
* 1.0 최초 생성
* 2009.09.17 김상수
* 1.1 Modification
 =========================================================*/
package com.hanjin.apps.alps.ees.ctm.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.EquipmentMovementMgtSC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.UbizhjsAlpsCtmEqmvmtEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 *  MQ에서 String 메세지를 받아 EquipmentMovementMgtSC에 넘겨준다. Event관리를 한다.
 *  [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author 김상수
 * @see EquipmentMovementMgtSC
 * @since J2EE 1.6
 */
public class CtmMovementGatenewMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(UBIZHJS_NIS2010VSK_ACTSKD)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException, XmlException, Exception
	 */
	public void receiveEqMvmtEDIForGatenew(TransferEAI eai) throws EventException {
		String str = eai.getMessage();
		log.debug("\n======================================" +
				  "\n[CtmMovementGatenewMQProxy] : str" +
				  "\n======================================" +
				  "\n" + str +
				  "======================================\n");
		try{
			Event event = new UbizhjsAlpsCtmEqmvmtEvent();
			EquipmentMovementMgtSC sc = new EquipmentMovementMgtSC();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((UbizhjsAlpsCtmEqmvmtEvent) event).setFlatFile(str);
			sc.perform(event);
			eai.commit(str.substring(0, 10));
		} catch (EventException ex) {
			eai.rollback(ex);			
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			eai.rollback(ex);
			log.error(" err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		eai.close();
	}

}