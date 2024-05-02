/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0972Event.java
*@FileTitle : Service Mode And Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.12 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;


/**
 * ESM_BKG_0972 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0972HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0972HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0972Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBookingVO bkgBookingVO = null;
	private BkgBlNoVO bkgBlNoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgBookingVO[] bkgBookingVOs = null;

	public EsmBkg0972Event(){}

	public void setBkgBookingVO(BkgBookingVO bkgBookingVO){
		this. bkgBookingVO = bkgBookingVO;
	}

	public void setBkgBookingVOS(BkgBookingVO[] bkgBookingVOs){
		this. bkgBookingVOs = bkgBookingVOs;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBookingVO getBkgBookingVO(){
		return bkgBookingVO;
	}

	public BkgBookingVO[] getBkgBookingVOS(){
		return bkgBookingVOs;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

}