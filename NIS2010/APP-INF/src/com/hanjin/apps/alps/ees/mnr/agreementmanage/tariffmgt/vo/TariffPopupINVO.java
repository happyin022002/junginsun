/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffPopupINVO.java
*@FileTitle : TariffPopupINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.10 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffPopupINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffPopupINVO> models = new ArrayList<TariffPopupINVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrTrfStsCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mnrTrfKndCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String creDtFr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffPopupINVO() {}

	public TariffPopupINVO(String ibflag, String pagerows, String ofcCd, String mnrTrfStsCd, String mnrTrfKndCd, String eqKndCd, String creDtTo, String creDtFr, String vndrSeq) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.mnrTrfStsCd = mnrTrfStsCd;
		this.vndrSeq = vndrSeq;
		this.mnrTrfKndCd = mnrTrfKndCd;
		this.eqKndCd = eqKndCd;
		this.creDtTo = creDtTo;
		this.creDtFr = creDtFr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_trf_sts_cd", getMnrTrfStsCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mnr_trf_knd_cd", getMnrTrfKndCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("cre_dt_fr", getCreDtFr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_trf_sts_cd", "mnrTrfStsCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mnr_trf_knd_cd", "mnrTrfKndCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("cre_dt_fr", "creDtFr");
		this.hashFields.put("pagerows", "pagerows");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsCd
	 */
	public String getMnrTrfStsCd() {
		return this.mnrTrfStsCd;
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
	 * @return mnrTrfKndCd
	 */
	public String getMnrTrfKndCd() {
		return this.mnrTrfKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return creDtFr
	 */
	public String getCreDtFr() {
		return this.creDtFr;
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
	 * @param mnrTrfStsCd
	 */
	public void setMnrTrfStsCd(String mnrTrfStsCd) {
		this.mnrTrfStsCd = mnrTrfStsCd;
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
	 * @param mnrTrfKndCd
	 */
	public void setMnrTrfKndCd(String mnrTrfKndCd) {
		this.mnrTrfKndCd = mnrTrfKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		this.creDtFr = creDtFr;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrTrfStsCd(JSPUtil.getParameter(request, "mnr_trf_sts_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setMnrTrfKndCd(JSPUtil.getParameter(request, "mnr_trf_knd_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCreDtTo(JSPUtil.getParameter(request, "cre_dt_to", ""));
		setCreDtFr(JSPUtil.getParameter(request, "cre_dt_fr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffPopupINVO[]
	 */
	public TariffPopupINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffPopupINVO[]
	 */
	public TariffPopupINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffPopupINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mnrTrfKndCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_knd_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] creDtFr = (JSPUtil.getParameter(request, prefix	+ "cre_dt_fr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffPopupINVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrTrfStsCd[i] != null)
					model.setMnrTrfStsCd(mnrTrfStsCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mnrTrfKndCd[i] != null)
					model.setMnrTrfKndCd(mnrTrfKndCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (creDtFr[i] != null)
					model.setCreDtFr(creDtFr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffPopupINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffPopupINVO[]
	 */
	public TariffPopupINVO[] getTariffPopupINVOs(){
		TariffPopupINVO[] vos = (TariffPopupINVO[])models.toArray(new TariffPopupINVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsCd = this.mnrTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfKndCd = this.mnrTrfKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFr = this.creDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
