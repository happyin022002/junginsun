/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEdiMsgVO.java
*@FileTitle : SearchEdiMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.23 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEdiMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchEdiMsgVO> models = new ArrayList<SearchEdiMsgVO>();

	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mvmtEdiRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pCntrno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mtyPlnNo = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String ediDate = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cntrFullStsCd = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String mvmtEdiSghtCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String pDate2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchEdiMsgVO() {}

	public SearchEdiMsgVO(String ibflag, String pagerows, String evntYdCd, String evntDt, String pDate1, String pDate2, String creLoclDt, String bkgNo, String blNo, String mtyPlnNo, String crntVslCd, String crntSkdVoyNo, String crntSkdDirCd, String ediMvmtStsCd, String ediGateIoCd, String cntrFullStsCd, String mvmtEdiSghtCd, String mvmtEdiRmk, String pCntrno, String checkDigit, String ediDate) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.ediGateIoCd = ediGateIoCd;
		this.checkDigit = checkDigit;
		this.crntSkdDirCd = crntSkdDirCd;
		this.blNo = blNo;
		this.mvmtEdiRmk = mvmtEdiRmk;
		this.pagerows = pagerows;
		this.pCntrno = pCntrno;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.mtyPlnNo = mtyPlnNo;
		this.evntYdCd = evntYdCd;
		this.ediDate = ediDate;
		this.creLoclDt = creLoclDt;
		this.cntrFullStsCd = cntrFullStsCd;
		this.crntVslCd = crntVslCd;
		this.mvmtEdiSghtCd = mvmtEdiSghtCd;
		this.evntDt = evntDt;
		this.pDate1 = pDate1;
		this.pDate2 = pDate2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("edi_date", getEdiDate());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("mvmt_edi_sght_cd", getMvmtEdiSghtCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("p_date2", getPDate2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("edi_date", "ediDate");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("mvmt_edi_sght_cd", "mvmtEdiSghtCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("p_date2", "pDate2");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return ediMvmtStsCd
	 */
	public String getEdiMvmtStsCd() {
		return this.ediMvmtStsCd;
	}

	/**
	 * Column Info
	 * @return ediGateIoCd
	 */
	public String getEdiGateIoCd() {
		return this.ediGateIoCd;
	}

	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}

	/**
	 * Column Info
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return mvmtEdiRmk
	 */
	public String getMvmtEdiRmk() {
		return this.mvmtEdiRmk;
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
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}

	/**
	 * Column Info
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}

	/**
	 * Column Info
	 * @return ediDate
	 */
	public String getEdiDate() {
		return this.ediDate;
	}

	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}

	/**
	 * Column Info
	 * @return cntrFullStsCd
	 */
	public String getCntrFullStsCd() {
		return this.cntrFullStsCd;
	}

	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}

	/**
	 * Column Info
	 * @return mvmtEdiSghtCd
	 */
	public String getMvmtEdiSghtCd() {
		return this.mvmtEdiSghtCd;
	}

	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}


	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param ediMvmtStsCd
	 */
	public void setEdiMvmtStsCd(String ediMvmtStsCd) {
		this.ediMvmtStsCd = ediMvmtStsCd;
	}

	/**
	 * Column Info
	 * @param ediGateIoCd
	 */
	public void setEdiGateIoCd(String ediGateIoCd) {
		this.ediGateIoCd = ediGateIoCd;
	}

	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	/**
	 * Column Info
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param mvmtEdiRmk
	 */
	public void setMvmtEdiRmk(String mvmtEdiRmk) {
		this.mvmtEdiRmk = mvmtEdiRmk;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}

	/**
	 * Column Info
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}

	/**
	 * Column Info
	 * @param ediDate
	 */
	public void setEdiDate(String ediDate) {
		this.ediDate = ediDate;
	}

	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}

	/**
	 * Column Info
	 * @param cntrFullStsCd
	 */
	public void setCntrFullStsCd(String cntrFullStsCd) {
		this.cntrFullStsCd = cntrFullStsCd;
	}

	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}

	/**
	 * Column Info
	 * @param mvmtEdiSghtCd
	 */
	public void setMvmtEdiSghtCd(String mvmtEdiSghtCd) {
		this.mvmtEdiSghtCd = mvmtEdiSghtCd;
	}

	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCrntSkdVoyNo(JSPUtil.getParameter(request, "crnt_skd_voy_no", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, "edi_mvmt_sts_cd", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, "edi_gate_io_cd", ""));
		setCheckDigit(JSPUtil.getParameter(request, "check_digit", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, "crnt_skd_dir_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request, "mvmt_edi_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPCntrno(JSPUtil.getParameter(request, "p_cntrno", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, "mty_pln_no", ""));
		setEvntYdCd(JSPUtil.getParameter(request, "evnt_yd_cd", ""));
		setEdiDate(JSPUtil.getParameter(request, "edi_date", ""));
		setCreLoclDt(JSPUtil.getParameter(request, "cre_locl_dt", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request, "cntr_full_sts_cd", ""));
		setCrntVslCd(JSPUtil.getParameter(request, "crnt_vsl_cd", ""));
		setMvmtEdiSghtCd(JSPUtil.getParameter(request, "mvmt_edi_sght_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdiMsgVO[]
	 */
	public SearchEdiMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchEdiMsgVO[]
	 */
	public SearchEdiMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEdiMsgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mvmtEdiRmk = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] ediDate = (JSPUtil.getParameter(request, prefix	+ "edi_date", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cntrFullStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_full_sts_cd", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] mvmtEdiSghtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_sght_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));

			for (int i = 0; i < length; i++) {
				model = new SearchEdiMsgVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mvmtEdiRmk[i] != null)
					model.setMvmtEdiRmk(mvmtEdiRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (ediDate[i] != null)
					model.setEdiDate(ediDate[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cntrFullStsCd[i] != null)
					model.setCntrFullStsCd(cntrFullStsCd[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (mvmtEdiSghtCd[i] != null)
					model.setMvmtEdiSghtCd(mvmtEdiSghtCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEdiMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEdiMsgVO[]
	 */
	public SearchEdiMsgVO[] getSearchEdiMsgVOs(){
		SearchEdiMsgVO[] vos = (SearchEdiMsgVO[])models.toArray(new SearchEdiMsgVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk = this.mvmtEdiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediDate = this.ediDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd = this.cntrFullStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiSghtCd = this.mvmtEdiSghtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
