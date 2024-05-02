/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0111Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.05 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;


/**
 * ESM_BKG_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0111HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCMCroChkListinVO bkgCMCroChkListinVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCMCroChkListinVO[] bkgCMCroChkListinVOs = null;

	public EsmBkg0111Event(){}
	
	public void setBkgCMCroChkListinVO(BkgCMCroChkListinVO bkgCMCroChkListinVO){
		this. bkgCMCroChkListinVO = bkgCMCroChkListinVO;
	}

//	public void setBkgCMCroChkListinVOS(BkgCMCroChkListinVO[] bkgCMCroChkListinVOs){
//		this. bkgCMCroChkListinVOs = bkgCMCroChkListinVOs;
//	}

	public BkgCMCroChkListinVO getBkgCMCroChkListinVO(){
		return bkgCMCroChkListinVO;
	}

//	public BkgCMCroChkListinVO[] getBkgCMCroChkListinVOS(){
//		return bkgCMCroChkListinVOs;
//	}

	//2015.03.01 Secure Coding 적용 [CWE-495]
	public BkgCMCroChkListinVO[] getBkgCMCroChkListinVOS(){
		BkgCMCroChkListinVO[] rtnVOs = null;
		if (this.bkgCMCroChkListinVOs != null) {
			rtnVOs = new BkgCMCroChkListinVO[bkgCMCroChkListinVOs.length];
			System.arraycopy(bkgCMCroChkListinVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setBkgCMCroChkListinVOS(BkgCMCroChkListinVO[] bkgCMCroChkListinVOs){
		if (bkgCMCroChkListinVOs != null) {
			BkgCMCroChkListinVO[] tmpVOs = new BkgCMCroChkListinVO[bkgCMCroChkListinVOs.length];
			System.arraycopy(bkgCMCroChkListinVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCMCroChkListinVOs = tmpVOs;
		}
	}
	
}