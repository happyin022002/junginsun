package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class CommonGroupCommodityVO {
	
	//쉬트별 조회 구분  타이틀:1, 본문:2
	String searchGubun = "";

	//맥스 시퀀스
	String maxSeq = "0";
	
	PriScgGrpCmdtVO priScgGrpCmdtVO 		  = new PriScgGrpCmdtVO();
	PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO     = new PriScgGrpCmdtDtlVO();
	
	List<PriScgGrpCmdtVO> priScgGrpCmdtVOList 			= new ArrayList<PriScgGrpCmdtVO>();
	List<PriScgGrpCmdtDtlVO> priScgGrpCmdtDtlVOList     = new ArrayList<PriScgGrpCmdtDtlVO>();
	
	List<RsltPriScgGrpCmdtDtlVO> rsltPriScgGrpCmdtDtlVOList   = new ArrayList<RsltPriScgGrpCmdtDtlVO>();
	
	List<RsltPriComGrpCmdtExcelVO> rsltPriComGrpCmdtExcelVO   = new ArrayList<RsltPriComGrpCmdtExcelVO>();
	
	
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpCmdtVO[] priScgGrpCmdtVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs = null;

	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public PriScgGrpCmdtVO getPriScgGrpCmdtVO() {
		return priScgGrpCmdtVO;
	}

	public void setPriScgGrpCmdtVO(PriScgGrpCmdtVO priScgGrpCmdtVO) {
		this.priScgGrpCmdtVO = priScgGrpCmdtVO;
	}

	public PriScgGrpCmdtDtlVO getPriScgGrpCmdtDtlVO() {
		return priScgGrpCmdtDtlVO;
	}

	public void setPriScgGrpCmdtDtlVO(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO) {
		this.priScgGrpCmdtDtlVO = priScgGrpCmdtDtlVO;
	}

	public List<PriScgGrpCmdtVO> getPriScgGrpCmdtVOList() {
		return priScgGrpCmdtVOList;
	}

	public void setPriScgGrpCmdtVOList(List<PriScgGrpCmdtVO> priScgGrpCmdtVOList) {
		this.priScgGrpCmdtVOList = priScgGrpCmdtVOList;
	}

	public List<PriScgGrpCmdtDtlVO> getPriScgGrpCmdtDtlVOList() {
		return priScgGrpCmdtDtlVOList;
	}

	public void setPriScgGrpCmdtDtlVOList(
			List<PriScgGrpCmdtDtlVO> priScgGrpCmdtDtlVOList) {
		this.priScgGrpCmdtDtlVOList = priScgGrpCmdtDtlVOList;
	}

	public List<RsltPriScgGrpCmdtDtlVO> getRsltPriScgGrpCmdtDtlVOList() {
		return rsltPriScgGrpCmdtDtlVOList;
	}

	public void setRsltPriScgGrpCmdtDtlVOList(
			List<RsltPriScgGrpCmdtDtlVO> rsltPriScgGrpCmdtDtlVOList) {
		this.rsltPriScgGrpCmdtDtlVOList = rsltPriScgGrpCmdtDtlVOList;
	}

	public PriScgGrpCmdtVO[] getPriScgGrpCmdtVOs() {
		return priScgGrpCmdtVOs;
	}

	public void setPriScgGrpCmdtVOs(PriScgGrpCmdtVO[] priScgGrpCmdtVOs) {
		this.priScgGrpCmdtVOs = priScgGrpCmdtVOs;
	}

	public PriScgGrpCmdtDtlVO[] getPriScgGrpCmdtDtlVOs() {
		return priScgGrpCmdtDtlVOs;
	}

	public void setPriScgGrpCmdtDtlVOs(PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs) {
		this.priScgGrpCmdtDtlVOs = priScgGrpCmdtDtlVOs;
	}

	public String getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}

	public List<RsltPriComGrpCmdtExcelVO> getRsltPriComGrpCmdtExcelVO() {
		return rsltPriComGrpCmdtExcelVO;
	}

	public void setRsltPriComGrpCmdtExcelVO(
			List<RsltPriComGrpCmdtExcelVO> rsltPriComGrpCmdtExcelVO) {
		this.rsltPriComGrpCmdtExcelVO = rsltPriComGrpCmdtExcelVO;
	}

	
}