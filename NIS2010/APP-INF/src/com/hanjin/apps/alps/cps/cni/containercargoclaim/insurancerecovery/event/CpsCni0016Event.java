/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0016Event.java
 *@FileTitle : Insurance Recovery by VVD
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
 * [CPS_CNI_0016] Insurance Recovery by VVD
 * @author 진윤오
 * @see CPS_CNI_0016HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0016Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	
	private String trnkRefVvdNo;

	private String insurPlcyYr;
	
	private String insurClmPtyNo;
	
	private String ddctAmt;
	
	private CniCgoClmInsurVO[] cniCgoClmInsurVOs;	
	
	public CniCgoClmInsurVO[] getCniCgoClmInsurVOs() {
		return cniCgoClmInsurVOs;
	}

	public void setCniCgoClmInsurVOs(CniCgoClmInsurVO[] cniCgoClmInsurVOs) {
		this.cniCgoClmInsurVOs = cniCgoClmInsurVOs;
	}

	

	public String getTrnkRefVvdNo() {
		return trnkRefVvdNo;
	}

	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}

	public String getInsurPlcyYr() {
		return insurPlcyYr;
	}

	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}

	public String getInsurClmPtyNo() {
		return insurClmPtyNo;
	}

	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}

	public String getDdctAmt() {
		return ddctAmt;
	}

	public void setDdctAmt(String ddctAmt) {
		this.ddctAmt = ddctAmt;
	}
	

}