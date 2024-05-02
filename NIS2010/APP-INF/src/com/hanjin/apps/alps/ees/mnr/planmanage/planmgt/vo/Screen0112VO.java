/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Screen0112VO.java
*@FileTitle : Screen0112VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.07.06 정영훈 
* 1.0 Creation
=========================================================*/

package	com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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
public class Screen0112VO	extends	AbstractValueObject
{

	private	static final long serialVersionUID = 1L;

	private	Collection<Screen0112VO> models =	new	ArrayList<Screen0112VO>();


	/*	Column Info	*/
	private	String	 office ;
	/*	Column Info	*/
	private	String	 p511511 ;
	/*	Column Info	*/
	private	String	 mnrPlnDtlSeq ;
	/*	Column Info	*/
	private	String	 creDt ;
	/*	Column Info	*/
	private	String	 mnrPlnOfcCd ;
	/*	Column Info	*/
	private	String	 mnrPlnFlg ;
	/*	Column Info	*/
	private	String	 pagerows ;
	/*	Column Info	*/
	private	String	 p511551 ;
	/*	Column Info	*/
	private	String	 ibflag ;
	/*	Column Info	*/
	private	String	 creUsrId ;
	/*	Column Info	*/
	private	String	 mnrPlnSeq ;
	/*	Column Info	*/
	private	String	 p511561 ;
	/*	Column Info	*/
	private	String	 p511531 ;
	/*	Column Info	*/
	private	String	 p511541 ;
	/*	Column Info	*/
	private	String	 p511521 ;
	/*	Column Info	*/
	private	String	 mnrPlnYr ;
	/*	Column Info	*/
	private	String	 ofcTpCd ;
	/*	Column Info	*/
	private	String	 mnrPlnOfcHdrCd ;
	/*	Column Info	*/
	private	String	 ofcTpHdrCd ;
	/*	Column Info	*/
	private	String	 mnrPlnHdrSeq ;
	/*	Column Info	*/
	private	String	 mnrPlnGrpNo ;

	/* hashColumnInpo */
	private	HashMap<String,	String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	HashMap<String,	String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public Screen0112VO(){}

