/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MailingServiceSettingListVO.java
*@FileTitle : MailingServiceSettingListVO
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.03.31 Chang Young Kim
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MailingServiceSettingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MailingServiceSettingListVO> models = new ArrayList<MailingServiceSettingListVO>();
	
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String scontiChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCdH = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntChk = null;
	/* Column Info */
	private String scontiCdH = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MailingServiceSettingListVO() {}

	public MailingServiceSettingListVO(String ibflag, String pagerows, String scontiCdH, String scontiChk, String scontiCd, String cntCdH, String cntChk, String cntCd, String cntNm) {
		this.cntNm = cntNm;
		this.scontiChk = scontiChk;
		this.ibflag = ibflag;
		this.cntCdH = cntCdH;
		this.cntCd = cntCd;
		this.cntChk = cntChk;
		this.scontiCdH = scontiCdH;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("sconti_chk", getScontiChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd_h", getCntCdH());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cnt_chk", getCntChk());
		this.hashColumns.put("sconti_cd_h", getScontiCdH());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("sconti_chk", "scontiChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd_h", "cntCdH");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cnt_chk", "cntChk");
		this.hashFields.put("sconti_cd_h", "scontiCdH");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return scontiChk
	 */
	public String getScontiChk() {
		return this.scontiChk;
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
	 * @return cntCdH
	 */
	public String getCntCdH() {
		return this.cntCdH;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return cntChk
	 */
	public String getCntChk() {
		return this.cntChk;
	}
	
	/**
	 * Column Info
	 * @return scontiCdH
	 */
	public String getScontiCdH() {
		return this.scontiCdH;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param scontiChk
	 */
	public void setScontiChk(String scontiChk) {
		this.scontiChk = scontiChk;
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
	 * @param cntCdH
	 */
	public void setCntCdH(String cntCdH) {
		this.cntCdH = cntCdH;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param cntChk
	 */
	public void setCntChk(String cntChk) {
		this.cntChk = cntChk;
	}
	
	/**
	 * Column Info
	 * @param scontiCdH
	 */
	public void setScontiCdH(String scontiCdH) {
		this.scontiCdH = scontiCdH;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
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
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setScontiChk(JSPUtil.getParameter(request, prefix + "sconti_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntCdH(JSPUtil.getParameter(request, prefix + "cnt_cd_h", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntChk(JSPUtil.getParameter(request, prefix + "cnt_chk", ""));
		setScontiCdH(JSPUtil.getParameter(request, prefix + "sconti_cd_h", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MailingServiceSettingListVO[]
	 */
	public MailingServiceSettingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MailingServiceSettingListVO[]
	 */
	public MailingServiceSettingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MailingServiceSettingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] scontiChk = (JSPUtil.getParameter(request, prefix	+ "sconti_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCdH = (JSPUtil.getParameter(request, prefix	+ "cnt_cd_h", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntChk = (JSPUtil.getParameter(request, prefix	+ "cnt_chk", length));
			String[] scontiCdH = (JSPUtil.getParameter(request, prefix	+ "sconti_cd_h", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MailingServiceSettingListVO();
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (scontiChk[i] != null)
					model.setScontiChk(scontiChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCdH[i] != null)
					model.setCntCdH(cntCdH[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntChk[i] != null)
					model.setCntChk(cntChk[i]);
				if (scontiCdH[i] != null)
					model.setScontiCdH(scontiCdH[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMailingServiceSettingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MailingServiceSettingListVO[]
	 */
	public MailingServiceSettingListVO[] getMailingServiceSettingListVOs(){
		MailingServiceSettingListVO[] vos = (MailingServiceSettingListVO[])models.toArray(new MailingServiceSettingListVO[models.size()]);
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
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiChk = this.scontiChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCdH = this.cntCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntChk = this.cntChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCdH = this.scontiCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
