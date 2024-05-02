/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbInfoVO.java
*@FileTitle : TpbInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class TpbInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TpbInfoVO> models = new ArrayList<TpbInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String incurChgAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ntcSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String n3ptyBilYn = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String n3ptyBilNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String isSo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TpbInfoVO() {}

	public TpbInfoVO(String ibflag, String pagerows, String bkgNo, String ntcSeq, String cntrNo, String cnmvStsCd, String isSo, String n3ptyBilYn, String n3ptyBilNo, String incurChgAmt, String creUsrId, String creDt, String updUsrId, String updDt, String cntrTpszCd) {
		this.updDt = updDt;
		this.incurChgAmt = incurChgAmt;
		this.creDt = creDt;
		this.ntcSeq = ntcSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cnmvStsCd = cnmvStsCd;
		this.n3ptyBilYn = n3ptyBilYn;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.n3ptyBilNo = n3ptyBilNo;
		this.cntrTpszCd = cntrTpszCd;
		this.isSo = isSo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("incur_chg_amt", getIncurChgAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ntc_seq", getNtcSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("n3pty_bil_yn", getN3ptyBilYn());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("n3pty_bil_no", getN3ptyBilNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("is_so", getIsSo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("incur_chg_amt", "incurChgAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ntc_seq", "ntcSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("n3pty_bil_yn", "n3ptyBilYn");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("n3pty_bil_no", "n3ptyBilNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("is_so", "isSo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return incurChgAmt
	 */
	public String getIncurChgAmt() {
		return this.incurChgAmt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ntcSeq
	 */
	public String getNtcSeq() {
		return this.ntcSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilYn
	 */
	public String getN3ptyBilYn() {
		return this.n3ptyBilYn;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return n3ptyBilNo
	 */
	public String getN3ptyBilNo() {
		return this.n3ptyBilNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return isSo
	 */
	public String getIsSo() {
		return this.isSo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param incurChgAmt
	 */
	public void setIncurChgAmt(String incurChgAmt) {
		this.incurChgAmt = incurChgAmt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ntcSeq
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilYn
	 */
	public void setN3ptyBilYn(String n3ptyBilYn) {
		this.n3ptyBilYn = n3ptyBilYn;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param n3ptyBilNo
	 */
	public void setN3ptyBilNo(String n3ptyBilNo) {
		this.n3ptyBilNo = n3ptyBilNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param isSo
	 */
	public void setIsSo(String isSo) {
		this.isSo = isSo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIncurChgAmt(JSPUtil.getParameter(request, "incur_chg_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setNtcSeq(JSPUtil.getParameter(request, "ntc_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setN3ptyBilYn(JSPUtil.getParameter(request, "n3pty_bil_yn", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setN3ptyBilNo(JSPUtil.getParameter(request, "n3pty_bil_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setIsSo(JSPUtil.getParameter(request, "is_so", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TpbInfoVO[]
	 */
	public TpbInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TpbInfoVO[]
	 */
	public TpbInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TpbInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] incurChgAmt = (JSPUtil.getParameter(request, prefix	+ "incur_chg_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ntcSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] n3ptyBilYn = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_yn", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] n3ptyBilNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] isSo = (JSPUtil.getParameter(request, prefix	+ "is_so", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TpbInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (incurChgAmt[i] != null)
					model.setIncurChgAmt(incurChgAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ntcSeq[i] != null)
					model.setNtcSeq(ntcSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (n3ptyBilYn[i] != null)
					model.setN3ptyBilYn(n3ptyBilYn[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (n3ptyBilNo[i] != null)
					model.setN3ptyBilNo(n3ptyBilNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (isSo[i] != null)
					model.setIsSo(isSo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTpbInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TpbInfoVO[]
	 */
	public TpbInfoVO[] getTpbInfoVOs(){
		TpbInfoVO[] vos = (TpbInfoVO[])models.toArray(new TpbInfoVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurChgAmt = this.incurChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSeq = this.ntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilYn = this.n3ptyBilYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilNo = this.n3ptyBilNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isSo = this.isSo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
