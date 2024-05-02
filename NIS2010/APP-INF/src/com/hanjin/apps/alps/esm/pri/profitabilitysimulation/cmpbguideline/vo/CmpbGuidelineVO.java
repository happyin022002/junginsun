package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriCmpbGlineAmtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCustVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutPntVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutViaVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineSvcLaneVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class CmpbGuidelineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";


	/** Table Value Object 단건 Data 처리 */
	private PriCmpbGlineAmtVO priCmpbGlineAmtVO = null;
	private PriCmpbGlineBseVO priCmpbGlineBseVO = null;
	private PriCmpbGlineCmdtVO priCmpbGlineCmdtVO = null;
	private PriCmpbGlineCustVO priCmpbGlineCustVO = null;
	private PriCmpbGlineMnVO priCmpbGlineMnVO = null;
	private PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO = null;
	private PriCmpbGlineRoutPntVO priCmpbGlineRoutPntVO = null;
	private PriCmpbGlineRoutViaVO priCmpbGlineRoutViaVO = null;
	private PriCmpbGlineSvcLaneVO priCmpbGlineSvcLaneVO = null;
	private PriCmpbGrpCmdtDtlVO priCmpbGrpCmdtDtlVO = null;
	private PriCmpbGrpCmdtVO priCmpbGrpCmdtVO = null;
	private PriCmpbGrpLocDtlVO priCmpbGrpLocDtlVO = null;
	private PriCmpbGrpLocVO priCmpbGrpLocVO = null;
	
	private RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO = null;
	
		
	/** Table Value Object Multi Data 처리 */
	private PriCmpbGlineAmtVO[] priCmpbGlineAmtVOs = null;
	private PriCmpbGlineBseVO[] priCmpbGlineBseVOs = null;
	private PriCmpbGlineCmdtVO[] priCmpbGlineCmdtVOs = null;
	private PriCmpbGlineCustVO[] priCmpbGlineCustVOs = null;
	private PriCmpbGlineMnVO[] priCmpbGlineMnVOs = null;
	private PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVOs = null;
	private PriCmpbGlineRoutPntVO[] priCmpbGlineOrgRoutPntVOs = null;
	private PriCmpbGlineRoutViaVO[] priCmpbGlineOrgRoutViaVOs = null;
	private PriCmpbGlineRoutPntVO[] priCmpbGlineDestRoutPntVOs = null;
	private PriCmpbGlineRoutViaVO[] priCmpbGlineDestRoutViaVOs = null;
	private PriCmpbGlineSvcLaneVO[] priCmpbGlineSvcLaneVOs = null;
	private PriCmpbGrpCmdtDtlVO[] priCmpbGrpCmdtDtlVOs = null;
	private PriCmpbGrpCmdtVO[] priCmpbGrpCmdtVOs = null;
	private PriCmpbGrpLocDtlVO[] priCmpbGrpLocDtlVOs = null;
	private PriCmpbGrpLocVO[] priCmpbGrpLocVOs = null;

	
	/** Table Value Object Multi Data 처리 */
	List<RsltPriCmpbGlineAmtVO> priCmpbGlineAmtVOList 					= new ArrayList<RsltPriCmpbGlineAmtVO>();
//	List<RsltPriCmpbGlineBseVO> priCmpbGlineBseVOList 					= new ArrayList<RsltPriCmpbGlineBseVO>();
	List<RsltPriCmpbGlineCmdtVO> priCmpbGlineCmdtVOList 				= new ArrayList<RsltPriCmpbGlineCmdtVO>();
