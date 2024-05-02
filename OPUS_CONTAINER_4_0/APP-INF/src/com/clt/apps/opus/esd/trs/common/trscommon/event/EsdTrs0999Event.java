/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : EsdTrs0999Event.java
 *@FileTitle : TrsCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.19
 *@LastModifier : 황효근
 *@LastVersion : 1.0
 * 2011.10.19 황효근
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsComboVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author HwangHyoKeun
 * @see ESD_TRS_0999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0999Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String cmdtCd = "";

	private String custCd = "";

	private String wgtMeasUtCd;

	private String cntrWgt;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TrsComboVO trsComboVO = null;

	/** Table Value Object Multi Data 처리 */
	private TrsComboVO[] trsComboVOs = null;

	public EsdTrs0999Event() {
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public void setTrsComboVO(TrsComboVO trsComboVO) {
		this.trsComboVO = trsComboVO;
	}

	public void setTrsComboVOS(TrsComboVO[] trsComboVOs) {
		if (trsComboVOs != null) {
			TrsComboVO[] tmpVOs = Arrays.copyOf(trsComboVOs, trsComboVOs.length);
			this.trsComboVOs = tmpVOs;
		} // end if
	}

	public TrsComboVO getTrsComboVO() {
		return trsComboVO;
	}

	public TrsComboVO[] getTrsComboVOS() {
		TrsComboVO[] rtnVOs = null;
		if (this.trsComboVOs != null) {
			rtnVOs = Arrays.copyOf(trsComboVOs, trsComboVOs.length);
		} // end if
		return rtnVOs;
	}

	public String getWgtMeasUtCd() {
		return wgtMeasUtCd;
	}

	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}

	public String getCntrWgt() {
		return cntrWgt;
	}

	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

}