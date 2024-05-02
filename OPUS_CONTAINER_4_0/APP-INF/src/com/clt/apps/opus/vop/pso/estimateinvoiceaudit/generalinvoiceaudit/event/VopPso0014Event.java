/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0014Event.java
*@FileTitle : Invoice Creation N' Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.28 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoChargeVO;


/**
 * VOP_PSO-0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoChargeVO psoChargeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoChargeVO[] psoChargeVOs = null;

	/** PORT_SKD에 존재하는 확인할 정보*/
	private String vslCd;
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/** PORT_SKD에 존재하는 확인할 정보*/
	private String skdVoyNo;
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/** PORT_SKD에 존재하는 확인할 정보*/
	private String skdDirCd;	
	
	/** Double Pay Check : VVD/Cost_cd/Cost_ofc/YD_CD로 해서 기존 Invoice 생성 되었는지 체크 */
	private String costOfcCd;

	/** Calc 를 위한조회 조건  */
	private String vndrSeq;
	private String lgsCostCd;
	private String issDt;
	private String ydCd;

	/** Multi Data 처리를 위한 VO 배열*/
	private InvAuditDataValidVO[] auditDataValidVOs;
    /** Sheet 조회를 위한 조회 조건 VO*/
	private InvAuditDataValidVO invAuditDataValidVO;
	/** 삭제 처리를 위한 조건*/
	private String invNo;

	private String rcvDt;

	private String currCd;

	private String psoChgStsCd;

	private String ioFlag;

	//Grid 한 로우에 대해 계산 로직을 적용하기 위해 현재 선택된 Row의 Index를 보유한다.
	private String rowIdx;
	
	//NYK Modify 2014.10.31 Canal flag
	private String spCalAngFlg;
	
	//NYK Modify 2014.12.03 Defalut Vsl CD
	private String dftVslCd;

	private String existDtlYn;
	
	private String clptIndSeq; //2016.04.26 Double calling port Add 
	
	/**
	 * @return the clptIndSeq
	 */
	public String getClptIndSeq() {
		return clptIndSeq;
	}

	/**
	 * @param clptIndSeq the clptIndSeq to set
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	public String getExistDtlYn() {
		return existDtlYn;
	}

	public void setExistDtlYn(String existDtlYn) {
		this.existDtlYn = existDtlYn;
	}

	public String getDftVslCd() {
		return dftVslCd;
	}

	public void setDftVslCd(String dftVslCd) {
		this.dftVslCd = dftVslCd;
	}

	public String getSpCalAngFlg() {
		return spCalAngFlg;
	}

	public void setSpCalAngFlg(String spCalAngFlg) {
		this.spCalAngFlg = spCalAngFlg;
	}

	public String getRowIdx() {
		return rowIdx;
	}

	public String getIoFlag() {
		return ioFlag;
	}

	public String getPsoChgStsCd() {
		return psoChgStsCd;
	}

	public String getCurrCd() {
		return currCd;
	}

	public String getRcvDt() {
		return rcvDt;
	}

	/**
	 * 삭제 처리를 위한 invNo 의 getter
	 * @return
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * 조회 조건 VO getter
	 * @return
	 */
	public InvAuditDataValidVO getInvAuditDataValidVO() {
		return invAuditDataValidVO;
	}

	/**
	 * @return the costOfcCd
	 */
	public String getCostOfcCd() {
		return costOfcCd;
	}

	/**
	 * @param costOfcCd the costOfcCd to set
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}

	/**
	 * sheet Object 의 내용을 저장하고 있는 VO getter
	 * @return
	 */
	public InvAuditDataValidVO[] getAuditDataValidVOs() {
		InvAuditDataValidVO[] tmpVOs = null;
		if (this.auditDataValidVOs != null) {
			tmpVOs = new InvAuditDataValidVO[auditDataValidVOs.length];
			System.arraycopy(auditDataValidVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public String getYdCd() {
		return ydCd;
	}

	public String getIssDt() {
		return issDt;
	}

	public String getLgsCostCd() {
		return lgsCostCd;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public VopPso0014Event(){}
	
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

	public String getVslCd() {
		// TODO Auto-generated method stub
		return this.vslCd;
	}

	public String getSkdVoyNo() {
		// TODO Auto-generated method stub
		return this.skdVoyNo;
	}

	public String getSkdDirCd() {
		// TODO Auto-generated method stub
		return this.skdDirCd;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq ;
	}

	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * sheet 저장 내역을 담고 있는 VO의 setter 
	 * @param auditDataValidVOs
	 */
	public void setAuditDataValidVOs(InvAuditDataValidVO[] auditDataValidVOs) {
		if (auditDataValidVOs != null) {
			InvAuditDataValidVO[] tmpVOs = new InvAuditDataValidVO[auditDataValidVOs.length];
			System.arraycopy(auditDataValidVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.auditDataValidVOs = tmpVOs;
		}
	}

	/**
	 * Sheet 조회를 위한 조회 조건 저장 VO
	 * @param invAuditDataValidVO
	 */
	public void setInvAuditDataValidVO(InvAuditDataValidVO invAuditDataValidVO) {
		// TODO Auto-generated method stub
		this.invAuditDataValidVO = invAuditDataValidVO;
	}

	/**
	 * 삭제 처리 조건인 invNo 의 setter
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public void setRcvDt(String rcvDt) {
		// TODO Auto-generated method stub
		this.rcvDt = rcvDt;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;	
	}

	public void setPsoChgStsCd(String psoChgStsCd) {
		this.psoChgStsCd = psoChgStsCd;
	}

	public void setIoFlag(String ioFlag) {
		this.ioFlag = ioFlag; 
	}

	public void setRowIdx(String rowIdx) {
		this.rowIdx = rowIdx;
	}

}