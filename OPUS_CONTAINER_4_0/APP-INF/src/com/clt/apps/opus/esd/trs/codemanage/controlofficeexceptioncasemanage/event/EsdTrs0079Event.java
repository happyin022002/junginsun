/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_079Event.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : poong
*@LastVersion : 1.0 
* 2006-09-27 poong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event;

import java.util.Arrays;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.vo.ControlOfficeExceptionSearchConditionVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspOfcExptRule2VO;
import com.clt.syscommon.common.table.TrsTrspOfcExptRuleVO;

/**
 * ESD_TRS_079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0079Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** trs_trsp_cmdt_grp Table  Value Object */
	private TrsTrspOfcExptRuleVO trsTrspOfcExptRuleVO = null;
	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private TrsTrspOfcExptRuleVO[] trsTrspOfcExptRuleVOs = null;

	/** trs_trsp_cmdt_grp Table  Value Object */
	private TrsTrspOfcExptRule2VO trsTrspOfcExptRule2VO = null;
	/** trs_trsp_cmdt_grps Multi Action을 위한 Collection */
	private TrsTrspOfcExptRule2VO[] trsTrspOfcExptRule2VOs = null;
	
	private ControlOfficeExceptionSearchConditionVO controlOfficeExceptionSearchConditionVO = null;

	/** getTrsTrspOfcExptRuleVO*/
	public TrsTrspOfcExptRuleVO getTrsTrspOfcExptRuleVO(){
		return trsTrspOfcExptRuleVO;
	}
	/** getTrsTrspOfcExptRuleVO*/
	public TrsTrspOfcExptRule2VO getTrsTrspOfcExptRule2VO(){
		return trsTrspOfcExptRule2VO;
	}
	
	/** getTrsTrspOfcExptRuleVO*/
	public TrsTrspOfcExptRuleVO[] getTrsTrspOfcExptRuleVOS(){
		TrsTrspOfcExptRuleVO[] rtnVOs = null;
		if (this.trsTrspOfcExptRuleVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspOfcExptRuleVOs, trsTrspOfcExptRuleVOs.length);
		}
		return rtnVOs;
	}
	/** getTrsTrspOfcExptRuleVO*/
	public TrsTrspOfcExptRule2VO[] getTrsTrspOfcExptRule2VOS(){
		TrsTrspOfcExptRule2VO[] rtnVOs = null;
		if (this.trsTrspOfcExptRule2VOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspOfcExptRule2VOs, trsTrspOfcExptRule2VOs.length);
		}
		return rtnVOs;
	}
	
	public ControlOfficeExceptionSearchConditionVO getControlOfficeExceptionSearchConditionVO(){
		return controlOfficeExceptionSearchConditionVO;
	}

	public void setControlOfficeExceptionSearchConditionVO(ControlOfficeExceptionSearchConditionVO controlOfficeExceptionSearchConditionVO) {
		this.controlOfficeExceptionSearchConditionVO = controlOfficeExceptionSearchConditionVO;
	}

	private String searchStr = null;
	private String ctrlOfcCd = null;
	private String trspSoEqKind = null;
	private String isZone = null;
	private String formUsrOfcCd = null;
	private String formCreUsrId = null;
	
	public String getFORM_USR_OFC_CD() {
		return formUsrOfcCd;
	}

	public void setFORM_USR_OFC_CD(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String getFORM_CRE_USR_ID() {
		return formCreUsrId;
	}

	public void setFORM_CRE_USR_ID(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getTRSP_SO_EQ_KIND() {
		return trspSoEqKind;
	}

	public void setTRSP_SO_EQ_KIND(String trspSoEqKind) {
		this.trspSoEqKind = trspSoEqKind;
	}

	public String getIsZone() {
		return isZone;
	}

	public void setIsZone(String isZone) {
		this.isZone = isZone;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public String getCtrl_ofc_cd() {
		return ctrlOfcCd;
	}

	public void setCtrl_ofc_cd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("searchStr", getSearchStr());
		this.hashColumns.put("ctrl_ofc_cd", getCtrl_ofc_cd());
		this.hashColumns.put("TRSP_SO_EQ_KIND", getTRSP_SO_EQ_KIND());
		this.hashColumns.put("isZone", getIsZone());
		this.hashColumns.put("FORM_USR_OFC_CD", getFORM_USR_OFC_CD());
		this.hashColumns.put("FORM_CRE_USR_ID", getFORM_CRE_USR_ID());

		return this.hashColumns;
	}

	public EsdTrs0079Event(){}

	public void setTrsTrspOfcExptRuleVOS(TrsTrspOfcExptRuleVO[] trsTrspOfcExptRuleVOs){
		if (trsTrspOfcExptRuleVOs != null) {
			TrsTrspOfcExptRuleVO[] tmpVOs = Arrays.copyOf(trsTrspOfcExptRuleVOs, trsTrspOfcExptRuleVOs.length);
			this.trsTrspOfcExptRuleVOs = tmpVOs;
		}
	}
	
	public void setTrsTrspOfcExptRule2VOS(TrsTrspOfcExptRule2VO[] trsTrspOfcExptRule2VOs){
		if (trsTrspOfcExptRule2VOs != null) {
			TrsTrspOfcExptRule2VO[] tmpVOs = Arrays.copyOf(trsTrspOfcExptRule2VOs, trsTrspOfcExptRule2VOs.length);
			this.trsTrspOfcExptRule2VOs = tmpVOs;
		}
	}
	
	public String getEventName() {
		return "EsdTrs0079Event";
	}

	public String toString() {
		return "EsdTrs0079Event";
	}
}
