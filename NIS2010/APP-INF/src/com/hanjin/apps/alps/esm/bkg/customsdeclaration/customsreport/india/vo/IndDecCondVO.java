/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndDecCondVO.java
*@FileTitle : IndDecCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndDecCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndDecCondVO> models = new ArrayList<IndDecCondVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String fromDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exportVvd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String terminalVal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndDecCondVO() {}

	public IndDecCondVO(String ibflag, String pagerows, String fromDt, String toDt, String exportVvd, String pol, String terminalVal) {
		this.toDt = toDt;
		this.fromDt = fromDt;
		this.ibflag = ibflag;
		this.exportVvd = exportVvd;
		this.pol = pol;
		this.terminalVal = terminalVal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("export_vvd", getExportVvd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("terminal_val", getTerminalVal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("export_vvd", "exportVvd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("terminal_val", "terminalVal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return exportVvd
	 */
	public String getExportVvd() {
		return this.exportVvd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return terminalVal
	 */
	public String getTerminalVal() {
		return this.terminalVal;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param exportVvd
	 */
	public void setExportVvd(String exportVvd) {
		this.exportVvd = exportVvd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param terminalVal
	 */
	public void setTerminalVal(String terminalVal) {
		this.terminalVal = terminalVal;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExportVvd(JSPUtil.getParameter(request, prefix + "export_vvd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setTerminalVal(JSPUtil.getParameter(request, prefix + "terminal_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndDecCondVO[]
	 */
	public IndDecCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndDecCondVO[]
	 */
	public IndDecCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndDecCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exportVvd = (JSPUtil.getParameter(request, prefix	+ "export_vvd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] terminalVal = (JSPUtil.getParameter(request, prefix	+ "terminal_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndDecCondVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exportVvd[i] != null)
					model.setExportVvd(exportVvd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (terminalVal[i] != null)
					model.setTerminalVal(terminalVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndDecCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndDecCondVO[]
	 */
	public IndDecCondVO[] getIndDecCondVOs(){
		IndDecCondVO[] vos = (IndDecCondVO[])models.toArray(new IndDecCondVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exportVvd = this.exportVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminalVal = this.terminalVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
