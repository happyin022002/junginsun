/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSFoundAutoMGTVO.java
*@FileTitle : CHSFoundAutoMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.22 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSFoundAutoMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSFoundAutoMGTVO> models = new ArrayList<CHSFoundAutoMGTVO>();
	
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String mvmtsDt = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String stsEvntDt = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sysSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSFoundAutoMGTVO() {}

	public CHSFoundAutoMGTVO(String ibflag, String pagerows, String delChk, String stsEvntOfcCd, String mvmtsDt, String location, String vndrLglEngNm, String stsEvntYdCd, String agmtLstmCd,  String eqTpszCd, String creUsrId,  String sccCd, String eqNo, String eqAsetStsCd, String vndrSeq, String chssMvmtStsCd, String mvmtDt, String stsEvntDt, String updUsrId, String sysSeq) {
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.mvmtsDt = mvmtsDt;
		this.location = location;
		this.vndrLglEngNm = vndrLglEngNm;
		this.stsEvntYdCd = stsEvntYdCd;
		this.agmtLstmCd = agmtLstmCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.delChk = delChk;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.sccCd = sccCd;
		this.eqNo = eqNo;
		this.eqAsetStsCd = eqAsetStsCd;
		this.vndrSeq = vndrSeq;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.stsEvntDt = stsEvntDt;
		this.mvmtDt = mvmtDt;
		this.updUsrId = updUsrId;
		this.sysSeq = sysSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("mvmts_dt", getMvmtsDt());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sys_seq", getSysSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("mvmts_dt", "mvmtsDt");
		this.hashFields.put("location", "location");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sys_seq", "sysSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsEvntOfcCd
	 */
	public String getStsEvntOfcCd() {
		return this.stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtsDt
	 */
	public String getMvmtsDt() {
		return this.mvmtsDt;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
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
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDt
	 */
	public String getStsEvntDt() {
		return this.stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return sysSeq
	 */
	public String getSysSeq() {
		return this.sysSeq;
	}
	

	/**
	 * Column Info
	 * @param stsEvntOfcCd
	 */
	public void setStsEvntOfcCd(String stsEvntOfcCd) {
		this.stsEvntOfcCd = stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtsDt
	 */
	public void setMvmtsDt(String mvmtsDt) {
		this.mvmtsDt = mvmtsDt;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
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
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDt
	 */
	public void setStsEvntDt(String stsEvntDt) {
		this.stsEvntDt = stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param sysSeq
	 */
	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setMvmtsDt(JSPUtil.getParameter(request, "mvmts_dt", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setStsEvntDt(JSPUtil.getParameter(request, "sts_evnt_dt", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSysSeq(JSPUtil.getParameter(request, "sys_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSFoundAutoMGTVO[]
	 */
	public CHSFoundAutoMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSFoundAutoMGTVO[]
	 */
	public CHSFoundAutoMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSFoundAutoMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] mvmtsDt = (JSPUtil.getParameter(request, prefix	+ "mvmts_dt", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] stsEvntDt = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sysSeq = (JSPUtil.getParameter(request, prefix	+ "sys_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSFoundAutoMGTVO();
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (mvmtsDt[i] != null)
					model.setMvmtsDt(mvmtsDt[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (stsEvntDt[i] != null)
					model.setStsEvntDt(stsEvntDt[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sysSeq[i] != null)
					model.setSysSeq(sysSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSFoundAutoMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSFoundAutoMGTVO[]
	 */
	public CHSFoundAutoMGTVO[] getCHSFoundAutoMGTVOs(){
		CHSFoundAutoMGTVO[] vos = (CHSFoundAutoMGTVO[])models.toArray(new CHSFoundAutoMGTVO[models.size()]);
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
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtsDt = this.mvmtsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt = this.stsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq = this.sysSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
