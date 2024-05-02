/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0015Event.java
 *@FileTitle : Indemnity Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.22 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0015] Indemnity Claim
 * @author 박제성
 * @see CPS_CNI_0015HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_NO */
    private String cgoClmNo;
    
    /* CGO_CLM_MISC_CD */
    private String miscCd;
    
    private String cgoClmStlUsdAmt;
    
    /* B/L NO */
    private String blNo;
    

    /* VO */
    private LiablePartyVO liablePartyVO;
    private CniLiablePartyVO cniLiablePartyVO;
    

	public CniLiablePartyVO getCniLiablePartyVO() {
		return cniLiablePartyVO;
	}

	public void setCniLiablePartyVO(CniLiablePartyVO cniLiablePartyVO) {
		this.cniLiablePartyVO = cniLiablePartyVO;
	}

	public LiablePartyVO getLiablePartyVO() {
		return liablePartyVO;
	}

	public void setLiablePartyVO(LiablePartyVO liablePartyVO) {
		this.liablePartyVO = liablePartyVO;
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
	
	public String getCgoClmStlUsdAmt() {
		return cgoClmStlUsdAmt;
	}

	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}


}