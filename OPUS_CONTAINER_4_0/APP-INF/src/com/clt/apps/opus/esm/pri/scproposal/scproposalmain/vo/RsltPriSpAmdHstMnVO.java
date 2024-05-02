/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriSpAmdHstMnVO.java
*@FileTitle : RsltPriSpAmdHstMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.18 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpAmdHstMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpAmdHstMnVO> models = new ArrayList<RsltPriSpAmdHstMnVO>();
	
	/* Column Info */
	private String ctrtPtyNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String lgcyIfFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpAmdHstMnVO() {}

	public RsltPriSpAmdHstMnVO(String ibflag, String pagerows, String scNo, String propNo, String amdtSeq, String ctrtPtyNm, String ctrtEffDt, String ctrtExpDt, String lgcyIfFlg) {
		this.ctrtPtyNm = ctrtPtyNm;
		this.ibflag = ibflag;
		this.ctrtEffDt = ctrtEffDt;
		this.lgcyIfFlg = lgcyIfFlg;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.scNo = scNo;
		this.ctrtExpDt = ctrtExpDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("lgcy_if_flg", getLgcyIfFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("lgcy_if_flg", "lgcyIfFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return lgcyIfFlg
	 */
	public String getLgcyIfFlg() {
		return this.lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
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
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param lgcyIfFlg
	 */
	public void setLgcyIfFlg(String lgcyIfFlg) {
		this.lgcyIfFlg = lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setLgcyIfFlg(JSPUtil.getParameter(request, prefix + "lgcy_if_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpAmdHstMnVO[]
	 */
	public RsltPriSpAmdHstMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpAmdHstMnVO[]
	 */
	public RsltPriSpAmdHstMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpAmdHstMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] lgcyIfFlg = (JSPUtil.getParameter(request, prefix	+ "lgcy_if_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpAmdHstMnVO();
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (lgcyIfFlg[i] != null)
					model.setLgcyIfFlg(lgcyIfFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpAmdHstMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpAmdHstMnVO[]
	 */
	public RsltPriSpAmdHstMnVO[] getRsltPriSpAmdHstMnVOs(){
		RsltPriSpAmdHstMnVO[] vos = (RsltPriSpAmdHstMnVO[])models.toArray(new RsltPriSpAmdHstMnVO[models.size()]);
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
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgcyIfFlg = this.lgcyIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
