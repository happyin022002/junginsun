/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1329Event.java
*@FileTitle : EsmBkg1329Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.25 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MsnNoCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1329 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1329HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_1329HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1329Event extends EventSupport {


	private static final long serialVersionUID = 1L;

	private Kor24ManifestInfoVO[] kor24ManifestInfoVOs = null;
	private Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs = null;
	private Kor24BkgCntrQtyInfoVO[] kor24BkgCntrQtyInfoVOs = null;
	private Kor24MrnNoVO kor24MrnNoVO = null;
	private String key = null;
	private Kor24MsnNoCondVO[] kor24MsnNoCondVOs = null;

	public EsmBkg1329Event(){}

	public Kor24ManifestInfoVO[] getKor24ManifestInfoVOs() {
		return kor24ManifestInfoVOs;
	}

	public void setKor24ManifestInfoVOs(Kor24ManifestInfoVO[] kor24ManifestInfoVOs) {
		this.kor24ManifestInfoVOs = kor24ManifestInfoVOs;
	}

	public Kor24ManifestCrsChkInfoVO[] getKor24ManifestCrsChkInfoVOs() {
		return kor24ManifestCrsChkInfoVOs;
	}

	public void setKor24ManifestCrsChkInfoVOs(
			Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs) {
		this.kor24ManifestCrsChkInfoVOs = kor24ManifestCrsChkInfoVOs;
	}

	public Kor24BkgCntrQtyInfoVO[] getKor24BkgCntrQtyInfoVOs() {
		return kor24BkgCntrQtyInfoVOs;
	}

	public void setKor24BkgCntrQtyInfoVOs(
			Kor24BkgCntrQtyInfoVO[] kor24BkgCntrQtyInfoVOs) {
		this.kor24BkgCntrQtyInfoVOs = kor24BkgCntrQtyInfoVOs;
	}

	public Kor24MrnNoVO getKor24MrnNoVO() {
		return kor24MrnNoVO;
	}

	public void setKor24MrnNoVO(Kor24MrnNoVO kor24MrnNoVO) {
		this.kor24MrnNoVO = kor24MrnNoVO;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Kor24MsnNoCondVO[] getKor24MsnNoCondVOs() {
		return kor24MsnNoCondVOs;
	}

	public void setKor24MsnNoCondVOs(Kor24MsnNoCondVO[] kor24MsnNoCondVOs) {
		this.kor24MsnNoCondVOs = kor24MsnNoCondVOs;
	}

}