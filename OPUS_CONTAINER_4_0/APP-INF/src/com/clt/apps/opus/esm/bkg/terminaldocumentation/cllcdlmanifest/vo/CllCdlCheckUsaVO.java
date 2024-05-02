/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CllCdlCheckUsaVO.java
*@FileTitle : CllCdlCheckUsaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.09
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class CllCdlCheckUsaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CllCdlCheckUsaVO> models = new ArrayList<CllCdlCheckUsaVO>();

	/* Column Info */
	private String fpod = null;
	/* Column Info */
	private String kind = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgQty1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgQty2 = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String match = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CllCdlCheckUsaVO() {}

	public CllCdlCheckUsaVO(String ibflag, String pagerows, String kind, String bkgNo, String pol, String pod, String bkgQty1, String bkgQty2, String fpod, String shprNm, String cntrNo, String cmdtNm, String special, String rnum, String match) {
		this.fpod = fpod;
		this.kind = kind;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.bkgQty1 = bkgQty1;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.bkgQty2 = bkgQty2;
		this.rnum = rnum;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.special = special;
		this.match = match;
		this.shprNm = shprNm;
		this.pod = pod;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fpod", getFpod());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_qty1", getBkgQty1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_qty2", getBkgQty2());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("match", getMatch());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fpod", "fpod");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_qty1", "bkgQty1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_qty2", "bkgQty2");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("special", "special");
		this.hashFields.put("match", "match");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return fpod
	 */
	public String getFpod() {
		return this.fpod;
	}

	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return bkgQty1
	 */
	public String getBkgQty1() {
		return this.bkgQty1;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return bkgQty2
	 */
	public String getBkgQty2() {
		return this.bkgQty2;
	}

	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}

	/**
	 * Column Info
	 * @return match
	 */
	public String getMatch() {
		return this.match;
	}

	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}

	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}


	/**
	 * Column Info
	 * @param fpod
	 */
	public void setFpod(String fpod) {
		this.fpod = fpod;
	}

	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param bkgQty1
	 */
	public void setBkgQty1(String bkgQty1) {
		this.bkgQty1 = bkgQty1;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param bkgQty2
	 */
	public void setBkgQty2(String bkgQty2) {
		this.bkgQty2 = bkgQty2;
	}

	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}

	/**
	 * Column Info
	 * @param match
	 */
	public void setMatch(String match) {
		this.match = match;
	}

	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}

	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFpod(JSPUtil.getParameter(request, "fpod", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgQty1(JSPUtil.getParameter(request, "bkg_qty1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgQty2(JSPUtil.getParameter(request, "bkg_qty2", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
		setMatch(JSPUtil.getParameter(request, "match", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlCheckUsaVO[]
	 */
	public CllCdlCheckUsaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CllCdlCheckUsaVO[]
	 */
	public CllCdlCheckUsaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlCheckUsaVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fpod = (JSPUtil.getParameter(request, prefix	+ "fpod", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgQty1 = (JSPUtil.getParameter(request, prefix	+ "bkg_qty1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgQty2 = (JSPUtil.getParameter(request, prefix	+ "bkg_qty2", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] match = (JSPUtil.getParameter(request, prefix	+ "match", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));

			for (int i = 0; i < length; i++) {
				model = new CllCdlCheckUsaVO();
				if (fpod[i] != null)
					model.setFpod(fpod[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgQty1[i] != null)
					model.setBkgQty1(bkgQty1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgQty2[i] != null)
					model.setBkgQty2(bkgQty2[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (match[i] != null)
					model.setMatch(match[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlCheckUsaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlCheckUsaVO[]
	 */
	public CllCdlCheckUsaVO[] getCllCdlCheckUsaVOs(){
		CllCdlCheckUsaVO[] vos = (CllCdlCheckUsaVO[])models.toArray(new CllCdlCheckUsaVO[models.size()]);
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
		this.fpod = this.fpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty1 = this.bkgQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty2 = this.bkgQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.match = this.match .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
