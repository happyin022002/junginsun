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

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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

	private List<AlpsRfVO> nisRfVO = null;
	private List<BkgXterRfCgoVO> bkgXterRfCgoVO = null;
	private List<AlpsCntrTpszVO> alpsCntrTpszVO = null;

	public List<AlpsRfVO> getNisRfVO() {
		return nisRfVO;
	}
	public void setNisRfVO(List<AlpsRfVO> nisRfVO) {
		this.nisRfVO = nisRfVO;
	}
	public List<BkgXterRfCgoVO> getBkgXterRfCgoVO() {
		return bkgXterRfCgoVO;
	}
	public void setBkgXterRfCgoVO(List<BkgXterRfCgoVO> bkgXterRfCgoVO) {
		this.bkgXterRfCgoVO = bkgXterRfCgoVO;
	}
	public List<AlpsCntrTpszVO> getAlpsCntrTpszVO() {
		return alpsCntrTpszVO;
	}
	public void setAlpsCntrTpszVO(List<AlpsCntrTpszVO> alpsCntrTpszVO) {
		this.alpsCntrTpszVO = alpsCntrTpszVO;
	}

}
