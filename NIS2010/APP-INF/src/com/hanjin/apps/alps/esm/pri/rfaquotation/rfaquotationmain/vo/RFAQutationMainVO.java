package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class RFAQutationMainVO {
	
	/** Table Value Object 단건 Data 처리 */
	private PriRqHdrVO priRqHdrVO = null;
	private PriRqMnVO priRqMnVO = null;
	private RsltPriRqMnVO rsltPriRqMnVO = null;	
	//add version 용
	RsltCopyToQuotationVO rsltCopyToQuotationVO = null;
	//Gline copy option
	private RsltSearchGlineExistVO rsltSearchGlineExistVO = null;	
	private RqScpGlineCopyVO rqScpGlineCopyVO = null;
	private RqScpGlineCopyVO[] rqScpGlineCopyVOs = null;
	
	private RsltSearchGlineExistVO[] rsltSearchGlineExistVOs = null;
	
	//auth
	private RsltPriAuthorizationVO rsltPriAuthorizationVO = null;

	/**
	 * @return the rsltPriAuthorizationVO
	 */
	public RsltPriAuthorizationVO getRsltPriAuthorizationVO() {
		return rsltPriAuthorizationVO;
	}

	/**
	 * @param rsltPriAuthorizationVO the rsltPriAuthorizationVO to set
	 */
	public void setRsltPriAuthorizationVO(
			RsltPriAuthorizationVO rsltPriAuthorizationVO) {
		this.rsltPriAuthorizationVO = rsltPriAuthorizationVO;
	}

	/**
	 * @return the priRqHdrVO
	 */
	public PriRqHdrVO getPriRqHdrVO() {
		return priRqHdrVO;
	}

	/**
	 * @param priRqHdrVO the priRqHdrVO to set
	 */
	public void setPriRqHdrVO(PriRqHdrVO priRqHdrVO) {
		this.priRqHdrVO = priRqHdrVO;
	}

	/**
	 * @return the priRqMnVO
	 */
	public PriRqMnVO getPriRqMnVO() {
		return priRqMnVO;
	}

	/**
	 * @param priRqMnVO the priRqMnVO to set
	 */
	public void setPriRqMnVO(PriRqMnVO priRqMnVO) {
		this.priRqMnVO = priRqMnVO;
	}

	/**
	 * @return the rsltPriRqMnVO
	 */
	public RsltPriRqMnVO getRsltPriRqMnVO() {
		return rsltPriRqMnVO;
	}

	/**
	 * @param rsltPriRqMnVO the rsltPriRqMnVO to set
	 */
	public void setRsltPriRqMnVO(RsltPriRqMnVO rsltPriRqMnVO) {
		this.rsltPriRqMnVO = rsltPriRqMnVO;
	}

	/**
	 * @return the rsltCopyToQuotationVO
	 */
	public RsltCopyToQuotationVO getRsltCopyToQuotationVO() {
		return rsltCopyToQuotationVO;
	}

	/**
	 * @param rsltCopyToQuotationVO the rsltCopyToQuotationVO to set
	 */
	public void setRsltCopyToQuotationVO(RsltCopyToQuotationVO rsltCopyToQuotationVO) {
		this.rsltCopyToQuotationVO = rsltCopyToQuotationVO;
	}

	/**
	 * @return the rsltSearchGlineExistVO
	 */
	public RsltSearchGlineExistVO getRsltSearchGlineExistVO() {
		return rsltSearchGlineExistVO;
	}

	/**
	 * @param rsltSearchGlineExistVO the rsltSearchGlineExistVO to set
	 */
	public void setRsltSearchGlineExistVO(
			RsltSearchGlineExistVO rsltSearchGlineExistVO) {
		this.rsltSearchGlineExistVO = rsltSearchGlineExistVO;
	}

	/**
	 * @return the rqScpGlineCopyVO
	 */
	public RqScpGlineCopyVO getRqScpGlineCopyVO() {
		return rqScpGlineCopyVO;
	}

	/**
	 * @param rqScpGlineCopyVO the rqScpGlineCopyVO to set
	 */
	public void setRqScpGlineCopyVO(RqScpGlineCopyVO rqScpGlineCopyVO) {
		this.rqScpGlineCopyVO = rqScpGlineCopyVO;
	}

	/**
	 * @return the rqScpGlineCopyVOs
	 */
	public RqScpGlineCopyVO[] getRqScpGlineCopyVOs() {
		return rqScpGlineCopyVOs;
	}

	/**
	 * @param rqScpGlineCopyVOs the rqScpGlineCopyVOs to set
	 */
	public void setRqScpGlineCopyVOs(RqScpGlineCopyVO[] rqScpGlineCopyVOs) {
		this.rqScpGlineCopyVOs = rqScpGlineCopyVOs;
	}

	/**
	 * @return the rsltSearchGlineExistVOs
	 */
	public RsltSearchGlineExistVO[] getRsltSearchGlineExistVOs() {
		return rsltSearchGlineExistVOs;
	}

	/**
	 * @param rsltSearchGlineExistVOs the rsltSearchGlineExistVOs to set
	 */
	public void setRsltSearchGlineExistVOs(
			RsltSearchGlineExistVO[] rsltSearchGlineExistVOs) {
		this.rsltSearchGlineExistVOs = rsltSearchGlineExistVOs;
	}

	
	
	
}