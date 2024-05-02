/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitProCmDescInfoVO.java
*@FileTitle : SitProCmDescInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.13 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProCmDescInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProCmDescInfoVO> models = new ArrayList<SitProCmDescInfoVO>();
	
	/* Column Info */
	private String eqpickdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqrel = null;
	/* Column Info */
	private String localIpi = null;
	/* Column Info */
	private String cmdesc = null;
	/* Column Info */
	private String eqrtn = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProCmDescInfoVO() {}

	public SitProCmDescInfoVO(String ibflag, String pagerows, String cmdesc, String localIpi, String eqrel, String eqpickdt, String eqrtn) {
		this.eqpickdt = eqpickdt;
		this.ibflag = ibflag;
		this.eqrel = eqrel;
		this.localIpi = localIpi;
		this.cmdesc = cmdesc;
		this.eqrtn = eqrtn;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eqpickdt", getEqpickdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("local_ipi", getLocalIpi());
		this.hashColumns.put("cmdesc", getCmdesc());
		this.hashColumns.put("eqrtn", getEqrtn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eqpickdt", "eqpickdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("local_ipi", "localIpi");
		this.hashFields.put("cmdesc", "cmdesc");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqpickdt
	 */
	public String getEqpickdt() {
		return this.eqpickdt;
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
	 * @return eqrel
	 */
	public String getEqrel() {
		return this.eqrel;
	}
	
	/**
	 * Column Info
	 * @return localIpi
	 */
	public String getLocalIpi() {
		return this.localIpi;
	}
	
	/**
	 * Column Info
	 * @return cmdesc
	 */
	public String getCmdesc() {
		return this.cmdesc;
	}
	
	/**
	 * Column Info
	 * @return eqrtn
	 */
	public String getEqrtn() {
		return this.eqrtn;
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
	 * @param eqpickdt
	 */
	public void setEqpickdt(String eqpickdt) {
		this.eqpickdt = eqpickdt;
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
	 * @param eqrel
	 */
	public void setEqrel(String eqrel) {
		this.eqrel = eqrel;
	}
	
	/**
	 * Column Info
	 * @param localIpi
	 */
	public void setLocalIpi(String localIpi) {
		this.localIpi = localIpi;
	}
	
	/**
	 * Column Info
	 * @param cmdesc
	 */
	public void setCmdesc(String cmdesc) {
		this.cmdesc = cmdesc;
	}
	
	/**
	 * Column Info
	 * @param eqrtn
	 */
	public void setEqrtn(String eqrtn) {
		this.eqrtn = eqrtn;
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
		setEqpickdt(JSPUtil.getParameter(request, "eqpickdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqrel(JSPUtil.getParameter(request, "eqrel", ""));
		setLocalIpi(JSPUtil.getParameter(request, "local_ipi", ""));
		setCmdesc(JSPUtil.getParameter(request, "cmdesc", ""));
		setEqrtn(JSPUtil.getParameter(request, "eqrtn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProCmDescInfoVO[]
	 */
	public SitProCmDescInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProCmDescInfoVO[]
	 */
	public SitProCmDescInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProCmDescInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqpickdt = (JSPUtil.getParameter(request, prefix	+ "eqpickdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] localIpi = (JSPUtil.getParameter(request, prefix	+ "local_ipi", length));
			String[] cmdesc = (JSPUtil.getParameter(request, prefix	+ "cmdesc", length));
			String[] eqrtn = (JSPUtil.getParameter(request, prefix	+ "eqrtn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProCmDescInfoVO();
				if (eqpickdt[i] != null)
					model.setEqpickdt(eqpickdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqrel[i] != null)
					model.setEqrel(eqrel[i]);
				if (localIpi[i] != null)
					model.setLocalIpi(localIpi[i]);
				if (cmdesc[i] != null)
					model.setCmdesc(cmdesc[i]);
				if (eqrtn[i] != null)
					model.setEqrtn(eqrtn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProCmDescInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProCmDescInfoVO[]
	 */
	public SitProCmDescInfoVO[] getSitProCmDescInfoVOs(){
		SitProCmDescInfoVO[] vos = (SitProCmDescInfoVO[])models.toArray(new SitProCmDescInfoVO[models.size()]);
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
		this.eqpickdt = this.eqpickdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localIpi = this.localIpi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdesc = this.cmdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn = this.eqrtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
