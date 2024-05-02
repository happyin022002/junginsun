package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.util.List;

import com.clt.syscommon.common.table.BkgCstmsChnCustVO;
import com.clt.syscommon.common.table.BkgCstmsSealNoVO;

public class ChinaBlInfoVO {

	public ChinaBlInfoVO() {}

	ChinaBlGeneralListVO chinaBlGeneralListVO = null;
	List<ChinaBlCntrListVO> chinaBlCntrListVOs = null;
	ChinaBlCustListVO chinaBlCustListVO = null;
	List<ChinaBlDangerCntrListVO> chinaBlDangerCntrListVOs = null;
	List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs = null;

	ChinaBlCntrListVO[] blCntrListVOs = null;
	BkgCstmsChnCustVO[] bkgCstmsChnCustVOs = null;
	ChinaBlDangerCntrListVO[] blDangerCntrListVOs = null;

	/**
	 * @return the chinaBlGeneralListVO
	 */
	public ChinaBlGeneralListVO getChinaBlGeneralListVO() {
		return chinaBlGeneralListVO;
	}
	/**
	 * @param chinaBlGeneralListVO the chinaBlGeneralListVO to set
	 */
	public void setChinaBlGeneralListVO(ChinaBlGeneralListVO chinaBlGeneralListVO) {
		this.chinaBlGeneralListVO = chinaBlGeneralListVO;
	}
	/**
	 * @return the chinaBlCntrListVOs
	 */
	public List<ChinaBlCntrListVO> getChinaBlCntrListVOs() {
		return chinaBlCntrListVOs;
	}
	/**
	 * @param chinaBlCntrListVOs the chinaBlCntrListVOs to set
	 */
	public void setChinaBlCntrListVOs(List<ChinaBlCntrListVO> chinaBlCntrListVOs) {
		this.chinaBlCntrListVOs = chinaBlCntrListVOs;
	}
	/**
	 * @return the chinaBlCustListVO
	 */
	public ChinaBlCustListVO getChinaBlCustListVO() {
		return chinaBlCustListVO;
	}
	/**
	 * @param chinaBlCustListVO the chinaBlCustListVO to set
	 */
	public void setChinaBlCustListVO(ChinaBlCustListVO chinaBlCustListVO) {
		this.chinaBlCustListVO = chinaBlCustListVO;
	}
	/**
	 * @return the chinaBlDangerCntrListVOs
	 */
	public List<ChinaBlDangerCntrListVO> getChinaBlDangerCntrListVOs() {
		return chinaBlDangerCntrListVOs;
	}
	/**
	 * @param chinaBlDangerCntrListVOs the chinaBlDangerCntrListVOs to set
	 */
	public void setChinaBlDangerCntrListVOs(
			List<ChinaBlDangerCntrListVO> chinaBlDangerCntrListVOs) {
		this.chinaBlDangerCntrListVOs = chinaBlDangerCntrListVOs;
	}
	/**
	 * @return the blCntrListVOs
	 */
	public ChinaBlCntrListVO[] getBlCntrListVOs() {
		return blCntrListVOs;
	}
	/**
	 * @param blCntrListVOs the blCntrListVOs to set
	 */
	public void setBlCntrListVOs(ChinaBlCntrListVO[] blCntrListVOs) {
		this.blCntrListVOs = blCntrListVOs;
	}
	/**
	 * @return the bkgCstmsChnCustVOs
	 */
	public BkgCstmsChnCustVO[] getBkgCstmsChnCustVOs() {
		return bkgCstmsChnCustVOs;
	}
	/**
	 * @param bkgCstmsChnCustVOs the bkgCstmsChnCustVOs to set
	 */
	public void setBkgCstmsChnCustVOs(BkgCstmsChnCustVO[] bkgCstmsChnCustVOs) {
		this.bkgCstmsChnCustVOs = bkgCstmsChnCustVOs;
	}
	/**
	 * @return the blDangerCntrListVOs
	 */
	public ChinaBlDangerCntrListVO[] getBlDangerCntrListVOs() {
		return blDangerCntrListVOs;
	}
	/**
	 * @param blDangerCntrListVOs the blDangerCntrListVOs to set
	 */
	public void setBlDangerCntrListVOs(ChinaBlDangerCntrListVO[] blDangerCntrListVOs) {
		this.blDangerCntrListVOs = blDangerCntrListVOs;
	}
	/**
	 * @return the bkgCstmsSealNoVOs
	 */
	public List<BkgCstmsSealNoVO> getBkgCstmsSealNoVOs() {
		return bkgCstmsSealNoVOs;
	}
	/**
	 * @param bkgCstmsSealNoVOs the bkgCstmsSealNoVOs to set
	 */
	public void setBkgCstmsSealNoVOs(List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs) {
		this.bkgCstmsSealNoVOs = bkgCstmsSealNoVOs;
	}

}
