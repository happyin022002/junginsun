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
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtVO;


/**
 * ESM_PRI_2003_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2003_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2003_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri200303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpCmdtVO priRpScpGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs = null;
	
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

	public EsmPri200303Event(){}
	
	public void setPriRpScpGrpCmdtDtlVO(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO){
		this. priRpScpGrpCmdtDtlVO = priRpScpGrpCmdtDtlVO;
	}

	public void setPriRpScpGrpCmdtDtlVOS(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs){
		if (priRpScpGrpCmdtDtlVOs != null) {
			PriRpScpGrpCmdtDtlVO[] tmpVOs = new PriRpScpGrpCmdtDtlVO[priRpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priRpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpGrpCmdtDtlVOs = tmpVOs;
		}
	}

	public void setPriRpScpGrpCmdtVO(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO){
		this. priRpScpGrpCmdtVO = priRpScpGrpCmdtVO;
	}

	public void setPriRpScpGrpCmdtVOS(PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs){
		if (priRpScpGrpCmdtVOs != null) {
			PriRpScpGrpCmdtVO[] tmpVOs = new PriRpScpGrpCmdtVO[priRpScpGrpCmdtVOs.length];
			System.arraycopy(priRpScpGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpGrpCmdtVOs = tmpVOs;
		}
	}

	public PriRpScpGrpCmdtDtlVO getPriRpScpGrpCmdtDtlVO(){
		return priRpScpGrpCmdtDtlVO;
	}

	public PriRpScpGrpCmdtDtlVO[] getPriRpScpGrpCmdtDtlVOS(){
		PriRpScpGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priRpScpGrpCmdtDtlVOs != null) {
			tmpVOs = new PriRpScpGrpCmdtDtlVO[priRpScpGrpCmdtDtlVOs.length];
			System.arraycopy(priRpScpGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriRpScpGrpCmdtVO getPriRpScpGrpCmdtVO(){
		return priRpScpGrpCmdtVO;
	}

	public PriRpScpGrpCmdtVO[] getPriRpScpGrpCmdtVOS(){
		PriRpScpGrpCmdtVO[] tmpVOs = null;
		if (this.priRpScpGrpCmdtVOs != null) {
			tmpVOs = new PriRpScpGrpCmdtVO[priRpScpGrpCmdtVOs.length];
			System.arraycopy(priRpScpGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
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
	public void setRsltGrpCmdtDtlListVOs(RsltGrpCmdtDtlListVO[] rsltGrpCmdtDtlListVOs) {
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
	
	

}