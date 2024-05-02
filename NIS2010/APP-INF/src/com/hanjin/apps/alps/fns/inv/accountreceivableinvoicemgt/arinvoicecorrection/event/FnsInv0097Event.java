/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0097Event.java
*@FileTitle : Invoice Letter Wording Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.03 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvIssAtchVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvissAtchInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0097HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	//기본 조회 조건
	private String ofcCd = null;
	private String vvdCd = null;
	private String portCd = null;
	private String searchOption = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvissAtchInputVO invissAtchInput = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvIssAtchVO invIssAtchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvIssAtchVO[] invIssAtchVOs = null;

	public FnsInv0097Event(){}

	public void setInvissAtchInput(InvissAtchInputVO invissAtchInput){
		this. invissAtchInput = invissAtchInput;
	}

	public void setInvIssAtchVO(InvIssAtchVO invIssAtchVO){
		this. invIssAtchVO = invIssAtchVO;
	}

	public void setInvIssAtchVOS(InvIssAtchVO[] invIssAtchVOs){
		this. invIssAtchVOs = invIssAtchVOs;
	}

	public InvissAtchInputVO getInvissAtchInput(){
		return invissAtchInput;
	}

	public InvIssAtchVO getInvIssAtchVO(){
		return invIssAtchVO;
	}

	public InvIssAtchVO[] getInvIssAtchVOS(){
		return invIssAtchVOs;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getVvdCd() {
		return vvdCd;
	}

	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

}