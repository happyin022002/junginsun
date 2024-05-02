/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsJpVslSkdVO.java
*@FileTitle : BkgCstmsJpVslSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsJpVslSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsJpVslSkdVO> models = new ArrayList<BkgCstmsJpVslSkdVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String depYdCd = null;
	/* Column Info */
	private String atdDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String fwddrLen = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bagFlg = null;
	/* Column Info */
	private String atbDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String jpAgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jpShftDt = null;
	/* Column Info */
	private String ataDt = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String joCd1 = null;
	/* Column Info */
	private String joCd10 = null;
	/* Column Info */
	private String joCd5 = null;
	/* Column Info */
	private String joCd4 = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String joCd3 = null;
	/* Column Info */
	private String arrYdCd = null;
	/* Column Info */
	private String jpShftCd = null;
	/* Column Info */
	private String joCd2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String aftdrLen = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cnmtExtdFlg = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String joCd8 = null;
	/* Column Info */
	private String joCd9 = null;
	/* Column Info */
	private String joCd6 = null;
	/* Column Info */
	private String joCd7 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsJpVslSkdVO() {}

	public BkgCstmsJpVslSkdVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String podCd, String etaDt, String etbDt, String etdDt, String arrYdCd, String depYdCd, String bagFlg, String cnmtExtdFlg, String jpAgnCd, String jpShftCd, String jpShftDt, String diffRmk, String aftdrLen, String fwddrLen, String joCd1, String joCd2, String joCd3, String joCd4, String joCd5, String joCd6, String joCd7, String joCd8, String joCd9, String joCd10, String ataDt, String atbDt, String atdDt, String callSgnNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.depYdCd = depYdCd;
		this.atdDt = atdDt;
		this.etaDt = etaDt;
		this.fwddrLen = fwddrLen;
		this.creDt = creDt;
		this.bagFlg = bagFlg;
		this.atbDt = atbDt;
		this.pagerows = pagerows;
		this.jpAgnCd = jpAgnCd;
		this.ibflag = ibflag;
		this.jpShftDt = jpShftDt;
		this.ataDt = ataDt;
		this.etbDt = etbDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.joCd1 = joCd1;
		this.joCd10 = joCd10;
		this.joCd5 = joCd5;
		this.joCd4 = joCd4;
		this.callSgnNo = callSgnNo;
		this.joCd3 = joCd3;
		this.arrYdCd = arrYdCd;
		this.jpShftCd = jpShftCd;
		this.joCd2 = joCd2;
		this.skdVoyNo = skdVoyNo;
		this.etdDt = etdDt;
		this.aftdrLen = aftdrLen;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.cnmtExtdFlg = cnmtExtdFlg;
		this.diffRmk = diffRmk;
		this.joCd8 = joCd8;
		this.joCd9 = joCd9;
		this.joCd6 = joCd6;
		this.joCd7 = joCd7;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dep_yd_cd", getDepYdCd());
		this.hashColumns.put("atd_dt", getAtdDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("fwddr_len", getFwddrLen());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bag_flg", getBagFlg());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jp_agn_cd", getJpAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jp_shft_dt", getJpShftDt());
		this.hashColumns.put("ata_dt", getAtaDt());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_cd1", getJoCd1());
		this.hashColumns.put("jo_cd10", getJoCd10());
		this.hashColumns.put("jo_cd5", getJoCd5());
		this.hashColumns.put("jo_cd4", getJoCd4());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("jo_cd3", getJoCd3());
		this.hashColumns.put("arr_yd_cd", getArrYdCd());
		this.hashColumns.put("jp_shft_cd", getJpShftCd());
		this.hashColumns.put("jo_cd2", getJoCd2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("aftdr_len", getAftdrLen());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnmt_extd_flg", getCnmtExtdFlg());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("jo_cd8", getJoCd8());
		this.hashColumns.put("jo_cd9", getJoCd9());
		this.hashColumns.put("jo_cd6", getJoCd6());
		this.hashColumns.put("jo_cd7", getJoCd7());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dep_yd_cd", "depYdCd");
		this.hashFields.put("atd_dt", "atdDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("fwddr_len", "fwddrLen");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bag_flg", "bagFlg");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jp_agn_cd", "jpAgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jp_shft_dt", "jpShftDt");
		this.hashFields.put("ata_dt", "ataDt");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_cd1", "joCd1");
		this.hashFields.put("jo_cd10", "joCd10");
		this.hashFields.put("jo_cd5", "joCd5");
		this.hashFields.put("jo_cd4", "joCd4");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("jo_cd3", "joCd3");
		this.hashFields.put("arr_yd_cd", "arrYdCd");
		this.hashFields.put("jp_shft_cd", "jpShftCd");
		this.hashFields.put("jo_cd2", "joCd2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("aftdr_len", "aftdrLen");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnmt_extd_flg", "cnmtExtdFlg");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("jo_cd8", "joCd8");
		this.hashFields.put("jo_cd9", "joCd9");
		this.hashFields.put("jo_cd6", "joCd6");
		this.hashFields.put("jo_cd7", "joCd7");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return depYdCd
	 */
	public String getDepYdCd() {
		return this.depYdCd;
	}
	
	/**
	 * Column Info
	 * @return atdDt
	 */
	public String getAtdDt() {
		return this.atdDt;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return fwddrLen
	 */
	public String getFwddrLen() {
		return this.fwddrLen;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return bagFlg
	 */
	public String getBagFlg() {
		return this.bagFlg;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @return jpAgnCd
	 */
	public String getJpAgnCd() {
		return this.jpAgnCd;
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
	 * @return jpShftDt
	 */
	public String getJpShftDt() {
		return this.jpShftDt;
	}
	
	/**
	 * Column Info
	 * @return ataDt
	 */
	public String getAtaDt() {
		return this.ataDt;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return joCd1
	 */
	public String getJoCd1() {
		return this.joCd1;
	}
	
	/**
	 * Column Info
	 * @return joCd10
	 */
	public String getJoCd10() {
		return this.joCd10;
	}
	
	/**
	 * Column Info
	 * @return joCd5
	 */
	public String getJoCd5() {
		return this.joCd5;
	}
	
	/**
	 * Column Info
	 * @return joCd4
	 */
	public String getJoCd4() {
		return this.joCd4;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return joCd3
	 */
	public String getJoCd3() {
		return this.joCd3;
	}
	
	/**
	 * Column Info
	 * @return arrYdCd
	 */
	public String getArrYdCd() {
		return this.arrYdCd;
	}
	
	/**
	 * Column Info
	 * @return jpShftCd
	 */
	public String getJpShftCd() {
		return this.jpShftCd;
	}
	
	/**
	 * Column Info
	 * @return joCd2
	 */
	public String getJoCd2() {
		return this.joCd2;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return aftdrLen
	 */
	public String getAftdrLen() {
		return this.aftdrLen;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cnmtExtdFlg
	 */
	public String getCnmtExtdFlg() {
		return this.cnmtExtdFlg;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return joCd8
	 */
	public String getJoCd8() {
		return this.joCd8;
	}
	
	/**
	 * Column Info
	 * @return joCd9
	 */
	public String getJoCd9() {
		return this.joCd9;
	}
	
	/**
	 * Column Info
	 * @return joCd6
	 */
	public String getJoCd6() {
		return this.joCd6;
	}
	
	/**
	 * Column Info
	 * @return joCd7
	 */
	public String getJoCd7() {
		return this.joCd7;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param depYdCd
	 */
	public void setDepYdCd(String depYdCd) {
		this.depYdCd = depYdCd;
	}
	
	/**
	 * Column Info
	 * @param atdDt
	 */
	public void setAtdDt(String atdDt) {
		this.atdDt = atdDt;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param fwddrLen
	 */
	public void setFwddrLen(String fwddrLen) {
		this.fwddrLen = fwddrLen;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param bagFlg
	 */
	public void setBagFlg(String bagFlg) {
		this.bagFlg = bagFlg;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
	 * @param jpAgnCd
	 */
	public void setJpAgnCd(String jpAgnCd) {
		this.jpAgnCd = jpAgnCd;
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
	 * @param jpShftDt
	 */
	public void setJpShftDt(String jpShftDt) {
		this.jpShftDt = jpShftDt;
	}
	
	/**
	 * Column Info
	 * @param ataDt
	 */
	public void setAtaDt(String ataDt) {
		this.ataDt = ataDt;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param joCd1
	 */
	public void setJoCd1(String joCd1) {
		this.joCd1 = joCd1;
	}
	
	/**
	 * Column Info
	 * @param joCd10
	 */
	public void setJoCd10(String joCd10) {
		this.joCd10 = joCd10;
	}
	
	/**
	 * Column Info
	 * @param joCd5
	 */
	public void setJoCd5(String joCd5) {
		this.joCd5 = joCd5;
	}
	
	/**
	 * Column Info
	 * @param joCd4
	 */
	public void setJoCd4(String joCd4) {
		this.joCd4 = joCd4;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param joCd3
	 */
	public void setJoCd3(String joCd3) {
		this.joCd3 = joCd3;
	}
	
	/**
	 * Column Info
	 * @param arrYdCd
	 */
	public void setArrYdCd(String arrYdCd) {
		this.arrYdCd = arrYdCd;
	}
	
	/**
	 * Column Info
	 * @param jpShftCd
	 */
	public void setJpShftCd(String jpShftCd) {
		this.jpShftCd = jpShftCd;
	}
	
	/**
	 * Column Info
	 * @param joCd2
	 */
	public void setJoCd2(String joCd2) {
		this.joCd2 = joCd2;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param aftdrLen
	 */
	public void setAftdrLen(String aftdrLen) {
		this.aftdrLen = aftdrLen;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cnmtExtdFlg
	 */
	public void setCnmtExtdFlg(String cnmtExtdFlg) {
		this.cnmtExtdFlg = cnmtExtdFlg;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param joCd8
	 */
	public void setJoCd8(String joCd8) {
		this.joCd8 = joCd8;
	}
	
	/**
	 * Column Info
	 * @param joCd9
	 */
	public void setJoCd9(String joCd9) {
		this.joCd9 = joCd9;
	}
	
	/**
	 * Column Info
	 * @param joCd6
	 */
	public void setJoCd6(String joCd6) {
		this.joCd6 = joCd6;
	}
	
	/**
	 * Column Info
	 * @param joCd7
	 */
	public void setJoCd7(String joCd7) {
		this.joCd7 = joCd7;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDepYdCd(JSPUtil.getParameter(request, "dep_yd_cd", ""));
		setAtdDt(JSPUtil.getParameter(request, "atd_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setFwddrLen(JSPUtil.getParameter(request, "fwddr_len", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBagFlg(JSPUtil.getParameter(request, "bag_flg", ""));
		setAtbDt(JSPUtil.getParameter(request, "atb_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setJpAgnCd(JSPUtil.getParameter(request, "jp_agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setJpShftDt(JSPUtil.getParameter(request, "jp_shft_dt", ""));
		setAtaDt(JSPUtil.getParameter(request, "ata_dt", ""));
		setEtbDt(JSPUtil.getParameter(request, "etb_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setJoCd1(JSPUtil.getParameter(request, "jo_cd1", ""));
		setJoCd10(JSPUtil.getParameter(request, "jo_cd10", ""));
		setJoCd5(JSPUtil.getParameter(request, "jo_cd5", ""));
		setJoCd4(JSPUtil.getParameter(request, "jo_cd4", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setJoCd3(JSPUtil.getParameter(request, "jo_cd3", ""));
		setArrYdCd(JSPUtil.getParameter(request, "arr_yd_cd", ""));
		setJpShftCd(JSPUtil.getParameter(request, "jp_shft_cd", ""));
		setJoCd2(JSPUtil.getParameter(request, "jo_cd2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setAftdrLen(JSPUtil.getParameter(request, "aftdr_len", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCnmtExtdFlg(JSPUtil.getParameter(request, "cnmt_extd_flg", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setJoCd8(JSPUtil.getParameter(request, "jo_cd8", ""));
		setJoCd9(JSPUtil.getParameter(request, "jo_cd9", ""));
		setJoCd6(JSPUtil.getParameter(request, "jo_cd6", ""));
		setJoCd7(JSPUtil.getParameter(request, "jo_cd7", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsJpVslSkdVO[]
	 */
	public BkgCstmsJpVslSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsJpVslSkdVO[]
	 */
	public BkgCstmsJpVslSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsJpVslSkdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] depYdCd = (JSPUtil.getParameter(request, prefix	+ "dep_yd_cd", length));
			String[] atdDt = (JSPUtil.getParameter(request, prefix	+ "atd_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] fwddrLen = (JSPUtil.getParameter(request, prefix	+ "fwddr_len", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bagFlg = (JSPUtil.getParameter(request, prefix	+ "bag_flg", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] jpAgnCd = (JSPUtil.getParameter(request, prefix	+ "jp_agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jpShftDt = (JSPUtil.getParameter(request, prefix	+ "jp_shft_dt", length));
			String[] ataDt = (JSPUtil.getParameter(request, prefix	+ "ata_dt", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] joCd1 = (JSPUtil.getParameter(request, prefix	+ "jo_cd1", length));
			String[] joCd10 = (JSPUtil.getParameter(request, prefix	+ "jo_cd10", length));
			String[] joCd5 = (JSPUtil.getParameter(request, prefix	+ "jo_cd5", length));
			String[] joCd4 = (JSPUtil.getParameter(request, prefix	+ "jo_cd4", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] joCd3 = (JSPUtil.getParameter(request, prefix	+ "jo_cd3", length));
			String[] arrYdCd = (JSPUtil.getParameter(request, prefix	+ "arr_yd_cd", length));
			String[] jpShftCd = (JSPUtil.getParameter(request, prefix	+ "jp_shft_cd", length));
			String[] joCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_cd2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] aftdrLen = (JSPUtil.getParameter(request, prefix	+ "aftdr_len", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cnmtExtdFlg = (JSPUtil.getParameter(request, prefix	+ "cnmt_extd_flg", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] joCd8 = (JSPUtil.getParameter(request, prefix	+ "jo_cd8", length));
			String[] joCd9 = (JSPUtil.getParameter(request, prefix	+ "jo_cd9", length));
			String[] joCd6 = (JSPUtil.getParameter(request, prefix	+ "jo_cd6", length));
			String[] joCd7 = (JSPUtil.getParameter(request, prefix	+ "jo_cd7", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsJpVslSkdVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (depYdCd[i] != null)
					model.setDepYdCd(depYdCd[i]);
				if (atdDt[i] != null)
					model.setAtdDt(atdDt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (fwddrLen[i] != null)
					model.setFwddrLen(fwddrLen[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bagFlg[i] != null)
					model.setBagFlg(bagFlg[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (jpAgnCd[i] != null)
					model.setJpAgnCd(jpAgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jpShftDt[i] != null)
					model.setJpShftDt(jpShftDt[i]);
				if (ataDt[i] != null)
					model.setAtaDt(ataDt[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (joCd1[i] != null)
					model.setJoCd1(joCd1[i]);
				if (joCd10[i] != null)
					model.setJoCd10(joCd10[i]);
				if (joCd5[i] != null)
					model.setJoCd5(joCd5[i]);
				if (joCd4[i] != null)
					model.setJoCd4(joCd4[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (joCd3[i] != null)
					model.setJoCd3(joCd3[i]);
				if (arrYdCd[i] != null)
					model.setArrYdCd(arrYdCd[i]);
				if (jpShftCd[i] != null)
					model.setJpShftCd(jpShftCd[i]);
				if (joCd2[i] != null)
					model.setJoCd2(joCd2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (aftdrLen[i] != null)
					model.setAftdrLen(aftdrLen[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cnmtExtdFlg[i] != null)
					model.setCnmtExtdFlg(cnmtExtdFlg[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (joCd8[i] != null)
					model.setJoCd8(joCd8[i]);
				if (joCd9[i] != null)
					model.setJoCd9(joCd9[i]);
				if (joCd6[i] != null)
					model.setJoCd6(joCd6[i]);
				if (joCd7[i] != null)
					model.setJoCd7(joCd7[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsJpVslSkdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsJpVslSkdVO[]
	 */
	public BkgCstmsJpVslSkdVO[] getBkgCstmsJpVslSkdVOs(){
		BkgCstmsJpVslSkdVO[] vos = (BkgCstmsJpVslSkdVO[])models.toArray(new BkgCstmsJpVslSkdVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depYdCd = this.depYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdDt = this.atdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwddrLen = this.fwddrLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bagFlg = this.bagFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpAgnCd = this.jpAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpShftDt = this.jpShftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataDt = this.ataDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd1 = this.joCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd10 = this.joCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd5 = this.joCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd4 = this.joCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd3 = this.joCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrYdCd = this.arrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpShftCd = this.jpShftCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd2 = this.joCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftdrLen = this.aftdrLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmtExtdFlg = this.cnmtExtdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd8 = this.joCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd9 = this.joCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd6 = this.joCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCd7 = this.joCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
