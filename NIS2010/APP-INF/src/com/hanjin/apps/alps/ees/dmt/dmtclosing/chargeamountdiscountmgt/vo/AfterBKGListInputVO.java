/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AfterBKGListInputVO.java
*@FileTitle : AfterBKGListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class AfterBKGListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBKGListInputVO> models = new ArrayList<AfterBKGListInputVO>();
	
	/* Column Info */
	private String stsDesc = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String apvlOfcCd = null;
	/* Column Info */
	private String dmdtExptRqstRsnCd = null;
	/* Column Info */
	private String rqstFlg = null;
	/* Column Info */
	private String apvlPathCd = null;
	/* Column Info */
	private String taaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterBKGListInputVO() {}

	public AfterBKGListInputVO(String ibflag, String pagerows, String apvlOfcCd, String darNo, String apvlNo, String stsCd, String stsDesc, String scNo, String rfaNo, String custCd, String custNm, String bkgNo, String blNo, String tariff, String dmdtExptRqstRsnCd, String rqstFlg, String apvlPathCd, String taaNo) {
		this.stsDesc = stsDesc;
		this.custNm = custNm;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.scNo = scNo;
		this.custCd = custCd;
		this.tariff = tariff;
		this.apvlOfcCd = apvlOfcCd;
		this.dmdtExptRqstRsnCd = dmdtExptRqstRsnCd;
		this.rqstFlg = rqstFlg;
		this.apvlPathCd = apvlPathCd;
		this.taaNo = taaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_desc", getStsDesc());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("apvl_ofc_cd", getApvlOfcCd());
		this.hashColumns.put("dmdt_expt_rqst_rsn_cd", getDmdtExptRqstRsnCd());
		this.hashColumns.put("rqst_flg", getRqstFlg());
		this.hashColumns.put("apvl_path_cd", getApvlPathCd());
		this.hashColumns.put("taa_no", getTaaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_desc", "stsDesc");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("apvl_ofc_cd", "apvlOfcCd");
		this.hashFields.put("dmdt_expt_rqst_rsn_cd","dmdtExptRqstRsnCd");
		this.hashFields.put("rqst_flg","rqstFlg");
		this.hashFields.put("apvl_path_cd","apvlPathCd");
		this.hashFields.put("taa_no","taaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsDesc
	 */
	public String getStsDesc() {
		return this.stsDesc;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return apvlOfcCd
	 */
	public String getApvlOfcCd() {
		return this.apvlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstRsnCd
	 */	
	public String getDmdtExptRqstRsnCd() {
		return this.dmdtExptRqstRsnCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstRsnCd
	 */	
	public void setDmdtExptRqstRsnCd(String dmdtExptRqstRsnCd) {
		this.dmdtExptRqstRsnCd = dmdtExptRqstRsnCd;
	}

	/**
	 * Column Info
	 * @param stsDesc
	 */
	public void setStsDesc(String stsDesc) {
		this.stsDesc = stsDesc;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param apvlOfcCd
	 */
	public void setApvlOfcCd(String apvlOfcCd) {
		this.apvlOfcCd = apvlOfcCd;
	}
	
	public String getRqstFlg() {
		return rqstFlg;
	}

	public void setRqstFlg(String rqstFlg) {
		this.rqstFlg = rqstFlg;
	}

	public String getApvlPathCd() {
		return apvlPathCd;
	}

	public void setApvlPathCd(String apvlPathCd) {
		this.apvlPathCd = apvlPathCd;
	}

	public String getTaaNo() {
		return taaNo;
	}

	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStsDesc(JSPUtil.getParameter(request, "sts_desc", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setApvlOfcCd(JSPUtil.getParameter(request, "apvl_ofc_cd", ""));
		setDmdtExptRqstRsnCd(JSPUtil.getParameter(request, "dmdt_expt_rqst_rsn_cd", ""));
		setRqstFlg(JSPUtil.getParameter(request, "rqst_flg", ""));
		setApvlPathCd(JSPUtil.getParameter(request, "apvl_path_cd", ""));
		setTaaNo(JSPUtil.getParameter(request, "taa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBKGListInputVO[]
	 */
	public AfterBKGListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBKGListInputVO[]
	 */
	public AfterBKGListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBKGListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsDesc = (JSPUtil.getParameter(request, prefix	+ "sts_desc", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] apvlOfcCd = (JSPUtil.getParameter(request, prefix	+ "apvl_ofc_cd", length));
			String[] dmdtExptRqstRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_rsn_cd", length));
			String[] rqstFlg = (JSPUtil.getParameter(request, prefix	+ "rqst_flg", length));
			String[] apvlPathCd = (JSPUtil.getParameter(request, prefix	+ "apvl_path_cd", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBKGListInputVO();
				if (stsDesc[i] != null)
					model.setStsDesc(stsDesc[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (apvlOfcCd[i] != null)
					model.setApvlOfcCd(apvlOfcCd[i]);
				if (dmdtExptRqstRsnCd[i] != null)
					model.setDmdtExptRqstRsnCd(dmdtExptRqstRsnCd[i]);		
				if (rqstFlg[i] != null)
					model.setRqstFlg(rqstFlg[i]);	
				if (apvlPathCd[i] != null)
					model.setApvlPathCd(apvlPathCd[i]);			
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);			


				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBKGListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBKGListInputVO[]
	 */
	public AfterBKGListInputVO[] getAfterBKGListInputVOs(){
		AfterBKGListInputVO[] vos = (AfterBKGListInputVO[])models.toArray(new AfterBKGListInputVO[models.size()]);
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
		this.stsDesc = this.stsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlOfcCd = this.apvlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstRsnCd = this.dmdtExptRqstRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFlg = this.rqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlPathCd = this.apvlPathCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
