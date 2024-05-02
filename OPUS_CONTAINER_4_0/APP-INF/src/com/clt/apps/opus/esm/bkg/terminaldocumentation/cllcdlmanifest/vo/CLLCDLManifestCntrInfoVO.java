/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestCntrInfoVO.java
*@FileTitle : CLLCDLManifestCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.15
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestCntrInfoVO> models = new ArrayList<CLLCDLManifestCntrInfoVO>();

	/* Column Info */
	private String shprNm1 = null;
	/* Column Info */
	private String shprNm3 = null;
	/* Column Info */
	private String shprNm2 = null;
	/* Column Info */
	private String shprNm5 = null;
	/* Column Info */
	private String shprNm4 = null;
	/* Column Info */
	private String ntfyNm5 = null;
	/* Column Info */
	private String ntfyNm4 = null;
	/* Column Info */
	private String ntfyNm3 = null;
	/* Column Info */
	private String ntfyNm2 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ntfyNm1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String antfyNm1 = null;
	/* Column Info */
	private String antfyNm2 = null;
	/* Column Info */
	private String antfyNm3 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String antfyNm4 = null;
	/* Column Info */
	private String antfyNm5 = null;
	/* Column Info */
	private String ffNm5 = null;
	/* Column Info */
	private String ffNm4 = null;
	/* Column Info */
	private String ffNm3 = null;
	/* Column Info */
	private String ffNm2 = null;
	/* Column Info */
	private String ffNm1 = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String tsVvdId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String ntfySeq = null;
	/* Column Info */
	private String antfySeq = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String blRmk = null;
	/* Column Info */
	private String trnkVvdId = null;
	/* Column Info */
	private String cneeNm1 = null;
	/* Column Info */
	private String cneeNm4 = null;
	/* Column Info */
	private String cneeNm5 = null;
	/* Column Info */
	private String cneeNm2 = null;
	/* Column Info */
	private String cneeNm3 = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String tareCntrWgt = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String antfyCntCd = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestCntrInfoVO() {}

	public CLLCDLManifestCntrInfoVO(String ibflag, String pagerows, String blNo, String blTpCd, String shprCntCd, String shprSeq, String shprNm1, String shprNm2, String shprNm3, String shprNm4, String shprNm5, String cneeCntCd, String cneeSeq, String cneeNm1, String cneeNm2, String cneeNm3, String cneeNm4, String cneeNm5, String ntfyCntCd, String ntfySeq, String ntfyNm1, String ntfyNm2, String ntfyNm3, String ntfyNm4, String ntfyNm5, String antfyCntCd, String antfySeq, String antfyNm1, String antfyNm2, String antfyNm3, String antfyNm4, String antfyNm5, String ffCntCd, String ffCustSeq, String ffNm1, String ffNm2, String ffNm3, String ffNm4, String ffNm5, String tareCntrWgt, String tsVvdId, String polCd, String podCd, String cmdtCd, String cmdtNm, String repCmdtCd, String repCmdtNm, String trnkVvdId, String blRmk) {
		this.shprNm1 = shprNm1;
		this.shprNm3 = shprNm3;
		this.shprNm2 = shprNm2;
		this.shprNm5 = shprNm5;
		this.shprNm4 = shprNm4;
		this.ntfyNm5 = ntfyNm5;
		this.ntfyNm4 = ntfyNm4;
		this.ntfyNm3 = ntfyNm3;
		this.ntfyNm2 = ntfyNm2;
		this.blNo = blNo;
		this.ntfyNm1 = ntfyNm1;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.antfyNm1 = antfyNm1;
		this.antfyNm2 = antfyNm2;
		this.antfyNm3 = antfyNm3;
		this.polCd = polCd;
		this.antfyNm4 = antfyNm4;
		this.antfyNm5 = antfyNm5;
		this.ffNm5 = ffNm5;
		this.ffNm4 = ffNm4;
		this.ffNm3 = ffNm3;
		this.ffNm2 = ffNm2;
		this.ffNm1 = ffNm1;
		this.ntfyCntCd = ntfyCntCd;
		this.repCmdtNm = repCmdtNm;
		this.shprCntCd = shprCntCd;
		this.tsVvdId = tsVvdId;
		this.podCd = podCd;
		this.shprSeq = shprSeq;
		this.ntfySeq = ntfySeq;
		this.antfySeq = antfySeq;
		this.ffCustSeq = ffCustSeq;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.blRmk = blRmk;
		this.trnkVvdId = trnkVvdId;
		this.cneeNm1 = cneeNm1;
		this.cneeNm4 = cneeNm4;
		this.cneeNm5 = cneeNm5;
		this.cneeNm2 = cneeNm2;
		this.cneeNm3 = cneeNm3;
		this.cmdtNm = cmdtNm;
		this.blTpCd = blTpCd;
		this.tareCntrWgt = tareCntrWgt;
		this.cneeSeq = cneeSeq;
		this.antfyCntCd = antfyCntCd;
		this.ffCntCd = ffCntCd;
		this.repCmdtCd = repCmdtCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_nm1", getShprNm1());
		this.hashColumns.put("shpr_nm3", getShprNm3());
		this.hashColumns.put("shpr_nm2", getShprNm2());
		this.hashColumns.put("shpr_nm5", getShprNm5());
		this.hashColumns.put("shpr_nm4", getShprNm4());
		this.hashColumns.put("ntfy_nm5", getNtfyNm5());
		this.hashColumns.put("ntfy_nm4", getNtfyNm4());
		this.hashColumns.put("ntfy_nm3", getNtfyNm3());
		this.hashColumns.put("ntfy_nm2", getNtfyNm2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ntfy_nm1", getNtfyNm1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("antfy_nm1", getAntfyNm1());
		this.hashColumns.put("antfy_nm2", getAntfyNm2());
		this.hashColumns.put("antfy_nm3", getAntfyNm3());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("antfy_nm4", getAntfyNm4());
		this.hashColumns.put("antfy_nm5", getAntfyNm5());
		this.hashColumns.put("ff_nm5", getFfNm5());
		this.hashColumns.put("ff_nm4", getFfNm4());
		this.hashColumns.put("ff_nm3", getFfNm3());
		this.hashColumns.put("ff_nm2", getFfNm2());
		this.hashColumns.put("ff_nm1", getFfNm1());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("ts_vvd_id", getTsVvdId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("ntfy_seq", getNtfySeq());
		this.hashColumns.put("antfy_seq", getAntfySeq());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bl_rmk", getBlRmk());
		this.hashColumns.put("trnk_vvd_id", getTrnkVvdId());
		this.hashColumns.put("cnee_nm1", getCneeNm1());
		this.hashColumns.put("cnee_nm4", getCneeNm4());
		this.hashColumns.put("cnee_nm5", getCneeNm5());
		this.hashColumns.put("cnee_nm2", getCneeNm2());
		this.hashColumns.put("cnee_nm3", getCneeNm3());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("tare_cntr_wgt", getTareCntrWgt());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("antfy_cnt_cd", getAntfyCntCd());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_nm1", "shprNm1");
		this.hashFields.put("shpr_nm3", "shprNm3");
		this.hashFields.put("shpr_nm2", "shprNm2");
		this.hashFields.put("shpr_nm5", "shprNm5");
		this.hashFields.put("shpr_nm4", "shprNm4");
		this.hashFields.put("ntfy_nm5", "ntfyNm5");
		this.hashFields.put("ntfy_nm4", "ntfyNm4");
		this.hashFields.put("ntfy_nm3", "ntfyNm3");
		this.hashFields.put("ntfy_nm2", "ntfyNm2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ntfy_nm1", "ntfyNm1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("antfy_nm1", "antfyNm1");
		this.hashFields.put("antfy_nm2", "antfyNm2");
		this.hashFields.put("antfy_nm3", "antfyNm3");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("antfy_nm4", "antfyNm4");
		this.hashFields.put("antfy_nm5", "antfyNm5");
		this.hashFields.put("ff_nm5", "ffNm5");
		this.hashFields.put("ff_nm4", "ffNm4");
		this.hashFields.put("ff_nm3", "ffNm3");
		this.hashFields.put("ff_nm2", "ffNm2");
		this.hashFields.put("ff_nm1", "ffNm1");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("ts_vvd_id", "tsVvdId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("ntfy_seq", "ntfySeq");
		this.hashFields.put("antfy_seq", "antfySeq");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bl_rmk", "blRmk");
		this.hashFields.put("trnk_vvd_id", "trnkVvdId");
		this.hashFields.put("cnee_nm1", "cneeNm1");
		this.hashFields.put("cnee_nm4", "cneeNm4");
		this.hashFields.put("cnee_nm5", "cneeNm5");
		this.hashFields.put("cnee_nm2", "cneeNm2");
		this.hashFields.put("cnee_nm3", "cneeNm3");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("tare_cntr_wgt", "tareCntrWgt");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("antfy_cnt_cd", "antfyCntCd");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return shprNm1
	 */
	public String getShprNm1() {
		return this.shprNm1;
	}

	/**
	 * Column Info
	 * @return shprNm3
	 */
	public String getShprNm3() {
		return this.shprNm3;
	}

	/**
	 * Column Info
	 * @return shprNm2
	 */
	public String getShprNm2() {
		return this.shprNm2;
	}

	/**
	 * Column Info
	 * @return shprNm5
	 */
	public String getShprNm5() {
		return this.shprNm5;
	}

	/**
	 * Column Info
	 * @return shprNm4
	 */
	public String getShprNm4() {
		return this.shprNm4;
	}

	/**
	 * Column Info
	 * @return ntfyNm5
	 */
	public String getNtfyNm5() {
		return this.ntfyNm5;
	}

	/**
	 * Column Info
	 * @return ntfyNm4
	 */
	public String getNtfyNm4() {
		return this.ntfyNm4;
	}

	/**
	 * Column Info
	 * @return ntfyNm3
	 */
	public String getNtfyNm3() {
		return this.ntfyNm3;
	}

	/**
	 * Column Info
	 * @return ntfyNm2
	 */
	public String getNtfyNm2() {
		return this.ntfyNm2;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return ntfyNm1
	 */
	public String getNtfyNm1() {
		return this.ntfyNm1;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}

	/**
	 * Column Info
	 * @return antfyNm1
	 */
	public String getAntfyNm1() {
		return this.antfyNm1;
	}

	/**
	 * Column Info
	 * @return antfyNm2
	 */
	public String getAntfyNm2() {
		return this.antfyNm2;
	}

	/**
	 * Column Info
	 * @return antfyNm3
	 */
	public String getAntfyNm3() {
		return this.antfyNm3;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return antfyNm4
	 */
	public String getAntfyNm4() {
		return this.antfyNm4;
	}

	/**
	 * Column Info
	 * @return antfyNm5
	 */
	public String getAntfyNm5() {
		return this.antfyNm5;
	}

	/**
	 * Column Info
	 * @return ffNm5
	 */
	public String getFfNm5() {
		return this.ffNm5;
	}

	/**
	 * Column Info
	 * @return ffNm4
	 */
	public String getFfNm4() {
		return this.ffNm4;
	}

	/**
	 * Column Info
	 * @return ffNm3
	 */
	public String getFfNm3() {
		return this.ffNm3;
	}

	/**
	 * Column Info
	 * @return ffNm2
	 */
	public String getFfNm2() {
		return this.ffNm2;
	}

	/**
	 * Column Info
	 * @return ffNm1
	 */
	public String getFfNm1() {
		return this.ffNm1;
	}

	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}

	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return tsVvdId
	 */
	public String getTsVvdId() {
		return this.tsVvdId;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}

	/**
	 * Column Info
	 * @return ntfySeq
	 */
	public String getNtfySeq() {
		return this.ntfySeq;
	}

	/**
	 * Column Info
	 * @return antfySeq
	 */
	public String getAntfySeq() {
		return this.antfySeq;
	}

	/**
	 * Column Info
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return blRmk
	 */
	public String getBlRmk() {
		return this.blRmk;
	}

	/**
	 * Column Info
	 * @return trnkVvdId
	 */
	public String getTrnkVvdId() {
		return this.trnkVvdId;
	}

	/**
	 * Column Info
	 * @return cneeNm1
	 */
	public String getCneeNm1() {
		return this.cneeNm1;
	}

	/**
	 * Column Info
	 * @return cneeNm4
	 */
	public String getCneeNm4() {
		return this.cneeNm4;
	}

	/**
	 * Column Info
	 * @return cneeNm5
	 */
	public String getCneeNm5() {
		return this.cneeNm5;
	}

	/**
	 * Column Info
	 * @return cneeNm2
	 */
	public String getCneeNm2() {
		return this.cneeNm2;
	}

	/**
	 * Column Info
	 * @return cneeNm3
	 */
	public String getCneeNm3() {
		return this.cneeNm3;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}

	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}

	/**
	 * Column Info
	 * @return tareCntrWgt
	 */
	public String getTareCntrWgt() {
		return this.tareCntrWgt;
	}

	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}

	/**
	 * Column Info
	 * @return antfyCntCd
	 */
	public String getAntfyCntCd() {
		return this.antfyCntCd;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}


	/**
	 * Column Info
	 * @param shprNm1
	 */
	public void setShprNm1(String shprNm1) {
		this.shprNm1 = shprNm1;
	}

	/**
	 * Column Info
	 * @param shprNm3
	 */
	public void setShprNm3(String shprNm3) {
		this.shprNm3 = shprNm3;
	}

	/**
	 * Column Info
	 * @param shprNm2
	 */
	public void setShprNm2(String shprNm2) {
		this.shprNm2 = shprNm2;
	}

	/**
	 * Column Info
	 * @param shprNm5
	 */
	public void setShprNm5(String shprNm5) {
		this.shprNm5 = shprNm5;
	}

	/**
	 * Column Info
	 * @param shprNm4
	 */
	public void setShprNm4(String shprNm4) {
		this.shprNm4 = shprNm4;
	}

	/**
	 * Column Info
	 * @param ntfyNm5
	 */
	public void setNtfyNm5(String ntfyNm5) {
		this.ntfyNm5 = ntfyNm5;
	}

	/**
	 * Column Info
	 * @param ntfyNm4
	 */
	public void setNtfyNm4(String ntfyNm4) {
		this.ntfyNm4 = ntfyNm4;
	}

	/**
	 * Column Info
	 * @param ntfyNm3
	 */
	public void setNtfyNm3(String ntfyNm3) {
		this.ntfyNm3 = ntfyNm3;
	}

	/**
	 * Column Info
	 * @param ntfyNm2
	 */
	public void setNtfyNm2(String ntfyNm2) {
		this.ntfyNm2 = ntfyNm2;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param ntfyNm1
	 */
	public void setNtfyNm1(String ntfyNm1) {
		this.ntfyNm1 = ntfyNm1;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}

	/**
	 * Column Info
	 * @param antfyNm1
	 */
	public void setAntfyNm1(String antfyNm1) {
		this.antfyNm1 = antfyNm1;
	}

	/**
	 * Column Info
	 * @param antfyNm2
	 */
	public void setAntfyNm2(String antfyNm2) {
		this.antfyNm2 = antfyNm2;
	}

	/**
	 * Column Info
	 * @param antfyNm3
	 */
	public void setAntfyNm3(String antfyNm3) {
		this.antfyNm3 = antfyNm3;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param antfyNm4
	 */
	public void setAntfyNm4(String antfyNm4) {
		this.antfyNm4 = antfyNm4;
	}

	/**
	 * Column Info
	 * @param antfyNm5
	 */
	public void setAntfyNm5(String antfyNm5) {
		this.antfyNm5 = antfyNm5;
	}

	/**
	 * Column Info
	 * @param ffNm5
	 */
	public void setFfNm5(String ffNm5) {
		this.ffNm5 = ffNm5;
	}

	/**
	 * Column Info
	 * @param ffNm4
	 */
	public void setFfNm4(String ffNm4) {
		this.ffNm4 = ffNm4;
	}

	/**
	 * Column Info
	 * @param ffNm3
	 */
	public void setFfNm3(String ffNm3) {
		this.ffNm3 = ffNm3;
	}

	/**
	 * Column Info
	 * @param ffNm2
	 */
	public void setFfNm2(String ffNm2) {
		this.ffNm2 = ffNm2;
	}

	/**
	 * Column Info
	 * @param ffNm1
	 */
	public void setFfNm1(String ffNm1) {
		this.ffNm1 = ffNm1;
	}

	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}

	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}

	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	/**
	 * Column Info
	 * @param tsVvdId
	 */
	public void setTsVvdId(String tsVvdId) {
		this.tsVvdId = tsVvdId;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}

	/**
	 * Column Info
	 * @param ntfySeq
	 */
	public void setNtfySeq(String ntfySeq) {
		this.ntfySeq = ntfySeq;
	}

	/**
	 * Column Info
	 * @param antfySeq
	 */
	public void setAntfySeq(String antfySeq) {
		this.antfySeq = antfySeq;
	}

	/**
	 * Column Info
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param blRmk
	 */
	public void setBlRmk(String blRmk) {
		this.blRmk = blRmk;
	}

	/**
	 * Column Info
	 * @param trnkVvdId
	 */
	public void setTrnkVvdId(String trnkVvdId) {
		this.trnkVvdId = trnkVvdId;
	}

	/**
	 * Column Info
	 * @param cneeNm1
	 */
	public void setCneeNm1(String cneeNm1) {
		this.cneeNm1 = cneeNm1;
	}

	/**
	 * Column Info
	 * @param cneeNm4
	 */
	public void setCneeNm4(String cneeNm4) {
		this.cneeNm4 = cneeNm4;
	}

	/**
	 * Column Info
	 * @param cneeNm5
	 */
	public void setCneeNm5(String cneeNm5) {
		this.cneeNm5 = cneeNm5;
	}

	/**
	 * Column Info
	 * @param cneeNm2
	 */
	public void setCneeNm2(String cneeNm2) {
		this.cneeNm2 = cneeNm2;
	}

	/**
	 * Column Info
	 * @param cneeNm3
	 */
	public void setCneeNm3(String cneeNm3) {
		this.cneeNm3 = cneeNm3;
	}

	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}

	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}

	/**
	 * Column Info
	 * @param tareCntrWgt
	 */
	public void setTareCntrWgt(String tareCntrWgt) {
		this.tareCntrWgt = tareCntrWgt;
	}

	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}

	/**
	 * Column Info
	 * @param antfyCntCd
	 */
	public void setAntfyCntCd(String antfyCntCd) {
		this.antfyCntCd = antfyCntCd;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setShprNm1(JSPUtil.getParameter(request, "shpr_nm1", ""));
		setShprNm3(JSPUtil.getParameter(request, "shpr_nm3", ""));
		setShprNm2(JSPUtil.getParameter(request, "shpr_nm2", ""));
		setShprNm5(JSPUtil.getParameter(request, "shpr_nm5", ""));
		setShprNm4(JSPUtil.getParameter(request, "shpr_nm4", ""));
		setNtfyNm5(JSPUtil.getParameter(request, "ntfy_nm5", ""));
		setNtfyNm4(JSPUtil.getParameter(request, "ntfy_nm4", ""));
		setNtfyNm3(JSPUtil.getParameter(request, "ntfy_nm3", ""));
		setNtfyNm2(JSPUtil.getParameter(request, "ntfy_nm2", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setNtfyNm1(JSPUtil.getParameter(request, "ntfy_nm1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, "cnee_cnt_cd", ""));
		setAntfyNm1(JSPUtil.getParameter(request, "antfy_nm1", ""));
		setAntfyNm2(JSPUtil.getParameter(request, "antfy_nm2", ""));
		setAntfyNm3(JSPUtil.getParameter(request, "antfy_nm3", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setAntfyNm4(JSPUtil.getParameter(request, "antfy_nm4", ""));
		setAntfyNm5(JSPUtil.getParameter(request, "antfy_nm5", ""));
		setFfNm5(JSPUtil.getParameter(request, "ff_nm5", ""));
		setFfNm4(JSPUtil.getParameter(request, "ff_nm4", ""));
		setFfNm3(JSPUtil.getParameter(request, "ff_nm3", ""));
		setFfNm2(JSPUtil.getParameter(request, "ff_nm2", ""));
		setFfNm1(JSPUtil.getParameter(request, "ff_nm1", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, "ntfy_cnt_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setShprCntCd(JSPUtil.getParameter(request, "shpr_cnt_cd", ""));
		setTsVvdId(JSPUtil.getParameter(request, "ts_vvd_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setShprSeq(JSPUtil.getParameter(request, "shpr_seq", ""));
		setNtfySeq(JSPUtil.getParameter(request, "ntfy_seq", ""));
		setAntfySeq(JSPUtil.getParameter(request, "antfy_seq", ""));
		setFfCustSeq(JSPUtil.getParameter(request, "ff_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBlRmk(JSPUtil.getParameter(request, "bl_rmk", ""));
		setTrnkVvdId(JSPUtil.getParameter(request, "trnk_vvd_id", ""));
		setCneeNm1(JSPUtil.getParameter(request, "cnee_nm1", ""));
		setCneeNm4(JSPUtil.getParameter(request, "cnee_nm4", ""));
		setCneeNm5(JSPUtil.getParameter(request, "cnee_nm5", ""));
		setCneeNm2(JSPUtil.getParameter(request, "cnee_nm2", ""));
		setCneeNm3(JSPUtil.getParameter(request, "cnee_nm3", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setTareCntrWgt(JSPUtil.getParameter(request, "tare_cntr_wgt", ""));
		setCneeSeq(JSPUtil.getParameter(request, "cnee_seq", ""));
		setAntfyCntCd(JSPUtil.getParameter(request, "antfy_cnt_cd", ""));
		setFfCntCd(JSPUtil.getParameter(request, "ff_cnt_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestCntrInfoVO[]
	 */
	public CLLCDLManifestCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestCntrInfoVO[]
	 */
	public CLLCDLManifestCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] shprNm1 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm1", length));
			String[] shprNm3 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm3", length));
			String[] shprNm2 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm2", length));
			String[] shprNm5 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm5", length));
			String[] shprNm4 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm4", length));
			String[] ntfyNm5 = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm5", length));
			String[] ntfyNm4 = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm4", length));
			String[] ntfyNm3 = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm3", length));
			String[] ntfyNm2 = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ntfyNm1 = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] antfyNm1 = (JSPUtil.getParameter(request, prefix	+ "antfy_nm1", length));
			String[] antfyNm2 = (JSPUtil.getParameter(request, prefix	+ "antfy_nm2", length));
			String[] antfyNm3 = (JSPUtil.getParameter(request, prefix	+ "antfy_nm3", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] antfyNm4 = (JSPUtil.getParameter(request, prefix	+ "antfy_nm4", length));
			String[] antfyNm5 = (JSPUtil.getParameter(request, prefix	+ "antfy_nm5", length));
			String[] ffNm5 = (JSPUtil.getParameter(request, prefix	+ "ff_nm5", length));
			String[] ffNm4 = (JSPUtil.getParameter(request, prefix	+ "ff_nm4", length));
			String[] ffNm3 = (JSPUtil.getParameter(request, prefix	+ "ff_nm3", length));
			String[] ffNm2 = (JSPUtil.getParameter(request, prefix	+ "ff_nm2", length));
			String[] ffNm1 = (JSPUtil.getParameter(request, prefix	+ "ff_nm1", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] tsVvdId = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] ntfySeq = (JSPUtil.getParameter(request, prefix	+ "ntfy_seq", length));
			String[] antfySeq = (JSPUtil.getParameter(request, prefix	+ "antfy_seq", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] blRmk = (JSPUtil.getParameter(request, prefix	+ "bl_rmk", length));
			String[] trnkVvdId = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd_id", length));
			String[] cneeNm1 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm1", length));
			String[] cneeNm4 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm4", length));
			String[] cneeNm5 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm5", length));
			String[] cneeNm2 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm2", length));
			String[] cneeNm3 = (JSPUtil.getParameter(request, prefix	+ "cnee_nm3", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] tareCntrWgt = (JSPUtil.getParameter(request, prefix	+ "tare_cntr_wgt", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] antfyCntCd = (JSPUtil.getParameter(request, prefix	+ "antfy_cnt_cd", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestCntrInfoVO();
				if (shprNm1[i] != null)
					model.setShprNm1(shprNm1[i]);
				if (shprNm3[i] != null)
					model.setShprNm3(shprNm3[i]);
				if (shprNm2[i] != null)
					model.setShprNm2(shprNm2[i]);
				if (shprNm5[i] != null)
					model.setShprNm5(shprNm5[i]);
				if (shprNm4[i] != null)
					model.setShprNm4(shprNm4[i]);
				if (ntfyNm5[i] != null)
					model.setNtfyNm5(ntfyNm5[i]);
				if (ntfyNm4[i] != null)
					model.setNtfyNm4(ntfyNm4[i]);
				if (ntfyNm3[i] != null)
					model.setNtfyNm3(ntfyNm3[i]);
				if (ntfyNm2[i] != null)
					model.setNtfyNm2(ntfyNm2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ntfyNm1[i] != null)
					model.setNtfyNm1(ntfyNm1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (antfyNm1[i] != null)
					model.setAntfyNm1(antfyNm1[i]);
				if (antfyNm2[i] != null)
					model.setAntfyNm2(antfyNm2[i]);
				if (antfyNm3[i] != null)
					model.setAntfyNm3(antfyNm3[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (antfyNm4[i] != null)
					model.setAntfyNm4(antfyNm4[i]);
				if (antfyNm5[i] != null)
					model.setAntfyNm5(antfyNm5[i]);
				if (ffNm5[i] != null)
					model.setFfNm5(ffNm5[i]);
				if (ffNm4[i] != null)
					model.setFfNm4(ffNm4[i]);
				if (ffNm3[i] != null)
					model.setFfNm3(ffNm3[i]);
				if (ffNm2[i] != null)
					model.setFfNm2(ffNm2[i]);
				if (ffNm1[i] != null)
					model.setFfNm1(ffNm1[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (tsVvdId[i] != null)
					model.setTsVvdId(tsVvdId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (ntfySeq[i] != null)
					model.setNtfySeq(ntfySeq[i]);
				if (antfySeq[i] != null)
					model.setAntfySeq(antfySeq[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (blRmk[i] != null)
					model.setBlRmk(blRmk[i]);
				if (trnkVvdId[i] != null)
					model.setTrnkVvdId(trnkVvdId[i]);
				if (cneeNm1[i] != null)
					model.setCneeNm1(cneeNm1[i]);
				if (cneeNm4[i] != null)
					model.setCneeNm4(cneeNm4[i]);
				if (cneeNm5[i] != null)
					model.setCneeNm5(cneeNm5[i]);
				if (cneeNm2[i] != null)
					model.setCneeNm2(cneeNm2[i]);
				if (cneeNm3[i] != null)
					model.setCneeNm3(cneeNm3[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (tareCntrWgt[i] != null)
					model.setTareCntrWgt(tareCntrWgt[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (antfyCntCd[i] != null)
					model.setAntfyCntCd(antfyCntCd[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestCntrInfoVO[]
	 */
	public CLLCDLManifestCntrInfoVO[] getCLLCDLManifestCntrInfoVOs(){
		CLLCDLManifestCntrInfoVO[] vos = (CLLCDLManifestCntrInfoVO[])models.toArray(new CLLCDLManifestCntrInfoVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.shprNm1 = this.shprNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm3 = this.shprNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm2 = this.shprNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm5 = this.shprNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm4 = this.shprNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm5 = this.ntfyNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm4 = this.ntfyNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm3 = this.ntfyNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm2 = this.ntfyNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm1 = this.ntfyNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyNm1 = this.antfyNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyNm2 = this.antfyNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyNm3 = this.antfyNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyNm4 = this.antfyNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyNm5 = this.antfyNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm5 = this.ffNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm4 = this.ffNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm3 = this.ffNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm2 = this.ffNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm1 = this.ffNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdId = this.tsVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfySeq = this.ntfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfySeq = this.antfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRmk = this.blRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdId = this.trnkVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm1 = this.cneeNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm4 = this.cneeNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm5 = this.cneeNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm2 = this.cneeNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm3 = this.cneeNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareCntrWgt = this.tareCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyCntCd = this.antfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
