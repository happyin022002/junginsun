/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_201Event.java
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier :
*@LastVersion : 1.0
* 2006-11-23
* 1.0 최초 생성 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.Search04RailSoManageVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.SearchIrgCandidateVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.SearchRailSoManageHdrVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
 

/**
 * ESD_TRS_201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_201HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0201Event extends EventSupport {
	
	// use in [ IRG ADJUST ]
	private String userid          = null; 
	private String hidParameter   = null;
	private String emptyYn        = null;
	
	// use in [ CANDIDATE ADJUST ]
	private String[] arrSeq            = null;
	private String[] arrBkgRcvdeTermCd = null;
	private String[] arrTrspBndCd      = null;
	private String[] arrCgoTpCd        = null;
	private String[] arrKeyOrg         = null;
	private String[] arrKeyDest        = null;
	
	// s/o correction
	private String sdateSep 		= null;
	private String splanFromDate 	= null;
	private String splanToDate 		= null;
	private String sselStatus 		= null;
	private String sselEdikind 		= null;
	private String sselBnd 			= null;
	private String sselThrough 		= null;
	private String sselLimtinq 		= null;
	private String sfromLocationCd 	= null;
	private String stoLocationCd 	= null;
	private String sselUnmatch 		= null;
	private String strunkVvd 		= null;
	private String sbkgNo 			= null;
	private String sbilNo 			= null;
	private String scntrNo 			= null;
	private String sctrlOfcCd 		= null;
	private String radVendor 		= null;
	private String selRailRoad 		= null;
	private String comboSvcProvider = null;
	
	// use in [ Request Service Provider Inquiry Popup ]
	private String fTrspSoOfcCd    = null;
	private String fTrspSoSeq      = null;
	private String fProvVndrSeq    = null;
	
	// empty s/o creation
	private String selKind			= null;
	private String cntrType			= null;
	private String cntrSize			= null;
	private String referNo			= null;
	private String hidRefId     	= null;
	private String hidFmNodCd     	= null;
	private String hidToNodCd     	= null;
	private String hidEqTpszCd     	= null;
	private String hidMoreQty     	= null;
	private String hidCurrDt     	= null;
	private String eqNoVerify     	= null;
	private String frmNodeVerify    = null;
	private String hidCntrNo    	= null;
	private String hidCntrTpszCd    = null;
	private String toNodVerify     	= null;
	private String bkgNoVerify     	= null;
	
	// s/o i/b search
	private String sdelNode			= null;
	private String podNode			= null;
	private String scNo				= null;
	private String selCustoms		= null;
	
	// s/o o/b search
	private String sporNode			= null;
	private String spolNode			= null;
	
	// wrs railbilling cancel
	private String sctrlUserId		= null;


	/** TRS_TRSP_RAIL_BIL_ORD Table  조회 조건 및 단건 처리 */
	private TrsTrspRailBilOrdVO   trsTrspRailBilOrdVo  ;
	
	/** TRS_TRSP_RAIL_BIL_ORD Table  Multi Data 처리 */
	private TrsTrspRailBilOrdVO[] trsTrspRailBilOrdVos ;
	
	private Search04RailSoManageVO search04RailSoManageVo;
	
	private Search04RailSoManageVO[] search04RailSoManageVos;
	
	private SearchIrgCandidateVO   searchIrgCandidateVo;
	
	private SearchIrgCandidateVO[] searchIrgCandidateVos;
	
	private SearchRailSoManageHdrVO searchRailSoManageHdrVo;
	
	private SearchRailSoManageHdrVO[] searchRailSoManageHdrVos;
	
	/** EsdTrs0201Event */
	public EsdTrs0201Event(){
		this.userid          = "";
		this.hidParameter   = "";
		this.emptyYn        = "";
		this.search04RailSoManageVo = null;
		this.search04RailSoManageVos= null;
	}
	
	/** TrsTrspRailBilOrdVo getter */
	public TrsTrspRailBilOrdVO getTrsTrspRailBilOrdVo() {
		return trsTrspRailBilOrdVo;
	}

	/** TrsTrspRailBilOrdVo setter */
	public void setTrsTrspRailBilOrdVo(TrsTrspRailBilOrdVO trsTrspRailBilOrdVo) {
		this.trsTrspRailBilOrdVo = trsTrspRailBilOrdVo;
	}

	/** TrsTrspRailBilOrdVos getter */
	public TrsTrspRailBilOrdVO[] getTrsTrspRailBilOrdVos() {
		return trsTrspRailBilOrdVos;
	}

	/** TrsTrspRailBilOrdVos setter */
	public void setTrsTrspRailBilOrdVos(TrsTrspRailBilOrdVO[] trsTrspRailBilOrdVos) {
		this.trsTrspRailBilOrdVos = trsTrspRailBilOrdVos;
	}

	public Search04RailSoManageVO getSearch04RailSoManageVo() {
		return search04RailSoManageVo;
	}
	public void setSearch04RailSoManageVo(Search04RailSoManageVO search04RailSoManageVo) {
		this.search04RailSoManageVo = search04RailSoManageVo;
	}

	public Search04RailSoManageVO[] getSearch04RailSoManageVos() {
		return search04RailSoManageVos;
	}
	public void setSearch04RailSoManageVos(Search04RailSoManageVO[] search04RailSoManageVos) {
		this.search04RailSoManageVos = search04RailSoManageVos;
	}
	
	/** searchIrgCandidate getter */
	public SearchIrgCandidateVO getSearchIrgCandidateVo() {
		return searchIrgCandidateVo;
	}
	/** searchIrgCandidate setter */
	public void setSearchIrgCandidateVo(SearchIrgCandidateVO searchIrgCandidateVo) {
		this.searchIrgCandidateVo = searchIrgCandidateVo;
	}
	/** searchIrgCandidate multi getter */
	public SearchIrgCandidateVO[] getSearchIrgCandidateVos() {
		return searchIrgCandidateVos;
	}
	/** searchIrgCandidate multi setter */
	public void setSearchIrgCandidateVos(
			SearchIrgCandidateVO[] searchIrgCandidateVos) {
		this.searchIrgCandidateVos = searchIrgCandidateVos;
	}
	
	
	public SearchRailSoManageHdrVO getSearchRailSoManageHdrVo() {
		return searchRailSoManageHdrVo;
	}

	public void setSearchRailSoManageHdrVo(SearchRailSoManageHdrVO searchRailSoManageHdrVo) {
		this.searchRailSoManageHdrVo = searchRailSoManageHdrVo;
	}

	public SearchRailSoManageHdrVO[] getSearchRailSoManageHdrVos() {
		return searchRailSoManageHdrVos;
	}

	public void setSearchRailSoManageHdrVos(SearchRailSoManageHdrVO[] searchRailSoManageHdrVos) {
		this.searchRailSoManageHdrVos = searchRailSoManageHdrVos;
	}

	public String getUserid() {
		return userid;
	}
	
	public String getToNodVerify() {
		return toNodVerify;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getHid_parameter() {
		return hidParameter;
	}
	
	public void setHid_parameter(String hidParameter) {
		this.hidParameter = hidParameter;
	}

	public String getEmpty_yn() {
		return emptyYn;
	}
	
	public void setEmpty_yn(String emptyYn) {
		this.emptyYn = emptyYn;
	}

	public String getBkgNoVerify() {
		return bkgNoVerify;
	}

	public void setBkgNoVerify(String bkgNoVerify) {
		this.bkgNoVerify = bkgNoVerify;
	}

	public String[] getArrSeq() {
		return arrSeq;
	}

	public String[] getArrBkgRcvdeTermCd() {
		return arrBkgRcvdeTermCd;
	}

	public String[] getArrTrspBndCd() {
		return arrTrspBndCd;
	}

	public String[] getArrCgoTpCd() {
		return arrCgoTpCd;
	}

	public String[] getArrKeyOrg() {
		return arrKeyOrg;
	}

	public String[] getArrKeyDest() {
		return arrKeyDest;
	}

	public void setArrSeq(String[] arrSeq) {
		this.arrSeq = arrSeq;
	}

	public void setArrBkgRcvdeTermCd(String[] arrBkgRcvdeTermCd) {
		this.arrBkgRcvdeTermCd = arrBkgRcvdeTermCd;
	}

	public void setArrTrspBndCd(String[] arrTrspBndCd) {
		this.arrTrspBndCd = arrTrspBndCd;
	}

	public void setArrCgoTpCd(String[] arrCgoTpCd) {
		this.arrCgoTpCd = arrCgoTpCd;
	}

	public void setArrKeyOrg(String[] arrKeyOrg) {
		this.arrKeyOrg = arrKeyOrg;
	}

	public void setArrKeyDest(String[] arrKeyDest) {
		this.arrKeyDest = arrKeyDest;
	}
	
	public String getSdateSep() {
		return sdateSep;
	}

	public void setSdateSep(String sdateSep) {
		this.sdateSep = sdateSep;
	}

	public String getSplanFromDate() {
		return splanFromDate;
	}

	public void setSplanFromDate(String splanFromDate) {
		this.splanFromDate = splanFromDate;
	}

	public String getSplanToDate() {
		return splanToDate;
	}

	public void setSplanToDate(String splanToDate) {
		this.splanToDate = splanToDate;
	}

	public String getSselStatus() {
		return sselStatus;
	}

	public void setSselStatus(String sselStatus) {
		this.sselStatus = sselStatus;
	}

	public String getSselEdikind() {
		return sselEdikind;
	}

	public void setSselEdikind(String sselEdikind) {
		this.sselEdikind = sselEdikind;
	}

	public String getSselBnd() {
		return sselBnd;
	}

	public void setSselBnd(String sselBnd) {
		this.sselBnd = sselBnd;
	}

	public String getSselThrough() {
		return sselThrough;
	}

	public void setSselThrough(String sselThrough) {
		this.sselThrough = sselThrough;
	}

	public String getSselLimtinq() {
		return sselLimtinq;
	}

	public void setSselLimtinq(String sselLimtinq) {
		this.sselLimtinq = sselLimtinq;
	}

	public String getSfromLocationCd() {
		return sfromLocationCd;
	}

	public void setSfromLocationCd(String sfromLocationCd) {
		this.sfromLocationCd = sfromLocationCd;
	}

	public String getStoLocationCd() {
		return stoLocationCd;
	}

	public void setStoLocationCd(String stoLocationCd) {
		this.stoLocationCd = stoLocationCd;
	}

	public String getSselUnmatch() {
		return sselUnmatch;
	}

	public void setSselUnmatch(String sselUnmatch) {
		this.sselUnmatch = sselUnmatch;
	}

	public String getStrunkVvd() {
		return strunkVvd;
	}

	public void setStrunkVvd(String strunkVvd) {
		this.strunkVvd = strunkVvd;
	}

	public String getSbkgNo() {
		return sbkgNo;
	}

	public void setSbkgNo(String sbkgNo) {
		this.sbkgNo = sbkgNo;
	}

	public String getSbilNo() {
		return sbilNo;
	}

	public void setSbilNo(String sbilNo) {
		this.sbilNo = sbilNo;
	}

	public String getScntrNo() {
		return scntrNo;
	}

	public void setScntrNo(String scntrNo) {
		this.scntrNo = scntrNo;
	}

	public String getSctrlOfcCd() {
		return sctrlOfcCd;
	}

	public void setSctrlOfcCd(String sctrlOfcCd) {
		this.sctrlOfcCd = sctrlOfcCd;
	}
	
	public String getFTrspSoOfcCd() {
		return fTrspSoOfcCd;
	}

	public void setFTrspSoOfcCd(String trspSoOfcCd) {
		this.fTrspSoOfcCd = trspSoOfcCd;
	}

	public String getFTrspSoSeq() {
		return fTrspSoSeq;
	}

	public void setFTrspSoSeq(String trspSoSeq) {
		this.fTrspSoSeq = trspSoSeq;
	}

	public String getFProvVndrSeq() {
		return fProvVndrSeq;
	}

	public void setFProvVndrSeq(String provVndrSeq) {
		this.fProvVndrSeq = provVndrSeq;
	}

	public String getSelKind() {
		return selKind;
	}

	public void setSelKind(String selKind) {
		this.selKind = selKind;
	}

	public String getCntrType() {
		return cntrType;
	}

	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}

	public String getCntrSize() {
		return cntrSize;
	}

	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}

	public String getReferNo() {
		return referNo;
	}

	public void setReferNo(String referNo) {
		this.referNo = referNo;
	}

	public String getHidRefId() {
		return hidRefId;
	}

	public void setHidRefId(String hidRefId) {
		this.hidRefId = hidRefId;
	}

	public String getHidFmNodCd() {
		return hidFmNodCd;
	}

	public void setHidFmNodCd(String hidFmNodCd) {
		this.hidFmNodCd = hidFmNodCd;
	}

	public String getHidToNodCd() {
		return hidToNodCd;
	}

	public void setHidToNodCd(String hidToNodCd) {
		this.hidToNodCd = hidToNodCd;
	}

	public String getHidEqTpszCd() {
		return hidEqTpszCd;
	}

	public void setHidEqTpszCd(String hidEqTpszCd) {
		this.hidEqTpszCd = hidEqTpszCd;
	}

	public String getHidMoreQty() {
		return hidMoreQty;
	}

	public void setHidMoreQty(String hidMoreQty) {
		this.hidMoreQty = hidMoreQty;
	}

	public String getHidCurrDt() {
		return hidCurrDt;
	}

	public void setHidCurrDt(String hidCurrDt) {
		this.hidCurrDt = hidCurrDt;
	}

	public String getEqNoVerify() {
		return eqNoVerify;
	}

	public void setEqNoVerify(String eqNoVerify) {
		this.eqNoVerify = eqNoVerify;
	}

	public String getFrmNodeVerify() {
		return frmNodeVerify;
	}

	public void setFrmNodeVerify(String frmNodeVerify) {
		this.frmNodeVerify = frmNodeVerify;
	}

	public String getSdelNode() {
		return sdelNode;
	}

	public void setSdelNode(String sdelNode) {
		this.sdelNode = sdelNode;
	}

	public String getPodNode() {
		return podNode;
	}

	public void setPodNode(String podNode) {
		this.podNode = podNode;
	}

	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getSelCustoms() {
		return selCustoms;
	}

	public void setSelCustoms(String selCustoms) {
		this.selCustoms = selCustoms;
	}

	public String getSporNode() {
		return sporNode;
	}

	public void setSporNode(String sporNode) {
		this.sporNode = sporNode;
	}

	public String getSpolNode() {
		return spolNode;
	}

	public void setSpolNode(String spolNode) {
		this.spolNode = spolNode;
	}

	public String getHidCntrNo() {
		return hidCntrNo;
	}

	public void setHidCntrNo(String hidCntrNo) {
		this.hidCntrNo = hidCntrNo;
	}

	public String getHidCntrTpszCd() {
		return hidCntrTpszCd;
	}

	public void setHidCntrTpszCd(String hidCntrTpszCd) {
		this.hidCntrTpszCd = hidCntrTpszCd;
	}

	public String getSctrlUserId() {
		return sctrlUserId;
	}

	public void setSctrlUserId(String sctrlUserId) {
		this.sctrlUserId = sctrlUserId;
	}

	public String getRadVendor() {
		return radVendor;
	}

	public void setRadVendor(String radVendor) {
		this.radVendor = radVendor;
	}

	public String getSelRailRoad() {
		return selRailRoad;
	}

	public void setSelRailRoad(String selRailRoad) {
		this.selRailRoad = selRailRoad;
	}

	public String getComboSvcProvider() {
		return comboSvcProvider;
	}

	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}
	
	public void setToNodVerify(String toNodVerify) {
		this.toNodVerify = toNodVerify;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("user_id"       , this.getUserid());
		this.hashColumns.put("hid_parameter" , this.getHid_parameter());		
		this.hashColumns.put("empty_yn"      , this.getEmpty_yn());
		
		this.hashColumns.put("f_trsp_so_ofc_cd", this.getFTrspSoOfcCd());
		this.hashColumns.put("f_trsp_so_seq"   , this.getFTrspSoSeq());
		this.hashColumns.put("f_prov_vndr_seq" , this.getFProvVndrSeq());
		
		this.hashColumns.put("sdateSep", getSdateSep());
		this.hashColumns.put("splanFromDate", getSplanFromDate());
		this.hashColumns.put("splanToDate", getSplanToDate());
		this.hashColumns.put("sselStatus", getSselStatus());
		this.hashColumns.put("sselEdikind", getSselEdikind());
		this.hashColumns.put("sselBnd", getSselBnd());
		this.hashColumns.put("sselThrough", getSselThrough());
		this.hashColumns.put("sselLimtinq", getSselLimtinq());
		this.hashColumns.put("sfromLocationCd", getSfromLocationCd());
		this.hashColumns.put("stoLocationCd", getStoLocationCd());
		this.hashColumns.put("sselUnmatch", getSselUnmatch());
		this.hashColumns.put("strunkVvd", getStrunkVvd());
		this.hashColumns.put("sbkgNo", getSbkgNo());
		this.hashColumns.put("sbilNo", getSbilNo());
		this.hashColumns.put("scntrNo", getScntrNo());
		this.hashColumns.put("sctrlOfcCd", getSctrlOfcCd());
		this.hashColumns.put("radVendor", getRadVendor());
		this.hashColumns.put("selRailRoad", getSelRailRoad());
		this.hashColumns.put("comboSvcProvider", getComboSvcProvider());
		
		this.hashColumns.put("selKind", getSelKind());
		this.hashColumns.put("cntrType", getCntrType());
		this.hashColumns.put("cntrSize", getCntrSize());
		this.hashColumns.put("referNo", getReferNo());
		this.hashColumns.put("hidRefId", getHidRefId());
		this.hashColumns.put("hidFmNodCd", getHidFmNodCd());
		this.hashColumns.put("hidToNodCd", getHidToNodCd());
		this.hashColumns.put("hidEqTpszCd", getHidEqTpszCd());
		this.hashColumns.put("hidMoreQty", getHidMoreQty());
		this.hashColumns.put("hidCurrDt", getHidCurrDt());
		this.hashColumns.put("eqNoVerify", getEqNoVerify());
		this.hashColumns.put("frmNodeVerify", getFrmNodeVerify());
		this.hashColumns.put("hidCntrNo", getHidCntrNo());
		this.hashColumns.put("hidCntrTpszCd", getHidCntrTpszCd());
		this.hashColumns.put("toNodVerify", getToNodVerify());
		
		this.hashColumns.put("sdelNode", getSdelNode());
		this.hashColumns.put("podNode", getPodNode());
		this.hashColumns.put("scNo", getScNo());
		this.hashColumns.put("selCustoms", getSelCustoms());
		
		this.hashColumns.put("sporNode", getSporNode());
		this.hashColumns.put("spolNode", getSpolNode());
		
		this.hashColumns.put("sctrlUserId", getSctrlUserId());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0201Event";
	}
	
	public String toString() {
		return "EsdTrs0201Event";
	}
	
}