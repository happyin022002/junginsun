/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi323AdjustmentLaneVO.java
*@FileTitle : Edi323AdjustmentLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo;

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

public class Edi323AdjustmentLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi323AdjustmentLaneVO> models = new ArrayList<Edi323AdjustmentLaneVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String adjRgstDt = null;
	/* Column Info */
	private String adjSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi323AdjustmentLaneVO() {}

	public Edi323AdjustmentLaneVO(String ibflag, String pagerows, String slanCd, String vslSlanNm, String gubun, String adjRgstDt, String adjSeq) {
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.vslSlanNm = vslSlanNm;
		this.slanCd = slanCd;
		this.adjRgstDt = adjRgstDt;
		this.adjSeq = adjSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("adj_rgst_dt", getAdjRgstDt());
		this.hashColumns.put("adj_seq", getAdjSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("adj_rgst_dt", "adjRgstDt");
		this.hashFields.put("adj_seq", "adjSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return adjRgstDt
	 */
	public String getAdjRgstDt() {
		return this.adjRgstDt;
	}
	
	/**
	 * Column Info
	 * @return adjSeq
	 */
	public String getAdjSeq() {
		return this.adjSeq;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param adjRgstDt
	 */
	public void setAdjRgstDt(String adjRgstDt) {
		this.adjRgstDt = adjRgstDt;
	}
	
	/**
	 * Column Info
	 * @param adjSeq
	 */
	public void setAdjSeq(String adjSeq) {
		this.adjSeq = adjSeq;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setAdjRgstDt(JSPUtil.getParameter(request, prefix + "adj_rgst_dt", ""));
		setAdjSeq(JSPUtil.getParameter(request, prefix + "adj_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi323AdjustmentLaneVO[]
	 */
	public Edi323AdjustmentLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi323AdjustmentLaneVO[]
	 */
	public Edi323AdjustmentLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi323AdjustmentLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] adjRgstDt = (JSPUtil.getParameter(request, prefix	+ "adj_rgst_dt", length));
			String[] adjSeq = (JSPUtil.getParameter(request, prefix	+ "adj_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi323AdjustmentLaneVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (adjRgstDt[i] != null)
					model.setAdjRgstDt(adjRgstDt[i]);
				if (adjSeq[i] != null)
					model.setAdjSeq(adjSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi323AdjustmentLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi323AdjustmentLaneVO[]
	 */
	public Edi323AdjustmentLaneVO[] getEdi323AdjustmentLaneVOs(){
		Edi323AdjustmentLaneVO[] vos = (Edi323AdjustmentLaneVO[])models.toArray(new Edi323AdjustmentLaneVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRgstDt = this.adjRgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjSeq = this.adjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
