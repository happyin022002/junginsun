/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VopFcm0003Event.java
*@FileTitle : Departure Report PK Error Cleansing
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastVersion : 1.0
* 1.0 Creation 
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.FcmDepRptClsHisVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrVO;

/**
 * VOP_FCM_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_FCM_0003HTMLAction 참조
 * @since J2EE 1.4
 */
public class VopFcm0003Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRptInqVO vslRptInqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslFcmDepRptVO[] vslFcmDepRptVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVslPortSkdVO searchVslPortSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVslPortSkdVO[] searchVslPortSkdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmDepRptErrVO fcmDepRptErrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FcmDepRptErrVO[] fcmDepRptErrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmDepRptClsHisVO fcmDepRptClsHisVO = null;	
	
	public VopFcm0003Event(){}

	public VslRptInqVO getVslRptInqVO() {
		return vslRptInqVO;
	}
	
	public VslFcmDepRptVO[] getVslFcmDepRptVOs() {
		VslFcmDepRptVO[] rtnVOs = null;
		if (this.vslFcmDepRptVOs != null) {
			rtnVOs = new VslFcmDepRptVO[vslFcmDepRptVOs.length];
			System.arraycopy(vslFcmDepRptVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVslRptInqVO(VslRptInqVO vslRptInqVO) {
		this.vslRptInqVO = vslRptInqVO;
	}
	
	public void setVslFcmDepRptVOs(VslFcmDepRptVO[] vslFcmDepRptVOs) {
		if (vslFcmDepRptVOs != null) {
			VslFcmDepRptVO[] tmpVOs = new VslFcmDepRptVO[vslFcmDepRptVOs.length];
			System.arraycopy(vslFcmDepRptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslFcmDepRptVOs = tmpVOs;
		}
	}
	
	/**************************************************/
	public SearchVslPortSkdVO getSearchVslPortSkdVO() {
		return searchVslPortSkdVO;
	}
	
	public SearchVslPortSkdVO[] getSearchVslPortSkdVOs() {
		SearchVslPortSkdVO[] rtnVOs = null;
		if (this.searchVslPortSkdVOs != null) {
			rtnVOs = new SearchVslPortSkdVO[searchVslPortSkdVOs.length];
			System.arraycopy(searchVslPortSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSearchVslPortSkdVO(SearchVslPortSkdVO searchVslPortSkdVO) {
		this.searchVslPortSkdVO = searchVslPortSkdVO;
	}
	
	public void setSearchVslPortSkdVOs(SearchVslPortSkdVO[] searchVslPortSkdVOs) {
		if (searchVslPortSkdVOs != null) {
			SearchVslPortSkdVO[] tmpVOs = new SearchVslPortSkdVO[searchVslPortSkdVOs.length];
			System.arraycopy(searchVslPortSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchVslPortSkdVOs = tmpVOs;
		}
	}
	
	public FcmDepRptErrVO getFcmDepRptErrVO() {
		return fcmDepRptErrVO;
	}
	
	public FcmDepRptErrVO[] getFcmDepRptErrVOs() {
		FcmDepRptErrVO[] rtnVOs = null;
		if (this.fcmDepRptErrVOs != null) {
			rtnVOs = new FcmDepRptErrVO[fcmDepRptErrVOs.length];
			System.arraycopy(fcmDepRptErrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setFcmDepRptErrVO(FcmDepRptErrVO fcmDepRptErrVO) {
		this.fcmDepRptErrVO = fcmDepRptErrVO;
	}
	
	public void setFcmDepRptErrVOs(FcmDepRptErrVO[] fcmDepRptErrVOs) {
		if (fcmDepRptErrVOs != null) {
			FcmDepRptErrVO[] tmpVOs = new FcmDepRptErrVO[fcmDepRptErrVOs.length];
			System.arraycopy(fcmDepRptErrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmDepRptErrVOs = tmpVOs;
		}
	}
	
	public FcmDepRptClsHisVO getFcmDepRptClsHisVO() {
		return fcmDepRptClsHisVO;
	}
	public void setFcmDepRptClsHisVO(FcmDepRptClsHisVO fcmDepRptClsHisVO) {
		this.fcmDepRptClsHisVO = fcmDepRptClsHisVO;
	}
}