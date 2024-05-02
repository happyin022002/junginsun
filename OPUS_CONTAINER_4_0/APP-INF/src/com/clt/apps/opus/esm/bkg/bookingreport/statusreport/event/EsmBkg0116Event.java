/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0116Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.10 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCMPrintListinVO bkgCMPrintListinVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCMPrintListinVO[] bkgCMPrintListinVos = null;

	public EsmBkg0116Event(){}
	
	public void setBkgCMPrintListinVO(BkgCMPrintListinVO bkgCMPrintListinVo){
		this. bkgCMPrintListinVo = bkgCMPrintListinVo;
	}

	public void setBkgCMPrintListinVOS(BkgCMPrintListinVO[] bkgCMPrintListinVos){
		if(bkgCMPrintListinVos != null){
			BkgCMPrintListinVO[] tmpVOs = Arrays.copyOf(bkgCMPrintListinVos, bkgCMPrintListinVos.length);
			this.bkgCMPrintListinVos = tmpVOs;
		}
	}

	public BkgCMPrintListinVO getBkgCMPrintListinVO(){
		return bkgCMPrintListinVo;
	}

	public BkgCMPrintListinVO[] getBkgCMPrintListinVOS(){
		BkgCMPrintListinVO[] rtnVOs = null;
		if(this.bkgCMPrintListinVos != null){
			rtnVOs= Arrays.copyOf(bkgCMPrintListinVos, bkgCMPrintListinVos.length);
		}
		return rtnVOs;
	}

}