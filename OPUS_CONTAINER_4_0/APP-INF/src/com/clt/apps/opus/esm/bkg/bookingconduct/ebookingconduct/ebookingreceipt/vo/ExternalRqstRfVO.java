/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstRfVO.java
*@FileTitle : ExternalRqstRfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstRfVO {

	private List<OpusRfVO> opusRfVO = null;
	private List<BkgXterRfCgoVO> bkgXterRfCgoVO = null;
	private List<OpusCntrTpszVO> opusCntrTpszVO = null;

	public List<OpusRfVO> getOpusRfVO() {
		return opusRfVO;
	}
	public void setOpusRfVO(List<OpusRfVO> opusRfVO) {
		this.opusRfVO = opusRfVO;
	}
	public List<BkgXterRfCgoVO> getBkgXterRfCgoVO() {
		return bkgXterRfCgoVO;
	}
	public void setBkgXterRfCgoVO(List<BkgXterRfCgoVO> bkgXterRfCgoVO) {
		this.bkgXterRfCgoVO = bkgXterRfCgoVO;
	}
	public List<OpusCntrTpszVO> getOpusCntrTpszVO() {
		return opusCntrTpszVO;
	}
	public void setOpusCntrTpszVO(List<OpusCntrTpszVO> opusCntrTpszVO) {
		this.opusCntrTpszVO = opusCntrTpszVO;
	}

}
