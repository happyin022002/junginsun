/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DisposalCandidateFlagINVO.java
 *@FileTitle : DisposalCandidateFlagINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.03  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo;

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
public class DisposalCandidateFlagINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DisposalCandidateFlagINVO>  models =	new	ArrayList<DisposalCandidateFlagINVO>();


	/*	Column Info	*/
	private  String	 selectCd   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 fryear   =  null;
	/*	Column Info	*/
	private  String	 fGubuns   =  null;
	/*	Column Info	*/
	private  String	 mnrDispTrfTpCd   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 tocal   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rqstEqNo   =  null;
	/*	Column Info	*/
	private  String	 toyear   =  null;
	/*	Column Info	*/
	private  String	 locationCd   =  null;
	/*	Column Info	*/
	private  String	 fromcal   =  null;
	/*	Column Info	*/
	private  String	 ruLableType   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLbl   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public DisposalCandidateFlagINVO(){}

	public DisposalCandidateFlagINVO(String selectCd,String costOfcCd,String fryear,String fGubuns,String mnrDispTrfTpCd,String eqKndCd,String pagerows,String eqTpszCd,String tocal,String ibflag,String rqstEqNo,String toyear,String locationCd,String fromcal,String ruLableType,String rstrUsgLbl)	{
		this.selectCd  = selectCd ;
		this.costOfcCd  = costOfcCd ;
		this.fryear  = fryear ;
		this.fGubuns  = fGubuns ;
		this.mnrDispTrfTpCd  = mnrDispTrfTpCd ;
		this.eqKndCd  = eqKndCd ;
		this.pagerows  = pagerows ;
		this.eqTpszCd  = eqTpszCd ;
		this.tocal  = tocal ;
		this.ibflag  = ibflag ;
		this.rqstEqNo  = rqstEqNo ;
		this.toyear  = toyear ;
		this.locationCd  = locationCd ;
		this.fromcal  = fromcal ;
		this.ruLableType  = ruLableType ;
		this.rstrUsgLbl  = rstrUsgLbl ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("select_cd", getSelectCd());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("fryear", getFryear());		
		this.hashColumns.put("f_gubuns", getFGubuns());		
		this.hashColumns.put("mnr_disp_trf_tp_cd", getMnrDispTrfTpCd());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("tocal", getTocal());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());		
		this.hashColumns.put("toyear", getToyear());		
		this.hashColumns.put("location_cd", getLocationCd());		
		this.hashColumns.put("fromcal", getFromcal());		
		this.hashColumns.put("ru_lable_type", getRuLableType());		
		this.hashColumns.put("rstr_usg_lbl", getRstrUsgLbl());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("select_cd", "selectCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("fryear", "fryear");
		this.hashFields.put("f_gubuns", "fGubuns");
		this.hashFields.put("mnr_disp_trf_tp_cd", "mnrDispTrfTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("tocal", "tocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("toyear", "toyear");
		this.hashFields.put("location_cd", "locationCd");
		this.hashFields.put("fromcal", "fromcal");
		this.hashFields.put("ru_lable_type", "ruLableType");
		this.hashFields.put("rstr_usg_lbl", "rstrUsgLbl");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  selectCd
	*/
	public void	setSelectCd( String	selectCd ) {
		this.selectCd =	selectCd;
	}
 
	/**
	 * Column Info
	 * @return	selectCd
	 */
	 public	 String	getSelectCd() {
		 return	this.selectCd;
	 } 
 	/**
	* Column Info
	* @param  costOfcCd
	*/
	public void	setCostOfcCd( String	costOfcCd ) {
		this.costOfcCd =	costOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	costOfcCd
	 */
	 public	 String	getCostOfcCd() {
		 return	this.costOfcCd;
	 } 
 	/**
	* Column Info
	* @param  fryear
	*/
	public void	setFryear( String	fryear ) {
		this.fryear =	fryear;
	}
 
	/**
	 * Column Info
	 * @return	fryear
	 */
	 public	 String	getFryear() {
		 return	this.fryear;
	 } 
 	/**
	* Column Info
	* @param  fGubuns
	*/
	public void	setFGubuns( String	fGubuns ) {
		this.fGubuns =	fGubuns;
	}
 
	/**
	 * Column Info
	 * @return	fGubuns
	 */
	 public	 String	getFGubuns() {
		 return	this.fGubuns;
	 } 
 	/**
	* Column Info
	* @param  mnrDispTrfTpCd
	*/
	public void	setMnrDispTrfTpCd( String	mnrDispTrfTpCd ) {
		this.mnrDispTrfTpCd =	mnrDispTrfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrDispTrfTpCd
	 */
	 public	 String	getMnrDispTrfTpCd() {
		 return	this.mnrDispTrfTpCd;
	 } 
 	/**
	* Column Info
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
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
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
	 } 
 	/**
	* Column Info
	* @param  tocal
	*/
	public void	setTocal( String	tocal ) {
		this.tocal =	tocal;
	}
 
	/**
	 * Column Info
	 * @return	tocal
	 */
	 public	 String	getTocal() {
		 return	this.tocal;
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
	* @param  rqstEqNo
	*/
	public void	setRqstEqNo( String	rqstEqNo ) {
		this.rqstEqNo =	rqstEqNo;
	}
 
	/**
	 * Column Info
	 * @return	rqstEqNo
	 */
	 public	 String	getRqstEqNo() {
		 return	this.rqstEqNo;
	 } 
 	/**
	* Column Info
	* @param  toyear
	*/
	public void	setToyear( String	toyear ) {
		this.toyear =	toyear;
	}
 
	/**
	 * Column Info
	 * @return	toyear
	 */
	 public	 String	getToyear() {
		 return	this.toyear;
	 } 
 	/**
	* Column Info
	* @param  locationCd
	*/
	public void	setLocationCd( String	locationCd ) {
		this.locationCd =	locationCd;
	}
 
	/**
	 * Column Info
	 * @return	locationCd
	 */
	 public	 String	getLocationCd() {
		 return	this.locationCd;
	 } 
 	/**
	* Column Info
	* @param  fromcal
	*/
	public void	setFromcal( String	fromcal ) {
		this.fromcal =	fromcal;
	}
 
	/**
	 * Column Info
	 * @return	fromcal
	 */
	 public	 String	getFromcal() {
		 return	this.fromcal;
	 } 
 	/**
	* Column Info
	* @param  ruLableType
	*/
	public void	setRuLableType( String	ruLableType ) {
		this.ruLableType =	ruLableType;
	}
 
	/**
	 * Column Info
	 * @return	ruLableType
	 */
	 public	 String	getRuLableType() {
		 return	this.ruLableType;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLbl
	*/
	public void	setRstrUsgLbl( String	rstrUsgLbl ) {
		this.rstrUsgLbl =	rstrUsgLbl;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLbl
	 */
	 public	 String	getRstrUsgLbl() {
		 return	this.rstrUsgLbl;
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
		setSelectCd(JSPUtil.getParameter(request,	prefix + "select_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setFryear(JSPUtil.getParameter(request,	prefix + "fryear", ""));
		setFGubuns(JSPUtil.getParameter(request,	prefix + "f_gubuns", ""));
		setMnrDispTrfTpCd(JSPUtil.getParameter(request,	prefix + "mnr_disp_trf_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setTocal(JSPUtil.getParameter(request,	prefix + "tocal", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRqstEqNo(JSPUtil.getParameter(request,	prefix + "rqst_eq_no", ""));
		setToyear(JSPUtil.getParameter(request,	prefix + "toyear", ""));
		setLocationCd(JSPUtil.getParameter(request,	prefix + "location_cd", ""));
		setFromcal(JSPUtil.getParameter(request,	prefix + "fromcal", ""));
		setRuLableType(JSPUtil.getParameter(request,	prefix + "ru_lable_type", ""));
		setRstrUsgLbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalCandidateFlagINVO[]
	 */
	public DisposalCandidateFlagINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalCandidateFlagINVO[]
	 */
	public DisposalCandidateFlagINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DisposalCandidateFlagINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] selectCd =	(JSPUtil.getParameter(request, prefix +	"select_cd".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] fryear =	(JSPUtil.getParameter(request, prefix +	"fryear".trim(),	length));
				String[] fGubuns =	(JSPUtil.getParameter(request, prefix +	"f_gubuns".trim(),	length));
				String[] mnrDispTrfTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_disp_trf_tp_cd".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] tocal =	(JSPUtil.getParameter(request, prefix +	"tocal".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rqstEqNo =	(JSPUtil.getParameter(request, prefix +	"rqst_eq_no".trim(),	length));
				String[] toyear =	(JSPUtil.getParameter(request, prefix +	"toyear".trim(),	length));
				String[] locationCd =	(JSPUtil.getParameter(request, prefix +	"location_cd".trim(),	length));
				String[] fromcal =	(JSPUtil.getParameter(request, prefix +	"fromcal".trim(),	length));
				String[] ruLableType =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
				String[] rstrUsgLbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	DisposalCandidateFlagINVO();
						if ( selectCd[i] !=	null)
						model.setSelectCd( selectCd[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( fryear[i] !=	null)
						model.setFryear( fryear[i]);
						if ( fGubuns[i] !=	null)
						model.setFGubuns( fGubuns[i]);
						if ( mnrDispTrfTpCd[i] !=	null)
						model.setMnrDispTrfTpCd( mnrDispTrfTpCd[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( tocal[i] !=	null)
						model.setTocal( tocal[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rqstEqNo[i] !=	null)
						model.setRqstEqNo( rqstEqNo[i]);
						if ( toyear[i] !=	null)
						model.setToyear( toyear[i]);
						if ( locationCd[i] !=	null)
						model.setLocationCd( locationCd[i]);
						if ( fromcal[i] !=	null)
						model.setFromcal( fromcal[i]);
						if ( ruLableType[i] !=	null)
						model.setRuLableType( ruLableType[i]);
						if ( rstrUsgLbl[i] !=	null)
						model.setRstrUsgLbl( rstrUsgLbl[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getDisposalCandidateFlagINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DisposalCandidateFlagINVO[]
	 */
	public DisposalCandidateFlagINVO[]	 getDisposalCandidateFlagINVOs(){
		DisposalCandidateFlagINVO[] vos = (DisposalCandidateFlagINVO[])models.toArray(new	DisposalCandidateFlagINVO[models.size()]);
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
		this.selectCd =	this.selectCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fryear =	this.fryear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubuns =	this.fGubuns.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTpCd =	this.mnrDispTrfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tocal =	this.tocal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo =	this.rqstEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toyear =	this.toyear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd =	this.locationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromcal =	this.fromcal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruLableType =	this.ruLableType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLbl =	this.rstrUsgLbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}