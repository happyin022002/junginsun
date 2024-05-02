/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IndiaDoNtcSendVO.java
 *@FileTitle : IndiaDoNtcSendVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.08  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class IndiaDoNtcSendVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<IndiaDoNtcSendVO>  models =	new	ArrayList<IndiaDoNtcSendVO>();


	/*	Column Info	*/
	private  String	 doNoSplit   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 doNo   =  null;
	/*	Column Info	*/
	private  String	 ntcViaCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ntcEml   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 sndId   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 lclFlg   =  null;
	/*	Column Info	*/
	private  String	 ntcFaxNo   =  null;
	/*	Column Info	*/
	private  String	 usrEml   =  null;
	/*	Column Info	*/
	private  String	 mrdId   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 inDoOdcyAddrCd   =  null;
	/*	Column Info	*/
	private  String	 evntDt   =  null;
	/*	Column Info	*/
	private  String	 atchSveyLtrFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public IndiaDoNtcSendVO(){}

	public IndiaDoNtcSendVO(String doNoSplit,String pagerows,String doNo,String ntcViaCd,String ofcCd,String creUsrId,String ibflag,String ntcEml,String bkgNo,String blNo,String sndId,String usrNm,String usrId,String lclFlg,String ntcFaxNo,String usrEml,String mrdId,String updUsrId,String custNm,String inDoOdcyAddrCd,String evntDt,String atchSveyLtrFlg,String rcvrCd)	{
		this.doNoSplit  = doNoSplit ;
		this.pagerows  = pagerows ;
		this.doNo  = doNo ;
		this.ntcViaCd  = ntcViaCd ;
		this.ofcCd  = ofcCd ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.ntcEml  = ntcEml ;
		this.bkgNo  = bkgNo ;
		this.blNo  = blNo ;
		this.sndId  = sndId ;
		this.usrNm  = usrNm ;
		this.usrId  = usrId ;
		this.lclFlg  = lclFlg ;
		this.ntcFaxNo  = ntcFaxNo ;
		this.usrEml  = usrEml ;
		this.mrdId  = mrdId ;
		this.updUsrId  = updUsrId ;
		this.custNm  = custNm ;
		this.inDoOdcyAddrCd  = inDoOdcyAddrCd ;
		this.evntDt  = evntDt ;
		this.atchSveyLtrFlg  = atchSveyLtrFlg ;
		this.rcvrCd  = rcvrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("do_no", getDoNo());		
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ntc_eml", getNtcEml());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("snd_id", getSndId());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("lcl_flg", getLclFlg());		
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());		
		this.hashColumns.put("usr_eml", getUsrEml());		
		this.hashColumns.put("mrd_id", getMrdId());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("in_do_odcy_addr_cd", getInDoOdcyAddrCd());		
		this.hashColumns.put("evnt_dt", getEvntDt());		
		this.hashColumns.put("atch_svey_ltr_flg", getAtchSveyLtrFlg());		
		this.hashColumns.put("rcvr_cd", getRcvrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("snd_id", "sndId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("lcl_flg", "lclFlg");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("mrd_id", "mrdId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("in_do_odcy_addr_cd", "inDoOdcyAddrCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("atch_svey_ltr_flg", "atchSveyLtrFlg");
		this.hashFields.put("rcvr_cd", "rcvrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  doNoSplit
	*/
	public void	setDoNoSplit( String	doNoSplit ) {
		this.doNoSplit =	doNoSplit;
	}
 
	/**
	 * Column Info
	 * @return	doNoSplit
	 */
	 public	 String	getDoNoSplit() {
		 return	this.doNoSplit;
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
	* @param  doNo
	*/
	public void	setDoNo( String	doNo ) {
		this.doNo =	doNo;
	}
 
	/**
	 * Column Info
	 * @return	doNo
	 */
	 public	 String	getDoNo() {
		 return	this.doNo;
	 } 
 	/**
	* Column Info
	* @param  ntcViaCd
	*/
	public void	setNtcViaCd( String	ntcViaCd ) {
		this.ntcViaCd =	ntcViaCd;
	}
 
	/**
	 * Column Info
	 * @return	ntcViaCd
	 */
	 public	 String	getNtcViaCd() {
		 return	this.ntcViaCd;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
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
	* @param  ntcEml
	*/
	public void	setNtcEml( String	ntcEml ) {
		this.ntcEml =	ntcEml;
	}
 
	/**
	 * Column Info
	 * @return	ntcEml
	 */
	 public	 String	getNtcEml() {
		 return	this.ntcEml;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  sndId
	*/
	public void	setSndId( String	sndId ) {
		this.sndId =	sndId;
	}
 
	/**
	 * Column Info
	 * @return	sndId
	 */
	 public	 String	getSndId() {
		 return	this.sndId;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  lclFlg
	*/
	public void	setLclFlg( String	lclFlg ) {
		this.lclFlg =	lclFlg;
	}
 
	/**
	 * Column Info
	 * @return	lclFlg
	 */
	 public	 String	getLclFlg() {
		 return	this.lclFlg;
	 } 
 	/**
	* Column Info
	* @param  ntcFaxNo
	*/
	public void	setNtcFaxNo( String	ntcFaxNo ) {
		this.ntcFaxNo =	ntcFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	ntcFaxNo
	 */
	 public	 String	getNtcFaxNo() {
		 return	this.ntcFaxNo;
	 } 
 	/**
	* Column Info
	* @param  usrEml
	*/
	public void	setUsrEml( String	usrEml ) {
		this.usrEml =	usrEml;
	}
 
	/**
	 * Column Info
	 * @return	usrEml
	 */
	 public	 String	getUsrEml() {
		 return	this.usrEml;
	 } 
 	/**
	* Column Info
	* @param  mrdId
	*/
	public void	setMrdId( String	mrdId ) {
		this.mrdId =	mrdId;
	}
 
	/**
	 * Column Info
	 * @return	mrdId
	 */
	 public	 String	getMrdId() {
		 return	this.mrdId;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  inDoOdcyAddrCd
	*/
	public void	setInDoOdcyAddrCd( String	inDoOdcyAddrCd ) {
		this.inDoOdcyAddrCd =	inDoOdcyAddrCd;
	}
 
	/**
	 * Column Info
	 * @return	inDoOdcyAddrCd
	 */
	 public	 String	getInDoOdcyAddrCd() {
		 return	this.inDoOdcyAddrCd;
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
	* @param  atchSveyLtrFlg
	*/
	public void	setAtchSveyLtrFlg( String	atchSveyLtrFlg ) {
		this.atchSveyLtrFlg =	atchSveyLtrFlg;
	}
 
	/**
	 * Column Info
	 * @return	atchSveyLtrFlg
	 */
	 public	 String	getAtchSveyLtrFlg() {
		 return	this.atchSveyLtrFlg;
	 } 
 	/**
	* Column Info
	* @param  rcvrCd
	*/
	public void	setRcvrCd( String	rcvrCd ) {
		this.rcvrCd =	rcvrCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvrCd
	 */
	 public	 String	getRcvrCd() {
		 return	this.rcvrCd;
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
		setDoNoSplit(JSPUtil.getParameter(request,	prefix + "do_no_split", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request,	prefix + "do_no", ""));
		setNtcViaCd(JSPUtil.getParameter(request,	prefix + "ntc_via_cd", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setNtcEml(JSPUtil.getParameter(request,	prefix + "ntc_eml", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setSndId(JSPUtil.getParameter(request,	prefix + "snd_id", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setLclFlg(JSPUtil.getParameter(request,	prefix + "lcl_flg", ""));
		setNtcFaxNo(JSPUtil.getParameter(request,	prefix + "ntc_fax_no", ""));
		setUsrEml(JSPUtil.getParameter(request,	prefix + "usr_eml", ""));
		setMrdId(JSPUtil.getParameter(request,	prefix + "mrd_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInDoOdcyAddrCd(JSPUtil.getParameter(request,	prefix + "in_do_odcy_addr_cd", ""));
		setEvntDt(JSPUtil.getParameter(request,	prefix + "evnt_dt", ""));
		setAtchSveyLtrFlg(JSPUtil.getParameter(request,	prefix + "atch_svey_ltr_flg", ""));
		setRcvrCd(JSPUtil.getParameter(request,	prefix + "rcvr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaDoNtcSendVO[]
	 */
	public IndiaDoNtcSendVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return IndiaDoNtcSendVO[]
	 */
	public IndiaDoNtcSendVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		IndiaDoNtcSendVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] doNoSplit =	(JSPUtil.getParameter(request, prefix +	"do_no_split".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] doNo =	(JSPUtil.getParameter(request, prefix +	"do_no".trim(),	length));
				String[] ntcViaCd =	(JSPUtil.getParameter(request, prefix +	"ntc_via_cd".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ntcEml =	(JSPUtil.getParameter(request, prefix +	"ntc_eml".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] sndId =	(JSPUtil.getParameter(request, prefix +	"snd_id".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] lclFlg =	(JSPUtil.getParameter(request, prefix +	"lcl_flg".trim(),	length));
				String[] ntcFaxNo =	(JSPUtil.getParameter(request, prefix +	"ntc_fax_no".trim(),	length));
				String[] usrEml =	(JSPUtil.getParameter(request, prefix +	"usr_eml".trim(),	length));
				String[] mrdId =	(JSPUtil.getParameter(request, prefix +	"mrd_id".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] inDoOdcyAddrCd =	(JSPUtil.getParameter(request, prefix +	"in_do_odcy_addr_cd".trim(),	length));
				String[] evntDt =	(JSPUtil.getParameter(request, prefix +	"evnt_dt".trim(),	length));
				String[] atchSveyLtrFlg =	(JSPUtil.getParameter(request, prefix +	"atch_svey_ltr_flg".trim(),	length));
				String[] rcvrCd =	(JSPUtil.getParameter(request, prefix +	"rcvr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	IndiaDoNtcSendVO();
						if ( doNoSplit[i] !=	null)
						model.setDoNoSplit( doNoSplit[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( doNo[i] !=	null)
						model.setDoNo( doNo[i]);
						if ( ntcViaCd[i] !=	null)
						model.setNtcViaCd( ntcViaCd[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ntcEml[i] !=	null)
						model.setNtcEml( ntcEml[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( sndId[i] !=	null)
						model.setSndId( sndId[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( lclFlg[i] !=	null)
						model.setLclFlg( lclFlg[i]);
						if ( ntcFaxNo[i] !=	null)
						model.setNtcFaxNo( ntcFaxNo[i]);
						if ( usrEml[i] !=	null)
						model.setUsrEml( usrEml[i]);
						if ( mrdId[i] !=	null)
						model.setMrdId( mrdId[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( inDoOdcyAddrCd[i] !=	null)
						model.setInDoOdcyAddrCd( inDoOdcyAddrCd[i]);
						if ( evntDt[i] !=	null)
						model.setEvntDt( evntDt[i]);
						if ( atchSveyLtrFlg[i] !=	null)
						model.setAtchSveyLtrFlg( atchSveyLtrFlg[i]);
						if ( rcvrCd[i] !=	null)
						model.setRcvrCd( rcvrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getIndiaDoNtcSendVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return IndiaDoNtcSendVO[]
	 */
	public IndiaDoNtcSendVO[]	 getIndiaDoNtcSendVOs(){
		IndiaDoNtcSendVO[] vos = (IndiaDoNtcSendVO[])models.toArray(new	IndiaDoNtcSendVO[models.size()]);
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
		this.doNoSplit =	this.doNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo =	this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd =	this.ntcViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml =	this.ntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndId =	this.sndId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclFlg =	this.lclFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo =	this.ntcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml =	this.usrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdId =	this.mrdId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDoOdcyAddrCd =	this.inDoOdcyAddrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt =	this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchSveyLtrFlg =	this.atchSveyLtrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCd =	this.rcvrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}