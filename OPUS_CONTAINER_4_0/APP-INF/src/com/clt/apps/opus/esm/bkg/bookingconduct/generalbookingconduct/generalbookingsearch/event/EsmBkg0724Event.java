/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0724Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.11 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0724 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0724HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0724HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0724Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private BkgInforForHistVO bkgInforForHistVO = null;
	private BkgInforForHistVO[] bkgInforForHistVOs = null; 
	private RollOvrVO rollOvrVO = null;
	private RollOvrVO[] rollOvrVOs = null;

	public EsmBkg0724Event(){}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
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

	public BkgInforForHistVO getBkgInforForHistVO() {
		return bkgInforForHistVO;
	}

	public void setBkgInforForHistVO(BkgInforForHistVO bkgInforForHistVO) {
		this.bkgInforForHistVO = bkgInforForHistVO;
	}

	public BkgInforForHistVO[] getBkgInforForHistVOs() {
		BkgInforForHistVO[] tmpVOs = null;
		if (this. bkgInforForHistVOs != null) {
			tmpVOs = Arrays.copyOf(bkgInforForHistVOs, bkgInforForHistVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgInforForHistVOs(BkgInforForHistVO[] bkgInforForHistVOs) {
		if (bkgInforForHistVOs != null) {
			BkgInforForHistVO[] tmpVOs = Arrays.copyOf(bkgInforForHistVOs, bkgInforForHistVOs .length);
			this. bkgInforForHistVOs = tmpVOs;
		}
	}

	public RollOvrVO getRollOvrVO() {
		return rollOvrVO;
	}

	public void setRollOvrVO(RollOvrVO rollOvrVO) {
		this.rollOvrVO = rollOvrVO;
	}

	public RollOvrVO[] getRollOvrVOs() {
		RollOvrVO[] tmpVOs = null;
		if (this. rollOvrVOs != null) {
			tmpVOs = Arrays.copyOf(rollOvrVOs, rollOvrVOs .length);
		}
		return tmpVOs;
	}

	public void setRollOvrVOs(RollOvrVO[] rollOvrVOs) {
		if (rollOvrVOs != null) {
			RollOvrVO[] tmpVOs = Arrays.copyOf(rollOvrVOs, rollOvrVOs .length);
			this. rollOvrVOs = tmpVOs;
		}
	}
}
