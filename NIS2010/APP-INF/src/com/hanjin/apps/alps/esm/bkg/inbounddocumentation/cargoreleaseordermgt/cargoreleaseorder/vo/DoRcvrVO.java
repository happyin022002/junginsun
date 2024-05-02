/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DoRcvrVO.java
 *@FileTitle : DoRcvrVO
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
public class DoRcvrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DoRcvrVO>  models =	new	ArrayList<DoRcvrVO>();


	/*	Column Info	*/
	private  String	 doNo   =  null;
	/*	Column Info	*/
	private  String	 doNoSplit   =  null;
	/*	Column Info	*/
	private  String	 rcvrEml   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rcvrPhnNo   =  null;
	/*	Column Info	*/
	private  String	 hblNo   =  null;
	/*	Column Info	*/
	private  String	 rcvrCoNm   =  null;
	/*	Column Info	*/
	private  String	 picNm   =  null;
	/*	Column Info	*/
	private  String	 custToOrdFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvrCneeNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rcvrFaxNo   =  null;
	/*	Column Info	*/
	private  String	 rcvrCneeAddr   =  null;
	/*	Column Info	*/
	private  String	 cfsEml   =  null;
	/*	Column Info	*/
	private  String	 mtyYdEml   =  null;
	/*	Column Info	*/
	private  String	 inDoOdcyAddrCd   =  null;
	/*	Column Info	*/
	private  String	 evntDt   =  null;
	/*	Column Info	*/
	private  String	 atchSveyLtrFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public DoRcvrVO(){}

	public DoRcvrVO(String doNo,String doNoSplit,String rcvrEml,String bkgNo,String ibflag,String rcvrPhnNo,String hblNo,String rcvrCoNm,String picNm,String custToOrdFlg,String rcvrCneeNm,String pagerows,String rcvrFaxNo,String rcvrCneeAddr,String cfsEml,String mtyYdEml,String inDoOdcyAddrCd,String evntDt,String atchSveyLtrFlg)	{
		this.doNo  = doNo ;
		this.doNoSplit  = doNoSplit ;
		this.rcvrEml  = rcvrEml ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.rcvrPhnNo  = rcvrPhnNo ;
		this.hblNo  = hblNo ;
		this.rcvrCoNm  = rcvrCoNm ;
		this.picNm  = picNm ;
		this.custToOrdFlg  = custToOrdFlg ;
		this.rcvrCneeNm  = rcvrCneeNm ;
		this.pagerows  = pagerows ;
		this.rcvrFaxNo  = rcvrFaxNo ;
		this.rcvrCneeAddr  = rcvrCneeAddr ;
		this.cfsEml  = cfsEml ;
		this.mtyYdEml  = mtyYdEml ;
		this.inDoOdcyAddrCd  = inDoOdcyAddrCd ;
		this.evntDt  = evntDt ;
		this.atchSveyLtrFlg  = atchSveyLtrFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no", getDoNo());		
		this.hashColumns.put("do_no_split", getDoNoSplit());		
		this.hashColumns.put("rcvr_eml", getRcvrEml());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());		
		this.hashColumns.put("hbl_no", getHblNo());		
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());		
		this.hashColumns.put("pic_nm", getPicNm());		
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());		
		this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());		
		this.hashColumns.put("rcvr_cnee_addr", getRcvrCneeAddr());		
		this.hashColumns.put("cfs_eml", getCfsEml());		
		this.hashColumns.put("mty_yd_eml", getMtyYdEml());		
		this.hashColumns.put("in_do_odcy_addr_cd", getInDoOdcyAddrCd());		
		this.hashColumns.put("evnt_dt", getEvntDt());		
		this.hashColumns.put("atch_svey_ltr_flg", getAtchSveyLtrFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		this.hashFields.put("rcvr_cnee_addr", "rcvrCneeAddr");
		this.hashFields.put("cfs_eml", "cfsEml");
		this.hashFields.put("mty_yd_eml", "mtyYdEml");
		this.hashFields.put("in_do_odcy_addr_cd", "inDoOdcyAddrCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("atch_svey_ltr_flg", "atchSveyLtrFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  rcvrEml
	*/
	public void	setRcvrEml( String	rcvrEml ) {
		this.rcvrEml =	rcvrEml;
	}
 
	/**
	 * Column Info
	 * @return	rcvrEml
	 */
	 public	 String	getRcvrEml() {
		 return	this.rcvrEml;
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
	* @param  rcvrPhnNo
	*/
	public void	setRcvrPhnNo( String	rcvrPhnNo ) {
		this.rcvrPhnNo =	rcvrPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	rcvrPhnNo
	 */
	 public	 String	getRcvrPhnNo() {
		 return	this.rcvrPhnNo;
	 } 
 	/**
	* Column Info
	* @param  hblNo
	*/
	public void	setHblNo( String	hblNo ) {
		this.hblNo =	hblNo;
	}
 
	/**
	 * Column Info
	 * @return	hblNo
	 */
	 public	 String	getHblNo() {
		 return	this.hblNo;
	 } 
 	/**
	* Column Info
	* @param  rcvrCoNm
	*/
	public void	setRcvrCoNm( String	rcvrCoNm ) {
		this.rcvrCoNm =	rcvrCoNm;
	}
 
	/**
	 * Column Info
	 * @return	rcvrCoNm
	 */
	 public	 String	getRcvrCoNm() {
		 return	this.rcvrCoNm;
	 } 
 	/**
	* Column Info
	* @param  picNm
	*/
	public void	setPicNm( String	picNm ) {
		this.picNm =	picNm;
	}
 
	/**
	 * Column Info
	 * @return	picNm
	 */
	 public	 String	getPicNm() {
		 return	this.picNm;
	 } 
 	/**
	* Column Info
	* @param  custToOrdFlg
	*/
	public void	setCustToOrdFlg( String	custToOrdFlg ) {
		this.custToOrdFlg =	custToOrdFlg;
	}
 
	/**
	 * Column Info
	 * @return	custToOrdFlg
	 */
	 public	 String	getCustToOrdFlg() {
		 return	this.custToOrdFlg;
	 } 
 	/**
	* Column Info
	* @param  rcvrCneeNm
	*/
	public void	setRcvrCneeNm( String	rcvrCneeNm ) {
		this.rcvrCneeNm =	rcvrCneeNm;
	}
 
	/**
	 * Column Info
	 * @return	rcvrCneeNm
	 */
	 public	 String	getRcvrCneeNm() {
		 return	this.rcvrCneeNm;
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
	* @param  rcvrFaxNo
	*/
	public void	setRcvrFaxNo( String	rcvrFaxNo ) {
		this.rcvrFaxNo =	rcvrFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	rcvrFaxNo
	 */
	 public	 String	getRcvrFaxNo() {
		 return	this.rcvrFaxNo;
	 } 
 	/**
	* Column Info
	* @param  rcvrCneeAddr
	*/
	public void	setRcvrCneeAddr( String	rcvrCneeAddr ) {
		this.rcvrCneeAddr =	rcvrCneeAddr;
	}
 
	/**
	 * Column Info
	 * @return	rcvrCneeAddr
	 */
	 public	 String	getRcvrCneeAddr() {
		 return	this.rcvrCneeAddr;
	 } 
 	/**
	* Column Info
	* @param  cfsEml
	*/
	public void	setCfsEml( String	cfsEml ) {
		this.cfsEml =	cfsEml;
	}
 
	/**
	 * Column Info
	 * @return	cfsEml
	 */
	 public	 String	getCfsEml() {
		 return	this.cfsEml;
	 } 
 	/**
	* Column Info
	* @param  mtyYdEml
	*/
	public void	setMtyYdEml( String	mtyYdEml ) {
		this.mtyYdEml =	mtyYdEml;
	}
 
	/**
	 * Column Info
	 * @return	mtyYdEml
	 */
	 public	 String	getMtyYdEml() {
		 return	this.mtyYdEml;
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
		setDoNo(JSPUtil.getParameter(request,	prefix + "do_no", ""));
		setDoNoSplit(JSPUtil.getParameter(request,	prefix + "do_no_split", ""));
		setRcvrEml(JSPUtil.getParameter(request,	prefix + "rcvr_eml", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request,	prefix + "rcvr_phn_no", ""));
		setHblNo(JSPUtil.getParameter(request,	prefix + "hbl_no", ""));
		setRcvrCoNm(JSPUtil.getParameter(request,	prefix + "rcvr_co_nm", ""));
		setPicNm(JSPUtil.getParameter(request,	prefix + "pic_nm", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request,	prefix + "cust_to_ord_flg", ""));
		setRcvrCneeNm(JSPUtil.getParameter(request,	prefix + "rcvr_cnee_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request,	prefix + "rcvr_fax_no", ""));
		setRcvrCneeAddr(JSPUtil.getParameter(request,	prefix + "rcvr_cnee_addr", ""));
		setCfsEml(JSPUtil.getParameter(request,	prefix + "cfs_eml", ""));
		setMtyYdEml(JSPUtil.getParameter(request,	prefix + "mty_yd_eml", ""));
		setInDoOdcyAddrCd(JSPUtil.getParameter(request,	prefix + "in_do_odcy_addr_cd", ""));
		setEvntDt(JSPUtil.getParameter(request,	prefix + "evnt_dt", ""));
		setAtchSveyLtrFlg(JSPUtil.getParameter(request,	prefix + "atch_svey_ltr_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DoRcvrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] doNo =	(JSPUtil.getParameter(request, prefix +	"do_no".trim(),	length));
				String[] doNoSplit =	(JSPUtil.getParameter(request, prefix +	"do_no_split".trim(),	length));
				String[] rcvrEml =	(JSPUtil.getParameter(request, prefix +	"rcvr_eml".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rcvrPhnNo =	(JSPUtil.getParameter(request, prefix +	"rcvr_phn_no".trim(),	length));
				String[] hblNo =	(JSPUtil.getParameter(request, prefix +	"hbl_no".trim(),	length));
				String[] rcvrCoNm =	(JSPUtil.getParameter(request, prefix +	"rcvr_co_nm".trim(),	length));
				String[] picNm =	(JSPUtil.getParameter(request, prefix +	"pic_nm".trim(),	length));
				String[] custToOrdFlg =	(JSPUtil.getParameter(request, prefix +	"cust_to_ord_flg".trim(),	length));
				String[] rcvrCneeNm =	(JSPUtil.getParameter(request, prefix +	"rcvr_cnee_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rcvrFaxNo =	(JSPUtil.getParameter(request, prefix +	"rcvr_fax_no".trim(),	length));
				String[] rcvrCneeAddr =	(JSPUtil.getParameter(request, prefix +	"rcvr_cnee_addr".trim(),	length));
				String[] cfsEml =	(JSPUtil.getParameter(request, prefix +	"cfs_eml".trim(),	length));
				String[] mtyYdEml =	(JSPUtil.getParameter(request, prefix +	"mty_yd_eml".trim(),	length));
				String[] inDoOdcyAddrCd =	(JSPUtil.getParameter(request, prefix +	"in_do_odcy_addr_cd".trim(),	length));
				String[] evntDt =	(JSPUtil.getParameter(request, prefix +	"evnt_dt".trim(),	length));
				String[] atchSveyLtrFlg =	(JSPUtil.getParameter(request, prefix +	"atch_svey_ltr_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	DoRcvrVO();
						if ( doNo[i] !=	null)
						model.setDoNo( doNo[i]);
						if ( doNoSplit[i] !=	null)
						model.setDoNoSplit( doNoSplit[i]);
						if ( rcvrEml[i] !=	null)
						model.setRcvrEml( rcvrEml[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rcvrPhnNo[i] !=	null)
						model.setRcvrPhnNo( rcvrPhnNo[i]);
						if ( hblNo[i] !=	null)
						model.setHblNo( hblNo[i]);
						if ( rcvrCoNm[i] !=	null)
						model.setRcvrCoNm( rcvrCoNm[i]);
						if ( picNm[i] !=	null)
						model.setPicNm( picNm[i]);
						if ( custToOrdFlg[i] !=	null)
						model.setCustToOrdFlg( custToOrdFlg[i]);
						if ( rcvrCneeNm[i] !=	null)
						model.setRcvrCneeNm( rcvrCneeNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rcvrFaxNo[i] !=	null)
						model.setRcvrFaxNo( rcvrFaxNo[i]);
						if ( rcvrCneeAddr[i] !=	null)
						model.setRcvrCneeAddr( rcvrCneeAddr[i]);
						if ( cfsEml[i] !=	null)
						model.setCfsEml( cfsEml[i]);
						if ( mtyYdEml[i] !=	null)
						model.setMtyYdEml( mtyYdEml[i]);
						if ( inDoOdcyAddrCd[i] !=	null)
						model.setInDoOdcyAddrCd( inDoOdcyAddrCd[i]);
						if ( evntDt[i] !=	null)
						model.setEvntDt( evntDt[i]);
						if ( atchSveyLtrFlg[i] !=	null)
						model.setAtchSveyLtrFlg( atchSveyLtrFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getDoRcvrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DoRcvrVO[]
	 */
	public DoRcvrVO[]	 getDoRcvrVOs(){
		DoRcvrVO[] vos = (DoRcvrVO[])models.toArray(new	DoRcvrVO[models.size()]);
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
		this.doNo =	this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit =	this.doNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml =	this.rcvrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo =	this.rcvrPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo =	this.hblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm =	this.rcvrCoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm =	this.picNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg =	this.custToOrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeNm =	this.rcvrCneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo =	this.rcvrFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeAddr =	this.rcvrCneeAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsEml =	this.cfsEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyYdEml =	this.mtyYdEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDoOdcyAddrCd =	this.inDoOdcyAddrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt =	this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchSveyLtrFlg =	this.atchSveyLtrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}