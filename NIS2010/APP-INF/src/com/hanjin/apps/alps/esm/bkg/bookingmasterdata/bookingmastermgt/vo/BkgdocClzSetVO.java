/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgdocClzSetVO.java
*@FileTitle : BkgdocClzSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.24 강동윤 
* 1.0 Creation
* 2012.02.23 박성호[CHM-201115347] BKG 한국지역 사전 적하목록 제출 시간 변경에 따른 Cut-off time 변경 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgdocClzSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgdocClzSetVO> models = new ArrayList<BkgdocClzSetVO>();
	
	/* Column Info */
	private String itvalHrs = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String docClzTpCd = null;
	/* Column Info */
	private String destCntCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String day = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String docClzDyCd = null;
	/* Column Info */
	private String docClzDyHrs = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String vvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgdocClzSetVO() {}

	public BkgdocClzSetVO(String ibflag, String pagerows, String vslSlanCd, String ydCd, String destCntCd, String docClzTpCd, String itvalHrs, String xcldHolFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String pol, String day, String ofcCd, String docClzDyCd, String docClzDyHrs, String contiCd, String vvdCd) {
		this.itvalHrs = itvalHrs;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.pol = pol;
		this.docClzTpCd = docClzTpCd;
		this.destCntCd = destCntCd;
		this.xcldHolFlg = xcldHolFlg;
		this.updUsrId = updUsrId;
		this.day = day;
		this.ofcCd = ofcCd;
		this.docClzDyCd = docClzDyCd;
		this.docClzDyHrs = docClzDyHrs;
		this.contiCd = contiCd;
		this.vvdCd = vvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("itval_hrs", getItvalHrs());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("doc_clz_tp_cd", getDocClzTpCd());
		this.hashColumns.put("dest_cnt_cd", getDestCntCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("day", getDay());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("doc_clz_dy_cd", getDocClzDyCd());
		this.hashColumns.put("doc_clz_dy_hrs", getDocClzDyHrs());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("itval_hrs", "itvalHrs");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("doc_clz_tp_cd", "docClzTpCd");
		this.hashFields.put("dest_cnt_cd", "destCntCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("day", "day");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("doc_clz_dy_cd", "docClzDyCd");
		this.hashFields.put("doc_clz_dy_hrs", "docClzDyHrs");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return itvalHrs
	 */
	public String getItvalHrs() {
		return this.itvalHrs;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return docClzTpCd
	 */
	public String getDocClzTpCd() {
		return this.docClzTpCd;
	}
	
	/**
	 * Column Info
	 * @return destCntCd
	 */
	public String getDestCntCd() {
		return this.destCntCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
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
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * Column Info
	 * @return docClzDyCd
	 */
	public String getDocClzDyCd() {
		return docClzDyCd;
	}
	
	/**
	 * Column Info
	 * @return docClzDyHrs
	 */
	public String getDocClzDyHrs() {
		return docClzDyHrs;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param itvalHrs
	 */
	public void setItvalHrs(String itvalHrs) {
		this.itvalHrs = itvalHrs;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param docClzTpCd
	 */
	public void setDocClzTpCd(String docClzTpCd) {
		this.docClzTpCd = docClzTpCd;
	}
	
	/**
	 * Column Info
	 * @param destCntCd
	 */
	public void setDestCntCd(String destCntCd) {
		this.destCntCd = destCntCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
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
	 * @param docClzDyCd
	 */
	public void setDocClzDyCd(String docClzDyCd) {
		this.docClzDyCd = docClzDyCd;
	}

	/**
	 * Column Info
	 * @param docClzDyHrs
	 */
	public void setDocClzDyHrs(String docClzDyHrs) {
		this.docClzDyHrs = docClzDyHrs;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setItvalHrs(JSPUtil.getParameter(request, "itval_hrs", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setDocClzTpCd(JSPUtil.getParameter(request, "doc_clz_tp_cd", ""));
		setDestCntCd(JSPUtil.getParameter(request, "dest_cnt_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDay(JSPUtil.getParameter(request, "day", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDocClzDyCd(JSPUtil.getParameter(request, "doc_clz_dy_cd", ""));
		setDocClzDyHrs(JSPUtil.getParameter(request, "doc_clz_dy_hrs", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
	}


	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgdocClzSetVO[]
	 */
	public BkgdocClzSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgdocClzSetVO[]
	 */
	public BkgdocClzSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgdocClzSetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] itvalHrs = (JSPUtil.getParameter(request, prefix	+ "itval_hrs", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] docClzTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_clz_tp_cd", length));
			String[] destCntCd = (JSPUtil.getParameter(request, prefix	+ "dest_cnt_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] day = (JSPUtil.getParameter(request, prefix	+ "day", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] docClzDyCd = (JSPUtil.getParameter(request, prefix	+ "doc_clz_dy_cd", length));
			String[] docClzDyHrs = (JSPUtil.getParameter(request, prefix	+ "doc_clz_dy_hrs", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgdocClzSetVO();
				if (itvalHrs[i] != null)
					model.setItvalHrs(itvalHrs[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (docClzTpCd[i] != null)
					model.setDocClzTpCd(docClzTpCd[i]);
				if (destCntCd[i] != null)
					model.setDestCntCd(destCntCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (day[i] != null)
					model.setDay(day[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (docClzDyCd[i] != null)
					model.setDocClzDyCd(docClzDyCd[i]);
				if (docClzDyHrs[i] != null)
					model.setDocClzDyHrs(docClzDyHrs[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgdocClzSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgdocClzSetVO[]
	 */
	public BkgdocClzSetVO[] getBkgdocClzSetVOs(){
		BkgdocClzSetVO[] vos = (BkgdocClzSetVO[])models.toArray(new BkgdocClzSetVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.itvalHrs = this.itvalHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docClzTpCd = this.docClzTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCntCd = this.destCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day = this.day .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docClzDyCd = this.docClzDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docClzDyHrs = this.docClzDyHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
