/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0079Event.java
*@FileTitle : Unmatched Revenue VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.07 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0079HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/* I/F Date */
	private String fromDt = "";
	private String toDt = "";
	
	private ARBkgInterfaceCreationVO aRBkgInterfaceCreationVO = null;
	private ARBkgInterfaceCreationVO[] aRBkgInterfaceCreationVOs = null;	
	
	/* BKG I/F */
	private String bkgIfFlg = "";
	
	/* BackEndJob ID */
	private String batchJobID = "";

	public String getFromDt() {
		return fromDt;
	}

	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	public String getBkgIfFlg() {
		return bkgIfFlg;
	}

	public void setBkgIfFlg(String bkgIfFlg) {
		this.bkgIfFlg = bkgIfFlg;
	}
	
	public String getBatchJobID() {
		return batchJobID;
	}

	public void setBatchJobID(String batchJobID) {
		this.batchJobID = batchJobID;
	}

	public ARBkgInterfaceCreationVO getARBkgInterfaceCreationVO(){
		return aRBkgInterfaceCreationVO;
	}
	
	public void setARBkgInterfaceCreationVO(ARBkgInterfaceCreationVO aRBkgInterfaceCreationVO){
		this.aRBkgInterfaceCreationVO = aRBkgInterfaceCreationVO;
	}

	public ARBkgInterfaceCreationVO[] getARBkgInterfaceCreationVOS(){
		return aRBkgInterfaceCreationVOs;
	}

	public void setARBkgInterfaceCreationVOS(ARBkgInterfaceCreationVO[] aRBkgInterfaceCreationVOs){
		this.aRBkgInterfaceCreationVOs = aRBkgInterfaceCreationVOs;
	}
}