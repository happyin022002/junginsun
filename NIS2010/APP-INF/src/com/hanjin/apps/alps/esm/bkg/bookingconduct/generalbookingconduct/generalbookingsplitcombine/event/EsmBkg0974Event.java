/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0974Event.java
*@FileTitle : Master Booking Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.24 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0974 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0974HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0974HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0974Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVo = null;

	/** Booking - Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;

	public EsmBkg0974Event(){}

	public BkgBlNoVO getBkgBlNoVo() {
		return bkgBlNoVo;
	}

	public void setBkgBlNoVo(BkgBlNoVO bkgBlNoVo) {
		this.bkgBlNoVo = bkgBlNoVo;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

}