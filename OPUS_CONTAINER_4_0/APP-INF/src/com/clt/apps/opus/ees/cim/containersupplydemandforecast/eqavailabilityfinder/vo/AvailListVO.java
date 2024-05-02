/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AvailListVO.java
*@FileTitle : AvailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.02.09 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvailListVO> models = new ArrayList<AvailListVO>();
	
	/* Column Info */
	private String sn2 = null;
	/* Column Info */
	private String sn1 = null;
	/* Column Info */
	private String sn4 = null;
	/* Column Info */
	private String sn3 = null;
	/* Column Info */
	private String ig1 = null;
	/* Column Info */
	private String ig2 = null;
	/* Column Info */
	private String ig3 = null;
	/* Column Info */
	private String ig4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofh3 = null;
	/* Column Info */
	private String ofh4 = null;
	/* Column Info */
	private String ofh1 = null;
	/* Column Info */
	private String ofh2 = null;
	/* Column Info */
	private String rtn4 = null;
	/* Column Info */
	private String ri3 = null;
	/* Column Info */
	private String ri4 = null;
	/* Column Info */
	private String rtn3 = null;
	/* Column Info */
	private String ri1 = null;
	/* Column Info */
	private String rtn2 = null;
	/* Column Info */
	private String ri2 = null;
	/* Column Info */
	private String rtn1 = null;
	/* Column Info */
	private String dg3 = null;
	/* Column Info */
	private String dg4 = null;
	/* Column Info */
	private String pup3 = null;
	/* Column Info */
	private String pup4 = null;
	/* Column Info */
	private String pup1 = null;
	/* Column Info */
	private String onh4 = null;
	/* Column Info */
	private String onh3 = null;
	/* Column Info */
	private String pup2 = null;
	/* Column Info */
	private String onh2 = null;
	/* Column Info */
	private String onh1 = null;
	/* Column Info */
	private String locLevel = null;
	/* Column Info */
	private String fcastDt = null;
	/* Column Info */
	private String br3 = null;
	/* Column Info */
	private String br2 = null;
	/* Column Info */
	private String br1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String br4 = null;
	/* Column Info */
	private String dg2 = null;
	/* Column Info */
	private String dg1 = null;
	/* Column Info */
	private String avail3 = null;
	/* Column Info */
	private String ro1 = null;
	/* Column Info */
	private String avail2 = null;
	/* Column Info */
	private String avail1 = null;
	/* Column Info */
	private String ro2 = null;
	/* Column Info */
	private String ro3 = null;
	/* Column Info */
	private String sccYdCd = null;
	/* Column Info */
	private String ro4 = null;
	/* Column Info */
	private String ea2 = null;
	/* Column Info */
	private String ea3 = null;
	/* Column Info */
	private String ea1 = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String avail14 = null;
	/* Column Info */
	private String ea4 = null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 tpCd   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AvailListVO() {}

	public AvailListVO(String ibflag, String pagerows, String sn1, String sn2, String sn3, String sn4, String ig1, String onh1, String onh2, String onh3, String onh4, String ig2, String ig3, String ig4, String rtn1, String rtn2, String rtn3, String rtn4, String fcastDt, String locLevel, String br3, String br2, String br1, String br4, String pup1, String pup2, String pup3, String pup4, String ofh3, String ofh4, String ofh1, String ofh2, String avail3, String ro1, String avail2, String avail1, String ro2, String ro3, String sccYdCd, String ro4, String ea2, String ea3, String ea1, String sccCd, String ydCd, String ri3, String ri4, String ri1, String ri2, String ea4, String avail14, String dg1, String dg2, String dg3, String dg4,String cntrTpszCd,String tpCd) {
		this.sn2 = sn2;
		this.sn1 = sn1;
		this.sn4 = sn4;
		this.sn3 = sn3;
		this.ig1 = ig1;
		this.ig2 = ig2;
		this.ig3 = ig3;
		this.ig4 = ig4;
		this.pagerows = pagerows;
		this.ofh3 = ofh3;
		this.ofh4 = ofh4;
		this.ofh1 = ofh1;
		this.ofh2 = ofh2;
		this.rtn4 = rtn4;
		this.ri3 = ri3;
		this.ri4 = ri4;
		this.rtn3 = rtn3;
		this.ri1 = ri1;
		this.rtn2 = rtn2;
		this.ri2 = ri2;
		this.rtn1 = rtn1;
		this.dg3 = dg3;
		this.dg4 = dg4;
		this.pup3 = pup3;
		this.pup4 = pup4;
		this.pup1 = pup1;
		this.onh4 = onh4;
		this.onh3 = onh3;
		this.pup2 = pup2;
		this.onh2 = onh2;
		this.onh1 = onh1;
		this.locLevel = locLevel;
		this.fcastDt = fcastDt;
		this.br3 = br3;
		this.br2 = br2;
		this.br1 = br1;
		this.ibflag = ibflag;
		this.br4 = br4;
		this.dg2 = dg2;
		this.dg1 = dg1;
		this.avail3 = avail3;
		this.ro1 = ro1;
		this.avail2 = avail2;
		this.avail1 = avail1;
		this.ro2 = ro2;
		this.ro3 = ro3;
		this.sccYdCd = sccYdCd;
		this.ro4 = ro4;
		this.ea2 = ea2;
		this.ea3 = ea3;
		this.ea1 = ea1;
		this.sccCd = sccCd;
		this.ydCd = ydCd;
		this.avail14 = avail14;
		this.ea4 = ea4;
		this.cntrTpszCd  = cntrTpszCd ;
		this.tpCd  = tpCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sn2", getSn2());
		this.hashColumns.put("sn1", getSn1());
		this.hashColumns.put("sn4", getSn4());
		this.hashColumns.put("sn3", getSn3());
		this.hashColumns.put("ig1", getIg1());
		this.hashColumns.put("ig2", getIg2());
		this.hashColumns.put("ig3", getIg3());
		this.hashColumns.put("ig4", getIg4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofh3", getOfh3());
		this.hashColumns.put("ofh4", getOfh4());
		this.hashColumns.put("ofh1", getOfh1());
		this.hashColumns.put("ofh2", getOfh2());
		this.hashColumns.put("rtn4", getRtn4());
		this.hashColumns.put("ri3", getRi3());
		this.hashColumns.put("ri4", getRi4());
		this.hashColumns.put("rtn3", getRtn3());
		this.hashColumns.put("ri1", getRi1());
		this.hashColumns.put("rtn2", getRtn2());
		this.hashColumns.put("ri2", getRi2());
		this.hashColumns.put("rtn1", getRtn1());
		this.hashColumns.put("dg3", getDg3());
		this.hashColumns.put("dg4", getDg4());
		this.hashColumns.put("pup3", getPup3());
		this.hashColumns.put("pup4", getPup4());
		this.hashColumns.put("pup1", getPup1());
		this.hashColumns.put("onh4", getOnh4());
		this.hashColumns.put("onh3", getOnh3());
		this.hashColumns.put("pup2", getPup2());
		this.hashColumns.put("onh2", getOnh2());
		this.hashColumns.put("onh1", getOnh1());
		this.hashColumns.put("loc_level", getLocLevel());
		this.hashColumns.put("fcast_dt", getFcastDt());
		this.hashColumns.put("br3", getBr3());
		this.hashColumns.put("br2", getBr2());
		this.hashColumns.put("br1", getBr1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("br4", getBr4());
		this.hashColumns.put("dg2", getDg2());
		this.hashColumns.put("dg1", getDg1());
		this.hashColumns.put("avail3", getAvail3());
		this.hashColumns.put("ro1", getRo1());
		this.hashColumns.put("avail2", getAvail2());
		this.hashColumns.put("avail1", getAvail1());
		this.hashColumns.put("ro2", getRo2());
		this.hashColumns.put("ro3", getRo3());
		this.hashColumns.put("scc_yd_cd", getSccYdCd());
		this.hashColumns.put("ro4", getRo4());
		this.hashColumns.put("ea2", getEa2());
		this.hashColumns.put("ea3", getEa3());
		this.hashColumns.put("ea1", getEa1());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("avail14", getAvail14());
		this.hashColumns.put("ea4", getEa4());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("tp_cd", getTpCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sn2", "sn2");
		this.hashFields.put("sn1", "sn1");
		this.hashFields.put("sn4", "sn4");
		this.hashFields.put("sn3", "sn3");
		this.hashFields.put("ig1", "ig1");
		this.hashFields.put("ig2", "ig2");
		this.hashFields.put("ig3", "ig3");
		this.hashFields.put("ig4", "ig4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofh3", "ofh3");
		this.hashFields.put("ofh4", "ofh4");
		this.hashFields.put("ofh1", "ofh1");
		this.hashFields.put("ofh2", "ofh2");
		this.hashFields.put("rtn4", "rtn4");
		this.hashFields.put("ri3", "ri3");
		this.hashFields.put("ri4", "ri4");
		this.hashFields.put("rtn3", "rtn3");
		this.hashFields.put("ri1", "ri1");
		this.hashFields.put("rtn2", "rtn2");
		this.hashFields.put("ri2", "ri2");
		this.hashFields.put("rtn1", "rtn1");
		this.hashFields.put("dg3", "dg3");
		this.hashFields.put("dg4", "dg4");
		this.hashFields.put("pup3", "pup3");
		this.hashFields.put("pup4", "pup4");
		this.hashFields.put("pup1", "pup1");
		this.hashFields.put("onh4", "onh4");
		this.hashFields.put("onh3", "onh3");
		this.hashFields.put("pup2", "pup2");
		this.hashFields.put("onh2", "onh2");
		this.hashFields.put("onh1", "onh1");
		this.hashFields.put("loc_level", "locLevel");
		this.hashFields.put("fcast_dt", "fcastDt");
		this.hashFields.put("br3", "br3");
		this.hashFields.put("br2", "br2");
		this.hashFields.put("br1", "br1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("br4", "br4");
		this.hashFields.put("dg2", "dg2");
		this.hashFields.put("dg1", "dg1");
		this.hashFields.put("avail3", "avail3");
		this.hashFields.put("ro1", "ro1");
		this.hashFields.put("avail2", "avail2");
		this.hashFields.put("avail1", "avail1");
		this.hashFields.put("ro2", "ro2");
		this.hashFields.put("ro3", "ro3");
		this.hashFields.put("scc_yd_cd", "sccYdCd");
		this.hashFields.put("ro4", "ro4");
		this.hashFields.put("ea2", "ea2");
		this.hashFields.put("ea3", "ea3");
		this.hashFields.put("ea1", "ea1");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("avail14", "avail14");
		this.hashFields.put("ea4", "ea4");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sn2
	 */
	public String getSn2() {
		return this.sn2;
	}
	
	/**
	 * Column Info
	 * @return sn1
	 */
	public String getSn1() {
		return this.sn1;
	}
	
	/**
	 * Column Info
	 * @return sn4
	 */
	public String getSn4() {
		return this.sn4;
	}
	
	/**
	 * Column Info
	 * @return sn3
	 */
	public String getSn3() {
		return this.sn3;
	}
	
	/**
	 * Column Info
	 * @return ig1
	 */
	public String getIg1() {
		return this.ig1;
	}
	
	/**
	 * Column Info
	 * @return ig2
	 */
	public String getIg2() {
		return this.ig2;
	}
	
	/**
	 * Column Info
	 * @return ig3
	 */
	public String getIg3() {
		return this.ig3;
	}
	
	/**
	 * Column Info
	 * @return ig4
	 */
	public String getIg4() {
		return this.ig4;
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
	 * @return ofh3
	 */
	public String getOfh3() {
		return this.ofh3;
	}
	
	/**
	 * Column Info
	 * @return ofh4
	 */
	public String getOfh4() {
		return this.ofh4;
	}
	
	/**
	 * Column Info
	 * @return ofh1
	 */
	public String getOfh1() {
		return this.ofh1;
	}
	
	/**
	 * Column Info
	 * @return ofh2
	 */
	public String getOfh2() {
		return this.ofh2;
	}
	
	/**
	 * Column Info
	 * @return rtn4
	 */
	public String getRtn4() {
		return this.rtn4;
	}
	
	/**
	 * Column Info
	 * @return ri3
	 */
	public String getRi3() {
		return this.ri3;
	}
	
	/**
	 * Column Info
	 * @return ri4
	 */
	public String getRi4() {
		return this.ri4;
	}
	
	/**
	 * Column Info
	 * @return rtn3
	 */
	public String getRtn3() {
		return this.rtn3;
	}
	
	/**
	 * Column Info
	 * @return ri1
	 */
	public String getRi1() {
		return this.ri1;
	}
	
	/**
	 * Column Info
	 * @return rtn2
	 */
	public String getRtn2() {
		return this.rtn2;
	}
	
	/**
	 * Column Info
	 * @return ri2
	 */
	public String getRi2() {
		return this.ri2;
	}
	
	/**
	 * Column Info
	 * @return rtn1
	 */
	public String getRtn1() {
		return this.rtn1;
	}
	
	/**
	 * Column Info
	 * @return dg3
	 */
	public String getDg3() {
		return this.dg3;
	}
	
	/**
	 * Column Info
	 * @return dg4
	 */
	public String getDg4() {
		return this.dg4;
	}
	
	/**
	 * Column Info
	 * @return pup3
	 */
	public String getPup3() {
		return this.pup3;
	}
	
	/**
	 * Column Info
	 * @return pup4
	 */
	public String getPup4() {
		return this.pup4;
	}
	
	/**
	 * Column Info
	 * @return pup1
	 */
	public String getPup1() {
		return this.pup1;
	}
	
	/**
	 * Column Info
	 * @return onh4
	 */
	public String getOnh4() {
		return this.onh4;
	}
	
	/**
	 * Column Info
	 * @return onh3
	 */
	public String getOnh3() {
		return this.onh3;
	}
	
	/**
	 * Column Info
	 * @return pup2
	 */
	public String getPup2() {
		return this.pup2;
	}
	
	/**
	 * Column Info
	 * @return onh2
	 */
	public String getOnh2() {
		return this.onh2;
	}
	
	/**
	 * Column Info
	 * @return onh1
	 */
	public String getOnh1() {
		return this.onh1;
	}
	
	/**
	 * Column Info
	 * @return locLevel
	 */
	public String getLocLevel() {
		return this.locLevel;
	}
	
	/**
	 * Column Info
	 * @return fcastDt
	 */
	public String getFcastDt() {
		return this.fcastDt;
	}
	
	/**
	 * Column Info
	 * @return br3
	 */
	public String getBr3() {
		return this.br3;
	}
	
	/**
	 * Column Info
	 * @return br2
	 */
	public String getBr2() {
		return this.br2;
	}
	
	/**
	 * Column Info
	 * @return br1
	 */
	public String getBr1() {
		return this.br1;
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
	 * @return br4
	 */
	public String getBr4() {
		return this.br4;
	}
	
	/**
	 * Column Info
	 * @return dg2
	 */
	public String getDg2() {
		return this.dg2;
	}
	
	/**
	 * Column Info
	 * @return dg1
	 */
	public String getDg1() {
		return this.dg1;
	}
	
	/**
	 * Column Info
	 * @return avail3
	 */
	public String getAvail3() {
		return this.avail3;
	}
	
	/**
	 * Column Info
	 * @return ro1
	 */
	public String getRo1() {
		return this.ro1;
	}
	
	/**
	 * Column Info
	 * @return avail2
	 */
	public String getAvail2() {
		return this.avail2;
	}
	
	/**
	 * Column Info
	 * @return avail1
	 */
	public String getAvail1() {
		return this.avail1;
	}
	
	/**
	 * Column Info
	 * @return ro2
	 */
	public String getRo2() {
		return this.ro2;
	}
	
	/**
	 * Column Info
	 * @return ro3
	 */
	public String getRo3() {
		return this.ro3;
	}
	
	/**
	 * Column Info
	 * @return sccYdCd
	 */
	public String getSccYdCd() {
		return this.sccYdCd;
	}
	
	/**
	 * Column Info
	 * @return ro4
	 */
	public String getRo4() {
		return this.ro4;
	}
	
	/**
	 * Column Info
	 * @return ea2
	 */
	public String getEa2() {
		return this.ea2;
	}
	
	/**
	 * Column Info
	 * @return ea3
	 */
	public String getEa3() {
		return this.ea3;
	}
	
	/**
	 * Column Info
	 * @return ea1
	 */
	public String getEa1() {
		return this.ea1;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return avail14
	 */
	public String getAvail14() {
		return this.avail14;
	}
	
	/**
	 * Column Info
	 * @return ea4
	 */
	public String getEa4() {
		return this.ea4;
	}
	

	/**
	 * Column Info
	 * @param sn2
	 */
	public void setSn2(String sn2) {
		this.sn2 = sn2;
	}
	
	/**
	 * Column Info
	 * @param sn1
	 */
	public void setSn1(String sn1) {
		this.sn1 = sn1;
	}
	
	/**
	 * Column Info
	 * @param sn4
	 */
	public void setSn4(String sn4) {
		this.sn4 = sn4;
	}
	
	/**
	 * Column Info
	 * @param sn3
	 */
	public void setSn3(String sn3) {
		this.sn3 = sn3;
	}
	
	/**
	 * Column Info
	 * @param ig1
	 */
	public void setIg1(String ig1) {
		this.ig1 = ig1;
	}
	
	/**
	 * Column Info
	 * @param ig2
	 */
	public void setIg2(String ig2) {
		this.ig2 = ig2;
	}
	
	/**
	 * Column Info
	 * @param ig3
	 */
	public void setIg3(String ig3) {
		this.ig3 = ig3;
	}
	
	/**
	 * Column Info
	 * @param ig4
	 */
	public void setIg4(String ig4) {
		this.ig4 = ig4;
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
	 * @param ofh3
	 */
	public void setOfh3(String ofh3) {
		this.ofh3 = ofh3;
	}
	
	/**
	 * Column Info
	 * @param ofh4
	 */
	public void setOfh4(String ofh4) {
		this.ofh4 = ofh4;
	}
	
	/**
	 * Column Info
	 * @param ofh1
	 */
	public void setOfh1(String ofh1) {
		this.ofh1 = ofh1;
	}
	
	/**
	 * Column Info
	 * @param ofh2
	 */
	public void setOfh2(String ofh2) {
		this.ofh2 = ofh2;
	}
	
	/**
	 * Column Info
	 * @param rtn4
	 */
	public void setRtn4(String rtn4) {
		this.rtn4 = rtn4;
	}
	
	/**
	 * Column Info
	 * @param ri3
	 */
	public void setRi3(String ri3) {
		this.ri3 = ri3;
	}
	
	/**
	 * Column Info
	 * @param ri4
	 */
	public void setRi4(String ri4) {
		this.ri4 = ri4;
	}
	
	/**
	 * Column Info
	 * @param rtn3
	 */
	public void setRtn3(String rtn3) {
		this.rtn3 = rtn3;
	}
	
	/**
	 * Column Info
	 * @param ri1
	 */
	public void setRi1(String ri1) {
		this.ri1 = ri1;
	}
	
	/**
	 * Column Info
	 * @param rtn2
	 */
	public void setRtn2(String rtn2) {
		this.rtn2 = rtn2;
	}
	
	/**
	 * Column Info
	 * @param ri2
	 */
	public void setRi2(String ri2) {
		this.ri2 = ri2;
	}
	
	/**
	 * Column Info
	 * @param rtn1
	 */
	public void setRtn1(String rtn1) {
		this.rtn1 = rtn1;
	}
	
	/**
	 * Column Info
	 * @param dg3
	 */
	public void setDg3(String dg3) {
		this.dg3 = dg3;
	}
	
	/**
	 * Column Info
	 * @param dg4
	 */
	public void setDg4(String dg4) {
		this.dg4 = dg4;
	}
	
	/**
	 * Column Info
	 * @param pup3
	 */
	public void setPup3(String pup3) {
		this.pup3 = pup3;
	}
	
	/**
	 * Column Info
	 * @param pup4
	 */
	public void setPup4(String pup4) {
		this.pup4 = pup4;
	}
	
	/**
	 * Column Info
	 * @param pup1
	 */
	public void setPup1(String pup1) {
		this.pup1 = pup1;
	}
	
	/**
	 * Column Info
	 * @param onh4
	 */
	public void setOnh4(String onh4) {
		this.onh4 = onh4;
	}
	
	/**
	 * Column Info
	 * @param onh3
	 */
	public void setOnh3(String onh3) {
		this.onh3 = onh3;
	}
	
	/**
	 * Column Info
	 * @param pup2
	 */
	public void setPup2(String pup2) {
		this.pup2 = pup2;
	}
	
	/**
	 * Column Info
	 * @param onh2
	 */
	public void setOnh2(String onh2) {
		this.onh2 = onh2;
	}
	
	/**
	 * Column Info
	 * @param onh1
	 */
	public void setOnh1(String onh1) {
		this.onh1 = onh1;
	}
	
	/**
	 * Column Info
	 * @param locLevel
	 */
	public void setLocLevel(String locLevel) {
		this.locLevel = locLevel;
	}
	
	/**
	 * Column Info
	 * @param fcastDt
	 */
	public void setFcastDt(String fcastDt) {
		this.fcastDt = fcastDt;
	}
	
	/**
	 * Column Info
	 * @param br3
	 */
	public void setBr3(String br3) {
		this.br3 = br3;
	}
	
	/**
	 * Column Info
	 * @param br2
	 */
	public void setBr2(String br2) {
		this.br2 = br2;
	}
	
	/**
	 * Column Info
	 * @param br1
	 */
	public void setBr1(String br1) {
		this.br1 = br1;
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
	 * @param br4
	 */
	public void setBr4(String br4) {
		this.br4 = br4;
	}
	
	/**
	 * Column Info
	 * @param dg2
	 */
	public void setDg2(String dg2) {
		this.dg2 = dg2;
	}
	
	/**
	 * Column Info
	 * @param dg1
	 */
	public void setDg1(String dg1) {
		this.dg1 = dg1;
	}
	
	/**
	 * Column Info
	 * @param avail3
	 */
	public void setAvail3(String avail3) {
		this.avail3 = avail3;
	}
	
	/**
	 * Column Info
	 * @param ro1
	 */
	public void setRo1(String ro1) {
		this.ro1 = ro1;
	}
	
	/**
	 * Column Info
	 * @param avail2
	 */
	public void setAvail2(String avail2) {
		this.avail2 = avail2;
	}
	
	/**
	 * Column Info
	 * @param avail1
	 */
	public void setAvail1(String avail1) {
		this.avail1 = avail1;
	}
	
	/**
	 * Column Info
	 * @param ro2
	 */
	public void setRo2(String ro2) {
		this.ro2 = ro2;
	}
	
	/**
	 * Column Info
	 * @param ro3
	 */
	public void setRo3(String ro3) {
		this.ro3 = ro3;
	}
	
	/**
	 * Column Info
	 * @param sccYdCd
	 */
	public void setSccYdCd(String sccYdCd) {
		this.sccYdCd = sccYdCd;
	}
	
	/**
	 * Column Info
	 * @param ro4
	 */
	public void setRo4(String ro4) {
		this.ro4 = ro4;
	}
	
	/**
	 * Column Info
	 * @param ea2
	 */
	public void setEa2(String ea2) {
		this.ea2 = ea2;
	}
	
	/**
	 * Column Info
	 * @param ea3
	 */
	public void setEa3(String ea3) {
		this.ea3 = ea3;
	}
	
	/**
	 * Column Info
	 * @param ea1
	 */
	public void setEa1(String ea1) {
		this.ea1 = ea1;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param avail14
	 */
	public void setAvail14(String avail14) {
		this.avail14 = avail14;
	}
	
	/**
	 * Column Info
	 * @param ea4
	 */
	public void setEa4(String ea4) {
		this.ea4 = ea4;
	}
	
	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
	 
	 /**
	* Column Info
	* @param  TpCd
	*/
	public void	setTpCd( String	tpCd ) {
		this.tpCd =	tpCd;
	}
 
	/**
	 * Column Info
	 * @return	TpCd
	 */
	 public	 String	getTpCd() {
		 return	this.tpCd;
	 } 
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSn2(JSPUtil.getParameter(request, "sn2", ""));
		setSn1(JSPUtil.getParameter(request, "sn1", ""));
		setSn4(JSPUtil.getParameter(request, "sn4", ""));
		setSn3(JSPUtil.getParameter(request, "sn3", ""));
		setIg1(JSPUtil.getParameter(request, "ig1", ""));
		setIg2(JSPUtil.getParameter(request, "ig2", ""));
		setIg3(JSPUtil.getParameter(request, "ig3", ""));
		setIg4(JSPUtil.getParameter(request, "ig4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfh3(JSPUtil.getParameter(request, "ofh3", ""));
		setOfh4(JSPUtil.getParameter(request, "ofh4", ""));
		setOfh1(JSPUtil.getParameter(request, "ofh1", ""));
		setOfh2(JSPUtil.getParameter(request, "ofh2", ""));
		setRtn4(JSPUtil.getParameter(request, "rtn4", ""));
		setRi3(JSPUtil.getParameter(request, "ri3", ""));
		setRi4(JSPUtil.getParameter(request, "ri4", ""));
		setRtn3(JSPUtil.getParameter(request, "rtn3", ""));
		setRi1(JSPUtil.getParameter(request, "ri1", ""));
		setRtn2(JSPUtil.getParameter(request, "rtn2", ""));
		setRi2(JSPUtil.getParameter(request, "ri2", ""));
		setRtn1(JSPUtil.getParameter(request, "rtn1", ""));
		setDg3(JSPUtil.getParameter(request, "dg3", ""));
		setDg4(JSPUtil.getParameter(request, "dg4", ""));
		setPup3(JSPUtil.getParameter(request, "pup3", ""));
		setPup4(JSPUtil.getParameter(request, "pup4", ""));
		setPup1(JSPUtil.getParameter(request, "pup1", ""));
		setOnh4(JSPUtil.getParameter(request, "onh4", ""));
		setOnh3(JSPUtil.getParameter(request, "onh3", ""));
		setPup2(JSPUtil.getParameter(request, "pup2", ""));
		setOnh2(JSPUtil.getParameter(request, "onh2", ""));
		setOnh1(JSPUtil.getParameter(request, "onh1", ""));
		setLocLevel(JSPUtil.getParameter(request, "loc_level", ""));
		setFcastDt(JSPUtil.getParameter(request, "fcast_dt", ""));
		setBr3(JSPUtil.getParameter(request, "br3", ""));
		setBr2(JSPUtil.getParameter(request, "br2", ""));
		setBr1(JSPUtil.getParameter(request, "br1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBr4(JSPUtil.getParameter(request, "br4", ""));
		setDg2(JSPUtil.getParameter(request, "dg2", ""));
		setDg1(JSPUtil.getParameter(request, "dg1", ""));
		setAvail3(JSPUtil.getParameter(request, "avail3", ""));
		setRo1(JSPUtil.getParameter(request, "ro1", ""));
		setAvail2(JSPUtil.getParameter(request, "avail2", ""));
		setAvail1(JSPUtil.getParameter(request, "avail1", ""));
		setRo2(JSPUtil.getParameter(request, "ro2", ""));
		setRo3(JSPUtil.getParameter(request, "ro3", ""));
		setSccYdCd(JSPUtil.getParameter(request, "scc_yd_cd", ""));
		setRo4(JSPUtil.getParameter(request, "ro4", ""));
		setEa2(JSPUtil.getParameter(request, "ea2", ""));
		setEa3(JSPUtil.getParameter(request, "ea3", ""));
		setEa1(JSPUtil.getParameter(request, "ea1", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setAvail14(JSPUtil.getParameter(request, "avail14", ""));
		setEa4(JSPUtil.getParameter(request, "ea4", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	 "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request,	 "tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailListVO[]
	 */
	public AvailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvailListVO[]
	 */
	public AvailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sn2 = (JSPUtil.getParameter(request, prefix	+ "sn2", length));
			String[] sn1 = (JSPUtil.getParameter(request, prefix	+ "sn1", length));
			String[] sn4 = (JSPUtil.getParameter(request, prefix	+ "sn4", length));
			String[] sn3 = (JSPUtil.getParameter(request, prefix	+ "sn3", length));
			String[] ig1 = (JSPUtil.getParameter(request, prefix	+ "ig1", length));
			String[] ig2 = (JSPUtil.getParameter(request, prefix	+ "ig2", length));
			String[] ig3 = (JSPUtil.getParameter(request, prefix	+ "ig3", length));
			String[] ig4 = (JSPUtil.getParameter(request, prefix	+ "ig4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofh3 = (JSPUtil.getParameter(request, prefix	+ "ofh3", length));
			String[] ofh4 = (JSPUtil.getParameter(request, prefix	+ "ofh4", length));
			String[] ofh1 = (JSPUtil.getParameter(request, prefix	+ "ofh1", length));
			String[] ofh2 = (JSPUtil.getParameter(request, prefix	+ "ofh2", length));
			String[] rtn4 = (JSPUtil.getParameter(request, prefix	+ "rtn4", length));
			String[] ri3 = (JSPUtil.getParameter(request, prefix	+ "ri3", length));
			String[] ri4 = (JSPUtil.getParameter(request, prefix	+ "ri4", length));
			String[] rtn3 = (JSPUtil.getParameter(request, prefix	+ "rtn3", length));
			String[] ri1 = (JSPUtil.getParameter(request, prefix	+ "ri1", length));
			String[] rtn2 = (JSPUtil.getParameter(request, prefix	+ "rtn2", length));
			String[] ri2 = (JSPUtil.getParameter(request, prefix	+ "ri2", length));
			String[] rtn1 = (JSPUtil.getParameter(request, prefix	+ "rtn1", length));
			String[] dg3 = (JSPUtil.getParameter(request, prefix	+ "dg3", length));
			String[] dg4 = (JSPUtil.getParameter(request, prefix	+ "dg4", length));
			String[] pup3 = (JSPUtil.getParameter(request, prefix	+ "pup3", length));
			String[] pup4 = (JSPUtil.getParameter(request, prefix	+ "pup4", length));
			String[] pup1 = (JSPUtil.getParameter(request, prefix	+ "pup1", length));
			String[] onh4 = (JSPUtil.getParameter(request, prefix	+ "onh4", length));
			String[] onh3 = (JSPUtil.getParameter(request, prefix	+ "onh3", length));
			String[] pup2 = (JSPUtil.getParameter(request, prefix	+ "pup2", length));
			String[] onh2 = (JSPUtil.getParameter(request, prefix	+ "onh2", length));
			String[] onh1 = (JSPUtil.getParameter(request, prefix	+ "onh1", length));
			String[] locLevel = (JSPUtil.getParameter(request, prefix	+ "loc_level", length));
			String[] fcastDt = (JSPUtil.getParameter(request, prefix	+ "fcast_dt", length));
			String[] br3 = (JSPUtil.getParameter(request, prefix	+ "br3", length));
			String[] br2 = (JSPUtil.getParameter(request, prefix	+ "br2", length));
			String[] br1 = (JSPUtil.getParameter(request, prefix	+ "br1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] br4 = (JSPUtil.getParameter(request, prefix	+ "br4", length));
			String[] dg2 = (JSPUtil.getParameter(request, prefix	+ "dg2", length));
			String[] dg1 = (JSPUtil.getParameter(request, prefix	+ "dg1", length));
			String[] avail3 = (JSPUtil.getParameter(request, prefix	+ "avail3", length));
			String[] ro1 = (JSPUtil.getParameter(request, prefix	+ "ro1", length));
			String[] avail2 = (JSPUtil.getParameter(request, prefix	+ "avail2", length));
			String[] avail1 = (JSPUtil.getParameter(request, prefix	+ "avail1", length));
			String[] ro2 = (JSPUtil.getParameter(request, prefix	+ "ro2", length));
			String[] ro3 = (JSPUtil.getParameter(request, prefix	+ "ro3", length));
			String[] sccYdCd = (JSPUtil.getParameter(request, prefix	+ "scc_yd_cd", length));
			String[] ro4 = (JSPUtil.getParameter(request, prefix	+ "ro4", length));
			String[] ea2 = (JSPUtil.getParameter(request, prefix	+ "ea2", length));
			String[] ea3 = (JSPUtil.getParameter(request, prefix	+ "ea3", length));
			String[] ea1 = (JSPUtil.getParameter(request, prefix	+ "ea1", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] avail14 = (JSPUtil.getParameter(request, prefix	+ "avail14", length));
			String[] ea4 = (JSPUtil.getParameter(request, prefix	+ "ea4", length));
			String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
			String[] tpCd =	(JSPUtil.getParameter(request, prefix +	"tp_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new AvailListVO();
				if (sn2[i] != null)
					model.setSn2(sn2[i]);
				if (sn1[i] != null)
					model.setSn1(sn1[i]);
				if (sn4[i] != null)
					model.setSn4(sn4[i]);
				if (sn3[i] != null)
					model.setSn3(sn3[i]);
				if (ig1[i] != null)
					model.setIg1(ig1[i]);
				if (ig2[i] != null)
					model.setIg2(ig2[i]);
				if (ig3[i] != null)
					model.setIg3(ig3[i]);
				if (ig4[i] != null)
					model.setIg4(ig4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofh3[i] != null)
					model.setOfh3(ofh3[i]);
				if (ofh4[i] != null)
					model.setOfh4(ofh4[i]);
				if (ofh1[i] != null)
					model.setOfh1(ofh1[i]);
				if (ofh2[i] != null)
					model.setOfh2(ofh2[i]);
				if (rtn4[i] != null)
					model.setRtn4(rtn4[i]);
				if (ri3[i] != null)
					model.setRi3(ri3[i]);
				if (ri4[i] != null)
					model.setRi4(ri4[i]);
				if (rtn3[i] != null)
					model.setRtn3(rtn3[i]);
				if (ri1[i] != null)
					model.setRi1(ri1[i]);
				if (rtn2[i] != null)
					model.setRtn2(rtn2[i]);
				if (ri2[i] != null)
					model.setRi2(ri2[i]);
				if (rtn1[i] != null)
					model.setRtn1(rtn1[i]);
				if (dg3[i] != null)
					model.setDg3(dg3[i]);
				if (dg4[i] != null)
					model.setDg4(dg4[i]);
				if (pup3[i] != null)
					model.setPup3(pup3[i]);
				if (pup4[i] != null)
					model.setPup4(pup4[i]);
				if (pup1[i] != null)
					model.setPup1(pup1[i]);
				if (onh4[i] != null)
					model.setOnh4(onh4[i]);
				if (onh3[i] != null)
					model.setOnh3(onh3[i]);
				if (pup2[i] != null)
					model.setPup2(pup2[i]);
				if (onh2[i] != null)
					model.setOnh2(onh2[i]);
				if (onh1[i] != null)
					model.setOnh1(onh1[i]);
				if (locLevel[i] != null)
					model.setLocLevel(locLevel[i]);
				if (fcastDt[i] != null)
					model.setFcastDt(fcastDt[i]);
				if (br3[i] != null)
					model.setBr3(br3[i]);
				if (br2[i] != null)
					model.setBr2(br2[i]);
				if (br1[i] != null)
					model.setBr1(br1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (br4[i] != null)
					model.setBr4(br4[i]);
				if (dg2[i] != null)
					model.setDg2(dg2[i]);
				if (dg1[i] != null)
					model.setDg1(dg1[i]);
				if (avail3[i] != null)
					model.setAvail3(avail3[i]);
				if (ro1[i] != null)
					model.setRo1(ro1[i]);
				if (avail2[i] != null)
					model.setAvail2(avail2[i]);
				if (avail1[i] != null)
					model.setAvail1(avail1[i]);
				if (ro2[i] != null)
					model.setRo2(ro2[i]);
				if (ro3[i] != null)
					model.setRo3(ro3[i]);
				if (sccYdCd[i] != null)
					model.setSccYdCd(sccYdCd[i]);
				if (ro4[i] != null)
					model.setRo4(ro4[i]);
				if (ea2[i] != null)
					model.setEa2(ea2[i]);
				if (ea3[i] != null)
					model.setEa3(ea3[i]);
				if (ea1[i] != null)
					model.setEa1(ea1[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (avail14[i] != null)
					model.setAvail14(avail14[i]);
				if (ea4[i] != null)
					model.setEa4(ea4[i]);
				if ( cntrTpszCd[i] !=	null)
					model.setCntrTpszCd( cntrTpszCd[i]);
				if ( tpCd[i] !=	null)
					model.setTpCd( tpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvailListVO[]
	 */
	public AvailListVO[] getAvailListVOs(){
		AvailListVO[] vos = (AvailListVO[])models.toArray(new AvailListVO[models.size()]);
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
		this.sn2 = this.sn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sn1 = this.sn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sn4 = this.sn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sn3 = this.sn3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ig1 = this.ig1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ig2 = this.ig2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ig3 = this.ig3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ig4 = this.ig4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofh3 = this.ofh3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofh4 = this.ofh4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofh1 = this.ofh1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofh2 = this.ofh2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtn4 = this.rtn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ri3 = this.ri3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ri4 = this.ri4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtn3 = this.rtn3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ri1 = this.ri1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtn2 = this.rtn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ri2 = this.ri2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtn1 = this.rtn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg3 = this.dg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4 = this.dg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pup3 = this.pup3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pup4 = this.pup4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pup1 = this.pup1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onh4 = this.onh4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onh3 = this.onh3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pup2 = this.pup2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onh2 = this.onh2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onh1 = this.onh1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLevel = this.locLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt = this.fcastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br3 = this.br3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br2 = this.br2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br1 = this.br1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br4 = this.br4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2 = this.dg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg1 = this.dg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avail3 = this.avail3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ro1 = this.ro1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avail2 = this.avail2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avail1 = this.avail1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ro2 = this.ro2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ro3 = this.ro3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccYdCd = this.sccYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ro4 = this.ro4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ea2 = this.ea2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ea3 = this.ea3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ea1 = this.ea1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avail14 = this.avail14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ea4 = this.ea4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd =	this.tpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
