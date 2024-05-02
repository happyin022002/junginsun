/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgTroActCustExtVO.java
*@FileTitle : BkgTroActCustExtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.05.07 이남경
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0905 화면에서, Customer/EQ tab의 Detail그리드 Condition 및 조회목록 출력용 VO
 * @author 이남경
 * @since J2EE 1.5
 */

public class BkgTroActCustExtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgTroActCustExtVO> models = new ArrayList<BkgTroActCustExtVO>();

	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String troActCustKndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String troActRepSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String cntcFaxNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntcMphnNo = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actShprNm = null;
	/* Column Info */
	private String dorZipId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String troVndrSeq = null;
	/* Column Info */
	private String actShprAddr = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 기본생성자
	 */
	public BkgTroActCustExtVO() {}
	/**
	 * 생성자
	 */
	public BkgTroActCustExtVO(String ibflag, String pagerows, String troActCustKndCd, String troVndrSeq, String ofcCd, String troActRepSeq, String cntCd, String custSeq, String vndrSeq, String locCd, String znCd, String actShprNm, String actShprAddr, String cntcPsonNm, String cntcPhnNo, String cntcFaxNo, String cntcMphnNo, String cntcEml, String dorZipId, String diffRmk, String vndrLglEngNm, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.cntCd = cntCd;
		this.custSeq = custSeq;
		this.cntcEml = cntcEml;
		this.ofcCd = ofcCd;
		this.troActCustKndCd = troActCustKndCd;
		this.updUsrId = updUsrId;
		this.troActRepSeq = troActRepSeq;
		this.updDt = updDt;
		this.locCd = locCd;
		this.znCd = znCd;
		this.cntcFaxNo = cntcFaxNo;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.cntcPhnNo = cntcPhnNo;
		this.diffRmk = diffRmk;
		this.cntcMphnNo = cntcMphnNo;
		this.cntcPsonNm = cntcPsonNm;
		this.creDt = creDt;
		this.actShprNm = actShprNm;
		this.dorZipId = dorZipId;
		this.creUsrId = creUsrId;
		this.troVndrSeq = troVndrSeq;
		this.actShprAddr = actShprAddr;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("tro_act_cust_knd_cd", getTroActCustKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tro_act_rep_seq", getTroActRepSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("cntc_fax_no", getCntcFaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_shpr_nm", getActShprNm());
		this.hashColumns.put("dor_zip_id", getDorZipId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tro_vndr_seq", getTroVndrSeq());
		this.hashColumns.put("act_shpr_addr", getActShprAddr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("tro_act_cust_knd_cd", "troActCustKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tro_act_rep_seq", "troActRepSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cntc_fax_no", "cntcFaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("dor_zip_id", "dorZipId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tro_vndr_seq", "troVndrSeq");
		this.hashFields.put("act_shpr_addr", "actShprAddr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getCntCd() {
		return this.cntCd;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getCntcEml() {
		return this.cntcEml;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getTroActCustKndCd() {
		return this.troActCustKndCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getTroActRepSeq() {
		return this.troActRepSeq;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getZnCd() {
		return this.znCd;
	}
	public String getCntcFaxNo() {
		return this.cntcFaxNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
	}
	public String getDiffRmk() {
		return this.diffRmk;
	}
	public String getCntcMphnNo() {
		return this.cntcMphnNo;
	}
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getActShprNm() {
		return this.actShprNm;
	}
	public String getDorZipId() {
		return this.dorZipId;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getTroVndrSeq() {
		return this.troVndrSeq;
	}
	public String getActShprAddr() {
		return this.actShprAddr;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
		//this.cntCd=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
		//this.cntcEml=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setTroActCustKndCd(String troActCustKndCd) {
		this.troActCustKndCd = troActCustKndCd;
		//this.troActCustKndCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setTroActRepSeq(String troActRepSeq) {
		this.troActRepSeq = troActRepSeq;
		//this.troActRepSeq=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setZnCd(String znCd) {
		this.znCd = znCd;
		//this.znCd=true;
	}
	public void setCntcFaxNo(String cntcFaxNo) {
		this.cntcFaxNo = cntcFaxNo;
		//this.cntcFaxNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
		//this.vndrSeq=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
		//this.cntcPhnNo=true;
	}
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
		//this.diffRmk=true;
	}
	public void setCntcMphnNo(String cntcMphnNo) {
		this.cntcMphnNo = cntcMphnNo;
		//this.cntcMphnNo=true;
	}
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
		//this.cntcPsonNm=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setActShprNm(String actShprNm) {
		this.actShprNm = actShprNm;
		//this.actShprNm=true;
	}
	public void setDorZipId(String dorZipId) {
		this.dorZipId = dorZipId;
		//this.dorZipId=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setTroVndrSeq(String troVndrSeq) {
		this.troVndrSeq = troVndrSeq;
		//this.troVndrSeq=true;
	}
	public void setActShprAddr(String actShprAddr) {
		this.actShprAddr = actShprAddr;
		//this.actShprAddr=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}

	/**
	 * fromRequest
	 * @return void
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCntcEml(JSPUtil.getParameter(request, "cntc_eml", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTroActCustKndCd(JSPUtil.getParameter(request, "tro_act_cust_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTroActRepSeq(JSPUtil.getParameter(request, "tro_act_rep_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setZnCd(JSPUtil.getParameter(request, "zn_cd", ""));
		setCntcFaxNo(JSPUtil.getParameter(request, "cntc_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, "cntc_phn_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCntcMphnNo(JSPUtil.getParameter(request, "cntc_mphn_no", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setActShprNm(JSPUtil.getParameter(request, "act_shpr_nm", ""));
		setDorZipId(JSPUtil.getParameter(request, "dor_zip_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTroVndrSeq(JSPUtil.getParameter(request, "tro_vndr_seq", ""));
		setActShprAddr(JSPUtil.getParameter(request, "act_shpr_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}
	/**
	 * fromRequestGrid
	 * @return BkgTroActCustExtVO[]
	 */
	public BkgTroActCustExtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	/**
	 * fromRequestGrid
	 * @return BkgTroActCustExtVO[]
	 */
	public BkgTroActCustExtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTroActCustExtVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] troActCustKndCd = (JSPUtil.getParameter(request, prefix	+ "tro_act_cust_knd_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] troActRepSeq = (JSPUtil.getParameter(request, prefix	+ "tro_act_rep_seq".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd".trim(), length));
			String[] cntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_fax_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] cntcMphnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_mphn_no".trim(), length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] actShprNm = (JSPUtil.getParameter(request, prefix	+ "act_shpr_nm".trim(), length));
			String[] dorZipId = (JSPUtil.getParameter(request, prefix	+ "dor_zip_id".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] troVndrSeq = (JSPUtil.getParameter(request, prefix	+ "tro_vndr_seq".trim(), length));
			String[] actShprAddr = (JSPUtil.getParameter(request, prefix	+ "act_shpr_addr".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new BkgTroActCustExtVO();
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (troActCustKndCd[i] != null)
					model.setTroActCustKndCd(troActCustKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (troActRepSeq[i] != null)
					model.setTroActRepSeq(troActRepSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (cntcFaxNo[i] != null)
					model.setCntcFaxNo(cntcFaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntcMphnNo[i] != null)
					model.setCntcMphnNo(cntcMphnNo[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actShprNm[i] != null)
					model.setActShprNm(actShprNm[i]);
				if (dorZipId[i] != null)
					model.setDorZipId(dorZipId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (troVndrSeq[i] != null)
					model.setTroVndrSeq(troVndrSeq[i]);
				if (actShprAddr[i] != null)
					model.setActShprAddr(actShprAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTroActCustExtVOs();
	}
	/**
	 * getBkgTroActCustExtVOs
	 * @return BkgTroActCustExtVO[]
	 */
	public BkgTroActCustExtVO[] getBkgTroActCustExtVOs(){
		BkgTroActCustExtVO[] vos = (BkgTroActCustExtVO[])models.toArray(new BkgTroActCustExtVO[models.size()]);
		return vos;
	}
	/**
	 * toString
	 * @return String
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
		} catch (Exception e) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troActCustKndCd = this.troActCustKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troActRepSeq = this.troActRepSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcFaxNo = this.cntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo = this.cntcMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm = this.actShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorZipId = this.dorZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troVndrSeq = this.troVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr = this.actShprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
