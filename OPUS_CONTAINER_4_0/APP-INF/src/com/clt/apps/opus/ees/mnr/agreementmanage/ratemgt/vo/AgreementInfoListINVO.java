/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AgreementInfoListINVO.java
 *@FileTitle : AgreementInfoListINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.23
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.23  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo;

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
public class AgreementInfoListINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AgreementInfoListINVO>  models =	new	ArrayList<AgreementInfoListINVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 agmtEqType   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 arHdQtrCd   =  null;
	/*	Column Info	*/
	private  String	 agmtOfcCd   =  null;
	/*	Column Info	*/
	private  String	 agmtFmDt   =  null;
	/*	Column Info	*/
	private  String	 agmtToDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AgreementInfoListINVO(){}

	public AgreementInfoListINVO(String ibflag,String costOfcCd,String agmtEqType,String vndrSeq,String arHdQtrCd,String agmtOfcCd,String agmtFmDt,String agmtToDt,String pagerows,String oldAgmtNo)	{
		this.ibflag  = ibflag ;
		this.costOfcCd  = costOfcCd ;
		this.agmtEqType  = agmtEqType ;
		this.vndrSeq  = vndrSeq ;
		this.arHdQtrCd  = arHdQtrCd ;
		this.agmtOfcCd  = agmtOfcCd ;
		this.agmtFmDt  = agmtFmDt ;
		this.agmtToDt  = agmtToDt ;
		this.pagerows  = pagerows ;
		this.oldAgmtNo  = oldAgmtNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("agmt_eq_type", getAgmtEqType());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("ar_hd_qtr_cd", getArHdQtrCd());		
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());		
		this.hashColumns.put("agmt_fm_dt", getAgmtFmDt());		
		this.hashColumns.put("agmt_to_dt", getAgmtToDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("agmt_eq_type", "agmtEqType");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ar_hd_qtr_cd", "arHdQtrCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("agmt_fm_dt", "agmtFmDt");
		this.hashFields.put("agmt_to_dt", "agmtToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  costOfcCd
	*/
	public void	setCostOfcCd( String	costOfcCd ) {
		this.costOfcCd =	costOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	costOfcCd
	 */
	 public	 String	getCostOfcCd() {
		 return	this.costOfcCd;
	 } 
 	/**
	* Column Info
	* @param  agmtEqType
	*/
	public void	setAgmtEqType( String	agmtEqType ) {
		this.agmtEqType =	agmtEqType;
	}
 
	/**
	 * Column Info
	 * @return	agmtEqType
	 */
	 public	 String	getAgmtEqType() {
		 return	this.agmtEqType;
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
	* @param  arHdQtrCd
	*/
	public void	setArHdQtrCd( String	arHdQtrCd ) {
		this.arHdQtrCd =	arHdQtrCd;
	}
 
	/**
	 * Column Info
	 * @return	arHdQtrCd
	 */
	 public	 String	getArHdQtrCd() {
		 return	this.arHdQtrCd;
	 } 
 	/**
	* Column Info
	* @param  agmtOfcCd
	*/
	public void	setAgmtOfcCd( String	agmtOfcCd ) {
		this.agmtOfcCd =	agmtOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtOfcCd
	 */
	 public	 String	getAgmtOfcCd() {
		 return	this.agmtOfcCd;
	 } 
 	/**
	* Column Info
	* @param  agmtFmDt
	*/
	public void	setAgmtFmDt( String	agmtFmDt ) {
		this.agmtFmDt =	agmtFmDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtFmDt
	 */
	 public	 String	getAgmtFmDt() {
		 return	this.agmtFmDt;
	 } 
 	/**
	* Column Info
	* @param  agmtToDt
	*/
	public void	setAgmtToDt( String	agmtToDt ) {
		this.agmtToDt =	agmtToDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtToDt
	 */
	 public	 String	getAgmtToDt() {
		 return	this.agmtToDt;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setAgmtEqType(JSPUtil.getParameter(request,	prefix + "agmt_eq_type", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setArHdQtrCd(JSPUtil.getParameter(request,	prefix + "ar_hd_qtr_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request,	prefix + "agmt_ofc_cd", ""));
		setAgmtFmDt(JSPUtil.getParameter(request,	prefix + "agmt_fm_dt", ""));
		setAgmtToDt(JSPUtil.getParameter(request,	prefix + "agmt_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOldAgmtNo(JSPUtil.getParameter(request,	prefix + "old_agmt_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AgreementInfoListINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] agmtEqType =	(JSPUtil.getParameter(request, prefix +	"agmt_eq_type".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] arHdQtrCd =	(JSPUtil.getParameter(request, prefix +	"ar_hd_qtr_cd".trim(),	length));
				String[] agmtOfcCd =	(JSPUtil.getParameter(request, prefix +	"agmt_ofc_cd".trim(),	length));
				String[] agmtFmDt =	(JSPUtil.getParameter(request, prefix +	"agmt_fm_dt".trim(),	length));
				String[] agmtToDt =	(JSPUtil.getParameter(request, prefix +	"agmt_to_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] oldAgmtNo =	(JSPUtil.getParameter(request, prefix +	"old_agmt_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AgreementInfoListINVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( agmtEqType[i] !=	null)
						model.setAgmtEqType( agmtEqType[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( arHdQtrCd[i] !=	null)
						model.setArHdQtrCd( arHdQtrCd[i]);
						if ( agmtOfcCd[i] !=	null)
						model.setAgmtOfcCd( agmtOfcCd[i]);
						if ( agmtFmDt[i] !=	null)
						model.setAgmtFmDt( agmtFmDt[i]);
						if ( agmtToDt[i] !=	null)
						model.setAgmtToDt( agmtToDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( oldAgmtNo[i] !=	null)
						model.setOldAgmtNo( oldAgmtNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAgreementInfoListINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[]	 getAgreementInfoListINVOs(){
		AgreementInfoListINVO[] vos = (AgreementInfoListINVO[])models.toArray(new	AgreementInfoListINVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtEqType =	this.agmtEqType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrCd =	this.arHdQtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd =	this.agmtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDt =	this.agmtFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDt =	this.agmtToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}