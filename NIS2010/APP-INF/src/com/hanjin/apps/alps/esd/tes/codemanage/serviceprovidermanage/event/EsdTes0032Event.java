/*=========================================================
*Copyright(c) 2017 HiplusCard
*@FileName : ESD_TES_0032Event.java
*@FileTitle : Service Provider Code Master(India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017-06-29
*@LastModifier : 
*@LastVersion : 1.0
* 2017-06-29 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.event;

import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.vo.MdmVendorInfoVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_ESD_TES_032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_ESD_TES_032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class EsdTes0032Event extends EventSupport {
	
	private MdmVendorInfoVO mdmVendorInfoVO = null;
	private MdmVendorInfoVO[] mdmVendorInfoVOs = null; 
	
	/**
	 * @return the mdmVendorInfoVO
	 */
	public MdmVendorInfoVO getMdmVendorInfoVO() {
		return mdmVendorInfoVO;
	}
	/**
	 * @param mdmVendorInfoVO the mdmVendorInfoVO to set
	 */
	public void setMdmVendorInfoVO(MdmVendorInfoVO mdmVendorInfoVO) {
		this.mdmVendorInfoVO = mdmVendorInfoVO;
	}
	/**
	 * @return the mdmVendorInfoVOs
	 */
	public MdmVendorInfoVO[] getMdmVendorInfoVOs() {
		return mdmVendorInfoVOs;
	}
	/**
	 * @param mdmVendorInfoVOs the mdmVendorInfoVOs to set
	 */
	public void setMdmVendorInfoVOs(MdmVendorInfoVO[] mdmVendorInfoVOs) {
		this.mdmVendorInfoVOs = mdmVendorInfoVOs;
	}
	
}
