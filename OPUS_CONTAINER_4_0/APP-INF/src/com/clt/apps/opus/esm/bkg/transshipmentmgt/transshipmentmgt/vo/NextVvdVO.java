/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NextVvdVO.java
*@FileTitle : NextVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.18 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NextVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NextVvdVO> models = new ArrayList<NextVvdVO>();
	
	/* Column Info */
	private String eta = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String relayTmnl = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String nextTmnl = null;
	/* Column Info */
	private String nextSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NextVvdVO() {}

	public NextVvdVO(String ibflag, String pagerows, String nextVvd, String slanCd, String opCd, String etd, String eta, String relayTmnl, String nextTmnl, String nextSeq) {
		this.eta = eta;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.relayTmnl = relayTmnl;
		this.etd = etd;
		this.opCd = opCd;
		this.nextVvd = nextVvd;
		this.nextTmnl = nextTmnl;
		this.nextSeq = nextSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("relay_tmnl", getRelayTmnl());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("next_tmnl", getNextTmnl());
		this.hashColumns.put("next_seq", getNextSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("relay_tmnl", "relayTmnl");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("next_tmnl", "nextTmnl");
		this.hashFields.put("next_seq", "nextSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
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
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param relayTmnl
	 */
	public void setRelayTmnl(String relayTmnl) {
		this.relayTmnl = relayTmnl;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param nextTmnl
	 */
	public void setNextTmnl(String nextTmnl) {
		this.nextTmnl = nextTmnl;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRelayTmnl(JSPUtil.getParameter(request, "relay_tmnl", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setNextTmnl(JSPUtil.getParameter(request, "next_tmnl", ""));
		setNextSeq(JSPUtil.getParameter(request, "next_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NextVvdVO[]
	 */
	public NextVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NextVvdVO[]
	 */
	public NextVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NextVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] relayTmnl = (JSPUtil.getParameter(request, prefix	+ "relay_tmnl", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] nextTmnl = (JSPUtil.getParameter(request, prefix	+ "next_tmnl", length));
			String[] nextSeq = (JSPUtil.getParameter(request, prefix	+ "next_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NextVvdVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (relayTmnl[i] != null)
					model.setRelayTmnl(relayTmnl[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (nextTmnl[i] != null)
					model.setNextTmnl(nextTmnl[i]);
				if (nextSeq[i] != null)
					model.setNextSeq(nextSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNextVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NextVvdVO[]
	 */
	public NextVvdVO[] getNextVvdVOs(){
		NextVvdVO[] vos = (NextVvdVO[])models.toArray(new NextVvdVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relayTmnl = this.relayTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTmnl = this.nextTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSeq = this.nextSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
