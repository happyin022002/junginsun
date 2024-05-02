/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstHbl1VO.java
*@FileTitle : ExternalRqstHbl1VO
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

public class ExternalRqstHbl1VO {

	private List<OpusHbl1VO> opusHbl1VO = null;
	private List<XterHbl1VO> xterHbl1VO = null;

	public List<OpusHbl1VO> getOpusHbl1VO() {
		return opusHbl1VO;
	}
	public void setOpusHbl1VO(List<OpusHbl1VO> opusHbl1VO) {
		this.opusHbl1VO = opusHbl1VO;
	}
	public List<XterHbl1VO> getXterHbl1VO() {
		return xterHbl1VO;
	}
	public void setXterHbl1VO(List<XterHbl1VO> xterHbl1VO) {
		this.xterHbl1VO = xterHbl1VO;
	}

}
