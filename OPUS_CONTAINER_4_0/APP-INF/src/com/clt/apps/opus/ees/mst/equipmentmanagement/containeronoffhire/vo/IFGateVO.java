/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IFGateVO.java
 *@FileTitle : IFGateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.09.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.09.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
public class IFGateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<IFGateVO>  models =	new	ArrayList<IFGateVO>();


	/*	Column Info	*/
	private  String	 cnmvCycNo   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvSeq   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 orgYdCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvSplitNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 backDateFlg   = "N";

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public IFGateVO(){}

	public IFGateVO(String cnmvCycNo,String cntrStsCd,String cnmvSeq,String cnmvDt,String cnmvEvntDt,String orgYdCd,String pagerows,String cnmvIdNo,String cnmvSplitNo,String ibflag,String mvmtStsCd,String cntrNo,String cnmvYr,String updUsrId,String backDateFlg)	{
		this.cnmvCycNo  = cnmvCycNo ;
		this.cntrStsCd  = cntrStsCd ;
		this.cnmvSeq  = cnmvSeq ;
		this.cnmvDt  = cnmvDt ;
		this.cnmvEvntDt  = cnmvEvntDt ;
		this.orgYdCd  = orgYdCd ;
		this.pagerows  = pagerows ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.cnmvSplitNo  = cnmvSplitNo ;
		this.ibflag  = ibflag ;
		this.mvmtStsCd  = mvmtStsCd ;
		this.cntrNo  = cntrNo ;
		this.cnmvYr  = cnmvYr ;
		this.updUsrId  = updUsrId ;
		this.backDateFlg  = backDateFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("cnmv_seq", getCnmvSeq());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());		
		this.hashColumns.put("org_yd_cd", getOrgYdCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("back_date_flg", getBackDateFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("back_date_flg", "backDateFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cnmvCycNo
	*/
	public void	setCnmvCycNo( String	cnmvCycNo ) {
		this.cnmvCycNo =	cnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNo
	 */
	 public	 String	getCnmvCycNo() {
		 return	this.cnmvCycNo;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvSeq
	*/
	public void	setCnmvSeq( String	cnmvSeq ) {
		this.cnmvSeq =	cnmvSeq;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSeq
	 */
	 public	 String	getCnmvSeq() {
		 return	this.cnmvSeq;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
	 } 
 	/**
	* Column Info
	* @param  cnmvEvntDt
	*/
	public void	setCnmvEvntDt( String	cnmvEvntDt ) {
		this.cnmvEvntDt =	cnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvEvntDt
	 */
	 public	 String	getCnmvEvntDt() {
		 return	this.cnmvEvntDt;
	 } 
 	/**
	* Column Info
	* @param  orgYdCd
	*/
	public void	setOrgYdCd( String	orgYdCd ) {
		this.orgYdCd =	orgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	orgYdCd
	 */
	 public	 String	getOrgYdCd() {
		 return	this.orgYdCd;
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
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvSplitNo
	*/
	public void	setCnmvSplitNo( String	cnmvSplitNo ) {
		this.cnmvSplitNo =	cnmvSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSplitNo
	 */
	 public	 String	getCnmvSplitNo() {
		 return	this.cnmvSplitNo;
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
	* @param  mvmtStsCd
	*/
	public void	setMvmtStsCd( String	mvmtStsCd ) {
		this.mvmtStsCd =	mvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStsCd
	 */
	 public	 String	getMvmtStsCd() {
		 return	this.mvmtStsCd;
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
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
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
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  backDateFlg
	*/
	public void	setBackDateFlg( String	backDateFlg ) {
		this.backDateFlg =	backDateFlg;
	}
 
	/**
	 * Column Info
	 * @return	backDateFlg
	 */
	 public	 String	getBackDateFlg() {
		 return	this.backDateFlg;
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
		setCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setCnmvSeq(JSPUtil.getParameter(request,	prefix + "cnmv_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "cnmv_evnt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request,	prefix + "org_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request,	prefix + "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setBackDateFlg(JSPUtil.getParameter(request,	prefix + "back_date_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IFGateVO[]
	 */
	public IFGateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return IFGateVO[]
	 */
	public IFGateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		IFGateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] cnmvSeq =	(JSPUtil.getParameter(request, prefix +	"cnmv_seq".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] cnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_evnt_dt".trim(),	length));
				String[] orgYdCd =	(JSPUtil.getParameter(request, prefix +	"org_yd_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] cnmvSplitNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_split_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] backDateFlg =	(JSPUtil.getParameter(request, prefix +	"back_date_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	IFGateVO();
						if ( cnmvCycNo[i] !=	null)
						model.setCnmvCycNo( cnmvCycNo[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( cnmvSeq[i] !=	null)
						model.setCnmvSeq( cnmvSeq[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( cnmvEvntDt[i] !=	null)
						model.setCnmvEvntDt( cnmvEvntDt[i]);
						if ( orgYdCd[i] !=	null)
						model.setOrgYdCd( orgYdCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( cnmvSplitNo[i] !=	null)
						model.setCnmvSplitNo( cnmvSplitNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( backDateFlg[i] !=	null)
						model.setBackDateFlg( backDateFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getIFGateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return IFGateVO[]
	 */
	public IFGateVO[]	 getIFGateVOs(){
		IFGateVO[] vos = (IFGateVO[])models.toArray(new	IFGateVO[models.size()]);
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
		this.cnmvCycNo =	this.cnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq =	this.cnmvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt =	this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd =	this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo =	this.cnmvSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backDateFlg =	this.backDateFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}