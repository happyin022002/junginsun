/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppusermanageEvent.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.30 안준상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.event;

import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.vo.MnrPartnerGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MnrPartnerVO;


/**
 * SppUserManage 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SppUserManageHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jsahn
 * @see SppUserManageHTMLAction 참조
 * @since J2EE 1.6
 */

public class SppusermanageEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MnrPartnerGRPVO mnrPartnerGRPVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MnrPartnerVO mnrPartnerVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVendorVO mdmVendorVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String spPtalId = null;
	
	/* Vendor Sequence */
	private String vndrSeq;

	public SppusermanageEvent(){}
	
	public void setSpPtalId(String spPtalId){
		this.spPtalId = spPtalId;
	}
	
	public void setMnrPartnerGRPVO(MnrPartnerGRPVO mnrPartnerGRPVO){
		this.mnrPartnerGRPVO = mnrPartnerGRPVO;
	}

	public void setMnrPartnerVO(MnrPartnerVO mnrPartnerVO){
		this. mnrPartnerVO = mnrPartnerVO;
	}
	
	public void setMdmVendorVO(MdmVendorVO mdmVendorVO){
		this. mdmVendorVO = mdmVendorVO;
	}
	
	public String getSpPtalId(){
		return spPtalId;
	}
	
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}
	
	public MnrPartnerGRPVO getMnrPartnerGRPVO(){
		return mnrPartnerGRPVO;
	}
	
	
	public MnrPartnerVO getMnrPartnerVO(){
		return mnrPartnerVO;
	}
	

	public MdmVendorVO getMdmVendorVO(){
		return mdmVendorVO;
	}
}