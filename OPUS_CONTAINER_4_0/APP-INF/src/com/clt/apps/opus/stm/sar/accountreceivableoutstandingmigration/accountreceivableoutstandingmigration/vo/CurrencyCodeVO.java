/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CurrencyCodeVO.java
*@FileTitle : CurrencyCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CurrencyCodeVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<CurrencyCodeVO> models = new ArrayList<CurrencyCodeVO>();
	
	/* Column Info */
	private String xtdPrcsKnt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currDesc = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String currNm = null;
	/* Column Info */
	private String fmEffDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CurrencyCodeVO() {}

	public CurrencyCodeVO(String ibflag, String pagerows, String currCd, String currNm, String currDesc, String cntCd, String fmEffDt, String toEffDt, String dpPrcsKnt, String xtdPrcsKnt, String deltFlg, String eaiEvntDt, String eaiIfId) {
		this.xtdPrcsKnt = xtdPrcsKnt;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.eaiIfId = eaiIfId;
		this.toEffDt = toEffDt;
		this.eaiEvntDt = eaiEvntDt;
		this.pagerows = pagerows;
		this.currDesc = currDesc;
		this.dpPrcsKnt = dpPrcsKnt;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.currNm = currNm;
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xtd_prcs_knt", getXtdPrcsKnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("curr_desc", getCurrDesc());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xtd_prcs_knt", "xtdPrcsKnt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("curr_desc", "currDesc");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xtdPrcsKnt
	 */
	public String getXtdPrcsKnt() {
		return this.xtdPrcsKnt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @return currDesc
	 */
	public String getCurrDesc() {
		return this.currDesc;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return currNm
	 */
	public String getCurrNm() {
		return this.currNm;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	

	/**
	 * Column Info
	 * @param xtdPrcsKnt
	 */
	public void setXtdPrcsKnt(String xtdPrcsKnt) {
		this.xtdPrcsKnt = xtdPrcsKnt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
	 * @param currDesc
	 */
	public void setCurrDesc(String currDesc) {
		this.currDesc = currDesc;
	}
	
	/**
	 * Column Info
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param currNm
	 */
	public void setCurrNm(String currNm) {
		this.currNm = currNm;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
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
		setXtdPrcsKnt(JSPUtil.getParameter(request, prefix + "xtd_prcs_knt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCurrDesc(JSPUtil.getParameter(request, prefix + "curr_desc", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCurrNm(JSPUtil.getParameter(request, prefix + "curr_nm", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CurrencyCodeVO[]
	 */
	public CurrencyCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CurrencyCodeVO[]
	 */
	public CurrencyCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CurrencyCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xtdPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "xtd_prcs_knt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currDesc = (JSPUtil.getParameter(request, prefix	+ "curr_desc", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CurrencyCodeVO();
				if (xtdPrcsKnt[i] != null)
					model.setXtdPrcsKnt(xtdPrcsKnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currDesc[i] != null)
					model.setCurrDesc(currDesc[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (currNm[i] != null)
					model.setCurrNm(currNm[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCurrencyCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CurrencyCodeVO[]
	 */
	public CurrencyCodeVO[] getCurrencyCodeVOs(){
		CurrencyCodeVO[] vos = (CurrencyCodeVO[])models.toArray(new CurrencyCodeVO[models.size()]);
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
		this.xtdPrcsKnt = this.xtdPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDesc = this.currDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
