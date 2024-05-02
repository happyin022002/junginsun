/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstCmVO.java
*@FileTitle : ExternalRqstCmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.List;

import com.clt.syscommon.common.table.BkgDgCgoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstCmVO {

	private List<OpusCmVO> opusCmVO = null;
	private List<BkgXterCntrMkDescVO> bkgXterCntrMkDescVO = null;
	private List<BkgDgCgoVO> bkgDgCgoVOs = null;

	public List<OpusCmVO> getOpusCmVO() {
		return opusCmVO;
	}
	public void setOpusCmVO(List<OpusCmVO> opusCmVO) {
		this.opusCmVO = opusCmVO;
	}
	public List<BkgXterCntrMkDescVO> getBkgXterCntrMkDescVO() {
		return bkgXterCntrMkDescVO;
	}
	public void setBkgXterCntrMkDescVO(List<BkgXterCntrMkDescVO> bkgXterCntrMkDescVO) {
		this.bkgXterCntrMkDescVO = bkgXterCntrMkDescVO;
	}
	public List<BkgDgCgoVO> getBkgDgCgoVOs() {
		return bkgDgCgoVOs;
	}
	public void setBkgDgCgoVOs(List<BkgDgCgoVO> bkgDgCgoVOs) {
		this.bkgDgCgoVOs = bkgDgCgoVOs;
	}

}
