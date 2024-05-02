/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgtChargeDeductionVO.java
*@FileTitle : AgtChargeDeductionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.03 추경원 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo;

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
 * @author 추경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgtChargeDeductionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtChargeDeductionVO> models = new ArrayList<AgtChargeDeductionVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String agnSeq = null;
	/* Column Info */
	private String frtChgTpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String repChgNm = null;
	/* Column Info */
	private String agnAgmtVerSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String chgRevTpCd = null;
	/* Column Info */
	private String chgAplyTpCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String checkbox = null;
	
	private String pageType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtChargeDeductionVO() {}

	public AgtChargeDeductionVO(String ibflag, String pagerows, String checkbox, String chgCd, String chgNm, String repChgCd, String repChgNm, String frtChgTpCd, String chgRevTpCd, String chgAplyTpCd, String agmtOfcCd, String agmtOfcCtyCd, String agnAgmtSeq, String vndrCntCd, String vndrSeq, String agnAgmtVerSeq, String ioBndCd, String acTpCd, String agnSeq, String pageType) {
		this.vndrCntCd = vndrCntCd;
		this.repChgCd = repChgCd;
		this.chgNm = chgNm;
		this.agnSeq = agnSeq;
		this.frtChgTpCd = frtChgTpCd;
		this.ioBndCd = ioBndCd;
		this.agmtOfcCd = agmtOfcCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.agnAgmtSeq = agnAgmtSeq;
		this.ibflag = ibflag;
		this.repChgNm = repChgNm;
		this.agnAgmtVerSeq = agnAgmtVerSeq;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.chgRevTpCd = chgRevTpCd;
		this.chgAplyTpCd = chgAplyTpCd;
		this.acTpCd = acTpCd;
		this.checkbox = checkbox;
		this.pageType = pageType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("agn_seq", getAgnSeq());
		this.hashColumns.put("frt_chg_tp_cd", getFrtChgTpCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rep_chg_nm", getRepChgNm());
		this.hashColumns.put("agn_agmt_ver_seq", getAgnAgmtVerSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("chg_rev_tp_cd", getChgRevTpCd());
		this.hashColumns.put("chg_aply_tp_cd", getChgAplyTpCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("checkbox", getCheckbox());
		this.hashColumns.put("pageType", getPageType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("agn_seq", "agnSeq");
		this.hashFields.put("frt_chg_tp_cd", "frtChgTpCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rep_chg_nm", "repChgNm");
		this.hashFields.put("agn_agmt_ver_seq", "agnAgmtVerSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("chg_rev_tp_cd", "chgRevTpCd");
		this.hashFields.put("chg_aply_tp_cd", "chgAplyTpCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("checkbox", "checkbox");
		this.hashFields.put("pageType", "pageType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}
	
	/**
	 * Column Info
	 * @return agnSeq
	 */
	public String getAgnSeq() {
		return this.agnSeq;
	}
	
	/**
	 * Column Info
	 * @return frtChgTpCd
	 */
	public String getFrtChgTpCd() {
		return this.frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return agnAgmtSeq
	 */
	public String getAgnAgmtSeq() {
		return this.agnAgmtSeq;
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
	 * @return repChgNm
	 */
	public String getRepChgNm() {
		return this.repChgNm;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtVerSeq
	 */
	public String getAgnAgmtVerSeq() {
		return this.agnAgmtVerSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return chgRevTpCd
	 */
	public String getChgRevTpCd() {
		return this.chgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgAplyTpCd
	 */
	public String getChgAplyTpCd() {
		return this.chgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}
	
	/**
	 * Column Info
	 * @return checkbox
	 */
	public String getCheckbox() {
		return this.checkbox;
	}
	
	
	public String getPageType() {
		return pageType;
	}

	

	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}
	
	/**
	 * Column Info
	 * @param agnSeq
	 */
	public void setAgnSeq(String agnSeq) {
		this.agnSeq = agnSeq;
	}
	
	/**
	 * Column Info
	 * @param frtChgTpCd
	 */
	public void setFrtChgTpCd(String frtChgTpCd) {
		this.frtChgTpCd = frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param agnAgmtSeq
	 */
	public void setAgnAgmtSeq(String agnAgmtSeq) {
		this.agnAgmtSeq = agnAgmtSeq;
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
	 * @param repChgNm
	 */
	public void setRepChgNm(String repChgNm) {
		this.repChgNm = repChgNm;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtVerSeq
	 */
	public void setAgnAgmtVerSeq(String agnAgmtVerSeq) {
		this.agnAgmtVerSeq = agnAgmtVerSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param chgRevTpCd
	 */
	public void setChgRevTpCd(String chgRevTpCd) {
		this.chgRevTpCd = chgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgAplyTpCd
	 */
	public void setChgAplyTpCd(String chgAplyTpCd) {
		this.chgAplyTpCd = chgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}
	
	/**
	 * Column Info
	 * @param checkbox
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setChgNm(JSPUtil.getParameter(request, "chg_nm", ""));
		setAgnSeq(JSPUtil.getParameter(request, "agn_seq", ""));
		setFrtChgTpCd(JSPUtil.getParameter(request, "frt_chg_tp_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, "agn_agmt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRepChgNm(JSPUtil.getParameter(request, "rep_chg_nm", ""));
		setAgnAgmtVerSeq(JSPUtil.getParameter(request, "agn_agmt_ver_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setChgRevTpCd(JSPUtil.getParameter(request, "chg_rev_tp_cd", ""));
		setChgAplyTpCd(JSPUtil.getParameter(request, "chg_aply_tp_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, "ac_tp_cd", ""));
		setCheckbox(JSPUtil.getParameter(request, "checkbox", ""));
		setPageType(JSPUtil.getParameter(request, "pageType", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtChargeDeductionVO[]
	 */
	public AgtChargeDeductionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtChargeDeductionVO[]
	 */
	public AgtChargeDeductionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtChargeDeductionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] agnSeq = (JSPUtil.getParameter(request, prefix	+ "agn_seq", length));
			String[] frtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "frt_chg_tp_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] repChgNm = (JSPUtil.getParameter(request, prefix	+ "rep_chg_nm", length));
			String[] agnAgmtVerSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_ver_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] chgRevTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rev_tp_cd", length));
			String[] chgAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_aply_tp_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] checkbox = (JSPUtil.getParameter(request, prefix	+ "checkbox", length));
			String[] pageType = (JSPUtil.getParameter(request, prefix	+ "pageType", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtChargeDeductionVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (agnSeq[i] != null)
					model.setAgnSeq(agnSeq[i]);
				if (frtChgTpCd[i] != null)
					model.setFrtChgTpCd(frtChgTpCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (repChgNm[i] != null)
					model.setRepChgNm(repChgNm[i]);
				if (agnAgmtVerSeq[i] != null)
					model.setAgnAgmtVerSeq(agnAgmtVerSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (chgRevTpCd[i] != null)
					model.setChgRevTpCd(chgRevTpCd[i]);
				if (chgAplyTpCd[i] != null)
					model.setChgAplyTpCd(chgAplyTpCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (checkbox[i] != null)
					model.setCheckbox(checkbox[i]);
				if(pageType[i] != null)
					model.setPageType(pageType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtChargeDeductionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtChargeDeductionVO[]
	 */
	public AgtChargeDeductionVO[] getAgtChargeDeductionVOs(){
		AgtChargeDeductionVO[] vos = (AgtChargeDeductionVO[])models.toArray(new AgtChargeDeductionVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnSeq = this.agnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgTpCd = this.frtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgNm = this.repChgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtVerSeq = this.agnAgmtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRevTpCd = this.chgRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAplyTpCd = this.chgAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox = this.checkbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageType = this.pageType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
