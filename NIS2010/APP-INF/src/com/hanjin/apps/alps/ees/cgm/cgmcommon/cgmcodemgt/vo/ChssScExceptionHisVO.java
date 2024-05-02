/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChssScExceptionHisVO.java
*@FileTitle : ChssScExceptionHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChssScExceptionHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChssScExceptionHisVO> models = new ArrayList<ChssScExceptionHisVO>();
	
	/* Column Info */
	private String acctDt = null;
	/* Column Info */
	private String reqOfcCd = null;
	/* Column Info */
	private String chssExptVerStsDesc = null;
	/* Column Info */
	private String liveDt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String reqUsrNm = null;
	/* Column Info */
	private String reqDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctOfcCd = null;
	/* Column Info */
	private String acctUsrNm = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String delDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChssScExceptionHisVO() {}

	public ChssScExceptionHisVO(String ibflag, String pagerows, String scNo, String propNo, String scExptVerSeq, String chssExptVerStsDesc, String reqOfcCd, String reqUsrNm, String reqDt, String acctOfcCd, String acctUsrNm, String acctDt, String liveDt, String delDt) {
		this.acctDt = acctDt;
		this.reqOfcCd = reqOfcCd;
		this.chssExptVerStsDesc = chssExptVerStsDesc;
		this.liveDt = liveDt;
		this.scExptVerSeq = scExptVerSeq;
		this.reqUsrNm = reqUsrNm;
		this.reqDt = reqDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.acctOfcCd = acctOfcCd;
		this.acctUsrNm = acctUsrNm;
		this.propNo = propNo;
		this.scNo = scNo;
		this.delDt = delDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_dt", getAcctDt());
		this.hashColumns.put("req_ofc_cd", getReqOfcCd());
		this.hashColumns.put("chss_expt_ver_sts_desc", getChssExptVerStsDesc());
		this.hashColumns.put("live_dt", getLiveDt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("req_usr_nm", getReqUsrNm());
		this.hashColumns.put("req_dt", getReqDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_ofc_cd", getAcctOfcCd());
		this.hashColumns.put("acct_usr_nm", getAcctUsrNm());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("del_dt", getDelDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_dt", "acctDt");
		this.hashFields.put("req_ofc_cd", "reqOfcCd");
		this.hashFields.put("chss_expt_ver_sts_desc", "chssExptVerStsDesc");
		this.hashFields.put("live_dt", "liveDt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("req_usr_nm", "reqUsrNm");
		this.hashFields.put("req_dt", "reqDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_ofc_cd", "acctOfcCd");
		this.hashFields.put("acct_usr_nm", "acctUsrNm");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("del_dt", "delDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctDt
	 */
	public String getAcctDt() {
		return this.acctDt;
	}
	
	/**
	 * Column Info
	 * @return reqOfcCd
	 */
	public String getReqOfcCd() {
		return this.reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssExptVerStsDesc
	 */
	public String getChssExptVerStsDesc() {
		return this.chssExptVerStsDesc;
	}
	
	/**
	 * Column Info
	 * @return liveDt
	 */
	public String getLiveDt() {
		return this.liveDt;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return reqUsrNm
	 */
	public String getReqUsrNm() {
		return this.reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @return reqDt
	 */
	public String getReqDt() {
		return this.reqDt;
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
	 * @return acctOfcCd
	 */
	public String getAcctOfcCd() {
		return this.acctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acctUsrNm
	 */
	public String getAcctUsrNm() {
		return this.acctUsrNm;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return delDt
	 */
	public String getDelDt() {
		return this.delDt;
	}
	

	/**
	 * Column Info
	 * @param acctDt
	 */
	public void setAcctDt(String acctDt) {
		this.acctDt = acctDt;
	}
	
	/**
	 * Column Info
	 * @param reqOfcCd
	 */
	public void setReqOfcCd(String reqOfcCd) {
		this.reqOfcCd = reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssExptVerStsDesc
	 */
	public void setChssExptVerStsDesc(String chssExptVerStsDesc) {
		this.chssExptVerStsDesc = chssExptVerStsDesc;
	}
	
	/**
	 * Column Info
	 * @param liveDt
	 */
	public void setLiveDt(String liveDt) {
		this.liveDt = liveDt;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param reqUsrNm
	 */
	public void setReqUsrNm(String reqUsrNm) {
		this.reqUsrNm = reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @param reqDt
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
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
	 * @param acctOfcCd
	 */
	public void setAcctOfcCd(String acctOfcCd) {
		this.acctOfcCd = acctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acctUsrNm
	 */
	public void setAcctUsrNm(String acctUsrNm) {
		this.acctUsrNm = acctUsrNm;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
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
		setAcctDt(JSPUtil.getParameter(request, prefix + "acct_dt", ""));
		setReqOfcCd(JSPUtil.getParameter(request, prefix + "req_ofc_cd", ""));
		setChssExptVerStsDesc(JSPUtil.getParameter(request, prefix + "chss_expt_ver_sts_desc", ""));
		setLiveDt(JSPUtil.getParameter(request, prefix + "live_dt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, prefix + "sc_expt_ver_seq", ""));
		setReqUsrNm(JSPUtil.getParameter(request, prefix + "req_usr_nm", ""));
		setReqDt(JSPUtil.getParameter(request, prefix + "req_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctOfcCd(JSPUtil.getParameter(request, prefix + "acct_ofc_cd", ""));
		setAcctUsrNm(JSPUtil.getParameter(request, prefix + "acct_usr_nm", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setDelDt(JSPUtil.getParameter(request, prefix + "del_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChssScExceptionHisVO[]
	 */
	public ChssScExceptionHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChssScExceptionHisVO[]
	 */
	public ChssScExceptionHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChssScExceptionHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctDt = (JSPUtil.getParameter(request, prefix	+ "acct_dt", length));
			String[] reqOfcCd = (JSPUtil.getParameter(request, prefix	+ "req_ofc_cd", length));
			String[] chssExptVerStsDesc = (JSPUtil.getParameter(request, prefix	+ "chss_expt_ver_sts_desc", length));
			String[] liveDt = (JSPUtil.getParameter(request, prefix	+ "live_dt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] reqUsrNm = (JSPUtil.getParameter(request, prefix	+ "req_usr_nm", length));
			String[] reqDt = (JSPUtil.getParameter(request, prefix	+ "req_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctOfcCd = (JSPUtil.getParameter(request, prefix	+ "acct_ofc_cd", length));
			String[] acctUsrNm = (JSPUtil.getParameter(request, prefix	+ "acct_usr_nm", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChssScExceptionHisVO();
				if (acctDt[i] != null)
					model.setAcctDt(acctDt[i]);
				if (reqOfcCd[i] != null)
					model.setReqOfcCd(reqOfcCd[i]);
				if (chssExptVerStsDesc[i] != null)
					model.setChssExptVerStsDesc(chssExptVerStsDesc[i]);
				if (liveDt[i] != null)
					model.setLiveDt(liveDt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (reqUsrNm[i] != null)
					model.setReqUsrNm(reqUsrNm[i]);
				if (reqDt[i] != null)
					model.setReqDt(reqDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctOfcCd[i] != null)
					model.setAcctOfcCd(acctOfcCd[i]);
				if (acctUsrNm[i] != null)
					model.setAcctUsrNm(acctUsrNm[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChssScExceptionHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChssScExceptionHisVO[]
	 */
	public ChssScExceptionHisVO[] getChssScExceptionHisVOs(){
		ChssScExceptionHisVO[] vos = (ChssScExceptionHisVO[])models.toArray(new ChssScExceptionHisVO[models.size()]);
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
		this.acctDt = this.acctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfcCd = this.reqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssExptVerStsDesc = this.chssExptVerStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liveDt = this.liveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrNm = this.reqUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqDt = this.reqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctOfcCd = this.acctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctUsrNm = this.acctUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
