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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.OfcCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;


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
    private String subChk = null;

	public EsmBkg0587Event(){}

	public OfcCdVO getOfcCdVO() {
		return ofcCdVO;
	}

	public void setOfcCdVO(OfcCdVO ofcCdVO) {
		this.ofcCdVO = ofcCdVO;
	}

	public OfcCdVO[] getOfcCdVOs() {
		return ofcCdVOs;
	}

	public void setOfcCdVOs(OfcCdVO[] ofcCdVOs) {
		this.ofcCdVOs = ofcCdVOs;
	}

	public BkgListForBayPlanInputVO getBkgListForBayPlanInputVO() {
		return bkgListForBayPlanInputVO;
	}

	public void setBkgListForBayPlanInputVO(
			BkgListForBayPlanInputVO bkgListForBayPlanInputVO) {
		this.bkgListForBayPlanInputVO = bkgListForBayPlanInputVO;
	}

	public BkgListForBayPlanInputVO[] getBkgListForBayPlanInputVOs() {
		return bkgListForBayPlanInputVOs;
	}

	public void setBkgListForBayPlanInputVOs(
			BkgListForBayPlanInputVO[] bkgListForBayPlanInputVOs) {
		this.bkgListForBayPlanInputVOs = bkgListForBayPlanInputVOs;
	}

	public BkgCoffTmListVO getBkgCoffTmListVO() {
		return bkgCoffTmListVO;
	}

	public void setBkgCoffTmListVO(BkgCoffTmListVO bkgCoffTmListVO) {
		this.bkgCoffTmListVO = bkgCoffTmListVO;
	}

	public BkgCoffTmListVO[] getBkgCoffTmListVOs() {
		return bkgCoffTmListVOs;
	}

	public void setBkgCoffTmListVOs(BkgCoffTmListVO[] bkgCoffTmListVOs) {
		this.bkgCoffTmListVOs = bkgCoffTmListVOs;
	}

	public BkgCoffTmVO getBkgCoffTmVO() {
		return bkgCoffTmVO;
	}

	public void setBkgCoffTmVO(BkgCoffTmVO bkgCoffTmVO) {
		this.bkgCoffTmVO = bkgCoffTmVO;
	}

	public BkgCoffTmVO[] getBkgCoffTmVOs() {
		return bkgCoffTmVOs;
	}

	public void setBkgCoffTmVOs(BkgCoffTmVO[] bkgCoffTmVOs) {
		this.bkgCoffTmVOs = bkgCoffTmVOs;
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

	public String getSubChk() {
		return subChk;
	}

	public void setSubChk(String subChk) {
		this.subChk = subChk;
	}

}