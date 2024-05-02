/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0073Event.java
*@FileTitle : EsdSce0073
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-10
*@LastModifier : sanghyun-kim
*@LastVersion : 1.0
* 2008-05-10 sanghyun-kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCsTpIdInfoCntVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsTpIdInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0073Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**조회를 위한 VO 정의*/
	public EsdSce0073Event(){}
	
	private SearchEDIPerformanceOptionsVO schEpOpts = null;
	/** Table Value Object insert 처리 */
	private SearchCsTpIdInfoCntVO myTpCnt = null;
	/** Table Value Object insert 처리 */
	private SearchCsTpIdInfoCntVO[] myTpCnts = null;
	/** Table Value Object insert 처리 */
	private SearchPerCsTpIdInfoVO myTpInfo = null;
	/** Table Value Object insert 처리 */
	private SearchPerCsTpIdInfoVO[] myTpInfos = null;
	/** Table Value Object insert 처리 */
	private SearchCustomerInfoVO myCustInfo = null;
	/** Table Value Object insert 처리 */
	private SearchCustomerInfoVO[] myCustInfos = null;
	/** Table Value Object insert 처리 */
	private CustomerInqChoiceVO myUserInfo = null;
	/** Table Value Object insert 처리 */
	private CustomerInqChoiceVO[] myUserInfos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPerRepPupModiVO mySearchperPup = null;
	/** Table Value Object Multi Data 처리 */
	private SearchPerRepPupModiVO[] mySearchperPups = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerInqueryVO custInq = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerInqueryVO[] custInqs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiSummaryReportOptionsVO schSROptsVO = null;

	public SearchPerRepPupModiVO getMySearchperPup() {
		return mySearchperPup;
	}
	public void setMySearchperPup(SearchPerRepPupModiVO mySearchperPup) {
		this.mySearchperPup = mySearchperPup;
	}
	public SearchPerRepPupModiVO[] getMySearchperPups() {
		return mySearchperPups;
	}
	public void setMySearchperPups(SearchPerRepPupModiVO[] mySearchperPups) {
		this.mySearchperPups = mySearchperPups;
	}
	public SearchCustomerInfoVO getMyCustInfo() {
		return myCustInfo;
	}
	public void setMyCustInfo(SearchCustomerInfoVO myCustInfo) {
		this.myCustInfo = myCustInfo;
	}
	public SearchCustomerInfoVO[] getMyCustInfos() {
		return myCustInfos;
	}
	public void setMyCustInfos(SearchCustomerInfoVO[] myCustInfos) {
		this.myCustInfos = myCustInfos;
	}
	public CustomerInqChoiceVO getMyUserInfo() {
		return myUserInfo;
	}
	public void setMyUserInfo(CustomerInqChoiceVO myUserInfo) {
		this.myUserInfo = myUserInfo;
	}
	public CustomerInqChoiceVO[] getMyUserInfos() {
		return myUserInfos;
	}
	public void setMyUserInfos(CustomerInqChoiceVO[] myUserInfos) {
		this.myUserInfos = myUserInfos;
	}
	public SearchCsTpIdInfoCntVO getMyTpCnt() {
		return myTpCnt;
	}
	public void setMyTpCnt(SearchCsTpIdInfoCntVO myTpCnt) {
		this.myTpCnt = myTpCnt;
	}
	public SearchCsTpIdInfoCntVO[] getMyTpCnts() {
		return myTpCnts;
	}
	public void setMyTpCnts(SearchCsTpIdInfoCntVO[] myTpCnts) {
		this.myTpCnts = myTpCnts;
	}
	public SearchPerCsTpIdInfoVO getMyTpInfo() {
		return myTpInfo;
	}
	public void setMyTpInfo(SearchPerCsTpIdInfoVO myTpInfo) {
		this.myTpInfo = myTpInfo;
	}
	public SearchPerCsTpIdInfoVO[] getMyTpInfos() {
		return myTpInfos;
	}
	public void setMyTpInfos(SearchPerCsTpIdInfoVO[] myTpInfos) {
		this.myTpInfos = myTpInfos;
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
	public SearchEDIPerformanceOptionsVO getSchEpOpts() {
		return schEpOpts;
	}
	public void setSchEpOpts(SearchEDIPerformanceOptionsVO schEpOpts) {
		this.schEpOpts = schEpOpts;
	}
	public SearchEdiSummaryReportOptionsVO getSchSROptsVO() {
		return schSROptsVO;
	}
	public void setSchSROptsVO(SearchEdiSummaryReportOptionsVO schSROptsVO) {
		this.schSROptsVO = schSROptsVO;
	}
		
}
