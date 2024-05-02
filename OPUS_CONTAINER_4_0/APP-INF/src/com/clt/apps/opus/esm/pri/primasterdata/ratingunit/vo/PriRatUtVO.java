/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriRatUtVO.java
*@FileTitle : PriRatUtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.08.20 송호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.ratingunit.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRatUtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRatUtVO> models = new ArrayList<PriRatUtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ratUtDesc = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String ratUtGrpCd = null;
	/* Column Info */
	private String cntrWdt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String cntrHgt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtUseOnyFlg = null;
	/* Column Info */
	private String fDeltFlg = null;
	/* Column Info */
	private String cntrLen = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriRatUtVO() {}

	public PriRatUtVO(String ibflag, String pagerows, String ratUtCd, String ratUtDesc, String ratUtGrpCd, String cntrSzCd, String cntrLen, String cntrWdt, String cntrHgt, String cntrWgt, String ctrtUseOnyFlg, String creDt, String updDt, String deltFlg, String fDeltFlg) {
		this.updDt = updDt;
		this.cntrWgt = cntrWgt;
		this.deltFlg = deltFlg;
		this.ratUtDesc = ratUtDesc;
		this.cntrSzCd = cntrSzCd;
		this.ratUtGrpCd = ratUtGrpCd;
		this.cntrWdt = cntrWdt;
		this.creDt = creDt;
		this.ratUtCd = ratUtCd;
		this.cntrHgt = cntrHgt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ctrtUseOnyFlg = ctrtUseOnyFlg;
		this.fDeltFlg = fDeltFlg;
		this.cntrLen = cntrLen;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rat_ut_desc", getRatUtDesc());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("rat_ut_grp_cd", getRatUtGrpCd());
		this.hashColumns.put("cntr_wdt", getCntrWdt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cntr_hgt", getCntrHgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_use_ony_flg", getCtrtUseOnyFlg());
		this.hashColumns.put("f_delt_flg", getFDeltFlg());
		this.hashColumns.put("cntr_len", getCntrLen());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rat_ut_desc", "ratUtDesc");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("rat_ut_grp_cd", "ratUtGrpCd");
		this.hashFields.put("cntr_wdt", "cntrWdt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cntr_hgt", "cntrHgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_use_ony_flg", "ctrtUseOnyFlg");
		this.hashFields.put("f_delt_flg", "fDeltFlg");
		this.hashFields.put("cntr_len", "cntrLen");
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
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return ratUtDesc
	 */
	public String getRatUtDesc() {
		return this.ratUtDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtGrpCd
	 */
	public String getRatUtGrpCd() {
		return this.ratUtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWdt
	 */
	public String getCntrWdt() {
		return this.cntrWdt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHgt
	 */
	public String getCntrHgt() {
		return this.cntrHgt;
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
	 * @return ctrtUseOnyFlg
	 */
	public String getCtrtUseOnyFlg() {
		return this.ctrtUseOnyFlg;
	}
	
	/**
	 * Column Info
	 * @return fDeltFlg
	 */
	public String getFDeltFlg() {
		return this.fDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrLen
	 */
	public String getCntrLen() {
		return this.cntrLen;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param ratUtDesc
	 */
	public void setRatUtDesc(String ratUtDesc) {
		this.ratUtDesc = ratUtDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtGrpCd
	 */
	public void setRatUtGrpCd(String ratUtGrpCd) {
		this.ratUtGrpCd = ratUtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWdt
	 */
	public void setCntrWdt(String cntrWdt) {
		this.cntrWdt = cntrWdt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHgt
	 */
	public void setCntrHgt(String cntrHgt) {
		this.cntrHgt = cntrHgt;
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
	 * @param ctrtUseOnyFlg
	 */
	public void setCtrtUseOnyFlg(String ctrtUseOnyFlg) {
		this.ctrtUseOnyFlg = ctrtUseOnyFlg;
	}
	
	/**
	 * Column Info
	 * @param fDeltFlg
	 */
	public void setFDeltFlg(String fDeltFlg) {
		this.fDeltFlg = fDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrLen
	 */
	public void setCntrLen(String cntrLen) {
		this.cntrLen = cntrLen;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setRatUtDesc(JSPUtil.getParameter(request, prefix + "rat_ut_desc", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setRatUtGrpCd(JSPUtil.getParameter(request, prefix + "rat_ut_grp_cd", ""));
		setCntrWdt(JSPUtil.getParameter(request, prefix + "cntr_wdt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCntrHgt(JSPUtil.getParameter(request, prefix + "cntr_hgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtUseOnyFlg(JSPUtil.getParameter(request, prefix + "ctrt_use_ony_flg", ""));
		setFDeltFlg(JSPUtil.getParameter(request, prefix + "f_delt_flg", ""));
		setCntrLen(JSPUtil.getParameter(request, prefix + "cntr_len", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRatUtVO[]
	 */
	public PriRatUtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRatUtVO[]
	 */
	public PriRatUtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRatUtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ratUtDesc = (JSPUtil.getParameter(request, prefix	+ "rat_ut_desc", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] ratUtGrpCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_grp_cd", length));
			String[] cntrWdt = (JSPUtil.getParameter(request, prefix	+ "cntr_wdt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] cntrHgt = (JSPUtil.getParameter(request, prefix	+ "cntr_hgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtUseOnyFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_use_ony_flg", length));
			String[] fDeltFlg = (JSPUtil.getParameter(request, prefix	+ "f_delt_flg", length));
			String[] cntrLen = (JSPUtil.getParameter(request, prefix	+ "cntr_len", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRatUtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ratUtDesc[i] != null)
					model.setRatUtDesc(ratUtDesc[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (ratUtGrpCd[i] != null)
					model.setRatUtGrpCd(ratUtGrpCd[i]);
				if (cntrWdt[i] != null)
					model.setCntrWdt(cntrWdt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (cntrHgt[i] != null)
					model.setCntrHgt(cntrHgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtUseOnyFlg[i] != null)
					model.setCtrtUseOnyFlg(ctrtUseOnyFlg[i]);
				if (fDeltFlg[i] != null)
					model.setFDeltFlg(fDeltFlg[i]);
				if (cntrLen[i] != null)
					model.setCntrLen(cntrLen[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRatUtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRatUtVO[]
	 */
	public PriRatUtVO[] getPriRatUtVOs(){
		PriRatUtVO[] vos = (PriRatUtVO[])models.toArray(new PriRatUtVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtDesc = this.ratUtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtGrpCd = this.ratUtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWdt = this.cntrWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHgt = this.cntrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtUseOnyFlg = this.ctrtUseOnyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeltFlg = this.fDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLen = this.cntrLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
