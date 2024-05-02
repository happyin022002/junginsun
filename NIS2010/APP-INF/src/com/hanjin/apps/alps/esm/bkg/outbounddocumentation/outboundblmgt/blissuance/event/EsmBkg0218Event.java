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
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgSrEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;


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
	private BkgSrEmlEdtVO bkgSrEmlEdtVO;
	private InDblWblInVO[] inDblWblInVOs;
	private ObDblWblInVO[] obDblWblInVOs;
	private DblWblOutVO[] dblWblOutVOs;
	private DblWblVO[] dblWblVOs;
	private BkgSrEmlEdtVO[] bkgSrEmlEdtVOs;
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

	public BkgSrEmlEdtVO getBkgSrEmlEdtVO() {
		return bkgSrEmlEdtVO;
	}

	public void setBkgSrEmlEdtVO(BkgSrEmlEdtVO bkgSrEmlEdtVO) {
		this.bkgSrEmlEdtVO = bkgSrEmlEdtVO;
	}
	
	public InDblWblInVO[] getInDblWblInVOs() {
		return inDblWblInVOs;
	}

	public void setInDblWblInVOs(InDblWblInVO[] inDblWblInVOs) {
		this.inDblWblInVOs = inDblWblInVOs;
	}

	public ObDblWblInVO[] getObDblWblInVOs() {
		return obDblWblInVOs;
	}

	public void setObDblWblInVOs(ObDblWblInVO[] obDblWblInVOs) {
		this.obDblWblInVOs = obDblWblInVOs;
	}

	public DblWblOutVO[] getDblWblOutVOs() {
		return dblWblOutVOs;
	}

	public void setDblWblOutVOs(DblWblOutVO[] dblWblOutVOs) {
		this.dblWblOutVOs = dblWblOutVOs;
	}

	public DblWblVO[] getDblWblVOs() {
		return dblWblVOs;
	}

	public void setDblWblVOs(DblWblVO[] dblWblVOs) {
		this.dblWblVOs = dblWblVOs;
	}

	public BkgSrEmlEdtVO[] getBkgSrEmlEdtVOs() {
		return bkgSrEmlEdtVOs;
	}

	public void setBkgSrEmlEdtVOs(BkgSrEmlEdtVO[] bkgSrEmlEdtVOs) {
		this.bkgSrEmlEdtVOs = bkgSrEmlEdtVOs;
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
