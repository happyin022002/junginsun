/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchNonTPBDescVO.java
*@FileTitle : SearchNonTPBDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo;

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

public class SearchNonTPBDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNonTPBDescVO> models = new ArrayList<SearchNonTPBDescVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String n3ptyNonCfmRsn = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String n3ptyNonCfmRsnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNonTPBDescVO() {}

	public SearchNonTPBDescVO(String ibflag, String pagerows, String otsDtlSeq, String n3ptyNonCfmRsnCd, String n3ptyNonCfmRsn, String userId) {
		this.ibflag = ibflag;
		this.userId = userId;
		this.n3ptyNonCfmRsn = n3ptyNonCfmRsn;
		this.otsDtlSeq = otsDtlSeq;
		this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("n3pty_non_cfm_rsn", getN3ptyNonCfmRsn());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("n3pty_non_cfm_rsn_cd", getN3ptyNonCfmRsnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("n3pty_non_cfm_rsn", "n3ptyNonCfmRsn");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("n3pty_non_cfm_rsn_cd", "n3ptyNonCfmRsnCd");
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNonCfmRsn
	 */
	public String getN3ptyNonCfmRsn() {
		return this.n3ptyNonCfmRsn;
	}
	
	/**
	 * Column Info
	 * @return otsDtlSeq
	 */
	public String getOtsDtlSeq() {
		return this.otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNonCfmRsnCd
	 */
	public String getN3ptyNonCfmRsnCd() {
		return this.n3ptyNonCfmRsnCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNonCfmRsn
	 */
	public void setN3ptyNonCfmRsn(String n3ptyNonCfmRsn) {
		this.n3ptyNonCfmRsn = n3ptyNonCfmRsn;
	}
	
	/**
	 * Column Info
	 * @param otsDtlSeq
	 */
	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNonCfmRsnCd
	 */
	public void setN3ptyNonCfmRsnCd(String n3ptyNonCfmRsnCd) {
		this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setN3ptyNonCfmRsn(JSPUtil.getParameter(request, prefix + "n3pty_non_cfm_rsn", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, prefix + "ots_dtl_seq", ""));
		setN3ptyNonCfmRsnCd(JSPUtil.getParameter(request, prefix + "n3pty_non_cfm_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNonTPBDescVO[]
	 */
	public SearchNonTPBDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNonTPBDescVO[]
	 */
	public SearchNonTPBDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNonTPBDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] n3ptyNonCfmRsn = (JSPUtil.getParameter(request, prefix	+ "n3pty_non_cfm_rsn", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] n3ptyNonCfmRsnCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_non_cfm_rsn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNonTPBDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (n3ptyNonCfmRsn[i] != null)
					model.setN3ptyNonCfmRsn(n3ptyNonCfmRsn[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (n3ptyNonCfmRsnCd[i] != null)
					model.setN3ptyNonCfmRsnCd(n3ptyNonCfmRsnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNonTPBDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNonTPBDescVO[]
	 */
	public SearchNonTPBDescVO[] getSearchNonTPBDescVOs(){
		SearchNonTPBDescVO[] vos = (SearchNonTPBDescVO[])models.toArray(new SearchNonTPBDescVO[models.size()]);
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
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNonCfmRsn = this.n3ptyNonCfmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNonCfmRsnCd = this.n3ptyNonCfmRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
