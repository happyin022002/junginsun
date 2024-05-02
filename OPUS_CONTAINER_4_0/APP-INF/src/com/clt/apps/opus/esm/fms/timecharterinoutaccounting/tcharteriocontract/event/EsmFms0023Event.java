/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0023Event.java
*@FileTitle : SearchContracNoList
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.25 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0023HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** vslCd VesselCode  */
	private String vslCd = "";

	/** fletCtrtNo 계약번호  */
	private String fletCtrtNo = "";
	
	/** fletCtrtTpCd Contract Type  */
	private String fletCtrtTpCd = "";
	
	/** 계약 화면인지 판다(Y)  */
	private String ctrtFlag = "";
	
	/** Contract Type  */
	private String typeFlag = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContracNoListByVesselVO searchcontracnolistbyvesselvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchContracNoListByVesselVO[] searchcontracnolistbyvesselvos = null;

	public EsmFms0023Event(){}
	
	public void setSearchContracNoListByVesselVO(SearchContracNoListByVesselVO searchcontracnolistbyvesselvo){
		this. searchcontracnolistbyvesselvo = searchcontracnolistbyvesselvo;
	}

	public void setSearchContracNoListByVesselVOS(SearchContracNoListByVesselVO[] searchcontracnolistbyvesselvos){
		if (searchcontracnolistbyvesselvos != null) {
			SearchContracNoListByVesselVO[] tmpVOs = new SearchContracNoListByVesselVO[searchcontracnolistbyvesselvos.length];
			System.arraycopy(searchcontracnolistbyvesselvos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchcontracnolistbyvesselvos = tmpVOs;
		}
	}
		   
	public SearchContracNoListByVesselVO getSearchContracNoListByVesselVO(){
		return searchcontracnolistbyvesselvo;
	}

	public SearchContracNoListByVesselVO[] getSearchContracNoListByVesselVOS(){
		SearchContracNoListByVesselVO[] tmpVOs = null;
		if (this.searchcontracnolistbyvesselvos != null) {
			tmpVOs = new SearchContracNoListByVesselVO[searchcontracnolistbyvesselvos.length];
			System.arraycopy(searchcontracnolistbyvesselvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getFletCtrtTpCd() {
		return fletCtrtTpCd;
	}

	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	 
	public String getCtrtFlag() {
		return ctrtFlag;
	}

	public void setCtrtFlag(String ctrtFlag) {
		this.ctrtFlag = ctrtFlag;
	}
	
	public String getTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}

}