package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRqGrpLocVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class RFAGroupLocationQuotationVO {
	
	/** Table Value Object 단건 Data 처리 */
	private PriRqGrpLocVO priRqGrpLocVO = null;
	private PriRqGrpLocDtlVO priRqGrpLocDtlVO = null;
	private RsltPriRqGrpLocVO rsltPriRqGrpLocVO = null;
	private RsltPriRqGrpLocDtlVO rsltPriRqGrpLocDtlVO = null;
	//gline copy 
	private RsltPriRqMnVO rsltPriRqMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRqGrpLocVO[] priRqGrpLocVOs = null;
	private PriRqGrpLocDtlVO[] priRqGrpLocDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	List<RsltPriRqGrpLocVO> rsltPriRqGrpLocVOist 	 = new ArrayList<RsltPriRqGrpLocVO>();
	List<RsltPriRqGrpLocDtlVO> rsltPriRqGrpLocDtlVOList = new ArrayList<RsltPriRqGrpLocDtlVO>();
	/**
	 * @return the priRqGrpLocVO
	 */
	public PriRqGrpLocVO getPriRqGrpLocVO() {
		return priRqGrpLocVO;
	}
	/**
	 * @param priRqGrpLocVO the priRqGrpLocVO to set
	 */
	public void setPriRqGrpLocVO(PriRqGrpLocVO priRqGrpLocVO) {
		this.priRqGrpLocVO = priRqGrpLocVO;
	}
	/**
	 * @return the priRqGrpLocDtlVO
	 */
	public PriRqGrpLocDtlVO getPriRqGrpLocDtlVO() {
		return priRqGrpLocDtlVO;
	}
	/**
	 * @param priRqGrpLocDtlVO the priRqGrpLocDtlVO to set
	 */
	public void setPriRqGrpLocDtlVO(PriRqGrpLocDtlVO priRqGrpLocDtlVO) {
		this.priRqGrpLocDtlVO = priRqGrpLocDtlVO;
	}
	/**
	 * @return the rsltPriRqGrpLocVO
	 */
	public RsltPriRqGrpLocVO getRsltPriRqGrpLocVO() {
		return rsltPriRqGrpLocVO;
	}
	/**
	 * @param rsltPriRqGrpLocVO the rsltPriRqGrpLocVO to set
	 */
	public void setRsltPriRqGrpLocVO(RsltPriRqGrpLocVO rsltPriRqGrpLocVO) {
		this.rsltPriRqGrpLocVO = rsltPriRqGrpLocVO;
	}
	/**
	 * @return the rsltPriRqGrpLocDtlVO
	 */
	public RsltPriRqGrpLocDtlVO getRsltPriRqGrpLocDtlVO() {
		return rsltPriRqGrpLocDtlVO;
	}
	/**
	 * @param rsltPriRqGrpLocDtlVO the rsltPriRqGrpLocDtlVO to set
	 */
	public void setRsltPriRqGrpLocDtlVO(RsltPriRqGrpLocDtlVO rsltPriRqGrpLocDtlVO) {
		this.rsltPriRqGrpLocDtlVO = rsltPriRqGrpLocDtlVO;
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
	 * @return the priRqGrpLocVOs
	 */
	public PriRqGrpLocVO[] getPriRqGrpLocVOs() {
		return priRqGrpLocVOs;
	}
	/**
	 * @param priRqGrpLocVOs the priRqGrpLocVOs to set
	 */
	public void setPriRqGrpLocVOs(PriRqGrpLocVO[] priRqGrpLocVOs) {
		this.priRqGrpLocVOs = priRqGrpLocVOs;
	}
	/**
	 * @return the priRqGrpLocDtlVOs
	 */
	public PriRqGrpLocDtlVO[] getPriRqGrpLocDtlVOs() {
		return priRqGrpLocDtlVOs;
	}
	/**
	 * @param priRqGrpLocDtlVOs the priRqGrpLocDtlVOs to set
	 */
	public void setPriRqGrpLocDtlVOs(PriRqGrpLocDtlVO[] priRqGrpLocDtlVOs) {
		this.priRqGrpLocDtlVOs = priRqGrpLocDtlVOs;
	}
	/**
	 * @return the rsltPriRqGrpLocVOist
	 */
	public List<RsltPriRqGrpLocVO> getRsltPriRqGrpLocVOist() {
		return rsltPriRqGrpLocVOist;
	}
	/**
	 * @param rsltPriRqGrpLocVOist the rsltPriRqGrpLocVOist to set
	 */
	public void setRsltPriRqGrpLocVOist(List<RsltPriRqGrpLocVO> rsltPriRqGrpLocVOist) {
		this.rsltPriRqGrpLocVOist = rsltPriRqGrpLocVOist;
	}
	/**
	 * @return the rsltPriRqGrpLocDtlVOList
	 */
	public List<RsltPriRqGrpLocDtlVO> getRsltPriRqGrpLocDtlVOList() {
		return rsltPriRqGrpLocDtlVOList;
	}
	/**
	 * @param rsltPriRqGrpLocDtlVOList the rsltPriRqGrpLocDtlVOList to set
	 */
	public void setRsltPriRqGrpLocDtlVOList(
			List<RsltPriRqGrpLocDtlVO> rsltPriRqGrpLocDtlVOList) {
		this.rsltPriRqGrpLocDtlVOList = rsltPriRqGrpLocDtlVOList;
	}
	
}