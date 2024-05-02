package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRqGrpCmdtVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class RFAGroupCommodityQuotationVO {

	/** Table Value Object 단건 Data 처리 */
	private PriRqGrpCmdtVO priRqGrpCmdtVO = null;
	private PriRqGrpCmdtDtlVO priRqGrpCmdtDtlVO = null;
	private RsltPriRqGrpCmdtVO rsltPriRqGrpCmdtVO = null;
	private RsltPriRqGrpCmdtDtlVO rsltPriRqGrpCmdtDtlVO = null;
	//gline copy 
	private RsltPriRqMnVO rsltPriRqMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRqGrpCmdtVO[] priRqGrpCmdtVOs = null;
	private PriRqGrpCmdtDtlVO[] priRqGrpCmdtDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	List<RsltPriRqGrpCmdtVO> rsltPriRqGrpCmdtVOist 	 = new ArrayList<RsltPriRqGrpCmdtVO>();
	List<RsltPriRqGrpCmdtDtlVO> rsltPriRqGrpCmdtDtlVOList = new ArrayList<RsltPriRqGrpCmdtDtlVO>();
	/**
	 * @return the priRqGrpCmdtVO
	 */
	public PriRqGrpCmdtVO getPriRqGrpCmdtVO() {
		return priRqGrpCmdtVO;
	}
	/**
	 * @param priRqGrpCmdtVO the priRqGrpCmdtVO to set
	 */
	public void setPriRqGrpCmdtVO(PriRqGrpCmdtVO priRqGrpCmdtVO) {
		this.priRqGrpCmdtVO = priRqGrpCmdtVO;
	}
	/**
	 * @return the priRqGrpCmdtDtlVO
	 */
	public PriRqGrpCmdtDtlVO getPriRqGrpCmdtDtlVO() {
		return priRqGrpCmdtDtlVO;
	}
	/**
	 * @param priRqGrpCmdtDtlVO the priRqGrpCmdtDtlVO to set
	 */
	public void setPriRqGrpCmdtDtlVO(PriRqGrpCmdtDtlVO priRqGrpCmdtDtlVO) {
		this.priRqGrpCmdtDtlVO = priRqGrpCmdtDtlVO;
	}
	/**
	 * @return the rsltPriRqGrpCmdtVO
	 */
	public RsltPriRqGrpCmdtVO getRsltPriRqGrpCmdtVO() {
		return rsltPriRqGrpCmdtVO;
	}
	/**
	 * @param rsltPriRqGrpCmdtVO the rsltPriRqGrpCmdtVO to set
	 */
	public void setRsltPriRqGrpCmdtVO(RsltPriRqGrpCmdtVO rsltPriRqGrpCmdtVO) {
		this.rsltPriRqGrpCmdtVO = rsltPriRqGrpCmdtVO;
	}
	/**
	 * @return the rsltPriRqGrpCmdtDtlVO
	 */
	public RsltPriRqGrpCmdtDtlVO getRsltPriRqGrpCmdtDtlVO() {
		return rsltPriRqGrpCmdtDtlVO;
	}
	/**
	 * @param rsltPriRqGrpCmdtDtlVO the rsltPriRqGrpCmdtDtlVO to set
	 */
	public void setRsltPriRqGrpCmdtDtlVO(RsltPriRqGrpCmdtDtlVO rsltPriRqGrpCmdtDtlVO) {
		this.rsltPriRqGrpCmdtDtlVO = rsltPriRqGrpCmdtDtlVO;
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
	 * @return the priRqGrpCmdtVOs
	 */
	public PriRqGrpCmdtVO[] getPriRqGrpCmdtVOs() {
		return priRqGrpCmdtVOs;
	}
	/**
	 * @param priRqGrpCmdtVOs the priRqGrpCmdtVOs to set
	 */
	public void setPriRqGrpCmdtVOs(PriRqGrpCmdtVO[] priRqGrpCmdtVOs) {
		this.priRqGrpCmdtVOs = priRqGrpCmdtVOs;
	}
	/**
	 * @return the priRqGrpCmdtDtlVOs
	 */
	public PriRqGrpCmdtDtlVO[] getPriRqGrpCmdtDtlVOs() {
		return priRqGrpCmdtDtlVOs;
	}
	/**
	 * @param priRqGrpCmdtDtlVOs the priRqGrpCmdtDtlVOs to set
	 */
	public void setPriRqGrpCmdtDtlVOs(PriRqGrpCmdtDtlVO[] priRqGrpCmdtDtlVOs) {
		this.priRqGrpCmdtDtlVOs = priRqGrpCmdtDtlVOs;
	}
	/**
	 * @return the rsltPriRqGrpCmdtVOist
	 */
	public List<RsltPriRqGrpCmdtVO> getRsltPriRqGrpCmdtVOist() {
		return rsltPriRqGrpCmdtVOist;
	}
	/**
	 * @param rsltPriRqGrpCmdtVOist the rsltPriRqGrpCmdtVOist to set
	 */
	public void setRsltPriRqGrpCmdtVOist(
			List<RsltPriRqGrpCmdtVO> rsltPriRqGrpCmdtVOist) {
		this.rsltPriRqGrpCmdtVOist = rsltPriRqGrpCmdtVOist;
	}
	/**
	 * @return the rsltPriRqGrpCmdtDtlVOList
	 */
	public List<RsltPriRqGrpCmdtDtlVO> getRsltPriRqGrpCmdtDtlVOList() {
		return rsltPriRqGrpCmdtDtlVOList;
	}
	/**
	 * @param rsltPriRqGrpCmdtDtlVOList the rsltPriRqGrpCmdtDtlVOList to set
	 */
	public void setRsltPriRqGrpCmdtDtlVOList(
			List<RsltPriRqGrpCmdtDtlVO> rsltPriRqGrpCmdtDtlVOList) {
		this.rsltPriRqGrpCmdtDtlVOList = rsltPriRqGrpCmdtDtlVOList;
	}
	
	
}