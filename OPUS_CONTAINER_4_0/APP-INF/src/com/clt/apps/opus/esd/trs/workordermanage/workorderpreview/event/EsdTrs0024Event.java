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
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event;

import java.util.HashMap;

import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdPrvTmpVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

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
	private static final long serialVersionUID = -4720631949554514578L;

	TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs = null;
	TrsTrspWrkOrdPrvTmpVO[] trsTrspWrkOrdPrvTmpVOs = null;
	TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;

	WorkOrderPreviewVO workOrderPreviewVO = null;
	WorkOrderPreviewVO[] workOrderPreviewVOs = null;

	/** trs_trsp_wrk_ord Table Value Object */
	private TrsTrspWrkOrdPrvTmpVO trsTrspWrkOrdPrvTmpVO = null;

	/** trs_trsp_svc_ord Table Value Object */
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;

	/** trs_trsp_wrk_ord Table Value Object */
	private TrsTrspWrkOrdVO trsTrspWrkOrdVO = null;

	String groupSeq = "";
	String formCreUsrId = "";
	String formUsrOfcCd = "";

	String pWoNo = null;
	String pwoPrvGrpSeq = null;
	String rdserverIp = null;

	@SuppressWarnings("rawtypes")
	private HashMap hashParam = new HashMap();

	public EsdTrs0024Event() {
	}

	/**
	 * @return the trsTrspWrkOrdVOs
	 */
	public TrsTrspWrkOrdVO[] getTrsTrspWrkOrdVOs() {
		TrsTrspWrkOrdVO[] tmpVo = null;
		if (this.trsTrspWrkOrdVOs != null) {
			tmpVo = new TrsTrspWrkOrdVO[this.trsTrspWrkOrdVOs.length];
			System.arraycopy(this.trsTrspWrkOrdVOs, 0, tmpVo, 0, tmpVo.length);
		}
		return tmpVo;
	}

	/**
	 * @param trsTrspWrkOrdVOs the trsTrspWrkOrdVOs to set
	 */
	public void setTrsTrspWrkOrdVOs(TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs) {
		if (trsTrspWrkOrdVOs != null) {
			TrsTrspWrkOrdVO[] tmpVo = new TrsTrspWrkOrdVO[trsTrspWrkOrdVOs.length];
			System.arraycopy(trsTrspWrkOrdVOs, 0, tmpVo, 0, tmpVo.length);
			this.trsTrspWrkOrdVOs = tmpVo;
		}
	}

	/**
	 * @return the trsTrspWrkOrdPrvTmpVOs
	 */
	public TrsTrspWrkOrdPrvTmpVO[] getTrsTrspWrkOrdPrvTmpVOs() {
		TrsTrspWrkOrdPrvTmpVO[] tmpVo = null;
		if (this.trsTrspWrkOrdPrvTmpVOs != null) {
			tmpVo = new TrsTrspWrkOrdPrvTmpVO[this.trsTrspWrkOrdPrvTmpVOs.length];
			System.arraycopy(this.trsTrspWrkOrdPrvTmpVOs, 0, tmpVo, 0, tmpVo.length);
		}
		return tmpVo;
	}

	/**
	 * @param trsTrspWrkOrdPrvTmpVOs the trsTrspWrkOrdPrvTmpVOs to set
	 */
	public void setTrsTrspWrkOrdPrvTmpVOs(TrsTrspWrkOrdPrvTmpVO[] trsTrspWrkOrdPrvTmpVOs) {
		if (trsTrspWrkOrdPrvTmpVOs != null) {
			TrsTrspWrkOrdPrvTmpVO[] tmpVo = new TrsTrspWrkOrdPrvTmpVO[trsTrspWrkOrdPrvTmpVOs.length];
			System.arraycopy(trsTrspWrkOrdPrvTmpVOs, 0, tmpVo, 0, tmpVo.length);
			this.trsTrspWrkOrdPrvTmpVOs = tmpVo;
		}
	}

	/**
	 * @return the trsTrspSvcOrdVOs
	 */
	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		TrsTrspSvcOrdVO[] tmpVo = null;
		if (this.trsTrspSvcOrdVOs != null) {
			tmpVo = new TrsTrspSvcOrdVO[this.trsTrspSvcOrdVOs.length];
			System.arraycopy(this.trsTrspSvcOrdVOs, 0, tmpVo, 0, tmpVo.length);
		}
		return tmpVo;
	}

	/**
	 * @param trsTrspSvcOrdVOs the trsTrspSvcOrdVOs to set
	 */
	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs) {
		if (trsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVo = new TrsTrspSvcOrdVO[trsTrspSvcOrdVOs.length];
			System.arraycopy(trsTrspSvcOrdVOs, 0, tmpVo, 0, tmpVo.length);
			this.trsTrspSvcOrdVOs = tmpVo;
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
	public void setWorkOrderPreviewVO(WorkOrderPreviewVO workOrderPreviewVO) {
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
	@SuppressWarnings("rawtypes")
	public HashMap getHashParam() {
		return hashParam;
	}

	/**
	 * @param hashParam the hashParam to set
	 */
	@SuppressWarnings("rawtypes")
	public void setHashParam(HashMap hashParam) {
		this.hashParam = hashParam;
	}

	public String getpWoNo() {
		return pWoNo;
	}

	public void setpWoNo(String pWoNo) {
		this.pWoNo = pWoNo;
	}

	public String getPwoPrvGrpSeq() {
		return pwoPrvGrpSeq;
	}

	public void setPwoPrvGrpSeq(String pwoPrvGrpSeq) {
		this.pwoPrvGrpSeq = pwoPrvGrpSeq;
	}

	public String getRdserverIp() {
		return rdserverIp;
	}

	public void setRdserverIp(String rdserverIp) {
		this.rdserverIp = rdserverIp;
	}

	/**
	 * @return the workOrderPreviewVOs
	 */
	public WorkOrderPreviewVO[] getWorkOrderPreviewVOs() {
		WorkOrderPreviewVO[] tmpVo = null;
		if (this.workOrderPreviewVOs != null) {
			tmpVo = new WorkOrderPreviewVO[this.workOrderPreviewVOs.length];
			System.arraycopy(this.workOrderPreviewVOs, 0, tmpVo, 0, tmpVo.length);
		}
		return tmpVo;
	}

	/**
	 * @param workOrderPreviewVOs the workOrderPreviewVOs to set
	 */
	public void setWorkOrderPreviewVOs(WorkOrderPreviewVO[] workOrderPreviewVOs) {
		if (workOrderPreviewVOs != null) {
			WorkOrderPreviewVO[] tmpVo = new WorkOrderPreviewVO[workOrderPreviewVOs.length];
			System.arraycopy(workOrderPreviewVOs, 0, tmpVo, 0, tmpVo.length);
			this.workOrderPreviewVOs = tmpVo;
		}
	}
}
