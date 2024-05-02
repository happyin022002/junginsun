/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0587Event.java
*@FileTitle : Booking Closing Bayplan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.22 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.OfcCdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCoffTmVO;


/**
 * ESM-BKG-0587 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM-BKG-0587HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM-BKG-0587HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0587Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private OfcCdVO ofcCdVO = null;
	private OfcCdVO[] ofcCdVOs = null;
	private BkgListForBayPlanInputVO bkgListForBayPlanInputVO= null;
	private BkgListForBayPlanInputVO[] bkgListForBayPlanInputVOs= null;
	private BkgCoffTmListVO bkgCoffTmListVO = null;
	private BkgCoffTmListVO[] bkgCoffTmListVOs = null;
	private BkgCoffTmVO bkgCoffTmVO =null;
	private BkgCoffTmVO[] bkgCoffTmVOs =null;

    private String polCd = null;
    private String vslCd = null;


	public EsmBkg0587Event(){}

	public OfcCdVO getOfcCdVO() {
		return ofcCdVO;
	}

	public void setOfcCdVO(OfcCdVO ofcCdVO) {
		this.ofcCdVO = ofcCdVO;
	}

	public OfcCdVO[] getOfcCdVOs() {
		OfcCdVO[] tmpVOs = null;
		if (this. ofcCdVOs != null) {
			tmpVOs = Arrays.copyOf(ofcCdVOs, ofcCdVOs .length);
		}
		return tmpVOs;
	}

	public void setOfcCdVOs(OfcCdVO[] ofcCdVOs) {
		if (ofcCdVOs != null) {
			OfcCdVO[] tmpVOs = Arrays.copyOf(ofcCdVOs, ofcCdVOs .length);
			this. ofcCdVOs = tmpVOs;
		}
	}

	public BkgListForBayPlanInputVO getBkgListForBayPlanInputVO() {
		return bkgListForBayPlanInputVO;
	}

	public void setBkgListForBayPlanInputVO(BkgListForBayPlanInputVO bkgListForBayPlanInputVO) {
		this.bkgListForBayPlanInputVO = bkgListForBayPlanInputVO;
	}

	public BkgListForBayPlanInputVO[] getBkgListForBayPlanInputVOs() {
		BkgListForBayPlanInputVO[] tmpVOs = null;
		if (this. bkgListForBayPlanInputVOs != null) {
			tmpVOs = Arrays.copyOf(bkgListForBayPlanInputVOs, bkgListForBayPlanInputVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgListForBayPlanInputVOs(BkgListForBayPlanInputVO[] bkgListForBayPlanInputVOs) {
		if (bkgListForBayPlanInputVOs != null) {
			BkgListForBayPlanInputVO[] tmpVOs = Arrays.copyOf(bkgListForBayPlanInputVOs, bkgListForBayPlanInputVOs .length);
			this. bkgListForBayPlanInputVOs = tmpVOs;
		}
	}

	public BkgCoffTmListVO getBkgCoffTmListVO() {
		return bkgCoffTmListVO;
	}

	public void setBkgCoffTmListVO(BkgCoffTmListVO bkgCoffTmListVO) {
		this.bkgCoffTmListVO = bkgCoffTmListVO;
	}

	public BkgCoffTmListVO[] getBkgCoffTmListVOs() {
		BkgCoffTmListVO[] tmpVOs = null;
		if (this. bkgCoffTmListVOs != null) {
			tmpVOs = Arrays.copyOf(bkgCoffTmListVOs, bkgCoffTmListVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgCoffTmListVOs(BkgCoffTmListVO[] bkgCoffTmListVOs) {
		if (bkgCoffTmListVOs != null) {
			BkgCoffTmListVO[] tmpVOs = Arrays.copyOf(bkgCoffTmListVOs, bkgCoffTmListVOs .length);
			this. bkgCoffTmListVOs = tmpVOs;
		}
	}

	public BkgCoffTmVO getBkgCoffTmVO() {
		return bkgCoffTmVO;
	}

	public void setBkgCoffTmVO(BkgCoffTmVO bkgCoffTmVO) {
		this.bkgCoffTmVO = bkgCoffTmVO;
	}

	public BkgCoffTmVO[] getBkgCoffTmVOs() {
		BkgCoffTmVO[] tmpVOs = null;
		if (this. bkgCoffTmVOs != null) {
			tmpVOs = Arrays.copyOf(bkgCoffTmVOs, bkgCoffTmVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgCoffTmVOs(BkgCoffTmVO[] bkgCoffTmVOs) {
		if (bkgCoffTmVOs != null) {
			BkgCoffTmVO[] tmpVOs = Arrays.copyOf(bkgCoffTmVOs, bkgCoffTmVOs .length);
			this. bkgCoffTmVOs = tmpVOs;
		}
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}


}