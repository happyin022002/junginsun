/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : EsdTrs0976Event.java
 *@FileTitle : TRS Invoice Authority
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.16
 *@LastModifier : 유선오
 *@LastVersion : 1.2
 * 2011.11.09 유선오
--------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.1 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16 유선오 1.2 [CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 : Line No.25 클래스 주석을 기술
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

     /**
	 * ESD_TRS_976 에 대한 PDTO(Data Transfer Object including Parameters)<br>
	 * - ESD_TRS_976HTMLAction에서 작성<br>
	 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
	 *
	 * @author  Yoo,SunOh
	 * @see HTMLAction 참조
	 * @since J2EE 1.6
	 */
public class EsdTrs0976Event extends EventSupport {
		
	private static final long serialVersionUID = 1L;
	/** InvoiceOffice Table  Value Object */
	InvoiceOfficeAuthorityManagementVO invoiceOfficeAuthorityManagementVO = null;
	/** Multi Action을 위한 Collection */
	InvoiceOfficeAuthorityManagementVO[] invoiceOfficeAuthorityManagementVOs = null;
	/** ESD_TRS_0976Event */
	public EsdTrs0976Event(){}
    String invOfcCd;
    String invOfcEngNm;
    String ofcCd;
    String ofcEngNm;
    String creUsrId;
    String creDt;
    String updUsrId;
    String updDt;
     
        
	public InvoiceOfficeAuthorityManagementVO getInvoiceOfficeAuthorityManagementVO() {
		return invoiceOfficeAuthorityManagementVO;
	}
    
	public void setInvoiceOfficeAuthorityManagementVO(
		InvoiceOfficeAuthorityManagementVO invoiceOfficeAuthorityManagementVO) {
		this.invoiceOfficeAuthorityManagementVO = invoiceOfficeAuthorityManagementVO;
	}	
    public InvoiceOfficeAuthorityManagementVO[] getInvoiceOfficeAuthorityManagementVOs() {
		return invoiceOfficeAuthorityManagementVOs;
	}    
	public void setInvoiceOfficeAuthorityManagementVOs(
		InvoiceOfficeAuthorityManagementVO[] invoiceOfficeAuthorityManagementVOs) {
		this.invoiceOfficeAuthorityManagementVOs = invoiceOfficeAuthorityManagementVOs;
	}  	
	public String getInvOfcEngNm() {
		return invOfcEngNm;
	}	
	public void setInvOfcEngNm(String invOfcEngNm) {
		this.invOfcEngNm = invOfcEngNm;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getInvOfcCd() {
		return invOfcCd;
	}
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	public String getOfcEngNm() {
		return ofcEngNm;
	}
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	public String getCreUsrId() {
		return creUsrId;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	public String getCreDt() {
		return creDt;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}	
	public String getUpdUsrId(){
		return updUsrId;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	public String getUpdDt() {
		return updDt;
	}
	public void setUpdDt(String updDt){
		this.updDt = updDt;
	}
	public String getEventName() {
		return "EsdTrs0976Event";
	}
	public String toString() {
		return "EsdTrs0976Event";
	}
	private String row = "";
		public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
}
    



