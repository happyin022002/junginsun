/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeBookingContainerParmVO.java
*@FileTitle : ChargeBookingContainerParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.05  
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

public class ChargeBookingContainerParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeBookingContainerParmVO> models = new ArrayList<ChargeBookingContainerParmVO>();
	
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String isAftBkgCntr = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String ofcTrnsRhqCngFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String apvlOfcCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String isCntr = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeBookingContainerParmVO() {}

	public ChargeBookingContainerParmVO(String ibflag, String pagerows, String pod, String pol, String del, String por, String blNo, String tariff, String darNo, String bkgNo, String apvlNo, String isCntr, String apvlOfcCd, String aftExptDarNo, String aftExptAdjSeq, String isAftBkgCntr, String ofcTrnsFlg, String ofcTrnsRhqCngFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.darNo = darNo;
		this.isAftBkgCntr = isAftBkgCntr;
		this.apvlNo = apvlNo;
		this.por = por;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.aftExptDarNo = aftExptDarNo;
		this.pol = pol;
		this.tariff = tariff;
		this.apvlOfcCd = apvlOfcCd;
		this.del = del;
		this.isCntr = isCntr;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("is_aft_bkg_cntr", getIsAftBkgCntr());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("ofc_trns_rhq_cng_flg", getOfcTrnsRhqCngFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("apvl_ofc_cd", getApvlOfcCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("is_cntr", getIsCntr());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("is_aft_bkg_cntr", "isAftBkgCntr");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("por", "por");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("ofc_trns_rhq_cng_flg", "ofcTrnsRhqCngFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("apvl_ofc_cd", "apvlOfcCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("is_cntr", "isCntr");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
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
	 * @return isAftBkgCntr
	 */
	public String getIsAftBkgCntr() {
		return this.isAftBkgCntr;
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
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return aftExptAdjSeq
	 */
	public String getAftExptAdjSeq() {
		return this.aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsRhqCngFlg
	 */
	public String getOfcTrnsRhqCngFlg() {
		return this.ofcTrnsRhqCngFlg;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return isCntr
	 */
	public String getIsCntr() {
		return this.isCntr;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
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
	 * @param isAftBkgCntr
	 */
	public void setIsAftBkgCntr(String isAftBkgCntr) {
		this.isAftBkgCntr = isAftBkgCntr;
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
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param aftExptAdjSeq
	 */
	public void setAftExptAdjSeq(String aftExptAdjSeq) {
		this.aftExptAdjSeq = aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsRhqCngFlg
	 */
	public void setOfcTrnsRhqCngFlg(String ofcTrnsRhqCngFlg) {
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
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
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param isCntr
	 */
	public void setIsCntr(String isCntr) {
		this.isCntr = isCntr;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcTrnsFlg(JSPUtil.getParameter(request, "ofc_trns_flg", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setIsAftBkgCntr(JSPUtil.getParameter(request, "is_aft_bkg_cntr", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, "aft_expt_adj_seq", ""));
		setOfcTrnsRhqCngFlg(JSPUtil.getParameter(request, "ofc_trns_rhq_cng_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setApvlOfcCd(JSPUtil.getParameter(request, "apvl_ofc_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setIsCntr(JSPUtil.getParameter(request, "is_cntr", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeBookingContainerParmVO[]
	 */
	public ChargeBookingContainerParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeBookingContainerParmVO[]
	 */
	public ChargeBookingContainerParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeBookingContainerParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] isAftBkgCntr = (JSPUtil.getParameter(request, prefix	+ "is_aft_bkg_cntr", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] ofcTrnsRhqCngFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_rhq_cng_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] apvlOfcCd = (JSPUtil.getParameter(request, prefix	+ "apvl_ofc_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] isCntr = (JSPUtil.getParameter(request, prefix	+ "is_cntr", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeBookingContainerParmVO();
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (isAftBkgCntr[i] != null)
					model.setIsAftBkgCntr(isAftBkgCntr[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (ofcTrnsRhqCngFlg[i] != null)
					model.setOfcTrnsRhqCngFlg(ofcTrnsRhqCngFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (apvlOfcCd[i] != null)
					model.setApvlOfcCd(apvlOfcCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (isCntr[i] != null)
					model.setIsCntr(isCntr[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeBookingContainerParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeBookingContainerParmVO[]
	 */
	public ChargeBookingContainerParmVO[] getChargeBookingContainerParmVOs(){
		ChargeBookingContainerParmVO[] vos = (ChargeBookingContainerParmVO[])models.toArray(new ChargeBookingContainerParmVO[models.size()]);
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
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isAftBkgCntr = this.isAftBkgCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsRhqCngFlg = this.ofcTrnsRhqCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlOfcCd = this.apvlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCntr = this.isCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
