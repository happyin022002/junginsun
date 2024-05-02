/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SetupOfficeVO.java
*@FileTitle : SetupOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.01.07 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SetupOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SetupOfficeVO> models = new ArrayList<SetupOfficeVO>();
	
	/* Column Info */
	private String invMltBlIssFlg = null;
	/* Column Info */
	private String invIssTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDupFlg = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SetupOfficeVO() {}

	public SetupOfficeVO(String ibflag, String pagerows, String invMltBlIssFlg, String invDupFlg, String otsSmryCd, String invIssTpCd) {
		this.invMltBlIssFlg = invMltBlIssFlg;
		this.invIssTpCd = invIssTpCd;
		this.ibflag = ibflag;
		this.invDupFlg = invDupFlg;
		this.otsSmryCd = otsSmryCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());
		this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invMltBlIssFlg
	 */
	public String getInvMltBlIssFlg() {
		return this.invMltBlIssFlg;
	}
	
	/**
	 * Column Info
	 * @return invIssTpCd
	 */
	public String getInvIssTpCd() {
		return this.invIssTpCd;
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
	 * @return invDupFlg
	 */
	public String getInvDupFlg() {
		return this.invDupFlg;
	}
	
	/**
	 * Column Info
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
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
	 * @param invMltBlIssFlg
	 */
	public void setInvMltBlIssFlg(String invMltBlIssFlg) {
		this.invMltBlIssFlg = invMltBlIssFlg;
	}
	
	/**
	 * Column Info
	 * @param invIssTpCd
	 */
	public void setInvIssTpCd(String invIssTpCd) {
		this.invIssTpCd = invIssTpCd;
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
	 * @param invDupFlg
	 */
	public void setInvDupFlg(String invDupFlg) {
		this.invDupFlg = invDupFlg;
	}
	
	/**
	 * Column Info
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
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
		setInvMltBlIssFlg(JSPUtil.getParameter(request, prefix + "inv_mlt_bl_iss_flg", ""));
		setInvIssTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDupFlg(JSPUtil.getParameter(request, prefix + "inv_dup_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SetupOfficeVO[]
	 */
	public SetupOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SetupOfficeVO[]
	 */
	public SetupOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SetupOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invMltBlIssFlg = (JSPUtil.getParameter(request, prefix	+ "inv_mlt_bl_iss_flg", length));
			String[] invIssTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDupFlg = (JSPUtil.getParameter(request, prefix	+ "inv_dup_flg", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SetupOfficeVO();
				if (invMltBlIssFlg[i] != null)
					model.setInvMltBlIssFlg(invMltBlIssFlg[i]);
				if (invIssTpCd[i] != null)
					model.setInvIssTpCd(invIssTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDupFlg[i] != null)
					model.setInvDupFlg(invDupFlg[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSetupOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SetupOfficeVO[]
	 */
	public SetupOfficeVO[] getSetupOfficeVOs(){
		SetupOfficeVO[] vos = (SetupOfficeVO[])models.toArray(new SetupOfficeVO[models.size()]);
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
		this.invMltBlIssFlg = this.invMltBlIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTpCd = this.invIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg = this.invDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
