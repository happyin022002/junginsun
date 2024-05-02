/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1507Event.java
*@FileTitle : Allocation Stand by Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.01.13 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1507 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1507HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dongsun Moon
 * @see ESM_BKG_1507HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1507Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String    bkgNo         = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
//	private BkgBlNoVO bkgBlNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	private BkgBlNoVO[] bkgBlNoVOs = null;

	public EsmBkg1507Event(){}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}	
}