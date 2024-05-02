/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0073Event.java
*@FileTitle : Offhire Expenses from VMS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOffhireInvoiceVmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffhExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceVmsListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0073HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOffhireInvoiceVmsListVO[] searchOffhireInvoiceVmsListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOffhExpnVO[] customOffhExpnVOs = null;

	public EsmFms0073Event(){}
	
	public void setCondSearchOffhireInvoiceVmsVO(CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO){
		this.condSearchOffhireInvoiceVmsVO = condSearchOffhireInvoiceVmsVO;
	}
	
	public CondSearchOffhireInvoiceVmsVO getCondSearchOffhireInvoiceVmsVO(){
		return condSearchOffhireInvoiceVmsVO;
	}
	
	public void setSearchOffhireInvoiceVmsListVOS(SearchOffhireInvoiceVmsListVO[] searchOffhireInvoiceVmsListVOs){
		if (searchOffhireInvoiceVmsListVOs != null) {
			SearchOffhireInvoiceVmsListVO[] tmpVOs = Arrays.copyOf(searchOffhireInvoiceVmsListVOs, searchOffhireInvoiceVmsListVOs.length);
			this.searchOffhireInvoiceVmsListVOs = tmpVOs;
		}
	}
	
	public SearchOffhireInvoiceVmsListVO[] getSearchOffhireInvoiceVmsListVOS(){
		SearchOffhireInvoiceVmsListVO[] rtnVOs = null;
		if (this.searchOffhireInvoiceVmsListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOffhireInvoiceVmsListVOs, searchOffhireInvoiceVmsListVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomOffhExpnVOS(CustomOffhExpnVO[] customOffhExpnVOs){
		if (customOffhExpnVOs != null) {
			CustomOffhExpnVO[] tmpVOs = Arrays.copyOf(customOffhExpnVOs, customOffhExpnVOs.length);
			this.customOffhExpnVOs = tmpVOs;
		}
	}
	
	public CustomOffhExpnVO[] getCustomOffhExpnVOS(){
		CustomOffhExpnVO[] rtnVOs = null;
		if (this.customOffhExpnVOs != null) {
			rtnVOs = Arrays.copyOf(customOffhExpnVOs, customOffhExpnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
}