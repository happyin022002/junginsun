/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterTroVO.java
 *@FileTitle : BkgXterTroVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.26  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class BkgXterTroVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterTroVO>  models =	new	ArrayList<BkgXterTroVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 diffRmk   =  null;
	/*	Column Info	*/
	private  String	 dorPstNo   =  null;
	/*	Column Info	*/
	private  String	 isEur   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 troSeq   =  null;
	/*	Column Info	*/
	private  String	 ownrTrkFlg   =  null;
	/*	Column Info	*/
	private  String	 cntcMphnNo   =  null;
	/*	Column Info	*/
	private  String	 cntcPhnNo   =  null;
	/*	Column Info	*/
	private  String	 actShprNm   =  null;
	/*	Column Info	*/
	private  String	 actShprAddr   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterTroVO(){}

	public BkgXterTroVO(String ibflag,String diffRmk,String dorPstNo,String isEur,String cntcPsonNm,String troSeq,String ownrTrkFlg,String cntcMphnNo,String cntcPhnNo,String actShprNm,String actShprAddr,String pagerows,String cntrRtnYdCd,String cntrRtnDt)	{
		this.ibflag  = ibflag ;
		this.diffRmk  = diffRmk ;
		this.dorPstNo  = dorPstNo ;
		this.isEur  = isEur ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.troSeq  = troSeq ;
		this.ownrTrkFlg  = ownrTrkFlg ;
		this.cntcMphnNo  = cntcMphnNo ;
		this.cntcPhnNo  = cntcPhnNo ;
		this.actShprNm  = actShprNm ;
		this.actShprAddr  = actShprAddr ;
		this.pagerows  = pagerows ;
		this.cntrRtnYdCd  = cntrRtnYdCd ;
		this.cntrRtnDt  = cntrRtnDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("diff_rmk", getDiffRmk());		
		this.hashColumns.put("dor_pst_no", getDorPstNo());		
		this.hashColumns.put("is_eur", getIsEur());		
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());		
		this.hashColumns.put("tro_seq", getTroSeq());		
		this.hashColumns.put("ownr_trk_flg", getOwnrTrkFlg());		
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());		
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());		
		this.hashColumns.put("act_shpr_nm", getActShprNm());		
		this.hashColumns.put("act_shpr_addr", getActShprAddr());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());		
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("dor_pst_no", "dorPstNo");
		this.hashFields.put("is_eur", "isEur");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("ownr_trk_flg", "ownrTrkFlg");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("act_shpr_addr", "actShprAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  diffRmk
	*/
	public void	setDiffRmk( String	diffRmk ) {
		this.diffRmk =	diffRmk;
	}
 
	/**
	 * Column Info
	 * @return	diffRmk
	 */
	 public	String	getDiffRmk() {
		 return	this.diffRmk;
	 } 
 	/**
	* Column Info
	* @param  dorPstNo
	*/
	public void	setDorPstNo( String	dorPstNo ) {
		this.dorPstNo =	dorPstNo;
	}
 
	/**
	 * Column Info
	 * @return	dorPstNo
	 */
	 public	String	getDorPstNo() {
		 return	this.dorPstNo;
	 } 
 	/**
	* Column Info
	* @param  isEur
	*/
	public void	setIsEur( String	isEur ) {
		this.isEur =	isEur;
	}
 
	/**
	 * Column Info
	 * @return	isEur
	 */
	 public	String	getIsEur() {
		 return	this.isEur;
	 } 
 	/**
	* Column Info
	* @param  cntcPsonNm
	*/
	public void	setCntcPsonNm( String	cntcPsonNm ) {
		this.cntcPsonNm =	cntcPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonNm
	 */
	 public	String	getCntcPsonNm() {
		 return	this.cntcPsonNm;
	 } 
 	/**
	* Column Info
	* @param  troSeq
	*/
	public void	setTroSeq( String	troSeq ) {
		this.troSeq =	troSeq;
	}
 
	/**
	 * Column Info
	 * @return	troSeq
	 */
	 public	String	getTroSeq() {
		 return	this.troSeq;
	 } 
 	/**
	* Column Info
	* @param  ownrTrkFlg
	*/
	public void	setOwnrTrkFlg( String	ownrTrkFlg ) {
		this.ownrTrkFlg =	ownrTrkFlg;
	}
 
	/**
	 * Column Info
	 * @return	ownrTrkFlg
	 */
	 public	String	getOwnrTrkFlg() {
		 return	this.ownrTrkFlg;
	 } 
 	/**
	* Column Info
	* @param  cntcMphnNo
	*/
	public void	setCntcMphnNo( String	cntcMphnNo ) {
		this.cntcMphnNo =	cntcMphnNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcMphnNo
	 */
	 public	String	getCntcMphnNo() {
		 return	this.cntcMphnNo;
	 } 
 	/**
	* Column Info
	* @param  cntcPhnNo
	*/
	public void	setCntcPhnNo( String	cntcPhnNo ) {
		this.cntcPhnNo =	cntcPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcPhnNo
	 */
	 public	String	getCntcPhnNo() {
		 return	this.cntcPhnNo;
	 } 
 	/**
	* Column Info
	* @param  actShprNm
	*/
	public void	setActShprNm( String	actShprNm ) {
		this.actShprNm =	actShprNm;
	}
 
	/**
	 * Column Info
	 * @return	actShprNm
	 */
	 public	String	getActShprNm() {
		 return	this.actShprNm;
	 } 
 	/**
	* Column Info
	* @param  actShprAddr
	*/
	public void	setActShprAddr( String	actShprAddr ) {
		this.actShprAddr =	actShprAddr;
	}
 
	/**
	 * Column Info
	 * @return	actShprAddr
	 */
	 public	String	getActShprAddr() {
		 return	this.actShprAddr;
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
	* @param  cntrRtnYdCd
	*/
	public void	setCntrRtnYdCd( String	cntrRtnYdCd ) {
		this.cntrRtnYdCd =	cntrRtnYdCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnYdCd
	 */
	 public	String	getCntrRtnYdCd() {
		 return	this.cntrRtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRtnDt
	*/
	public void	setCntrRtnDt( String	cntrRtnDt ) {
		this.cntrRtnDt =	cntrRtnDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnDt
	 */
	 public	String	getCntrRtnDt() {
		 return	this.cntrRtnDt;
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
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setDorPstNo(JSPUtil.getParameter(request,	prefix + "dor_pst_no", ""));
		setIsEur(JSPUtil.getParameter(request,	prefix + "is_eur", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setTroSeq(JSPUtil.getParameter(request,	prefix + "tro_seq", ""));
		setOwnrTrkFlg(JSPUtil.getParameter(request,	prefix + "ownr_trk_flg", ""));
		setCntcMphnNo(JSPUtil.getParameter(request,	prefix + "cntc_mphn_no", ""));
		setCntcPhnNo(JSPUtil.getParameter(request,	prefix + "cntc_phn_no", ""));
		setActShprNm(JSPUtil.getParameter(request,	prefix + "act_shpr_nm", ""));
		setActShprAddr(JSPUtil.getParameter(request,	prefix + "act_shpr_addr", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request,	prefix + "cntr_rtn_yd_cd", ""));
		setCntrRtnDt(JSPUtil.getParameter(request,	prefix + "cntr_rtn_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterTroVO[]
	 */
	public BkgXterTroVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterTroVO[]
	 */
	public BkgXterTroVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterTroVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk".trim(),	length));
				String[] dorPstNo =	(JSPUtil.getParameter(request, prefix +	"dor_pst_no".trim(),	length));
				String[] isEur =	(JSPUtil.getParameter(request, prefix +	"is_eur".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] troSeq =	(JSPUtil.getParameter(request, prefix +	"tro_seq".trim(),	length));
				String[] ownrTrkFlg =	(JSPUtil.getParameter(request, prefix +	"ownr_trk_flg".trim(),	length));
				String[] cntcMphnNo =	(JSPUtil.getParameter(request, prefix +	"cntc_mphn_no".trim(),	length));
				String[] cntcPhnNo =	(JSPUtil.getParameter(request, prefix +	"cntc_phn_no".trim(),	length));
				String[] actShprNm =	(JSPUtil.getParameter(request, prefix +	"act_shpr_nm".trim(),	length));
				String[] actShprAddr =	(JSPUtil.getParameter(request, prefix +	"act_shpr_addr".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] cntrRtnYdCd =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_yd_cd".trim(),	length));
				String[] cntrRtnDt =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterTroVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( diffRmk[i] !=	null)
						model.setDiffRmk( diffRmk[i]);
						if ( dorPstNo[i] !=	null)
						model.setDorPstNo( dorPstNo[i]);
						if ( isEur[i] !=	null)
						model.setIsEur( isEur[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( troSeq[i] !=	null)
						model.setTroSeq( troSeq[i]);
						if ( ownrTrkFlg[i] !=	null)
						model.setOwnrTrkFlg( ownrTrkFlg[i]);
						if ( cntcMphnNo[i] !=	null)
						model.setCntcMphnNo( cntcMphnNo[i]);
						if ( cntcPhnNo[i] !=	null)
						model.setCntcPhnNo( cntcPhnNo[i]);
						if ( actShprNm[i] !=	null)
						model.setActShprNm( actShprNm[i]);
						if ( actShprAddr[i] !=	null)
						model.setActShprAddr( actShprAddr[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( cntrRtnYdCd[i] !=	null)
						model.setCntrRtnYdCd( cntrRtnYdCd[i]);
						if ( cntrRtnDt[i] !=	null)
						model.setCntrRtnDt( cntrRtnDt[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterTroVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterTroVO[]
	 */
	public BkgXterTroVO[]	 getBkgXterTroVOs(){
		BkgXterTroVO[] vos = (BkgXterTroVO[])models.toArray(new	BkgXterTroVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstNo =	this.dorPstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isEur =	this.isEur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq =	this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrTrkFlg =	this.ownrTrkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo =	this.cntcMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo =	this.cntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm =	this.actShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr =	this.actShprAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd =	this.cntrRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt =	this.cntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}