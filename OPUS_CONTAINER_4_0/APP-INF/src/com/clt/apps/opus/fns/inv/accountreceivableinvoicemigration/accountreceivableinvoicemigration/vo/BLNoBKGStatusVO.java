/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BLNoBKGStatusVO.java
 *@FileTitle : BLNoBKGStatusVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.14  
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
public class BLNoBKGStatusVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BLNoBKGStatusVO>  models =	new	ArrayList<BLNoBKGStatusVO>();


	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 whfDeclCxlFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgStsCd   =  null;
	/*	Column Info	*/
	private  String	 cxlFlg   =  null;
	/*	Column Info	*/
	private  String	 chnAgnCd   =  null;
	/*	Column Info	*/
	private  String	 whfDeclNo   =  null;
	/*	Column Info	*/
	private  String	 autoMnlDivCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 obrdDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public BLNoBKGStatusVO(){}

	public BLNoBKGStatusVO(String blSrcNo,String bkgNo,String ibflag,String whfDeclCxlFlg,String bkgStsCd,String cxlFlg,String chnAgnCd,String whfDeclNo,String autoMnlDivCd,String pagerows,String obrdDt)	{
		this.blSrcNo  = blSrcNo ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.whfDeclCxlFlg  = whfDeclCxlFlg ;
		this.bkgStsCd  = bkgStsCd ;
		this.cxlFlg  = cxlFlg ;
		this.chnAgnCd  = chnAgnCd ;
		this.whfDeclNo  = whfDeclNo ;
		this.autoMnlDivCd  = autoMnlDivCd ;
		this.pagerows  = pagerows ;
		this.obrdDt  = obrdDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("whf_decl_cxl_flg", getWhfDeclCxlFlg());		
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());		
		this.hashColumns.put("cxl_flg", getCxlFlg());		
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());		
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());		
		this.hashColumns.put("auto_mnl_div_cd", getAutoMnlDivCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("obrd_dt", getObrdDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("whf_decl_cxl_flg", "whfDeclCxlFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("auto_mnl_div_cd", "autoMnlDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("obrd_dt", "obrdDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
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
	* @param  whfDeclCxlFlg
	*/
	public void	setWhfDeclCxlFlg( String	whfDeclCxlFlg ) {
		this.whfDeclCxlFlg =	whfDeclCxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	whfDeclCxlFlg
	 */
	 public	 String	getWhfDeclCxlFlg() {
		 return	this.whfDeclCxlFlg;
	 } 
 	/**
	* Column Info
	* @param  bkgStsCd
	*/
	public void	setBkgStsCd( String	bkgStsCd ) {
		this.bkgStsCd =	bkgStsCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgStsCd
	 */
	 public	 String	getBkgStsCd() {
		 return	this.bkgStsCd;
	 } 
 	/**
	* Column Info
	* @param  cxlFlg
	*/
	public void	setCxlFlg( String	cxlFlg ) {
		this.cxlFlg =	cxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	cxlFlg
	 */
	 public	 String	getCxlFlg() {
		 return	this.cxlFlg;
	 } 
 	/**
	* Column Info
	* @param  chnAgnCd
	*/
	public void	setChnAgnCd( String	chnAgnCd ) {
		this.chnAgnCd =	chnAgnCd;
	}
 
	/**
	 * Column Info
	 * @return	chnAgnCd
	 */
	 public	 String	getChnAgnCd() {
		 return	this.chnAgnCd;
	 } 
 	/**
	* Column Info
	* @param  whfDeclNo
	*/
	public void	setWhfDeclNo( String	whfDeclNo ) {
		this.whfDeclNo =	whfDeclNo;
	}
 
	/**
	 * Column Info
	 * @return	whfDeclNo
	 */
	 public	 String	getWhfDeclNo() {
		 return	this.whfDeclNo;
	 } 
 	/**
	* Column Info
	* @param  autoMnlDivCd
	*/
	public void	setAutoMnlDivCd( String	autoMnlDivCd ) {
		this.autoMnlDivCd =	autoMnlDivCd;
	}
 
	/**
	 * Column Info
	 * @return	autoMnlDivCd
	 */
	 public	 String	getAutoMnlDivCd() {
		 return	this.autoMnlDivCd;
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
	* @param  obrdDt
	*/
	public void	setObrdDt( String	obrdDt ) {
		this.obrdDt =	obrdDt;
	}
 
	/**
	 * Column Info
	 * @return	obrdDt
	 */
	 public	 String	getObrdDt() {
		 return	this.obrdDt;
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
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setWhfDeclCxlFlg(JSPUtil.getParameter(request,	prefix + "whf_decl_cxl_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request,	prefix + "bkg_sts_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request,	prefix + "cxl_flg", ""));
		setChnAgnCd(JSPUtil.getParameter(request,	prefix + "chn_agn_cd", ""));
		setWhfDeclNo(JSPUtil.getParameter(request,	prefix + "whf_decl_no", ""));
		setAutoMnlDivCd(JSPUtil.getParameter(request,	prefix + "auto_mnl_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setObrdDt(JSPUtil.getParameter(request,	prefix + "obrd_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BLNoBKGStatusVO[]
	 */
	public BLNoBKGStatusVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BLNoBKGStatusVO[]
	 */
	public BLNoBKGStatusVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BLNoBKGStatusVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] whfDeclCxlFlg =	(JSPUtil.getParameter(request, prefix +	"whf_decl_cxl_flg".trim(),	length));
				String[] bkgStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_sts_cd".trim(),	length));
				String[] cxlFlg =	(JSPUtil.getParameter(request, prefix +	"cxl_flg".trim(),	length));
				String[] chnAgnCd =	(JSPUtil.getParameter(request, prefix +	"chn_agn_cd".trim(),	length));
				String[] whfDeclNo =	(JSPUtil.getParameter(request, prefix +	"whf_decl_no".trim(),	length));
				String[] autoMnlDivCd =	(JSPUtil.getParameter(request, prefix +	"auto_mnl_div_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] obrdDt =	(JSPUtil.getParameter(request, prefix +	"obrd_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BLNoBKGStatusVO();
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( whfDeclCxlFlg[i] !=	null)
						model.setWhfDeclCxlFlg( whfDeclCxlFlg[i]);
						if ( bkgStsCd[i] !=	null)
						model.setBkgStsCd( bkgStsCd[i]);
						if ( cxlFlg[i] !=	null)
						model.setCxlFlg( cxlFlg[i]);
						if ( chnAgnCd[i] !=	null)
						model.setChnAgnCd( chnAgnCd[i]);
						if ( whfDeclNo[i] !=	null)
						model.setWhfDeclNo( whfDeclNo[i]);
						if ( autoMnlDivCd[i] !=	null)
						model.setAutoMnlDivCd( autoMnlDivCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( obrdDt[i] !=	null)
						model.setObrdDt( obrdDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBLNoBKGStatusVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BLNoBKGStatusVO[]
	 */
	public BLNoBKGStatusVO[]	 getBLNoBKGStatusVOs(){
		BLNoBKGStatusVO[] vos = (BLNoBKGStatusVO[])models.toArray(new	BLNoBKGStatusVO[models.size()]);
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
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclCxlFlg =	this.whfDeclCxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd =	this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg =	this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd =	this.chnAgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo =	this.whfDeclNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlDivCd =	this.autoMnlDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt =	this.obrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}