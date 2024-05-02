/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffApprovalINVO.java
*@FileTitle : TariffApprovalINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.20 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffApprovalINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffApprovalINVO> models = new ArrayList<TariffApprovalINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrTrfStsCd = null;
	/* Column Info */
	private String effDtFr = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String effDtTo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
    
    /**
     * TariffApprovalINVO을 생성함
     */	
	public TariffApprovalINVO() {}
    
    /**
     * TariffApprovalINVO을 생성함
     */
	public TariffApprovalINVO(String ibflag, String pagerows, String arHdQtrOfcCd, String rqstOfcCd, String effDtFr, String effDtTo, String mnrTrfStsCd, String vndrSeq, String eqKndCd) {
		this.ibflag = ibflag;
		this.mnrTrfStsCd = mnrTrfStsCd;
		this.effDtFr = effDtFr;
		this.vndrSeq = vndrSeq;
		this.effDtTo = effDtTo;
		this.rqstOfcCd = rqstOfcCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_trf_sts_cd", getMnrTrfStsCd());
		this.hashColumns.put("eff_dt_fr", getEffDtFr());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eff_dt_to", getEffDtTo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_trf_sts_cd", "mnrTrfStsCd");
		this.hashFields.put("eff_dt_fr", "effDtFr");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eff_dt_to", "effDtTo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return effDtFr
	 */
	public String getEffDtFr() {
		return this.effDtFr;
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
	 * @return effDtTo
	 */
	public String getEffDtTo() {
		return this.effDtTo;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @param effDtFr
	 */
	public void setEffDtFr(String effDtFr) {
		this.effDtFr = effDtFr;
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
	 * @param effDtTo
	 */
	public void setEffDtTo(String effDtTo) {
		this.effDtTo = effDtTo;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrTrfStsCd(JSPUtil.getParameter(request, "mnr_trf_sts_cd", ""));
		setEffDtFr(JSPUtil.getParameter(request, "eff_dt_fr", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEffDtTo(JSPUtil.getParameter(request, "eff_dt_to", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffApprovalINVO[]
	 */
	public TariffApprovalINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffApprovalINVO[]
	 */
	public TariffApprovalINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffApprovalINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_cd", length));
			String[] effDtFr = (JSPUtil.getParameter(request, prefix	+ "eff_dt_fr", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] effDtTo = (JSPUtil.getParameter(request, prefix	+ "eff_dt_to", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffApprovalINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrTrfStsCd[i] != null)
					model.setMnrTrfStsCd(mnrTrfStsCd[i]);
				if (effDtFr[i] != null)
					model.setEffDtFr(effDtFr[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (effDtTo[i] != null)
					model.setEffDtTo(effDtTo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffApprovalINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffApprovalINVO[]
	 */
	public TariffApprovalINVO[] getTariffApprovalINVOs(){
		TariffApprovalINVO[] vos = (TariffApprovalINVO[])models.toArray(new TariffApprovalINVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsCd = this.mnrTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtFr = this.effDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtTo = this.effDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
