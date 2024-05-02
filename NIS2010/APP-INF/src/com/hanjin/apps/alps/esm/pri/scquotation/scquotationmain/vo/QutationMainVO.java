package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class QutationMainVO {
	
	/** Table Value Object 단건 Data 처리 */
	private PriSqHdrVO priSqHdrVO = null;
	private PriSqMnVO priSqMnVO = null;
	private RsltPriSqMnVO rsltPriSqMnVO = null;	
	//add version 용
	RsltCopyToQuotationVO rsltCopyToQuotationVO = null;
	//Gline copy option
	private RsltSearchGlineExistVO rsltSearchGlineExistVO = null;	
	private SqScpGlineCopyVO sqScpGlineCopyVO = null;
	private SqScpGlineCopyVO[] sqScpGlineCopyVOs = null;
	
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
	 * @return the sqScpGlineCopyVO
	 */
	public SqScpGlineCopyVO getSqScpGlineCopyVO() {
		return sqScpGlineCopyVO;
	}
	/**
	 * @param sqScpGlineCopyVO the sqScpGlineCopyVO to set
	 */
	public void setSqScpGlineCopyVO(SqScpGlineCopyVO sqScpGlineCopyVO) {
		this.sqScpGlineCopyVO = sqScpGlineCopyVO;
	}
	/** Table Value Object Multi Data 처리 */
	List<PriSqHdrVO> priSqHdrVOList 				= new ArrayList<PriSqHdrVO>();
	List<PriSqMnVO> priSqMnVOList 					= new ArrayList<PriSqMnVO>();
	List<RsltPriSqMnVO> rsltPriCmpbGrpLocVOList		= new ArrayList<RsltPriSqMnVO>();
	
	
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
	 * @return the priSqHdrVO
	 */
	public PriSqHdrVO getPriSqHdrVO() {
		return priSqHdrVO;
	}
	/**
	 * @param priSqHdrVO the priSqHdrVO to set
	 */
	public void setPriSqHdrVO(PriSqHdrVO priSqHdrVO) {
		this.priSqHdrVO = priSqHdrVO;
	}
	/**
	 * @return the priSqMnVO
	 */
	public PriSqMnVO getPriSqMnVO() {
		return priSqMnVO;
	}
	/**
	 * @param priSqMnVO the priSqMnVO to set
	 */
	public void setPriSqMnVO(PriSqMnVO priSqMnVO) {
		this.priSqMnVO = priSqMnVO;
	}
	/**
	 * @return the rsltPriSqMnVO
	 */
	public RsltPriSqMnVO getRsltPriSqMnVO() {
		return rsltPriSqMnVO;
	}
	/**
	 * @param rsltPriSqMnVO the rsltPriSqMnVO to set
	 */
	public void setRsltPriSqMnVO(RsltPriSqMnVO rsltPriSqMnVO) {
		this.rsltPriSqMnVO = rsltPriSqMnVO;
	}
	/**
	 * @return the priSqHdrVOList
	 */
	public List<PriSqHdrVO> getPriSqHdrVOList() {
		return priSqHdrVOList;
	}
	/**
	 * @param priSqHdrVOList the priSqHdrVOList to set
	 */
	public void setPriSqHdrVOList(List<PriSqHdrVO> priSqHdrVOList) {
		this.priSqHdrVOList = priSqHdrVOList;
	}
	/**
	 * @return the priSqMnVOList
	 */
	public List<PriSqMnVO> getPriSqMnVOList() {
		return priSqMnVOList;
	}
	/**
	 * @param priSqMnVOList the priSqMnVOList to set
	 */
	public void setPriSqMnVOList(List<PriSqMnVO> priSqMnVOList) {
		this.priSqMnVOList = priSqMnVOList;
	}
	/**
	 * @return the rsltPriCmpbGrpLocVOList
	 */
	public List<RsltPriSqMnVO> getRsltPriCmpbGrpLocVOList() {
		return rsltPriCmpbGrpLocVOList;
	}
	/**
	 * @param rsltPriCmpbGrpLocVOList the rsltPriCmpbGrpLocVOList to set
	 */
	public void setRsltPriCmpbGrpLocVOList(
			List<RsltPriSqMnVO> rsltPriCmpbGrpLocVOList) {
		this.rsltPriCmpbGrpLocVOList = rsltPriCmpbGrpLocVOList;
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
	 * @return the sqScpGlineCopyVOs
	 */
	public SqScpGlineCopyVO[] getSqScpGlineCopyVOs() {
		return sqScpGlineCopyVOs;
	}
	/**
	 * @param sqScpGlineCopyVOs the sqScpGlineCopyVOs to set
	 */
	public void setSqScpGlineCopyVOs(SqScpGlineCopyVO[] sqScpGlineCopyVOs) {
		this.sqScpGlineCopyVOs = sqScpGlineCopyVOs;
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