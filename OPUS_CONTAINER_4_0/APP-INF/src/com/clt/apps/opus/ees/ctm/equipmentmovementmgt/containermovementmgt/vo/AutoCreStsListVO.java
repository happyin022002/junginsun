/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GetAutoCreStsListVO.java
*@FileTitle : GetAutoCreStsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoCreStsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoCreStsListVO> models = new ArrayList<AutoCreStsListVO>();
	
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String cnmvId = null;
	/* Column Info */
	private String locType = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String preEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String preYdCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tarDate = null;
	/* Column Info */
	private String preSts = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String creTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mtyPlnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoCreStsListVO() {}

	public AutoCreStsListVO(String ibflag, String pagerows, String stsCd, String cntrNo, String tpSz, String ydCd, String tarDate, String creDt, String preSts, String preYdCd, String preEvntDt, String mvmtCreTpCd, String cnmvYr, String cnmvId, String locType, String locCd, String creTpCd, String pDate1, String pDate2, String mvmtStsCd, String updUsrId, String ofcCd, String usrNm, String eventDt, String bkgNo, String mtyPlnNo) {
		this.tpSz = tpSz;
		this.cnmvId = cnmvId;
		this.locType = locType;
		this.creDt = creDt;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.preEvntDt = preEvntDt;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.preYdCd = preYdCd;
		this.mvmtStsCd = mvmtStsCd;
		this.pDate1 = pDate1;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.pDate2 = pDate2;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.tarDate = tarDate;
		this.preSts = preSts;
		this.cnmvYr = cnmvYr;
		this.creTpCd = creTpCd;
		this.updUsrId = updUsrId;
		this.ofcCd = ofcCd;
		this.usrNm = usrNm;
		this.eventDt = eventDt;
		this.bkgNo = bkgNo;
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("cnmv_id", getCnmvId());
		this.hashColumns.put("loc_type", getLocType());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("pre_evnt_dt", getPreEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("pre_yd_cd", getPreYdCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tar_date", getTarDate());
		this.hashColumns.put("pre_sts", getPreSts());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cre_tp_cd", getCreTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("cnmv_id", "cnmvId");
		this.hashFields.put("loc_type", "locType");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("pre_evnt_dt", "preEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("pre_yd_cd", "preYdCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tar_date", "tarDate");
		this.hashFields.put("pre_sts", "preSts");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cre_tp_cd", "creTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
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
	 * @return cnmvId
	 */
	public String getCnmvId() {
		return this.cnmvId;
	}
	
	/**
	 * Column Info
	 * @return locType
	 */
	public String getLocType() {
		return this.locType;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return preEvntDt
	 */
	public String getPreEvntDt() {
		return this.preEvntDt;
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
	 * @return preYdCd
	 */
	public String getPreYdCd() {
		return this.preYdCd;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return tarDate
	 */
	public String getTarDate() {
		return this.tarDate;
	}
	
	/**
	 * Column Info
	 * @return preSts
	 */
	public String getPreSts() {
		return this.preSts;
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
	 * @return creTpCd
	 */
	public String getCreTpCd() {
		return this.creTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}

	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
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
	 * @param cnmvId
	 */
	public void setCnmvId(String cnmvId) {
		this.cnmvId = cnmvId;
	}
	
	/**
	 * Column Info
	 * @param locType
	 */
	public void setLocType(String locType) {
		this.locType = locType;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param preEvntDt
	 */
	public void setPreEvntDt(String preEvntDt) {
		this.preEvntDt = preEvntDt;
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
	 * @param preYdCd
	 */
	public void setPreYdCd(String preYdCd) {
		this.preYdCd = preYdCd;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param tarDate
	 */
	public void setTarDate(String tarDate) {
		this.tarDate = tarDate;
	}
	
	/**
	 * Column Info
	 * @param preSts
	 */
	public void setPreSts(String preSts) {
		this.preSts = preSts;
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
	 * @param creTpCd
	 */
	public void setCreTpCd(String creTpCd) {
		this.creTpCd = creTpCd;
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
	 * @param cnmvId
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * Column Info
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setCnmvId(JSPUtil.getParameter(request, prefix + "cnmv_id", ""));
		setLocType(JSPUtil.getParameter(request, prefix + "loc_type", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setPreEvntDt(JSPUtil.getParameter(request, prefix + "pre_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setPreYdCd(JSPUtil.getParameter(request, prefix + "pre_yd_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTarDate(JSPUtil.getParameter(request, prefix + "tar_date", ""));
		setPreSts(JSPUtil.getParameter(request, prefix + "pre_sts", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCreTpCd(JSPUtil.getParameter(request, prefix + "cre_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetAutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetAutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoCreStsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] cnmvId = (JSPUtil.getParameter(request, prefix	+ "cnmv_id", length));
			String[] locType = (JSPUtil.getParameter(request, prefix	+ "loc_type", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] preEvntDt = (JSPUtil.getParameter(request, prefix	+ "pre_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] preYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_yd_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tarDate = (JSPUtil.getParameter(request, prefix	+ "tar_date", length));
			String[] preSts = (JSPUtil.getParameter(request, prefix	+ "pre_sts", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] creTpCd = (JSPUtil.getParameter(request, prefix	+ "cre_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoCreStsListVO();
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (cnmvId[i] != null)
					model.setCnmvId(cnmvId[i]);
				if (locType[i] != null)
					model.setLocType(locType[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (preEvntDt[i] != null)
					model.setPreEvntDt(preEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (preYdCd[i] != null)
					model.setPreYdCd(preYdCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tarDate[i] != null)
					model.setTarDate(tarDate[i]);
				if (preSts[i] != null)
					model.setPreSts(preSts[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (creTpCd[i] != null)
					model.setCreTpCd(creTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetAutoCreStsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetAutoCreStsListVO[]
	 */
	public AutoCreStsListVO[] getGetAutoCreStsListVOs(){
		AutoCreStsListVO[] vos = (AutoCreStsListVO[])models.toArray(new AutoCreStsListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvId = this.cnmvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locType = this.locType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEvntDt = this.preEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preYdCd = this.preYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tarDate = this.tarDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSts = this.preSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTpCd = this.creTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
