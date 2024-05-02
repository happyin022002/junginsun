/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg2004Event.java
*@FileTitle : Hard Coding Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.24 조정민
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_2004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_BKG_2004HTMLAction reference
 * @since J2EE 1.6
 */
public class EsmBkg2004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private BkgHrdCdgDescVO bkgHrdCdgDescVO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private BkgHrdCdgDescVO[] bkgHrdCdgDescVOs = null;
	
	public EsmBkg2004Event(){}

	public BkgHrdCdgDescVO getBkgHrdCdgDescVO() {
		return bkgHrdCdgDescVO;
	}

	public void setBkgHrdCdgDescVO(BkgHrdCdgDescVO bkgHrdCdgDescVO) {
		this.bkgHrdCdgDescVO = bkgHrdCdgDescVO;
	}

	public BkgHrdCdgDescVO[] getBkgHrdCdgDescVOs() {
		return bkgHrdCdgDescVOs;
	}

	public void setBkgHrdCdgDescVOs(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs) {
		this.bkgHrdCdgDescVOs = bkgHrdCdgDescVOs;
	}
	
}
