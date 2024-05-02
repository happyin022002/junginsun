/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExpTypeListForMultiVO.java
*@FileTitle : SearchExpTypeListForMultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.09 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExpTypeListForMultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExpTypeListForMultiVO> models = new ArrayList<SearchExpTypeListForMultiVO>();
	
	/* Column Info */
	private String rCopExptTpDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String rIbflag = null;
	/* Column Info */
	private String rActFlg = null;
	/* Column Info */
	private String rCopExptTpNm = null;
	/* Column Info */
	private String rUsrId = null;
	/* Column Info */
	private String rUpdDt = null;
	/* Column Info */
	private String rCopExptTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExpTypeListForMultiVO() {}

	public SearchExpTypeListForMultiVO(String rIbflag, String pagerows, String rCopExptTpCd, String rCopExptTpNm, String rCopExptTpDesc, String rUsrId, String rUpdDt, String rActFlg) {
		this.rCopExptTpDesc = rCopExptTpDesc;
		this.rIbflag = rIbflag;
		this.rActFlg = rActFlg;
		this.rCopExptTpNm = rCopExptTpNm;
		this.rUsrId = rUsrId;
		this.rUpdDt = rUpdDt;
		this.rCopExptTpCd = rCopExptTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_cop_expt_tp_desc", getRCopExptTpDesc());
		this.hashColumns.put("r_ibflag", getRIbflag());
		this.hashColumns.put("r_act_flg", getRActFlg());
		this.hashColumns.put("r_cop_expt_tp_nm", getRCopExptTpNm());
		this.hashColumns.put("r_usr_id", getRUsrId());
		this.hashColumns.put("r_upd_dt", getRUpdDt());
		this.hashColumns.put("r_cop_expt_tp_cd", getRCopExptTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_cop_expt_tp_desc", "rCopExptTpDesc");
		this.hashFields.put("r_ibflag", "rIbflag");
		this.hashFields.put("r_act_flg", "rActFlg");
		this.hashFields.put("r_cop_expt_tp_nm", "rCopExptTpNm");
		this.hashFields.put("r_usr_id", "rUsrId");
		this.hashFields.put("r_upd_dt", "rUpdDt");
		this.hashFields.put("r_cop_expt_tp_cd", "rCopExptTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rCopExptTpDesc
	 */
	public String getRCopExptTpDesc() {
		return this.rCopExptTpDesc;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return rIbflag
	 */
	public String getRIbflag() {
		return this.rIbflag;
	}
	
	/**
	 * Column Info
	 * @return rActFlg
	 */
	public String getRActFlg() {
		return this.rActFlg;
	}
	
	/**
	 * Column Info
	 * @return rCopExptTpNm
	 */
	public String getRCopExptTpNm() {
		return this.rCopExptTpNm;
	}
	
	/**
	 * Column Info
	 * @return rUsrId
	 */
	public String getRUsrId() {
		return this.rUsrId;
	}
	
	/**
	 * Column Info
	 * @return rUpdDt
	 */
	public String getRUpdDt() {
		return this.rUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rCopExptTpCd
	 */
	public String getRCopExptTpCd() {
		return this.rCopExptTpCd;
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
	 * @param rCopExptTpDesc
	 */
	public void setRCopExptTpDesc(String rCopExptTpDesc) {
		this.rCopExptTpDesc = rCopExptTpDesc;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param rIbflag
	 */
	public void setRIbflag(String rIbflag) {
		this.rIbflag = rIbflag;
	}
	
	/**
	 * Column Info
	 * @param rActFlg
	 */
	public void setRActFlg(String rActFlg) {
		this.rActFlg = rActFlg;
	}
	
	/**
	 * Column Info
	 * @param rCopExptTpNm
	 */
	public void setRCopExptTpNm(String rCopExptTpNm) {
		this.rCopExptTpNm = rCopExptTpNm;
	}
	
	/**
	 * Column Info
	 * @param rUsrId
	 */
	public void setRUsrId(String rUsrId) {
		this.rUsrId = rUsrId;
	}
	
	/**
	 * Column Info
	 * @param rUpdDt
	 */
	public void setRUpdDt(String rUpdDt) {
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rCopExptTpCd
	 */
	public void setRCopExptTpCd(String rCopExptTpCd) {
		this.rCopExptTpCd = rCopExptTpCd;
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
		setRCopExptTpDesc(JSPUtil.getParameter(request, "r_cop_expt_tp_desc", ""));
		setRIbflag(JSPUtil.getParameter(request, "r_ibflag", ""));
		setRActFlg(JSPUtil.getParameter(request, "r_act_flg", ""));
		setRCopExptTpNm(JSPUtil.getParameter(request, "r_cop_expt_tp_nm", ""));
		setRUsrId(JSPUtil.getParameter(request, "r_usr_id", ""));
		setRUpdDt(JSPUtil.getParameter(request, "r_upd_dt", ""));
		setRCopExptTpCd(JSPUtil.getParameter(request, "r_cop_expt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExpTypeListForMultiVO[]
	 */
	public SearchExpTypeListForMultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExpTypeListForMultiVO[]
	 */
	public SearchExpTypeListForMultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExpTypeListForMultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "r_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "r_ibflag").length;
  
		try {
			String[] rCopExptTpDesc = (JSPUtil.getParameter(request, prefix	+ "r_cop_expt_tp_desc", length));
			String[] rIbflag = (JSPUtil.getParameter(request, prefix	+ "r_ibflag", length));
			String[] rActFlg = (JSPUtil.getParameter(request, prefix	+ "r_act_flg", length));
			String[] rCopExptTpNm = (JSPUtil.getParameter(request, prefix	+ "r_cop_expt_tp_nm", length));
			String[] rUsrId = (JSPUtil.getParameter(request, prefix	+ "r_usr_id", length));
			String[] rUpdDt = (JSPUtil.getParameter(request, prefix	+ "r_upd_dt", length));
			String[] rCopExptTpCd = (JSPUtil.getParameter(request, prefix	+ "r_cop_expt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExpTypeListForMultiVO();
				if (rCopExptTpDesc[i] != null)
					model.setRCopExptTpDesc(rCopExptTpDesc[i]);
				if (rIbflag[i] != null)
					model.setRIbflag(rIbflag[i]);
				if (rActFlg[i] != null)
					model.setRActFlg(rActFlg[i]);
				if (rCopExptTpNm[i] != null)
					model.setRCopExptTpNm(rCopExptTpNm[i]);
				if (rUsrId[i] != null)
					model.setRUsrId(rUsrId[i]);
				if (rUpdDt[i] != null)
					model.setRUpdDt(rUpdDt[i]);
				if (rCopExptTpCd[i] != null)
					model.setRCopExptTpCd(rCopExptTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExpTypeListForMultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExpTypeListForMultiVO[]
	 */
	public SearchExpTypeListForMultiVO[] getSearchExpTypeListForMultiVOs(){
		SearchExpTypeListForMultiVO[] vos = (SearchExpTypeListForMultiVO[])models.toArray(new SearchExpTypeListForMultiVO[models.size()]);
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
		this.rCopExptTpDesc = this.rCopExptTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rIbflag = this.rIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rActFlg = this.rActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCopExptTpNm = this.rCopExptTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUsrId = this.rUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUpdDt = this.rUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCopExptTpCd = this.rCopExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
