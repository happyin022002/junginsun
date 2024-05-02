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
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		CniCgoClmInsurVO[] rtnVOs = null;
		if (this.cniCgoClmInsurVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniCgoClmInsurVOs, cniCgoClmInsurVOs.length);
		}
		return rtnVOs;
	}

	public void setCniCgoClmInsurVOs(CniCgoClmInsurVO[] cniCgoClmInsurVOs){
		if(cniCgoClmInsurVOs != null){
			CniCgoClmInsurVO[] tmpVOs = java.util.Arrays.copyOf(cniCgoClmInsurVOs, cniCgoClmInsurVOs.length);
			this.cniCgoClmInsurVOs = tmpVOs;
		}
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