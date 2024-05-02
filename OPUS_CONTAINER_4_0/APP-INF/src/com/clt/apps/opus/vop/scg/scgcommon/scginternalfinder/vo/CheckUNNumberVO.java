/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CheckUNNumberVO.java
 *@FileTitle : CheckUNNumberVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.29
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.29  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class CheckUNNumberVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CheckUNNumberVO>  models =	new	ArrayList<CheckUNNumberVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNoSeqMin   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNoSeq   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNoSeqCnt   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNoSeqMax   =  null;
	/*	Column Info	*/
	private  String	 imdgUnNo   =  null;
	/*	Column Info	*/
	private  String	 cfrFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 prpShpNm   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CheckUNNumberVO(){}

	public CheckUNNumberVO(String updDt,String ibflag,String imdgUnNoSeqMin,String imdgUnNoSeq,String imdgUnNoSeqCnt,String imdgUnNoSeqMax,String imdgUnNo,String cfrFlg,String pagerows,String prpShpNm)	{
		this.updDt  = updDt ;
		this.ibflag  = ibflag ;
		this.imdgUnNoSeqMin  = imdgUnNoSeqMin ;
		this.imdgUnNoSeq  = imdgUnNoSeq ;
		this.imdgUnNoSeqCnt  = imdgUnNoSeqCnt ;
		this.imdgUnNoSeqMax  = imdgUnNoSeqMax ;
		this.imdgUnNo  = imdgUnNo ;
		this.cfrFlg  = cfrFlg ;
		this.pagerows  = pagerows ;
		this.prpShpNm  = prpShpNm ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("imdg_un_no_seq_min", getImdgUnNoSeqMin());		
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());		
		this.hashColumns.put("imdg_un_no_seq_cnt", getImdgUnNoSeqCnt());		
		this.hashColumns.put("imdg_un_no_seq_max", getImdgUnNoSeqMax());		
		this.hashColumns.put("imdg_un_no", getImdgUnNo());		
		this.hashColumns.put("cfr_flg", getCfrFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_un_no_seq_min", "imdgUnNoSeqMin");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("imdg_un_no_seq_cnt", "imdgUnNoSeqCnt");
		this.hashFields.put("imdg_un_no_seq_max", "imdgUnNoSeqMax");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("cfr_flg", "cfrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
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
	* @param  imdgUnNoSeqMin
	*/
	public void	setImdgUnNoSeqMin( String	imdgUnNoSeqMin ) {
		this.imdgUnNoSeqMin =	imdgUnNoSeqMin;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNoSeqMin
	 */
	 public	 String	getImdgUnNoSeqMin() {
		 return	this.imdgUnNoSeqMin;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNoSeq
	*/
	public void	setImdgUnNoSeq( String	imdgUnNoSeq ) {
		this.imdgUnNoSeq =	imdgUnNoSeq;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNoSeq
	 */
	 public	 String	getImdgUnNoSeq() {
		 return	this.imdgUnNoSeq;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNoSeqCnt
	*/
	public void	setImdgUnNoSeqCnt( String	imdgUnNoSeqCnt ) {
		this.imdgUnNoSeqCnt =	imdgUnNoSeqCnt;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNoSeqCnt
	 */
	 public	 String	getImdgUnNoSeqCnt() {
		 return	this.imdgUnNoSeqCnt;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNoSeqMax
	*/
	public void	setImdgUnNoSeqMax( String	imdgUnNoSeqMax ) {
		this.imdgUnNoSeqMax =	imdgUnNoSeqMax;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNoSeqMax
	 */
	 public	 String	getImdgUnNoSeqMax() {
		 return	this.imdgUnNoSeqMax;
	 } 
 	/**
	* Column Info
	* @param  imdgUnNo
	*/
	public void	setImdgUnNo( String	imdgUnNo ) {
		this.imdgUnNo =	imdgUnNo;
	}
 
	/**
	 * Column Info
	 * @return	imdgUnNo
	 */
	 public	 String	getImdgUnNo() {
		 return	this.imdgUnNo;
	 } 
 	/**
	* Column Info
	* @param  cfrFlg
	*/
	public void	setCfrFlg( String	cfrFlg ) {
		this.cfrFlg =	cfrFlg;
	}
 
	/**
	 * Column Info
	 * @return	cfrFlg
	 */
	 public	 String	getCfrFlg() {
		 return	this.cfrFlg;
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
	* @param  prpShpNm
	*/
	public void	setPrpShpNm( String	prpShpNm ) {
		this.prpShpNm =	prpShpNm;
	}
 
	/**
	 * Column Info
	 * @return	prpShpNm
	 */
	 public	 String	getPrpShpNm() {
		 return	this.prpShpNm;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setImdgUnNoSeqMin(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq_min", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq", ""));
		setImdgUnNoSeqCnt(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq_cnt", ""));
		setImdgUnNoSeqMax(JSPUtil.getParameter(request,	prefix + "imdg_un_no_seq_max", ""));
		setImdgUnNo(JSPUtil.getParameter(request,	prefix + "imdg_un_no", ""));
		setCfrFlg(JSPUtil.getParameter(request,	prefix + "cfr_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPrpShpNm(JSPUtil.getParameter(request,	prefix + "prp_shp_nm", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return CheckUNNumberVO[]
	 */
	public CheckUNNumberVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return CheckUNNumberVO[]
	 */
	public CheckUNNumberVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CheckUNNumberVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] imdgUnNoSeqMin =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq_min".trim(),	length));
				String[] imdgUnNoSeq =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq".trim(),	length));
				String[] imdgUnNoSeqCnt =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq_cnt".trim(),	length));
				String[] imdgUnNoSeqMax =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no_seq_max".trim(),	length));
				String[] imdgUnNo =	(JSPUtil.getParameter(request, prefix +	"imdg_un_no".trim(),	length));
				String[] cfrFlg =	(JSPUtil.getParameter(request, prefix +	"cfr_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] prpShpNm =	(JSPUtil.getParameter(request, prefix +	"prp_shp_nm".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CheckUNNumberVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( imdgUnNoSeqMin[i] !=	null)
						model.setImdgUnNoSeqMin( imdgUnNoSeqMin[i]);
						if ( imdgUnNoSeq[i] !=	null)
						model.setImdgUnNoSeq( imdgUnNoSeq[i]);
						if ( imdgUnNoSeqCnt[i] !=	null)
						model.setImdgUnNoSeqCnt( imdgUnNoSeqCnt[i]);
						if ( imdgUnNoSeqMax[i] !=	null)
						model.setImdgUnNoSeqMax( imdgUnNoSeqMax[i]);
						if ( imdgUnNo[i] !=	null)
						model.setImdgUnNo( imdgUnNo[i]);
						if ( cfrFlg[i] !=	null)
						model.setCfrFlg( cfrFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( prpShpNm[i] !=	null)
						model.setPrpShpNm( prpShpNm[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCheckUNNumberVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return CheckUNNumberVO[]
	 */
	public CheckUNNumberVO[]	 getCheckUNNumberVOs(){
		CheckUNNumberVO[] vos = (CheckUNNumberVO[])models.toArray(new	CheckUNNumberVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqMin =	this.imdgUnNoSeqMin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq =	this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqCnt =	this.imdgUnNoSeqCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqMax =	this.imdgUnNoSeqMax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo =	this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrFlg =	this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm =	this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}