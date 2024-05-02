package com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSqGrpLocVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class GroupLocationQuotationVO {
	
	/** Table Value Object 단건 Data 처리 */
	private PriSqGrpLocVO priSqGrpLocVO = null;
	private PriSqGrpLocDtlVO priSqGrpLocDtlVO = null;
	private RsltPriSqGrpLocVO rsltPriSqGrpLocVO = null;
	private RsltPriSqGrpLocDtlVO rsltPriSqGrpLocDtlVO = null;
	//gline copy 
	private RsltPriSqMnVO rsltPriSqMnVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private PriSqGrpLocVO[] priSqGrpLocVOs = null;
	private PriSqGrpLocDtlVO[] priSqGrpLocDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	List<RsltPriSqGrpLocVO> rsltPriSqGrpLocVOist 	 = new ArrayList<RsltPriSqGrpLocVO>();
	List<RsltPriSqGrpLocDtlVO> rsltPriSqGrpLocDtlVOList = new ArrayList<RsltPriSqGrpLocDtlVO>();
	/**
	 * @return the priSqGrpLocVO
	 */
	public PriSqGrpLocVO getPriSqGrpLocVO() {
		return priSqGrpLocVO;
	}
	/**
	 * @param priSqGrpLocVO the priSqGrpLocVO to set
	 */
	public void setPriSqGrpLocVO(PriSqGrpLocVO priSqGrpLocVO) {
		this.priSqGrpLocVO = priSqGrpLocVO;
	}
	/**
	 * @return the priSqGrpLocDtlVO
	 */
	public PriSqGrpLocDtlVO getPriSqGrpLocDtlVO() {
		return priSqGrpLocDtlVO;
	}
	/**
	 * @param priSqGrpLocDtlVO the priSqGrpLocDtlVO to set
	 */
	public void setPriSqGrpLocDtlVO(PriSqGrpLocDtlVO priSqGrpLocDtlVO) {
		this.priSqGrpLocDtlVO = priSqGrpLocDtlVO;
	}
	/**
	 * @return the rsltPriSqGrpLocVO
	 */
	public RsltPriSqGrpLocVO getRsltPriSqGrpLocVO() {
		return rsltPriSqGrpLocVO;
	}
	/**
	 * @param rsltPriSqGrpLocVO the rsltPriSqGrpLocVO to set
	 */
	public void setRsltPriSqGrpLocVO(RsltPriSqGrpLocVO rsltPriSqGrpLocVO) {
		this.rsltPriSqGrpLocVO = rsltPriSqGrpLocVO;
	}
	/**
	 * @return the rsltPriSqGrpLocDtlVO
	 */
	public RsltPriSqGrpLocDtlVO getRsltPriSqGrpLocDtlVO() {
		return rsltPriSqGrpLocDtlVO;
	}
	/**
	 * @param rsltPriSqGrpLocDtlVO the rsltPriSqGrpLocDtlVO to set
	 */
	public void setRsltPriSqGrpLocDtlVO(RsltPriSqGrpLocDtlVO rsltPriSqGrpLocDtlVO) {
		this.rsltPriSqGrpLocDtlVO = rsltPriSqGrpLocDtlVO;
	}
	/**
	 * @return the priSqGrpLocVOs
	 */
	public PriSqGrpLocVO[] getPriSqGrpLocVOs() {
		return priSqGrpLocVOs;
	}
	/**
	 * @param priSqGrpLocVOs the priSqGrpLocVOs to set
	 */
	public void setPriSqGrpLocVOs(PriSqGrpLocVO[] priSqGrpLocVOs) {
		this.priSqGrpLocVOs = priSqGrpLocVOs;
	}
	/**
	 * @return the priSqGrpLocDtlVOs
	 */
	public PriSqGrpLocDtlVO[] getPriSqGrpLocDtlVOs() {
		return priSqGrpLocDtlVOs;
	}
	/**
	 * @param priSqGrpLocDtlVOs the priSqGrpLocDtlVOs to set
	 */
	public void setPriSqGrpLocDtlVOs(PriSqGrpLocDtlVO[] priSqGrpLocDtlVOs) {
		this.priSqGrpLocDtlVOs = priSqGrpLocDtlVOs;
	}
	/**
	 * @return the rsltPriSqGrpLocVOist
	 */
	public List<RsltPriSqGrpLocVO> getRsltPriSqGrpLocVOist() {
		return rsltPriSqGrpLocVOist;
	}
	/**
	 * @param rsltPriSqGrpLocVOist the rsltPriSqGrpLocVOist to set
	 */
	public void setRsltPriSqGrpLocVOist(List<RsltPriSqGrpLocVO> rsltPriSqGrpLocVOist) {
		this.rsltPriSqGrpLocVOist = rsltPriSqGrpLocVOist;
	}
	/**
	 * @return the rsltPriSqGrpLocDtlVOList
	 */
	public List<RsltPriSqGrpLocDtlVO> getRsltPriSqGrpLocDtlVOList() {
		return rsltPriSqGrpLocDtlVOList;
	}
	/**
	 * @param rsltPriSqGrpLocDtlVOList the rsltPriSqGrpLocDtlVOList to set
	 */
	public void setRsltPriSqGrpLocDtlVOList(
			List<RsltPriSqGrpLocDtlVO> rsltPriSqGrpLocDtlVOList) {
		this.rsltPriSqGrpLocDtlVOList = rsltPriSqGrpLocDtlVOList;
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