/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEDIGrpIDVO.java
*@FileTitle : SearchEDIGrpIDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.01 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDIGrpIDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIGrpIDVO> models = new ArrayList<SearchEDIGrpIDVO>();
	
	/* Column Info */
	private String cgoFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String drfFlg = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String grpNm = null;
	/* Column Info */
	private String grpId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEDIGrpIDVO() {}

	public SearchEDIGrpIDVO(String ibflag, String pagerows, String grpId, String cntCd, String custSeq, String ediId, String grpNm, String cfmFlg, String drfFlg, String cgoFlg) {
		this.cgoFlg = cgoFlg;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.drfFlg = drfFlg;
		this.ediId = ediId;
		this.custSeq = custSeq;
		this.cfmFlg = cfmFlg;
		this.grpNm = grpNm;
		this.grpId = grpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_flg", getCgoFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("drf_flg", getDrfFlg());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("grp_nm", getGrpNm());
		this.hashColumns.put("grp_id", getGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_flg", "cgoFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("drf_flg", "drfFlg");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("grp_nm", "grpNm");
		this.hashFields.put("grp_id", "grpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoFlg
	 */
	public String getCgoFlg() {
		return this.cgoFlg;
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
	 * @return drfFlg
	 */
	public String getDrfFlg() {
		return this.drfFlg;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return grpNm
	 */
	public String getGrpNm() {
		return this.grpNm;
	}
	
	/**
	 * Column Info
	 * @return grpId
	 */
	public String getGrpId() {
		return this.grpId;
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
	 * @param cgoFlg
	 */
	public void setCgoFlg(String cgoFlg) {
		this.cgoFlg = cgoFlg;
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
	 * @param drfFlg
	 */
	public void setDrfFlg(String drfFlg) {
		this.drfFlg = drfFlg;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param grpNm
	 */
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}
	
	/**
	 * Column Info
	 * @param grpId
	 */
	public void setGrpId(String grpId) {
		this.grpId = grpId;
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
		setCgoFlg(JSPUtil.getParameter(request, "cgo_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDrfFlg(JSPUtil.getParameter(request, "drf_flg", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setGrpNm(JSPUtil.getParameter(request, "grp_nm", ""));
		setGrpId(JSPUtil.getParameter(request, "grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIGrpIDVO[]
	 */
	public SearchEDIGrpIDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIGrpIDVO[]
	 */
	public SearchEDIGrpIDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIGrpIDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] drfFlg = (JSPUtil.getParameter(request, prefix	+ "drf_flg", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] grpNm = (JSPUtil.getParameter(request, prefix	+ "grp_nm", length));
			String[] grpId = (JSPUtil.getParameter(request, prefix	+ "grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIGrpIDVO();
				if (cgoFlg[i] != null)
					model.setCgoFlg(cgoFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (drfFlg[i] != null)
					model.setDrfFlg(drfFlg[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (grpNm[i] != null)
					model.setGrpNm(grpNm[i]);
				if (grpId[i] != null)
					model.setGrpId(grpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIGrpIDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIGrpIDVO[]
	 */
	public SearchEDIGrpIDVO[] getSearchEDIGrpIDVOs(){
		SearchEDIGrpIDVO[] vos = (SearchEDIGrpIDVO[])models.toArray(new SearchEDIGrpIDVO[models.size()]);
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
		this.cgoFlg = this.cgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drfFlg = this.drfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpNm = this.grpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpId = this.grpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
