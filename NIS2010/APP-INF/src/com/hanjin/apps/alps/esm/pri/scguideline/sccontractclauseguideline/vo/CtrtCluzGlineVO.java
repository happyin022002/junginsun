package com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzVO;

/**
 * Container Value Object<br>
 * - Table VO들을 전송하는 Container VO<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 */

public class CtrtCluzGlineVO {
	
	//쉬트별 조회 구분 헤더 :1, 타이틀:2, 본문:3
	String searchGubun = "";

	
	List<PriSgCtrtCluzVO> priSgCtrtClusVOList 		= new ArrayList<PriSgCtrtCluzVO>();
	List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList = new ArrayList<PriSgCtrtCluzDtlVO>();

	/** Table Value Object Multi Data 처리 */
	private PriSgCtrtCluzVO priSgCtrtCluzVO = null;
		
	/** Table Value Object Multi Data 처리 */
	private PriSgCtrtCluzVO[] priSgCtrtCluzVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgCtrtCluzDtlVO[] priSgCtrtCluzDtlVOs = null;

	public String getSearchGubun() {
		return searchGubun;
	}

	
	
	public PriSgCtrtCluzVO getPriSgCtrtCluzVO() {
		return priSgCtrtCluzVO;
	}



	public void setPriSgCtrtCluzVO(PriSgCtrtCluzVO priSgCtrtCluzVO) {
		this.priSgCtrtCluzVO = priSgCtrtCluzVO;
	}



	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public List<PriSgCtrtCluzVO> getPriSgCtrtClusVOList() {
		return priSgCtrtClusVOList;
	}

	public void setPriSgCtrtClusVOList(List<PriSgCtrtCluzVO> priSgCtrtClusVOList) {
		this.priSgCtrtClusVOList = priSgCtrtClusVOList;
	}

	public List<PriSgCtrtCluzDtlVO> getPriSgCtrtClusDtlVOList() {
		return priSgCtrtClusDtlVOList;
	}

	public void setPriSgCtrtClusDtlVOList(
			List<PriSgCtrtCluzDtlVO> priSgCtrtClusDtlVOList) {
		this.priSgCtrtClusDtlVOList = priSgCtrtClusDtlVOList;
	}

	public PriSgCtrtCluzVO[] getPriSgCtrtCluzVOs() {
		return priSgCtrtCluzVOs;
	}

	public void setPriSgCtrtCluzVOs(PriSgCtrtCluzVO[] priSgCtrtCluzVOs) {
		this.priSgCtrtCluzVOs = priSgCtrtCluzVOs;
	}

	public PriSgCtrtCluzDtlVO[] getPriSgCtrtCluzDtlVOs() {
		return priSgCtrtCluzDtlVOs;
	}

	public void setPriSgCtrtCluzDtlVOs(PriSgCtrtCluzDtlVO[] priSgCtrtCluzDtlVOs) {
		this.priSgCtrtCluzDtlVOs = priSgCtrtCluzDtlVOs;
	}

	
	
}