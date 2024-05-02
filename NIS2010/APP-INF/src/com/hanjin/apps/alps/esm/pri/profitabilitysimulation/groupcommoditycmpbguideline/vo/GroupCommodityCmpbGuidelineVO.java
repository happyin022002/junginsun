package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtDtlVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class GroupCommodityCmpbGuidelineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";


	/** Table Value Object 단건 Data 처리 */
	private PriCmpbGrpCmdtVO priCmpbGrpCmdtVO = null;
	private PriCmpbGrpCmdtDtlVO priCmpbGrpCmdtDtlVO = null;
	private RsltPriCmpbGrpCmdtDtlVO rsltPriCmpbGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriCmpbGrpCmdtVO[] priCmpbGrpCmdtVOs = null;
	private PriCmpbGrpCmdtDtlVO[] priCmpbGrpCmptDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	List<PriCmpbGrpCmdtVO> priCmpbGrpCmdtVOList 	 = new ArrayList<PriCmpbGrpCmdtVO>();
	List<PriCmpbGrpCmdtDtlVO> priCmpbGrpCmdtDtlVOList = new ArrayList<PriCmpbGrpCmdtDtlVO>();
	/**
	 * @return the searchGubun
	 */
	public String getSearchGubun() {
		return searchGubun;
	}
	/**
	 * @param searchGubun the searchGubun to set
	 */
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}
	/**
	 * @return the priCmpbGrpCmdtVO
	 */
	public PriCmpbGrpCmdtVO getPriCmpbGrpCmdtVO() {
		return priCmpbGrpCmdtVO;
	}
	/**
	 * @param priCmpbGrpCmdtVO the priCmpbGrpCmdtVO to set
	 */
	public void setPriCmpbGrpCmdtVO(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) {
		this.priCmpbGrpCmdtVO = priCmpbGrpCmdtVO;
	}
	
	
	/**
	 * @return the priCmpbGrpCmdtDtlVO
	 */
	public PriCmpbGrpCmdtDtlVO getPriCmpbGrpCmdtDtlVO() {
		return priCmpbGrpCmdtDtlVO;
	}
	/**
	 * @param priCmpbGrpCmdtDtlVO the priCmpbGrpCmdtDtlVO to set
	 */
	public void setPriCmpbGrpCmdtDtlVO(PriCmpbGrpCmdtDtlVO priCmpbGrpCmdtDtlVO) {
		this.priCmpbGrpCmdtDtlVO = priCmpbGrpCmdtDtlVO;
	}
	/**
	 * @return the rsltPriCmpbGrpCmdtDtlVO
	 */
	public RsltPriCmpbGrpCmdtDtlVO getRsltPriCmpbGrpCmdtDtlVO() {
		return rsltPriCmpbGrpCmdtDtlVO;
	}
	/**
	 * @param rsltPriCmpbGrpCmdtDtlVO the rsltPriCmpbGrpCmdtDtlVO to set
	 */
	public void setRsltPriCmpbGrpCmdtDtlVO(
			RsltPriCmpbGrpCmdtDtlVO rsltPriCmpbGrpCmdtDtlVO) {
		this.rsltPriCmpbGrpCmdtDtlVO = rsltPriCmpbGrpCmdtDtlVO;
	}
	/**
	 * @return the priCmpbGrpCmdtVOs
	 */
	public PriCmpbGrpCmdtVO[] getPriCmpbGrpCmdtVOs() {
		return priCmpbGrpCmdtVOs;
	}
	/**
	 * @param priCmpbGrpCmdtVOs the priCmpbGrpCmdtVOs to set
	 */
	public void setPriCmpbGrpCmdtVOs(PriCmpbGrpCmdtVO[] priCmpbGrpCmdtVOs) {
		this.priCmpbGrpCmdtVOs = priCmpbGrpCmdtVOs;
	}
	/**
	 * @return the priCmpbGrpCmptDtlVOs
	 */
	public PriCmpbGrpCmdtDtlVO[] getPriCmpbGrpCmptDtlVOs() {
		return priCmpbGrpCmptDtlVOs;
	}
	/**
	 * @param priCmpbGrpCmptDtlVOs the priCmpbGrpCmptDtlVOs to set
	 */
	public void setPriCmpbGrpCmptDtlVOs(PriCmpbGrpCmdtDtlVO[] priCmpbGrpCmptDtlVOs) {
		this.priCmpbGrpCmptDtlVOs = priCmpbGrpCmptDtlVOs;
	}
	/**
	 * @return the priCmpbGrpCmdtVOList
	 */
	public List<PriCmpbGrpCmdtVO> getPriCmpbGrpCmdtVOList() {
		return priCmpbGrpCmdtVOList;
	}
	/**
	 * @param priCmpbGrpCmdtVOList the priCmpbGrpCmdtVOList to set
	 */
	public void setPriCmpbGrpCmdtVOList(List<PriCmpbGrpCmdtVO> priCmpbGrpCmdtVOList) {
		this.priCmpbGrpCmdtVOList = priCmpbGrpCmdtVOList;
	}
	/**
	 * @return the priCmpbGrpCmdtDtlVOList
	 */
	public List<PriCmpbGrpCmdtDtlVO> getPriCmpbGrpCmdtDtlVOList() {
		return priCmpbGrpCmdtDtlVOList;
	}
	/**
	 * @param priCmpbGrpCmdtDtlVOList the priCmpbGrpCmdtDtlVOList to set
	 */
	public void setPriCmpbGrpCmdtDtlVOList(
			List<PriCmpbGrpCmdtDtlVO> priCmpbGrpCmdtDtlVOList) {
		this.priCmpbGrpCmdtDtlVOList = priCmpbGrpCmdtDtlVOList;
	}
	
}