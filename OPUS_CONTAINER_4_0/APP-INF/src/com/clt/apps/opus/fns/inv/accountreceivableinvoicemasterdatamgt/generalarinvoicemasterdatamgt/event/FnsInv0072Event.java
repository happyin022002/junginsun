/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0072Event.java
*@FileTitle : Cut-off VVD Entry for New A/R Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.05 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * FNS_INV_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0072HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String oldOfc = null;
	private String newOfc = null;
	
	private String slanCd = null;
	private String portCd = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;	
	
	private String ioBndCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvCutOffLaneVO invCutOffLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvCutOffLaneVO[] invCutOffLaneVOs = null;

	public FnsInv0072Event(){}
	
	public void setInvCutOffLaneVO(InvCutOffLaneVO invCutOffLaneVO){
		this. invCutOffLaneVO = invCutOffLaneVO;
	}

	public void setInvCutOffLaneVOS(InvCutOffLaneVO[] invCutOffLaneVOs){
		if (invCutOffLaneVOs != null) {
			InvCutOffLaneVO[] tmpVOs = new InvCutOffLaneVO[invCutOffLaneVOs.length];
			System.arraycopy(invCutOffLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invCutOffLaneVOs = tmpVOs;
		}
	}

	public InvCutOffLaneVO getInvCutOffLaneVO(){
		return invCutOffLaneVO;
	}

	public InvCutOffLaneVO[] getInvCutOffLaneVOS(){
		InvCutOffLaneVO[] rtnVOs = null;
		if (this.invCutOffLaneVOs != null) {
			rtnVOs = new InvCutOffLaneVO[invCutOffLaneVOs.length];
			System.arraycopy(invCutOffLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getOldOfc() {
		return oldOfc;
	}

	public void setOldOfc(String oldOfc) {
		this.oldOfc = oldOfc;
	}

	public String getNewOfc() {
		return newOfc;
	}

	public void setNewOfc(String newOfc) {
		this.newOfc = newOfc;
	}

	public String getSlanCd() {
		return slanCd;
	}

	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getIoBndCd() {
		return ioBndCd;
	}

	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}





}