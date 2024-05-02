package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;

public class Kor24DlContainerVO extends ManifestListCondVO
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Structure Data
	private String user_id = null;
	private String office = null;
	private Kor24MrnNoVO 				korMrnNoVO 				= null;
	private Kor24ManifestInfoVO[] 	korManifestInfoVOs 		= null;
	private Kor24BkgCntrQtyInfoVO[] 	korBkgCntrQtyInfoVOs 	= null;
	/**
	 * @return the korMrnNoVO
	 */
	public Kor24MrnNoVO getKor24MrnNoVO() {
		return korMrnNoVO;
	}
	/**
	 * @param korMrnNoVO the korMrnNoVO to set
	 */
	public void setKor24MrnNoVO(Kor24MrnNoVO korMrnNoVO) {
		this.korMrnNoVO = korMrnNoVO;
	}
	/**
	 * @return the korManifestInfoVOs
	 */
	public Kor24ManifestInfoVO[] getKor24ManifestInfoVOs() {
		return korManifestInfoVOs;
	}
	/**
	 * @param korManifestInfoVOs the korManifestInfoVOs to set
	 */
	public void setKor24ManifestInfoVOs(Kor24ManifestInfoVO[] korManifestInfoVOs) {
		this.korManifestInfoVOs = korManifestInfoVOs;
	}
	/**
	 * @return the korBkgCntrQtyInfoVOs
	 */
	public Kor24BkgCntrQtyInfoVO[] getKor24BkgCntrQtyInfoVOs() {
		return korBkgCntrQtyInfoVOs;
	}
	/**
	 * @param korBkgCntrQtyInfoVOs the korBkgCntrQtyInfoVOs to set
	 */
	public void setKor24BkgCntrQtyInfoVOs(Kor24BkgCntrQtyInfoVO[] korBkgCntrQtyInfoVOs) {
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