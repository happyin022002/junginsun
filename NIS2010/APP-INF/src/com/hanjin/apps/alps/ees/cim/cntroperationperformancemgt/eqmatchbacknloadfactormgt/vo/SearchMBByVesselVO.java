/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMBByVesselVO.java
*@FileTitle : SearchMBByVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.02 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMBByVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMBByVesselVO> models = new ArrayList<SearchMBByVesselVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String fullHc = null;
	/* Column Info */
	private String com = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String mty45 = null;
	/* Column Info */
	private String mty20 = null;
	/* Column Info */
	private String eq40 = null;
	/* Column Info */
	private String lastport = null;
	/* Column Info */
	private String boxTotal = null;
	/* Column Info */
	private String full20 = null;
	/* Column Info */
	private String eq45 = null;
	/* Column Info */
	private String eqHc = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String full40 = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String full45 = null;
	/* Column Info */
	private String mty40 = null;
	/* Column Info */
	private String teuEq = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String teuTotal = null;
	/* Column Info */
	private String datasource = null;
	/* Column Info */
	private String val10 = null;
	/* Column Info */
	private String val01 = null;
	/* Column Info */
	private String val02 = null;
	/* Column Info */
	private String val05 = null;
	/* Column Info */
	private String fullTotal = null;
	/* Column Info */
	private String val06 = null;
	/* Column Info */
	private String val03 = null;
	/* Column Info */
	private String val04 = null;
	/* Column Info */
	private String val09 = null;
	/* Column Info */
	private String teuFull = null;
	/* Column Info */
	private String val07 = null;
	/* Column Info */
	private String eq20 = null;
	/* Column Info */
	private String val08 = null;
	/* Column Info */
	private String mtyHc = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String mtyTotal = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String eqTotal = null;
	/* Column Info */
	private String week = null;

	/* Column Info */
	private String deadslot = null;
	
	/* Column Info */
	private String releasedteu = null;
	/* Column Info */
	private String releasedweight = null;
	/* Column Info */
	private String weighttotal = null;

	/* Column Info */
	private String bsaweight = null;
	/* Column Info */
	private String bsaspace = null;

	/* Column Info */
	private String lffull = null;
	/* Column Info */
	private String lfeq = null;
	/* Column Info */
	private String lfwgt = null;
	
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toRgn = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String wkStDt = null;
	/* Column Info */
	private String fromRgn = null;
	/* Column Info */
	private String wkEndDt = null;

	public String getLaneCd() {
		return laneCd;
	}

	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getVpsEtdDt() {
		return vpsEtdDt;
	}

	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}

	public String getTrdCd() {
		return trdCd;
	}

	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getToRgn() {
		return toRgn;
	}

	public void setToRgn(String toRgn) {
		this.toRgn = toRgn;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getVpsPortCd() {
		return vpsPortCd;
	}

	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}

	public String getWkStDt() {
		return wkStDt;
	}

	public void setWkStDt(String wkStDt) {
		this.wkStDt = wkStDt;
	}

	public String getFromRgn() {
		return fromRgn;
	}

	public void setFromRgn(String fromRgn) {
		this.fromRgn = fromRgn;
	}

	public String getWkEndDt() {
		return wkEndDt;
	}

	public void setWkEndDt(String wkEndDt) {
		this.wkEndDt = wkEndDt;
	}

	public String getDeadslot() {
		return deadslot;
	}

	public void setDeadslot(String deadslot) {
		this.deadslot = deadslot;
	}

	public String getReleasedteu() {
		return releasedteu;
	}

	public void setReleasedteu(String releasedteu) {
		this.releasedteu = releasedteu;
	}

	public String getReleasedweight() {
		return releasedweight;
	}

	public void setReleasedweight(String releasedweight) {
		this.releasedweight = releasedweight;
	}

	public String getWeighttotal() {
		return weighttotal;
	}

	public void setWeighttotal(String weighttotal) {
		this.weighttotal = weighttotal;
	}

	public String getBsaweight() {
		return bsaweight;
	}

	public void setBsaweight(String bsaweight) {
		this.bsaweight = bsaweight;
	}

	public String getBsaspace() {
		return bsaspace;
	}

	public void setBsaspace(String bsaspace) {
		this.bsaspace = bsaspace;
	}

	public String getLffull() {
		return lffull;
	}

	public void setLffull(String lffull) {
		this.lffull = lffull;
	}

	public String getLfeq() {
		return lfeq;
	}

	public void setLfeq(String lfeq) {
		this.lfeq = lfeq;
	}

	public String getLfwgt() {
		return lfwgt;
	}

	public void setLfwgt(String lfwgt) {
		this.lfwgt = lfwgt;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMBByVesselVO() {}
	

	public SearchMBByVesselVO(String ibflag, String pagerows, String seq, String com, String trade, String lane, String io, String region, String vvd, String lastport, String atd, String week, String full20, String full40, String fullHc, String full45, String fullTotal, String mty20, String mty40, String mtyHc, String mty45, String mtyTotal, String boxTotal, String teuTotal, String teuFull, String teuEq, String eq20, String eq40, String eqHc, String eq45, String eqTotal, String datasource, String clptIndSeq, String clptSeq, String val01, String val02, String val03, String val04, String val05, String val06, String val07, String val08, String val09, String val10,String deadslot,String releasedteu, String releasedweight, String weighttotal , String bsaweight,String bsaspace, String lffull,String lfeq , String lfwgt,String trdCd, String laneCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String vpsEtdDt, String wkStDt, String wkEndDt, String fromRgn, String toRgn) {
		this.region = region;
		this.fullHc = fullHc;
		this.com = com;
		this.trade = trade;
		this.mty45 = mty45;
		this.mty20 = mty20;
		this.eq40 = eq40;
		this.lastport = lastport;
		this.boxTotal = boxTotal;
		this.full20 = full20;
		this.eq45 = eq45;
		this.eqHc = eqHc;
		this.lane = lane;
		this.pagerows = pagerows;
		this.full40 = full40;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.full45 = full45;
		this.mty40 = mty40;
		this.teuEq = teuEq;
		this.atd = atd;
		this.teuTotal = teuTotal;
		this.datasource = datasource;
		this.val10 = val10;
		this.val01 = val01;
		this.val02 = val02;
		this.val05 = val05;
		this.fullTotal = fullTotal;
		this.val06 = val06;
		this.val03 = val03;
		this.val04 = val04;
		this.val09 = val09;
		this.teuFull = teuFull;
		this.val07 = val07;
		this.eq20 = eq20;
		this.val08 = val08;
		this.mtyHc = mtyHc;
		this.io = io;
		this.vvd = vvd;
		this.clptIndSeq = clptIndSeq;
		this.mtyTotal = mtyTotal;
		this.seq = seq;
		this.eqTotal = eqTotal;
		this.week = week;
		this.deadslot = deadslot;
		this.releasedteu = releasedteu;
		this.releasedweight = releasedweight;
		this.weighttotal = weighttotal;
		this.bsaweight = bsaweight;
		this.bsaspace = bsaspace;
		this.lffull = lffull;
		this.lfeq = lfeq;
		this.lfwgt = lfwgt;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.vpsEtdDt = vpsEtdDt;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.toRgn = toRgn;
		this.skdDirCd = skdDirCd;
		this.vpsPortCd = vpsPortCd;
		this.wkStDt = wkStDt;
		this.fromRgn = fromRgn;
		this.wkEndDt = wkEndDt;
}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("full_hc", getFullHc());
		this.hashColumns.put("com", getCom());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("mty_45", getMty45());
		this.hashColumns.put("mty_20", getMty20());
		this.hashColumns.put("eq_40", getEq40());
		this.hashColumns.put("lastport", getLastport());
		this.hashColumns.put("box_total", getBoxTotal());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("eq_45", getEq45());
		this.hashColumns.put("eq_hc", getEqHc());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("full_45", getFull45());
		this.hashColumns.put("mty_40", getMty40());
		this.hashColumns.put("teu_eq", getTeuEq());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("teu_total", getTeuTotal());
		this.hashColumns.put("datasource", getDatasource());
		this.hashColumns.put("val10", getVal10());
		this.hashColumns.put("val01", getVal01());
		this.hashColumns.put("val02", getVal02());
		this.hashColumns.put("val05", getVal05());
		this.hashColumns.put("full_total", getFullTotal());
		this.hashColumns.put("val06", getVal06());
		this.hashColumns.put("val03", getVal03());
		this.hashColumns.put("val04", getVal04());
		this.hashColumns.put("val09", getVal09());
		this.hashColumns.put("teu_full", getTeuFull());
		this.hashColumns.put("val07", getVal07());
		this.hashColumns.put("eq_20", getEq20());
		this.hashColumns.put("val08", getVal08());
		this.hashColumns.put("mty_hc", getMtyHc());
		this.hashColumns.put("io", getIo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("mty_total", getMtyTotal());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("eq_total", getEqTotal());
		this.hashColumns.put("week", getWeek());
		
		this.hashColumns.put("deadslot", getDeadslot());
		this.hashColumns.put("releasedteu", getReleasedteu());
		this.hashColumns.put("releasedweight", getReleasedweight());
		this.hashColumns.put("weighttotal", getWeighttotal());
		this.hashColumns.put("bsaweight", getBsaweight());
		this.hashColumns.put("bsaspace", getBsaspace());
		this.hashColumns.put("lffull", getLffull());
		this.hashColumns.put("lfeq", getLfeq());
		this.hashColumns.put("lfwgt", getLfwgt());
		
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_rgn", getToRgn());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("wk_st_dt", getWkStDt());
		this.hashColumns.put("from_rgn", getFromRgn());
		this.hashColumns.put("wk_end_dt", getWkEndDt());
		
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("full_hc", "fullHc");
		this.hashFields.put("com", "com");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("mty_45", "mty45");
		this.hashFields.put("mty_20", "mty20");
		this.hashFields.put("eq_40", "eq40");
		this.hashFields.put("lastport", "lastport");
		this.hashFields.put("box_total", "boxTotal");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("eq_45", "eq45");
		this.hashFields.put("eq_hc", "eqHc");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("full_45", "full45");
		this.hashFields.put("mty_40", "mty40");
		this.hashFields.put("teu_eq", "teuEq");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("teu_total", "teuTotal");
		this.hashFields.put("datasource", "datasource");
		this.hashFields.put("val10", "val10");
		this.hashFields.put("val01", "val01");
		this.hashFields.put("val02", "val02");
		this.hashFields.put("val05", "val05");
		this.hashFields.put("full_total", "fullTotal");
		this.hashFields.put("val06", "val06");
		this.hashFields.put("val03", "val03");
		this.hashFields.put("val04", "val04");
		this.hashFields.put("val09", "val09");
		this.hashFields.put("teu_full", "teuFull");
		this.hashFields.put("val07", "val07");
		this.hashFields.put("eq_20", "eq20");
		this.hashFields.put("val08", "val08");
		this.hashFields.put("mty_hc", "mtyHc");
		this.hashFields.put("io", "io");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("mty_total", "mtyTotal");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("eq_total", "eqTotal");
		this.hashFields.put("week", "week");

		this.hashFields.put("deadslot", "deadslot");
		this.hashFields.put("releasedteu", "releasedteu");
		this.hashFields.put("releasedweight", "releasedweight");
		this.hashFields.put("weighttotal", "weighttotal");
		this.hashFields.put("bsaweight", "bsaweight");
		this.hashFields.put("bsaspace", "bsaspace");
		this.hashFields.put("lffull", "lffull");
		this.hashFields.put("lfeq", "lfeq");
		this.hashFields.put("lfwgt", "lfwgt");
		
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_rgn", "toRgn");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("wk_st_dt", "wkStDt");
		this.hashFields.put("from_rgn", "fromRgn");
		this.hashFields.put("wk_end_dt", "wkEndDt");
		
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
	 * @return fullHc
	 */
	public String getFullHc() {
		return this.fullHc;
	}
	
	/**
	 * Column Info
	 * @return com
	 */
	public String getCom() {
		return this.com;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return mty45
	 */
	public String getMty45() {
		return this.mty45;
	}
	
	/**
	 * Column Info
	 * @return mty20
	 */
	public String getMty20() {
		return this.mty20;
	}
	
	/**
	 * Column Info
	 * @return eq40
	 */
	public String getEq40() {
		return this.eq40;
	}
	
	/**
	 * Column Info
	 * @return lastport
	 */
	public String getLastport() {
		return this.lastport;
	}
	
	/**
	 * Column Info
	 * @return boxTotal
	 */
	public String getBoxTotal() {
		return this.boxTotal;
	}
	
	/**
	 * Column Info
	 * @return full20
	 */
	public String getFull20() {
		return this.full20;
	}
	
	/**
	 * Column Info
	 * @return eq45
	 */
	public String getEq45() {
		return this.eq45;
	}
	
	/**
	 * Column Info
	 * @return eqHc
	 */
	public String getEqHc() {
		return this.eqHc;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return full40
	 */
	public String getFull40() {
		return this.full40;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return full45
	 */
	public String getFull45() {
		return this.full45;
	}
	
	/**
	 * Column Info
	 * @return mty40
	 */
	public String getMty40() {
		return this.mty40;
	}
	
	/**
	 * Column Info
	 * @return teuEq
	 */
	public String getTeuEq() {
		return this.teuEq;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return teuTotal
	 */
	public String getTeuTotal() {
		return this.teuTotal;
	}
	
	/**
	 * Column Info
	 * @return datasource
	 */
	public String getDatasource() {
		return this.datasource;
	}
	
	/**
	 * Column Info
	 * @return val10
	 */
	public String getVal10() {
		return this.val10;
	}
	
	/**
	 * Column Info
	 * @return val01
	 */
	public String getVal01() {
		return this.val01;
	}
	
	/**
	 * Column Info
	 * @return val02
	 */
	public String getVal02() {
		return this.val02;
	}
	
	/**
	 * Column Info
	 * @return val05
	 */
	public String getVal05() {
		return this.val05;
	}
	
	/**
	 * Column Info
	 * @return fullTotal
	 */
	public String getFullTotal() {
		return this.fullTotal;
	}
	
	/**
	 * Column Info
	 * @return val06
	 */
	public String getVal06() {
		return this.val06;
	}
	
	/**
	 * Column Info
	 * @return val03
	 */
	public String getVal03() {
		return this.val03;
	}
	
	/**
	 * Column Info
	 * @return val04
	 */
	public String getVal04() {
		return this.val04;
	}
	
	/**
	 * Column Info
	 * @return val09
	 */
	public String getVal09() {
		return this.val09;
	}
	
	/**
	 * Column Info
	 * @return teuFull
	 */
	public String getTeuFull() {
		return this.teuFull;
	}
	
	/**
	 * Column Info
	 * @return val07
	 */
	public String getVal07() {
		return this.val07;
	}
	
	/**
	 * Column Info
	 * @return eq20
	 */
	public String getEq20() {
		return this.eq20;
	}
	
	/**
	 * Column Info
	 * @return val08
	 */
	public String getVal08() {
		return this.val08;
	}
	
	/**
	 * Column Info
	 * @return mtyHc
	 */
	public String getMtyHc() {
		return this.mtyHc;
	}
	
	/**
	 * Column Info
	 * @return io
	 */
	public String getIo() {
		return this.io;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return mtyTotal
	 */
	public String getMtyTotal() {
		return this.mtyTotal;
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
	 * @return eqTotal
	 */
	public String getEqTotal() {
		return this.eqTotal;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param fullHc
	 */
	public void setFullHc(String fullHc) {
		this.fullHc = fullHc;
	}
	
	/**
	 * Column Info
	 * @param com
	 */
	public void setCom(String com) {
		this.com = com;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param mty45
	 */
	public void setMty45(String mty45) {
		this.mty45 = mty45;
	}
	
	/**
	 * Column Info
	 * @param mty20
	 */
	public void setMty20(String mty20) {
		this.mty20 = mty20;
	}
	
	/**
	 * Column Info
	 * @param eq40
	 */
	public void setEq40(String eq40) {
		this.eq40 = eq40;
	}
	
	/**
	 * Column Info
	 * @param lastport
	 */
	public void setLastport(String lastport) {
		this.lastport = lastport;
	}
	
	/**
	 * Column Info
	 * @param boxTotal
	 */
	public void setBoxTotal(String boxTotal) {
		this.boxTotal = boxTotal;
	}
	
	/**
	 * Column Info
	 * @param full20
	 */
	public void setFull20(String full20) {
		this.full20 = full20;
	}
	
	/**
	 * Column Info
	 * @param eq45
	 */
	public void setEq45(String eq45) {
		this.eq45 = eq45;
	}
	
	/**
	 * Column Info
	 * @param eqHc
	 */
	public void setEqHc(String eqHc) {
		this.eqHc = eqHc;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param full40
	 */
	public void setFull40(String full40) {
		this.full40 = full40;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param full45
	 */
	public void setFull45(String full45) {
		this.full45 = full45;
	}
	
	/**
	 * Column Info
	 * @param mty40
	 */
	public void setMty40(String mty40) {
		this.mty40 = mty40;
	}
	
	/**
	 * Column Info
	 * @param teuEq
	 */
	public void setTeuEq(String teuEq) {
		this.teuEq = teuEq;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param teuTotal
	 */
	public void setTeuTotal(String teuTotal) {
		this.teuTotal = teuTotal;
	}
	
	/**
	 * Column Info
	 * @param datasource
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	
	/**
	 * Column Info
	 * @param val10
	 */
	public void setVal10(String val10) {
		this.val10 = val10;
	}
	
	/**
	 * Column Info
	 * @param val01
	 */
	public void setVal01(String val01) {
		this.val01 = val01;
	}
	
	/**
	 * Column Info
	 * @param val02
	 */
	public void setVal02(String val02) {
		this.val02 = val02;
	}
	
	/**
	 * Column Info
	 * @param val05
	 */
	public void setVal05(String val05) {
		this.val05 = val05;
	}
	
	/**
	 * Column Info
	 * @param fullTotal
	 */
	public void setFullTotal(String fullTotal) {
		this.fullTotal = fullTotal;
	}
	
	/**
	 * Column Info
	 * @param val06
	 */
	public void setVal06(String val06) {
		this.val06 = val06;
	}
	
	/**
	 * Column Info
	 * @param val03
	 */
	public void setVal03(String val03) {
		this.val03 = val03;
	}
	
	/**
	 * Column Info
	 * @param val04
	 */
	public void setVal04(String val04) {
		this.val04 = val04;
	}
	
	/**
	 * Column Info
	 * @param val09
	 */
	public void setVal09(String val09) {
		this.val09 = val09;
	}
	
	/**
	 * Column Info
	 * @param teuFull
	 */
	public void setTeuFull(String teuFull) {
		this.teuFull = teuFull;
	}
	
	/**
	 * Column Info
	 * @param val07
	 */
	public void setVal07(String val07) {
		this.val07 = val07;
	}
	
	/**
	 * Column Info
	 * @param eq20
	 */
	public void setEq20(String eq20) {
		this.eq20 = eq20;
	}
	
	/**
	 * Column Info
	 * @param val08
	 */
	public void setVal08(String val08) {
		this.val08 = val08;
	}
	
	/**
	 * Column Info
	 * @param mtyHc
	 */
	public void setMtyHc(String mtyHc) {
		this.mtyHc = mtyHc;
	}
	
	/**
	 * Column Info
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param mtyTotal
	 */
	public void setMtyTotal(String mtyTotal) {
		this.mtyTotal = mtyTotal;
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
	 * @param eqTotal
	 */
	public void setEqTotal(String eqTotal) {
		this.eqTotal = eqTotal;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setFullHc(JSPUtil.getParameter(request, "full_hc", ""));
		setCom(JSPUtil.getParameter(request, "com", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setMty45(JSPUtil.getParameter(request, "mty_45", ""));
		setMty20(JSPUtil.getParameter(request, "mty_20", ""));
		setEq40(JSPUtil.getParameter(request, "eq_40", ""));
		setLastport(JSPUtil.getParameter(request, "lastport", ""));
		setBoxTotal(JSPUtil.getParameter(request, "box_total", ""));
		setFull20(JSPUtil.getParameter(request, "full_20", ""));
		setEq45(JSPUtil.getParameter(request, "eq_45", ""));
		setEqHc(JSPUtil.getParameter(request, "eq_hc", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFull40(JSPUtil.getParameter(request, "full_40", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFull45(JSPUtil.getParameter(request, "full_45", ""));
		setMty40(JSPUtil.getParameter(request, "mty_40", ""));
		setTeuEq(JSPUtil.getParameter(request, "teu_eq", ""));
		setAtd(JSPUtil.getParameter(request, "atd", ""));
		setTeuTotal(JSPUtil.getParameter(request, "teu_total", ""));
		setDatasource(JSPUtil.getParameter(request, "datasource", ""));
		setVal10(JSPUtil.getParameter(request, "val10", ""));
		setVal01(JSPUtil.getParameter(request, "val01", ""));
		setVal02(JSPUtil.getParameter(request, "val02", ""));
		setVal05(JSPUtil.getParameter(request, "val05", ""));
		setFullTotal(JSPUtil.getParameter(request, "full_total", ""));
		setVal06(JSPUtil.getParameter(request, "val06", ""));
		setVal03(JSPUtil.getParameter(request, "val03", ""));
		setVal04(JSPUtil.getParameter(request, "val04", ""));
		setVal09(JSPUtil.getParameter(request, "val09", ""));
		setTeuFull(JSPUtil.getParameter(request, "teu_full", ""));
		setVal07(JSPUtil.getParameter(request, "val07", ""));
		setEq20(JSPUtil.getParameter(request, "eq_20", ""));
		setVal08(JSPUtil.getParameter(request, "val08", ""));
		setMtyHc(JSPUtil.getParameter(request, "mty_hc", ""));
		setIo(JSPUtil.getParameter(request, "io", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setMtyTotal(JSPUtil.getParameter(request, "mty_total", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setEqTotal(JSPUtil.getParameter(request, "eq_total", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setDeadslot(JSPUtil.getParameter(request, "deadslot", ""));
		setReleasedteu(JSPUtil.getParameter(request, "releasedteu", ""));
		setReleasedweight(JSPUtil.getParameter(request, "releasedweight", ""));
		setWeighttotal(JSPUtil.getParameter(request, "weighttotal", ""));
		setBsaweight(JSPUtil.getParameter(request, "bsaweight", ""));
		setBsaspace(JSPUtil.getParameter(request, "bsaspace", ""));
		setLffull(JSPUtil.getParameter(request, "lffull", ""));
		setLfeq(JSPUtil.getParameter(request, "lfeq", ""));
		setLfwgt(JSPUtil.getParameter(request, "lfwgt", ""));
		
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setToRgn(JSPUtil.getParameter(request, "to_rgn", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setWkStDt(JSPUtil.getParameter(request, "wk_st_dt", ""));
		setFromRgn(JSPUtil.getParameter(request, "from_rgn", ""));
		setWkEndDt(JSPUtil.getParameter(request, "wk_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMBByVesselVO[]
	 */
	public SearchMBByVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMBByVesselVO[]
	 */
	public SearchMBByVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMBByVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] fullHc = (JSPUtil.getParameter(request, prefix	+ "full_hc", length));
			String[] com = (JSPUtil.getParameter(request, prefix	+ "com", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] mty45 = (JSPUtil.getParameter(request, prefix	+ "mty_45", length));
			String[] mty20 = (JSPUtil.getParameter(request, prefix	+ "mty_20", length));
			String[] eq40 = (JSPUtil.getParameter(request, prefix	+ "eq_40", length));
			String[] lastport = (JSPUtil.getParameter(request, prefix	+ "lastport", length));
			String[] boxTotal = (JSPUtil.getParameter(request, prefix	+ "box_total", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] eq45 = (JSPUtil.getParameter(request, prefix	+ "eq_45", length));
			String[] eqHc = (JSPUtil.getParameter(request, prefix	+ "eq_hc", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] full45 = (JSPUtil.getParameter(request, prefix	+ "full_45", length));
			String[] mty40 = (JSPUtil.getParameter(request, prefix	+ "mty_40", length));
			String[] teuEq = (JSPUtil.getParameter(request, prefix	+ "teu_eq", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] teuTotal = (JSPUtil.getParameter(request, prefix	+ "teu_total", length));
			String[] datasource = (JSPUtil.getParameter(request, prefix	+ "datasource", length));
			String[] val10 = (JSPUtil.getParameter(request, prefix	+ "val10", length));
			String[] val01 = (JSPUtil.getParameter(request, prefix	+ "val01", length));
			String[] val02 = (JSPUtil.getParameter(request, prefix	+ "val02", length));
			String[] val05 = (JSPUtil.getParameter(request, prefix	+ "val05", length));
			String[] fullTotal = (JSPUtil.getParameter(request, prefix	+ "full_total", length));
			String[] val06 = (JSPUtil.getParameter(request, prefix	+ "val06", length));
			String[] val03 = (JSPUtil.getParameter(request, prefix	+ "val03", length));
			String[] val04 = (JSPUtil.getParameter(request, prefix	+ "val04", length));
			String[] val09 = (JSPUtil.getParameter(request, prefix	+ "val09", length));
			String[] teuFull = (JSPUtil.getParameter(request, prefix	+ "teu_full", length));
			String[] val07 = (JSPUtil.getParameter(request, prefix	+ "val07", length));
			String[] eq20 = (JSPUtil.getParameter(request, prefix	+ "eq_20", length));
			String[] val08 = (JSPUtil.getParameter(request, prefix	+ "val08", length));
			String[] mtyHc = (JSPUtil.getParameter(request, prefix	+ "mty_hc", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] mtyTotal = (JSPUtil.getParameter(request, prefix	+ "mty_total", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] eqTotal = (JSPUtil.getParameter(request, prefix	+ "eq_total", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			String[] deadslot = (JSPUtil.getParameter(request, prefix	+ "deadslot", length));
			String[] releasedteu = (JSPUtil.getParameter(request, prefix	+ "releasedteu", length));
			String[] releasedweight = (JSPUtil.getParameter(request, prefix	+ "releasedweight", length));
			String[] weighttotal = (JSPUtil.getParameter(request, prefix	+ "weighttotal", length));
			String[] bsaweight = (JSPUtil.getParameter(request, prefix	+ "bsaweight", length));
			String[] bsaspace = (JSPUtil.getParameter(request, prefix	+ "bsaspace", length));
			String[] lffull = (JSPUtil.getParameter(request, prefix	+ "lffull", length));
			String[] lfeq = (JSPUtil.getParameter(request, prefix	+ "lfeq", length));
			String[] lfwgt = (JSPUtil.getParameter(request, prefix	+ "lfwgt", length));
			
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toRgn = (JSPUtil.getParameter(request, prefix	+ "to_rgn", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] wkStDt = (JSPUtil.getParameter(request, prefix	+ "wk_st_dt", length));
			String[] fromRgn = (JSPUtil.getParameter(request, prefix	+ "from_rgn", length));
			String[] wkEndDt = (JSPUtil.getParameter(request, prefix	+ "wk_end_dt", length));

			for (int i = 0; i < length; i++) {
				model = new SearchMBByVesselVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (fullHc[i] != null)
					model.setFullHc(fullHc[i]);
				if (com[i] != null)
					model.setCom(com[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (mty45[i] != null)
					model.setMty45(mty45[i]);
				if (mty20[i] != null)
					model.setMty20(mty20[i]);
				if (eq40[i] != null)
					model.setEq40(eq40[i]);
				if (lastport[i] != null)
					model.setLastport(lastport[i]);
				if (boxTotal[i] != null)
					model.setBoxTotal(boxTotal[i]);
				if (full20[i] != null)
					model.setFull20(full20[i]);
				if (eq45[i] != null)
					model.setEq45(eq45[i]);
				if (eqHc[i] != null)
					model.setEqHc(eqHc[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (full45[i] != null)
					model.setFull45(full45[i]);
				if (mty40[i] != null)
					model.setMty40(mty40[i]);
				if (teuEq[i] != null)
					model.setTeuEq(teuEq[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (teuTotal[i] != null)
					model.setTeuTotal(teuTotal[i]);
				if (datasource[i] != null)
					model.setDatasource(datasource[i]);
				if (val10[i] != null)
					model.setVal10(val10[i]);
				if (val01[i] != null)
					model.setVal01(val01[i]);
				if (val02[i] != null)
					model.setVal02(val02[i]);
				if (val05[i] != null)
					model.setVal05(val05[i]);
				if (fullTotal[i] != null)
					model.setFullTotal(fullTotal[i]);
				if (val06[i] != null)
					model.setVal06(val06[i]);
				if (val03[i] != null)
					model.setVal03(val03[i]);
				if (val04[i] != null)
					model.setVal04(val04[i]);
				if (val09[i] != null)
					model.setVal09(val09[i]);
				if (teuFull[i] != null)
					model.setTeuFull(teuFull[i]);
				if (val07[i] != null)
					model.setVal07(val07[i]);
				if (eq20[i] != null)
					model.setEq20(eq20[i]);
				if (val08[i] != null)
					model.setVal08(val08[i]);
				if (mtyHc[i] != null)
					model.setMtyHc(mtyHc[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (mtyTotal[i] != null)
					model.setMtyTotal(mtyTotal[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (eqTotal[i] != null)
					model.setEqTotal(eqTotal[i]);
				if (week[i] != null)
					model.setWeek(week[i]);

				if (deadslot[i] != null)
					model.setDeadslot(deadslot[i]);
				if (releasedteu[i] != null)
					model.setReleasedteu(releasedteu[i]);
				if (releasedweight[i] != null)
					model.setReleasedweight(releasedweight[i]);
				if (weighttotal[i] != null)
					model.setWeighttotal(weighttotal[i]);
				if (bsaweight[i] != null)
					model.setBsaweight(bsaweight[i]);
				if (bsaspace[i] != null)
					model.setBsaspace(bsaspace[i]);
				if (lffull[i] != null)
					model.setLffull(lffull[i]);
				if (lfeq[i] != null)
					model.setLfeq(lfeq[i]);
				if (lfwgt[i] != null)
					model.setLfwgt(lfwgt[i]);
				
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toRgn[i] != null)
					model.setToRgn(toRgn[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (wkStDt[i] != null)
					model.setWkStDt(wkStDt[i]);
				if (fromRgn[i] != null)
					model.setFromRgn(fromRgn[i]);
				if (wkEndDt[i] != null)
					model.setWkEndDt(wkEndDt[i]);
				models.add(model);
			}
		} catch (Exception e) {
			return null;
		}
		return getSearchMBByVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMBByVesselVO[]
	 */
	public SearchMBByVesselVO[] getSearchMBByVesselVOs(){
		SearchMBByVesselVO[] vos = (SearchMBByVesselVO[])models.toArray(new SearchMBByVesselVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullHc = this.fullHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.com = this.com .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty45 = this.mty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty20 = this.mty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eq40 = this.eq40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastport = this.lastport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxTotal = this.boxTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eq45 = this.eq45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqHc = this.eqHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full45 = this.full45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty40 = this.mty40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuEq = this.teuEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuTotal = this.teuTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datasource = this.datasource .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val10 = this.val10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val01 = this.val01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val02 = this.val02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val05 = this.val05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTotal = this.fullTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val06 = this.val06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val03 = this.val03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val04 = this.val04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val09 = this.val09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuFull = this.teuFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val07 = this.val07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eq20 = this.eq20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val08 = this.val08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyHc = this.mtyHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTotal = this.mtyTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTotal = this.eqTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deadslot = this.deadslot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releasedteu = this.releasedteu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releasedweight = this.releasedweight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weighttotal = this.weighttotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaweight = this.bsaweight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaspace = this.bsaspace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lffull = this.lffull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfeq = this.lfeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfwgt = this.lfwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRgn = this.toRgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkStDt = this.wkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromRgn = this.fromRgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEndDt = this.wkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
