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
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsTpIdInfoCntVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsTpIdInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		SearchPerRepPupModiVO[] rtnVOs = null;
		if (this.mySearchperPups != null) {
			rtnVOs = Arrays.copyOf(mySearchperPups, mySearchperPups.length);
		}
		return rtnVOs;
	}
	public void setMySearchperPups(SearchPerRepPupModiVO[] mySearchperPups) {
		if(mySearchperPups != null){
			SearchPerRepPupModiVO[] tmpVOs = Arrays.copyOf(mySearchperPups, mySearchperPups.length);
			this.mySearchperPups = tmpVOs;
		}
	}
	public SearchCustomerInfoVO getMyCustInfo() {
		return myCustInfo;
	}
	public void setMyCustInfo(SearchCustomerInfoVO myCustInfo) {
		this.myCustInfo = myCustInfo;
	}
	public SearchCustomerInfoVO[] getMyCustInfos() {
		SearchCustomerInfoVO[] rtnVOs = null;
		if (this.myCustInfos != null) {
			rtnVOs = Arrays.copyOf(myCustInfos, myCustInfos.length);
		}
		return rtnVOs;
	}
	public void setMyCustInfos(SearchCustomerInfoVO[] myCustInfos) {
		if(myCustInfos != null){
			SearchCustomerInfoVO[] tmpVOs = Arrays.copyOf(myCustInfos, myCustInfos.length);
			this.myCustInfos = tmpVOs;
		}
	}
	public CustomerInqChoiceVO getMyUserInfo() {
		return myUserInfo;
	}
	public void setMyUserInfo(CustomerInqChoiceVO myUserInfo) {
		this.myUserInfo = myUserInfo;
	}
	public CustomerInqChoiceVO[] getMyUserInfos() {
		CustomerInqChoiceVO[] rtnVOs = null;
		if (this.myUserInfos != null) {
			rtnVOs = Arrays.copyOf(myUserInfos, myUserInfos.length);
		}
		return rtnVOs;
	}
	public void setMyUserInfos(CustomerInqChoiceVO[] myUserInfos) {
		if(myUserInfos != null){
			CustomerInqChoiceVO[] tmpVOs = Arrays.copyOf(myUserInfos, myUserInfos.length);
			this.myUserInfos = tmpVOs;
		}
	}
	public SearchCsTpIdInfoCntVO getMyTpCnt() {
		return myTpCnt;
	}
	public void setMyTpCnt(SearchCsTpIdInfoCntVO myTpCnt) {
		this.myTpCnt = myTpCnt;
	}
	public SearchCsTpIdInfoCntVO[] getMyTpCnts() {
		SearchCsTpIdInfoCntVO[] rtnVOs = null;
		if (this.myTpCnts != null) {
			rtnVOs = Arrays.copyOf(myTpCnts, myTpCnts.length);
		}
		return rtnVOs;
	}
	public void setMyTpCnts(SearchCsTpIdInfoCntVO[] myTpCnts) {
		if(myTpCnts != null){
			SearchCsTpIdInfoCntVO[] tmpVOs = Arrays.copyOf(myTpCnts, myTpCnts.length);
			this.myTpCnts = tmpVOs;
		}
	}
	public SearchPerCsTpIdInfoVO getMyTpInfo() {
		return myTpInfo;
	}
	public void setMyTpInfo(SearchPerCsTpIdInfoVO myTpInfo) {
		this.myTpInfo = myTpInfo;
	}
	public SearchPerCsTpIdInfoVO[] getMyTpInfos() {
		SearchPerCsTpIdInfoVO[] rtnVOs = null;
		if (this.myTpInfos != null) {
			rtnVOs = Arrays.copyOf(myTpInfos, myTpInfos.length);
		}
		return rtnVOs;
	}
	public void setMyTpInfos(SearchPerCsTpIdInfoVO[] myTpInfos) {
		if(myTpInfos != null){
			SearchPerCsTpIdInfoVO[] tmpVOs = Arrays.copyOf(myTpInfos, myTpInfos.length);
			this.myTpInfos = tmpVOs;
		}
	}
	public SearchCustomerInqueryVO getCustInq() {
		return custInq;
	}
	public void setCustInq(SearchCustomerInqueryVO custInq) {
		this.custInq = custInq;
	}
	public SearchCustomerInqueryVO[] getCustInqs() {
		SearchCustomerInqueryVO[] rtnVOs = null;
		if (this.custInqs != null) {
			rtnVOs = Arrays.copyOf(custInqs, custInqs.length);
		}
		return rtnVOs;
	}
	public void setCustInqs(SearchCustomerInqueryVO[] custInqs) {
		if(custInqs != null){
			SearchCustomerInqueryVO[] tmpVOs = Arrays.copyOf(custInqs, custInqs.length);
			this.custInqs = tmpVOs;
		}
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
