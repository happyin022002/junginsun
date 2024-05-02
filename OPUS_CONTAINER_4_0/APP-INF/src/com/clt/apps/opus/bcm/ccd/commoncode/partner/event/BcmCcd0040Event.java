/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0040Event.java
*@FileTitle : credit customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;

import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorGroupVO;
import com.clt.framework.support.layer.event.EventSupport;
 

/**
 * BCM_CCD_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0040Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	public BcmCcd0040Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VendorGroupVO vendorGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VendorGroupVO[] vendorGroupVOs = null;
	
	private String checkCd = null;
	
	private String checkDeCntCd = null;
	
	private String vndrSeq = null; 
	
	private String vndrCntCd = null;
	
	private String rqstNo = null; 
	
	private MdmDatProcVO mdmDatProcVO = null;
	
	
///////////////////////////////////////////////////////////////////////	

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrCntCd() {
		return vndrCntCd;
	}

	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	public String getRqstNo() {
		return rqstNo;
	}
	
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	public VendorGroupVO getVendorGroupVO() {
		return vendorGroupVO;
	}

	public void setVendorGroupVO(VendorGroupVO vendorGroupVO) {
		this.vendorGroupVO = vendorGroupVO;
	}

	public VendorGroupVO[] getVendorGroupVOs() {
		VendorGroupVO[] rtnVOs = null;
		if (this.vendorGroupVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(vendorGroupVOs, vendorGroupVOs.length);
		}
		return rtnVOs;
	}

	public void setVendorGroupVOs(VendorGroupVO[] vendorGroupVOs){
		if(vendorGroupVOs != null){
			VendorGroupVO[] tmpVOs = java.util.Arrays.copyOf(vendorGroupVOs, vendorGroupVOs.length);
			this.vendorGroupVOs = tmpVOs;
		}
	}

	public String getCheckCd() {
		return checkCd;
	}

	public void setCheckCd(String checkCd) {
		this.checkCd = checkCd;
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}

	public String getCheckDeCntCd() {
		return checkDeCntCd;
	}

	public void setCheckDeCntCd(String checkDeCntCd) {
		this.checkDeCntCd = checkDeCntCd;
	}

}