/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceFaxEmailListVO.java
 *@FileTitle : InvoiceFaxEmailListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.31
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.07.31  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
public class InvoiceFaxEmailListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceFaxEmailListVO>  models =	new	ArrayList<InvoiceFaxEmailListVO>();


	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 invRefNo   =  null;
	/*	Column Info	*/
	private  String	 custEml   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 invIssRmk   =  null;
	/*	Column Info	*/
	private  String	 custFaxNo   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 fAdd   =  null;
	/*	Column Info	*/
	private  String	 fDel   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 attachView   =  null;
	/*	Column Info	*/
	private  String	 attachView2   =  null;
	/*	Column Info	*/
	private  String	 fCopy   =  null;
	/*	Column Info	*/
	private  String	 invIssCmbFlg   =  null;
	/*	Column Info	*/
	private  String	 loclPoNo   =  null;
	/*	Column Info	*/
	private  String	 issGrpTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceFaxEmailListVO(){}

	public InvoiceFaxEmailListVO(String blSrcNo,String custNm,String invRefNo,String custEml,String pagerows,String invNo,String vvd,String ibflag,String custCd,String arIfNo,String invRmk,String invIssRmk,String custFaxNo,String portCd,String fAdd,String fDel,String invSeq,String ioBndCd,String attachView,String attachView2,String fCopy,String invIssCmbFlg,String loclPoNo,String issGrpTpCd)	{
		this.blSrcNo  = blSrcNo ;
		this.custNm  = custNm ;
		this.invRefNo  = invRefNo ;
		this.custEml  = custEml ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.vvd  = vvd ;
		this.ibflag  = ibflag ;
		this.custCd  = custCd ;
		this.arIfNo  = arIfNo ;
		this.invRmk  = invRmk ;
		this.invIssRmk  = invIssRmk ;
		this.custFaxNo  = custFaxNo ;
		this.portCd  = portCd ;
		this.fAdd  = fAdd ;
		this.fDel  = fDel ;
		this.invSeq  = invSeq ;
		this.ioBndCd  = ioBndCd ;
		this.attachView  = attachView ;
		this.attachView2  = attachView2 ;
		this.fCopy  = fCopy ;
		this.invIssCmbFlg  = invIssCmbFlg ;
		this.loclPoNo  = loclPoNo ;
		this.issGrpTpCd  = issGrpTpCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("inv_ref_no", getInvRefNo());		
		this.hashColumns.put("cust_eml", getCustEml());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());		
		this.hashColumns.put("cust_fax_no", getCustFaxNo());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("f_add", getFAdd());		
		this.hashColumns.put("f_del", getFDel());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("attach_view", getAttachView());		
		this.hashColumns.put("attach_view2", getAttachView2());		
		this.hashColumns.put("f_copy", getFCopy());		
		this.hashColumns.put("inv_iss_cmb_flg", getInvIssCmbFlg());		
		this.hashColumns.put("locl_po_no", getLoclPoNo());		
		this.hashColumns.put("iss_grp_tp_cd", getIssGrpTpCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("f_add", "fAdd");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("attach_view", "attachView");
		this.hashFields.put("attach_view2", "attachView2");
		this.hashFields.put("f_copy", "fCopy");
		this.hashFields.put("inv_iss_cmb_flg", "invIssCmbFlg");
		this.hashFields.put("locl_po_no", "loclPoNo");
		this.hashFields.put("iss_grp_tp_cd", "issGrpTpCd");
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
	* @param  invRefNo
	*/
	public void	setInvRefNo( String	invRefNo ) {
		this.invRefNo =	invRefNo;
	}
 
	/**
	 * Column Info
	 * @return	invRefNo
	 */
	 public	 String	getInvRefNo() {
		 return	this.invRefNo;
	 } 
 	/**
	* Column Info
	* @param  custEml
	*/
	public void	setCustEml( String	custEml ) {
		this.custEml =	custEml;
	}
 
	/**
	 * Column Info
	 * @return	custEml
	 */
	 public	 String	getCustEml() {
		 return	this.custEml;
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
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
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
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
	 } 
 	/**
	* Column Info
	* @param  invRmk
	*/
	public void	setInvRmk( String	invRmk ) {
		this.invRmk =	invRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRmk
	 */
	 public	 String	getInvRmk() {
		 return	this.invRmk;
	 } 
 	/**
	* Column Info
	* @param  invIssRmk
	*/
	public void	setInvIssRmk( String	invIssRmk ) {
		this.invIssRmk =	invIssRmk;
	}
 
	/**
	 * Column Info
	 * @return	invIssRmk
	 */
	 public	 String	getInvIssRmk() {
		 return	this.invIssRmk;
	 } 
 	/**
	* Column Info
	* @param  custFaxNo
	*/
	public void	setCustFaxNo( String	custFaxNo ) {
		this.custFaxNo =	custFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	custFaxNo
	 */
	 public	 String	getCustFaxNo() {
		 return	this.custFaxNo;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
	 } 
 	/**
	* Column Info
	* @param  fAdd
	*/
	public void	setFAdd( String	fAdd ) {
		this.fAdd =	fAdd;
	}
 
	/**
	 * Column Info
	 * @return	fAdd
	 */
	 public	 String	getFAdd() {
		 return	this.fAdd;
	 } 
 	/**
	* Column Info
	* @param  fDel
	*/
	public void	setFDel( String	fDel ) {
		this.fDel =	fDel;
	}
 
	/**
	 * Column Info
	 * @return	fDel
	 */
	 public	 String	getFDel() {
		 return	this.fDel;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	 String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  attachView
	*/
	public void	setAttachView( String	attachView ) {
		this.attachView =	attachView;
	}
 
	/**
	 * Column Info
	 * @return	attachView
	 */
	 public	 String	getAttachView() {
		 return	this.attachView;
	 } 
 	/**
	* Column Info
	* @param  attachView2
	*/
	public void	setAttachView2( String	attachView2 ) {
		this.attachView2 =	attachView2;
	}
 
	/**
	 * Column Info
	 * @return	attachView2
	 */
	 public	 String	getAttachView2() {
		 return	this.attachView2;
	 } 
 	/**
	* Column Info
	* @param  fCopy
	*/
	public void	setFCopy( String	fCopy ) {
		this.fCopy =	fCopy;
	}
 
	/**
	 * Column Info
	 * @return	fCopy
	 */
	 public	 String	getFCopy() {
		 return	this.fCopy;
	 } 
 	/**
	* Column Info
	* @param  invIssCmbFlg
	*/
	public void	setInvIssCmbFlg( String	invIssCmbFlg ) {
		this.invIssCmbFlg =	invIssCmbFlg;
	}
 
	/**
	 * Column Info
	 * @return	invIssCmbFlg
	 */
	 public	 String	getInvIssCmbFlg() {
		 return	this.invIssCmbFlg;
	 } 
 	/**
	* Column Info
	* @param  loclPoNo
	*/
	public void	setLoclPoNo( String	loclPoNo ) {
		this.loclPoNo =	loclPoNo;
	}
 
	/**
	 * Column Info
	 * @return	loclPoNo
	 */
	 public	 String	getLoclPoNo() {
		 return	this.loclPoNo;
	 } 
 	/**
	* Column Info
	* @param  issGrpTpCd
	*/
	public void	setIssGrpTpCd( String	issGrpTpCd ) {
		this.issGrpTpCd =	issGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	issGrpTpCd
	 */
	 public	 String	getIssGrpTpCd() {
		 return	this.issGrpTpCd;
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
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInvRefNo(JSPUtil.getParameter(request,	prefix + "inv_ref_no", ""));
		setCustEml(JSPUtil.getParameter(request,	prefix + "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setInvIssRmk(JSPUtil.getParameter(request,	prefix + "inv_iss_rmk", ""));
		setCustFaxNo(JSPUtil.getParameter(request,	prefix + "cust_fax_no", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setFAdd(JSPUtil.getParameter(request,	prefix + "f_add", ""));
		setFDel(JSPUtil.getParameter(request,	prefix + "f_del", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setAttachView(JSPUtil.getParameter(request,	prefix + "attach_view", ""));
		setAttachView2(JSPUtil.getParameter(request,	prefix + "attach_view2", ""));
		setFCopy(JSPUtil.getParameter(request,	prefix + "f_copy", ""));
		setInvIssCmbFlg(JSPUtil.getParameter(request,	prefix + "inv_iss_cmb_flg", ""));
		setLoclPoNo(JSPUtil.getParameter(request,	prefix + "locl_po_no", ""));
		setIssGrpTpCd(JSPUtil.getParameter(request,	prefix + "iss_grp_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceFaxEmailListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] invRefNo =	(JSPUtil.getParameter(request, prefix +	"inv_ref_no".trim(),	length));
				String[] custEml =	(JSPUtil.getParameter(request, prefix +	"cust_eml".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] invIssRmk =	(JSPUtil.getParameter(request, prefix +	"inv_iss_rmk".trim(),	length));
				String[] custFaxNo =	(JSPUtil.getParameter(request, prefix +	"cust_fax_no".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] fAdd =	(JSPUtil.getParameter(request, prefix +	"f_add".trim(),	length));
				String[] fDel =	(JSPUtil.getParameter(request, prefix +	"f_del".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] attachView =	(JSPUtil.getParameter(request, prefix +	"attach_view".trim(),	length));
				String[] attachView2 =	(JSPUtil.getParameter(request, prefix +	"attach_view2".trim(),	length));
				String[] fCopy =	(JSPUtil.getParameter(request, prefix +	"f_copy".trim(),	length));
				String[] invIssCmbFlg =	(JSPUtil.getParameter(request, prefix +	"inv_iss_cmb_flg".trim(),	length));
				String[] loclPoNo =	(JSPUtil.getParameter(request, prefix +	"locl_po_no".trim(),	length));
				String[] issGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"iss_grp_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceFaxEmailListVO();
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( invRefNo[i] !=	null)
						model.setInvRefNo( invRefNo[i]);
						if ( custEml[i] !=	null)
						model.setCustEml( custEml[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( invIssRmk[i] !=	null)
						model.setInvIssRmk( invIssRmk[i]);
						if ( custFaxNo[i] !=	null)
						model.setCustFaxNo( custFaxNo[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( fAdd[i] !=	null)
						model.setFAdd( fAdd[i]);
						if ( fDel[i] !=	null)
						model.setFDel( fDel[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( attachView[i] !=	null)
						model.setAttachView( attachView[i]);
						if ( attachView2[i] !=	null)
						model.setAttachView2( attachView2[i]);
						if ( fCopy[i] !=	null)
						model.setFCopy( fCopy[i]);
						if ( invIssCmbFlg[i] !=	null)
						model.setInvIssCmbFlg( invIssCmbFlg[i]);
						if ( loclPoNo[i] !=	null)
						model.setLoclPoNo( loclPoNo[i]);
						if ( issGrpTpCd[i] !=	null)
						model.setIssGrpTpCd( issGrpTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceFaxEmailListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[]	 getInvoiceFaxEmailListVOs(){
		InvoiceFaxEmailListVO[] vos = (InvoiceFaxEmailListVO[])models.toArray(new	InvoiceFaxEmailListVO[models.size()]);
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
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo =	this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml =	this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk =	this.invIssRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo =	this.custFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAdd =	this.fAdd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel =	this.fDel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView =	this.attachView.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView2 =	this.attachView2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopy =	this.fCopy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCmbFlg =	this.invIssCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclPoNo =	this.loclPoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issGrpTpCd =	this.issGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}