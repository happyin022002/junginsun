/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0767Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.04 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;


/**
 * ESM_BKG_0767 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0767HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0767HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0767Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRptDfltVO bkgRptDfltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgRptDfltVO[] bkgRptDfltVOs = null;

	public EsmBkg0767Event(){}
	
	public void setBkgRptDfltVO(BkgRptDfltVO bkgRptDfltVO){
		this. bkgRptDfltVO = bkgRptDfltVO;
	}

	public void setBkgRptDfltVOS(BkgRptDfltVO[] bkgRptDfltVOs){
		this. bkgRptDfltVOs = bkgRptDfltVOs;
	}

	public BkgRptDfltVO getBkgRptDfltVO(){
		return bkgRptDfltVO;
	}

	public BkgRptDfltVO[] getBkgRptDfltVOS(){
		return bkgRptDfltVOs;
	}

}