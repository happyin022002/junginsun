/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RestrictCmdtDupListVO.java
*@FileTitle : RestrictCmdtDupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.14 Lee InYoung
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author Lee InYoung
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RestrictCmdtDupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RestrictCmdtDupListVO> models = new ArrayList<RestrictCmdtDupListVO>();
	
	/* Column Info */
	private String chkCntKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dupFlg = null;
	/* Column Info */
	private String chkCntCd = null;
	/* Column Info */
	private String chkLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RestrictCmdtDupListVO() {}

	public RestrictCmdtDupListVO(String ibflag, String pagerows, String dupFlg, String chkLocCd, String chkCntCd, String chkCntKnt) {
		this.chkCntKnt = chkCntKnt;
		this.ibflag = ibflag;
		this.dupFlg = dupFlg;
		this.chkCntCd = chkCntCd;
		this.chkLocCd = chkLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_cnt_knt", getChkCntKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("chk_cnt_cd", getChkCntCd());
		this.hashColumns.put("chk_loc_cd", getChkLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_cnt_knt", "chkCntKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("chk_cnt_cd", "chkCntCd");
		this.hashFields.put("chk_loc_cd", "chkLocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkCntKnt
	 */
	public String getChkCntKnt() {
		return this.chkCntKnt;
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
	 * @return dupFlg
	 */
	public String getDupFlg() {
		return this.dupFlg;
	}
	
	/**
	 * Column Info
	 * @return chkCntCd
	 */
	public String getChkCntCd() {
		return this.chkCntCd;
	}
	
	/**
	 * Column Info
	 * @return chkLocCd
	 */
	public String getChkLocCd() {
		return this.chkLocCd;
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
	 * @param chkCntKnt
	 */
	public void setChkCntKnt(String chkCntKnt) {
		this.chkCntKnt = chkCntKnt;
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
	 * @param dupFlg
	 */
	public void setDupFlg(String dupFlg) {
		this.dupFlg = dupFlg;
	}
	
	/**
	 * Column Info
	 * @param chkCntCd
	 */
	public void setChkCntCd(String chkCntCd) {
		this.chkCntCd = chkCntCd;
	}
	
	/**
	 * Column Info
	 * @param chkLocCd
	 */
	public void setChkLocCd(String chkLocCd) {
		this.chkLocCd = chkLocCd;
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
		setChkCntKnt(JSPUtil.getParameter(request, prefix + "chk_cnt_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDupFlg(JSPUtil.getParameter(request, prefix + "dup_flg", ""));
		setChkCntCd(JSPUtil.getParameter(request, prefix + "chk_cnt_cd", ""));
		setChkLocCd(JSPUtil.getParameter(request, prefix + "chk_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RestrictCmdtDupListVO[]
	 */
	public RestrictCmdtDupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RestrictCmdtDupListVO[]
	 */
	public RestrictCmdtDupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RestrictCmdtDupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkCntKnt = (JSPUtil.getParameter(request, prefix	+ "chk_cnt_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			String[] chkCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_cnt_cd", length));
			String[] chkLocCd = (JSPUtil.getParameter(request, prefix	+ "chk_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RestrictCmdtDupListVO();
				if (chkCntKnt[i] != null)
					model.setChkCntKnt(chkCntKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				if (chkCntCd[i] != null)
					model.setChkCntCd(chkCntCd[i]);
				if (chkLocCd[i] != null)
					model.setChkLocCd(chkLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRestrictCmdtDupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RestrictCmdtDupListVO[]
	 */
	public RestrictCmdtDupListVO[] getRestrictCmdtDupListVOs(){
		RestrictCmdtDupListVO[] vos = (RestrictCmdtDupListVO[])models.toArray(new RestrictCmdtDupListVO[models.size()]);
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
		this.chkCntKnt = this.chkCntKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCntCd = this.chkCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLocCd = this.chkLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
