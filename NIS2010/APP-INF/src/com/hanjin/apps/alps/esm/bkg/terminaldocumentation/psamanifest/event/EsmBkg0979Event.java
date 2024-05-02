/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0979Event.java
*@FileTitle : EsmBkg0979Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0979 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0979HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_0979HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0979Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgNo = null;
	private String bkgSeq = null;
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @return the bkgSeq
	 */
	public String getBkgSeq() {
		return bkgSeq;
	}
	/**
	 * @param bkgSeq the bkgSeq to set
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}
	
}
