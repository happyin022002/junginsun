/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RdrRgnCdVO.java
*@FileTitle : RdrRgnCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo;

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

public class RdrRgnCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RdrRgnCdVO> models = new ArrayList<RdrRgnCdVO>();
	
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String contiCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdrRgnCd = null;
	/* Column Info */
	private String rdrRgnNm = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RdrRgnCdVO() {}

	public RdrRgnCdVO(String ibflag, String pagerows, String rdrRgnCd, String contiCd, String scontiCd, String rdrRgnNm, String scontiNm) {
		this.scontiNm = scontiNm;
		this.contiCd = contiCd;
		this.ibflag = ibflag;
		this.rdrRgnCd = rdrRgnCd;
		this.rdrRgnNm = rdrRgnNm;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rdr_rgn_cd", getRdrRgnCd());
		this.hashColumns.put("rdr_rgn_nm", getRdrRgnNm());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rdr_rgn_cd", "rdrRgnCd");
		this.hashFields.put("rdr_rgn_nm", "rdrRgnNm");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return rdrRgnCd
	 */
	public String getRdrRgnCd() {
		return this.rdrRgnCd;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getRdrRgnNm() {
		return this.rdrRgnNm;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
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
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param rdrRgnCd
	 */
	public void setRdrRgnCd(String rdrRgnCd) {
		this.rdrRgnCd = rdrRgnCd;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setRdrRgnNm(String rdrRgnNm) {
		this.rdrRgnNm = rdrRgnNm;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
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
		setScontiNm(JSPUtil.getParameter(request, prefix + "sconti_nm", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRdrRgnCd(JSPUtil.getParameter(request, prefix + "rdr_rgn_cd", ""));
		setRdrRgnNm(JSPUtil.getParameter(request, prefix + "rdr_rgn_nm", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RdrRgnCdVO[]
	 */
	public RdrRgnCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RdrRgnCdVO[]
	 */
	public RdrRgnCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RdrRgnCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rdrRgnCd = (JSPUtil.getParameter(request, prefix	+ "rdr_rgn_cd", length));
			String[] rdrRgnNm = (JSPUtil.getParameter(request, prefix	+ "rdr_rgn_nm", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RdrRgnCdVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdrRgnCd[i] != null)
					model.setRdrRgnCd(rdrRgnCd[i]);
				if (rdrRgnNm[i] != null)
					model.setRdrRgnNm(rdrRgnNm[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRdrRgnCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RdrRgnCdVO[]
	 */
	public RdrRgnCdVO[] getRdrRgnCdVOs(){
		RdrRgnCdVO[] vos = (RdrRgnCdVO[])models.toArray(new RdrRgnCdVO[models.size()]);
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
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrRgnCd = this.rdrRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrRgnNm = this.rdrRgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
