/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgRevUmchBkgVO.java
*@FileTitle : BkgRevUmchBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgRevUmchBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRevUmchBkgVO> models = new ArrayList<BkgRevUmchBkgVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnlStlTpCd = null;
	/* Column Info */
    private String mnlStlTp = null;
	/* Column Info */
	private String revAudAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchRsnRmk = null;
	/* Column Info */
	private String stlSysDiffAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String revAudStsCd = null;
	/* Column Info */
	private String revAudTpCd = null;
	/* Column Info */
	private String mnlStlRqstFlg = null;
	/* Column Info */
	private String revAudStlKndCd = null;
	/* Column Info */
	private String stlUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgnGrpAvcRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String stlDt = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String n1stUmchFndDt = null;
	/* Column Info */
	private String stlBkgCorrNo = null;
	/* Column Info */
	private String stlMnlDiffAmt = null;
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lstUmchFndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgRevUmchBkgVO() {}

	public BkgRevUmchBkgVO(String ibflag, String pagerows, String bkgNo, String umchBkgSeq, String bkgCorrNo, String stlBkgCorrNo, String stlSysDiffAmt, String stlMnlDiffAmt, String revAudStsCd, String revAudStlKndCd, String n1stUmchFndDt, String lstUmchFndDt, String revAudTpCd, String stlDt, String umchRsnRmk, String rgnGrpAvcRmk, String stlUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String mnlStlTpCd, String mnlStlTp, String mnlStlRqstFlg, String revAudAmt) {
		this.pagerows = pagerows;
		this.mnlStlTpCd = mnlStlTpCd;
		this.mnlStlTp = mnlStlTp;
		this.revAudAmt = revAudAmt;
		this.ibflag = ibflag;
		this.umchRsnRmk = umchRsnRmk;
		this.stlSysDiffAmt = stlSysDiffAmt;
		this.bkgNo = bkgNo;
		this.revAudStsCd = revAudStsCd;
		this.revAudTpCd = revAudTpCd;
		this.mnlStlRqstFlg = mnlStlRqstFlg;
		this.revAudStlKndCd = revAudStlKndCd;
		this.stlUsrId = stlUsrId;
		this.updUsrId = updUsrId;
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.stlDt = stlDt;
		this.bkgCorrNo = bkgCorrNo;
		this.n1stUmchFndDt = n1stUmchFndDt;
		this.stlBkgCorrNo = stlBkgCorrNo;
		this.stlMnlDiffAmt = stlMnlDiffAmt;
		this.umchBkgSeq = umchBkgSeq;
		this.updDt = updDt;
		this.lstUmchFndDt = lstUmchFndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnl_stl_tp_cd", getMnlStlTpCd());
		this.hashColumns.put("mnl_stl_tp", getMnlStlTp());
		this.hashColumns.put("rev_aud_amt", getRevAudAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_rsn_rmk", getUmchRsnRmk());
		this.hashColumns.put("stl_sys_diff_amt", getStlSysDiffAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rev_aud_sts_cd", getRevAudStsCd());
		this.hashColumns.put("rev_aud_tp_cd", getRevAudTpCd());
		this.hashColumns.put("mnl_stl_rqst_flg", getMnlStlRqstFlg());
		this.hashColumns.put("rev_aud_stl_knd_cd", getRevAudStlKndCd());
		this.hashColumns.put("stl_usr_id", getStlUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgn_grp_avc_rmk", getRgnGrpAvcRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("stl_dt", getStlDt());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("n1st_umch_fnd_dt", getN1stUmchFndDt());
		this.hashColumns.put("stl_bkg_corr_no", getStlBkgCorrNo());
		this.hashColumns.put("stl_mnl_diff_amt", getStlMnlDiffAmt());
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lst_umch_fnd_dt", getLstUmchFndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnl_stl_tp_cd", "mnlStlTpCd");
		this.hashFields.put("mnl_stl_tp", "mnlStlTp");
		this.hashFields.put("rev_aud_amt", "revAudAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_rsn_rmk", "umchRsnRmk");
		this.hashFields.put("stl_sys_diff_amt", "stlSysDiffAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rev_aud_sts_cd", "revAudStsCd");
		this.hashFields.put("rev_aud_tp_cd", "revAudTpCd");
		this.hashFields.put("mnl_stl_rqst_flg", "mnlStlRqstFlg");
		this.hashFields.put("rev_aud_stl_knd_cd", "revAudStlKndCd");
		this.hashFields.put("stl_usr_id", "stlUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgn_grp_avc_rmk", "rgnGrpAvcRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("stl_dt", "stlDt");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("n1st_umch_fnd_dt", "n1stUmchFndDt");
		this.hashFields.put("stl_bkg_corr_no", "stlBkgCorrNo");
		this.hashFields.put("stl_mnl_diff_amt", "stlMnlDiffAmt");
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lst_umch_fnd_dt", "lstUmchFndDt");
		return this.hashFields;
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
	 * @return mnlStlTpCd
	 */
	public String getMnlStlTpCd() {
		return this.mnlStlTpCd;
	}
	
	/**
     * Column Info
     * @return mnlStlTp
     */
    public String getMnlStlTp() {
        return this.mnlStlTp;
    }
	
	/**
	 * Column Info
	 * @return revAudAmt
	 */
	public String getRevAudAmt() {
		return this.revAudAmt;
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
	 * @return umchRsnRmk
	 */
	public String getUmchRsnRmk() {
		return this.umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return stlSysDiffAmt
	 */
	public String getStlSysDiffAmt() {
		return this.stlSysDiffAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return revAudStsCd
	 */
	public String getRevAudStsCd() {
		return this.revAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return revAudTpCd
	 */
	public String getRevAudTpCd() {
		return this.revAudTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnlStlRqstFlg
	 */
	public String getMnlStlRqstFlg() {
		return this.mnlStlRqstFlg;
	}
	
	/**
	 * Column Info
	 * @return revAudStlKndCd
	 */
	public String getRevAudStlKndCd() {
		return this.revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @return stlUsrId
	 */
	public String getStlUsrId() {
		return this.stlUsrId;
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
	 * @return rgnGrpAvcRmk
	 */
	public String getRgnGrpAvcRmk() {
		return this.rgnGrpAvcRmk;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return stlDt
	 */
	public String getStlDt() {
		return this.stlDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return n1stUmchFndDt
	 */
	public String getN1stUmchFndDt() {
		return this.n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @return stlBkgCorrNo
	 */
	public String getStlBkgCorrNo() {
		return this.stlBkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return stlMnlDiffAmt
	 */
	public String getStlMnlDiffAmt() {
		return this.stlMnlDiffAmt;
	}
	
	/**
	 * Column Info
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
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
	 * @return lstUmchFndDt
	 */
	public String getLstUmchFndDt() {
		return this.lstUmchFndDt;
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
	 * @param mnlStlTpCd
	 */
	public void setMnlStlTpCd(String mnlStlTpCd) {
		this.mnlStlTpCd = mnlStlTpCd;
	}
	
	/**
     * Column Info
     * @param mnlStlTp
     */
    public void setMnlStlTp(String mnlStlTp) {
        this.mnlStlTp = mnlStlTp;
    }
	
	/**
	 * Column Info
	 * @param revAudAmt
	 */
	public void setRevAudAmt(String revAudAmt) {
		this.revAudAmt = revAudAmt;
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
	 * @param umchRsnRmk
	 */
	public void setUmchRsnRmk(String umchRsnRmk) {
		this.umchRsnRmk = umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param stlSysDiffAmt
	 */
	public void setStlSysDiffAmt(String stlSysDiffAmt) {
		this.stlSysDiffAmt = stlSysDiffAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param revAudStsCd
	 */
	public void setRevAudStsCd(String revAudStsCd) {
		this.revAudStsCd = revAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param revAudTpCd
	 */
	public void setRevAudTpCd(String revAudTpCd) {
		this.revAudTpCd = revAudTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnlStlRqstFlg
	 */
	public void setMnlStlRqstFlg(String mnlStlRqstFlg) {
		this.mnlStlRqstFlg = mnlStlRqstFlg;
	}
	
	/**
	 * Column Info
	 * @param revAudStlKndCd
	 */
	public void setRevAudStlKndCd(String revAudStlKndCd) {
		this.revAudStlKndCd = revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @param stlUsrId
	 */
	public void setStlUsrId(String stlUsrId) {
		this.stlUsrId = stlUsrId;
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
	 * @param rgnGrpAvcRmk
	 */
	public void setRgnGrpAvcRmk(String rgnGrpAvcRmk) {
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param stlDt
	 */
	public void setStlDt(String stlDt) {
		this.stlDt = stlDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param n1stUmchFndDt
	 */
	public void setN1stUmchFndDt(String n1stUmchFndDt) {
		this.n1stUmchFndDt = n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @param stlBkgCorrNo
	 */
	public void setStlBkgCorrNo(String stlBkgCorrNo) {
		this.stlBkgCorrNo = stlBkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param stlMnlDiffAmt
	 */
	public void setStlMnlDiffAmt(String stlMnlDiffAmt) {
		this.stlMnlDiffAmt = stlMnlDiffAmt;
	}
	
	/**
	 * Column Info
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
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
	 * @param lstUmchFndDt
	 */
	public void setLstUmchFndDt(String lstUmchFndDt) {
		this.lstUmchFndDt = lstUmchFndDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnlStlTpCd(JSPUtil.getParameter(request, prefix + "mnl_stl_tp_cd", ""));
		setMnlStlTp(JSPUtil.getParameter(request, prefix + "mnl_stl_tp", ""));
		setRevAudAmt(JSPUtil.getParameter(request, prefix + "rev_aud_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUmchRsnRmk(JSPUtil.getParameter(request, prefix + "umch_rsn_rmk", ""));
		setStlSysDiffAmt(JSPUtil.getParameter(request, prefix + "stl_sys_diff_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRevAudStsCd(JSPUtil.getParameter(request, prefix + "rev_aud_sts_cd", ""));
		setRevAudTpCd(JSPUtil.getParameter(request, prefix + "rev_aud_tp_cd", ""));
		setMnlStlRqstFlg(JSPUtil.getParameter(request, prefix + "mnl_stl_rqst_flg", ""));
		setRevAudStlKndCd(JSPUtil.getParameter(request, prefix + "rev_aud_stl_knd_cd", ""));
		setStlUsrId(JSPUtil.getParameter(request, prefix + "stl_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRgnGrpAvcRmk(JSPUtil.getParameter(request, prefix + "rgn_grp_avc_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setStlDt(JSPUtil.getParameter(request, prefix + "stl_dt", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, prefix + "bkg_corr_no", ""));
		setN1stUmchFndDt(JSPUtil.getParameter(request, prefix + "n1st_umch_fnd_dt", ""));
		setStlBkgCorrNo(JSPUtil.getParameter(request, prefix + "stl_bkg_corr_no", ""));
		setStlMnlDiffAmt(JSPUtil.getParameter(request, prefix + "stl_mnl_diff_amt", ""));
		setUmchBkgSeq(JSPUtil.getParameter(request, prefix + "umch_bkg_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLstUmchFndDt(JSPUtil.getParameter(request, prefix + "lst_umch_fnd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRevUmchBkgVO[]
	 */
	public BkgRevUmchBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRevUmchBkgVO[]
	 */
	public BkgRevUmchBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRevUmchBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnlStlTpCd = (JSPUtil.getParameter(request, prefix	+ "mnl_stl_tp_cd", length));
			String[] mnlStlTp = (JSPUtil.getParameter(request, prefix  + "mnl_stl_tp", length));
			String[] revAudAmt = (JSPUtil.getParameter(request, prefix	+ "rev_aud_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchRsnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rsn_rmk", length));
			String[] stlSysDiffAmt = (JSPUtil.getParameter(request, prefix	+ "stl_sys_diff_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] revAudStsCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_sts_cd", length));
			String[] revAudTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tp_cd", length));
			String[] mnlStlRqstFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_stl_rqst_flg", length));
			String[] revAudStlKndCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_stl_knd_cd", length));
			String[] stlUsrId = (JSPUtil.getParameter(request, prefix	+ "stl_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgnGrpAvcRmk = (JSPUtil.getParameter(request, prefix	+ "rgn_grp_avc_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] stlDt = (JSPUtil.getParameter(request, prefix	+ "stl_dt", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] n1stUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "n1st_umch_fnd_dt", length));
			String[] stlBkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "stl_bkg_corr_no", length));
			String[] stlMnlDiffAmt = (JSPUtil.getParameter(request, prefix	+ "stl_mnl_diff_amt", length));
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lstUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "lst_umch_fnd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgRevUmchBkgVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnlStlTpCd[i] != null)
					model.setMnlStlTpCd(mnlStlTpCd[i]);
				if (mnlStlTp[i] != null)
                    model.setMnlStlTp(mnlStlTp[i]);
				if (revAudAmt[i] != null)
					model.setRevAudAmt(revAudAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchRsnRmk[i] != null)
					model.setUmchRsnRmk(umchRsnRmk[i]);
				if (stlSysDiffAmt[i] != null)
					model.setStlSysDiffAmt(stlSysDiffAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (revAudStsCd[i] != null)
					model.setRevAudStsCd(revAudStsCd[i]);
				if (revAudTpCd[i] != null)
					model.setRevAudTpCd(revAudTpCd[i]);
				if (mnlStlRqstFlg[i] != null)
					model.setMnlStlRqstFlg(mnlStlRqstFlg[i]);
				if (revAudStlKndCd[i] != null)
					model.setRevAudStlKndCd(revAudStlKndCd[i]);
				if (stlUsrId[i] != null)
					model.setStlUsrId(stlUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgnGrpAvcRmk[i] != null)
					model.setRgnGrpAvcRmk(rgnGrpAvcRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (stlDt[i] != null)
					model.setStlDt(stlDt[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (n1stUmchFndDt[i] != null)
					model.setN1stUmchFndDt(n1stUmchFndDt[i]);
				if (stlBkgCorrNo[i] != null)
					model.setStlBkgCorrNo(stlBkgCorrNo[i]);
				if (stlMnlDiffAmt[i] != null)
					model.setStlMnlDiffAmt(stlMnlDiffAmt[i]);
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lstUmchFndDt[i] != null)
					model.setLstUmchFndDt(lstUmchFndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRevUmchBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRevUmchBkgVO[]
	 */
	public BkgRevUmchBkgVO[] getBkgRevUmchBkgVOs(){
		BkgRevUmchBkgVO[] vos = (BkgRevUmchBkgVO[])models.toArray(new BkgRevUmchBkgVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlTpCd = this.mnlStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlTp = this.mnlStlTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudAmt = this.revAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRsnRmk = this.umchRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSysDiffAmt = this.stlSysDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStsCd = this.revAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudTpCd = this.revAudTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlStlRqstFlg = this.mnlStlRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStlKndCd = this.revAudStlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsrId = this.stlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrpAvcRmk = this.rgnGrpAvcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDt = this.stlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stUmchFndDt = this.n1stUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlBkgCorrNo = this.stlBkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlMnlDiffAmt = this.stlMnlDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUmchFndDt = this.lstUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
