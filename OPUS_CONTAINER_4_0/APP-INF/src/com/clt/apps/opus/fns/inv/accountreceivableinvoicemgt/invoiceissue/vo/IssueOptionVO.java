/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IssueOptionVO.java
 *@FileTitle : IssueOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.27  
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
public class IssueOptionVO	extends	 AbstractValueObject 
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<IssueOptionVO>  models =	new	ArrayList<IssueOptionVO>();


	/*	Column Info	*/
	private  String	 titleFlag   =  null;
	/*	Column Info	*/
	private  String	 sendFlag   =  null;
	/*	Column Info	*/
	private  String	 sendFlag2   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 issueGubn   =  null;
	/*	Column Info	*/
	private  String	 nameFlag   =  null;
	/*	Column Info	*/
	private  String	 rdName   =  null;
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 sendType   =  null;
	/*	Column Info	*/
	private  String	 issueType   =  null;
	/*	Column Info	*/
	private  String	 copyCnt   =  null;
	/*	Column Info	*/
	private  String	 issLehbb   =  null;
	/*	Column Info	*/
	private  String	 logoGb   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 officeCntCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public IssueOptionVO(){}

	public IssueOptionVO(String titleFlag,String sendFlag,String sendFlag2,String ibflag,String issueGubn,String nameFlag,String rdName,String issOfcCd,String sendType,String issueType,String copyCnt,String issLehbb,String logoGb,String pagerows,String officeCntCd)	{
		this.titleFlag  = titleFlag ;
		this.sendFlag  = sendFlag ;
		this.sendFlag2  = sendFlag2 ;
		this.ibflag  = ibflag ;
		this.issueGubn  = issueGubn ;
		this.nameFlag  = nameFlag ;
		this.rdName  = rdName ;
		this.issOfcCd  = issOfcCd ;
		this.sendType  = sendType ;
		this.issueType  = issueType ;
		this.copyCnt  = copyCnt ;
		this.issLehbb  = issLehbb ;
		this.logoGb  = logoGb ;
		this.pagerows  = pagerows ;
		this.officeCntCd  = officeCntCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("title_flag", getTitleFlag());		
		this.hashColumns.put("send_flag", getSendFlag());		
		this.hashColumns.put("send_flag2", getSendFlag2());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("issue_gubn", getIssueGubn());		
		this.hashColumns.put("name_flag", getNameFlag());		
		this.hashColumns.put("rd_name", getRdName());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("send_type", getSendType());		
		this.hashColumns.put("issue_type", getIssueType());		
		this.hashColumns.put("copy_cnt", getCopyCnt());		
		this.hashColumns.put("iss_lehbb", getIssLehbb());		
		this.hashColumns.put("logo_gb", getLogoGb());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("office_cnt_cd", getOfficeCntCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("title_flag", "titleFlag");
		this.hashFields.put("send_flag", "sendFlag");
		this.hashFields.put("send_flag2", "sendFlag2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("issue_gubn", "issueGubn");
		this.hashFields.put("name_flag", "nameFlag");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("iss_lehbb", "issLehbb");
		this.hashFields.put("logo_gb", "logoGb");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("office_cnt_cd", "officeCntCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  titleFlag
	*/
	public void	setTitleFlag( String	titleFlag ) {
		this.titleFlag =	titleFlag;
	}
 
	/**
	 * Column Info
	 * @return	titleFlag
	 */
	 public	 String	getTitleFlag() {
		 return	this.titleFlag;
	 } 
 	/**
	* Column Info
	* @param  sendFlag
	*/
	public void	setSendFlag( String	sendFlag ) {
		this.sendFlag =	sendFlag;
	}
 
	/**
	 * Column Info
	 * @return	sendFlag
	 */
	 public	 String	getSendFlag() {
		 return	this.sendFlag;
	 } 
 	/**
	* Column Info
	* @param  sendFlag2
	*/
	public void	setSendFlag2( String	sendFlag2 ) {
		this.sendFlag2 =	sendFlag2;
	}
 
	/**
	 * Column Info
	 * @return	sendFlag2
	 */
	 public	 String	getSendFlag2() {
		 return	this.sendFlag2;
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
	* @param  issueGubn
	*/
	public void	setIssueGubn( String	issueGubn ) {
		this.issueGubn =	issueGubn;
	}
 
	/**
	 * Column Info
	 * @return	issueGubn
	 */
	 public	 String	getIssueGubn() {
		 return	this.issueGubn;
	 } 
 	/**
	* Column Info
	* @param  nameFlag
	*/
	public void	setNameFlag( String	nameFlag ) {
		this.nameFlag =	nameFlag;
	}
 
	/**
	 * Column Info
	 * @return	nameFlag
	 */
	 public	 String	getNameFlag() {
		 return	this.nameFlag;
	 } 
 	/**
	* Column Info
	* @param  rdName
	*/
	public void	setRdName( String	rdName ) {
		this.rdName =	rdName;
	}
 
	/**
	 * Column Info
	 * @return	rdName
	 */
	 public	 String	getRdName() {
		 return	this.rdName;
	 } 
 	/**
	* Column Info
	* @param  issOfcCd
	*/
	public void	setIssOfcCd( String	issOfcCd ) {
		this.issOfcCd =	issOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcCd
	 */
	 public	 String	getIssOfcCd() {
		 return	this.issOfcCd;
	 } 
 	/**
	* Column Info
	* @param  sendType
	*/
	public void	setSendType( String	sendType ) {
		this.sendType =	sendType;
	}
 
	/**
	 * Column Info
	 * @return	sendType
	 */
	 public	 String	getSendType() {
		 return	this.sendType;
	 } 
 	/**
	* Column Info
	* @param  issueType
	*/
	public void	setIssueType( String	issueType ) {
		this.issueType =	issueType;
	}
 
	/**
	 * Column Info
	 * @return	issueType
	 */
	 public	 String	getIssueType() {
		 return	this.issueType;
	 } 
 	/**
	* Column Info
	* @param  copyCnt
	*/
	public void	setCopyCnt( String	copyCnt ) {
		this.copyCnt =	copyCnt;
	}
 
	/**
	 * Column Info
	 * @return	copyCnt
	 */
	 public	 String	getCopyCnt() {
		 return	this.copyCnt;
	 } 
 	/**
	* Column Info
	* @param  issLehbb
	*/
	public void	setIssLehbb( String	issLehbb ) {
		this.issLehbb =	issLehbb;
	}
 
	/**
	 * Column Info
	 * @return	issLehbb
	 */
	 public	 String	getIssLehbb() {
		 return	this.issLehbb;
	 } 
 	/**
	* Column Info
	* @param  logoGb
	*/
	public void	setLogoGb( String	logoGb ) {
		this.logoGb =	logoGb;
	}
 
	/**
	 * Column Info
	 * @return	logoGb
	 */
	 public	 String	getLogoGb() {
		 return	this.logoGb;
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
	* @param  officeCntCd
	*/
	public void	setOfficeCntCd( String	officeCntCd ) {
		this.officeCntCd =	officeCntCd;
	}
 
	/**
	 * Column Info
	 * @return	officeCntCd
	 */
	 public	 String	getOfficeCntCd() {
		 return	this.officeCntCd;
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
		setTitleFlag(JSPUtil.getParameter(request,	prefix + "title_flag", ""));
		setSendFlag(JSPUtil.getParameter(request,	prefix + "send_flag", ""));
		setSendFlag2(JSPUtil.getParameter(request,	prefix + "send_flag2", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setIssueGubn(JSPUtil.getParameter(request,	prefix + "issue_gubn", ""));
		setNameFlag(JSPUtil.getParameter(request,	prefix + "name_flag", ""));
		setRdName(JSPUtil.getParameter(request,	prefix + "rd_name", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setSendType(JSPUtil.getParameter(request,	prefix + "send_type", ""));
		setIssueType(JSPUtil.getParameter(request,	prefix + "issue_type", ""));
		setCopyCnt(JSPUtil.getParameter(request,	prefix + "copy_cnt", ""));
		setIssLehbb(JSPUtil.getParameter(request,	prefix + "iss_lehbb", ""));
		setLogoGb(JSPUtil.getParameter(request,	prefix + "logo_gb", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOfficeCntCd(JSPUtil.getParameter(request,	prefix + "office_cnt_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssueOptionVO[]
	 */
	public IssueOptionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return IssueOptionVO[]
	 */
	public IssueOptionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		IssueOptionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] titleFlag =	(JSPUtil.getParameter(request, prefix +	"title_flag".trim(),	length));
				String[] sendFlag =	(JSPUtil.getParameter(request, prefix +	"send_flag".trim(),	length));
				String[] sendFlag2 =	(JSPUtil.getParameter(request, prefix +	"send_flag2".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] issueGubn =	(JSPUtil.getParameter(request, prefix +	"issue_gubn".trim(),	length));
				String[] nameFlag =	(JSPUtil.getParameter(request, prefix +	"name_flag".trim(),	length));
				String[] rdName =	(JSPUtil.getParameter(request, prefix +	"rd_name".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] sendType =	(JSPUtil.getParameter(request, prefix +	"send_type".trim(),	length));
				String[] issueType =	(JSPUtil.getParameter(request, prefix +	"issue_type".trim(),	length));
				String[] copyCnt =	(JSPUtil.getParameter(request, prefix +	"copy_cnt".trim(),	length));
				String[] issLehbb =	(JSPUtil.getParameter(request, prefix +	"iss_lehbb".trim(),	length));
				String[] logoGb =	(JSPUtil.getParameter(request, prefix +	"logo_gb".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] officeCntCd =	(JSPUtil.getParameter(request, prefix +	"office_cnt_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	IssueOptionVO();
						if ( titleFlag[i] !=	null)
						model.setTitleFlag( titleFlag[i]);
						if ( sendFlag[i] !=	null)
						model.setSendFlag( sendFlag[i]);
						if ( sendFlag2[i] !=	null)
						model.setSendFlag2( sendFlag2[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( issueGubn[i] !=	null)
						model.setIssueGubn( issueGubn[i]);
						if ( nameFlag[i] !=	null)
						model.setNameFlag( nameFlag[i]);
						if ( rdName[i] !=	null)
						model.setRdName( rdName[i]);
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( sendType[i] !=	null)
						model.setSendType( sendType[i]);
						if ( issueType[i] !=	null)
						model.setIssueType( issueType[i]);
						if ( copyCnt[i] !=	null)
						model.setCopyCnt( copyCnt[i]);
						if ( issLehbb[i] !=	null)
						model.setIssLehbb( issLehbb[i]);
						if ( logoGb[i] !=	null)
						model.setLogoGb( logoGb[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( officeCntCd[i] !=	null)
						model.setOfficeCntCd( officeCntCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getIssueOptionVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return IssueOptionVO[]
	 */
	public IssueOptionVO[]	 getIssueOptionVOs(){
		IssueOptionVO[] vos = (IssueOptionVO[])models.toArray(new	IssueOptionVO[models.size()]);
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
		this.titleFlag =	this.titleFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag =	this.sendFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag2 =	this.sendFlag2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGubn =	this.issueGubn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nameFlag =	this.nameFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName =	this.rdName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType =	this.sendType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType =	this.issueType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt =	this.copyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issLehbb =	this.issLehbb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logoGb =	this.logoGb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeCntCd =	this.officeCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}