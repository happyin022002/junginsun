/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CondSearchOwnerAccountVO.java
*@FileTitle : CondSearchOwnerAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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

public class CondSearchOwnerAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchOwnerAccountVO> models = new ArrayList<CondSearchOwnerAccountVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String cmbSttlmnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt1 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt2 = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String chkItemName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CondSearchOwnerAccountVO() {}

	public CondSearchOwnerAccountVO(String ibflag, String pagerows, String acctCd, String acctItmSeq, String effDt1, String effDt2, String vslCd, String vslEngNm, String locCd, String locNm, String acctItmNm, String chkItemName, String cmbSttlmnt) {
		this.vslCd = vslCd;
		this.acctItmNm = acctItmNm;
		this.locNm = locNm;
		this.cmbSttlmnt = cmbSttlmnt;
		this.pagerows = pagerows;
		this.acctItmSeq = acctItmSeq;
		this.ibflag = ibflag;
		this.effDt1 = effDt1;
		this.locCd = locCd;
		this.effDt2 = effDt2;
		this.vslEngNm = vslEngNm;
		this.acctCd = acctCd;
		this.chkItemName = chkItemName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("cmb_sttlmnt", getCmbSttlmnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt1", getEffDt1());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt2", getEffDt2());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("chk_item_name", getChkItemName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("cmb_sttlmnt", "cmbSttlmnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt1", "effDt1");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt2", "effDt2");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("chk_item_name", "chkItemName");
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
	 * @return acctItmNm
	 */
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return cmbSttlmnt
	 */
	public String getCmbSttlmnt() {
		return this.cmbSttlmnt;
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
	 * @return acctItmSeq
	 */
	public String getAcctItmSeq() {
		return this.acctItmSeq;
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
	 * @return effDt1
	 */
	public String getEffDt1() {
		return this.effDt1;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return effDt2
	 */
	public String getEffDt2() {
		return this.effDt2;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return chkItemName
	 */
	public String getChkItemName() {
		return this.chkItemName;
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
	 * @param acctItmNm
	 */
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param cmbSttlmnt
	 */
	public void setCmbSttlmnt(String cmbSttlmnt) {
		this.cmbSttlmnt = cmbSttlmnt;
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
	 * @param acctItmSeq
	 */
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
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
	 * @param effDt1
	 */
	public void setEffDt1(String effDt1) {
		this.effDt1 = effDt1;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param effDt2
	 */
	public void setEffDt2(String effDt2) {
		this.effDt2 = effDt2;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param chkItemName
	 */
	public void setChkItemName(String chkItemName) {
		this.chkItemName = chkItemName;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAcctItmNm(JSPUtil.getParameter(request, prefix + "acct_itm_nm", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setCmbSttlmnt(JSPUtil.getParameter(request, prefix + "cmb_sttlmnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, prefix + "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt1(JSPUtil.getParameter(request, prefix + "eff_dt1", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEffDt2(JSPUtil.getParameter(request, prefix + "eff_dt2", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setChkItemName(JSPUtil.getParameter(request, prefix + "chk_item_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchOwnerAccountVO[]
	 */
	public CondSearchOwnerAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchOwnerAccountVO[]
	 */
	public CondSearchOwnerAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchOwnerAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] cmbSttlmnt = (JSPUtil.getParameter(request, prefix	+ "cmb_sttlmnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt1 = (JSPUtil.getParameter(request, prefix	+ "eff_dt1", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt2 = (JSPUtil.getParameter(request, prefix	+ "eff_dt2", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] chkItemName = (JSPUtil.getParameter(request, prefix	+ "chk_item_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchOwnerAccountVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (cmbSttlmnt[i] != null)
					model.setCmbSttlmnt(cmbSttlmnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt1[i] != null)
					model.setEffDt1(effDt1[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt2[i] != null)
					model.setEffDt2(effDt2[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (chkItemName[i] != null)
					model.setChkItemName(chkItemName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchOwnerAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchOwnerAccountVO[]
	 */
	public CondSearchOwnerAccountVO[] getCondSearchOwnerAccountVOs(){
		CondSearchOwnerAccountVO[] vos = (CondSearchOwnerAccountVO[])models.toArray(new CondSearchOwnerAccountVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbSttlmnt = this.cmbSttlmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt1 = this.effDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt2 = this.effDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkItemName = this.chkItemName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
