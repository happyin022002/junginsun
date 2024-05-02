/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0252Event.java
*@FileTitle : Empty Container Release Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.07 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0252 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0252HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see ESM_BKG_0252HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0252Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyRlseOrdSimpleOutVO mtyRlseOrdSimpleOutVO = null;
	private MtyRlseOrdDetailOutVO mtyRlseOrdDetailOutVO = null;
	private MtyRlseOrdUsaOutVO mtyRlseOrdUsaOutVO = null;
	private MtyRlseOrdInVO mtyRlseOrdInVO = null;
	private SendMtyRlseOrdVO sendMtyRlseOrdVO = null;

	/** Table Value Object Multi Data 처리 */
	private MtyRlseOrdSimpleOutVO[] mtyRlseOrdSimpleOutVOs = null;
	private MtyRlseOrdDetailOutVO[] mtyRlseOrdDetailOutVOs = null;
	private MtyRlseOrdUsaOutVO[] mtyRlseOrdUsaOutVOs = null;
	private SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;

	private BkgEmlEdtVO bkgEmlEdtVO = null;

	public EsmBkg0252Event(){}

	public SendMtyRlseOrdVO getSendMtyRlseOrdVO() {
		return sendMtyRlseOrdVO;
	}


	public void setSendMtyRlseOrdVO(SendMtyRlseOrdVO sendMtyRlseOrdVO) {
		this.sendMtyRlseOrdVO = sendMtyRlseOrdVO;
	}


	
	public SendMtyRlseOrdVO[] getSendMtyRlseOrdVOs() {
		SendMtyRlseOrdVO[] rtnVOs = null;
		if (this.sendMtyRlseOrdVOs != null) {
			rtnVOs = Arrays.copyOf(sendMtyRlseOrdVOs, sendMtyRlseOrdVOs.length);
		}
		return rtnVOs;
	}

	public void setSendMtyRlseOrdVOs(SendMtyRlseOrdVO[] sendMtyRlseOrdVOs) {
		if (sendMtyRlseOrdVOs != null) {
			SendMtyRlseOrdVO[] tmpVOs = Arrays.copyOf(sendMtyRlseOrdVOs, sendMtyRlseOrdVOs.length);
			this.sendMtyRlseOrdVOs = tmpVOs;
		}
	}

	public MtyRlseOrdSimpleOutVO getMtyRlseOrdSimpleOutVO() {
		return mtyRlseOrdSimpleOutVO;
	}


	public void setMtyRlseOrdSimpleOutVO(MtyRlseOrdSimpleOutVO mtyRlseOrdSimpleOutVO) {
		this.mtyRlseOrdSimpleOutVO = mtyRlseOrdSimpleOutVO;
	}


	public MtyRlseOrdDetailOutVO getMtyRlseOrdDetailOutVO() {
		return mtyRlseOrdDetailOutVO;
	}


	public void setMtyRlseOrdDetailOutVO(MtyRlseOrdDetailOutVO mtyRlseOrdDetailOutVO) {
		this.mtyRlseOrdDetailOutVO = mtyRlseOrdDetailOutVO;
	}


	public MtyRlseOrdUsaOutVO getMtyRlseOrdUsaOutVO() {
		return mtyRlseOrdUsaOutVO;
	}


	public void setMtyRlseOrdUsaOutVO(MtyRlseOrdUsaOutVO mtyRlseOrdUsaOutVO) {
		this.mtyRlseOrdUsaOutVO = mtyRlseOrdUsaOutVO;
	}


	public MtyRlseOrdSimpleOutVO[] getMtyRlseOrdSimpleOutVOs() {MtyRlseOrdSimpleOutVO[] rtnVOs = null;
		if (this.mtyRlseOrdSimpleOutVOs != null) {
			rtnVOs = Arrays.copyOf(mtyRlseOrdSimpleOutVOs,mtyRlseOrdSimpleOutVOs.length);
		}
		return rtnVOs;
	}

	public void setMtyRlseOrdSimpleOutVOs(MtyRlseOrdSimpleOutVO[] mtyRlseOrdSimpleOutVOs) {
		if (mtyRlseOrdSimpleOutVOs != null) {
			MtyRlseOrdSimpleOutVO[] tmpVOs = Arrays.copyOf(mtyRlseOrdSimpleOutVOs,mtyRlseOrdSimpleOutVOs.length);
			this.mtyRlseOrdSimpleOutVOs = tmpVOs;
		}
	}

	public MtyRlseOrdDetailOutVO[] getMtyRlseOrdDetailOutVOs() {
		MtyRlseOrdDetailOutVO[] rtnVOs = null;
		if (this.mtyRlseOrdDetailOutVOs != null) {
			rtnVOs = Arrays.copyOf(mtyRlseOrdDetailOutVOs,mtyRlseOrdDetailOutVOs.length);
		}
		return rtnVOs;
	}

	public void setMtyRlseOrdDetailOutVOs(MtyRlseOrdDetailOutVO[] mtyRlseOrdDetailOutVOs) {
		if (mtyRlseOrdDetailOutVOs != null) {
			MtyRlseOrdDetailOutVO[] tmpVOs = Arrays.copyOf(mtyRlseOrdDetailOutVOs,mtyRlseOrdDetailOutVOs.length);
			this.mtyRlseOrdDetailOutVOs = tmpVOs;
		}
	}

	public MtyRlseOrdUsaOutVO[] getMtyRlseOrdUsaOutVOs() {
		MtyRlseOrdUsaOutVO[] rtnVOs = null;
		if (this.mtyRlseOrdUsaOutVOs != null) {
			rtnVOs = Arrays.copyOf(mtyRlseOrdUsaOutVOs, mtyRlseOrdUsaOutVOs.length);
		}
		return rtnVOs;
	}

	public void setMtyRlseOrdUsaOutVOs(MtyRlseOrdUsaOutVO[] mtyRlseOrdUsaOutVOs) {
		if (mtyRlseOrdUsaOutVOs != null) {
			MtyRlseOrdUsaOutVO[] tmpVOs = Arrays.copyOf(mtyRlseOrdUsaOutVOs,mtyRlseOrdUsaOutVOs.length);
			this.mtyRlseOrdUsaOutVOs = tmpVOs;
		}
	}

	public MtyRlseOrdInVO getMtyRlseOrdInVO() {
		return mtyRlseOrdInVO;
	}


	public void setMtyRlseOrdInVO(MtyRlseOrdInVO mtyRlseOrdInVO) {
		this.mtyRlseOrdInVO = mtyRlseOrdInVO;
	}

	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}

	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}

}