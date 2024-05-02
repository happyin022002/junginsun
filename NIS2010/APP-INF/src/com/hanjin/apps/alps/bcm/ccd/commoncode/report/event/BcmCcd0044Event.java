/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0025Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0044Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VendorReportVO vendorReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VendorReportVO[] vendorReportVOs = null;

	public BcmCcd0044Event(){}
	
	public void setVendorReportVO(VendorReportVO vendorReportVO){
		this. vendorReportVO = vendorReportVO;
	}

	public void setVendorReportVOS(VendorReportVO[] vendorReportVOs){
		if(vendorReportVOs != null){
			VendorReportVO[] tmpVOs = java.util.Arrays.copyOf(vendorReportVOs, vendorReportVOs.length);
			this.vendorReportVOs = tmpVOs;
		}
	}

	public VendorReportVO getVendorReportVO(){
		return vendorReportVO;
	}

	public VendorReportVO[] getVendorReportVOS(){
		VendorReportVO[] rtnVOs = null;
		if (this.vendorReportVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(vendorReportVOs, vendorReportVOs.length);
		}
		return rtnVOs;
	}
}