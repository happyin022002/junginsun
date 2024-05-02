/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmSvcScpLmtVO.java
*@FileTitle : MdmSvcScpLmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.17 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmSvcScpLmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmSvcScpLmtVO> models = new ArrayList<MdmSvcScpLmtVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDestCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rgnNm = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmSvcScpLmtVO() {}

	public MdmSvcScpLmtVO(String ibflag, String pagerows, String svcScpCd, String orgDestCd, String deltFlg, String rgnCd, String rgnNm, String cd, String nm) {
		this.rgnCd = rgnCd;
		this.ibflag = ibflag;
		this.orgDestCd = orgDestCd;
		this.deltFlg = deltFlg;
		this.svcScpCd = svcScpCd;
		this.rgnNm = rgnNm;
		this.nm = nm;
		this.cd = cd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest_cd", getOrgDestCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest_cd", "orgDestCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
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
	 * @return orgDestCd
	 */
	public String getOrgDestCd() {
		return this.orgDestCd;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rgnNm
	 */
	public String getRgnNm() {
		return this.rgnNm;
	}
	
	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
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
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
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
	 * @param orgDestCd
	 */
	public void setOrgDestCd(String orgDestCd) {
		this.orgDestCd = orgDestCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rgnNm
	 */
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
	}
	
	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
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
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgDestCd(JSPUtil.getParameter(request, "org_dest_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRgnNm(JSPUtil.getParameter(request, "rgn_nm", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
		setCd(JSPUtil.getParameter(request, "cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmSvcScpLmtVO[]
	 */
	public MdmSvcScpLmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmSvcScpLmtVO[]
	 */
	public MdmSvcScpLmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmSvcScpLmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDestCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmSvcScpLmtVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDestCd[i] != null)
					model.setOrgDestCd(orgDestCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmSvcScpLmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmSvcScpLmtVO[]
	 */
	public MdmSvcScpLmtVO[] getMdmSvcScpLmtVOs(){
		MdmSvcScpLmtVO[] vos = (MdmSvcScpLmtVO[])models.toArray(new MdmSvcScpLmtVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCd = this.orgDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
