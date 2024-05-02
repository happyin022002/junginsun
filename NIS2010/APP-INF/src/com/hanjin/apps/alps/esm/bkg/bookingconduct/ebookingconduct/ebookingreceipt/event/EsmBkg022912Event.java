/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022912Event.java
*@FileTitle : e-Booking & SI Process Detail(Break Bulk)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.22
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2013.05.22 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_12 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_12HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_12HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022912Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private XterRqstNoVO xterRqstNoVO= null;
	private BkgBbCgoVO[] bkgBbCgoVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;
	/**
	 * @return the xterRqstNoVO
	 */
	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}
	/**
	 * @param xterRqstNoVO the xterRqstNoVO to set
	 */
	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}
	/**
	 * @return the bkgBbCgoVOs
	 */
	public BkgBbCgoVO[] getBkgBbCgoVOs() {
		BkgBbCgoVO[] rtnVOs = null;
		if (this.bkgBbCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBbCgoVOs, bkgBbCgoVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param bkgBbCgoVOs the bkgBbCgoVOs to set
	 */
	public void setBkgBbCgoVOs(BkgBbCgoVO[] bkgBbCgoVOs){
		if(bkgBbCgoVOs != null){
			BkgBbCgoVO[] tmpVOs = Arrays.copyOf(bkgBbCgoVOs, bkgBbCgoVOs.length);
			this.bkgBbCgoVOs = tmpVOs;
		}
	}
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
}