/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OldNewVvdVO.java
*@FileTitle : OldNewVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.30 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OldNewVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OldNewVvdVO> models = new ArrayList<OldNewVvdVO>();
	
	/* Column Info */
	private String newvvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldvvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oopCd = null;
	/* Column Info */
	private String relayTmnl = null;
	/* Column Info */
	private String relaySeq = null;
	/* Column Info */
	private String nextSeq = null;
	/* Column Info */
	private String nextTmnl = null;
	/* Column Info */
	private String oldNextVvd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OldNewVvdVO() {}

	public OldNewVvdVO(String ibflag, String pagerows, String oldvvd, String newvvd, String oopCd, String relayTmnl, String nextSeq, String nextTmnl, String oldNextVvd, String relaySeq) {
		this.newvvd = newvvd;
		this.ibflag = ibflag;
		this.oldvvd = oldvvd;
		this.oopCd = oopCd;
		this.relayTmnl = relayTmnl;
		this.nextSeq = nextSeq;
		this.pagerows = pagerows;
		this.nextTmnl = nextTmnl;
		this.oldNextVvd = oldNextVvd;
		this.relaySeq = relaySeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("newvvd", getNewvvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oldvvd", getOldvvd());
		this.hashColumns.put("oopCd", getOopCd());
		this.hashColumns.put("relayTmnl", getRelayTmnl());
		this.hashColumns.put("nextSeq", getNextSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nextTmnl", getNextTmnl());
		this.hashColumns.put("oldNextVvd", getOldNextVvd());
		this.hashColumns.put("relaySeq", getRelaySeq());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("newvvd", "newvvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oldvvd", "oldvvd");
		this.hashFields.put("oopCd", "oopCd");
		this.hashFields.put("relayTmnl", "relayTmnl");
		this.hashFields.put("nextSeq", "nextSeq");
		this.hashFields.put("nextTmnl", "nextTmnl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oldNextVvd", "oldNextVvd");
		this.hashFields.put("relaySeq", "relaySeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newvvd
	 */
	public String getNewvvd() {
		return this.newvvd;
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
	 * @return oldvvd
	 */
	public String getOldvvd() {
		return this.oldvvd;
	}

	/**
	 * Column Info
	 * @return oopCd
	 */
	public String getOopCd() {
		return this.oopCd;
	}
	
	/**
	 * Column Info
	 * @return relayTmnl
	 */
	public String getRelayTmnl() {
		return this.relayTmnl;
	}
	
	/**
	 * Column Info
	 * @return relaySeq
	 */
	public String getRelaySeq() {
		return this.relaySeq;
	}	
	
	/**
	 * Column Info
	 * @return nextTmnl
	 */
	public String getNextTmnl() {
		return this.nextTmnl;
	}
	
	
	
	/**
	 * Column Info
	 * @return nextSeq
	 */
	public String getNextSeq() {
		return this.nextSeq;
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
	 * @return oldNextVvd
	 */
	public String getOldNextVvd() {
		return this.oldNextVvd;
	}


	/**
	 * Column Info
	 * @param newvvd
	 */
	public void setNewvvd(String newvvd) {
		this.newvvd = newvvd;
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
	 * @param oldvvd
	 */
	public void setOldvvd(String oldvvd) {
		this.oldvvd = oldvvd;
	}
	
	/**
	 * Column Info
	 * @param oopCd
	 */
	public void setRelayTmnl(String relayTmnl) {
		this.relayTmnl = relayTmnl;
	}
	
	/**
	 * Column Info
	 * @param oopCd
	 */
	public void setOopCd(String oopCd) {
		this.oopCd = oopCd;
	}
	
	/**
	 * Column Info
	 * @param nextSeq
	 */
	public void setNextSeq(String nextSeq) {
		this.nextSeq = nextSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param oopCd
	 */
	public void setNextTmnl(String nextTmnl) {
		this.nextTmnl = nextTmnl;
	}
	/**
	 * Column Info
	 * @param oopCd
	 */
	public void setRelaySeq(String relaySeq) {
		this.relaySeq = relaySeq;
	}	
	/**
	 * Column Info
	 * @param oldNextVvd
	 */
	public void setOldNextVvd(String oldNextVvd) {
		this.oldNextVvd = oldNextVvd;
	}
	

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNewvvd(JSPUtil.getParameter(request, "newvvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOldvvd(JSPUtil.getParameter(request, "oldvvd", ""));
		setOopCd(JSPUtil.getParameter(request, "oopCd", ""));
		setRelayTmnl(JSPUtil.getParameter(request, "relayTmnl", ""));
		setNextSeq(JSPUtil.getParameter(request, "nextSeq", ""));
		setNextTmnl(JSPUtil.getParameter(request, "nextTmnl", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOldNextVvd(JSPUtil.getParameter(request, "oldNextVvd", ""));
		setRelaySeq(JSPUtil.getParameter(request, "relaySeq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OldNewVvdVO[]
	 */
	public OldNewVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OldNewVvdVO[]
	 */
	public OldNewVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OldNewVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newvvd = (JSPUtil.getParameter(request, prefix	+ "newvvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldvvd = (JSPUtil.getParameter(request, prefix	+ "oldvvd", length));
			String[] oopCd = (JSPUtil.getParameter(request, prefix	+ "oopCd", length));
			String[] relayTmnl = (JSPUtil.getParameter(request, prefix	+ "relayTmnl", length));
			String[] nextSeq = (JSPUtil.getParameter(request, prefix	+ "nextSeq", length));
			String[] nextTmnl = (JSPUtil.getParameter(request, prefix	+ "nextTmnl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldNextVvd = (JSPUtil.getParameter(request, prefix	+ "oldNextVvd", length));
			String[] relaySeq = (JSPUtil.getParameter(request, prefix	+ "relaySeq", length));
			
			for (int i = 0; i < length; i++) {
				model = new OldNewVvdVO();
				if (newvvd[i] != null)
					model.setNewvvd(newvvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldvvd[i] != null)
					model.setOldvvd(oldvvd[i]);
				if (oopCd[i] != null)
					model.setOopCd(oopCd[i]);
				if (relayTmnl[i] != null)
					model.setRelayTmnl(relayTmnl[i]);
				if (nextSeq[i] != null)
					model.setNextSeq(nextSeq[i]);
				if (nextTmnl[i] != null)
					model.setNextTmnl(nextTmnl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldNextVvd[i] != null)
					model.setOldNextVvd(oldNextVvd[i]);
				if (relaySeq[i] != null)
					model.setRelaySeq(relaySeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOldNewVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OldNewVvdVO[]
	 */
	public OldNewVvdVO[] getOldNewVvdVOs(){
		OldNewVvdVO[] vos = (OldNewVvdVO[])models.toArray(new OldNewVvdVO[models.size()]);
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
		this.newvvd = this.newvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldvvd = this.oldvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oopCd = this.oopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relayTmnl = this.relayTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSeq = this.nextSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTmnl = this.nextTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldNextVvd = this.oldNextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relaySeq = this.relaySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
