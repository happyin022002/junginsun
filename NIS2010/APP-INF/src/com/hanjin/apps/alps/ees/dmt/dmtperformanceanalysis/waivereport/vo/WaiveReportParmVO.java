/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportParmVO.java
*@FileTitle : WaiveReportParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.21 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WaiveReportParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WaiveReportParmVO> models = new ArrayList<WaiveReportParmVO>();
	
	/* Column Info */
	private String ofcCd2 = null;
	/* Column Info */
	private String slctofccd = null;
	/* Column Info */
	private String toMvmtMon = null;
	/* Column Info */
	private String slctscno = null;
	/* Column Info */
	private String office2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slctrfano = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String dtFlg = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String ofcFlg2 = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String slcttrfcd = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String tariffType = null;
	/* Column Info */
	private String reqapp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WaiveReportParmVO() {}

	public WaiveReportParmVO(String ibflag, String pagerows, String dtFlg, String toMvmtMon, String fmDt, String toDt, String startDt, String endDt, String tariffType, String dmdtTrfCd, String ofcFlg, String office, String ofcCd, String reqapp, String ofcFlg2, String office2, String ofcCd2, String grpFlg, String currFlg, String cntrType, String dmdtCntrTpCd, String slctofccd, String slcttrfcd, String slctscno, String slctrfano) {
		this.ofcCd2 = ofcCd2;
		this.slctofccd = slctofccd;
		this.toMvmtMon = toMvmtMon;
		this.slctscno = slctscno;
		this.office2 = office2;
		this.pagerows = pagerows;
		this.currFlg = currFlg;
		this.ibflag = ibflag;
		this.slctrfano = slctrfano;
		this.startDt = startDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.office = office;
		this.dtFlg = dtFlg;
		this.fmDt = fmDt;
		this.endDt = endDt;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.ofcFlg2 = ofcFlg2;
		this.cntrType = cntrType;
		this.ofcFlg = ofcFlg;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.slcttrfcd = slcttrfcd;
		this.grpFlg = grpFlg;
		this.tariffType = tariffType;
		this.reqapp = reqapp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd2", getOfcCd2());
		this.hashColumns.put("slctofccd", getSlctofccd());
		this.hashColumns.put("to_mvmt_mon", getToMvmtMon());
		this.hashColumns.put("slctscno", getSlctscno());
		this.hashColumns.put("office2", getOffice2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("curr_flg", getCurrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slctrfano", getSlctrfano());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("dt_flg", getDtFlg());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("ofc_flg2", getOfcFlg2());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("slcttrfcd", getSlcttrfcd());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("tariff_type", getTariffType());
		this.hashColumns.put("reqapp", getReqapp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd2", "ofcCd2");
		this.hashFields.put("slctofccd", "slctofccd");
		this.hashFields.put("to_mvmt_mon", "toMvmtMon");
		this.hashFields.put("slctscno", "slctscno");
		this.hashFields.put("office2", "office2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("curr_flg", "currFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slctrfano", "slctrfano");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("office", "office");
		this.hashFields.put("dt_flg", "dtFlg");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("ofc_flg2", "ofcFlg2");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("slcttrfcd", "slcttrfcd");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("tariff_type", "tariffType");
		this.hashFields.put("reqapp", "reqapp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd2
	 */
	public String getOfcCd2() {
		return this.ofcCd2;
	}
	
	/**
	 * Column Info
	 * @return slctofccd
	 */
	public String getSlctofccd() {
		return this.slctofccd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtMon
	 */
	public String getToMvmtMon() {
		return this.toMvmtMon;
	}
	
	/**
	 * Column Info
	 * @return slctscno
	 */
	public String getSlctscno() {
		return this.slctscno;
	}
	
	/**
	 * Column Info
	 * @return office2
	 */
	public String getOffice2() {
		return this.office2;
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
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
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
	 * @return slctrfano
	 */
	public String getSlctrfano() {
		return this.slctrfano;
	}
	
	/**
	 * Column Info
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
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
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return dtFlg
	 */
	public String getDtFlg() {
		return this.dtFlg;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg2
	 */
	public String getOfcFlg2() {
		return this.ofcFlg2;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return slcttrfcd
	 */
	public String getSlcttrfcd() {
		return this.slcttrfcd;
	}
	
	/**
	 * Column Info
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return tariffType
	 */
	public String getTariffType() {
		return this.tariffType;
	}
	
	/**
	 * Column Info
	 * @return reqapp
	 */
	public String getReqapp() {
		return this.reqapp;
	}
	

	/**
	 * Column Info
	 * @param ofcCd2
	 */
	public void setOfcCd2(String ofcCd2) {
		this.ofcCd2 = ofcCd2;
	}
	
	/**
	 * Column Info
	 * @param slctofccd
	 */
	public void setSlctofccd(String slctofccd) {
		this.slctofccd = slctofccd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtMon
	 */
	public void setToMvmtMon(String toMvmtMon) {
		this.toMvmtMon = toMvmtMon;
	}
	
	/**
	 * Column Info
	 * @param slctscno
	 */
	public void setSlctscno(String slctscno) {
		this.slctscno = slctscno;
	}
	
	/**
	 * Column Info
	 * @param office2
	 */
	public void setOffice2(String office2) {
		this.office2 = office2;
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
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
	 * @param slctrfano
	 */
	public void setSlctrfano(String slctrfano) {
		this.slctrfano = slctrfano;
	}
	
	/**
	 * Column Info
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param dtFlg
	 */
	public void setDtFlg(String dtFlg) {
		this.dtFlg = dtFlg;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg2
	 */
	public void setOfcFlg2(String ofcFlg2) {
		this.ofcFlg2 = ofcFlg2;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param slcttrfcd
	 */
	public void setSlcttrfcd(String slcttrfcd) {
		this.slcttrfcd = slcttrfcd;
	}
	
	/**
	 * Column Info
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param tariffType
	 */
	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}
	
	/**
	 * Column Info
	 * @param reqapp
	 */
	public void setReqapp(String reqapp) {
		this.reqapp = reqapp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd2(JSPUtil.getParameter(request, "ofc_cd2", ""));
		setSlctofccd(JSPUtil.getParameter(request, "slctofccd", ""));
		setToMvmtMon(JSPUtil.getParameter(request, "to_mvmt_mon", ""));
		setSlctscno(JSPUtil.getParameter(request, "slctscno", ""));
		setOffice2(JSPUtil.getParameter(request, "office2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCurrFlg(JSPUtil.getParameter(request, "curr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlctrfano(JSPUtil.getParameter(request, "slctrfano", ""));
		setStartDt(JSPUtil.getParameter(request, "start_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setDtFlg(JSPUtil.getParameter(request, "dt_flg", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setOfcFlg2(JSPUtil.getParameter(request, "ofc_flg2", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setOfcFlg(JSPUtil.getParameter(request, "ofc_flg", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSlcttrfcd(JSPUtil.getParameter(request, "slcttrfcd", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setTariffType(JSPUtil.getParameter(request, "tariff_type", ""));
		setReqapp(JSPUtil.getParameter(request, "reqapp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WaiveReportParmVO[]
	 */
	public WaiveReportParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WaiveReportParmVO[]
	 */
	public WaiveReportParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WaiveReportParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd2 = (JSPUtil.getParameter(request, prefix	+ "ofc_cd2", length));
			String[] slctofccd = (JSPUtil.getParameter(request, prefix	+ "slctofccd", length));
			String[] toMvmtMon = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_mon", length));
			String[] slctscno = (JSPUtil.getParameter(request, prefix	+ "slctscno", length));
			String[] office2 = (JSPUtil.getParameter(request, prefix	+ "office2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slctrfano = (JSPUtil.getParameter(request, prefix	+ "slctrfano", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] dtFlg = (JSPUtil.getParameter(request, prefix	+ "dt_flg", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] ofcFlg2 = (JSPUtil.getParameter(request, prefix	+ "ofc_flg2", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] slcttrfcd = (JSPUtil.getParameter(request, prefix	+ "slcttrfcd", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] tariffType = (JSPUtil.getParameter(request, prefix	+ "tariff_type", length));
			String[] reqapp = (JSPUtil.getParameter(request, prefix	+ "reqapp", length));
			
			for (int i = 0; i < length; i++) {
				model = new WaiveReportParmVO();
				if (ofcCd2[i] != null)
					model.setOfcCd2(ofcCd2[i]);
				if (slctofccd[i] != null)
					model.setSlctofccd(slctofccd[i]);
				if (toMvmtMon[i] != null)
					model.setToMvmtMon(toMvmtMon[i]);
				if (slctscno[i] != null)
					model.setSlctscno(slctscno[i]);
				if (office2[i] != null)
					model.setOffice2(office2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slctrfano[i] != null)
					model.setSlctrfano(slctrfano[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (dtFlg[i] != null)
					model.setDtFlg(dtFlg[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (ofcFlg2[i] != null)
					model.setOfcFlg2(ofcFlg2[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (slcttrfcd[i] != null)
					model.setSlcttrfcd(slcttrfcd[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (tariffType[i] != null)
					model.setTariffType(tariffType[i]);
				if (reqapp[i] != null)
					model.setReqapp(reqapp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWaiveReportParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WaiveReportParmVO[]
	 */
	public WaiveReportParmVO[] getWaiveReportParmVOs(){
		WaiveReportParmVO[] vos = (WaiveReportParmVO[])models.toArray(new WaiveReportParmVO[models.size()]);
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
		this.ofcCd2 = this.ofcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctofccd = this.slctofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtMon = this.toMvmtMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctscno = this.slctscno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office2 = this.office2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctrfano = this.slctrfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtFlg = this.dtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg2 = this.ofcFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slcttrfcd = this.slcttrfcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffType = this.tariffType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqapp = this.reqapp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
