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

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public void setBkgCMCroChkListinVOS(BkgCMCroChkListinVO[] bkgCMCroChkListinVOs){
		if(bkgCMCroChkListinVOs != null){
			BkgCMCroChkListinVO[] tmpVOs = Arrays.copyOf(bkgCMCroChkListinVOs, bkgCMCroChkListinVOs.length);
			this.bkgCMCroChkListinVOs = tmpVOs;
		}
	}

	public BkgCMCroChkListinVO getBkgCMCroChkListinVO(){
		return bkgCMCroChkListinVO;
	}

	public BkgCMCroChkListinVO[] getBkgCMCroChkListinVOS(){
		BkgCMCroChkListinVO[] rtnVOs = null;
		if(this.bkgCMCroChkListinVOs != null){
			rtnVOs= Arrays.copyOf(bkgCMCroChkListinVOs, bkgCMCroChkListinVOs.length);
		}
		return rtnVOs;
	}

}