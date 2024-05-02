/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MGSOnOffhireSummaryMGTVO.java
 *@FileTitle : MGSOnOffhireSummaryMGTVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class MGSOnOffhireSummaryMGTVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MGSOnOffhireSummaryMGTVO>  models =	new	ArrayList<MGSOnOffhireSummaryMGTVO>();


	/*	Column Info	*/
	private  String	 total   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 agreement   =  null;
	/*	Column Info	*/
	private  String	 stsEvntYdCd   =  null;
	/*	Column Info	*/
	private  String	 agmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 lccCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 sccCd   =  null;
	/*	Column Info	*/
	private  String	 clg   =  null;
	/*	Column Info	*/
	private  String	 stsEvntLocCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 umg   =  null;
	/*	Column Info	*/
	private  String	 stsEvntDt   =  null;
	/*	Column Info	*/
	private  String	 evntDt   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd1   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd2   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd3   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd5   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd6   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd7   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd8   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd9   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd10   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd11   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd12   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd13   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd14   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd15   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd16   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd17   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd18   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd19   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd20   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MGSOnOffhireSummaryMGTVO(){}

	public MGSOnOffhireSummaryMGTVO(String total,String updDt,String agreement,String stsEvntYdCd,String agmtLstmCd,String pagerows,String eqTpszCd,String lccCd,String ibflag,String eqNo,String sccCd,String clg,String stsEvntLocCd,String vndrSeq,String umg,String stsEvntDt,String evntDt,String eqTpszCd1,String eqTpszCd2,String eqTpszCd3,String eqTpszCd4,String eqTpszCd5,String eqTpszCd6,String eqTpszCd7,String eqTpszCd8,String eqTpszCd9,String eqTpszCd10,String eqTpszCd11,String eqTpszCd12,String eqTpszCd13,String eqTpszCd14,String eqTpszCd15,String eqTpszCd16,String eqTpszCd17,String eqTpszCd18,String eqTpszCd19,String eqTpszCd20)	{
		this.total  = total ;
		this.updDt  = updDt ;
		this.agreement  = agreement ;
		this.stsEvntYdCd  = stsEvntYdCd ;
		this.agmtLstmCd  = agmtLstmCd ;
		this.pagerows  = pagerows ;
		this.eqTpszCd  = eqTpszCd ;
		this.lccCd  = lccCd ;
		this.ibflag  = ibflag ;
		this.eqNo  = eqNo ;
		this.sccCd  = sccCd ;
		this.clg  = clg ;
		this.stsEvntLocCd  = stsEvntLocCd ;
		this.vndrSeq  = vndrSeq ;
		this.umg  = umg ;
		this.stsEvntDt  = stsEvntDt ;
		this.evntDt  = evntDt ;
		this.eqTpszCd1  = eqTpszCd1 ;
		this.eqTpszCd2  = eqTpszCd2 ;
		this.eqTpszCd3  = eqTpszCd3 ;
		this.eqTpszCd4  = eqTpszCd4 ;
		this.eqTpszCd5  = eqTpszCd5 ;
		this.eqTpszCd6  = eqTpszCd6 ;
		this.eqTpszCd7  = eqTpszCd7 ;
		this.eqTpszCd8  = eqTpszCd8 ;
		this.eqTpszCd9  = eqTpszCd9 ;
		this.eqTpszCd10  = eqTpszCd10 ;
		this.eqTpszCd11  = eqTpszCd11 ;
		this.eqTpszCd12  = eqTpszCd12 ;
		this.eqTpszCd13  = eqTpszCd13 ;
		this.eqTpszCd14  = eqTpszCd14 ;
		this.eqTpszCd15  = eqTpszCd15 ;
		this.eqTpszCd16  = eqTpszCd16 ;
		this.eqTpszCd17  = eqTpszCd17 ;
		this.eqTpszCd18  = eqTpszCd18 ;
		this.eqTpszCd19  = eqTpszCd19 ;
		this.eqTpszCd20  = eqTpszCd20 ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("agreement", getAgreement());		
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());		
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("lcc_cd", getLccCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_no", getEqNo());		
		this.hashColumns.put("scc_cd", getSccCd());		
		this.hashColumns.put("clg", getClg());		
		this.hashColumns.put("sts_evnt_loc_cd", getStsEvntLocCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("umg", getUmg());		
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());		
		this.hashColumns.put("evnt_dt", getEvntDt());		
		this.hashColumns.put("eq_tpsz_cd1", getEqTpszCd1());		
		this.hashColumns.put("eq_tpsz_cd2", getEqTpszCd2());		
		this.hashColumns.put("eq_tpsz_cd3", getEqTpszCd3());		
		this.hashColumns.put("eq_tpsz_cd4", getEqTpszCd4());		
		this.hashColumns.put("eq_tpsz_cd5", getEqTpszCd5());		
		this.hashColumns.put("eq_tpsz_cd6", getEqTpszCd6());		
		this.hashColumns.put("eq_tpsz_cd7", getEqTpszCd7());		
		this.hashColumns.put("eq_tpsz_cd8", getEqTpszCd8());		
		this.hashColumns.put("eq_tpsz_cd9", getEqTpszCd9());		
		this.hashColumns.put("eq_tpsz_cd10", getEqTpszCd10());		
		this.hashColumns.put("eq_tpsz_cd11", getEqTpszCd11());		
		this.hashColumns.put("eq_tpsz_cd12", getEqTpszCd12());		
		this.hashColumns.put("eq_tpsz_cd13", getEqTpszCd13());		
		this.hashColumns.put("eq_tpsz_cd14", getEqTpszCd14());		
		this.hashColumns.put("eq_tpsz_cd15", getEqTpszCd15());		
		this.hashColumns.put("eq_tpsz_cd16", getEqTpszCd16());		
		this.hashColumns.put("eq_tpsz_cd17", getEqTpszCd17());		
		this.hashColumns.put("eq_tpsz_cd18", getEqTpszCd18());		
		this.hashColumns.put("eq_tpsz_cd19", getEqTpszCd19());		
		this.hashColumns.put("eq_tpsz_cd20", getEqTpszCd20());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agreement", "agreement");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("clg", "clg");
		this.hashFields.put("sts_evnt_loc_cd", "stsEvntLocCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("umg", "umg");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("eq_tpsz_cd1", "eqTpszCd1");
		this.hashFields.put("eq_tpsz_cd2", "eqTpszCd2");
		this.hashFields.put("eq_tpsz_cd3", "eqTpszCd3");
		this.hashFields.put("eq_tpsz_cd4", "eqTpszCd4");
		this.hashFields.put("eq_tpsz_cd5", "eqTpszCd5");
		this.hashFields.put("eq_tpsz_cd6", "eqTpszCd6");
		this.hashFields.put("eq_tpsz_cd7", "eqTpszCd7");
		this.hashFields.put("eq_tpsz_cd8", "eqTpszCd8");
		this.hashFields.put("eq_tpsz_cd9", "eqTpszCd9");
		this.hashFields.put("eq_tpsz_cd10", "eqTpszCd10");
		this.hashFields.put("eq_tpsz_cd11", "eqTpszCd11");
		this.hashFields.put("eq_tpsz_cd12", "eqTpszCd12");
		this.hashFields.put("eq_tpsz_cd13", "eqTpszCd13");
		this.hashFields.put("eq_tpsz_cd14", "eqTpszCd14");
		this.hashFields.put("eq_tpsz_cd15", "eqTpszCd15");
		this.hashFields.put("eq_tpsz_cd16", "eqTpszCd16");
		this.hashFields.put("eq_tpsz_cd17", "eqTpszCd17");
		this.hashFields.put("eq_tpsz_cd18", "eqTpszCd18");
		this.hashFields.put("eq_tpsz_cd19", "eqTpszCd19");
		this.hashFields.put("eq_tpsz_cd20", "eqTpszCd20");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  total
	*/
	public void	setTotal( String	total ) {
		this.total =	total;
	}
 
	/**
	 * Column Info
	 * @return	total
	 */
	 public	 String	getTotal() {
		 return	this.total;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  agreement
	*/
	public void	setAgreement( String	agreement ) {
		this.agreement =	agreement;
	}
 
	/**
	 * Column Info
	 * @return	agreement
	 */
	 public	 String	getAgreement() {
		 return	this.agreement;
	 } 
 	/**
	* Column Info
	* @param  stsEvntYdCd
	*/
	public void	setStsEvntYdCd( String	stsEvntYdCd ) {
		this.stsEvntYdCd =	stsEvntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntYdCd
	 */
	 public	 String	getStsEvntYdCd() {
		 return	this.stsEvntYdCd;
	 } 
 	/**
	* Column Info
	* @param  agmtLstmCd
	*/
	public void	setAgmtLstmCd( String	agmtLstmCd ) {
		this.agmtLstmCd =	agmtLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtLstmCd
	 */
	 public	 String	getAgmtLstmCd() {
		 return	this.agmtLstmCd;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
	 } 
 	/**
	* Column Info
	* @param  lccCd
	*/
	public void	setLccCd( String	lccCd ) {
		this.lccCd =	lccCd;
	}
 
	/**
	 * Column Info
	 * @return	lccCd
	 */
	 public	 String	getLccCd() {
		 return	this.lccCd;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  eqNo
	*/
	public void	setEqNo( String	eqNo ) {
		this.eqNo =	eqNo;
	}
 
	/**
	 * Column Info
	 * @return	eqNo
	 */
	 public	 String	getEqNo() {
		 return	this.eqNo;
	 } 
 	/**
	* Column Info
	* @param  sccCd
	*/
	public void	setSccCd( String	sccCd ) {
		this.sccCd =	sccCd;
	}
 
	/**
	 * Column Info
	 * @return	sccCd
	 */
	 public	 String	getSccCd() {
		 return	this.sccCd;
	 } 
 	/**
	* Column Info
	* @param  clg
	*/
	public void	setClg( String	clg ) {
		this.clg =	clg;
	}
 
	/**
	 * Column Info
	 * @return	clg
	 */
	 public	 String	getClg() {
		 return	this.clg;
	 } 
 	/**
	* Column Info
	* @param  stsEvntLocCd
	*/
	public void	setStsEvntLocCd( String	stsEvntLocCd ) {
		this.stsEvntLocCd =	stsEvntLocCd;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntLocCd
	 */
	 public	 String	getStsEvntLocCd() {
		 return	this.stsEvntLocCd;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  umg
	*/
	public void	setUmg( String	umg ) {
		this.umg =	umg;
	}
 
	/**
	 * Column Info
	 * @return	umg
	 */
	 public	 String	getUmg() {
		 return	this.umg;
	 } 
 	/**
	* Column Info
	* @param  stsEvntDt
	*/
	public void	setStsEvntDt( String	stsEvntDt ) {
		this.stsEvntDt =	stsEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntDt
	 */
	 public	 String	getStsEvntDt() {
		 return	this.stsEvntDt;
	 } 
 	/**
	* Column Info
	* @param  evntDt
	*/
	public void	setEvntDt( String	evntDt ) {
		this.evntDt =	evntDt;
	}
 
	/**
	 * Column Info
	 * @return	evntDt
	 */
	 public	 String	getEvntDt() {
		 return	this.evntDt;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd1
	*/
	public void	setEqTpszCd1( String	eqTpszCd1 ) {
		this.eqTpszCd1 =	eqTpszCd1;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd1
	 */
	 public	 String	getEqTpszCd1() {
		 return	this.eqTpszCd1;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd2
	*/
	public void	setEqTpszCd2( String	eqTpszCd2 ) {
		this.eqTpszCd2 =	eqTpszCd2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd2
	 */
	 public	 String	getEqTpszCd2() {
		 return	this.eqTpszCd2;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd3
	*/
	public void	setEqTpszCd3( String	eqTpszCd3 ) {
		this.eqTpszCd3 =	eqTpszCd3;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd3
	 */
	 public	 String	getEqTpszCd3() {
		 return	this.eqTpszCd3;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd4
	*/
	public void	setEqTpszCd4( String	eqTpszCd4 ) {
		this.eqTpszCd4 =	eqTpszCd4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd4
	 */
	 public	 String	getEqTpszCd4() {
		 return	this.eqTpszCd4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd5
	*/
	public void	setEqTpszCd5( String	eqTpszCd5 ) {
		this.eqTpszCd5 =	eqTpszCd5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd5
	 */
	 public	 String	getEqTpszCd5() {
		 return	this.eqTpszCd5;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd6
	*/
	public void	setEqTpszCd6( String	eqTpszCd6 ) {
		this.eqTpszCd6 =	eqTpszCd6;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd6
	 */
	 public	 String	getEqTpszCd6() {
		 return	this.eqTpszCd6;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd7
	*/
	public void	setEqTpszCd7( String	eqTpszCd7 ) {
		this.eqTpszCd7 =	eqTpszCd7;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd7
	 */
	 public	 String	getEqTpszCd7() {
		 return	this.eqTpszCd7;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd8
	*/
	public void	setEqTpszCd8( String	eqTpszCd8 ) {
		this.eqTpszCd8 =	eqTpszCd8;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd8
	 */
	 public	 String	getEqTpszCd8() {
		 return	this.eqTpszCd8;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd9
	*/
	public void	setEqTpszCd9( String	eqTpszCd9 ) {
		this.eqTpszCd9 =	eqTpszCd9;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd9
	 */
	 public	 String	getEqTpszCd9() {
		 return	this.eqTpszCd9;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd10
	*/
	public void	setEqTpszCd10( String	eqTpszCd10 ) {
		this.eqTpszCd10 =	eqTpszCd10;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd10
	 */
	 public	 String	getEqTpszCd10() {
		 return	this.eqTpszCd10;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd11
	*/
	public void	setEqTpszCd11( String	eqTpszCd11 ) {
		this.eqTpszCd11 =	eqTpszCd11;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd11
	 */
	 public	 String	getEqTpszCd11() {
		 return	this.eqTpszCd11;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd12
	*/
	public void	setEqTpszCd12( String	eqTpszCd12 ) {
		this.eqTpszCd12 =	eqTpszCd12;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd12
	 */
	 public	 String	getEqTpszCd12() {
		 return	this.eqTpszCd12;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd13
	*/
	public void	setEqTpszCd13( String	eqTpszCd13 ) {
		this.eqTpszCd13 =	eqTpszCd13;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd13
	 */
	 public	 String	getEqTpszCd13() {
		 return	this.eqTpszCd13;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd14
	*/
	public void	setEqTpszCd14( String	eqTpszCd14 ) {
		this.eqTpszCd14 =	eqTpszCd14;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd14
	 */
	 public	 String	getEqTpszCd14() {
		 return	this.eqTpszCd14;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd15
	*/
	public void	setEqTpszCd15( String	eqTpszCd15 ) {
		this.eqTpszCd15 =	eqTpszCd15;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd15
	 */
	 public	 String	getEqTpszCd15() {
		 return	this.eqTpszCd15;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd16
	*/
	public void	setEqTpszCd16( String	eqTpszCd16 ) {
		this.eqTpszCd16 =	eqTpszCd16;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd16
	 */
	 public	 String	getEqTpszCd16() {
		 return	this.eqTpszCd16;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd17
	*/
	public void	setEqTpszCd17( String	eqTpszCd17 ) {
		this.eqTpszCd17 =	eqTpszCd17;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd17
	 */
	 public	 String	getEqTpszCd17() {
		 return	this.eqTpszCd17;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd18
	*/
	public void	setEqTpszCd18( String	eqTpszCd18 ) {
		this.eqTpszCd18 =	eqTpszCd18;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd18
	 */
	 public	 String	getEqTpszCd18() {
		 return	this.eqTpszCd18;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd19
	*/
	public void	setEqTpszCd19( String	eqTpszCd19 ) {
		this.eqTpszCd19 =	eqTpszCd19;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd19
	 */
	 public	 String	getEqTpszCd19() {
		 return	this.eqTpszCd19;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd20
	*/
	public void	setEqTpszCd20( String	eqTpszCd20 ) {
		this.eqTpszCd20 =	eqTpszCd20;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd20
	 */
	 public	 String	getEqTpszCd20() {
		 return	this.eqTpszCd20;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setTotal(JSPUtil.getParameter(request,	prefix + "total", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setAgreement(JSPUtil.getParameter(request,	prefix + "agreement", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request,	prefix + "sts_evnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "agmt_lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setLccCd(JSPUtil.getParameter(request,	prefix + "lcc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setSccCd(JSPUtil.getParameter(request,	prefix + "scc_cd", ""));
		setClg(JSPUtil.getParameter(request,	prefix + "clg", ""));
		setStsEvntLocCd(JSPUtil.getParameter(request,	prefix + "sts_evnt_loc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setUmg(JSPUtil.getParameter(request,	prefix + "umg", ""));
		setStsEvntDt(JSPUtil.getParameter(request,	prefix + "sts_evnt_dt", ""));
		setEvntDt(JSPUtil.getParameter(request,	prefix + "evnt_dt", ""));
		setEqTpszCd1(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd1", ""));
		setEqTpszCd2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd2", ""));
		setEqTpszCd3(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd3", ""));
		setEqTpszCd4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd4", ""));
		setEqTpszCd5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd5", ""));
		setEqTpszCd6(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd6", ""));
		setEqTpszCd7(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd7", ""));
		setEqTpszCd8(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd8", ""));
		setEqTpszCd9(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd9", ""));
		setEqTpszCd10(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd10", ""));
		setEqTpszCd11(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd11", ""));
		setEqTpszCd12(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd12", ""));
		setEqTpszCd13(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd13", ""));
		setEqTpszCd14(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd14", ""));
		setEqTpszCd15(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd15", ""));
		setEqTpszCd16(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd16", ""));
		setEqTpszCd17(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd17", ""));
		setEqTpszCd18(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd18", ""));
		setEqTpszCd19(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd19", ""));
		setEqTpszCd20(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd20", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSOnOffhireSummaryMGTVO[]
	 */
	public MGSOnOffhireSummaryMGTVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MGSOnOffhireSummaryMGTVO[]
	 */
	public MGSOnOffhireSummaryMGTVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MGSOnOffhireSummaryMGTVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] total =	(JSPUtil.getParameter(request, prefix +	"total".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] agreement =	(JSPUtil.getParameter(request, prefix +	"agreement".trim(),	length));
				String[] stsEvntYdCd =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_yd_cd".trim(),	length));
				String[] agmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_lstm_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] lccCd =	(JSPUtil.getParameter(request, prefix +	"lcc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] sccCd =	(JSPUtil.getParameter(request, prefix +	"scc_cd".trim(),	length));
				String[] clg =	(JSPUtil.getParameter(request, prefix +	"clg".trim(),	length));
				String[] stsEvntLocCd =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_loc_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] umg =	(JSPUtil.getParameter(request, prefix +	"umg".trim(),	length));
				String[] stsEvntDt =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_dt".trim(),	length));
				String[] evntDt =	(JSPUtil.getParameter(request, prefix +	"evnt_dt".trim(),	length));
				String[] eqTpszCd1 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd1".trim(),	length));
				String[] eqTpszCd2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd2".trim(),	length));
				String[] eqTpszCd3 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd3".trim(),	length));
				String[] eqTpszCd4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd4".trim(),	length));
				String[] eqTpszCd5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd5".trim(),	length));
				String[] eqTpszCd6 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd6".trim(),	length));
				String[] eqTpszCd7 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd7".trim(),	length));
				String[] eqTpszCd8 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd8".trim(),	length));
				String[] eqTpszCd9 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd9".trim(),	length));
				String[] eqTpszCd10 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd10".trim(),	length));
				String[] eqTpszCd11 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd11".trim(),	length));
				String[] eqTpszCd12 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd12".trim(),	length));
				String[] eqTpszCd13 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd13".trim(),	length));
				String[] eqTpszCd14 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd14".trim(),	length));
				String[] eqTpszCd15 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd15".trim(),	length));
				String[] eqTpszCd16 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd16".trim(),	length));
				String[] eqTpszCd17 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd17".trim(),	length));
				String[] eqTpszCd18 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd18".trim(),	length));
				String[] eqTpszCd19 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd19".trim(),	length));
				String[] eqTpszCd20 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd20".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MGSOnOffhireSummaryMGTVO();
						if ( total[i] !=	null)
						model.setTotal( total[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( agreement[i] !=	null)
						model.setAgreement( agreement[i]);
						if ( stsEvntYdCd[i] !=	null)
						model.setStsEvntYdCd( stsEvntYdCd[i]);
						if ( agmtLstmCd[i] !=	null)
						model.setAgmtLstmCd( agmtLstmCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( lccCd[i] !=	null)
						model.setLccCd( lccCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( sccCd[i] !=	null)
						model.setSccCd( sccCd[i]);
						if ( clg[i] !=	null)
						model.setClg( clg[i]);
						if ( stsEvntLocCd[i] !=	null)
						model.setStsEvntLocCd( stsEvntLocCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( umg[i] !=	null)
						model.setUmg( umg[i]);
						if ( stsEvntDt[i] !=	null)
						model.setStsEvntDt( stsEvntDt[i]);
						if ( evntDt[i] !=	null)
						model.setEvntDt( evntDt[i]);
						if ( eqTpszCd1[i] !=	null)
						model.setEqTpszCd1( eqTpszCd1[i]);
						if ( eqTpszCd2[i] !=	null)
						model.setEqTpszCd2( eqTpszCd2[i]);
						if ( eqTpszCd3[i] !=	null)
						model.setEqTpszCd3( eqTpszCd3[i]);
						if ( eqTpszCd4[i] !=	null)
						model.setEqTpszCd4( eqTpszCd4[i]);
						if ( eqTpszCd5[i] !=	null)
						model.setEqTpszCd5( eqTpszCd5[i]);
						if ( eqTpszCd6[i] !=	null)
						model.setEqTpszCd6( eqTpszCd6[i]);
						if ( eqTpszCd7[i] !=	null)
						model.setEqTpszCd7( eqTpszCd7[i]);
						if ( eqTpszCd8[i] !=	null)
						model.setEqTpszCd8( eqTpszCd8[i]);
						if ( eqTpszCd9[i] !=	null)
						model.setEqTpszCd9( eqTpszCd9[i]);
						if ( eqTpszCd10[i] !=	null)
						model.setEqTpszCd10( eqTpszCd10[i]);
						if ( eqTpszCd11[i] !=	null)
						model.setEqTpszCd11( eqTpszCd11[i]);
						if ( eqTpszCd12[i] !=	null)
						model.setEqTpszCd12( eqTpszCd12[i]);
						if ( eqTpszCd13[i] !=	null)
						model.setEqTpszCd13( eqTpszCd13[i]);
						if ( eqTpszCd14[i] !=	null)
						model.setEqTpszCd14( eqTpszCd14[i]);
						if ( eqTpszCd15[i] !=	null)
						model.setEqTpszCd15( eqTpszCd15[i]);
						if ( eqTpszCd16[i] !=	null)
						model.setEqTpszCd16( eqTpszCd16[i]);
						if ( eqTpszCd17[i] !=	null)
						model.setEqTpszCd17( eqTpszCd17[i]);
						if ( eqTpszCd18[i] !=	null)
						model.setEqTpszCd18( eqTpszCd18[i]);
						if ( eqTpszCd19[i] !=	null)
						model.setEqTpszCd19( eqTpszCd19[i]);
						if ( eqTpszCd20[i] !=	null)
						model.setEqTpszCd20( eqTpszCd20[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMGSOnOffhireSummaryMGTVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MGSOnOffhireSummaryMGTVO[]
	 */
	public MGSOnOffhireSummaryMGTVO[]	 getMGSOnOffhireSummaryMGTVOs(){
		MGSOnOffhireSummaryMGTVO[] vos = (MGSOnOffhireSummaryMGTVO[])models.toArray(new	MGSOnOffhireSummaryMGTVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.total =	this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreement =	this.agreement.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd =	this.stsEvntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd =	this.agmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd =	this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd =	this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clg =	this.clg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntLocCd =	this.stsEvntLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umg =	this.umg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt =	this.stsEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt =	this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd1 =	this.eqTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd2 =	this.eqTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd3 =	this.eqTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd4 =	this.eqTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd5 =	this.eqTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd6 =	this.eqTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd7 =	this.eqTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd8 =	this.eqTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd9 =	this.eqTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd10 =	this.eqTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd11 =	this.eqTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd12 =	this.eqTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd13 =	this.eqTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd14 =	this.eqTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd15 =	this.eqTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd16 =	this.eqTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd17 =	this.eqTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd18 =	this.eqTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd19 =	this.eqTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd20 =	this.eqTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}