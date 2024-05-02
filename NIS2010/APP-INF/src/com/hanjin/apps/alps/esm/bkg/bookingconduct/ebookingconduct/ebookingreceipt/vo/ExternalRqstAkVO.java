/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstAkVO.java
*@FileTitle : ExternalRqstAkVO
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

public class ExternalRqstAkVO {

	private List<BkgXterAwkCgoVO> bkgXterAwkCgoVO = null;
	private List<AlpsAkVO> nisAkVO = null;
	private List<AlpsCntrTpszVO> alpsCntrTpszVO = null;

	public List<BkgXterAwkCgoVO> getBkgXterAwkCgoVO() {
		return bkgXterAwkCgoVO;
	}
	public void setBkgXterAwkCgoVO(List<BkgXterAwkCgoVO> bkgXterAwkCgoVO) {
		this.bkgXterAwkCgoVO = bkgXterAwkCgoVO;
	}
	public List<AlpsAkVO> getNisAkVO() {
		return nisAkVO;
	}
	public void setNisAkVO(List<AlpsAkVO> nisAkVO) {
		this.nisAkVO = nisAkVO;
	}
	public List<AlpsCntrTpszVO> getAlpsCntrTpszVO() {
		return alpsCntrTpszVO;
	}
	public void setAlpsCntrTpszVO(List<AlpsCntrTpszVO> alpsCntrTpszVO) {
		this.alpsCntrTpszVO = alpsCntrTpszVO;
	}

}