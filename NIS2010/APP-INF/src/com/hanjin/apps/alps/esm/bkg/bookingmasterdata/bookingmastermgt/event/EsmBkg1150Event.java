/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1150Event.java
*@FileTitle : Edit VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : JEONGMIN CHO
*@LastVersion : 1.0
* 2012.07.23 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMapgVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_BKG_1150 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_1131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_BKG_1131HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1150Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg1150Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private BkgMapgVvdVO bkgMapgVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgMapgVvdVO[] bkgMapgVvdVOs = null;
	
	
	public BkgMapgVvdVO getBkgMapgVvdVO() {
		return bkgMapgVvdVO;
	}

	public void setBkgMapgVvdVO(BkgMapgVvdVO bkgMapgVvdVO) {
		this.bkgMapgVvdVO = bkgMapgVvdVO;
	}

	public BkgMapgVvdVO[] getBkgMapgVvdVOs() {
		return bkgMapgVvdVOs;
	}

	public void setBkgMapgVvdVOs(BkgMapgVvdVO[] bkgMapgVvdVOs) {
		this.bkgMapgVvdVOs = bkgMapgVvdVOs;
	}
	

	

	
}
