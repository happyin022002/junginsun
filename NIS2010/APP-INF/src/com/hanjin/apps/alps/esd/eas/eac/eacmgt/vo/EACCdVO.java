/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACCdVO.java
*@FileTitle : EACCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACCdVO> models = new ArrayList<EACCdVO>();
	
	/* Column Info */
	private String bilTpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnTpNm = null;
	/* Column Info */
	private String bilTpCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String tpNm = null;
	/* Column Info */
	private String bilTpDesc = null;
	/* Column Info */
	private String ifTpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACCdVO() {}

	public EACCdVO(String ibflag, String pagerows, String tpCd, String tpNm, String bilTpCd, String bilTpNm, String bilTpDesc, String ifTpNm, String expnTpNm) {
		this.bilTpNm = bilTpNm;
		this.ibflag = ibflag;
		this.expnTpNm = expnTpNm;
		this.bilTpCd = bilTpCd;
		this.tpCd = tpCd;
		this.tpNm = tpNm;
		this.bilTpDesc = bilTpDesc;
		this.ifTpNm = ifTpNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bil_tp_nm", getBilTpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_tp_nm", getExpnTpNm());
		this.hashColumns.put("bil_tp_cd", getBilTpCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("tp_nm", getTpNm());
		this.hashColumns.put("bil_tp_desc", getBilTpDesc());
		this.hashColumns.put("if_tp_nm", getIfTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bil_tp_nm", "bilTpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_tp_nm", "expnTpNm");
		this.hashFields.put("bil_tp_cd", "bilTpCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("tp_nm", "tpNm");
		this.hashFields.put("bil_tp_desc", "bilTpDesc");
		this.hashFields.put("if_tp_nm", "ifTpNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bilTpNm
	 */
	public String getBilTpNm() {
		return this.bilTpNm;
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
	 * @return expnTpNm
	 */
	public String getExpnTpNm() {
		return this.expnTpNm;
	}
	
	/**
	 * Column Info
	 * @return bilTpCd
	 */
	public String getBilTpCd() {
		return this.bilTpCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return tpNm
	 */
	public String getTpNm() {
		return this.tpNm;
	}
	
	/**
	 * Column Info
	 * @return bilTpDesc
	 */
	public String getBilTpDesc() {
		return this.bilTpDesc;
	}
	
	/**
	 * Column Info
	 * @return ifTpNm
	 */
	public String getIfTpNm() {
		return this.ifTpNm;
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
	 * @param bilTpNm
	 */
	public void setBilTpNm(String bilTpNm) {
		this.bilTpNm = bilTpNm;
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
	 * @param expnTpNm
	 */
	public void setExpnTpNm(String expnTpNm) {
		this.expnTpNm = expnTpNm;
	}
	
	/**
	 * Column Info
	 * @param bilTpCd
	 */
	public void setBilTpCd(String bilTpCd) {
		this.bilTpCd = bilTpCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param tpNm
	 */
	public void setTpNm(String tpNm) {
		this.tpNm = tpNm;
	}
	
	/**
	 * Column Info
	 * @param bilTpDesc
	 */
	public void setBilTpDesc(String bilTpDesc) {
		this.bilTpDesc = bilTpDesc;
	}
	
	/**
	 * Column Info
	 * @param ifTpNm
	 */
	public void setIfTpNm(String ifTpNm) {
		this.ifTpNm = ifTpNm;
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
		setBilTpNm(JSPUtil.getParameter(request, prefix + "bil_tp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpnTpNm(JSPUtil.getParameter(request, prefix + "expn_tp_nm", ""));
		setBilTpCd(JSPUtil.getParameter(request, prefix + "bil_tp_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setTpNm(JSPUtil.getParameter(request, prefix + "tp_nm", ""));
		setBilTpDesc(JSPUtil.getParameter(request, prefix + "bil_tp_desc", ""));
		setIfTpNm(JSPUtil.getParameter(request, prefix + "if_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACCdVO[]
	 */
	public EACCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACCdVO[]
	 */
	public EACCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bilTpNm = (JSPUtil.getParameter(request, prefix	+ "bil_tp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnTpNm = (JSPUtil.getParameter(request, prefix	+ "expn_tp_nm", length));
			String[] bilTpCd = (JSPUtil.getParameter(request, prefix	+ "bil_tp_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] tpNm = (JSPUtil.getParameter(request, prefix	+ "tp_nm", length));
			String[] bilTpDesc = (JSPUtil.getParameter(request, prefix	+ "bil_tp_desc", length));
			String[] ifTpNm = (JSPUtil.getParameter(request, prefix	+ "if_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACCdVO();
				if (bilTpNm[i] != null)
					model.setBilTpNm(bilTpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnTpNm[i] != null)
					model.setExpnTpNm(expnTpNm[i]);
				if (bilTpCd[i] != null)
					model.setBilTpCd(bilTpCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (tpNm[i] != null)
					model.setTpNm(tpNm[i]);
				if (bilTpDesc[i] != null)
					model.setBilTpDesc(bilTpDesc[i]);
				if (ifTpNm[i] != null)
					model.setIfTpNm(ifTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACCdVO[]
	 */
	public EACCdVO[] getEACCdVOs(){
		EACCdVO[] vos = (EACCdVO[])models.toArray(new EACCdVO[models.size()]);
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
		this.bilTpNm = this.bilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTpNm = this.expnTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTpCd = this.bilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpNm = this.tpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTpDesc = this.bilTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTpNm = this.ifTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
