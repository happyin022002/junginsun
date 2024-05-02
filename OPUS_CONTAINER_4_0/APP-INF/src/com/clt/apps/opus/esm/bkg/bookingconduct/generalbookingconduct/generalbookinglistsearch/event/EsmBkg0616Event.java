/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0616Event.java
*@FileTitle : Booking EDI Transmit to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0616 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0616HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0616HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0616Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO = null;
	private String typeGbn = null;
	private String bracCd = null;

	/** Table Value Object Multi Data 처리 */
	private FwrdRefVvdVO[] fwrdRefVvdVOs = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private CustTpIdVO[] custTpIdVOs = null;

	public EsmBkg0616Event(){}

	public BkgListForTmlEdiInputVO getBkgListForTmlEdiInputVO() {
		return bkgListForTmlEdiInputVO;
	}

	public void setBkgListForTmlEdiInputVO(
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) {
		this.bkgListForTmlEdiInputVO = bkgListForTmlEdiInputVO;
	}

	public FwrdRefVvdVO[] getFwrdRefVvdVOs() {
		FwrdRefVvdVO[] tmpVOs = null;
		if (this. fwrdRefVvdVOs != null) {
			tmpVOs = Arrays.copyOf(fwrdRefVvdVOs, fwrdRefVvdVOs .length);
		}
		return tmpVOs;
	}

	public void setFwrdRefVvdVOs(FwrdRefVvdVO[] fwrdRefVvdVOs) {
		if (fwrdRefVvdVOs != null) {
			FwrdRefVvdVO[] tmpVOs = Arrays.copyOf(fwrdRefVvdVOs, fwrdRefVvdVOs .length);
			this. fwrdRefVvdVOs = tmpVOs;
		}
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public String getTypeGbn() {
		return typeGbn;
	}

	public void setTypeGbn(String typeGbn) {
		this.typeGbn = typeGbn;
	}

	public CustTpIdVO[] getCustTpIdVOs() {
		CustTpIdVO[] tmpVOs = null;
		if (this. custTpIdVOs != null) {
			tmpVOs = Arrays.copyOf(custTpIdVOs, custTpIdVOs .length);
		}
		return tmpVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		if (custTpIdVOs != null) {
			CustTpIdVO[] tmpVOs = Arrays.copyOf(custTpIdVOs, custTpIdVOs .length);
			this. custTpIdVOs = tmpVOs;
		}
	}

	public String getBracCd() {
		return bracCd;
	}

	public void setBracCd(String bracCd) {
		this.bracCd = bracCd;
	}

}