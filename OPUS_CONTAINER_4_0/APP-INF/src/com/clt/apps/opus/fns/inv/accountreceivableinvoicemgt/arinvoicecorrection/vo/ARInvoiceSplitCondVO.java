/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceSplitCondVO.java
 *@FileTitle : ARInvoiceSplitCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.09.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
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
public class ARInvoiceSplitCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceSplitCondVO>  models =	new	ArrayList<ARInvoiceSplitCondVO>();


	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 cancelIfNo   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 cxlIfNoList   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 splitCnt   =  null;
	/*	Column Info	*/
	private  String	 blInvCfmDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 maxSeq   =  null;
	/*	Column Info	*/
	private  String	 orgIfNoList   =  null;
	/*	Column Info	*/
	private  String	 issToSplitFlg   =  null;
	/*	Column Info	*/
	private  String	 maxIfNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceSplitCondVO(){}

	public ARInvoiceSplitCondVO(String blSrcNo,String ifNo,String cancelIfNo,String invCurrCd,String cxlIfNoList,String pagerows,String sailDt,String ofcCd,String splitCnt,String blInvCfmDt,String ibflag,String bkgNo,String usrId,String maxSeq,String orgIfNoList,String issToSplitFlg,String maxIfNo)	{
		this.blSrcNo  = blSrcNo ;
		this.ifNo  = ifNo ;
		this.cancelIfNo  = cancelIfNo ;
		this.invCurrCd  = invCurrCd ;
		this.cxlIfNoList  = cxlIfNoList ;
		this.pagerows  = pagerows ;
		this.sailDt  = sailDt ;
		this.ofcCd  = ofcCd ;
		this.splitCnt  = splitCnt ;
		this.blInvCfmDt  = blInvCfmDt ;
		this.ibflag  = ibflag ;
		this.bkgNo  = bkgNo ;
		this.usrId  = usrId ;
		this.maxSeq  = maxSeq ;
		this.orgIfNoList  = orgIfNoList ;
		this.issToSplitFlg  = issToSplitFlg ;
		this.maxIfNo  = maxIfNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("cancel_if_no", getCancelIfNo());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("cxl_if_no_list", getCxlIfNoList());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("split_cnt", getSplitCnt());		
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("max_seq", getMaxSeq());		
		this.hashColumns.put("org_if_no_list", getOrgIfNoList());		
		this.hashColumns.put("iss_to_split_flg", getIssToSplitFlg());		
		this.hashColumns.put("max_if_no", getMaxIfNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("cancel_if_no", "cancelIfNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("cxl_if_no_list", "cxlIfNoList");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("split_cnt", "splitCnt");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("org_if_no_list", "orgIfNoList");
		this.hashFields.put("iss_to_split_flg", "issToSplitFlg");
		this.hashFields.put("max_if_no", "maxIfNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
	 } 
 	/**
	* Column Info
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
	 } 
 	/**
	* Column Info
	* @param  cancelIfNo
	*/
	public void	setCancelIfNo( String	cancelIfNo ) {
		this.cancelIfNo =	cancelIfNo;
	}
 
	/**
	 * Column Info
	 * @return	cancelIfNo
	 */
	 public	 String	getCancelIfNo() {
		 return	this.cancelIfNo;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  cxlIfNoList
	*/
	public void	setCxlIfNoList( String	cxlIfNoList ) {
		this.cxlIfNoList =	cxlIfNoList;
	}
 
	/**
	 * Column Info
	 * @return	cxlIfNoList
	 */
	 public	 String	getCxlIfNoList() {
		 return	this.cxlIfNoList;
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
	* @param  sailDt
	*/
	public void	setSailDt( String	sailDt ) {
		this.sailDt =	sailDt;
	}
 
	/**
	 * Column Info
	 * @return	sailDt
	 */
	 public	 String	getSailDt() {
		 return	this.sailDt;
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
	* @param  splitCnt
	*/
	public void	setSplitCnt( String	splitCnt ) {
		this.splitCnt =	splitCnt;
	}
 
	/**
	 * Column Info
	 * @return	splitCnt
	 */
	 public	 String	getSplitCnt() {
		 return	this.splitCnt;
	 } 
 	/**
	* Column Info
	* @param  blInvCfmDt
	*/
	public void	setBlInvCfmDt( String	blInvCfmDt ) {
		this.blInvCfmDt =	blInvCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvCfmDt
	 */
	 public	 String	getBlInvCfmDt() {
		 return	this.blInvCfmDt;
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
	* @param  maxSeq
	*/
	public void	setMaxSeq( String	maxSeq ) {
		this.maxSeq =	maxSeq;
	}
 
	/**
	 * Column Info
	 * @return	maxSeq
	 */
	 public	 String	getMaxSeq() {
		 return	this.maxSeq;
	 } 
 	/**
	* Column Info
	* @param  orgIfNoList
	*/
	public void	setOrgIfNoList( String	orgIfNoList ) {
		this.orgIfNoList =	orgIfNoList;
	}
 
	/**
	 * Column Info
	 * @return	orgIfNoList
	 */
	 public	 String	getOrgIfNoList() {
		 return	this.orgIfNoList;
	 } 
 	/**
	* Column Info
	* @param  issToSplitFlg
	*/
	public void	setIssToSplitFlg( String	issToSplitFlg ) {
		this.issToSplitFlg =	issToSplitFlg;
	}
 
	/**
	 * Column Info
	 * @return	issToSplitFlg
	 */
	 public	 String	getIssToSplitFlg() {
		 return	this.issToSplitFlg;
	 } 
 	/**
	* Column Info
	* @param  maxIfNo
	*/
	public void	setMaxIfNo( String	maxIfNo ) {
		this.maxIfNo =	maxIfNo;
	}
 
	/**
	 * Column Info
	 * @return	maxIfNo
	 */
	 public	 String	getMaxIfNo() {
		 return	this.maxIfNo;
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
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setCancelIfNo(JSPUtil.getParameter(request,	prefix + "cancel_if_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setCxlIfNoList(JSPUtil.getParameter(request,	prefix + "cxl_if_no_list", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setSplitCnt(JSPUtil.getParameter(request,	prefix + "split_cnt", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request,	prefix + "bl_inv_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setMaxSeq(JSPUtil.getParameter(request,	prefix + "max_seq", ""));
		setOrgIfNoList(JSPUtil.getParameter(request,	prefix + "org_if_no_list", ""));
		setIssToSplitFlg(JSPUtil.getParameter(request,	prefix + "iss_to_split_flg", ""));
		setMaxIfNo(JSPUtil.getParameter(request,	prefix + "max_if_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceSplitCondVO[]
	 */
	public ARInvoiceSplitCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceSplitCondVO[]
	 */
	public ARInvoiceSplitCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceSplitCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] cancelIfNo =	(JSPUtil.getParameter(request, prefix +	"cancel_if_no".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] cxlIfNoList =	(JSPUtil.getParameter(request, prefix +	"cxl_if_no_list".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] splitCnt =	(JSPUtil.getParameter(request, prefix +	"split_cnt".trim(),	length));
				String[] blInvCfmDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_cfm_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] maxSeq =	(JSPUtil.getParameter(request, prefix +	"max_seq".trim(),	length));
				String[] orgIfNoList =	(JSPUtil.getParameter(request, prefix +	"org_if_no_list".trim(),	length));
				String[] issToSplitFlg =	(JSPUtil.getParameter(request, prefix +	"iss_to_split_flg".trim(),	length));
				String[] maxIfNo =	(JSPUtil.getParameter(request, prefix +	"max_if_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceSplitCondVO();
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( cancelIfNo[i] !=	null)
						model.setCancelIfNo( cancelIfNo[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( cxlIfNoList[i] !=	null)
						model.setCxlIfNoList( cxlIfNoList[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( splitCnt[i] !=	null)
						model.setSplitCnt( splitCnt[i]);
						if ( blInvCfmDt[i] !=	null)
						model.setBlInvCfmDt( blInvCfmDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( maxSeq[i] !=	null)
						model.setMaxSeq( maxSeq[i]);
						if ( orgIfNoList[i] !=	null)
						model.setOrgIfNoList( orgIfNoList[i]);
						if ( issToSplitFlg[i] !=	null)
						model.setIssToSplitFlg( issToSplitFlg[i]);
						if ( maxIfNo[i] !=	null)
						model.setMaxIfNo( maxIfNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceSplitCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARInvoiceSplitCondVO[]
	 */
	public ARInvoiceSplitCondVO[]	 getARInvoiceSplitCondVOs(){
		ARInvoiceSplitCondVO[] vos = (ARInvoiceSplitCondVO[])models.toArray(new	ARInvoiceSplitCondVO[models.size()]);
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
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelIfNo =	this.cancelIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlIfNoList =	this.cxlIfNoList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitCnt =	this.splitCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt =	this.blInvCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq =	this.maxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIfNoList =	this.orgIfNoList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issToSplitFlg =	this.issToSplitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxIfNo =	this.maxIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}