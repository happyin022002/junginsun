/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRateTpVO.java
*@FileTitle : RsltRateTpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRateTpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRateTpVO> models = new ArrayList<RsltRateTpVO>();
	
	/* Column Info */
	private String notAcptCnt = null;
	/* Column Info */
	private String amdtCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtFlg = null;
	/* Column Info */
	private String rateCnt = null;
	/* Column Info */
	private String acptFlg = null;
	/* Column Info */
	private String acptCnt = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRateTpVO() {}

	public RsltRateTpVO(String ibflag, String pagerows, String cd, String nm, String rateCnt, String amdtCnt, String acptCnt, String notAcptCnt, String amdtFlg, String acptFlg) {
		this.notAcptCnt = notAcptCnt;
		this.amdtCnt = amdtCnt;
		this.ibflag = ibflag;
		this.amdtFlg = amdtFlg;
		this.rateCnt = rateCnt;
		this.acptFlg = acptFlg;
		this.acptCnt = acptCnt;
		this.nm = nm;
		this.cd = cd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("not_acpt_cnt", getNotAcptCnt());
		this.hashColumns.put("amdt_cnt", getAmdtCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_flg", getAmdtFlg());
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("acpt_flg", getAcptFlg());
		this.hashColumns.put("acpt_cnt", getAcptCnt());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("not_acpt_cnt", "notAcptCnt");
		this.hashFields.put("amdt_cnt", "amdtCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_flg", "amdtFlg");
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("acpt_flg", "acptFlg");
		this.hashFields.put("acpt_cnt", "acptCnt");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return notAcptCnt
	 */
	public String getNotAcptCnt() {
		return this.notAcptCnt;
	}
	
	/**
	 * Column Info
	 * @return amdtCnt
	 */
	public String getAmdtCnt() {
		return this.amdtCnt;
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
	 * @return amdtFlg
	 */
	public String getAmdtFlg() {
		return this.amdtFlg;
	}
	
	/**
	 * Column Info
	 * @return rateCnt
	 */
	public String getRateCnt() {
		return this.rateCnt;
	}
	
	/**
	 * Column Info
	 * @return acptFlg
	 */
	public String getAcptFlg() {
		return this.acptFlg;
	}
	
	/**
	 * Column Info
	 * @return acptCnt
	 */
	public String getAcptCnt() {
		return this.acptCnt;
	}
	
	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
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
	 * @param notAcptCnt
	 */
	public void setNotAcptCnt(String notAcptCnt) {
		this.notAcptCnt = notAcptCnt;
	}
	
	/**
	 * Column Info
	 * @param amdtCnt
	 */
	public void setAmdtCnt(String amdtCnt) {
		this.amdtCnt = amdtCnt;
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
	 * @param amdtFlg
	 */
	public void setAmdtFlg(String amdtFlg) {
		this.amdtFlg = amdtFlg;
	}
	
	/**
	 * Column Info
	 * @param rateCnt
	 */
	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}
	
	/**
	 * Column Info
	 * @param acptFlg
	 */
	public void setAcptFlg(String acptFlg) {
		this.acptFlg = acptFlg;
	}
	
	/**
	 * Column Info
	 * @param acptCnt
	 */
	public void setAcptCnt(String acptCnt) {
		this.acptCnt = acptCnt;
	}
	
	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
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
		setNotAcptCnt(JSPUtil.getParameter(request, prefix + "not_acpt_cnt", ""));
		setAmdtCnt(JSPUtil.getParameter(request, prefix + "amdt_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtFlg(JSPUtil.getParameter(request, prefix + "amdt_flg", ""));
		setRateCnt(JSPUtil.getParameter(request, prefix + "rate_cnt", ""));
		setAcptFlg(JSPUtil.getParameter(request, prefix + "acpt_flg", ""));
		setAcptCnt(JSPUtil.getParameter(request, prefix + "acpt_cnt", ""));
		setNm(JSPUtil.getParameter(request, prefix + "nm", ""));
		setCd(JSPUtil.getParameter(request, prefix + "cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRateTpVO[]
	 */
	public RsltRateTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRateTpVO[]
	 */
	public RsltRateTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRateTpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] notAcptCnt = (JSPUtil.getParameter(request, prefix	+ "not_acpt_cnt", length));
			String[] amdtCnt = (JSPUtil.getParameter(request, prefix	+ "amdt_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_flg", length));
			String[] rateCnt = (JSPUtil.getParameter(request, prefix	+ "rate_cnt", length));
			String[] acptFlg = (JSPUtil.getParameter(request, prefix	+ "acpt_flg", length));
			String[] acptCnt = (JSPUtil.getParameter(request, prefix	+ "acpt_cnt", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRateTpVO();
				if (notAcptCnt[i] != null)
					model.setNotAcptCnt(notAcptCnt[i]);
				if (amdtCnt[i] != null)
					model.setAmdtCnt(amdtCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtFlg[i] != null)
					model.setAmdtFlg(amdtFlg[i]);
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (acptFlg[i] != null)
					model.setAcptFlg(acptFlg[i]);
				if (acptCnt[i] != null)
					model.setAcptCnt(acptCnt[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRateTpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRateTpVO[]
	 */
	public RsltRateTpVO[] getRsltRateTpVOs(){
		RsltRateTpVO[] vos = (RsltRateTpVO[])models.toArray(new RsltRateTpVO[models.size()]);
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
		this.notAcptCnt = this.notAcptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtCnt = this.amdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtFlg = this.amdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCnt = this.rateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptFlg = this.acptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptCnt = this.acptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
