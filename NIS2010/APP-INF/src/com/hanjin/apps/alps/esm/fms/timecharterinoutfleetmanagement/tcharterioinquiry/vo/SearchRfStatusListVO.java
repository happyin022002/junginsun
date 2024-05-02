/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchRfStatusListVO.java
*@FileTitle : SearchRfStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.02 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRfStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRfStatusListVO> models = new ArrayList<SearchRfStatusListVO>();
	
	/* Column Info */
	private String rob = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String celltocell = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loadingport = null;
	/* Column Info */
	private String dischargingport = null;
	/* Column Info */
	private String loading = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String discharging = null;
	/* Column Info */
	private String kind = null;
	/* Column Info */
	private String operator = null;
	/* Column Info */
	private String indicator = null;
	/* Column Info */
	private String preplantype = null;
	/* Column Info */
	private String yard = null;	
	/* Column Info */
	private String vpsetadt = null;	
	/* Column Info */
	private String vpsetddt = null;	
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRfStatusListVO() {}

	public SearchRfStatusListVO(String ibflag, String pagerows, String port, String loading, String discharging, String celltocell, String rob, String loadingport, String dischargingport, String operator, String cntrno, String kind, String indicator, String yard, String preplantype, String vpsetadt, String vpsetddt) {
		this.rob = rob;
		this.port = port;
		this.celltocell = celltocell;
		this.ibflag = ibflag;
		this.loadingport = loadingport;
		this.dischargingport = dischargingport;
		this.loading = loading;
		this.cntrno = cntrno;
		this.discharging = discharging;
		this.kind = kind;
		this.operator = operator;
		this.indicator = indicator;
		this.yard = yard;
		this.preplantype = preplantype;
		this.vpsetadt = vpsetadt;
		this.vpsetddt = vpsetddt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rob", getRob());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("celltocell", getCelltocell());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loadingport", getLoadingport());
		this.hashColumns.put("dischargingport", getDischargingport());
		this.hashColumns.put("loading", getLoading());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("discharging", getDischarging());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("operator", getOperator());
		this.hashColumns.put("indicator", getIndicator());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("preplantype", getPreplantype());				
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vpsetadt", getVpsEtaDt());
		this.hashColumns.put("vpsetddt", getVpsEtdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rob", "rob");
		this.hashFields.put("port", "port");
		this.hashFields.put("celltocell", "celltocell");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loadingport", "loadingport");
		this.hashFields.put("dischargingport", "dischargingport");
		this.hashFields.put("loading", "loading");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("discharging", "discharging");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("operator", "operator");
		this.hashFields.put("indicator", "indicator");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("preplantype", "preplantype");		
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vpsetadt", "vpsetadt");
		this.hashFields.put("vpsetddt", "vpsetddt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rob
	 */
	public String getRob() {
		return this.rob;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return celltocell
	 */
	public String getCelltocell() {
		return this.celltocell;
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
	 * @return loadingport
	 */
	public String getLoadingport() {
		return this.loadingport;
	}
	
	/**
	 * Column Info
	 * @return dischargingport
	 */
	public String getDischargingport() {
		return this.dischargingport;
	}
	
	/**
	 * Column Info
	 * @return loading
	 */
	public String getLoading() {
		return this.loading;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return discharging
	 */
	public String getDischarging() {
		return this.discharging;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
	}
	
	/**
	 * Column Info
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
	}
	
	/**
	 * Column Info
	 * @return indicator
	 */
	public String getIndicator() {
		return this.indicator;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}	
	
	/**
	 * Column Info
	 * @return preplantype
	 */
	public String getPreplantype() {
		return this.preplantype;
	}		
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *Column Info
	 * @return vpsetadt
	 */
	public String getVpsEtaDt() {
		return this.vpsetadt;
	}
	
	
	/**
	 * Column Info
	 * @return vpsetddt
	 */
	public String getVpsEtdDt() {
		return this.vpsetddt;
	}
	
	
	/**
	 * Column Info
	 * @param rob
	 */
	public void setRob(String rob) {
		this.rob = rob;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param celltocell
	 */
	public void setCelltocell(String celltocell) {
		this.celltocell = celltocell;
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
	 * @param loadingport
	 */
	public void setLoadingport(String loadingport) {
		this.loadingport = loadingport;
	}
	
	/**
	 * Column Info
	 * @param dischargingport
	 */
	public void setDischargingport(String dischargingport) {
		this.dischargingport = dischargingport;
	}
	
	/**
	 * Column Info
	 * @param loading
	 */
	public void setLoading(String loading) {
		this.loading = loading;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param discharging
	 */
	public void setDischarging(String discharging) {
		this.discharging = discharging;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	/**
	 * Column Info
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * Column Info
	 * @param indicator
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
		
	/**
	 * Column Info
	 * @param preplantype
	 */
	public void setPreplantype(String preplantype) {
		this.preplantype = preplantype;
	}	
		
	/**
	 * Column Info
	 * @param vpsetadt
	 */
	public void setVpsEtaDt(String vpsetadt) {
		this.vpsetadt = vpsetadt;
	}

	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setVpsEtdDt(String vpsetddt) {
		this.vpsetddt = vpsetddt;
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
		setRob(JSPUtil.getParameter(request, prefix + "rob", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setCelltocell(JSPUtil.getParameter(request, prefix + "celltocell", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoadingport(JSPUtil.getParameter(request, prefix + "loadingport", ""));
		setDischargingport(JSPUtil.getParameter(request, prefix + "dischargingport", ""));
		setLoading(JSPUtil.getParameter(request, prefix + "loading", ""));
		setCntrno(JSPUtil.getParameter(request, prefix + "cntrno", ""));
		setDischarging(JSPUtil.getParameter(request, prefix + "discharging", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setOperator(JSPUtil.getParameter(request, prefix + "operator", ""));
		setIndicator(JSPUtil.getParameter(request, prefix + "indicator", ""));		
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setPreplantype(JSPUtil.getParameter(request, prefix + "preplantype", ""));				
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vpsetadt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vpsetddt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRfStatusListVO[]
	 */
	public SearchRfStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRfStatusListVO[]
	 */
	public SearchRfStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRfStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rob = (JSPUtil.getParameter(request, prefix	+ "rob", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] celltocell = (JSPUtil.getParameter(request, prefix	+ "celltocell", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loadingport = (JSPUtil.getParameter(request, prefix	+ "loadingport", length));
			String[] dischargingport = (JSPUtil.getParameter(request, prefix	+ "dischargingport", length));
			String[] loading = (JSPUtil.getParameter(request, prefix	+ "loading", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] discharging = (JSPUtil.getParameter(request, prefix	+ "discharging", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] operator = (JSPUtil.getParameter(request, prefix	+ "operator", length));
			String[] indicator = (JSPUtil.getParameter(request, prefix	+ "indicator", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] preplantype = (JSPUtil.getParameter(request, prefix	+ "preplantype", length));	
			String[] vpsetadt = (JSPUtil.getParameter(request, prefix	+ "vpsetadt", length));	
			String[] vpsetddt = (JSPUtil.getParameter(request, prefix	+ "vpsetddt", length));	
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRfStatusListVO();
				if (rob[i] != null)
					model.setRob(rob[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (celltocell[i] != null)
					model.setCelltocell(celltocell[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loadingport[i] != null)
					model.setLoadingport(loadingport[i]);
				if (dischargingport[i] != null)
					model.setDischargingport(dischargingport[i]);
				if (loading[i] != null)
					model.setLoading(loading[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (discharging[i] != null)
					model.setDischarging(discharging[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (operator[i] != null)
					model.setOperator(operator[i]);
				if (indicator[i] != null)
					model.setIndicator(indicator[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (preplantype[i] != null)
					model.setPreplantype(preplantype[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsetadt[i] != null)
					model.setVpsEtaDt(vpsetadt[i]);	
				if (vpsetddt[i] != null)
					model.setVpsEtdDt(vpsetddt[i]);		
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRfStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRfStatusListVO[]
	 */
	public SearchRfStatusListVO[] getSearchRfStatusListVOs(){
		SearchRfStatusListVO[] vos = (SearchRfStatusListVO[])models.toArray(new SearchRfStatusListVO[models.size()]);
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
		this.rob = this.rob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.celltocell = this.celltocell .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadingport = this.loadingport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dischargingport = this.dischargingport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loading = this.loading .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discharging = this.discharging .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator = this.operator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indicator = this.indicator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preplantype = this.preplantype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsetadt = this.vpsetadt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsetddt = this.vpsetddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
