/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri000103Event.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0565 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0565HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0565HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0565Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO = null;
	
	public EsmBkg0565Event(){}

	public RsltBkgRevDrNotesPerformanceVO getRsltBkgRevDrNotesPerformanceVO() {
		return rsltBkgRevDrNotesPerformanceVO;
	}

	public void setRsltBkgRevDrNotesPerformanceVO(
			RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO) {
		this.rsltBkgRevDrNotesPerformanceVO = rsltBkgRevDrNotesPerformanceVO;
	}

	

}