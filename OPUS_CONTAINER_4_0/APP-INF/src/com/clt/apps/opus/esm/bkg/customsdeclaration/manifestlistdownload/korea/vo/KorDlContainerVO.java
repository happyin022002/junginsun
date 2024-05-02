package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;

public class KorDlContainerVO extends ManifestListCondVO
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Structure Data
	private String user_id = null;
	private String office = null;
	private KorMrnNoVO 				korMrnNoVO 				= null;
	private KorManifestInfoVO[] 	korManifestInfoVOs 		= null;
	private KorBkgCntrQtyInfoVO[] 	korBkgCntrQtyInfoVOs 	= null;
	/**
	 * @return the korMrnNoVO
	 */
	public KorMrnNoVO getKorMrnNoVO() {
		return korMrnNoVO;
	}
	/**
	 * @param korMrnNoVO the korMrnNoVO to set
	 */
	public void setKorMrnNoVO(KorMrnNoVO korMrnNoVO) {
		this.korMrnNoVO = korMrnNoVO;
	}
	/**
	 * @return the korManifestInfoVOs
	 */
	public KorManifestInfoVO[] getKorManifestInfoVOs() {
		return korManifestInfoVOs;
	}
	/**
	 * @param korManifestInfoVOs the korManifestInfoVOs to set
	 */
	public void setKorManifestInfoVOs(KorManifestInfoVO[] korManifestInfoVOs) {
		this.korManifestInfoVOs = korManifestInfoVOs;
	}
	/**
	 * @return the korBkgCntrQtyInfoVOs
	 */
	public KorBkgCntrQtyInfoVO[] getKorBkgCntrQtyInfoVOs() {
		return korBkgCntrQtyInfoVOs;
	}
	/**
	 * @param korBkgCntrQtyInfoVOs the korBkgCntrQtyInfoVOs to set
	 */
	public void setKorBkgCntrQtyInfoVOs(KorBkgCntrQtyInfoVO[] korBkgCntrQtyInfoVOs) {
		this.korBkgCntrQtyInfoVOs = korBkgCntrQtyInfoVOs;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOffice(){
		return this.office;
	}

	public void setOffice(String p){
		this.office = p;
	}
}