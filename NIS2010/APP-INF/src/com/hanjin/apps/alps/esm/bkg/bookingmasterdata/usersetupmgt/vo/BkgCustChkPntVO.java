/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCustChkPntVO.java
*@FileTitle : BkgCustChkPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.06.29 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustChkPntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustChkPntVO> models = new ArrayList<BkgCustChkPntVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String chkPntTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String chkPntItmTpNm = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String chkPntRmk = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String atchFileKnt = null;
	/* Column Info */
	private String chkPntItmTpSeq = null;
	/* Column Info */
	private String chkPntItmNm = null;
	/* Column Info */
	private String chkPntItmSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custChkPntSeq = null;
	/* Column Info */
	private String picEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCustChkPntVO() {}

	public BkgCustChkPntVO(String ibflag, String pagerows, String custCntCd, String custSeq, String custLglEngNm, String bkgOfcCd, String chkPntTpCd, String custChkPntSeq, String chkPntItmSeq, String chkPntItmNm, String chkPntItmTpSeq, String chkPntItmTpNm, String chkPntRmk, String picEml, String atchFileLnkId, String atchFileKnt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String usrNm, String ofcCd) {
		this.updDt = updDt;
		this.bkgOfcCd = bkgOfcCd;
		this.chkPntTpCd = chkPntTpCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.custSeq = custSeq;
		this.chkPntItmTpNm = chkPntItmTpNm;
		this.atchFileLnkId = atchFileLnkId;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.chkPntRmk = chkPntRmk;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.atchFileKnt = atchFileKnt;
		this.chkPntItmTpSeq = chkPntItmTpSeq;
		this.chkPntItmNm = chkPntItmNm;
		this.chkPntItmSeq = chkPntItmSeq;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.custChkPntSeq = custChkPntSeq;
		this.picEml = picEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("chk_pnt_tp_cd", getChkPntTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("chk_pnt_itm_tp_nm", getChkPntItmTpNm());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("chk_pnt_rmk", getChkPntRmk());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("atch_file_knt", getAtchFileKnt());
		this.hashColumns.put("chk_pnt_itm_tp_seq", getChkPntItmTpSeq());
		this.hashColumns.put("chk_pnt_itm_nm", getChkPntItmNm());
		this.hashColumns.put("chk_pnt_itm_seq", getChkPntItmSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_chk_pnt_seq", getCustChkPntSeq());
		this.hashColumns.put("pic_eml", getPicEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("chk_pnt_tp_cd", "chkPntTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("chk_pnt_itm_tp_nm", "chkPntItmTpNm");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("chk_pnt_rmk", "chkPntRmk");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("atch_file_knt", "atchFileKnt");
		this.hashFields.put("chk_pnt_itm_tp_seq", "chkPntItmTpSeq");
		this.hashFields.put("chk_pnt_itm_nm", "chkPntItmNm");
		this.hashFields.put("chk_pnt_itm_seq", "chkPntItmSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_chk_pnt_seq", "custChkPntSeq");
		this.hashFields.put("pic_eml", "picEml");
		return this.hashFields;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chkPntTpCd
	 */
	public String getChkPntTpCd() {
		return this.chkPntTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return chkPntItmTpNm
	 */
	public String getChkPntItmTpNm() {
		return this.chkPntItmTpNm;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return chkPntRmk
	 */
	public String getChkPntRmk() {
		return this.chkPntRmk;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return atchFileKnt
	 */
	public String getAtchFileKnt() {
		return this.atchFileKnt;
	}
	
	/**
	 * Column Info
	 * @return chkPntItmTpSeq
	 */
	public String getChkPntItmTpSeq() {
		return this.chkPntItmTpSeq;
	}
	
	/**
	 * Column Info
	 * @return chkPntItmNm
	 */
	public String getChkPntItmNm() {
		return this.chkPntItmNm;
	}
	
	/**
	 * Column Info
	 * @return chkPntItmSeq
	 */
	public String getChkPntItmSeq() {
		return this.chkPntItmSeq;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return custChkPntSeq
	 */
	public String getCustChkPntSeq() {
		return this.custChkPntSeq;
	}
	
	/**
	 * Column Info
	 * @return picEml
	 */
	public String getPicEml() {
		return this.picEml;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chkPntTpCd
	 */
	public void setChkPntTpCd(String chkPntTpCd) {
		this.chkPntTpCd = chkPntTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param chkPntItmTpNm
	 */
	public void setChkPntItmTpNm(String chkPntItmTpNm) {
		this.chkPntItmTpNm = chkPntItmTpNm;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param chkPntRmk
	 */
	public void setChkPntRmk(String chkPntRmk) {
		this.chkPntRmk = chkPntRmk;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param atchFileKnt
	 */
	public void setAtchFileKnt(String atchFileKnt) {
		this.atchFileKnt = atchFileKnt;
	}
	
	/**
	 * Column Info
	 * @param chkPntItmTpSeq
	 */
	public void setChkPntItmTpSeq(String chkPntItmTpSeq) {
		this.chkPntItmTpSeq = chkPntItmTpSeq;
	}
	
	/**
	 * Column Info
	 * @param chkPntItmNm
	 */
	public void setChkPntItmNm(String chkPntItmNm) {
		this.chkPntItmNm = chkPntItmNm;
	}
	
	/**
	 * Column Info
	 * @param chkPntItmSeq
	 */
	public void setChkPntItmSeq(String chkPntItmSeq) {
		this.chkPntItmSeq = chkPntItmSeq;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param custChkPntSeq
	 */
	public void setCustChkPntSeq(String custChkPntSeq) {
		this.custChkPntSeq = custChkPntSeq;
	}
	
	/**
	 * Column Info
	 * @param picEml
	 */
	public void setPicEml(String picEml) {
		this.picEml = picEml;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setChkPntTpCd(JSPUtil.getParameter(request, prefix + "chk_pnt_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setChkPntItmTpNm(JSPUtil.getParameter(request, prefix + "chk_pnt_itm_tp_nm", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setChkPntRmk(JSPUtil.getParameter(request, prefix + "chk_pnt_rmk", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setAtchFileKnt(JSPUtil.getParameter(request, prefix + "atch_file_knt", ""));
		setChkPntItmTpSeq(JSPUtil.getParameter(request, prefix + "chk_pnt_itm_tp_seq", ""));
		setChkPntItmNm(JSPUtil.getParameter(request, prefix + "chk_pnt_itm_nm", ""));
		setChkPntItmSeq(JSPUtil.getParameter(request, prefix + "chk_pnt_itm_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustChkPntSeq(JSPUtil.getParameter(request, prefix + "cust_chk_pnt_seq", ""));
		setPicEml(JSPUtil.getParameter(request, prefix + "pic_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustChkPntVO[]
	 */
	public BkgCustChkPntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustChkPntVO[]
	 */
	public BkgCustChkPntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustChkPntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] chkPntTpCd = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] chkPntItmTpNm = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_itm_tp_nm", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] chkPntRmk = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_rmk", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] atchFileKnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_knt", length));
			String[] chkPntItmTpSeq = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_itm_tp_seq", length));
			String[] chkPntItmNm = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_itm_nm", length));
			String[] chkPntItmSeq = (JSPUtil.getParameter(request, prefix	+ "chk_pnt_itm_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custChkPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_chk_pnt_seq", length));
			String[] picEml = (JSPUtil.getParameter(request, prefix	+ "pic_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustChkPntVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (chkPntTpCd[i] != null)
					model.setChkPntTpCd(chkPntTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (chkPntItmTpNm[i] != null)
					model.setChkPntItmTpNm(chkPntItmTpNm[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (chkPntRmk[i] != null)
					model.setChkPntRmk(chkPntRmk[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (atchFileKnt[i] != null)
					model.setAtchFileKnt(atchFileKnt[i]);
				if (chkPntItmTpSeq[i] != null)
					model.setChkPntItmTpSeq(chkPntItmTpSeq[i]);
				if (chkPntItmNm[i] != null)
					model.setChkPntItmNm(chkPntItmNm[i]);
				if (chkPntItmSeq[i] != null)
					model.setChkPntItmSeq(chkPntItmSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custChkPntSeq[i] != null)
					model.setCustChkPntSeq(custChkPntSeq[i]);
				if (picEml[i] != null)
					model.setPicEml(picEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustChkPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustChkPntVO[]
	 */
	public BkgCustChkPntVO[] getBkgCustChkPntVOs(){
		BkgCustChkPntVO[] vos = (BkgCustChkPntVO[])models.toArray(new BkgCustChkPntVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntTpCd = this.chkPntTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntItmTpNm = this.chkPntItmTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntRmk = this.chkPntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileKnt = this.atchFileKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntItmTpSeq = this.chkPntItmTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntItmNm = this.chkPntItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPntItmSeq = this.chkPntItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custChkPntSeq = this.custChkPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picEml = this.picEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
