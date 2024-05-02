/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesTmlSoBbDtlVO.java
*@FileTitle : TesTmlSoBbDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.25
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.25 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesTmlSoBbDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesTmlSoBbDtlVO> models = new ArrayList<TesTmlSoBbDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bbCgoTpSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String bbCgoRmk = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesTmlSoBbDtlVO() {}

	public TesTmlSoBbDtlVO(String ibflag, String pagerows, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq, String bbCgoTpSeq, String lgsCostCd, String bkgNo, String invAmt, String bbCgoRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.bbCgoTpSeq = bbCgoTpSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.lgsCostCd = lgsCostCd;
		this.invAmt = invAmt;
		this.bbCgoRmk = bbCgoRmk;
		this.tmlSoSeq = tmlSoSeq;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bb_cgo_tp_seq", getBbCgoTpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("bb_cgo_rmk", getBbCgoRmk());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bb_cgo_tp_seq", "bbCgoTpSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("bb_cgo_rmk", "bbCgoRmk");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return bbCgoTpSeq
	 */
	public String getBbCgoTpSeq() {
		return this.bbCgoTpSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return bbCgoRmk
	 */
	public String getBbCgoRmk() {
		return this.bbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSoDtlSeq
	 */
	public String getTmlSoDtlSeq() {
		return this.tmlSoDtlSeq;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param bbCgoTpSeq
	 */
	public void setBbCgoTpSeq(String bbCgoTpSeq) {
		this.bbCgoTpSeq = bbCgoTpSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param bbCgoRmk
	 */
	public void setBbCgoRmk(String bbCgoRmk) {
		this.bbCgoRmk = bbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSoDtlSeq
	 */
	public void setTmlSoDtlSeq(String tmlSoDtlSeq) {
		this.tmlSoDtlSeq = tmlSoDtlSeq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBbCgoTpSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_tp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setBbCgoRmk(JSPUtil.getParameter(request, prefix + "bb_cgo_rmk", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesTmlSoBbDtlVO[]
	 */
	public TesTmlSoBbDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesTmlSoBbDtlVO[]
	 */
	public TesTmlSoBbDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesTmlSoBbDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bbCgoTpSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_tp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] bbCgoRmk = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_rmk", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesTmlSoBbDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bbCgoTpSeq[i] != null)
					model.setBbCgoTpSeq(bbCgoTpSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (bbCgoRmk[i] != null)
					model.setBbCgoRmk(bbCgoRmk[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesTmlSoBbDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesTmlSoBbDtlVO[]
	 */
	public TesTmlSoBbDtlVO[] getTesTmlSoBbDtlVOs(){
		TesTmlSoBbDtlVO[] vos = (TesTmlSoBbDtlVO[])models.toArray(new TesTmlSoBbDtlVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoTpSeq = this.bbCgoTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoRmk = this.bbCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
