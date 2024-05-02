/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCuscarLocInfoVO.java
*@FileTitle : AusCuscarLocInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusCuscarLocInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusCuscarLocInfoVO> models = new ArrayList<AusCuscarLocInfoVO>();
	
	/* Column Info */
	private String locTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusCuscarLocInfoVO() {}

	public AusCuscarLocInfoVO(String ibflag, String pagerows, String locTp, String unLocCd, String locNm) {
		this.locTp = locTp;
		this.ibflag = ibflag;
		this.unLocCd = unLocCd;
		this.locNm = locNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
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
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
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
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusCuscarLocInfoVO[]
	 */
	public AusCuscarLocInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusCuscarLocInfoVO[]
	 */
	public AusCuscarLocInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusCuscarLocInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusCuscarLocInfoVO();
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusCuscarLocInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusCuscarLocInfoVO[]
	 */
	public AusCuscarLocInfoVO[] getAusCuscarLocInfoVOs(){
		AusCuscarLocInfoVO[] vos = (AusCuscarLocInfoVO[])models.toArray(new AusCuscarLocInfoVO[models.size()]);
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
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
