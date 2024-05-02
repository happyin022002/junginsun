/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorCllCrossChkCondVO.java
*@FileTitle : KorCllCrossChkCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.11.09 민정호 
* 1.0 Creation
* 
* 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllCrossChkCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCllCrossChkCondVO> models = new ArrayList<KorCllCrossChkCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dataCrossCheck = null;
	/* Column Info */
	private String dataType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCllCrossChkCondVO() {}

	public KorCllCrossChkCondVO(String ibflag, String pagerows, String vvd, String pol, String pod, String dataType, String dataCrossCheck) {
		this.vvd = vvd;
		this.dataCrossCheck = dataCrossCheck;
		this.dataType = dataType;
		this.ibflag = ibflag;
		this.pol = pol;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("data_cross_check", getDataCrossCheck());
		this.hashColumns.put("data_type", getDataType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("data_cross_check", "dataCrossCheck");
		this.hashFields.put("data_type", "dataType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return dataCrossCheck
	 */
	public String getDataCrossCheck() {
		return this.dataCrossCheck;
	}
	
	/**
	 * Column Info
	 * @return dataType
	 */
	public String getDataType() {
		return this.dataType;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param dataCrossCheck
	 */
	public void setDataCrossCheck(String dataCrossCheck) {
		this.dataCrossCheck = dataCrossCheck;
	}
	
	/**
	 * Column Info
	 * @param dataType
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDataCrossCheck(JSPUtil.getParameter(request, prefix + "data_cross_check", ""));
		setDataType(JSPUtil.getParameter(request, prefix + "data_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllCrossChkCondVO[]
	 */
	public KorCllCrossChkCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllCrossChkCondVO[]
	 */
	public KorCllCrossChkCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllCrossChkCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] dataCrossCheck = (JSPUtil.getParameter(request, prefix	+ "data_cross_check", length));
			String[] dataType = (JSPUtil.getParameter(request, prefix	+ "data_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCllCrossChkCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dataCrossCheck[i] != null)
					model.setDataCrossCheck(dataCrossCheck[i]);
				if (dataType[i] != null)
					model.setDataType(dataType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllCrossChkCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllCrossChkCondVO[]
	 */
	public KorCllCrossChkCondVO[] getKorCllCrossChkCondVOs(){
		KorCllCrossChkCondVO[] vos = (KorCllCrossChkCondVO[])models.toArray(new KorCllCrossChkCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataCrossCheck = this.dataCrossCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataType = this.dataType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
