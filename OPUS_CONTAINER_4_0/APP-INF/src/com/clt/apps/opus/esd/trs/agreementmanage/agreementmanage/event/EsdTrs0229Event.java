/*=========================================================
 *@FileName : ESD_TRS_0229Event.java
 *@FileTitle : Agreement Surcharge Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0229 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0229HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EsdTrs0229Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	String fmAgmtno          = null;
	String fmTrspAgmtRtTpSerNo  = null;
	String curPageCnt       = null;

	String fmEqKndCd       = null;
	String pageSize          = null;
	String gridFlg           = null;
	String fmEffectiveAgmt   = null;
	// ESD_TRS_0921 More Candidates Surcharge Form
	String fmCostModCd = null;
	String fmCrrModCd = null;
	String fmCgoTpCd = null;
	String fmLoce = null;
	String fmYard = null;
	String viaLoce = null;
	String viaYard = null;
	String toLoce = null;
	String toYard = null;
	String dorLoce = null;
	String dorYard = null;
	String eqTpszCd = null;
	String cntrWgt = null;
	String cntrWgtTpCd = null;
	// ESD_TRS_0921 More Candidates Surcharge Grid
	String wayType = null;
	String agmtNo = null;
	String vndrSeq = null;
	String trspBndCd = null;
	String spclCgoCntrTpCd = null;
	String trspAgmtEqTpSzCd = null;
	String usrDefRmk = null;
	String basicRate = null;
	String negoAmt = null;
	String totalAmt = null;
	String basisDt = null;
	String currCd = null;
	
	public String getFm_agmtno() {
		return fmAgmtno;
	}

	public void setFm_agmtno(String fmAgmtno) {
		this.fmAgmtno = fmAgmtno;
	}

	public String getFm_trsp_agmt_rt_tp_ser_no() {
		return fmTrspAgmtRtTpSerNo;
	}

	public void setFm_trsp_agmt_rt_tp_ser_no(String fmTrspAgmtRtTpSerNo) {
		this.fmTrspAgmtRtTpSerNo = fmTrspAgmtRtTpSerNo;
	}

	public String getCur_page_cnt() {
		return curPageCnt;
	}

	public void setCur_page_cnt(String curPageCnt) {
		this.curPageCnt = curPageCnt;
	}

	public String getFm_eq_knd_cd() {
		return fmEqKndCd;
	}

	public void setFm_eq_knd_cd(String fmEqKndCd) {
		this.fmEqKndCd = fmEqKndCd;
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

	public String getCurPageCnt() {
		return curPageCnt;
	}

	public void setCurPageCnt(String curPageCnt) {
		this.curPageCnt = curPageCnt;
	}

	public String getFmCostModCd() {
		return fmCostModCd;
	}

	public void setFmCostModCd(String fmCostModCd) {
		this.fmCostModCd = fmCostModCd;
	}

	public String getFmCrrModCd() {
		return fmCrrModCd;
	}

	public void setFmCrrModCd(String fmCrrModCd) {
		this.fmCrrModCd = fmCrrModCd;
	}

	public String getFmCgoTpCd() {
		return fmCgoTpCd;
	}

	public void setFmCgoTpCd(String fmCgoTpCd) {
		this.fmCgoTpCd = fmCgoTpCd;
	}

	public String getFmLoce() {
		return fmLoce;
	}

	public void setFmLoce(String fmLoce) {
		this.fmLoce = fmLoce;
	}

	public String getFmYard() {
		return fmYard;
	}

	public void setFmYard(String fmYard) {
		this.fmYard = fmYard;
	}

	public String getViaLoce() {
		return viaLoce;
	}

	public void setViaLoce(String viaLoce) {
		this.viaLoce = viaLoce;
	}

	public String getViaYard() {
		return viaYard;
	}

	public void setViaYard(String viaYard) {
		this.viaYard = viaYard;
	}

	public String getToLoce() {
		return toLoce;
	}

	public void setToLoce(String toLoce) {
		this.toLoce = toLoce;
	}

	public String getToYard() {
		return toYard;
	}

	public void setToYard(String toYard) {
		this.toYard = toYard;
	}

	public String getDorLoce() {
		return dorLoce;
	}

	public void setDorLoce(String dorLoce) {
		this.dorLoce = dorLoce;
	}

	public String getDorYard() {
		return dorYard;
	}

	public void setDorYard(String dorYard) {
		this.dorYard = dorYard;
	}

	public String getEqTpszCd() {
		return eqTpszCd;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	public String getCntrWgt() {
		return cntrWgt;
	}

	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	public String getCntrWgtTpCd() {
		return cntrWgtTpCd;
	}

	public void setCntrWgtTpCd(String cntrWgtTpCd) {
		this.cntrWgtTpCd = cntrWgtTpCd;
	}

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getTrspBndCd() {
		return trspBndCd;
	}

	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}

	public String getSpclCgoCntrTpCd() {
		return spclCgoCntrTpCd;
	}

	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public String getTrspAgmtEqTpSzCd() {
		return trspAgmtEqTpSzCd;
	}

	public void setTrspAgmtEqTpSzCd(String trspAgmtEqTpSzCd) {
		this.trspAgmtEqTpSzCd = trspAgmtEqTpSzCd;
	}

	public String getUsrDefRmk() {
		return usrDefRmk;
	}

	public void setUsrDefRmk(String usrDefRmk) {
		this.usrDefRmk = usrDefRmk;
	}

	public String getWayType() {
		return wayType;
	}

	public void setWayType(String wayType) {
		this.wayType = wayType;
	}

	public String getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(String basicRate) {
		this.basicRate = basicRate;
	}

	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}

	public String getBasisDt() {
		return basisDt;
	}

	public void setBasisDt(String basisDt) {
		this.basisDt = basisDt;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getNegoAmt() {
		return negoAmt;
	}

	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
}
