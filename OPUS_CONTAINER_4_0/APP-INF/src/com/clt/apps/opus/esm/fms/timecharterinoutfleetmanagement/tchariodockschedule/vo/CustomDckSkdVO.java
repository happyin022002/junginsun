/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomDckSkdVO.java
*@FileTitle : CustomDckSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo;

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

public class CustomDckSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomDckSkdVO> models = new ArrayList<CustomDckSkdVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dckDurDys = null;
	/* Column Info */
	private String dckFmDtTime = null;
	/* Column Info */
	private String phsOutPortCd = null;
	/* Column Info */
	private String fletDckSveyTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ydSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String phsOutDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shpYdNm = null;
	/* Column Info */
	private String fletDckStsCd = null;
	/* Column Info */
	private String dckSelCd = null;
	/* Column Info */
	private String dckDurDysDays = null;
	/* Column Info */
	private String dckToDtTime = null;
	/* Column Info */
	private String dckFmDt = null;
	/* Column Info */
	private String dckLocCd = null;
	/* Column Info */
	private String dckToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String phsInDt = null;
	/* Column Info */
	private String dckSeq = null;
	/* Column Info */
	private String phsInPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomDckSkdVO() {}

	public CustomDckSkdVO(String ibflag, String pagerows, String vslCd, String dckSelCd, String dckSeq, String dckFmDt, String dckFmDtTime, String dckToDt, String dckToDtTime, String dckDurDys, String dckDurDysDays, String fletDckSveyTpCd, String fletDckStsCd, String phsOutDt, String phsOutPortCd, String phsInDt, String phsInPortCd, String dckLocCd, String creUsrId, String updUsrId, String ydSeq, String shpYdNm) {
		this.vslCd = vslCd;
		this.dckDurDys = dckDurDys;
		this.dckFmDtTime = dckFmDtTime;
		this.phsOutPortCd = phsOutPortCd;
		this.fletDckSveyTpCd = fletDckSveyTpCd;
		this.pagerows = pagerows;
		this.ydSeq = ydSeq;
		this.creUsrId = creUsrId;
		this.phsOutDt = phsOutDt;
		this.ibflag = ibflag;
		this.shpYdNm = shpYdNm;
		this.fletDckStsCd = fletDckStsCd;
		this.dckSelCd = dckSelCd;
		this.dckDurDysDays = dckDurDysDays;
		this.dckToDtTime = dckToDtTime;
		this.dckFmDt = dckFmDt;
		this.dckLocCd = dckLocCd;
		this.dckToDt = dckToDt;
		this.updUsrId = updUsrId;
		this.phsInDt = phsInDt;
		this.dckSeq = dckSeq;
		this.phsInPortCd = phsInPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dck_dur_dys", getDckDurDys());
		this.hashColumns.put("dck_fm_dt_time", getDckFmDtTime());
		this.hashColumns.put("phs_out_port_cd", getPhsOutPortCd());
		this.hashColumns.put("flet_dck_svey_tp_cd", getFletDckSveyTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yd_seq", getYdSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("phs_out_dt", getPhsOutDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shp_yd_nm", getShpYdNm());
		this.hashColumns.put("flet_dck_sts_cd", getFletDckStsCd());
		this.hashColumns.put("dck_sel_cd", getDckSelCd());
		this.hashColumns.put("dck_dur_dys_days", getDckDurDysDays());
		this.hashColumns.put("dck_to_dt_time", getDckToDtTime());
		this.hashColumns.put("dck_fm_dt", getDckFmDt());
		this.hashColumns.put("dck_loc_cd", getDckLocCd());
		this.hashColumns.put("dck_to_dt", getDckToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("phs_in_dt", getPhsInDt());
		this.hashColumns.put("dck_seq", getDckSeq());
		this.hashColumns.put("phs_in_port_cd", getPhsInPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dck_dur_dys", "dckDurDys");
		this.hashFields.put("dck_fm_dt_time", "dckFmDtTime");
		this.hashFields.put("phs_out_port_cd", "phsOutPortCd");
		this.hashFields.put("flet_dck_svey_tp_cd", "fletDckSveyTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yd_seq", "ydSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("phs_out_dt", "phsOutDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shp_yd_nm", "shpYdNm");
		this.hashFields.put("flet_dck_sts_cd", "fletDckStsCd");
		this.hashFields.put("dck_sel_cd", "dckSelCd");
		this.hashFields.put("dck_dur_dys_days", "dckDurDysDays");
		this.hashFields.put("dck_to_dt_time", "dckToDtTime");
		this.hashFields.put("dck_fm_dt", "dckFmDt");
		this.hashFields.put("dck_loc_cd", "dckLocCd");
		this.hashFields.put("dck_to_dt", "dckToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("phs_in_dt", "phsInDt");
		this.hashFields.put("dck_seq", "dckSeq");
		this.hashFields.put("phs_in_port_cd", "phsInPortCd");
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
	 * @return dckDurDys
	 */
	public String getDckDurDys() {
		return this.dckDurDys;
	}
	
	/**
	 * Column Info
	 * @return dckFmDtTime
	 */
	public String getDckFmDtTime() {
		return this.dckFmDtTime;
	}
	
	/**
	 * Column Info
	 * @return phsOutPortCd
	 */
	public String getPhsOutPortCd() {
		return this.phsOutPortCd;
	}
	
	/**
	 * Column Info
	 * @return fletDckSveyTpCd
	 */
	public String getFletDckSveyTpCd() {
		return this.fletDckSveyTpCd;
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
	 * @return ydSeq
	 */
	public String getYdSeq() {
		return this.ydSeq;
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
	 * @return phsOutDt
	 */
	public String getPhsOutDt() {
		return this.phsOutDt;
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
	 * @return shpYdNm
	 */
	public String getShpYdNm() {
		return this.shpYdNm;
	}
	
	/**
	 * Column Info
	 * @return fletDckStsCd
	 */
	public String getFletDckStsCd() {
		return this.fletDckStsCd;
	}
	
	/**
	 * Column Info
	 * @return dckSelCd
	 */
	public String getDckSelCd() {
		return this.dckSelCd;
	}
	
	/**
	 * Column Info
	 * @return dckDurDysDays
	 */
	public String getDckDurDysDays() {
		return this.dckDurDysDays;
	}
	
	/**
	 * Column Info
	 * @return dckToDtTime
	 */
	public String getDckToDtTime() {
		return this.dckToDtTime;
	}
	
	/**
	 * Column Info
	 * @return dckFmDt
	 */
	public String getDckFmDt() {
		return this.dckFmDt;
	}
	
	/**
	 * Column Info
	 * @return dckLocCd
	 */
	public String getDckLocCd() {
		return this.dckLocCd;
	}
	
	/**
	 * Column Info
	 * @return dckToDt
	 */
	public String getDckToDt() {
		return this.dckToDt;
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
	 * @return phsInDt
	 */
	public String getPhsInDt() {
		return this.phsInDt;
	}
	
	/**
	 * Column Info
	 * @return dckSeq
	 */
	public String getDckSeq() {
		return this.dckSeq;
	}
	
	/**
	 * Column Info
	 * @return phsInPortCd
	 */
	public String getPhsInPortCd() {
		return this.phsInPortCd;
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
	 * @param dckDurDys
	 */
	public void setDckDurDys(String dckDurDys) {
		this.dckDurDys = dckDurDys;
	}
	
	/**
	 * Column Info
	 * @param dckFmDtTime
	 */
	public void setDckFmDtTime(String dckFmDtTime) {
		this.dckFmDtTime = dckFmDtTime;
	}
	
	/**
	 * Column Info
	 * @param phsOutPortCd
	 */
	public void setPhsOutPortCd(String phsOutPortCd) {
		this.phsOutPortCd = phsOutPortCd;
	}
	
	/**
	 * Column Info
	 * @param fletDckSveyTpCd
	 */
	public void setFletDckSveyTpCd(String fletDckSveyTpCd) {
		this.fletDckSveyTpCd = fletDckSveyTpCd;
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
	 * @param ydSeq
	 */
	public void setYdSeq(String ydSeq) {
		this.ydSeq = ydSeq;
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
	 * @param phsOutDt
	 */
	public void setPhsOutDt(String phsOutDt) {
		this.phsOutDt = phsOutDt;
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
	 * @param shpYdNm
	 */
	public void setShpYdNm(String shpYdNm) {
		this.shpYdNm = shpYdNm;
	}
	
	/**
	 * Column Info
	 * @param fletDckStsCd
	 */
	public void setFletDckStsCd(String fletDckStsCd) {
		this.fletDckStsCd = fletDckStsCd;
	}
	
	/**
	 * Column Info
	 * @param dckSelCd
	 */
	public void setDckSelCd(String dckSelCd) {
		this.dckSelCd = dckSelCd;
	}
	
	/**
	 * Column Info
	 * @param dckDurDysDays
	 */
	public void setDckDurDysDays(String dckDurDysDays) {
		this.dckDurDysDays = dckDurDysDays;
	}
	
	/**
	 * Column Info
	 * @param dckToDtTime
	 */
	public void setDckToDtTime(String dckToDtTime) {
		this.dckToDtTime = dckToDtTime;
	}
	
	/**
	 * Column Info
	 * @param dckFmDt
	 */
	public void setDckFmDt(String dckFmDt) {
		this.dckFmDt = dckFmDt;
	}
	
	/**
	 * Column Info
	 * @param dckLocCd
	 */
	public void setDckLocCd(String dckLocCd) {
		this.dckLocCd = dckLocCd;
	}
	
	/**
	 * Column Info
	 * @param dckToDt
	 */
	public void setDckToDt(String dckToDt) {
		this.dckToDt = dckToDt;
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
	 * @param phsInDt
	 */
	public void setPhsInDt(String phsInDt) {
		this.phsInDt = phsInDt;
	}
	
	/**
	 * Column Info
	 * @param dckSeq
	 */
	public void setDckSeq(String dckSeq) {
		this.dckSeq = dckSeq;
	}
	
	/**
	 * Column Info
	 * @param phsInPortCd
	 */
	public void setPhsInPortCd(String phsInPortCd) {
		this.phsInPortCd = phsInPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDckDurDys(JSPUtil.getParameter(request, "dck_dur_dys", ""));
		setDckFmDtTime(JSPUtil.getParameter(request, "dck_fm_dt_time", ""));
		setPhsOutPortCd(JSPUtil.getParameter(request, "phs_out_port_cd", ""));
		setFletDckSveyTpCd(JSPUtil.getParameter(request, "flet_dck_svey_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYdSeq(JSPUtil.getParameter(request, "yd_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPhsOutDt(JSPUtil.getParameter(request, "phs_out_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setShpYdNm(JSPUtil.getParameter(request, "shp_yd_nm", ""));
		setFletDckStsCd(JSPUtil.getParameter(request, "flet_dck_sts_cd", ""));
		setDckSelCd(JSPUtil.getParameter(request, "dck_sel_cd", ""));
		setDckDurDysDays(JSPUtil.getParameter(request, "dck_dur_dys_days", ""));
		setDckToDtTime(JSPUtil.getParameter(request, "dck_to_dt_time", ""));
		setDckFmDt(JSPUtil.getParameter(request, "dck_fm_dt", ""));
		setDckLocCd(JSPUtil.getParameter(request, "dck_loc_cd", ""));
		setDckToDt(JSPUtil.getParameter(request, "dck_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPhsInDt(JSPUtil.getParameter(request, "phs_in_dt", ""));
		setDckSeq(JSPUtil.getParameter(request, "dck_seq", ""));
		setPhsInPortCd(JSPUtil.getParameter(request, "phs_in_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomDckSkdVO[]
	 */
	public CustomDckSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomDckSkdVO[]
	 */
	public CustomDckSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomDckSkdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dckDurDys = (JSPUtil.getParameter(request, prefix	+ "dck_dur_dys", length));
			String[] dckFmDtTime = (JSPUtil.getParameter(request, prefix	+ "dck_fm_dt_time", length));
			String[] phsOutPortCd = (JSPUtil.getParameter(request, prefix	+ "phs_out_port_cd", length));
			String[] fletDckSveyTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_dck_svey_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ydSeq = (JSPUtil.getParameter(request, prefix	+ "yd_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] phsOutDt = (JSPUtil.getParameter(request, prefix	+ "phs_out_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shpYdNm = (JSPUtil.getParameter(request, prefix	+ "shp_yd_nm", length));
			String[] fletDckStsCd = (JSPUtil.getParameter(request, prefix	+ "flet_dck_sts_cd", length));
			String[] dckSelCd = (JSPUtil.getParameter(request, prefix	+ "dck_sel_cd", length));
			String[] dckDurDysDays = (JSPUtil.getParameter(request, prefix	+ "dck_dur_dys_days", length));
			String[] dckToDtTime = (JSPUtil.getParameter(request, prefix	+ "dck_to_dt_time", length));
			String[] dckFmDt = (JSPUtil.getParameter(request, prefix	+ "dck_fm_dt", length));
			String[] dckLocCd = (JSPUtil.getParameter(request, prefix	+ "dck_loc_cd", length));
			String[] dckToDt = (JSPUtil.getParameter(request, prefix	+ "dck_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] phsInDt = (JSPUtil.getParameter(request, prefix	+ "phs_in_dt", length));
			String[] dckSeq = (JSPUtil.getParameter(request, prefix	+ "dck_seq", length));
			String[] phsInPortCd = (JSPUtil.getParameter(request, prefix	+ "phs_in_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomDckSkdVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dckDurDys[i] != null)
					model.setDckDurDys(dckDurDys[i]);
				if (dckFmDtTime[i] != null)
					model.setDckFmDtTime(dckFmDtTime[i]);
				if (phsOutPortCd[i] != null)
					model.setPhsOutPortCd(phsOutPortCd[i]);
				if (fletDckSveyTpCd[i] != null)
					model.setFletDckSveyTpCd(fletDckSveyTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ydSeq[i] != null)
					model.setYdSeq(ydSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (phsOutDt[i] != null)
					model.setPhsOutDt(phsOutDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shpYdNm[i] != null)
					model.setShpYdNm(shpYdNm[i]);
				if (fletDckStsCd[i] != null)
					model.setFletDckStsCd(fletDckStsCd[i]);
				if (dckSelCd[i] != null)
					model.setDckSelCd(dckSelCd[i]);
				if (dckDurDysDays[i] != null)
					model.setDckDurDysDays(dckDurDysDays[i]);
				if (dckToDtTime[i] != null)
					model.setDckToDtTime(dckToDtTime[i]);
				if (dckFmDt[i] != null)
					model.setDckFmDt(dckFmDt[i]);
				if (dckLocCd[i] != null)
					model.setDckLocCd(dckLocCd[i]);
				if (dckToDt[i] != null)
					model.setDckToDt(dckToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (phsInDt[i] != null)
					model.setPhsInDt(phsInDt[i]);
				if (dckSeq[i] != null)
					model.setDckSeq(dckSeq[i]);
				if (phsInPortCd[i] != null)
					model.setPhsInPortCd(phsInPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomDckSkdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomDckSkdVO[]
	 */
	public CustomDckSkdVO[] getCustomDckSkdVOs(){
		CustomDckSkdVO[] vos = (CustomDckSkdVO[])models.toArray(new CustomDckSkdVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckDurDys = this.dckDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckFmDtTime = this.dckFmDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsOutPortCd = this.phsOutPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletDckSveyTpCd = this.fletDckSveyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydSeq = this.ydSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsOutDt = this.phsOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpYdNm = this.shpYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletDckStsCd = this.fletDckStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckSelCd = this.dckSelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckDurDysDays = this.dckDurDysDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckToDtTime = this.dckToDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckFmDt = this.dckFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckLocCd = this.dckLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckToDt = this.dckToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsInDt = this.phsInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dckSeq = this.dckSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsInPortCd = this.phsInPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
