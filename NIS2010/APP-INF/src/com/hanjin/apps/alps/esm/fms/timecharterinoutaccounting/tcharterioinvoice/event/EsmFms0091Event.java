/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0014Event.java
*@FileTitle : Off-Hire Expenses
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

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/** 
 * ESM_FMS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0014HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";
	
	/** vslCd vesselCode */
	private String vslCd = "";

	/** invSeq Invoice Sequence */
	private String invSeq = "";

	/** Duration From 일자 */
	private String effDt = "";

	/** Duration To 일자 */
	private String expDt = "";
	
	/** fletCtrtTpCd Contract Type  */
	private String fletCtrtTpCd = "";
	
	/** 계약 화면인지 판다(Y)  */
	private String ctrtFlag = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOffInvoiceVO customOffInvoiceVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondCalOffhireInvoiceVO condCalOffhireInvoiceVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCalOffhireInvoiceListVO searchCalOffhireInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCalOffhireInvoiceListVO[] searchCalOffhireInvoiceListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOffInvDtlVO[] customOffInvDtlVOs = null;
	
	public EsmFms0091Event(){}
	
	public void setCustomOffInvoiceVO(CustomOffInvoiceVO customOffInvoiceVO){
		this.customOffInvoiceVO = customOffInvoiceVO;
	}
	
	public void setCondCalOffhireInvoiceVO(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO){
		this.condCalOffhireInvoiceVO = condCalOffhireInvoiceVO;
	}
	
	public void setSearchCalOffhireInvoiceListVO(SearchCalOffhireInvoiceListVO searchCalOffhireInvoiceListVO){
		this.searchCalOffhireInvoiceListVO = searchCalOffhireInvoiceListVO;
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
	
	public CustomOffInvoiceVO getCustomOffInvoiceVO(){
		return customOffInvoiceVO;
	}

	public SearchCalOffhireInvoiceListVO getSearchCalOffhireInvoiceListVO(){
		return searchCalOffhireInvoiceListVO;
	}
	
	public CondCalOffhireInvoiceVO getCondCalOffhireInvoiceVO(){
		return condCalOffhireInvoiceVO;
	}

	public SearchCalOffhireInvoiceListVO[] getSearchCalOffhireInvoiceListVOS(){
		SearchCalOffhireInvoiceListVO[] rtnVOs = null;
		if (this.searchCalOffhireInvoiceListVOs != null) {
			rtnVOs = Arrays.copyOf(searchCalOffhireInvoiceListVOs, searchCalOffhireInvoiceListVOs.length);
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
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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

}