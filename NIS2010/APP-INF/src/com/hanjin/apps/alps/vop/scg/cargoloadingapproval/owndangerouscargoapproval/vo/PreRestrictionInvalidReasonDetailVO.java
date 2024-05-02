/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PreRestrictionInvalidReasonDetailVO.java
*@FileTitle : PreRestrictionInvalidReasonDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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

public class PreRestrictionInvalidReasonDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionInvalidReasonDetailVO> models = new ArrayList<PreRestrictionInvalidReasonDetailVO>();
	
	/* Column Info */
	private String invldDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionInvalidReasonDetailVO() {}

	public PreRestrictionInvalidReasonDetailVO(String ibflag, String pagerows, String seq, String invldDesc) {
		this.invldDesc = invldDesc;
		this.ibflag = ibflag;
		this.seq = seq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("invld_desc", getInvldDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("invld_desc", "invldDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invldDesc
	 */
	public String getInvldDesc() {
		return this.invldDesc;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param invldDesc
	 */
	public void setInvldDesc(String invldDesc) {
		this.invldDesc = invldDesc;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setInvldDesc(JSPUtil.getParameter(request, prefix + "invld_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionInvalidReasonDetailVO[]
	 */
	public PreRestrictionInvalidReasonDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionInvalidReasonDetailVO[]
	 */
	public PreRestrictionInvalidReasonDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionInvalidReasonDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invldDesc = (JSPUtil.getParameter(request, prefix	+ "invld_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionInvalidReasonDetailVO();
				if (invldDesc[i] != null)
					model.setInvldDesc(invldDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionInvalidReasonDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionInvalidReasonDetailVO[]
	 */
	public PreRestrictionInvalidReasonDetailVO[] getPreRestrictionInvalidReasonDetailVOs(){
		PreRestrictionInvalidReasonDetailVO[] vos = (PreRestrictionInvalidReasonDetailVO[])models.toArray(new PreRestrictionInvalidReasonDetailVO[models.size()]);
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
		this.invldDesc = this.invldDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
