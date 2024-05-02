/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0112Event.java
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
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByExportBLVO;


/**
 * ESM_BKG_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *  
 * @author kang dong yun
 * @see ESM_BKG_0112HTMLAction 참조  
 * @since J2EE 1.6
 */

public class EsmBkg0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCMCroChkListByExportBLVO bkgCMCroChkListByExportBLVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCMCroChkListByExportBLVO[] bkgCMCroChkListByExportBLVOs = null;

	public EsmBkg0112Event(){}
	
	public void setBkgCMCroChkListinVO(BkgCMCroChkListByExportBLVO bkgCMCroChkListinVO){
		this.bkgCMCroChkListByExportBLVO = bkgCMCroChkListinVO;
	}

	public void setBkgCMCroChkListinVOS(BkgCMCroChkListByExportBLVO[] bkgCMCroChkListinVOs){
		this.bkgCMCroChkListByExportBLVOs = bkgCMCroChkListinVOs;
	}

	public BkgCMCroChkListByExportBLVO getBkgCMCroChkListinVO(){
		return bkgCMCroChkListByExportBLVO;
	}

	public BkgCMCroChkListByExportBLVO[] getBkgCMCroChkListinVOS(){
		return bkgCMCroChkListByExportBLVOs;
	}

}