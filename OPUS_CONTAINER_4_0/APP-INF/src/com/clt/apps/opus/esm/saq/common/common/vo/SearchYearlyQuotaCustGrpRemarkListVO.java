/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchYearlyQuotaCustGrpRemarkListVO.java
*@FileTitle      : SearchYearlyQuotaCustGrpRemarkListVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SearchYearlyQuotaCustGrpRemarkListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearlyQuotaCustGrpRemarkListVO> models = new ArrayList<SearchYearlyQuotaCustGrpRemarkListVO>();
	
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String saqStsCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String subjCtnt = null;
	/* Column Info */
	private String yqtaStepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmtCtnt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rmkCreGdt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String keyAcctMgrUsrId = null;
	/* Column Info */
	private String yqtaVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearlyQuotaCustGrpRemarkListVO() {}

	public SearchYearlyQuotaCustGrpRemarkListVO(String ibflag, String pagerows, String yqtaStepCd, String bseYr, String yqtaVerNo, String keyAcctMgrUsrId, String custGrpId, String trdCd, String dirCd, String rlaneCd, String creSeq, String subjCtnt, String creOfcCd, String cmtCtnt, String rmkCreGdt, String saqStsCd) {
		this.custGrpId = custGrpId;
		this.creSeq = creSeq;
		this.saqStsCd = saqStsCd;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.subjCtnt = subjCtnt;
		this.yqtaStepCd = yqtaStepCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cmtCtnt = cmtCtnt;
		this.creOfcCd = creOfcCd;
		this.rmkCreGdt = rmkCreGdt;
		this.dirCd = dirCd;
		this.keyAcctMgrUsrId = keyAcctMgrUsrId;
		this.yqtaVerNo = yqtaVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("saq_sts_cd", getSaqStsCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("subj_ctnt", getSubjCtnt());
		this.hashColumns.put("yqta_step_cd", getYqtaStepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rmk_cre_gdt", getRmkCreGdt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("key_acct_mgr_usr_id", getKeyAcctMgrUsrId());
		this.hashColumns.put("yqta_ver_no", getYqtaVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("saq_sts_cd", "saqStsCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("subj_ctnt", "subjCtnt");
		this.hashFields.put("yqta_step_cd", "yqtaStepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rmk_cre_gdt", "rmkCreGdt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("key_acct_mgr_usr_id", "keyAcctMgrUsrId");
		this.hashFields.put("yqta_ver_no", "yqtaVerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return creSeq
	 */
	public String getCreSeq() {
		return this.creSeq;
	}
	
	/**
	 * Column Info
	 * @return saqStsCd
	 */
	public String getSaqStsCd() {
		return this.saqStsCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return subjCtnt
	 */
	public String getSubjCtnt() {
		return this.subjCtnt;
	}
	
	/**
	 * Column Info
	 * @return yqtaStepCd
	 */
	public String getYqtaStepCd() {
		return this.yqtaStepCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rmkCreGdt
	 */
	public String getRmkCreGdt() {
		return this.rmkCreGdt;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return keyAcctMgrUsrId
	 */
	public String getKeyAcctMgrUsrId() {
		return this.keyAcctMgrUsrId;
	}
	
	/**
	 * Column Info
	 * @return yqtaVerNo
	 */
	public String getYqtaVerNo() {
		return this.yqtaVerNo;
	}
	

	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param creSeq
	 */
	public void setCreSeq(String creSeq) {
		this.creSeq = creSeq;
	}
	
	/**
	 * Column Info
	 * @param saqStsCd
	 */
	public void setSaqStsCd(String saqStsCd) {
		this.saqStsCd = saqStsCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param subjCtnt
	 */
	public void setSubjCtnt(String subjCtnt) {
		this.subjCtnt = subjCtnt;
	}
	
	/**
	 * Column Info
	 * @param yqtaStepCd
	 */
	public void setYqtaStepCd(String yqtaStepCd) {
		this.yqtaStepCd = yqtaStepCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rmkCreGdt
	 */
	public void setRmkCreGdt(String rmkCreGdt) {
		this.rmkCreGdt = rmkCreGdt;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param keyAcctMgrUsrId
	 */
	public void setKeyAcctMgrUsrId(String keyAcctMgrUsrId) {
		this.keyAcctMgrUsrId = keyAcctMgrUsrId;
	}
	
	/**
	 * Column Info
	 * @param yqtaVerNo
	 */
	public void setYqtaVerNo(String yqtaVerNo) {
		this.yqtaVerNo = yqtaVerNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustGrpId(JSPUtil.getParameter(request, "cust_grp_id", ""));
		setCreSeq(JSPUtil.getParameter(request, "cre_seq", ""));
		setSaqStsCd(JSPUtil.getParameter(request, "saq_sts_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSubjCtnt(JSPUtil.getParameter(request, "subj_ctnt", ""));
		setYqtaStepCd(JSPUtil.getParameter(request, "yqta_step_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmtCtnt(JSPUtil.getParameter(request, "cmt_ctnt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRmkCreGdt(JSPUtil.getParameter(request, "rmk_cre_gdt", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setKeyAcctMgrUsrId(JSPUtil.getParameter(request, "key_acct_mgr_usr_id", ""));
		setYqtaVerNo(JSPUtil.getParameter(request, "yqta_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearlyQuotaCustGrpRemarkListVO[]
	 */
	public SearchYearlyQuotaCustGrpRemarkListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearlyQuotaCustGrpRemarkListVO[]
	 */
	public SearchYearlyQuotaCustGrpRemarkListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearlyQuotaCustGrpRemarkListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] saqStsCd = (JSPUtil.getParameter(request, prefix	+ "saq_sts_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] subjCtnt = (JSPUtil.getParameter(request, prefix	+ "subj_ctnt", length));
			String[] yqtaStepCd = (JSPUtil.getParameter(request, prefix	+ "yqta_step_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rmkCreGdt = (JSPUtil.getParameter(request, prefix	+ "rmk_cre_gdt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] keyAcctMgrUsrId = (JSPUtil.getParameter(request, prefix	+ "key_acct_mgr_usr_id", length));
			String[] yqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "yqta_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearlyQuotaCustGrpRemarkListVO();
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (saqStsCd[i] != null)
					model.setSaqStsCd(saqStsCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (subjCtnt[i] != null)
					model.setSubjCtnt(subjCtnt[i]);
				if (yqtaStepCd[i] != null)
					model.setYqtaStepCd(yqtaStepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rmkCreGdt[i] != null)
					model.setRmkCreGdt(rmkCreGdt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (keyAcctMgrUsrId[i] != null)
					model.setKeyAcctMgrUsrId(keyAcctMgrUsrId[i]);
				if (yqtaVerNo[i] != null)
					model.setYqtaVerNo(yqtaVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearlyQuotaCustGrpRemarkListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearlyQuotaCustGrpRemarkListVO[]
	 */
	public SearchYearlyQuotaCustGrpRemarkListVO[] getSearchYearlyQuotaCustGrpRemarkListVOs(){
		SearchYearlyQuotaCustGrpRemarkListVO[] vos = (SearchYearlyQuotaCustGrpRemarkListVO[])models.toArray(new SearchYearlyQuotaCustGrpRemarkListVO[models.size()]);
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
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqStsCd = this.saqStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjCtnt = this.subjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaStepCd = this.yqtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCreGdt = this.rmkCreGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctMgrUsrId = this.keyAcctMgrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaVerNo = this.yqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
