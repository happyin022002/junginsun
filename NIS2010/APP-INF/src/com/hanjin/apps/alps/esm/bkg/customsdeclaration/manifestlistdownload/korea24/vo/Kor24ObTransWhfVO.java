/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ObTransWhfVO.java
*@FileTitle : Kor24ObTransWhfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.02 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24ObTransWhfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24ObTransWhfVO> models = new ArrayList<Kor24ObTransWhfVO>();

	/* Column Info */
	private String ktSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String transType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String transTypeChg = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String exptKcdTp = null;
	/* Column Info */
	private String ktPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24ObTransWhfVO() {}

	public Kor24ObTransWhfVO(String ibflag, String pagerows, String transType, String transTypeChg, String bkgNo, String ktPort, String ktSeq, String exptKcdTp, String kcdTp) {
		this.ktSeq = ktSeq;
		this.bkgNo = bkgNo;
		this.transType = transType;
		this.ibflag = ibflag;
		this.transTypeChg = transTypeChg;
		this.kcdTp = kcdTp;
		this.exptKcdTp = exptKcdTp;
		this.ktPort = ktPort;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trans_type", getTransType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trans_type_chg", getTransTypeChg());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kt_seq", "ktSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trans_type", "transType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trans_type_chg", "transTypeChg");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("expt_kcd_tp", "exptKcdTp");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ktSeq
	 */
	public String getKtSeq() {
		return this.ktSeq;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return transType
	 */
	public String getTransType() {
		return this.transType;
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
	 * @return transTypeChg
	 */
	public String getTransTypeChg() {
		return this.transTypeChg;
	}

	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
	}

	/**
	 * Column Info
	 * @return exptKcdTp
	 */
	public String getExptKcdTp() {
		return this.exptKcdTp;
	}

	/**
	 * Column Info
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
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
	 * @param ktSeq
	 */
	public void setKtSeq(String ktSeq) {
		this.ktSeq = ktSeq;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param transType
	 */
	public void setTransType(String transType) {
		this.transType = transType;
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
	 * @param transTypeChg
	 */
	public void setTransTypeChg(String transTypeChg) {
		this.transTypeChg = transTypeChg;
	}

	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
	}

	/**
	 * Column Info
	 * @param exptKcdTp
	 */
	public void setExptKcdTp(String exptKcdTp) {
		this.exptKcdTp = exptKcdTp;
	}

	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
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
		setKtSeq(JSPUtil.getParameter(request, "kt_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTransType(JSPUtil.getParameter(request, "trans_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTransTypeChg(JSPUtil.getParameter(request, "trans_type_chg", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
		setExptKcdTp(JSPUtil.getParameter(request, "expt_kcd_tp", ""));
		setKtPort(JSPUtil.getParameter(request, "kt_port", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24ObTransWhfVO[]
	 */
	public Kor24ObTransWhfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24ObTransWhfVO[]
	 */
	public Kor24ObTransWhfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24ObTransWhfVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] transType = (JSPUtil.getParameter(request, prefix	+ "trans_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] transTypeChg = (JSPUtil.getParameter(request, prefix	+ "trans_type_chg", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] exptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24ObTransWhfVO();
				if (ktSeq[i] != null)
					model.setKtSeq(ktSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (transType[i] != null)
					model.setTransType(transType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (transTypeChg[i] != null)
					model.setTransTypeChg(transTypeChg[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (exptKcdTp[i] != null)
					model.setExptKcdTp(exptKcdTp[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24ObTransWhfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24ObTransWhfVO[]
	 */
	public Kor24ObTransWhfVO[] getKor24ObTransWhfVOs(){
		Kor24ObTransWhfVO[] vos = (Kor24ObTransWhfVO[])models.toArray(new Kor24ObTransWhfVO[models.size()]);
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
		this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transType = this.transType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTypeChg = this.transTypeChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptKcdTp = this.exptKcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
