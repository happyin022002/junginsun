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
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0014HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0014Event extends EventSupport {

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

	public EsmFms0014Event(){}
	
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
			CustomOffInvDtlVO[] tmpVOs = new CustomOffInvDtlVO[customOffInvDtlVOs.length];
			System.arraycopy(customOffInvDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customOffInvDtlVOs = tmpVOs;
		}
	}
	
	public void setSearchCalOffhireInvoiceListVOS(SearchCalOffhireInvoiceListVO[] searchCalOffhireInvoiceListVOs){
		if (searchCalOffhireInvoiceListVOs != null) {
			SearchCalOffhireInvoiceListVO[] tmpVOs = new SearchCalOffhireInvoiceListVO[searchCalOffhireInvoiceListVOs.length];
			System.arraycopy(searchCalOffhireInvoiceListVOs, 0, tmpVOs, 0, tmpVOs.length);
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
		SearchCalOffhireInvoiceListVO[] tmpVOs = null;
		if (this.searchCalOffhireInvoiceListVOs != null) {
			tmpVOs = new SearchCalOffhireInvoiceListVO[searchCalOffhireInvoiceListVOs.length];
			System.arraycopy(searchCalOffhireInvoiceListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public CustomOffInvDtlVO[] getCustomOffInvDtlVOS(){
		CustomOffInvDtlVO[] tmpVOs = null;
		if (this.customOffInvDtlVOs != null) {
			tmpVOs = new CustomOffInvDtlVO[customOffInvDtlVOs.length];
			System.arraycopy(customOffInvDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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

}
