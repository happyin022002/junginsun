package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriSgBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class ScBlplGlineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";

	
	List<PriSgBlplHdrVO> priSgBlplHdrVOList 	= new ArrayList<PriSgBlplHdrVO>();
	List<PriSgBlplVO> priSgBlplVOList 			= new ArrayList<PriSgBlplVO>();
	List<PriSgBlplCtntVO> priSgBlplCtntVOList   = new ArrayList<PriSgBlplCtntVO>();
	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgBlplHdrVO priSgBlplHdrVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgBlplVO priSgBlplVO = null;
	

	/** Table Value Object Multi Data 처리 */
	private PriSgBlplVO[] priSgBlplVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgBlplCtntVO[] priSgBlplCtntVOs = null;

	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public List<PriSgBlplHdrVO> getPriSgBlplHdrVOList() {
		return priSgBlplHdrVOList;
	}

	public void setPriSgBlplHdrVOList(List<PriSgBlplHdrVO> priSgBlplHdrVOList) {
		this.priSgBlplHdrVOList = priSgBlplHdrVOList;
	}

	public List<PriSgBlplVO> getPriSgBlplVOList() {
		return priSgBlplVOList;
	}

	public void setPriSgBlplVOList(List<PriSgBlplVO> priSgBlplVOList) {
		this.priSgBlplVOList = priSgBlplVOList;
	}

	public List<PriSgBlplCtntVO> getPriSgBlplCtntVOList() {
		return priSgBlplCtntVOList;
	}

	public void setPriSgBlplCtntVOList(List<PriSgBlplCtntVO> priSgBlplCtntVOList) {
		this.priSgBlplCtntVOList = priSgBlplCtntVOList;
	}


	

	public PriSgBlplVO getPriSgBlplVO() {
		return priSgBlplVO;
	}

	public void setPriSgBlplVO(PriSgBlplVO priSgBlplVO) {
		this.priSgBlplVO = priSgBlplVO;
	}

	public PriSgBlplHdrVO getPriSgBlplHdrVO() {
		return priSgBlplHdrVO;
	}

	public void setPriSgBlplHdrVO(PriSgBlplHdrVO priSgBlplHdrVO) {
		this.priSgBlplHdrVO = priSgBlplHdrVO;
	}

	public PriSgBlplVO[] getPriSgBlplVOs() {
		return priSgBlplVOs;
	}

	public void setPriSgBlplVOs(PriSgBlplVO[] priSgBlplVOs) {
		this.priSgBlplVOs = priSgBlplVOs;
	}

	public PriSgBlplCtntVO[] getPriSgBlplCtntVOs() {
		return priSgBlplCtntVOs;
	}

	public void setPriSgBlplCtntVOs(PriSgBlplCtntVO[] priSgBlplCtntVOs) {
		this.priSgBlplCtntVOs = priSgBlplCtntVOs;
	}

	
	
}