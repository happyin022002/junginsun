/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0040Event.java
*@FileTitle : BookingMaster
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.05.21 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;


/**
 * esm_bkg_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see esm_bkg_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCstmsAdvScacVO bkgCstmsAdvScacVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs = null;

	public EsmBkg0040Event(){}
	
	public void setBkgCstmsAdvScacVO(BkgCstmsAdvScacVO bkgCstmsAdvScacVO){
		this. bkgCstmsAdvScacVO = bkgCstmsAdvScacVO;
	}

	public void setBkgCstmsAdvScacVOS(BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs){
		this. bkgCstmsAdvScacVOs = bkgCstmsAdvScacVOs;
	}

	public BkgCstmsAdvScacVO getBkgCstmsAdvScacVO(){
		return bkgCstmsAdvScacVO;
	}

	public BkgCstmsAdvScacVO[] getBkgCstmsAdvScacVOS(){
		return bkgCstmsAdvScacVOs;
	}

}