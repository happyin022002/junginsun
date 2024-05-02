/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltPercentBaseChargeVO.java
*@FileTitle : RsltPercentBaseChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.04.25 서미진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPercentBaseChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPercentBaseChargeVO> models = new ArrayList<RsltPercentBaseChargeVO>();
	
	/* Column Info */
	private String maxPctBseCd = null;
	/* Column Info */
	private String dpSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String priScgPrfUseYn = null;
	/* Column Info */
	private String pctBseCd = null;
	/* Column Info */
	private String pattDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPercentBaseChargeVO() {}

	public RsltPercentBaseChargeVO(String ibflag, String pagerows, String pctBseCd, String pattDesc, String dpSeq, String priScgPrfUseYn, String maxPctBseCd) {
		this.maxPctBseCd = maxPctBseCd;
		this.dpSeq = dpSeq;
		this.ibflag = ibflag;
		this.priScgPrfUseYn = priScgPrfUseYn;
		this.pctBseCd = pctBseCd;
		this.pattDesc = pattDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("max_pct_bse_cd", getMaxPctBseCd());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pri_scg_prf_use_yn", getPriScgPrfUseYn());
		this.hashColumns.put("pct_bse_cd", getPctBseCd());
		this.hashColumns.put("patt_desc", getPattDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("max_pct_bse_cd", "maxPctBseCd");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pri_scg_prf_use_yn", "priScgPrfUseYn");
		this.hashFields.put("pct_bse_cd", "pctBseCd");
		this.hashFields.put("patt_desc", "pattDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return maxPctBseCd
	 */
	public String getMaxPctBseCd() {
		return this.maxPctBseCd;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return priScgPrfUseYn
	 */
	public String getPriScgPrfUseYn() {
		return this.priScgPrfUseYn;
	}
	
	/**
	 * Column Info
	 * @return pctBseCd
	 */
	public String getPctBseCd() {
		return this.pctBseCd;
	}
	
	/**
	 * Column Info
	 * @return pattDesc
	 */
	public String getPattDesc() {
		return this.pattDesc;
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
	 * @param maxPctBseCd
	 */
	public void setMaxPctBseCd(String maxPctBseCd) {
		this.maxPctBseCd = maxPctBseCd;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param priScgPrfUseYn
	 */
	public void setPriScgPrfUseYn(String priScgPrfUseYn) {
		this.priScgPrfUseYn = priScgPrfUseYn;
	}
	
	/**
	 * Column Info
	 * @param pctBseCd
	 */
	public void setPctBseCd(String pctBseCd) {
		this.pctBseCd = pctBseCd;
	}
	
	/**
	 * Column Info
	 * @param pattDesc
	 */
	public void setPattDesc(String pattDesc) {
		this.pattDesc = pattDesc;
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
		setMaxPctBseCd(JSPUtil.getParameter(request, prefix + "max_pct_bse_cd", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPriScgPrfUseYn(JSPUtil.getParameter(request, prefix + "pri_scg_prf_use_yn", ""));
		setPctBseCd(JSPUtil.getParameter(request, prefix + "pct_bse_cd", ""));
		setPattDesc(JSPUtil.getParameter(request, prefix + "patt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPercentBaseChargeVO[]
	 */
	public RsltPercentBaseChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPercentBaseChargeVO[]
	 */
	public RsltPercentBaseChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPercentBaseChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] maxPctBseCd = (JSPUtil.getParameter(request, prefix	+ "max_pct_bse_cd", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] priScgPrfUseYn = (JSPUtil.getParameter(request, prefix	+ "pri_scg_prf_use_yn", length));
			String[] pctBseCd = (JSPUtil.getParameter(request, prefix	+ "pct_bse_cd", length));
			String[] pattDesc = (JSPUtil.getParameter(request, prefix	+ "patt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPercentBaseChargeVO();
				if (maxPctBseCd[i] != null)
					model.setMaxPctBseCd(maxPctBseCd[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (priScgPrfUseYn[i] != null)
					model.setPriScgPrfUseYn(priScgPrfUseYn[i]);
				if (pctBseCd[i] != null)
					model.setPctBseCd(pctBseCd[i]);
				if (pattDesc[i] != null)
					model.setPattDesc(pattDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPercentBaseChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPercentBaseChargeVO[]
	 */
	public RsltPercentBaseChargeVO[] getRsltPercentBaseChargeVOs(){
		RsltPercentBaseChargeVO[] vos = (RsltPercentBaseChargeVO[])models.toArray(new RsltPercentBaseChargeVO[models.size()]);
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
		this.maxPctBseCd = this.maxPctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.priScgPrfUseYn = this.priScgPrfUseYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctBseCd = this.pctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pattDesc = this.pattDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
