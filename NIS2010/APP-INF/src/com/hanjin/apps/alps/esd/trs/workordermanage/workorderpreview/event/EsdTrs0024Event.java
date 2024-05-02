/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_024Event.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-06 poong_yeon
* 1.0 최초 생성
* 1.8 2011.02.08 이재위 [CHM-201108673-01] [TRS] Work Order Issue(ESD_TRS_0023) : W/O Preview per B/L 기능 개발
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdPrvTmpVO;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;


/**
 * ESD_TRS_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0024Event extends EventSupport {
	
	TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs 					= null;
	TrsTrspWrkOrdPrvTmpVO[] trsTrspWrkOrdPrvTmpVOs 		= null;
	TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs					= null; 
	
	WorkOrderPreviewVO workOrderPreviewVO	= null;
	
	/** trs_trsp_wrk_ord Table  Value Object */
	private TrsTrspWrkOrdPrvTmpVO trsTrspWrkOrdPrvTmpVO = null;
	
	/** trs_trsp_svc_ord Table  Value Object */
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;
	
	/** trs_trsp_wrk_ord Table  Value Object */
	private TrsTrspWrkOrdVO trsTrspWrkOrdVO = null;
	
	String groupSeq 	= "";
	String woPrvGrpBlFlg 	= "";
	String formCreUsrId = "";
	String formUsrOfcCd = "";

	// CHM-201536387 ALPS Auth 사후 결재 기능 개발
	String scgGrpSeq = "";
	String authAproRqstNo = "";
	
	private HashMap hashParam = new HashMap();
	
	public EsdTrs0024Event(){}

	/**
	 * @return the trsTrspWrkOrdVOs
	 */
	public TrsTrspWrkOrdVO[] getTrsTrspWrkOrdVOs() {
		TrsTrspWrkOrdVO [] rtnVOs = null;
		if (this.trsTrspWrkOrdVOs != null) {
			rtnVOs = new TrsTrspWrkOrdVO[trsTrspWrkOrdVOs.length];
			System.arraycopy(trsTrspWrkOrdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param trsTrspWrkOrdVOs the trsTrspWrkOrdVOs to set
	 */
	public void setTrsTrspWrkOrdVOs(TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs) {
		if (trsTrspWrkOrdVOs != null) {
			TrsTrspWrkOrdVO[] tmpVOs = new TrsTrspWrkOrdVO[trsTrspWrkOrdVOs.length];
			System.arraycopy(trsTrspWrkOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsTrspWrkOrdVOs = tmpVOs;
		}
	}

	/**
	 * @return the trsTrspWrkOrdPrvTmpVOs
	 */
	public TrsTrspWrkOrdPrvTmpVO[] getTrsTrspWrkOrdPrvTmpVOs() {
		TrsTrspWrkOrdPrvTmpVO [] rtnVOs = null;
		if (this.trsTrspWrkOrdPrvTmpVOs != null) {
			rtnVOs = new TrsTrspWrkOrdPrvTmpVO[trsTrspWrkOrdPrvTmpVOs.length];
			System.arraycopy(trsTrspWrkOrdPrvTmpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param trsTrspWrkOrdPrvTmpVOs the trsTrspWrkOrdPrvTmpVOs to set
	 */
	public void setTrsTrspWrkOrdPrvTmpVOs(
			TrsTrspWrkOrdPrvTmpVO[] trsTrspWrkOrdPrvTmpVOs) {
		if (trsTrspWrkOrdPrvTmpVOs != null) {
			TrsTrspWrkOrdPrvTmpVO[] tmpVOs = new TrsTrspWrkOrdPrvTmpVO[trsTrspWrkOrdPrvTmpVOs.length];
			System.arraycopy(trsTrspWrkOrdPrvTmpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsTrspWrkOrdPrvTmpVOs = tmpVOs;
		}
	}

//	public void setTrsTrspWrkOrdPrvTmpVOs(Collection trsTrspWrkOrdPrvTmpVO){
//		this.trsTrspWrkOrdPrvTmpVO = trsTrspWrkOrdPrvTmpVO;
//	}
	
	/**
	 * @return the trsTrspSvcOrdVOs
	 */
	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		TrsTrspSvcOrdVO [] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param trsTrspSvcOrdVOs the trsTrspSvcOrdVOs to set
	 */
	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs) {
		if (trsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		}
	}

	/**
	 * @return the trsTrspWrkOrdPrvTmpVO
	 */
	public TrsTrspWrkOrdPrvTmpVO getTrsTrspWrkOrdPrvTmpVO() {
		return trsTrspWrkOrdPrvTmpVO;
	}

	/**
	 * @param trsTrspWrkOrdPrvTmpVO the trsTrspWrkOrdPrvTmpVO to set
	 */
	public void setTrsTrspWrkOrdPrvTmpVO(TrsTrspWrkOrdPrvTmpVO trsTrspWrkOrdPrvTmpVO) {
		this.trsTrspWrkOrdPrvTmpVO = trsTrspWrkOrdPrvTmpVO;
	}

	/**
	 * @return the trsTrspSvcOrdVO
	 */
	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	/**
	 * @param trsTrspSvcOrdVO the trsTrspSvcOrdVO to set
	 */
	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO trsTrspSvcOrdVO) {
		this.trsTrspSvcOrdVO = trsTrspSvcOrdVO;
	}

	/**
	 * @return the trsTrspWrkOrdVO
	 */
	public TrsTrspWrkOrdVO getTrsTrspWrkOrdVO() {
		return trsTrspWrkOrdVO;
	}

	/**
	 * @param trsTrspWrkOrdVO the trsTrspWrkOrdVO to set
	 */
	public void setTrsTrspWrkOrdVO(TrsTrspWrkOrdVO trsTrspWrkOrdVO) {
		this.trsTrspWrkOrdVO = trsTrspWrkOrdVO;
	}

	/**
	 * @return the workOrderPreviewVO
	 */
	public WorkOrderPreviewVO getWorkOrderPreviewVO() {
		return workOrderPreviewVO;
	}

	/**
	 * @param workOrderPreviewVO the workOrderPreviewVO to set
	 */
	public void setWorkOrderPreviewVO(
			WorkOrderPreviewVO workOrderPreviewVO) {
		this.workOrderPreviewVO = workOrderPreviewVO;
	}

	/**
	 * @return the groupSeq
	 */
	public String getGroupSeq() {
		return groupSeq;
	}

	/**
	 * @param groupSeq the groupSeq to set
	 */
	public void setGroupSeq(String groupSeq) {
		this.groupSeq = groupSeq;
	}
	
	/**
	 * @return the woPrvGrpBlFlg
	 */
	public String getWoPrvGrpBlFlg() {
		return woPrvGrpBlFlg;
	}
	
	/**
	 * @param woPrvGrpBlFlg the woPrvGrpBlFlg to set
	 */
	public void setWoPrvGrpBlFlg(String woPrvGrpBlFlg) {
		this.woPrvGrpBlFlg = woPrvGrpBlFlg;
	}

	/**
	 * @return the formCreUsrId
	 */
	public String getFormCreUsrId() {
		return formCreUsrId;
	}

	/**
	 * @param formCreUsrId the formCreUsrId to set
	 */
	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	/**
	 * @return the formUsrOfcCd
	 */
	public String getFormUsrOfcCd() {
		return formUsrOfcCd;
	}

	/**
	 * @param formUsrOfcCd the formUsrOfcCd to set
	 */
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String toString() {
		return "EsdTrs0024Event";
	}

	/**
	 * @return the hashParam
	 */
	public HashMap getHashParam() {
		return hashParam;
	}
	
	/**
	 * @param hashParam the hashParam to set
	 */
	public void setHashParam(HashMap hashParam) {
		this.hashParam = hashParam;
	}

	/**
	 * @return the scgGrpSeq
	 */
	public String getScgGrpSeq() {
		return scgGrpSeq;
	}

	/**
	 * @param scgGrpSeq the scgGrpSeq to set
	 */
	public void setScgGrpSeq(String scgGrpSeq) {
		this.scgGrpSeq = scgGrpSeq;
	}

	/**
	 * @return the authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	/**
	 * @param authAproRqstNo the authAproRqstNo to set
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}
}
