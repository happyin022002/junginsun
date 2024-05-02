/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EsmBkg1518Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.09
 *@LastModifier : Hyung-Seok HAM
 *@LastVersion : 1.0
 * 2014.12.09 Hyung-Seok HAM
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdRefNoCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1518 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1518HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyung-Seok HAM
 * @see ESM_BKG_1518HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1518Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO  = null;
	/** 조회조건 */
	private NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO   = null;

	private NewZealandCstmsVvdInfoVO[] NewZealandcstmsVvdInfoVOs = null;
	private NewZealandCstmsVvdRefNoCondVO NewZealandcstmsVvdRefNoCondVO = null;
	private NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO = null;
	private NewZealandManifestVO newZealandManifestVO = null;

	private String key = "";



	public NewZealandCstmsMfDtlCondVO getNewZealandCstmsMfDtlCondVO() {
		return newZealandCstmsMfDtlCondVO;
	}

	public void setNewZealandCstmsMfDtlCondVO(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) {
		this.newZealandCstmsMfDtlCondVO = newZealandCstmsMfDtlCondVO;
	}

	public NewZealandCstmsVvdInfoCondVO getNewZealandCstmsVvdInfoCondVO() {
		return newZealandCstmsVvdInfoCondVO;
	}

	public void setNewZealandCstmsVvdInfoCondVO(NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO) {
		this.newZealandCstmsVvdInfoCondVO = newZealandCstmsVvdInfoCondVO;
	}

	public NewZealandCstmsVvdInfoVO[] getNewZealandCstmsVvdInfoVOS() {
		NewZealandCstmsVvdInfoVO[] rtnVOs = null;
		if (this.NewZealandcstmsVvdInfoVOs != null) {
			rtnVOs = Arrays.copyOf(NewZealandcstmsVvdInfoVOs, NewZealandcstmsVvdInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setNewZealandCstmsVvdRefNoCondVO(NewZealandCstmsVvdRefNoCondVO NewZealandcstmsVvdRefNoCondVO) {
		this.NewZealandcstmsVvdRefNoCondVO = NewZealandcstmsVvdRefNoCondVO;
	}

	public NewZealandCstmsVvdRefNoCondVO getNewZealandCstmsVvdRefNoCondVO() {
		return NewZealandcstmsVvdRefNoCondVO;
	}

	public NewZealandCstmsMfDtl2VO getNewZealandCstmsMfDtl2VO() {
		return newZealandCstmsMfDtl2VO;
	}

	public void setNewZealandCstmsMfDtl2VO(NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO) {
		this.newZealandCstmsMfDtl2VO = newZealandCstmsMfDtl2VO;
	}

	public NewZealandManifestVO getNewZealandManifestVO() {
		return newZealandManifestVO;
	}

	public void setNewZealandManifestVO(NewZealandManifestVO newZealandManifestVO) {
		this.newZealandManifestVO = newZealandManifestVO;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
