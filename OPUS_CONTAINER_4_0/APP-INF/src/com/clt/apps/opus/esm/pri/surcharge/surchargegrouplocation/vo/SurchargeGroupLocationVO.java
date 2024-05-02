package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.PriScgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriScgGrpLocVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class SurchargeGroupLocationVO {
	
	//쉬트별 조회 구분  타이틀:1, 본문:2
	String searchGubun = "";

	//PriScgGrpLoc Max seq
	String maxSeq = "0";
	
	PriScgGrpLocVO priScgGrpLocVO 		  = new PriScgGrpLocVO();
	PriScgGrpLocDtlVO priScgGrpLocDtlVO   = new PriScgGrpLocDtlVO();
	
	List<PriScgGrpLocVO> priScgGrpLocVOList 		= new ArrayList<PriScgGrpLocVO>();
	List<PriScgGrpLocDtlVO> priScgGrpLocDtlVOList   = new ArrayList<PriScgGrpLocDtlVO>();
	
	List<RsltPriScgGrpLocVO> rsltPriScgGrpLocVOList   	    = new ArrayList<RsltPriScgGrpLocVO>();
	
	List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList   = new ArrayList<RsltPriScgGrpLocDtlVO>();
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpLocVO[] priScgGrpLocVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpLocDtlVO[] priScgGrpLocDtlVOs = null;

	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public PriScgGrpLocVO getPriScgGrpLocVO() {
		return priScgGrpLocVO;
	}

	public void setPriScgGrpLocVO(PriScgGrpLocVO priScgGrpLocVO) {
		this.priScgGrpLocVO = priScgGrpLocVO;
	}

	public PriScgGrpLocDtlVO getPriScgGrpLocDtlVO() {
		return priScgGrpLocDtlVO;
	}

	public void setPriScgGrpLocDtlVO(PriScgGrpLocDtlVO priScgGrpLocDtlVO) {
		this.priScgGrpLocDtlVO = priScgGrpLocDtlVO;
	}

	public List<PriScgGrpLocVO> getPriScgGrpLocVOList() {
		return priScgGrpLocVOList;
	}

	public void setPriScgGrpLocVOList(List<PriScgGrpLocVO> priScgGrpLocVOList) {
		this.priScgGrpLocVOList = priScgGrpLocVOList;
	}

	public List<PriScgGrpLocDtlVO> getPriScgGrpLocDtlVOList() {
		return priScgGrpLocDtlVOList;
	}

	public void setPriScgGrpLocDtlVOList(
			List<PriScgGrpLocDtlVO> priScgGrpLocDtlVOList) {
		this.priScgGrpLocDtlVOList = priScgGrpLocDtlVOList;
	}

	public PriScgGrpLocVO[] getPriScgGrpLocVOs() {
		return priScgGrpLocVOs;
	}

	public void setPriScgGrpLocVOs(PriScgGrpLocVO[] priScgGrpLocVOs) {
		this.priScgGrpLocVOs = priScgGrpLocVOs;
	}

	public PriScgGrpLocDtlVO[] getPriScgGrpLocDtlVOs() {
		return priScgGrpLocDtlVOs;
	}

	public void setPriScgGrpLocDtlVOs(PriScgGrpLocDtlVO[] priScgGrpLocDtlVOs) {
		this.priScgGrpLocDtlVOs = priScgGrpLocDtlVOs;
	}

	public List<RsltPriScgGrpLocDtlVO> getRsltPriScgGrpLocDtlVOList() {
		return rsltPriScgGrpLocDtlVOList;
	}

	public void setRsltPriScgGrpLocDtlVOList(
			List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList) {
		this.rsltPriScgGrpLocDtlVOList = rsltPriScgGrpLocDtlVOList;
	}

	public List<RsltPriScgGrpLocVO> getRsltPriScgGrpLocVOList() {
		return rsltPriScgGrpLocVOList;
	}

	public void setRsltPriScgGrpLocVOList(
			List<RsltPriScgGrpLocVO> rsltPriScgGrpLocVOList) {
		this.rsltPriScgGrpLocVOList = rsltPriScgGrpLocVOList;
	}

	public String getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}


	
}