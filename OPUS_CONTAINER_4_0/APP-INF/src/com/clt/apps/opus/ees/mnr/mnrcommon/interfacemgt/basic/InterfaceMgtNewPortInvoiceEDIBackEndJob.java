/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceMgtNewPortInvoiceEDIBackEndJob.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2015.10.08 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * OPUS-New Port EDI Back End Job Business Logic Basic Command implementation<br>
 * - OPUS-New Port EDI Back End Job에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KYOUNG WAN CHO
 * @see InterfaceMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InterfaceMgtNewPortInvoiceEDIBackEndJob extends BackEndCommandSupport{
	
	private static final long serialVersionUID = 1L;
	
	private InterfaceGRPVO ifGRPVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	
	/**
	 * InterfaceMgtNewPortInvoiceEDIBackEndJob 객체 생성<br>
	 * InterfaceMgtDBDAO를 생성한다.<br>
	 */
	public InterfaceMgtNewPortInvoiceEDIBackEndJob(){

	}
	
	/**
	 * New Port EDI 를 Import 하고 Verify 하는 오퍼레이션 BackEndJob Start
	 * @return InterfaceGRPVO
	 * @throws Exception
	 */
	@Override
	public Object doStart() throws Exception {
		InterfaceGRPVO interfaceGRPVO = null;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		try {
//			interfaceGRPVO = manageMQNewPortRepairInvoiceBasic(this.interfaceGRPVO);
			interfaceGRPVO = command.verifyNewPortTempDataBasic(this.ifGRPVO, this.signOnUserAccount);
			interfaceGRPVO = command.manageNewPortWOInvoiceDataBasic(interfaceGRPVO, this.signOnUserAccount);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("NEW PORT EDI", new String[] {}).getMessage());
	    }
		return "";
	}

	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * CusCtmMovementVO
	 */
	public void setInterfaceGRPVO(InterfaceGRPVO interfaceGRPVO) {
		this.ifGRPVO = interfaceGRPVO;
	}
	
	public void setSignOnAccount(SignOnUserAccount account){
		this.signOnUserAccount = account;
	}
}
