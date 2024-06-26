/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0232Event.java
*@FileTitle : e-Booking & SI Set Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.19 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;


/**
 * ESM_BKG_0232 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0232HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0232HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0232Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgXterSrchSetVO bkgXterSrchSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgXterSrchSetVO[] bkgXterSrchSetVOs = null;

	public EsmBkg0232Event(){}
	
	public void setBkgXterSrchSetVO(BkgXterSrchSetVO bkgXterSrchSetVO){
		this. bkgXterSrchSetVO = bkgXterSrchSetVO;
	}

//	public void setBkgXterSrchSetVOS(BkgXterSrchSetVO[] bkgXterSrchSetVOs){
//		this. bkgXterSrchSetVOs = bkgXterSrchSetVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgXterSrchSetVOS(BkgXterSrchSetVO[] bkgXterSrchSetVOs){
		if (bkgXterSrchSetVOs != null) {
			BkgXterSrchSetVO[] tmpVOs = new BkgXterSrchSetVO[bkgXterSrchSetVOs.length];
			System.arraycopy(bkgXterSrchSetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgXterSrchSetVOs = tmpVOs;
		}		
	}
	
	public BkgXterSrchSetVO getBkgXterSrchSetVO(){
		return bkgXterSrchSetVO;
	}

//	public BkgXterSrchSetVO[] getBkgXterSrchSetVOS(){
//		return bkgXterSrchSetVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgXterSrchSetVO[] getBkgXterSrchSetVOS(){
		BkgXterSrchSetVO[] tmpVOs = null;
		if (this.bkgXterSrchSetVOs != null) {
			tmpVOs = new BkgXterSrchSetVO[bkgXterSrchSetVOs.length];
			System.arraycopy(bkgXterSrchSetVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
}