/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RdApplCdFtpVO.java
*@FileTitle : RdApplCdFtpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.04  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RdApplCdFtpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RdApplCdFtpVO> models = new ArrayList<RdApplCdFtpVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdApplCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdSubSysCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RdApplCdFtpVO() {}

	public RdApplCdFtpVO(String ibflag, String pagerows, String rdApplCd, String rdSubSysCd) {
		this.pagerows = pagerows;
		this.rdApplCd = rdApplCd;
		this.ibflag = ibflag;
		this.rdSubSysCd = rdSubSysCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rd_appl_cd", getRdApplCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rd_sub_sys_cd", getRdSubSysCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rd_appl_cd", "rdApplCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rd_sub_sys_cd", "rdSubSysCd");
		return this.hashFields;
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
	 * @return rdApplCd
	 */
	public String getRdApplCd() {
		return this.rdApplCd;
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
	 * @return rdSubSysCd
	 */
	public String getRdSubSysCd() {
		return this.rdSubSysCd;
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
	 * @param rdApplCd
	 */
	public void setRdApplCd(String rdApplCd) {
		this.rdApplCd = rdApplCd;
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
	 * @param rdSubSysCd
	 */
	public void setRdSubSysCd(String rdSubSysCd) {
		this.rdSubSysCd = rdSubSysCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdApplCd(JSPUtil.getParameter(request, prefix + "rd_appl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRdSubSysCd(JSPUtil.getParameter(request, prefix + "rd_sub_sys_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RdApplCdFtpVO[]
	 */
	public RdApplCdFtpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RdApplCdFtpVO[]
	 */
	public RdApplCdFtpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RdApplCdFtpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdApplCd = (JSPUtil.getParameter(request, prefix	+ "rd_appl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rdSubSysCd = (JSPUtil.getParameter(request, prefix	+ "rd_sub_sys_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RdApplCdFtpVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdApplCd[i] != null)
					model.setRdApplCd(rdApplCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdSubSysCd[i] != null)
					model.setRdSubSysCd(rdSubSysCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRdApplCdFtpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RdApplCdFtpVO[]
	 */
	public RdApplCdFtpVO[] getRdApplCdFtpVOs(){
		RdApplCdFtpVO[] vos = (RdApplCdFtpVO[])models.toArray(new RdApplCdFtpVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdApplCd = this.rdApplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSubSysCd = this.rdSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
