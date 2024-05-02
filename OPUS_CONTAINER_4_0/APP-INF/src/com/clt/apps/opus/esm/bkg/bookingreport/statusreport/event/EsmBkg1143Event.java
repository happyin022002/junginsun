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
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public BkgCroChkListinVO getBkgCroChkListinVO(){
		return bkgCroChkListinVO;
	}

	public BkgCroChkListinVO[] getBkgCroChkListinVOs() {
		BkgCroChkListinVO[] rtnVOs = null;
		if (this.bkgCroChkListinVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCroChkListinVOs, bkgCroChkListinVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCroChkListinVOs(BkgCroChkListinVO[] bkgCroChkListinVOs) {
		if (bkgCroChkListinVOs != null) {
			BkgCroChkListinVO[] tmpVOs = Arrays.copyOf(bkgCroChkListinVOs,
					bkgCroChkListinVOs.length);
			this.bkgCroChkListinVOs = tmpVOs;
		}
	}

}