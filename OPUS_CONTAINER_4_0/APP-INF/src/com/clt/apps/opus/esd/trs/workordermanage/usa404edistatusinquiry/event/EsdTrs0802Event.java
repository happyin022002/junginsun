 /*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTrs0802Event.java
*@FileTitle : TRS STCC Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0802 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0802HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0802Event  extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String frmStccCd	= null;
	private String frmStccSeq	= null;
	private String frmUnCmdtCd	= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrsStccVO trsStccVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrsStccVO[] trsStccVOs = null;
	
	public TrsStccVO getTrsStccVO() {
		return trsStccVO;
	}

	public void setTrsStccVO(TrsStccVO trsStccVO) {
		this.trsStccVO = trsStccVO;
	}

	public TrsStccVO[] getTrsStccVOs() {
		TrsStccVO[] rtnVOs = null;
		if (this.trsStccVOs != null) {
			rtnVOs = Arrays.copyOf(this.trsStccVOs, this.trsStccVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsStccVOs(TrsStccVO[] trsStccVOs) {
		if (trsStccVOs != null) {
			TrsStccVO[] tmpVOs = Arrays.copyOf(trsStccVOs, trsStccVOs.length);
			this.trsStccVOs = tmpVOs;
		} // end if
	}

	public String getFrmStccCd() {
		return frmStccCd;
	}

	public void setFrmStccCd(String frmStccCd) {
		this.frmStccCd = frmStccCd;
	}

	public String getFrmStccSeq() {
		return frmStccSeq;
	}

	public void setFrmStccSeq(String frmStccSeq) {
		this.frmStccSeq = frmStccSeq;
	}

	public String getFrmUnCmdtCd() {
		return frmUnCmdtCd;
	}

	public void setFrmUnCmdtCd(String frmUnCmdtCd) {
		this.frmUnCmdtCd = frmUnCmdtCd;
	}
}