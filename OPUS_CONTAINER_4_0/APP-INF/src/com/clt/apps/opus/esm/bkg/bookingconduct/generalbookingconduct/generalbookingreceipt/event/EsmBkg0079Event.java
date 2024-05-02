/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0079Event.java
*@FileTitle : BKG Creation Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgBookingVO;


/**
 * ESM_BKG_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0079HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BkgBlNoVO bkgBlNoVO  = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBookingVO bkgBookingVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgBookingVO[] bkgBookingVOs = null;

	
	public EsmBkg0079Event(){}

	public void setBkgBookingVO(BkgBookingVO bkgBookingVO){
		this. bkgBookingVO = bkgBookingVO;
	}

	public void setBkgBookingVOS(BkgBookingVO[] bkgBookingVOs){
		if (bkgBookingVOs != null) {
			BkgBookingVO[] tmpVOs = Arrays.copyOf(bkgBookingVOs, bkgBookingVOs .length);
			this. bkgBookingVOs = tmpVOs;
		}
	}

	public BkgBookingVO getBkgBookingVO(){
		return bkgBookingVO;
	}

	public BkgBookingVO[] getBkgBookingVOS(){
		BkgBookingVO[] tmpVOs = null;
		if (this. bkgBookingVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBookingVOs, bkgBookingVOs .length);
		}
		return tmpVOs;
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
}