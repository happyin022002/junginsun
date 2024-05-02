/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0732Event.java
*@FileTitle : Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.18 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0732 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0732HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0732HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0732Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;

	public EsmBkg0732Event(){}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

}