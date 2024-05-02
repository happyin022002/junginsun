/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSco0020Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0020Event 참조
 * @since J2EE 1.4
 */

public class StmSco0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private LookupHeaderVO[] lookupHeaderVOs = null;
	private LookupDetailVO[] lookupDetailVOs = null;
	private ApplicationComboVO[] applicationComboVOs = null;

	private String luTpCd  = "";
	private String luApplCd  = "";
	private String hLuTpCd  = "";
	private String dLuTpCd  = "";
	private String applCd = "";
	
	public String getLuTpCd() {
		return luTpCd;
	}
	
	public void setLuTpCd(String luTpCd) {
		this.luTpCd = luTpCd;
	}
	
	public String getLuApplCd() {
		return luApplCd;
	}
	
	public void setLuApplCd(String luApplCd) {
		this.luApplCd = luApplCd;
	}
	 
	public String getHluTpCd() {
		return hLuTpCd;
	}
	
	public void setHluTpCd(String hLuTpCd) {
		this.hLuTpCd = hLuTpCd;
	}
	
	public String getDluTpCd() {
		return dLuTpCd;
	}
	
	public void setDluTpCd(String dLuTpCd) {
		this.dLuTpCd = dLuTpCd;
	}

	public LookupHeaderVO[] getLookupHeaderVOs() {		
		LookupHeaderVO[] rtnVOs = null;
		if (this.lookupHeaderVOs != null) {
			rtnVOs = new LookupHeaderVO[lookupHeaderVOs.length];
			System.arraycopy(lookupHeaderVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLookupHeaderVOs(LookupHeaderVO[] lookupHeaderVOs) {
		if (lookupHeaderVOs != null) {
			LookupHeaderVO[] tmpVOs = new LookupHeaderVO[lookupHeaderVOs.length];
			System.arraycopy(lookupHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lookupHeaderVOs = tmpVOs;
		}
	}
	
    public LookupDetailVO[] getLookupDetailVOs() {
		LookupDetailVO[] rtnVOs = null;
		if (this.lookupDetailVOs != null) {
			rtnVOs = new LookupDetailVO[lookupDetailVOs.length];
			System.arraycopy(lookupDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLookupDetailVOs(LookupDetailVO[] lookupDetailVOs) {
		if (lookupDetailVOs != null) {
			LookupDetailVO[] tmpVOs = new LookupDetailVO[lookupDetailVOs.length];
			System.arraycopy(lookupDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lookupDetailVOs = tmpVOs;
		}
	}
	
    public ApplicationComboVO[] getApplicationComboVOs() {
		ApplicationComboVO[] rtnVOs = null;
		if (this.applicationComboVOs != null) {
			rtnVOs = new ApplicationComboVO[applicationComboVOs.length];
			System.arraycopy(applicationComboVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setApplicationComboVOs(ApplicationComboVO[] applicationComboVOs) {
		if (applicationComboVOs != null) {
			ApplicationComboVO[] tmpVOs = new ApplicationComboVO[applicationComboVOs.length];
			System.arraycopy(applicationComboVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.applicationComboVOs = tmpVOs;
		}
	}
	
	public String getApplCd() {
		return applCd;
	}

	public void setApplCd(String applCd) {
		this.applCd = applCd;
	}
	

}