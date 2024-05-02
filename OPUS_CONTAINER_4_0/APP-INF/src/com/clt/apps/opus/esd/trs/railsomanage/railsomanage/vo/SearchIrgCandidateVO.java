/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchIrgCandidateVO.java
*@FileTitle : SearchIrgCandidateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.08.28 최진오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchIrgCandidateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	 
	private Collection<SearchIrgCandidateVO> models = new ArrayList<SearchIrgCandidateVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String polpod = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String newRoutOrg = null;
	/* Column Info */
	private String newFmNodYard = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String newRailCmbThruTpCd = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String newRoutDest = null;
	/* Column Info */
	private String keyOrg = null;
	/* Column Info */
	private String toNode = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newToNodYard = null;
	/* Column Info */
	private String newRoutSeq = null;
	/* Column Info */
	private String bkgRcvdeTermCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String interchange1Loc = null;
	/* Column Info */
	private String newInlndRoutRmk = null;
	/* Column Info */
	private String newRoutPlnCd = null;
	/* Column Info */
	private String railCmbThruTpCd = null;
	/* Column Info */
	private String interchange1Nod = null;
	/* Column Info */
	private String keyDest = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String newFmNodCd = null;
	/* Column Info */
	private String newToNodCd = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String interchange2Loc = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String newIrg = null;
	/* Column Info */
	private String irg = null;
	/* Column Info */
	private String irgDropdownlist = null;
	/* Column Info */
	private String newRefNo = null;
	/* Column Info */
	private String fromNode = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String newPrioSeq = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String interchange2Nod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIrgCandidateVO() {}

	public SearchIrgCandidateVO(String ibflag, String pagerows, String seq, String bkgRcvdeTermCd, String polpod, String fmNodCd, String fmNodYard, String toNodCd, String toNodYard, String irg, String routPlnCd, String refNo, String inlndRoutRmk, String irgDropdownlist, String newRoutOrg, String newRoutDest, String newRoutSeq, String newPrioSeq, String newIrg, String newFmNodCd, String newFmNodYard, String newToNodCd, String newToNodYard, String newRoutPlnCd, String newRefNo, String newInlndRoutRmk, String newRailCmbThruTpCd, String fromNode, String toNode, String routOrgNodCd, String routDestNodCd, String routSeq, String prioSeq, String cgoTpCd, String railCmbThruTpCd, String trspBndCd, String keyOrg, String keyDest, String interchange1Loc, String interchange1Nod, String interchange2Loc, String interchange2Nod) {
		this.toNodCd = toNodCd;
		this.polpod = polpod;
		this.toNodYard = toNodYard;
		this.cgoTpCd = cgoTpCd;
		this.newRoutOrg = newRoutOrg;
		this.newFmNodYard = newFmNodYard;
		this.routOrgNodCd = routOrgNodCd;
		this.newRailCmbThruTpCd = newRailCmbThruTpCd;
		this.fmNodYard = fmNodYard;
		this.newRoutDest = newRoutDest;
		this.keyOrg = keyOrg;
		this.toNode = toNode;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.newToNodYard = newToNodYard;
		this.newRoutSeq = newRoutSeq;
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
		this.routDestNodCd = routDestNodCd;
		this.interchange1Loc = interchange1Loc;
		this.newInlndRoutRmk = newInlndRoutRmk;
		this.newRoutPlnCd = newRoutPlnCd;
		this.railCmbThruTpCd = railCmbThruTpCd;
		this.interchange1Nod = interchange1Nod;
		this.keyDest = keyDest;
		this.trspBndCd = trspBndCd;
		this.newFmNodCd = newFmNodCd;
		this.newToNodCd = newToNodCd;
		this.routPlnCd = routPlnCd;
		this.routSeq = routSeq;
		this.interchange2Loc = interchange2Loc;
		this.fmNodCd = fmNodCd;
		this.inlndRoutRmk = inlndRoutRmk;
		this.newIrg = newIrg;
		this.irg = irg;
		this.irgDropdownlist = irgDropdownlist;
		this.newRefNo = newRefNo;
		this.fromNode = fromNode;
		this.refNo = refNo;
		this.seq = seq;
		this.newPrioSeq = newPrioSeq;
		this.prioSeq = prioSeq;
		this.interchange2Nod = interchange2Nod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("polpod", getPolpod());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("new_rout_org", getNewRoutOrg());
		this.hashColumns.put("new_fm_nod_yard", getNewFmNodYard());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("new_rail_cmb_thru_tp_cd", getNewRailCmbThruTpCd());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("new_rout_dest", getNewRoutDest());
		this.hashColumns.put("key_org", getKeyOrg());
		this.hashColumns.put("to_node", getToNode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_to_nod_yard", getNewToNodYard());
		this.hashColumns.put("new_rout_seq", getNewRoutSeq());
		this.hashColumns.put("bkg_rcvde_term_cd", getBkgRcvdeTermCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("interchange1_loc", getInterchange1Loc());
		this.hashColumns.put("new_inlnd_rout_rmk", getNewInlndRoutRmk());
		this.hashColumns.put("new_rout_pln_cd", getNewRoutPlnCd());
		this.hashColumns.put("rail_cmb_thru_tp_cd", getRailCmbThruTpCd());
		this.hashColumns.put("interchange1_nod", getInterchange1Nod());
		this.hashColumns.put("key_dest", getKeyDest());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("new_fm_nod_cd", getNewFmNodCd());
		this.hashColumns.put("new_to_nod_cd", getNewToNodCd());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("interchange2_loc", getInterchange2Loc());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("new_irg", getNewIrg());
		this.hashColumns.put("irg", getIrg());
		this.hashColumns.put("irg_dropdownlist", getIrgDropdownlist());
		this.hashColumns.put("new_ref_no", getNewRefNo());
		this.hashColumns.put("from_node", getFromNode());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("new_prio_seq", getNewPrioSeq());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("interchange2_nod", getInterchange2Nod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("polpod", "polpod");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("new_rout_org", "newRoutOrg");
		this.hashFields.put("new_fm_nod_yard", "newFmNodYard");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("new_rail_cmb_thru_tp_cd", "newRailCmbThruTpCd");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("new_rout_dest", "newRoutDest");
		this.hashFields.put("key_org", "keyOrg");
		this.hashFields.put("to_node", "toNode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_to_nod_yard", "newToNodYard");
		this.hashFields.put("new_rout_seq", "newRoutSeq");
		this.hashFields.put("bkg_rcvde_term_cd", "bkgRcvdeTermCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("interchange1_loc", "interchange1Loc");
		this.hashFields.put("new_inlnd_rout_rmk", "newInlndRoutRmk");
		this.hashFields.put("new_rout_pln_cd", "newRoutPlnCd");
		this.hashFields.put("rail_cmb_thru_tp_cd", "railCmbThruTpCd");
		this.hashFields.put("interchange1_nod", "interchange1Nod");
		this.hashFields.put("key_dest", "keyDest");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("new_fm_nod_cd", "newFmNodCd");
		this.hashFields.put("new_to_nod_cd", "newToNodCd");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("interchange2_loc", "interchange2Loc");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("new_irg", "newIrg");
		this.hashFields.put("irg", "irg");
		this.hashFields.put("irg_dropdownlist", "irgDropdownlist");
		this.hashFields.put("new_ref_no", "newRefNo");
		this.hashFields.put("from_node", "fromNode");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("new_prio_seq", "newPrioSeq");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("interchange2_nod", "interchange2Nod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return polpod
	 */
	public String getPolpod() {
		return this.polpod;
	}
	
	/**
	 * Column Info
	 * @return toNodYard
	 */
	public String getToNodYard() {
		return this.toNodYard;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return newRoutOrg
	 */
	public String getNewRoutOrg() {
		return this.newRoutOrg;
	}
	
	/**
	 * Column Info
	 * @return newFmNodYard
	 */
	public String getNewFmNodYard() {
		return this.newFmNodYard;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return newRailCmbThruTpCd
	 */
	public String getNewRailCmbThruTpCd() {
		return this.newRailCmbThruTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodYard
	 */
	public String getFmNodYard() {
		return this.fmNodYard;
	}
	
	/**
	 * Column Info
	 * @return newRoutDest
	 */
	public String getNewRoutDest() {
		return this.newRoutDest;
	}
	
	/**
	 * Column Info
	 * @return keyOrg
	 */
	public String getKeyOrg() {
		return this.keyOrg;
	}
	
	/**
	 * Column Info
	 * @return toNode
	 */
	public String getToNode() {
		return this.toNode;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return newToNodYard
	 */
	public String getNewToNodYard() {
		return this.newToNodYard;
	}
	
	/**
	 * Column Info
	 * @return newRoutSeq
	 */
	public String getNewRoutSeq() {
		return this.newRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvdeTermCd
	 */
	public String getBkgRcvdeTermCd() {
		return this.bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return interchange1Loc
	 */
	public String getInterchange1Loc() {
		return this.interchange1Loc;
	}
	
	/**
	 * Column Info
	 * @return newInlndRoutRmk
	 */
	public String getNewInlndRoutRmk() {
		return this.newInlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return newRoutPlnCd
	 */
	public String getNewRoutPlnCd() {
		return this.newRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @return railCmbThruTpCd
	 */
	public String getRailCmbThruTpCd() {
		return this.railCmbThruTpCd;
	}
	
	/**
	 * Column Info
	 * @return interchange1Nod
	 */
	public String getInterchange1Nod() {
		return this.interchange1Nod;
	}
	
	/**
	 * Column Info
	 * @return keyDest
	 */
	public String getKeyDest() {
		return this.keyDest;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return newFmNodCd
	 */
	public String getNewFmNodCd() {
		return this.newFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return newToNodCd
	 */
	public String getNewToNodCd() {
		return this.newToNodCd;
	}
	
	/**
	 * Column Info
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return interchange2Loc
	 */
	public String getInterchange2Loc() {
		return this.interchange2Loc;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return newIrg
	 */
	public String getNewIrg() {
		return this.newIrg;
	}
	
	/**
	 * Column Info
	 * @return irg
	 */
	public String getIrg() {
		return this.irg;
	}
	
	/**
	 * Column Info
	 * @return irgDropdownlist
	 */
	public String getIrgDropdownlist() {
		return this.irgDropdownlist;
	}
	
	/**
	 * Column Info
	 * @return newRefNo
	 */
	public String getNewRefNo() {
		return this.newRefNo;
	}
	
	/**
	 * Column Info
	 * @return fromNode
	 */
	public String getFromNode() {
		return this.fromNode;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return newPrioSeq
	 */
	public String getNewPrioSeq() {
		return this.newPrioSeq;
	}
	
	/**
	 * Column Info
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return interchange2Nod
	 */
	public String getInterchange2Nod() {
		return this.interchange2Nod;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param polpod
	 */
	public void setPolpod(String polpod) {
		this.polpod = polpod;
	}
	
	/**
	 * Column Info
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param newRoutOrg
	 */
	public void setNewRoutOrg(String newRoutOrg) {
		this.newRoutOrg = newRoutOrg;
	}
	
	/**
	 * Column Info
	 * @param newFmNodYard
	 */
	public void setNewFmNodYard(String newFmNodYard) {
		this.newFmNodYard = newFmNodYard;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param newRailCmbThruTpCd
	 */
	public void setNewRailCmbThruTpCd(String newRailCmbThruTpCd) {
		this.newRailCmbThruTpCd = newRailCmbThruTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
	}
	
	/**
	 * Column Info
	 * @param newRoutDest
	 */
	public void setNewRoutDest(String newRoutDest) {
		this.newRoutDest = newRoutDest;
	}
	
	/**
	 * Column Info
	 * @param keyOrg
	 */
	public void setKeyOrg(String keyOrg) {
		this.keyOrg = keyOrg;
	}
	
	/**
	 * Column Info
	 * @param toNode
	 */
	public void setToNode(String toNode) {
		this.toNode = toNode;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param newToNodYard
	 */
	public void setNewToNodYard(String newToNodYard) {
		this.newToNodYard = newToNodYard;
	}
	
	/**
	 * Column Info
	 * @param newRoutSeq
	 */
	public void setNewRoutSeq(String newRoutSeq) {
		this.newRoutSeq = newRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvdeTermCd
	 */
	public void setBkgRcvdeTermCd(String bkgRcvdeTermCd) {
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param interchange1Loc
	 */
	public void setInterchange1Loc(String interchange1Loc) {
		this.interchange1Loc = interchange1Loc;
	}
	
	/**
	 * Column Info
	 * @param newInlndRoutRmk
	 */
	public void setNewInlndRoutRmk(String newInlndRoutRmk) {
		this.newInlndRoutRmk = newInlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param newRoutPlnCd
	 */
	public void setNewRoutPlnCd(String newRoutPlnCd) {
		this.newRoutPlnCd = newRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @param railCmbThruTpCd
	 */
	public void setRailCmbThruTpCd(String railCmbThruTpCd) {
		this.railCmbThruTpCd = railCmbThruTpCd;
	}
	
	/**
	 * Column Info
	 * @param interchange1Nod
	 */
	public void setInterchange1Nod(String interchange1Nod) {
		this.interchange1Nod = interchange1Nod;
	}
	
	/**
	 * Column Info
	 * @param keyDest
	 */
	public void setKeyDest(String keyDest) {
		this.keyDest = keyDest;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param newFmNodCd
	 */
	public void setNewFmNodCd(String newFmNodCd) {
		this.newFmNodCd = newFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param newToNodCd
	 */
	public void setNewToNodCd(String newToNodCd) {
		this.newToNodCd = newToNodCd;
	}
	
	/**
	 * Column Info
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param interchange2Loc
	 */
	public void setInterchange2Loc(String interchange2Loc) {
		this.interchange2Loc = interchange2Loc;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param newIrg
	 */
	public void setNewIrg(String newIrg) {
		this.newIrg = newIrg;
	}
	
	/**
	 * Column Info
	 * @param irg
	 */
	public void setIrg(String irg) {
		this.irg = irg;
	}
	
	/**
	 * Column Info
	 * @param irgDropdownlist
	 */
	public void setIrgDropdownlist(String irgDropdownlist) {
		this.irgDropdownlist = irgDropdownlist;
	}
	
	/**
	 * Column Info
	 * @param newRefNo
	 */
	public void setNewRefNo(String newRefNo) {
		this.newRefNo = newRefNo;
	}
	
	/**
	 * Column Info
	 * @param fromNode
	 */
	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param newPrioSeq
	 */
	public void setNewPrioSeq(String newPrioSeq) {
		this.newPrioSeq = newPrioSeq;
	}
	
	/**
	 * Column Info
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param interchange2Nod
	 */
	public void setInterchange2Nod(String interchange2Nod) {
		this.interchange2Nod = interchange2Nod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setPolpod(JSPUtil.getParameter(request, "polpod", ""));
		setToNodYard(JSPUtil.getParameter(request, "to_nod_yard", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setNewRoutOrg(JSPUtil.getParameter(request, "new_rout_org", ""));
		setNewFmNodYard(JSPUtil.getParameter(request, "new_fm_nod_yard", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setNewRailCmbThruTpCd(JSPUtil.getParameter(request, "new_rail_cmb_thru_tp_cd", ""));
		setFmNodYard(JSPUtil.getParameter(request, "fm_nod_yard", ""));
		setNewRoutDest(JSPUtil.getParameter(request, "new_rout_dest", ""));
		setKeyOrg(JSPUtil.getParameter(request, "key_org", ""));
		setToNode(JSPUtil.getParameter(request, "to_node", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewToNodYard(JSPUtil.getParameter(request, "new_to_nod_yard", ""));
		setNewRoutSeq(JSPUtil.getParameter(request, "new_rout_seq", ""));
		setBkgRcvdeTermCd(JSPUtil.getParameter(request, "bkg_rcvde_term_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setInterchange1Loc(JSPUtil.getParameter(request, "interchange1_loc", ""));
		setNewInlndRoutRmk(JSPUtil.getParameter(request, "new_inlnd_rout_rmk", ""));
		setNewRoutPlnCd(JSPUtil.getParameter(request, "new_rout_pln_cd", ""));
		setRailCmbThruTpCd(JSPUtil.getParameter(request, "rail_cmb_thru_tp_cd", ""));
		setInterchange1Nod(JSPUtil.getParameter(request, "interchange1_nod", ""));
		setKeyDest(JSPUtil.getParameter(request, "key_dest", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setNewFmNodCd(JSPUtil.getParameter(request, "new_fm_nod_cd", ""));
		setNewToNodCd(JSPUtil.getParameter(request, "new_to_nod_cd", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setInterchange2Loc(JSPUtil.getParameter(request, "interchange2_loc", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setNewIrg(JSPUtil.getParameter(request, "new_irg", ""));
		setIrg(JSPUtil.getParameter(request, "irg", ""));
		setIrgDropdownlist(JSPUtil.getParameter(request, "irg_dropdownlist", ""));
		setNewRefNo(JSPUtil.getParameter(request, "new_ref_no", ""));
		setFromNode(JSPUtil.getParameter(request, "from_node", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setNewPrioSeq(JSPUtil.getParameter(request, "new_prio_seq", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setInterchange2Nod(JSPUtil.getParameter(request, "interchange2_nod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIrgCandidateVO[]
	 */
	public SearchIrgCandidateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIrgCandidateVO[]
	 */
	public SearchIrgCandidateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIrgCandidateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] polpod = (JSPUtil.getParameter(request, prefix	+ "polpod", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix	+ "to_nod_yard", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] newRoutOrg = (JSPUtil.getParameter(request, prefix	+ "new_rout_org", length));
			String[] newFmNodYard = (JSPUtil.getParameter(request, prefix	+ "new_fm_nod_yard", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] newRailCmbThruTpCd = (JSPUtil.getParameter(request, prefix	+ "new_rail_cmb_thru_tp_cd", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yard", length));
			String[] newRoutDest = (JSPUtil.getParameter(request, prefix	+ "new_rout_dest", length));
			String[] keyOrg = (JSPUtil.getParameter(request, prefix	+ "key_org", length));
			String[] toNode = (JSPUtil.getParameter(request, prefix	+ "to_node", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newToNodYard = (JSPUtil.getParameter(request, prefix	+ "new_to_nod_yard", length));
			String[] newRoutSeq = (JSPUtil.getParameter(request, prefix	+ "new_rout_seq", length));
			String[] bkgRcvdeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcvde_term_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] interchange1Loc = (JSPUtil.getParameter(request, prefix	+ "interchange1_loc", length));
			String[] newInlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "new_inlnd_rout_rmk", length));
			String[] newRoutPlnCd = (JSPUtil.getParameter(request, prefix	+ "new_rout_pln_cd", length));
			String[] railCmbThruTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_cmb_thru_tp_cd", length));
			String[] interchange1Nod = (JSPUtil.getParameter(request, prefix	+ "interchange1_nod", length));
			String[] keyDest = (JSPUtil.getParameter(request, prefix	+ "key_dest", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] newFmNodCd = (JSPUtil.getParameter(request, prefix	+ "new_fm_nod_cd", length));
			String[] newToNodCd = (JSPUtil.getParameter(request, prefix	+ "new_to_nod_cd", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix	+ "rout_pln_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] interchange2Loc = (JSPUtil.getParameter(request, prefix	+ "interchange2_loc", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk", length));
			String[] newIrg = (JSPUtil.getParameter(request, prefix	+ "new_irg", length));
			String[] irg = (JSPUtil.getParameter(request, prefix	+ "irg", length));
			String[] irgDropdownlist = (JSPUtil.getParameter(request, prefix	+ "irg_dropdownlist", length));
			String[] newRefNo = (JSPUtil.getParameter(request, prefix	+ "new_ref_no", length));
			String[] fromNode = (JSPUtil.getParameter(request, prefix	+ "from_node", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] newPrioSeq = (JSPUtil.getParameter(request, prefix	+ "new_prio_seq", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] interchange2Nod = (JSPUtil.getParameter(request, prefix	+ "interchange2_nod", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIrgCandidateVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (polpod[i] != null)
					model.setPolpod(polpod[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (newRoutOrg[i] != null)
					model.setNewRoutOrg(newRoutOrg[i]);
				if (newFmNodYard[i] != null)
					model.setNewFmNodYard(newFmNodYard[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (newRailCmbThruTpCd[i] != null)
					model.setNewRailCmbThruTpCd(newRailCmbThruTpCd[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (newRoutDest[i] != null)
					model.setNewRoutDest(newRoutDest[i]);
				if (keyOrg[i] != null)
					model.setKeyOrg(keyOrg[i]);
				if (toNode[i] != null)
					model.setToNode(toNode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newToNodYard[i] != null)
					model.setNewToNodYard(newToNodYard[i]);
				if (newRoutSeq[i] != null)
					model.setNewRoutSeq(newRoutSeq[i]);
				if (bkgRcvdeTermCd[i] != null)
					model.setBkgRcvdeTermCd(bkgRcvdeTermCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (interchange1Loc[i] != null)
					model.setInterchange1Loc(interchange1Loc[i]);
				if (newInlndRoutRmk[i] != null)
					model.setNewInlndRoutRmk(newInlndRoutRmk[i]);
				if (newRoutPlnCd[i] != null)
					model.setNewRoutPlnCd(newRoutPlnCd[i]);
				if (railCmbThruTpCd[i] != null)
					model.setRailCmbThruTpCd(railCmbThruTpCd[i]);
				if (interchange1Nod[i] != null)
					model.setInterchange1Nod(interchange1Nod[i]);
				if (keyDest[i] != null)
					model.setKeyDest(keyDest[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (newFmNodCd[i] != null)
					model.setNewFmNodCd(newFmNodCd[i]);
				if (newToNodCd[i] != null)
					model.setNewToNodCd(newToNodCd[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (interchange2Loc[i] != null)
					model.setInterchange2Loc(interchange2Loc[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (newIrg[i] != null)
					model.setNewIrg(newIrg[i]);
				if (irg[i] != null)
					model.setIrg(irg[i]);
				if (irgDropdownlist[i] != null)
					model.setIrgDropdownlist(irgDropdownlist[i]);
				if (newRefNo[i] != null)
					model.setNewRefNo(newRefNo[i]);
				if (fromNode[i] != null)
					model.setFromNode(fromNode[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (newPrioSeq[i] != null)
					model.setNewPrioSeq(newPrioSeq[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (interchange2Nod[i] != null)
					model.setInterchange2Nod(interchange2Nod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIrgCandidateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIrgCandidateVO[]
	 */
	public SearchIrgCandidateVO[] getSearchIrgCandidateVOs(){
		SearchIrgCandidateVO[] vos = (SearchIrgCandidateVO[])models.toArray(new SearchIrgCandidateVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polpod = this.polpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRoutOrg = this.newRoutOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFmNodYard = this.newFmNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRailCmbThruTpCd = this.newRailCmbThruTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRoutDest = this.newRoutDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyOrg = this.keyOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNode = this.toNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newToNodYard = this.newToNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRoutSeq = this.newRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvdeTermCd = this.bkgRcvdeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interchange1Loc = this.interchange1Loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newInlndRoutRmk = this.newInlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRoutPlnCd = this.newRoutPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCmbThruTpCd = this.railCmbThruTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interchange1Nod = this.interchange1Nod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyDest = this.keyDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFmNodCd = this.newFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newToNodCd = this.newToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interchange2Loc = this.interchange2Loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newIrg = this.newIrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irg = this.irg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgDropdownlist = this.irgDropdownlist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRefNo = this.newRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNode = this.fromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPrioSeq = this.newPrioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interchange2Nod = this.interchange2Nod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
