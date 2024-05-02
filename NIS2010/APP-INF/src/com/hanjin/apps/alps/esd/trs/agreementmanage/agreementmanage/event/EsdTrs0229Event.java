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
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0229 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0229HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0229Event extends EventSupport {
	String fmAgmtno          = null;
	String fmTrspAgmtRtTpSerNo  = null;
	String curPageCnt       = null;

	String fmEqKndCd       = null;
	String pageSize          = null;
	String gridFlg           = null;
	String fmEffectiveAgmt   = null;
	
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

	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}


}
