/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_076Event.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-09-22 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event;

import java.util.Arrays;
import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsDmstLstCtyVO;


/**
 * ESD_TRS_076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0076Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** TrsDmstLstCtyVO Table  Value Object */
	private TrsDmstLstCtyVO trsDmstLstCtyVo = null;

	/** trs_dmst_lst_ctys Multi Action을 위한 Collection */
	private TrsDmstLstCtyVO[] trsDmstLstCtyVos = null;

	/** ESD_TRS_076Event */
	public EsdTrs0076Event(){}

	/** getTrsDmstLstCtyVO */
	public TrsDmstLstCtyVO getTrsDmstLstCtyVO(){
		return trsDmstLstCtyVo;
	}
	
	/** setTrsDmstLstCtyVO */
	public void setTrsDmstLstCtyVO(TrsDmstLstCtyVO trsDmstLstCtyVo){
		this.trsDmstLstCtyVo = trsDmstLstCtyVo;
	}
	
	/** getTrsDmstLstCtyVos */
	public TrsDmstLstCtyVO[] getTrsDmstLstCtyVos() {
		TrsDmstLstCtyVO[] rtnVOs = null;
		if (this.trsDmstLstCtyVos != null) {
			rtnVOs = Arrays.copyOf(trsDmstLstCtyVos, trsDmstLstCtyVos.length);
		} // end if
		return rtnVOs;
	}

	/** setTrsDmstLstCtyVos */
	public void setTrsDmstLstCtyVos(TrsDmstLstCtyVO[] trsDmstLstCtyVos) {
		if (trsDmstLstCtyVos != null) {
			TrsDmstLstCtyVO[] tmpVOs = Arrays.copyOf(trsDmstLstCtyVos, trsDmstLstCtyVos.length);
			this.trsDmstLstCtyVos = tmpVOs;
		} // end if
	}
	
	//2010 변환작업 시작
	private String searchStr = null;
	private String userId1 = null;
	private String today1 = null;
	private String userId2 = null;
	private String today2 = null;
	private String stsVal = null;
	
	public String getSearchStr() {
		return searchStr;
	}
	
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}	
	
	public String getUserId1() {
		return userId1;
	}

	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}

	public String getToday1() {
		return today1;
	}

	public void setToday1(String today1) {
		this.today1 = today1;
	}

	public String getUserId2() {
		return userId2;
	}

	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}

	public String getToday2() {
		return today2;
	}

	public void setToday2(String today2) {
		this.today2 = today2;
	}	

	public String getStsVal() {
		return stsVal;
	}

	public void setStsVal(String stsVal) {
		this.stsVal = stsVal;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("searchStr", getSearchStr());
		this.hashColumns.put("userId1", getUserId1());
		this.hashColumns.put("userId2", getUserId2());
		this.hashColumns.put("today1", getToday1());
		this.hashColumns.put("today2", getToday2());
		this.hashColumns.put("stsVal", getStsVal());
		return this.hashColumns;
	}
	
	public String getEventName() {
		return "EsdTrs0076Event";
	}
	
	public String toString() {
		return "EsdTrs0076Event";
	}
	
	// 2015.06.02	CHAN WOO PARK
	// USA/CA CY&Door S/O Creation USA Last City Combo용
	private String trspCostDtlModCd;
	private String orgLocCd;
	private String destLocCd;

	public String getTrspCostDtlModCd() {
		return trspCostDtlModCd;
	}

	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	public String getOrgLocCd() {
		return orgLocCd;
	}

	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}

	public String getDestLocCd() {
		return destLocCd;
	}

	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}

}
