/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForCompFirmInputVO.java
*@FileTitle : BkgListForCompFirmInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForCompFirmInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgListForCompFirmInputVO> models = new ArrayList<BkgListForCompFirmInputVO>();

	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String eBkgCreDt = null;
	/* Column Info */
	private String sBkgCreDt = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String vslPrePostCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCustCntCd = null;
	/* Column Info */
	private String fCustSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String repCmdt = null;
	/* Column Info */
	private String fCustNm = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String bkgStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgListForCompFirmInputVO() {}

	public BkgListForCompFirmInputVO(String ibflag, String pagerows, String bkgVvdCd, String vslPrePostCd, String polCd, String podCd, String repCmdt, String bkgOfcCd, String obSlsOfcCd, String sCustCntCd, String sCustSeq, String sCustNm, String fCustCntCd, String fCustSeq, String fCustNm, String bkgNo,  String sBkgCreDt, String eBkgCreDt, String bkgStsCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.eBkgCreDt = eBkgCreDt;
		this.sBkgCreDt = sBkgCreDt;
		this.sCustSeq = sCustSeq;
		this.sCustNm = sCustNm;
		this.sCustCntCd = sCustCntCd;
		this.vslPrePostCd = vslPrePostCd;
		this.pagerows = pagerows;
		this.fCustCntCd = fCustCntCd;
		this.fCustSeq = fCustSeq;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.repCmdt = repCmdt;
		this.fCustNm = fCustNm;
		this.obSlsOfcCd = obSlsOfcCd;
		this.bkgVvdCd = bkgVvdCd;
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("e_bkg_cre_dt", getEBkgCreDt());
		this.hashColumns.put("s_bkg_cre_dt", getSBkgCreDt());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("vsl_pre_post_cd", getVslPrePostCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());
		this.hashColumns.put("f_cust_seq", getFCustSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rep_cmdt", getRepCmdt());
		this.hashColumns.put("f_cust_nm", getFCustNm());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("e_bkg_cre_dt", "eBkgCreDt");
		this.hashFields.put("s_bkg_cre_dt", "sBkgCreDt");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("vsl_pre_post_cd", "vslPrePostCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
		this.hashFields.put("f_cust_seq", "fCustSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rep_cmdt", "repCmdt");
		this.hashFields.put("f_cust_nm", "fCustNm");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}

	/**
	 * Column Info
	 * @return eBkgCreDt
	 */
	public String getEBkgCreDt() {
		return this.eBkgCreDt;
	}

	/**
	 * Column Info
	 * @return sBkgCreDt
	 */
	public String getSBkgCreDt() {
		return this.sBkgCreDt;
	}

	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}

	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}

	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}

	/**
	 * Column Info
	 * @return vslPrePostCd
	 */
	public String getVslPrePostCd() {
		return this.vslPrePostCd;
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
	 * @return fCustCntCd
	 */
	public String getFCustCntCd() {
		return this.fCustCntCd;
	}

	/**
	 * Column Info
	 * @return fCustSeq
	 */
	public String getFCustSeq() {
		return this.fCustSeq;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return repCmdt
	 */
	public String getRepCmdt() {
		return this.repCmdt;
	}

	/**
	 * Column Info
	 * @return fCustNm
	 */
	public String getFCustNm() {
		return this.fCustNm;
	}

	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
	}

	/**
	 * Column Info
	 * @return bkgVvdCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}


	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}

	/**
	 * Column Info
	 * @param eBkgCreDt
	 */
	public void setEBkgCreDt(String eBkgCreDt) {
		this.eBkgCreDt = eBkgCreDt;
	}

	/**
	 * Column Info
	 * @param sBkgCreDt
	 */
	public void setSBkgCreDt(String sBkgCreDt) {
		this.sBkgCreDt = sBkgCreDt;
	}

	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}

	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}

	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}

	/**
	 * Column Info
	 * @param vslPrePostCd
	 */
	public void setVslPrePostCd(String vslPrePostCd) {
		this.vslPrePostCd = vslPrePostCd;
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
	 * @param fCustCntCd
	 */
	public void setFCustCntCd(String fCustCntCd) {
		this.fCustCntCd = fCustCntCd;
	}

	/**
	 * Column Info
	 * @param fCustSeq
	 */
	public void setFCustSeq(String fCustSeq) {
		this.fCustSeq = fCustSeq;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param repCmdt
	 */
	public void setRepCmdt(String repCmdt) {
		this.repCmdt = repCmdt;
	}

	/**
	 * Column Info
	 * @param fCustNm
	 */
	public void setFCustNm(String fCustNm) {
		this.fCustNm = fCustNm;
	}

	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
	}

	/**
	 * Column Info
	 * @param bkgVvdCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setEBkgCreDt(JSPUtil.getParameter(request, "e_bkg_cre_dt", ""));
		setSBkgCreDt(JSPUtil.getParameter(request, "s_bkg_cre_dt", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setVslPrePostCd(JSPUtil.getParameter(request, "vsl_pre_post_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFCustCntCd(JSPUtil.getParameter(request, "f_cust_cnt_cd", ""));
		setFCustSeq(JSPUtil.getParameter(request, "f_cust_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRepCmdt(JSPUtil.getParameter(request, "rep_cmdt", ""));
		setFCustNm(JSPUtil.getParameter(request, "f_cust_nm", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, "bkg_vvd_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForCompFirmInputVO[]
	 */
	public BkgListForCompFirmInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgListForCompFirmInputVO[]
	 */
	public BkgListForCompFirmInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForCompFirmInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd".trim(), length));
			String[] eBkgCreDt = (JSPUtil.getParameter(request, prefix	+ "e_bkg_cre_dt".trim(), length));
			String[] sBkgCreDt = (JSPUtil.getParameter(request, prefix	+ "s_bkg_cre_dt".trim(), length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq".trim(), length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm".trim(), length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd".trim(), length));
			String[] vslPrePostCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_post_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fCustCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd".trim(), length));
			String[] fCustSeq = (JSPUtil.getParameter(request, prefix	+ "f_cust_seq".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] repCmdt = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt".trim(), length));
			String[] fCustNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_nm".trim(), length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd".trim(), length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd".trim(), length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new BkgListForCompFirmInputVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (eBkgCreDt[i] != null)
					model.setEBkgCreDt(eBkgCreDt[i]);
				if (sBkgCreDt[i] != null)
					model.setSBkgCreDt(sBkgCreDt[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (vslPrePostCd[i] != null)
					model.setVslPrePostCd(vslPrePostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCustCntCd[i] != null)
					model.setFCustCntCd(fCustCntCd[i]);
				if (fCustSeq[i] != null)
					model.setFCustSeq(fCustSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (repCmdt[i] != null)
					model.setRepCmdt(repCmdt[i]);
				if (fCustNm[i] != null)
					model.setFCustNm(fCustNm[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForCompFirmInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForCompFirmInputVO[]
	 */
	public BkgListForCompFirmInputVO[] getBkgListForCompFirmInputVOs(){
		BkgListForCompFirmInputVO[] vos = (BkgListForCompFirmInputVO[])models.toArray(new BkgListForCompFirmInputVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBkgCreDt = this.eBkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgCreDt = this.sBkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePostCd = this.vslPrePostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCd = this.fCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeq = this.fCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdt = this.repCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustNm = this.fCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
