/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CtntInfoVO.java
*@FileTitle : CtntInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.25
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014.02.25 SHIN DONG IL 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnoticemail.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author SHIN DONG IL
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtntInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtntInfoVO> models = new ArrayList<CtntInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntcCnt = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String agmtTrspTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CtntInfoVO() {}

	public CtntInfoVO(String ibflag, String pagerows, String updDt, String agmtEffDt, String deltFlg, String agmtNo, String creUsrNm, String vndrNm, String agmtTrspTpCd, String creUsrId, String cntcCnt, String ctrtOfcCd, String vndrSeq, String agmtExpDt, String seq, String sysCd) {
		this.updDt = updDt;
		this.agmtEffDt = agmtEffDt;
		this.deltFlg = deltFlg;
		this.agmtNo = agmtNo;
		this.creUsrNm = creUsrNm;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntcCnt = cntcCnt;
		this.ctrtOfcCd = ctrtOfcCd;
		this.vndrSeq = vndrSeq;
		this.agmtExpDt = agmtExpDt;
		this.sysCd = sysCd;
		this.seq = seq;
		this.agmtTrspTpCd = agmtTrspTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntc_cnt", getCntcCnt());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntc_cnt", "cntcCnt");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
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
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntcCnt
	 */
	public String getCntcCnt() {
		return this.cntcCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
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
	 * @return agmtTrspTpCd
	 */
	public String getAgmtTrspTpCd() {
		return this.agmtTrspTpCd;
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
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntcCnt
	 */
	public void setCntcCnt(String cntcCnt) {
		this.cntcCnt = cntcCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
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
	 * @param agmtTrspTpCd
	 */
	public void setAgmtTrspTpCd(String agmtTrspTpCd) {
		this.agmtTrspTpCd = agmtTrspTpCd;
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
		setAgmtEffDt(JSPUtil.getParameter(request, prefix + "agmt_eff_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntcCnt(JSPUtil.getParameter(request, prefix + "cntc_cnt", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, prefix + "agmt_exp_dt", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtntInfoVO[]
	 */
	public CtntInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtntInfoVO[]
	 */
	public CtntInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtntInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntcCnt = (JSPUtil.getParameter(request, prefix	+ "cntc_cnt", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtntInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntcCnt[i] != null)
					model.setCntcCnt(cntcCnt[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtntInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtntInfoVO[]
	 */
	public CtntInfoVO[] getCtntInfoVOs(){
		CtntInfoVO[] vos = (CtntInfoVO[])models.toArray(new CtntInfoVO[models.size()]);
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
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcCnt = this.cntcCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
