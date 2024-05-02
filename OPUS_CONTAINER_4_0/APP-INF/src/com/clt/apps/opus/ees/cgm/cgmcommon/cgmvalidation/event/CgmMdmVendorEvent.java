/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmMdmVendorEvent.java
*@FileTitle : s
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.02 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CGM_MDM_VENDOR 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CGM_MDM_VENDORHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see CGM_MDM_VENDOR_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmMdmVendorEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVendorMGTVO mdmVendorMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVendorMGTVO[] mdmVendorMGTVOs = null;

	public CgmMdmVendorEvent(){}

	/**
	 * @return the mdmVendorMGTVO
	 */
	public MdmVendorMGTVO getMdmVendorMGTVO() {
		return mdmVendorMGTVO;
	}

	/**
	 * @param mdmVendorMGTVO the mdmVendorMGTVO to set
	 */
	public void setMdmVendorMGTVO(MdmVendorMGTVO mdmVendorMGTVO) {
		this.mdmVendorMGTVO = mdmVendorMGTVO;
	}

	/**
	 * @return the mdmVendorMGTVOs
	 */
	public MdmVendorMGTVO[] getMdmVendorMGTVOs() {
		MdmVendorMGTVO[] rtnVOs = null;
		if (this.mdmVendorMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmVendorMGTVOs, mdmVendorMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param mdmVendorMGTVOs the mdmVendorMGTVOs to set
	 */
	public void setMdmVendorMGTVOs(MdmVendorMGTVO[] mdmVendorMGTVOs){
		if(mdmVendorMGTVOs != null){
			MdmVendorMGTVO[] tmpVOs = java.util.Arrays.copyOf(mdmVendorMGTVOs, mdmVendorMGTVOs.length);
			this.mdmVendorMGTVOs = tmpVOs;
		}
	}
	
	

}