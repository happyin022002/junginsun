/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0003Event.java
*@FileTitle : 선박 VESSLE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.20 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchAuditDataCheckListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO-0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String fromDate = "";
	private String toDate = "";
	private String srhCnd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAuditDataCheckListVO searchAuditDataCheckListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAuditDataCheckListVO[] searchAuditDataCheckListVOs = null;
	
	public VopPso0003Event(){}
	

	
	
	public void setSearchAuditDataCheckListVO(SearchAuditDataCheckListVO searchAuditDataCheckListVO){
		this. searchAuditDataCheckListVO = searchAuditDataCheckListVO;
	}

	public void setSearchAuditDataCheckListVOS(SearchAuditDataCheckListVO[] searchAuditDataCheckListVOs){
		if (searchAuditDataCheckListVOs != null) {
			SearchAuditDataCheckListVO[] tmpVOs = new SearchAuditDataCheckListVO[searchAuditDataCheckListVOs .length];
			System.arraycopy(searchAuditDataCheckListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. searchAuditDataCheckListVOs = tmpVOs;
		}
	}

	
	public SearchAuditDataCheckListVO getSearchAuditDataCheckListVO(){
		return searchAuditDataCheckListVO;
	}

	public SearchAuditDataCheckListVO[] getSearchAuditDataCheckListVOS(){
		SearchAuditDataCheckListVO[] tmpVOs = null;
		if (this. searchAuditDataCheckListVOs != null) {
			tmpVOs = new SearchAuditDataCheckListVO[searchAuditDataCheckListVOs .length];
			System.arraycopy(searchAuditDataCheckListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}



	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}




	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}




	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}




	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}




	/**
	 * @param srhCnd the srhCnd to set
	 */
	public void setSrhCnd(String srhCnd) {
		this.srhCnd = srhCnd;
	}




	/**
	 * @return the srhCnd
	 */
	public String getSrhCnd() {
		return srhCnd;
	}

}