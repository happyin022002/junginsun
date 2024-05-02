/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ResultOnTimeRatioVO.java
*@FileTitle : ResultOnTimeRatioVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.09.04 유혁 
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ResultOnTimeRatioVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ResultOnTimeRatioVO> models = new ArrayList<ResultOnTimeRatioVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String sum = null;
	/* Column Info */
	private String durRatio01 = null;
	/* Column Info */
	private String durRatio02 = null;
	/* Column Info */
	private String durRatio03 = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grpId = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlCall01 = null;
	/* Column Info */
	private String ttlCall02 = null;
	/* Column Info */
	private String ttlCall03 = null;
	/* Column Info */
	private String ontimeCall01 = null;
	/* Column Info */
	private String ontimeCall02 = null;
	/* Column Info */
	private String ontimeCall03 = null;
	/* Column Info */
	private String diffRat = null;
	/* Column Info */
	private String endDate2 = null;
	/* Column Info */
	private String startDate2 = null;
	/* Column Info */
	private String endDate1 = null;
	/* Column Info */
	private String startDate1 = null;
	/* Column Info */
	private String ontimeOpt = null;
	/* Column Info */
	private String delayOpt = null;
	/* Column Info */
	private String ratioOpt = null;
	/* Column Info */
	private String sumDate = null;
	/* Column Info */
	private String incDelVsl = null;
	
	/* Column Info */
	private String updUsrId = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ResultOnTimeRatioVO() {}

	public ResultOnTimeRatioVO(String ibflag, String pagerows, String grpId, String ttlCall01, String ontimeCall01, String durRatio01, String ttlCall02, String ttlCall03, String ontimeCall02, String ontimeCall03, String durRatio02, String durRatio03, String diffRat, String sum, String vslSlanCd, String vslCd, String vpsPortCd, String crrCd, String startDate1, String endDate1, String startDate2, String endDate2, String ontimeOpt, String delayOpt, String ratioOpt, String sumDate, String incDelVsl, String updUsrId) {
		this.vslCd = vslCd;
		this.crrCd = crrCd;
		this.sum = sum;
		this.durRatio01 = durRatio01;
		this.durRatio02 = durRatio02;
		this.durRatio03 = durRatio03;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.grpId = grpId;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.ttlCall01 = ttlCall01;
		this.ttlCall02 = ttlCall02;
		this.ttlCall03 = ttlCall03;
		this.ontimeCall01 = ontimeCall01;
		this.ontimeCall02 = ontimeCall02;
		this.ontimeCall03 = ontimeCall03;
		this.diffRat = diffRat;
		this.endDate2 = endDate2;
		this.startDate2 = startDate2;
		this.endDate1 = endDate1;
		this.startDate1 = startDate1;
		this.ontimeOpt = ontimeOpt;
		this.delayOpt = delayOpt;
		this.ratioOpt = ratioOpt;
		this.sumDate = sumDate;
		this.incDelVsl 	= incDelVsl;
		this.updUsrId 	= updUsrId;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("sum", getSum());
		this.hashColumns.put("dur_ratio01", getDurRatio01());
		this.hashColumns.put("dur_ratio02", getDurRatio02());
		this.hashColumns.put("dur_ratio03", getDurRatio03());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grp_id", getGrpId());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ontime_call01", getOntimeCall01());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_call01", getTtlCall01());
		this.hashColumns.put("ttl_call02", getTtlCall02());
		this.hashColumns.put("ttl_call03", getTtlCall03());
		this.hashColumns.put("ontime_call02", getOntimeCall02());
		this.hashColumns.put("ontime_call03", getOntimeCall03());
		this.hashColumns.put("diff_rat", getDiffRat());
		this.hashColumns.put("end_date2", getEndDate2());
		this.hashColumns.put("start_date2", getStartDate2());
		this.hashColumns.put("end_date1", getEndDate1());
		this.hashColumns.put("start_date1", getStartDate1());
		this.hashColumns.put("ontime_opt", getOntimeOpt());
		this.hashColumns.put("delay_opt", getDelayOpt());
		this.hashColumns.put("ratio_opt", getRatioOpt());
		this.hashColumns.put("sum_date", getSumDate());
		this.hashColumns.put("inc_del_vsl"	, getIncDelVsl	());
		this.hashColumns.put("upd_usr_id"	, getUpdUsrId	());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("sum", "sum");
		this.hashFields.put("dur_ratio01", "durRatio01");
		this.hashFields.put("dur_ratio02", "durRatio02");
		this.hashFields.put("dur_ratio03", "durRatio03");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grp_id", "grpId");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ontime_call01", "ontimeCall01");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_call01", "ttlCall01");
		this.hashFields.put("ttl_call02", "ttlCall02");
		this.hashFields.put("ttl_call03", "ttlCall03");
		this.hashFields.put("ontime_call02", "ontimeCall02");
		this.hashFields.put("ontime_call03", "ontimeCall03");
		this.hashFields.put("diff_rat", "diffRat");
		this.hashFields.put("end_date2", "endDate2");
		this.hashFields.put("start_date2", "startDate2");
		this.hashFields.put("end_date1", "endDate1");
		this.hashFields.put("start_date1", "startDate1");
		this.hashFields.put("ontime_opt", "ontimeOpt");
		this.hashFields.put("dalay_opt", "delayOpt");
		this.hashFields.put("ratio_opt", "ratioOpt");
		this.hashFields.put("sum_date", "sumDate");
		this.hashFields.put("inc_del_vsl"	, "incDelVsl"	);
		this.hashFields.put("upd_usr_id"	, "updUsrId"	);
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return sum
	 */
	public String getSum() {
		return this.sum;
	}
	
	/**
	 * Column Info
	 * @return durRatio01
	 */
	public String getDurRatio01() {
		return this.durRatio01;
	}
	
	/**
	 * Column Info
	 * @return durRatio02
	 */
	public String getDurRatio02() {
		return this.durRatio02;
	}
	
	/**
	 * Column Info
	 * @return durRatio03
	 */
	public String getDurRatio03() {
		return this.durRatio03;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return grpId
	 */
	public String getGrpId() {
		return this.grpId;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return ontimeCall01
	 */
	public String getOntimeCall01() {
		return this.ontimeCall01;
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
	 * @return ttlCall01
	 */
	public String getTtlCall01() {
		return this.ttlCall01;
	}
	
	/**
	 * Column Info
	 * @return ttlCall02
	 */
	public String getTtlCall02() {
		return this.ttlCall02;
	}
	
	/**
	 * Column Info
	 * @return ttlCall03
	 */
	public String getTtlCall03() {
		return this.ttlCall03;
	}
	
	/**
	 * Column Info
	 * @return ontimeCall02
	 */
	public String getOntimeCall02() {
		return this.ontimeCall02;
	}
	
	/**
	 * Column Info
	 * @return ontimeCall03
	 */
	public String getOntimeCall03() {
		return this.ontimeCall03;
	}
	
	/**
	 * Column Info
	 * @return diffRat
	 */
	public String getDiffRat() {
		return this.diffRat;
	}
	
	/**
	 * Column Info
	 * @return endDate2
	 */
	public String getEndDate2() {
		return this.endDate2;
	}
	
	/**
	 * Column Info
	 * @return startDate2
	 */
	public String getStartDate2() {
		return this.startDate2;
	}
	
	/**
	 * Column Info
	 * @return endDate1
	 */
	public String getEndDate1() {
		return this.endDate1;
	}
	
	/**
	 * Column Info
	 * @return startDate1
	 */
	public String getStartDate1() {
		return this.startDate1;
	}
	
	/**
	 * Column Info
	 * @return ontimeOpt
	 */
	public String getOntimeOpt() {
		return this.ontimeOpt;
	}
	
	/**
	 * Column Info
	 * @return delayOpt
	 */
	public String getDelayOpt() {
		return this.delayOpt;
	}
	
	/**
	 * Column Info
	 * @return ratioOpt
	 */
	public String getRatioOpt() {
		return this.ratioOpt;
	}
	
	/**
	 * Column Info
	 * @return sumDate
	 */
	public String getSumDate() {
		return this.sumDate;
	}
	
	/**
	 * Column Info
	 * @return incDelVsl
	 */
	public String getIncDelVsl() {
		return this.incDelVsl;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param sum
	 */
	public void setSum(String sum) {
		this.sum = sum;
	}
	
	/**
	 * Column Info
	 * @param durRatio01
	 */
	public void setDurRatio01(String durRatio01) {
		this.durRatio01 = durRatio01;
	}
	
	/**
	 * Column Info
	 * @param durRatio02
	 */
	public void setDurRatio02(String durRatio02) {
		this.durRatio02 = durRatio02;
	}
	
	/**
	 * Column Info
	 * @param durRatio03
	 */
	public void setDurRatio03(String durRatio03) {
		this.durRatio03 = durRatio03;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param grpId
	 */
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param ontimeCall01
	 */
	public void setOntimeCall01(String ontimeCall01) {
		this.ontimeCall01 = ontimeCall01;
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
	 * @param ttlCall01
	 */
	public void setTtlCall01(String ttlCall01) {
		this.ttlCall01 = ttlCall01;
	}
	
	/**
	 * Column Info
	 * @param ttlCall02
	 */
	public void setTtlCall02(String ttlCall02) {
		this.ttlCall02 = ttlCall02;
	}
	
	/**
	 * Column Info
	 * @param ttlCall03
	 */
	public void setTtlCall03(String ttlCall03) {
		this.ttlCall03 = ttlCall03;
	}
	
	/**
	 * Column Info
	 * @param ontimeCall02
	 */
	public void setOntimeCall02(String ontimeCall02) {
		this.ontimeCall02 = ontimeCall02;
	}
	
	/**
	 * Column Info
	 * @param ontimeCall03
	 */
	public void setOntimeCall03(String ontimeCall03) {
		this.ontimeCall03 = ontimeCall03;
	}
	
	/**
	 * Column Info
	 * @param diffRat
	 */
	public void setDiffRat(String diffRat) {
		this.diffRat = diffRat;
	}
	
	/**
	 * Column Info
	 * @param endDate2
	 */
	public void setEndDate2(String endDate2) {
		this.endDate2 = endDate2;
	}
	
	/**
	 * Column Info
	 * @param startDate2
	 */
	public void setStartDate2(String startDate2) {
		this.startDate2 = startDate2;
	}
	
	/**
	 * Column Info
	 * @param endDate1
	 */
	public void setEndDate1(String endDate1) {
		this.endDate1 = endDate1;
	}
	
	/**
	 * Column Info
	 * @param startDate1
	 */
	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}
	
	/**
	 * Column Info
	 * @param ontimeOpt
	 */
	public void setOntimeOpt(String ontimeOpt) {
		this.ontimeOpt = ontimeOpt;
	}
	
	/**
	 * Column Info
	 * @param delayOpt
	 */
	public void setDelayOpt(String delayOpt) {
		this.delayOpt = delayOpt;
	}
	
	/**
	 * Column Info
	 * @param ratioOpt
	 */
	public void setRatioOpt(String ratioOpt) {
		this.ratioOpt = ratioOpt;
	}
	
	/**
	 * Column Info
	 * @param sumDate
	 */
	public void setSumDate(String sumDate) {
		this.sumDate = sumDate;
	}
	
	/**
	 * Column Info
	 * @param incDelVsl
	 */
	public void setIncDelVsl(String incDelVsl) {
		this.incDelVsl = incDelVsl;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setSum(JSPUtil.getParameter(request, "sum", ""));
		setDurRatio01(JSPUtil.getParameter(request, "dur_ratio01", ""));
		setDurRatio02(JSPUtil.getParameter(request, "dur_ratio02", ""));
		setDurRatio03(JSPUtil.getParameter(request, "dur_ratio03", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrpId(JSPUtil.getParameter(request, "grp_id", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setOntimeCall01(JSPUtil.getParameter(request, "ontime_call01", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTtlCall01(JSPUtil.getParameter(request, "ttl_call01", ""));
		setTtlCall02(JSPUtil.getParameter(request, "ttl_call02", ""));
		setTtlCall03(JSPUtil.getParameter(request, "ttl_call03", ""));
		setOntimeCall02(JSPUtil.getParameter(request, "ontime_call02", ""));
		setOntimeCall03(JSPUtil.getParameter(request, "ontime_call03", ""));
		setDiffRat(JSPUtil.getParameter(request, "diff_rat", ""));
		setEndDate2(JSPUtil.getParameter(request, "end_date2", ""));
		setStartDate2(JSPUtil.getParameter(request, "start_date2", ""));
		setEndDate1(JSPUtil.getParameter(request, "end_date1", ""));
		setStartDate1(JSPUtil.getParameter(request, "start_date1", ""));
		setOntimeOpt(JSPUtil.getParameter(request, "ontime_opt", ""));
		setDelayOpt(JSPUtil.getParameter(request, "delay_opt", ""));
		setRatioOpt(JSPUtil.getParameter(request, "ratio_opt", ""));
		setSumDate(JSPUtil.getParameter(request, "sum_date", ""));
		setIncDelVsl(JSPUtil.getParameter(request, "inc_del_vsl", ""));
		setUpdUsrId	(JSPUtil.getParameter(request, "upd_usr_id"	, ""));
			
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ResultOnTimeRatioVO[]
	 */
	public ResultOnTimeRatioVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ResultOnTimeRatioVO[]
	 */
	public ResultOnTimeRatioVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ResultOnTimeRatioVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] sum = (JSPUtil.getParameter(request, prefix	+ "sum", length));
			String[] durRatio01 = (JSPUtil.getParameter(request, prefix	+ "dur_ratio01", length));
			String[] durRatio02 = (JSPUtil.getParameter(request, prefix	+ "dur_ratio02", length));
			String[] durRatio03 = (JSPUtil.getParameter(request, prefix	+ "dur_ratio03", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grpId = (JSPUtil.getParameter(request, prefix	+ "grp_id", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ontimeCall01 = (JSPUtil.getParameter(request, prefix	+ "ontime_call01", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlCall01 = (JSPUtil.getParameter(request, prefix	+ "ttl_call01", length));
			String[] ttlCall02 = (JSPUtil.getParameter(request, prefix	+ "ttl_call02", length));
			String[] ttlCall03 = (JSPUtil.getParameter(request, prefix	+ "ttl_call03", length));
			String[] ontimeCall02 = (JSPUtil.getParameter(request, prefix	+ "ontime_call02", length));
			String[] ontimeCall03 = (JSPUtil.getParameter(request, prefix	+ "ontime_call03", length));
			String[] diffRat = (JSPUtil.getParameter(request, prefix	+ "diff_rat", length));
			String[] endDate2 = (JSPUtil.getParameter(request, prefix	+ "end_date2", length));
			String[] startDate2 = (JSPUtil.getParameter(request, prefix	+ "start_date2", length));
			String[] endDate1 = (JSPUtil.getParameter(request, prefix	+ "end_date1", length));
			String[] startDate1 = (JSPUtil.getParameter(request, prefix	+ "start_date1", length));
			String[] ontimeOpt = (JSPUtil.getParameter(request, prefix	+ "ontime_opt", length));
			String[] delayOpt = (JSPUtil.getParameter(request, prefix	+ "delay_opt", length));
			String[] ratioOpt = (JSPUtil.getParameter(request, prefix	+ "ratio_opt", length));
			String[] sumDate = (JSPUtil.getParameter(request, prefix	+ "sum_date", length));
			String[] incDelVsl 	= (JSPUtil.getParameter(request, prefix	+ "inc_del_vsl"	, length));
			String[] updUsrId 	= (JSPUtil.getParameter(request, prefix	+ "upd_usr_id"	, length));
			
			for (int i = 0; i < length; i++) {
				model = new ResultOnTimeRatioVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (sum[i] != null)
					model.setSum(sum[i]);
				if (durRatio01[i] != null)
					model.setDurRatio01(durRatio01[i]);
				if (durRatio02[i] != null)
					model.setDurRatio02(durRatio02[i]);
				if (durRatio03[i] != null)
					model.setDurRatio03(durRatio03[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grpId[i] != null)
					model.setGrpId(grpId[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ontimeCall01[i] != null)
					model.setOntimeCall01(ontimeCall01[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlCall01[i] != null)
					model.setTtlCall01(ttlCall01[i]);
				if (ttlCall02[i] != null)
					model.setTtlCall02(ttlCall02[i]);
				if (ttlCall03[i] != null)
					model.setTtlCall03(ttlCall03[i]);
				if (ontimeCall02[i] != null)
					model.setOntimeCall02(ontimeCall02[i]);
				if (ontimeCall03[i] != null)
					model.setOntimeCall03(ontimeCall03[i]);
				if (diffRat[i] != null)
					model.setDiffRat(diffRat[i]);
				if (endDate2[i] != null)
					model.setEndDate2(endDate2[i]);
				if (startDate2[i] != null)
					model.setStartDate2(startDate2[i]);
				if (endDate1[i] != null)
					model.setEndDate1(endDate1[i]);
				if (startDate1[i] != null)
					model.setStartDate1(startDate1[i]);
				if (ontimeOpt[i] != null)
					model.setOntimeOpt(ontimeOpt[i]);
				if (delayOpt[i] != null)
					model.setDelayOpt(delayOpt[i]);
				if (ratioOpt[i] != null)
					model.setRatioOpt(ratioOpt[i]);
				if (sumDate[i] != null)
					model.setSumDate(sumDate[i]);
				if (incDelVsl[i] != null)
					model.setIncDelVsl(incDelVsl[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getResultOnTimeRatioVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ResultOnTimeRatioVO[]
	 */
	public ResultOnTimeRatioVO[] getResultOnTimeRatioVOs(){
		ResultOnTimeRatioVO[] vos = (ResultOnTimeRatioVO[])models.toArray(new ResultOnTimeRatioVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sum = this.sum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durRatio01 = this.durRatio01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durRatio02 = this.durRatio02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durRatio03 = this.durRatio03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpId = this.grpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontimeCall01 = this.ontimeCall01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCall01 = this.ttlCall01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCall02 = this.ttlCall02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCall03 = this.ttlCall03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontimeCall02 = this.ontimeCall02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontimeCall03 = this.ontimeCall03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRat = this.diffRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate2 = this.endDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDate2 = this.startDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate1 = this.endDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDate1 = this.startDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ontimeOpt = this.ontimeOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delayOpt = this.delayOpt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioOpt = this.ratioOpt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumDate = this.sumDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incDelVsl 	= this.incDelVsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId 	= this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
