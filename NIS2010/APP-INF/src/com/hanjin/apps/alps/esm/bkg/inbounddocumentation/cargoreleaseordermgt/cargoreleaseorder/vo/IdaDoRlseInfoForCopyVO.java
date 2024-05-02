/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IdaDoRlseInfoForCopyVO.java
 *@FileTitle : IdaDoRlseInfoForCopyVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.05  
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
public class IdaDoRlseInfoForCopyVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<IdaDoRlseInfoForCopyVO>  models =	new	ArrayList<IdaDoRlseInfoForCopyVO>();


	/*	Column Info	*/
	private  String	 doNoSplit   =  null;
	/*	Column Info	*/
	private  String	 custPrnFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvrFaxNo   =  null;
	/*	Column Info	*/
	private  String	 selfTrnsFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvrCoNm   =  null;
	/*	Column Info	*/
	private  String	 picNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rcvrCneeNm   =  null;
	/*	Column Info	*/
	private  String	 doNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 rcvrEml   =  null;
	/*	Column Info	*/
	private  String	 rcvrPhnNo   =  null;
	/*	Column Info	*/
	private  String	 hblNo   =  null;
	/*	Column Info	*/
	private  String	 doPrnRmk   =  null;
	/*	Column Info	*/
	private  String	 cfsEml   =  null;
	/*	Column Info	*/
	private  String	 mtyYdEml   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public IdaDoRlseInfoForCopyVO(){}

	public IdaDoRlseInfoForCopyVO(String doNoSplit,String custPrnFlg,String rcvrFaxNo,String selfTrnsFlg,String rcvrCoNm,String picNm,String pagerows,String rcvrCneeNm,String doNo,String ibflag,String bkgNo,String rcvrEml,String rcvrPhnNo,String hblNo,String doPrnRmk,String cfsEml,String mtyYdEml)	{
		this.doNoSplit  = doNoSplit ;
		this.custPrnFlg  = custPrnFlg ;
		this.rcvrFaxNo  = rcvrFaxNo ;
		this.selfTrnsFlg  = selfTrnsFlg ;
		this.rcvrCoNm  = rcvrCoNm ;
		this.picNm  = picNm ;
		this.pagerows  = pagerows ;
		this.rcvrCneeNm  = rcvrCneeNm ;
		this.doNo  = doNo ;
		this.ibflag  = ibflag ;
		this.bkgNo  = bkgNo ;
		this.rcvrEml  = rcvrEml ;
		this.rcvrPhnNo  = rcvrPhnNo ;
		this.hblNo  = hblNo ;
		this.doPrnRmk  = doPrnRmk ;
		this.cfsEml  = cfsEml ;
		this.mtyYdEml  = mtyYdEml ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());		
		this.hashColumns.put("cust_prn_flg", getCustPrnFlg());		
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());		
		this.hashColumns.put("self_trns_flg", getSelfTrnsFlg());		
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());		
		this.hashColumns.put("pic_nm", getPicNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());		
		this.hashColumns.put("do_no", getDoNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("rcvr_eml", getRcvrEml());		
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());		
		this.hashColumns.put("hbl_no", getHblNo());		
		this.hashColumns.put("do_prn_rmk", getDoPrnRmk());		
		this.hashColumns.put("cfs_eml", getCfsEml());		
		this.hashColumns.put("mty_yd_eml", getMtyYdEml());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("cust_prn_flg", "custPrnFlg");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		this.hashFields.put("self_trns_flg", "selfTrnsFlg");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("do_prn_rmk", "doPrnRmk");
		this.hashFields.put("cfs_eml", "cfsEml");
		this.hashFields.put("mty_yd_eml", "mtyYdEml");
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
	* @param  custPrnFlg
	*/
	public void	setCustPrnFlg( String	custPrnFlg ) {
		this.custPrnFlg =	custPrnFlg;
	}
 
	/**
	 * Column Info
	 * @return	custPrnFlg
	 */
	 public	 String	getCustPrnFlg() {
		 return	this.custPrnFlg;
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
	* @param  selfTrnsFlg
	*/
	public void	setSelfTrnsFlg( String	selfTrnsFlg ) {
		this.selfTrnsFlg =	selfTrnsFlg;
	}
 
	/**
	 * Column Info
	 * @return	selfTrnsFlg
	 */
	 public	 String	getSelfTrnsFlg() {
		 return	this.selfTrnsFlg;
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
	* @param  doPrnRmk
	*/
	public void	setDoPrnRmk( String	doPrnRmk ) {
		this.doPrnRmk =	doPrnRmk;
	}
 
	/**
	 * Column Info
	 * @return	doPrnRmk
	 */
	 public	 String	getDoPrnRmk() {
		 return	this.doPrnRmk;
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
		setCustPrnFlg(JSPUtil.getParameter(request,	prefix + "cust_prn_flg", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request,	prefix + "rcvr_fax_no", ""));
		setSelfTrnsFlg(JSPUtil.getParameter(request,	prefix + "self_trns_flg", ""));
		setRcvrCoNm(JSPUtil.getParameter(request,	prefix + "rcvr_co_nm", ""));
		setPicNm(JSPUtil.getParameter(request,	prefix + "pic_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRcvrCneeNm(JSPUtil.getParameter(request,	prefix + "rcvr_cnee_nm", ""));
		setDoNo(JSPUtil.getParameter(request,	prefix + "do_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setRcvrEml(JSPUtil.getParameter(request,	prefix + "rcvr_eml", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request,	prefix + "rcvr_phn_no", ""));
		setHblNo(JSPUtil.getParameter(request,	prefix + "hbl_no", ""));
		setDoPrnRmk(JSPUtil.getParameter(request,	prefix + "do_prn_rmk", ""));
		setCfsEml(JSPUtil.getParameter(request,	prefix + "cfs_eml", ""));
		setMtyYdEml(JSPUtil.getParameter(request,	prefix + "mty_yd_eml", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoRlseInfoForCopyVO[]
	 */
	public IdaDoRlseInfoForCopyVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return IdaDoRlseInfoForCopyVO[]
	 */
	public IdaDoRlseInfoForCopyVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		IdaDoRlseInfoForCopyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] doNoSplit =	(JSPUtil.getParameter(request, prefix +	"do_no_split".trim(),	length));
				String[] custPrnFlg =	(JSPUtil.getParameter(request, prefix +	"cust_prn_flg".trim(),	length));
				String[] rcvrFaxNo =	(JSPUtil.getParameter(request, prefix +	"rcvr_fax_no".trim(),	length));
				String[] selfTrnsFlg =	(JSPUtil.getParameter(request, prefix +	"self_trns_flg".trim(),	length));
				String[] rcvrCoNm =	(JSPUtil.getParameter(request, prefix +	"rcvr_co_nm".trim(),	length));
				String[] picNm =	(JSPUtil.getParameter(request, prefix +	"pic_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rcvrCneeNm =	(JSPUtil.getParameter(request, prefix +	"rcvr_cnee_nm".trim(),	length));
				String[] doNo =	(JSPUtil.getParameter(request, prefix +	"do_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] rcvrEml =	(JSPUtil.getParameter(request, prefix +	"rcvr_eml".trim(),	length));
				String[] rcvrPhnNo =	(JSPUtil.getParameter(request, prefix +	"rcvr_phn_no".trim(),	length));
				String[] hblNo =	(JSPUtil.getParameter(request, prefix +	"hbl_no".trim(),	length));
				String[] doPrnRmk =	(JSPUtil.getParameter(request, prefix +	"do_prn_rmk".trim(),	length));
				String[] cfsEml =	(JSPUtil.getParameter(request, prefix +	"cfs_eml".trim(),	length));
				String[] mtyYdEml =	(JSPUtil.getParameter(request, prefix +	"mty_yd_eml".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	IdaDoRlseInfoForCopyVO();
						if ( doNoSplit[i] !=	null)
						model.setDoNoSplit( doNoSplit[i]);
						if ( custPrnFlg[i] !=	null)
						model.setCustPrnFlg( custPrnFlg[i]);
						if ( rcvrFaxNo[i] !=	null)
						model.setRcvrFaxNo( rcvrFaxNo[i]);
						if ( selfTrnsFlg[i] !=	null)
						model.setSelfTrnsFlg( selfTrnsFlg[i]);
						if ( rcvrCoNm[i] !=	null)
						model.setRcvrCoNm( rcvrCoNm[i]);
						if ( picNm[i] !=	null)
						model.setPicNm( picNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rcvrCneeNm[i] !=	null)
						model.setRcvrCneeNm( rcvrCneeNm[i]);
						if ( doNo[i] !=	null)
						model.setDoNo( doNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( rcvrEml[i] !=	null)
						model.setRcvrEml( rcvrEml[i]);
						if ( rcvrPhnNo[i] !=	null)
						model.setRcvrPhnNo( rcvrPhnNo[i]);
						if ( hblNo[i] !=	null)
						model.setHblNo( hblNo[i]);
						if ( doPrnRmk[i] !=	null)
						model.setDoPrnRmk( doPrnRmk[i]);
						if ( cfsEml[i] !=	null)
						model.setCfsEml( cfsEml[i]);
						if ( mtyYdEml[i] !=	null)
						model.setMtyYdEml( mtyYdEml[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getIdaDoRlseInfoForCopyVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return IdaDoRlseInfoForCopyVO[]
	 */
	public IdaDoRlseInfoForCopyVO[]	 getIdaDoRlseInfoForCopyVOs(){
		IdaDoRlseInfoForCopyVO[] vos = (IdaDoRlseInfoForCopyVO[])models.toArray(new	IdaDoRlseInfoForCopyVO[models.size()]);
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
		this.custPrnFlg =	this.custPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo =	this.rcvrFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfTrnsFlg =	this.selfTrnsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm =	this.rcvrCoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm =	this.picNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeNm =	this.rcvrCneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo =	this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml =	this.rcvrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo =	this.rcvrPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo =	this.hblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doPrnRmk =	this.doPrnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsEml =	this.cfsEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyYdEml =	this.mtyYdEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}