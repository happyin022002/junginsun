/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GetMdmCustomerVO.java
*@FileTitle : GetMdmCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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

public class GetMdmCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<GetMdmCustomerVO> models = new ArrayList<GetMdmCustomerVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fincStsLvlCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public GetMdmCustomerVO() {}

	public GetMdmCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String fincStsLvlCd, String deltFlg, String custLglEngNm, String bzetAddr) {
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.bzetAddr = bzetAddr;
		this.custSeq = custSeq;
		this.fincStsLvlCd = fincStsLvlCd;
		this.custCntCd = custCntCd;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return fincStsLvlCd
	 */
	public String getFincStsLvlCd() {
		return this.fincStsLvlCd;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param fincStsLvlCd
	 */
	public void setFincStsLvlCd(String fincStsLvlCd) {
		this.fincStsLvlCd = fincStsLvlCd;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetMdmCustomerVO[]
	 */
	public GetMdmCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return GetMdmCustomerVO[]
	 */
	public GetMdmCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetMdmCustomerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix	+ "finc_sts_lvl_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new GetMdmCustomerVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fincStsLvlCd[i] != null)
					model.setFincStsLvlCd(fincStsLvlCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetMdmCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetMdmCustomerVO[]
	 */
	public GetMdmCustomerVO[] getGetMdmCustomerVOs(){
		GetMdmCustomerVO[] vos = (GetMdmCustomerVO[])models.toArray(new GetMdmCustomerVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincStsLvlCd = this.fincStsLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
