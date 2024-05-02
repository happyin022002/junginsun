/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000303Event.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;


/**
 * ESM_PRI_0003_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpCmdtVO priSpScpGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpCmdtDtlListVO rsltGrpCmdtDtlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGrpCmdtDtlListVO[] rsltGrpCmdtDtlListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpCmdtListVO rsltGrpCmdtListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGrpCmdtListVO[] rsltGrpCmdtListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GrpCmdtPropVO grpCmdtPropVO = null;
	
	private String propNo = null;
	
	private String amdtSeq = null;
	
	private String svcScpCd = null;	

	public EsmPri000303Event(){}
	
	public void setPriSpScpGrpCmdtDtlVO(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO){
		this. priSpScpGrpCmdtDtlVO = priSpScpGrpCmdtDtlVO;
	}

	public void setPriSpScpGrpCmdtDtlVOS(PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs){
		if (priSpScpGrpCmdtDtlVOs != null) {
			PriSpScpGrpCmdtDtlVO[] tmpVOs = new PriSpScpGrpCmdtDtlVO[priSpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priSpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGrpCmdtDtlVOs = tmpVOs;
		}
	}


	public void setPriSpScpGrpCmdtVO(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO){
		this. priSpScpGrpCmdtVO = priSpScpGrpCmdtVO;
	}

	public void setPriSpScpGrpCmdtVOS(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs){
		if (priSpScpGrpCmdtVOs != null) {
			PriSpScpGrpCmdtVO[] tmpVOs = new PriSpScpGrpCmdtVO[priSpScpGrpCmdtVOs.length];
			System.arraycopy(priSpScpGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGrpCmdtVOs = tmpVOs;
		}
	}

	public PriSpScpGrpCmdtDtlVO getPriSpScpGrpCmdtDtlVO(){
		return priSpScpGrpCmdtDtlVO;
	}

	public PriSpScpGrpCmdtDtlVO[] getPriSpScpGrpCmdtDtlVOS(){
		PriSpScpGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priSpScpGrpCmdtDtlVOs != null) {
			tmpVOs = new PriSpScpGrpCmdtDtlVO[priSpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priSpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpGrpCmdtVO getPriSpScpGrpCmdtVO(){
		return priSpScpGrpCmdtVO;
	}

	public PriSpScpGrpCmdtVO[] getPriSpScpGrpCmdtVOS(){
		PriSpScpGrpCmdtVO[] tmpVOs = null;
		if (this.priSpScpGrpCmdtVOs != null) {
			tmpVOs = new PriSpScpGrpCmdtVO[priSpScpGrpCmdtVOs.length];
			System.arraycopy(priSpScpGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @return the rsltGrpCmdtDtlListVO
	 */
	public RsltGrpCmdtDtlListVO getRsltGrpCmdtDtlListVO() {
		return rsltGrpCmdtDtlListVO;
	}

	/**
	 * @return the rsltGrpCmdtDtlListVOs
	 */
	public RsltGrpCmdtDtlListVO[] getRsltGrpCmdtDtlListVOs() {
		RsltGrpCmdtDtlListVO[] tmpVOs = null;
		if (this.rsltGrpCmdtDtlListVOs != null) {
			tmpVOs = new RsltGrpCmdtDtlListVO[rsltGrpCmdtDtlListVOs.length];
			System.arraycopy(rsltGrpCmdtDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @return the rsltGrpCmdtListVO
	 */
	public RsltGrpCmdtListVO getRsltGrpCmdtListVO() {
		return rsltGrpCmdtListVO;
	}

	/**
	 * @return the rsltGrpCmdtListVOs
	 */
	public RsltGrpCmdtListVO[] getRsltGrpCmdtListVOs() {
		RsltGrpCmdtListVO[] tmpVOs = null;
		if (this.rsltGrpCmdtListVOs != null) {
			tmpVOs = new RsltGrpCmdtListVO[rsltGrpCmdtListVOs.length];
			System.arraycopy(rsltGrpCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param rsltGrpCmdtDtlListVO the rsltGrpCmdtDtlListVO to set
	 */
	public void setRsltGrpCmdtDtlListVO(RsltGrpCmdtDtlListVO rsltGrpCmdtDtlListVO) {
		this.rsltGrpCmdtDtlListVO = rsltGrpCmdtDtlListVO;
	}

	/**
	 * @param rsltGrpCmdtDtlListVOs the rsltGrpCmdtDtlListVOs to set
	 */
	public void setRsltGrpCmdtDtlListVOs(	RsltGrpCmdtDtlListVO[] rsltGrpCmdtDtlListVOs) {
		if (rsltGrpCmdtDtlListVOs != null) {
			RsltGrpCmdtDtlListVO[] tmpVOs = new RsltGrpCmdtDtlListVO[rsltGrpCmdtDtlListVOs.length];
			System.arraycopy(rsltGrpCmdtDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpCmdtDtlListVOs = tmpVOs;
		}
	}

	/**
	 * @param rsltGrpCmdtListVO the rsltGrpCmdtListVO to set
	 */
	public void setRsltGrpCmdtListVO(RsltGrpCmdtListVO rsltGrpCmdtListVO) {
		this.rsltGrpCmdtListVO = rsltGrpCmdtListVO;
	}

	/**
	 * @param rsltGrpCmdtListVOs the rsltGrpCmdtListVOs to set
	 */
	public void setRsltGrpCmdtListVOs(RsltGrpCmdtListVO[] rsltGrpCmdtListVOs) {
		if (rsltGrpCmdtListVOs != null) {
			RsltGrpCmdtListVO[] tmpVOs = new RsltGrpCmdtListVO[rsltGrpCmdtListVOs.length];
			System.arraycopy(rsltGrpCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpCmdtListVOs = tmpVOs;
		}
	}

	public GrpCmdtPropVO getGrpCmdtPropVO() {
		return grpCmdtPropVO;
	}

	public void setGrpCmdtPropVO(GrpCmdtPropVO grpCmdtPropVO) {
		this.grpCmdtPropVO = grpCmdtPropVO;
	}
	
	public String getPropNo() {
		return propNo;
	}

	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}	
	
	public String getAmdtSeq() {
		return amdtSeq;
	}

	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}	
	
	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}		

}