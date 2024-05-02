package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class KorContainerVO extends ManifestListDetailVO
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Structure Data
	private KorMrnNoVO 					korMrnNoVO 				= null;
	private List<KorManifestInfoVO> 	korManifestInfoVOs 		= null;
	private List<KorManifestCrsChkInfoVO> 	korManifestCrsChkInfoVOs 		= null;
	private List<KorBkgCntrQtyInfoVO> 	korBkgCntrQtyInfoVOs 	= null;


	public KorContainerVO(){
	}

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
	public List<KorManifestInfoVO> getKorManifestInfoVOs() {
		return korManifestInfoVOs;
	}

	/**
	 * @param korManifestInfoVOs the korManifestInfoVOs to set
	 */
	public void setKorManifestInfoVOs(List<KorManifestInfoVO> korManifestInfoVOs) {
		this.korManifestInfoVOs = korManifestInfoVOs;
	}

	/**
	 * @return the korManifestCrsChkInfoVOs
	 */
	public List<KorManifestCrsChkInfoVO> getKorManifestCrsChkInfoVOs() {
		return korManifestCrsChkInfoVOs;
	}

	/**
	 * @param korManifestCrsChkInfoVOs the korManifestCrsChkInfoVOs to set
	 */
	public void setKorManifestCrsChkInfoVOs(List<KorManifestCrsChkInfoVO> korManifestCrsChkInfoVOs) {
		this.korManifestCrsChkInfoVOs = korManifestCrsChkInfoVOs;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the korBkgCntrQtyInfoVOs
	 */
	public List<KorBkgCntrQtyInfoVO> getKorBkgCntrQtyInfoVOs() {
		return korBkgCntrQtyInfoVOs;
	}

	/**
	 * @param korBkgCntrQtyInfoVOs the korBkgCntrQtyInfoVOs to set
	 */
	public void setKorBkgCntrQtyInfoVOs(List<KorBkgCntrQtyInfoVO> korBkgCntrQtyInfoVOs) {
		this.korBkgCntrQtyInfoVOs = korBkgCntrQtyInfoVOs;
	}

	/**
	 * @param List<KorBkgCntrQtyInfoVO> the korBkgCntrQtyInfoVOs to set
	 */
	public void addKorBkgCntrQtyInfoVO(List<KorBkgCntrQtyInfoVO> korBkgCntrQtyInfoVOs) {
		if(this.korBkgCntrQtyInfoVOs == null){
			this.korBkgCntrQtyInfoVOs = korBkgCntrQtyInfoVOs;
		}else{
			for(int i=0;i<korBkgCntrQtyInfoVOs.size();i++){
				KorBkgCntrQtyInfoVO node = (KorBkgCntrQtyInfoVO)korBkgCntrQtyInfoVOs.get(i);
				this.korBkgCntrQtyInfoVOs.add(node);
			}
		}
	}
}