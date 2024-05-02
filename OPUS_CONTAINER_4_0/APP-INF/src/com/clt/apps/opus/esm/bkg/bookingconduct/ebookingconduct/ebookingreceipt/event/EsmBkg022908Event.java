/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022908Event.java
*@FileTitle : e-Booking & SI Process Detail(DANGER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgImgStoVO;


/**
 * ESM_BKG_0229_08 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_08HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_08HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022908Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private XterRqstNoVO xterRqstNoVO = null;
	private DgCgoListVO[] dgCgoListVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgImgStoVO[] bkgImgStoVO = null;
	private SpclRiderInVO spclRiderInVO = null; //d/g rider add

	public EsmBkg022908Event() {
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

	public DgCgoListVO[] getDgCgoListVOs() {
		DgCgoListVO[] rtnVOs = null;
		if (this.dgCgoListVOs != null) {
			rtnVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
		}
		return rtnVOs;
	}

	public void setDgCgoListVOs(DgCgoListVO[] dgCgoListVOs) {
		if(dgCgoListVOs != null){
			DgCgoListVO[] tmpVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
			this.dgCgoListVOs  = tmpVOs;
		}
	}
	
	public SpclRiderInVO getSpclRiderInVO() {
		return spclRiderInVO;
	}

	public void setSpclRiderInVO(SpclRiderInVO spclRiderInVO) {
		this.spclRiderInVO = spclRiderInVO;
	}

	public BkgImgStoVO[] getBkgImgStoVO() {
		BkgImgStoVO[] rtnVOs = null;
		if (this.bkgImgStoVO != null) {
			rtnVOs = Arrays.copyOf(bkgImgStoVO, bkgImgStoVO.length);
		}
		return rtnVOs;
	}

	public void setBkgImgStoVO(BkgImgStoVO[] bkgImgStoVO) {
		if(bkgImgStoVO != null){
			BkgImgStoVO[] tmpVOs = Arrays.copyOf(bkgImgStoVO, bkgImgStoVO.length);
			this.bkgImgStoVO  = tmpVOs;
		}
	}	
	
}