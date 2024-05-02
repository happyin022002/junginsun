/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapDorStatusVO.java
*@FileTitle : JapDorStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.10.08 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class JapDorStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapDorStatusVO> models = new ArrayList<JapDorStatusVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jpDoId = null;
	/* Column Info */
	private String jpDoSndStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapDorStatusVO() {}

	public JapDorStatusVO(String ibflag, String pagerows, String jpDoSndStsCd, String jpDoId, String bkgNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.jpDoId = jpDoId;
		this.jpDoSndStsCd = jpDoSndStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jp_do_id", getJpDoId());
		this.hashColumns.put("jp_do_snd_sts_cd", getJpDoSndStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jp_do_id", "jpDoId");
		this.hashFields.put("jp_do_snd_sts_cd", "jpDoSndStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return jpDoId
	 */
	public String getJpDoId() {
		return this.jpDoId;
	}
	
	/**
	 * Column Info
	 * @return jpDoSndStsCd
	 */
	public String getJpDoSndStsCd() {
		return this.jpDoSndStsCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param jpDoId
	 */
	public void setJpDoId(String jpDoId) {
		this.jpDoId = jpDoId;
	}
	
	/**
	 * Column Info
	 * @param jpDoSndStsCd
	 */
	public void setJpDoSndStsCd(String jpDoSndStsCd) {
		this.jpDoSndStsCd = jpDoSndStsCd;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setJpDoId(JSPUtil.getParameter(request, "jp_do_id", ""));
		setJpDoSndStsCd(JSPUtil.getParameter(request, "jp_do_snd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapDorStatusVO[]
	 */
	public JapDorStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapDorStatusVO[]
	 */
	public JapDorStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapDorStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jpDoId = (JSPUtil.getParameter(request, prefix	+ "jp_do_id", length));
			String[] jpDoSndStsCd = (JSPUtil.getParameter(request, prefix	+ "jp_do_snd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapDorStatusVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jpDoId[i] != null)
					model.setJpDoId(jpDoId[i]);
				if (jpDoSndStsCd[i] != null)
					model.setJpDoSndStsCd(jpDoSndStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapDorStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapDorStatusVO[]
	 */
	public JapDorStatusVO[] getJapDorStatusVOs(){
		JapDorStatusVO[] vos = (JapDorStatusVO[])models.toArray(new JapDorStatusVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoId = this.jpDoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoSndStsCd = this.jpDoSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}