/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022909Event.java
*@FileTitle : e-Booking & SI Process Detail(AWKWARD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.29 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_09 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_09HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_09HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022909Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private XterRqstNoVO xterRqstNoVO= null;
	private BkgAwkCgoVO[] bkgAwkCgoVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;

	public EsmBkg022909Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgAwkCgoVO[] getBkgAwkCgoVOs() {
		BkgAwkCgoVO[] rtnVOs = null;
		if (this.bkgAwkCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgAwkCgoVOs, bkgAwkCgoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgAwkCgoVOs(BkgAwkCgoVO[] bkgAwkCgoVOs) {
		if(bkgAwkCgoVOs != null){
			BkgAwkCgoVO[] tmpVOs = Arrays.copyOf(bkgAwkCgoVOs, bkgAwkCgoVOs.length);
			this.bkgAwkCgoVOs  = tmpVOs;
		}
	}
}