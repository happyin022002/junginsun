/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OverdayNStatusParmVO.java
*@FileTitle : OverdayNStatusParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.12.06 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OverdayNStatusParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OverdayNStatusParmVO> models = new ArrayList<OverdayNStatusParmVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String dttCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String mtDate = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String cstopIdx = null;
	/* Column Info */
	private String ftimeEnd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private List<String> cstopNoList = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String yrdLocCd = null;
	/* Column Info */
	private String exclHoli = null;
	/* Column Info */
	private String exclSat = null;
	/* Column Info */
	private String exclSun = null;
	/* Column Info */
	private String bkgStateCd = null;
	/* Column Info */
	private String yrdStateCd = null;
	/* Column Info */
	private String bkgLocCd = null;
	/* Column Info */
	private String bkgCntCd = null;
	/* Column Info */
	private String yrdCntCd = null;
	/* Column Info */
	private String bkgRgnCd = null;
	/* Column Info */
	private String yrdRgnCd = null;	
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String exptCostFlg = null;

	/**
	 * Column Info
	 * @return this.cstopNoVOS
	 */
	public void setCStopNoList(List<String> cstopNoList) {
		this.cstopNoList = cstopNoList;
	}
	
	/**
	 * Column Info
	 * @return List<String>
	 */
	public List<String> getCStopNoList() {
		return cstopNoList;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OverdayNStatusParmVO() {}

	public OverdayNStatusParmVO(String ibflag, String pagerows, String toDate, String ftimeEnd, String dttCode, String ofcCd, String mtDate, String cstopIdx, String yardCd, String ioBndCd, String bkgDeTermCd, String bkgRcvTermCd, String yrdLocCd, String exclHoli, String exclSat, String exclSun, String bkgCntCd, String bkgStateCd, String bkgRgnCd, String bkgLocCd, String yrdCntCd, String yrdStateCd, String yrdRgnCd, String svrId, String exptCostFlg) {
		this.ofcCd = ofcCd;
		this.dttCode = dttCode;
		this.ibflag = ibflag;
		this.yardCd = yardCd;
		this.mtDate = mtDate;
		this.toDate = toDate;
		this.cstopIdx = cstopIdx;
		this.ftimeEnd = ftimeEnd;
		this.ioBndCd = ioBndCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.yrdLocCd = yrdLocCd;
		this.pagerows = pagerows;
		this.exclHoli = exclHoli;
		this.exclSat  = exclSat;
		this.exclSun  = exclSun;
		this.bkgStateCd = bkgStateCd;
		this.yrdStateCd = yrdStateCd;
		this.bkgLocCd = bkgLocCd;
		this.bkgCntCd = bkgCntCd;
		this.yrdCntCd = yrdCntCd;
		this.bkgRgnCd = bkgRgnCd;
		this.yrdRgnCd = yrdRgnCd;
		this.svrId    = svrId;
		this.exptCostFlg = exptCostFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dtt_code", getDttCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("mt_date", getMtDate());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("cstop_idx", getCstopIdx());
		this.hashColumns.put("ftime_end", getFtimeEnd());
		this.hashColumns.put("io_bnd_cd",getIoBndCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("yrd_loc_cd", getYrdLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("excl_holi", getExclHoli());
		this.hashColumns.put("excl_sat", getExclSat());
		this.hashColumns.put("excl_sun", getExclSun());
		this.hashColumns.put("bkg_state_cd", getBkgStateCd());
		this.hashColumns.put("yrd_state_cd", getYrdStateCd());
		this.hashColumns.put("bkg_loc_cd", getBkgLocCd());
		this.hashColumns.put("bkg_cnt_cd", getBkgCntCd());
		this.hashColumns.put("yrd_cnt_cd", getYrdCntCd());
		this.hashColumns.put("bkg_rgn_cd", getBkgRgnCd());
		this.hashColumns.put("yrd_rgn_cd", getYrdRgnCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("expt_cost_flg", getExptCostFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dtt_code", "dttCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("mt_date", "mtDate");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("cstop_idx", "cstopIdx");
		this.hashFields.put("ftime_end", "ftimeEnd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("yrd_loc_cd", "yrdLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("excl_holi", "exclHoli");
		this.hashFields.put("excl_sat", "exclSat");
		this.hashFields.put("excl_sun", "exclSun");
		this.hashFields.put("bkg_state_cd", "bkgStateCd");
		this.hashFields.put("yrd_state_cd", "yrdStateCd");
		this.hashFields.put("bkg_loc_cd", "bkgLocCd");
		this.hashFields.put("bkg_cnt_cd", "bkgCntCd");
		this.hashFields.put("yrd_cnt_cd", "yrdCntCd");
		this.hashFields.put("bkg_rgn_cd", "bkgRgnCd");
		this.hashFields.put("yrd_rgn_cd", "yrdRgnCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("expt_cost_flg", "exptCostFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return dttCode
	 */
	public String getDttCode() {
		return this.dttCode;
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
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return mtDate
	 */
	public String getMtDate() {
		return this.mtDate;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return cstopIdx
	 */
	public String getCstopIdx() {
		return this.cstopIdx;
	}
	
	/**
	 * Column Info
	 * @return ftimeEnd
	 */
	public String getFtimeEnd() {
		return this.ftimeEnd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	
	public String getIoBndCd() {
		return ioBndCd;
	}

	public String getBkgDeTermCd() {
		return bkgDeTermCd;
	}
	
	public String getBkgRcvTermCd() {
		return bkgRcvTermCd;
	}
	
	public String getYrdLocCd() {
		return yrdLocCd;
	}

	
	public String getExclHoli() {
		return exclHoli;
	}


	public String getExclSat() {
		return exclSat;
	}

	public String getExclSun() {
		return exclSun;
	}
	
	public String getBkgStateCd() {
		return bkgStateCd;
	}

	public String getYrdStateCd() {
		return yrdStateCd;
	}

	public String getBkgLocCd() {
		return bkgLocCd;
	}

	public String getBkgCntCd() {
		return bkgCntCd;
	}

	public String getYrdCntCd() {
		return yrdCntCd;
	}

	public String getBkgRgnCd() {
		return bkgRgnCd;
	}

	public String getYrdRgnCd() {
		return yrdRgnCd;
	}


	public String getSvrId() {
		return svrId;
	}
	
	
	public String getExptCostFlg() {
		return exptCostFlg;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param dttCode
	 */
	public void setDttCode(String dttCode) {
		this.dttCode = dttCode;
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
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param mtDate
	 */
	public void setMtDate(String mtDate) {
		this.mtDate = mtDate;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param cstopIdx
	 */
	public void setCstopIdx(String cstopIdx) {
		this.cstopIdx = cstopIdx;
	}
	
	/**
	 * Column Info
	 * @param ftimeEnd
	 */
	public void setFtimeEnd(String ftimeEnd) {
		this.ftimeEnd = ftimeEnd;
	}
	
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}

	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	public void setYrdLocCd(String yrdLocCd) {
		this.yrdLocCd = yrdLocCd;
	}
	
	public void setExclHoli(String exclHoli) {
		this.exclHoli = exclHoli;
	}

	public void setExclSat(String exclSat) {
		this.exclSat = exclSat;
	}
	
	public void setExclSun(String exclSun) {
		this.exclSun = exclSun;
	}
	public void setBkgStateCd(String bkgStateCd) {
		this.bkgStateCd = bkgStateCd;
	}

	public void setYrdStateCd(String yrdStateCd) {
		this.yrdStateCd = yrdStateCd;
	}

	public void setBkgLocCd(String bkgLocCd) {
		this.bkgLocCd = bkgLocCd;
	}

	public void setBkgCntCd(String bkgCntCd) {
		this.bkgCntCd = bkgCntCd;
	}

	public void setYrdCntCd(String yrdCntCd) {
		this.yrdCntCd = yrdCntCd;
	}

	public void setBkgRgnCd(String bkgRgnCd) {
		this.bkgRgnCd = bkgRgnCd;
	}

	public void setYrdRgnCd(String yrdRgnCd) {
		this.yrdRgnCd = yrdRgnCd;
	}

	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	public void setExptCostFlg(String exptCostFlg) {
		this.exptCostFlg = exptCostFlg;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDttCode(JSPUtil.getParameter(request, prefix + "dtt_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setMtDate(JSPUtil.getParameter(request, prefix + "mt_date", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setCstopIdx(JSPUtil.getParameter(request, prefix + "cstop_idx", ""));
		setFtimeEnd(JSPUtil.getParameter(request, prefix + "ftime_end", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setYrdLocCd(JSPUtil.getParameter(request, prefix + "yrd_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExclHoli(JSPUtil.getParameter(request, prefix + "excl_holi", ""));
		setExclSat(JSPUtil.getParameter(request, prefix + "excl_sat", ""));
		setExclSun(JSPUtil.getParameter(request, prefix + "excl_sun", ""));
		setBkgStateCd(JSPUtil.getParameter(request, prefix + "bkg_state_cd", ""));
		setYrdStateCd(JSPUtil.getParameter(request, prefix + "yrd_state_cd", ""));
		setBkgLocCd(JSPUtil.getParameter(request, prefix + "bkg_loc_cd", ""));
		setBkgCntCd(JSPUtil.getParameter(request, prefix + "bkg_cnt_cd", ""));
		setYrdCntCd(JSPUtil.getParameter(request, prefix + "yrd_cnt_cd", ""));
		setBkgRgnCd(JSPUtil.getParameter(request, prefix + "bkg_rgn_cd", ""));
		setYrdRgnCd(JSPUtil.getParameter(request, prefix + "yrd_rgn_cd", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setExptCostFlg(JSPUtil.getParameter(request, prefix + "expt_cost_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OverdayNStatusParmVO[]
	 */
	public OverdayNStatusParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OverdayNStatusParmVO[]
	 */
	public OverdayNStatusParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OverdayNStatusParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] dttCode = (JSPUtil.getParameter(request, prefix	+ "dtt_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] mtDate = (JSPUtil.getParameter(request, prefix	+ "mt_date", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] cstopIdx = (JSPUtil.getParameter(request, prefix	+ "cstop_idx", length));
			String[] ftimeEnd = (JSPUtil.getParameter(request, prefix	+ "ftime_end", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix  + "bkg_de_term_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", length));
			String[] yrdLocCd = (JSPUtil.getParameter(request, prefix	+ "yrd_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] exclHoli = (JSPUtil.getParameter(request, prefix	+ "excl_holi", length));
			String[] exclSat = (JSPUtil.getParameter(request, prefix	+ "excl_sat", length));
			String[] exclSun = (JSPUtil.getParameter(request, prefix	+ "excl_sun", length));
			String[] bkgStateCd = (JSPUtil.getParameter(request, prefix	+ "bkg_state_cd", length));
			String[] yrdStateCd = (JSPUtil.getParameter(request, prefix	+ "yrd_state_cd", length));
			String[] bkgLocCd = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_cd", length));
			String[] bkgCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt_cd", length));
			String[] yrdCntCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cnt_cd", length));
			String[] bkgRgnCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rgn_cd", length));
			String[] yrdRgnCd = (JSPUtil.getParameter(request, prefix	+ "yrd_rgn_cd", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] exptCostFlg = (JSPUtil.getParameter(request, prefix	+ "expt_cost_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new OverdayNStatusParmVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (dttCode[i] != null)
					model.setDttCode(dttCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (mtDate[i] != null)
					model.setMtDate(mtDate[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (cstopIdx[i] != null)
					model.setCstopIdx(cstopIdx[i]);
				if (ftimeEnd[i] != null)
					model.setFtimeEnd(ftimeEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (yrdLocCd[i] != null)
					model.setYrdLocCd(yrdLocCd[i]);
				if (exclHoli[i] != null)
					model.setExclHoli(exclHoli[i]);
				if (exclSat[i] != null)
					model.setExclSat(exclSat[i]);
				if (exclSun[i] != null)
					model.setExclSun(exclSun[i]);
				if (bkgStateCd[i] != null)
					model.setBkgStateCd(bkgStateCd[i]);
				if (yrdStateCd[i] != null)
					model.setYrdStateCd(yrdStateCd[i]);
				if (bkgLocCd[i] != null)
					model.setBkgLocCd(bkgLocCd[i]);
				if (bkgCntCd[i] != null)
					model.setBkgCntCd(bkgCntCd[i]);
				if (yrdCntCd[i] != null)
					model.setYrdCntCd(yrdCntCd[i]);
				if (bkgRgnCd[i] != null)
					model.setBkgRgnCd(bkgRgnCd[i]);
				if (yrdRgnCd[i] != null)
					model.setYrdRgnCd(yrdRgnCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (exptCostFlg[i] != null)
					model.setExptCostFlg(exptCostFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOverdayNStatusParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OverdayNStatusParmVO[]
	 */
	public OverdayNStatusParmVO[] getOverdayNStatusParmVOs(){
		OverdayNStatusParmVO[] vos = (OverdayNStatusParmVO[])models.toArray(new OverdayNStatusParmVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dttCode = this.dttCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDate = this.mtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopIdx = this.cstopIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftimeEnd = this.ftimeEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdLocCd = this.yrdLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclHoli = this.exclHoli .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSat = this.exclSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclSun = this.exclSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStateCd = this.bkgStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdStateCd = this.yrdStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocCd = this.bkgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntCd = this.bkgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCntCd = this.yrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRgnCd = this.bkgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdRgnCd = this.yrdRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCostFlg = this.exptCostFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
