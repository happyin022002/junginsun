package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriCmpbGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocVO;
/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class GroupLocationCmpbGuidelineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";


	/** Table Value Object 단건 Data 처리 */
	private PriCmpbGrpLocVO priCmpbGrpLocVO = null;
	private PriCmpbGrpLocDtlVO priCmpbGrpLocDtlVO = null;
	private RsltPriCmpbGrpLocDtlVO rsltPriCmpbGrpLocDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriCmpbGrpLocVO[] priCmpbGrpLocVOs = null;
	private PriCmpbGrpLocDtlVO[] priCmpbGrpLocDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	List<PriCmpbGrpLocVO> priCmpbGrpLocVOList 	 = new ArrayList<PriCmpbGrpLocVO>();
	List<PriCmpbGrpLocDtlVO> priCmpbGrpLocDtlVOList = new ArrayList<PriCmpbGrpLocDtlVO>();
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
	 * @return the priCmpbGrpLocVO
	 */
	public PriCmpbGrpLocVO getPriCmpbGrpLocVO() {
		return priCmpbGrpLocVO;
	}
	/**
	 * @param priCmpbGrpLocVO the priCmpbGrpLocVO to set
	 */
	public void setPriCmpbGrpLocVO(PriCmpbGrpLocVO priCmpbGrpLocVO) {
		this.priCmpbGrpLocVO = priCmpbGrpLocVO;
	}
	/**
	 * @return the priCmpbGrpLocDtlVO
	 */
	public PriCmpbGrpLocDtlVO getPriCmpbGrpLocDtlVO() {
		return priCmpbGrpLocDtlVO;
	}
	
	/**
	 * @return the rsltPriCmpbGrpLocDtlVO
	 */
	public RsltPriCmpbGrpLocDtlVO getRsltPriCmpbGrpLocDtlVO() {
		return rsltPriCmpbGrpLocDtlVO;
	}
	/**
	 * @param rsltPriCmpbGrpLocDtlVO the rsltPriCmpbGrpLocDtlVO to set
	 */
	public void setRsltPriCmpbGrpLocDtlVO(
			RsltPriCmpbGrpLocDtlVO rsltPriCmpbGrpLocDtlVO) {
		this.rsltPriCmpbGrpLocDtlVO = rsltPriCmpbGrpLocDtlVO;
	}
	/**
	 * @param priCmpbGrpLocDtlVO the priCmpbGrpLocDtlVO to set
	 */
	public void setPriCmpbGrpLocDtlVO(PriCmpbGrpLocDtlVO priCmpbGrpLocDtlVO) {
		this.priCmpbGrpLocDtlVO = priCmpbGrpLocDtlVO;
	}
	/**
	 * @return the priCmpbGrpLocVOs
	 */
	public PriCmpbGrpLocVO[] getPriCmpbGrpLocVOs() {
		return priCmpbGrpLocVOs;
	}
	/**
	 * @param priCmpbGrpLocVOs the priCmpbGrpLocVOs to set
	 */
	public void setPriCmpbGrpLocVOs(PriCmpbGrpLocVO[] priCmpbGrpLocVOs) {
		this.priCmpbGrpLocVOs = priCmpbGrpLocVOs;
	}
	/**
	 * @return the priCmpbGrpLocDtlVOs
	 */
	public PriCmpbGrpLocDtlVO[] getPriCmpbGrpLocDtlVOs() {
		return priCmpbGrpLocDtlVOs;
	}
	/**
	 * @param priCmpbGrpLocDtlVOs the priCmpbGrpLocDtlVOs to set
	 */
	public void setPriCmpbGrpLocDtlVOs(PriCmpbGrpLocDtlVO[] priCmpbGrpLocDtlVOs) {
		this.priCmpbGrpLocDtlVOs = priCmpbGrpLocDtlVOs;
	}
	/**
	 * @return the priCmpbGrpLocVOList
	 */
	public List<PriCmpbGrpLocVO> getPriCmpbGrpLocVOList() {
		return priCmpbGrpLocVOList;
	}
	/**
	 * @param priCmpbGrpLocVOList the priCmpbGrpLocVOList to set
	 */
	public void setPriCmpbGrpLocVOList(List<PriCmpbGrpLocVO> priCmpbGrpLocVOList) {
		this.priCmpbGrpLocVOList = priCmpbGrpLocVOList;
	}
	/**
	 * @return the priCmpbGrpLocDtlVOList
	 */
	public List<PriCmpbGrpLocDtlVO> getPriCmpbGrpLocDtlVOList() {
		return priCmpbGrpLocDtlVOList;
	}
	/**
	 * @param priCmpbGrpLocDtlVOList the priCmpbGrpLocDtlVOList to set
	 */
	public void setPriCmpbGrpLocDtlVOList(
			List<PriCmpbGrpLocDtlVO> priCmpbGrpLocDtlVOList) {
		this.priCmpbGrpLocDtlVOList = priCmpbGrpLocDtlVOList;
	}
	
	
}