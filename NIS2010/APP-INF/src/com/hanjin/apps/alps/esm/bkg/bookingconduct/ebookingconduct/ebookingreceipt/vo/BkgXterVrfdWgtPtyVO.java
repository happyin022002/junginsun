/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterVrfdWgtPtyVO.java
 *@FileTitle : BkgXterVrfdWgtPtyVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.24  
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
public class BkgXterVrfdWgtPtyVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterVrfdWgtPtyVO>  models =	new	ArrayList<BkgXterVrfdWgtPtyVO>();


	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyEml   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyAddr   =  null;
	/*	Column Info	*/
	private  String	 xterSndrId   =  null;
	/*	Column Info	*/
	private  String	 xterVgmRqstNo   =  null;
	/*	Column Info	*/
	private  String	 xterVgmSeq   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyFaxNo   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyCntcPhnNo   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyTpCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 vgmPtyId   =  null;
	/*	Column Info	*/
	private  String	 authPsonNm   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterVrfdWgtPtyVO(){}

	public BkgXterVrfdWgtPtyVO(String pagerows,String vgmPtyEml,String ibflag,String vgmPtyAddr,String xterSndrId,String xterVgmRqstNo,String xterVgmSeq,String vgmPtyFaxNo,String vgmPtyCntcPhnNo,String updUsrId,String vgmPtyTpCd,String creUsrId,String creDt,String updDt,String vgmPtyId,String authPsonNm,String cntrNo)	{
		this.pagerows  = pagerows ;
		this.vgmPtyEml  = vgmPtyEml ;
		this.ibflag  = ibflag ;
		this.vgmPtyAddr  = vgmPtyAddr ;
		this.xterSndrId  = xterSndrId ;
		this.xterVgmRqstNo  = xterVgmRqstNo ;
		this.xterVgmSeq  = xterVgmSeq ;
		this.vgmPtyFaxNo  = vgmPtyFaxNo ;
		this.vgmPtyCntcPhnNo  = vgmPtyCntcPhnNo ;
		this.updUsrId  = updUsrId ;
		this.vgmPtyTpCd  = vgmPtyTpCd ;
		this.creUsrId  = creUsrId ;
		this.creDt  = creDt ;
		this.updDt  = updDt ;
		this.vgmPtyId  = vgmPtyId ;
		this.authPsonNm  = authPsonNm ;
		this.cntrNo  = cntrNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vgm_pty_eml", getVgmPtyEml());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vgm_pty_addr", getVgmPtyAddr());		
		this.hashColumns.put("xter_sndr_id", getXterSndrId());		
		this.hashColumns.put("xter_vgm_rqst_no", getXterVgmRqstNo());		
		this.hashColumns.put("xter_vgm_seq", getXterVgmSeq());		
		this.hashColumns.put("vgm_pty_fax_no", getVgmPtyFaxNo());		
		this.hashColumns.put("vgm_pty_cntc_phn_no", getVgmPtyCntcPhnNo());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("vgm_pty_tp_cd", getVgmPtyTpCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("vgm_pty_id", getVgmPtyId());		
		this.hashColumns.put("auth_pson_nm", getAuthPsonNm());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vgm_pty_eml", "vgmPtyEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vgm_pty_addr", "vgmPtyAddr");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_vgm_rqst_no", "xterVgmRqstNo");
		this.hashFields.put("xter_vgm_seq", "xterVgmSeq");
		this.hashFields.put("vgm_pty_fax_no", "vgmPtyFaxNo");
		this.hashFields.put("vgm_pty_cntc_phn_no", "vgmPtyCntcPhnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vgm_pty_tp_cd", "vgmPtyTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vgm_pty_id", "vgmPtyId");
		this.hashFields.put("auth_pson_nm", "authPsonNm");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  vgmPtyEml
	*/
	public void	setVgmPtyEml( String	vgmPtyEml ) {
		this.vgmPtyEml =	vgmPtyEml;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyEml
	 */
	 public	String	getVgmPtyEml() {
		 return	this.vgmPtyEml;
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
	* @param  vgmPtyAddr
	*/
	public void	setVgmPtyAddr( String	vgmPtyAddr ) {
		this.vgmPtyAddr =	vgmPtyAddr;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyAddr
	 */
	 public	String	getVgmPtyAddr() {
		 return	this.vgmPtyAddr;
	 } 
 	/**
	* Column Info
	* @param  xterSndrId
	*/
	public void	setXterSndrId( String	xterSndrId ) {
		this.xterSndrId =	xterSndrId;
	}
 
	/**
	 * Column Info
	 * @return	xterSndrId
	 */
	 public	String	getXterSndrId() {
		 return	this.xterSndrId;
	 } 
 	/**
	* Column Info
	* @param  xterVgmRqstNo
	*/
	public void	setXterVgmRqstNo( String	xterVgmRqstNo ) {
		this.xterVgmRqstNo =	xterVgmRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	xterVgmRqstNo
	 */
	 public	String	getXterVgmRqstNo() {
		 return	this.xterVgmRqstNo;
	 } 
 	/**
	* Column Info
	* @param  xterVgmSeq
	*/
	public void	setXterVgmSeq( String	xterVgmSeq ) {
		this.xterVgmSeq =	xterVgmSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterVgmSeq
	 */
	 public	String	getXterVgmSeq() {
		 return	this.xterVgmSeq;
	 } 
 	/**
	* Column Info
	* @param  vgmPtyFaxNo
	*/
	public void	setVgmPtyFaxNo( String	vgmPtyFaxNo ) {
		this.vgmPtyFaxNo =	vgmPtyFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyFaxNo
	 */
	 public	String	getVgmPtyFaxNo() {
		 return	this.vgmPtyFaxNo;
	 } 
 	/**
	* Column Info
	* @param  vgmPtyCntcPhnNo
	*/
	public void	setVgmPtyCntcPhnNo( String	vgmPtyCntcPhnNo ) {
		this.vgmPtyCntcPhnNo =	vgmPtyCntcPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyCntcPhnNo
	 */
	 public	String	getVgmPtyCntcPhnNo() {
		 return	this.vgmPtyCntcPhnNo;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  vgmPtyTpCd
	*/
	public void	setVgmPtyTpCd( String	vgmPtyTpCd ) {
		this.vgmPtyTpCd =	vgmPtyTpCd;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyTpCd
	 */
	 public	String	getVgmPtyTpCd() {
		 return	this.vgmPtyTpCd;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	String	getCreDt() {
		 return	this.creDt;
	 } 
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
	 public	String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  vgmPtyId
	*/
	public void	setVgmPtyId( String	vgmPtyId ) {
		this.vgmPtyId =	vgmPtyId;
	}
 
	/**
	 * Column Info
	 * @return	vgmPtyId
	 */
	 public	String	getVgmPtyId() {
		 return	this.vgmPtyId;
	 } 
 	/**
	* Column Info
	* @param  authPsonNm
	*/
	public void	setAuthPsonNm( String	authPsonNm ) {
		this.authPsonNm =	authPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	authPsonNm
	 */
	 public	String	getAuthPsonNm() {
		 return	this.authPsonNm;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	String	getCntrNo() {
		 return	this.cntrNo;
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
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVgmPtyEml(JSPUtil.getParameter(request,	prefix + "vgm_pty_eml", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVgmPtyAddr(JSPUtil.getParameter(request,	prefix + "vgm_pty_addr", ""));
		setXterSndrId(JSPUtil.getParameter(request,	prefix + "xter_sndr_id", ""));
		setXterVgmRqstNo(JSPUtil.getParameter(request,	prefix + "xter_vgm_rqst_no", ""));
		setXterVgmSeq(JSPUtil.getParameter(request,	prefix + "xter_vgm_seq", ""));
		setVgmPtyFaxNo(JSPUtil.getParameter(request,	prefix + "vgm_pty_fax_no", ""));
		setVgmPtyCntcPhnNo(JSPUtil.getParameter(request,	prefix + "vgm_pty_cntc_phn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setVgmPtyTpCd(JSPUtil.getParameter(request,	prefix + "vgm_pty_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setVgmPtyId(JSPUtil.getParameter(request,	prefix + "vgm_pty_id", ""));
		setAuthPsonNm(JSPUtil.getParameter(request,	prefix + "auth_pson_nm", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterVrfdWgtPtyVO[]
	 */
	public BkgXterVrfdWgtPtyVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterVrfdWgtPtyVO[]
	 */
	public BkgXterVrfdWgtPtyVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterVrfdWgtPtyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vgmPtyEml =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_eml".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vgmPtyAddr =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_addr".trim(),	length));
				String[] xterSndrId =	(JSPUtil.getParameter(request, prefix +	"xter_sndr_id".trim(),	length));
				String[] xterVgmRqstNo =	(JSPUtil.getParameter(request, prefix +	"xter_vgm_rqst_no".trim(),	length));
				String[] xterVgmSeq =	(JSPUtil.getParameter(request, prefix +	"xter_vgm_seq".trim(),	length));
				String[] vgmPtyFaxNo =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_fax_no".trim(),	length));
				String[] vgmPtyCntcPhnNo =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_cntc_phn_no".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] vgmPtyTpCd =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_tp_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] vgmPtyId =	(JSPUtil.getParameter(request, prefix +	"vgm_pty_id".trim(),	length));
				String[] authPsonNm =	(JSPUtil.getParameter(request, prefix +	"auth_pson_nm".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterVrfdWgtPtyVO();
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vgmPtyEml[i] !=	null)
						model.setVgmPtyEml( vgmPtyEml[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vgmPtyAddr[i] !=	null)
						model.setVgmPtyAddr( vgmPtyAddr[i]);
						if ( xterSndrId[i] !=	null)
						model.setXterSndrId( xterSndrId[i]);
						if ( xterVgmRqstNo[i] !=	null)
						model.setXterVgmRqstNo( xterVgmRqstNo[i]);
						if ( xterVgmSeq[i] !=	null)
						model.setXterVgmSeq( xterVgmSeq[i]);
						if ( vgmPtyFaxNo[i] !=	null)
						model.setVgmPtyFaxNo( vgmPtyFaxNo[i]);
						if ( vgmPtyCntcPhnNo[i] !=	null)
						model.setVgmPtyCntcPhnNo( vgmPtyCntcPhnNo[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( vgmPtyTpCd[i] !=	null)
						model.setVgmPtyTpCd( vgmPtyTpCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( vgmPtyId[i] !=	null)
						model.setVgmPtyId( vgmPtyId[i]);
						if ( authPsonNm[i] !=	null)
						model.setAuthPsonNm( authPsonNm[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterVrfdWgtPtyVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterVrfdWgtPtyVO[]
	 */
	public BkgXterVrfdWgtPtyVO[]	 getBkgXterVrfdWgtPtyVOs(){
		BkgXterVrfdWgtPtyVO[] vos = (BkgXterVrfdWgtPtyVO[])models.toArray(new	BkgXterVrfdWgtPtyVO[models.size()]);
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
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyEml =	this.vgmPtyEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyAddr =	this.vgmPtyAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId =	this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstNo =	this.xterVgmRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmSeq =	this.xterVgmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyFaxNo =	this.vgmPtyFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyCntcPhnNo =	this.vgmPtyCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyTpCd =	this.vgmPtyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmPtyId =	this.vgmPtyId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPsonNm =	this.authPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}