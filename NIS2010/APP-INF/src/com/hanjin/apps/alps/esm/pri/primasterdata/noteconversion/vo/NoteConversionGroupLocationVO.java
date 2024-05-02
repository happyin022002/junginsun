package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriNoteConvGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class NoteConversionGroupLocationVO {
	
	//쉬트별 조회 구분  타이틀:1, 본문:2
	String searchGubun = "";
	
	PriNoteConvGrpLocVO priNoteConvGrpLocVO 		  = new PriNoteConvGrpLocVO();
	PriNoteConvGrpLocDtlVO priNoteConvGrpLocDtlVO   = new PriNoteConvGrpLocDtlVO();
	
	List<PriNoteConvGrpLocVO> priNoteConvGrpLocVOList 		= new ArrayList<PriNoteConvGrpLocVO>();
	List<PriNoteConvGrpLocDtlVO> priNoteConvGrpLocDtlVOList   = new ArrayList<PriNoteConvGrpLocDtlVO>();
	
	List<RsltPriNoteConvGrpLocVO> rsltPriNoteConvGrpLocVOList   	    = new ArrayList<RsltPriNoteConvGrpLocVO>();
	
	List<RsltPriNoteConvGrpLocDtlVO> rsltPriNoteConvGrpLocDtlVOList   = new ArrayList<RsltPriNoteConvGrpLocDtlVO>();
	
	/** Table Value Object Multi Data 처리 */
	private PriNoteConvGrpLocVO[] priNoteConvGrpLocVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriNoteConvGrpLocDtlVO[] priNoteConvGrpLocDtlVOs = null;

	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public PriNoteConvGrpLocVO getPriNoteConvGrpLocVO() {
		return priNoteConvGrpLocVO;
	}

	public void setPriNoteConvGrpLocVO(PriNoteConvGrpLocVO priNoteConvGrpLocVO) {
		this.priNoteConvGrpLocVO = priNoteConvGrpLocVO;
	}

	public PriNoteConvGrpLocDtlVO getPriNoteConvGrpLocDtlVO() {
		return priNoteConvGrpLocDtlVO;
	}

	public void setPriNoteConvGrpLocDtlVO(PriNoteConvGrpLocDtlVO priNoteConvGrpLocDtlVO) {
		this.priNoteConvGrpLocDtlVO = priNoteConvGrpLocDtlVO;
	}

	public List<PriNoteConvGrpLocVO> getPriNoteConvGrpLocVOList() {
		return priNoteConvGrpLocVOList;
	}

	public void setPriNoteConvGrpLocVOList(List<PriNoteConvGrpLocVO> priNoteConvGrpLocVOList) {
		this.priNoteConvGrpLocVOList = priNoteConvGrpLocVOList;
	}

	public List<PriNoteConvGrpLocDtlVO> getPriNoteConvGrpLocDtlVOList() {
		return priNoteConvGrpLocDtlVOList;
	}

	public void setPriNoteConvGrpLocDtlVOList(
			List<PriNoteConvGrpLocDtlVO> priNoteConvGrpLocDtlVOList) {
		this.priNoteConvGrpLocDtlVOList = priNoteConvGrpLocDtlVOList;
	}

	public PriNoteConvGrpLocVO[] getPriNoteConvGrpLocVOs() {
		return priNoteConvGrpLocVOs;
	}

	public void setPriNoteConvGrpLocVOs(PriNoteConvGrpLocVO[] priNoteConvGrpLocVOs) {
		this.priNoteConvGrpLocVOs = priNoteConvGrpLocVOs;
	}

	public PriNoteConvGrpLocDtlVO[] getPriNoteConvGrpLocDtlVOs() {
		return priNoteConvGrpLocDtlVOs;
	}

	public void setPriNoteConvGrpLocDtlVOs(PriNoteConvGrpLocDtlVO[] priNoteConvGrpLocDtlVOs) {
		this.priNoteConvGrpLocDtlVOs = priNoteConvGrpLocDtlVOs;
	}

	public List<RsltPriNoteConvGrpLocDtlVO> getRsltPriNoteConvGrpLocDtlVOList() {
		return rsltPriNoteConvGrpLocDtlVOList;
	}

	public void setRsltPriNoteConvGrpLocDtlVOList(
			List<RsltPriNoteConvGrpLocDtlVO> rsltPriNoteConvGrpLocDtlVOList) {
		this.rsltPriNoteConvGrpLocDtlVOList = rsltPriNoteConvGrpLocDtlVOList;
	}

	public List<RsltPriNoteConvGrpLocVO> getRsltPriNoteConvGrpLocVOList() {
		return rsltPriNoteConvGrpLocVOList;
	}

	public void setRsltPriNoteConvGrpLocVOList(
			List<RsltPriNoteConvGrpLocVO> rsltPriNoteConvGrpLocVOList) {
		this.rsltPriNoteConvGrpLocVOList = rsltPriNoteConvGrpLocVOList;
	}	
}