/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TmnlVvdLfdVO.java
*@FileTitle : TmnlVvdLfdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class TmnlVvdLfdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmnlVvdLfdVO> models = new ArrayList<TmnlVvdLfdVO>();
	
	/* Column Info */
	private String tmlVslNm = null;
	/* Column Info */
	private String tmlVpsEtbDt = null;
	/* Column Info */
	private String tmlVpsEtaDt = null;
	/* Column Info */
	private String tmlVpsEtdDt = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String tmlClptIndSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sTmlYdCd = null;
	/* Column Info */
	private String tmlVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String tmlLanCd = null;
	/* Column Info */
	private String tmlYdCd = null;
	/* Column Info */
	private String tmlOpr = null;
	/* Column Info */
	private String sFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TmnlVvdLfdVO() {}

	public TmnlVvdLfdVO(String ibflag, String pagerows, String tmlYdCd, String tmlLanCd, String tmlVvd, String tmlVslNm, String tmlOpr, String tmlVpsEtaDt, String tmlVpsEtbDt, String tmlVpsEtdDt, String tmlClptIndSeq, String sTmlYdCd, String sFmDt, String sToDt, String sVvd) {
		this.tmlVslNm = tmlVslNm;
		this.tmlVpsEtbDt = tmlVpsEtbDt;
		this.tmlVpsEtaDt = tmlVpsEtaDt;
		this.tmlVpsEtdDt = tmlVpsEtdDt;
		this.sVvd = sVvd;
		this.tmlClptIndSeq = tmlClptIndSeq;
		this.pagerows = pagerows;
		this.sTmlYdCd = sTmlYdCd;
		this.tmlVvd = tmlVvd;
		this.ibflag = ibflag;
		this.sToDt = sToDt;
		this.tmlLanCd = tmlLanCd;
		this.tmlYdCd = tmlYdCd;
		this.tmlOpr = tmlOpr;
		this.sFmDt = sFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tml_vsl_nm", getTmlVslNm());
		this.hashColumns.put("tml_vps_etb_dt", getTmlVpsEtbDt());
		this.hashColumns.put("tml_vps_eta_dt", getTmlVpsEtaDt());
		this.hashColumns.put("tml_vps_etd_dt", getTmlVpsEtdDt());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("tml_clpt_ind_seq", getTmlClptIndSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_tml_yd_cd", getSTmlYdCd());
		this.hashColumns.put("tml_vvd", getTmlVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("tml_lan_cd", getTmlLanCd());
		this.hashColumns.put("tml_yd_cd", getTmlYdCd());
		this.hashColumns.put("tml_opr", getTmlOpr());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tml_vsl_nm", "tmlVslNm");
		this.hashFields.put("tml_vps_etb_dt", "tmlVpsEtbDt");
		this.hashFields.put("tml_vps_eta_dt", "tmlVpsEtaDt");
		this.hashFields.put("tml_vps_etd_dt", "tmlVpsEtdDt");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("tml_clpt_ind_seq", "tmlClptIndSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_tml_yd_cd", "sTmlYdCd");
		this.hashFields.put("tml_vvd", "tmlVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("tml_lan_cd", "tmlLanCd");
		this.hashFields.put("tml_yd_cd", "tmlYdCd");
		this.hashFields.put("tml_opr", "tmlOpr");
		this.hashFields.put("s_fm_dt", "sFmDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmlVslNm
	 */
	public String getTmlVslNm() {
		return this.tmlVslNm;
	}
	
	/**
	 * Column Info
	 * @return tmlVpsEtbDt
	 */
	public String getTmlVpsEtbDt() {
		return this.tmlVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return tmlVpsEtaDt
	 */
	public String getTmlVpsEtaDt() {
		return this.tmlVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return tmlVpsEtdDt
	 */
	public String getTmlVpsEtdDt() {
		return this.tmlVpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return tmlClptIndSeq
	 */
	public String getTmlClptIndSeq() {
		return this.tmlClptIndSeq;
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
	 * @return sTmlYdCd
	 */
	public String getSTmlYdCd() {
		return this.sTmlYdCd;
	}
	
	/**
	 * Column Info
	 * @return tmlVvd
	 */
	public String getTmlVvd() {
		return this.tmlVvd;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return tmlLanCd
	 */
	public String getTmlLanCd() {
		return this.tmlLanCd;
	}
	
	/**
	 * Column Info
	 * @return tmlYdCd
	 */
	public String getTmlYdCd() {
		return this.tmlYdCd;
	}
	
	/**
	 * Column Info
	 * @return tmlOpr
	 */
	public String getTmlOpr() {
		return this.tmlOpr;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	

	/**
	 * Column Info
	 * @param tmlVslNm
	 */
	public void setTmlVslNm(String tmlVslNm) {
		this.tmlVslNm = tmlVslNm;
	}
	
	/**
	 * Column Info
	 * @param tmlVpsEtbDt
	 */
	public void setTmlVpsEtbDt(String tmlVpsEtbDt) {
		this.tmlVpsEtbDt = tmlVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param tmlVpsEtaDt
	 */
	public void setTmlVpsEtaDt(String tmlVpsEtaDt) {
		this.tmlVpsEtaDt = tmlVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param tmlVpsEtdDt
	 */
	public void setTmlVpsEtdDt(String tmlVpsEtdDt) {
		this.tmlVpsEtdDt = tmlVpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param tmlClptIndSeq
	 */
	public void setTmlClptIndSeq(String tmlClptIndSeq) {
		this.tmlClptIndSeq = tmlClptIndSeq;
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
	 * @param sTmlYdCd
	 */
	public void setSTmlYdCd(String sTmlYdCd) {
		this.sTmlYdCd = sTmlYdCd;
	}
	
	/**
	 * Column Info
	 * @param tmlVvd
	 */
	public void setTmlVvd(String tmlVvd) {
		this.tmlVvd = tmlVvd;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param tmlLanCd
	 */
	public void setTmlLanCd(String tmlLanCd) {
		this.tmlLanCd = tmlLanCd;
	}
	
	/**
	 * Column Info
	 * @param tmlYdCd
	 */
	public void setTmlYdCd(String tmlYdCd) {
		this.tmlYdCd = tmlYdCd;
	}
	
	/**
	 * Column Info
	 * @param tmlOpr
	 */
	public void setTmlOpr(String tmlOpr) {
		this.tmlOpr = tmlOpr;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
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
		setTmlVslNm(JSPUtil.getParameter(request, prefix + "tml_vsl_nm", ""));
		setTmlVpsEtbDt(JSPUtil.getParameter(request, prefix + "tml_vps_etb_dt", ""));
		setTmlVpsEtaDt(JSPUtil.getParameter(request, prefix + "tml_vps_eta_dt", ""));
		setTmlVpsEtdDt(JSPUtil.getParameter(request, prefix + "tml_vps_etd_dt", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setTmlClptIndSeq(JSPUtil.getParameter(request, prefix + "tml_clpt_ind_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSTmlYdCd(JSPUtil.getParameter(request, prefix + "s_tml_yd_cd", ""));
		setTmlVvd(JSPUtil.getParameter(request, prefix + "tml_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setTmlLanCd(JSPUtil.getParameter(request, prefix + "tml_lan_cd", ""));
		setTmlYdCd(JSPUtil.getParameter(request, prefix + "tml_yd_cd", ""));
		setTmlOpr(JSPUtil.getParameter(request, prefix + "tml_opr", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmnlVvdLfdVO[]
	 */
	public TmnlVvdLfdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmnlVvdLfdVO[]
	 */
	public TmnlVvdLfdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmnlVvdLfdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmlVslNm = (JSPUtil.getParameter(request, prefix	+ "tml_vsl_nm", length));
			String[] tmlVpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "tml_vps_etb_dt", length));
			String[] tmlVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "tml_vps_eta_dt", length));
			String[] tmlVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "tml_vps_etd_dt", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] tmlClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "tml_clpt_ind_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sTmlYdCd = (JSPUtil.getParameter(request, prefix	+ "s_tml_yd_cd", length));
			String[] tmlVvd = (JSPUtil.getParameter(request, prefix	+ "tml_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] tmlLanCd = (JSPUtil.getParameter(request, prefix	+ "tml_lan_cd", length));
			String[] tmlYdCd = (JSPUtil.getParameter(request, prefix	+ "tml_yd_cd", length));
			String[] tmlOpr = (JSPUtil.getParameter(request, prefix	+ "tml_opr", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmnlVvdLfdVO();
				if (tmlVslNm[i] != null)
					model.setTmlVslNm(tmlVslNm[i]);
				if (tmlVpsEtbDt[i] != null)
					model.setTmlVpsEtbDt(tmlVpsEtbDt[i]);
				if (tmlVpsEtaDt[i] != null)
					model.setTmlVpsEtaDt(tmlVpsEtaDt[i]);
				if (tmlVpsEtdDt[i] != null)
					model.setTmlVpsEtdDt(tmlVpsEtdDt[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (tmlClptIndSeq[i] != null)
					model.setTmlClptIndSeq(tmlClptIndSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sTmlYdCd[i] != null)
					model.setSTmlYdCd(sTmlYdCd[i]);
				if (tmlVvd[i] != null)
					model.setTmlVvd(tmlVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (tmlLanCd[i] != null)
					model.setTmlLanCd(tmlLanCd[i]);
				if (tmlYdCd[i] != null)
					model.setTmlYdCd(tmlYdCd[i]);
				if (tmlOpr[i] != null)
					model.setTmlOpr(tmlOpr[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmnlVvdLfdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmnlVvdLfdVO[]
	 */
	public TmnlVvdLfdVO[] getTmnlVvdLfdVOs(){
		TmnlVvdLfdVO[] vos = (TmnlVvdLfdVO[])models.toArray(new TmnlVvdLfdVO[models.size()]);
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
		this.tmlVslNm = this.tmlVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVpsEtbDt = this.tmlVpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVpsEtaDt = this.tmlVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVpsEtdDt = this.tmlVpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlClptIndSeq = this.tmlClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTmlYdCd = this.sTmlYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVvd = this.tmlVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlLanCd = this.tmlLanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlYdCd = this.tmlYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlOpr = this.tmlOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
