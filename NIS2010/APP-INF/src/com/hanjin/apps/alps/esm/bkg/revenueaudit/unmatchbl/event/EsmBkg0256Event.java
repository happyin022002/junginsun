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
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;


/**
 * ESM_BKG_0256 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0256HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0256HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0256Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRevUmchBkgVO bkgRevUmchBkgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public BkgRevUmchBkgVO[] bkgRevUmchBkgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	public ComBakEndJbVO[] comBakEndJbVOs = null;

	public EsmBkg0256Event(){}
	
	public void setBkgRevUmchBkgVO(BkgRevUmchBkgVO bkgRevUmchBkgVO){
		this. bkgRevUmchBkgVO = bkgRevUmchBkgVO;
	}

	public void setBkgRevUmchBkgVOS(BkgRevUmchBkgVO[] bkgRevUmchBkgVOs){
		this. bkgRevUmchBkgVOs = bkgRevUmchBkgVOs;
	}

	public void setRsltUnmatchBLListbyAuditorVO(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO){
		this. rsltUnmatchBLListbyAuditorVO = rsltUnmatchBLListbyAuditorVO;
	}

	public void setRsltUnmatchBLListbyAuditorVOS(RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs){
		this. rsltUnmatchBLListbyAuditorVOs = rsltUnmatchBLListbyAuditorVOs;
	}

	public BkgRevUmchBkgVO getBkgRevUmchBkgVO(){
		return bkgRevUmchBkgVO;
	}

	public BkgRevUmchBkgVO[] getBkgRevUmchBkgVOS(){
		return bkgRevUmchBkgVOs;
	}

	public RsltUnmatchBLListbyAuditorVO getRsltUnmatchBLListbyAuditorVO(){
		return rsltUnmatchBLListbyAuditorVO;
	}

	public RsltUnmatchBLListbyAuditorVO[] getRsltUnmatchBLListbyAuditorVOS(){
		return rsltUnmatchBLListbyAuditorVOs;
	}

	/**
	 * @return the bkgRevUmchBkgVOs
	 */
	public BkgRevUmchBkgVO[] getBkgRevUmchBkgVOs() {
		return bkgRevUmchBkgVOs;
	}

	/**
	 * @param bkgRevUmchBkgVOs the bkgRevUmchBkgVOs to set
	 */
	public void setBkgRevUmchBkgVOs(BkgRevUmchBkgVO[] bkgRevUmchBkgVOs) {
		this.bkgRevUmchBkgVOs = bkgRevUmchBkgVOs;
	}

	/**
	 * @return the rsltUnmatchBLListbyAuditorVOs
	 */
	public RsltUnmatchBLListbyAuditorVO[] getRsltUnmatchBLListbyAuditorVOs() {
		return rsltUnmatchBLListbyAuditorVOs;
	}

	/**
	 * @param rsltUnmatchBLListbyAuditorVOs the rsltUnmatchBLListbyAuditorVOs to set
	 */
	public void setRsltUnmatchBLListbyAuditorVOs(
			RsltUnmatchBLListbyAuditorVO[] rsltUnmatchBLListbyAuditorVOs) {
		this.rsltUnmatchBLListbyAuditorVOs = rsltUnmatchBLListbyAuditorVOs;
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

	/**
	 * @return the comBakEndJbVOs
	 */
	public ComBakEndJbVO[] getComBakEndJbVOs() {
		return comBakEndJbVOs;
	}

	/**
	 * @param comBakEndJbVOs the comBakEndJbVOs to set
	 */
	public void setComBakEndJbVOs(ComBakEndJbVO[] comBakEndJbVOs) {
		this.comBakEndJbVOs = comBakEndJbVOs;
	}

}