/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1344Event.java
*@FileTitle : EsmBkg1344Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.04 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1344 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1344HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_1344HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1344Event extends EventSupport
{

	private static final long serialVersionUID = 1L;

	// 조회용 객체
	private Kor24VslInfoNManifestCondVO kor24VslInfoNManifestCondVO = null;
	// 수정을 위한 객체
	private Kor24ManifestSmryCondVO kor24ManifestSmryCondVO = null;
	// 삭제를 위한 객체
	private Kor24ManiSumCondVO kor24ManiSumCondVO = null;
	// TRANS Discharge 를 위한 객체
	private Kor24DischManifestTransmitVO kor24DischManifestTransmitVO = null;
	// TRANS Manifest  를 위한 객체
	private Kor24ManifestTransmitVO kor24ManifestTransmitVO = null;
	// TRANS AMENDMENT 를 위한 객체
	private Kor24AmendManifestTransmitVO kor24AmendManifestTransmitVO = null;
	// TRANS Empty Amend 를 위한 객체
	private Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs = null;
	// Cancel Per B/L 을 위한 객체
	private Kor24CancelManifestTransmitVO kor24CancelManifestTransmitVO = null;


	public EsmBkg1344Event(){}


	public Kor24VslInfoNManifestCondVO getKor24VslInfoNManifestCondVO() {
		return kor24VslInfoNManifestCondVO;
	}


	public void setKor24VslInfoNManifestCondVO(
			Kor24VslInfoNManifestCondVO kor24VslInfoNManifestCondVO) {
		this.kor24VslInfoNManifestCondVO = kor24VslInfoNManifestCondVO;
	}


	public Kor24ManifestSmryCondVO getKor24ManifestSmryCondVO() {
		return kor24ManifestSmryCondVO;
	}


	public void setKor24ManifestSmryCondVO(
			Kor24ManifestSmryCondVO kor24ManifestSmryCondVO) {
		this.kor24ManifestSmryCondVO = kor24ManifestSmryCondVO;
	}


	public Kor24ManiSumCondVO getKor24ManiSumCondVO() {
		return kor24ManiSumCondVO;
	}


	public void setKor24ManiSumCondVO(Kor24ManiSumCondVO kor24ManiSumCondVO) {
		this.kor24ManiSumCondVO = kor24ManiSumCondVO;
	}


	public Kor24DischManifestTransmitVO getKor24DischManifestTransmitVO() {
		return kor24DischManifestTransmitVO;
	}


	public void setKor24DischManifestTransmitVO(
			Kor24DischManifestTransmitVO kor24DischManifestTransmitVO) {
		this.kor24DischManifestTransmitVO = kor24DischManifestTransmitVO;
	}


	public Kor24ManifestTransmitVO getKor24ManifestTransmitVO() {
		return kor24ManifestTransmitVO;
	}


	public void setKor24ManifestTransmitVO(
			Kor24ManifestTransmitVO kor24ManifestTransmitVO) {
		this.kor24ManifestTransmitVO = kor24ManifestTransmitVO;
	}


	public Kor24AmendManifestTransmitVO getKor24AmendManifestTransmitVO() {
		return kor24AmendManifestTransmitVO;
	}


	public void setKor24AmendManifestTransmitVO(
			Kor24AmendManifestTransmitVO kor24AmendManifestTransmitVO) {
		this.kor24AmendManifestTransmitVO = kor24AmendManifestTransmitVO;
	}


	public Kor24EmpAmdManiVO[] getKor24EmpAmdManiVOs() {
		return kor24EmpAmdManiVOs;
	}


	public void setKor24EmpAmdManiVOs(Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs) {
		this.kor24EmpAmdManiVOs = kor24EmpAmdManiVOs;
	}


	public Kor24CancelManifestTransmitVO getKor24CancelManifestTransmitVO() {
		return kor24CancelManifestTransmitVO;
	}


	public void setKor24CancelManifestTransmitVO(
			Kor24CancelManifestTransmitVO kor24CancelManifestTransmitVO) {
		this.kor24CancelManifestTransmitVO = kor24CancelManifestTransmitVO;
	}

}
