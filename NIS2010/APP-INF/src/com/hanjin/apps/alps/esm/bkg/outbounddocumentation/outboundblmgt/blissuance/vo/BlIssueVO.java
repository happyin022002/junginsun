package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

public class BlIssueVO {
	
	private List<BlIssInfoVO> 	blIssInfoList = null;
	private List<BkgComboVO> 	vesselVoyagedList = null;
	private List<BkgComboVO> 	preCarriageList = null;
	private SignOnUserAccount 	account = null;
	private String 				bkg_no = null;
	private String 				bl_no = null;
	private BlIssInfoVO[] 		blIssInfoVOs = null;
	private BlIssInfoVO 		blIssInfoVO = null;
	private String 			bl_not_ready = null;
	private OtsRcvInfoVO 	otsRcvInfoVO = null;
	
	
	/**
	 * @return the bl_not_ready
	 */
	public String getBl_not_ready() {
		return bl_not_ready;
	}
	/**
	 * @param bl_not_ready the bl_not_ready to set
	 */
	public void setBl_not_ready(String bl_not_ready) {
		this.bl_not_ready = bl_not_ready;
	}
	/**
	 * @return the otsRcvInfoVO
	 */
	public OtsRcvInfoVO getOtsRcvInfoVO() {
		return otsRcvInfoVO;
	}
	/**
	 * @param otsRcvInfoVO the otsRcvInfoVO to set
	 */
	public void setOtsRcvInfoVO(OtsRcvInfoVO otsRcvInfoVO) {
		this.otsRcvInfoVO = otsRcvInfoVO;
	}
	/**
	 * @return the vesselVoyagedList
	 */
	public List<BkgComboVO> getVesselVoyagedList() {
		return vesselVoyagedList;
	}
	/**
	 * @param vesselVoyagedList the vesselVoyagedList to set
	 */
	public void setVesselVoyagedList(List<BkgComboVO> vesselVoyagedList) {
		this.vesselVoyagedList = vesselVoyagedList;
	}
	/**
	 * @return the preCarriageList
	 */
	public List<BkgComboVO> getPreCarriageList() {
		return preCarriageList;
	}
	/**
	 * @param preCarriageList the preCarriageList to set
	 */
	public void setPreCarriageList(List<BkgComboVO> preCarriageList) {
		this.preCarriageList = preCarriageList;
	}
	/**
	 * @return the blIssInfoList
	 */
	public List<BlIssInfoVO> getBlIssInfoList() {
		return blIssInfoList;
	}
	/**
	 * @param blIssInfoList the blIssInfoList to set
	 */
	public void setBlIssInfoList(List<BlIssInfoVO> blIssInfoList) {
		this.blIssInfoList = blIssInfoList;
	}

	
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkg_no;
	}
	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return bl_no;
	}
	/**
	 * @param bl_no the bl_no to set
	 */
	public void setBl_no(String bl_no) {
		this.bl_no = bl_no;
	}

	
	
	/**
	 * @return the blIssInfoVOs
	 */
	public BlIssInfoVO[] getBlIssInfoVOs() {
		return blIssInfoVOs;
	}
	/**
	 * @param blIssInfoVOs the blIssInfoVOs to set
	 */
	public void setBlIssInfoVOs(BlIssInfoVO[] blIssInfoVOs) {
		this.blIssInfoVOs = blIssInfoVOs;
	}
	/**
	 * @return the blIssInfoVO
	 */
	public BlIssInfoVO getBlIssInfoVO() {
		return blIssInfoVO;
	}
	/**
	 * @param blIssInfoVO the blIssInfoVO to set
	 */
	public void setBlIssInfoVO(BlIssInfoVO blIssInfoVO) {
		this.blIssInfoVO = blIssInfoVO;
	}





}
