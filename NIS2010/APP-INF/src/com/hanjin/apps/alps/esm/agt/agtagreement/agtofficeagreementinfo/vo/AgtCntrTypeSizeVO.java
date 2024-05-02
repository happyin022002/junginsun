/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgtCntrTypeSizeVO.java
*@FileTitle : AgtCntrTypeSizeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.02 추경원 
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

public class AgtCntrTypeSizeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtCntrTypeSizeVO> models = new ArrayList<AgtCntrTypeSizeVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String agnSeq = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpDesc = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String agnAgmtVerSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String cntrSzDesc = null;
	/* Column Info */
	private String checkbox = null;
	
	private String pageType = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtCntrTypeSizeVO() {}

	public AgtCntrTypeSizeVO(String ibflag, String pagerows, String cntrSzCd, String cntrSzDesc, String cntrTpCd, String cntrTpDesc, String checkbox, String cntrTpszCd, String cntrTpszDesc, String agmtOfcCd, String agmtOfcCtyCd, String agnAgmtSeq, String vndrCntCd, String vndrSeq, String agnAgmtVerSeq, String ioBndCd, String acTpCd, String agnSeq, String pageType) {
		this.vndrCntCd = vndrCntCd;
		this.agnSeq = agnSeq;
		this.cntrSzCd = cntrSzCd;
		this.ioBndCd = ioBndCd;
		this.agmtOfcCd = agmtOfcCd;
		this.pagerows = pagerows;
		this.agnAgmtSeq = agnAgmtSeq;
		this.ibflag = ibflag;
		this.cntrTpDesc = cntrTpDesc;
		this.cntrTpszDesc = cntrTpszDesc;
		this.cntrTpCd = cntrTpCd;
		this.agnAgmtVerSeq = agnAgmtVerSeq;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.acTpCd = acTpCd;
		this.cntrSzDesc = cntrSzDesc;
		this.checkbox = checkbox;
		this.pageType = pageType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("agn_seq", getAgnSeq());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp_desc", getCntrTpDesc());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("agn_agmt_ver_seq", getAgnAgmtVerSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("cntr_sz_desc", getCntrSzDesc());
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
		this.hashFields.put("agn_seq", "agnSeq");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp_desc", "cntrTpDesc");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("agn_agmt_ver_seq", "agnAgmtVerSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("cntr_sz_desc", "cntrSzDesc");
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
	 * @return agnSeq
	 */
	public String getAgnSeq() {
		return this.agnSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntrTpDesc
	 */
	public String getCntrTpDesc() {
		return this.cntrTpDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return cntrSzDesc
	 */
	public String getCntrSzDesc() {
		return this.cntrSzDesc;
	}
	
	/**
	 * Column Info
	 * @return CheckBox
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
	 * @param agnSeq
	 */
	public void setAgnSeq(String agnSeq) {
		this.agnSeq = agnSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntrTpDesc
	 */
	public void setCntrTpDesc(String cntrTpDesc) {
		this.cntrTpDesc = cntrTpDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param cntrSzDesc
	 */
	public void setCntrSzDesc(String cntrSzDesc) {
		this.cntrSzDesc = cntrSzDesc;
	}
	
	/**
	 * Column Info
	 * @param CheckBox
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
		setAgnSeq(JSPUtil.getParameter(request, "agn_seq", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, "agn_agmt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpDesc(JSPUtil.getParameter(request, "cntr_tp_desc", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, "cntr_tpsz_desc", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setAgnAgmtVerSeq(JSPUtil.getParameter(request, "agn_agmt_ver_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, "ac_tp_cd", ""));
		setCntrSzDesc(JSPUtil.getParameter(request, "cntr_sz_desc", ""));
		setCheckbox(JSPUtil.getParameter(request, "checkbox", ""));
		setPageType(JSPUtil.getParameter(request, "pageType", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtCntrTypeSizeVO[]
	 */
	public AgtCntrTypeSizeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtCntrTypeSizeVO[]
	 */
	public AgtCntrTypeSizeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtCntrTypeSizeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] agnSeq = (JSPUtil.getParameter(request, prefix	+ "agn_seq", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_desc", length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] agnAgmtVerSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_ver_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] cntrSzDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_desc", length));
			String[] checkbox = (JSPUtil.getParameter(request, prefix	+ "checkbox", length));
			String[] pageType = (JSPUtil.getParameter(request, prefix	+ "pageType", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtCntrTypeSizeVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (agnSeq[i] != null)
					model.setAgnSeq(agnSeq[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpDesc[i] != null)
					model.setCntrTpDesc(cntrTpDesc[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (agnAgmtVerSeq[i] != null)
					model.setAgnAgmtVerSeq(agnAgmtVerSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (cntrSzDesc[i] != null)
					model.setCntrSzDesc(cntrSzDesc[i]);
				if (checkbox[i] != null)
					model.setCheckbox(checkbox[i]);
				if(pageType[i] != null)
					model.setPageType(pageType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtCntrTypeSizeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtCntrTypeSizeVO[]
	 */
	public AgtCntrTypeSizeVO[] getAgtCntrTypeSizeVOs(){
		AgtCntrTypeSizeVO[] vos = (AgtCntrTypeSizeVO[])models.toArray(new AgtCntrTypeSizeVO[models.size()]);
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
		this.agnSeq = this.agnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpDesc = this.cntrTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtVerSeq = this.agnAgmtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzDesc = this.cntrSzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox = this.checkbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageType = this.pageType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
