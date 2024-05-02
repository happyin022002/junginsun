package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class Kor24ContainerVO extends ManifestListDetailVO
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Structure Data
	private Kor24MrnNoVO 					korMrnNoVO 				= null;
	private List<Kor24ManifestInfoVO> 	korManifestInfoVOs 		= null;
	private List<Kor24ManifestCrsChkInfoVO> 	korManifestCrsChkInfoVOs 		= null;
	private List<Kor24BkgCntrQtyInfoVO> 	korBkgCntrQtyInfoVOs 	= null;


	public Kor24ContainerVO(){
	}

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
	public List<Kor24ManifestInfoVO> getKor24ManifestInfoVOs() {
		return korManifestInfoVOs;
	}

	/**
	 * @param korManifestInfoVOs the korManifestInfoVOs to set
	 */
	public void setKor24ManifestInfoVOs(List<Kor24ManifestInfoVO> korManifestInfoVOs) {
		this.korManifestInfoVOs = korManifestInfoVOs;
	}

	/**
	 * @return the korManifestCrsChkInfoVOs
	 */
	public List<Kor24ManifestCrsChkInfoVO> getKor24ManifestCrsChkInfoVOs() {
		return korManifestCrsChkInfoVOs;
	}

	/**
	 * @param korManifestCrsChkInfoVOs the korManifestCrsChkInfoVOs to set
	 */
	public void setKor24ManifestCrsChkInfoVOs(List<Kor24ManifestCrsChkInfoVO> korManifestCrsChkInfoVOs) {
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
	public List<Kor24BkgCntrQtyInfoVO> getKor24BkgCntrQtyInfoVOs() {
		return korBkgCntrQtyInfoVOs;
	}

	/**
	 * @param korBkgCntrQtyInfoVOs the korBkgCntrQtyInfoVOs to set
	 */
	public void setKor24BkgCntrQtyInfoVOs(List<Kor24BkgCntrQtyInfoVO> korBkgCntrQtyInfoVOs) {
		this.korBkgCntrQtyInfoVOs = korBkgCntrQtyInfoVOs;
	}

	/**
	 * @param List<Kor24BkgCntrQtyInfoVO> the korBkgCntrQtyInfoVOs to set
	 */
	public void addKor24BkgCntrQtyInfoVO(List<Kor24BkgCntrQtyInfoVO> korBkgCntrQtyInfoVOs) {
		if(this.korBkgCntrQtyInfoVOs == null){
			this.korBkgCntrQtyInfoVOs = korBkgCntrQtyInfoVOs;
		}else{
			for(int i=0;i<korBkgCntrQtyInfoVOs.size();i++){
				Kor24BkgCntrQtyInfoVO node = (Kor24BkgCntrQtyInfoVO)korBkgCntrQtyInfoVOs.get(i);
				this.korBkgCntrQtyInfoVOs.add(node);
			}
		}
	}
}