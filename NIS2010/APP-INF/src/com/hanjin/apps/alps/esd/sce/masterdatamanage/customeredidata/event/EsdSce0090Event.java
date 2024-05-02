/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0090Event.java
*@FileTitle : EsdSce0090
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-14
*@LastModifier : sanghyun_kim
*@LastVersion : 1.0
* 2008-04-14 sanghyun_kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sanghyun_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0090Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/**조회를 위한 VO 정의*/
	public EsdSce0090Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerInfoVO myCustInfo = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerInfoVO[] myCustInfos = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMyCustomerVO myCust = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMyCustomerVO[] myCusts = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMyPerformanceVO myPerf = null;
	/** Table Value Object Multi Data 처리 */
	private SearchMyPerformanceVO[] myPerfs = null;

	
	public SearchMyCustomerVO getMyCust() {
		return myCust;
	}
	public void setMyCust(SearchMyCustomerVO myCust) {
		this.myCust = myCust;
	}
	public SearchMyCustomerVO[] getMyCusts() {
		return myCusts;
	}
	public void setMyCusts(SearchMyCustomerVO[] myCusts) {
		this.myCusts = myCusts;
	} 
	public SearchMyPerformanceVO getMyPerf() {
		return myPerf;
	}
	public void setMyPerf(SearchMyPerformanceVO myPerf) {
		this.myPerf = myPerf;
	}
	public SearchMyPerformanceVO[] getMyPerfs() {
		return myPerfs;
	}
	public void setMyPerfs(SearchMyPerformanceVO[] myPerfs) {
		this.myPerfs = myPerfs;
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
	
}
