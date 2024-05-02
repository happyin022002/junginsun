/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmRestuffingDetailVO.java
*@FileTitle : CtmRestuffingDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.17 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo;

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
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmRestuffingDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmRestuffingDetailVO> models = new ArrayList<CtmRestuffingDetailVO>();
	
	/* Column Info */
	private String resonCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String vvdNo = null;
	/* Column Info */
	private String xchRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String saveFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String orgYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CtmRestuffingDetailVO() {}

	public CtmRestuffingDetailVO(String ibflag, String pagerows, String cntrNo, String checkDigit, String cntrTpszCd, String cntrSealNo, String chssNo, String mvmtStsCd, String vvdNo, String bkgNo, String cnmvIdNo, String cnmvYr, String resonCd, String orgYdCd, String saveFlg, String xchRmk, String cnmvEvntDt) {
		this.resonCd = resonCd;
		this.chssNo = chssNo;
		this.checkDigit = checkDigit;
		this.cnmvEvntDt = cnmvEvntDt;
		this.vvdNo = vvdNo;
		this.xchRmk = xchRmk;
		this.pagerows = pagerows;
		this.cnmvIdNo = cnmvIdNo;
		this.saveFlg = saveFlg;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrSealNo = cntrSealNo;
		this.cnmvYr = cnmvYr;
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("reson_cd", getResonCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("vvd_no", getVvdNo());
		this.hashColumns.put("xch_rmk", getXchRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("save_flg", getSaveFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("reson_cd", "resonCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("vvd_no", "vvdNo");
		this.hashFields.put("xch_rmk", "xchRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("save_flg", "saveFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("org_yd_cd", "orgYd_Cd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return resonCd
	 */
	public String getResonCd() {
		return this.resonCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return vvdNo
	 */
	public String getVvdNo() {
		return this.vvdNo;
	}
	
	/**
	 * Column Info
	 * @return xchRmk
	 */
	public String getXchRmk() {
		return this.xchRmk;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return saveFlg
	 */
	public String getSaveFlg() {
		return this.saveFlg;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	

	/**
	 * Column Info
	 * @param resonCd
	 */
	public void setResonCd(String resonCd) {
		this.resonCd = resonCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param vvdNo
	 */
	public void setVvdNo(String vvdNo) {
		this.vvdNo = vvdNo;
	}
	
	/**
	 * Column Info
	 * @param xchRmk
	 */
	public void setXchRmk(String xchRmk) {
		this.xchRmk = xchRmk;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param saveFlg
	 */
	public void setSaveFlg(String saveFlg) {
		this.saveFlg = saveFlg;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResonCd(JSPUtil.getParameter(request, "reson_cd", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, "check_digit", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setVvdNo(JSPUtil.getParameter(request, "vvd_no", ""));
		setXchRmk(JSPUtil.getParameter(request, "xch_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setSaveFlg(JSPUtil.getParameter(request, "save_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmRestuffingDetailVO[]
	 */
	public CtmRestuffingDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmRestuffingDetailVO[]
	 */
	public CtmRestuffingDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmRestuffingDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] resonCd = (JSPUtil.getParameter(request, prefix	+ "reson_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] vvdNo = (JSPUtil.getParameter(request, prefix	+ "vvd_no", length));
			String[] xchRmk = (JSPUtil.getParameter(request, prefix	+ "xch_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] saveFlg = (JSPUtil.getParameter(request, prefix	+ "save_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmRestuffingDetailVO();
				if (resonCd[i] != null)
					model.setResonCd(resonCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (vvdNo[i] != null)
					model.setVvdNo(vvdNo[i]);
				if (xchRmk[i] != null)
					model.setXchRmk(xchRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (saveFlg[i] != null)
					model.setSaveFlg(saveFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmRestuffingDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmRestuffingDetailVO[]
	 */
	public CtmRestuffingDetailVO[] getCtmRestuffingDetailVOs(){
		CtmRestuffingDetailVO[] vos = (CtmRestuffingDetailVO[])models.toArray(new CtmRestuffingDetailVO[models.size()]);
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
		this.resonCd = this.resonCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNo = this.vvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRmk = this.xchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlg = this.saveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
