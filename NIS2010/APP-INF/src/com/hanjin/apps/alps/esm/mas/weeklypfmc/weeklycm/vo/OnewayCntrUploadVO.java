/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnewayCntrUploadVO.java
*@FileTitle : OnewayCntrUploadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.03.05 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OnewayCntrUploadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OnewayCntrUploadVO> models = new ArrayList<OnewayCntrUploadVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String cntrNoOrg = null;
	/* Column Info */
	private String offhYdCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fFmyearmonth = null;
	/* Column Info */
	private String offhYdCdOrg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fToyearmonth = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fCntrno = null;
	/* Column Info */
	private String termCd = null;
	/* Column Info */
	private String fBkgno = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String onhYdCdOrg = null;
	/* Column Info */
	private String bkgNoOrg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OnewayCntrUploadVO() {}

	public OnewayCntrUploadVO(String ibflag, String pagerows, String cntrNo, String bkgNo, String tpszCd, String termCd, String mvmtCd, String onhDt, String onhYdCd, String offhDt, String offhYdCd, String creUsrId, String creDt, String updUsrId, String updDt, String bkgNoOrg, String cntrNoOrg, String onhYdCdOrg, String offhYdCdOrg, String fFmyearmonth, String fToyearmonth, String fBkgno, String fCntrno) {
		this.updDt = updDt;
		this.onhYdCd = onhYdCd;
		this.cntrNoOrg = cntrNoOrg;
		this.offhYdCd = offhYdCd;
		this.creDt = creDt;
		this.mvmtCd = mvmtCd;
		this.tpszCd = tpszCd;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.fFmyearmonth = fFmyearmonth;
		this.offhYdCdOrg = offhYdCdOrg;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.fToyearmonth = fToyearmonth;
		this.cntrNo = cntrNo;
		this.fCntrno = fCntrno;
		this.termCd = termCd;
		this.fBkgno = fBkgno;
		this.offhDt = offhDt;
		this.onhYdCdOrg = onhYdCdOrg;
		this.bkgNoOrg = bkgNoOrg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("cntr_no_org", getCntrNoOrg());
		this.hashColumns.put("offh_yd_cd", getOffhYdCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_fmyearmonth", getFFmyearmonth());
		this.hashColumns.put("offh_yd_cd_org", getOffhYdCdOrg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f_toyearmonth", getFToyearmonth());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("f_cntrno", getFCntrno());
		this.hashColumns.put("term_cd", getTermCd());
		this.hashColumns.put("f_bkgno", getFBkgno());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("onh_yd_cd_org", getOnhYdCdOrg());
		this.hashColumns.put("bkg_no_org", getBkgNoOrg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("cntr_no_org", "cntrNoOrg");
		this.hashFields.put("offh_yd_cd", "offhYdCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_fmyearmonth", "fFmyearmonth");
		this.hashFields.put("offh_yd_cd_org", "offhYdCdOrg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f_toyearmonth", "fToyearmonth");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("f_cntrno", "fCntrno");
		this.hashFields.put("term_cd", "termCd");
		this.hashFields.put("f_bkgno", "fBkgno");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("onh_yd_cd_org", "onhYdCdOrg");
		this.hashFields.put("bkg_no_org", "bkgNoOrg");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNoOrg
	 */
	public String getCntrNoOrg() {
		return this.cntrNoOrg;
	}
	
	/**
	 * Column Info
	 * @return offhYdCd
	 */
	public String getOffhYdCd() {
		return this.offhYdCd;
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
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return fFmyearmonth
	 */
	public String getFFmyearmonth() {
		return this.fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @return offhYdCdOrg
	 */
	public String getOffhYdCdOrg() {
		return this.offhYdCdOrg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fToyearmonth
	 */
	public String getFToyearmonth() {
		return this.fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return fCntrno
	 */
	public String getFCntrno() {
		return this.fCntrno;
	}
	
	/**
	 * Column Info
	 * @return termCd
	 */
	public String getTermCd() {
		return this.termCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgno
	 */
	public String getFBkgno() {
		return this.fBkgno;
	}
	
	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}
	
	/**
	 * Column Info
	 * @return onhYdCdOrg
	 */
	public String getOnhYdCdOrg() {
		return this.onhYdCdOrg;
	}
	
	/**
	 * Column Info
	 * @return bkgNoOrg
	 */
	public String getBkgNoOrg() {
		return this.bkgNoOrg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNoOrg
	 */
	public void setCntrNoOrg(String cntrNoOrg) {
		this.cntrNoOrg = cntrNoOrg;
	}
	
	/**
	 * Column Info
	 * @param offhYdCd
	 */
	public void setOffhYdCd(String offhYdCd) {
		this.offhYdCd = offhYdCd;
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
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param fFmyearmonth
	 */
	public void setFFmyearmonth(String fFmyearmonth) {
		this.fFmyearmonth = fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @param offhYdCdOrg
	 */
	public void setOffhYdCdOrg(String offhYdCdOrg) {
		this.offhYdCdOrg = offhYdCdOrg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fToyearmonth
	 */
	public void setFToyearmonth(String fToyearmonth) {
		this.fToyearmonth = fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param fCntrno
	 */
	public void setFCntrno(String fCntrno) {
		this.fCntrno = fCntrno;
	}
	
	/**
	 * Column Info
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgno
	 */
	public void setFBkgno(String fBkgno) {
		this.fBkgno = fBkgno;
	}
	
	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}
	
	/**
	 * Column Info
	 * @param onhYdCdOrg
	 */
	public void setOnhYdCdOrg(String onhYdCdOrg) {
		this.onhYdCdOrg = onhYdCdOrg;
	}
	
	/**
	 * Column Info
	 * @param bkgNoOrg
	 */
	public void setBkgNoOrg(String bkgNoOrg) {
		this.bkgNoOrg = bkgNoOrg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setOnhYdCd(JSPUtil.getParameter(request, prefix + "onh_yd_cd", ""));
		setCntrNoOrg(JSPUtil.getParameter(request, prefix + "cntr_no_org", ""));
		setOffhYdCd(JSPUtil.getParameter(request, prefix + "offh_yd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFFmyearmonth(JSPUtil.getParameter(request, prefix + "f_fmyearmonth", ""));
		setOffhYdCdOrg(JSPUtil.getParameter(request, prefix + "offh_yd_cd_org", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFToyearmonth(JSPUtil.getParameter(request, prefix + "f_toyearmonth", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFCntrno(JSPUtil.getParameter(request, prefix + "f_cntrno", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
		setFBkgno(JSPUtil.getParameter(request, prefix + "f_bkgno", ""));
		setOffhDt(JSPUtil.getParameter(request, prefix + "offh_dt", ""));
		setOnhYdCdOrg(JSPUtil.getParameter(request, prefix + "onh_yd_cd_org", ""));
		setBkgNoOrg(JSPUtil.getParameter(request, prefix + "bkg_no_org", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OnewayCntrUploadVO[]
	 */
	public OnewayCntrUploadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OnewayCntrUploadVO[]
	 */
	public OnewayCntrUploadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OnewayCntrUploadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] cntrNoOrg = (JSPUtil.getParameter(request, prefix	+ "cntr_no_org", length));
			String[] offhYdCd = (JSPUtil.getParameter(request, prefix	+ "offh_yd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fFmyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_fmyearmonth", length));
			String[] offhYdCdOrg = (JSPUtil.getParameter(request, prefix	+ "offh_yd_cd_org", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fToyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_toyearmonth", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fCntrno = (JSPUtil.getParameter(request, prefix	+ "f_cntrno", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			String[] fBkgno = (JSPUtil.getParameter(request, prefix	+ "f_bkgno", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] onhYdCdOrg = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd_org", length));
			String[] bkgNoOrg = (JSPUtil.getParameter(request, prefix	+ "bkg_no_org", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new OnewayCntrUploadVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (cntrNoOrg[i] != null)
					model.setCntrNoOrg(cntrNoOrg[i]);
				if (offhYdCd[i] != null)
					model.setOffhYdCd(offhYdCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fFmyearmonth[i] != null)
					model.setFFmyearmonth(fFmyearmonth[i]);
				if (offhYdCdOrg[i] != null)
					model.setOffhYdCdOrg(offhYdCdOrg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fToyearmonth[i] != null)
					model.setFToyearmonth(fToyearmonth[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fCntrno[i] != null)
					model.setFCntrno(fCntrno[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				if (fBkgno[i] != null)
					model.setFBkgno(fBkgno[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (onhYdCdOrg[i] != null)
					model.setOnhYdCdOrg(onhYdCdOrg[i]);
				if (bkgNoOrg[i] != null)
					model.setBkgNoOrg(bkgNoOrg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnewayCntrUploadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OnewayCntrUploadVO[]
	 */
	public OnewayCntrUploadVO[] getOnewayCntrUploadVOs(){
		OnewayCntrUploadVO[] vos = (OnewayCntrUploadVO[])models.toArray(new OnewayCntrUploadVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoOrg = this.cntrNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYdCd = this.offhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmyearmonth = this.fFmyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYdCdOrg = this.offhYdCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToyearmonth = this.fToyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrno = this.fCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgno = this.fBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhYdCdOrg = this.onhYdCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoOrg = this.bkgNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
