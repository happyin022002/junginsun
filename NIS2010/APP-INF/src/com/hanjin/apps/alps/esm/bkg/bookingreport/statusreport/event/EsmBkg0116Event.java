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
* 2012.06.25 김기택 [CHM-201218292-01] C/M 화면 다운로드 데이터 양식 수정(B/L No, TP/SZ, Seal No 컬럼 분리)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;


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
	
	private String TapTp = "";

	public String getTapTp() {
		return this.TapTp;
	}

	public void setTapTp(String tapTp) {
		this.TapTp = tapTp;
	}

	public EsmBkg0116Event(){}
	
	public void setBkgCMPrintListinVO(BkgCMPrintListinVO bkgCMPrintListinVo){
		this. bkgCMPrintListinVo = bkgCMPrintListinVo;
	}

	public void setBkgCMPrintListinVOS(BkgCMPrintListinVO[] bkgCMPrintListinVos){
		this. bkgCMPrintListinVos = bkgCMPrintListinVos;
	}

	public BkgCMPrintListinVO getBkgCMPrintListinVO(){
		return bkgCMPrintListinVo;
	}

	public BkgCMPrintListinVO[] getBkgCMPrintListinVOS(){
		return bkgCMPrintListinVos;
	}

}