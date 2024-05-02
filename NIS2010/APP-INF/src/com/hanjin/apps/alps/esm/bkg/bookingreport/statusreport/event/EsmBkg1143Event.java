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

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1143 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1143HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0111HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg1143Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCroChkListinVO bkgCroChkListinVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCroChkListinVO[] bkgCroChkListinVOs = null;

	public EsmBkg1143Event(){}
	
	public void setBkgCroChkListinVO(BkgCroChkListinVO bkgCroChkListinVO){
		this. bkgCroChkListinVO = bkgCroChkListinVO;
	}

//	public void setBkgCroChkListinVOS(BkgCroChkListinVO[] bkgCroChkListinVOs){
//		this. bkgCroChkListinVOs = bkgCroChkListinVOs;
//	}

	public BkgCroChkListinVO getBkgCroChkListinVO(){
		return bkgCroChkListinVO;
	}

//	public BkgCroChkListinVO[] getBkgCroChkListinVOS(){
//		return bkgCroChkListinVOs;
//	}
	
	//2015.03.01 Secure Coding 적용 [CWE-495]
	public BkgCroChkListinVO[] getBkgCroChkListinVOS(){
		BkgCroChkListinVO[] rtnVOs = null;
		if (this.bkgCroChkListinVOs != null) {
			rtnVOs = new BkgCroChkListinVO[bkgCroChkListinVOs.length];
			System.arraycopy(bkgCroChkListinVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setBkgCroChkListinVOS(BkgCroChkListinVO[] bkgCroChkListinVOs){
		if (bkgCroChkListinVOs != null) {
			BkgCroChkListinVO[] tmpVOs = new BkgCroChkListinVO[bkgCroChkListinVOs.length];
			System.arraycopy(bkgCroChkListinVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCroChkListinVOs = tmpVOs;
		}
	}	

}