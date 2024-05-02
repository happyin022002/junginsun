package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;

public class Eur24BlInfoVO extends BlInfoVO{
	private static final long serialVersionUID = 1L;
	public Eur24BlInfoVO() {}
	
	Eur24BlGeneralInfoVO eur24BlGeneralInfoVO = null;
	Eur24BlCustVO eur24BlCustVO = null;
	Eur24BlCntrListVO[] blCntrListVOs = null;
	List<Eur24BlCntrListVO> eur24BlCntrListVOs = null;
	List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs = null;
	List<Eur24BlDangerCntrListVO> eur24BlDangerCntrListVOs = null;
	List<Eur24BlCntrSealNoListVO> eur24BlCntrSealNoListVOs = null;
	
	/**
	 * @return the Eur24BlCntrSealNoListVO
	 */	
	public List<Eur24BlCntrSealNoListVO> getEur24BlCntrSealNoListVOs() {
		return eur24BlCntrSealNoListVOs;
	}
	
	/**
	 * @param the Eur24BlCntrSealNoListVO
	 */
	public void setEur24BlCntrSealNoListVOs(List<Eur24BlCntrSealNoListVO> eur24BlCntrSealNoListVOs) {
		this.eur24BlCntrSealNoListVOs = eur24BlCntrSealNoListVOs;
	}

	/**
	 * @return the setEur24BlCntrMFListVOs
	 */
	public List<Eur24BlCntrMFListVO> getEur24BlCntrMFListVOs() {
		return eur24BlCntrMFListVOs;
	}
	
	/**
	 * @return the setEur24BlCntrMFListVOs
	 */
	public void setEur24BlCntrMFListVOs(List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs) {
		this.eur24BlCntrMFListVOs = eur24BlCntrMFListVOs;
	}

	/**
	 * @return the eur24BlGeneralInfoVO
	 */
	public Eur24BlGeneralInfoVO getEur24BlGeneralInfoVO() {
		return eur24BlGeneralInfoVO;
	}
	/**
	 * @param eur24BlGeneralInfoVO the eur24BlGeneralInfoVO to set
	 */
	public void setEur24BlGeneralInfoVO(Eur24BlGeneralInfoVO eur24BlGeneralInfoVO) {
		this.eur24BlGeneralInfoVO = eur24BlGeneralInfoVO;
	}
	/**
	 * @return the eur24BlCntrListVOs
	 */
	public List<Eur24BlCntrListVO> getEur24BlCntrListVOs() {
		return eur24BlCntrListVOs;
	}
	/**
	 * @param eur24BlCntrListVOs the eur24BlCntrListVOs to set
	 */
	public void setEur24BlCntrListVOs(List<Eur24BlCntrListVO> eur24BlCntrListVOs) {
		this.eur24BlCntrListVOs = eur24BlCntrListVOs;
	}
	/**
	 * @return the eur24BlCustVO
	 */
	public Eur24BlCustVO getEur24BlCustVO() {
		return eur24BlCustVO;
	}
	/**
	 * @param eur24BlCustVO the eur24BlCustVO to set
	 */
	public void setEur24BlCustVO(Eur24BlCustVO eur24BlCustVO) {
		this.eur24BlCustVO = eur24BlCustVO;
	}
	/**
	 * @return the eur24BlDangerCntrListVOs
	 */
	public List<Eur24BlDangerCntrListVO> getEur24BlDangerCntrListVOs() {
		return eur24BlDangerCntrListVOs;
	}
	/**
	 * @param eur24BlDangerCntrListVOs the eur24BlDangerCntrListVOs to set
	 */
	public void setEur24BlDangerCntrListVOs(
			List<Eur24BlDangerCntrListVO> eur24BlDangerCntrListVOs) {
		this.eur24BlDangerCntrListVOs = eur24BlDangerCntrListVOs;
	}
	/**
	 * @return the blCntrListVOs
	 */
	public Eur24BlCntrListVO[] getBlCntrListVOs() {
		return blCntrListVOs;
	}
	/**
	 * @param blCntrListVOs the blCntrListVOs to set
	 */
	public void setBlCntrListVOs(Eur24BlCntrListVO[] blCntrListVOs) {
		this.blCntrListVOs = blCntrListVOs;
	}
}