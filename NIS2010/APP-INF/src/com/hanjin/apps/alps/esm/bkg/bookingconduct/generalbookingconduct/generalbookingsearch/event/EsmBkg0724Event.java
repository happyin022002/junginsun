/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0724Event.java
*@FileTitle : Roll Over Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.14 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

	public BkgInforForHistVO getBkgInforForHistVO() {
		return bkgInforForHistVO;
	}

	public void setBkgInforForHistVO(BkgInforForHistVO bkgInforForHistVO) {
		this.bkgInforForHistVO = bkgInforForHistVO;
	}

	public BkgInforForHistVO[] getBkgInforForHistVOs() {
		return bkgInforForHistVOs;
	}

	public void setBkgInforForHistVOs(BkgInforForHistVO[] bkgInforForHistVOs) {
		this.bkgInforForHistVOs = bkgInforForHistVOs;
	}

	public RollOvrVO getRollOvrVO() {
		return rollOvrVO;
	}

	public void setRollOvrVO(RollOvrVO rollOvrVO) {
		this.rollOvrVO = rollOvrVO;
	}

	public RollOvrVO[] getRollOvrVOs() {
		return rollOvrVOs;
	}

	public void setRollOvrVOs(RollOvrVO[] rollOvrVOs) {
		this.rollOvrVOs = rollOvrVOs;
	}
	 
	 
}