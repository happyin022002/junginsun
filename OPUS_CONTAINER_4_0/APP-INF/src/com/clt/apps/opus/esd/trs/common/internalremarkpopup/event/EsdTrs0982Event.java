 /*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTrs0982Event.java
*@FileTitle : Internal Remark 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-07
*@LastModifier : ChanWooPark
*@LastVersion : 1.0
* 2015-05-07 ChanWooPark
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0982 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0982HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHAN WOO PARK
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0982Event extends EventSupport {
	private static final long serialVersionUID = -854649763066287553L;

	private String bkg_no = "";		// Booking Number
	private String eq_no = "";		// Equipment Number(Container, Chassis, Genset)
	private String so_no = "";		// S/O No.
	private String wo_no = "";		// W/O No.
	private String inter_rmk_cd = "";
	private String ofc_cd = "";		// Office Code
	
	private InternalRemarkVO	internalRemarkVO	= null;
	private InternalRemarkVO[]	internalRemarkVOs	= null;

	public String getBkg_no() {
		return bkg_no;
	}
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	public String getEq_no() {
		return eq_no;
	}
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}
	public String getSo_no() {
		return so_no;
	}
	public void setSo_no(String so_no) {
		this.so_no = so_no;
	}
	public String getWo_no() {
		return wo_no;
	}
	public void setWo_no(String wo_no) {
		this.wo_no = wo_no;
	}
	public String getInter_rmk_cd() {
		return inter_rmk_cd;
	}
	public void setInter_rmk_cd(String inter_rmk_cd) {
		this.inter_rmk_cd = inter_rmk_cd;
	}
	public String getOfc_cd() {
		return ofc_cd;
	}
	public void setOfc_cd(String ofc_cd) {
		this.ofc_cd = ofc_cd;
	}
	public InternalRemarkVO getInternalRemarkVO() {
		return internalRemarkVO;
	}
	public void setInternalRemarkVO(InternalRemarkVO internalRemarkVO) {
		this.internalRemarkVO = internalRemarkVO;
	}
	public InternalRemarkVO[] getInternalRemarkVOs() {
		InternalRemarkVO[] rtnVOs = null;
		if (this.internalRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(this.internalRemarkVOs, this.internalRemarkVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setInternalRemarkVOs(InternalRemarkVO[] internalRemarkVOs) {
		if (internalRemarkVOs != null) {
			InternalRemarkVO[] tmpVOs = Arrays.copyOf(internalRemarkVOs, internalRemarkVOs.length);
			this.internalRemarkVOs = tmpVOs;
		}
	}
}
