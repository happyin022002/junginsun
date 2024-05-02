/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterCntrMkDescVO.java
 *@FileTitle : BkgXterCntrMkDescVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.11  
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
public class BkgXterCntrMkDescVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterCntrMkDescVO>  models =	new	ArrayList<BkgXterCntrMkDescVO>();


	/*	Column Info	*/
	private  String	 hamoTrfCd   =  null;
	/*	Column Info	*/
	private  String	 ncmNo   =  null;
	/*	Column Info	*/
	private  String	 cntrMfWgt   =  null;
	/*	Column Info	*/
	private  String	 cntrMfDtlDesc   =  null;
	/*	Column Info	*/
	private  String	 cntrMfMkDesc   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 poNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 wgtUtCd   =  null;
	/*	Column Info	*/
	private  String	 measQty   =  null;
	/*	Column Info	*/
	private  String	 cntrMfSeq   =  null;
	/*	Column Info	*/
	private  String	 pckQty   =  null;
	/*	Column Info	*/
	private  String	 cntrMfGdsDesc   =  null;
	/*	Column Info	*/
	private  String	 pckTpCd   =  null;
	/*	Column Info	*/
	private  String	 measUtCd   =  null;
	/*	Column Info	*/
	private  String	 dcgoSeq   =  null;
	/*	Column Info	*/
	private  String	 cmdtHsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrMfNo   =  null;
	/*	Column Info	*/
	private  String	 siNo   =  null;
	/*	Column Info	*/
	private  String	 xterRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 ncmMultiNo   =  null;
	/*	Column Info	*/
	private  String	 wpmTrtCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterCntrMkDescVO(){}

	public BkgXterCntrMkDescVO(String hamoTrfCd,String ncmNo,String cntrMfWgt,String cntrMfDtlDesc,String cntrMfMkDesc,String pagerows,String ibflag,String poNo,String cntrNo,String wgtUtCd,String measQty,String cntrMfSeq,String pckQty,String cntrMfGdsDesc,String pckTpCd,String measUtCd,String dcgoSeq,String cmdtHsCd,String cntrMfNo,String siNo,String xterRqstSeq,String ncmMultiNo,String wpmTrtCd)	{
		this.hamoTrfCd  = hamoTrfCd ;
		this.ncmNo  = ncmNo ;
		this.cntrMfWgt  = cntrMfWgt ;
		this.cntrMfDtlDesc  = cntrMfDtlDesc ;
		this.cntrMfMkDesc  = cntrMfMkDesc ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.poNo  = poNo ;
		this.cntrNo  = cntrNo ;
		this.wgtUtCd  = wgtUtCd ;
		this.measQty  = measQty ;
		this.cntrMfSeq  = cntrMfSeq ;
		this.pckQty  = pckQty ;
		this.cntrMfGdsDesc  = cntrMfGdsDesc ;
		this.pckTpCd  = pckTpCd ;
		this.measUtCd  = measUtCd ;
		this.dcgoSeq  = dcgoSeq ;
		this.cmdtHsCd  = cmdtHsCd ;
		this.cntrMfNo  = cntrMfNo ;
		this.siNo  = siNo ;
		this.xterRqstSeq  = xterRqstSeq ;
		this.ncmMultiNo  = ncmMultiNo ;
		this.wpmTrtCd  = wpmTrtCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());		
		this.hashColumns.put("ncm_no", getNcmNo());		
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());		
		this.hashColumns.put("cntr_mf_dtl_desc", getCntrMfDtlDesc());		
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("po_no", getPoNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());		
		this.hashColumns.put("meas_qty", getMeasQty());		
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());		
		this.hashColumns.put("pck_qty", getPckQty());		
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());		
		this.hashColumns.put("pck_tp_cd", getPckTpCd());		
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());		
		this.hashColumns.put("dcgo_seq", getDcgoSeq());		
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());		
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());		
		this.hashColumns.put("si_no", getSiNo());		
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());		
		this.hashColumns.put("ncm_multi_no", getNcmMultiNo());		
		this.hashColumns.put("wpm_trt_cd", getWpmTrtCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("cntr_mf_dtl_desc", "cntrMfDtlDesc");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("si_no", "siNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("ncm_multi_no", "ncmMultiNo");
		this.hashFields.put("wpm_trt_cd", "wpmTrtCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  hamoTrfCd
	*/
	public void	setHamoTrfCd( String	hamoTrfCd ) {
		this.hamoTrfCd =	hamoTrfCd;
	}
 
	/**
	 * Column Info
	 * @return	hamoTrfCd
	 */
	 public	String	getHamoTrfCd() {
		 return	this.hamoTrfCd;
	 } 
 	/**
	* Column Info
	* @param  ncmNo
	*/
	public void	setNcmNo( String	ncmNo ) {
		this.ncmNo =	ncmNo;
	}
 
	/**
	 * Column Info
	 * @return	ncmNo
	 */
	 public	String	getNcmNo() {
		 return	this.ncmNo;
	 } 
 	/**
	* Column Info
	* @param  cntrMfWgt
	*/
	public void	setCntrMfWgt( String	cntrMfWgt ) {
		this.cntrMfWgt =	cntrMfWgt;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfWgt
	 */
	 public	String	getCntrMfWgt() {
		 return	this.cntrMfWgt;
	 } 
 	/**
	* Column Info
	* @param  cntrMfDtlDesc
	*/
	public void	setCntrMfDtlDesc( String	cntrMfDtlDesc ) {
		this.cntrMfDtlDesc =	cntrMfDtlDesc;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfDtlDesc
	 */
	 public	String	getCntrMfDtlDesc() {
		 return	this.cntrMfDtlDesc;
	 } 
 	/**
	* Column Info
	* @param  cntrMfMkDesc
	*/
	public void	setCntrMfMkDesc( String	cntrMfMkDesc ) {
		this.cntrMfMkDesc =	cntrMfMkDesc;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfMkDesc
	 */
	 public	String	getCntrMfMkDesc() {
		 return	this.cntrMfMkDesc;
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
	* @param  cntrMfSeq
	*/
	public void	setCntrMfSeq( String	cntrMfSeq ) {
		this.cntrMfSeq =	cntrMfSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfSeq
	 */
	 public	String	getCntrMfSeq() {
		 return	this.cntrMfSeq;
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
	* @param  cntrMfGdsDesc
	*/
	public void	setCntrMfGdsDesc( String	cntrMfGdsDesc ) {
		this.cntrMfGdsDesc =	cntrMfGdsDesc;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfGdsDesc
	 */
	 public	String	getCntrMfGdsDesc() {
		 return	this.cntrMfGdsDesc;
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
	* @param  dcgoSeq
	*/
	public void	setDcgoSeq( String	dcgoSeq ) {
		this.dcgoSeq =	dcgoSeq;
	}
 
	/**
	 * Column Info
	 * @return	dcgoSeq
	 */
	 public	String	getDcgoSeq() {
		 return	this.dcgoSeq;
	 } 
 	/**
	* Column Info
	* @param  cmdtHsCd
	*/
	public void	setCmdtHsCd( String	cmdtHsCd ) {
		this.cmdtHsCd =	cmdtHsCd;
	}
 
	/**
	 * Column Info
	 * @return	cmdtHsCd
	 */
	 public	String	getCmdtHsCd() {
		 return	this.cmdtHsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrMfNo
	*/
	public void	setCntrMfNo( String	cntrMfNo ) {
		this.cntrMfNo =	cntrMfNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrMfNo
	 */
	 public	String	getCntrMfNo() {
		 return	this.cntrMfNo;
	 } 
 	/**
	* Column Info
	* @param  siNo
	*/
	public void	setSiNo( String	siNo ) {
		this.siNo =	siNo;
	}
 
	/**
	 * Column Info
	 * @return	siNo
	 */
	 public	String	getSiNo() {
		 return	this.siNo;
	 } 
 	/**
	* Column Info
	* @param  xterRqstSeq
	*/
	public void	setXterRqstSeq( String	xterRqstSeq ) {
		this.xterRqstSeq =	xterRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterRqstSeq
	 */
	 public	String	getXterRqstSeq() {
		 return	this.xterRqstSeq;
	 } 
 	/**
	* Column Info
	* @param  ncmMultiNo
	*/
	public void	setNcmMultiNo( String	ncmMultiNo ) {
		this.ncmMultiNo =	ncmMultiNo;
	}
 
	/**
	 * Column Info
	 * @return	ncmMultiNo
	 */
	 public	String	getNcmMultiNo() {
		 return	this.ncmMultiNo;
	 } 
 	/**
	* Column Info
	* @param  wpmTrtCd
	*/
	public void	setWpmTrtCd( String	wpmTrtCd ) {
		this.wpmTrtCd =	wpmTrtCd;
	}
 
	/**
	 * Column Info
	 * @return	wpmTrtCd
	 */
	 public	String	getWpmTrtCd() {
		 return	this.wpmTrtCd;
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
		setHamoTrfCd(JSPUtil.getParameter(request,	prefix + "hamo_trf_cd", ""));
		setNcmNo(JSPUtil.getParameter(request,	prefix + "ncm_no", ""));
		setCntrMfWgt(JSPUtil.getParameter(request,	prefix + "cntr_mf_wgt", ""));
		setCntrMfDtlDesc(JSPUtil.getParameter(request,	prefix + "cntr_mf_dtl_desc", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request,	prefix + "cntr_mf_mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPoNo(JSPUtil.getParameter(request,	prefix + "po_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request,	prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request,	prefix + "meas_qty", ""));
		setCntrMfSeq(JSPUtil.getParameter(request,	prefix + "cntr_mf_seq", ""));
		setPckQty(JSPUtil.getParameter(request,	prefix + "pck_qty", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request,	prefix + "cntr_mf_gds_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request,	prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request,	prefix + "meas_ut_cd", ""));
		setDcgoSeq(JSPUtil.getParameter(request,	prefix + "dcgo_seq", ""));
		setCmdtHsCd(JSPUtil.getParameter(request,	prefix + "cmdt_hs_cd", ""));
		setCntrMfNo(JSPUtil.getParameter(request,	prefix + "cntr_mf_no", ""));
		setSiNo(JSPUtil.getParameter(request,	prefix + "si_no", ""));
		setXterRqstSeq(JSPUtil.getParameter(request,	prefix + "xter_rqst_seq", ""));
		setNcmMultiNo(JSPUtil.getParameter(request,	prefix + "ncm_multi_no", ""));
		setWpmTrtCd(JSPUtil.getParameter(request,	prefix + "wpm_trt_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterCntrMkDescVO[]
	 */
	public BkgXterCntrMkDescVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterCntrMkDescVO[]
	 */
	public BkgXterCntrMkDescVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterCntrMkDescVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] hamoTrfCd =	(JSPUtil.getParameter(request, prefix +	"hamo_trf_cd".trim(),	length));
				String[] ncmNo =	(JSPUtil.getParameter(request, prefix +	"ncm_no".trim(),	length));
				String[] cntrMfWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_wgt".trim(),	length));
				String[] cntrMfDtlDesc =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_dtl_desc".trim(),	length));
				String[] cntrMfMkDesc =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_mk_desc".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] poNo =	(JSPUtil.getParameter(request, prefix +	"po_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] wgtUtCd =	(JSPUtil.getParameter(request, prefix +	"wgt_ut_cd".trim(),	length));
				String[] measQty =	(JSPUtil.getParameter(request, prefix +	"meas_qty".trim(),	length));
				String[] cntrMfSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_seq".trim(),	length));
				String[] pckQty =	(JSPUtil.getParameter(request, prefix +	"pck_qty".trim(),	length));
				String[] cntrMfGdsDesc =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_gds_desc".trim(),	length));
				String[] pckTpCd =	(JSPUtil.getParameter(request, prefix +	"pck_tp_cd".trim(),	length));
				String[] measUtCd =	(JSPUtil.getParameter(request, prefix +	"meas_ut_cd".trim(),	length));
				String[] dcgoSeq =	(JSPUtil.getParameter(request, prefix +	"dcgo_seq".trim(),	length));
				String[] cmdtHsCd =	(JSPUtil.getParameter(request, prefix +	"cmdt_hs_cd".trim(),	length));
				String[] cntrMfNo =	(JSPUtil.getParameter(request, prefix +	"cntr_mf_no".trim(),	length));
				String[] siNo =	(JSPUtil.getParameter(request, prefix +	"si_no".trim(),	length));
				String[] xterRqstSeq =	(JSPUtil.getParameter(request, prefix +	"xter_rqst_seq".trim(),	length));
				String[] ncmMultiNo =	(JSPUtil.getParameter(request, prefix +	"ncm_multi_no".trim(),	length));
				String[] wpmTrtCd =	(JSPUtil.getParameter(request, prefix +	"wpm_trt_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterCntrMkDescVO();
						if ( hamoTrfCd[i] !=	null)
						model.setHamoTrfCd( hamoTrfCd[i]);
						if ( ncmNo[i] !=	null)
						model.setNcmNo( ncmNo[i]);
						if ( cntrMfWgt[i] !=	null)
						model.setCntrMfWgt( cntrMfWgt[i]);
						if ( cntrMfDtlDesc[i] !=	null)
						model.setCntrMfDtlDesc( cntrMfDtlDesc[i]);
						if ( cntrMfMkDesc[i] !=	null)
						model.setCntrMfMkDesc( cntrMfMkDesc[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( poNo[i] !=	null)
						model.setPoNo( poNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( wgtUtCd[i] !=	null)
						model.setWgtUtCd( wgtUtCd[i]);
						if ( measQty[i] !=	null)
						model.setMeasQty( measQty[i]);
						if ( cntrMfSeq[i] !=	null)
						model.setCntrMfSeq( cntrMfSeq[i]);
						if ( pckQty[i] !=	null)
						model.setPckQty( pckQty[i]);
						if ( cntrMfGdsDesc[i] !=	null)
						model.setCntrMfGdsDesc( cntrMfGdsDesc[i]);
						if ( pckTpCd[i] !=	null)
						model.setPckTpCd( pckTpCd[i]);
						if ( measUtCd[i] !=	null)
						model.setMeasUtCd( measUtCd[i]);
						if ( dcgoSeq[i] !=	null)
						model.setDcgoSeq( dcgoSeq[i]);
						if ( cmdtHsCd[i] !=	null)
						model.setCmdtHsCd( cmdtHsCd[i]);
						if ( cntrMfNo[i] !=	null)
						model.setCntrMfNo( cntrMfNo[i]);
						if ( siNo[i] !=	null)
						model.setSiNo( siNo[i]);
						if ( xterRqstSeq[i] !=	null)
						model.setXterRqstSeq( xterRqstSeq[i]);
						if ( ncmMultiNo[i] !=	null)
						model.setNcmMultiNo( ncmMultiNo[i]);
						if ( wpmTrtCd[i] !=	null)
						model.setWpmTrtCd( wpmTrtCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterCntrMkDescVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterCntrMkDescVO[]
	 */
	public BkgXterCntrMkDescVO[]	 getBkgXterCntrMkDescVOs(){
		BkgXterCntrMkDescVO[] vos = (BkgXterCntrMkDescVO[])models.toArray(new	BkgXterCntrMkDescVO[models.size()]);
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
		this.hamoTrfCd =	this.hamoTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo =	this.ncmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt =	this.cntrMfWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDtlDesc =	this.cntrMfDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc =	this.cntrMfMkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo =	this.poNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd =	this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty =	this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq =	this.cntrMfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty =	this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc =	this.cntrMfGdsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd =	this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd =	this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq =	this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd =	this.cmdtHsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo =	this.cntrMfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNo =	this.siNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq =	this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmMultiNo =	this.ncmMultiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wpmTrtCd =	this.wpmTrtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}