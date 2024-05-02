/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0256Event.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgRevUmchBkgVO;
import com.clt.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_BKG_0701 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0701HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0701HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0701Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRevUmchBkgVO bkgRevUmchBkgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgRevUmchBkgVO[] bkgRevUmchBkgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;

	public EsmBkg0701Event(){}
	
	public void setBkgRevUmchBkgVO(BkgRevUmchBkgVO bkgRevUmchBkgVO){
		this. bkgRevUmchBkgVO = bkgRevUmchBkgVO;
	}

	public void setRsltUnmatchBLListbyAuditorVO(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO){
		this. rsltUnmatchBLListbyAuditorVO = rsltUnmatchBLListbyAuditorVO;
	}

	public BkgRevUmchBkgVO getBkgRevUmchBkgVO(){
		return bkgRevUmchBkgVO;
	}

	public RsltUnmatchBLListbyAuditorVO getRsltUnmatchBLListbyAuditorVO(){
		return rsltUnmatchBLListbyAuditorVO;
	}

	/**
	 * @return the comBakEndJbVO
	 */
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	/**
	 * @param comBakEndJbVO the comBakEndJbVO to set
	 */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}

	public BkgRevUmchBkgVO[] getBkgRevUmchBkgVOs() {
		BkgRevUmchBkgVO[] rtnVOs = null;
		if (this.bkgRevUmchBkgVOs != null) {
			rtnVOs = Arrays.copyOf(bkgRevUmchBkgVOs, bkgRevUmchBkgVOs.length);
		}
		return rtnVOs;
	}
	public BkgRevUmchBkgVO[] getBkgRevUmchBkgVOS() {
		BkgRevUmchBkgVO[] rtnVOs = null;
		if (this.bkgRevUmchBkgVOs != null) {
			rtnVOs = Arrays.copyOf(bkgRevUmchBkgVOs, bkgRevUmchBkgVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgRevUmchBkgVOs(BkgRevUmchBkgVO[] bkgRevUmchBkgVOs) {
		if (bkgRevUmchBkgVOs != null) {
			BkgRevUmchBkgVO[] tmpVOs = Arrays.copyOf(bkgRevUmchBkgVOs, bkgRevUmchBkgVOs.length);
			this.bkgRevUmchBkgVOs = tmpVOs;
		}
	}
	public void setBkgRevUmchBkgVOS(BkgRevUmchBkgVO[] bkgRevUmchBkgVOs){
		if (bkgRevUmchBkgVOs != null) {
			BkgRevUmchBkgVO[] tmpVOs = Arrays.copyOf(bkgRevUmchBkgVOs, bkgRevUmchBkgVOs.length);
			this.bkgRevUmchBkgVOs = tmpVOs;
		}
	}

	public RsltUnmatchBLListbyAuditorVO[] getRsltUnmatchBLListbyAuditorVOs() {
		RsltUnmatchBLListbyAuditorVO[] rtnVOs = null;
		if (this.rsltUnmatchBLListbyAuditorVOs != null) {
			rtnVOs = Arrays.copyOf(rsltUnmatchBLListbyAuditorVOs,rsltUnmatchBLListbyAuditorVOs.length);
		}
		return rtnVOs;
	}
	public RsltUnmatchBLListbyAuditorVO[] getRsltUnmatchBLListbyAuditorVOS() {
		RsltUnmatchBLListbyAuditorVO[] rtnVOs = null;
		if (this.rsltUnmatchBLListbyAuditorVOs != null) {
			rtnVOs = Arrays.copyOf(rsltUnmatchBLListbyAuditorVOs,rsltUnmatchBLListbyAuditorVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltUnmatchBLListbyAuditorVOs(RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs) {
		if (rsltUnmatchBLListbyAuditorVOs != null) {
			RsltUnmatchBLListbyAuditorVO[] tmpVOs = Arrays.copyOf(rsltUnmatchBLListbyAuditorVOs,rsltUnmatchBLListbyAuditorVOs.length);
			this.rsltUnmatchBLListbyAuditorVOs = tmpVOs;
		}
	}
	public void setRsltUnmatchBLListbyAuditorVOS(RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs) {
		if (rsltUnmatchBLListbyAuditorVOs != null) {
			RsltUnmatchBLListbyAuditorVO[] tmpVOs = Arrays.copyOf(rsltUnmatchBLListbyAuditorVOs,rsltUnmatchBLListbyAuditorVOs.length);
			this.rsltUnmatchBLListbyAuditorVOs = tmpVOs;
		}
	}
	public ComBakEndJbVO[] getComBakEndJbVOs() {
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
		}
		return rtnVOs;
	}

	public void setComBakEndJbVOs(ComBakEndJbVO[] comBakEndJbVOs) {
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
}