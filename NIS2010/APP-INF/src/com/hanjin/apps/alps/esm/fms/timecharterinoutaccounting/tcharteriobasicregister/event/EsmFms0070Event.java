/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0070Event.java
*@FileTitle : Vendor Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.16 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;


/**
 * ESM_FMS_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0070HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** agmtFlag 계약에서 팝업 호출 구분 */
	private String agmtFlag = "";
	
	/** condFlag Vendor/Customer 구분 */
	private String condFlag = "";
	
	/** cdSeq Vendor/Customer Code */
	private String cdSeq = "";
	
	/** cdCnt Vendor/Customer 국가코드 */
	private String cdCnt = "";

	/** vendorCustomerName Search Text */
	private String vendorCustomerName = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVendorCustomerVO searchvendorcustomervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVendorCustomerVO[] searchvendorcustomervos = null;

	public EsmFms0070Event(){}
	
	public void setSearchVendorCustomerVO(SearchVendorCustomerVO searchvendorcustomervo){
		this. searchvendorcustomervo = searchvendorcustomervo;
	}

	public void setSearchVendorCustomerVOS(SearchVendorCustomerVO[] searchvendorcustomervos){
			if (searchvendorcustomervos != null) {
			SearchVendorCustomerVO[] tmpVOs = new SearchVendorCustomerVO[searchvendorcustomervos.length];
			System.arraycopy(searchvendorcustomervos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchvendorcustomervos = tmpVOs;
		}
	}

	public void setAgmtFlag(String agmtFlag) {
		this.agmtFlag = agmtFlag;
	}

	public void setCondFlag(String condFlag) {
		this.condFlag = condFlag;
	}

	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}

	public void setCdCnt(String cdCnt) {
		this.cdCnt = cdCnt;
	}

	public void setVendorCustomerName(String vendorCustomerName) {
		this.vendorCustomerName = vendorCustomerName;
	}

	public SearchVendorCustomerVO getSearchVendorCustomerVO(){
		return searchvendorcustomervo;
	}

	public SearchVendorCustomerVO[] getSearchVendorCustomerVOS(){
		SearchVendorCustomerVO[] rtnVOs = null;
		if (this.searchvendorcustomervos != null) {
			rtnVOs = new SearchVendorCustomerVO[searchvendorcustomervos.length];
			System.arraycopy(searchvendorcustomervos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getAgmtFlag() {
		return agmtFlag;
	}
	
	public String getCondFlag() {
		return condFlag;
	}
	
	public String getCdSeq() {
		return cdSeq;
	}
	
	public String getCdCnt() {
		return cdCnt;
	}
	
	public String getVendorCustomerName() {
		return vendorCustomerName;
	}

}