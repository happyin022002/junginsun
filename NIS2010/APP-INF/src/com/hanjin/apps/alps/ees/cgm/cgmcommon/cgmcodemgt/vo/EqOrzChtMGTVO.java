/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqOrzChtMGTVO.java
*@FileTitle : EqOrzChtMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.16 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqOrzChtMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqOrzChtMGTVO> models = new ArrayList<EqOrzChtMGTVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqOrzChtSccCd = null;
	/* Column Info */
	private String eqOrzChtUsFlag = null;
	/* Column Info */
	private String eqOrzChtLccCd = null;
	/* Column Info */
	private String eqOrzChtChktype = null;
	/* Column Info */
	private String eqOrzChtRccCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqOrzChtMGTVO() {}

	public EqOrzChtMGTVO(String ibflag, String pagerows, String eqOrzChtChktype, String eqOrzChtRccCd, String eqOrzChtLccCd, String eqOrzChtSccCd, String eqOrzChtUsFlag) {
		this.ibflag = ibflag;
		this.eqOrzChtSccCd = eqOrzChtSccCd;
		this.eqOrzChtUsFlag = eqOrzChtUsFlag;
		this.eqOrzChtLccCd = eqOrzChtLccCd;
		this.eqOrzChtChktype = eqOrzChtChktype;
		this.eqOrzChtRccCd = eqOrzChtRccCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_orz_cht_scc_cd", getEqOrzChtSccCd());
		this.hashColumns.put("eq_orz_cht_us_flag", getEqOrzChtUsFlag());
		this.hashColumns.put("eq_orz_cht_lcc_cd", getEqOrzChtLccCd());
		this.hashColumns.put("eq_orz_cht_chktype", getEqOrzChtChktype());
		this.hashColumns.put("eq_orz_cht_rcc_cd", getEqOrzChtRccCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_orz_cht_scc_cd", "eqOrzChtSccCd");
		this.hashFields.put("eq_orz_cht_us_flag", "eqOrzChtUsFlag");
		this.hashFields.put("eq_orz_cht_lcc_cd", "eqOrzChtLccCd");
		this.hashFields.put("eq_orz_cht_chktype", "eqOrzChtChktype");
		this.hashFields.put("eq_orz_cht_rcc_cd", "eqOrzChtRccCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return eqOrzChtSccCd
	 */
	public String getEqOrzChtSccCd() {
		return this.eqOrzChtSccCd;
	}
	
	/**
	 * Column Info
	 * @return eqOrzChtUsFlag
	 */
	public String getEqOrzChtUsFlag() {
		return this.eqOrzChtUsFlag;
	}
	
	/**
	 * Column Info
	 * @return eqOrzChtLccCd
	 */
	public String getEqOrzChtLccCd() {
		return this.eqOrzChtLccCd;
	}
	
	/**
	 * Column Info
	 * @return eqOrzChtChktype
	 */
	public String getEqOrzChtChktype() {
		return this.eqOrzChtChktype;
	}
	
	/**
	 * Column Info
	 * @return eqOrzChtRccCd
	 */
	public String getEqOrzChtRccCd() {
		return this.eqOrzChtRccCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqOrzChtSccCd
	 */
	public void setEqOrzChtSccCd(String eqOrzChtSccCd) {
		this.eqOrzChtSccCd = eqOrzChtSccCd;
	}
	
	/**
	 * Column Info
	 * @param eqOrzChtUsFlag
	 */
	public void setEqOrzChtUsFlag(String eqOrzChtUsFlag) {
		this.eqOrzChtUsFlag = eqOrzChtUsFlag;
	}
	
	/**
	 * Column Info
	 * @param eqOrzChtLccCd
	 */
	public void setEqOrzChtLccCd(String eqOrzChtLccCd) {
		this.eqOrzChtLccCd = eqOrzChtLccCd;
	}
	
	/**
	 * Column Info
	 * @param eqOrzChtChktype
	 */
	public void setEqOrzChtChktype(String eqOrzChtChktype) {
		this.eqOrzChtChktype = eqOrzChtChktype;
	}
	
	/**
	 * Column Info
	 * @param eqOrzChtRccCd
	 */
	public void setEqOrzChtRccCd(String eqOrzChtRccCd) {
		this.eqOrzChtRccCd = eqOrzChtRccCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqOrzChtSccCd(JSPUtil.getParameter(request, "eq_orz_cht_scc_cd", ""));
		setEqOrzChtUsFlag(JSPUtil.getParameter(request, "eq_orz_cht_us_flag", ""));
		setEqOrzChtLccCd(JSPUtil.getParameter(request, "eq_orz_cht_lcc_cd", ""));
		setEqOrzChtChktype(JSPUtil.getParameter(request, "eq_orz_cht_chktype", ""));
		setEqOrzChtRccCd(JSPUtil.getParameter(request, "eq_orz_cht_rcc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqOrzChtMGTVO[]
	 */
	public EqOrzChtMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqOrzChtMGTVO[]
	 */
	public EqOrzChtMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqOrzChtMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqOrzChtSccCd = (JSPUtil.getParameter(request, prefix	+ "eq_orz_cht_scc_cd", length));
			String[] eqOrzChtUsFlag = (JSPUtil.getParameter(request, prefix	+ "eq_orz_cht_us_flag", length));
			String[] eqOrzChtLccCd = (JSPUtil.getParameter(request, prefix	+ "eq_orz_cht_lcc_cd", length));
			String[] eqOrzChtChktype = (JSPUtil.getParameter(request, prefix	+ "eq_orz_cht_chktype", length));
			String[] eqOrzChtRccCd = (JSPUtil.getParameter(request, prefix	+ "eq_orz_cht_rcc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqOrzChtMGTVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqOrzChtSccCd[i] != null)
					model.setEqOrzChtSccCd(eqOrzChtSccCd[i]);
				if (eqOrzChtUsFlag[i] != null)
					model.setEqOrzChtUsFlag(eqOrzChtUsFlag[i]);
				if (eqOrzChtLccCd[i] != null)
					model.setEqOrzChtLccCd(eqOrzChtLccCd[i]);
				if (eqOrzChtChktype[i] != null)
					model.setEqOrzChtChktype(eqOrzChtChktype[i]);
				if (eqOrzChtRccCd[i] != null)
					model.setEqOrzChtRccCd(eqOrzChtRccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqOrzChtMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqOrzChtMGTVO[]
	 */
	public EqOrzChtMGTVO[] getEqOrzChtMGTVOs(){
		EqOrzChtMGTVO[] vos = (EqOrzChtMGTVO[])models.toArray(new EqOrzChtMGTVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOrzChtSccCd = this.eqOrzChtSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOrzChtUsFlag = this.eqOrzChtUsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOrzChtLccCd = this.eqOrzChtLccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOrzChtChktype = this.eqOrzChtChktype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOrzChtRccCd = this.eqOrzChtRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
