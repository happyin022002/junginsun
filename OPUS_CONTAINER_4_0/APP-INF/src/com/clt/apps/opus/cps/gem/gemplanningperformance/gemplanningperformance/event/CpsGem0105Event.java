/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0105Event.java
 *@FileTitle : [CPS_GEM_0105] Request No. Reference
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_GEM_0105] Request No. Reference
 * CPS_GEM-0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CpsGem0105Event 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0105HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String plnYrmon = "";
	private String rqstOfcCd = "";
	private String updUserId = "";
	private String genExpnRqstTpCd = "";
	private String prgId = "";
	private String authFlg = "";
	
	public String getAuthFlg() {
		return authFlg;
	}
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	public String getPrgId() {
		return prgId;
	}
	public void setPrgId(String prgId) {
		this.prgId = prgId;
	}
	public String getPlnYrmon() {
		return plnYrmon;
	}
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	public String getRqstOfcCd() {
		return rqstOfcCd;
	}
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	public String getUpdUserId() {
		return updUserId;
	}
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}
	public String getGenExpnRqstTpCd() {
		return genExpnRqstTpCd;
	}
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}


}