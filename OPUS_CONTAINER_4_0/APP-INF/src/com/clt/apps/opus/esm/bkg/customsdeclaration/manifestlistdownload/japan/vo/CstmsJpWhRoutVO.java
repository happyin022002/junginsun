/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstmsJpWhRoutVO.java
*@FileTitle : CstmsJpWhRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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

public class CstmsJpWhRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsJpWhRoutVO> models = new ArrayList<CstmsJpWhRoutVO>();
	
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String cstmsCd2 = null;
	/* Column Info */
	private String cstmsCd1 = null;
	/* Column Info */
	private String orgTrspModCd = null;
	/* Column Info */
	private String orgAproNo = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String orgCstmsCd = null;
	/* Column Info */
	private String cstmsCd5 = null;
	/* Column Info */
	private String cstmsCd4 = null;
	/* Column Info */
	private String cstmsCd3 = null;
	/* Column Info */
	private String orgExpDt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String expDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsJpWhRoutVO() {}

	public CstmsJpWhRoutVO(String ibflag, String pagerows, String cstmsCd, String expDt, String aproNo, String trspModCd, String cstmsCd1, String cstmsCd2, String cstmsCd3, String cstmsCd4, String cstmsCd5, String orgCstmsCd, String orgExpDt, String orgAproNo, String orgTrspModCd, String usrId) {
		this.aproNo = aproNo;
		this.cstmsCd2 = cstmsCd2;
		this.cstmsCd1 = cstmsCd1;
		this.orgTrspModCd = orgTrspModCd;
		this.orgAproNo = orgAproNo;
		this.cstmsCd = cstmsCd;
		this.orgCstmsCd = orgCstmsCd;
		this.cstmsCd5 = cstmsCd5;
		this.cstmsCd4 = cstmsCd4;
		this.cstmsCd3 = cstmsCd3;
		this.orgExpDt = orgExpDt;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.expDt = expDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("cstms_cd2", getCstmsCd2());
		this.hashColumns.put("cstms_cd1", getCstmsCd1());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("org_apro_no", getOrgAproNo());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("org_cstms_cd", getOrgCstmsCd());
		this.hashColumns.put("cstms_cd5", getCstmsCd5());
		this.hashColumns.put("cstms_cd4", getCstmsCd4());
		this.hashColumns.put("cstms_cd3", getCstmsCd3());
		this.hashColumns.put("org_exp_dt", getOrgExpDt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("cstms_cd2", "cstmsCd2");
		this.hashFields.put("cstms_cd1", "cstmsCd1");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("org_apro_no", "orgAproNo");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("org_cstms_cd", "orgCstmsCd");
		this.hashFields.put("cstms_cd5", "cstmsCd5");
		this.hashFields.put("cstms_cd4", "cstmsCd4");
		this.hashFields.put("cstms_cd3", "cstmsCd3");
		this.hashFields.put("org_exp_dt", "orgExpDt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd2
	 */
	public String getCstmsCd2() {
		return this.cstmsCd2;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd1
	 */
	public String getCstmsCd1() {
		return this.cstmsCd1;
	}
	
	/**
	 * Column Info
	 * @return orgTrspModCd
	 */
	public String getOrgTrspModCd() {
		return this.orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return orgAproNo
	 */
	public String getOrgAproNo() {
		return this.orgAproNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return orgCstmsCd
	 */
	public String getOrgCstmsCd() {
		return this.orgCstmsCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd5
	 */
	public String getCstmsCd5() {
		return this.cstmsCd5;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd4
	 */
	public String getCstmsCd4() {
		return this.cstmsCd4;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd3
	 */
	public String getCstmsCd3() {
		return this.cstmsCd3;
	}
	
	/**
	 * Column Info
	 * @return orgExpDt
	 */
	public String getOrgExpDt() {
		return this.orgExpDt;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	

	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd2
	 */
	public void setCstmsCd2(String cstmsCd2) {
		this.cstmsCd2 = cstmsCd2;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd1
	 */
	public void setCstmsCd1(String cstmsCd1) {
		this.cstmsCd1 = cstmsCd1;
	}
	
	/**
	 * Column Info
	 * @param orgTrspModCd
	 */
	public void setOrgTrspModCd(String orgTrspModCd) {
		this.orgTrspModCd = orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param orgAproNo
	 */
	public void setOrgAproNo(String orgAproNo) {
		this.orgAproNo = orgAproNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param orgCstmsCd
	 */
	public void setOrgCstmsCd(String orgCstmsCd) {
		this.orgCstmsCd = orgCstmsCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd5
	 */
	public void setCstmsCd5(String cstmsCd5) {
		this.cstmsCd5 = cstmsCd5;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd4
	 */
	public void setCstmsCd4(String cstmsCd4) {
		this.cstmsCd4 = cstmsCd4;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd3
	 */
	public void setCstmsCd3(String cstmsCd3) {
		this.cstmsCd3 = cstmsCd3;
	}
	
	/**
	 * Column Info
	 * @param orgExpDt
	 */
	public void setOrgExpDt(String orgExpDt) {
		this.orgExpDt = orgExpDt;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setCstmsCd2(JSPUtil.getParameter(request, prefix + "cstms_cd2", ""));
		setCstmsCd1(JSPUtil.getParameter(request, prefix + "cstms_cd1", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", ""));
		setOrgAproNo(JSPUtil.getParameter(request, prefix + "org_apro_no", ""));
		setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
		setOrgCstmsCd(JSPUtil.getParameter(request, prefix + "org_cstms_cd", ""));
		setCstmsCd5(JSPUtil.getParameter(request, prefix + "cstms_cd5", ""));
		setCstmsCd4(JSPUtil.getParameter(request, prefix + "cstms_cd4", ""));
		setCstmsCd3(JSPUtil.getParameter(request, prefix + "cstms_cd3", ""));
		setOrgExpDt(JSPUtil.getParameter(request, prefix + "org_exp_dt", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsJpWhRoutVO[]
	 */
	public CstmsJpWhRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsJpWhRoutVO[]
	 */
	public CstmsJpWhRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsJpWhRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] cstmsCd2 = (JSPUtil.getParameter(request, prefix	+ "cstms_cd2", length));
			String[] cstmsCd1 = (JSPUtil.getParameter(request, prefix	+ "cstms_cd1", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] orgAproNo = (JSPUtil.getParameter(request, prefix	+ "org_apro_no", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] orgCstmsCd = (JSPUtil.getParameter(request, prefix	+ "org_cstms_cd", length));
			String[] cstmsCd5 = (JSPUtil.getParameter(request, prefix	+ "cstms_cd5", length));
			String[] cstmsCd4 = (JSPUtil.getParameter(request, prefix	+ "cstms_cd4", length));
			String[] cstmsCd3 = (JSPUtil.getParameter(request, prefix	+ "cstms_cd3", length));
			String[] orgExpDt = (JSPUtil.getParameter(request, prefix	+ "org_exp_dt", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsJpWhRoutVO();
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (cstmsCd2[i] != null)
					model.setCstmsCd2(cstmsCd2[i]);
				if (cstmsCd1[i] != null)
					model.setCstmsCd1(cstmsCd1[i]);
				if (orgTrspModCd[i] != null)
					model.setOrgTrspModCd(orgTrspModCd[i]);
				if (orgAproNo[i] != null)
					model.setOrgAproNo(orgAproNo[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (orgCstmsCd[i] != null)
					model.setOrgCstmsCd(orgCstmsCd[i]);
				if (cstmsCd5[i] != null)
					model.setCstmsCd5(cstmsCd5[i]);
				if (cstmsCd4[i] != null)
					model.setCstmsCd4(cstmsCd4[i]);
				if (cstmsCd3[i] != null)
					model.setCstmsCd3(cstmsCd3[i]);
				if (orgExpDt[i] != null)
					model.setOrgExpDt(orgExpDt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsJpWhRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsJpWhRoutVO[]
	 */
	public CstmsJpWhRoutVO[] getCstmsJpWhRoutVOs(){
		CstmsJpWhRoutVO[] vos = (CstmsJpWhRoutVO[])models.toArray(new CstmsJpWhRoutVO[models.size()]);
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
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd2 = this.cstmsCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd1 = this.cstmsCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAproNo = this.orgAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCstmsCd = this.orgCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd5 = this.cstmsCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd4 = this.cstmsCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd3 = this.cstmsCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgExpDt = this.orgExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
