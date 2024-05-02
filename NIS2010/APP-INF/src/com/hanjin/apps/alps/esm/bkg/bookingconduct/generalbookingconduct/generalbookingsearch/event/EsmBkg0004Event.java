/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0004Event.java
*@FileTitle : Hanger Installation Order
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : LeeInYoung
*@LastVersion : 1.0
* 2011.07.20 LeeInYoung
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcRmkVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LeeInYoung
 * @see ESM_BKG_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String vvd = null;
	private String dirCd = null;
	
	private BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO = null;

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getDirCd() {
		return dirCd;
	}

	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	public BkgCustAvcNtcRmkVO getBkgCustAvcNtcRmkVO() {
		return bkgCustAvcNtcRmkVO;
	}

	public void setBkgCustAvcNtcRmkVO(BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO) {
		this.bkgCustAvcNtcRmkVO = bkgCustAvcNtcRmkVO;
	}
	
}