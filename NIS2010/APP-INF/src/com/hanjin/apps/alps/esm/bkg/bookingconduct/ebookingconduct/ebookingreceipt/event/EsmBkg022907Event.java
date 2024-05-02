/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022907Event.java
*@FileTitle : e-Booking & SI Process Detail(REEFER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.24 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_07HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022907Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public String cmdtCd = null;
	private XterRqstNoVO xterRqstNoVO = null;
	private BkgRfCgoVO[] bkgRfCgoVOs = null;
	private BkgBlNoVO bkgBlNoVO     = null;
	
	public String cntrTpSzChk = null;

	public EsmBkg022907Event() {
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
	
	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public BkgRfCgoVO[] getBkgRfCgoVOs() {
		BkgRfCgoVO[] rtnVOs = null;
		if (this.bkgRfCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgRfCgoVOs, bkgRfCgoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgRfCgoVOs(BkgRfCgoVO[] bkgRfCgoVOs){
		if(bkgRfCgoVOs != null){
			BkgRfCgoVO[] tmpVOs = Arrays.copyOf(bkgRfCgoVOs, bkgRfCgoVOs.length);
			this.bkgRfCgoVOs = tmpVOs;
		}
	}
	
	public String getCntrTpSz() {
		return cntrTpSzChk;
	}

	public void setCntrTpSz(String cntrTpSzChk) {
		this.cntrTpSzChk = cntrTpSzChk;
	}
}