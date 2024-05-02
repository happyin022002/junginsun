/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgtGeogOfcVO.java
*@FileTitle : AgtGeogOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.04 추경원 
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

public class AgtGeogOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtGeogOfcVO> models = new ArrayList<AgtGeogOfcVO>();
	
	/* Column Info */
	private String routLvlCd = null;
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String routRefDivCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String agnSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String agnAgmtVerSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String checkbox = null;
	/* Column Info */
	private String scontiCd = null;
	
	private String pageType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtGeogOfcVO() {}

	public AgtGeogOfcVO(String ibflag, String pagerows, String checkbox, String contiCd, String contiNm, String scontiCd, String scontiNm, String cntCd, String cntNm, String locCd, String ofcCd, String agmtOfcCd, String agmtOfcCtyCd, String agnAgmtSeq, String vndrCntCd, String vndrSeq, String agnAgmtVerSeq, String ioBndCd, String acTpCd, String agnSeq, String routRefDivCd, String routLvlCd, String pageType) {
		this.routLvlCd = routLvlCd;
		this.scontiNm = scontiNm;
		this.routRefDivCd = routRefDivCd;
		this.vndrCntCd = vndrCntCd;
		this.contiCd = contiCd;
		this.agnSeq = agnSeq;
		this.ioBndCd = ioBndCd;
		this.agmtOfcCd = agmtOfcCd;
		this.pagerows = pagerows;
		this.agnAgmtSeq = agnAgmtSeq;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.locCd = locCd;
		this.agnAgmtVerSeq = agnAgmtVerSeq;
		this.vndrSeq = vndrSeq;
		this.contiNm = contiNm;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.cntCd = cntCd;
		this.acTpCd = acTpCd;
		this.checkbox = checkbox;
		this.scontiCd = scontiCd;
		this.pageType = pageType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rout_lvl_cd", getRoutLvlCd());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("rout_ref_div_cd", getRoutRefDivCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("agn_seq", getAgnSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("agn_agmt_ver_seq", getAgnAgmtVerSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("checkbox", getCheckbox());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pageType", getPageType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rout_lvl_cd", "routLvlCd");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("rout_ref_div_cd", "routRefDivCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("agn_seq", "agnSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("agn_agmt_ver_seq", "agnAgmtVerSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("checkbox", "checkbox");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pageType", "pageType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return routLvlCd
	 */
	public String getRoutLvlCd() {
		return this.routLvlCd;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return routRefDivCd
	 */
	public String getRoutRefDivCd() {
		return this.routRefDivCd;
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
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	

	public String getPageType() {
		return pageType;
	}

	

	/**
	 * Column Info
	 * @param routLvlCd
	 */
	public void setRoutLvlCd(String routLvlCd) {
		this.routLvlCd = routLvlCd;
	}
	
	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param routRefDivCd
	 */
	public void setRoutRefDivCd(String routRefDivCd) {
		this.routRefDivCd = routRefDivCd;
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
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param chkYn
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRoutLvlCd(JSPUtil.getParameter(request, "rout_lvl_cd", ""));
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setRoutRefDivCd(JSPUtil.getParameter(request, "rout_ref_div_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setAgnSeq(JSPUtil.getParameter(request, "agn_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, "agn_agmt_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setAgnAgmtVerSeq(JSPUtil.getParameter(request, "agn_agmt_ver_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setContiNm(JSPUtil.getParameter(request, "conti_nm", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, "ac_tp_cd", ""));
		setCheckbox(JSPUtil.getParameter(request, "checkbox", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPageType(JSPUtil.getParameter(request, "pageType", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtGeogOfcVO[]
	 */
	public AgtGeogOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtGeogOfcVO[]
	 */
	public AgtGeogOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtGeogOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] routLvlCd = (JSPUtil.getParameter(request, prefix	+ "rout_lvl_cd", length));
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] routRefDivCd = (JSPUtil.getParameter(request, prefix	+ "rout_ref_div_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] agnSeq = (JSPUtil.getParameter(request, prefix	+ "agn_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] agnAgmtVerSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_ver_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] checkbox = (JSPUtil.getParameter(request, prefix	+ "checkbox", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] pageType = (JSPUtil.getParameter(request, prefix	+ "pageType", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtGeogOfcVO();
				if (routLvlCd[i] != null)
					model.setRoutLvlCd(routLvlCd[i]);
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (routRefDivCd[i] != null)
					model.setRoutRefDivCd(routRefDivCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (agnSeq[i] != null)
					model.setAgnSeq(agnSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (agnAgmtVerSeq[i] != null)
					model.setAgnAgmtVerSeq(agnAgmtVerSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (checkbox[i] != null)
					model.setCheckbox(checkbox[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if(pageType[i] != null)
					model.setPageType(pageType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtGeogOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtGeogOfcVO[]
	 */
	public AgtGeogOfcVO[] getAgtGeogOfcVOs(){
		AgtGeogOfcVO[] vos = (AgtGeogOfcVO[])models.toArray(new AgtGeogOfcVO[models.size()]);
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
		this.routLvlCd = this.routLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRefDivCd = this.routRefDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnSeq = this.agnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtVerSeq = this.agnAgmtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox = this.checkbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageType = this.pageType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
