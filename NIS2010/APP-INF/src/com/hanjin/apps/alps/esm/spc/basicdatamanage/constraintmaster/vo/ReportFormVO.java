/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReportFormVO.java
*@FileTitle : ReportFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportFormVO> models = new ArrayList<ReportFormVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpNm = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fRptFomDesc = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rptFomDesc = null;
	/* Column Info */
	private String rptfomnm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pgm = null;
	/* Column Info */
	private String rptFomNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rptFomNo = null;
	
	private String header     		    = null;
	private String headerNM     		= null;   

	/* event Name */
	private String eventName     		= null;
	
	/* event Name */
	private String shtFlag     		= null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReportFormVO() {}

	public ReportFormVO(String ibflag, String pagerows, String pgmNo, String creUsrId, String rptFomNo, String rptFomNm, String rptFomDesc, String dpSeq, String deltFlg, String creDt, String updUsrId, String updDt, String colNm, String dpNm, String pgm, String rptfomnm, String fRptFomDesc) {
		this.dpSeq = dpSeq;
		this.updDt = updDt;
		this.dpNm = dpNm;
		this.colNm = colNm;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.fRptFomDesc = fRptFomDesc;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.rptFomDesc = rptFomDesc;
		this.rptfomnm = rptfomnm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.pgm = pgm;
		this.rptFomNm = rptFomNm;
		this.updUsrId = updUsrId;
		this.rptFomNo = rptFomNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_nm", getDpNm());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("f_rpt_fom_desc", getFRptFomDesc());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpt_fom_desc", getRptFomDesc());
		this.hashColumns.put("rptfomnm", getRptfomnm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pgm", getPgm());
		this.hashColumns.put("rpt_fom_nm", getRptFomNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpt_fom_no", getRptFomNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_nm", "dpNm");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("f_rpt_fom_desc", "fRptFomDesc");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpt_fom_desc", "rptFomDesc");
		this.hashFields.put("rptfomnm", "rptfomnm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pgm", "pgm");
		this.hashFields.put("rpt_fom_nm", "rptFomNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpt_fom_no", "rptFomNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dpNm
	 */
	public String getDpNm() {
		return this.dpNm;
	}
	
	/**
	 * Column Info
	 * @return colNm
	 */
	public String getColNm() {
		return this.colNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return fRptFomDesc
	 */
	public String getFRptFomDesc() {
		return this.fRptFomDesc;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return rptFomDesc
	 */
	public String getRptFomDesc() {
		return this.rptFomDesc;
	}
	
	/**
	 * Column Info
	 * @return rptfomnm
	 */
	public String getRptfomnm() {
		return this.rptfomnm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return pgm
	 */
	public String getPgm() {
		return this.pgm;
	}
	
	/**
	 * Column Info
	 * @return rptFomNm
	 */
	public String getRptFomNm() {
		return this.rptFomNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return rptFomNo
	 */
	public String getRptFomNo() {
		return this.rptFomNo;
	}
	

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dpNm
	 */
	public void setDpNm(String dpNm) {
		this.dpNm = dpNm;
	}
	
	/**
	 * Column Info
	 * @param colNm
	 */
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param fRptFomDesc
	 */
	public void setFRptFomDesc(String fRptFomDesc) {
		this.fRptFomDesc = fRptFomDesc;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param rptFomDesc
	 */
	public void setRptFomDesc(String rptFomDesc) {
		this.rptFomDesc = rptFomDesc;
	}
	
	/**
	 * Column Info
	 * @param rptfomnm
	 */
	public void setRptfomnm(String rptfomnm) {
		this.rptfomnm = rptfomnm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param pgm
	 */
	public void setPgm(String pgm) {
		this.pgm = pgm;
	}
	
	/**
	 * Column Info
	 * @param rptFomNm
	 */
	public void setRptFomNm(String rptFomNm) {
		this.rptFomNm = rptFomNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param rptFomNo
	 */
	public void setRptFomNo(String rptFomNo) {
		this.rptFomNo = rptFomNo;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	/**
	 * column info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}	
	/**
	 * column info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}	
	/**
	 * column info
	 * @param headerNM
	 */
	public void setHeaderNM(String headerNM) {
		this.headerNM = headerNM;
	}	
	/**
	 * column info
	 * @return headerNM
	 */
	public String getHeaderNM() {
		return this.headerNM;
	}
	
	/**
	 * event name
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}	
	/**
	 * event name
	 * @return eventName
	 */
	public String getEventName() {
		return this.eventName;
	}	
	
	public String getShtFlag() {
		return shtFlag;
	}

	public void setShtFlag(String shtFlag) {
		this.shtFlag = shtFlag;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDpNm(JSPUtil.getParameter(request, prefix + "dp_nm", ""));
		setColNm(JSPUtil.getParameter(request, prefix + "col_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFRptFomDesc(JSPUtil.getParameter(request, prefix + "f_rpt_fom_desc", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRptFomDesc(JSPUtil.getParameter(request, prefix + "rpt_fom_desc", ""));
		setRptfomnm(JSPUtil.getParameter(request, prefix + "rptfomnm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPgm(JSPUtil.getParameter(request, prefix + "pgm", ""));
		setRptFomNm(JSPUtil.getParameter(request, prefix + "rpt_fom_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRptFomNo(JSPUtil.getParameter(request, prefix + "rpt_fom_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportFormVO[]
	 */
	public ReportFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportFormVO[]
	 */
	public ReportFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpNm = (JSPUtil.getParameter(request, prefix	+ "dp_nm", length));
			String[] colNm = (JSPUtil.getParameter(request, prefix	+ "col_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fRptFomDesc = (JSPUtil.getParameter(request, prefix	+ "f_rpt_fom_desc", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rptFomDesc = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_desc", length));
			String[] rptfomnm = (JSPUtil.getParameter(request, prefix	+ "rptfomnm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pgm = (JSPUtil.getParameter(request, prefix	+ "pgm", length));
			String[] rptFomNm = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rptFomNo = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportFormVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpNm[i] != null)
					model.setDpNm(dpNm[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fRptFomDesc[i] != null)
					model.setFRptFomDesc(fRptFomDesc[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rptFomDesc[i] != null)
					model.setRptFomDesc(rptFomDesc[i]);
				if (rptfomnm[i] != null)
					model.setRptfomnm(rptfomnm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pgm[i] != null)
					model.setPgm(pgm[i]);
				if (rptFomNm[i] != null)
					model.setRptFomNm(rptFomNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rptFomNo[i] != null)
					model.setRptFomNo(rptFomNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportFormVO[]
	 */
	public ReportFormVO[] getReportFormVOs(){
		ReportFormVO[] vos = (ReportFormVO[])models.toArray(new ReportFormVO[models.size()]);
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
	public void unDataFormat(){
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpNm = this.dpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm = this.colNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRptFomDesc = this.fRptFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomDesc = this.rptFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptfomnm = this.rptfomnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgm = this.pgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomNm = this.rptFomNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomNo = this.rptFomNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	//추가6############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################  	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashIndirectColumns = new HashMap<String, String>();
	
	/*	Velocity 변수에  값을 저장하는 Hashtable */
	private HashMap<String, Object> hashIndirectVariables = new HashMap<String, Object>();	


	/**
	 * ColumnValues Info
	 * @return hashIndirectColumns
	 */
	public HashMap<String, String> getIndirectColumnValues() {
		return this.hashIndirectColumns;
	}
	/**
	 * ColumnValues Info
	 * @param hashIndirectColumns
	 */
	public void setIndirectColumnValues(HashMap<String, String> hMap) {
		this.hashIndirectColumns = hMap;
	}	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"condition_name", "value"> 로 반환
	 *  - 쿼리의 매개변수로 셋팅.
	 *  - 가변조회 조건에 대한 값.
	 * 
	 * @return Map
	 */			
	public Map<String, Object> getIndirectQueryParameter(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.putAll(getIndirectColumnValues());
		return param;
	}
	/**
	 * VariableValues Info
	 * @return hashIndirectVariables
	 */
	public HashMap<String, Object> getIndirectVariableValues() {
		return this.hashIndirectVariables;
	}
	/**
	 * VariableValues Info
	 * @param hashIndirectVariables
	 */
	public void setIndirectVariableValues(HashMap<String, Object> hMap) {
		this.hashIndirectVariables = hMap;
	}	
	/**
	 * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
	 *  - 쿼리의 매개변수로 셋팅.
	 *  - 가변조회 조건에 대한 값.
	 * 
	 * @return Map
	 */			
	public Map<String, Object> getIndirectVelocityParameter(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.putAll(getIndirectVariableValues());
		return param;
	}	
}
