/*=========================================================
 *@FileName : ESD_TRS_0225Event.java
 *@FileTitle : Agreement Rate Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.05
 *@LastModifier : 최종혁
 *@LastVersion : 1.1
 * 2010.03.26 최종혁
 * 1.0 최초 생성
-----------------------------------------------------------
 * History
 * 2010.10.05 최 선     1.1 [CHM-201006313] From, Via, Door, To POP UP 조회 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0226 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0226HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0226Event extends EventSupport {
	String fmAgmtno          = null;
	String curPageCnt       = null;
	String fmTrspAgmtRtTpSerNo  = null;
	
	String searchFmLoc       = null;
	String searchFmYard       = null;
	String searchViaLoc      = null;
	String searchViaYard      = null;
	String searchToLoc       = null;
	String searchToYard       = null;
	String searchDoorLoc      = null;
	String searchDoorYard      = null;
	String fmTrspAgmtDist  = null;
	String fmEqKndCd       = null;
	String pageSize          = null;
	String gridFlg           = null;
	String fmEffectiveAgmt   = null;
	String fmCfmFlg   = null;

	private String trspAgmtTmpSeq = null;
	private DummyAgmtRateVO dummyAgmtRateVO = null;
	private DummyAgmtRateVO[] dummyAgmtRateVOs = null;

	public String getFm_agmtno() {
		return fmAgmtno;
	}

	public void setFm_agmtno(String fmAgmtno) {
		this.fmAgmtno = fmAgmtno;
	}

	public String getCur_page_cnt() {
		return curPageCnt;
	}

	public void setCur_page_cnt(String curPageCnt) {
		this.curPageCnt = curPageCnt;
	}

	public String getFm_trsp_agmt_rt_tp_ser_no() {
		return fmTrspAgmtRtTpSerNo;
	}

	public void setFm_trsp_agmt_rt_tp_ser_no(String fmTrspAgmtRtTpSerNo) {
		this.fmTrspAgmtRtTpSerNo = fmTrspAgmtRtTpSerNo;
	}

	public String getSearchFmLoc() {
		return searchFmLoc;
	}

	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}

	public String getSearchFmYard() {
		return searchFmYard;
	}

	public void setSearchFmYard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}

	public String getSearchViaLoc() {
		return searchViaLoc;
	}

	public void setSearchViaLoc(String searchViaLoc) {
		this.searchViaLoc = searchViaLoc;
	}

	public String getSearchViaYard() {
		return searchViaYard;
	}

	public void setSearchViaYard(String searchViaYard) {
		this.searchViaYard = searchViaYard;
	}

	public String getSearchToLoc() {
		return searchToLoc;
	}

	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
	}

	public String getSearchToYard() {
		return searchToYard;
	}

	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
	}

	public String getSearchDoorLoc() {
		return searchDoorLoc;
	}

	public void setSearchDoorLoc(String searchDoorLoc) {
		this.searchDoorLoc = searchDoorLoc;
	}

	public String getSearchDoorYard() {
		return searchDoorYard;
	}

	public void setSearchDoorYard(String searchDoorYard) {
		this.searchDoorYard = searchDoorYard;
	}

	public String getFm_trsp_agmt_dist() {
		return fmTrspAgmtDist;
	}

	public void setFm_trsp_agmt_dist(String fmTrspAgmtDist) {
		this.fmTrspAgmtDist = fmTrspAgmtDist;
	}

	public String getFm_eq_knd_cd() {
		return fmEqKndCd;
	}

	public void setFm_eq_knd_cd(String fmEqKndCd) {
		this.fmEqKndCd = fmEqKndCd;
	}

	public String getTrspAgmtTmpSeq() {
		return trspAgmtTmpSeq;
	}

	public void setTrspAgmtTmpSeq(String trspAgmtTmpSeq) {
		this.trspAgmtTmpSeq = trspAgmtTmpSeq;
	}

	public String getPage_size() {
		return pageSize;
	}

	public void setPage_size(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getGrid_flg() {
		return gridFlg;
	}

	public void setGrid_flg(String gridFlg) {
		this.gridFlg = gridFlg;
	}

	public String getFmEffectiveAgmt() {
		return fmEffectiveAgmt;
	}

	public void setFmEffectiveAgmt(String fmEffectiveAgmt) {
		this.fmEffectiveAgmt = fmEffectiveAgmt;
	}

	public String getFmCfmFlg() {
		return fmCfmFlg;
	}

	public void setFmCfmFlg(String fmCfmFlg) {
		this.fmCfmFlg = fmCfmFlg;
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


}
