/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgEqlzPortVO.java
*@FileTitle : BkgEqlzPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.31 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmStateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmStateVO> models = new ArrayList<MdmStateVO>();
	
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String indSteCd = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String indTerrDivCd = null;
	/* Column Info */
	private String indTerrDivNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmStateVO() {}

	public MdmStateVO(String cntCd, String steCd, String indSteCd, String steNm, String indTerrDivCd, String indTerrDivNm, String updUsrId, String chgCd, String ibflag) {
		this.cntCd = cntCd;
		this.steCd = steCd;
		this.indSteCd = indSteCd;
		this.steNm = steNm;
		this.indTerrDivCd = indTerrDivCd;
		this.indTerrDivNm = indTerrDivNm;
		this.updUsrId = updUsrId;
		this.chgCd = chgCd;
		this.ibflag = ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("ind_ste_cd", getIndSteCd());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("ind_terr_div_cd", getIndTerrDivCd());
		this.hashColumns.put("ind_terr_div_nm", getIndTerrDivNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("ind_ste_cd", "indSteCd");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("ind_terr_div_cd", "indTerrDivCd");
		this.hashFields.put("ind_terr_div_nm", "indTerrDivNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return steCd;
	}
	
	/**
	 * Column Info
	 * @return indSteCd
	 */
	public String getIndSteCd() {
		return indSteCd;
	}
	
	/**
	 * Column Info
	 * @return steNm
	 */
	public String getSteNm() {
		return steNm;
	}
	
	/**
	 * Column Info
	 * @return indTerrDivCd
	 */
	public String getIndTerrDivCd() {
		return indTerrDivCd;
	}
	
	/**
	 * Column Info
	 * @return indTerrDivNm
	 */
	public String getIndTerrDivNm() {
		return indTerrDivNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return chgCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @return indSteCd
	 */
	public void setIndSteCd(String indSteCd) {
		this.indSteCd = indSteCd;
	}
	
	/**
	 * Column Info
	 * @return steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @return indTerrDivCd
	 */
	public void setIndTerrDivCd(String indTerrDivCd) {
		this.indTerrDivCd = indTerrDivCd;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public void setIndTerrDivNm(String indTerrDivNm) {
		this.indTerrDivNm = indTerrDivNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @return chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setIndSteCd(JSPUtil.getParameter(request, prefix + "ind_ste_cd", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setIndTerrDivCd(JSPUtil.getParameter(request, prefix + "ind_terr_div_cd", ""));
		setIndTerrDivNm(JSPUtil.getParameter(request, prefix + "ind_terr_div_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEqlzPortVO[]
	 */
	public MdmStateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEqlzPortVO[]
	 */
	public MdmStateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmStateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] indSteCd  = (JSPUtil.getParameter(request, prefix	+ "ind_ste_cd", length));
			String[] steNm  = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] indTerrDivCd  = (JSPUtil.getParameter(request, prefix	+ "ind_terr_div_cd", length));
			String[] indTerrDivNm  = (JSPUtil.getParameter(request, prefix	+ "ind_terr_div_nm", length));
			String[] updUsrId  = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmStateVO();
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (indSteCd[i] != null)
					model.setIndSteCd(indSteCd[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (indTerrDivCd[i] != null)
					model.setIndTerrDivCd(indTerrDivCd[i]);
				if (indTerrDivNm[i] != null)
					model.setIndTerrDivNm(indTerrDivNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmStateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEqlzPortVO[]
	 */
	public MdmStateVO[] getMdmStateVOs(){
		MdmStateVO[] vos = (MdmStateVO[])models.toArray(new MdmStateVO[models.size()]);
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
		this.cntCd  = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd  = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indSteCd  = this.indSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm  = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indTerrDivCd  = this.indTerrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indTerrDivNm  = this.indTerrDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
