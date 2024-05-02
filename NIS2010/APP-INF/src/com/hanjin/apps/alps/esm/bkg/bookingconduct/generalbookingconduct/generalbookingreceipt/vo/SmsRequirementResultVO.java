/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SmsRequirementResultVO.java
*@FileTitle : SmsRequirementResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.23  
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class SmsRequirementResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SmsRequirementResultVO> models = new ArrayList<SmsRequirementResultVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String cntrCnt = null;
	/* Page Number */
	private String polYd = null;
	/* Page Number */
	private String dcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SmsRequirementResultVO() {}

	public SmsRequirementResultVO(String ibflag, String pagerows, String vvd, String slanCd, String cntrCnt, String polYd, String dcFlg) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.pagerows = pagerows;
		this.cntrCnt = cntrCnt;
		this.polYd = polYd;
		this.dcFlg = dcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("pol_yd", getPolYd());
		this.hashColumns.put("dc_flg", getDcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("dc_flg", "dcFlg");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getCntrCnt() {
		return cntrCnt;
	}

	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}

	public String getPolYd() {
		return polYd;
	}

	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}

	public String getDcFlg() {
		return dcFlg;
	}

	public void setDcFlg(String dcFlg) {
		this.dcFlg = dcFlg;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setPolYd(JSPUtil.getParameter(request, prefix + "pol_yd", ""));
		setDcFlg(JSPUtil.getParameter(request, prefix + "dc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SmsRequirementResultVO[]
	 */
	public SmsRequirementResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SmsRequirementResultVO[]
	 */
	public SmsRequirementResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SmsRequirementResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] polYd = (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] dcFlg = (JSPUtil.getParameter(request, prefix	+ "dc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SmsRequirementResultVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (polYd[i] != null)
					model.setPolYd(polYd[i]);
				if (dcFlg[i] != null)
					model.setDcFlg(dcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSmsRequirementResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SmsRequirementResultVO[]
	 */
	public SmsRequirementResultVO[] getSmsRequirementResultVOs(){
		SmsRequirementResultVO[] vos = (SmsRequirementResultVO[])models.toArray(new SmsRequirementResultVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcFlg = this.dcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
