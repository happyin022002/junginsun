/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CHSTermChangeResultMGTVO.java
 *@FileTitle : CHSTermChangeResultMGTVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.19  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
public class CHSTermChangeResultMGTVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CHSTermChangeResultMGTVO>  models =	new	ArrayList<CHSTermChangeResultMGTVO>();


	/*	Column Info	*/
	private  String	 stsEvntOfcCd   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSf4   =  null;
	/*	Column Info	*/
	private  String	 stsEvntDtFr   =  null;
	/*	Column Info	*/
	private  String	 newAgmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdCb4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSl2   =  null;
	/*	Column Info	*/
	private  String	 newAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 viewflg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdEg8   =  null;
	/*	Column Info	*/
	private  String	 newVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdZt4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdGn4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdTa2   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdGn5   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdEg5   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 stsEvntDtTo   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSf2   =  null;
	/*	Column Info	*/
	private  String	 oldVndrSeq   =  null;
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
	public CHSTermChangeResultMGTVO(){}

	public CHSTermChangeResultMGTVO(String stsEvntOfcCd,String eqTpszCdSf4,String stsEvntDtFr,String newAgmtLstmCd,String oldAgmtLstmCd,String eqTpszCdCb4,String eqTpszCdSl2,String newAgmtNo,String eqKndCd,String viewflg,String pagerows,String ibflag,String eqTpszCdEg8,String newVndrSeq,String eqTpszCdZt4,String eqTpszCdGn4,String eqTpszCdTa2,String eqTpszCdGn5,String eqTpszCdEg5,String vndrSeq,String oldAgmtNo,String stsEvntDtTo,String eqTpszCdSf2,String oldVndrSeq,String eqTpszCd1,String eqTpszCd2,String eqTpszCd3,String eqTpszCd4,String eqTpszCd5,String eqTpszCd6,String eqTpszCd7,String eqTpszCd8,String eqTpszCd9,String eqTpszCd10,String eqTpszCd11,String eqTpszCd12,String eqTpszCd13,String eqTpszCd14,String eqTpszCd15,String eqTpszCd16,String eqTpszCd17,String eqTpszCd18,String eqTpszCd19,String eqTpszCd20)	{
		this.stsEvntOfcCd  = stsEvntOfcCd ;
		this.eqTpszCdSf4  = eqTpszCdSf4 ;
		this.stsEvntDtFr  = stsEvntDtFr ;
		this.newAgmtLstmCd  = newAgmtLstmCd ;
		this.oldAgmtLstmCd  = oldAgmtLstmCd ;
		this.eqTpszCdCb4  = eqTpszCdCb4 ;
		this.eqTpszCdSl2  = eqTpszCdSl2 ;
		this.newAgmtNo  = newAgmtNo ;
		this.eqKndCd  = eqKndCd ;
		this.viewflg  = viewflg ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.eqTpszCdEg8  = eqTpszCdEg8 ;
		this.newVndrSeq  = newVndrSeq ;
		this.eqTpszCdZt4  = eqTpszCdZt4 ;
		this.eqTpszCdGn4  = eqTpszCdGn4 ;
		this.eqTpszCdTa2  = eqTpszCdTa2 ;
		this.eqTpszCdGn5  = eqTpszCdGn5 ;
		this.eqTpszCdEg5  = eqTpszCdEg5 ;
		this.vndrSeq  = vndrSeq ;
		this.oldAgmtNo  = oldAgmtNo ;
		this.stsEvntDtTo  = stsEvntDtTo ;
		this.eqTpszCdSf2  = eqTpszCdSf2 ;
		this.oldVndrSeq  = oldVndrSeq ;
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
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());		
		this.hashColumns.put("eq_tpsz_cd_sf4", getEqTpszCdSf4());		
		this.hashColumns.put("sts_evnt_dt_fr", getStsEvntDtFr());		
		this.hashColumns.put("new_agmt_lstm_cd", getNewAgmtLstmCd());		
		this.hashColumns.put("old_agmt_lstm_cd", getOldAgmtLstmCd());		
		this.hashColumns.put("eq_tpsz_cd_cb4", getEqTpszCdCb4());		
		this.hashColumns.put("eq_tpsz_cd_sl2", getEqTpszCdSl2());		
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("viewflg", getViewflg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_tpsz_cd_eg8", getEqTpszCdEg8());		
		this.hashColumns.put("new_vndr_seq", getNewVndrSeq());		
		this.hashColumns.put("eq_tpsz_cd_zt4", getEqTpszCdZt4());		
		this.hashColumns.put("eq_tpsz_cd_gn4", getEqTpszCdGn4());		
		this.hashColumns.put("eq_tpsz_cd_ta2", getEqTpszCdTa2());		
		this.hashColumns.put("eq_tpsz_cd_gn5", getEqTpszCdGn5());		
		this.hashColumns.put("eq_tpsz_cd_eg5", getEqTpszCdEg5());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());		
		this.hashColumns.put("sts_evnt_dt_to", getStsEvntDtTo());		
		this.hashColumns.put("eq_tpsz_cd_sf2", getEqTpszCdSf2());		
		this.hashColumns.put("old_vndr_seq", getOldVndrSeq());		
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
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("eq_tpsz_cd_sf4", "eqTpszCdSf4");
		this.hashFields.put("sts_evnt_dt_fr", "stsEvntDtFr");
		this.hashFields.put("new_agmt_lstm_cd", "newAgmtLstmCd");
		this.hashFields.put("old_agmt_lstm_cd", "oldAgmtLstmCd");
		this.hashFields.put("eq_tpsz_cd_cb4", "eqTpszCdCb4");
		this.hashFields.put("eq_tpsz_cd_sl2", "eqTpszCdSl2");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("viewflg", "viewflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_eg8", "eqTpszCdEg8");
		this.hashFields.put("new_vndr_seq", "newVndrSeq");
		this.hashFields.put("eq_tpsz_cd_zt4", "eqTpszCdZt4");
		this.hashFields.put("eq_tpsz_cd_gn4", "eqTpszCdGn4");
		this.hashFields.put("eq_tpsz_cd_ta2", "eqTpszCdTa2");
		this.hashFields.put("eq_tpsz_cd_gn5", "eqTpszCdGn5");
		this.hashFields.put("eq_tpsz_cd_eg5", "eqTpszCdEg5");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("sts_evnt_dt_to", "stsEvntDtTo");
		this.hashFields.put("eq_tpsz_cd_sf2", "eqTpszCdSf2");
		this.hashFields.put("old_vndr_seq", "oldVndrSeq");
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
	* @param  stsEvntOfcCd
	*/
	public void	setStsEvntOfcCd( String	stsEvntOfcCd ) {
		this.stsEvntOfcCd =	stsEvntOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntOfcCd
	 */
	 public	 String	getStsEvntOfcCd() {
		 return	this.stsEvntOfcCd;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdSf4
	*/
	public void	setEqTpszCdSf4( String	eqTpszCdSf4 ) {
		this.eqTpszCdSf4 =	eqTpszCdSf4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSf4
	 */
	 public	 String	getEqTpszCdSf4() {
		 return	this.eqTpszCdSf4;
	 } 
 	/**
	* Column Info
	* @param  stsEvntDtFr
	*/
	public void	setStsEvntDtFr( String	stsEvntDtFr ) {
		this.stsEvntDtFr =	stsEvntDtFr;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntDtFr
	 */
	 public	 String	getStsEvntDtFr() {
		 return	this.stsEvntDtFr;
	 } 
 	/**
	* Column Info
	* @param  newAgmtLstmCd
	*/
	public void	setNewAgmtLstmCd( String	newAgmtLstmCd ) {
		this.newAgmtLstmCd =	newAgmtLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	newAgmtLstmCd
	 */
	 public	 String	getNewAgmtLstmCd() {
		 return	this.newAgmtLstmCd;
	 } 
 	/**
	* Column Info
	* @param  oldAgmtLstmCd
	*/
	public void	setOldAgmtLstmCd( String	oldAgmtLstmCd ) {
		this.oldAgmtLstmCd =	oldAgmtLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	oldAgmtLstmCd
	 */
	 public	 String	getOldAgmtLstmCd() {
		 return	this.oldAgmtLstmCd;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdCb4
	*/
	public void	setEqTpszCdCb4( String	eqTpszCdCb4 ) {
		this.eqTpszCdCb4 =	eqTpszCdCb4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdCb4
	 */
	 public	 String	getEqTpszCdCb4() {
		 return	this.eqTpszCdCb4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdSl2
	*/
	public void	setEqTpszCdSl2( String	eqTpszCdSl2 ) {
		this.eqTpszCdSl2 =	eqTpszCdSl2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSl2
	 */
	 public	 String	getEqTpszCdSl2() {
		 return	this.eqTpszCdSl2;
	 } 
 	/**
	* Column Info
	* @param  newAgmtNo
	*/
	public void	setNewAgmtNo( String	newAgmtNo ) {
		this.newAgmtNo =	newAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	newAgmtNo
	 */
	 public	 String	getNewAgmtNo() {
		 return	this.newAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
	 } 
 	/**
	* Column Info
	* @param  viewflg
	*/
	public void	setViewflg( String	viewflg ) {
		this.viewflg =	viewflg;
	}
 
	/**
	 * Column Info
	 * @return	viewflg
	 */
	 public	 String	getViewflg() {
		 return	this.viewflg;
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
	* @param  eqTpszCdEg8
	*/
	public void	setEqTpszCdEg8( String	eqTpszCdEg8 ) {
		this.eqTpszCdEg8 =	eqTpszCdEg8;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdEg8
	 */
	 public	 String	getEqTpszCdEg8() {
		 return	this.eqTpszCdEg8;
	 } 
 	/**
	* Column Info
	* @param  newVndrSeq
	*/
	public void	setNewVndrSeq( String	newVndrSeq ) {
		this.newVndrSeq =	newVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	newVndrSeq
	 */
	 public	 String	getNewVndrSeq() {
		 return	this.newVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdZt4
	*/
	public void	setEqTpszCdZt4( String	eqTpszCdZt4 ) {
		this.eqTpszCdZt4 =	eqTpszCdZt4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdZt4
	 */
	 public	 String	getEqTpszCdZt4() {
		 return	this.eqTpszCdZt4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdGn4
	*/
	public void	setEqTpszCdGn4( String	eqTpszCdGn4 ) {
		this.eqTpszCdGn4 =	eqTpszCdGn4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdGn4
	 */
	 public	 String	getEqTpszCdGn4() {
		 return	this.eqTpszCdGn4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdTa2
	*/
	public void	setEqTpszCdTa2( String	eqTpszCdTa2 ) {
		this.eqTpszCdTa2 =	eqTpszCdTa2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdTa2
	 */
	 public	 String	getEqTpszCdTa2() {
		 return	this.eqTpszCdTa2;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdGn5
	*/
	public void	setEqTpszCdGn5( String	eqTpszCdGn5 ) {
		this.eqTpszCdGn5 =	eqTpszCdGn5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdGn5
	 */
	 public	 String	getEqTpszCdGn5() {
		 return	this.eqTpszCdGn5;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdEg5
	*/
	public void	setEqTpszCdEg5( String	eqTpszCdEg5 ) {
		this.eqTpszCdEg5 =	eqTpszCdEg5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdEg5
	 */
	 public	 String	getEqTpszCdEg5() {
		 return	this.eqTpszCdEg5;
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
	* @param  oldAgmtNo
	*/
	public void	setOldAgmtNo( String	oldAgmtNo ) {
		this.oldAgmtNo =	oldAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	oldAgmtNo
	 */
	 public	 String	getOldAgmtNo() {
		 return	this.oldAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  stsEvntDtTo
	*/
	public void	setStsEvntDtTo( String	stsEvntDtTo ) {
		this.stsEvntDtTo =	stsEvntDtTo;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntDtTo
	 */
	 public	 String	getStsEvntDtTo() {
		 return	this.stsEvntDtTo;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdSf2
	*/
	public void	setEqTpszCdSf2( String	eqTpszCdSf2 ) {
		this.eqTpszCdSf2 =	eqTpszCdSf2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSf2
	 */
	 public	 String	getEqTpszCdSf2() {
		 return	this.eqTpszCdSf2;
	 } 
 	/**
	* Column Info
	* @param  oldVndrSeq
	*/
	public void	setOldVndrSeq( String	oldVndrSeq ) {
		this.oldVndrSeq =	oldVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	oldVndrSeq
	 */
	 public	 String	getOldVndrSeq() {
		 return	this.oldVndrSeq;
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
		setStsEvntOfcCd(JSPUtil.getParameter(request,	prefix + "sts_evnt_ofc_cd", ""));
		setEqTpszCdSf4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sf4", ""));
		setStsEvntDtFr(JSPUtil.getParameter(request,	prefix + "sts_evnt_dt_fr", ""));
		setNewAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "new_agmt_lstm_cd", ""));
		setOldAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "old_agmt_lstm_cd", ""));
		setEqTpszCdCb4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_cb4", ""));
		setEqTpszCdSl2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sl2", ""));
		setNewAgmtNo(JSPUtil.getParameter(request,	prefix + "new_agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setViewflg(JSPUtil.getParameter(request,	prefix + "viewflg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqTpszCdEg8(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_eg8", ""));
		setNewVndrSeq(JSPUtil.getParameter(request,	prefix + "new_vndr_seq", ""));
		setEqTpszCdZt4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_zt4", ""));
		setEqTpszCdGn4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_gn4", ""));
		setEqTpszCdTa2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_ta2", ""));
		setEqTpszCdGn5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_gn5", ""));
		setEqTpszCdEg5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_eg5", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setOldAgmtNo(JSPUtil.getParameter(request,	prefix + "old_agmt_no", ""));
		setStsEvntDtTo(JSPUtil.getParameter(request,	prefix + "sts_evnt_dt_to", ""));
		setEqTpszCdSf2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sf2", ""));
		setOldVndrSeq(JSPUtil.getParameter(request,	prefix + "old_vndr_seq", ""));
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
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CHSTermChangeResultMGTVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] stsEvntOfcCd =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_ofc_cd".trim(),	length));
				String[] eqTpszCdSf4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sf4".trim(),	length));
				String[] stsEvntDtFr =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_dt_fr".trim(),	length));
				String[] newAgmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"new_agmt_lstm_cd".trim(),	length));
				String[] oldAgmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"old_agmt_lstm_cd".trim(),	length));
				String[] eqTpszCdCb4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_cb4".trim(),	length));
				String[] eqTpszCdSl2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sl2".trim(),	length));
				String[] newAgmtNo =	(JSPUtil.getParameter(request, prefix +	"new_agmt_no".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] viewflg =	(JSPUtil.getParameter(request, prefix +	"viewflg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqTpszCdEg8 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_eg8".trim(),	length));
				String[] newVndrSeq =	(JSPUtil.getParameter(request, prefix +	"new_vndr_seq".trim(),	length));
				String[] eqTpszCdZt4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_zt4".trim(),	length));
				String[] eqTpszCdGn4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_gn4".trim(),	length));
				String[] eqTpszCdTa2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_ta2".trim(),	length));
				String[] eqTpszCdGn5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_gn5".trim(),	length));
				String[] eqTpszCdEg5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_eg5".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] oldAgmtNo =	(JSPUtil.getParameter(request, prefix +	"old_agmt_no".trim(),	length));
				String[] stsEvntDtTo =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_dt_to".trim(),	length));
				String[] eqTpszCdSf2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sf2".trim(),	length));
				String[] oldVndrSeq =	(JSPUtil.getParameter(request, prefix +	"old_vndr_seq".trim(),	length));
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
					model =	new	CHSTermChangeResultMGTVO();
						if ( stsEvntOfcCd[i] !=	null)
						model.setStsEvntOfcCd( stsEvntOfcCd[i]);
						if ( eqTpszCdSf4[i] !=	null)
						model.setEqTpszCdSf4( eqTpszCdSf4[i]);
						if ( stsEvntDtFr[i] !=	null)
						model.setStsEvntDtFr( stsEvntDtFr[i]);
						if ( newAgmtLstmCd[i] !=	null)
						model.setNewAgmtLstmCd( newAgmtLstmCd[i]);
						if ( oldAgmtLstmCd[i] !=	null)
						model.setOldAgmtLstmCd( oldAgmtLstmCd[i]);
						if ( eqTpszCdCb4[i] !=	null)
						model.setEqTpszCdCb4( eqTpszCdCb4[i]);
						if ( eqTpszCdSl2[i] !=	null)
						model.setEqTpszCdSl2( eqTpszCdSl2[i]);
						if ( newAgmtNo[i] !=	null)
						model.setNewAgmtNo( newAgmtNo[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( viewflg[i] !=	null)
						model.setViewflg( viewflg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqTpszCdEg8[i] !=	null)
						model.setEqTpszCdEg8( eqTpszCdEg8[i]);
						if ( newVndrSeq[i] !=	null)
						model.setNewVndrSeq( newVndrSeq[i]);
						if ( eqTpszCdZt4[i] !=	null)
						model.setEqTpszCdZt4( eqTpszCdZt4[i]);
						if ( eqTpszCdGn4[i] !=	null)
						model.setEqTpszCdGn4( eqTpszCdGn4[i]);
						if ( eqTpszCdTa2[i] !=	null)
						model.setEqTpszCdTa2( eqTpszCdTa2[i]);
						if ( eqTpszCdGn5[i] !=	null)
						model.setEqTpszCdGn5( eqTpszCdGn5[i]);
						if ( eqTpszCdEg5[i] !=	null)
						model.setEqTpszCdEg5( eqTpszCdEg5[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( oldAgmtNo[i] !=	null)
						model.setOldAgmtNo( oldAgmtNo[i]);
						if ( stsEvntDtTo[i] !=	null)
						model.setStsEvntDtTo( stsEvntDtTo[i]);
						if ( eqTpszCdSf2[i] !=	null)
						model.setEqTpszCdSf2( eqTpszCdSf2[i]);
						if ( oldVndrSeq[i] !=	null)
						model.setOldVndrSeq( oldVndrSeq[i]);
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
		return getCHSTermChangeResultMGTVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[]	 getCHSTermChangeResultMGTVOs(){
		CHSTermChangeResultMGTVO[] vos = (CHSTermChangeResultMGTVO[])models.toArray(new	CHSTermChangeResultMGTVO[models.size()]);
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
		this.stsEvntOfcCd =	this.stsEvntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf4 =	this.eqTpszCdSf4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtFr =	this.stsEvntDtFr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtLstmCd =	this.newAgmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtLstmCd =	this.oldAgmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdCb4 =	this.eqTpszCdCb4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSl2 =	this.eqTpszCdSl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo =	this.newAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewflg =	this.viewflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg8 =	this.eqTpszCdEg8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVndrSeq =	this.newVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdZt4 =	this.eqTpszCdZt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn4 =	this.eqTpszCdGn4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTa2 =	this.eqTpszCdTa2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn5 =	this.eqTpszCdGn5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg5 =	this.eqTpszCdEg5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtTo =	this.stsEvntDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf2 =	this.eqTpszCdSf2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVndrSeq =	this.oldVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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