/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeTransferParmVO.java
*@FileTitle : OfficeTransferParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.23 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeTransferParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeTransferParmVO> models = new ArrayList<OfficeTransferParmVO>();
	
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fmCreDt = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String toSvrId = null;
	/* Column Info */
	private String fmRhq = null;
	/* Column Info */
	private String trnsRsn = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String toCreDt = null;
	/* Column Info */
	private String toRhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeTransferParmVO() {}

	public OfficeTransferParmVO(String ibflag, String pagerows, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String dmdtChgStsCd, String fmCreDt, String toCreDt, String fmRhq, String toRhq, String fmOfcCd, String toOfcCd, String condType, String bkgNo, String blNo, String trnsRsn, String toSvrId) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fmCreDt = fmCreDt;
		this.cntrCycNo = cntrCycNo;
		this.chgSeq = chgSeq;
		this.fmOfcCd = fmOfcCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.condType = condType;
		this.svrId = svrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.cntrNo = cntrNo;
		this.toOfcCd = toOfcCd;
		this.toSvrId = toSvrId;
		this.fmRhq = fmRhq;
		this.trnsRsn = trnsRsn;
		this.dmdtTrfCd = dmdtTrfCd;
		this.toCreDt = toCreDt;
		this.toRhq = toRhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("fm_cre_dt", getFmCreDt());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("to_svr_id", getToSvrId());
		this.hashColumns.put("fm_rhq", getFmRhq());
		this.hashColumns.put("trns_rsn", getTrnsRsn());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("to_cre_dt", getToCreDt());
		this.hashColumns.put("to_rhq", getToRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("fm_cre_dt", "fmCreDt");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("to_svr_id", "toSvrId");
		this.hashFields.put("fm_rhq", "fmRhq");
		this.hashFields.put("trns_rsn", "trnsRsn");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("to_cre_dt", "toCreDt");
		this.hashFields.put("to_rhq", "toRhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmCreDt
	 */
	public String getFmCreDt() {
		return this.fmCreDt;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return fmOfcCd
	 */
	public String getFmOfcCd() {
		return this.fmOfcCd;
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
	 * @return condType
	 */
	public String getCondType() {
		return this.condType;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
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
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toSvrId
	 */
	public String getToSvrId() {
		return this.toSvrId;
	}
	
	/**
	 * Column Info
	 * @return fmRhq
	 */
	public String getFmRhq() {
		return this.fmRhq;
	}
	
	/**
	 * Column Info
	 * @return trnsRsn
	 */
	public String getTrnsRsn() {
		return this.trnsRsn;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return toCreDt
	 */
	public String getToCreDt() {
		return this.toCreDt;
	}
	
	/**
	 * Column Info
	 * @return toRhq
	 */
	public String getToRhq() {
		return this.toRhq;
	}
	

	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmCreDt
	 */
	public void setFmCreDt(String fmCreDt) {
		this.fmCreDt = fmCreDt;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param fmOfcCd
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
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
	 * @param condType
	 */
	public void setCondType(String condType) {
		this.condType = condType;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
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
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toSvrId
	 */
	public void setToSvrId(String toSvrId) {
		this.toSvrId = toSvrId;
	}
	
	/**
	 * Column Info
	 * @param fmRhq
	 */
	public void setFmRhq(String fmRhq) {
		this.fmRhq = fmRhq;
	}
	
	/**
	 * Column Info
	 * @param trnsRsn
	 */
	public void setTrnsRsn(String trnsRsn) {
		this.trnsRsn = trnsRsn;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param toCreDt
	 */
	public void setToCreDt(String toCreDt) {
		this.toCreDt = toCreDt;
	}
	
	/**
	 * Column Info
	 * @param toRhq
	 */
	public void setToRhq(String toRhq) {
		this.toRhq = toRhq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setFmCreDt(JSPUtil.getParameter(request, "fm_cre_dt", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCondType(JSPUtil.getParameter(request, "cond_type", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setToSvrId(JSPUtil.getParameter(request, "to_svr_id", ""));
		setFmRhq(JSPUtil.getParameter(request, "fm_rhq", ""));
		setTrnsRsn(JSPUtil.getParameter(request, "trns_rsn", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setToCreDt(JSPUtil.getParameter(request, "to_cre_dt", ""));
		setToRhq(JSPUtil.getParameter(request, "to_rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeTransferParmVO[]
	 */
	public OfficeTransferParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeTransferParmVO[]
	 */
	public OfficeTransferParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeTransferParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fmCreDt = (JSPUtil.getParameter(request, prefix	+ "fm_cre_dt", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] toSvrId = (JSPUtil.getParameter(request, prefix	+ "to_svr_id", length));
			String[] fmRhq = (JSPUtil.getParameter(request, prefix	+ "fm_rhq", length));
			String[] trnsRsn = (JSPUtil.getParameter(request, prefix	+ "trns_rsn", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] toCreDt = (JSPUtil.getParameter(request, prefix	+ "to_cre_dt", length));
			String[] toRhq = (JSPUtil.getParameter(request, prefix	+ "to_rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeTransferParmVO();
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fmCreDt[i] != null)
					model.setFmCreDt(fmCreDt[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (toSvrId[i] != null)
					model.setToSvrId(toSvrId[i]);
				if (fmRhq[i] != null)
					model.setFmRhq(fmRhq[i]);
				if (trnsRsn[i] != null)
					model.setTrnsRsn(trnsRsn[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (toCreDt[i] != null)
					model.setToCreDt(toCreDt[i]);
				if (toRhq[i] != null)
					model.setToRhq(toRhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeTransferParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeTransferParmVO[]
	 */
	public OfficeTransferParmVO[] getOfficeTransferParmVOs(){
		OfficeTransferParmVO[] vos = (OfficeTransferParmVO[])models.toArray(new OfficeTransferParmVO[models.size()]);
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
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCreDt = this.fmCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSvrId = this.toSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRhq = this.fmRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRsn = this.trnsRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCreDt = this.toCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRhq = this.toRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
