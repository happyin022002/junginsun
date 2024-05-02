/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdTrs0280Event.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event;
import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0280 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0280HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdTrs0280Event extends EventSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 검색 값
	private String fm_ofc_cd			= "";
	private String fm_usr_id 			= "";
	private String fm_agmtno 			= "";
	private String fm_agmt_trsp_tp_cd 	= "";
	private String fm_vndr_prmry_seq 	= "";
	private String fm_ctrt_ofc_cd 		= "";
	private String fm_effective_agmt 	= "";
	private String fm_trsp_cost_mod_cd	= "";
	/** Verify위한 Temp Sequence */
	private String trspAgmtTmpSeq = null;
	private String headerRow = "";
	
	private DummyAgmtRateVO dummyAgmtRateVO = null;
	private DummyAgmtRateVO[] dummyAgmtRateVOs = null;
	
	public String getFm_ofc_cd() {
		return fm_ofc_cd;
	}

	public void setFm_ofc_cd(String fm_ofc_cd) {
		this.fm_ofc_cd = fm_ofc_cd;
	}

	public String getFm_usr_id() {
		return fm_usr_id;
	}

	public void setFm_usr_id(String fm_usr_id) {
		this.fm_usr_id = fm_usr_id;
	}

	public String getFm_agmtno() {
		return fm_agmtno;
	}

	public void setFm_agmtno(String fm_agmtno) {
		this.fm_agmtno = fm_agmtno;
	}

	public String getFm_agmt_trsp_tp_cd() {
		return fm_agmt_trsp_tp_cd;
	}

	public void setFm_agmt_trsp_tp_cd(String fm_agmt_trsp_tp_cd) {
		this.fm_agmt_trsp_tp_cd = fm_agmt_trsp_tp_cd;
	}

	public String getFm_vndr_prmry_seq() {
		return fm_vndr_prmry_seq;
	}

	public void setFm_vndr_prmry_seq(String fm_vndr_prmry_seq) {
		this.fm_vndr_prmry_seq = fm_vndr_prmry_seq;
	}

	public String getFm_ctrt_ofc_cd() {
		return fm_ctrt_ofc_cd;
	}

	public void setFm_ctrt_ofc_cd(String fm_ctrt_ofc_cd) {
		this.fm_ctrt_ofc_cd = fm_ctrt_ofc_cd;
	}

	public String getFm_effective_agmt() {
		return fm_effective_agmt;
	}

	public void setFm_effective_agmt(String fm_effective_agmt) {
		this.fm_effective_agmt = fm_effective_agmt;
	}

	public String getFm_trsp_cost_mod_cd() {
		return fm_trsp_cost_mod_cd;
	}

	public void setFm_trsp_cost_mod_cd(String fm_trsp_cost_mod_cd) {
		this.fm_trsp_cost_mod_cd = fm_trsp_cost_mod_cd;
	}
	
	public String getTrspAgmtTmpSeq() {
		return trspAgmtTmpSeq;
	}

	public void setTrspAgmtTmpSeq(String trspAgmtTmpSeq) {
		this.trspAgmtTmpSeq = trspAgmtTmpSeq;
	}

	public String getHeaderRow() {
		return headerRow;
	}

	public void setHeaderRow(String headerRow) {
		this.headerRow = headerRow;
	}

	public DummyAgmtRateVO getDummyAgmtRateVO() {
		return dummyAgmtRateVO;
	}

	public void setDummyAgmtRateVO(DummyAgmtRateVO dummyAgmtRateVO) {
		this.dummyAgmtRateVO = dummyAgmtRateVO;
	}

	public DummyAgmtRateVO[] getDummyAgmtRateVOs() {
		return dummyAgmtRateVOs;
	}

	public void setDummyAgmtRateVOs(DummyAgmtRateVO[] dummyAgmtRateVOs) {
		this.dummyAgmtRateVOs = dummyAgmtRateVOs;
	}

	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}

	public EsdTrs0280Event(){}
	
	public String getEventName() {
		return "EsdTrs0280Event";
	}

	public String toString() {
		return "EsdTrs0280Event";
	}
	
}

