/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScNoteOutVO.java
*@FileTitle : ScNoteOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.29 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScNoteOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScNoteOutVO> models = new ArrayList<ScNoteOutVO>();
	
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effectDt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String expireDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScNoteOutVO() {}

	public ScNoteOutVO(String ibflag, String pagerows, String content, String title, String fromdate, String todate, String seq, String type, String effectDt, String expireDt) {
		this.content = content;
		this.title = title;
		this.ibflag = ibflag;
		this.effectDt = effectDt;
		this.seq = seq;
		this.fromdate = fromdate;
		this.todate = todate;
		this.type = type;
		this.expireDt = expireDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("effect_dt", getEffectDt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("expire_dt", getExpireDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("content", "content");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("effect_dt", "effectDt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("type", "type");
		this.hashFields.put("expire_dt", "expireDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return effectDt
	 */
	public String getEffectDt() {
		return this.effectDt;
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
	 * @return fromdate
	 */
	public String getFromdate() {
		return this.fromdate;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return expireDt
	 */
	public String getExpireDt() {
		return this.expireDt;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param effectDt
	 */
	public void setEffectDt(String effectDt) {
		this.effectDt = effectDt;
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
	 * @param fromdate
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param expireDt
	 */
	public void setExpireDt(String expireDt) {
		this.expireDt = expireDt;
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
		setContent(JSPUtil.getParameter(request, "content", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffectDt(JSPUtil.getParameter(request, "effect_dt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFromdate(JSPUtil.getParameter(request, "fromdate", ""));
		setTodate(JSPUtil.getParameter(request, "todate", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setExpireDt(JSPUtil.getParameter(request, "expire_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScNoteOutVO[]
	 */
	public ScNoteOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScNoteOutVO[]
	 */
	public ScNoteOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScNoteOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effectDt = (JSPUtil.getParameter(request, prefix	+ "effect_dt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] expireDt = (JSPUtil.getParameter(request, prefix	+ "expire_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScNoteOutVO();
				if (content[i] != null)
					model.setContent(content[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effectDt[i] != null)
					model.setEffectDt(effectDt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (expireDt[i] != null)
					model.setExpireDt(expireDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScNoteOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScNoteOutVO[]
	 */
	public ScNoteOutVO[] getScNoteOutVOs(){
		ScNoteOutVO[] vos = (ScNoteOutVO[])models.toArray(new ScNoteOutVO[models.size()]);
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
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effectDt = this.effectDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expireDt = this.expireDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
