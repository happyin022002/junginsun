/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : XterCntrVO.java
 *@FileTitle : XterCntrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.04.14  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class XterCntrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<XterCntrVO>  models =	new	ArrayList<XterCntrVO>();


	/*	Column Info	*/
	private  String	 cntrWgt   =  null;
	/*	Column Info	*/
	private  String	 prtFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 poNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntrNoOld   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrSeq   =  null;
	/*	Column Info	*/
	private  String	 wgtUtCd   =  null;
	/*	Column Info	*/
	private  String	 measQty   =  null;
	/*	Column Info	*/
	private  String	 pckQty   =  null;
	/*	Column Info	*/
	private  String	 cntrSealNo   =  null;
	/*	Column Info	*/
	private  String	 pckTpCd   =  null;
	/*	Column Info	*/
	private  String	 measUtCd   =  null;
	/*	Column Info	*/
	private  String	 vgmWgt   =  null;
	/*	Column Info	*/
	private  String	 vgmWgtUtCd   =  null;
	/*	Column Info	*/
	private  String	 vgmDtmnDt   =  null;
	/*	Column Info	*/
	private  String	 vgmMzdTpCd   =  null;
	/*	Column Info	*/
	private  String	 vgmVrfyDt   =  null;
	/*	Column Info	*/
	private  String	 vgmVrfySigCtnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public XterCntrVO(){}

	public XterCntrVO(String cntrWgt,String prtFlg,String pagerows,String poNo,String ibflag,String cntrNoOld,String cntrNo,String cntrTpszCd,String cntrSeq,String wgtUtCd,String measQty,String pckQty,String cntrSealNo,String pckTpCd,String measUtCd,String vgmWgt,String vgmWgtUtCd,String vgmDtmnDt,String vgmMzdTpCd,String vgmVrfyDt,String vgmVrfySigCtnt)	{
		this.cntrWgt  = cntrWgt ;
		this.prtFlg  = prtFlg ;
		this.pagerows  = pagerows ;
		this.poNo  = poNo ;
		this.ibflag  = ibflag ;
		this.cntrNoOld  = cntrNoOld ;
		this.cntrNo  = cntrNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrSeq  = cntrSeq ;
		this.wgtUtCd  = wgtUtCd ;
		this.measQty  = measQty ;
		this.pckQty  = pckQty ;
		this.cntrSealNo  = cntrSealNo ;
		this.pckTpCd  = pckTpCd ;
		this.measUtCd  = measUtCd ;
		this.vgmWgt  = vgmWgt ;
		this.vgmWgtUtCd  = vgmWgtUtCd ;
		this.vgmDtmnDt  = vgmDtmnDt ;
		this.vgmMzdTpCd  = vgmMzdTpCd ;
		this.vgmVrfyDt  = vgmVrfyDt ;
		this.vgmVrfySigCtnt  = vgmVrfySigCtnt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());		
		this.hashColumns.put("prt_flg", getPrtFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("po_no", getPoNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_no_old", getCntrNoOld());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_seq", getCntrSeq());		
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());		
		this.hashColumns.put("meas_qty", getMeasQty());		
		this.hashColumns.put("pck_qty", getPckQty());		
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());		
		this.hashColumns.put("pck_tp_cd", getPckTpCd());		
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());		
		this.hashColumns.put("vgm_wgt", getVgmWgt());		
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());		
		this.hashColumns.put("vgm_dtmn_dt", getVgmDtmnDt());		
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());		
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());		
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("prt_flg", "prtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no_old", "cntrNoOld");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vgm_dtmn_dt", "vgmDtmnDt");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrWgt
	*/
	public void	setCntrWgt( String	cntrWgt ) {
		this.cntrWgt =	cntrWgt;
	}
 
	/**
	 * Column Info
	 * @return	cntrWgt
	 */
	 public	String	getCntrWgt() {
		 return	this.cntrWgt;
	 } 
 	/**
	* Column Info
	* @param  prtFlg
	*/
	public void	setPrtFlg( String	prtFlg ) {
		this.prtFlg =	prtFlg;
	}
 
	/**
	 * Column Info
	 * @return	prtFlg
	 */
	 public	String	getPrtFlg() {
		 return	this.prtFlg;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  poNo
	*/
	public void	setPoNo( String	poNo ) {
		this.poNo =	poNo;
	}
 
	/**
	 * Column Info
	 * @return	poNo
	 */
	 public	String	getPoNo() {
		 return	this.poNo;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  cntrNoOld
	*/
	public void	setCntrNoOld( String	cntrNoOld ) {
		this.cntrNoOld =	cntrNoOld;
	}
 
	/**
	 * Column Info
	 * @return	cntrNoOld
	 */
	 public	String	getCntrNoOld() {
		 return	this.cntrNoOld;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	String	getCntrNo() {
		 return	this.cntrNo;
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
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  cntrSeq
	*/
	public void	setCntrSeq( String	cntrSeq ) {
		this.cntrSeq =	cntrSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrSeq
	 */
	 public	String	getCntrSeq() {
		 return	this.cntrSeq;
	 } 
 	/**
	* Column Info
	* @param  wgtUtCd
	*/
	public void	setWgtUtCd( String	wgtUtCd ) {
		this.wgtUtCd =	wgtUtCd;
	}
 
	/**
	 * Column Info
	 * @return	wgtUtCd
	 */
	 public	String	getWgtUtCd() {
		 return	this.wgtUtCd;
	 } 
 	/**
	* Column Info
	* @param  measQty
	*/
	public void	setMeasQty( String	measQty ) {
		this.measQty =	measQty;
	}
 
	/**
	 * Column Info
	 * @return	measQty
	 */
	 public	String	getMeasQty() {
		 return	this.measQty;
	 } 
 	/**
	* Column Info
	* @param  pckQty
	*/
	public void	setPckQty( String	pckQty ) {
		this.pckQty =	pckQty;
	}
 
	/**
	 * Column Info
	 * @return	pckQty
	 */
	 public	String	getPckQty() {
		 return	this.pckQty;
	 } 
 	/**
	* Column Info
	* @param  cntrSealNo
	*/
	public void	setCntrSealNo( String	cntrSealNo ) {
		this.cntrSealNo =	cntrSealNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSealNo
	 */
	 public	String	getCntrSealNo() {
		 return	this.cntrSealNo;
	 } 
 	/**
	* Column Info
	* @param  pckTpCd
	*/
	public void	setPckTpCd( String	pckTpCd ) {
		this.pckTpCd =	pckTpCd;
	}
 
	/**
	 * Column Info
	 * @return	pckTpCd
	 */
	 public	String	getPckTpCd() {
		 return	this.pckTpCd;
	 } 
 	/**
	* Column Info
	* @param  measUtCd
	*/
	public void	setMeasUtCd( String	measUtCd ) {
		this.measUtCd =	measUtCd;
	}
 
	/**
	 * Column Info
	 * @return	measUtCd
	 */
	 public	String	getMeasUtCd() {
		 return	this.measUtCd;
	 } 
 	/**
	* Column Info
	* @param  vgmWgt
	*/
	public void	setVgmWgt( String	vgmWgt ) {
		this.vgmWgt =	vgmWgt;
	}
 
	/**
	 * Column Info
	 * @return	vgmWgt
	 */
	 public	String	getVgmWgt() {
		 return	this.vgmWgt;
	 } 
 	/**
	* Column Info
	* @param  vgmWgtUtCd
	*/
	public void	setVgmWgtUtCd( String	vgmWgtUtCd ) {
		this.vgmWgtUtCd =	vgmWgtUtCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmWgtUtCd
	 */
	 public	String	getVgmWgtUtCd() {
		 return	this.vgmWgtUtCd;
	 } 
 	/**
	* Column Info
	* @param  vgmDtmnDt
	*/
	public void	setVgmDtmnDt( String	vgmDtmnDt ) {
		this.vgmDtmnDt =	vgmDtmnDt;
	}
 
	/**
	 * Column Info
	 * @return	vgmDtmnDt
	 */
	 public	String	getVgmDtmnDt() {
		 return	this.vgmDtmnDt;
	 } 
 	/**
	* Column Info
	* @param  vgmMzdTpCd
	*/
	public void	setVgmMzdTpCd( String	vgmMzdTpCd ) {
		this.vgmMzdTpCd =	vgmMzdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmMzdTpCd
	 */
	 public	String	getVgmMzdTpCd() {
		 return	this.vgmMzdTpCd;
	 } 
 	/**
	* Column Info
	* @param  vgmVrfyDt
	*/
	public void	setVgmVrfyDt( String	vgmVrfyDt ) {
		this.vgmVrfyDt =	vgmVrfyDt;
	}
 
	/**
	 * Column Info
	 * @return	vgmVrfyDt
	 */
	 public	String	getVgmVrfyDt() {
		 return	this.vgmVrfyDt;
	 } 
 	/**
	* Column Info
	* @param  vgmVrfySigCtnt
	*/
	public void	setVgmVrfySigCtnt( String	vgmVrfySigCtnt ) {
		this.vgmVrfySigCtnt =	vgmVrfySigCtnt;
	}
 
	/**
	 * Column Info
	 * @return	vgmVrfySigCtnt
	 */
	 public	String	getVgmVrfySigCtnt() {
		 return	this.vgmVrfySigCtnt;
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
		setCntrWgt(JSPUtil.getParameter(request,	prefix + "cntr_wgt", ""));
		setPrtFlg(JSPUtil.getParameter(request,	prefix + "prt_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPoNo(JSPUtil.getParameter(request,	prefix + "po_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntrNoOld(JSPUtil.getParameter(request,	prefix + "cntr_no_old", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrSeq(JSPUtil.getParameter(request,	prefix + "cntr_seq", ""));
		setWgtUtCd(JSPUtil.getParameter(request,	prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request,	prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request,	prefix + "pck_qty", ""));
		setCntrSealNo(JSPUtil.getParameter(request,	prefix + "cntr_seal_no", ""));
		setPckTpCd(JSPUtil.getParameter(request,	prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request,	prefix + "meas_ut_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request,	prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request,	prefix + "vgm_wgt_ut_cd", ""));
		setVgmDtmnDt(JSPUtil.getParameter(request,	prefix + "vgm_dtmn_dt", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request,	prefix + "vgm_mzd_tp_cd", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request,	prefix + "vgm_vrfy_dt", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request,	prefix + "vgm_vrfy_sig_ctnt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterCntrVO[]
	 */
	public XterCntrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return XterCntrVO[]
	 */
	public XterCntrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		XterCntrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_wgt".trim(),	length));
				String[] prtFlg =	(JSPUtil.getParameter(request, prefix +	"prt_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] poNo =	(JSPUtil.getParameter(request, prefix +	"po_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntrNoOld =	(JSPUtil.getParameter(request, prefix +	"cntr_no_old".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_seq".trim(),	length));
				String[] wgtUtCd =	(JSPUtil.getParameter(request, prefix +	"wgt_ut_cd".trim(),	length));
				String[] measQty =	(JSPUtil.getParameter(request, prefix +	"meas_qty".trim(),	length));
				String[] pckQty =	(JSPUtil.getParameter(request, prefix +	"pck_qty".trim(),	length));
				String[] cntrSealNo =	(JSPUtil.getParameter(request, prefix +	"cntr_seal_no".trim(),	length));
				String[] pckTpCd =	(JSPUtil.getParameter(request, prefix +	"pck_tp_cd".trim(),	length));
				String[] measUtCd =	(JSPUtil.getParameter(request, prefix +	"meas_ut_cd".trim(),	length));
				String[] vgmWgt =	(JSPUtil.getParameter(request, prefix +	"vgm_wgt".trim(),	length));
				String[] vgmWgtUtCd =	(JSPUtil.getParameter(request, prefix +	"vgm_wgt_ut_cd".trim(),	length));
				String[] vgmDtmnDt =	(JSPUtil.getParameter(request, prefix +	"vgm_dtmn_dt".trim(),	length));
				String[] vgmMzdTpCd =	(JSPUtil.getParameter(request, prefix +	"vgm_mzd_tp_cd".trim(),	length));
				String[] vgmVrfyDt =	(JSPUtil.getParameter(request, prefix +	"vgm_vrfy_dt".trim(),	length));
				String[] vgmVrfySigCtnt =	(JSPUtil.getParameter(request, prefix +	"vgm_vrfy_sig_ctnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	XterCntrVO();
						if ( cntrWgt[i] !=	null)
						model.setCntrWgt( cntrWgt[i]);
						if ( prtFlg[i] !=	null)
						model.setPrtFlg( prtFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( poNo[i] !=	null)
						model.setPoNo( poNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntrNoOld[i] !=	null)
						model.setCntrNoOld( cntrNoOld[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrSeq[i] !=	null)
						model.setCntrSeq( cntrSeq[i]);
						if ( wgtUtCd[i] !=	null)
						model.setWgtUtCd( wgtUtCd[i]);
						if ( measQty[i] !=	null)
						model.setMeasQty( measQty[i]);
						if ( pckQty[i] !=	null)
						model.setPckQty( pckQty[i]);
						if ( cntrSealNo[i] !=	null)
						model.setCntrSealNo( cntrSealNo[i]);
						if ( pckTpCd[i] !=	null)
						model.setPckTpCd( pckTpCd[i]);
						if ( measUtCd[i] !=	null)
						model.setMeasUtCd( measUtCd[i]);
						if ( vgmWgt[i] !=	null)
						model.setVgmWgt( vgmWgt[i]);
						if ( vgmWgtUtCd[i] !=	null)
						model.setVgmWgtUtCd( vgmWgtUtCd[i]);
						if ( vgmDtmnDt[i] !=	null)
						model.setVgmDtmnDt( vgmDtmnDt[i]);
						if ( vgmMzdTpCd[i] !=	null)
						model.setVgmMzdTpCd( vgmMzdTpCd[i]);
						if ( vgmVrfyDt[i] !=	null)
						model.setVgmVrfyDt( vgmVrfyDt[i]);
						if ( vgmVrfySigCtnt[i] !=	null)
						model.setVgmVrfySigCtnt( vgmVrfySigCtnt[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getXterCntrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return XterCntrVO[]
	 */
	public XterCntrVO[]	 getXterCntrVOs(){
		XterCntrVO[] vos = (XterCntrVO[])models.toArray(new	XterCntrVO[models.size()]);
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
	public void	unDataFormat(){
		this.cntrWgt =	this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtFlg =	this.prtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo =	this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoOld =	this.cntrNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq =	this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd =	this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty =	this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty =	this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo =	this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd =	this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd =	this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt =	this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd =	this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtmnDt =	this.vgmDtmnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd =	this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt =	this.vgmVrfyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt =	this.vgmVrfySigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}