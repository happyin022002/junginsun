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
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		return sendMtyRlseOrdVOs;
	}


	public void setSendMtyRlseOrdVOs(SendMtyRlseOrdVO[] sendMtyRlseOrdVOs) {
		this.sendMtyRlseOrdVOs = sendMtyRlseOrdVOs;
	}
	
	
	public MtyRlseOrdSimpleOutVO getMtyRlseOrdSimpleOutVO() {
		return mtyRlseOrdSimpleOutVO;
	}


	public void setMtyRlseOrdSimpleOutVO(MtyRlseOrdSimpleOutVO mtyRlseOrdSimpleOutVO) {
		this.mtyRlseOrdSimpleOutVO = mtyRlseOrdSimpleOutVO;
	}


	public MtyRlseOrdSimpleOutVO[] getMtyRlseOrdSimpleOutVOs() {
		return mtyRlseOrdSimpleOutVOs;
	}


	public void setMtyRlseOrdSimpleOutVOs(MtyRlseOrdSimpleOutVO[] mtyRlseOrdSimpleOutVOs) {
		this.mtyRlseOrdSimpleOutVOs = mtyRlseOrdSimpleOutVOs;
	}
	
	public MtyRlseOrdDetailOutVO getMtyRlseOrdDetailOutVO() {
		return mtyRlseOrdDetailOutVO;
	}


	public void setMtyRlseOrdDetailOutVO(MtyRlseOrdDetailOutVO mtyRlseOrdDetailOutVO) {
		this.mtyRlseOrdDetailOutVO = mtyRlseOrdDetailOutVO;
	}


	public MtyRlseOrdDetailOutVO[] getMtyRlseOrdDetailOutVOs() {
		return mtyRlseOrdDetailOutVOs;
	}


	public void setMtyRlseOrdVOs(MtyRlseOrdDetailOutVO[] mtyRlseOrdDetailOutVOs) {
		this.mtyRlseOrdDetailOutVOs = mtyRlseOrdDetailOutVOs;
	}
	
	public MtyRlseOrdUsaOutVO getMtyRlseOrdUsaOutVO() {
		return mtyRlseOrdUsaOutVO;
	}


	public void setMtyRlseOrdUsaOutVO(MtyRlseOrdUsaOutVO mtyRlseOrdUsaOutVO) {
		this.mtyRlseOrdUsaOutVO = mtyRlseOrdUsaOutVO;
	}


	public MtyRlseOrdUsaOutVO[] getMtyRlseOrdUsaOutVOs() {
		return mtyRlseOrdUsaOutVOs;
	}


	public void setMtyRlseOrdUsaOutVOs(MtyRlseOrdUsaOutVO[] mtyRlseOrdUsaOutVOs) {
		this.mtyRlseOrdUsaOutVOs = mtyRlseOrdUsaOutVOs;
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