/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorTransCrossChkDtlVO.java
*@FileTitle : KorTransCrossChkDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier :
*@LastVersion : 1.0
* 2011.03.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorTransCrossChkDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorTransCrossChkDtlVO> models = new ArrayList<KorTransCrossChkDtlVO>();

	/* Column Info */
	private String typeA = null;
	/* Column Info */
	private String picA = null;
	/* Column Info */
	private String picD = null;
	/* Column Info */
	private String typeD = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String typeB = null;
	/* Column Info */
	private String picB = null;
	/* Column Info */
	private String portDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etdaDt = null;
	/* Column Info */
	private String typeC = null;
	/* Column Info */
	private String picC = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String typeOth = null;
	/* Column Info */
	private String custOprCd = null;
	/* Column Info */
	private String picOth = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorTransCrossChkDtlVO() {}

	public KorTransCrossChkDtlVO(String ibflag, String pagerows, String slanCd, String vvd, String portCd, String etdaDt, String typeA, String picA, String typeB, String picB, String typeC, String picC, String typeD, String picD, String typeOth, String picOth, String crrCd, String custOprCd, String portDiv) {
		this.typeA = typeA;
		this.picA = picA;
		this.picD = picD;
		this.typeD = typeD;
		this.crrCd = crrCd;
		this.typeB = typeB;
		this.picB = picB;
		this.portDiv = portDiv;
		this.pagerows = pagerows;
		this.etdaDt = etdaDt;
		this.typeC = typeC;
		this.picC = picC;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.typeOth = typeOth;
		this.custOprCd = custOprCd;
		this.picOth = picOth;
		this.portCd = portCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("type_a", getTypeA());
		this.hashColumns.put("pic_a", getPicA());
		this.hashColumns.put("pic_d", getPicD());
		this.hashColumns.put("type_d", getTypeD());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("type_b", getTypeB());
		this.hashColumns.put("pic_b", getPicB());
		this.hashColumns.put("port_div", getPortDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("etda_dt", getEtdaDt());
		this.hashColumns.put("type_c", getTypeC());
		this.hashColumns.put("pic_c", getPicC());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("type_oth", getTypeOth());
		this.hashColumns.put("cust_opr_cd", getCustOprCd());
		this.hashColumns.put("pic_oth", getPicOth());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("type_a", "typeA");
		this.hashFields.put("pic_a", "picA");
		this.hashFields.put("pic_d", "picD");
		this.hashFields.put("type_d", "typeD");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("type_b", "typeB");
		this.hashFields.put("pic_b", "picB");
		this.hashFields.put("port_div", "portDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("etda_dt", "etdaDt");
		this.hashFields.put("type_c", "typeC");
		this.hashFields.put("pic_c", "picC");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("type_oth", "typeOth");
		this.hashFields.put("cust_opr_cd", "custOprCd");
		this.hashFields.put("pic_oth", "picOth");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return typeA
	 */
	public String getTypeA() {
		return this.typeA;
	}

	/**
	 * Column Info
	 * @return picA
	 */
	public String getPicA() {
		return this.picA;
	}

	/**
	 * Column Info
	 * @return picD
	 */
	public String getPicD() {
		return this.picD;
	}

	/**
	 * Column Info
	 * @return typeD
	 */
	public String getTypeD() {
		return this.typeD;
	}

	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}

	/**
	 * Column Info
	 * @return typeB
	 */
	public String getTypeB() {
		return this.typeB;
	}

	/**
	 * Column Info
	 * @return picB
	 */
	public String getPicB() {
		return this.picB;
	}

	/**
	 * Column Info
	 * @return portDiv
	 */
	public String getPortDiv() {
		return this.portDiv;
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
	 * @return etdaDt
	 */
	public String getEtdaDt() {
		return this.etdaDt;
	}

	/**
	 * Column Info
	 * @return typeC
	 */
	public String getTypeC() {
		return this.typeC;
	}

	/**
	 * Column Info
	 * @return picC
	 */
	public String getPicC() {
		return this.picC;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return typeOth
	 */
	public String getTypeOth() {
		return this.typeOth;
	}

	/**
	 * Column Info
	 * @return custOprCd
	 */
	public String getCustOprCd() {
		return this.custOprCd;
	}

	/**
	 * Column Info
	 * @return picOth
	 */
	public String getPicOth() {
		return this.picOth;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}


	/**
	 * Column Info
	 * @param typeA
	 */
	public void setTypeA(String typeA) {
		this.typeA = typeA;
	}

	/**
	 * Column Info
	 * @param picA
	 */
	public void setPicA(String picA) {
		this.picA = picA;
	}

	/**
	 * Column Info
	 * @param picD
	 */
	public void setPicD(String picD) {
		this.picD = picD;
	}

	/**
	 * Column Info
	 * @param typeD
	 */
	public void setTypeD(String typeD) {
		this.typeD = typeD;
	}

	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}

	/**
	 * Column Info
	 * @param typeB
	 */
	public void setTypeB(String typeB) {
		this.typeB = typeB;
	}

	/**
	 * Column Info
	 * @param picB
	 */
	public void setPicB(String picB) {
		this.picB = picB;
	}

	/**
	 * Column Info
	 * @param portDiv
	 */
	public void setPortDiv(String portDiv) {
		this.portDiv = portDiv;
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
	 * @param etdaDt
	 */
	public void setEtdaDt(String etdaDt) {
		this.etdaDt = etdaDt;
	}

	/**
	 * Column Info
	 * @param typeC
	 */
	public void setTypeC(String typeC) {
		this.typeC = typeC;
	}

	/**
	 * Column Info
	 * @param picC
	 */
	public void setPicC(String picC) {
		this.picC = picC;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param typeOth
	 */
	public void setTypeOth(String typeOth) {
		this.typeOth = typeOth;
	}

	/**
	 * Column Info
	 * @param custOprCd
	 */
	public void setCustOprCd(String custOprCd) {
		this.custOprCd = custOprCd;
	}

	/**
	 * Column Info
	 * @param picOth
	 */
	public void setPicOth(String picOth) {
		this.picOth = picOth;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setTypeA(JSPUtil.getParameter(request, prefix + "type_a", ""));
		setPicA(JSPUtil.getParameter(request, prefix + "pic_a", ""));
		setPicD(JSPUtil.getParameter(request, prefix + "pic_d", ""));
		setTypeD(JSPUtil.getParameter(request, prefix + "type_d", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setTypeB(JSPUtil.getParameter(request, prefix + "type_b", ""));
		setPicB(JSPUtil.getParameter(request, prefix + "pic_b", ""));
		setPortDiv(JSPUtil.getParameter(request, prefix + "port_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEtdaDt(JSPUtil.getParameter(request, prefix + "etda_dt", ""));
		setTypeC(JSPUtil.getParameter(request, prefix + "type_c", ""));
		setPicC(JSPUtil.getParameter(request, prefix + "pic_c", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTypeOth(JSPUtil.getParameter(request, prefix + "type_oth", ""));
		setCustOprCd(JSPUtil.getParameter(request, prefix + "cust_opr_cd", ""));
		setPicOth(JSPUtil.getParameter(request, prefix + "pic_oth", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransCrossChkDtlVO[]
	 */
	public KorTransCrossChkDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorTransCrossChkDtlVO[]
	 */
	public KorTransCrossChkDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorTransCrossChkDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] typeA = (JSPUtil.getParameter(request, prefix	+ "type_a", length));
			String[] picA = (JSPUtil.getParameter(request, prefix	+ "pic_a", length));
			String[] picD = (JSPUtil.getParameter(request, prefix	+ "pic_d", length));
			String[] typeD = (JSPUtil.getParameter(request, prefix	+ "type_d", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] typeB = (JSPUtil.getParameter(request, prefix	+ "type_b", length));
			String[] picB = (JSPUtil.getParameter(request, prefix	+ "pic_b", length));
			String[] portDiv = (JSPUtil.getParameter(request, prefix	+ "port_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etdaDt = (JSPUtil.getParameter(request, prefix	+ "etda_dt", length));
			String[] typeC = (JSPUtil.getParameter(request, prefix	+ "type_c", length));
			String[] picC = (JSPUtil.getParameter(request, prefix	+ "pic_c", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] typeOth = (JSPUtil.getParameter(request, prefix	+ "type_oth", length));
			String[] custOprCd = (JSPUtil.getParameter(request, prefix	+ "cust_opr_cd", length));
			String[] picOth = (JSPUtil.getParameter(request, prefix	+ "pic_oth", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));

			for (int i = 0; i < length; i++) {
				model = new KorTransCrossChkDtlVO();
				if (typeA[i] != null)
					model.setTypeA(typeA[i]);
				if (picA[i] != null)
					model.setPicA(picA[i]);
				if (picD[i] != null)
					model.setPicD(picD[i]);
				if (typeD[i] != null)
					model.setTypeD(typeD[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (typeB[i] != null)
					model.setTypeB(typeB[i]);
				if (picB[i] != null)
					model.setPicB(picB[i]);
				if (portDiv[i] != null)
					model.setPortDiv(portDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etdaDt[i] != null)
					model.setEtdaDt(etdaDt[i]);
				if (typeC[i] != null)
					model.setTypeC(typeC[i]);
				if (picC[i] != null)
					model.setPicC(picC[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (typeOth[i] != null)
					model.setTypeOth(typeOth[i]);
				if (custOprCd[i] != null)
					model.setCustOprCd(custOprCd[i]);
				if (picOth[i] != null)
					model.setPicOth(picOth[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorTransCrossChkDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransCrossChkDtlVO[]
	 */
	public KorTransCrossChkDtlVO[] getKorTransCrossChkDtlVOs(){
		KorTransCrossChkDtlVO[] vos = (KorTransCrossChkDtlVO[])models.toArray(new KorTransCrossChkDtlVO[models.size()]);
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
		this.typeA = this.typeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picA = this.picA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picD = this.picD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeD = this.typeD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeB = this.typeB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picB = this.picB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDiv = this.portDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdaDt = this.etdaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeC = this.typeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picC = this.picC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeOth = this.typeOth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custOprCd = this.custOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picOth = this.picOth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
