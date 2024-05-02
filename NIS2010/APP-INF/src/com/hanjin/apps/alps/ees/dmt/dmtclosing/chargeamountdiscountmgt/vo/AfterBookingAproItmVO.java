/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AfterBookingAproItmVO.java
*@FileTitle : AfterBookingAproItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingAproItmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingAproItmVO> models = new ArrayList<AfterBookingAproItmVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aftBkgItmLvl = null;
	/* Column Info */
	private String aftBkgItmCtnt2 = null;
	/* Column Info */
	private String no = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String value3 = null;
	/* Column Info */
	private String aftBkgItmCtnt1 = null;
	/* Column Info */
	private String value1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String value2 = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String fomlNm = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String rvwItm = null;
	/* Column Info */
	private String aftBkgItmNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingAproItmVO() {}

	public AfterBookingAproItmVO(String ibflag, String pagerows, String seq, String no, String rvwItm, String fomlNm, String value1, String value2, String value3, String aftExptDarNo, String aftBkgItmLvl, String aftBkgItmNm, String aftBkgItmCtnt1, String aftBkgItmCtnt2, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.aftBkgItmLvl = aftBkgItmLvl;
		this.aftBkgItmCtnt2 = aftBkgItmCtnt2;
		this.no = no;
		this.creDt = creDt;
		this.value3 = value3;
		this.aftBkgItmCtnt1 = aftBkgItmCtnt1;
		this.value1 = value1;
		this.pagerows = pagerows;
		this.value2 = value2;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.fomlNm = fomlNm;
		this.seq = seq;
		this.rvwItm = rvwItm;
		this.aftBkgItmNm = aftBkgItmNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aft_bkg_itm_lvl", getAftBkgItmLvl());
		this.hashColumns.put("aft_bkg_itm_ctnt2", getAftBkgItmCtnt2());
		this.hashColumns.put("no", getNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("value_3", getValue3());
		this.hashColumns.put("aft_bkg_itm_ctnt1", getAftBkgItmCtnt1());
		this.hashColumns.put("value_1", getValue1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("value_2", getValue2());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("foml_nm", getFomlNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("rvw_itm", getRvwItm());
		this.hashColumns.put("aft_bkg_itm_nm", getAftBkgItmNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("aft_bkg_itm_lvl", "aftBkgItmLvl");
		this.hashFields.put("aft_bkg_itm_ctnt2", "aftBkgItmCtnt2");
		this.hashFields.put("no", "no");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("value_3", "value3");
		this.hashFields.put("aft_bkg_itm_ctnt1", "aftBkgItmCtnt1");
		this.hashFields.put("value_1", "value1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("value_2", "value2");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("foml_nm", "fomlNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rvw_itm", "rvwItm");
		this.hashFields.put("aft_bkg_itm_nm", "aftBkgItmNm");
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
	 * @return aftBkgItmLvl
	 */
	public String getAftBkgItmLvl() {
		return this.aftBkgItmLvl;
	}
	
	/**
	 * Column Info
	 * @return aftBkgItmCtnt2
	 */
	public String getAftBkgItmCtnt2() {
		return this.aftBkgItmCtnt2;
	}
	
	/**
	 * Column Info
	 * @return no
	 */
	public String getNo() {
		return this.no;
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
	 * @return value3
	 */
	public String getValue3() {
		return this.value3;
	}
	
	/**
	 * Column Info
	 * @return aftBkgItmCtnt1
	 */
	public String getAftBkgItmCtnt1() {
		return this.aftBkgItmCtnt1;
	}
	
	/**
	 * Column Info
	 * @return value1
	 */
	public String getValue1() {
		return this.value1;
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
	 * @return value2
	 */
	public String getValue2() {
		return this.value2;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return fomlNm
	 */
	public String getFomlNm() {
		return this.fomlNm;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return rvwItm
	 */
	public String getRvwItm() {
		return this.rvwItm;
	}
	
	/**
	 * Column Info
	 * @return aftBkgItmNm
	 */
	public String getAftBkgItmNm() {
		return this.aftBkgItmNm;
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
	 * @param aftBkgItmLvl
	 */
	public void setAftBkgItmLvl(String aftBkgItmLvl) {
		this.aftBkgItmLvl = aftBkgItmLvl;
	}
	
	/**
	 * Column Info
	 * @param aftBkgItmCtnt2
	 */
	public void setAftBkgItmCtnt2(String aftBkgItmCtnt2) {
		this.aftBkgItmCtnt2 = aftBkgItmCtnt2;
	}
	
	/**
	 * Column Info
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
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
	 * @param value3
	 */
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	
	/**
	 * Column Info
	 * @param aftBkgItmCtnt1
	 */
	public void setAftBkgItmCtnt1(String aftBkgItmCtnt1) {
		this.aftBkgItmCtnt1 = aftBkgItmCtnt1;
	}
	
	/**
	 * Column Info
	 * @param value1
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
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
	 * @param value2
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param fomlNm
	 */
	public void setFomlNm(String fomlNm) {
		this.fomlNm = fomlNm;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param rvwItm
	 */
	public void setRvwItm(String rvwItm) {
		this.rvwItm = rvwItm;
	}
	
	/**
	 * Column Info
	 * @param aftBkgItmNm
	 */
	public void setAftBkgItmNm(String aftBkgItmNm) {
		this.aftBkgItmNm = aftBkgItmNm;
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
		setAftBkgItmLvl(JSPUtil.getParameter(request, prefix + "aft_bkg_itm_lvl", ""));
		setAftBkgItmCtnt2(JSPUtil.getParameter(request, prefix + "aft_bkg_itm_ctnt2", ""));
		setNo(JSPUtil.getParameter(request, prefix + "no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setValue3(JSPUtil.getParameter(request, prefix + "value_3", ""));
		setAftBkgItmCtnt1(JSPUtil.getParameter(request, prefix + "aft_bkg_itm_ctnt1", ""));
		setValue1(JSPUtil.getParameter(request, prefix + "value_1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setValue2(JSPUtil.getParameter(request, prefix + "value_2", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setFomlNm(JSPUtil.getParameter(request, prefix + "foml_nm", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setRvwItm(JSPUtil.getParameter(request, prefix + "rvw_itm", ""));
		setAftBkgItmNm(JSPUtil.getParameter(request, prefix + "aft_bkg_itm_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingAproItmVO[]
	 */
	public AfterBookingAproItmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingAproItmVO[]
	 */
	public AfterBookingAproItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingAproItmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aftBkgItmLvl = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_itm_lvl", length));
			String[] aftBkgItmCtnt2 = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_itm_ctnt2", length));
			String[] no = (JSPUtil.getParameter(request, prefix	+ "no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] value3 = (JSPUtil.getParameter(request, prefix	+ "value_3", length));
			String[] aftBkgItmCtnt1 = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_itm_ctnt1", length));
			String[] value1 = (JSPUtil.getParameter(request, prefix	+ "value_1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] value2 = (JSPUtil.getParameter(request, prefix	+ "value_2", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] fomlNm = (JSPUtil.getParameter(request, prefix	+ "foml_nm", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] rvwItm = (JSPUtil.getParameter(request, prefix	+ "rvw_itm", length));
			String[] aftBkgItmNm = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_itm_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingAproItmVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aftBkgItmLvl[i] != null)
					model.setAftBkgItmLvl(aftBkgItmLvl[i]);
				if (aftBkgItmCtnt2[i] != null)
					model.setAftBkgItmCtnt2(aftBkgItmCtnt2[i]);
				if (no[i] != null)
					model.setNo(no[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (value3[i] != null)
					model.setValue3(value3[i]);
				if (aftBkgItmCtnt1[i] != null)
					model.setAftBkgItmCtnt1(aftBkgItmCtnt1[i]);
				if (value1[i] != null)
					model.setValue1(value1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (value2[i] != null)
					model.setValue2(value2[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (fomlNm[i] != null)
					model.setFomlNm(fomlNm[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (rvwItm[i] != null)
					model.setRvwItm(rvwItm[i]);
				if (aftBkgItmNm[i] != null)
					model.setAftBkgItmNm(aftBkgItmNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingAproItmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingAproItmVO[]
	 */
	public AfterBookingAproItmVO[] getAfterBookingAproItmVOs(){
		AfterBookingAproItmVO[] vos = (AfterBookingAproItmVO[])models.toArray(new AfterBookingAproItmVO[models.size()]);
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
		this.aftBkgItmLvl = this.aftBkgItmLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgItmCtnt2 = this.aftBkgItmCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no = this.no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value3 = this.value3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgItmCtnt1 = this.aftBkgItmCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value1 = this.value1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value2 = this.value2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlNm = this.fomlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvwItm = this.rvwItm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgItmNm = this.aftBkgItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