//	List<RsltPriCmpbGlineCustVO> priCmpbGlineCustVOList 				= new ArrayList<RsltPriCmpbGlineCustVO>();
//	List<RsltPriCmpbGlineMnVO> priCmpbGlineMnVOList 					= new ArrayList<RsltPriCmpbGlineMnVO>();
//	List<RsltPriCmpbGlineMqcRngVO> priCmpbGlineMqcRngVOList 			= new ArrayList<RsltPriCmpbGlineMqcRngVO>();
	List<RsltPriCmpbGlineRoutPntVO> priOrgCmpbGlineRoutPntVOList 		= new ArrayList<RsltPriCmpbGlineRoutPntVO>();
	List<RsltPriCmpbGlineRoutPntVO> priDestCmpbGlineRoutPntVOList 		= new ArrayList<RsltPriCmpbGlineRoutPntVO>();
	List<RsltPriCmpbGlineRoutViaVO> priOrgCmpbGlineRoutViaVOList 		= new ArrayList<RsltPriCmpbGlineRoutViaVO>();
	List<RsltPriCmpbGlineRoutViaVO> priDestCmpbGlineRoutViaVOList 		= new ArrayList<RsltPriCmpbGlineRoutViaVO>();
	List<RsltPriCmpbGlineSvcLaneVO> priCmpbGlineSvcLaneVOList 			= new ArrayList<RsltPriCmpbGlineSvcLaneVO>();
	List<RsltPriCmpbGrpCmdtDtlVO> priCmpbGrpCmdtDtlVOList 				= new ArrayList<RsltPriCmpbGrpCmdtDtlVO>();
	List<RsltPriCmpbGrpCmdtVO> priCmpbGrpCmdtVOList 					= new ArrayList<RsltPriCmpbGrpCmdtVO>();
	List<RsltPriCmpbGrpLocDtlVO> priCmpbGrpLocDtlVOList 				= new ArrayList<RsltPriCmpbGrpLocDtlVO>();
	List<RsltPriCmpbGrpLocVO> priCmpbGrpLocVOList						= new ArrayList<RsltPriCmpbGrpLocVO>();
	
	//header
	List<RsltDurationCreationOfficeVO> rsltDurationCreationOfficeVOList 	= new ArrayList<RsltDurationCreationOfficeVO>();
	//base list
	List<RsltPriCmpbGlineBaseListVO> rsltPriCmpbGlineBaseList 	= new ArrayList<RsltPriCmpbGlineBaseListVO>();
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
	 * @return the priCmpbGlineAmtVO
	 */
	public PriCmpbGlineAmtVO getPriCmpbGlineAmtVO() {
		return priCmpbGlineAmtVO;
	}
	/**
	 * @param priCmpbGlineAmtVO the priCmpbGlineAmtVO to set
	 */
	public void setPriCmpbGlineAmtVO(PriCmpbGlineAmtVO priCmpbGlineAmtVO) {
		this.priCmpbGlineAmtVO = priCmpbGlineAmtVO;
	}
	/**
	 * @return the priCmpbGlineBseVO
	 */
	public PriCmpbGlineBseVO getPriCmpbGlineBseVO() {
		return priCmpbGlineBseVO;
	}
	/**
	 * @param priCmpbGlineBseVO the priCmpbGlineBseVO to set
	 */
	public void setPriCmpbGlineBseVO(PriCmpbGlineBseVO priCmpbGlineBseVO) {
		this.priCmpbGlineBseVO = priCmpbGlineBseVO;
	}
	/**
	 * @return the priCmpbGlineCmdtVO
	 */
	public PriCmpbGlineCmdtVO getPriCmpbGlineCmdtVO() {
		return priCmpbGlineCmdtVO;
	}
	/**
	 * @param priCmpbGlineCmdtVO the priCmpbGlineCmdtVO to set
	 */
	public void setPriCmpbGlineCmdtVO(PriCmpbGlineCmdtVO priCmpbGlineCmdtVO) {
		this.priCmpbGlineCmdtVO = priCmpbGlineCmdtVO;
	}
	
	/**
	 * @return the rsltDurationCreationOfficeVO
	 */
	public RsltDurationCreationOfficeVO getRsltDurationCreationOfficeVO() {
		return rsltDurationCreationOfficeVO;
	}
	/**
	 * @param rsltDurationCreationOfficeVO the rsltDurationCreationOfficeVO to set
	 */
	public void setRsltDurationCreationOfficeVO(
			RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) {
		this.rsltDurationCreationOfficeVO = rsltDurationCreationOfficeVO;
	}
	/**
	 * @return the priCmpbGlineCustVO
	 */
	public PriCmpbGlineCustVO getPriCmpbGlineCustVO() {
		return priCmpbGlineCustVO;
	}
	/**
	 * @param priCmpbGlineCustVO the priCmpbGlineCustVO to set
	 */
	public void setPriCmpbGlineCustVO(PriCmpbGlineCustVO priCmpbGlineCustVO) {
		this.priCmpbGlineCustVO = priCmpbGlineCustVO;
	}
	/**
	 * @return the priCmpbGlineMnVO
	 */
	public PriCmpbGlineMnVO getPriCmpbGlineMnVO() {
		return priCmpbGlineMnVO;
	}
	/**
	 * @param priCmpbGlineMnVO the priCmpbGlineMnVO to set
	 */
	public void setPriCmpbGlineMnVO(PriCmpbGlineMnVO priCmpbGlineMnVO) {
		this.priCmpbGlineMnVO = priCmpbGlineMnVO;
	}
	/**
	 * @return the priCmpbGlineMqcRngVO
	 */
	public PriCmpbGlineMqcRngVO getPriCmpbGlineMqcRngVO() {
		return priCmpbGlineMqcRngVO;
	}
	/**
	 * @param priCmpbGlineMqcRngVO the priCmpbGlineMqcRngVO to set
	 */
	public void setPriCmpbGlineMqcRngVO(PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO) {
		this.priCmpbGlineMqcRngVO = priCmpbGlineMqcRngVO;
	}
	/**
	 * @return the priCmpbGlineRoutPntVO
	 */
	public PriCmpbGlineRoutPntVO getPriCmpbGlineRoutPntVO() {
		return priCmpbGlineRoutPntVO;
	}
	/**
	 * @param priCmpbGlineRoutPntVO the priCmpbGlineRoutPntVO to set
	 */
	public void setPriCmpbGlineRoutPntVO(PriCmpbGlineRoutPntVO priCmpbGlineRoutPntVO) {
		this.priCmpbGlineRoutPntVO = priCmpbGlineRoutPntVO;
	}
	/**
	 * @return the priCmpbGlineRoutViaVO
	 */
	public PriCmpbGlineRoutViaVO getPriCmpbGlineRoutViaVO() {
		return priCmpbGlineRoutViaVO;
	}
	/**
	 * @param priCmpbGlineRoutViaVO the priCmpbGlineRoutViaVO to set
	 */
	public void setPriCmpbGlineRoutViaVO(PriCmpbGlineRoutViaVO priCmpbGlineRoutViaVO) {
		this.priCmpbGlineRoutViaVO = priCmpbGlineRoutViaVO;
	}
	/**
	 * @return the priCmpbGlineSvcLaneVO
	 */
	public PriCmpbGlineSvcLaneVO getPriCmpbGlineSvcLaneVO() {
		return priCmpbGlineSvcLaneVO;
	}
	/**
	 * @param priCmpbGlineSvcLaneVO the priCmpbGlineSvcLaneVO to set
	 */
	public void setPriCmpbGlineSvcLaneVO(PriCmpbGlineSvcLaneVO priCmpbGlineSvcLaneVO) {
		this.priCmpbGlineSvcLaneVO = priCmpbGlineSvcLaneVO;
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
	 * @return the priCmpbGrpLocDtlVO
	 */
	public PriCmpbGrpLocDtlVO getPriCmpbGrpLocDtlVO() {
		return priCmpbGrpLocDtlVO;
	}
	/**
	 * @param priCmpbGrpLocDtlVO the priCmpbGrpLocDtlVO to set
	 */
	public void setPriCmpbGrpLocDtlVO(PriCmpbGrpLocDtlVO priCmpbGrpLocDtlVO) {
		this.priCmpbGrpLocDtlVO = priCmpbGrpLocDtlVO;
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
	 * @return the priCmpbGlineAmtVOs
	 */
	public PriCmpbGlineAmtVO[] getPriCmpbGlineAmtVOs() {
		return priCmpbGlineAmtVOs;
	}
	/**
	 * @param priCmpbGlineAmtVOs the priCmpbGlineAmtVOs to set
	 */
	public void setPriCmpbGlineAmtVOs(PriCmpbGlineAmtVO[] priCmpbGlineAmtVOs) {
		this.priCmpbGlineAmtVOs = priCmpbGlineAmtVOs;
	}
	/**
	 * @return the priCmpbGlineBseVOs
	 */
	public PriCmpbGlineBseVO[] getPriCmpbGlineBseVOs() {
		return priCmpbGlineBseVOs;
	}
	/**
	 * @param priCmpbGlineBseVOs the priCmpbGlineBseVOs to set
	 */
	public void setPriCmpbGlineBseVOs(PriCmpbGlineBseVO[] priCmpbGlineBseVOs) {
		this.priCmpbGlineBseVOs = priCmpbGlineBseVOs;
	}
	/**
	 * @return the priCmpbGlineCmdtVOs
	 */
	public PriCmpbGlineCmdtVO[] getPriCmpbGlineCmdtVOs() {
		return priCmpbGlineCmdtVOs;
	}
	/**
	 * @param priCmpbGlineCmdtVOs the priCmpbGlineCmdtVOs to set
	 */
	public void setPriCmpbGlineCmdtVOs(PriCmpbGlineCmdtVO[] priCmpbGlineCmdtVOs) {
		this.priCmpbGlineCmdtVOs = priCmpbGlineCmdtVOs;
	}
	/**
	 * @return the priCmpbGlineCustVOs
	 */
	public PriCmpbGlineCustVO[] getPriCmpbGlineCustVOs() {
		return priCmpbGlineCustVOs;
	}
	/**
	 * @param priCmpbGlineCustVOs the priCmpbGlineCustVOs to set
	 */
	public void setPriCmpbGlineCustVOs(PriCmpbGlineCustVO[] priCmpbGlineCustVOs) {
		this.priCmpbGlineCustVOs = priCmpbGlineCustVOs;
	}
	/**
	 * @return the priCmpbGlineMnVOs
	 */
	public PriCmpbGlineMnVO[] getPriCmpbGlineMnVOs() {
		return priCmpbGlineMnVOs;
	}
	/**
	 * @param priCmpbGlineMnVOs the priCmpbGlineMnVOs to set
	 */
	public void setPriCmpbGlineMnVOs(PriCmpbGlineMnVO[] priCmpbGlineMnVOs) {
		this.priCmpbGlineMnVOs = priCmpbGlineMnVOs;
	}
	/**
	 * @return the priCmpbGlineMqcRngVOs
	 */
	public PriCmpbGlineMqcRngVO[] getPriCmpbGlineMqcRngVOs() {
		return priCmpbGlineMqcRngVOs;
	}
	/**
	 * @param priCmpbGlineMqcRngVOs the priCmpbGlineMqcRngVOs to set
	 */
	public void setPriCmpbGlineMqcRngVOs(
			PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVOs) {
		this.priCmpbGlineMqcRngVOs = priCmpbGlineMqcRngVOs;
	}
	
	/**
	 * @return the priCmpbGlineOrgRoutPntVOs
	 */
	public PriCmpbGlineRoutPntVO[] getPriCmpbGlineOrgRoutPntVOs() {
		return priCmpbGlineOrgRoutPntVOs;
	}
	/**
	 * @param priCmpbGlineOrgRoutPntVOs the priCmpbGlineOrgRoutPntVOs to set
	 */
	public void setPriCmpbGlineOrgRoutPntVOs(
			PriCmpbGlineRoutPntVO[] priCmpbGlineOrgRoutPntVOs) {
		this.priCmpbGlineOrgRoutPntVOs = priCmpbGlineOrgRoutPntVOs;
	}
	/**
	 * @return the priCmpbGlineOrgRoutViaVOs
	 */
	public PriCmpbGlineRoutViaVO[] getPriCmpbGlineOrgRoutViaVOs() {
		return priCmpbGlineOrgRoutViaVOs;
	}
	/**
	 * @param priCmpbGlineOrgRoutViaVOs the priCmpbGlineOrgRoutViaVOs to set
	 */
	public void setPriCmpbGlineOrgRoutViaVOs(
			PriCmpbGlineRoutViaVO[] priCmpbGlineOrgRoutViaVOs) {
		this.priCmpbGlineOrgRoutViaVOs = priCmpbGlineOrgRoutViaVOs;
	}
	/**
	 * @return the priCmpbGlineDestRoutPntVOs
	 */
	public PriCmpbGlineRoutPntVO[] getPriCmpbGlineDestRoutPntVOs() {
		return priCmpbGlineDestRoutPntVOs;
	}
	/**
	 * @param priCmpbGlineDestRoutPntVOs the priCmpbGlineDestRoutPntVOs to set
	 */
	public void setPriCmpbGlineDestRoutPntVOs(
			PriCmpbGlineRoutPntVO[] priCmpbGlineDestRoutPntVOs) {
		this.priCmpbGlineDestRoutPntVOs = priCmpbGlineDestRoutPntVOs;
	}
	/**
	 * @return the priCmpbGlineDestRoutViaVOs
	 */
	public PriCmpbGlineRoutViaVO[] getPriCmpbGlineDestRoutViaVOs() {
		return priCmpbGlineDestRoutViaVOs;
	}
	/**
	 * @param priCmpbGlineDestRoutViaVOs the priCmpbGlineDestRoutViaVOs to set
	 */
	public void setPriCmpbGlineDestRoutViaVOs(
			PriCmpbGlineRoutViaVO[] priCmpbGlineDestRoutViaVOs) {
		this.priCmpbGlineDestRoutViaVOs = priCmpbGlineDestRoutViaVOs;
	}
	/**
	 * @return the priCmpbGlineSvcLaneVOs
	 */
	public PriCmpbGlineSvcLaneVO[] getPriCmpbGlineSvcLaneVOs() {
		return priCmpbGlineSvcLaneVOs;
	}
	/**
	 * @param priCmpbGlineSvcLaneVOs the priCmpbGlineSvcLaneVOs to set
	 */
	public void setPriCmpbGlineSvcLaneVOs(
			PriCmpbGlineSvcLaneVO[] priCmpbGlineSvcLaneVOs) {
		this.priCmpbGlineSvcLaneVOs = priCmpbGlineSvcLaneVOs;
	}
	/**
	 * @return the priCmpbGrpCmdtDtlVOs
	 */
	public PriCmpbGrpCmdtDtlVO[] getPriCmpbGrpCmdtDtlVOs() {
		return priCmpbGrpCmdtDtlVOs;
	}
	/**
	 * @param priCmpbGrpCmdtDtlVOs the priCmpbGrpCmdtDtlVOs to set
	 */
	public void setPriCmpbGrpCmdtDtlVOs(PriCmpbGrpCmdtDtlVO[] priCmpbGrpCmdtDtlVOs) {
		this.priCmpbGrpCmdtDtlVOs = priCmpbGrpCmdtDtlVOs;
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
	 * @return the priCmpbGlineAmtVOList
	 */
	public List<RsltPriCmpbGlineAmtVO> getPriCmpbGlineAmtVOList() {
		return priCmpbGlineAmtVOList;
	}
	/**
	 * @param priCmpbGlineAmtVOList the priCmpbGlineAmtVOList to set
	 */
	public void setPriCmpbGlineAmtVOList(
			List<RsltPriCmpbGlineAmtVO> priCmpbGlineAmtVOList) {
		this.priCmpbGlineAmtVOList = priCmpbGlineAmtVOList;
	}
	/**
	 * @return the priCmpbGlineCmdtVOList
	 */
	public List<RsltPriCmpbGlineCmdtVO> getPriCmpbGlineCmdtVOList() {
		return priCmpbGlineCmdtVOList;
	}
	/**
	 * @param priCmpbGlineCmdtVOList the priCmpbGlineCmdtVOList to set
	 */
	public void setPriCmpbGlineCmdtVOList(
			List<RsltPriCmpbGlineCmdtVO> priCmpbGlineCmdtVOList) {
		this.priCmpbGlineCmdtVOList = priCmpbGlineCmdtVOList;
	}
	/**
	 * @return the priOrgCmpbGlineRoutPntVOList
	 */
	public List<RsltPriCmpbGlineRoutPntVO> getPriOrgCmpbGlineRoutPntVOList() {
		return priOrgCmpbGlineRoutPntVOList;
	}
	/**
	 * @param priOrgCmpbGlineRoutPntVOList the priOrgCmpbGlineRoutPntVOList to set
	 */
	public void setPriOrgCmpbGlineRoutPntVOList(
			List<RsltPriCmpbGlineRoutPntVO> priOrgCmpbGlineRoutPntVOList) {
		this.priOrgCmpbGlineRoutPntVOList = priOrgCmpbGlineRoutPntVOList;
	}
	
	/**
	 * @return the priDestCmpbGlineRoutPntVOList
	 */
	public List<RsltPriCmpbGlineRoutPntVO> getPriDestCmpbGlineRoutPntVOList() {
		return priDestCmpbGlineRoutPntVOList;
	}
	/**
	 * @param priDestCmpbGlineRoutPntVOList the priDestCmpbGlineRoutPntVOList to set
	 */
	public void setPriDestCmpbGlineRoutPntVOList(
			List<RsltPriCmpbGlineRoutPntVO> priDestCmpbGlineRoutPntVOList) {
		this.priDestCmpbGlineRoutPntVOList = priDestCmpbGlineRoutPntVOList;
	}
	/**
	 * @return the priOrgCmpbGlineRoutViaVOList
	 */
	public List<RsltPriCmpbGlineRoutViaVO> getPriOrgCmpbGlineRoutViaVOList() {
		return priOrgCmpbGlineRoutViaVOList;
	}
	/**
	 * @param priOrgCmpbGlineRoutViaVOList the priOrgCmpbGlineRoutViaVOList to set
	 */
	public void setPriOrgCmpbGlineRoutViaVOList(
			List<RsltPriCmpbGlineRoutViaVO> priOrgCmpbGlineRoutViaVOList) {
		this.priOrgCmpbGlineRoutViaVOList = priOrgCmpbGlineRoutViaVOList;
	}
	/**
	 * @return the priDestCmpbGlineRoutViaVOList
	 */
	public List<RsltPriCmpbGlineRoutViaVO> getPriDestCmpbGlineRoutViaVOList() {
		return priDestCmpbGlineRoutViaVOList;
	}
	/**
	 * @param priDestCmpbGlineRoutViaVOList the priDestCmpbGlineRoutViaVOList to set
	 */
	public void setPriDestCmpbGlineRoutViaVOList(
			List<RsltPriCmpbGlineRoutViaVO> priDestCmpbGlineRoutViaVOList) {
		this.priDestCmpbGlineRoutViaVOList = priDestCmpbGlineRoutViaVOList;
	}
	/**
	 * @return the priCmpbGlineSvcLaneVOList
	 */
	public List<RsltPriCmpbGlineSvcLaneVO> getPriCmpbGlineSvcLaneVOList() {
		return priCmpbGlineSvcLaneVOList;
	}
	/**
	 * @param priCmpbGlineSvcLaneVOList the priCmpbGlineSvcLaneVOList to set
	 */
	public void setPriCmpbGlineSvcLaneVOList(
			List<RsltPriCmpbGlineSvcLaneVO> priCmpbGlineSvcLaneVOList) {
		this.priCmpbGlineSvcLaneVOList = priCmpbGlineSvcLaneVOList;
	}
	/**
	 * @return the priCmpbGrpCmdtDtlVOList
	 */
	public List<RsltPriCmpbGrpCmdtDtlVO> getPriCmpbGrpCmdtDtlVOList() {
		return priCmpbGrpCmdtDtlVOList;
	}
	/**
	 * @param priCmpbGrpCmdtDtlVOList the priCmpbGrpCmdtDtlVOList to set
	 */
	public void setPriCmpbGrpCmdtDtlVOList(
			List<RsltPriCmpbGrpCmdtDtlVO> priCmpbGrpCmdtDtlVOList) {
		this.priCmpbGrpCmdtDtlVOList = priCmpbGrpCmdtDtlVOList;
	}
	/**
	 * @return the priCmpbGrpCmdtVOList
	 */
	public List<RsltPriCmpbGrpCmdtVO> getPriCmpbGrpCmdtVOList() {
		return priCmpbGrpCmdtVOList;
	}
	/**
	 * @param priCmpbGrpCmdtVOList the priCmpbGrpCmdtVOList to set
	 */
	public void setPriCmpbGrpCmdtVOList(
			List<RsltPriCmpbGrpCmdtVO> priCmpbGrpCmdtVOList) {
		this.priCmpbGrpCmdtVOList = priCmpbGrpCmdtVOList;
	}
	/**
	 * @return the priCmpbGrpLocDtlVOList
	 */
	public List<RsltPriCmpbGrpLocDtlVO> getPriCmpbGrpLocDtlVOList() {
		return priCmpbGrpLocDtlVOList;
	}
	/**
	 * @param priCmpbGrpLocDtlVOList the priCmpbGrpLocDtlVOList to set
	 */
	public void setPriCmpbGrpLocDtlVOList(
			List<RsltPriCmpbGrpLocDtlVO> priCmpbGrpLocDtlVOList) {
		this.priCmpbGrpLocDtlVOList = priCmpbGrpLocDtlVOList;
	}
	/**
	 * @return the priCmpbGrpLocVOList
	 */
	public List<RsltPriCmpbGrpLocVO> getPriCmpbGrpLocVOList() {
		return priCmpbGrpLocVOList;
	}
	/**
	 * @param priCmpbGrpLocVOList the priCmpbGrpLocVOList to set
	 */
	public void setPriCmpbGrpLocVOList(List<RsltPriCmpbGrpLocVO> priCmpbGrpLocVOList) {
		this.priCmpbGrpLocVOList = priCmpbGrpLocVOList;
	}
	/**
	 * @return the rsltDurationCreationOfficeVOList
	 */
	public List<RsltDurationCreationOfficeVO> getRsltDurationCreationOfficeVOList() {
		return rsltDurationCreationOfficeVOList;
	}
	/**
	 * @param rsltDurationCreationOfficeVOList the rsltDurationCreationOfficeVOList to set
	 */
	public void setRsltDurationCreationOfficeVOList(
			List<RsltDurationCreationOfficeVO> rsltDurationCreationOfficeVOList) {
		this.rsltDurationCreationOfficeVOList = rsltDurationCreationOfficeVOList;
	}
	/**
	 * @return the rsltPriCmpbGlineBaseList
	 */
	public List<RsltPriCmpbGlineBaseListVO> getRsltPriCmpbGlineBaseList() {
		return rsltPriCmpbGlineBaseList;
	}
	/**
	 * @param rsltPriCmpbGlineBaseList the rsltPriCmpbGlineBaseList to set
	 */
	public void setRsltPriCmpbGlineBaseList(
			List<RsltPriCmpbGlineBaseListVO> rsltPriCmpbGlineBaseList) {
		this.rsltPriCmpbGlineBaseList = rsltPriCmpbGlineBaseList;
	}
	
	
	
	
}