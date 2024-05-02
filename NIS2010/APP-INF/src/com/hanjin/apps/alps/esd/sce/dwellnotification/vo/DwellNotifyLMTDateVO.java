/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwellNotifyLMTDateVO.java
*@FileTitle : DwellNotifyLMTDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.24
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.24 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DwellNotifyLMTDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DwellNotifyLMTDateVO> models = new ArrayList<DwellNotifyLMTDateVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltEmlSndDt = null;
	/* Column Info */
	private String dfltToSndDt = null;
	/* Column Info */
	private String dfltFmSndDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DwellNotifyLMTDateVO() {}

	public DwellNotifyLMTDateVO(String ibflag, String pagerows, String dfltEmlSndDt, String dfltFmSndDt, String dfltToSndDt) {
		this.ibflag = ibflag;
		this.dfltEmlSndDt = dfltEmlSndDt;
		this.dfltToSndDt = dfltToSndDt;
		this.dfltFmSndDt = dfltFmSndDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_eml_snd_dt", getDfltEmlSndDt());
		this.hashColumns.put("dflt_to_snd_dt", getDfltToSndDt());
		this.hashColumns.put("dflt_fm_snd_dt", getDfltFmSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_eml_snd_dt", "dfltEmlSndDt");
		this.hashFields.put("dflt_to_snd_dt", "dfltToSndDt");
		this.hashFields.put("dflt_fm_snd_dt", "dfltFmSndDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return dfltEmlSndDt
	 */
	public String getDfltEmlSndDt() {
		return this.dfltEmlSndDt;
	}
	
	/**
	 * Column Info
	 * @return dfltToSndDt
	 */
	public String getDfltToSndDt() {
		return this.dfltToSndDt;
	}
	
	/**
	 * Column Info
	 * @return dfltFmSndDt
	 */
	public String getDfltFmSndDt() {
		return this.dfltFmSndDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param dfltEmlSndDt
	 */
	public void setDfltEmlSndDt(String dfltEmlSndDt) {
		this.dfltEmlSndDt = dfltEmlSndDt;
	}
	
	/**
	 * Column Info
	 * @param dfltToSndDt
	 */
	public void setDfltToSndDt(String dfltToSndDt) {
		this.dfltToSndDt = dfltToSndDt;
	}
	
	/**
	 * Column Info
	 * @param dfltFmSndDt
	 */
	public void setDfltFmSndDt(String dfltFmSndDt) {
		this.dfltFmSndDt = dfltFmSndDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDfltEmlSndDt(JSPUtil.getParameter(request, prefix + "dflt_eml_snd_dt", ""));
		setDfltToSndDt(JSPUtil.getParameter(request, prefix + "dflt_to_snd_dt", ""));
		setDfltFmSndDt(JSPUtil.getParameter(request, prefix + "dflt_fm_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DwellNotifyLMTDateVO[]
	 */
	public DwellNotifyLMTDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DwellNotifyLMTDateVO[]
	 */
	public DwellNotifyLMTDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DwellNotifyLMTDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltEmlSndDt = (JSPUtil.getParameter(request, prefix	+ "dflt_eml_snd_dt", length));
			String[] dfltToSndDt = (JSPUtil.getParameter(request, prefix	+ "dflt_to_snd_dt", length));
			String[] dfltFmSndDt = (JSPUtil.getParameter(request, prefix	+ "dflt_fm_snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DwellNotifyLMTDateVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltEmlSndDt[i] != null)
					model.setDfltEmlSndDt(dfltEmlSndDt[i]);
				if (dfltToSndDt[i] != null)
					model.setDfltToSndDt(dfltToSndDt[i]);
				if (dfltFmSndDt[i] != null)
					model.setDfltFmSndDt(dfltFmSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDwellNotifyLMTDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DwellNotifyLMTDateVO[]
	 */
	public DwellNotifyLMTDateVO[] getDwellNotifyLMTDateVOs(){
		DwellNotifyLMTDateVO[] vos = (DwellNotifyLMTDateVO[])models.toArray(new DwellNotifyLMTDateVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltEmlSndDt = this.dfltEmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltToSndDt = this.dfltToSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltFmSndDt = this.dfltFmSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
