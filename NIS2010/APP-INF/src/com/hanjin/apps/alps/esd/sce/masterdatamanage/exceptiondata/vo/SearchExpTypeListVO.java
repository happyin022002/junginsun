/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExpTypeListVO.java
*@FileTitle : SearchExpTypeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.07 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExpTypeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExpTypeListVO> models = new ArrayList<SearchExpTypeListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String copExptTpCd = null;
	/* Column Info */
	private String copExptTpDesc = null;
	/* Column Info */
	private String copExptTpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExpTypeListVO() {}

	public SearchExpTypeListVO(String ibflag, String pagerows, String copExptTpCd, String copExptTpNm, String copExptTpDesc, String usrId, String updDt, String actFlg) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.actFlg = actFlg;
		this.usrId = usrId;
		this.copExptTpCd = copExptTpCd;
		this.copExptTpDesc = copExptTpDesc;
		this.copExptTpNm = copExptTpNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cop_expt_tp_cd", getCopExptTpCd());
		this.hashColumns.put("cop_expt_tp_desc", getCopExptTpDesc());
		this.hashColumns.put("cop_expt_tp_nm", getCopExptTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cop_expt_tp_cd", "copExptTpCd");
		this.hashFields.put("cop_expt_tp_desc", "copExptTpDesc");
		this.hashFields.put("cop_expt_tp_nm", "copExptTpNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
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
	 * @return copExptTpCd
	 */
	public String getCopExptTpCd() {
		return this.copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @return copExptTpDesc
	 */
	public String getCopExptTpDesc() {
		return this.copExptTpDesc;
	}
	
	/**
	 * Column Info
	 * @return copExptTpNm
	 */
	public String getCopExptTpNm() {
		return this.copExptTpNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
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
	 * @param copExptTpCd
	 */
	public void setCopExptTpCd(String copExptTpCd) {
		this.copExptTpCd = copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @param copExptTpDesc
	 */
	public void setCopExptTpDesc(String copExptTpDesc) {
		this.copExptTpDesc = copExptTpDesc;
	}
	
	/**
	 * Column Info
	 * @param copExptTpNm
	 */
	public void setCopExptTpNm(String copExptTpNm) {
		this.copExptTpNm = copExptTpNm;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActFlg(JSPUtil.getParameter(request, "act_flg", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCopExptTpCd(JSPUtil.getParameter(request, "cop_expt_tp_cd", ""));
		setCopExptTpDesc(JSPUtil.getParameter(request, "cop_expt_tp_desc", ""));
		setCopExptTpNm(JSPUtil.getParameter(request, "cop_expt_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExpTypeListVO[]
	 */
	public SearchExpTypeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExpTypeListVO[]
	 */
	public SearchExpTypeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExpTypeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] copExptTpCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_cd", length));
			String[] copExptTpDesc = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_desc", length));
			String[] copExptTpNm = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExpTypeListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (copExptTpCd[i] != null)
					model.setCopExptTpCd(copExptTpCd[i]);
				if (copExptTpDesc[i] != null)
					model.setCopExptTpDesc(copExptTpDesc[i]);
				if (copExptTpNm[i] != null)
					model.setCopExptTpNm(copExptTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExpTypeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExpTypeListVO[]
	 */
	public SearchExpTypeListVO[] getSearchExpTypeListVOs(){
		SearchExpTypeListVO[] vos = (SearchExpTypeListVO[])models.toArray(new SearchExpTypeListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpCd = this.copExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpDesc = this.copExptTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpNm = this.copExptTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
