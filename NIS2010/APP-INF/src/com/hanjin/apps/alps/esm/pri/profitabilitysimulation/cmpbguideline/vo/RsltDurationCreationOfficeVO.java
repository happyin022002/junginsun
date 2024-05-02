/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltDurationCreationOfficeVO.java
*@FileTitle : RsltDurationCreationOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.03 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltDurationCreationOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltDurationCreationOfficeVO> models = new ArrayList<RsltDurationCreationOfficeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String maxGlineSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String durationKey = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String prsCustTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prsCustTpCdBefore = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String creOfcCdHidden = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltDurationCreationOfficeVO() {}

	public RsltDurationCreationOfficeVO(String ibflag, String pagerows, String svcScpCd, String creOfcCd, String glineSeq, String effDt, String expDt, String cfmFlg, String prsCustTpCd, String creDt, String custCntCd, String custSeq, String creUsrId, String updUsrId, String updDt, String maxGlineSeq, String creOfcCdHidden, String prsCustTpCdBefore, String durationKey) {
		this.updDt = updDt;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.maxGlineSeq = maxGlineSeq;
		this.glineSeq = glineSeq;
		this.custSeq = custSeq;
		this.cfmFlg = cfmFlg;
		this.durationKey = durationKey;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.prsCustTpCd = prsCustTpCd;
		this.creUsrId = creUsrId;
		this.prsCustTpCdBefore = prsCustTpCdBefore;
		this.creOfcCd = creOfcCd;
		this.expDt = expDt;
		this.creOfcCdHidden = creOfcCdHidden;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("max_gline_seq", getMaxGlineSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("duration_key", getDurationKey());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prs_cust_tp_cd", getPrsCustTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prs_cust_tp_cd_before", getPrsCustTpCdBefore());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cre_ofc_cd_hidden", getCreOfcCdHidden());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("max_gline_seq", "maxGlineSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("duration_key", "durationKey");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prs_cust_tp_cd", "prsCustTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prs_cust_tp_cd_before", "prsCustTpCdBefore");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cre_ofc_cd_hidden", "creOfcCdHidden");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return maxGlineSeq
	 */
	public String getMaxGlineSeq() {
		return this.maxGlineSeq;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
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
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return durationKey
	 */
	public String getDurationKey() {
		return this.durationKey;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return prsCustTpCd
	 */
	public String getPrsCustTpCd() {
		return this.prsCustTpCd;
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
	 * @return prsCustTpCdBefore
	 */
	public String getPrsCustTpCdBefore() {
		return this.prsCustTpCdBefore;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCdHidden
	 */
	public String getCreOfcCdHidden() {
		return this.creOfcCdHidden;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param maxGlineSeq
	 */
	public void setMaxGlineSeq(String maxGlineSeq) {
		this.maxGlineSeq = maxGlineSeq;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
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
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param durationKey
	 */
	public void setDurationKey(String durationKey) {
		this.durationKey = durationKey;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param prsCustTpCd
	 */
	public void setPrsCustTpCd(String prsCustTpCd) {
		this.prsCustTpCd = prsCustTpCd;
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
	 * @param prsCustTpCdBefore
	 */
	public void setPrsCustTpCdBefore(String prsCustTpCdBefore) {
		this.prsCustTpCdBefore = prsCustTpCdBefore;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCdHidden
	 */
	public void setCreOfcCdHidden(String creOfcCdHidden) {
		this.creOfcCdHidden = creOfcCdHidden;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMaxGlineSeq(JSPUtil.getParameter(request, "max_gline_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setDurationKey(JSPUtil.getParameter(request, "duration_key", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPrsCustTpCd(JSPUtil.getParameter(request, "prs_cust_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPrsCustTpCdBefore(JSPUtil.getParameter(request, "prs_cust_tp_cd_before", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCreOfcCdHidden(JSPUtil.getParameter(request, "cre_ofc_cd_hidden", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltDurationCreationOfficeVO[]
	 */
	public RsltDurationCreationOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltDurationCreationOfficeVO[]
	 */
	public RsltDurationCreationOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltDurationCreationOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] maxGlineSeq = (JSPUtil.getParameter(request, prefix	+ "max_gline_seq", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] durationKey = (JSPUtil.getParameter(request, prefix	+ "duration_key", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] prsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prsCustTpCdBefore = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_cd_before", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] creOfcCdHidden = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd_hidden", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltDurationCreationOfficeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (maxGlineSeq[i] != null)
					model.setMaxGlineSeq(maxGlineSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (durationKey[i] != null)
					model.setDurationKey(durationKey[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (prsCustTpCd[i] != null)
					model.setPrsCustTpCd(prsCustTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prsCustTpCdBefore[i] != null)
					model.setPrsCustTpCdBefore(prsCustTpCdBefore[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (creOfcCdHidden[i] != null)
					model.setCreOfcCdHidden(creOfcCdHidden[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltDurationCreationOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltDurationCreationOfficeVO[]
	 */
	public RsltDurationCreationOfficeVO[] getRsltDurationCreationOfficeVOs(){
		RsltDurationCreationOfficeVO[] vos = (RsltDurationCreationOfficeVO[])models.toArray(new RsltDurationCreationOfficeVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxGlineSeq = this.maxGlineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationKey = this.durationKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpCd = this.prsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpCdBefore = this.prsCustTpCdBefore .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCdHidden = this.creOfcCdHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
