/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSearchUnmatchTypeListVO.java
*@FileTitle : RsltSearchUnmatchTypeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchUnmatchTypeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchUnmatchTypeListVO> models = new ArrayList<RsltSearchUnmatchTypeListVO>();
	
	/* Column Info */
	private String umchTpDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String revUmchClssNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchUnmatchTypeListVO() {}

	public RsltSearchUnmatchTypeListVO(String ibflag, String pagerows, String umchTpCd, String umchTpDesc, String revUmchClssNm) {
		this.umchTpDesc = umchTpDesc;
		this.ibflag = ibflag;
		this.umchTpCd = umchTpCd;
		this.revUmchClssNm = revUmchClssNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("umch_tp_desc", getUmchTpDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rev_umch_clss_nm", getRevUmchClssNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("umch_tp_desc", "umchTpDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rev_umch_clss_nm", "revUmchClssNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return umchTpDesc
	 */
	public String getUmchTpDesc() {
		return this.umchTpDesc;
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
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return revUmchClssNm
	 */
	public String getRevUmchClssNm() {
		return this.revUmchClssNm;
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
	 * @param umchTpDesc
	 */
	public void setUmchTpDesc(String umchTpDesc) {
		this.umchTpDesc = umchTpDesc;
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
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param revUmchClssNm
	 */
	public void setRevUmchClssNm(String revUmchClssNm) {
		this.revUmchClssNm = revUmchClssNm;
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
		setUmchTpDesc(JSPUtil.getParameter(request, "umch_tp_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUmchTpCd(JSPUtil.getParameter(request, "umch_tp_cd", ""));
		setRevUmchClssNm(JSPUtil.getParameter(request, "rev_umch_clss_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchUnmatchTypeListVO[]
	 */
	public RsltSearchUnmatchTypeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchUnmatchTypeListVO[]
	 */
	public RsltSearchUnmatchTypeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchUnmatchTypeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] umchTpDesc = (JSPUtil.getParameter(request, prefix	+ "umch_tp_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] revUmchClssNm = (JSPUtil.getParameter(request, prefix	+ "rev_umch_clss_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchUnmatchTypeListVO();
				if (umchTpDesc[i] != null)
					model.setUmchTpDesc(umchTpDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (revUmchClssNm[i] != null)
					model.setRevUmchClssNm(revUmchClssNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchUnmatchTypeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchUnmatchTypeListVO[]
	 */
	public RsltSearchUnmatchTypeListVO[] getRsltSearchUnmatchTypeListVOs(){
		RsltSearchUnmatchTypeListVO[] vos = (RsltSearchUnmatchTypeListVO[])models.toArray(new RsltSearchUnmatchTypeListVO[models.size()]);
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
		this.umchTpDesc = this.umchTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revUmchClssNm = this.revUmchClssNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
