/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdAssignTargetVvdVO.java
*@FileTitle : VvdAssignTargetVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.20 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdAssignTargetVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdAssignTargetVvdVO> models = new ArrayList<VvdAssignTargetVvdVO>();
	
	/* Column Info */
	private String etb = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String fit20 = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String spcl = null;
	/* Column Info */
	private String fit40 = null;
	/* Column Info */
	private String nextPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdAssignTargetVvdVO() {}

	public VvdAssignTargetVvdVO(String ibflag, String pagerows, String nextPort, String fit20, String fit40, String nextVvd, String opCd, String etb, String etd, String spcl) {
		this.etb = etb;
		this.ibflag = ibflag;
		this.etd = etd;
		this.opCd = opCd;
		this.fit20 = fit20;
		this.nextVvd = nextVvd;
		this.spcl = spcl;
		this.fit40 = fit40;
		this.nextPort = nextPort;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("fit20", getFit20());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("spcl", getSpcl());
		this.hashColumns.put("fit40", getFit40());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("fit20", "fit20");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("spcl", "spcl");
		this.hashFields.put("fit40", "fit40");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return fit20
	 */
	public String getFit20() {
		return this.fit20;
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
	 * @return spcl
	 */
	public String getSpcl() {
		return this.spcl;
	}
	
	/**
	 * Column Info
	 * @return fit40
	 */
	public String getFit40() {
		return this.fit40;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
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
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param fit20
	 */
	public void setFit20(String fit20) {
		this.fit20 = fit20;
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
	 * @param spcl
	 */
	public void setSpcl(String spcl) {
		this.spcl = spcl;
	}
	
	/**
	 * Column Info
	 * @param fit40
	 */
	public void setFit40(String fit40) {
		this.fit40 = fit40;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
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
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setFit20(JSPUtil.getParameter(request, "fit20", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setSpcl(JSPUtil.getParameter(request, "spcl", ""));
		setFit40(JSPUtil.getParameter(request, "fit40", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdAssignTargetVvdVO[]
	 */
	public VvdAssignTargetVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdAssignTargetVvdVO[]
	 */
	public VvdAssignTargetVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdAssignTargetVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] fit20 = (JSPUtil.getParameter(request, prefix	+ "fit20", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] spcl = (JSPUtil.getParameter(request, prefix	+ "spcl", length));
			String[] fit40 = (JSPUtil.getParameter(request, prefix	+ "fit40", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdAssignTargetVvdVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (fit20[i] != null)
					model.setFit20(fit20[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (spcl[i] != null)
					model.setSpcl(spcl[i]);
				if (fit40[i] != null)
					model.setFit40(fit40[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdAssignTargetVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdAssignTargetVvdVO[]
	 */
	public VvdAssignTargetVvdVO[] getVvdAssignTargetVvdVOs(){
		VvdAssignTargetVvdVO[] vos = (VvdAssignTargetVvdVO[])models.toArray(new VvdAssignTargetVvdVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fit20 = this.fit20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcl = this.spcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fit40 = this.fit40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
