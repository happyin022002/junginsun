/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0035Event.java
 *@FileTitle : View-Indemnity Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.29
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.29 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0035] View-Indemnity Claim
 * @author 박제성
 * @see CPS_CNI_0035HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CGO_CLM_NO */
    private String cgoClmNo;

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


}