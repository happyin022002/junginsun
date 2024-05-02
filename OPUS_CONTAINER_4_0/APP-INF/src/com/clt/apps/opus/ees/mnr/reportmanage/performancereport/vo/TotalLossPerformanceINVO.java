/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TotalLossPerformanceINVO.java
 *@FileTitle : TotalLossPerformanceINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.04
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.04  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
public class TotalLossPerformanceINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TotalLossPerformanceINVO>  models =	new	ArrayList<TotalLossPerformanceINVO>();


	/*	Column Info	*/
	private  String	 ttlLssCmplCd   =  null;
	/*	Column Info	*/
	private  String	 fmDt   =  null;
	/*	Column Info	*/
	private  String	 inStatusTp   =  null;
	/*	Column Info	*/
	private  String	 rsnCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 totalLossNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 inSearchDtTp   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDtlRsnCd   =  null;
	/*	Column Info	*/
	private  String	 eqKind   =  null;
	/*	Column Info	*/
	private  String	 rhq   =  null;
	/*	Column Info	*/
	private  String	 ruLableType   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLbl   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TotalLossPerformanceINVO(){}

	public TotalLossPerformanceINVO(String ttlLssCmplCd,String fmDt,String inStatusTp,String rsnCd,String pagerows,String toDt,String totalLossNo,String ofcCd,String ibflag,String eqNo,String inSearchDtTp,String vndrSeq,String ttlLssDtlRsnCd,String eqKind,String rhq,String ruLableType,String rstrUsgLbl)	{
		this.ttlLssCmplCd  = ttlLssCmplCd ;
		this.fmDt  = fmDt ;
		this.inStatusTp  = inStatusTp ;
		this.rsnCd  = rsnCd ;
		this.pagerows  = pagerows ;
		this.toDt  = toDt ;
		this.totalLossNo  = totalLossNo ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.eqNo  = eqNo ;
		this.inSearchDtTp  = inSearchDtTp ;
		this.vndrSeq  = vndrSeq ;
		this.ttlLssDtlRsnCd  = ttlLssDtlRsnCd ;
		this.eqKind  = eqKind ;
		this.rhq  = rhq ;
		this.ruLableType  = ruLableType ;
		this.rstrUsgLbl  = rstrUsgLbl ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_lss_cmpl_cd", getTtlLssCmplCd());		
		this.hashColumns.put("fm_dt", getFmDt());		
		this.hashColumns.put("in_status_tp", getInStatusTp());		
		this.hashColumns.put("rsn_cd", getRsnCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("total_loss_no", getTotalLossNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_no", getEqNo());		
		this.hashColumns.put("in_search_dt_tp", getInSearchDtTp());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());		
		this.hashColumns.put("eq_kind", getEqKind());		
		this.hashColumns.put("rhq", getRhq());		
		this.hashColumns.put("ru_lable_type", getRuLableType());		
		this.hashColumns.put("rstr_usg_lbl", getRstrUsgLbl());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ttl_lss_cmpl_cd", "ttlLssCmplCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("in_status_tp", "inStatusTp");
		this.hashFields.put("rsn_cd", "rsnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("total_loss_no", "totalLossNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("in_search_dt_tp", "inSearchDtTp");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("eq_kind", "eqKind");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ru_lable_type", "ruLableType");
		this.hashFields.put("rstr_usg_lbl", "rstrUsgLbl");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ttlLssCmplCd
	*/
	public void	setTtlLssCmplCd( String	ttlLssCmplCd ) {
		this.ttlLssCmplCd =	ttlLssCmplCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssCmplCd
	 */
	 public	 String	getTtlLssCmplCd() {
		 return	this.ttlLssCmplCd;
	 } 
 	/**
	* Column Info
	* @param  fmDt
	*/
	public void	setFmDt( String	fmDt ) {
		this.fmDt =	fmDt;
	}
 
	/**
	 * Column Info
	 * @return	fmDt
	 */
	 public	 String	getFmDt() {
		 return	this.fmDt;
	 } 
 	/**
	* Column Info
	* @param  inStatusTp
	*/
	public void	setInStatusTp( String	inStatusTp ) {
		this.inStatusTp =	inStatusTp;
	}
 
	/**
	 * Column Info
	 * @return	inStatusTp
	 */
	 public	 String	getInStatusTp() {
		 return	this.inStatusTp;
	 } 
 	/**
	* Column Info
	* @param  rsnCd
	*/
	public void	setRsnCd( String	rsnCd ) {
		this.rsnCd =	rsnCd;
	}
 
	/**
	 * Column Info
	 * @return	rsnCd
	 */
	 public	 String	getRsnCd() {
		 return	this.rsnCd;
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
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
	 } 
 	/**
	* Column Info
	* @param  totalLossNo
	*/
	public void	setTotalLossNo( String	totalLossNo ) {
		this.totalLossNo =	totalLossNo;
	}
 
	/**
	 * Column Info
	 * @return	totalLossNo
	 */
	 public	 String	getTotalLossNo() {
		 return	this.totalLossNo;
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
	* @param  inSearchDtTp
	*/
	public void	setInSearchDtTp( String	inSearchDtTp ) {
		this.inSearchDtTp =	inSearchDtTp;
	}
 
	/**
	 * Column Info
	 * @return	inSearchDtTp
	 */
	 public	 String	getInSearchDtTp() {
		 return	this.inSearchDtTp;
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
	* @param  ttlLssDtlRsnCd
	*/
	public void	setTtlLssDtlRsnCd( String	ttlLssDtlRsnCd ) {
		this.ttlLssDtlRsnCd =	ttlLssDtlRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDtlRsnCd
	 */
	 public	 String	getTtlLssDtlRsnCd() {
		 return	this.ttlLssDtlRsnCd;
	 } 
 	/**
	* Column Info
	* @param  eqKind
	*/
	public void	setEqKind( String	eqKind ) {
		this.eqKind =	eqKind;
	}
 
	/**
	 * Column Info
	 * @return	eqKind
	 */
	 public	 String	getEqKind() {
		 return	this.eqKind;
	 } 
 	/**
	* Column Info
	* @param  rhq
	*/
	public void	setRhq( String	rhq ) {
		this.rhq =	rhq;
	}
 
	/**
	 * Column Info
	 * @return	rhq
	 */
	 public	 String	getRhq() {
		 return	this.rhq;
	 } 
 	/**
	* Column Info
	* @param  ruLableType
	*/
	public void	setRuLableType( String	ruLableType ) {
		this.ruLableType =	ruLableType;
	}
 
	/**
	 * Column Info
	 * @return	ruLableType
	 */
	 public	 String	getRuLableType() {
		 return	this.ruLableType;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLbl
	*/
	public void	setRstrUsgLbl( String	rstrUsgLbl ) {
		this.rstrUsgLbl =	rstrUsgLbl;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLbl
	 */
	 public	 String	getRstrUsgLbl() {
		 return	this.rstrUsgLbl;
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
		setTtlLssCmplCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_cmpl_cd", ""));
		setFmDt(JSPUtil.getParameter(request,	prefix + "fm_dt", ""));
		setInStatusTp(JSPUtil.getParameter(request,	prefix + "in_status_tp", ""));
		setRsnCd(JSPUtil.getParameter(request,	prefix + "rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setTotalLossNo(JSPUtil.getParameter(request,	prefix + "total_loss_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setInSearchDtTp(JSPUtil.getParameter(request,	prefix + "in_search_dt_tp", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_dtl_rsn_cd", ""));
		setEqKind(JSPUtil.getParameter(request,	prefix + "eq_kind", ""));
		setRhq(JSPUtil.getParameter(request,	prefix + "rhq", ""));
		setRuLableType(JSPUtil.getParameter(request,	prefix + "ru_lable_type", ""));
		setRstrUsgLbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TotalLossPerformanceINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ttlLssCmplCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_cmpl_cd".trim(),	length));
				String[] fmDt =	(JSPUtil.getParameter(request, prefix +	"fm_dt".trim(),	length));
				String[] inStatusTp =	(JSPUtil.getParameter(request, prefix +	"in_status_tp".trim(),	length));
				String[] rsnCd =	(JSPUtil.getParameter(request, prefix +	"rsn_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] totalLossNo =	(JSPUtil.getParameter(request, prefix +	"total_loss_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] inSearchDtTp =	(JSPUtil.getParameter(request, prefix +	"in_search_dt_tp".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] ttlLssDtlRsnCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dtl_rsn_cd".trim(),	length));
				String[] eqKind =	(JSPUtil.getParameter(request, prefix +	"eq_kind".trim(),	length));
				String[] rhq =	(JSPUtil.getParameter(request, prefix +	"rhq".trim(),	length));
				String[] ruLableType =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
				String[] rstrUsgLbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TotalLossPerformanceINVO();
						if ( ttlLssCmplCd[i] !=	null)
						model.setTtlLssCmplCd( ttlLssCmplCd[i]);
						if ( fmDt[i] !=	null)
						model.setFmDt( fmDt[i]);
						if ( inStatusTp[i] !=	null)
						model.setInStatusTp( inStatusTp[i]);
						if ( rsnCd[i] !=	null)
						model.setRsnCd( rsnCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( totalLossNo[i] !=	null)
						model.setTotalLossNo( totalLossNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( inSearchDtTp[i] !=	null)
						model.setInSearchDtTp( inSearchDtTp[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( ttlLssDtlRsnCd[i] !=	null)
						model.setTtlLssDtlRsnCd( ttlLssDtlRsnCd[i]);
						if ( eqKind[i] !=	null)
						model.setEqKind( eqKind[i]);
						if ( rhq[i] !=	null)
						model.setRhq( rhq[i]);
						if ( ruLableType[i] !=	null)
						model.setRuLableType( ruLableType[i]);
						if ( rstrUsgLbl[i] !=	null)
						model.setRstrUsgLbl( rstrUsgLbl[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTotalLossPerformanceINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TotalLossPerformanceINVO[]
	 */
	public TotalLossPerformanceINVO[]	 getTotalLossPerformanceINVOs(){
		TotalLossPerformanceINVO[] vos = (TotalLossPerformanceINVO[])models.toArray(new	TotalLossPerformanceINVO[models.size()]);
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
		this.ttlLssCmplCd =	this.ttlLssCmplCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt =	this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inStatusTp =	this.inStatusTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCd =	this.rsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLossNo =	this.totalLossNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSearchDtTp =	this.inSearchDtTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd =	this.ttlLssDtlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKind =	this.eqKind.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq =	this.rhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLableType =	this.ruLableType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLbl =	this.rstrUsgLbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}