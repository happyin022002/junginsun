/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : APCostActivityInfoVO.java
 *@FileTitle : APCostActivityInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.26  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
public class APCostActivityInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<APCostActivityInfoVO>  models =	new	ArrayList<APCostActivityInfoVO>();


	/*	Column Info	*/
	private  String	 actPlcNm   =  null;
	/*	Column Info	*/
	private  String	 convAcctCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 actCostNm   =  null;
	/*	Column Info	*/
	private  String	 actCostCd   =  null;
	/*	Column Info	*/
	private  String	 actDtNm   =  null;
	/*	Column Info	*/
	private  String	 srcMdlCd   =  null;
	/*	Column Info	*/
	private  String	 enblFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 acclFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public APCostActivityInfoVO(){}

	public APCostActivityInfoVO(String actPlcNm,String convAcctCd,String ibflag,String usrId,String actCostNm,String actCostCd,String actDtNm,String srcMdlCd,String enblFlg,String pagerows,String acclFlg)	{
		this.actPlcNm  = actPlcNm ;
		this.convAcctCd  = convAcctCd ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.actCostNm  = actCostNm ;
		this.actCostCd  = actCostCd ;
		this.actDtNm  = actDtNm ;
		this.srcMdlCd  = srcMdlCd ;
		this.enblFlg  = enblFlg ;
		this.pagerows  = pagerows ;
		this.acclFlg  = acclFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_plc_nm", getActPlcNm());		
		this.hashColumns.put("conv_acct_cd", getConvAcctCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("act_cost_nm", getActCostNm());		
		this.hashColumns.put("act_cost_cd", getActCostCd());		
		this.hashColumns.put("act_dt_nm", getActDtNm());		
		this.hashColumns.put("src_mdl_cd", getSrcMdlCd());		
		this.hashColumns.put("enbl_flg", getEnblFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("accl_flg", getAcclFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("act_plc_nm", "actPlcNm");
		this.hashFields.put("conv_acct_cd", "convAcctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("act_cost_nm", "actCostNm");
		this.hashFields.put("act_cost_cd", "actCostCd");
		this.hashFields.put("act_dt_nm", "actDtNm");
		this.hashFields.put("src_mdl_cd", "srcMdlCd");
		this.hashFields.put("enbl_flg", "enblFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("accl_flg", "acclFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  actPlcNm
	*/
	public void	setActPlcNm( String	actPlcNm ) {
		this.actPlcNm =	actPlcNm;
	}
 
	/**
	 * Column Info
	 * @return	actPlcNm
	 */
	 public	String	getActPlcNm() {
		 return	this.actPlcNm;
	 } 
 	/**
	* Column Info
	* @param  convAcctCd
	*/
	public void	setConvAcctCd( String	convAcctCd ) {
		this.convAcctCd =	convAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	convAcctCd
	 */
	 public	String	getConvAcctCd() {
		 return	this.convAcctCd;
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
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  actCostNm
	*/
	public void	setActCostNm( String	actCostNm ) {
		this.actCostNm =	actCostNm;
	}
 
	/**
	 * Column Info
	 * @return	actCostNm
	 */
	 public	String	getActCostNm() {
		 return	this.actCostNm;
	 } 
 	/**
	* Column Info
	* @param  actCostCd
	*/
	public void	setActCostCd( String	actCostCd ) {
		this.actCostCd =	actCostCd;
	}
 
	/**
	 * Column Info
	 * @return	actCostCd
	 */
	 public	String	getActCostCd() {
		 return	this.actCostCd;
	 } 
 	/**
	* Column Info
	* @param  actDtNm
	*/
	public void	setActDtNm( String	actDtNm ) {
		this.actDtNm =	actDtNm;
	}
 
	/**
	 * Column Info
	 * @return	actDtNm
	 */
	 public	String	getActDtNm() {
		 return	this.actDtNm;
	 } 
 	/**
	* Column Info
	* @param  srcMdlCd
	*/
	public void	setSrcMdlCd( String	srcMdlCd ) {
		this.srcMdlCd =	srcMdlCd;
	}
 
	/**
	 * Column Info
	 * @return	srcMdlCd
	 */
	 public	String	getSrcMdlCd() {
		 return	this.srcMdlCd;
	 } 
 	/**
	* Column Info
	* @param  enblFlg
	*/
	public void	setEnblFlg( String	enblFlg ) {
		this.enblFlg =	enblFlg;
	}
 
	/**
	 * Column Info
	 * @return	enblFlg
	 */
	 public	String	getEnblFlg() {
		 return	this.enblFlg;
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
	* @param  acclFlg
	*/
	public void	setAcclFlg( String	acclFlg ) {
		this.acclFlg =	acclFlg;
	}
 
	/**
	 * Column Info
	 * @return	acclFlg
	 */
	 public	String	getAcclFlg() {
		 return	this.acclFlg;
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
		setActPlcNm(JSPUtil.getParameter(request,	prefix + "act_plc_nm", ""));
		setConvAcctCd(JSPUtil.getParameter(request,	prefix + "conv_acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setActCostNm(JSPUtil.getParameter(request,	prefix + "act_cost_nm", ""));
		setActCostCd(JSPUtil.getParameter(request,	prefix + "act_cost_cd", ""));
		setActDtNm(JSPUtil.getParameter(request,	prefix + "act_dt_nm", ""));
		setSrcMdlCd(JSPUtil.getParameter(request,	prefix + "src_mdl_cd", ""));
		setEnblFlg(JSPUtil.getParameter(request,	prefix + "enbl_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAcclFlg(JSPUtil.getParameter(request,	prefix + "accl_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APCostActivityInfoVO[]
	 */
	public APCostActivityInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return APCostActivityInfoVO[]
	 */
	public APCostActivityInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		APCostActivityInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] actPlcNm =	(JSPUtil.getParameter(request, prefix +	"act_plc_nm".trim(),	length));
				String[] convAcctCd =	(JSPUtil.getParameter(request, prefix +	"conv_acct_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] actCostNm =	(JSPUtil.getParameter(request, prefix +	"act_cost_nm".trim(),	length));
				String[] actCostCd =	(JSPUtil.getParameter(request, prefix +	"act_cost_cd".trim(),	length));
				String[] actDtNm =	(JSPUtil.getParameter(request, prefix +	"act_dt_nm".trim(),	length));
				String[] srcMdlCd =	(JSPUtil.getParameter(request, prefix +	"src_mdl_cd".trim(),	length));
				String[] enblFlg =	(JSPUtil.getParameter(request, prefix +	"enbl_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] acclFlg =	(JSPUtil.getParameter(request, prefix +	"accl_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	APCostActivityInfoVO();
						if ( actPlcNm[i] !=	null)
						model.setActPlcNm( actPlcNm[i]);
						if ( convAcctCd[i] !=	null)
						model.setConvAcctCd( convAcctCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( actCostNm[i] !=	null)
						model.setActCostNm( actCostNm[i]);
						if ( actCostCd[i] !=	null)
						model.setActCostCd( actCostCd[i]);
						if ( actDtNm[i] !=	null)
						model.setActDtNm( actDtNm[i]);
						if ( srcMdlCd[i] !=	null)
						model.setSrcMdlCd( srcMdlCd[i]);
						if ( enblFlg[i] !=	null)
						model.setEnblFlg( enblFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( acclFlg[i] !=	null)
						model.setAcclFlg( acclFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAPCostActivityInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return APCostActivityInfoVO[]
	 */
	public APCostActivityInfoVO[]	 getAPCostActivityInfoVOs(){
		APCostActivityInfoVO[] vos = (APCostActivityInfoVO[])models.toArray(new	APCostActivityInfoVO[models.size()]);
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
		this.actPlcNm =	this.actPlcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convAcctCd =	this.convAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostNm =	this.actCostNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostCd =	this.actCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDtNm =	this.actDtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcMdlCd =	this.srcMdlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enblFlg =	this.enblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclFlg =	this.acclFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}