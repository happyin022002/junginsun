/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RqsNoVO.java
*@FileTitle : RqsNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.12 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RqsNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RqsNoVO> models = new ArrayList<RqsNoVO>();
	
	/* Column Info */
	private String toGenExpnItmNo = null;
	/* Column Info */
	private String toCurrCd = null;
	/* Column Info */
	private String toUtVal = null;
	/* Column Info */
	private String frUtVal = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String frOfcCd = null;
	/* Column Info */
	private String toAmt = null;
	/* Column Info */
	private String reqUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String frGenExpnItmNo = null;
	/* Column Info */
	private String frAmt = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String frGenExpnCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RqsNoVO() {}

	public RqsNoVO(String ibflag, String pagerows, String genExpnRqstNo, String genExpnRqstSeq, String frGenExpnCd, String toGenExpnCd, String frGenExpnItmNo, String toGenExpnItmNo, String frOfcCd, String toOfcCd, String frAmt, String toAmt, String creUsrId, String reqUpdDt, String frCurrCd, String toCurrCd, String frUtVal, String toUtVal) {
		this.toGenExpnItmNo = toGenExpnItmNo;
		this.toCurrCd = toCurrCd;
		this.toUtVal = toUtVal;
		this.frUtVal = frUtVal;
		this.toGenExpnCd = toGenExpnCd;
		this.frOfcCd = frOfcCd;
		this.toAmt = toAmt;
		this.reqUpdDt = reqUpdDt;
		this.pagerows = pagerows;
		this.frCurrCd = frCurrCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.genExpnRqstNo = genExpnRqstNo;
		this.frGenExpnItmNo = frGenExpnItmNo;
		this.frAmt = frAmt;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.toOfcCd = toOfcCd;
		this.frGenExpnCd = frGenExpnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_gen_expn_itm_no", getToGenExpnItmNo());
		this.hashColumns.put("to_curr_cd", getToCurrCd());
		this.hashColumns.put("to_ut_val", getToUtVal());
		this.hashColumns.put("fr_ut_val", getFrUtVal());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("fr_ofc_cd", getFrOfcCd());
		this.hashColumns.put("to_amt", getToAmt());
		this.hashColumns.put("req_upd_dt", getReqUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fr_curr_cd", getFrCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("fr_gen_expn_itm_no", getFrGenExpnItmNo());
		this.hashColumns.put("fr_amt", getFrAmt());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("fr_gen_expn_cd", getFrGenExpnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_gen_expn_itm_no", "toGenExpnItmNo");
		this.hashFields.put("to_curr_cd", "toCurrCd");
		this.hashFields.put("to_ut_val", "toUtVal");
		this.hashFields.put("fr_ut_val", "frUtVal");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("fr_ofc_cd", "frOfcCd");
		this.hashFields.put("to_amt", "toAmt");
		this.hashFields.put("req_upd_dt", "reqUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fr_curr_cd", "frCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("fr_gen_expn_itm_no", "frGenExpnItmNo");
		this.hashFields.put("fr_amt", "frAmt");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("fr_gen_expn_cd", "frGenExpnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmNo
	 */
	public String getToGenExpnItmNo() {
		return this.toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return toCurrCd
	 */
	public String getToCurrCd() {
		return this.toCurrCd;
	}
	
	/**
	 * Column Info
	 * @return toUtVal
	 */
	public String getToUtVal() {
		return this.toUtVal;
	}
	
	/**
	 * Column Info
	 * @return frUtVal
	 */
	public String getFrUtVal() {
		return this.frUtVal;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return frOfcCd
	 */
	public String getFrOfcCd() {
		return this.frOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toAmt
	 */
	public String getToAmt() {
		return this.toAmt;
	}
	
	/**
	 * Column Info
	 * @return reqUpdDt
	 */
	public String getReqUpdDt() {
		return this.reqUpdDt;
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
	 * @return frCurrCd
	 */
	public String getFrCurrCd() {
		return this.frCurrCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return frGenExpnItmNo
	 */
	public String getFrGenExpnItmNo() {
		return this.frGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return frAmt
	 */
	public String getFrAmt() {
		return this.frAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frGenExpnCd
	 */
	public String getFrGenExpnCd() {
		return this.frGenExpnCd;
	}
	

	/**
	 * Column Info
	 * @param toGenExpnItmNo
	 */
	public void setToGenExpnItmNo(String toGenExpnItmNo) {
		this.toGenExpnItmNo = toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param toCurrCd
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
	}
	
	/**
	 * Column Info
	 * @param toUtVal
	 */
	public void setToUtVal(String toUtVal) {
		this.toUtVal = toUtVal;
	}
	
	/**
	 * Column Info
	 * @param frUtVal
	 */
	public void setFrUtVal(String frUtVal) {
		this.frUtVal = frUtVal;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param frOfcCd
	 */
	public void setFrOfcCd(String frOfcCd) {
		this.frOfcCd = frOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toAmt
	 */
	public void setToAmt(String toAmt) {
		this.toAmt = toAmt;
	}
	
	/**
	 * Column Info
	 * @param reqUpdDt
	 */
	public void setReqUpdDt(String reqUpdDt) {
		this.reqUpdDt = reqUpdDt;
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
	 * @param frCurrCd
	 */
	public void setFrCurrCd(String frCurrCd) {
		this.frCurrCd = frCurrCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param frGenExpnItmNo
	 */
	public void setFrGenExpnItmNo(String frGenExpnItmNo) {
		this.frGenExpnItmNo = frGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param frAmt
	 */
	public void setFrAmt(String frAmt) {
		this.frAmt = frAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frGenExpnCd
	 */
	public void setFrGenExpnCd(String frGenExpnCd) {
		this.frGenExpnCd = frGenExpnCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToGenExpnItmNo(JSPUtil.getParameter(request, "to_gen_expn_itm_no", ""));
		setToCurrCd(JSPUtil.getParameter(request, "to_curr_cd", ""));
		setToUtVal(JSPUtil.getParameter(request, "to_ut_val", ""));
		setFrUtVal(JSPUtil.getParameter(request, "fr_ut_val", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setFrOfcCd(JSPUtil.getParameter(request, "fr_ofc_cd", ""));
		setToAmt(JSPUtil.getParameter(request, "to_amt", ""));
		setReqUpdDt(JSPUtil.getParameter(request, "req_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrCurrCd(JSPUtil.getParameter(request, "fr_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setFrGenExpnItmNo(JSPUtil.getParameter(request, "fr_gen_expn_itm_no", ""));
		setFrAmt(JSPUtil.getParameter(request, "fr_amt", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setFrGenExpnCd(JSPUtil.getParameter(request, "fr_gen_expn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RqsNoVO[]
	 */
	public RqsNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RqsNoVO[]
	 */
	public RqsNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RqsNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_no", length));
			String[] toCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_curr_cd", length));
			String[] toUtVal = (JSPUtil.getParameter(request, prefix	+ "to_ut_val", length));
			String[] frUtVal = (JSPUtil.getParameter(request, prefix	+ "fr_ut_val", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] frOfcCd = (JSPUtil.getParameter(request, prefix	+ "fr_ofc_cd", length));
			String[] toAmt = (JSPUtil.getParameter(request, prefix	+ "to_amt", length));
			String[] reqUpdDt = (JSPUtil.getParameter(request, prefix	+ "req_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frCurrCd = (JSPUtil.getParameter(request, prefix	+ "fr_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] frGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "fr_gen_expn_itm_no", length));
			String[] frAmt = (JSPUtil.getParameter(request, prefix	+ "fr_amt", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] frGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fr_gen_expn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RqsNoVO();
				if (toGenExpnItmNo[i] != null)
					model.setToGenExpnItmNo(toGenExpnItmNo[i]);
				if (toCurrCd[i] != null)
					model.setToCurrCd(toCurrCd[i]);
				if (toUtVal[i] != null)
					model.setToUtVal(toUtVal[i]);
				if (frUtVal[i] != null)
					model.setFrUtVal(frUtVal[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (frOfcCd[i] != null)
					model.setFrOfcCd(frOfcCd[i]);
				if (toAmt[i] != null)
					model.setToAmt(toAmt[i]);
				if (reqUpdDt[i] != null)
					model.setReqUpdDt(reqUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frCurrCd[i] != null)
					model.setFrCurrCd(frCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (frGenExpnItmNo[i] != null)
					model.setFrGenExpnItmNo(frGenExpnItmNo[i]);
				if (frAmt[i] != null)
					model.setFrAmt(frAmt[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (frGenExpnCd[i] != null)
					model.setFrGenExpnCd(frGenExpnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRqsNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RqsNoVO[]
	 */
	public RqsNoVO[] getRqsNoVOs(){
		RqsNoVO[] vos = (RqsNoVO[])models.toArray(new RqsNoVO[models.size()]);
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
		this.toGenExpnItmNo = this.toGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrCd = this.toCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUtVal = this.toUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frUtVal = this.frUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frOfcCd = this.frOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAmt = this.toAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUpdDt = this.reqUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frCurrCd = this.frCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frGenExpnItmNo = this.frGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frAmt = this.frAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frGenExpnCd = this.frGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
