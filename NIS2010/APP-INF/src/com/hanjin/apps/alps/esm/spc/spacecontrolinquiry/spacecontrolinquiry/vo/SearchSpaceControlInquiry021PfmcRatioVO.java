/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSpaceControlInquiry021PfmcRatioVO.java
*@FileTitle : SearchSpaceControlInquiry021PfmcRatioVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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

public class SearchSpaceControlInquiry021PfmcRatioVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry021PfmcRatioVO> models = new ArrayList<SearchSpaceControlInquiry021PfmcRatioVO>();
	
	/* Column Info */
	private String bqta61 = null;
	/* Column Info */
	private String fqta61 = null;
	/* Column Info */
	private String fbsa61 = null;
	/* Column Info */
	private String bqta21 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fct61 = null;
	/* Column Info */
	private String fbsa11 = null;
	/* Column Info */
	private String fct11 = null;
	/* Column Info */
	private String bkg31 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bbsa31 = null;
	/* Column Info */
	private String qta31 = null;
	/* Column Info */
	private String bkg21 = null;
	/* Column Info */
	private String fqta21 = null;
	/* Column Info */
	private String bqta11 = null;
	/* Column Info */
	private String fqta51 = null;
	/* Column Info */
	private String bkg41 = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String bqta51 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String vvd6 = null;
	/* Column Info */
	private String bbsa21 = null;
	/* Column Info */
	private String vvd5 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String fqta11 = null;
	/* Column Info */
	private String qta61 = null;
	/* Column Info */
	private String qta21 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bbsa61 = null;
	/* Column Info */
	private String bkg11 = null;
	/* Column Info */
	private String bqta41 = null;
	/* Column Info */
	private String fbsa41 = null;
	/* Column Info */
	private String fct31 = null;
	/* Column Info */
	private String fct41 = null;
	/* Column Info */
	private String fbsa31 = null;
	/* Column Info */
	private String bkg51 = null;
	/* Column Info */
	private String port4 = null;
	/* Column Info */
	private String port3 = null;
	/* Column Info */
	private String qta51 = null;
	/* Column Info */
	private String port2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String port1 = null;
	/* Column Info */
	private String port6 = null;
	/* Column Info */
	private String port5 = null;
	/* Column Info */
	private String bbsa11 = null;
	/* Column Info */
	private String bsa5 = null;
	/* Column Info */
	private String fqta41 = null;
	/* Column Info */
	private String bsa4 = null;
	/* Column Info */
	private String bbsa51 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bsa6 = null;
	/* Column Info */
	private String qta11 = null;
	/* Column Info */
	private String bsa1 = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String bsa3 = null;
	/* Column Info */
	private String bsa2 = null;
	/* Column Info */
	private String bqta31 = null;
	/* Column Info */
	private String fbsa51 = null;
	/* Column Info */
	private String fct21 = null;
	/* Column Info */
	private String fbsa21 = null;
	/* Column Info */
	private String fct51 = null;
	/* Column Info */
	private String bkg61 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String qta41 = null;
	/* Column Info */
	private String bbsa41 = null;
	/* Column Info */
	private String fqta31 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String t = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiry021PfmcRatioVO() {}

	public SearchSpaceControlInquiry021PfmcRatioVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String aqCd, String ofcCd, String vvd1, String vvd2, String vvd3, String vvd4, String vvd5, String vvd6, String bsa1, String bsa2, String bsa3, String bsa4, String bsa5, String bsa6, String qta11, String qta21, String qta31, String qta41, String qta51, String qta61, String fct11, String fct21, String fct31, String fct41, String fct51, String fct61, String bkg11, String bkg21, String bkg31, String bkg41, String bkg51, String bkg61, String fqta11, String fqta21, String fqta31, String fqta41, String fqta51, String fqta61, String fbsa11, String fbsa21, String fbsa31, String fbsa41, String fbsa51, String fbsa61, String bqta11, String bqta21, String bqta31, String bqta41, String bqta51, String bqta61, String bbsa11, String bbsa21, String bbsa31, String bbsa41, String bbsa51, String bbsa61, String port1, String port2, String port3, String port4, String port5, String port6, String cnt, String rhqCd, String t) {
		this.bqta61 = bqta61;
		this.fqta61 = fqta61;
		this.fbsa61 = fbsa61;
		this.bqta21 = bqta21;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.fct61 = fct61;
		this.fbsa11 = fbsa11;
		this.fct11 = fct11;
		this.bkg31 = bkg31;
		this.pagerows = pagerows;
		this.bbsa31 = bbsa31;
		this.qta31 = qta31;
		this.bkg21 = bkg21;
		this.fqta21 = fqta21;
		this.bqta11 = bqta11;
		this.fqta51 = fqta51;
		this.bkg41 = bkg41;
		this.vvd2 = vvd2;
		this.bqta51 = bqta51;
		this.vvd3 = vvd3;
		this.vvd1 = vvd1;
		this.vvd6 = vvd6;
		this.bbsa21 = bbsa21;
		this.vvd5 = vvd5;
		this.vvd4 = vvd4;
		this.fqta11 = fqta11;
		this.qta61 = qta61;
		this.qta21 = qta21;
		this.subTrdCd = subTrdCd;
		this.bbsa61 = bbsa61;
		this.bkg11 = bkg11;
		this.bqta41 = bqta41;
		this.fbsa41 = fbsa41;
		this.fct31 = fct31;
		this.fct41 = fct41;
		this.fbsa31 = fbsa31;
		this.bkg51 = bkg51;
		this.port4 = port4;
		this.port3 = port3;
		this.qta51 = qta51;
		this.port2 = port2;
		this.ibflag = ibflag;
		this.port1 = port1;
		this.port6 = port6;
		this.port5 = port5;
		this.bbsa11 = bbsa11;
		this.bsa5 = bsa5;
		this.fqta41 = fqta41;
		this.bsa4 = bsa4;
		this.bbsa51 = bbsa51;
		this.dirCd = dirCd;
		this.bsa6 = bsa6;
		this.qta11 = qta11;
		this.bsa1 = bsa1;
		this.aqCd = aqCd;
		this.bsa3 = bsa3;
		this.bsa2 = bsa2;
		this.bqta31 = bqta31;
		this.fbsa51 = fbsa51;
		this.fct21 = fct21;
		this.fbsa21 = fbsa21;
		this.fct51 = fct51;
		this.bkg61 = bkg61;
		this.ofcCd = ofcCd;
		this.qta41 = qta41;
		this.bbsa41 = bbsa41;
		this.fqta31 = fqta31;
		this.rhqCd = rhqCd;
		this.t = t;
		this.cnt = cnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bqta61", getBqta61());
		this.hashColumns.put("fqta61", getFqta61());
		this.hashColumns.put("fbsa61", getFbsa61());
		this.hashColumns.put("bqta21", getBqta21());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("fct61", getFct61());
		this.hashColumns.put("fbsa11", getFbsa11());
		this.hashColumns.put("fct11", getFct11());
		this.hashColumns.put("bkg31", getBkg31());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bbsa31", getBbsa31());
		this.hashColumns.put("qta31", getQta31());
		this.hashColumns.put("bkg21", getBkg21());
		this.hashColumns.put("fqta21", getFqta21());
		this.hashColumns.put("bqta11", getBqta11());
		this.hashColumns.put("fqta51", getFqta51());
		this.hashColumns.put("bkg41", getBkg41());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("bqta51", getBqta51());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("vvd6", getVvd6());
		this.hashColumns.put("bbsa21", getBbsa21());
		this.hashColumns.put("vvd5", getVvd5());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("fqta11", getFqta11());
		this.hashColumns.put("qta61", getQta61());
		this.hashColumns.put("qta21", getQta21());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bbsa61", getBbsa61());
		this.hashColumns.put("bkg11", getBkg11());
		this.hashColumns.put("bqta41", getBqta41());
		this.hashColumns.put("fbsa41", getFbsa41());
		this.hashColumns.put("fct31", getFct31());
		this.hashColumns.put("fct41", getFct41());
		this.hashColumns.put("fbsa31", getFbsa31());
		this.hashColumns.put("bkg51", getBkg51());
		this.hashColumns.put("port4", getPort4());
		this.hashColumns.put("port3", getPort3());
		this.hashColumns.put("qta51", getQta51());
		this.hashColumns.put("port2", getPort2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port1", getPort1());
		this.hashColumns.put("port6", getPort6());
		this.hashColumns.put("port5", getPort5());
		this.hashColumns.put("bbsa11", getBbsa11());
		this.hashColumns.put("bsa5", getBsa5());
		this.hashColumns.put("fqta41", getFqta41());
		this.hashColumns.put("bsa4", getBsa4());
		this.hashColumns.put("bbsa51", getBbsa51());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bsa6", getBsa6());
		this.hashColumns.put("qta11", getQta11());
		this.hashColumns.put("bsa1", getBsa1());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("bsa3", getBsa3());
		this.hashColumns.put("bsa2", getBsa2());
		this.hashColumns.put("bqta31", getBqta31());
		this.hashColumns.put("fbsa51", getFbsa51());
		this.hashColumns.put("fct21", getFct21());
		this.hashColumns.put("fbsa21", getFbsa21());
		this.hashColumns.put("fct51", getFct51());
		this.hashColumns.put("bkg61", getBkg61());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("qta41", getQta41());
		this.hashColumns.put("bbsa41", getBbsa41());
		this.hashColumns.put("fqta31", getFqta31());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("t", getT());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bqta61", "bqta61");
		this.hashFields.put("fqta61", "fqta61");
		this.hashFields.put("fbsa61", "fbsa61");
		this.hashFields.put("bqta21", "bqta21");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("fct61", "fct61");
		this.hashFields.put("fbsa11", "fbsa11");
		this.hashFields.put("fct11", "fct11");
		this.hashFields.put("bkg31", "bkg31");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bbsa31", "bbsa31");
		this.hashFields.put("qta31", "qta31");
		this.hashFields.put("bkg21", "bkg21");
		this.hashFields.put("fqta21", "fqta21");
		this.hashFields.put("bqta11", "bqta11");
		this.hashFields.put("fqta51", "fqta51");
		this.hashFields.put("bkg41", "bkg41");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("bqta51", "bqta51");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("vvd6", "vvd6");
		this.hashFields.put("bbsa21", "bbsa21");
		this.hashFields.put("vvd5", "vvd5");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("fqta11", "fqta11");
		this.hashFields.put("qta61", "qta61");
		this.hashFields.put("qta21", "qta21");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bbsa61", "bbsa61");
		this.hashFields.put("bkg11", "bkg11");
		this.hashFields.put("bqta41", "bqta41");
		this.hashFields.put("fbsa41", "fbsa41");
		this.hashFields.put("fct31", "fct31");
		this.hashFields.put("fct41", "fct41");
		this.hashFields.put("fbsa31", "fbsa31");
		this.hashFields.put("bkg51", "bkg51");
		this.hashFields.put("port4", "port4");
		this.hashFields.put("port3", "port3");
		this.hashFields.put("qta51", "qta51");
		this.hashFields.put("port2", "port2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port1", "port1");
		this.hashFields.put("port6", "port6");
		this.hashFields.put("port5", "port5");
		this.hashFields.put("bbsa11", "bbsa11");
		this.hashFields.put("bsa5", "bsa5");
		this.hashFields.put("fqta41", "fqta41");
		this.hashFields.put("bsa4", "bsa4");
		this.hashFields.put("bbsa51", "bbsa51");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bsa6", "bsa6");
		this.hashFields.put("qta11", "qta11");
		this.hashFields.put("bsa1", "bsa1");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("bsa3", "bsa3");
		this.hashFields.put("bsa2", "bsa2");
		this.hashFields.put("bqta31", "bqta31");
		this.hashFields.put("fbsa51", "fbsa51");
		this.hashFields.put("fct21", "fct21");
		this.hashFields.put("fbsa21", "fbsa21");
		this.hashFields.put("fct51", "fct51");
		this.hashFields.put("bkg61", "bkg61");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("qta41", "qta41");
		this.hashFields.put("bbsa41", "bbsa41");
		this.hashFields.put("fqta31", "fqta31");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("t", "t");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bqta61
	 */
	public String getBqta61() {
		return this.bqta61;
	}
	
	/**
	 * Column Info
	 * @return fqta61
	 */
	public String getFqta61() {
		return this.fqta61;
	}
	
	/**
	 * Column Info
	 * @return fbsa61
	 */
	public String getFbsa61() {
		return this.fbsa61;
	}
	
	/**
	 * Column Info
	 * @return bqta21
	 */
	public String getBqta21() {
		return this.bqta21;
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
	 * @return fct61
	 */
	public String getFct61() {
		return this.fct61;
	}
	
	/**
	 * Column Info
	 * @return fbsa11
	 */
	public String getFbsa11() {
		return this.fbsa11;
	}
	
	/**
	 * Column Info
	 * @return fct11
	 */
	public String getFct11() {
		return this.fct11;
	}
	
	/**
	 * Column Info
	 * @return bkg31
	 */
	public String getBkg31() {
		return this.bkg31;
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
	 * @return bbsa31
	 */
	public String getBbsa31() {
		return this.bbsa31;
	}
	
	/**
	 * Column Info
	 * @return qta31
	 */
	public String getQta31() {
		return this.qta31;
	}
	
	/**
	 * Column Info
	 * @return bkg21
	 */
	public String getBkg21() {
		return this.bkg21;
	}
	
	/**
	 * Column Info
	 * @return fqta21
	 */
	public String getFqta21() {
		return this.fqta21;
	}
	
	/**
	 * Column Info
	 * @return bqta11
	 */
	public String getBqta11() {
		return this.bqta11;
	}
	
	/**
	 * Column Info
	 * @return fqta51
	 */
	public String getFqta51() {
		return this.fqta51;
	}
	
	/**
	 * Column Info
	 * @return bkg41
	 */
	public String getBkg41() {
		return this.bkg41;
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
	 * @return bqta51
	 */
	public String getBqta51() {
		return this.bqta51;
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
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
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
	 * @return bbsa21
	 */
	public String getBbsa21() {
		return this.bbsa21;
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
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return fqta11
	 */
	public String getFqta11() {
		return this.fqta11;
	}
	
	/**
	 * Column Info
	 * @return qta61
	 */
	public String getQta61() {
		return this.qta61;
	}
	
	/**
	 * Column Info
	 * @return qta21
	 */
	public String getQta21() {
		return this.qta21;
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
	 * @return bbsa61
	 */
	public String getBbsa61() {
		return this.bbsa61;
	}
	
	/**
	 * Column Info
	 * @return bkg11
	 */
	public String getBkg11() {
		return this.bkg11;
	}
	
	/**
	 * Column Info
	 * @return bqta41
	 */
	public String getBqta41() {
		return this.bqta41;
	}
	
	/**
	 * Column Info
	 * @return fbsa41
	 */
	public String getFbsa41() {
		return this.fbsa41;
	}
	
	/**
	 * Column Info
	 * @return fct31
	 */
	public String getFct31() {
		return this.fct31;
	}
	
	/**
	 * Column Info
	 * @return fct41
	 */
	public String getFct41() {
		return this.fct41;
	}
	
	/**
	 * Column Info
	 * @return fbsa31
	 */
	public String getFbsa31() {
		return this.fbsa31;
	}
	
	/**
	 * Column Info
	 * @return bkg51
	 */
	public String getBkg51() {
		return this.bkg51;
	}
	
	/**
	 * Column Info
	 * @return port4
	 */
	public String getPort4() {
		return this.port4;
	}
	
	/**
	 * Column Info
	 * @return port3
	 */
	public String getPort3() {
		return this.port3;
	}
	
	/**
	 * Column Info
	 * @return qta51
	 */
	public String getQta51() {
		return this.qta51;
	}
	
	/**
	 * Column Info
	 * @return port2
	 */
	public String getPort2() {
		return this.port2;
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
	 * @return port1
	 */
	public String getPort1() {
		return this.port1;
	}
	
	/**
	 * Column Info
	 * @return port6
	 */
	public String getPort6() {
		return this.port6;
	}
	
	/**
	 * Column Info
	 * @return port5
	 */
	public String getPort5() {
		return this.port5;
	}
	
	/**
	 * Column Info
	 * @return bbsa11
	 */
	public String getBbsa11() {
		return this.bbsa11;
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
	 * @return fqta41
	 */
	public String getFqta41() {
		return this.fqta41;
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
	 * @return bbsa51
	 */
	public String getBbsa51() {
		return this.bbsa51;
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
	 * @return bsa6
	 */
	public String getBsa6() {
		return this.bsa6;
	}
	
	/**
	 * Column Info
	 * @return qta11
	 */
	public String getQta11() {
		return this.qta11;
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
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
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
	 * @return bqta31
	 */
	public String getBqta31() {
		return this.bqta31;
	}
	
	/**
	 * Column Info
	 * @return fbsa51
	 */
	public String getFbsa51() {
		return this.fbsa51;
	}
	
	/**
	 * Column Info
	 * @return fct21
	 */
	public String getFct21() {
		return this.fct21;
	}
	
	/**
	 * Column Info
	 * @return fbsa21
	 */
	public String getFbsa21() {
		return this.fbsa21;
	}
	
	/**
	 * Column Info
	 * @return fct51
	 */
	public String getFct51() {
		return this.fct51;
	}
	
	/**
	 * Column Info
	 * @return bkg61
	 */
	public String getBkg61() {
		return this.bkg61;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return qta41
	 */
	public String getQta41() {
		return this.qta41;
	}
	
	/**
	 * Column Info
	 * @return bbsa41
	 */
	public String getBbsa41() {
		return this.bbsa41;
	}
	
	/**
	 * Column Info
	 * @return fqta31
	 */
	public String getFqta31() {
		return this.fqta31;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	
	/**
	 * @return the rhqCd
	 */
	public String getRhqCd() {
		return rhqCd;
	}

	/**
	 * @param rhqCd the rhqCd to set
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.bqta61 = cnt;
	}

	/**
	 * Column Info
	 * @param bqta61
	 */
	public void setBqta61(String bqta61) {
		this.bqta61 = bqta61;
	}
	
	/**
	 * Column Info
	 * @param fqta61
	 */
	public void setFqta61(String fqta61) {
		this.fqta61 = fqta61;
	}
	
	/**
	 * Column Info
	 * @param fbsa61
	 */
	public void setFbsa61(String fbsa61) {
		this.fbsa61 = fbsa61;
	}
	
	/**
	 * Column Info
	 * @param bqta21
	 */
	public void setBqta21(String bqta21) {
		this.bqta21 = bqta21;
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
	 * @param fct61
	 */
	public void setFct61(String fct61) {
		this.fct61 = fct61;
	}
	
	/**
	 * Column Info
	 * @param fbsa11
	 */
	public void setFbsa11(String fbsa11) {
		this.fbsa11 = fbsa11;
	}
	
	/**
	 * Column Info
	 * @param fct11
	 */
	public void setFct11(String fct11) {
		this.fct11 = fct11;
	}
	
	/**
	 * Column Info
	 * @param bkg31
	 */
	public void setBkg31(String bkg31) {
		this.bkg31 = bkg31;
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
	 * @param bbsa31
	 */
	public void setBbsa31(String bbsa31) {
		this.bbsa31 = bbsa31;
	}
	
	/**
	 * Column Info
	 * @param qta31
	 */
	public void setQta31(String qta31) {
		this.qta31 = qta31;
	}
	
	/**
	 * Column Info
	 * @param bkg21
	 */
	public void setBkg21(String bkg21) {
		this.bkg21 = bkg21;
	}
	
	/**
	 * Column Info
	 * @param fqta21
	 */
	public void setFqta21(String fqta21) {
		this.fqta21 = fqta21;
	}
	
	/**
	 * Column Info
	 * @param bqta11
	 */
	public void setBqta11(String bqta11) {
		this.bqta11 = bqta11;
	}
	
	/**
	 * Column Info
	 * @param fqta51
	 */
	public void setFqta51(String fqta51) {
		this.fqta51 = fqta51;
	}
	
	/**
	 * Column Info
	 * @param bkg41
	 */
	public void setBkg41(String bkg41) {
		this.bkg41 = bkg41;
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
	 * @param bqta51
	 */
	public void setBqta51(String bqta51) {
		this.bqta51 = bqta51;
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
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
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
	 * @param bbsa21
	 */
	public void setBbsa21(String bbsa21) {
		this.bbsa21 = bbsa21;
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
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param fqta11
	 */
	public void setFqta11(String fqta11) {
		this.fqta11 = fqta11;
	}
	
	/**
	 * Column Info
	 * @param qta61
	 */
	public void setQta61(String qta61) {
		this.qta61 = qta61;
	}
	
	/**
	 * Column Info
	 * @param qta21
	 */
	public void setQta21(String qta21) {
		this.qta21 = qta21;
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
	 * @param bbsa61
	 */
	public void setBbsa61(String bbsa61) {
		this.bbsa61 = bbsa61;
	}
	
	/**
	 * Column Info
	 * @param bkg11
	 */
	public void setBkg11(String bkg11) {
		this.bkg11 = bkg11;
	}
	
	/**
	 * Column Info
	 * @param bqta41
	 */
	public void setBqta41(String bqta41) {
		this.bqta41 = bqta41;
	}
	
	/**
	 * Column Info
	 * @param fbsa41
	 */
	public void setFbsa41(String fbsa41) {
		this.fbsa41 = fbsa41;
	}
	
	/**
	 * Column Info
	 * @param fct31
	 */
	public void setFct31(String fct31) {
		this.fct31 = fct31;
	}
	
	/**
	 * Column Info
	 * @param fct41
	 */
	public void setFct41(String fct41) {
		this.fct41 = fct41;
	}
	
	/**
	 * Column Info
	 * @param fbsa31
	 */
	public void setFbsa31(String fbsa31) {
		this.fbsa31 = fbsa31;
	}
	
	/**
	 * Column Info
	 * @param bkg51
	 */
	public void setBkg51(String bkg51) {
		this.bkg51 = bkg51;
	}
	
	/**
	 * Column Info
	 * @param port4
	 */
	public void setPort4(String port4) {
		this.port4 = port4;
	}
	
	/**
	 * Column Info
	 * @param port3
	 */
	public void setPort3(String port3) {
		this.port3 = port3;
	}
	
	/**
	 * Column Info
	 * @param qta51
	 */
	public void setQta51(String qta51) {
		this.qta51 = qta51;
	}
	
	/**
	 * Column Info
	 * @param port2
	 */
	public void setPort2(String port2) {
		this.port2 = port2;
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
	 * @param port1
	 */
	public void setPort1(String port1) {
		this.port1 = port1;
	}
	
	/**
	 * Column Info
	 * @param port6
	 */
	public void setPort6(String port6) {
		this.port6 = port6;
	}
	
	/**
	 * Column Info
	 * @param port5
	 */
	public void setPort5(String port5) {
		this.port5 = port5;
	}
	
	/**
	 * Column Info
	 * @param bbsa11
	 */
	public void setBbsa11(String bbsa11) {
		this.bbsa11 = bbsa11;
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
	 * @param fqta41
	 */
	public void setFqta41(String fqta41) {
		this.fqta41 = fqta41;
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
	 * @param bbsa51
	 */
	public void setBbsa51(String bbsa51) {
		this.bbsa51 = bbsa51;
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
	 * @param bsa6
	 */
	public void setBsa6(String bsa6) {
		this.bsa6 = bsa6;
	}
	
	/**
	 * Column Info
	 * @param qta11
	 */
	public void setQta11(String qta11) {
		this.qta11 = qta11;
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
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
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
	 * @param bqta31
	 */
	public void setBqta31(String bqta31) {
		this.bqta31 = bqta31;
	}
	
	/**
	 * Column Info
	 * @param fbsa51
	 */
	public void setFbsa51(String fbsa51) {
		this.fbsa51 = fbsa51;
	}
	
	/**
	 * Column Info
	 * @param fct21
	 */
	public void setFct21(String fct21) {
		this.fct21 = fct21;
	}
	
	/**
	 * Column Info
	 * @param fbsa21
	 */
	public void setFbsa21(String fbsa21) {
		this.fbsa21 = fbsa21;
	}
	
	/**
	 * Column Info
	 * @param fct51
	 */
	public void setFct51(String fct51) {
		this.fct51 = fct51;
	}
	
	/**
	 * Column Info
	 * @param bkg61
	 */
	public void setBkg61(String bkg61) {
		this.bkg61 = bkg61;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param qta41
	 */
	public void setQta41(String qta41) {
		this.qta41 = qta41;
	}
	
	/**
	 * Column Info
	 * @param bbsa41
	 */
	public void setBbsa41(String bbsa41) {
		this.bbsa41 = bbsa41;
	}
	
	/**
	 * Column Info
	 * @param fqta31
	 */
	public void setFqta31(String fqta31) {
		this.fqta31 = fqta31;
	}
	
	
	
	/**
	 * @return the t
	 */
	public String getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(String t) {
		this.t = t;
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
		setBqta61(JSPUtil.getParameter(request, prefix + "bqta61", ""));
		setFqta61(JSPUtil.getParameter(request, prefix + "fqta61", ""));
		setFbsa61(JSPUtil.getParameter(request, prefix + "fbsa61", ""));
		setBqta21(JSPUtil.getParameter(request, prefix + "bqta21", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFct61(JSPUtil.getParameter(request, prefix + "fct61", ""));
		setFbsa11(JSPUtil.getParameter(request, prefix + "fbsa11", ""));
		setFct11(JSPUtil.getParameter(request, prefix + "fct11", ""));
		setBkg31(JSPUtil.getParameter(request, prefix + "bkg31", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBbsa31(JSPUtil.getParameter(request, prefix + "bbsa31", ""));
		setQta31(JSPUtil.getParameter(request, prefix + "qta31", ""));
		setBkg21(JSPUtil.getParameter(request, prefix + "bkg21", ""));
		setFqta21(JSPUtil.getParameter(request, prefix + "fqta21", ""));
		setBqta11(JSPUtil.getParameter(request, prefix + "bqta11", ""));
		setFqta51(JSPUtil.getParameter(request, prefix + "fqta51", ""));
		setBkg41(JSPUtil.getParameter(request, prefix + "bkg41", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setBqta51(JSPUtil.getParameter(request, prefix + "bqta51", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setVvd6(JSPUtil.getParameter(request, prefix + "vvd6", ""));
		setBbsa21(JSPUtil.getParameter(request, prefix + "bbsa21", ""));
		setVvd5(JSPUtil.getParameter(request, prefix + "vvd5", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setFqta11(JSPUtil.getParameter(request, prefix + "fqta11", ""));
		setQta61(JSPUtil.getParameter(request, prefix + "qta61", ""));
		setQta21(JSPUtil.getParameter(request, prefix + "qta21", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBbsa61(JSPUtil.getParameter(request, prefix + "bbsa61", ""));
		setBkg11(JSPUtil.getParameter(request, prefix + "bkg11", ""));
		setBqta41(JSPUtil.getParameter(request, prefix + "bqta41", ""));
		setFbsa41(JSPUtil.getParameter(request, prefix + "fbsa41", ""));
		setFct31(JSPUtil.getParameter(request, prefix + "fct31", ""));
		setFct41(JSPUtil.getParameter(request, prefix + "fct41", ""));
		setFbsa31(JSPUtil.getParameter(request, prefix + "fbsa31", ""));
		setBkg51(JSPUtil.getParameter(request, prefix + "bkg51", ""));
		setPort4(JSPUtil.getParameter(request, prefix + "port4", ""));
		setPort3(JSPUtil.getParameter(request, prefix + "port3", ""));
		setQta51(JSPUtil.getParameter(request, prefix + "qta51", ""));
		setPort2(JSPUtil.getParameter(request, prefix + "port2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPort1(JSPUtil.getParameter(request, prefix + "port1", ""));
		setPort6(JSPUtil.getParameter(request, prefix + "port6", ""));
		setPort5(JSPUtil.getParameter(request, prefix + "port5", ""));
		setBbsa11(JSPUtil.getParameter(request, prefix + "bbsa11", ""));
		setBsa5(JSPUtil.getParameter(request, prefix + "bsa5", ""));
		setFqta41(JSPUtil.getParameter(request, prefix + "fqta41", ""));
		setBsa4(JSPUtil.getParameter(request, prefix + "bsa4", ""));
		setBbsa51(JSPUtil.getParameter(request, prefix + "bbsa51", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBsa6(JSPUtil.getParameter(request, prefix + "bsa6", ""));
		setQta11(JSPUtil.getParameter(request, prefix + "qta11", ""));
		setBsa1(JSPUtil.getParameter(request, prefix + "bsa1", ""));
		setAqCd(JSPUtil.getParameter(request, prefix + "aq_cd", ""));
		setBsa3(JSPUtil.getParameter(request, prefix + "bsa3", ""));
		setBsa2(JSPUtil.getParameter(request, prefix + "bsa2", ""));
		setBqta31(JSPUtil.getParameter(request, prefix + "bqta31", ""));
		setFbsa51(JSPUtil.getParameter(request, prefix + "fbsa51", ""));
		setFct21(JSPUtil.getParameter(request, prefix + "fct21", ""));
		setFbsa21(JSPUtil.getParameter(request, prefix + "fbsa21", ""));
		setFct51(JSPUtil.getParameter(request, prefix + "fct51", ""));
		setBkg61(JSPUtil.getParameter(request, prefix + "bkg61", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setQta41(JSPUtil.getParameter(request, prefix + "qta41", ""));
		setBbsa41(JSPUtil.getParameter(request, prefix + "bbsa41", ""));
		setFqta31(JSPUtil.getParameter(request, prefix + "fqta31", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhqCd", ""));
		setT(JSPUtil.getParameter(request, prefix + "t", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry021PfmcRatioVO[]
	 */
	public SearchSpaceControlInquiry021PfmcRatioVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiry021PfmcRatioVO[]
	 */
	public SearchSpaceControlInquiry021PfmcRatioVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry021PfmcRatioVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bqta61 = (JSPUtil.getParameter(request, prefix	+ "bqta61", length));
			String[] fqta61 = (JSPUtil.getParameter(request, prefix	+ "fqta61", length));
			String[] fbsa61 = (JSPUtil.getParameter(request, prefix	+ "fbsa61", length));
			String[] bqta21 = (JSPUtil.getParameter(request, prefix	+ "bqta21", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fct61 = (JSPUtil.getParameter(request, prefix	+ "fct61", length));
			String[] fbsa11 = (JSPUtil.getParameter(request, prefix	+ "fbsa11", length));
			String[] fct11 = (JSPUtil.getParameter(request, prefix	+ "fct11", length));
			String[] bkg31 = (JSPUtil.getParameter(request, prefix	+ "bkg31", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bbsa31 = (JSPUtil.getParameter(request, prefix	+ "bbsa31", length));
			String[] qta31 = (JSPUtil.getParameter(request, prefix	+ "qta31", length));
			String[] bkg21 = (JSPUtil.getParameter(request, prefix	+ "bkg21", length));
			String[] fqta21 = (JSPUtil.getParameter(request, prefix	+ "fqta21", length));
			String[] bqta11 = (JSPUtil.getParameter(request, prefix	+ "bqta11", length));
			String[] fqta51 = (JSPUtil.getParameter(request, prefix	+ "fqta51", length));
			String[] bkg41 = (JSPUtil.getParameter(request, prefix	+ "bkg41", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] bqta51 = (JSPUtil.getParameter(request, prefix	+ "bqta51", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] vvd6 = (JSPUtil.getParameter(request, prefix	+ "vvd6", length));
			String[] bbsa21 = (JSPUtil.getParameter(request, prefix	+ "bbsa21", length));
			String[] vvd5 = (JSPUtil.getParameter(request, prefix	+ "vvd5", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] fqta11 = (JSPUtil.getParameter(request, prefix	+ "fqta11", length));
			String[] qta61 = (JSPUtil.getParameter(request, prefix	+ "qta61", length));
			String[] qta21 = (JSPUtil.getParameter(request, prefix	+ "qta21", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bbsa61 = (JSPUtil.getParameter(request, prefix	+ "bbsa61", length));
			String[] bkg11 = (JSPUtil.getParameter(request, prefix	+ "bkg11", length));
			String[] bqta41 = (JSPUtil.getParameter(request, prefix	+ "bqta41", length));
			String[] fbsa41 = (JSPUtil.getParameter(request, prefix	+ "fbsa41", length));
			String[] fct31 = (JSPUtil.getParameter(request, prefix	+ "fct31", length));
			String[] fct41 = (JSPUtil.getParameter(request, prefix	+ "fct41", length));
			String[] fbsa31 = (JSPUtil.getParameter(request, prefix	+ "fbsa31", length));
			String[] bkg51 = (JSPUtil.getParameter(request, prefix	+ "bkg51", length));
			String[] port4 = (JSPUtil.getParameter(request, prefix	+ "port4", length));
			String[] port3 = (JSPUtil.getParameter(request, prefix	+ "port3", length));
			String[] qta51 = (JSPUtil.getParameter(request, prefix	+ "qta51", length));
			String[] port2 = (JSPUtil.getParameter(request, prefix	+ "port2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] port1 = (JSPUtil.getParameter(request, prefix	+ "port1", length));
			String[] port6 = (JSPUtil.getParameter(request, prefix	+ "port6", length));
			String[] port5 = (JSPUtil.getParameter(request, prefix	+ "port5", length));
			String[] bbsa11 = (JSPUtil.getParameter(request, prefix	+ "bbsa11", length));
			String[] bsa5 = (JSPUtil.getParameter(request, prefix	+ "bsa5", length));
			String[] fqta41 = (JSPUtil.getParameter(request, prefix	+ "fqta41", length));
			String[] bsa4 = (JSPUtil.getParameter(request, prefix	+ "bsa4", length));
			String[] bbsa51 = (JSPUtil.getParameter(request, prefix	+ "bbsa51", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bsa6 = (JSPUtil.getParameter(request, prefix	+ "bsa6", length));
			String[] qta11 = (JSPUtil.getParameter(request, prefix	+ "qta11", length));
			String[] bsa1 = (JSPUtil.getParameter(request, prefix	+ "bsa1", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] bsa3 = (JSPUtil.getParameter(request, prefix	+ "bsa3", length));
			String[] bsa2 = (JSPUtil.getParameter(request, prefix	+ "bsa2", length));
			String[] bqta31 = (JSPUtil.getParameter(request, prefix	+ "bqta31", length));
			String[] fbsa51 = (JSPUtil.getParameter(request, prefix	+ "fbsa51", length));
			String[] fct21 = (JSPUtil.getParameter(request, prefix	+ "fct21", length));
			String[] fbsa21 = (JSPUtil.getParameter(request, prefix	+ "fbsa21", length));
			String[] fct51 = (JSPUtil.getParameter(request, prefix	+ "fct51", length));
			String[] bkg61 = (JSPUtil.getParameter(request, prefix	+ "bkg61", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] qta41 = (JSPUtil.getParameter(request, prefix	+ "qta41", length));
			String[] bbsa41 = (JSPUtil.getParameter(request, prefix	+ "bbsa41", length));
			String[] fqta31 = (JSPUtil.getParameter(request, prefix	+ "fqta31", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhqCd", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry021PfmcRatioVO();
				if (bqta61[i] != null)
					model.setBqta61(bqta61[i]);
				if (fqta61[i] != null)
					model.setFqta61(fqta61[i]);
				if (fbsa61[i] != null)
					model.setFbsa61(fbsa61[i]);
				if (bqta21[i] != null)
					model.setBqta21(bqta21[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fct61[i] != null)
					model.setFct61(fct61[i]);
				if (fbsa11[i] != null)
					model.setFbsa11(fbsa11[i]);
				if (fct11[i] != null)
					model.setFct11(fct11[i]);
				if (bkg31[i] != null)
					model.setBkg31(bkg31[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bbsa31[i] != null)
					model.setBbsa31(bbsa31[i]);
				if (qta31[i] != null)
					model.setQta31(qta31[i]);
				if (bkg21[i] != null)
					model.setBkg21(bkg21[i]);
				if (fqta21[i] != null)
					model.setFqta21(fqta21[i]);
				if (bqta11[i] != null)
					model.setBqta11(bqta11[i]);
				if (fqta51[i] != null)
					model.setFqta51(fqta51[i]);
				if (bkg41[i] != null)
					model.setBkg41(bkg41[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (bqta51[i] != null)
					model.setBqta51(bqta51[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (vvd6[i] != null)
					model.setVvd6(vvd6[i]);
				if (bbsa21[i] != null)
					model.setBbsa21(bbsa21[i]);
				if (vvd5[i] != null)
					model.setVvd5(vvd5[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (fqta11[i] != null)
					model.setFqta11(fqta11[i]);
				if (qta61[i] != null)
					model.setQta61(qta61[i]);
				if (qta21[i] != null)
					model.setQta21(qta21[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bbsa61[i] != null)
					model.setBbsa61(bbsa61[i]);
				if (bkg11[i] != null)
					model.setBkg11(bkg11[i]);
				if (bqta41[i] != null)
					model.setBqta41(bqta41[i]);
				if (fbsa41[i] != null)
					model.setFbsa41(fbsa41[i]);
				if (fct31[i] != null)
					model.setFct31(fct31[i]);
				if (fct41[i] != null)
					model.setFct41(fct41[i]);
				if (fbsa31[i] != null)
					model.setFbsa31(fbsa31[i]);
				if (bkg51[i] != null)
					model.setBkg51(bkg51[i]);
				if (port4[i] != null)
					model.setPort4(port4[i]);
				if (port3[i] != null)
					model.setPort3(port3[i]);
				if (qta51[i] != null)
					model.setQta51(qta51[i]);
				if (port2[i] != null)
					model.setPort2(port2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (port1[i] != null)
					model.setPort1(port1[i]);
				if (port6[i] != null)
					model.setPort6(port6[i]);
				if (port5[i] != null)
					model.setPort5(port5[i]);
				if (bbsa11[i] != null)
					model.setBbsa11(bbsa11[i]);
				if (bsa5[i] != null)
					model.setBsa5(bsa5[i]);
				if (fqta41[i] != null)
					model.setFqta41(fqta41[i]);
				if (bsa4[i] != null)
					model.setBsa4(bsa4[i]);
				if (bbsa51[i] != null)
					model.setBbsa51(bbsa51[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bsa6[i] != null)
					model.setBsa6(bsa6[i]);
				if (qta11[i] != null)
					model.setQta11(qta11[i]);
				if (bsa1[i] != null)
					model.setBsa1(bsa1[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (bsa3[i] != null)
					model.setBsa3(bsa3[i]);
				if (bsa2[i] != null)
					model.setBsa2(bsa2[i]);
				if (bqta31[i] != null)
					model.setBqta31(bqta31[i]);
				if (fbsa51[i] != null)
					model.setFbsa51(fbsa51[i]);
				if (fct21[i] != null)
					model.setFct21(fct21[i]);
				if (fbsa21[i] != null)
					model.setFbsa21(fbsa21[i]);
				if (fct51[i] != null)
					model.setFct51(fct51[i]);
				if (bkg61[i] != null)
					model.setBkg61(bkg61[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (qta41[i] != null)
					model.setQta41(qta41[i]);
				if (bbsa41[i] != null)
					model.setBbsa41(bbsa41[i]);
				if (fqta31[i] != null)
					model.setFqta31(fqta31[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (t[i] != null)
					model.setT(t[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiry021PfmcRatioVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry021PfmcRatioVO[]
	 */
	public SearchSpaceControlInquiry021PfmcRatioVO[] getSearchSpaceControlInquiry021PfmcRatioVOs(){
		SearchSpaceControlInquiry021PfmcRatioVO[] vos = (SearchSpaceControlInquiry021PfmcRatioVO[])models.toArray(new SearchSpaceControlInquiry021PfmcRatioVO[models.size()]);
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
		this.bqta61 = this.bqta61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta61 = this.fqta61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa61 = this.fbsa61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqta21 = this.bqta21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct61 = this.fct61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa11 = this.fbsa11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct11 = this.fct11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg31 = this.bkg31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa31 = this.bbsa31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta31 = this.qta31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg21 = this.bkg21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta21 = this.fqta21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqta11 = this.bqta11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta51 = this.fqta51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg41 = this.bkg41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqta51 = this.bqta51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd6 = this.vvd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa21 = this.bbsa21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd5 = this.vvd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta11 = this.fqta11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta61 = this.qta61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta21 = this.qta21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa61 = this.bbsa61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg11 = this.bkg11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqta41 = this.bqta41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa41 = this.fbsa41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct31 = this.fct31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct41 = this.fct41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa31 = this.fbsa31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg51 = this.bkg51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port4 = this.port4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port3 = this.port3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta51 = this.qta51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port2 = this.port2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port1 = this.port1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port6 = this.port6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port5 = this.port5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa11 = this.bbsa11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa5 = this.bsa5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta41 = this.fqta41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa4 = this.bsa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa51 = this.bbsa51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa6 = this.bsa6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta11 = this.qta11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa1 = this.bsa1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa3 = this.bsa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa2 = this.bsa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqta31 = this.bqta31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa51 = this.fbsa51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct21 = this.fct21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbsa21 = this.fbsa21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct51 = this.fct51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg61 = this.bkg61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qta41 = this.qta41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbsa41 = this.bbsa41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqta31 = this.fqta31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
