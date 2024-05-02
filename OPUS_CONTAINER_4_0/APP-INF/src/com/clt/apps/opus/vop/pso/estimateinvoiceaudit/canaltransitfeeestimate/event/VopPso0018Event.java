/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VopPso0018Event.java
 *@FileTitle : Requested Advance Payment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 김진일
 *@LastVersion : 1.0
 * 2009.06.15 김진일
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoMsaDtlVO;
import com.clt.syscommon.common.table.PsoMsaVO;

/**
 * VOP_PSO-0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_PSO-0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PsoMsaVO psoMsaVO = null;

	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PsoMsaDtlVO psoMsaDtlVO = null;

	/** Table Value Object Multi Data 처리 */
	private PsoMsaDtlVO[] psoMsaDtlVOs = null;

	/** 조회 조건에 사용될 필드 */
	private String vvd;
	private String payTo;

	/* InvoNo Creation 시 조회 조건 vo */
	private CanalTzFeeHdVO canalTzFeeHdVO = null;
	/* Invoice Creation시 조회 조건 */
	private AuditDataValidVO[] auditDataValidVOs;

	/* 조회조건 VO */
	private CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO;

	/** Invoice Number */
	private String invNo;

	/** Inv Register Number */
	private String invRgstNo;

	public String getInvRgstNo() {
		return invRgstNo;
	}

	public String getInvNo() {
		return invNo;
	}

	/**
	 * 조회조건 VO Getter
	 * 
	 * @return
	 */
	public CanalTzFeeEstDtlByVvdCondVO getCanalTzFeeEstDtlByVvdCondVO() {
		return canalTzFeeEstDtlByVvdCondVO;
	}

	public VopPso0018Event() {
	}

	/**
	 * Requested Advanced Payment InvoNo조회 vo getter
	 * 
	 * @category VOP_PSO_0018_confirm_click
	 * @return canalTzFeeHdVO
	 */
	public CanalTzFeeHdVO getCanalTzFeeHdVO() {
		return this.canalTzFeeHdVO;
	}

	/**
	 * Requested Advanced Payment InvoNo조회 vo setter
	 * 
	 * @category VOP_PSO_0018_confirm_click
	 * @param vo
	 */
	public void setCanalTzFeeHdVO(CanalTzFeeHdVO canalTzFeeHdVO) {
		// TODO Auto-generated method stub
		this.canalTzFeeHdVO = canalTzFeeHdVO;
	}

	public void setPsoMsaVO(PsoMsaVO psoMsaVO) {
		this.psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs) {
		if (psoMsaVOs != null) {
			PsoMsaVO[] tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoMsaVOs = tmpVOs;
		}
	}

	public void setPsoMsaDtlVO(PsoMsaDtlVO psoMsaDtlVO) {
		this.psoMsaDtlVO = psoMsaDtlVO;
	}

	public void setPsoMsaDtlVOS(PsoMsaDtlVO[] psoMsaDtlVOs) {
		if (psoMsaDtlVOs != null) {
			PsoMsaDtlVO[] tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs.length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoMsaDtlVOs = tmpVOs;
		}
	}

	public PsoMsaVO getPsoMsaVO() {
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS() {
		PsoMsaVO[] tmpVOs = null;
		if (this.psoMsaVOs != null) {
			tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PsoMsaDtlVO getPsoMsaDtlVO() {
		return psoMsaDtlVO;
	}

	public PsoMsaDtlVO[] getPsoMsaDtlVOS() {
		PsoMsaDtlVO[] tmpVOs = null;
		if (this.psoMsaDtlVOs != null) {
			tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs.length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * VVD정보를 리턴한다.
	 * 
	 * @return
	 */
	public String getVvd() {
		// TODO Auto-generated method stub
		return this.vvd;
	}

	/**
	 * VVD정보 setter
	 * 
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * PayTo(vendor_seq)정보를 리턴 한다.
	 * 
	 * @return
	 */
	public String getPayTo() {
		// TODO Auto-generated method stub
		return payTo;
	}

	/**
	 * payTo정보의 setter
	 * 
	 * @param payTo
	 */
	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	/**
	 * Invoice Creation 조건 vo list getter
	 * 
	 * @return
	 */
	public AuditDataValidVO[] getAuditDataValidVOs() {
		AuditDataValidVO[] tmpVOs = null;
		if (this.auditDataValidVOs != null) {
			tmpVOs = new AuditDataValidVO[auditDataValidVOs.length];
			System.arraycopy(auditDataValidVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * Invoice Creation 조건 vo list setter
	 * 
	 * @param os
	 */
	public void setAuditDataValidVOs(AuditDataValidVO[] auditDataValidVOs) {
		if (auditDataValidVOs != null) {
			AuditDataValidVO[] tmpVOs = new AuditDataValidVO[auditDataValidVOs.length];
			System.arraycopy(auditDataValidVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.auditDataValidVOs = tmpVOs;
		}
	}

	/**
	 * 메인 조회 조건
	 * 
	 * @category VOP_PSO_0018_searchcond_voset
	 * @param vo
	 */
	public void setCanalTzFeeEstDtlByVvdCondVO(CanalTzFeeEstDtlByVvdCondVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeEstDtlByVvdCondVO = vo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}

}