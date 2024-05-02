/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstBbVO.java
*@FileTitle : ExternalRqstBbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.22
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2013.05.22 경종윤
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

public class ExternalRqstBbVO {

	private List<BkgXterBbCgoVO> bkgXterBbCgoVO = null;
	private List<AlpsBbVO> alpsBbVO = null;
	private List<AlpsCntrTpszVO> alpsCntrTpszVO = null;
	/**
	 * @return the bkgXterBbCgoVO
	 */
	public List<BkgXterBbCgoVO> getBkgXterBbCgoVO() {
		return bkgXterBbCgoVO;
	}
	/**
	 * @param bkgXterBbCgoVO the bkgXterBbCgoVO to set
	 */
	public void setBkgXterBbCgoVO(List<BkgXterBbCgoVO> bkgXterBbCgoVO) {
		this.bkgXterBbCgoVO = bkgXterBbCgoVO;
	}
	/**
	 * @return the alpsBbVO
	 */
	public List<AlpsBbVO> getAlpsBbVO() {
		return alpsBbVO;
	}
	/**
	 * @param alpsBbVO the alpsBbVO to set
	 */
	public void setAlpsBbVO(List<AlpsBbVO> alpsBbVO) {
		this.alpsBbVO = alpsBbVO;
	}
	/**
	 * @return the alpsCntrTpszVO
	 */
	public List<AlpsCntrTpszVO> getAlpsCntrTpszVO() {
		return alpsCntrTpszVO;
	}
	/**
	 * @param alpsCntrTpszVO the alpsCntrTpszVO to set
	 */
	public void setAlpsCntrTpszVO(List<AlpsCntrTpszVO> alpsCntrTpszVO) {
		this.alpsCntrTpszVO = alpsCntrTpszVO;
	}
	
	

}