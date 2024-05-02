/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0035Event.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerCntVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0062Event extends EventSupport{
	private static final long serialVersionUID = 1L;

	/**조회를 위한 VO 정의*/
	public EsdSce0062Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerInqChoiceVO custChoice = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerInqueryVO custInq = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerInqueryVO[] custInqs = null;
	/** Table Value Object insert 처리 */
	private SearchCustomerInfoVO myCustInfo = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerCntVO custInqCnt = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerCntVO[] custInqCnts = null;

	public CustomerInqChoiceVO getCustChoice() {
		return custChoice;
	}
	public void setCustChoice(CustomerInqChoiceVO custChoice) {
		this.custChoice = custChoice;
	}
	public SearchCustomerInqueryVO getCustInq() {
		return custInq;
	}
	public void setCustInq(SearchCustomerInqueryVO custInq) {
		this.custInq = custInq;
	}
	public SearchCustomerInqueryVO[] getCustInqs() {
		return custInqs;
	}
	public void setCustInqs(SearchCustomerInqueryVO[] custInqs) {
		this.custInqs = custInqs;
	}
	public SearchCustomerInfoVO getMyCustInfo() {
		return myCustInfo;
	}
	public void setMyCustInfo(SearchCustomerInfoVO myCustInfo) {
		this.myCustInfo = myCustInfo;
	}
	public SearchCustomerCntVO getCustInqCnt() {
		return custInqCnt;
	}
	public void setCustInqCnt(SearchCustomerCntVO custInqCnt) {
		this.custInqCnt = custInqCnt;
	}
	public SearchCustomerCntVO[] getCustInqCnts() {
		return custInqCnts;
	}
	public void setCustInqCnts(SearchCustomerCntVO[] custInqCnts) {
		this.custInqCnts = custInqCnts;
	}

}
