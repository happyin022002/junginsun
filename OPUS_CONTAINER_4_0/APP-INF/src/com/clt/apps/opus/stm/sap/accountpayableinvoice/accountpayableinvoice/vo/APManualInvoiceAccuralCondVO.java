/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : APManualInvoiceAccuralCondVO.java
 *@FileTitle : APManualInvoiceAccuralCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.19  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class APManualInvoiceAccuralCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<APManualInvoiceAccuralCondVO>  models =	new	ArrayList<APManualInvoiceAccuralCondVO>();


	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 estmSeqNo   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 glYymm   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public APManualInvoiceAccuralCondVO(){}

	public APManualInvoiceAccuralCondVO(String csrNo,String ibflag,String usrId,String estmSeqNo,String invSeq,String pagerows,String glYymm)	{
		this.csrNo  = csrNo ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.estmSeqNo  = estmSeqNo ;
		this.invSeq  = invSeq ;
		this.pagerows  = pagerows ;
		this.glYymm  = glYymm ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("gl_yymm", getGlYymm());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gl_yymm", "glYymm");
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
	 public	String	getCsrNo() {
		 return	this.csrNo;
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
	* @param  estmSeqNo
	*/
	public void	setEstmSeqNo( String	estmSeqNo ) {
		this.estmSeqNo =	estmSeqNo;
	}
 
	/**
	 * Column Info
	 * @return	estmSeqNo
	 */
	 public	String	getEstmSeqNo() {
		 return	this.estmSeqNo;
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
	 public	String	getInvSeq() {
		 return	this.invSeq;
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
	* @param  glYymm
	*/
	public void	setGlYymm( String	glYymm ) {
		this.glYymm =	glYymm;
	}
 
	/**
	 * Column Info
	 * @return	glYymm
	 */
	 public	String	getGlYymm() {
		 return	this.glYymm;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setEstmSeqNo(JSPUtil.getParameter(request,	prefix + "estm_seq_no", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setGlYymm(JSPUtil.getParameter(request,	prefix + "gl_yymm", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return APManualInvoiceAccuralCondVO[]
	 */
	public APManualInvoiceAccuralCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return APManualInvoiceAccuralCondVO[]
	 */
	public APManualInvoiceAccuralCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		APManualInvoiceAccuralCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] estmSeqNo =	(JSPUtil.getParameter(request, prefix +	"estm_seq_no".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] glYymm =	(JSPUtil.getParameter(request, prefix +	"gl_yymm".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	APManualInvoiceAccuralCondVO();
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( estmSeqNo[i] !=	null)
						model.setEstmSeqNo( estmSeqNo[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( glYymm[i] !=	null)
						model.setGlYymm( glYymm[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAPManualInvoiceAccuralCondVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return APManualInvoiceAccuralCondVO[]
	 */
	public APManualInvoiceAccuralCondVO[]	 getAPManualInvoiceAccuralCondVOs(){
		APManualInvoiceAccuralCondVO[] vos = (APManualInvoiceAccuralCondVO[])models.toArray(new	APManualInvoiceAccuralCondVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo =	this.estmSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glYymm =	this.glYymm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}