	public Screen0112VO(String office,String p511511,String mnrPlnDtlSeq,String creDt,String mnrPlnOfcCd,String mnrPlnFlg,String pagerows,String p511551,String ibflag,String creUsrId,String mnrPlnSeq,String p511561,String p511531,String p511541,String p511521,String mnrPlnYr,String ofcTpCd,String mnrPlnOfcHdrCd,String ofcTpHdrCd,String mnrPlnHdrSeq,String mnrPlnGrpNo)	{
		this.office  = office ;
		this.p511511  = p511511 ;
		this.mnrPlnDtlSeq  = mnrPlnDtlSeq ;
		this.creDt  = creDt ;
		this.mnrPlnOfcCd  = mnrPlnOfcCd ;
		this.mnrPlnFlg  = mnrPlnFlg ;
		this.pagerows  = pagerows ;
		this.p511551  = p511551 ;
		this.ibflag  = ibflag ;
		this.creUsrId  = creUsrId ;
		this.mnrPlnSeq  = mnrPlnSeq ;
		this.p511561  = p511561 ;
		this.p511531  = p511531 ;
		this.p511541  = p511541 ;
		this.p511521  = p511521 ;
		this.mnrPlnYr  = mnrPlnYr ;
		this.ofcTpCd  = ofcTpCd ;
		this.mnrPlnOfcHdrCd  = mnrPlnOfcHdrCd ;
		this.ofcTpHdrCd  = ofcTpHdrCd ;
		this.mnrPlnHdrSeq  = mnrPlnHdrSeq ;
		this.mnrPlnGrpNo  = mnrPlnGrpNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());		
		this.hashColumns.put("p511511", getP511511());		
		this.hashColumns.put("mnr_pln_dtl_seq", getMnrPlnDtlSeq());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());		
		this.hashColumns.put("mnr_pln_flg", getMnrPlnFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("p511551", getP511551());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("mnr_pln_seq", getMnrPlnSeq());		
		this.hashColumns.put("p511561", getP511561());		
		this.hashColumns.put("p511531", getP511531());		
		this.hashColumns.put("p511541", getP511541());		
		this.hashColumns.put("p511521", getP511521());		
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());		
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());		
		this.hashColumns.put("mnr_pln_ofc_hdr_cd", getMnrPlnOfcHdrCd());		
		this.hashColumns.put("ofc_tp_hdr_cd", getOfcTpHdrCd());		
		this.hashColumns.put("mnr_pln_hdr_seq", getMnrPlnHdrSeq());		
		this.hashColumns.put("mnr_pln_grp_no", getMnrPlnGrpNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로	반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("p511511", "p511511");
		this.hashFields.put("mnr_pln_dtl_seq", "mnrPlnDtlSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("mnr_pln_flg", "mnrPlnFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p511551", "p511551");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_pln_seq", "mnrPlnSeq");
		this.hashFields.put("p511561", "p511561");
		this.hashFields.put("p511531", "p511531");
		this.hashFields.put("p511541", "p511541");
		this.hashFields.put("p511521", "p511521");
		this.hashFields.put("mnr_pln_yr", "mnrPlnYr");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("mnr_pln_ofc_hdr_cd", "mnrPlnOfcHdrCd");
		this.hashFields.put("ofc_tp_hdr_cd", "ofcTpHdrCd");
		this.hashFields.put("mnr_pln_hdr_seq", "mnrPlnHdrSeq");
		this.hashFields.put("mnr_pln_grp_no", "mnrPlnGrpNo");
		return this.hashFields;
	}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  office
	*/
	public void	setOffice(String	office ) {
		this.office =	office;
	}
 
	/**
	 * Column Info
	 * @return	office
	 */
	 public	String	getOffice() {
		 return	this.office;
	 } 
 	/**
	* Column Info
	* @param  p511511
	*/
	public void	setP511511(String	p511511 ) {
		this.p511511 =	p511511;
	}
 
	/**
	 * Column Info
	 * @return	p511511
	 */
	 public	String	getP511511() {
		 return	this.p511511;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnDtlSeq
	*/
	public void	setMnrPlnDtlSeq(String	mnrPlnDtlSeq ) {
		this.mnrPlnDtlSeq =	mnrPlnDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnDtlSeq
	 */
	 public	String	getMnrPlnDtlSeq() {
		 return	this.mnrPlnDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt(String	creDt ) {
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
	* @param  mnrPlnOfcCd
	*/
	public void	setMnrPlnOfcCd(String	mnrPlnOfcCd ) {
		this.mnrPlnOfcCd =	mnrPlnOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnOfcCd
	 */
	 public	String	getMnrPlnOfcCd() {
		 return	this.mnrPlnOfcCd;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnFlg
	*/
	public void	setMnrPlnFlg(String	mnrPlnFlg ) {
		this.mnrPlnFlg =	mnrPlnFlg;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnFlg
	 */
	 public	String	getMnrPlnFlg() {
		 return	this.mnrPlnFlg;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows(String	pagerows ) {
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
	* @param  p511551
	*/
	public void	setP511551(String	p511551 ) {
		this.p511551 =	p511551;
	}
 
	/**
	 * Column Info
	 * @return	p511551
	 */
	 public	String	getP511551() {
		 return	this.p511551;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag(String	ibflag ) {
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
	* @param  creUsrId
	*/
	public void	setCreUsrId(String	creUsrId ) {
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
	* @param  mnrPlnSeq
	*/
	public void	setMnrPlnSeq(String	mnrPlnSeq ) {
		this.mnrPlnSeq =	mnrPlnSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnSeq
	 */
	 public	String	getMnrPlnSeq() {
		 return	this.mnrPlnSeq;
	 } 
 	/**
	* Column Info
	* @param  p511561
	*/
	public void	setP511561(String	p511561 ) {
		this.p511561 =	p511561;
	}
 
	/**
	 * Column Info
	 * @return	p511561
	 */
	 public	String	getP511561() {
		 return	this.p511561;
	 } 
 	/**
	* Column Info
	* @param  p511531
	*/
	public void	setP511531(String	p511531 ) {
		this.p511531 =	p511531;
	}
 
	/**
	 * Column Info
	 * @return	p511531
	 */
	 public	String	getP511531() {
		 return	this.p511531;
	 } 
 	/**
	* Column Info
	* @param  p511541
	*/
	public void	setP511541(String	p511541 ) {
		this.p511541 =	p511541;
	}
 
	/**
	 * Column Info
	 * @return	p511541
	 */
	 public	String	getP511541() {
		 return	this.p511541;
	 } 
 	/**
	* Column Info
	* @param  p511521
	*/
	public void	setP511521(String	p511521 ) {
		this.p511521 =	p511521;
	}
 
	/**
	 * Column Info
	 * @return	p511521
	 */
	 public	String	getP511521() {
		 return	this.p511521;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnYr
	*/
	public void	setMnrPlnYr(String	mnrPlnYr ) {
		this.mnrPlnYr =	mnrPlnYr;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnYr
	 */
	 public	String	getMnrPlnYr() {
		 return	this.mnrPlnYr;
	 } 
 	/**
	* Column Info
	* @param  ofcTpCd
	*/
	public void	setOfcTpCd(String	ofcTpCd ) {
		this.ofcTpCd =	ofcTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcTpCd
	 */
	 public	String	getOfcTpCd() {
		 return	this.ofcTpCd;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnOfcHdrCd
	*/
	public void	setMnrPlnOfcHdrCd(String	mnrPlnOfcHdrCd ) {
		this.mnrPlnOfcHdrCd =	mnrPlnOfcHdrCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnOfcHdrCd
	 */
	 public	String	getMnrPlnOfcHdrCd() {
		 return	this.mnrPlnOfcHdrCd;
	 } 
 	/**
	* Column Info
	* @param  ofcTpHdrCd
	*/
	public void	setOfcTpHdrCd(String	ofcTpHdrCd ) {
		this.ofcTpHdrCd =	ofcTpHdrCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcTpHdrCd
	 */
	 public	String	getOfcTpHdrCd() {
		 return	this.ofcTpHdrCd;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnHdrSeq
	*/
	public void	setMnrPlnHdrSeq(String	mnrPlnHdrSeq ) {
		this.mnrPlnHdrSeq =	mnrPlnHdrSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnHdrSeq
	 */
	 public	String	getMnrPlnHdrSeq() {
		 return	this.mnrPlnHdrSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrPlnGrpNo
	*/
	public void	setMnrPlnGrpNo(String	mnrPlnGrpNo ) {
		this.mnrPlnGrpNo =	mnrPlnGrpNo;
	}
 
	/**
	 * Column Info
	 * @return	mnrPlnGrpNo
	 */
	 public	String	getMnrPlnGrpNo() {
		 return	this.mnrPlnGrpNo;
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
		setOffice(JSPUtil.getParameter(request,	prefix + "office", ""));
		setP511511(JSPUtil.getParameter(request,	prefix + "p511511", ""));
		setMnrPlnDtlSeq(JSPUtil.getParameter(request,	prefix + "mnr_pln_dtl_seq", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request,	prefix + "mnr_pln_ofc_cd", ""));
		setMnrPlnFlg(JSPUtil.getParameter(request,	prefix + "mnr_pln_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setP511551(JSPUtil.getParameter(request,	prefix + "p511551", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setMnrPlnSeq(JSPUtil.getParameter(request,	prefix + "mnr_pln_seq", ""));
		setP511561(JSPUtil.getParameter(request,	prefix + "p511561", ""));
		setP511531(JSPUtil.getParameter(request,	prefix + "p511531", ""));
		setP511541(JSPUtil.getParameter(request,	prefix + "p511541", ""));
		setP511521(JSPUtil.getParameter(request,	prefix + "p511521", ""));
		setMnrPlnYr(JSPUtil.getParameter(request,	prefix + "mnr_pln_yr", ""));
		setOfcTpCd(JSPUtil.getParameter(request,	prefix + "ofc_tp_cd", ""));
		setMnrPlnOfcHdrCd(JSPUtil.getParameter(request,	prefix + "mnr_pln_ofc_hdr_cd", ""));
		setOfcTpHdrCd(JSPUtil.getParameter(request,	prefix + "ofc_tp_hdr_cd", ""));
		setMnrPlnHdrSeq(JSPUtil.getParameter(request,	prefix + "mnr_pln_hdr_seq", ""));
		setMnrPlnGrpNo(JSPUtil.getParameter(request,	prefix + "mnr_pln_grp_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Screen0112VO[]
	 */
	public Screen0112VO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Screen0112VO[]
	 */
	public Screen0112VO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		Screen0112VO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] office =	(JSPUtil.getParameter(request, prefix +	"office".trim(),	length));
				String[] p511511 =	(JSPUtil.getParameter(request, prefix +	"p511511".trim(),	length));
				String[] mnrPlnDtlSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_dtl_seq".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] mnrPlnOfcCd =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_ofc_cd".trim(),	length));
				String[] mnrPlnFlg =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] p511551 =	(JSPUtil.getParameter(request, prefix +	"p511551".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] mnrPlnSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_seq".trim(),	length));
				String[] p511561 =	(JSPUtil.getParameter(request, prefix +	"p511561".trim(),	length));
				String[] p511531 =	(JSPUtil.getParameter(request, prefix +	"p511531".trim(),	length));
				String[] p511541 =	(JSPUtil.getParameter(request, prefix +	"p511541".trim(),	length));
				String[] p511521 =	(JSPUtil.getParameter(request, prefix +	"p511521".trim(),	length));
				String[] mnrPlnYr =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_yr".trim(),	length));
				String[] ofcTpCd =	(JSPUtil.getParameter(request, prefix +	"ofc_tp_cd".trim(),	length));
				String[] mnrPlnOfcHdrCd =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_ofc_hdr_cd".trim(),	length));
				String[] ofcTpHdrCd =	(JSPUtil.getParameter(request, prefix +	"ofc_tp_hdr_cd".trim(),	length));
				String[] mnrPlnHdrSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_hdr_seq".trim(),	length));
				String[] mnrPlnGrpNo =	(JSPUtil.getParameter(request, prefix +	"mnr_pln_grp_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	Screen0112VO();
						if ( office[i] !=	null)
						model.setOffice( office[i]);
						if ( p511511[i] !=	null)
						model.setP511511( p511511[i]);
						if ( mnrPlnDtlSeq[i] !=	null)
						model.setMnrPlnDtlSeq( mnrPlnDtlSeq[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( mnrPlnOfcCd[i] !=	null)
						model.setMnrPlnOfcCd( mnrPlnOfcCd[i]);
						if ( mnrPlnFlg[i] !=	null)
						model.setMnrPlnFlg( mnrPlnFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( p511551[i] !=	null)
						model.setP511551( p511551[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( mnrPlnSeq[i] !=	null)
						model.setMnrPlnSeq( mnrPlnSeq[i]);
						if ( p511561[i] !=	null)
						model.setP511561( p511561[i]);
						if ( p511531[i] !=	null)
						model.setP511531( p511531[i]);
						if ( p511541[i] !=	null)
						model.setP511541( p511541[i]);
						if ( p511521[i] !=	null)
						model.setP511521( p511521[i]);
						if ( mnrPlnYr[i] !=	null)
						model.setMnrPlnYr( mnrPlnYr[i]);
						if ( ofcTpCd[i] !=	null)
						model.setOfcTpCd( ofcTpCd[i]);
						if ( mnrPlnOfcHdrCd[i] !=	null)
						model.setMnrPlnOfcHdrCd( mnrPlnOfcHdrCd[i]);
						if ( ofcTpHdrCd[i] !=	null)
						model.setOfcTpHdrCd( ofcTpHdrCd[i]);
						if ( mnrPlnHdrSeq[i] !=	null)
						model.setMnrPlnHdrSeq( mnrPlnHdrSeq[i]);
						if ( mnrPlnGrpNo[i] !=	null)
						model.setMnrPlnGrpNo( mnrPlnGrpNo[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getScreen0112VOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return Screen0112VO[]
	 */
	public Screen0112VO[]	getScreen0112VOs(){
		Screen0112VO[] vos = (Screen0112VO[])models.toArray(new	Screen0112VO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}

	/**
	 * getField 에서 catch문에 대한 로직
	 * 
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.office =	this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511511 =	this.p511511.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnDtlSeq =	this.mnrPlnDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd =	this.mnrPlnOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnFlg =	this.mnrPlnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511551 =	this.p511551.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnSeq =	this.mnrPlnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511561 =	this.p511561.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511531 =	this.p511531.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511541 =	this.p511541.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p511521 =	this.p511521.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnYr =	this.mnrPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd =	this.ofcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcHdrCd =	this.mnrPlnOfcHdrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpHdrCd =	this.ofcTpHdrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnHdrSeq =	this.mnrPlnHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnGrpNo =	this.mnrPlnGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}
