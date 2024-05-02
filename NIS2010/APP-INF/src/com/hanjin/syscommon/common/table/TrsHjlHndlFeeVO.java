/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsHjlHndlFeeVO.java
*@FileTitle : TrsHjlHndlFeeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2012.05.25 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsHjlHndlFeeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsHjlHndlFeeVO> models = new ArrayList<TrsHjlHndlFeeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hjlOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hndlFeeHisSeq = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String commAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgTtlAmt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String orgCostRcvrAmt = null;
	/* Column Info */
	private String orgCommAmt = null;
	/* Column Info */
	private String costRcvrAmt = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgEffFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsHjlHndlFeeVO() {}

	public TrsHjlHndlFeeVO(String ibflag, String pagerows, String hjlOfcCd, String hndlFeeHisSeq, String vndrSeq, String currCd, String costRcvrAmt, String commAmt, String ttlAmt, String effFmDt, String FmDt,String orgCurrCd, String orgCostRcvrAmt, String orgCommAmt, String orgTtlAmt, String orgEffFmDt, String creUsrId, String creDt, String updUsrId, String updDt, String effToDt, String chk) {
		this.updDt = updDt;
		this.hjlOfcCd = hjlOfcCd;
		this.currCd = currCd;
		this.creDt = creDt;
		this.hndlFeeHisSeq = hndlFeeHisSeq;
		this.ttlAmt = ttlAmt;
		this.orgCurrCd = orgCurrCd;
		this.pagerows = pagerows;
		this.commAmt = commAmt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chk = chk;
		this.vndrSeq = vndrSeq;
		this.orgTtlAmt = orgTtlAmt;
		this.fmDt = fmDt;
		this.effFmDt = effFmDt;
		this.orgCostRcvrAmt = orgCostRcvrAmt;
		this.orgCommAmt = orgCommAmt;
		this.costRcvrAmt = costRcvrAmt;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
		this.orgEffFmDt = orgEffFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hjl_ofc_cd", getHjlOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("hndl_fee_his_seq", getHndlFeeHisSeq());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("comm_amt", getCommAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_ttl_amt", getOrgTtlAmt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("org_cost_rcvr_amt", getOrgCostRcvrAmt());
		this.hashColumns.put("org_comm_amt", getOrgCommAmt());
		this.hashColumns.put("cost_rcvr_amt", getCostRcvrAmt());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_eff_fm_dt", getOrgEffFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hjl_ofc_cd", "hjlOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hndl_fee_his_seq", "hndlFeeHisSeq");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_ttl_amt", "orgTtlAmt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("org_cost_rcvr_amt", "orgCostRcvrAmt");
		this.hashFields.put("org_comm_amt", "orgCommAmt");
		this.hashFields.put("cost_rcvr_amt", "costRcvrAmt");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_eff_fm_dt", "orgEffFmDt");
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
	 * @return hjlOfcCd
	 */
	public String getHjlOfcCd() {
		return this.hjlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return hndlFeeHisSeq
	 */
	public String getHndlFeeHisSeq() {
		return this.hndlFeeHisSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
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
	 * @return commAmt
	 */
	public String getCommAmt() {
		return this.commAmt;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgTtlAmt
	 */
	public String getOrgTtlAmt() {
		return this.orgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return orgCostRcvrAmt
	 */
	public String getOrgCostRcvrAmt() {
		return this.orgCostRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCommAmt
	 */
	public String getOrgCommAmt() {
		return this.orgCommAmt;
	}
	
	/**
	 * Column Info
	 * @return costRcvrAmt
	 */
	public String getCostRcvrAmt() {
		return this.costRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * @return orgEffFmDt
	 */
	public String getOrgEffFmDt() {
		return this.orgEffFmDt;
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
	 * @param hjlOfcCd
	 */
	public void setHjlOfcCd(String hjlOfcCd) {
		this.hjlOfcCd = hjlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param hndlFeeHisSeq
	 */
	public void setHndlFeeHisSeq(String hndlFeeHisSeq) {
		this.hndlFeeHisSeq = hndlFeeHisSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
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
	 * @param commAmt
	 */
	public void setCommAmt(String commAmt) {
		this.commAmt = commAmt;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgTtlAmt
	 */
	public void setOrgTtlAmt(String orgTtlAmt) {
		this.orgTtlAmt = orgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param orgCostRcvrAmt
	 */
	public void setOrgCostRcvrAmt(String orgCostRcvrAmt) {
		this.orgCostRcvrAmt = orgCostRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCommAmt
	 */
	public void setOrgCommAmt(String orgCommAmt) {
		this.orgCommAmt = orgCommAmt;
	}
	
	/**
	 * Column Info
	 * @param costRcvrAmt
	 */
	public void setCostRcvrAmt(String costRcvrAmt) {
		this.costRcvrAmt = costRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
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
	 * @param orgEffFmDt
	 */
	public void setOrgEffFmDt(String orgEffFmDt) {
		this.orgEffFmDt = orgEffFmDt;
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
		setHjlOfcCd(JSPUtil.getParameter(request, prefix + "hjl_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setHndlFeeHisSeq(JSPUtil.getParameter(request, prefix + "hndl_fee_his_seq", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, prefix + "org_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCommAmt(JSPUtil.getParameter(request, prefix + "comm_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOrgTtlAmt(JSPUtil.getParameter(request, prefix + "org_ttl_amt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));		
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setOrgCostRcvrAmt(JSPUtil.getParameter(request, prefix + "org_cost_rcvr_amt", ""));
		setOrgCommAmt(JSPUtil.getParameter(request, prefix + "org_comm_amt", ""));
		setCostRcvrAmt(JSPUtil.getParameter(request, prefix + "cost_rcvr_amt", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOrgEffFmDt(JSPUtil.getParameter(request, prefix + "org_eff_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsHjlHndlFeeVO[]
	 */
	public TrsHjlHndlFeeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsHjlHndlFeeVO[]
	 */
	public TrsHjlHndlFeeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsHjlHndlFeeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hjlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hjl_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hndlFeeHisSeq = (JSPUtil.getParameter(request, prefix	+ "hndl_fee_his_seq", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] commAmt = (JSPUtil.getParameter(request, prefix	+ "comm_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] orgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "org_ttl_amt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] orgCostRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "org_cost_rcvr_amt", length));
			String[] orgCommAmt = (JSPUtil.getParameter(request, prefix	+ "org_comm_amt", length));
			String[] costRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "cost_rcvr_amt", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgEffFmDt = (JSPUtil.getParameter(request, prefix	+ "org_eff_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsHjlHndlFeeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hjlOfcCd[i] != null)
					model.setHjlOfcCd(hjlOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hndlFeeHisSeq[i] != null)
					model.setHndlFeeHisSeq(hndlFeeHisSeq[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (commAmt[i] != null)
					model.setCommAmt(commAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgTtlAmt[i] != null)
					model.setOrgTtlAmt(orgTtlAmt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (orgCostRcvrAmt[i] != null)
					model.setOrgCostRcvrAmt(orgCostRcvrAmt[i]);
				if (orgCommAmt[i] != null)
					model.setOrgCommAmt(orgCommAmt[i]);
				if (costRcvrAmt[i] != null)
					model.setCostRcvrAmt(costRcvrAmt[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgEffFmDt[i] != null)
					model.setOrgEffFmDt(orgEffFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsHjlHndlFeeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsHjlHndlFeeVO[]
	 */
	public TrsHjlHndlFeeVO[] getTrsHjlHndlFeeVOs(){
		TrsHjlHndlFeeVO[] vos = (TrsHjlHndlFeeVO[])models.toArray(new TrsHjlHndlFeeVO[models.size()]);
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
		this.hjlOfcCd = this.hjlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlFeeHisSeq = this.hndlFeeHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAmt = this.commAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTtlAmt = this.orgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCostRcvrAmt = this.orgCostRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCommAmt = this.orgCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRcvrAmt = this.costRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEffFmDt = this.orgEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
