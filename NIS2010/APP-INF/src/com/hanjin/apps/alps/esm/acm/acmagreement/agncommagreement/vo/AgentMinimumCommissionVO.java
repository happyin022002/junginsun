/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AgentMinimumCommissionVO.java
 *@FileTitle : AgentMinimumCommissionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.03.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.03.22  
 * 1.0 Creation
=========================================================*/
 
package	 com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
public class AgentMinimumCommissionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AgentMinimumCommissionVO>  models =	new	ArrayList<AgentMinimumCommissionVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 agnCd   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 acTpCd   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtMinCommSeq   =  null;
	/*	Column Info	*/
	private  String	 minCommDivCd   =  null;
	/*	Column Info	*/
	private  String	 minCommRt   =  null;
	/*	Column Info	*/
	private  String	 minCommCurrCd   =  null;
	/*	Column Info	*/
	private  String	 minCommPerCd   =  null;
	/*	Column Info	*/
	private  String	 minCommNetRevAmt   =  null;
	/*	Column Info	*/
	private  String	 minCommNetRevCurrCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 agmtDtlHisNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AgentMinimumCommissionVO(){}

	public AgentMinimumCommissionVO(String ibflag,String agnCd,String agnAgmtNo,String ioBndCd,String acTpCd,String agnAgmtSeq,String agnAgmtMinCommSeq,String minCommDivCd,String minCommRt,String minCommCurrCd,String minCommPerCd,String minCommNetRevAmt,String minCommNetRevCurrCd,String creUsrId,String creDt,String updUsrId,String updDt,String agmtDtlHisNo)	{
		this.ibflag  = ibflag ;
		this.agnCd  = agnCd ;
		this.agnAgmtNo  = agnAgmtNo ;
		this.ioBndCd  = ioBndCd ;
		this.acTpCd  = acTpCd ;
		this.agnAgmtSeq  = agnAgmtSeq ;
		this.agnAgmtMinCommSeq  = agnAgmtMinCommSeq ;
		this.minCommDivCd  = minCommDivCd ;
		this.minCommRt  = minCommRt ;
		this.minCommCurrCd  = minCommCurrCd ;
		this.minCommPerCd  = minCommPerCd ;
		this.minCommNetRevAmt  = minCommNetRevAmt ;
		this.minCommNetRevCurrCd  = minCommNetRevCurrCd ;
		this.creUsrId  = creUsrId ;
		this.creDt  = creDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.agmtDtlHisNo  = agmtDtlHisNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_flag", getIbflag());		
		this.hashColumns.put("agn_cd", getAgnCd());		
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ac_tp_cd", getAcTpCd());		
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());		
		this.hashColumns.put("agn_agmt_min_comm_seq", getAgnAgmtMinCommSeq());		
		this.hashColumns.put("min_comm_div_cd", getMinCommDivCd());		
		this.hashColumns.put("min_comm_rt", getMinCommRt());		
		this.hashColumns.put("min_comm_curr_cd", getMinCommCurrCd());		
		this.hashColumns.put("min_comm_per_cd", getMinCommPerCd());		
		this.hashColumns.put("min_comm_net_rev_amt", getMinCommNetRevAmt());		
		this.hashColumns.put("min_comm_net_rev_curr_cd", getMinCommNetRevCurrCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("agmt_dtl_his_no", getAgmtDtlHisNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ib_flag", "ibflag");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("agn_agmt_min_comm_seq", "agnAgmtMinCommSeq");
		this.hashFields.put("min_comm_div_cd", "minCommDivCd");
		this.hashFields.put("min_comm_rt", "minCommRt");
		this.hashFields.put("min_comm_curr_cd", "minCommCurrCd");
		this.hashFields.put("min_comm_per_cd", "minCommPerCd");
		this.hashFields.put("min_comm_net_rev_amt", "minCommNetRevAmt");
		this.hashFields.put("min_comm_net_rev_curr_cd", "minCommNetRevCurrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_dtl_his_no", "agmtDtlHisNo");
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
	* @param  agnCd
	*/
	public void	setAgnCd( String	agnCd ) {
		this.agnCd =	agnCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCd
	 */
	 public	 String	getAgnCd() {
		 return	this.agnCd;
	 } 
 	/**
	* Column Info
	* @param  agnAgmtNo
	*/
	public void	setAgnAgmtNo( String	agnAgmtNo ) {
		this.agnAgmtNo =	agnAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtNo
	 */
	 public	 String	getAgnAgmtNo() {
		 return	this.agnAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  acTpCd
	*/
	public void	setAcTpCd( String	acTpCd ) {
		this.acTpCd =	acTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acTpCd
	 */
	 public	 String	getAcTpCd() {
		 return	this.acTpCd;
	 } 
 	/**
	* Column Info
	* @param  agnAgmtSeq
	*/
	public void	setAgnAgmtSeq( String	agnAgmtSeq ) {
		this.agnAgmtSeq =	agnAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtSeq
	 */
	 public	 String	getAgnAgmtSeq() {
		 return	this.agnAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  agnAgmtMinCommSeq
	*/
	public void	setAgnAgmtMinCommSeq( String	agnAgmtMinCommSeq ) {
		this.agnAgmtMinCommSeq =	agnAgmtMinCommSeq;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtMinCommSeq
	 */
	 public	 String	getAgnAgmtMinCommSeq() {
		 return	this.agnAgmtMinCommSeq;
	 } 
 	/**
	* Column Info
	* @param  minCommDivCd
	*/
	public void	setMinCommDivCd( String	minCommDivCd ) {
		this.minCommDivCd =	minCommDivCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommDivCd
	 */
	 public	 String	getMinCommDivCd() {
		 return	this.minCommDivCd;
	 } 
 	/**
	* Column Info
	* @param  minCommRt
	*/
	public void	setMinCommRt( String	minCommRt ) {
		this.minCommRt =	minCommRt;
	}
 
	/**
	 * Column Info
	 * @return	minCommRt
	 */
	 public	 String	getMinCommRt() {
		 return	this.minCommRt;
	 } 
 	/**
	* Column Info
	* @param  minCommCurrCd
	*/
	public void	setMinCommCurrCd( String	minCommCurrCd ) {
		this.minCommCurrCd =	minCommCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommCurrCd
	 */
	 public	 String	getMinCommCurrCd() {
		 return	this.minCommCurrCd;
	 } 
 	/**
	* Column Info
	* @param  minCommPerCd
	*/
	public void	setMinCommPerCd( String	minCommPerCd ) {
		this.minCommPerCd =	minCommPerCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommPerCd
	 */
	 public	 String	getMinCommPerCd() {
		 return	this.minCommPerCd;
	 } 
 	/**
	* Column Info
	* @param  minCommNetRevAmt
	*/
	public void	setMinCommNetRevAmt( String	minCommNetRevAmt ) {
		this.minCommNetRevAmt =	minCommNetRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	minCommNetRevAmt
	 */
	 public	 String	getMinCommNetRevAmt() {
		 return	this.minCommNetRevAmt;
	 } 
 	/**
	* Column Info
	* @param  minCommNetRevCurrCd
	*/
	public void	setMinCommNetRevCurrCd( String	minCommNetRevCurrCd ) {
		this.minCommNetRevCurrCd =	minCommNetRevCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommNetRevCurrCd
	 */
	 public	 String	getMinCommNetRevCurrCd() {
		 return	this.minCommNetRevCurrCd;
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
	 public	 String	getCreUsrId() {
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
	 public	 String	getCreDt() {
		 return	this.creDt;
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
	* @param  agmtDtlHisNo
	*/
	public void	setAgmtDtlHisNo( String	agmtDtlHisNo ) {
		this.agmtDtlHisNo =	agmtDtlHisNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtDtlHisNo
	 */
	 public	 String	getAgmtDtlHisNo() {
		 return	this.agmtDtlHisNo;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ib_flag", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request,	prefix + "agn_agmt_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request,	prefix + "ac_tp_cd", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request,	prefix + "agn_agmt_seq", ""));
		setAgnAgmtMinCommSeq(JSPUtil.getParameter(request,	prefix + "agn_agmt_min_comm_seq", ""));
		setMinCommDivCd(JSPUtil.getParameter(request,	prefix + "min_comm_div_cd", ""));
		setMinCommRt(JSPUtil.getParameter(request,	prefix + "min_comm_rt", ""));
		setMinCommCurrCd(JSPUtil.getParameter(request,	prefix + "min_comm_curr_cd", ""));
		setMinCommPerCd(JSPUtil.getParameter(request,	prefix + "min_comm_per_cd", ""));
		setMinCommNetRevAmt(JSPUtil.getParameter(request,	prefix + "min_comm_net_rev_amt", ""));
		setMinCommNetRevCurrCd(JSPUtil.getParameter(request,	prefix + "min_comm_net_rev_curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setAgmtDtlHisNo(JSPUtil.getParameter(request,	prefix + "agmt_dtl_his_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgentMinimumCommissionVO[]
	 */
	public AgentMinimumCommissionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgentMinimumCommissionVO[]
	 */
	public AgentMinimumCommissionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AgentMinimumCommissionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ib_flag".trim(),	length));
				String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd".trim(),	length));
				String[] agnAgmtNo =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] acTpCd =	(JSPUtil.getParameter(request, prefix +	"ac_tp_cd".trim(),	length));
				String[] agnAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_seq".trim(),	length));
				String[] agnAgmtMinCommSeq =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_min_comm_seq".trim(),	length));
				String[] minCommDivCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_div_cd".trim(),	length));
				String[] minCommRt =	(JSPUtil.getParameter(request, prefix +	"min_comm_rt".trim(),	length));
				String[] minCommCurrCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_curr_cd".trim(),	length));
				String[] minCommPerCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_per_cd".trim(),	length));
				String[] minCommNetRevAmt =	(JSPUtil.getParameter(request, prefix +	"min_comm_net_rev_amt".trim(),	length));
				String[] minCommNetRevCurrCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_net_rev_curr_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] agmtDtlHisNo =	(JSPUtil.getParameter(request, prefix +	"agmt_dtl_his_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AgentMinimumCommissionVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( agnCd[i] !=	null)
						model.setAgnCd( agnCd[i]);
						if ( agnAgmtNo[i] !=	null)
						model.setAgnAgmtNo( agnAgmtNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( acTpCd[i] !=	null)
						model.setAcTpCd( acTpCd[i]);
						if ( agnAgmtSeq[i] !=	null)
						model.setAgnAgmtSeq( agnAgmtSeq[i]);
						if ( agnAgmtMinCommSeq[i] !=	null)
						model.setAgnAgmtMinCommSeq( agnAgmtMinCommSeq[i]);
						if ( minCommDivCd[i] !=	null)
						model.setMinCommDivCd( minCommDivCd[i]);
						if ( minCommRt[i] !=	null)
						model.setMinCommRt( minCommRt[i]);
						if ( minCommCurrCd[i] !=	null)
						model.setMinCommCurrCd( minCommCurrCd[i]);
						if ( minCommPerCd[i] !=	null)
						model.setMinCommPerCd( minCommPerCd[i]);
						if ( minCommNetRevAmt[i] !=	null)
						model.setMinCommNetRevAmt( minCommNetRevAmt[i]);
						if ( minCommNetRevCurrCd[i] !=	null)
						model.setMinCommNetRevCurrCd( minCommNetRevCurrCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( agmtDtlHisNo[i] !=	null)
						model.setAgmtDtlHisNo( agmtDtlHisNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAgentMinimumCommissionVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AgentMinimumCommissionVO[]
	 */
	public AgentMinimumCommissionVO[]	 getAgentMinimumCommissionVOs(){
		AgentMinimumCommissionVO[] vos = (AgentMinimumCommissionVO[])models.toArray(new	AgentMinimumCommissionVO[models.size()]);
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
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo =	this.agnAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd =	this.acTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq =	this.agnAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtMinCommSeq =	this.agnAgmtMinCommSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommDivCd =	this.minCommDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommRt =	this.minCommRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommCurrCd =	this.minCommCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommPerCd =	this.minCommPerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommNetRevAmt =	this.minCommNetRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommNetRevCurrCd =	this.minCommNetRevCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDtlHisNo =	this.agmtDtlHisNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}