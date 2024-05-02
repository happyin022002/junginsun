/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0510Event.java
*@FileTitle : Hold Notice Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.31 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0510 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0510HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_0510HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0510Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";
	
	private String podCd = "";
	
	private String hldNtcTpCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private HldNtcSearchVO hldNtcSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreHldNtcSendListVO[] preHldNtcSendListVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ConfirmHldNtcSendListVO[] confirmHldNtcSendListVOs = null;
	
	// 테스트로 임시!!
	private CstmsHldVO cstmsHldVO = null;
	
	public EsmBkg0510Event(){}
	
	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}
	
	/**
	 * @param hldNtcTpCd the hldNtcTpCd to set
	 */
	public void setHldNtcTpCd(String hldNtcTpCd) {
		this.hldNtcTpCd = hldNtcTpCd;
	}

	/**
	 * @return the hldNtcTpCd
	 */
	public String getHldNtcTpCd() {
		return hldNtcTpCd;
	}
	
	/**
	 * @param hldNtcSearchVO the hldNtcSearchVO to set
	 */
	public void setHldNtcSearchVO(HldNtcSearchVO hldNtcSearchVO) {
		this.hldNtcSearchVO = hldNtcSearchVO;
	}

	/**
	 * @return the hldNtcSearchVO
	 */
	public HldNtcSearchVO getHldNtcSearchVO() {
		return hldNtcSearchVO;
	}

	/**
	 * @param preHldNtcSendListVOs the preHldNtcSendListVOs to set
	 */
	public void setPreHldNtcSendListVOs(PreHldNtcSendListVO[] preHldNtcSendListVOs) {
		this.preHldNtcSendListVOs = preHldNtcSendListVOs;
	}

	/**
	 * @return the preHldNtcSendListVOs
	 */
	public PreHldNtcSendListVO[] getPreHldNtcSendListVOs() {
		return preHldNtcSendListVOs;
	}

	/**
	 * @param confirmHldNtcSendListVOs the confirmHldNtcSendListVOs to set
	 */
	public void setConfirmHldNtcSendListVOs(ConfirmHldNtcSendListVO[] confirmHldNtcSendListVOs) {
		this.confirmHldNtcSendListVOs = confirmHldNtcSendListVOs;
	}

	/**
	 * @return the confirmHldNtcSendListVOs
	 */
	public ConfirmHldNtcSendListVO[] getConfirmHldNtcSendListVOs() {
		return confirmHldNtcSendListVOs;
	}

	/**
	 * @param cstmsHldVO the cstmsHldVO to set
	 */
	public void setCstmsHldVO(CstmsHldVO cstmsHldVO) {
		this.cstmsHldVO = cstmsHldVO;
	}

	/**
	 * @return the cstmsHldVO
	 */
	public CstmsHldVO getCstmsHldVO() {
		return cstmsHldVO;
	}

}