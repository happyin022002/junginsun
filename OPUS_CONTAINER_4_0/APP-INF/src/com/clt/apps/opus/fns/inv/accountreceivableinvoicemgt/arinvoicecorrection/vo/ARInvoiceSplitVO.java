/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceSplitVO.java
 *@FileTitle : ARInvoiceSplitVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.09.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
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
public class ARInvoiceSplitVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceSplitVO>  models =	new	ArrayList<ARInvoiceSplitVO>();

	
	private ARInvoiceCorrectionVO ARInvoiceCorrectionVO = null;
	
	private List<ARInvoiceCorrectionVO> ARInvoiceCorrectionVOs = null;
	
	private ARInvoiceCustomerVO ARInvoiceCustomerVO = null;
	
	private List<ARInvoiceCustomerVO> ARInvoiceCustomerVOs = null;
	
	private List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArAmtVO invArAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArAmtVO> invArAmtVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArChgVO invArChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArChgVO> invArChgVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArCntrVO invArCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArCntrVO> invArCntrVOs;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArMnVO invArMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArMnVO> invArMnVOs;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfNoVO invArIfNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArIfNoVO> invArIfNoVOs;	
	

	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 maxSeq   =  null;
	/*	Column Info	*/
	private  String	 splitFlag   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 orgIfNoList   =  null;
	/*	Column Info	*/
	private  String	 cxlIfNoList   =  null;
	/*	Column Info	*/
	private  String	 maxIfNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceSplitVO(){}

	public ARInvoiceSplitVO(String ibflag,String maxSeq,String splitFlag,String otsSmryCd,String userId,String ifNo,String pagerows,String invCurrCd,String orgIfNoList,String cxlIfNoList,String maxIfNo)	{
		this.ibflag  = ibflag ;
		this.maxSeq  = maxSeq ;
		this.splitFlag  = splitFlag ;
		this.otsSmryCd  = otsSmryCd ;
		this.userId  = userId ;
		this.ifNo  = ifNo ;
		this.pagerows  = pagerows ;
		this.invCurrCd  = invCurrCd ;
		this.orgIfNoList  = orgIfNoList ;
		this.cxlIfNoList  = cxlIfNoList ;
		this.maxIfNo  = maxIfNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("max_seq", getMaxSeq());		
		this.hashColumns.put("split_flag", getSplitFlag());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("org_if_no_list", getOrgIfNoList());		
		this.hashColumns.put("cxl_if_no_list", getCxlIfNoList());		
		this.hashColumns.put("max_if_no", getMaxIfNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("split_flag", "splitFlag");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("org_if_no_list", "orgIfNoList");
		this.hashFields.put("cxl_if_no_list", "cxlIfNoList");
		this.hashFields.put("max_if_no", "maxIfNo");
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
	* @param  maxSeq
	*/
	public void	setMaxSeq( String	maxSeq ) {
		this.maxSeq =	maxSeq;
	}
 
	/**
	 * Column Info
	 * @return	maxSeq
	 */
	 public	 String	getMaxSeq() {
		 return	this.maxSeq;
	 } 
 	/**
	* Column Info
	* @param  splitFlag
	*/
	public void	setSplitFlag( String	splitFlag ) {
		this.splitFlag =	splitFlag;
	}
 
	/**
	 * Column Info
	 * @return	splitFlag
	 */
	 public	 String	getSplitFlag() {
		 return	this.splitFlag;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
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
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
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
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  orgIfNoList
	*/
	public void	setOrgIfNoList( String	orgIfNoList ) {
		this.orgIfNoList =	orgIfNoList;
	}
 
	/**
	 * Column Info
	 * @return	orgIfNoList
	 */
	 public	 String	getOrgIfNoList() {
		 return	this.orgIfNoList;
	 } 
 	/**
	* Column Info
	* @param  cxlIfNoList
	*/
	public void	setCxlIfNoList( String	cxlIfNoList ) {
		this.cxlIfNoList =	cxlIfNoList;
	}
 
	/**
	 * Column Info
	 * @return	cxlIfNoList
	 */
	 public	 String	getCxlIfNoList() {
		 return	this.cxlIfNoList;
	 } 
 	/**
	* Column Info
	* @param  maxIfNo
	*/
	public void	setMaxIfNo( String	maxIfNo ) {
		this.maxIfNo =	maxIfNo;
	}
 
	/**
	 * Column Info
	 * @return	maxIfNo
	 */
	 public	 String	getMaxIfNo() {
		 return	this.maxIfNo;
	 } 

	 public ARInvoiceCorrectionVO getARInvoiceCorrectionVO() {
		return ARInvoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO aRInvoiceCorrectionVO) {
		ARInvoiceCorrectionVO = aRInvoiceCorrectionVO;
	}

	public List<ARInvoiceCorrectionVO> getARInvoiceCorrectionVOs() {
		return ARInvoiceCorrectionVOs;
	}

	public void setARInvoiceCorrectionVOs(
			List<ARInvoiceCorrectionVO> aRInvoiceCorrectionVOs) {
		ARInvoiceCorrectionVOs = aRInvoiceCorrectionVOs;
	}

	public ARInvoiceCustomerVO getARInvoiceCustomerVO() {
		return ARInvoiceCustomerVO;
	}

	public void setARInvoiceCustomerVO(ARInvoiceCustomerVO aRInvoiceCustomerVO) {
		ARInvoiceCustomerVO = aRInvoiceCustomerVO;
	}

	public List<ARInvoiceCustomerVO> getARInvoiceCustomerVOs() {
		return ARInvoiceCustomerVOs;
	}

	public void setARInvoiceCustomerVOs(
			List<ARInvoiceCustomerVO> aRInvoiceCustomerVOs) {
		ARInvoiceCustomerVOs = aRInvoiceCustomerVOs;
	}

	public List<ARInvoiceChargeCorrectionVO> getListInvoiceChargeCorrectionVO() {
		return listInvoiceChargeCorrectionVO;
	}

	public void setListInvoiceChargeCorrectionVO(
			List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO) {
		this.listInvoiceChargeCorrectionVO = listInvoiceChargeCorrectionVO;
	}
	
	public InvArAmtVO getInvArAmtVO() {
		return invArAmtVO;
	}

	public void setInvArAmtVO(InvArAmtVO invArAmtVO) {
		this.invArAmtVO = invArAmtVO;
	}

	public List<InvArAmtVO> getInvArAmtVOs() {
		return invArAmtVOs;
	}

	public void setInvArAmtVOs(List<InvArAmtVO> invArAmtVOs) {
		this.invArAmtVOs = invArAmtVOs;
	}

	public InvArChgVO getInvArChgVO() {
		return invArChgVO;
	}

	public void setInvArChgVO(InvArChgVO invArChgVO) {
		this.invArChgVO = invArChgVO;
	}

	public List<InvArChgVO> getInvArChgVOs() {
		return invArChgVOs;
	}

	public void setInvArChgVOs(List<InvArChgVO> invArChgVOs) {
		this.invArChgVOs = invArChgVOs;
	}

	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	public List<InvArCntrVO> getInvArCntrVOs() {
		return invArCntrVOs;
	}

	public void setInvArCntrVOs(List<InvArCntrVO> invArCntrVOs) {
		this.invArCntrVOs = invArCntrVOs;
	}

	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	public List<InvArMnVO> getInvArMnVOs() {
		return invArMnVOs;
	}

	public void setInvArMnVOs(List<InvArMnVO> invArMnVOs) {
		this.invArMnVOs = invArMnVOs;
	}

	public InvArIfNoVO getInvArIfNoVO() {
		return invArIfNoVO;
	}

	public void setInvArIfNoVO(InvArIfNoVO invArIfNoVO) {
		this.invArIfNoVO = invArIfNoVO;
	}

	public List<InvArIfNoVO> getInvArIfNoVOs() {
		return invArIfNoVOs;
	}

	public void setInvArIfNoVOs(List<InvArIfNoVO> invArIfNoVOs) {
		this.invArIfNoVOs = invArIfNoVOs;
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
		setMaxSeq(JSPUtil.getParameter(request,	prefix + "max_seq", ""));
		setSplitFlag(JSPUtil.getParameter(request,	prefix + "split_flag", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setOrgIfNoList(JSPUtil.getParameter(request,	prefix + "org_if_no_list", ""));
		setCxlIfNoList(JSPUtil.getParameter(request,	prefix + "cxl_if_no_list", ""));
		setMaxIfNo(JSPUtil.getParameter(request,	prefix + "max_if_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceSplitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] maxSeq =	(JSPUtil.getParameter(request, prefix +	"max_seq".trim(),	length));
				String[] splitFlag =	(JSPUtil.getParameter(request, prefix +	"split_flag".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] orgIfNoList =	(JSPUtil.getParameter(request, prefix +	"org_if_no_list".trim(),	length));
				String[] cxlIfNoList =	(JSPUtil.getParameter(request, prefix +	"cxl_if_no_list".trim(),	length));
				String[] maxIfNo =	(JSPUtil.getParameter(request, prefix +	"max_if_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceSplitVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( maxSeq[i] !=	null)
						model.setMaxSeq( maxSeq[i]);
						if ( splitFlag[i] !=	null)
						model.setSplitFlag( splitFlag[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( orgIfNoList[i] !=	null)
						model.setOrgIfNoList( orgIfNoList[i]);
						if ( cxlIfNoList[i] !=	null)
						model.setCxlIfNoList( cxlIfNoList[i]);
						if ( maxIfNo[i] !=	null)
						model.setMaxIfNo( maxIfNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceSplitVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[]	 getARInvoiceSplitVOs(){
		ARInvoiceSplitVO[] vos = (ARInvoiceSplitVO[])models.toArray(new	ARInvoiceSplitVO[models.size()]);
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
		this.maxSeq =	this.maxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlag =	this.splitFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIfNoList =	this.orgIfNoList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlIfNoList =	this.cxlIfNoList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxIfNo =	this.maxIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}