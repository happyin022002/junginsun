/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0218Event.java
*@FileTitle : Draft B/L & Waybill (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2009.09.07 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0218 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0218HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ilmin Lee
 * @see ESM_BKG_0218HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0218Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private InDblWblInVO inDblWblInVO;
	private ObDblWblInVO obDblWblInVO;
	private DblWblOutVO dblWblOutVO;
	private DblWblVO dblWblVO;
	private InDblWblInVO[] inDblWblInVOs;
	private ObDblWblInVO[] obDblWblInVOs;
	private DblWblOutVO[] dblWblOutVOs;
	private DblWblVO[] dblWblVOs;
	String grpFlag;
	String mfFlag;
	String rdFormId;
	String sendId;
	private BkgEmlEdtVO bkgEmlEdtVO = null;

	public InDblWblInVO getInDblWblInVO() {
		return inDblWblInVO;
	}

	public void setInDblWblInVO(InDblWblInVO inDblWblInVO) {
		this.inDblWblInVO = inDblWblInVO;
	}

	public ObDblWblInVO getObDblWblInVO() {
		return obDblWblInVO;
	}

	public void setObDblWblInVO(ObDblWblInVO obDblWblInVO) {
		this.obDblWblInVO = obDblWblInVO;
	}

	public DblWblOutVO getDblWblOutVO() {
		return dblWblOutVO;
	}

	public void setDblWblOutVO(DblWblOutVO dblWblOutVO) {
		this.dblWblOutVO = dblWblOutVO;
	}

	public DblWblVO getDblWblVO() {
		return dblWblVO;
	}

	public void setDblWblVO(DblWblVO dblWblVO) {
		this.dblWblVO = dblWblVO;
	}

	public InDblWblInVO[] getInDblWblInVOs() {
		InDblWblInVO[] rtnVOs = null;
		if (this.inDblWblInVOs != null) {
			rtnVOs = Arrays.copyOf(inDblWblInVOs, inDblWblInVOs.length);
		}
		return rtnVOs;
	}

	public void setInDblWblInVOs(InDblWblInVO[] inDblWblInVOs) {
		if (inDblWblInVOs != null) {
			InDblWblInVO[] tmpVOs = Arrays.copyOf(inDblWblInVOs, inDblWblInVOs.length);
			this.inDblWblInVOs = tmpVOs;
		}
	}

	public ObDblWblInVO[] getObDblWblInVOs() {
		ObDblWblInVO[] rtnVOs = null;
		if (this.obDblWblInVOs != null) {
			rtnVOs = Arrays.copyOf(obDblWblInVOs, obDblWblInVOs.length);
		}
		return rtnVOs;
	}

	public void setObDblWblInVOs(ObDblWblInVO[] obDblWblInVOs) {
		if (obDblWblInVOs != null) {
			ObDblWblInVO[] tmpVOs = Arrays.copyOf(obDblWblInVOs, obDblWblInVOs.length);
			this.obDblWblInVOs = tmpVOs;
		}
	}

	public DblWblOutVO[] getDblWblOutVOs() {
		DblWblOutVO[] rtnVOs = null;
		if (this.dblWblOutVOs != null) {
			rtnVOs = Arrays.copyOf(dblWblOutVOs, dblWblOutVOs.length);
		}
		return rtnVOs;
	}

	public void setDblWblOutVOs(DblWblOutVO[] dblWblOutVOs) {
		if (dblWblOutVOs != null) {
			DblWblOutVO[] tmpVOs = Arrays.copyOf(dblWblOutVOs, dblWblOutVOs.length);
			this.dblWblOutVOs = tmpVOs;
		}
	}

	public DblWblVO[] getDblWblVOs() {
		DblWblVO[] rtnVOs = null;
		if (this.dblWblVOs != null) {
			rtnVOs = Arrays.copyOf(dblWblVOs, dblWblVOs.length);
		}
		return rtnVOs;
	}

	public void setDblWblVOs(DblWblVO[] dblWblVOs) {
		if (dblWblVOs != null) {
			DblWblVO[] tmpVOs = Arrays.copyOf(dblWblVOs, dblWblVOs.length);
			this.dblWblVOs = tmpVOs;
		}
	}

	public String getGrpFlag() {
		return grpFlag;
	}

	public void setGrpFlag(String grpFlag) {
		this.grpFlag = grpFlag;
	}

	public String getMfFlag() {
		return mfFlag;
	}

	public void setMfFlag(String mfFlag) {
		this.mfFlag = mfFlag;
	}

	public String getRdFormId() {
		return rdFormId;
	}

	public void setRdFormId(String rdFormId) {
		this.rdFormId = rdFormId;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}

}
