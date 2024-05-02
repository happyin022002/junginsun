/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0019Event.java
*@FileTitle : Requested Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeSumVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoChargeVO;


/**
 * VOP_PSO-0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoChargeVO psoChargeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoChargeVO[] psoChargeVOs = null;

	/** PopUp Open시 조건 VO*/
	private CanalTzFeeSumVO canalTzFeeSumVO = null;
	/** PopUp Open시 조건 VO*/
	private CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO = null;

	/** invoice no 생성용 vo*/
	private CanalTzFeeHdVO canalTzFeeHdVO;

	/**invoice생성용 VO*/
	private AuditDataValidVO[] auditDataValidVOs;

	/** reject용 VO*/
	private CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO;

	/** Invoice Number */
	private String invNo;

	/** Invoice Register Number*/
	private String invRgstNo;

	public String getInvRgstNo() {
		return invRgstNo;
	}

	public String getInvNo() {
		return invNo;
	}

	/**
	 * Reject VO getter
	 * @return
	 */
	public CanalTzFeeEstDtlByVvdCondVO getCanalTzFeeEstDtlByVvdCondVO() {
		return canalTzFeeEstDtlByVvdCondVO;
	}

	/**
	 * Invoice 생성용 VO getter
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
	 * invoice no 생성용 vo getter
	 * @return
	 */
	public CanalTzFeeHdVO getCanalTzFeeHdVO() {
		return canalTzFeeHdVO;
	}

	/**
	 * Condition VO의 getter
	 * @return
	 */
	public CanalTzFeeInvDtlCondVO getCanalTzFeeInvDtlCondVO() {
		return canalTzFeeInvDtlCondVO;
	}

	/**
	 *  조회 조건 VO getter
	 * @return
	 */
	public CanalTzFeeSumVO getCanalTzFeeSumVO() {
		return canalTzFeeSumVO;
	}

	public VopPso0019Event(){}
	
	public void setPsoChargeVO(PsoChargeVO psoChargeVO){
		this. psoChargeVO = psoChargeVO;
	}

	public void setPsoChargeVOS(PsoChargeVO[] psoChargeVOs){
		if (psoChargeVOs != null) {
			PsoChargeVO[] tmpVOs = new PsoChargeVO[psoChargeVOs.length];
			System.arraycopy(psoChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoChargeVOs = tmpVOs;
		}
	}

	public PsoChargeVO getPsoChargeVO(){
		return psoChargeVO;
	}

	public PsoChargeVO[] getPsoChargeVOS(){
		PsoChargeVO[] tmpVOs = null;
		if (this.psoChargeVOs != null) {
			tmpVOs = new PsoChargeVO[psoChargeVOs.length];
			System.arraycopy(psoChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param vo
	 */
	public void setCanalTzFeeSumVO(CanalTzFeeSumVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeSumVO = vo;
	}

	/**
	 * Condtion VO setter
	 * @param vo
	 */
	public void setCanalTzFeeInvDtlCondVO(CanalTzFeeInvDtlCondVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeInvDtlCondVO = vo;
	}

	/**
	 * invoice생성사용VO setter
	 * @param vo
	 */
	public void setCanalTzFeeHdVO(CanalTzFeeHdVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeHdVO = vo;
	}

	/**
	 * Invoce생성용 VO setter.
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
	 * Reject처리를 위한 .. Condition vo 설정 
	 * @param vo
	 */
	public void setCanalTzFeeEstDtlByVvdCondVO(CanalTzFeeEstDtlByVvdCondVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeEstDtlByVvdCondVO = vo;
	}

	public void setInvNo(String invNo) {
		// TODO Auto-generated method stub
		this.invNo = invNo;
	}

	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}

}