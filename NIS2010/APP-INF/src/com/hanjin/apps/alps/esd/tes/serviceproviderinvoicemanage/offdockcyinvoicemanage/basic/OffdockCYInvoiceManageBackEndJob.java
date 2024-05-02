/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OffdockCYInvoiceManageBackEndJob.java
 *@FileTitle : OffdockCYInvoiceManageBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.03.11
 *@LastModifier : 박재흥
 *@LastVersion : 1.0
 * 2009.08.17 박재흥
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OffdockCYInvoiceManageBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private EsdTes9140Event event;

	/**
	 *  setEvent
	 * @param event
	 * @throws Exception
	 */
	public void setEvent(EsdTes9140Event event) {
		this.event = event;
	}


	/**
	 * BackEndCommand Start
	 * @return DBRowSet
	 * @throws Exception
	 */
	public EventResponse doStart() throws Exception {
		
		EventResponse eventResponse = null;
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
		int insCnt = 0;
		
		//무조건 임시 TABLE 지우기 1
		log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
		command.removeTES_FILE_IMP_TMP(event);

		//임시 TABLE에 넣고
		log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
		command.createTES_FILE_IMP_TMP(event);

		//계산하기
		log.debug("\n 계산하기 ------------------------  \n");
		eventResponse = command.verifyOffdockCYInvoiceVolume(event); //계산하기
		event.setRowSet(eventResponse.getRs());
		
		//CNTR_LIST에 넣고
		log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
//		begin();
		insCnt = command.insertOffdockCYInvoiceContainerList(event);
//		commit();
		
		eventResponse.setETCData("insCnt", String.valueOf(insCnt));
		eventResponse.setETCData( "successFlag", "SUCCESS" );
		
		eventResponse = command.searchTES_FILE_IMP_TMP(event);
		
		return eventResponse;
	}
}