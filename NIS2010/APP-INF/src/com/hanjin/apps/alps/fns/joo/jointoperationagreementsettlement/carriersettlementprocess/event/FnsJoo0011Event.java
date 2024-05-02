/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0011Event.java
*@FileTitle : Reefer Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.13 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProcSettlementVO procSettlementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ProcSettlementVO[] procSettlementVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SettlementRFVO settlementRFVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SettlementRFVO[] settlementRFVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCodeParamVO jooCodeParamVO = null;
	
	public FnsJoo0011Event(){}
	
	public void setProcSettlementVO(ProcSettlementVO procSettlementVO){
		this. procSettlementVO = procSettlementVO;
	}

	public void setProcSettlementVOS(ProcSettlementVO[] procSettlementVOs){
		if (procSettlementVOs != null) {
			ProcSettlementVO[] tmpVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.procSettlementVOs = tmpVOs;
		}				
	}

	public ProcSettlementVO getProcSettlementVO(){
		return procSettlementVO;
	}

	public ProcSettlementVO[] getProcSettlementVOS(){
		ProcSettlementVO[] rtnVOs = null;
		if (this.procSettlementVOs != null) {
			rtnVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public SettlementRFVO getSettlementRFVO() {
		return settlementRFVO;
	}

	public void setSettlementRFVO(SettlementRFVO settlementRFVO) {
		this.settlementRFVO = settlementRFVO;
	}

	public SettlementRFVO[] getSettlementRFVOs() {
		SettlementRFVO[] rtnVOs = null;
		if (this.settlementRFVOs != null) {
			rtnVOs = new SettlementRFVO[settlementRFVOs.length];
			System.arraycopy(settlementRFVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setSettlementRFVOS(SettlementRFVO[] settlementRFVOs) {		
		if (settlementRFVOs != null) {
			SettlementRFVO[] tmpVOs = new SettlementRFVO[settlementRFVOs.length];
			System.arraycopy(settlementRFVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.settlementRFVOs = tmpVOs;
		}				
	}

	public JooCodeParamVO getJooCodeParamVO() {
		return jooCodeParamVO;
	}

	public void setJooCodeParamVO(JooCodeParamVO jooCodeParamVO) {
		this.jooCodeParamVO = jooCodeParamVO;
	}
	
	public ProcSettlementVO setProcSettlementVO(SettlementRFVO vo){
		ProcSettlementVO voRtn = new ProcSettlementVO();
		voRtn.setIbflag        (vo.getIbflag        ());
		voRtn.setVslCd         (vo.getVslCd         ());
		voRtn.setSkdVoyNo      (vo.getSkdVoyNo      ());
		voRtn.setSkdDirCd      (vo.getSkdDirCd      ());
		voRtn.setRevDirCd      (vo.getRevDirCd      ());
		voRtn.setStlBzcPortCd  (vo.getStlBzcPortCd  ());
		voRtn.setEtaDt         (vo.getEtaDt         ());
		voRtn.setUcBssPortCd   (vo.getUcBssPortCd   ());
		voRtn.setRfScgStlTpCd  (vo.getRfScgStlTpCd  ());
		voRtn.setIocCd         (vo.getIocCd         ());
		voRtn.setScontiCd      (vo.getScontiCd      ());
		voRtn.setFmPortCd      (vo.getFmPortCd      ());
		voRtn.setToPortCd      (vo.getToPortCd      ());
		voRtn.setLoclCurrCd    (vo.getLoclCurrCd    ());
		voRtn.setAcctYrmon     (vo.getAcctYrmon     ());
		voRtn.setStlVvdSeq     (vo.getStlVvdSeq     ());
		voRtn.setTrdCd         (vo.getTrdCd         ());
		voRtn.setJoCrrCd       (vo.getJoCrrCd       ());
		voRtn.setRlaneCd       (vo.getRlaneCd       ());
		voRtn.setReDivrCd      (vo.getReDivrCd      ());
		voRtn.setJoStlItmCd    (vo.getJoStlItmCd    ());
		voRtn.setJoMnuNm       (vo.getJoMnuNm       ());
		voRtn.setUcBssPortEtdDt(vo.getUcBssPortEtdDt());
		
		return voRtn;
	}
}