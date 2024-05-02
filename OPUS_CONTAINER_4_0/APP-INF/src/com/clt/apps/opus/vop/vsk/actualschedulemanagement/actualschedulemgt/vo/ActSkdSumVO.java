/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ActSkdSumVO.java
 *@FileTitle : ActSkdSumVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.24
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.24 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ActSkdSumVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ActSkdSumVO>  models =	new	ArrayList<ActSkdSumVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String ctrlOfc = null;
	/*	Column Info	*/
	private String inputtedCnt = null;
	/*	Column Info	*/
	private String targetLaneCnt = null;
	/*	Column Info	*/
	private String overdueRto = null;
	/*	Column Info	*/
	private String targetVvdCnt = null;
	/*	Column Info	*/
	private String portCd = null;
	/*	Column Info	*/
	private String inputRto = null;
	/*	Column Info	*/
	private String rhq = null;
	/*	Column Info	*/
	private String ttlPortCnt = null;
	/*	Column Info	*/
	private String overInputCnt = null;
	/*	Column Info	*/
	private String observanceRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public ActSkdSumVO(){}

	public ActSkdSumVO(String ibflag,String pagerows,String ctrlOfc,String inputtedCnt,String targetLaneCnt,String overdueRto,String targetVvdCnt,String portCd,String inputRto,String rhq,String ttlPortCnt,String overInputCnt,String observanceRto)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.ctrlOfc = ctrlOfc;
		this.inputtedCnt = inputtedCnt;
		this.targetLaneCnt = targetLaneCnt;
		this.overdueRto = overdueRto;
		this.targetVvdCnt = targetVvdCnt;
		this.portCd = portCd;
		this.inputRto = inputRto;
		this.rhq = rhq;
		this.ttlPortCnt = ttlPortCnt;
		this.overInputCnt = overInputCnt;
		this.observanceRto = observanceRto;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrl_ofc", getCtrlOfc());
		this.hashColumns.put("inputted_cnt", getInputtedCnt());
		this.hashColumns.put("target_lane_cnt", getTargetLaneCnt());
		this.hashColumns.put("overdue_rto", getOverdueRto());
		this.hashColumns.put("target_vvd_cnt", getTargetVvdCnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("input_rto", getInputRto());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("ttl_port_cnt", getTtlPortCnt());
		this.hashColumns.put("over_input_cnt", getOverInputCnt());
		this.hashColumns.put("observance_rto", getObservanceRto());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrl_ofc", "ctrlOfc");
		this.hashFields.put("inputted_cnt", "inputtedCnt");
		this.hashFields.put("target_lane_cnt", "targetLaneCnt");
		this.hashFields.put("overdue_rto", "overdueRto");
		this.hashFields.put("target_vvd_cnt", "targetVvdCnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("input_rto", "inputRto");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ttl_port_cnt", "ttlPortCnt");
		this.hashFields.put("over_input_cnt", "overInputCnt");
		this.hashFields.put("observance_rto", "observanceRto");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return ctrlOfc
	 */
	public	String getCtrlOfc() {
		return	this.ctrlOfc;
	}

	/**
	 * Column Info
	 * @return inputtedCnt
	 */
	public	String getInputtedCnt() {
		return	this.inputtedCnt;
	}

	/**
	 * Column Info
	 * @return targetLaneCnt
	 */
	public	String getTargetLaneCnt() {
		return	this.targetLaneCnt;
	}

	/**
	 * Column Info
	 * @return overdueRto
	 */
	public	String getOverdueRto() {
		return	this.overdueRto;
	}

	/**
	 * Column Info
	 * @return targetVvdCnt
	 */
	public	String getTargetVvdCnt() {
		return	this.targetVvdCnt;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public	String getPortCd() {
		return	this.portCd;
	}

	/**
	 * Column Info
	 * @return inputRto
	 */
	public	String getInputRto() {
		return	this.inputRto;
	}

	/**
	 * Column Info
	 * @return rhq
	 */
	public	String getRhq() {
		return	this.rhq;
	}

	/**
	 * Column Info
	 * @return ttlPortCnt
	 */
	public	String getTtlPortCnt() {
		return	this.ttlPortCnt;
	}

	/**
	 * Column Info
	 * @return overInputCnt
	 */
	public	String getOverInputCnt() {
		return	this.overInputCnt;
	}

	/**
	 * Column Info
	 * @return observanceRto
	 */
	public	String getObservanceRto() {
		return	this.observanceRto;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  ctrlOfc
 	 */
	public void	setCtrlOfc(String ctrlOfc ) {
		this.ctrlOfc =	ctrlOfc;
	}
 	/**
	 * Column Info
	 * @param  inputtedCnt
 	 */
	public void	setInputtedCnt(String inputtedCnt ) {
		this.inputtedCnt =	inputtedCnt;
	}
 	/**
	 * Column Info
	 * @param  targetLaneCnt
 	 */
	public void	setTargetLaneCnt(String targetLaneCnt ) {
		this.targetLaneCnt =	targetLaneCnt;
	}
 	/**
	 * Column Info
	 * @param  overdueRto
 	 */
	public void	setOverdueRto(String overdueRto ) {
		this.overdueRto =	overdueRto;
	}
 	/**
	 * Column Info
	 * @param  targetVvdCnt
 	 */
	public void	setTargetVvdCnt(String targetVvdCnt ) {
		this.targetVvdCnt =	targetVvdCnt;
	}
 	/**
	 * Column Info
	 * @param  portCd
 	 */
	public void	setPortCd(String portCd ) {
		this.portCd =	portCd;
	}
 	/**
	 * Column Info
	 * @param  inputRto
 	 */
	public void	setInputRto(String inputRto ) {
		this.inputRto =	inputRto;
	}
 	/**
	 * Column Info
	 * @param  rhq
 	 */
	public void	setRhq(String rhq ) {
		this.rhq =	rhq;
	}
 	/**
	 * Column Info
	 * @param  ttlPortCnt
 	 */
	public void	setTtlPortCnt(String ttlPortCnt ) {
		this.ttlPortCnt =	ttlPortCnt;
	}
 	/**
	 * Column Info
	 * @param  overInputCnt
 	 */
	public void	setOverInputCnt(String overInputCnt ) {
		this.overInputCnt =	overInputCnt;
	}
 	/**
	 * Column Info
	 * @param  observanceRto
 	 */
	public void	setObservanceRto(String observanceRto ) {
		this.observanceRto =	observanceRto;
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
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCtrlOfc(JSPUtil.getParameter(request,	prefix + "ctrl_ofc", ""));
		setInputtedCnt(JSPUtil.getParameter(request,	prefix + "inputted_cnt", ""));
		setTargetLaneCnt(JSPUtil.getParameter(request,	prefix + "target_lane_cnt", ""));
		setOverdueRto(JSPUtil.getParameter(request,	prefix + "overdue_rto", ""));
		setTargetVvdCnt(JSPUtil.getParameter(request,	prefix + "target_vvd_cnt", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setInputRto(JSPUtil.getParameter(request,	prefix + "input_rto", ""));
		setRhq(JSPUtil.getParameter(request,	prefix + "rhq", ""));
		setTtlPortCnt(JSPUtil.getParameter(request,	prefix + "ttl_port_cnt", ""));
		setOverInputCnt(JSPUtil.getParameter(request,	prefix + "over_input_cnt", ""));
		setObservanceRto(JSPUtil.getParameter(request,	prefix + "observance_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ActSkdSumVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] ctrlOfc =	(JSPUtil.getParameter(request, prefix +	"ctrl_ofc",	length));
			String[] inputtedCnt =	(JSPUtil.getParameter(request, prefix +	"inputted_cnt",	length));
			String[] targetLaneCnt =	(JSPUtil.getParameter(request, prefix +	"target_lane_cnt",	length));
			String[] overdueRto =	(JSPUtil.getParameter(request, prefix +	"overdue_rto",	length));
			String[] targetVvdCnt =	(JSPUtil.getParameter(request, prefix +	"target_vvd_cnt",	length));
			String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd",	length));
			String[] inputRto =	(JSPUtil.getParameter(request, prefix +	"input_rto",	length));
			String[] rhq =	(JSPUtil.getParameter(request, prefix +	"rhq",	length));
			String[] ttlPortCnt =	(JSPUtil.getParameter(request, prefix +	"ttl_port_cnt",	length));
			String[] overInputCnt =	(JSPUtil.getParameter(request, prefix +	"over_input_cnt",	length));
			String[] observanceRto =	(JSPUtil.getParameter(request, prefix +	"observance_rto",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	ActSkdSumVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( ctrlOfc[i] !=	null)
					model.setCtrlOfc( ctrlOfc[i]);
				if ( inputtedCnt[i] !=	null)
					model.setInputtedCnt( inputtedCnt[i]);
				if ( targetLaneCnt[i] !=	null)
					model.setTargetLaneCnt( targetLaneCnt[i]);
				if ( overdueRto[i] !=	null)
					model.setOverdueRto( overdueRto[i]);
				if ( targetVvdCnt[i] !=	null)
					model.setTargetVvdCnt( targetVvdCnt[i]);
				if ( portCd[i] !=	null)
					model.setPortCd( portCd[i]);
				if ( inputRto[i] !=	null)
					model.setInputRto( inputRto[i]);
				if ( rhq[i] !=	null)
					model.setRhq( rhq[i]);
				if ( ttlPortCnt[i] !=	null)
					model.setTtlPortCnt( ttlPortCnt[i]);
				if ( overInputCnt[i] !=	null)
					model.setOverInputCnt( overInputCnt[i]);
				if ( observanceRto[i] !=	null)
					model.setObservanceRto( observanceRto[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getActSkdSumVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[]	 getActSkdSumVOs(){
		ActSkdSumVO[] vos = (ActSkdSumVO[])models.toArray(new	ActSkdSumVO[models.size()]);
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
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfc =	this.ctrlOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputtedCnt =	this.inputtedCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetLaneCnt =	this.targetLaneCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueRto =	this.overdueRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetVvdCnt =	this.targetVvdCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputRto =	this.inputRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq =	this.rhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPortCnt =	this.ttlPortCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overInputCnt =	this.overInputCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.observanceRto =	this.observanceRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}