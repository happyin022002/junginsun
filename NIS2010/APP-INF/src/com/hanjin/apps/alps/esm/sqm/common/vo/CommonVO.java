/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonVO.java
*@FileTitle : CommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.11 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.common.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommonVO> models = new ArrayList<CommonVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fBseYr = null;
	/* Column Info */
	private String fBseQtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fOfcVwCd = null;
	/* Column Info */
	private String fBatRmk = null;
	/* Column Info */
	private String fBatStsCd = null;
	/* Column Info */
	private String fBseTpCd = null;
	/* Column Info */
	private String fBatId = null;
	/* Column Info */
	private String allFlag = null;
	/* Column Info */
	private String codeParam = null;
	/* Column Info */
	private String codeName = null;
	/* Column Info */
	private String fUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CommonVO() {}

	public CommonVO(String ibflag, String pagerows, String codeName, String codeParam, String allFlag, String fBatId, String fBatStsCd, String fBatRmk, String fBseTpCd, String fBseYr, String fBseQtrCd, String fOfcVwCd, String fUsrId) {
		this.pagerows = pagerows;
		this.fBseYr = fBseYr;
		this.fBseQtrCd = fBseQtrCd;
		this.ibflag = ibflag;
		this.fOfcVwCd = fOfcVwCd;
		this.fBatRmk = fBatRmk;
		this.fBatStsCd = fBatStsCd;
		this.fBseTpCd = fBseTpCd;
		this.fBatId = fBatId;
		this.allFlag = allFlag;
		this.codeParam = codeParam;
		this.codeName = codeName;
		this.fUsrId = fUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_bse_yr", getFBseYr());
		this.hashColumns.put("f_bse_qtr_cd", getFBseQtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_ofc_vw_cd", getFOfcVwCd());
		this.hashColumns.put("f_bat_rmk", getFBatRmk());
		this.hashColumns.put("f_bat_sts_cd", getFBatStsCd());
		this.hashColumns.put("f_bse_tp_cd", getFBseTpCd());
		this.hashColumns.put("f_bat_id", getFBatId());
		this.hashColumns.put("all_flag", getAllFlag());
		this.hashColumns.put("code_param", getCodeParam());
		this.hashColumns.put("code_name", getCodeName());
		this.hashColumns.put("f_usr_id", getFUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_bse_yr", "fBseYr");
		this.hashFields.put("f_bse_qtr_cd", "fBseQtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_ofc_vw_cd", "fOfcVwCd");
		this.hashFields.put("f_bat_rmk", "fBatRmk");
		this.hashFields.put("f_bat_sts_cd", "fBatStsCd");
		this.hashFields.put("f_bse_tp_cd", "fBseTpCd");
		this.hashFields.put("f_bat_id", "fBatId");
		this.hashFields.put("all_flag", "allFlag");
		this.hashFields.put("code_param", "codeParam");
		this.hashFields.put("code_name", "codeName");
		this.hashFields.put("f_usr_id", "fUsrId");
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
	 * @return fBseYr
	 */
	public String getFBseYr() {
		return this.fBseYr;
	}
	
	/**
	 * Column Info
	 * @return fBseQtrCd
	 */
	public String getFBseQtrCd() {
		return this.fBseQtrCd;
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
	 * @return fOfcVwCd
	 */
	public String getFOfcVwCd() {
		return this.fOfcVwCd;
	}
	
	/**
	 * Column Info
	 * @return fBatRmk
	 */
	public String getFBatRmk() {
		return this.fBatRmk;
	}
	
	/**
	 * Column Info
	 * @return fBatStsCd
	 */
	public String getFBatStsCd() {
		return this.fBatStsCd;
	}
	
	/**
	 * Column Info
	 * @return fBseTpCd
	 */
	public String getFBseTpCd() {
		return this.fBseTpCd;
	}
	
	/**
	 * Column Info
	 * @return fBatId
	 */
	public String getFBatId() {
		return this.fBatId;
	}
	
	/**
	 * Column Info
	 * @return allFlag
	 */
	public String getAllFlag() {
		return this.allFlag;
	}
	
	/**
	 * Column Info
	 * @return codeParam
	 */
	public String getCodeParam() {
		return this.codeParam;
	}
	
	/**
	 * Column Info
	 * @return codeName
	 */
	public String getCodeName() {
		return this.codeName;
	}
	
	/**
	 * Column Info
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
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
	 * @param fBseYr
	 */
	public void setFBseYr(String fBseYr) {
		this.fBseYr = fBseYr;
	}
	
	/**
	 * Column Info
	 * @param fBseQtrCd
	 */
	public void setFBseQtrCd(String fBseQtrCd) {
		this.fBseQtrCd = fBseQtrCd;
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
	 * @param fOfcVwCd
	 */
	public void setFOfcVwCd(String fOfcVwCd) {
		this.fOfcVwCd = fOfcVwCd;
	}
	
	/**
	 * Column Info
	 * @param fBatRmk
	 */
	public void setFBatRmk(String fBatRmk) {
		this.fBatRmk = fBatRmk;
	}
	
	/**
	 * Column Info
	 * @param fBatStsCd
	 */
	public void setFBatStsCd(String fBatStsCd) {
		this.fBatStsCd = fBatStsCd;
	}
	
	/**
	 * Column Info
	 * @param fBseTpCd
	 */
	public void setFBseTpCd(String fBseTpCd) {
		this.fBseTpCd = fBseTpCd;
	}
	
	/**
	 * Column Info
	 * @param fBatId
	 */
	public void setFBatId(String fBatId) {
		this.fBatId = fBatId;
	}
	
	/**
	 * Column Info
	 * @param allFlag
	 */
	public void setAllFlag(String allFlag) {
		this.allFlag = allFlag;
	}
	
	/**
	 * Column Info
	 * @param codeParam
	 */
	public void setCodeParam(String codeParam) {
		this.codeParam = codeParam;
	}
	
	/**
	 * Column Info
	 * @param codeName
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	/**
	 * Column Info
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
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
		setFBseYr(JSPUtil.getParameter(request, prefix + "f_bse_yr", ""));
		setFBseQtrCd(JSPUtil.getParameter(request, prefix + "f_bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFOfcVwCd(JSPUtil.getParameter(request, prefix + "f_ofc_vw_cd", ""));
		setFBatRmk(JSPUtil.getParameter(request, prefix + "f_bat_rmk", ""));
		setFBatStsCd(JSPUtil.getParameter(request, prefix + "f_bat_sts_cd", ""));
		setFBseTpCd(JSPUtil.getParameter(request, prefix + "f_bse_tp_cd", ""));
		setFBatId(JSPUtil.getParameter(request, prefix + "f_bat_id", ""));
		setAllFlag(JSPUtil.getParameter(request, prefix + "all_flag", ""));
		setCodeParam(JSPUtil.getParameter(request, prefix + "code_param", ""));
		setCodeName(JSPUtil.getParameter(request, prefix + "code_name", ""));
		setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommonVO[]
	 */
	public CommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommonVO[]
	 */
	public CommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fBseYr = (JSPUtil.getParameter(request, prefix	+ "f_bse_yr", length));
			String[] fBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_qtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fOfcVwCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw_cd", length));
			String[] fBatRmk = (JSPUtil.getParameter(request, prefix	+ "f_bat_rmk", length));
			String[] fBatStsCd = (JSPUtil.getParameter(request, prefix	+ "f_bat_sts_cd", length));
			String[] fBseTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_tp_cd", length));
			String[] fBatId = (JSPUtil.getParameter(request, prefix	+ "f_bat_id", length));
			String[] allFlag = (JSPUtil.getParameter(request, prefix	+ "all_flag", length));
			String[] codeParam = (JSPUtil.getParameter(request, prefix	+ "code_param", length));
			String[] codeName = (JSPUtil.getParameter(request, prefix	+ "code_name", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommonVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fBseYr[i] != null)
					model.setFBseYr(fBseYr[i]);
				if (fBseQtrCd[i] != null)
					model.setFBseQtrCd(fBseQtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fOfcVwCd[i] != null)
					model.setFOfcVwCd(fOfcVwCd[i]);
				if (fBatRmk[i] != null)
					model.setFBatRmk(fBatRmk[i]);
				if (fBatStsCd[i] != null)
					model.setFBatStsCd(fBatStsCd[i]);
				if (fBseTpCd[i] != null)
					model.setFBseTpCd(fBseTpCd[i]);
				if (fBatId[i] != null)
					model.setFBatId(fBatId[i]);
				if (allFlag[i] != null)
					model.setAllFlag(allFlag[i]);
				if (codeParam[i] != null)
					model.setCodeParam(codeParam[i]);
				if (codeName[i] != null)
					model.setCodeName(codeName[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommonVO[]
	 */
	public CommonVO[] getCommonVOs(){
		CommonVO[] vos = (CommonVO[])models.toArray(new CommonVO[models.size()]);
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
		this.fBseYr = this.fBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseQtrCd = this.fBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVwCd = this.fOfcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBatRmk = this.fBatRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBatStsCd = this.fBatStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseTpCd = this.fBseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBatId = this.fBatId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allFlag = this.allFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeParam = this.codeParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeName = this.codeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
