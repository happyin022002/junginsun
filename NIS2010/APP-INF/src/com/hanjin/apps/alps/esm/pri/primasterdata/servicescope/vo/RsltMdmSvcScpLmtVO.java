/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltMdmSvcScpLmtVO.java
*@FileTitle : RsltMdmSvcScpLmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.08 김재연 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltMdmSvcScpLmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltMdmSvcScpLmtVO> models = new ArrayList<RsltMdmSvcScpLmtVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcScpIndFlg = null;
	/* Column Info */
	private String rgnNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltMdmSvcScpLmtVO() {}

	public RsltMdmSvcScpLmtVO(String ibflag, String pagerows, String rgnCd, String rgnNm, String svcScpIndFlg) {
		this.rgnCd = rgnCd;
		this.ibflag = ibflag;
		this.svcScpIndFlg = svcScpIndFlg;
		this.rgnNm = rgnNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_scp_ind_flg", getSvcScpIndFlg());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_scp_ind_flg", "svcScpIndFlg");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
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
	 * @return svcScpIndFlg
	 */
	public String getSvcScpIndFlg() {
		return this.svcScpIndFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnNm
	 */
	public String getRgnNm() {
		return this.rgnNm;
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
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
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
	 * @param svcScpIndFlg
	 */
	public void setSvcScpIndFlg(String svcScpIndFlg) {
		this.svcScpIndFlg = svcScpIndFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnNm
	 */
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
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
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSvcScpIndFlg(JSPUtil.getParameter(request, "svc_scp_ind_flg", ""));
		setRgnNm(JSPUtil.getParameter(request, "rgn_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltMdmSvcScpLmtVO[]
	 */
	public RsltMdmSvcScpLmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltMdmSvcScpLmtVO[]
	 */
	public RsltMdmSvcScpLmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltMdmSvcScpLmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcScpIndFlg = (JSPUtil.getParameter(request, prefix	+ "svc_scp_ind_flg", length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltMdmSvcScpLmtVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcScpIndFlg[i] != null)
					model.setSvcScpIndFlg(svcScpIndFlg[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltMdmSvcScpLmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltMdmSvcScpLmtVO[]
	 */
	public RsltMdmSvcScpLmtVO[] getRsltMdmSvcScpLmtVOs(){
		RsltMdmSvcScpLmtVO[] vos = (RsltMdmSvcScpLmtVO[])models.toArray(new RsltMdmSvcScpLmtVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpIndFlg = this.svcScpIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
