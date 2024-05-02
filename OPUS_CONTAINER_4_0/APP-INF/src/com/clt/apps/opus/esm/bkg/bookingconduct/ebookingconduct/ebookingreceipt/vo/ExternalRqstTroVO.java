/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstTroVO.java
*@FileTitle : ExternalRqstTroVO
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

public class ExternalRqstTroVO {

	private List<BkgXterTroVO> bkgXterTroVO = null;
	private List<BkgXterTroDtlVO> bkgXterTroDtlVO = null;
	private List<OpusTroMstVO> opusTroMstVO = null;
	private List<OpusTroDtlVO> opusTroDtlVO = null;

	public List<BkgXterTroVO> getBkgXterTroVO() {
		return bkgXterTroVO;
	}
	public void setBkgXterTroVO(List<BkgXterTroVO> bkgXterTroVO) {
		this.bkgXterTroVO = bkgXterTroVO;
	}
	public List<BkgXterTroDtlVO> getBkgXterTroDtlVO() {
		return bkgXterTroDtlVO;
	}
	public void setBkgXterTroDtlVO(List<BkgXterTroDtlVO> bkgXterTroDtlVO) {
		this.bkgXterTroDtlVO = bkgXterTroDtlVO;
	}
	public List<OpusTroMstVO> getOpusTroMstVO() {
		return opusTroMstVO;
	}
	public void setOpusTroMstVO(List<OpusTroMstVO> opusTroMstVO) {
		this.opusTroMstVO = opusTroMstVO;
	}
	public List<OpusTroDtlVO> getOpusTroDtlVO() {
		return opusTroDtlVO;
	}
	public void setOpusTroDtlVO(List<OpusTroDtlVO> opusTroDtlVO) {
		this.opusTroDtlVO = opusTroDtlVO;
	}

}
