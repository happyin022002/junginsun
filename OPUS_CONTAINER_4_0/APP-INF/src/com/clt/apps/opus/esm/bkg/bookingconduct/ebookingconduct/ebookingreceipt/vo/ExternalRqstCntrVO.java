/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstCntrVO.java
*@FileTitle : ExternalRqstCntrVO
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

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgXterCntrSealNoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstCntrVO {

	private List<OpusCntrVO> opusCntrVO = null;
	private List<BkgCntrSealNoVO> bkgCntrSealNoVO = null;
	private List<XterCntrVO> xterCntrVO = null;
	private List<BkgXterCntrSealNoVO> bkgXterCntrSealNoVO = null;

	public List<OpusCntrVO> getopusCntrVO() {
		return opusCntrVO;
	}
	public void setOpusCntrVO(List<OpusCntrVO> opusCntrVO) {
		this.opusCntrVO = opusCntrVO;
	}
	public List<BkgCntrSealNoVO> getBkgCntrSealNoVO() {
		return bkgCntrSealNoVO;
	}
	public void setBkgCntrSealNoVO(List<BkgCntrSealNoVO> bkgCntrSealNoVO) {
		this.bkgCntrSealNoVO = bkgCntrSealNoVO;
	}
	public List<XterCntrVO> getXterCntrVO() {
		return xterCntrVO;
	}
	public void setXterCntrVO(List<XterCntrVO> xterCntrVO) {
		this.xterCntrVO = xterCntrVO;
	}
	public List<BkgXterCntrSealNoVO> getBkgXterCntrSealNoVO() {
		return bkgXterCntrSealNoVO;
	}
	public void setBkgXterCntrSealNoVO(List<BkgXterCntrSealNoVO> bkgXterCntrSealNoVO) {
		this.bkgXterCntrSealNoVO = bkgXterCntrSealNoVO;
	}

}
