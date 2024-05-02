/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RdrLoadVO.java
*@FileTitle : RdrLoadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.05.08 김창헌 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 김창헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RdrLoadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RdrLoadVO> models = new ArrayList<RdrLoadVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String emptyTeu = null;
	/* Column Info */
	private String adjustTeu = null;
	/* Column Info */
	private String joVoidTeuQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String alcAlloc = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String joShrtLegRmkWgt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String swapSlot = null;
	/* Column Info */
	private String remarkCont = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preFr = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alcWgt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bsa45 = null;
	/* Column Info */
	private String actSlot = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String joRfIptQty = null;
	/* Column Info */
	private String sumFlg = null;
	/* Column Info */
	private String rO = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String swapWgt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String joShrtLegRmkDiffQty = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String joShrtLegRmkTeuQty = null;
	/* Column Info */
	private String bsaHc40 = null;
	/* Column Info */
	private String rI = null;
	/* Column Info */
	private String overWgt = null;
	/* Column Info */
	private String joRfOcnQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String emptyWt = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String bsaHc20 = null;
	/* Column Info */
	private String load20 = null;
	/* Column Info */
	private String adjustWt = null;
	/* Column Info */
	private String load40 = null;
	/* Column Info */
	private String joSltRlseCd = null;
	/* Column Info */
	private String load45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RdrLoadVO() {}

	public RdrLoadVO(String ibflag, String pagerows, String actSlot, String actWgt, String adjustTeu, String adjustWt, String alcAlloc, String alcWgt, String bsa45, String bsaHc20, String bsaHc40, String dirCd, String emptyTeu, String emptyWt, String joRfIptQty, String joRfOcnQty, String joShrtLegRmkDiffQty, String joShrtLegRmkTeuQty, String joShrtLegRmkWgt, String joSltRlseCd, String joVoidTeuQty, String load20, String load40, String load45, String oprCd, String overSlot, String overWgt, String portCd, String preFr, String preTo, String region, String remark, String remarkCont, String rlaneCd, String rI, String rO, String superCd1, String swapSlot, String swapWgt, String usrId, String voyNo, String vpsEtdDt, String vslCd, String vvd, String source, String skdDirCd, String sumFlg) {
		this.region = region;
		this.emptyTeu = emptyTeu;
		this.adjustTeu = adjustTeu;
		this.joVoidTeuQty = joVoidTeuQty;
		this.vslCd = vslCd;
		this.alcAlloc = alcAlloc;
		this.remark = remark;
		this.joShrtLegRmkWgt = joShrtLegRmkWgt;
		this.rlaneCd = rlaneCd;
		this.swapSlot = swapSlot;
		this.remarkCont = remarkCont;
		this.pagerows = pagerows;
		this.preFr = preFr;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.alcWgt = alcWgt;
		this.usrId = usrId;
		this.bsa45 = bsa45;
		this.actSlot = actSlot;
		this.dirCd = dirCd;
		this.portCd = portCd;
		this.joRfIptQty = joRfIptQty;
		this.sumFlg = sumFlg;
		this.rO = rO;
		this.voyNo = voyNo;
		this.swapWgt = swapWgt;
		this.vpsEtdDt = vpsEtdDt;
		this.joShrtLegRmkDiffQty = joShrtLegRmkDiffQty;
		this.superCd1 = superCd1;
		this.joShrtLegRmkTeuQty = joShrtLegRmkTeuQty;
		this.bsaHc40 = bsaHc40;
		this.rI = rI;
		this.overWgt = overWgt;
		this.joRfOcnQty = joRfOcnQty;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.vvd = vvd;
		this.emptyWt = emptyWt;
		this.source = source;
		this.preTo = preTo;
		this.oprCd = oprCd;
		this.bsaHc20 = bsaHc20;
		this.load20 = load20;
		this.adjustWt = adjustWt;
		this.load40 = load40;
		this.joSltRlseCd = joSltRlseCd;
		this.load45 = load45;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("empty_teu", getEmptyTeu());
		this.hashColumns.put("adjust_teu", getAdjustTeu());
		this.hashColumns.put("jo_void_teu_qty", getJoVoidTeuQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("alc_alloc", getAlcAlloc());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("jo_shrt_leg_rmk_wgt", getJoShrtLegRmkWgt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("swap_slot", getSwapSlot());
		this.hashColumns.put("remark_cont", getRemarkCont());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("alc_wgt", getAlcWgt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bsa_45", getBsa45());
		this.hashColumns.put("act_slot", getActSlot());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("jo_rf_ipt_qty", getJoRfIptQty());
		this.hashColumns.put("sum_flg", getSumFlg());
		this.hashColumns.put("r_o", getRO());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("swap_wgt", getSwapWgt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("jo_shrt_leg_rmk_diff_qty", getJoShrtLegRmkDiffQty());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("jo_shrt_leg_rmk_teu_qty", getJoShrtLegRmkTeuQty());
		this.hashColumns.put("bsa_hc40", getBsaHc40());
		this.hashColumns.put("r_i", getRI());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("jo_rf_ocn_qty", getJoRfOcnQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("empty_wt", getEmptyWt());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("bsa_hc20", getBsaHc20());
		this.hashColumns.put("load_20", getLoad20());
		this.hashColumns.put("adjust_wt", getAdjustWt());
		this.hashColumns.put("load_40", getLoad40());
		this.hashColumns.put("jo_slt_rlse_cd", getJoSltRlseCd());
		this.hashColumns.put("load_45", getLoad45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("empty_teu", "emptyTeu");
		this.hashFields.put("adjust_teu", "adjustTeu");
		this.hashFields.put("jo_void_teu_qty", "joVoidTeuQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("alc_alloc", "alcAlloc");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("jo_shrt_leg_rmk_wgt", "joShrtLegRmkWgt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("swap_slot", "swapSlot");
		this.hashFields.put("remark_cont", "remarkCont");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("alc_wgt", "alcWgt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bsa_45", "bsa45");
		this.hashFields.put("act_slot", "actSlot");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("jo_rf_ipt_qty", "joRfIptQty");
		this.hashFields.put("sum_flg", "sumFlg");
		this.hashFields.put("r_o", "rO");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("swap_wgt", "swapWgt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("jo_shrt_leg_rmk_diff_qty", "joShrtLegRmkDiffQty");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("jo_shrt_leg_rmk_teu_qty", "joShrtLegRmkTeuQty");
		this.hashFields.put("bsa_hc40", "bsaHc40");
		this.hashFields.put("r_i", "rI");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("jo_rf_ocn_qty", "joRfOcnQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("empty_wt", "emptyWt");
		this.hashFields.put("source", "source");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("bsa_hc20", "bsaHc20");
		this.hashFields.put("load_20", "load20");
		this.hashFields.put("adjust_wt", "adjustWt");
		this.hashFields.put("load_40", "load40");
		this.hashFields.put("jo_slt_rlse_cd", "joSltRlseCd");
		this.hashFields.put("load_45", "load45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return emptyTeu
	 */
	public String getEmptyTeu() {
		return this.emptyTeu;
	}
	
	/**
	 * Column Info
	 * @return adjustTeu
	 */
	public String getAdjustTeu() {
		return this.adjustTeu;
	}
	
	/**
	 * Column Info
	 * @return joVoidTeuQty
	 */
	public String getJoVoidTeuQty() {
		return this.joVoidTeuQty;
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
	 * @return alcAlloc
	 */
	public String getAlcAlloc() {
		return this.alcAlloc;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkWgt
	 */
	public String getJoShrtLegRmkWgt() {
		return this.joShrtLegRmkWgt;
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
	 * @return swapSlot
	 */
	public String getSwapSlot() {
		return this.swapSlot;
	}
	
	/**
	 * Column Info
	 * @return remarkCont
	 */
	public String getRemarkCont() {
		return this.remarkCont;
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
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
	}
	
	/**
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return alcWgt
	 */
	public String getAlcWgt() {
		return this.alcWgt;
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
	 * @return bsa45
	 */
	public String getBsa45() {
		return this.bsa45;
	}
	
	/**
	 * Column Info
	 * @return actSlot
	 */
	public String getActSlot() {
		return this.actSlot;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return joRfIptQty
	 */
	public String getJoRfIptQty() {
		return this.joRfIptQty;
	}
	
	/**
	 * Column Info
	 * @return sumFlg
	 */
	public String getSumFlg() {
		return this.sumFlg;
	}
	
	/**
	 * Column Info
	 * @return rO
	 */
	public String getRO() {
		return this.rO;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return swapWgt
	 */
	public String getSwapWgt() {
		return this.swapWgt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkDiffQty
	 */
	public String getJoShrtLegRmkDiffQty() {
		return this.joShrtLegRmkDiffQty;
	}
	
	/**
	 * Column Info
	 * @return superCd1
	 */
	public String getSuperCd1() {
		return this.superCd1;
	}
	
	/**
	 * Column Info
	 * @return joShrtLegRmkTeuQty
	 */
	public String getJoShrtLegRmkTeuQty() {
		return this.joShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @return bsaHc40
	 */
	public String getBsaHc40() {
		return this.bsaHc40;
	}
	
	/**
	 * Column Info
	 * @return rI
	 */
	public String getRI() {
		return this.rI;
	}
	
	/**
	 * Column Info
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
	}
	
	/**
	 * Column Info
	 * @return joRfOcnQty
	 */
	public String getJoRfOcnQty() {
		return this.joRfOcnQty;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return emptyWt
	 */
	public String getEmptyWt() {
		return this.emptyWt;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return bsaHc20
	 */
	public String getBsaHc20() {
		return this.bsaHc20;
	}
	
	/**
	 * Column Info
	 * @return load20
	 */
	public String getLoad20() {
		return this.load20;
	}
	
	/**
	 * Column Info
	 * @return adjustWt
	 */
	public String getAdjustWt() {
		return this.adjustWt;
	}
	
	/**
	 * Column Info
	 * @return load40
	 */
	public String getLoad40() {
		return this.load40;
	}
	
	/**
	 * Column Info
	 * @return joSltRlseCd
	 */
	public String getJoSltRlseCd() {
		return this.joSltRlseCd;
	}
	
	/**
	 * Column Info
	 * @return load45
	 */
	public String getLoad45() {
		return this.load45;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param emptyTeu
	 */
	public void setEmptyTeu(String emptyTeu) {
		this.emptyTeu = emptyTeu;
	}
	
	/**
	 * Column Info
	 * @param adjustTeu
	 */
	public void setAdjustTeu(String adjustTeu) {
		this.adjustTeu = adjustTeu;
	}
	
	/**
	 * Column Info
	 * @param joVoidTeuQty
	 */
	public void setJoVoidTeuQty(String joVoidTeuQty) {
		this.joVoidTeuQty = joVoidTeuQty;
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
	 * @param alcAlloc
	 */
	public void setAlcAlloc(String alcAlloc) {
		this.alcAlloc = alcAlloc;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkWgt
	 */
	public void setJoShrtLegRmkWgt(String joShrtLegRmkWgt) {
		this.joShrtLegRmkWgt = joShrtLegRmkWgt;
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
	 * @param swapSlot
	 */
	public void setSwapSlot(String swapSlot) {
		this.swapSlot = swapSlot;
	}
	
	/**
	 * Column Info
	 * @param remarkCont
	 */
	public void setRemarkCont(String remarkCont) {
		this.remarkCont = remarkCont;
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
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
	}
	
	/**
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param alcWgt
	 */
	public void setAlcWgt(String alcWgt) {
		this.alcWgt = alcWgt;
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
	 * @param bsa45
	 */
	public void setBsa45(String bsa45) {
		this.bsa45 = bsa45;
	}
	
	/**
	 * Column Info
	 * @param actSlot
	 */
	public void setActSlot(String actSlot) {
		this.actSlot = actSlot;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param joRfIptQty
	 */
	public void setJoRfIptQty(String joRfIptQty) {
		this.joRfIptQty = joRfIptQty;
	}
	
	/**
	 * Column Info
	 * @param sumFlg
	 */
	public void setSumFlg(String sumFlg) {
		this.sumFlg = sumFlg;
	}
	
	/**
	 * Column Info
	 * @param rO
	 */
	public void setRO(String rO) {
		this.rO = rO;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param swapWgt
	 */
	public void setSwapWgt(String swapWgt) {
		this.swapWgt = swapWgt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkDiffQty
	 */
	public void setJoShrtLegRmkDiffQty(String joShrtLegRmkDiffQty) {
		this.joShrtLegRmkDiffQty = joShrtLegRmkDiffQty;
	}
	
	/**
	 * Column Info
	 * @param superCd1
	 */
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
	}
	
	/**
	 * Column Info
	 * @param joShrtLegRmkTeuQty
	 */
	public void setJoShrtLegRmkTeuQty(String joShrtLegRmkTeuQty) {
		this.joShrtLegRmkTeuQty = joShrtLegRmkTeuQty;
	}
	
	/**
	 * Column Info
	 * @param bsaHc40
	 */
	public void setBsaHc40(String bsaHc40) {
		this.bsaHc40 = bsaHc40;
	}
	
	/**
	 * Column Info
	 * @param rI
	 */
	public void setRI(String rI) {
		this.rI = rI;
	}
	
	/**
	 * Column Info
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
	}
	
	/**
	 * Column Info
	 * @param joRfOcnQty
	 */
	public void setJoRfOcnQty(String joRfOcnQty) {
		this.joRfOcnQty = joRfOcnQty;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param emptyWt
	 */
	public void setEmptyWt(String emptyWt) {
		this.emptyWt = emptyWt;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param bsaHc20
	 */
	public void setBsaHc20(String bsaHc20) {
		this.bsaHc20 = bsaHc20;
	}
	
	/**
	 * Column Info
	 * @param load20
	 */
	public void setLoad20(String load20) {
		this.load20 = load20;
	}
	
	/**
	 * Column Info
	 * @param adjustWt
	 */
	public void setAdjustWt(String adjustWt) {
		this.adjustWt = adjustWt;
	}
	
	/**
	 * Column Info
	 * @param load40
	 */
	public void setLoad40(String load40) {
		this.load40 = load40;
	}
	
	/**
	 * Column Info
	 * @param joSltRlseCd
	 */
	public void setJoSltRlseCd(String joSltRlseCd) {
		this.joSltRlseCd = joSltRlseCd;
	}
	
	/**
	 * Column Info
	 * @param load45
	 */
	public void setLoad45(String load45) {
		this.load45 = load45;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setEmptyTeu(JSPUtil.getParameter(request, prefix + "empty_teu", ""));
		setAdjustTeu(JSPUtil.getParameter(request, prefix + "adjust_teu", ""));
		setJoVoidTeuQty(JSPUtil.getParameter(request, prefix + "jo_void_teu_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAlcAlloc(JSPUtil.getParameter(request, prefix + "alc_alloc", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setJoShrtLegRmkWgt(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_wgt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setSwapSlot(JSPUtil.getParameter(request, prefix + "swap_slot", ""));
		setRemarkCont(JSPUtil.getParameter(request, prefix + "remark_cont", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setOverSlot(JSPUtil.getParameter(request, prefix + "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlcWgt(JSPUtil.getParameter(request, prefix + "alc_wgt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBsa45(JSPUtil.getParameter(request, prefix + "bsa_45", ""));
		setActSlot(JSPUtil.getParameter(request, prefix + "act_slot", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setJoRfIptQty(JSPUtil.getParameter(request, prefix + "jo_rf_ipt_qty", ""));
		setSumFlg(JSPUtil.getParameter(request, prefix + "sum_flg", ""));
		setRO(JSPUtil.getParameter(request, prefix + "r_o", ""));
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setSwapWgt(JSPUtil.getParameter(request, prefix + "swap_wgt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setJoShrtLegRmkDiffQty(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_diff_qty", ""));
		setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
		setJoShrtLegRmkTeuQty(JSPUtil.getParameter(request, prefix + "jo_shrt_leg_rmk_teu_qty", ""));
		setBsaHc40(JSPUtil.getParameter(request, prefix + "bsa_hc40", ""));
		setRI(JSPUtil.getParameter(request, prefix + "r_i", ""));
		setOverWgt(JSPUtil.getParameter(request, prefix + "over_wgt", ""));
		setJoRfOcnQty(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEmptyWt(JSPUtil.getParameter(request, prefix + "empty_wt", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setBsaHc20(JSPUtil.getParameter(request, prefix + "bsa_hc20", ""));
		setLoad20(JSPUtil.getParameter(request, prefix + "load_20", ""));
		setAdjustWt(JSPUtil.getParameter(request, prefix + "adjust_wt", ""));
		setLoad40(JSPUtil.getParameter(request, prefix + "load_40", ""));
		setJoSltRlseCd(JSPUtil.getParameter(request, prefix + "jo_slt_rlse_cd", ""));
		setLoad45(JSPUtil.getParameter(request, prefix + "load_45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RdrLoadVO[]
	 */
	public RdrLoadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RdrLoadVO[]
	 */
	public RdrLoadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RdrLoadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] emptyTeu = (JSPUtil.getParameter(request, prefix	+ "empty_teu", length));
			String[] adjustTeu = (JSPUtil.getParameter(request, prefix	+ "adjust_teu", length));
			String[] joVoidTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_void_teu_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] alcAlloc = (JSPUtil.getParameter(request, prefix	+ "alc_alloc", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] joShrtLegRmkWgt = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_wgt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] swapSlot = (JSPUtil.getParameter(request, prefix	+ "swap_slot", length));
			String[] remarkCont = (JSPUtil.getParameter(request, prefix	+ "remark_cont", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alcWgt = (JSPUtil.getParameter(request, prefix	+ "alc_wgt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bsa45 = (JSPUtil.getParameter(request, prefix	+ "bsa_45", length));
			String[] actSlot = (JSPUtil.getParameter(request, prefix	+ "act_slot", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] joRfIptQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ipt_qty", length));
			String[] sumFlg = (JSPUtil.getParameter(request, prefix	+ "sum_flg", length));
			String[] rO = (JSPUtil.getParameter(request, prefix	+ "r_o", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] swapWgt = (JSPUtil.getParameter(request, prefix	+ "swap_wgt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] joShrtLegRmkDiffQty = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_diff_qty", length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1", length));
			String[] joShrtLegRmkTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_shrt_leg_rmk_teu_qty", length));
			String[] bsaHc40 = (JSPUtil.getParameter(request, prefix	+ "bsa_hc40", length));
			String[] rI = (JSPUtil.getParameter(request, prefix	+ "r_i", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] joRfOcnQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] emptyWt = (JSPUtil.getParameter(request, prefix	+ "empty_wt", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] bsaHc20 = (JSPUtil.getParameter(request, prefix	+ "bsa_hc20", length));
			String[] load20 = (JSPUtil.getParameter(request, prefix	+ "load_20", length));
			String[] adjustWt = (JSPUtil.getParameter(request, prefix	+ "adjust_wt", length));
			String[] load40 = (JSPUtil.getParameter(request, prefix	+ "load_40", length));
			String[] joSltRlseCd = (JSPUtil.getParameter(request, prefix	+ "jo_slt_rlse_cd", length));
			String[] load45 = (JSPUtil.getParameter(request, prefix	+ "load_45", length));
			
			for (int i = 0; i < length; i++) {
				model = new RdrLoadVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (emptyTeu[i] != null)
					model.setEmptyTeu(emptyTeu[i]);
				if (adjustTeu[i] != null)
					model.setAdjustTeu(adjustTeu[i]);
				if (joVoidTeuQty[i] != null)
					model.setJoVoidTeuQty(joVoidTeuQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (alcAlloc[i] != null)
					model.setAlcAlloc(alcAlloc[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (joShrtLegRmkWgt[i] != null)
					model.setJoShrtLegRmkWgt(joShrtLegRmkWgt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (swapSlot[i] != null)
					model.setSwapSlot(swapSlot[i]);
				if (remarkCont[i] != null)
					model.setRemarkCont(remarkCont[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alcWgt[i] != null)
					model.setAlcWgt(alcWgt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bsa45[i] != null)
					model.setBsa45(bsa45[i]);
				if (actSlot[i] != null)
					model.setActSlot(actSlot[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (joRfIptQty[i] != null)
					model.setJoRfIptQty(joRfIptQty[i]);
				if (sumFlg[i] != null)
					model.setSumFlg(sumFlg[i]);
				if (rO[i] != null)
					model.setRO(rO[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (swapWgt[i] != null)
					model.setSwapWgt(swapWgt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (joShrtLegRmkDiffQty[i] != null)
					model.setJoShrtLegRmkDiffQty(joShrtLegRmkDiffQty[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (joShrtLegRmkTeuQty[i] != null)
					model.setJoShrtLegRmkTeuQty(joShrtLegRmkTeuQty[i]);
				if (bsaHc40[i] != null)
					model.setBsaHc40(bsaHc40[i]);
				if (rI[i] != null)
					model.setRI(rI[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (joRfOcnQty[i] != null)
					model.setJoRfOcnQty(joRfOcnQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (emptyWt[i] != null)
					model.setEmptyWt(emptyWt[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (bsaHc20[i] != null)
					model.setBsaHc20(bsaHc20[i]);
				if (load20[i] != null)
					model.setLoad20(load20[i]);
				if (adjustWt[i] != null)
					model.setAdjustWt(adjustWt[i]);
				if (load40[i] != null)
					model.setLoad40(load40[i]);
				if (joSltRlseCd[i] != null)
					model.setJoSltRlseCd(joSltRlseCd[i]);
				if (load45[i] != null)
					model.setLoad45(load45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRdrLoadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RdrLoadVO[]
	 */
	public RdrLoadVO[] getRdrLoadVOs(){
		RdrLoadVO[] vos = (RdrLoadVO[])models.toArray(new RdrLoadVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyTeu = this.emptyTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustTeu = this.adjustTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joVoidTeuQty = this.joVoidTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcAlloc = this.alcAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkWgt = this.joShrtLegRmkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapSlot = this.swapSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkCont = this.remarkCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcWgt = this.alcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa45 = this.bsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSlot = this.actSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfIptQty = this.joRfIptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumFlg = this.sumFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rO = this.rO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapWgt = this.swapWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkDiffQty = this.joShrtLegRmkDiffQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joShrtLegRmkTeuQty = this.joShrtLegRmkTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaHc40 = this.bsaHc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rI = this.rI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnQty = this.joRfOcnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyWt = this.emptyWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaHc20 = this.bsaHc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load20 = this.load20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustWt = this.adjustWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load40 = this.load40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSltRlseCd = this.joSltRlseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load45 = this.load45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
