/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0014Event.java
 *@FileTitle : Settlement Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.24
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.24 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.event;



import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0014] Settlement Claim
 * @author 박제성
 * @see CPS_CNI_0014HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_NO */
    private String cgoClmNo;
    
    /* CGO_CLM_MISC_CD */
    private String miscCd;
    


	/* VO */
    private SettlementVO settlementVO;
    private CniSettlementVO cniSettlementVO;
    private GwApproveStatusVO gwApproveStatusVO;

	public GwApproveStatusVO getGwApproveStatusVO() {
		return gwApproveStatusVO;
	}

	public void setGwApproveStatusVO(GwApproveStatusVO gwApproveStatusVO) {
		this.gwApproveStatusVO = gwApproveStatusVO;
	}

	public CniSettlementVO getCniSettlementVO() {
		return cniSettlementVO;
	}

	public void setCniSettlementVO(CniSettlementVO cniSettlementVO) {
		this.cniSettlementVO = cniSettlementVO;
	}

	public SettlementVO getSettlementVO() {
		return settlementVO;
	}

	public void setSettlementVO(SettlementVO settlementVO) {
		this.settlementVO = settlementVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	
	public String getMiscCd() {
		return miscCd;
	}

	public void setMiscCd(String miscCd) {
		this.miscCd = miscCd;
	}
	

}