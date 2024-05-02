/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PassagePlanDtVO.java
*@FileTitle : PassagePlanDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PassagePlanDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PassagePlanDtVO> models = new ArrayList<PassagePlanDtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslAproDocNo = null;
	/* Column Info */
	private String arrDepPlcDiffHrs = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String pasgPlnTitNm = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String pltStnDesc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arrPortCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String portToPortMlgDist = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlMlgDist = null;
	/* Column Info */
	private String avgVslSpd = null;
	/* Column Info */
	private String depPlnDt = null;
	/* Column Info */
	private String arrPlnDt = null;
	/* Column Info */
	private String pasgPlnDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String selfShpFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PassagePlanDtVO() {}

	public PassagePlanDtVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String pasgPlnDt, String depPortCd, String arrPortCd, String pasgPlnTitNm, String vslSlanCd, String avgVslSpd, String depPlnDt, String arrPlnDt, String arrDepPlcDiffHrs, String vslAproDocNo, String ttlMlgDist, String portToPortMlgDist, String selfShpFlg, String creUsrId, String creDt, String updUsrId, String updDt, String skdDirCd, String pltStnDesc) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.vslAproDocNo = vslAproDocNo;
		this.arrDepPlcDiffHrs = arrDepPlcDiffHrs;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.depPortCd = depPortCd;
		this.pasgPlnTitNm = pasgPlnTitNm;
		this.vslSlanCd = vslSlanCd;
		this.pltStnDesc = pltStnDesc;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.arrPortCd = arrPortCd;
		this.creUsrId = creUsrId;
		this.portToPortMlgDist = portToPortMlgDist;
		this.ibflag = ibflag;
		this.ttlMlgDist = ttlMlgDist;
		this.avgVslSpd = avgVslSpd;
		this.depPlnDt = depPlnDt;
		this.arrPlnDt = arrPlnDt;
		this.pasgPlnDt = pasgPlnDt;
		this.updUsrId = updUsrId;
		this.selfShpFlg = selfShpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_apro_doc_no", getVslAproDocNo());
		this.hashColumns.put("arr_dep_plc_diff_hrs", getArrDepPlcDiffHrs());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("pasg_pln_tit_nm", getPasgPlnTitNm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("plt_stn_desc", getPltStnDesc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("arr_port_cd", getArrPortCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("port_to_port_mlg_dist", getPortToPortMlgDist());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_mlg_dist", getTtlMlgDist());
		this.hashColumns.put("avg_vsl_spd", getAvgVslSpd());
		this.hashColumns.put("dep_pln_dt", getDepPlnDt());
		this.hashColumns.put("arr_pln_dt", getArrPlnDt());
		this.hashColumns.put("pasg_pln_dt", getPasgPlnDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("self_shp_flg", getSelfShpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_apro_doc_no", "vslAproDocNo");
		this.hashFields.put("arr_dep_plc_diff_hrs", "arrDepPlcDiffHrs");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("pasg_pln_tit_nm", "pasgPlnTitNm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("plt_stn_desc", "pltStnDesc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("arr_port_cd", "arrPortCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("port_to_port_mlg_dist", "portToPortMlgDist");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_mlg_dist", "ttlMlgDist");
		this.hashFields.put("avg_vsl_spd", "avgVslSpd");
		this.hashFields.put("dep_pln_dt", "depPlnDt");
		this.hashFields.put("arr_pln_dt", "arrPlnDt");
		this.hashFields.put("pasg_pln_dt", "pasgPlnDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("self_shp_flg", "selfShpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return vslAproDocNo
	 */
	public String getVslAproDocNo() {
		return this.vslAproDocNo;
	}
	
	/**
	 * Column Info
	 * @return arrDepPlcDiffHrs
	 */
	public String getArrDepPlcDiffHrs() {
		return this.arrDepPlcDiffHrs;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return depPortCd
	 */
	public String getDepPortCd() {
		return this.depPortCd;
	}
	
	/**
	 * Column Info
	 * @return pasgPlnTitNm
	 */
	public String getPasgPlnTitNm() {
		return this.pasgPlnTitNm;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return pltStnDesc
	 */
	public String getPltStnDesc() {
		return this.pltStnDesc;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return arrPortCd
	 */
	public String getArrPortCd() {
		return this.arrPortCd;
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
	 * @return portToPortMlgDist
	 */
	public String getPortToPortMlgDist() {
		return this.portToPortMlgDist;
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
	 * @return ttlMlgDist
	 */
	public String getTtlMlgDist() {
		return this.ttlMlgDist;
	}
	
	/**
	 * Column Info
	 * @return avgVslSpd
	 */
	public String getAvgVslSpd() {
		return this.avgVslSpd;
	}
	
	/**
	 * Column Info
	 * @return depPlnDt
	 */
	public String getDepPlnDt() {
		return this.depPlnDt;
	}
	
	/**
	 * Column Info
	 * @return arrPlnDt
	 */
	public String getArrPlnDt() {
		return this.arrPlnDt;
	}
	
	/**
	 * Column Info
	 * @return pasgPlnDt
	 */
	public String getPasgPlnDt() {
		return this.pasgPlnDt;
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
	 * @return selfShpFlg
	 */
	public String getSelfShpFlg() {
		return this.selfShpFlg;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param vslAproDocNo
	 */
	public void setVslAproDocNo(String vslAproDocNo) {
		this.vslAproDocNo = vslAproDocNo;
	}
	
	/**
	 * Column Info
	 * @param arrDepPlcDiffHrs
	 */
	public void setArrDepPlcDiffHrs(String arrDepPlcDiffHrs) {
		this.arrDepPlcDiffHrs = arrDepPlcDiffHrs;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param depPortCd
	 */
	public void setDepPortCd(String depPortCd) {
		this.depPortCd = depPortCd;
	}
	
	/**
	 * Column Info
	 * @param pasgPlnTitNm
	 */
	public void setPasgPlnTitNm(String pasgPlnTitNm) {
		this.pasgPlnTitNm = pasgPlnTitNm;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param pltStnDesc
	 */
	public void setPltStnDesc(String pltStnDesc) {
		this.pltStnDesc = pltStnDesc;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param arrPortCd
	 */
	public void setArrPortCd(String arrPortCd) {
		this.arrPortCd = arrPortCd;
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
	 * @param portToPortMlgDist
	 */
	public void setPortToPortMlgDist(String portToPortMlgDist) {
		this.portToPortMlgDist = portToPortMlgDist;
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
	 * @param ttlMlgDist
	 */
	public void setTtlMlgDist(String ttlMlgDist) {
		this.ttlMlgDist = ttlMlgDist;
	}
	
	/**
	 * Column Info
	 * @param avgVslSpd
	 */
	public void setAvgVslSpd(String avgVslSpd) {
		this.avgVslSpd = avgVslSpd;
	}
	
	/**
	 * Column Info
	 * @param depPlnDt
	 */
	public void setDepPlnDt(String depPlnDt) {
		this.depPlnDt = depPlnDt;
	}
	
	/**
	 * Column Info
	 * @param arrPlnDt
	 */
	public void setArrPlnDt(String arrPlnDt) {
		this.arrPlnDt = arrPlnDt;
	}
	
	/**
	 * Column Info
	 * @param pasgPlnDt
	 */
	public void setPasgPlnDt(String pasgPlnDt) {
		this.pasgPlnDt = pasgPlnDt;
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
	 * @param selfShpFlg
	 */
	public void setSelfShpFlg(String selfShpFlg) {
		this.selfShpFlg = selfShpFlg;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVslAproDocNo(JSPUtil.getParameter(request, prefix + "vsl_apro_doc_no", ""));
		setArrDepPlcDiffHrs(JSPUtil.getParameter(request, prefix + "arr_dep_plc_diff_hrs", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setPasgPlnTitNm(JSPUtil.getParameter(request, prefix + "pasg_pln_tit_nm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPltStnDesc(JSPUtil.getParameter(request, prefix + "plt_stn_desc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setArrPortCd(JSPUtil.getParameter(request, prefix + "arr_port_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPortToPortMlgDist(JSPUtil.getParameter(request, prefix + "port_to_port_mlg_dist", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTtlMlgDist(JSPUtil.getParameter(request, prefix + "ttl_mlg_dist", ""));
		setAvgVslSpd(JSPUtil.getParameter(request, prefix + "avg_vsl_spd", ""));
		setDepPlnDt(JSPUtil.getParameter(request, prefix + "dep_pln_dt", ""));
		setArrPlnDt(JSPUtil.getParameter(request, prefix + "arr_pln_dt", ""));
		setPasgPlnDt(JSPUtil.getParameter(request, prefix + "pasg_pln_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSelfShpFlg(JSPUtil.getParameter(request, prefix + "self_shp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PassagePlanDtVO[]
	 */
	public PassagePlanDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PassagePlanDtVO[]
	 */
	public PassagePlanDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PassagePlanDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslAproDocNo = (JSPUtil.getParameter(request, prefix	+ "vsl_apro_doc_no", length));
			String[] arrDepPlcDiffHrs = (JSPUtil.getParameter(request, prefix	+ "arr_dep_plc_diff_hrs", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] pasgPlnTitNm = (JSPUtil.getParameter(request, prefix	+ "pasg_pln_tit_nm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pltStnDesc = (JSPUtil.getParameter(request, prefix	+ "plt_stn_desc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arrPortCd = (JSPUtil.getParameter(request, prefix	+ "arr_port_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] portToPortMlgDist = (JSPUtil.getParameter(request, prefix	+ "port_to_port_mlg_dist", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlMlgDist = (JSPUtil.getParameter(request, prefix	+ "ttl_mlg_dist", length));
			String[] avgVslSpd = (JSPUtil.getParameter(request, prefix	+ "avg_vsl_spd", length));
			String[] depPlnDt = (JSPUtil.getParameter(request, prefix	+ "dep_pln_dt", length));
			String[] arrPlnDt = (JSPUtil.getParameter(request, prefix	+ "arr_pln_dt", length));
			String[] pasgPlnDt = (JSPUtil.getParameter(request, prefix	+ "pasg_pln_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] selfShpFlg = (JSPUtil.getParameter(request, prefix	+ "self_shp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PassagePlanDtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslAproDocNo[i] != null)
					model.setVslAproDocNo(vslAproDocNo[i]);
				if (arrDepPlcDiffHrs[i] != null)
					model.setArrDepPlcDiffHrs(arrDepPlcDiffHrs[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (pasgPlnTitNm[i] != null)
					model.setPasgPlnTitNm(pasgPlnTitNm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pltStnDesc[i] != null)
					model.setPltStnDesc(pltStnDesc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arrPortCd[i] != null)
					model.setArrPortCd(arrPortCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (portToPortMlgDist[i] != null)
					model.setPortToPortMlgDist(portToPortMlgDist[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlMlgDist[i] != null)
					model.setTtlMlgDist(ttlMlgDist[i]);
				if (avgVslSpd[i] != null)
					model.setAvgVslSpd(avgVslSpd[i]);
				if (depPlnDt[i] != null)
					model.setDepPlnDt(depPlnDt[i]);
				if (arrPlnDt[i] != null)
					model.setArrPlnDt(arrPlnDt[i]);
				if (pasgPlnDt[i] != null)
					model.setPasgPlnDt(pasgPlnDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (selfShpFlg[i] != null)
					model.setSelfShpFlg(selfShpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPassagePlanDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PassagePlanDtVO[]
	 */
	public PassagePlanDtVO[] getPassagePlanDtVOs(){
		PassagePlanDtVO[] vos = (PassagePlanDtVO[])models.toArray(new PassagePlanDtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAproDocNo = this.vslAproDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDepPlcDiffHrs = this.arrDepPlcDiffHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pasgPlnTitNm = this.pasgPlnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltStnDesc = this.pltStnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrPortCd = this.arrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portToPortMlgDist = this.portToPortMlgDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMlgDist = this.ttlMlgDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgVslSpd = this.avgVslSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPlnDt = this.depPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrPlnDt = this.arrPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pasgPlnDt = this.pasgPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfShpFlg = this.selfShpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
