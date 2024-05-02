/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0278Event.java
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.04.29 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0278 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0278HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Joon Yong Park
 * @see esm_bkg_0278HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0278Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgComboVO bkgcombovo = null;
	private GrpBlPrtInVO grpBlPrtInVO = null;
	private GrpBlPrtVO grpBlPrtVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgComboVO[] bkgcombovos = null;
	private GrpBlPrtInVO[] grpBlPrtInVOs = null;
	private GrpBlPrtVO[] grpBlPrtVOs = null;

	public EsmBkg0278Event(){}


	public BkgComboVO getBkgcombovo() {
		return bkgcombovo;
	}


	public void setBkgcombovo(BkgComboVO bkgcombovo) {
		this.bkgcombovo = bkgcombovo;
	}


	public BkgComboVO[] getBkgcombovos() {
		return bkgcombovos;
	}


	public void setBkgcombovos(BkgComboVO[] bkgcombovos) {
		this.bkgcombovos = bkgcombovos;
	}


	public GrpBlPrtInVO getGrpBlPrtInVO() {
		return grpBlPrtInVO;
	}


	public void setGrpBlPrtInVO(GrpBlPrtInVO grpBlPrtInVO) {
		this.grpBlPrtInVO = grpBlPrtInVO;
	}


	public GrpBlPrtVO getGrpBlPrtVO() {
		return grpBlPrtVO;
	}


	public void setGrpBlPrtVO(GrpBlPrtVO grpBlPrtVO) {
		this.grpBlPrtVO = grpBlPrtVO;
	}


	public GrpBlPrtInVO[] getGrpBlPrtInVOs() {
		return grpBlPrtInVOs;
	}


	public void setGrpBlPrtInVOs(GrpBlPrtInVO[] grpBlPrtInVOs) {
		this.grpBlPrtInVOs = grpBlPrtInVOs;
	}


	public GrpBlPrtVO[] getGrpBlPrtVOs() {
		return grpBlPrtVOs;
	}


	public void setGrpBlPrtVOs(GrpBlPrtVO[] grpBlPrtVOs) {
		this.grpBlPrtVOs = grpBlPrtVOs;
	}

}