/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckReguPkgCdVO.java
*@FileTitle : ScgPckReguPkgCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;


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

public class ScgPckReguPkgCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckReguPkgCdVO> models = new ArrayList<ScgPckReguPkgCdVO>();
	
	/* Column Info */
	private String pkgNm = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String pkgCd = null;
	/* Column Info */
	private String fPckCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String outPkgQty = null;
	/* Column Info */
	private String pckCdSeq = null;
	/* Column Info */
	private String inPkgQty = null;
	/* Column Info */
	private String pkgTpCd = null;
	/* Column Info */
	private String inPkgMeasUt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String fPckCdSeq = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String chkPckCd = null;
	/* Column Info */
	private String outPkgMeasUt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckReguPkgCdVO() {}

	public ScgPckReguPkgCdVO(String ibflag, String pagerows, String pckCd, String pckCdSeq, String dispNo, String seq, String pkgTpCd, String pkgCd, String pkgNm, String inPkgQty, String inPkgMeasUt, String outPkgQty, String outPkgMeasUt, String deltFlg, String userId, String fPckCd, String fPckCdSeq, String chkPckCd) {
		this.pkgNm = pkgNm;
		this.dispNo = dispNo;
		this.pkgCd = pkgCd;
		this.fPckCd = fPckCd;
		this.deltFlg = deltFlg;
		this.outPkgQty = outPkgQty;
		this.pckCdSeq = pckCdSeq;
		this.inPkgQty = inPkgQty;
		this.pkgTpCd = pkgTpCd;
		this.inPkgMeasUt = inPkgMeasUt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pckCd = pckCd;
		this.userId = userId;
		this.fPckCdSeq = fPckCdSeq;
		this.seq = seq;
		this.chkPckCd = chkPckCd;
		this.outPkgMeasUt = outPkgMeasUt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkg_nm", getPkgNm());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("pkg_cd", getPkgCd());
		this.hashColumns.put("f_pck_cd", getFPckCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("out_pkg_qty", getOutPkgQty());
		this.hashColumns.put("pck_cd_seq", getPckCdSeq());
		this.hashColumns.put("in_pkg_qty", getInPkgQty());
		this.hashColumns.put("pkg_tp_cd", getPkgTpCd());
		this.hashColumns.put("in_pkg_meas_ut", getInPkgMeasUt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_cd", getPckCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("f_pck_cd_seq", getFPckCdSeq());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("chk_pck_cd", getChkPckCd());
		this.hashColumns.put("out_pkg_meas_ut", getOutPkgMeasUt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkg_nm", "pkgNm");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("pkg_cd", "pkgCd");
		this.hashFields.put("f_pck_cd", "fPckCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("out_pkg_qty", "outPkgQty");
		this.hashFields.put("pck_cd_seq", "pckCdSeq");
		this.hashFields.put("in_pkg_qty", "inPkgQty");
		this.hashFields.put("pkg_tp_cd", "pkgTpCd");
		this.hashFields.put("in_pkg_meas_ut", "inPkgMeasUt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_cd", "pckCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("f_pck_cd_seq", "fPckCdSeq");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("chk_pck_cd", "chkPckCd");
		this.hashFields.put("out_pkg_meas_ut", "outPkgMeasUt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pkgNm
	 */
	public String getPkgNm() {
		return this.pkgNm;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return pkgCd
	 */
	public String getPkgCd() {
		return this.pkgCd;
	}
	
	/**
	 * Column Info
	 * @return fPckCd
	 */
	public String getFPckCd() {
		return this.fPckCd;
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
	 * @return outPkgQty
	 */
	public String getOutPkgQty() {
		return this.outPkgQty;
	}
	
	/**
	 * Column Info
	 * @return pckCdSeq
	 */
	public String getPckCdSeq() {
		return this.pckCdSeq;
	}
	
	/**
	 * Column Info
	 * @return inPkgQty
	 */
	public String getInPkgQty() {
		return this.inPkgQty;
	}
	
	/**
	 * Column Info
	 * @return pkgTpCd
	 */
	public String getPkgTpCd() {
		return this.pkgTpCd;
	}
	
	/**
	 * Column Info
	 * @return inPkgMeasUt
	 */
	public String getInPkgMeasUt() {
		return this.inPkgMeasUt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return pckCd
	 */
	public String getPckCd() {
		return this.pckCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return fPckCdSeq
	 */
	public String getFPckCdSeq() {
		return this.fPckCdSeq;
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
	 * @return chkPckCd
	 */
	public String getChkPckCd() {
		return this.chkPckCd;
	}
	
	/**
	 * Column Info
	 * @return outPkgMeasUt
	 */
	public String getOutPkgMeasUt() {
		return this.outPkgMeasUt;
	}
	

	/**
	 * Column Info
	 * @param pkgNm
	 */
	public void setPkgNm(String pkgNm) {
		this.pkgNm = pkgNm;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param pkgCd
	 */
	public void setPkgCd(String pkgCd) {
		this.pkgCd = pkgCd;
	}
	
	/**
	 * Column Info
	 * @param fPckCd
	 */
	public void setFPckCd(String fPckCd) {
		this.fPckCd = fPckCd;
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
	 * @param outPkgQty
	 */
	public void setOutPkgQty(String outPkgQty) {
		this.outPkgQty = outPkgQty;
	}
	
	/**
	 * Column Info
	 * @param pckCdSeq
	 */
	public void setPckCdSeq(String pckCdSeq) {
		this.pckCdSeq = pckCdSeq;
	}
	
	/**
	 * Column Info
	 * @param inPkgQty
	 */
	public void setInPkgQty(String inPkgQty) {
		this.inPkgQty = inPkgQty;
	}
	
	/**
	 * Column Info
	 * @param pkgTpCd
	 */
	public void setPkgTpCd(String pkgTpCd) {
		this.pkgTpCd = pkgTpCd;
	}
	
	/**
	 * Column Info
	 * @param inPkgMeasUt
	 */
	public void setInPkgMeasUt(String inPkgMeasUt) {
		this.inPkgMeasUt = inPkgMeasUt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param pckCd
	 */
	public void setPckCd(String pckCd) {
		this.pckCd = pckCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param fPckCdSeq
	 */
	public void setFPckCdSeq(String fPckCdSeq) {
		this.fPckCdSeq = fPckCdSeq;
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
	 * @param chkPckCd
	 */
	public void setChkPckCd(String chkPckCd) {
		this.chkPckCd = chkPckCd;
	}
	
	/**
	 * Column Info
	 * @param outPkgMeasUt
	 */
	public void setOutPkgMeasUt(String outPkgMeasUt) {
		this.outPkgMeasUt = outPkgMeasUt;
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
		setPkgNm(JSPUtil.getParameter(request, prefix + "pkg_nm", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setPkgCd(JSPUtil.getParameter(request, prefix + "pkg_cd", ""));
		setFPckCd(JSPUtil.getParameter(request, prefix + "f_pck_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOutPkgQty(JSPUtil.getParameter(request, prefix + "out_pkg_qty", ""));
		setPckCdSeq(JSPUtil.getParameter(request, prefix + "pck_cd_seq", ""));
		setInPkgQty(JSPUtil.getParameter(request, prefix + "in_pkg_qty", ""));
		setPkgTpCd(JSPUtil.getParameter(request, prefix + "pkg_tp_cd", ""));
		setInPkgMeasUt(JSPUtil.getParameter(request, prefix + "in_pkg_meas_ut", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckCd(JSPUtil.getParameter(request, prefix + "pck_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setFPckCdSeq(JSPUtil.getParameter(request, prefix + "f_pck_cd_seq", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setChkPckCd(JSPUtil.getParameter(request, prefix + "chk_pck_cd", ""));
		setOutPkgMeasUt(JSPUtil.getParameter(request, prefix + "out_pkg_meas_ut", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckReguPkgCdVO[]
	 */
	public ScgPckReguPkgCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckReguPkgCdVO[]
	 */
	public ScgPckReguPkgCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckReguPkgCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkgNm = (JSPUtil.getParameter(request, prefix	+ "pkg_nm", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] pkgCd = (JSPUtil.getParameter(request, prefix	+ "pkg_cd", length));
			String[] fPckCd = (JSPUtil.getParameter(request, prefix	+ "f_pck_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] outPkgQty = (JSPUtil.getParameter(request, prefix	+ "out_pkg_qty", length));
			String[] pckCdSeq = (JSPUtil.getParameter(request, prefix	+ "pck_cd_seq", length));
			String[] inPkgQty = (JSPUtil.getParameter(request, prefix	+ "in_pkg_qty", length));
			String[] pkgTpCd = (JSPUtil.getParameter(request, prefix	+ "pkg_tp_cd", length));
			String[] inPkgMeasUt = (JSPUtil.getParameter(request, prefix	+ "in_pkg_meas_ut", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckCd = (JSPUtil.getParameter(request, prefix	+ "pck_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] fPckCdSeq = (JSPUtil.getParameter(request, prefix	+ "f_pck_cd_seq", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] chkPckCd = (JSPUtil.getParameter(request, prefix	+ "chk_pck_cd", length));
			String[] outPkgMeasUt = (JSPUtil.getParameter(request, prefix	+ "out_pkg_meas_ut", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckReguPkgCdVO();
				if (pkgNm[i] != null)
					model.setPkgNm(pkgNm[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (pkgCd[i] != null)
					model.setPkgCd(pkgCd[i]);
				if (fPckCd[i] != null)
					model.setFPckCd(fPckCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (outPkgQty[i] != null)
					model.setOutPkgQty(outPkgQty[i]);
				if (pckCdSeq[i] != null)
					model.setPckCdSeq(pckCdSeq[i]);
				if (inPkgQty[i] != null)
					model.setInPkgQty(inPkgQty[i]);
				if (pkgTpCd[i] != null)
					model.setPkgTpCd(pkgTpCd[i]);
				if (inPkgMeasUt[i] != null)
					model.setInPkgMeasUt(inPkgMeasUt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckCd[i] != null)
					model.setPckCd(pckCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (fPckCdSeq[i] != null)
					model.setFPckCdSeq(fPckCdSeq[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (chkPckCd[i] != null)
					model.setChkPckCd(chkPckCd[i]);
				if (outPkgMeasUt[i] != null)
					model.setOutPkgMeasUt(outPkgMeasUt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckReguPkgCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckReguPkgCdVO[]
	 */
	public ScgPckReguPkgCdVO[] getScgPckReguPkgCdVOs(){
		ScgPckReguPkgCdVO[] vos = (ScgPckReguPkgCdVO[])models.toArray(new ScgPckReguPkgCdVO[models.size()]);
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
		this.pkgNm = this.pkgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCd = this.pkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPckCd = this.fPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outPkgQty = this.outPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCdSeq = this.pckCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPkgQty = this.inPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgTpCd = this.pkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPkgMeasUt = this.inPkgMeasUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCd = this.pckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPckCdSeq = this.fPckCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPckCd = this.chkPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outPkgMeasUt = this.outPkgMeasUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
