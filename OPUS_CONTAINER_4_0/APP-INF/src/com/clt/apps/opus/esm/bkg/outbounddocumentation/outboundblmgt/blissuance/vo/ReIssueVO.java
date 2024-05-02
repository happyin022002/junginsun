package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.util.List;

import com.clt.framework.support.view.signon.SignOnUserAccount;

public class ReIssueVO {
	
	private List<ReIssueInfoVO> reIssueInfoVO = null;
	private List<BkgDocIssHisVO> bkgDocIssHisVO = null;
	private List<BkgDocIssRdemVO> bkgDocIssRdemVO = null;
	
	private BkgDocIssHisVO[]  bkgDocIssHisVOs = null;
	private BkgDocIssRdemVO[] bkgDocIssRdemVOs = null;
	private SignOnUserAccount 	account	= null;//사용자 정보
	
	private String bkg_no = null;
	private String his_seq = null;
	private String command_type = null;
	
	/**
	 * @return the command_type
	 */
	public String getCommand_type() {
		return command_type;
	}
	/**
	 * @param command_type the command_type to set
	 */
	public void setCommand_type(String command_type) {
		this.command_type = command_type;
	}
	/**
	 * @return the his_seq
	 */
	public String getHis_seq() {
		return his_seq;
	}
	/**
	 * @param his_seq the his_seq to set
	 */
	public void setHis_seq(String his_seq) {
		this.his_seq = his_seq;
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
	 * @return the bkgDocIssHisVOs
	 */
	public BkgDocIssHisVO[] getBkgDocIssHisVOs() {
		return bkgDocIssHisVOs;
	}
	/**
	 * @param bkgDocIssHisVOs the bkgDocIssHisVOs to set
	 */
	public void setBkgDocIssHisVOs(BkgDocIssHisVO[] bkgDocIssHisVOs) {
		this.bkgDocIssHisVOs = bkgDocIssHisVOs;
	}
	/**
	 * @return the bkgDocIssRdemVOs
	 */
	public BkgDocIssRdemVO[] getBkgDocIssRdemVOs() {
		return bkgDocIssRdemVOs;
	}
	/**
	 * @param bkgDocIssRdemVOs the bkgDocIssRdemVOs to set
	 */
	public void setBkgDocIssRdemVOs(BkgDocIssRdemVO[] bkgDocIssRdemVOs) {
		this.bkgDocIssRdemVOs = bkgDocIssRdemVOs;
	}

	
	/**
	 * @return the reIssueInfoVO
	 */
	public List<ReIssueInfoVO> getReIssueInfoVO() {
		return reIssueInfoVO;
	}
	/**
	 * @param reIssueInfoVO the reIssueInfoVO to set
	 */
	public void setReIssueInfoVO(List<ReIssueInfoVO> reIssueInfoVO) {
		this.reIssueInfoVO = reIssueInfoVO;
	}
	/**
	 * @return the bkgDocIssHisVO
	 */
	public List<BkgDocIssHisVO> getBkgDocIssHisVO() {
		return bkgDocIssHisVO;
	}
	/**
	 * @param bkgDocIssHisVO the bkgDocIssHisVO to set
	 */
	public void setBkgDocIssHisVO(List<BkgDocIssHisVO> bkgDocIssHisVO) {
		this.bkgDocIssHisVO = bkgDocIssHisVO;
	}
	/**
	 * @return the bkgDocIssRdemVO
	 */
	public List<BkgDocIssRdemVO> getBkgDocIssRdemVO() {
		return bkgDocIssRdemVO;
	}
	/**
	 * @param bkgDocIssRdemVO the bkgDocIssRdemVO to set
	 */
	public void setBkgDocIssRdemVO(List<BkgDocIssRdemVO> bkgDocIssRdemVO) {
		this.bkgDocIssRdemVO = bkgDocIssRdemVO;
	}

	

}
