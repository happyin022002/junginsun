/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDailyBKGView0078ListVO.java
*@FileTitle : SearchDailyBKGView0078ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.26 윤진영 
* 1.0 Creation
* 
* 2012.01.02 이석준 [CHM-201114896-01] [COA] CM2 추가 개발 요청
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDailyBKGView0078ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyBKGView0078ListVO> models = new ArrayList<SearchDailyBKGView0078ListVO>();
	
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String opb = null;
	/* Column Info */
	private String opCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cRepCd = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String revPodCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String lOfcCd = null;
	/* Column Info */
	private String cmCost = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String lRepCd = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String spclCntrTpszCd = null;
	/* Column Info */
	private String cOfcCd = null;
	/* Column Info */
	private String grpb = null;
	/* Column Info */
	private String revPolCd = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String box = null;
	/* Column Info */
	private String cm2 = null;
	/* Column Info */
	private String ownFdr = null;
	/* Column Info */
	private String cm2Cost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyBKGView0078ListVO() {}

	public SearchDailyBKGView0078ListVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String dirCd, String vvdCd, String costWk, String bkgPorCd, String bkgPolCd, String bkgPodCd, String revPolCd, String revPodCd, String bkgDelCd, String cOfcCd, String lOfcCd, String lRepCd, String cRepCd, String scNo, String rfaNo, String shprNm, String cneeNm, String cmdtCd, String cmdtNm, String bkgNo, String spclCntrTpszCd, String box, String load, String rev, String cm, String op, String cmCost, String opCost, String grpb, String cmb, String opb,String cm2,String ownFdr,String cm2Cost) {
		this.rev = rev;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.opb = opb;
		this.opCost = opCost;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cRepCd = cRepCd;
		this.bkgDelCd = bkgDelCd;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.revPodCd = revPodCd;
		this.dirCd = dirCd;
		this.shprNm = shprNm;
		this.cneeNm = cneeNm;
		this.bkgPolCd = bkgPolCd;
		this.bkgPorCd = bkgPorCd;
		this.op = op;
		this.lOfcCd = lOfcCd;
		this.cmCost = cmCost;
		this.cmdtNm = cmdtNm;
		this.cmb = cmb;
		this.bkgNo = bkgNo;
		this.lRepCd = lRepCd;
		this.cm = cm;
		this.costWk = costWk;
		this.spclCntrTpszCd = spclCntrTpszCd;
		this.cOfcCd = cOfcCd;
		this.grpb = grpb;
		this.revPolCd = revPolCd;
		this.load = load;
		this.box = box;
		this.cm2 = cm2;
		this.ownFdr = ownFdr;
		this.cm2Cost = cm2Cost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("c_rep_cd", getCRepCd());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rev_pod_cd", getRevPodCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("l_ofc_cd", getLOfcCd());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("l_rep_cd", getLRepCd());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("spcl_cntr_tpsz_cd", getSpclCntrTpszCd());
		this.hashColumns.put("c_ofc_cd", getCOfcCd());
		this.hashColumns.put("grpb", getGrpb());
		this.hashColumns.put("rev_pol_cd", getRevPolCd());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("box", getBox());
		this.hashColumns.put("cm2", getCm2());
		this.hashColumns.put("own_fdr", getOwnFdr());
		this.hashColumns.put("cm2_cost", getCm2Cost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("c_rep_cd", "cRepCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rev_pod_cd", "revPodCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("op", "op");
		this.hashFields.put("l_ofc_cd", "lOfcCd");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("l_rep_cd", "lRepCd");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("spcl_cntr_tpsz_cd", "spclCntrTpszCd");
		this.hashFields.put("c_ofc_cd", "cOfcCd");
		this.hashFields.put("grpb", "grpb");
		this.hashFields.put("rev_pol_cd", "revPolCd");
		this.hashFields.put("load", "load");
		this.hashFields.put("box", "box");
		this.hashFields.put("cm2", "cm2");
		this.hashFields.put("own_fdr", "ownFdr");
		this.hashFields.put("cm2_cost", "cm2Cost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return opb
	 */
	public String getOpb() {
		return this.opb;
	}
	
	/**
	 * Column Info
	 * @return opCost
	 */
	public String getOpCost() {
		return this.opCost;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cRepCd
	 */
	public String getCRepCd() {
		return this.cRepCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return revPodCd
	 */
	public String getRevPodCd() {
		return this.revPodCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return lOfcCd
	 */
	public String getLOfcCd() {
		return this.lOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cmCost
	 */
	public String getCmCost() {
		return this.cmCost;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
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
	 * @return lRepCd
	 */
	public String getLRepCd() {
		return this.lRepCd;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return spclCntrTpszCd
	 */
	public String getSpclCntrTpszCd() {
		return this.spclCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cOfcCd
	 */
	public String getCOfcCd() {
		return this.cOfcCd;
	}
	
	/**
	 * Column Info
	 * @return grpb
	 */
	public String getGrpb() {
		return this.grpb;
	}
	
	/**
	 * Column Info
	 * @return revPolCd
	 */
	public String getRevPolCd() {
		return this.revPolCd;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return box
	 */
	public String getBox() {
		return this.box;
	}
	
	/**
	 * Column Info
	 * @return cm2
	 */
	public String getCm2() {
		return this.cm2;
	}
	
	/**
	 * Column Info
	 * @return ownFdr
	 */
	public String getOwnFdr() {
		return this.ownFdr;
	}
	
	/**
	 * Column Info
	 * @return cm2Cost
	 */
	public String getCm2Cost() {
		return this.cm2Cost;
	}	
	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param opb
	 */
	public void setOpb(String opb) {
		this.opb = opb;
	}
	
	/**
	 * Column Info
	 * @param opCost
	 */
	public void setOpCost(String opCost) {
		this.opCost = opCost;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cRepCd
	 */
	public void setCRepCd(String cRepCd) {
		this.cRepCd = cRepCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param revPodCd
	 */
	public void setRevPodCd(String revPodCd) {
		this.revPodCd = revPodCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param lOfcCd
	 */
	public void setLOfcCd(String lOfcCd) {
		this.lOfcCd = lOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cmCost
	 */
	public void setCmCost(String cmCost) {
		this.cmCost = cmCost;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
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
	 * @param lRepCd
	 */
	public void setLRepCd(String lRepCd) {
		this.lRepCd = lRepCd;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param spclCntrTpszCd
	 */
	public void setSpclCntrTpszCd(String spclCntrTpszCd) {
		this.spclCntrTpszCd = spclCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cOfcCd
	 */
	public void setCOfcCd(String cOfcCd) {
		this.cOfcCd = cOfcCd;
	}
	
	/**
	 * Column Info
	 * @param grpb
	 */
	public void setGrpb(String grpb) {
		this.grpb = grpb;
	}
	
	/**
	 * Column Info
	 * @param revPolCd
	 */
	public void setRevPolCd(String revPolCd) {
		this.revPolCd = revPolCd;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param box
	 */
	public void setBox(String box) {
		this.box = box;
	}

	/**
	 * Column Info
	 * @param cm2
	 */
	public void setCm2(String cm2) {
		this.box = cm2;
	}
	
	/**
	 * Column Info
	 * @param ownFdr
	 */
	public void setOwnFdr(String ownFdr) {
		this.box = ownFdr;
	}
	
	/**
	 * Column Info
	 * @param cm2Cost
	 */
	public void setCm2Cost(String cm2Cost) {
		this.box = cm2Cost;
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
		setRev(JSPUtil.getParameter(request, prefix + "rev", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOpb(JSPUtil.getParameter(request, prefix + "opb", ""));
		setOpCost(JSPUtil.getParameter(request, prefix + "op_cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCRepCd(JSPUtil.getParameter(request, prefix + "c_rep_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRevPodCd(JSPUtil.getParameter(request, prefix + "rev_pod_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setOp(JSPUtil.getParameter(request, prefix + "op", ""));
		setLOfcCd(JSPUtil.getParameter(request, prefix + "l_ofc_cd", ""));
		setCmCost(JSPUtil.getParameter(request, prefix + "cm_cost", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setLRepCd(JSPUtil.getParameter(request, prefix + "l_rep_cd", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setSpclCntrTpszCd(JSPUtil.getParameter(request, prefix + "spcl_cntr_tpsz_cd", ""));
		setCOfcCd(JSPUtil.getParameter(request, prefix + "c_ofc_cd", ""));
		setGrpb(JSPUtil.getParameter(request, prefix + "grpb", ""));
		setRevPolCd(JSPUtil.getParameter(request, prefix + "rev_pol_cd", ""));
		setLoad(JSPUtil.getParameter(request, prefix + "load", ""));
		setBox(JSPUtil.getParameter(request, prefix + "box", ""));
		setCm2(JSPUtil.getParameter(request, prefix + "cm2", ""));
		setOwnFdr(JSPUtil.getParameter(request, prefix + "own_fdr", ""));
		setCm2Cost(JSPUtil.getParameter(request, prefix + "cm2_cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyBKGView0078ListVO[]
	 */
	public SearchDailyBKGView0078ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyBKGView0078ListVO[]
	 */
	public SearchDailyBKGView0078ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyBKGView0078ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cRepCd = (JSPUtil.getParameter(request, prefix	+ "c_rep_cd", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] revPodCd = (JSPUtil.getParameter(request, prefix	+ "rev_pod_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] lOfcCd = (JSPUtil.getParameter(request, prefix	+ "l_ofc_cd", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] lRepCd = (JSPUtil.getParameter(request, prefix	+ "l_rep_cd", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] spclCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_tpsz_cd", length));
			String[] cOfcCd = (JSPUtil.getParameter(request, prefix	+ "c_ofc_cd", length));
			String[] grpb = (JSPUtil.getParameter(request, prefix	+ "grpb", length));
			String[] revPolCd = (JSPUtil.getParameter(request, prefix	+ "rev_pol_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] box = (JSPUtil.getParameter(request, prefix	+ "box", length));
			String[] cm2 = (JSPUtil.getParameter(request, prefix	+ "cm2", length));
			String[] ownFdr = (JSPUtil.getParameter(request, prefix	+ "own_fdr", length));
			String[] cm2Cost = (JSPUtil.getParameter(request, prefix	+ "cm2_cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyBKGView0078ListVO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (opb[i] != null)
					model.setOpb(opb[i]);
				if (opCost[i] != null)
					model.setOpCost(opCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cRepCd[i] != null)
					model.setCRepCd(cRepCd[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (revPodCd[i] != null)
					model.setRevPodCd(revPodCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (lOfcCd[i] != null)
					model.setLOfcCd(lOfcCd[i]);
				if (cmCost[i] != null)
					model.setCmCost(cmCost[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (lRepCd[i] != null)
					model.setLRepCd(lRepCd[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (spclCntrTpszCd[i] != null)
					model.setSpclCntrTpszCd(spclCntrTpszCd[i]);
				if (cOfcCd[i] != null)
					model.setCOfcCd(cOfcCd[i]);
				if (grpb[i] != null)
					model.setGrpb(grpb[i]);
				if (revPolCd[i] != null)
					model.setRevPolCd(revPolCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (box[i] != null)
					model.setBox(box[i]);
				if (cm2[i] != null)
					model.setCm2(cm2[i]);
				if (ownFdr[i] != null)
					model.setOwnFdr(ownFdr[i]);
				if (cm2Cost[i] != null)
					model.setCm2Cost(cm2Cost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyBKGView0078ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyBKGView0078ListVO[]
	 */
	public SearchDailyBKGView0078ListVO[] getSearchDailyBKGView0078ListVOs(){
		SearchDailyBKGView0078ListVO[] vos = (SearchDailyBKGView0078ListVO[])models.toArray(new SearchDailyBKGView0078ListVO[models.size()]);
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
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cRepCd = this.cRepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPodCd = this.revPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcCd = this.lOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRepCd = this.lRepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrTpszCd = this.spclCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOfcCd = this.cOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpb = this.grpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPolCd = this.revPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.box = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm2 = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownFdr = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm2Cost = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}


