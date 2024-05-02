/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchReeferSpclTpSzMgmtVO.java
*@FileTitle : SearchReeferSpclTpSzMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo;

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

public class SearchReeferSpclTpSzMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReeferSpclTpSzMgmtVO> models = new ArrayList<SearchReeferSpclTpSzMgmtVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclTgtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String spclDgCgoFlg = null;
	/* Column Info */
	private String rdFlg = null;
	/* Column Info */
	private String sqmActFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchReeferSpclTpSzMgmtVO() {}

	public SearchReeferSpclTpSzMgmtVO(String ibflag, String pagerows, String spclTgtCd, String spclDgCgoFlg, String cntrTpszCd, String rdFlg, String sqmActFlg, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.spclTgtCd = spclTgtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.spclDgCgoFlg = spclDgCgoFlg;
		this.rdFlg = rdFlg;
		this.sqmActFlg = sqmActFlg;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_tgt_cd", getSpclTgtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("spcl_dg_cgo_flg", getSpclDgCgoFlg());
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("sqm_act_flg", getSqmActFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_tgt_cd", "spclTgtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("spcl_dg_cgo_flg", "spclDgCgoFlg");
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("sqm_act_flg", "sqmActFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return spclTgtCd
	 */
	public String getSpclTgtCd() {
		return this.spclTgtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return spclDgCgoFlg
	 */
	public String getSpclDgCgoFlg() {
		return this.spclDgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rdFlg
	 */
	public String getRdFlg() {
		return this.rdFlg;
	}
	
	/**
	 * Column Info
	 * @return sqmActFlg
	 */
	public String getSqmActFlg() {
		return this.sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param spclTgtCd
	 */
	public void setSpclTgtCd(String spclTgtCd) {
		this.spclTgtCd = spclTgtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param spclDgCgoFlg
	 */
	public void setSpclDgCgoFlg(String spclDgCgoFlg) {
		this.spclDgCgoFlg = spclDgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
	}
	
	/**
	 * Column Info
	 * @param sqmActFlg
	 */
	public void setSqmActFlg(String sqmActFlg) {
		this.sqmActFlg = sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclTgtCd(JSPUtil.getParameter(request, prefix + "spcl_tgt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSpclDgCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_dg_cgo_flg", ""));
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setSqmActFlg(JSPUtil.getParameter(request, prefix + "sqm_act_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReeferSpclTpSzMgmtVO[]
	 */
	public SearchReeferSpclTpSzMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReeferSpclTpSzMgmtVO[]
	 */
	public SearchReeferSpclTpSzMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReeferSpclTpSzMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclTgtCd = (JSPUtil.getParameter(request, prefix	+ "spcl_tgt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] spclDgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_dg_cgo_flg", length));
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] sqmActFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_act_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReeferSpclTpSzMgmtVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclTgtCd[i] != null)
					model.setSpclTgtCd(spclTgtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (spclDgCgoFlg[i] != null)
					model.setSpclDgCgoFlg(spclDgCgoFlg[i]);
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (sqmActFlg[i] != null)
					model.setSqmActFlg(sqmActFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReeferSpclTpSzMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReeferSpclTpSzMgmtVO[]
	 */
	public SearchReeferSpclTpSzMgmtVO[] getSearchReeferSpclTpSzMgmtVOs(){
		SearchReeferSpclTpSzMgmtVO[] vos = (SearchReeferSpclTpSzMgmtVO[])models.toArray(new SearchReeferSpclTpSzMgmtVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTgtCd = this.spclTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclDgCgoFlg = this.spclDgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmActFlg = this.sqmActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
