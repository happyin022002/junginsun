package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;


public class NewZealandManifestVO {

	private NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO = null;
	private NewZealandCstmsMfDtl2VO[] newZealandCstmsMfDtl2VOs = null;


	public NewZealandManifestVO() {}


	public NewZealandCstmsVvdInfoCondVO getNewZealandCstmsVvdInfoCondVO() {
		return newZealandCstmsVvdInfoCondVO;
	}

	public void setNewZealandCstmsVvdInfoCondVO(NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO) {
		this.newZealandCstmsVvdInfoCondVO = newZealandCstmsVvdInfoCondVO;
	}

	public NewZealandCstmsMfDtl2VO[] getNewZealandCstmsMfDtl2VOs() {
		NewZealandCstmsMfDtl2VO[] rtnVOs = null;
		if (this.newZealandCstmsMfDtl2VOs != null) {
			rtnVOs = Arrays.copyOf(newZealandCstmsMfDtl2VOs, newZealandCstmsMfDtl2VOs.length);
		}
		return rtnVOs;
	}

	public void setNewZealandCstmsMfDtl2VOs(NewZealandCstmsMfDtl2VO[] newZealandCstmsMfDtl2VOs) {
		if (newZealandCstmsMfDtl2VOs != null) {
			NewZealandCstmsMfDtl2VO[] tmpVOs = Arrays.copyOf(newZealandCstmsMfDtl2VOs, newZealandCstmsMfDtl2VOs.length);
			this.newZealandCstmsMfDtl2VOs = tmpVOs;
		}
	}

}