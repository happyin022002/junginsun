/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApprovalStaffVO.java
 *@FileTitle : ApprovalStaffVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.02.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.02.01  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.bizcommon.approval.vo;

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
 * - 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ApprovalStaffVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApprovalStaffVO>  models =	new	ArrayList<ApprovalStaffVO>();


	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 subSysCd   =  null;
	/*	Column Info	*/
	private  String	 status   =  null;
	/*	Column Info	*/
	private  String	 mode   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 edate   =  null;
	/*	Column Info	*/
	private  String	 psnEngNm   =  null;
	/*	Column Info	*/
	private  String	 sdate   =  null;
	/*	Column Info	*/
	private  String	 aproRoutSeq   =  null;
	/*	Column Info	*/
	private  String	 ofcCdDeptsrch   =  null;
	/*	Column Info	*/
	private  String	 alpsStatus   =  null;
	/*	Column Info	*/
	private  String	 ifStatus   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApprovalStaffVO(){}

	public ApprovalStaffVO(String csrNo,String subSysCd,String status,String mode,String pagerows,String ofcCd,String ibflag,String usrNm,String usrId,String edate,String psnEngNm,String sdate,String aproRoutSeq,String ofcCdDeptsrch,String alpsStatus,String ifStatus)	{
		this.csrNo  = csrNo ;
		this.subSysCd  = subSysCd ;
		this.status  = status ;
		this.mode  = mode ;
		this.pagerows  = pagerows ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.usrNm  = usrNm ;
		this.usrId  = usrId ;
		this.edate  = edate ;
		this.psnEngNm  = psnEngNm ;
		this.sdate  = sdate ;
		this.aproRoutSeq  = aproRoutSeq ;
		this.ofcCdDeptsrch  = ofcCdDeptsrch ;
		this.alpsStatus  = alpsStatus ;
		this.ifStatus  = ifStatus ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("sub_sys_cd", getSubSysCd());		
		this.hashColumns.put("status", getStatus());		
		this.hashColumns.put("mode", getMode());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("edate", getEdate());		
		this.hashColumns.put("psn_eng_nm", getPsnEngNm());		
		this.hashColumns.put("sdate", getSdate());		
		this.hashColumns.put("apro_rout_seq", getAproRoutSeq());		
		this.hashColumns.put("ofc_cd_deptsrch", getOfcCdDeptsrch());		
		this.hashColumns.put("alps_status", getAlpsStatus());		
		this.hashColumns.put("if_status", getIfStatus());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("psn_eng_nm", "psnEngNm");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("apro_rout_seq", "aproRoutSeq");
		this.hashFields.put("ofc_cd_deptsrch", "ofcCdDeptsrch");
		this.hashFields.put("alps_status", "alpsStatus");
		this.hashFields.put("if_status", "ifStatus");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  csrNo
	*/
	public void	setCsrNo( String	csrNo ) {
		this.csrNo =	csrNo;
	}
 
	/**
	 * Column Info
	 * @return	csrNo
	 */
	 public	 String	getCsrNo() {
		 return	this.csrNo;
	 } 
 	/**
	* Column Info
	* @param  subSysCd
	*/
	public void	setSubSysCd( String	subSysCd ) {
		this.subSysCd =	subSysCd;
	}
 
	/**
	 * Column Info
	 * @return	subSysCd
	 */
	 public	 String	getSubSysCd() {
		 return	this.subSysCd;
	 } 
 	/**
	* Column Info
	* @param  status
	*/
	public void	setStatus( String	status ) {
		this.status =	status;
	}
 
	/**
	 * Column Info
	 * @return	status
	 */
	 public	 String	getStatus() {
		 return	this.status;
	 } 
 	/**
	* Column Info
	* @param  mode
	*/
	public void	setMode( String	mode ) {
		this.mode =	mode;
	}
 
	/**
	 * Column Info
	 * @return	mode
	 */
	 public	 String	getMode() {
		 return	this.mode;
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
	* @param  edate
	*/
	public void	setEdate( String	edate ) {
		this.edate =	edate;
	}
 
	/**
	 * Column Info
	 * @return	edate
	 */
	 public	 String	getEdate() {
		 return	this.edate;
	 } 
 	/**
	* Column Info
	* @param  psnEngNm
	*/
	public void	setPsnEngNm( String	psnEngNm ) {
		this.psnEngNm =	psnEngNm;
	}
 
	/**
	 * Column Info
	 * @return	psnEngNm
	 */
	 public	 String	getPsnEngNm() {
		 return	this.psnEngNm;
	 } 
 	/**
	* Column Info
	* @param  sdate
	*/
	public void	setSdate( String	sdate ) {
		this.sdate =	sdate;
	}
 
	/**
	 * Column Info
	 * @return	sdate
	 */
	 public	 String	getSdate() {
		 return	this.sdate;
	 } 
 	/**
	* Column Info
	* @param  aproRoutSeq
	*/
	public void	setAproRoutSeq( String	aproRoutSeq ) {
		this.aproRoutSeq =	aproRoutSeq;
	}
 
	/**
	 * Column Info
	 * @return	aproRoutSeq
	 */
	 public	 String	getAproRoutSeq() {
		 return	this.aproRoutSeq;
	 } 
 	/**
	* Column Info
	* @param  ofcCdDeptsrch
	*/
	public void	setOfcCdDeptsrch( String	ofcCdDeptsrch ) {
		this.ofcCdDeptsrch =	ofcCdDeptsrch;
	}
 
	/**
	 * Column Info
	 * @return	ofcCdDeptsrch
	 */
	 public	 String	getOfcCdDeptsrch() {
		 return	this.ofcCdDeptsrch;
	 } 
 	/**
	* Column Info
	* @param  alpsStatus
	*/
	public void	setAlpsStatus( String	alpsStatus ) {
		this.alpsStatus =	alpsStatus;
	}
 
	/**
	 * Column Info
	 * @return	alpsStatus
	 */
	 public	 String	getAlpsStatus() {
		 return	this.alpsStatus;
	 } 
 	/**
	* Column Info
	* @param  ifStatus
	*/
	public void	setIfStatus( String	ifStatus ) {
		this.ifStatus =	ifStatus;
	}
 
	/**
	 * Column Info
	 * @return	ifStatus
	 */
	 public	 String	getIfStatus() {
		 return	this.ifStatus;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setSubSysCd(JSPUtil.getParameter(request,	prefix + "sub_sys_cd", ""));
		setStatus(JSPUtil.getParameter(request,	prefix + "status", ""));
		setMode(JSPUtil.getParameter(request,	prefix + "mode", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setEdate(JSPUtil.getParameter(request,	prefix + "edate", ""));
		setPsnEngNm(JSPUtil.getParameter(request,	prefix + "psn_eng_nm", ""));
		setSdate(JSPUtil.getParameter(request,	prefix + "sdate", ""));
		setAproRoutSeq(JSPUtil.getParameter(request,	prefix + "apro_rout_seq", ""));
		setOfcCdDeptsrch(JSPUtil.getParameter(request,	prefix + "ofc_cd_deptsrch", ""));
		setAlpsStatus(JSPUtil.getParameter(request,	prefix + "alps_status", ""));
		setIfStatus(JSPUtil.getParameter(request,	prefix + "if_status", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApprovalStaffVO[]
	 */
	public ApprovalStaffVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApprovalStaffVO[]
	 */
	public ApprovalStaffVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApprovalStaffVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] subSysCd =	(JSPUtil.getParameter(request, prefix +	"sub_sys_cd".trim(),	length));
				String[] status =	(JSPUtil.getParameter(request, prefix +	"status".trim(),	length));
				String[] mode =	(JSPUtil.getParameter(request, prefix +	"mode".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] edate =	(JSPUtil.getParameter(request, prefix +	"edate".trim(),	length));
				String[] psnEngNm =	(JSPUtil.getParameter(request, prefix +	"psn_eng_nm".trim(),	length));
				String[] sdate =	(JSPUtil.getParameter(request, prefix +	"sdate".trim(),	length));
				String[] aproRoutSeq =	(JSPUtil.getParameter(request, prefix +	"apro_rout_seq".trim(),	length));
				String[] ofcCdDeptsrch =	(JSPUtil.getParameter(request, prefix +	"ofc_cd_deptsrch".trim(),	length));
				String[] alpsStatus =	(JSPUtil.getParameter(request, prefix +	"alps_status".trim(),	length));
				String[] ifStatus =	(JSPUtil.getParameter(request, prefix +	"if_status".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApprovalStaffVO();
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( subSysCd[i] !=	null)
						model.setSubSysCd( subSysCd[i]);
						if ( status[i] !=	null)
						model.setStatus( status[i]);
						if ( mode[i] !=	null)
						model.setMode( mode[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( edate[i] !=	null)
						model.setEdate( edate[i]);
						if ( psnEngNm[i] !=	null)
						model.setPsnEngNm( psnEngNm[i]);
						if ( sdate[i] !=	null)
						model.setSdate( sdate[i]);
						if ( aproRoutSeq[i] !=	null)
						model.setAproRoutSeq( aproRoutSeq[i]);
						if ( ofcCdDeptsrch[i] !=	null)
						model.setOfcCdDeptsrch( ofcCdDeptsrch[i]);
						if ( alpsStatus[i] !=	null)
						model.setAlpsStatus( alpsStatus[i]);
						if ( ifStatus[i] !=	null)
						model.setIfStatus( ifStatus[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApprovalStaffVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApprovalStaffVO[]
	 */
	public ApprovalStaffVO[]	 getApprovalStaffVOs(){
		ApprovalStaffVO[] vos = (ApprovalStaffVO[])models.toArray(new	ApprovalStaffVO[models.size()]);
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
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd =	this.subSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status =	this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode =	this.mode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate =	this.edate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psnEngNm =	this.psnEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate =	this.sdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRoutSeq =	this.aproRoutSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdDeptsrch =	this.ofcCdDeptsrch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsStatus =	this.alpsStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifStatus =	this.ifStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}