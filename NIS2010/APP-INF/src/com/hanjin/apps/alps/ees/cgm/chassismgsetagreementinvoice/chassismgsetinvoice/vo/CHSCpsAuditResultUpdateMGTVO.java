/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSCpsAuditResultUpdateMGTVO.java
*@FileTitle : CHSCpsAuditResultUpdateMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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

public class CHSCpsAuditResultUpdateMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSCpsAuditResultUpdateMGTVO> models = new ArrayList<CHSCpsAuditResultUpdateMGTVO>();
	
	/* Column Info */
	private String delChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updtKey = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String reaudRslt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CHSCpsAuditResultUpdateMGTVO() {}

	public CHSCpsAuditResultUpdateMGTVO(String ibflag, String pagerows, String updtKey, String seq, String delChk, String reaudRslt) {
		this.delChk = delChk;
		this.ibflag = ibflag;
		this.updtKey = updtKey;
		this.seq = seq;
		this.reaudRslt = reaudRslt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("updt_key", getUpdtKey());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("reaud_rslt", getReaudRslt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updt_key", "updtKey");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("reaud_rslt", "reaudRslt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
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
	 * @return updtKey
	 */
	public String getUpdtKey() {
		return this.updtKey;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return reaudRslt
	 */
	public String getReaudRslt() {
		return this.reaudRslt;
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
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
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
	 * @param updtKey
	 */
	public void setUpdtKey(String updtKey) {
		this.updtKey = updtKey;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param reaudRslt
	 */
	public void setReaudRslt(String reaudRslt) {
		this.reaudRslt = reaudRslt;
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
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUpdtKey(JSPUtil.getParameter(request, prefix + "updt_key", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setReaudRslt(JSPUtil.getParameter(request, prefix + "reaud_rslt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSCpsAuditResultUpdateMGTVO[]
	 */
	public CHSCpsAuditResultUpdateMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSCpsAuditResultUpdateMGTVO[]
	 */
	public CHSCpsAuditResultUpdateMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSCpsAuditResultUpdateMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updtKey = (JSPUtil.getParameter(request, prefix	+ "updt_key", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] reaudRslt = (JSPUtil.getParameter(request, prefix	+ "reaud_rslt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSCpsAuditResultUpdateMGTVO();
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updtKey[i] != null)
					model.setUpdtKey(updtKey[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (reaudRslt[i] != null)
					model.setReaudRslt(reaudRslt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSCpsAuditResultUpdateMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSCpsAuditResultUpdateMGTVO[]
	 */
	public CHSCpsAuditResultUpdateMGTVO[] getCHSCpsAuditResultUpdateMGTVOs(){
		CHSCpsAuditResultUpdateMGTVO[] vos = (CHSCpsAuditResultUpdateMGTVO[])models.toArray(new CHSCpsAuditResultUpdateMGTVO[models.size()]);
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
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updtKey = this.updtKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaudRslt = this.reaudRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
