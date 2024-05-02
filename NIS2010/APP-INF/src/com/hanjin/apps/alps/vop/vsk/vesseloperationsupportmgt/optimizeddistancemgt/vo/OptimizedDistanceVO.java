/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizedDistanceVO.java
*@FileTitle : OptimizedDistanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OptimizedDistanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OptimizedDistanceVO> models = new ArrayList<OptimizedDistanceVO>();
	
	/* Column Info */
	private String avgSlpRt = null;
	/* Column Info */
	private String stndDist = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String fmPortCd = null; 
	/* Column Info */
	private String preSheetToYdGrpCd = null;
	/* Column Info */
	private String sheetFmYdGrpCd = null;
	/* Column Info */
	private String sheetToYdGrpCd = null;
	/* Column Info */
	private String opmzDist = null;
	/* Column Info */
	private String fmDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sheetFmPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vmsShtgDist = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String preSheetFmYdGrpCd = null;
	/* Column Info */
	private String toYdGrpId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String varSlpRt = null;
	/* Column Info */
	private String gmtTdHrs = null;
	/* Column Info */
	private String fmYdGrpId = null;
	/* Column Info */
	private String rngMaxDist = null;
	/* Column Info */
	private String rngMinDist = null;
	/* Column Info */
	private String slpKnt = null;
	/* Column Info */
	private String vmsAvgDist = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String sheetToPortCd = null;
	/* Column Info */
	private String fmYdGrpCd = null;
	/* Column Info */
	private String toYdGrpCd = null;
	/* Column Info */
	private String toPortCd = null;
	
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fileSetYn = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String vslSlanCd = null;
	
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pasgPlnDt = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String arrPortCd = null;
	
	/* Column Info */
	private String pltStnDesc = null;
	/* Column Info */
	private String vpsEtaDt = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OptimizedDistanceVO() {}

	public OptimizedDistanceVO(String ibflag, String pagerows, String fmYdCd, String sheetToPortCd, String sheetFmPortCd, String fmYdGrpCd, String sheetToYdGrpCd, String sheetFmYdGrpCd, String gmtTdHrs, String stndDist, String opmzDist, String vmsAvgDist, String vmsShtgDist, String rngMaxDist, String rngMinDist, String updUsrId, String updDt, String fmPortCd, String fmYdGrpId, String toPortCd, String toYdGrpId, String fmDate, String toDate, String usrId, String portCd, String toYdGrpCd, String avgSlpRt, String slpKnt, String varSlpRt, String preSheetToYdGrpCd, String preSheetFmYdGrpCd) {
		this.avgSlpRt = avgSlpRt;
		this.stndDist = stndDist;
		this.fmYdCd = fmYdCd;
		this.fmPortCd = fmPortCd;
		this.preSheetToYdGrpCd = preSheetToYdGrpCd;
		this.sheetFmYdGrpCd = sheetFmYdGrpCd;
		this.sheetToYdGrpCd = sheetToYdGrpCd;
		this.opmzDist = opmzDist;
		this.fmDate = fmDate;
		this.pagerows = pagerows;
		this.sheetFmPortCd = sheetFmPortCd;
		this.ibflag = ibflag;
		this.vmsShtgDist = vmsShtgDist;
		this.usrId = usrId;
		this.preSheetFmYdGrpCd = preSheetFmYdGrpCd;
		this.toYdGrpId = toYdGrpId;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.varSlpRt = varSlpRt;
		this.gmtTdHrs = gmtTdHrs;
		this.fmYdGrpId = fmYdGrpId;
		this.rngMaxDist = rngMaxDist;
		this.rngMinDist = rngMinDist;
		this.slpKnt = slpKnt;
		this.vmsAvgDist = vmsAvgDist;
		this.toDate = toDate;
		this.sheetToPortCd = sheetToPortCd;
		this.fmYdGrpCd = fmYdGrpCd;
		this.toYdGrpCd = toYdGrpCd;
		this.toPortCd = toPortCd;
		this.fileSavId = fileSavId;
		this.creUsrId = creUsrId;
		this.fileSetYn = fileSetYn;
		this.creDt = creDt;
		this.fileNm = fileNm;
		this.vslSlanCd = vslSlanCd;
		
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pasgPlnDt = pasgPlnDt;
		this.depPortCd = depPortCd;
		this.arrPortCd = arrPortCd;
		this.pltStnDesc = pltStnDesc;
		this.vpsEtaDt = vpsEtaDt;



	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("avg_slp_rt", getAvgSlpRt());
		this.hashColumns.put("stnd_dist", getStndDist());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("pre_sheet_to_yd_grp_cd", getPreSheetToYdGrpCd());
		this.hashColumns.put("sheet_fm_yd_grp_cd", getSheetFmYdGrpCd());
		this.hashColumns.put("sheet_to_yd_grp_cd", getSheetToYdGrpCd());
		this.hashColumns.put("opmz_dist", getOpmzDist());
		this.hashColumns.put("fm_date", getFmDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sheet_fm_port_cd", getSheetFmPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vms_shtg_dist", getVmsShtgDist());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pre_sheet_fm_yd_grp_cd", getPreSheetFmYdGrpCd());
		this.hashColumns.put("to_yd_grp_id", getToYdGrpId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("var_slp_rt", getVarSlpRt());
		this.hashColumns.put("gmt_td_hrs", getGmtTdHrs());
		this.hashColumns.put("fm_yd_grp_id", getFmYdGrpId());
		this.hashColumns.put("rng_max_dist", getRngMaxDist());
		this.hashColumns.put("rng_min_dist", getRngMinDist());
		this.hashColumns.put("slp_knt", getSlpKnt());
		this.hashColumns.put("vms_avg_dist", getVmsAvgDist());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("sheet_to_port_cd", getSheetToPortCd());
		this.hashColumns.put("fm_yd_grp_cd", getFmYdGrpCd());
		this.hashColumns.put("to_yd_grp_cd", getToYdGrpCd());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("file_set_yn", getFileSetYn());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());

		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pasg_pln_dt", getPasgPlnDt());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("arr_port_cd", getArrPortCd());
		this.hashColumns.put("plt_stn_desc", getPltStnDesc());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());


		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("avg_slp_rt", "avgSlpRt");
		this.hashFields.put("stnd_dist", "stndDist");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("pre_sheet_to_yd_grp_cd", "preSheetToYdGrpCd");
		this.hashFields.put("sheet_fm_yd_grp_cd", "sheetFmYdGrpCd");
		this.hashFields.put("sheet_to_yd_grp_cd", "sheetToYdGrpCd");
		this.hashFields.put("opmz_dist", "opmzDist");
		this.hashFields.put("fm_date", "fmDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sheet_fm_port_cd", "sheetFmPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vms_shtg_dist", "vmsShtgDist");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pre_sheet_fm_yd_grp_cd", "preSheetFmYdGrpCd");
		this.hashFields.put("to_yd_grp_id", "toYdGrpId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("var_slp_rt", "varSlpRt");
		this.hashFields.put("gmt_td_hrs", "gmtTdHrs");
		this.hashFields.put("fm_yd_grp_id", "fmYdGrpId");
		this.hashFields.put("rng_max_dist", "rngMaxDist");
		this.hashFields.put("rng_min_dist", "rngMinDist");
		this.hashFields.put("slp_knt", "slpKnt");
		this.hashFields.put("vms_avg_dist", "vmsAvgDist");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("sheet_to_port_cd", "sheetToPortCd");
		this.hashFields.put("fm_yd_grp_cd", "fmYdGrpCd");
		this.hashFields.put("to_yd_grp_cd", "toYdGrpCd");
		this.hashFields.put("to_port_cd", "toPortCd");
		
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("file_set_yn", "fileSetYn");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pasg_pln_dt", "pasgPlnDt");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("arr_port_cd", "arrPortCd");
		this.hashFields.put("plt_stn_desc", "pltStnDesc");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return avgSlpRt
	 */
	public String getAvgSlpRt() {
		return this.avgSlpRt;
	}
	
	/**
	 * Column Info
	 * @return stndDist
	 */
	public String getStndDist() {
		return this.stndDist;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
	}
	
	/**
	 * Column Info
	 * @return preSheetToYdGrpCd
	 */
	public String getPreSheetToYdGrpCd() {
		return this.preSheetToYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sheetFmYdGrpCd
	 */
	public String getSheetFmYdGrpCd() {
		return this.sheetFmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sheetToYdGrpCd
	 */
	public String getSheetToYdGrpCd() {
		return this.sheetToYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return opmzDist
	 */
	public String getOpmzDist() {
		return this.opmzDist;
	}
	
	/**
	 * Column Info
	 * @return fmDate
	 */
	public String getFmDate() {
		return this.fmDate;
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
	 * @return sheetFmPortCd
	 */
	public String getSheetFmPortCd() {
		return this.sheetFmPortCd;
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
	 * @return vmsShtgDist
	 */
	public String getVmsShtgDist() {
		return this.vmsShtgDist;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return preSheetFmYdGrpCd
	 */
	public String getPreSheetFmYdGrpCd() {
		return this.preSheetFmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return toYdGrpId
	 */
	public String getToYdGrpId() {
		return this.toYdGrpId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return varSlpRt
	 */
	public String getVarSlpRt() {
		return this.varSlpRt;
	}
	
	/**
	 * Column Info
	 * @return gmtTdHrs
	 */
	public String getGmtTdHrs() {
		return this.gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @return fmYdGrpId
	 */
	public String getFmYdGrpId() {
		return this.fmYdGrpId;
	}
	
	/**
	 * Column Info
	 * @return rngMaxDist
	 */
	public String getRngMaxDist() {
		return this.rngMaxDist;
	}
	
	/**
	 * Column Info
	 * @return rngMinDist
	 */
	public String getRngMinDist() {
		return this.rngMinDist;
	}
	
	/**
	 * Column Info
	 * @return slpKnt
	 */
	public String getSlpKnt() {
		return this.slpKnt;
	}
	
	/**
	 * Column Info
	 * @return vmsAvgDist
	 */
	public String getVmsAvgDist() {
		return this.vmsAvgDist;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return sheetToPortCd
	 */
	public String getSheetToPortCd() {
		return this.sheetToPortCd;
	}
	
	/**
	 * Column Info
	 * @return fmYdGrpCd
	 */
	public String getFmYdGrpCd() {
		return this.fmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return toYdGrpCd
	 */
	public String getToYdGrpCd() {
		return this.toYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return fileSetYn
	 */
	public String getFileSetYn() {
		return this.fileSetYn;
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
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return depPortCd
	 */
	public String getDepPortCd() {
		return this.depPortCd;
	}
	
	/**
	 * Column Info
	 * @return arrportCd
	 */
	public String getArrPortCd() {
		return this.arrPortCd;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	

	/**
	 * Column Info
	 * @param avgSlpRt
	 */
	public void setAvgSlpRt(String avgSlpRt) {
		this.avgSlpRt = avgSlpRt;
	}
	
	/**
	 * Column Info
	 * @param stndDist
	 */
	public void setStndDist(String stndDist) {
		this.stndDist = stndDist;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
	}
	
	/**
	 * Column Info
	 * @param preSheetToYdGrpCd
	 */
	public void setPreSheetToYdGrpCd(String preSheetToYdGrpCd) {
		this.preSheetToYdGrpCd = preSheetToYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sheetFmYdGrpCd
	 */
	public void setSheetFmYdGrpCd(String sheetFmYdGrpCd) {
		this.sheetFmYdGrpCd = sheetFmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sheetToYdGrpCd
	 */
	public void setSheetToYdGrpCd(String sheetToYdGrpCd) {
		this.sheetToYdGrpCd = sheetToYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param opmzDist
	 */
	public void setOpmzDist(String opmzDist) {
		this.opmzDist = opmzDist;
	}
	
	/**
	 * Column Info
	 * @param fmDate
	 */
	public void setFmDate(String fmDate) {
		this.fmDate = fmDate;
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
	 * @param sheetFmPortCd
	 */
	public void setSheetFmPortCd(String sheetFmPortCd) {
		this.sheetFmPortCd = sheetFmPortCd;
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
	 * @param vmsShtgDist
	 */
	public void setVmsShtgDist(String vmsShtgDist) {
		this.vmsShtgDist = vmsShtgDist;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param preSheetFmYdGrpCd
	 */
	public void setPreSheetFmYdGrpCd(String preSheetFmYdGrpCd) {
		this.preSheetFmYdGrpCd = preSheetFmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param toYdGrpId
	 */
	public void setToYdGrpId(String toYdGrpId) {
		this.toYdGrpId = toYdGrpId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param varSlpRt
	 */
	public void setVarSlpRt(String varSlpRt) {
		this.varSlpRt = varSlpRt;
	}
	
	/**
	 * Column Info
	 * @param gmtTdHrs
	 */
	public void setGmtTdHrs(String gmtTdHrs) {
		this.gmtTdHrs = gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @param fmYdGrpId
	 */
	public void setFmYdGrpId(String fmYdGrpId) {
		this.fmYdGrpId = fmYdGrpId;
	}
	
	/**
	 * Column Info
	 * @param rngMaxDist
	 */
	public void setRngMaxDist(String rngMaxDist) {
		this.rngMaxDist = rngMaxDist;
	}
	
	/**
	 * Column Info
	 * @param rngMinDist
	 */
	public void setRngMinDist(String rngMinDist) {
		this.rngMinDist = rngMinDist;
	}
	
	/**
	 * Column Info
	 * @param slpKnt
	 */
	public void setSlpKnt(String slpKnt) {
		this.slpKnt = slpKnt;
	}
	
	/**
	 * Column Info
	 * @param vmsAvgDist
	 */
	public void setVmsAvgDist(String vmsAvgDist) {
		this.vmsAvgDist = vmsAvgDist;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param sheetToPortCd
	 */
	public void setSheetToPortCd(String sheetToPortCd) {
		this.sheetToPortCd = sheetToPortCd;
	}
	
	/**
	 * Column Info
	 * @param fmYdGrpCd
	 */
	public void setFmYdGrpCd(String fmYdGrpCd) {
		this.fmYdGrpCd = fmYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param toYdGrpCd
	 */
	public void setToYdGrpCd(String toYdGrpCd) {
		this.toYdGrpCd = toYdGrpCd;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param fileSetYn
	 */
	public void setFileSetYn(String fileSetYn) {
		this.fileSetYn = fileSetYn;
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
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param depPortCd
	 */
	public void setDepPortCd(String depPortCd) {
		this.depPortCd = depPortCd;
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
	 * @param pltStnDesc
	 */
	public void setPltStnDesc(String pltStnDesc) {
		this.pltStnDesc = pltStnDesc;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
		setAvgSlpRt(JSPUtil.getParameter(request, prefix + "avg_slp_rt", ""));
		setStndDist(JSPUtil.getParameter(request, prefix + "stnd_dist", ""));
		setFmYdCd(JSPUtil.getParameter(request, prefix + "fm_yd_cd", ""));
		setFmPortCd(JSPUtil.getParameter(request, prefix + "fm_port_cd", ""));
		setPreSheetToYdGrpCd(JSPUtil.getParameter(request, prefix + "pre_sheet_to_yd_grp_cd", ""));
		setSheetFmYdGrpCd(JSPUtil.getParameter(request, prefix + "sheet_fm_yd_grp_cd", ""));
		setSheetToYdGrpCd(JSPUtil.getParameter(request, prefix + "sheet_to_yd_grp_cd", ""));
		setOpmzDist(JSPUtil.getParameter(request, prefix + "opmz_dist", ""));
		setFmDate(JSPUtil.getParameter(request, prefix + "fm_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSheetFmPortCd(JSPUtil.getParameter(request, prefix + "sheet_fm_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVmsShtgDist(JSPUtil.getParameter(request, prefix + "vms_shtg_dist", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPreSheetFmYdGrpCd(JSPUtil.getParameter(request, prefix + "pre_sheet_fm_yd_grp_cd", ""));
		setToYdGrpId(JSPUtil.getParameter(request, prefix + "to_yd_grp_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVarSlpRt(JSPUtil.getParameter(request, prefix + "var_slp_rt", ""));
		setGmtTdHrs(JSPUtil.getParameter(request, prefix + "gmt_td_hrs", ""));
		setFmYdGrpId(JSPUtil.getParameter(request, prefix + "fm_yd_grp_id", ""));
		setRngMaxDist(JSPUtil.getParameter(request, prefix + "rng_max_dist", ""));
		setRngMinDist(JSPUtil.getParameter(request, prefix + "rng_min_dist", ""));
		setSlpKnt(JSPUtil.getParameter(request, prefix + "slp_knt", ""));
		setVmsAvgDist(JSPUtil.getParameter(request, prefix + "vms_avg_dist", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setSheetToPortCd(JSPUtil.getParameter(request, prefix + "sheet_to_port_cd", ""));
		setFmYdGrpCd(JSPUtil.getParameter(request, prefix + "fm_yd_grp_cd", ""));
		setToYdGrpCd(JSPUtil.getParameter(request, prefix + "to_yd_grp_cd", ""));
		setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
		
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFileSetYn(JSPUtil.getParameter(request, "file_set_yn", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPasgPlnDt(JSPUtil.getParameter(request, "pasg_pln_dt", ""));
		setDepPortCd(JSPUtil.getParameter(request, "dep_port_cd", ""));
		setArrPortCd(JSPUtil.getParameter(request, "arr_port_cd", ""));
		setPltStnDesc(JSPUtil.getParameter(request, "plt_stn_desc", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));


	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OptimizedDistanceVO[]
	 */
	public OptimizedDistanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OptimizedDistanceVO[]
	 */
	public OptimizedDistanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OptimizedDistanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] avgSlpRt = (JSPUtil.getParameter(request, prefix	+ "avg_slp_rt", length));
			String[] stndDist = (JSPUtil.getParameter(request, prefix	+ "stnd_dist", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] preSheetToYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "pre_sheet_to_yd_grp_cd", length));
			String[] sheetFmYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "sheet_fm_yd_grp_cd", length));
			String[] sheetToYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "sheet_to_yd_grp_cd", length));
			String[] opmzDist = (JSPUtil.getParameter(request, prefix	+ "opmz_dist", length));
			String[] fmDate = (JSPUtil.getParameter(request, prefix	+ "fm_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sheetFmPortCd = (JSPUtil.getParameter(request, prefix	+ "sheet_fm_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vmsShtgDist = (JSPUtil.getParameter(request, prefix	+ "vms_shtg_dist", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] preSheetFmYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "pre_sheet_fm_yd_grp_cd", length));
			String[] toYdGrpId = (JSPUtil.getParameter(request, prefix	+ "to_yd_grp_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] varSlpRt = (JSPUtil.getParameter(request, prefix	+ "var_slp_rt", length));
			String[] gmtTdHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_td_hrs", length));
			String[] fmYdGrpId = (JSPUtil.getParameter(request, prefix	+ "fm_yd_grp_id", length));
			String[] rngMaxDist = (JSPUtil.getParameter(request, prefix	+ "rng_max_dist", length));
			String[] rngMinDist = (JSPUtil.getParameter(request, prefix	+ "rng_min_dist", length));
			String[] slpKnt = (JSPUtil.getParameter(request, prefix	+ "slp_knt", length));
			String[] vmsAvgDist = (JSPUtil.getParameter(request, prefix	+ "vms_avg_dist", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] sheetToPortCd = (JSPUtil.getParameter(request, prefix	+ "sheet_to_port_cd", length));
			String[] fmYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_grp_cd", length));
			String[] toYdGrpCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_grp_cd", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fileSetYn = (JSPUtil.getParameter(request, prefix	+ "file_set_yn", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pasgPlnDt = (JSPUtil.getParameter(request, prefix	+ "pasg_pln_dt", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] arrPortCd = (JSPUtil.getParameter(request, prefix	+ "arr_port_cd", length));
			String[] pltStnDesc = (JSPUtil.getParameter(request, prefix	+ "plt_stn_desc", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));


			
			for (int i = 0; i < length; i++) {
				model = new OptimizedDistanceVO();
				if (avgSlpRt[i] != null)
					model.setAvgSlpRt(avgSlpRt[i]);
				if (stndDist[i] != null)
					model.setStndDist(stndDist[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fmPortCd[i] != null)
					model.setFmPortCd(fmPortCd[i]);
				if (preSheetToYdGrpCd[i] != null)
					model.setPreSheetToYdGrpCd(preSheetToYdGrpCd[i]);
				if (sheetFmYdGrpCd[i] != null)
					model.setSheetFmYdGrpCd(sheetFmYdGrpCd[i]);
				if (sheetToYdGrpCd[i] != null)
					model.setSheetToYdGrpCd(sheetToYdGrpCd[i]);
				if (opmzDist[i] != null)
					model.setOpmzDist(opmzDist[i]);
				if (fmDate[i] != null)
					model.setFmDate(fmDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sheetFmPortCd[i] != null)
					model.setSheetFmPortCd(sheetFmPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vmsShtgDist[i] != null)
					model.setVmsShtgDist(vmsShtgDist[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (preSheetFmYdGrpCd[i] != null)
					model.setPreSheetFmYdGrpCd(preSheetFmYdGrpCd[i]);
				if (toYdGrpId[i] != null)
					model.setToYdGrpId(toYdGrpId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (varSlpRt[i] != null)
					model.setVarSlpRt(varSlpRt[i]);
				if (gmtTdHrs[i] != null)
					model.setGmtTdHrs(gmtTdHrs[i]);
				if (fmYdGrpId[i] != null)
					model.setFmYdGrpId(fmYdGrpId[i]);
				if (rngMaxDist[i] != null)
					model.setRngMaxDist(rngMaxDist[i]);
				if (rngMinDist[i] != null)
					model.setRngMinDist(rngMinDist[i]);
				if (slpKnt[i] != null)
					model.setSlpKnt(slpKnt[i]);
				if (vmsAvgDist[i] != null)
					model.setVmsAvgDist(vmsAvgDist[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (sheetToPortCd[i] != null)
					model.setSheetToPortCd(sheetToPortCd[i]);
				if (fmYdGrpCd[i] != null)
					model.setFmYdGrpCd(fmYdGrpCd[i]);
				if (toYdGrpCd[i] != null)
					model.setToYdGrpCd(toYdGrpCd[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);

				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fileSetYn[i] != null)
					model.setFileSetYn(fileSetYn[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pasgPlnDt[i] != null)
					model.setPasgPlnDt(pasgPlnDt[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (arrPortCd[i] != null)
					model.setArrPortCd(arrPortCd[i]);
				if (pltStnDesc[i] != null)
					model.setPltStnDesc(pltStnDesc[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOptimizedDistanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OptimizedDistanceVO[]
	 */
	public OptimizedDistanceVO[] getOptimizedDistanceVOs(){
		OptimizedDistanceVO[] vos = (OptimizedDistanceVO[])models.toArray(new OptimizedDistanceVO[models.size()]);
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
		this.avgSlpRt = this.avgSlpRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndDist = this.stndDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSheetToYdGrpCd = this.preSheetToYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetFmYdGrpCd = this.sheetFmYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetToYdGrpCd = this.sheetToYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzDist = this.opmzDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDate = this.fmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetFmPortCd = this.sheetFmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vmsShtgDist = this.vmsShtgDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSheetFmYdGrpCd = this.preSheetFmYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdGrpId = this.toYdGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.varSlpRt = this.varSlpRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtTdHrs = this.gmtTdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdGrpId = this.fmYdGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngMaxDist = this.rngMaxDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rngMinDist = this.rngMinDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpKnt = this.slpKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vmsAvgDist = this.vmsAvgDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetToPortCd = this.sheetToPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdGrpCd = this.fmYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdGrpCd = this.toYdGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSetYn = this.fileSetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pasgPlnDt = this.pasgPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrPortCd = this.arrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltStnDesc = this.pltStnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");


	}
}
