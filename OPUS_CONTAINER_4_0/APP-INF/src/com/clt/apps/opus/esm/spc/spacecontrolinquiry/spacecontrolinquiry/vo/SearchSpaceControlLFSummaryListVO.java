/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSpaceControlLFSummaryListVO.java
*@FileTitle : SearchSpaceControlLFSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.19
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.01.19 최윤성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlLFSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlLFSummaryListVO> models = new ArrayList<SearchSpaceControlLFSummaryListVO>();
	
	/* Column Info */
	private String tEmpty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlLoad14 = null;
	/* Column Info */
	private String ttlLoad13 = null;
	/* Column Info */
	private String ttlLoad15 = null;
	/* Column Info */
	private String vvd10 = null;
	/* Column Info */
	private String ttlLoad10 = null;
	/* Column Info */
	private String vvd11 = null;
	/* Column Info */
	private String vvd12 = null;
	/* Column Info */
	private String ttlLoad12 = null;
	/* Column Info */
	private String vvd13 = null;
	/* Column Info */
	private String ttlLoad11 = null;
	/* Column Info */
	private String vvd14 = null;
	/* Column Info */
	private String vvd15 = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String ttlLf6 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String ttlLf7 = null;
	/* Column Info */
	private String ttlLf8 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String ttlLf9 = null;
	/* Column Info */
	private String vvd7 = null;
	/* Column Info */
	private String ttlLf3 = null;
	/* Column Info */
	private String vvd6 = null;
	/* Column Info */
	private String ttlLf2 = null;
	/* Column Info */
	private String vvd5 = null;
	/* Column Info */
	private String ttlLf5 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String ttlLf4 = null;
	/* Column Info */
	private String empty1 = null;
	/* Column Info */
	private String empty2 = null;
	/* Column Info */
	private String vvd9 = null;
	/* Column Info */
	private String empty3 = null;
	/* Column Info */
	private String ttlLf1 = null;
	/* Column Info */
	private String vvd8 = null;
	/* Column Info */
	private String empty4 = null;
	/* Column Info */
	private String ttlLoad5 = null;
	/* Column Info */
	private String empty5 = null;
	/* Column Info */
	private String ttlLoad4 = null;
	/* Column Info */
	private String empty6 = null;
	/* Column Info */
	private String ttlLoad3 = null;
	/* Column Info */
	private String empty7 = null;
	/* Column Info */
	private String ttlLoad2 = null;
	/* Column Info */
	private String empty8 = null;
	/* Column Info */
	private String ttlLoad9 = null;
	/* Column Info */
	private String empty9 = null;
	/* Column Info */
	private String ttlLoad8 = null;
	/* Column Info */
	private String ttlLoad7 = null;
	/* Column Info */
	private String ttlLoad6 = null;
	/* Column Info */
	private String full2 = null;
	/* Column Info */
	private String full1 = null;
	/* Column Info */
	private String tFullLf = null;
	/* Column Info */
	private String full6 = null;
	/* Column Info */
	private String full5 = null;
	/* Column Info */
	private String full4 = null;
	/* Column Info */
	private String full3 = null;
	/* Column Info */
	private String full9 = null;
	/* Column Info */
	private String full8 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String full7 = null;
	/* Column Info */
	private String bsa10 = null;
	/* Column Info */
	private String tLoad = null;
	/* Column Info */
	private String t = null;
	/* Column Info */
	private String bsa14 = null;
	/* Column Info */
	private String bsa13 = null;
	/* Column Info */
	private String bsa12 = null;
	/* Column Info */
	private String bsa11 = null;
	/* Column Info */
	private String bsa15 = null;
	/* Column Info */
	private String fullLf12 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fullLf13 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fullLf10 = null;
	/* Column Info */
	private String fullLf11 = null;
	/* Column Info */
	private String fullLf14 = null;
	/* Column Info */
	private String fullLf15 = null;
	/* Column Info */
	private String full12 = null;
	/* Column Info */
	private String full13 = null;
	/* Column Info */
	private String full14 = null;
	/* Column Info */
	private String full15 = null;
	/* Column Info */
	private String full11 = null;
	/* Column Info */
	private String full10 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fullLf1 = null;
	/* Column Info */
	private String fullLf2 = null;
	/* Column Info */
	private String ttlLoad1 = null;
	/* Column Info */
	private String fullLf3 = null;
	/* Column Info */
	private String fullLf4 = null;
	/* Column Info */
	private String fullLf5 = null;
	/* Column Info */
	private String fullLf6 = null;
	/* Column Info */
	private String fullLf7 = null;
	/* Column Info */
	private String fullLf8 = null;
	/* Column Info */
	private String fullLf9 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa9 = null;
	/* Column Info */
	private String bsa8 = null;
	/* Column Info */
	private String bsa5 = null;
	/* Column Info */
	private String bsa4 = null;
	/* Column Info */
	private String bsa7 = null;
	/* Column Info */
	private String bsa6 = null;
	/* Column Info */
	private String bsa1 = null;
	/* Column Info */
	private String bsa3 = null;
	/* Column Info */
	private String bsa2 = null;
	/* Column Info */
	private String empty14 = null;
	/* Column Info */
	private String tBsa = null;
	/* Column Info */
	private String empty15 = null;
	/* Column Info */
	private String ttlLf15 = null;
	/* Column Info */
	private String ttlLf14 = null;
	/* Column Info */
	private String ttlLf13 = null;
	/* Column Info */
	private String tTtlLf = null;
	/* Column Info */
	private String ttlLf12 = null;
	/* Column Info */
	private String ttlLf11 = null;
	/* Column Info */
	private String ttlLf10 = null;
	/* Column Info */
	private String tFull = null;
	/* Column Info */
	private String empty13 = null;
	/* Column Info */
	private String empty12 = null;
	/* Column Info */
	private String empty11 = null;
	/* Column Info */
	private String empty10 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlLFSummaryListVO() {}

	public SearchSpaceControlLFSummaryListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String tBsa, String tFull, String tEmpty, String tLoad, String t, String vvd1, String vvd2, String vvd3, String vvd4, String vvd5, String vvd6, String vvd7, String vvd8, String vvd9, String vvd10, String vvd11, String vvd12, String vvd13, String vvd14, String vvd15, String bsa1, String bsa2, String bsa3, String bsa4, String bsa5, String bsa6, String bsa7, String bsa8, String bsa9, String bsa10, String bsa11, String bsa12, String bsa13, String bsa14, String bsa15, String full1, String full2, String full3, String full4, String full5, String full6, String full7, String full8, String full9, String full10, String full11, String full12, String full13, String full14, String full15, String empty1, String empty2, String empty3, String empty4, String empty5, String empty6, String empty7, String empty8, String empty9, String empty10, String empty11, String empty12, String empty13, String empty14, String empty15, String fullLf1, String fullLf2, String fullLf3, String fullLf4, String fullLf5, String fullLf6, String fullLf7, String fullLf8, String fullLf9, String fullLf10, String fullLf11, String fullLf12, String fullLf13, String fullLf14, String fullLf15, String ttlLf1, String ttlLf2, String ttlLf3, String ttlLf4, String ttlLf5, String ttlLf6, String ttlLf7, String ttlLf8, String ttlLf9, String ttlLf10, String ttlLf11, String ttlLf12, String ttlLf13, String ttlLf14, String ttlLf15, String tFullLf, String tTtlLf, String ttlLoad1, String ttlLoad2, String ttlLoad3, String ttlLoad4, String ttlLoad5, String ttlLoad6, String ttlLoad7, String ttlLoad8, String ttlLoad9, String ttlLoad10, String ttlLoad11, String ttlLoad12, String ttlLoad13, String ttlLoad14, String ttlLoad15) {
		this.tEmpty = tEmpty;
		this.pagerows = pagerows;
		this.ttlLoad14 = ttlLoad14;
		this.ttlLoad13 = ttlLoad13;
		this.ttlLoad15 = ttlLoad15;
		this.vvd10 = vvd10;
		this.ttlLoad10 = ttlLoad10;
		this.vvd11 = vvd11;
		this.vvd12 = vvd12;
		this.ttlLoad12 = ttlLoad12;
		this.vvd13 = vvd13;
		this.ttlLoad11 = ttlLoad11;
		this.vvd14 = vvd14;
		this.vvd15 = vvd15;
		this.vvd2 = vvd2;
		this.ttlLf6 = ttlLf6;
		this.vvd3 = vvd3;
		this.ttlLf7 = ttlLf7;
		this.ttlLf8 = ttlLf8;
		this.vvd1 = vvd1;
		this.ttlLf9 = ttlLf9;
		this.vvd7 = vvd7;
		this.ttlLf3 = ttlLf3;
		this.vvd6 = vvd6;
		this.ttlLf2 = ttlLf2;
		this.vvd5 = vvd5;
		this.ttlLf5 = ttlLf5;
		this.vvd4 = vvd4;
		this.ttlLf4 = ttlLf4;
		this.empty1 = empty1;
		this.empty2 = empty2;
		this.vvd9 = vvd9;
		this.empty3 = empty3;
		this.ttlLf1 = ttlLf1;
		this.vvd8 = vvd8;
		this.empty4 = empty4;
		this.ttlLoad5 = ttlLoad5;
		this.empty5 = empty5;
		this.ttlLoad4 = ttlLoad4;
		this.empty6 = empty6;
		this.ttlLoad3 = ttlLoad3;
		this.empty7 = empty7;
		this.ttlLoad2 = ttlLoad2;
		this.empty8 = empty8;
		this.ttlLoad9 = ttlLoad9;
		this.empty9 = empty9;
		this.ttlLoad8 = ttlLoad8;
		this.ttlLoad7 = ttlLoad7;
		this.ttlLoad6 = ttlLoad6;
		this.full2 = full2;
		this.full1 = full1;
		this.tFullLf = tFullLf;
		this.full6 = full6;
		this.full5 = full5;
		this.full4 = full4;
		this.full3 = full3;
		this.full9 = full9;
		this.full8 = full8;
		this.dirCd = dirCd;
		this.full7 = full7;
		this.bsa10 = bsa10;
		this.tLoad = tLoad;
		this.t = t;
		this.bsa14 = bsa14;
		this.bsa13 = bsa13;
		this.bsa12 = bsa12;
		this.bsa11 = bsa11;
		this.bsa15 = bsa15;
		this.fullLf12 = fullLf12;
		this.trdCd = trdCd;
		this.fullLf13 = fullLf13;
		this.rlaneCd = rlaneCd;
		this.fullLf10 = fullLf10;
		this.fullLf11 = fullLf11;
		this.fullLf14 = fullLf14;
		this.fullLf15 = fullLf15;
		this.full12 = full12;
		this.full13 = full13;
		this.full14 = full14;
		this.full15 = full15;
		this.full11 = full11;
		this.full10 = full10;
		this.subTrdCd = subTrdCd;
		this.fullLf1 = fullLf1;
		this.fullLf2 = fullLf2;
		this.ttlLoad1 = ttlLoad1;
		this.fullLf3 = fullLf3;
		this.fullLf4 = fullLf4;
		this.fullLf5 = fullLf5;
		this.fullLf6 = fullLf6;
		this.fullLf7 = fullLf7;
		this.fullLf8 = fullLf8;
		this.fullLf9 = fullLf9;
		this.ibflag = ibflag;
		this.bsa9 = bsa9;
		this.bsa8 = bsa8;
		this.bsa5 = bsa5;
		this.bsa4 = bsa4;
		this.bsa7 = bsa7;
		this.bsa6 = bsa6;
		this.bsa1 = bsa1;
		this.bsa3 = bsa3;
		this.bsa2 = bsa2;
		this.empty14 = empty14;
		this.tBsa = tBsa;
		this.empty15 = empty15;
		this.ttlLf15 = ttlLf15;
		this.ttlLf14 = ttlLf14;
		this.ttlLf13 = ttlLf13;
		this.tTtlLf = tTtlLf;
		this.ttlLf12 = ttlLf12;
		this.ttlLf11 = ttlLf11;
		this.ttlLf10 = ttlLf10;
		this.tFull = tFull;
		this.empty13 = empty13;
		this.empty12 = empty12;
		this.empty11 = empty11;
		this.empty10 = empty10;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_empty", getTEmpty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_load14", getTtlLoad14());
		this.hashColumns.put("ttl_load13", getTtlLoad13());
		this.hashColumns.put("ttl_load15", getTtlLoad15());
		this.hashColumns.put("vvd10", getVvd10());
		this.hashColumns.put("ttl_load10", getTtlLoad10());
		this.hashColumns.put("vvd11", getVvd11());
		this.hashColumns.put("vvd12", getVvd12());
		this.hashColumns.put("ttl_load12", getTtlLoad12());
		this.hashColumns.put("vvd13", getVvd13());
		this.hashColumns.put("ttl_load11", getTtlLoad11());
		this.hashColumns.put("vvd14", getVvd14());
		this.hashColumns.put("vvd15", getVvd15());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("ttl_lf6", getTtlLf6());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("ttl_lf7", getTtlLf7());
		this.hashColumns.put("ttl_lf8", getTtlLf8());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("ttl_lf9", getTtlLf9());
		this.hashColumns.put("vvd7", getVvd7());
		this.hashColumns.put("ttl_lf3", getTtlLf3());
		this.hashColumns.put("vvd6", getVvd6());
		this.hashColumns.put("ttl_lf2", getTtlLf2());
		this.hashColumns.put("vvd5", getVvd5());
		this.hashColumns.put("ttl_lf5", getTtlLf5());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("ttl_lf4", getTtlLf4());
		this.hashColumns.put("empty1", getEmpty1());
		this.hashColumns.put("empty2", getEmpty2());
		this.hashColumns.put("vvd9", getVvd9());
		this.hashColumns.put("empty3", getEmpty3());
		this.hashColumns.put("ttl_lf1", getTtlLf1());
		this.hashColumns.put("vvd8", getVvd8());
		this.hashColumns.put("empty4", getEmpty4());
		this.hashColumns.put("ttl_load5", getTtlLoad5());
		this.hashColumns.put("empty5", getEmpty5());
		this.hashColumns.put("ttl_load4", getTtlLoad4());
		this.hashColumns.put("empty6", getEmpty6());
		this.hashColumns.put("ttl_load3", getTtlLoad3());
		this.hashColumns.put("empty7", getEmpty7());
		this.hashColumns.put("ttl_load2", getTtlLoad2());
		this.hashColumns.put("empty8", getEmpty8());
		this.hashColumns.put("ttl_load9", getTtlLoad9());
		this.hashColumns.put("empty9", getEmpty9());
		this.hashColumns.put("ttl_load8", getTtlLoad8());
		this.hashColumns.put("ttl_load7", getTtlLoad7());
		this.hashColumns.put("ttl_load6", getTtlLoad6());
		this.hashColumns.put("full2", getFull2());
		this.hashColumns.put("full1", getFull1());
		this.hashColumns.put("t_full_lf", getTFullLf());
		this.hashColumns.put("full6", getFull6());
		this.hashColumns.put("full5", getFull5());
		this.hashColumns.put("full4", getFull4());
		this.hashColumns.put("full3", getFull3());
		this.hashColumns.put("full9", getFull9());
		this.hashColumns.put("full8", getFull8());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("full7", getFull7());
		this.hashColumns.put("bsa10", getBsa10());
		this.hashColumns.put("t_load", getTLoad());
		this.hashColumns.put("t", getT());
		this.hashColumns.put("bsa14", getBsa14());
		this.hashColumns.put("bsa13", getBsa13());
		this.hashColumns.put("bsa12", getBsa12());
		this.hashColumns.put("bsa11", getBsa11());
		this.hashColumns.put("bsa15", getBsa15());
		this.hashColumns.put("full_lf12", getFullLf12());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("full_lf13", getFullLf13());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("full_lf10", getFullLf10());
		this.hashColumns.put("full_lf11", getFullLf11());
		this.hashColumns.put("full_lf14", getFullLf14());
		this.hashColumns.put("full_lf15", getFullLf15());
		this.hashColumns.put("full12", getFull12());
		this.hashColumns.put("full13", getFull13());
		this.hashColumns.put("full14", getFull14());
		this.hashColumns.put("full15", getFull15());
		this.hashColumns.put("full11", getFull11());
		this.hashColumns.put("full10", getFull10());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("full_lf1", getFullLf1());
		this.hashColumns.put("full_lf2", getFullLf2());
		this.hashColumns.put("ttl_load1", getTtlLoad1());
		this.hashColumns.put("full_lf3", getFullLf3());
		this.hashColumns.put("full_lf4", getFullLf4());
		this.hashColumns.put("full_lf5", getFullLf5());
		this.hashColumns.put("full_lf6", getFullLf6());
		this.hashColumns.put("full_lf7", getFullLf7());
		this.hashColumns.put("full_lf8", getFullLf8());
		this.hashColumns.put("full_lf9", getFullLf9());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa9", getBsa9());
		this.hashColumns.put("bsa8", getBsa8());
		this.hashColumns.put("bsa5", getBsa5());
		this.hashColumns.put("bsa4", getBsa4());
		this.hashColumns.put("bsa7", getBsa7());
		this.hashColumns.put("bsa6", getBsa6());
		this.hashColumns.put("bsa1", getBsa1());
		this.hashColumns.put("bsa3", getBsa3());
		this.hashColumns.put("bsa2", getBsa2());
		this.hashColumns.put("empty14", getEmpty14());
		this.hashColumns.put("t_bsa", getTBsa());
		this.hashColumns.put("empty15", getEmpty15());
		this.hashColumns.put("ttl_lf15", getTtlLf15());
		this.hashColumns.put("ttl_lf14", getTtlLf14());
		this.hashColumns.put("ttl_lf13", getTtlLf13());
		this.hashColumns.put("t_ttl_lf", getTTtlLf());
		this.hashColumns.put("ttl_lf12", getTtlLf12());
		this.hashColumns.put("ttl_lf11", getTtlLf11());
		this.hashColumns.put("ttl_lf10", getTtlLf10());
		this.hashColumns.put("t_full", getTFull());
		this.hashColumns.put("empty13", getEmpty13());
		this.hashColumns.put("empty12", getEmpty12());
		this.hashColumns.put("empty11", getEmpty11());
		this.hashColumns.put("empty10", getEmpty10());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_empty", "tEmpty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_load14", "ttlLoad14");
		this.hashFields.put("ttl_load13", "ttlLoad13");
		this.hashFields.put("ttl_load15", "ttlLoad15");
		this.hashFields.put("vvd10", "vvd10");
		this.hashFields.put("ttl_load10", "ttlLoad10");
		this.hashFields.put("vvd11", "vvd11");
		this.hashFields.put("vvd12", "vvd12");
		this.hashFields.put("ttl_load12", "ttlLoad12");
		this.hashFields.put("vvd13", "vvd13");
		this.hashFields.put("ttl_load11", "ttlLoad11");
		this.hashFields.put("vvd14", "vvd14");
		this.hashFields.put("vvd15", "vvd15");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("ttl_lf6", "ttlLf6");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("ttl_lf7", "ttlLf7");
		this.hashFields.put("ttl_lf8", "ttlLf8");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("ttl_lf9", "ttlLf9");
		this.hashFields.put("vvd7", "vvd7");
		this.hashFields.put("ttl_lf3", "ttlLf3");
		this.hashFields.put("vvd6", "vvd6");
		this.hashFields.put("ttl_lf2", "ttlLf2");
		this.hashFields.put("vvd5", "vvd5");
		this.hashFields.put("ttl_lf5", "ttlLf5");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("ttl_lf4", "ttlLf4");
		this.hashFields.put("empty1", "empty1");
		this.hashFields.put("empty2", "empty2");
		this.hashFields.put("vvd9", "vvd9");
		this.hashFields.put("empty3", "empty3");
		this.hashFields.put("ttl_lf1", "ttlLf1");
		this.hashFields.put("vvd8", "vvd8");
		this.hashFields.put("empty4", "empty4");
		this.hashFields.put("ttl_load5", "ttlLoad5");
		this.hashFields.put("empty5", "empty5");
		this.hashFields.put("ttl_load4", "ttlLoad4");
		this.hashFields.put("empty6", "empty6");
		this.hashFields.put("ttl_load3", "ttlLoad3");
		this.hashFields.put("empty7", "empty7");
		this.hashFields.put("ttl_load2", "ttlLoad2");
		this.hashFields.put("empty8", "empty8");
		this.hashFields.put("ttl_load9", "ttlLoad9");
		this.hashFields.put("empty9", "empty9");
		this.hashFields.put("ttl_load8", "ttlLoad8");
		this.hashFields.put("ttl_load7", "ttlLoad7");
		this.hashFields.put("ttl_load6", "ttlLoad6");
		this.hashFields.put("full2", "full2");
		this.hashFields.put("full1", "full1");
		this.hashFields.put("t_full_lf", "tFullLf");
		this.hashFields.put("full6", "full6");
		this.hashFields.put("full5", "full5");
		this.hashFields.put("full4", "full4");
		this.hashFields.put("full3", "full3");
		this.hashFields.put("full9", "full9");
		this.hashFields.put("full8", "full8");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("full7", "full7");
		this.hashFields.put("bsa10", "bsa10");
		this.hashFields.put("t_load", "tLoad");
		this.hashFields.put("t", "t");
		this.hashFields.put("bsa14", "bsa14");
		this.hashFields.put("bsa13", "bsa13");
		this.hashFields.put("bsa12", "bsa12");
		this.hashFields.put("bsa11", "bsa11");
		this.hashFields.put("bsa15", "bsa15");
		this.hashFields.put("full_lf12", "fullLf12");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("full_lf13", "fullLf13");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("full_lf10", "fullLf10");
		this.hashFields.put("full_lf11", "fullLf11");
		this.hashFields.put("full_lf14", "fullLf14");
		this.hashFields.put("full_lf15", "fullLf15");
		this.hashFields.put("full12", "full12");
		this.hashFields.put("full13", "full13");
		this.hashFields.put("full14", "full14");
		this.hashFields.put("full15", "full15");
		this.hashFields.put("full11", "full11");
		this.hashFields.put("full10", "full10");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("full_lf1", "fullLf1");
		this.hashFields.put("full_lf2", "fullLf2");
		this.hashFields.put("ttl_load1", "ttlLoad1");
		this.hashFields.put("full_lf3", "fullLf3");
		this.hashFields.put("full_lf4", "fullLf4");
		this.hashFields.put("full_lf5", "fullLf5");
		this.hashFields.put("full_lf6", "fullLf6");
		this.hashFields.put("full_lf7", "fullLf7");
		this.hashFields.put("full_lf8", "fullLf8");
		this.hashFields.put("full_lf9", "fullLf9");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa9", "bsa9");
		this.hashFields.put("bsa8", "bsa8");
		this.hashFields.put("bsa5", "bsa5");
		this.hashFields.put("bsa4", "bsa4");
		this.hashFields.put("bsa7", "bsa7");
		this.hashFields.put("bsa6", "bsa6");
		this.hashFields.put("bsa1", "bsa1");
		this.hashFields.put("bsa3", "bsa3");
		this.hashFields.put("bsa2", "bsa2");
		this.hashFields.put("empty14", "empty14");
		this.hashFields.put("t_bsa", "tBsa");
		this.hashFields.put("empty15", "empty15");
		this.hashFields.put("ttl_lf15", "ttlLf15");
		this.hashFields.put("ttl_lf14", "ttlLf14");
		this.hashFields.put("ttl_lf13", "ttlLf13");
		this.hashFields.put("t_ttl_lf", "tTtlLf");
		this.hashFields.put("ttl_lf12", "ttlLf12");
		this.hashFields.put("ttl_lf11", "ttlLf11");
		this.hashFields.put("ttl_lf10", "ttlLf10");
		this.hashFields.put("t_full", "tFull");
		this.hashFields.put("empty13", "empty13");
		this.hashFields.put("empty12", "empty12");
		this.hashFields.put("empty11", "empty11");
		this.hashFields.put("empty10", "empty10");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tEmpty
	 */
	public String getTEmpty() {
		return this.tEmpty;
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
	 * @return ttlLoad14
	 */
	public String getTtlLoad14() {
		return this.ttlLoad14;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad13
	 */
	public String getTtlLoad13() {
		return this.ttlLoad13;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad15
	 */
	public String getTtlLoad15() {
		return this.ttlLoad15;
	}
	
	/**
	 * Column Info
	 * @return vvd10
	 */
	public String getVvd10() {
		return this.vvd10;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad10
	 */
	public String getTtlLoad10() {
		return this.ttlLoad10;
	}
	
	/**
	 * Column Info
	 * @return vvd11
	 */
	public String getVvd11() {
		return this.vvd11;
	}
	
	/**
	 * Column Info
	 * @return vvd12
	 */
	public String getVvd12() {
		return this.vvd12;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad12
	 */
	public String getTtlLoad12() {
		return this.ttlLoad12;
	}
	
	/**
	 * Column Info
	 * @return vvd13
	 */
	public String getVvd13() {
		return this.vvd13;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad11
	 */
	public String getTtlLoad11() {
		return this.ttlLoad11;
	}
	
	/**
	 * Column Info
	 * @return vvd14
	 */
	public String getVvd14() {
		return this.vvd14;
	}
	
	/**
	 * Column Info
	 * @return vvd15
	 */
	public String getVvd15() {
		return this.vvd15;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return ttlLf6
	 */
	public String getTtlLf6() {
		return this.ttlLf6;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return ttlLf7
	 */
	public String getTtlLf7() {
		return this.ttlLf7;
	}
	
	/**
	 * Column Info
	 * @return ttlLf8
	 */
	public String getTtlLf8() {
		return this.ttlLf8;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return ttlLf9
	 */
	public String getTtlLf9() {
		return this.ttlLf9;
	}
	
	/**
	 * Column Info
	 * @return vvd7
	 */
	public String getVvd7() {
		return this.vvd7;
	}
	
	/**
	 * Column Info
	 * @return ttlLf3
	 */
	public String getTtlLf3() {
		return this.ttlLf3;
	}
	
	/**
	 * Column Info
	 * @return vvd6
	 */
	public String getVvd6() {
		return this.vvd6;
	}
	
	/**
	 * Column Info
	 * @return ttlLf2
	 */
	public String getTtlLf2() {
		return this.ttlLf2;
	}
	
	/**
	 * Column Info
	 * @return vvd5
	 */
	public String getVvd5() {
		return this.vvd5;
	}
	
	/**
	 * Column Info
	 * @return ttlLf5
	 */
	public String getTtlLf5() {
		return this.ttlLf5;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return ttlLf4
	 */
	public String getTtlLf4() {
		return this.ttlLf4;
	}
	
	/**
	 * Column Info
	 * @return empty1
	 */
	public String getEmpty1() {
		return this.empty1;
	}
	
	/**
	 * Column Info
	 * @return empty2
	 */
	public String getEmpty2() {
		return this.empty2;
	}
	
	/**
	 * Column Info
	 * @return vvd9
	 */
	public String getVvd9() {
		return this.vvd9;
	}
	
	/**
	 * Column Info
	 * @return empty3
	 */
	public String getEmpty3() {
		return this.empty3;
	}
	
	/**
	 * Column Info
	 * @return ttlLf1
	 */
	public String getTtlLf1() {
		return this.ttlLf1;
	}
	
	/**
	 * Column Info
	 * @return vvd8
	 */
	public String getVvd8() {
		return this.vvd8;
	}
	
	/**
	 * Column Info
	 * @return empty4
	 */
	public String getEmpty4() {
		return this.empty4;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad5
	 */
	public String getTtlLoad5() {
		return this.ttlLoad5;
	}
	
	/**
	 * Column Info
	 * @return empty5
	 */
	public String getEmpty5() {
		return this.empty5;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad4
	 */
	public String getTtlLoad4() {
		return this.ttlLoad4;
	}
	
	/**
	 * Column Info
	 * @return empty6
	 */
	public String getEmpty6() {
		return this.empty6;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad3
	 */
	public String getTtlLoad3() {
		return this.ttlLoad3;
	}
	
	/**
	 * Column Info
	 * @return empty7
	 */
	public String getEmpty7() {
		return this.empty7;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad2
	 */
	public String getTtlLoad2() {
		return this.ttlLoad2;
	}
	
	/**
	 * Column Info
	 * @return empty8
	 */
	public String getEmpty8() {
		return this.empty8;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad9
	 */
	public String getTtlLoad9() {
		return this.ttlLoad9;
	}
	
	/**
	 * Column Info
	 * @return empty9
	 */
	public String getEmpty9() {
		return this.empty9;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad8
	 */
	public String getTtlLoad8() {
		return this.ttlLoad8;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad7
	 */
	public String getTtlLoad7() {
		return this.ttlLoad7;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad6
	 */
	public String getTtlLoad6() {
		return this.ttlLoad6;
	}
	
	/**
	 * Column Info
	 * @return full2
	 */
	public String getFull2() {
		return this.full2;
	}
	
	/**
	 * Column Info
	 * @return full1
	 */
	public String getFull1() {
		return this.full1;
	}
	
	/**
	 * Column Info
	 * @return tFullLf
	 */
	public String getTFullLf() {
		return this.tFullLf;
	}
	
	/**
	 * Column Info
	 * @return full6
	 */
	public String getFull6() {
		return this.full6;
	}
	
	/**
	 * Column Info
	 * @return full5
	 */
	public String getFull5() {
		return this.full5;
	}
	
	/**
	 * Column Info
	 * @return full4
	 */
	public String getFull4() {
		return this.full4;
	}
	
	/**
	 * Column Info
	 * @return full3
	 */
	public String getFull3() {
		return this.full3;
	}
	
	/**
	 * Column Info
	 * @return full9
	 */
	public String getFull9() {
		return this.full9;
	}
	
	/**
	 * Column Info
	 * @return full8
	 */
	public String getFull8() {
		return this.full8;
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
	 * @return full7
	 */
	public String getFull7() {
		return this.full7;
	}
	
	/**
	 * Column Info
	 * @return bsa10
	 */
	public String getBsa10() {
		return this.bsa10;
	}
	
	/**
	 * Column Info
	 * @return tLoad
	 */
	public String getTLoad() {
		return this.tLoad;
	}
	
	/**
	 * Column Info
	 * @return t
	 */
	public String getT() {
		return this.t;
	}
	
	/**
	 * Column Info
	 * @return bsa14
	 */
	public String getBsa14() {
		return this.bsa14;
	}
	
	/**
	 * Column Info
	 * @return bsa13
	 */
	public String getBsa13() {
		return this.bsa13;
	}
	
	/**
	 * Column Info
	 * @return bsa12
	 */
	public String getBsa12() {
		return this.bsa12;
	}
	
	/**
	 * Column Info
	 * @return bsa11
	 */
	public String getBsa11() {
		return this.bsa11;
	}
	
	/**
	 * Column Info
	 * @return bsa15
	 */
	public String getBsa15() {
		return this.bsa15;
	}
	
	/**
	 * Column Info
	 * @return fullLf12
	 */
	public String getFullLf12() {
		return this.fullLf12;
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
	 * @return fullLf13
	 */
	public String getFullLf13() {
		return this.fullLf13;
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
	 * @return fullLf10
	 */
	public String getFullLf10() {
		return this.fullLf10;
	}
	
	/**
	 * Column Info
	 * @return fullLf11
	 */
	public String getFullLf11() {
		return this.fullLf11;
	}
	
	/**
	 * Column Info
	 * @return fullLf14
	 */
	public String getFullLf14() {
		return this.fullLf14;
	}
	
	/**
	 * Column Info
	 * @return fullLf15
	 */
	public String getFullLf15() {
		return this.fullLf15;
	}
	
	/**
	 * Column Info
	 * @return full12
	 */
	public String getFull12() {
		return this.full12;
	}
	
	/**
	 * Column Info
	 * @return full13
	 */
	public String getFull13() {
		return this.full13;
	}
	
	/**
	 * Column Info
	 * @return full14
	 */
	public String getFull14() {
		return this.full14;
	}
	
	/**
	 * Column Info
	 * @return full15
	 */
	public String getFull15() {
		return this.full15;
	}
	
	/**
	 * Column Info
	 * @return full11
	 */
	public String getFull11() {
		return this.full11;
	}
	
	/**
	 * Column Info
	 * @return full10
	 */
	public String getFull10() {
		return this.full10;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fullLf1
	 */
	public String getFullLf1() {
		return this.fullLf1;
	}
	
	/**
	 * Column Info
	 * @return fullLf2
	 */
	public String getFullLf2() {
		return this.fullLf2;
	}
	
	/**
	 * Column Info
	 * @return ttlLoad1
	 */
	public String getTtlLoad1() {
		return this.ttlLoad1;
	}
	
	/**
	 * Column Info
	 * @return fullLf3
	 */
	public String getFullLf3() {
		return this.fullLf3;
	}
	
	/**
	 * Column Info
	 * @return fullLf4
	 */
	public String getFullLf4() {
		return this.fullLf4;
	}
	
	/**
	 * Column Info
	 * @return fullLf5
	 */
	public String getFullLf5() {
		return this.fullLf5;
	}
	
	/**
	 * Column Info
	 * @return fullLf6
	 */
	public String getFullLf6() {
		return this.fullLf6;
	}
	
	/**
	 * Column Info
	 * @return fullLf7
	 */
	public String getFullLf7() {
		return this.fullLf7;
	}
	
	/**
	 * Column Info
	 * @return fullLf8
	 */
	public String getFullLf8() {
		return this.fullLf8;
	}
	
	/**
	 * Column Info
	 * @return fullLf9
	 */
	public String getFullLf9() {
		return this.fullLf9;
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
	 * @return bsa9
	 */
	public String getBsa9() {
		return this.bsa9;
	}
	
	/**
	 * Column Info
	 * @return bsa8
	 */
	public String getBsa8() {
		return this.bsa8;
	}
	
	/**
	 * Column Info
	 * @return bsa5
	 */
	public String getBsa5() {
		return this.bsa5;
	}
	
	/**
	 * Column Info
	 * @return bsa4
	 */
	public String getBsa4() {
		return this.bsa4;
	}
	
	/**
	 * Column Info
	 * @return bsa7
	 */
	public String getBsa7() {
		return this.bsa7;
	}
	
	/**
	 * Column Info
	 * @return bsa6
	 */
	public String getBsa6() {
		return this.bsa6;
	}
	
	/**
	 * Column Info
	 * @return bsa1
	 */
	public String getBsa1() {
		return this.bsa1;
	}
	
	/**
	 * Column Info
	 * @return bsa3
	 */
	public String getBsa3() {
		return this.bsa3;
	}
	
	/**
	 * Column Info
	 * @return bsa2
	 */
	public String getBsa2() {
		return this.bsa2;
	}
	
	/**
	 * Column Info
	 * @return empty14
	 */
	public String getEmpty14() {
		return this.empty14;
	}
	
	/**
	 * Column Info
	 * @return tBsa
	 */
	public String getTBsa() {
		return this.tBsa;
	}
	
	/**
	 * Column Info
	 * @return empty15
	 */
	public String getEmpty15() {
		return this.empty15;
	}
	
	/**
	 * Column Info
	 * @return ttlLf15
	 */
	public String getTtlLf15() {
		return this.ttlLf15;
	}
	
	/**
	 * Column Info
	 * @return ttlLf14
	 */
	public String getTtlLf14() {
		return this.ttlLf14;
	}
	
	/**
	 * Column Info
	 * @return ttlLf13
	 */
	public String getTtlLf13() {
		return this.ttlLf13;
	}
	
	/**
	 * Column Info
	 * @return tTtlLf
	 */
	public String getTTtlLf() {
		return this.tTtlLf;
	}
	
	/**
	 * Column Info
	 * @return ttlLf12
	 */
	public String getTtlLf12() {
		return this.ttlLf12;
	}
	
	/**
	 * Column Info
	 * @return ttlLf11
	 */
	public String getTtlLf11() {
		return this.ttlLf11;
	}
	
	/**
	 * Column Info
	 * @return ttlLf10
	 */
	public String getTtlLf10() {
		return this.ttlLf10;
	}
	
	/**
	 * Column Info
	 * @return tFull
	 */
	public String getTFull() {
		return this.tFull;
	}
	
	/**
	 * Column Info
	 * @return empty13
	 */
	public String getEmpty13() {
		return this.empty13;
	}
	
	/**
	 * Column Info
	 * @return empty12
	 */
	public String getEmpty12() {
		return this.empty12;
	}
	
	/**
	 * Column Info
	 * @return empty11
	 */
	public String getEmpty11() {
		return this.empty11;
	}
	
	/**
	 * Column Info
	 * @return empty10
	 */
	public String getEmpty10() {
		return this.empty10;
	}
	

	/**
	 * Column Info
	 * @param tEmpty
	 */
	public void setTEmpty(String tEmpty) {
		this.tEmpty = tEmpty;
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
	 * @param ttlLoad14
	 */
	public void setTtlLoad14(String ttlLoad14) {
		this.ttlLoad14 = ttlLoad14;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad13
	 */
	public void setTtlLoad13(String ttlLoad13) {
		this.ttlLoad13 = ttlLoad13;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad15
	 */
	public void setTtlLoad15(String ttlLoad15) {
		this.ttlLoad15 = ttlLoad15;
	}
	
	/**
	 * Column Info
	 * @param vvd10
	 */
	public void setVvd10(String vvd10) {
		this.vvd10 = vvd10;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad10
	 */
	public void setTtlLoad10(String ttlLoad10) {
		this.ttlLoad10 = ttlLoad10;
	}
	
	/**
	 * Column Info
	 * @param vvd11
	 */
	public void setVvd11(String vvd11) {
		this.vvd11 = vvd11;
	}
	
	/**
	 * Column Info
	 * @param vvd12
	 */
	public void setVvd12(String vvd12) {
		this.vvd12 = vvd12;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad12
	 */
	public void setTtlLoad12(String ttlLoad12) {
		this.ttlLoad12 = ttlLoad12;
	}
	
	/**
	 * Column Info
	 * @param vvd13
	 */
	public void setVvd13(String vvd13) {
		this.vvd13 = vvd13;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad11
	 */
	public void setTtlLoad11(String ttlLoad11) {
		this.ttlLoad11 = ttlLoad11;
	}
	
	/**
	 * Column Info
	 * @param vvd14
	 */
	public void setVvd14(String vvd14) {
		this.vvd14 = vvd14;
	}
	
	/**
	 * Column Info
	 * @param vvd15
	 */
	public void setVvd15(String vvd15) {
		this.vvd15 = vvd15;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param ttlLf6
	 */
	public void setTtlLf6(String ttlLf6) {
		this.ttlLf6 = ttlLf6;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param ttlLf7
	 */
	public void setTtlLf7(String ttlLf7) {
		this.ttlLf7 = ttlLf7;
	}
	
	/**
	 * Column Info
	 * @param ttlLf8
	 */
	public void setTtlLf8(String ttlLf8) {
		this.ttlLf8 = ttlLf8;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param ttlLf9
	 */
	public void setTtlLf9(String ttlLf9) {
		this.ttlLf9 = ttlLf9;
	}
	
	/**
	 * Column Info
	 * @param vvd7
	 */
	public void setVvd7(String vvd7) {
		this.vvd7 = vvd7;
	}
	
	/**
	 * Column Info
	 * @param ttlLf3
	 */
	public void setTtlLf3(String ttlLf3) {
		this.ttlLf3 = ttlLf3;
	}
	
	/**
	 * Column Info
	 * @param vvd6
	 */
	public void setVvd6(String vvd6) {
		this.vvd6 = vvd6;
	}
	
	/**
	 * Column Info
	 * @param ttlLf2
	 */
	public void setTtlLf2(String ttlLf2) {
		this.ttlLf2 = ttlLf2;
	}
	
	/**
	 * Column Info
	 * @param vvd5
	 */
	public void setVvd5(String vvd5) {
		this.vvd5 = vvd5;
	}
	
	/**
	 * Column Info
	 * @param ttlLf5
	 */
	public void setTtlLf5(String ttlLf5) {
		this.ttlLf5 = ttlLf5;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param ttlLf4
	 */
	public void setTtlLf4(String ttlLf4) {
		this.ttlLf4 = ttlLf4;
	}
	
	/**
	 * Column Info
	 * @param empty1
	 */
	public void setEmpty1(String empty1) {
		this.empty1 = empty1;
	}
	
	/**
	 * Column Info
	 * @param empty2
	 */
	public void setEmpty2(String empty2) {
		this.empty2 = empty2;
	}
	
	/**
	 * Column Info
	 * @param vvd9
	 */
	public void setVvd9(String vvd9) {
		this.vvd9 = vvd9;
	}
	
	/**
	 * Column Info
	 * @param empty3
	 */
	public void setEmpty3(String empty3) {
		this.empty3 = empty3;
	}
	
	/**
	 * Column Info
	 * @param ttlLf1
	 */
	public void setTtlLf1(String ttlLf1) {
		this.ttlLf1 = ttlLf1;
	}
	
	/**
	 * Column Info
	 * @param vvd8
	 */
	public void setVvd8(String vvd8) {
		this.vvd8 = vvd8;
	}
	
	/**
	 * Column Info
	 * @param empty4
	 */
	public void setEmpty4(String empty4) {
		this.empty4 = empty4;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad5
	 */
	public void setTtlLoad5(String ttlLoad5) {
		this.ttlLoad5 = ttlLoad5;
	}
	
	/**
	 * Column Info
	 * @param empty5
	 */
	public void setEmpty5(String empty5) {
		this.empty5 = empty5;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad4
	 */
	public void setTtlLoad4(String ttlLoad4) {
		this.ttlLoad4 = ttlLoad4;
	}
	
	/**
	 * Column Info
	 * @param empty6
	 */
	public void setEmpty6(String empty6) {
		this.empty6 = empty6;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad3
	 */
	public void setTtlLoad3(String ttlLoad3) {
		this.ttlLoad3 = ttlLoad3;
	}
	
	/**
	 * Column Info
	 * @param empty7
	 */
	public void setEmpty7(String empty7) {
		this.empty7 = empty7;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad2
	 */
	public void setTtlLoad2(String ttlLoad2) {
		this.ttlLoad2 = ttlLoad2;
	}
	
	/**
	 * Column Info
	 * @param empty8
	 */
	public void setEmpty8(String empty8) {
		this.empty8 = empty8;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad9
	 */
	public void setTtlLoad9(String ttlLoad9) {
		this.ttlLoad9 = ttlLoad9;
	}
	
	/**
	 * Column Info
	 * @param empty9
	 */
	public void setEmpty9(String empty9) {
		this.empty9 = empty9;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad8
	 */
	public void setTtlLoad8(String ttlLoad8) {
		this.ttlLoad8 = ttlLoad8;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad7
	 */
	public void setTtlLoad7(String ttlLoad7) {
		this.ttlLoad7 = ttlLoad7;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad6
	 */
	public void setTtlLoad6(String ttlLoad6) {
		this.ttlLoad6 = ttlLoad6;
	}
	
	/**
	 * Column Info
	 * @param full2
	 */
	public void setFull2(String full2) {
		this.full2 = full2;
	}
	
	/**
	 * Column Info
	 * @param full1
	 */
	public void setFull1(String full1) {
		this.full1 = full1;
	}
	
	/**
	 * Column Info
	 * @param tFullLf
	 */
	public void setTFullLf(String tFullLf) {
		this.tFullLf = tFullLf;
	}
	
	/**
	 * Column Info
	 * @param full6
	 */
	public void setFull6(String full6) {
		this.full6 = full6;
	}
	
	/**
	 * Column Info
	 * @param full5
	 */
	public void setFull5(String full5) {
		this.full5 = full5;
	}
	
	/**
	 * Column Info
	 * @param full4
	 */
	public void setFull4(String full4) {
		this.full4 = full4;
	}
	
	/**
	 * Column Info
	 * @param full3
	 */
	public void setFull3(String full3) {
		this.full3 = full3;
	}
	
	/**
	 * Column Info
	 * @param full9
	 */
	public void setFull9(String full9) {
		this.full9 = full9;
	}
	
	/**
	 * Column Info
	 * @param full8
	 */
	public void setFull8(String full8) {
		this.full8 = full8;
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
	 * @param full7
	 */
	public void setFull7(String full7) {
		this.full7 = full7;
	}
	
	/**
	 * Column Info
	 * @param bsa10
	 */
	public void setBsa10(String bsa10) {
		this.bsa10 = bsa10;
	}
	
	/**
	 * Column Info
	 * @param tLoad
	 */
	public void setTLoad(String tLoad) {
		this.tLoad = tLoad;
	}
	
	/**
	 * Column Info
	 * @param t
	 */
	public void setT(String t) {
		this.t = t;
	}
	
	/**
	 * Column Info
	 * @param bsa14
	 */
	public void setBsa14(String bsa14) {
		this.bsa14 = bsa14;
	}
	
	/**
	 * Column Info
	 * @param bsa13
	 */
	public void setBsa13(String bsa13) {
		this.bsa13 = bsa13;
	}
	
	/**
	 * Column Info
	 * @param bsa12
	 */
	public void setBsa12(String bsa12) {
		this.bsa12 = bsa12;
	}
	
	/**
	 * Column Info
	 * @param bsa11
	 */
	public void setBsa11(String bsa11) {
		this.bsa11 = bsa11;
	}
	
	/**
	 * Column Info
	 * @param bsa15
	 */
	public void setBsa15(String bsa15) {
		this.bsa15 = bsa15;
	}
	
	/**
	 * Column Info
	 * @param fullLf12
	 */
	public void setFullLf12(String fullLf12) {
		this.fullLf12 = fullLf12;
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
	 * @param fullLf13
	 */
	public void setFullLf13(String fullLf13) {
		this.fullLf13 = fullLf13;
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
	 * @param fullLf10
	 */
	public void setFullLf10(String fullLf10) {
		this.fullLf10 = fullLf10;
	}
	
	/**
	 * Column Info
	 * @param fullLf11
	 */
	public void setFullLf11(String fullLf11) {
		this.fullLf11 = fullLf11;
	}
	
	/**
	 * Column Info
	 * @param fullLf14
	 */
	public void setFullLf14(String fullLf14) {
		this.fullLf14 = fullLf14;
	}
	
	/**
	 * Column Info
	 * @param fullLf15
	 */
	public void setFullLf15(String fullLf15) {
		this.fullLf15 = fullLf15;
	}
	
	/**
	 * Column Info
	 * @param full12
	 */
	public void setFull12(String full12) {
		this.full12 = full12;
	}
	
	/**
	 * Column Info
	 * @param full13
	 */
	public void setFull13(String full13) {
		this.full13 = full13;
	}
	
	/**
	 * Column Info
	 * @param full14
	 */
	public void setFull14(String full14) {
		this.full14 = full14;
	}
	
	/**
	 * Column Info
	 * @param full15
	 */
	public void setFull15(String full15) {
		this.full15 = full15;
	}
	
	/**
	 * Column Info
	 * @param full11
	 */
	public void setFull11(String full11) {
		this.full11 = full11;
	}
	
	/**
	 * Column Info
	 * @param full10
	 */
	public void setFull10(String full10) {
		this.full10 = full10;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fullLf1
	 */
	public void setFullLf1(String fullLf1) {
		this.fullLf1 = fullLf1;
	}
	
	/**
	 * Column Info
	 * @param fullLf2
	 */
	public void setFullLf2(String fullLf2) {
		this.fullLf2 = fullLf2;
	}
	
	/**
	 * Column Info
	 * @param ttlLoad1
	 */
	public void setTtlLoad1(String ttlLoad1) {
		this.ttlLoad1 = ttlLoad1;
	}
	
	/**
	 * Column Info
	 * @param fullLf3
	 */
	public void setFullLf3(String fullLf3) {
		this.fullLf3 = fullLf3;
	}
	
	/**
	 * Column Info
	 * @param fullLf4
	 */
	public void setFullLf4(String fullLf4) {
		this.fullLf4 = fullLf4;
	}
	
	/**
	 * Column Info
	 * @param fullLf5
	 */
	public void setFullLf5(String fullLf5) {
		this.fullLf5 = fullLf5;
	}
	
	/**
	 * Column Info
	 * @param fullLf6
	 */
	public void setFullLf6(String fullLf6) {
		this.fullLf6 = fullLf6;
	}
	
	/**
	 * Column Info
	 * @param fullLf7
	 */
	public void setFullLf7(String fullLf7) {
		this.fullLf7 = fullLf7;
	}
	
	/**
	 * Column Info
	 * @param fullLf8
	 */
	public void setFullLf8(String fullLf8) {
		this.fullLf8 = fullLf8;
	}
	
	/**
	 * Column Info
	 * @param fullLf9
	 */
	public void setFullLf9(String fullLf9) {
		this.fullLf9 = fullLf9;
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
	 * @param bsa9
	 */
	public void setBsa9(String bsa9) {
		this.bsa9 = bsa9;
	}
	
	/**
	 * Column Info
	 * @param bsa8
	 */
	public void setBsa8(String bsa8) {
		this.bsa8 = bsa8;
	}
	
	/**
	 * Column Info
	 * @param bsa5
	 */
	public void setBsa5(String bsa5) {
		this.bsa5 = bsa5;
	}
	
	/**
	 * Column Info
	 * @param bsa4
	 */
	public void setBsa4(String bsa4) {
		this.bsa4 = bsa4;
	}
	
	/**
	 * Column Info
	 * @param bsa7
	 */
	public void setBsa7(String bsa7) {
		this.bsa7 = bsa7;
	}
	
	/**
	 * Column Info
	 * @param bsa6
	 */
	public void setBsa6(String bsa6) {
		this.bsa6 = bsa6;
	}
	
	/**
	 * Column Info
	 * @param bsa1
	 */
	public void setBsa1(String bsa1) {
		this.bsa1 = bsa1;
	}
	
	/**
	 * Column Info
	 * @param bsa3
	 */
	public void setBsa3(String bsa3) {
		this.bsa3 = bsa3;
	}
	
	/**
	 * Column Info
	 * @param bsa2
	 */
	public void setBsa2(String bsa2) {
		this.bsa2 = bsa2;
	}
	
	/**
	 * Column Info
	 * @param empty14
	 */
	public void setEmpty14(String empty14) {
		this.empty14 = empty14;
	}
	
	/**
	 * Column Info
	 * @param tBsa
	 */
	public void setTBsa(String tBsa) {
		this.tBsa = tBsa;
	}
	
	/**
	 * Column Info
	 * @param empty15
	 */
	public void setEmpty15(String empty15) {
		this.empty15 = empty15;
	}
	
	/**
	 * Column Info
	 * @param ttlLf15
	 */
	public void setTtlLf15(String ttlLf15) {
		this.ttlLf15 = ttlLf15;
	}
	
	/**
	 * Column Info
	 * @param ttlLf14
	 */
	public void setTtlLf14(String ttlLf14) {
		this.ttlLf14 = ttlLf14;
	}
	
	/**
	 * Column Info
	 * @param ttlLf13
	 */
	public void setTtlLf13(String ttlLf13) {
		this.ttlLf13 = ttlLf13;
	}
	
	/**
	 * Column Info
	 * @param tTtlLf
	 */
	public void setTTtlLf(String tTtlLf) {
		this.tTtlLf = tTtlLf;
	}
	
	/**
	 * Column Info
	 * @param ttlLf12
	 */
	public void setTtlLf12(String ttlLf12) {
		this.ttlLf12 = ttlLf12;
	}
	
	/**
	 * Column Info
	 * @param ttlLf11
	 */
	public void setTtlLf11(String ttlLf11) {
		this.ttlLf11 = ttlLf11;
	}
	
	/**
	 * Column Info
	 * @param ttlLf10
	 */
	public void setTtlLf10(String ttlLf10) {
		this.ttlLf10 = ttlLf10;
	}
	
	/**
	 * Column Info
	 * @param tFull
	 */
	public void setTFull(String tFull) {
		this.tFull = tFull;
	}
	
	/**
	 * Column Info
	 * @param empty13
	 */
	public void setEmpty13(String empty13) {
		this.empty13 = empty13;
	}
	
	/**
	 * Column Info
	 * @param empty12
	 */
	public void setEmpty12(String empty12) {
		this.empty12 = empty12;
	}
	
	/**
	 * Column Info
	 * @param empty11
	 */
	public void setEmpty11(String empty11) {
		this.empty11 = empty11;
	}
	
	/**
	 * Column Info
	 * @param empty10
	 */
	public void setEmpty10(String empty10) {
		this.empty10 = empty10;
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
		setTEmpty(JSPUtil.getParameter(request, prefix + "t_empty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlLoad14(JSPUtil.getParameter(request, prefix + "ttl_load14", ""));
		setTtlLoad13(JSPUtil.getParameter(request, prefix + "ttl_load13", ""));
		setTtlLoad15(JSPUtil.getParameter(request, prefix + "ttl_load15", ""));
		setVvd10(JSPUtil.getParameter(request, prefix + "vvd10", ""));
		setTtlLoad10(JSPUtil.getParameter(request, prefix + "ttl_load10", ""));
		setVvd11(JSPUtil.getParameter(request, prefix + "vvd11", ""));
		setVvd12(JSPUtil.getParameter(request, prefix + "vvd12", ""));
		setTtlLoad12(JSPUtil.getParameter(request, prefix + "ttl_load12", ""));
		setVvd13(JSPUtil.getParameter(request, prefix + "vvd13", ""));
		setTtlLoad11(JSPUtil.getParameter(request, prefix + "ttl_load11", ""));
		setVvd14(JSPUtil.getParameter(request, prefix + "vvd14", ""));
		setVvd15(JSPUtil.getParameter(request, prefix + "vvd15", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setTtlLf6(JSPUtil.getParameter(request, prefix + "ttl_lf6", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setTtlLf7(JSPUtil.getParameter(request, prefix + "ttl_lf7", ""));
		setTtlLf8(JSPUtil.getParameter(request, prefix + "ttl_lf8", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setTtlLf9(JSPUtil.getParameter(request, prefix + "ttl_lf9", ""));
		setVvd7(JSPUtil.getParameter(request, prefix + "vvd7", ""));
		setTtlLf3(JSPUtil.getParameter(request, prefix + "ttl_lf3", ""));
		setVvd6(JSPUtil.getParameter(request, prefix + "vvd6", ""));
		setTtlLf2(JSPUtil.getParameter(request, prefix + "ttl_lf2", ""));
		setVvd5(JSPUtil.getParameter(request, prefix + "vvd5", ""));
		setTtlLf5(JSPUtil.getParameter(request, prefix + "ttl_lf5", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setTtlLf4(JSPUtil.getParameter(request, prefix + "ttl_lf4", ""));
		setEmpty1(JSPUtil.getParameter(request, prefix + "empty1", ""));
		setEmpty2(JSPUtil.getParameter(request, prefix + "empty2", ""));
		setVvd9(JSPUtil.getParameter(request, prefix + "vvd9", ""));
		setEmpty3(JSPUtil.getParameter(request, prefix + "empty3", ""));
		setTtlLf1(JSPUtil.getParameter(request, prefix + "ttl_lf1", ""));
		setVvd8(JSPUtil.getParameter(request, prefix + "vvd8", ""));
		setEmpty4(JSPUtil.getParameter(request, prefix + "empty4", ""));
		setTtlLoad5(JSPUtil.getParameter(request, prefix + "ttl_load5", ""));
		setEmpty5(JSPUtil.getParameter(request, prefix + "empty5", ""));
		setTtlLoad4(JSPUtil.getParameter(request, prefix + "ttl_load4", ""));
		setEmpty6(JSPUtil.getParameter(request, prefix + "empty6", ""));
		setTtlLoad3(JSPUtil.getParameter(request, prefix + "ttl_load3", ""));
		setEmpty7(JSPUtil.getParameter(request, prefix + "empty7", ""));
		setTtlLoad2(JSPUtil.getParameter(request, prefix + "ttl_load2", ""));
		setEmpty8(JSPUtil.getParameter(request, prefix + "empty8", ""));
		setTtlLoad9(JSPUtil.getParameter(request, prefix + "ttl_load9", ""));
		setEmpty9(JSPUtil.getParameter(request, prefix + "empty9", ""));
		setTtlLoad8(JSPUtil.getParameter(request, prefix + "ttl_load8", ""));
		setTtlLoad7(JSPUtil.getParameter(request, prefix + "ttl_load7", ""));
		setTtlLoad6(JSPUtil.getParameter(request, prefix + "ttl_load6", ""));
		setFull2(JSPUtil.getParameter(request, prefix + "full2", ""));
		setFull1(JSPUtil.getParameter(request, prefix + "full1", ""));
		setTFullLf(JSPUtil.getParameter(request, prefix + "t_full_lf", ""));
		setFull6(JSPUtil.getParameter(request, prefix + "full6", ""));
		setFull5(JSPUtil.getParameter(request, prefix + "full5", ""));
		setFull4(JSPUtil.getParameter(request, prefix + "full4", ""));
		setFull3(JSPUtil.getParameter(request, prefix + "full3", ""));
		setFull9(JSPUtil.getParameter(request, prefix + "full9", ""));
		setFull8(JSPUtil.getParameter(request, prefix + "full8", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setFull7(JSPUtil.getParameter(request, prefix + "full7", ""));
		setBsa10(JSPUtil.getParameter(request, prefix + "bsa10", ""));
		setTLoad(JSPUtil.getParameter(request, prefix + "t_load", ""));
		setT(JSPUtil.getParameter(request, prefix + "t", ""));
		setBsa14(JSPUtil.getParameter(request, prefix + "bsa14", ""));
		setBsa13(JSPUtil.getParameter(request, prefix + "bsa13", ""));
		setBsa12(JSPUtil.getParameter(request, prefix + "bsa12", ""));
		setBsa11(JSPUtil.getParameter(request, prefix + "bsa11", ""));
		setBsa15(JSPUtil.getParameter(request, prefix + "bsa15", ""));
		setFullLf12(JSPUtil.getParameter(request, prefix + "full_lf12", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFullLf13(JSPUtil.getParameter(request, prefix + "full_lf13", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFullLf10(JSPUtil.getParameter(request, prefix + "full_lf10", ""));
		setFullLf11(JSPUtil.getParameter(request, prefix + "full_lf11", ""));
		setFullLf14(JSPUtil.getParameter(request, prefix + "full_lf14", ""));
		setFullLf15(JSPUtil.getParameter(request, prefix + "full_lf15", ""));
		setFull12(JSPUtil.getParameter(request, prefix + "full12", ""));
		setFull13(JSPUtil.getParameter(request, prefix + "full13", ""));
		setFull14(JSPUtil.getParameter(request, prefix + "full14", ""));
		setFull15(JSPUtil.getParameter(request, prefix + "full15", ""));
		setFull11(JSPUtil.getParameter(request, prefix + "full11", ""));
		setFull10(JSPUtil.getParameter(request, prefix + "full10", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFullLf1(JSPUtil.getParameter(request, prefix + "full_lf1", ""));
		setFullLf2(JSPUtil.getParameter(request, prefix + "full_lf2", ""));
		setTtlLoad1(JSPUtil.getParameter(request, prefix + "ttl_load1", ""));
		setFullLf3(JSPUtil.getParameter(request, prefix + "full_lf3", ""));
		setFullLf4(JSPUtil.getParameter(request, prefix + "full_lf4", ""));
		setFullLf5(JSPUtil.getParameter(request, prefix + "full_lf5", ""));
		setFullLf6(JSPUtil.getParameter(request, prefix + "full_lf6", ""));
		setFullLf7(JSPUtil.getParameter(request, prefix + "full_lf7", ""));
		setFullLf8(JSPUtil.getParameter(request, prefix + "full_lf8", ""));
		setFullLf9(JSPUtil.getParameter(request, prefix + "full_lf9", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBsa9(JSPUtil.getParameter(request, prefix + "bsa9", ""));
		setBsa8(JSPUtil.getParameter(request, prefix + "bsa8", ""));
		setBsa5(JSPUtil.getParameter(request, prefix + "bsa5", ""));
		setBsa4(JSPUtil.getParameter(request, prefix + "bsa4", ""));
		setBsa7(JSPUtil.getParameter(request, prefix + "bsa7", ""));
		setBsa6(JSPUtil.getParameter(request, prefix + "bsa6", ""));
		setBsa1(JSPUtil.getParameter(request, prefix + "bsa1", ""));
		setBsa3(JSPUtil.getParameter(request, prefix + "bsa3", ""));
		setBsa2(JSPUtil.getParameter(request, prefix + "bsa2", ""));
		setEmpty14(JSPUtil.getParameter(request, prefix + "empty14", ""));
		setTBsa(JSPUtil.getParameter(request, prefix + "t_bsa", ""));
		setEmpty15(JSPUtil.getParameter(request, prefix + "empty15", ""));
		setTtlLf15(JSPUtil.getParameter(request, prefix + "ttl_lf15", ""));
		setTtlLf14(JSPUtil.getParameter(request, prefix + "ttl_lf14", ""));
		setTtlLf13(JSPUtil.getParameter(request, prefix + "ttl_lf13", ""));
		setTTtlLf(JSPUtil.getParameter(request, prefix + "t_ttl_lf", ""));
		setTtlLf12(JSPUtil.getParameter(request, prefix + "ttl_lf12", ""));
		setTtlLf11(JSPUtil.getParameter(request, prefix + "ttl_lf11", ""));
		setTtlLf10(JSPUtil.getParameter(request, prefix + "ttl_lf10", ""));
		setTFull(JSPUtil.getParameter(request, prefix + "t_full", ""));
		setEmpty13(JSPUtil.getParameter(request, prefix + "empty13", ""));
		setEmpty12(JSPUtil.getParameter(request, prefix + "empty12", ""));
		setEmpty11(JSPUtil.getParameter(request, prefix + "empty11", ""));
		setEmpty10(JSPUtil.getParameter(request, prefix + "empty10", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlLFSummaryListVO[]
	 */
	public SearchSpaceControlLFSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlLFSummaryListVO[]
	 */
	public SearchSpaceControlLFSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlLFSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tEmpty = (JSPUtil.getParameter(request, prefix	+ "t_empty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlLoad14 = (JSPUtil.getParameter(request, prefix	+ "ttl_load14", length));
			String[] ttlLoad13 = (JSPUtil.getParameter(request, prefix	+ "ttl_load13", length));
			String[] ttlLoad15 = (JSPUtil.getParameter(request, prefix	+ "ttl_load15", length));
			String[] vvd10 = (JSPUtil.getParameter(request, prefix	+ "vvd10", length));
			String[] ttlLoad10 = (JSPUtil.getParameter(request, prefix	+ "ttl_load10", length));
			String[] vvd11 = (JSPUtil.getParameter(request, prefix	+ "vvd11", length));
			String[] vvd12 = (JSPUtil.getParameter(request, prefix	+ "vvd12", length));
			String[] ttlLoad12 = (JSPUtil.getParameter(request, prefix	+ "ttl_load12", length));
			String[] vvd13 = (JSPUtil.getParameter(request, prefix	+ "vvd13", length));
			String[] ttlLoad11 = (JSPUtil.getParameter(request, prefix	+ "ttl_load11", length));
			String[] vvd14 = (JSPUtil.getParameter(request, prefix	+ "vvd14", length));
			String[] vvd15 = (JSPUtil.getParameter(request, prefix	+ "vvd15", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] ttlLf6 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf6", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] ttlLf7 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf7", length));
			String[] ttlLf8 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf8", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] ttlLf9 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf9", length));
			String[] vvd7 = (JSPUtil.getParameter(request, prefix	+ "vvd7", length));
			String[] ttlLf3 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf3", length));
			String[] vvd6 = (JSPUtil.getParameter(request, prefix	+ "vvd6", length));
			String[] ttlLf2 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf2", length));
			String[] vvd5 = (JSPUtil.getParameter(request, prefix	+ "vvd5", length));
			String[] ttlLf5 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf5", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] ttlLf4 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf4", length));
			String[] empty1 = (JSPUtil.getParameter(request, prefix	+ "empty1", length));
			String[] empty2 = (JSPUtil.getParameter(request, prefix	+ "empty2", length));
			String[] vvd9 = (JSPUtil.getParameter(request, prefix	+ "vvd9", length));
			String[] empty3 = (JSPUtil.getParameter(request, prefix	+ "empty3", length));
			String[] ttlLf1 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf1", length));
			String[] vvd8 = (JSPUtil.getParameter(request, prefix	+ "vvd8", length));
			String[] empty4 = (JSPUtil.getParameter(request, prefix	+ "empty4", length));
			String[] ttlLoad5 = (JSPUtil.getParameter(request, prefix	+ "ttl_load5", length));
			String[] empty5 = (JSPUtil.getParameter(request, prefix	+ "empty5", length));
			String[] ttlLoad4 = (JSPUtil.getParameter(request, prefix	+ "ttl_load4", length));
			String[] empty6 = (JSPUtil.getParameter(request, prefix	+ "empty6", length));
			String[] ttlLoad3 = (JSPUtil.getParameter(request, prefix	+ "ttl_load3", length));
			String[] empty7 = (JSPUtil.getParameter(request, prefix	+ "empty7", length));
			String[] ttlLoad2 = (JSPUtil.getParameter(request, prefix	+ "ttl_load2", length));
			String[] empty8 = (JSPUtil.getParameter(request, prefix	+ "empty8", length));
			String[] ttlLoad9 = (JSPUtil.getParameter(request, prefix	+ "ttl_load9", length));
			String[] empty9 = (JSPUtil.getParameter(request, prefix	+ "empty9", length));
			String[] ttlLoad8 = (JSPUtil.getParameter(request, prefix	+ "ttl_load8", length));
			String[] ttlLoad7 = (JSPUtil.getParameter(request, prefix	+ "ttl_load7", length));
			String[] ttlLoad6 = (JSPUtil.getParameter(request, prefix	+ "ttl_load6", length));
			String[] full2 = (JSPUtil.getParameter(request, prefix	+ "full2", length));
			String[] full1 = (JSPUtil.getParameter(request, prefix	+ "full1", length));
			String[] tFullLf = (JSPUtil.getParameter(request, prefix	+ "t_full_lf", length));
			String[] full6 = (JSPUtil.getParameter(request, prefix	+ "full6", length));
			String[] full5 = (JSPUtil.getParameter(request, prefix	+ "full5", length));
			String[] full4 = (JSPUtil.getParameter(request, prefix	+ "full4", length));
			String[] full3 = (JSPUtil.getParameter(request, prefix	+ "full3", length));
			String[] full9 = (JSPUtil.getParameter(request, prefix	+ "full9", length));
			String[] full8 = (JSPUtil.getParameter(request, prefix	+ "full8", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] full7 = (JSPUtil.getParameter(request, prefix	+ "full7", length));
			String[] bsa10 = (JSPUtil.getParameter(request, prefix	+ "bsa10", length));
			String[] tLoad = (JSPUtil.getParameter(request, prefix	+ "t_load", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			String[] bsa14 = (JSPUtil.getParameter(request, prefix	+ "bsa14", length));
			String[] bsa13 = (JSPUtil.getParameter(request, prefix	+ "bsa13", length));
			String[] bsa12 = (JSPUtil.getParameter(request, prefix	+ "bsa12", length));
			String[] bsa11 = (JSPUtil.getParameter(request, prefix	+ "bsa11", length));
			String[] bsa15 = (JSPUtil.getParameter(request, prefix	+ "bsa15", length));
			String[] fullLf12 = (JSPUtil.getParameter(request, prefix	+ "full_lf12", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fullLf13 = (JSPUtil.getParameter(request, prefix	+ "full_lf13", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fullLf10 = (JSPUtil.getParameter(request, prefix	+ "full_lf10", length));
			String[] fullLf11 = (JSPUtil.getParameter(request, prefix	+ "full_lf11", length));
			String[] fullLf14 = (JSPUtil.getParameter(request, prefix	+ "full_lf14", length));
			String[] fullLf15 = (JSPUtil.getParameter(request, prefix	+ "full_lf15", length));
			String[] full12 = (JSPUtil.getParameter(request, prefix	+ "full12", length));
			String[] full13 = (JSPUtil.getParameter(request, prefix	+ "full13", length));
			String[] full14 = (JSPUtil.getParameter(request, prefix	+ "full14", length));
			String[] full15 = (JSPUtil.getParameter(request, prefix	+ "full15", length));
			String[] full11 = (JSPUtil.getParameter(request, prefix	+ "full11", length));
			String[] full10 = (JSPUtil.getParameter(request, prefix	+ "full10", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fullLf1 = (JSPUtil.getParameter(request, prefix	+ "full_lf1", length));
			String[] fullLf2 = (JSPUtil.getParameter(request, prefix	+ "full_lf2", length));
			String[] ttlLoad1 = (JSPUtil.getParameter(request, prefix	+ "ttl_load1", length));
			String[] fullLf3 = (JSPUtil.getParameter(request, prefix	+ "full_lf3", length));
			String[] fullLf4 = (JSPUtil.getParameter(request, prefix	+ "full_lf4", length));
			String[] fullLf5 = (JSPUtil.getParameter(request, prefix	+ "full_lf5", length));
			String[] fullLf6 = (JSPUtil.getParameter(request, prefix	+ "full_lf6", length));
			String[] fullLf7 = (JSPUtil.getParameter(request, prefix	+ "full_lf7", length));
			String[] fullLf8 = (JSPUtil.getParameter(request, prefix	+ "full_lf8", length));
			String[] fullLf9 = (JSPUtil.getParameter(request, prefix	+ "full_lf9", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa9 = (JSPUtil.getParameter(request, prefix	+ "bsa9", length));
			String[] bsa8 = (JSPUtil.getParameter(request, prefix	+ "bsa8", length));
			String[] bsa5 = (JSPUtil.getParameter(request, prefix	+ "bsa5", length));
			String[] bsa4 = (JSPUtil.getParameter(request, prefix	+ "bsa4", length));
			String[] bsa7 = (JSPUtil.getParameter(request, prefix	+ "bsa7", length));
			String[] bsa6 = (JSPUtil.getParameter(request, prefix	+ "bsa6", length));
			String[] bsa1 = (JSPUtil.getParameter(request, prefix	+ "bsa1", length));
			String[] bsa3 = (JSPUtil.getParameter(request, prefix	+ "bsa3", length));
			String[] bsa2 = (JSPUtil.getParameter(request, prefix	+ "bsa2", length));
			String[] empty14 = (JSPUtil.getParameter(request, prefix	+ "empty14", length));
			String[] tBsa = (JSPUtil.getParameter(request, prefix	+ "t_bsa", length));
			String[] empty15 = (JSPUtil.getParameter(request, prefix	+ "empty15", length));
			String[] ttlLf15 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf15", length));
			String[] ttlLf14 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf14", length));
			String[] ttlLf13 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf13", length));
			String[] tTtlLf = (JSPUtil.getParameter(request, prefix	+ "t_ttl_lf", length));
			String[] ttlLf12 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf12", length));
			String[] ttlLf11 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf11", length));
			String[] ttlLf10 = (JSPUtil.getParameter(request, prefix	+ "ttl_lf10", length));
			String[] tFull = (JSPUtil.getParameter(request, prefix	+ "t_full", length));
			String[] empty13 = (JSPUtil.getParameter(request, prefix	+ "empty13", length));
			String[] empty12 = (JSPUtil.getParameter(request, prefix	+ "empty12", length));
			String[] empty11 = (JSPUtil.getParameter(request, prefix	+ "empty11", length));
			String[] empty10 = (JSPUtil.getParameter(request, prefix	+ "empty10", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlLFSummaryListVO();
				if (tEmpty[i] != null)
					model.setTEmpty(tEmpty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlLoad14[i] != null)
					model.setTtlLoad14(ttlLoad14[i]);
				if (ttlLoad13[i] != null)
					model.setTtlLoad13(ttlLoad13[i]);
				if (ttlLoad15[i] != null)
					model.setTtlLoad15(ttlLoad15[i]);
				if (vvd10[i] != null)
					model.setVvd10(vvd10[i]);
				if (ttlLoad10[i] != null)
					model.setTtlLoad10(ttlLoad10[i]);
				if (vvd11[i] != null)
					model.setVvd11(vvd11[i]);
				if (vvd12[i] != null)
					model.setVvd12(vvd12[i]);
				if (ttlLoad12[i] != null)
					model.setTtlLoad12(ttlLoad12[i]);
				if (vvd13[i] != null)
					model.setVvd13(vvd13[i]);
				if (ttlLoad11[i] != null)
					model.setTtlLoad11(ttlLoad11[i]);
				if (vvd14[i] != null)
					model.setVvd14(vvd14[i]);
				if (vvd15[i] != null)
					model.setVvd15(vvd15[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (ttlLf6[i] != null)
					model.setTtlLf6(ttlLf6[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (ttlLf7[i] != null)
					model.setTtlLf7(ttlLf7[i]);
				if (ttlLf8[i] != null)
					model.setTtlLf8(ttlLf8[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (ttlLf9[i] != null)
					model.setTtlLf9(ttlLf9[i]);
				if (vvd7[i] != null)
					model.setVvd7(vvd7[i]);
				if (ttlLf3[i] != null)
					model.setTtlLf3(ttlLf3[i]);
				if (vvd6[i] != null)
					model.setVvd6(vvd6[i]);
				if (ttlLf2[i] != null)
					model.setTtlLf2(ttlLf2[i]);
				if (vvd5[i] != null)
					model.setVvd5(vvd5[i]);
				if (ttlLf5[i] != null)
					model.setTtlLf5(ttlLf5[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (ttlLf4[i] != null)
					model.setTtlLf4(ttlLf4[i]);
				if (empty1[i] != null)
					model.setEmpty1(empty1[i]);
				if (empty2[i] != null)
					model.setEmpty2(empty2[i]);
				if (vvd9[i] != null)
					model.setVvd9(vvd9[i]);
				if (empty3[i] != null)
					model.setEmpty3(empty3[i]);
				if (ttlLf1[i] != null)
					model.setTtlLf1(ttlLf1[i]);
				if (vvd8[i] != null)
					model.setVvd8(vvd8[i]);
				if (empty4[i] != null)
					model.setEmpty4(empty4[i]);
				if (ttlLoad5[i] != null)
					model.setTtlLoad5(ttlLoad5[i]);
				if (empty5[i] != null)
					model.setEmpty5(empty5[i]);
				if (ttlLoad4[i] != null)
					model.setTtlLoad4(ttlLoad4[i]);
				if (empty6[i] != null)
					model.setEmpty6(empty6[i]);
				if (ttlLoad3[i] != null)
					model.setTtlLoad3(ttlLoad3[i]);
				if (empty7[i] != null)
					model.setEmpty7(empty7[i]);
				if (ttlLoad2[i] != null)
					model.setTtlLoad2(ttlLoad2[i]);
				if (empty8[i] != null)
					model.setEmpty8(empty8[i]);
				if (ttlLoad9[i] != null)
					model.setTtlLoad9(ttlLoad9[i]);
				if (empty9[i] != null)
					model.setEmpty9(empty9[i]);
				if (ttlLoad8[i] != null)
					model.setTtlLoad8(ttlLoad8[i]);
				if (ttlLoad7[i] != null)
					model.setTtlLoad7(ttlLoad7[i]);
				if (ttlLoad6[i] != null)
					model.setTtlLoad6(ttlLoad6[i]);
				if (full2[i] != null)
					model.setFull2(full2[i]);
				if (full1[i] != null)
					model.setFull1(full1[i]);
				if (tFullLf[i] != null)
					model.setTFullLf(tFullLf[i]);
				if (full6[i] != null)
					model.setFull6(full6[i]);
				if (full5[i] != null)
					model.setFull5(full5[i]);
				if (full4[i] != null)
					model.setFull4(full4[i]);
				if (full3[i] != null)
					model.setFull3(full3[i]);
				if (full9[i] != null)
					model.setFull9(full9[i]);
				if (full8[i] != null)
					model.setFull8(full8[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (full7[i] != null)
					model.setFull7(full7[i]);
				if (bsa10[i] != null)
					model.setBsa10(bsa10[i]);
				if (tLoad[i] != null)
					model.setTLoad(tLoad[i]);
				if (t[i] != null)
					model.setT(t[i]);
				if (bsa14[i] != null)
					model.setBsa14(bsa14[i]);
				if (bsa13[i] != null)
					model.setBsa13(bsa13[i]);
				if (bsa12[i] != null)
					model.setBsa12(bsa12[i]);
				if (bsa11[i] != null)
					model.setBsa11(bsa11[i]);
				if (bsa15[i] != null)
					model.setBsa15(bsa15[i]);
				if (fullLf12[i] != null)
					model.setFullLf12(fullLf12[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fullLf13[i] != null)
					model.setFullLf13(fullLf13[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fullLf10[i] != null)
					model.setFullLf10(fullLf10[i]);
				if (fullLf11[i] != null)
					model.setFullLf11(fullLf11[i]);
				if (fullLf14[i] != null)
					model.setFullLf14(fullLf14[i]);
				if (fullLf15[i] != null)
					model.setFullLf15(fullLf15[i]);
				if (full12[i] != null)
					model.setFull12(full12[i]);
				if (full13[i] != null)
					model.setFull13(full13[i]);
				if (full14[i] != null)
					model.setFull14(full14[i]);
				if (full15[i] != null)
					model.setFull15(full15[i]);
				if (full11[i] != null)
					model.setFull11(full11[i]);
				if (full10[i] != null)
					model.setFull10(full10[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fullLf1[i] != null)
					model.setFullLf1(fullLf1[i]);
				if (fullLf2[i] != null)
					model.setFullLf2(fullLf2[i]);
				if (ttlLoad1[i] != null)
					model.setTtlLoad1(ttlLoad1[i]);
				if (fullLf3[i] != null)
					model.setFullLf3(fullLf3[i]);
				if (fullLf4[i] != null)
					model.setFullLf4(fullLf4[i]);
				if (fullLf5[i] != null)
					model.setFullLf5(fullLf5[i]);
				if (fullLf6[i] != null)
					model.setFullLf6(fullLf6[i]);
				if (fullLf7[i] != null)
					model.setFullLf7(fullLf7[i]);
				if (fullLf8[i] != null)
					model.setFullLf8(fullLf8[i]);
				if (fullLf9[i] != null)
					model.setFullLf9(fullLf9[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa9[i] != null)
					model.setBsa9(bsa9[i]);
				if (bsa8[i] != null)
					model.setBsa8(bsa8[i]);
				if (bsa5[i] != null)
					model.setBsa5(bsa5[i]);
				if (bsa4[i] != null)
					model.setBsa4(bsa4[i]);
				if (bsa7[i] != null)
					model.setBsa7(bsa7[i]);
				if (bsa6[i] != null)
					model.setBsa6(bsa6[i]);
				if (bsa1[i] != null)
					model.setBsa1(bsa1[i]);
				if (bsa3[i] != null)
					model.setBsa3(bsa3[i]);
				if (bsa2[i] != null)
					model.setBsa2(bsa2[i]);
				if (empty14[i] != null)
					model.setEmpty14(empty14[i]);
				if (tBsa[i] != null)
					model.setTBsa(tBsa[i]);
				if (empty15[i] != null)
					model.setEmpty15(empty15[i]);
				if (ttlLf15[i] != null)
					model.setTtlLf15(ttlLf15[i]);
				if (ttlLf14[i] != null)
					model.setTtlLf14(ttlLf14[i]);
				if (ttlLf13[i] != null)
					model.setTtlLf13(ttlLf13[i]);
				if (tTtlLf[i] != null)
					model.setTTtlLf(tTtlLf[i]);
				if (ttlLf12[i] != null)
					model.setTtlLf12(ttlLf12[i]);
				if (ttlLf11[i] != null)
					model.setTtlLf11(ttlLf11[i]);
				if (ttlLf10[i] != null)
					model.setTtlLf10(ttlLf10[i]);
				if (tFull[i] != null)
					model.setTFull(tFull[i]);
				if (empty13[i] != null)
					model.setEmpty13(empty13[i]);
				if (empty12[i] != null)
					model.setEmpty12(empty12[i]);
				if (empty11[i] != null)
					model.setEmpty11(empty11[i]);
				if (empty10[i] != null)
					model.setEmpty10(empty10[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlLFSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlLFSummaryListVO[]
	 */
	public SearchSpaceControlLFSummaryListVO[] getSearchSpaceControlLFSummaryListVOs(){
		SearchSpaceControlLFSummaryListVO[] vos = (SearchSpaceControlLFSummaryListVO[])models.toArray(new SearchSpaceControlLFSummaryListVO[models.size()]);
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
		this.tEmpty = this.tEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad14 = this.ttlLoad14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad13 = this.ttlLoad13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad15 = this.ttlLoad15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd10 = this.vvd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad10 = this.ttlLoad10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd11 = this.vvd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd12 = this.vvd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad12 = this.ttlLoad12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd13 = this.vvd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad11 = this.ttlLoad11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd14 = this.vvd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd15 = this.vvd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf6 = this.ttlLf6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf7 = this.ttlLf7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf8 = this.ttlLf8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf9 = this.ttlLf9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd7 = this.vvd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf3 = this.ttlLf3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd6 = this.vvd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf2 = this.ttlLf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd5 = this.vvd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf5 = this.ttlLf5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf4 = this.ttlLf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty1 = this.empty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty2 = this.empty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd9 = this.vvd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty3 = this.empty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf1 = this.ttlLf1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd8 = this.vvd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty4 = this.empty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad5 = this.ttlLoad5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty5 = this.empty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad4 = this.ttlLoad4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty6 = this.empty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad3 = this.ttlLoad3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty7 = this.empty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad2 = this.ttlLoad2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty8 = this.empty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad9 = this.ttlLoad9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty9 = this.empty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad8 = this.ttlLoad8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad7 = this.ttlLoad7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad6 = this.ttlLoad6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full2 = this.full2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full1 = this.full1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFullLf = this.tFullLf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full6 = this.full6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full5 = this.full5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full4 = this.full4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full3 = this.full3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full9 = this.full9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full8 = this.full8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full7 = this.full7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa10 = this.bsa10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tLoad = this.tLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa14 = this.bsa14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa13 = this.bsa13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa12 = this.bsa12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa11 = this.bsa11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa15 = this.bsa15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf12 = this.fullLf12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf13 = this.fullLf13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf10 = this.fullLf10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf11 = this.fullLf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf14 = this.fullLf14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf15 = this.fullLf15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full12 = this.full12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full13 = this.full13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full14 = this.full14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full15 = this.full15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full11 = this.full11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full10 = this.full10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf1 = this.fullLf1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf2 = this.fullLf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoad1 = this.ttlLoad1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf3 = this.fullLf3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf4 = this.fullLf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf5 = this.fullLf5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf6 = this.fullLf6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf7 = this.fullLf7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf8 = this.fullLf8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLf9 = this.fullLf9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa9 = this.bsa9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa8 = this.bsa8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa5 = this.bsa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa4 = this.bsa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa7 = this.bsa7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa6 = this.bsa6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa1 = this.bsa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa3 = this.bsa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa2 = this.bsa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty14 = this.empty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBsa = this.tBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty15 = this.empty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf15 = this.ttlLf15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf14 = this.ttlLf14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf13 = this.ttlLf13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTtlLf = this.tTtlLf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf12 = this.ttlLf12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf11 = this.ttlLf11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLf10 = this.ttlLf10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFull = this.tFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty13 = this.empty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty12 = this.empty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty11 = this.empty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empty10 = this.empty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
