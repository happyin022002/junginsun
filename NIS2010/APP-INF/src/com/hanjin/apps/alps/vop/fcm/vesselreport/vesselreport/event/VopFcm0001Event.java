/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm9999Event.java
*@FileTitle : VopFcm9999Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* 
* 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmAblogRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptErrVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptOverlapVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmDepRptLogVO fcmDepRptLogVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmDepRptLogVO[] fcmDepRptLogVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRptInqVO vslRptInqVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslNoonRptVO vslNoonRptVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmNoonRptLogVO fcmNoonRptLogVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmNoonRptLogVO[] fcmNoonRptLogVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslNoonRptNotRcvVO vslNoonRptNotRcvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslNoonRptMssMtchVO vslNoonRptMssMtchVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDepRptVO vslDepRptVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDepRptNotRcvVO vslDepRptNotRcvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDepRptMssMtchVO vslDepRptMssMtchVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDepRptErrVO vslDepRptErrVO = null;
	private VslDepRptErrVO[] vslDepRptErrVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDepRptOverlapVO vslDepRptOverlapVO = null;
	private VslDepRptOverlapVO[] vslDepRptOverlapVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslABLogRptVO vslABLogRptVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslABLogRptNotRcvVO vslABLogRptNotRcvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslABLogRptMssMtchVO vslABLogRptMssMtchVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRobMthEndRptVO vslRobMthEndRptVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRobMthEndRptNotRcvVO vslRobMthEndRptNotRcvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRobMthEndRptMssMtchVO vslRobMthEndRptMssMtchVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmAblogRptLogVO fcmAblogRptLogVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmAblogRptLogVO[] fcmAblogRptLogVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMailingListVO searchMailingListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMailingListVO[] searchMailingListVOs = null;

	private String depRmk = null;

	
	public SearchMailingListVO getSearchMailingListVO() {
		return searchMailingListVO;
	}

	public void setSearchMailingListVO(SearchMailingListVO searchMailingListVO) {
		this.searchMailingListVO = searchMailingListVO;
	}

	public SearchMailingListVO[] getSearchMailingListVOs() {
//		return searchMailingListVOs;
		SearchMailingListVO[] rtnVOs = null;
		if (this.searchMailingListVOs != null) {
			rtnVOs = new SearchMailingListVO[searchMailingListVOs.length];
			System.arraycopy(searchMailingListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchMailingListVOs(SearchMailingListVO[] searchMailingListVOs) {
//		this.searchMailingListVOs = searchMailingListVOs;
		if (searchMailingListVOs != null) {
			SearchMailingListVO[] tmpVOs = new SearchMailingListVO[searchMailingListVOs.length];
			System.arraycopy(searchMailingListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchMailingListVOs = tmpVOs;
		}
	}
	
	public FcmNoonRptLogVO getFcmNoonRptLogVO() {
		return fcmNoonRptLogVO;
	}

	public void setFcmNoonRptLogVO(FcmNoonRptLogVO fcmNoonRptLogVO) {
		this.fcmNoonRptLogVO = fcmNoonRptLogVO;
	}
	
	public FcmNoonRptLogVO[] getFcmNoonRptLogVOs() {
//		return fcmNoonRptLogVOs;
		FcmNoonRptLogVO[] rtnVOs = null;
		if (this.fcmNoonRptLogVOs != null) {
			rtnVOs = new FcmNoonRptLogVO[fcmNoonRptLogVOs.length];
			System.arraycopy(fcmNoonRptLogVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmNoonRptLogVOs(FcmNoonRptLogVO[] fcmNoonRptLogVOs) {
//		this.fcmNoonRptLogVOs = fcmNoonRptLogVOs;
		if (fcmNoonRptLogVOs != null) {
			FcmNoonRptLogVO[] tmpVOs = new FcmNoonRptLogVO[fcmNoonRptLogVOs.length];
			System.arraycopy(fcmNoonRptLogVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmNoonRptLogVOs = tmpVOs;
		}
	}

	public FcmDepRptLogVO getFcmDepRptLogVO() {
		return fcmDepRptLogVO;
	}

	public void setFcmDepRptLogVO(FcmDepRptLogVO fcmDepRptLogVO) {
		this.fcmDepRptLogVO = fcmDepRptLogVO;
	}

	public FcmDepRptLogVO[] getFcmDepRptLogVOs() {
//		return fcmDepRptLogVOs;
		FcmDepRptLogVO[] rtnVOs = null;
		if (this.fcmDepRptLogVOs != null) {
			rtnVOs = new FcmDepRptLogVO[fcmDepRptLogVOs.length];
			System.arraycopy(fcmDepRptLogVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmDepRptLogVOs(FcmDepRptLogVO[] fcmDepRptLogVOs) {
//		this.fcmDepRptLogVOs = fcmDepRptLogVOs;
		if (fcmDepRptLogVOs != null) {
			FcmDepRptLogVO[] tmpVOs = new FcmDepRptLogVO[fcmDepRptLogVOs.length];
			System.arraycopy(fcmDepRptLogVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmDepRptLogVOs = tmpVOs;
		}
	}

	public VslNoonRptVO getVslNoonRptVO() {
		return vslNoonRptVO;
	}

	public VopFcm0001Event(){}
	
	public VslRptInqVO getVslRptInqVO() {
		return vslRptInqVO;
	}

	public void setVslRptInqVO(VslRptInqVO vslRptInqVO) {
		this.vslRptInqVO = vslRptInqVO;
	}
	
	public void setVslNoonRptVO(VslNoonRptVO vslNoonRptVO) {
		this.vslNoonRptVO = vslNoonRptVO;
	}

	public VslNoonRptNotRcvVO getVslNoonRptNotRcvVO() {
		return vslNoonRptNotRcvVO;
	}

	public void setVslNoonRptNotRcvVO(VslNoonRptNotRcvVO vslNoonRptNotRcvVO) {
		this.vslNoonRptNotRcvVO = vslNoonRptNotRcvVO;
	}

	public VslNoonRptMssMtchVO getVslNoonRptMssMtchVO() {
		return vslNoonRptMssMtchVO;
	}

	public void setVslNoonRptMssMtchVO(VslNoonRptMssMtchVO vslNoonRptMssMtchVO) {
		this.vslNoonRptMssMtchVO = vslNoonRptMssMtchVO;
	}

	public VslDepRptVO getVslDepRptVO() {
		return vslDepRptVO;
	}

	public void setVslDepRptVO(VslDepRptVO vslDepRptVO) {
		this.vslDepRptVO = vslDepRptVO;
	}

	public VslDepRptNotRcvVO getVslDepRptNotRcvVO() {
		return vslDepRptNotRcvVO;
	}

	public void setVslDepRptNotRcvVO(VslDepRptNotRcvVO vslDepRptNotRcvVO) {
		this.vslDepRptNotRcvVO = vslDepRptNotRcvVO;
	}

	public VslDepRptMssMtchVO getVslDepRptMssMtchVO() {
		return vslDepRptMssMtchVO;
	}

	public void setVslDepRptMssMtchVO(VslDepRptMssMtchVO vslDepRptMssMtchVO) {
		this.vslDepRptMssMtchVO = vslDepRptMssMtchVO;
	}
	
	public VslDepRptErrVO getVslDepRptErrVO() {
		return vslDepRptErrVO;
	}
	
	public void setVslDepRptMssMtchVO(VslDepRptErrVO vslDepRptErrVO) {
		this.vslDepRptErrVO = vslDepRptErrVO;
	}
	
	public VslDepRptErrVO[] getVslDepRptErrVOs() {
		VslDepRptErrVO[] rtnVOs = null;
		if (this.vslDepRptErrVOs != null) {
			rtnVOs = new VslDepRptErrVO[vslDepRptErrVOs.length];
			System.arraycopy(vslDepRptErrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVslDepRptErrVOs(VslDepRptErrVO[] vslDepRptErrVOs) {
		if (vslDepRptErrVOs != null) {
			VslDepRptErrVO[] tmpVOs = new VslDepRptErrVO[vslDepRptErrVOs.length];
			System.arraycopy(vslDepRptErrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslDepRptErrVOs = tmpVOs;
		}
	}
	
	public VslDepRptOverlapVO getVslDepRptOverlapVO() {
		return vslDepRptOverlapVO;
	}

	public void setVslDepRptOverlapVO(VslDepRptOverlapVO vslDepRptOverlapVO) {
		this.vslDepRptOverlapVO = vslDepRptOverlapVO;
	}
	
	public VslDepRptOverlapVO[] getVslDepRptOverlapVOs() {
		VslDepRptOverlapVO[] rtnVOs = null;
		if (this.vslDepRptOverlapVOs != null) {
			rtnVOs = new VslDepRptOverlapVO[vslDepRptOverlapVOs.length];
			System.arraycopy(vslDepRptOverlapVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVslDepRptOverlapVOs(VslDepRptOverlapVO[] vslDepRptOverlapVOs) {
		if (vslDepRptOverlapVOs != null) {
			VslDepRptOverlapVO[] tmpVOs = new VslDepRptOverlapVO[vslDepRptOverlapVOs.length];
			System.arraycopy(vslDepRptOverlapVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslDepRptOverlapVOs = tmpVOs;
		}
	}
	
	public VslABLogRptVO getVslABLogRptVO() {
		return vslABLogRptVO;
	}

	public void setVslABLogRptVO(VslABLogRptVO vslABLogRptVO) {
		this.vslABLogRptVO = vslABLogRptVO;
	}

	public VslABLogRptNotRcvVO getVslABLogRptNotRcvVO() {
		return vslABLogRptNotRcvVO;
	}

	public void setVslABLogRptNotRcvVO(VslABLogRptNotRcvVO vslABLogRptNotRcvVO) {
		this.vslABLogRptNotRcvVO = vslABLogRptNotRcvVO;
	}

	public VslABLogRptMssMtchVO getVslABLogRptMssMtchVO() {
		return vslABLogRptMssMtchVO;
	}

	public void setVslABLogRptMssMtchVO(VslABLogRptMssMtchVO vslABLogRptMssMtchVO) {
		this.vslABLogRptMssMtchVO = vslABLogRptMssMtchVO;
	}

	public VslRobMthEndRptVO getVslRobMthEndRptVO() {
		return vslRobMthEndRptVO;
	}

	public void setVslRobMthEndRptVO(VslRobMthEndRptVO vslRobMthEndRptVO) {
		this.vslRobMthEndRptVO = vslRobMthEndRptVO;
	}

	public VslRobMthEndRptNotRcvVO getVslRobMthEndRptNotRcvVO() {
		return vslRobMthEndRptNotRcvVO;
	}

	public void setVslRobMthEndRptNotRcvVO(
			VslRobMthEndRptNotRcvVO vslRobMthEndRptNotRcvVO) {
		this.vslRobMthEndRptNotRcvVO = vslRobMthEndRptNotRcvVO;
	}

	public VslRobMthEndRptMssMtchVO getVslRobMthEndRptMssMtchVO() {
		return vslRobMthEndRptMssMtchVO;
	}

	public void setVslRobMthEndRptMssMtchVO(
			VslRobMthEndRptMssMtchVO vslRobMthEndRptMssMtchVO) {
		this.vslRobMthEndRptMssMtchVO = vslRobMthEndRptMssMtchVO;
	}

	public FcmAblogRptLogVO getFcmAblogRptLogVO() {
		return fcmAblogRptLogVO;
	}

	public void setFcmAblogRptLogVO(FcmAblogRptLogVO fcmAblogRptLogVO) {
		this.fcmAblogRptLogVO = fcmAblogRptLogVO;
	}

	public FcmAblogRptLogVO[] getFcmAblogRptLogVOs() {
//		return fcmAblogRptLogVOs;
		FcmAblogRptLogVO[] rtnVOs = null;
		if (this.fcmAblogRptLogVOs != null) {
			rtnVOs = new FcmAblogRptLogVO[fcmAblogRptLogVOs.length];
			System.arraycopy(fcmAblogRptLogVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFcmAblogRptLogVOs(FcmAblogRptLogVO[] fcmAblogRptLogVOs) {
//		this.fcmAblogRptLogVOs = fcmAblogRptLogVOs;
		if (fcmAblogRptLogVOs != null) {
			FcmAblogRptLogVO[] tmpVOs = new FcmAblogRptLogVO[fcmAblogRptLogVOs.length];
			System.arraycopy(fcmAblogRptLogVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmAblogRptLogVOs = tmpVOs;
		}
	}
	
	public String getDepRmk() {
		return depRmk;
	}

	public void setDepRmk(String depRmk) {
		this.depRmk = depRmk;
	}

}