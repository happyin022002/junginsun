/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0002Event.java
 *@FileTitle : Find
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0002] Find
 * @author 양정란 
 * @see CPS_CNI_0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* 조회라디오박스 */
    private String schCond;
    /* 조회 문자열 */
    private String schStr;
    
	private String pageNo;

    /* VO */
    private FindVO findVO;
    private FindCondVO findCondVO;
    
    public FindCondVO getFindCondVO() {
		return findCondVO;
	}

	public void setFindCondVO(FindCondVO findCondVO) {
		this.findCondVO = findCondVO;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getSchCond() {
		return schCond;
	}

	public void setSchCond(String schCond) {
		this.schCond = schCond;
	}

	public String getSchStr() {
		return schStr;
	}

	public void setSchStr(String schStr) {
		this.schStr = schStr;
	}

	public FindVO getFindVO() {
		return findVO;
	}

	public void setFindVO(FindVO findVO) {
		this.findVO = findVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}