/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1157Event.java
*@FileTitle : T/S Booking Closing Bayplan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.18 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.OfcCdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsBkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetBkgVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgVvdVO;


/**
 * ESM-BKG-0587 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM-BKG-0587HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM-BKG-0587HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1157Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg1157Event(){}

	private OfcCdVO ofcCdVO = null;
	private OfcCdVO[] ofcCdVOs = null;
	private TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO= null;
	private TsBkgListForBayPlanInputVO[] tsBkgListForBayPlanInputVOs= null;
	private BkgTsCoffTmVO bkgTsCoffTmVO = null;
	private BkgTsCoffTmVO[] bkgTsCoffTmVOs = null;

    private String polCd = null;
    private String vslCd = null;
    private String subChk = null;
    
    private String newVvd = null;
    private String nextVvd = null;
    private BkgBlNoVO bkgBlNoVO = null;
    private BkgBlNoVO[] bkgBlNoVOs = null;    
    
    private VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs = null;
    private BkgVvdVO[] bkgVvdVOs = null;

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

	public TsBkgListForBayPlanInputVO getTsBkgListForBayPlanInputVO() {
		return tsBkgListForBayPlanInputVO;
	}

	public void setTsBkgListForBayPlanInputVO(
			TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO) {
		this.tsBkgListForBayPlanInputVO = tsBkgListForBayPlanInputVO;
	}

	public TsBkgListForBayPlanInputVO[] getTsBkgListForBayPlanInputVOs() {
		return tsBkgListForBayPlanInputVOs;
	}

	public void setTsBkgListForBayPlanInputVOs(
			TsBkgListForBayPlanInputVO[] tsBkgListForBayPlanInputVOs) {
		this.tsBkgListForBayPlanInputVOs = tsBkgListForBayPlanInputVOs;
	}

	public BkgTsCoffTmVO getBkgTsCoffTmVO() {
		return bkgTsCoffTmVO;
	}

	public void setBkgTsCoffTmVO(BkgTsCoffTmVO bkgTsCoffTmVO) {
		this.bkgTsCoffTmVO = bkgTsCoffTmVO;
	}

	public BkgTsCoffTmVO[] getBkgTsCoffTmVOs() {
		return bkgTsCoffTmVOs;
	}

	public void setBkgTsCoffTmVOs(BkgTsCoffTmVO[] bkgTsCoffTmVOs) {
		this.bkgTsCoffTmVOs = bkgTsCoffTmVOs;
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

	public String getNewVvd() {
		return newVvd;
	}

	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}

	public String getNextVvd() {
		return nextVvd;
	}

	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

	public VvdAssignTargetBkgVO[] getVvdAssignTargetBkgVOs() {
		return vvdAssignTargetBkgVOs;
	}

	public void setVvdAssignTargetBkgVOs(VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs) {
		this.vvdAssignTargetBkgVOs = vvdAssignTargetBkgVOs;
	}

	public BkgVvdVO[] getBkgVvdVOs() {
		return bkgVvdVOs;
	}

	public void setBkgVvdVOs(BkgVvdVO[] bkgVvdVOs) {
		this.bkgVvdVOs = bkgVvdVOs;
	}

}