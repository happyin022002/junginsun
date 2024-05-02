/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmPri0040Event.java
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.RsltRealCustInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpRealCustVO priSpRealCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpRealCustVO[] priSpRealCustVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRealCustInquiryVO rsltRealCustInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltRealCustInquiryVO[] rsltRealCustInquiryVOs = null;

	private SchCustVO schCustVO = null;

	public EsmPri0040Event(){}
	
	public PriSpRealCustVO getPriSpRealCustVO() {
		return priSpRealCustVO;
	}

	public void setPriSpRealCustVO(PriSpRealCustVO priSpRealCustVO) {
		this.priSpRealCustVO = priSpRealCustVO;
	}

	public PriSpRealCustVO[] getPriSpRealCustVOs() {
		return priSpRealCustVOs;
	}

	public void setPriSpRealCustVOs(PriSpRealCustVO[] priSpRealCustVOs) {
		this.priSpRealCustVOs = priSpRealCustVOs;
	}

	public RsltRealCustInquiryVO getRsltRealCustInquiryVO() {
		return rsltRealCustInquiryVO;
	}

	public void setRsltRealCustInquiryVO(RsltRealCustInquiryVO rsltRealCustInquiryVO) {
		this.rsltRealCustInquiryVO = rsltRealCustInquiryVO;
	}

	public RsltRealCustInquiryVO[] getRsltRealCustInquiryVOs() {
		return rsltRealCustInquiryVOs;
	}

	public void setRsltRealCustInquiryVOs(
			RsltRealCustInquiryVO[] rsltRealCustInquiryVOs) {
		this.rsltRealCustInquiryVOs = rsltRealCustInquiryVOs;
	}
	
    public SchCustVO getSchCustVO() {
		return schCustVO;
	}

	public void setSchCustVO(SchCustVO schCustVO) {
		this.schCustVO = schCustVO;
	}

}