/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PCFRevExpnAmountVO.java
 *@FileTitle : PCFRevExpnAmountVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.06.21
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.06.21  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
public class PCFRevExpnAmountVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PCFRevExpnAmountVO>  models =	new	ArrayList<PCFRevExpnAmountVO>();


	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rePortSeq   =  null;
	/*	Column Info	*/
	private  String	 toEffDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt8   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt6   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt7   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt4   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt5   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt2   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt3   =  null;
	/*	Column Info	*/
	private  String	 pcfUtAmt1   =  null;
	/*	Column Info	*/
	private  String	 reDivrCd   =  null;
	/*	Column Info	*/
	private  String	 fmEffDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PCFRevExpnAmountVO(){}

	public PCFRevExpnAmountVO(String pagerows,String rePortSeq,String toEffDt,String ibflag,String currCd,String pcfUtAmt8,String updUsrId,String pcfUtAmt6,String pcfUtAmt7,String pcfUtAmt4,String pcfUtAmt5,String portCd,String pcfUtAmt2,String pcfUtAmt3,String pcfUtAmt1,String reDivrCd,String fmEffDt,String updDt,String creUsrId)	{
		this.pagerows  = pagerows ;
		this.rePortSeq  = rePortSeq ;
		this.toEffDt  = toEffDt ;
		this.ibflag  = ibflag ;
		this.currCd  = currCd ;
		this.pcfUtAmt8  = pcfUtAmt8 ;
		this.updUsrId  = updUsrId ;
		this.pcfUtAmt6  = pcfUtAmt6 ;
		this.pcfUtAmt7  = pcfUtAmt7 ;
		this.pcfUtAmt4  = pcfUtAmt4 ;
		this.pcfUtAmt5  = pcfUtAmt5 ;
		this.portCd  = portCd ;
		this.pcfUtAmt2  = pcfUtAmt2 ;
		this.pcfUtAmt3  = pcfUtAmt3 ;
		this.pcfUtAmt1  = pcfUtAmt1 ;
		this.reDivrCd  = reDivrCd ;
		this.fmEffDt  = fmEffDt ;
		this.updDt  = updDt ;
		this.creUsrId  = creUsrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("re_port_seq", getRePortSeq());		
		this.hashColumns.put("to_eff_dt", getToEffDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("pcf_ut_amt8", getPcfUtAmt8());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("pcf_ut_amt6", getPcfUtAmt6());		
		this.hashColumns.put("pcf_ut_amt7", getPcfUtAmt7());		
		this.hashColumns.put("pcf_ut_amt4", getPcfUtAmt4());		
		this.hashColumns.put("pcf_ut_amt5", getPcfUtAmt5());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("pcf_ut_amt2", getPcfUtAmt2());		
		this.hashColumns.put("pcf_ut_amt3", getPcfUtAmt3());		
		this.hashColumns.put("pcf_ut_amt1", getPcfUtAmt1());		
		this.hashColumns.put("re_divr_cd", getReDivrCd());		
		this.hashColumns.put("fm_eff_dt", getFmEffDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("re_port_seq", "rePortSeq");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pcf_ut_amt8", "pcfUtAmt8");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pcf_ut_amt6", "pcfUtAmt6");
		this.hashFields.put("pcf_ut_amt7", "pcfUtAmt7");
		this.hashFields.put("pcf_ut_amt4", "pcfUtAmt4");
		this.hashFields.put("pcf_ut_amt5", "pcfUtAmt5");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pcf_ut_amt2", "pcfUtAmt2");
		this.hashFields.put("pcf_ut_amt3", "pcfUtAmt3");
		this.hashFields.put("pcf_ut_amt1", "pcfUtAmt1");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
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
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  rePortSeq
	*/
	public void	setRePortSeq( String	rePortSeq ) {
		this.rePortSeq =	rePortSeq;
	}
 
	/**
	 * Column Info
	 * @return	rePortSeq
	 */
	 public	 String	getRePortSeq() {
		 return	this.rePortSeq;
	 } 
 	/**
	* Column Info
	* @param  toEffDt
	*/
	public void	setToEffDt( String	toEffDt ) {
		this.toEffDt =	toEffDt;
	}
 
	/**
	 * Column Info
	 * @return	toEffDt
	 */
	 public	 String	getToEffDt() {
		 return	this.toEffDt;
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
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt8
	*/
	public void	setPcfUtAmt8( String	pcfUtAmt8 ) {
		this.pcfUtAmt8 =	pcfUtAmt8;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt8
	 */
	 public	 String	getPcfUtAmt8() {
		 return	this.pcfUtAmt8;
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
	* @param  pcfUtAmt6
	*/
	public void	setPcfUtAmt6( String	pcfUtAmt6 ) {
		this.pcfUtAmt6 =	pcfUtAmt6;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt6
	 */
	 public	 String	getPcfUtAmt6() {
		 return	this.pcfUtAmt6;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt7
	*/
	public void	setPcfUtAmt7( String	pcfUtAmt7 ) {
		this.pcfUtAmt7 =	pcfUtAmt7;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt7
	 */
	 public	 String	getPcfUtAmt7() {
		 return	this.pcfUtAmt7;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt4
	*/
	public void	setPcfUtAmt4( String	pcfUtAmt4 ) {
		this.pcfUtAmt4 =	pcfUtAmt4;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt4
	 */
	 public	 String	getPcfUtAmt4() {
		 return	this.pcfUtAmt4;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt5
	*/
	public void	setPcfUtAmt5( String	pcfUtAmt5 ) {
		this.pcfUtAmt5 =	pcfUtAmt5;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt5
	 */
	 public	 String	getPcfUtAmt5() {
		 return	this.pcfUtAmt5;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt2
	*/
	public void	setPcfUtAmt2( String	pcfUtAmt2 ) {
		this.pcfUtAmt2 =	pcfUtAmt2;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt2
	 */
	 public	 String	getPcfUtAmt2() {
		 return	this.pcfUtAmt2;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt3
	*/
	public void	setPcfUtAmt3( String	pcfUtAmt3 ) {
		this.pcfUtAmt3 =	pcfUtAmt3;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt3
	 */
	 public	 String	getPcfUtAmt3() {
		 return	this.pcfUtAmt3;
	 } 
 	/**
	* Column Info
	* @param  pcfUtAmt1
	*/
	public void	setPcfUtAmt1( String	pcfUtAmt1 ) {
		this.pcfUtAmt1 =	pcfUtAmt1;
	}
 
	/**
	 * Column Info
	 * @return	pcfUtAmt1
	 */
	 public	 String	getPcfUtAmt1() {
		 return	this.pcfUtAmt1;
	 } 
 	/**
	* Column Info
	* @param  reDivrCd
	*/
	public void	setReDivrCd( String	reDivrCd ) {
		this.reDivrCd =	reDivrCd;
	}
 
	/**
	 * Column Info
	 * @return	reDivrCd
	 */
	 public	 String	getReDivrCd() {
		 return	this.reDivrCd;
	 } 
 	/**
	* Column Info
	* @param  fmEffDt
	*/
	public void	setFmEffDt( String	fmEffDt ) {
		this.fmEffDt =	fmEffDt;
	}
 
	/**
	 * Column Info
	 * @return	fmEffDt
	 */
	 public	 String	getFmEffDt() {
		 return	this.fmEffDt;
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
		setRePortSeq(JSPUtil.getParameter(request,	prefix + "re_port_seq", ""));
		setToEffDt(JSPUtil.getParameter(request,	prefix + "to_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPcfUtAmt8(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt8", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPcfUtAmt6(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt6", ""));
		setPcfUtAmt7(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt7", ""));
		setPcfUtAmt4(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt4", ""));
		setPcfUtAmt5(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt5", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setPcfUtAmt2(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt2", ""));
		setPcfUtAmt3(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt3", ""));
		setPcfUtAmt1(JSPUtil.getParameter(request,	prefix + "pcf_ut_amt1", ""));
		setReDivrCd(JSPUtil.getParameter(request,	prefix + "re_divr_cd", ""));
		setFmEffDt(JSPUtil.getParameter(request,	prefix + "fm_eff_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PCFRevExpnAmountVO[]
	 */
	public PCFRevExpnAmountVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PCFRevExpnAmountVO[]
	 */
	public PCFRevExpnAmountVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PCFRevExpnAmountVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rePortSeq =	(JSPUtil.getParameter(request, prefix +	"re_port_seq".trim(),	length));
				String[] toEffDt =	(JSPUtil.getParameter(request, prefix +	"to_eff_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] pcfUtAmt8 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt8".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] pcfUtAmt6 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt6".trim(),	length));
				String[] pcfUtAmt7 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt7".trim(),	length));
				String[] pcfUtAmt4 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt4".trim(),	length));
				String[] pcfUtAmt5 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt5".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] pcfUtAmt2 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt2".trim(),	length));
				String[] pcfUtAmt3 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt3".trim(),	length));
				String[] pcfUtAmt1 =	(JSPUtil.getParameter(request, prefix +	"pcf_ut_amt1".trim(),	length));
				String[] reDivrCd =	(JSPUtil.getParameter(request, prefix +	"re_divr_cd".trim(),	length));
				String[] fmEffDt =	(JSPUtil.getParameter(request, prefix +	"fm_eff_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PCFRevExpnAmountVO();
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rePortSeq[i] !=	null)
						model.setRePortSeq( rePortSeq[i]);
						if ( toEffDt[i] !=	null)
						model.setToEffDt( toEffDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( pcfUtAmt8[i] !=	null)
						model.setPcfUtAmt8( pcfUtAmt8[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( pcfUtAmt6[i] !=	null)
						model.setPcfUtAmt6( pcfUtAmt6[i]);
						if ( pcfUtAmt7[i] !=	null)
						model.setPcfUtAmt7( pcfUtAmt7[i]);
						if ( pcfUtAmt4[i] !=	null)
						model.setPcfUtAmt4( pcfUtAmt4[i]);
						if ( pcfUtAmt5[i] !=	null)
						model.setPcfUtAmt5( pcfUtAmt5[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( pcfUtAmt2[i] !=	null)
						model.setPcfUtAmt2( pcfUtAmt2[i]);
						if ( pcfUtAmt3[i] !=	null)
						model.setPcfUtAmt3( pcfUtAmt3[i]);
						if ( pcfUtAmt1[i] !=	null)
						model.setPcfUtAmt1( pcfUtAmt1[i]);
						if ( reDivrCd[i] !=	null)
						model.setReDivrCd( reDivrCd[i]);
						if ( fmEffDt[i] !=	null)
						model.setFmEffDt( fmEffDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPCFRevExpnAmountVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PCFRevExpnAmountVO[]
	 */
	public PCFRevExpnAmountVO[]	 getPCFRevExpnAmountVOs(){
		PCFRevExpnAmountVO[] vos = (PCFRevExpnAmountVO[])models.toArray(new	PCFRevExpnAmountVO[models.size()]);
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
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rePortSeq =	this.rePortSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt =	this.toEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt8 =	this.pcfUtAmt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt6 =	this.pcfUtAmt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt7 =	this.pcfUtAmt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt4 =	this.pcfUtAmt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt5 =	this.pcfUtAmt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt2 =	this.pcfUtAmt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt3 =	this.pcfUtAmt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcfUtAmt1 =	this.pcfUtAmt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd =	this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt =	this.fmEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}