/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0012Event.java
*@FileTitle : Prepayments
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.06.09 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0012HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";
	
	/** Hire No. */
	private String ppayHirNo = "";

	/** invSeq Invoice Sequence */
	private String invSeq = "";
	
	/** Contract TP */
	private String fletCtrtTpGb = "";

	/** Duration From 일자 */
	private String effDt = "";

	/** Duration To 일자 */
	private String expDt = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomPreInvoiceVO customPreInvoiceVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOffInvoiceVO customOffInvoiceVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCalPrepaymentInvoiceListVO searchCalPrepaymentInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCalOffhireInvoiceListVO[] searchCalOffhireInvoiceListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOffInvDtlVO[] customOffInvDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomPreInvDtlVO[] customPreInvDtlVOs = null;

	public EsmFms0012Event(){}
	
	public void setCustomPreInvoiceVO(CustomPreInvoiceVO customPreInvoiceVO){
		this.customPreInvoiceVO = customPreInvoiceVO;
	}
	
	public void setCustomOffInvoiceVO(CustomOffInvoiceVO customOffInvoiceVO){
		this.customOffInvoiceVO = customOffInvoiceVO;
	}
	
	public void setCondSearchCalPrepaymentInvoiceListVO(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO){
		this.condSearchCalPrepaymentInvoiceListVO = condSearchCalPrepaymentInvoiceListVO;
	}
	
	public void setSearchCalPrepaymentInvoiceListVO(SearchCalPrepaymentInvoiceListVO searchCalPrepaymentInvoiceListVO){
		this.searchCalPrepaymentInvoiceListVO = searchCalPrepaymentInvoiceListVO;
	}
	
	public void setCustomPreInvDtlVOS(CustomPreInvDtlVO[] customPreInvDtlVOs){
		if (customPreInvDtlVOs != null) {
			CustomPreInvDtlVO[] tmpVOs = Arrays.copyOf(customPreInvDtlVOs, customPreInvDtlVOs.length);
			this.customPreInvDtlVOs = tmpVOs;
		}
	}

	public void setCustomOffInvDtlVOS(CustomOffInvDtlVO[] customOffInvDtlVOs){
		if (customOffInvDtlVOs != null) {
			CustomOffInvDtlVO[] tmpVOs = Arrays.copyOf(customOffInvDtlVOs, customOffInvDtlVOs.length);
			this.customOffInvDtlVOs = tmpVOs;
		}
	}
	
	public void setSearchCalOffhireInvoiceListVOS(SearchCalOffhireInvoiceListVO[] searchCalOffhireInvoiceListVOs){
		if (searchCalOffhireInvoiceListVOs != null) {
			SearchCalOffhireInvoiceListVO[] tmpVOs = Arrays.copyOf(searchCalOffhireInvoiceListVOs, searchCalOffhireInvoiceListVOs.length);
			this.searchCalOffhireInvoiceListVOs = tmpVOs;
		}
	}
	
	public CustomPreInvoiceVO getCustomPreInvoiceVO(){
		return customPreInvoiceVO;
	}
	
	public CustomOffInvoiceVO getCustomOffInvoiceVO(){
		return customOffInvoiceVO;
	}

	public SearchCalPrepaymentInvoiceListVO getSearchCalPrepaymentInvoiceListVO(){
		return searchCalPrepaymentInvoiceListVO;
	}
	
	public CondSearchCalPrepaymentInvoiceListVO getCondSearchCalPrepaymentInvoiceListVO(){
		return condSearchCalPrepaymentInvoiceListVO;
	}

	public SearchCalOffhireInvoiceListVO[] getSearchCalOffhireInvoiceListVOS(){
		SearchCalOffhireInvoiceListVO[] rtnVOs = null;
		if (this.searchCalOffhireInvoiceListVOs != null) {
			rtnVOs = Arrays.copyOf(searchCalOffhireInvoiceListVOs, searchCalOffhireInvoiceListVOs.length);
		}
		return rtnVOs;
	}
	
	public CustomPreInvDtlVO[] getCustomPreInvDtlVOS(){
		CustomPreInvDtlVO[] rtnVOs = null;
		if (this.customPreInvDtlVOs != null) {
			rtnVOs = Arrays.copyOf(customPreInvDtlVOs, customPreInvDtlVOs.length);
		}
		return rtnVOs;
	}
	
	public CustomOffInvDtlVO[] getCustomOffInvDtlVOS(){
		CustomOffInvDtlVO[] rtnVOs = null;
		if (this.customOffInvDtlVOs != null) {
			rtnVOs = Arrays.copyOf(customOffInvDtlVOs, customOffInvDtlVOs.length);
		}
		return rtnVOs;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getPpayHirNo() {
		return ppayHirNo;
	}

	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}
	
	public String getFletCtrtTpGb() {
		return fletCtrtTpGb;
	}

	public void setFletCtrtTpGb(String fletCtrtTpGb) {
		this.fletCtrtTpGb = fletCtrtTpGb;
	}
	
	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	public String getInvSeq() {
		return invSeq;
	}

	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

}
