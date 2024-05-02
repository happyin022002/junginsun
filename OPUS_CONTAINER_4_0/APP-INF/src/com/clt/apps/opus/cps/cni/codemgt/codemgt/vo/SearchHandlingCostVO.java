/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchHandlingCostVO.java
*@FileTitle : SearchHandlingCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.12 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHandlingCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHandlingCostVO> models = new ArrayList<SearchHandlingCostVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lablPtyTmBarDt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String dwClmStsNm = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String dwClmAttDefTpNm = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dwClmTpNm = null;
	/* Column Info */
	private String hdlrUsrNm = null;
	/* Column Info */
	private String dwCoNm = null;
	/* Column Info */
	private String rHandler = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHandlingCostVO() {}

	public SearchHandlingCostVO(String ibflag, String pagerows, String dwClmNo, String dwClmTpNm, String dwCoNm, String vslEngNm, String inciOccrDt, String creOfcCd, String rHandler, String hdlrUsrNm, String tmBarDt, String csClzDt, String dwClmStsNm, String updDt, String dwClmAttDefTpNm, String lablPtyTmBarDt, String hdlrUsrId) {
		this.updDt = updDt;
		this.lablPtyTmBarDt = lablPtyTmBarDt;
		this.csClzDt = csClzDt;
		this.dwClmStsNm = dwClmStsNm;
		this.inciOccrDt = inciOccrDt;
		this.dwClmAttDefTpNm = dwClmAttDefTpNm;
		this.hdlrUsrId = hdlrUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tmBarDt = tmBarDt;
		this.vslEngNm = vslEngNm;
		this.creOfcCd = creOfcCd;
		this.dwClmTpNm = dwClmTpNm;
		this.hdlrUsrNm = hdlrUsrNm;
		this.dwCoNm = dwCoNm;
		this.rHandler = rHandler;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("labl_pty_tm_bar_dt", getLablPtyTmBarDt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("dw_clm_sts_nm", getDwClmStsNm());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("dw_clm_att_def_tp_nm", getDwClmAttDefTpNm());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dw_clm_tp_nm", getDwClmTpNm());
		this.hashColumns.put("hdlr_usr_nm", getHdlrUsrNm());
		this.hashColumns.put("dw_co_nm", getDwCoNm());
		this.hashColumns.put("r_handler", getRHandler());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("labl_pty_tm_bar_dt", "lablPtyTmBarDt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("dw_clm_sts_nm", "dwClmStsNm");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("dw_clm_att_def_tp_nm", "dwClmAttDefTpNm");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dw_clm_tp_nm", "dwClmTpNm");
		this.hashFields.put("hdlr_usr_nm", "hdlrUsrNm");
		this.hashFields.put("dw_co_nm", "dwCoNm");
		this.hashFields.put("r_handler", "rHandler");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyTmBarDt
	 */
	public String getLablPtyTmBarDt() {
		return this.lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsNm
	 */
	public String getDwClmStsNm() {
		return this.dwClmStsNm;
	}
	
	/**
	 * Column Info
	 * @return inciOccrDt
	 */
	public String getInciOccrDt() {
		return this.inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmAttDefTpNm
	 */
	public String getDwClmAttDefTpNm() {
		return this.dwClmAttDefTpNm;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @return tmBarDt
	 */
	public String getTmBarDt() {
		return this.tmBarDt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmTpNm
	 */
	public String getDwClmTpNm() {
		return this.dwClmTpNm;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrNm
	 */
	public String getHdlrUsrNm() {
		return this.hdlrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dwCoNm
	 */
	public String getDwCoNm() {
		return this.dwCoNm;
	}
	
	/**
	 * Column Info
	 * @return rHandler
	 */
	public String getRHandler() {
		return this.rHandler;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyTmBarDt
	 */
	public void setLablPtyTmBarDt(String lablPtyTmBarDt) {
		this.lablPtyTmBarDt = lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsNm
	 */
	public void setDwClmStsNm(String dwClmStsNm) {
		this.dwClmStsNm = dwClmStsNm;
	}
	
	/**
	 * Column Info
	 * @param inciOccrDt
	 */
	public void setInciOccrDt(String inciOccrDt) {
		this.inciOccrDt = inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmAttDefTpNm
	 */
	public void setDwClmAttDefTpNm(String dwClmAttDefTpNm) {
		this.dwClmAttDefTpNm = dwClmAttDefTpNm;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
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
	 * @param tmBarDt
	 */
	public void setTmBarDt(String tmBarDt) {
		this.tmBarDt = tmBarDt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmTpNm
	 */
	public void setDwClmTpNm(String dwClmTpNm) {
		this.dwClmTpNm = dwClmTpNm;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrNm
	 */
	public void setHdlrUsrNm(String hdlrUsrNm) {
		this.hdlrUsrNm = hdlrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dwCoNm
	 */
	public void setDwCoNm(String dwCoNm) {
		this.dwCoNm = dwCoNm;
	}
	
	/**
	 * Column Info
	 * @param rHandler
	 */
	public void setRHandler(String rHandler) {
		this.rHandler = rHandler;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLablPtyTmBarDt(JSPUtil.getParameter(request, prefix + "labl_pty_tm_bar_dt", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setDwClmStsNm(JSPUtil.getParameter(request, prefix + "dw_clm_sts_nm", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setDwClmAttDefTpNm(JSPUtil.getParameter(request, prefix + "dw_clm_att_def_tp_nm", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmBarDt(JSPUtil.getParameter(request, prefix + "tm_bar_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDwClmTpNm(JSPUtil.getParameter(request, prefix + "dw_clm_tp_nm", ""));
		setHdlrUsrNm(JSPUtil.getParameter(request, prefix + "hdlr_usr_nm", ""));
		setDwCoNm(JSPUtil.getParameter(request, prefix + "dw_co_nm", ""));
		setRHandler(JSPUtil.getParameter(request, prefix + "r_handler", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHandlingCostVO[]
	 */
	public SearchHandlingCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHandlingCostVO[]
	 */
	public SearchHandlingCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHandlingCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lablPtyTmBarDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_tm_bar_dt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] dwClmStsNm = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_nm", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] dwClmAttDefTpNm = (JSPUtil.getParameter(request, prefix	+ "dw_clm_att_def_tp_nm", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dwClmTpNm = (JSPUtil.getParameter(request, prefix	+ "dw_clm_tp_nm", length));
			String[] hdlrUsrNm = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_nm", length));
			String[] dwCoNm = (JSPUtil.getParameter(request, prefix	+ "dw_co_nm", length));
			String[] rHandler = (JSPUtil.getParameter(request, prefix	+ "r_handler", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHandlingCostVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lablPtyTmBarDt[i] != null)
					model.setLablPtyTmBarDt(lablPtyTmBarDt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (dwClmStsNm[i] != null)
					model.setDwClmStsNm(dwClmStsNm[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (dwClmAttDefTpNm[i] != null)
					model.setDwClmAttDefTpNm(dwClmAttDefTpNm[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dwClmTpNm[i] != null)
					model.setDwClmTpNm(dwClmTpNm[i]);
				if (hdlrUsrNm[i] != null)
					model.setHdlrUsrNm(hdlrUsrNm[i]);
				if (dwCoNm[i] != null)
					model.setDwCoNm(dwCoNm[i]);
				if (rHandler[i] != null)
					model.setRHandler(rHandler[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHandlingCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHandlingCostVO[]
	 */
	public SearchHandlingCostVO[] getSearchHandlingCostVOs(){
		SearchHandlingCostVO[] vos = (SearchHandlingCostVO[])models.toArray(new SearchHandlingCostVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyTmBarDt = this.lablPtyTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsNm = this.dwClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmAttDefTpNm = this.dwClmAttDefTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmTpNm = this.dwClmTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrNm = this.hdlrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwCoNm = this.dwCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rHandler = this.rHandler .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
