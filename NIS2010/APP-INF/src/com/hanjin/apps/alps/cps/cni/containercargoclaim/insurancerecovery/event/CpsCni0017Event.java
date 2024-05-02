/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0017Event.java
 *@FileTitle : Insurance Recovery by Case
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0017] Insurance Recovery by Case
 * @author 진윤오
 * @see CPS_CNI_0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0017Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	
		
	private CniCgoClmInsurVO cniCgoClmInsurVO;

	private String cgoClmNo;

	private String cgoClmStlUsdAmt = "0";
	
	private String lablPtyRcvrUsdAmt = "0";
	
	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public String getCgoClmStlUsdAmt() {
		return cgoClmStlUsdAmt;
	}

	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}

	public String getLablPtyRcvrUsdAmt() {
		return lablPtyRcvrUsdAmt;
	}

	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}


	public CniCgoClmInsurVO getCniCgoClmInsurVO() {
		return cniCgoClmInsurVO;
	}


	public void setCniCgoClmInsurVO(CniCgoClmInsurVO cniCgoClmInsurVO) {
		this.cniCgoClmInsurVO = cniCgoClmInsurVO;
	}	
	


}