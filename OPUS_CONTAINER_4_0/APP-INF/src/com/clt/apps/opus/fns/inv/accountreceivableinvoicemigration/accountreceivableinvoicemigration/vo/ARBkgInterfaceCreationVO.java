/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARBkgInterfaceCreationVO.java
 *@FileTitle : ARBkgInterfaceCreationVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.03  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

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
public class ARBkgInterfaceCreationVO	extends	 AbstractValueObject
{
 
	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARBkgInterfaceCreationVO>  models =	new	ArrayList<ARBkgInterfaceCreationVO>();


	/*	Column Info	*/
	private  String	 bkgCorrDt   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 bkgCorrNo   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 manDivInd   =  null;
	/*	Column Info	*/
	private  String	 bkgDiv   =  null;
	/*	Column Info	*/
	private  String	 bkgSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 bkgOfcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARBkgInterfaceCreationVO(){}

	public ARBkgInterfaceCreationVO(String bkgCorrDt,String bkgNo,String ibflag,String vvdCd,String arIfNo,String bkgCorrNo,String userId,String manDivInd,String bkgDiv,String bkgSeq,String pagerows,String bkgOfcCd)	{
		this.bkgCorrDt  = bkgCorrDt ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.vvdCd  = vvdCd ;
		this.arIfNo  = arIfNo ;
		this.bkgCorrNo  = bkgCorrNo ;
		this.userId  = userId ;
		this.manDivInd  = manDivInd ;
		this.bkgDiv  = bkgDiv ;
		this.bkgSeq  = bkgSeq ;
		this.pagerows  = pagerows ;
		this.bkgOfcCd  = bkgOfcCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("man_div_ind", getManDivInd());		
		this.hashColumns.put("bkg_div", getBkgDiv());		
		this.hashColumns.put("bkg_seq", getBkgSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("man_div_ind", "manDivInd");
		this.hashFields.put("bkg_div", "bkgDiv");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  bkgCorrDt
	*/
	public void	setBkgCorrDt( String	bkgCorrDt ) {
		this.bkgCorrDt =	bkgCorrDt;
	}
 
	/**
	 * Column Info
	 * @return	bkgCorrDt
	 */
	 public	 String	getBkgCorrDt() {
		 return	this.bkgCorrDt;
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
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
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
	* @param  bkgCorrNo
	*/
	public void	setBkgCorrNo( String	bkgCorrNo ) {
		this.bkgCorrNo =	bkgCorrNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgCorrNo
	 */
	 public	 String	getBkgCorrNo() {
		 return	this.bkgCorrNo;
	 } 
 	/**
	* Column Info
	* @param  userId
	*/
	public void	setUserId( String	userId ) {
		this.userId =	userId;
	}
 
	/**
	 * Column Info
	 * @return	userId
	 */
	 public	 String	getUserId() {
		 return	this.userId;
	 } 
 	/**
	* Column Info
	* @param  manDivInd
	*/
	public void	setManDivInd( String	manDivInd ) {
		this.manDivInd =	manDivInd;
	}
 
	/**
	 * Column Info
	 * @return	manDivInd
	 */
	 public	 String	getManDivInd() {
		 return	this.manDivInd;
	 } 
 	/**
	* Column Info
	* @param  bkgDiv
	*/
	public void	setBkgDiv( String	bkgDiv ) {
		this.bkgDiv =	bkgDiv;
	}
 
	/**
	 * Column Info
	 * @return	bkgDiv
	 */
	 public	 String	getBkgDiv() {
		 return	this.bkgDiv;
	 } 
 	/**
	* Column Info
	* @param  bkgSeq
	*/
	public void	setBkgSeq( String	bkgSeq ) {
		this.bkgSeq =	bkgSeq;
	}
 
	/**
	 * Column Info
	 * @return	bkgSeq
	 */
	 public	 String	getBkgSeq() {
		 return	this.bkgSeq;
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
	* @param  bkgOfcCd
	*/
	public void	setBkgOfcCd( String	bkgOfcCd ) {
		this.bkgOfcCd =	bkgOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgOfcCd
	 */
	 public	 String	getBkgOfcCd() {
		 return	this.bkgOfcCd;
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
		setBkgCorrDt(JSPUtil.getParameter(request,	prefix + "bkg_corr_dt", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setBkgCorrNo(JSPUtil.getParameter(request,	prefix + "bkg_corr_no", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setManDivInd(JSPUtil.getParameter(request,	prefix + "man_div_ind", ""));
		setBkgDiv(JSPUtil.getParameter(request,	prefix + "bkg_div", ""));
		setBkgSeq(JSPUtil.getParameter(request,	prefix + "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBkgOfcCd(JSPUtil.getParameter(request,	prefix + "bkg_ofc_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARBkgInterfaceCreationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bkgCorrDt =	(JSPUtil.getParameter(request, prefix +	"bkg_corr_dt".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] bkgCorrNo =	(JSPUtil.getParameter(request, prefix +	"bkg_corr_no".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] manDivInd =	(JSPUtil.getParameter(request, prefix +	"man_div_ind".trim(),	length));
				String[] bkgDiv =	(JSPUtil.getParameter(request, prefix +	"bkg_div".trim(),	length));
				String[] bkgSeq =	(JSPUtil.getParameter(request, prefix +	"bkg_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] bkgOfcCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ofc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARBkgInterfaceCreationVO();
						if ( bkgCorrDt[i] !=	null)
						model.setBkgCorrDt( bkgCorrDt[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( bkgCorrNo[i] !=	null)
						model.setBkgCorrNo( bkgCorrNo[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( manDivInd[i] !=	null)
						model.setManDivInd( manDivInd[i]);
						if ( bkgDiv[i] !=	null)
						model.setBkgDiv( bkgDiv[i]);
						if ( bkgSeq[i] !=	null)
						model.setBkgSeq( bkgSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( bkgOfcCd[i] !=	null)
						model.setBkgOfcCd( bkgOfcCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARBkgInterfaceCreationVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[]	 getARBkgInterfaceCreationVOs(){
		ARBkgInterfaceCreationVO[] vos = (ARBkgInterfaceCreationVO[])models.toArray(new	ARBkgInterfaceCreationVO[models.size()]);
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
		this.bkgCorrDt =	this.bkgCorrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo =	this.bkgCorrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manDivInd =	this.manDivInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDiv =	this.bkgDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq =	this.bkgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd =	this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}