package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSqRtVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class RateQuotationVO {
	
	/** Table Value Object 단건 Data 처리 */
	private PriSqRtCmdtHdrVO priSqRtCmdtHdrVO = null;
	private PriSqRtCmdtVO priSqRtCmdtVO = null;
	private PriSqRtCmdtRoutVO PriSqRtCmdtRoutVO = null;
	private PriSqRtRoutPntVO priSqRtRoutOrgPntVO = null;
	private PriSqRtRoutPntVO priSqRtRoutDestPntVO = null;
	private PriSqRtRoutViaVO priSqRtRoutOrgViaVO = null;
	private PriSqRtRoutViaVO priSqRtRoutDestViaVO = null;
	private PriSqRtVO priSqRtVO = null;
	private RsltPriSqMnVO rsltPriSqMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSqRtCmdtHdrVO[] priSqRtCmdtHdrVOs = null;
	private PriSqRtCmdtVO[] priSqRtCmdtVOs = null;
	private PriSqRtCmdtRoutVO[] PriSqRtCmdtRoutVOs = null;
	private PriSqRtRoutPntVO[] priSqRtRoutOrgPntVOs = null;
	private PriSqRtRoutPntVO[] priSqRtRoutDestPntVOs = null;
	private PriSqRtRoutViaVO[] priSqRtRoutOrgViaVOs = null;
	private PriSqRtRoutViaVO[] priSqRtRoutDestViaVOs = null;
	private PriSqRtVO[] priSqRtVOs = null;
	
	private RsltPriSqRtCmdtVO[] rsltPriSqRtCmdtVOs = null;
	
	
	/** Table Value Object Multi Data 처리 */
	List<RsltPriSqRtCmdtVO> rsltPriSqRtCmdtVOList 	 = new ArrayList<RsltPriSqRtCmdtVO>();
	List<RsltPriSqRtCmdtRoutVO> rsltPriSqRtCmdtRoutVOList = new ArrayList<RsltPriSqRtCmdtRoutVO>();
	List<RsltPriSqRtRoutPntVO> rsltPriSqRtRoutOrgPntVOList 	 = new ArrayList<RsltPriSqRtRoutPntVO>();
	List<RsltPriSqRtRoutPntVO> rsltPriSqRtRoutDestPntVOList = new ArrayList<RsltPriSqRtRoutPntVO>();
	List<RsltPriSqRtRoutViaVO> rsltPriSqRtRoutOrgViaVOList 	 = new ArrayList<RsltPriSqRtRoutViaVO>();
	List<RsltPriSqRtRoutViaVO> rsltPriSqRtRoutDestViaVOList = new ArrayList<RsltPriSqRtRoutViaVO>();
	List<RsltPriSqRtVO> rsltPriSqRtVOList = new ArrayList<RsltPriSqRtVO>();
	
	
	
	/**
	 * @return the rsltPriSqRtCmdtVOs
	 */
	public RsltPriSqRtCmdtVO[] getRsltPriSqRtCmdtVOs() {
		return rsltPriSqRtCmdtVOs;
	}
	/**
	 * @param rsltPriSqRtCmdtVOs the rsltPriSqRtCmdtVOs to set
	 */
	public void setRsltPriSqRtCmdtVOs(RsltPriSqRtCmdtVO[] rsltPriSqRtCmdtVOs) {
		this.rsltPriSqRtCmdtVOs = rsltPriSqRtCmdtVOs;
	}
	/**
	 * @return the rsltPriSqRtCmdtVOList
	 */
	public List<RsltPriSqRtCmdtVO> getRsltPriSqRtCmdtVOList() {
		return rsltPriSqRtCmdtVOList;
	}
	/**
	 * @param rsltPriSqRtCmdtVOList the rsltPriSqRtCmdtVOList to set
	 */
	public void setRsltPriSqRtCmdtVOList(
			List<RsltPriSqRtCmdtVO> rsltPriSqRtCmdtVOList) {
		this.rsltPriSqRtCmdtVOList = rsltPriSqRtCmdtVOList;
	}
	/**
	 * @return the priSqRtCmdtHdrVO
	 */
	public PriSqRtCmdtHdrVO getPriSqRtCmdtHdrVO() {
		return priSqRtCmdtHdrVO;
	}
	/**
	 * @param priSqRtCmdtHdrVO the priSqRtCmdtHdrVO to set
	 */
	public void setPriSqRtCmdtHdrVO(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) {
		this.priSqRtCmdtHdrVO = priSqRtCmdtHdrVO;
	}
	/**
	 * @return the priSqRtCmdtVO
	 */
	public PriSqRtCmdtVO getPriSqRtCmdtVO() {
		return priSqRtCmdtVO;
	}
	/**
	 * @param priSqRtCmdtVO the priSqRtCmdtVO to set
	 */
	public void setPriSqRtCmdtVO(PriSqRtCmdtVO priSqRtCmdtVO) {
		this.priSqRtCmdtVO = priSqRtCmdtVO;
	}
	/**
	 * @return the priSqRtCmdtRoutVO
	 */
	public PriSqRtCmdtRoutVO getPriSqRtCmdtRoutVO() {
		return PriSqRtCmdtRoutVO;
	}
	/**
	 * @param priSqRtCmdtRoutVO the priSqRtCmdtRoutVO to set
	 */
	public void setPriSqRtCmdtRoutVO(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) {
		PriSqRtCmdtRoutVO = priSqRtCmdtRoutVO;
	}
	/**
	 * @return the priSqRtRoutOrgPntVO
	 */
	public PriSqRtRoutPntVO getPriSqRtRoutOrgPntVO() {
		return priSqRtRoutOrgPntVO;
	}
	/**
	 * @param priSqRtRoutOrgPntVO the priSqRtRoutOrgPntVO to set
	 */
	public void setPriSqRtRoutOrgPntVO(PriSqRtRoutPntVO priSqRtRoutOrgPntVO) {
		this.priSqRtRoutOrgPntVO = priSqRtRoutOrgPntVO;
	}
	/**
	 * @return the priSqRtRoutDestPntVO
	 */
	public PriSqRtRoutPntVO getPriSqRtRoutDestPntVO() {
		return priSqRtRoutDestPntVO;
	}
	/**
	 * @param priSqRtRoutDestPntVO the priSqRtRoutDestPntVO to set
	 */
	public void setPriSqRtRoutDestPntVO(PriSqRtRoutPntVO priSqRtRoutDestPntVO) {
		this.priSqRtRoutDestPntVO = priSqRtRoutDestPntVO;
	}
	/**
	 * @return the priSqRtRoutOrgViaVO
	 */
	public PriSqRtRoutViaVO getPriSqRtRoutOrgViaVO() {
		return priSqRtRoutOrgViaVO;
	}
	/**
	 * @param priSqRtRoutOrgViaVO the priSqRtRoutOrgViaVO to set
	 */
	public void setPriSqRtRoutOrgViaVO(PriSqRtRoutViaVO priSqRtRoutOrgViaVO) {
		this.priSqRtRoutOrgViaVO = priSqRtRoutOrgViaVO;
	}
	/**
	 * @return the priSqRtRoutDestViaVO
	 */
	public PriSqRtRoutViaVO getPriSqRtRoutDestViaVO() {
		return priSqRtRoutDestViaVO;
	}
	/**
	 * @param priSqRtRoutDestViaVO the priSqRtRoutDestViaVO to set
	 */
	public void setPriSqRtRoutDestViaVO(PriSqRtRoutViaVO priSqRtRoutDestViaVO) {
		this.priSqRtRoutDestViaVO = priSqRtRoutDestViaVO;
	}
	/**
	 * @return the priSqRtVO
	 */
	public PriSqRtVO getPriSqRtVO() {
		return priSqRtVO;
	}
	/**
	 * @param priSqRtVO the priSqRtVO to set
	 */
	public void setPriSqRtVO(PriSqRtVO priSqRtVO) {
		this.priSqRtVO = priSqRtVO;
	}
	/**
	 * @return the priSqRtCmdtHdrVOs
	 */
	public PriSqRtCmdtHdrVO[] getPriSqRtCmdtHdrVOs() {
		return priSqRtCmdtHdrVOs;
	}
	/**
	 * @param priSqRtCmdtHdrVOs the priSqRtCmdtHdrVOs to set
	 */
	public void setPriSqRtCmdtHdrVOs(PriSqRtCmdtHdrVO[] priSqRtCmdtHdrVOs) {
		this.priSqRtCmdtHdrVOs = priSqRtCmdtHdrVOs;
	}
	/**
	 * @return the priSqRtCmdtVOs
	 */
	public PriSqRtCmdtVO[] getPriSqRtCmdtVOs() {
		return priSqRtCmdtVOs;
	}
	/**
	 * @param priSqRtCmdtVOs the priSqRtCmdtVOs to set
	 */
	public void setPriSqRtCmdtVOs(PriSqRtCmdtVO[] priSqRtCmdtVOs) {
		this.priSqRtCmdtVOs = priSqRtCmdtVOs;
	}
	/**
	 * @return the priSqRtCmdtRoutVOs
	 */
	public PriSqRtCmdtRoutVO[] getPriSqRtCmdtRoutVOs() {
		return PriSqRtCmdtRoutVOs;
	}
	/**
	 * @param priSqRtCmdtRoutVOs the priSqRtCmdtRoutVOs to set
	 */
	public void setPriSqRtCmdtRoutVOs(PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOs) {
		PriSqRtCmdtRoutVOs = priSqRtCmdtRoutVOs;
	}
	
	/**
	 * @return the priSqRtRoutOrgPntVOs
	 */
	public PriSqRtRoutPntVO[] getPriSqRtRoutOrgPntVOs() {
		return priSqRtRoutOrgPntVOs;
	}
	/**
	 * @param priSqRtRoutOrgPntVOs the priSqRtRoutOrgPntVOs to set
	 */
	public void setPriSqRtRoutOrgPntVOs(PriSqRtRoutPntVO[] priSqRtRoutOrgPntVOs) {
		this.priSqRtRoutOrgPntVOs = priSqRtRoutOrgPntVOs;
	}
	/**
	 * @return the priSqRtRoutDestPntVOs
	 */
	public PriSqRtRoutPntVO[] getPriSqRtRoutDestPntVOs() {
		return priSqRtRoutDestPntVOs;
	}
	/**
	 * @param priSqRtRoutDestPntVOs the priSqRtRoutDestPntVOs to set
	 */
	public void setPriSqRtRoutDestPntVOs(PriSqRtRoutPntVO[] priSqRtRoutDestPntVOs) {
		this.priSqRtRoutDestPntVOs = priSqRtRoutDestPntVOs;
	}
	/**
	 * @return the priSqRtRoutOrgViaVOs
	 */
	public PriSqRtRoutViaVO[] getPriSqRtRoutOrgViaVOs() {
		return priSqRtRoutOrgViaVOs;
	}
	/**
	 * @param priSqRtRoutOrgViaVOs the priSqRtRoutOrgViaVOs to set
	 */
	public void setPriSqRtRoutOrgViaVOs(PriSqRtRoutViaVO[] priSqRtRoutOrgViaVOs) {
		this.priSqRtRoutOrgViaVOs = priSqRtRoutOrgViaVOs;
	}
	/**
	 * @return the priSqRtRoutDestViaVOs
	 */
	public PriSqRtRoutViaVO[] getPriSqRtRoutDestViaVOs() {
		return priSqRtRoutDestViaVOs;
	}
	/**
	 * @param priSqRtRoutDestViaVOs the priSqRtRoutDestViaVOs to set
	 */
	public void setPriSqRtRoutDestViaVOs(PriSqRtRoutViaVO[] priSqRtRoutDestViaVOs) {
		this.priSqRtRoutDestViaVOs = priSqRtRoutDestViaVOs;
	}
	/**
	 * @return the priSqRtVOs
	 */
	public PriSqRtVO[] getPriSqRtVOs() {
		return priSqRtVOs;
	}
	/**
	 * @param priSqRtVOs the priSqRtVOs to set
	 */
	public void setPriSqRtVOs(PriSqRtVO[] priSqRtVOs) {
		this.priSqRtVOs = priSqRtVOs;
	}
	
	/**
	 * @return the rsltPriSqRtCmdtRoutVOList
	 */
	public List<RsltPriSqRtCmdtRoutVO> getRsltPriSqRtCmdtRoutVOList() {
		return rsltPriSqRtCmdtRoutVOList;
	}
	/**
	 * @param rsltPriSqRtCmdtRoutVOList the rsltPriSqRtCmdtRoutVOList to set
	 */
	public void setRsltPriSqRtCmdtRoutVOList(
			List<RsltPriSqRtCmdtRoutVO> rsltPriSqRtCmdtRoutVOList) {
		this.rsltPriSqRtCmdtRoutVOList = rsltPriSqRtCmdtRoutVOList;
	}
	/**
	 * @return the rsltPriSqRtRoutOrgPntVOList
	 */
	public List<RsltPriSqRtRoutPntVO> getRsltPriSqRtRoutOrgPntVOList() {
		return rsltPriSqRtRoutOrgPntVOList;
	}
	/**
	 * @param rsltPriSqRtRoutOrgPntVOList the rsltPriSqRtRoutOrgPntVOList to set
	 */
	public void setRsltPriSqRtRoutOrgPntVOList(
			List<RsltPriSqRtRoutPntVO> rsltPriSqRtRoutOrgPntVOList) {
		this.rsltPriSqRtRoutOrgPntVOList = rsltPriSqRtRoutOrgPntVOList;
	}
	/**
	 * @return the rsltPriSqRtRoutDestPntVOList
	 */
	public List<RsltPriSqRtRoutPntVO> getRsltPriSqRtRoutDestPntVOList() {
		return rsltPriSqRtRoutDestPntVOList;
	}
	/**
	 * @param rsltPriSqRtRoutDestPntVOList the rsltPriSqRtRoutDestPntVOList to set
	 */
	public void setRsltPriSqRtRoutDestPntVOList(
			List<RsltPriSqRtRoutPntVO> rsltPriSqRtRoutDestPntVOList) {
		this.rsltPriSqRtRoutDestPntVOList = rsltPriSqRtRoutDestPntVOList;
	}
	/**
	 * @return the rsltPriSqRtRoutOrgViaVOList
	 */
	public List<RsltPriSqRtRoutViaVO> getRsltPriSqRtRoutOrgViaVOList() {
		return rsltPriSqRtRoutOrgViaVOList;
	}
	/**
	 * @param rsltPriSqRtRoutOrgViaVOList the rsltPriSqRtRoutOrgViaVOList to set
	 */
	public void setRsltPriSqRtRoutOrgViaVOList(
			List<RsltPriSqRtRoutViaVO> rsltPriSqRtRoutOrgViaVOList) {
		this.rsltPriSqRtRoutOrgViaVOList = rsltPriSqRtRoutOrgViaVOList;
	}
	/**
	 * @return the rsltPriSqRtRoutDestViaVOList
	 */
	public List<RsltPriSqRtRoutViaVO> getRsltPriSqRtRoutDestViaVOList() {
		return rsltPriSqRtRoutDestViaVOList;
	}
	/**
	 * @param rsltPriSqRtRoutDestViaVOList the rsltPriSqRtRoutDestViaVOList to set
	 */
	public void setRsltPriSqRtRoutDestViaVOList(
			List<RsltPriSqRtRoutViaVO> rsltPriSqRtRoutDestViaVOList) {
		this.rsltPriSqRtRoutDestViaVOList = rsltPriSqRtRoutDestViaVOList;
	}
	/**
	 * @return the rsltPriSqRtVOList
	 */
	public List<RsltPriSqRtVO> getRsltPriSqRtVOList() {
		return rsltPriSqRtVOList;
	}
	/**
	 * @param rsltPriSqRtVOList the rsltPriSqRtVOList to set
	 */
	public void setRsltPriSqRtVOList(List<RsltPriSqRtVO> rsltPriSqRtVOList) {
		this.rsltPriSqRtVOList = rsltPriSqRtVOList;
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


	
	
}