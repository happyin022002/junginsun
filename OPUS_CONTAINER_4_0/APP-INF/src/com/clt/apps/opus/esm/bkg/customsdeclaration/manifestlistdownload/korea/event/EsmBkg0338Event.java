/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0338Event.java
*@FileTitle : EsmBkg0338Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrMfSeqNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBondTsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnBondInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0338 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0338HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 박상훈
 * @see ESM_BKG_0338HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0338Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorMsnBondInfoVO korMsnBondInfoVO = null;
	// GRID 에서 넘어오는 객체배열 (LOCAL과 같지만 필드가 더 있는 TS 기준으로 처리)
	private KorBondTsInfoVO[] korBondInfoVOs = null;
	// MSN Check 용
	private BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO = null;

	// Disch CY 코드를 담는 변수
	private String dischCy = null;

	public EsmBkg0338Event() {}

	/**
	 * @return the dischCy
	 */
	public String getDischCy() {
		return dischCy;
	}

	/**
	 * @param dischCy the dischCy to set
	 */
	public void setDischCy(String dischCy) {
		this.dischCy = dischCy;
	}

	/**
	 * @return the bkgCstmsKrMfSeqNoVO
	 */
	public BkgCstmsKrMfSeqNoVO getBkgCstmsKrMfSeqNoVO() {
		return bkgCstmsKrMfSeqNoVO;
	}

	/**
	 * @param bkgCstmsKrMfSeqNoVO the bkgCstmsKrMfSeqNoVO to set
	 */
	public void setBkgCstmsKrMfSeqNoVO(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) {
		this.bkgCstmsKrMfSeqNoVO = bkgCstmsKrMfSeqNoVO;
	}

	/**
	 * @return the korMsnBondInfoVO
	 */
	public KorMsnBondInfoVO getKorMsnBondInfoVO() {
		return korMsnBondInfoVO;
	}

	/**
	 * @param korMsnBondInfoVO the korMsnBondInfoVO to set
	 */
	public void setKorMsnBondInfoVO(KorMsnBondInfoVO korMsnBondInfoVO) {
		this.korMsnBondInfoVO = korMsnBondInfoVO;
	}

	/**
	 * @return the korBondInfoVOs
	 */
	public KorBondTsInfoVO[] getKorBondInfoVOs() {
		KorBondTsInfoVO[] rtnVOs = null;
		if (this.korBondInfoVOs != null) {
			rtnVOs = Arrays.copyOf(korBondInfoVOs, korBondInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korBondInfoVOs the korBondInfoVOs to set
	 */
	public void setKorBondInfoVOs(KorBondTsInfoVO[] korBondInfoVOs) {
		if (korBondInfoVOs != null) {
			KorBondTsInfoVO[] tmpVOs = Arrays.copyOf(korBondInfoVOs, korBondInfoVOs.length);
			this.korBondInfoVOs = tmpVOs;
		}
	}

}
