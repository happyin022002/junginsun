/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckReguPkgMzdVO.java
*@FileTitle : ScgPckReguPkgMzdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPckReguPkgMzdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckReguPkgMzdVO> models = new ArrayList<ScgPckReguPkgMzdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cmbPckMaxWgt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String refDivNo = null;
	/* Column Info */
	private String imdgPckMzdCd = null;
	/* Column Info */
	private String lqdMaxWgt = null;
	/* Column Info */
	private String reguDpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pckRefCd = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckReguPkgMzdVO() {}

	public ScgPckReguPkgMzdVO(String ibflag, String pagerows, String reguDpNo, String imdgPckInstrCd, String imdgPckInstrSeq, String subSeq, String cmbPckMaxWgt, String creDt, String creUsrId, String deltFlg, String imdgPckMzdCd, String lqdMaxWgt, String pckRefCd, String refDivNo, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.cmbPckMaxWgt = cmbPckMaxWgt;
		this.deltFlg = deltFlg;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.refDivNo = refDivNo;
		this.imdgPckMzdCd = imdgPckMzdCd;
		this.lqdMaxWgt = lqdMaxWgt;
		this.reguDpNo = reguDpNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.pckRefCd = pckRefCd;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.subSeq = subSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cmb_pck_max_wgt", getCmbPckMaxWgt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ref_div_no", getRefDivNo());
		this.hashColumns.put("imdg_pck_mzd_cd", getImdgPckMzdCd());
		this.hashColumns.put("lqd_max_wgt", getLqdMaxWgt());
		this.hashColumns.put("regu_dp_no", getReguDpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pck_ref_cd", getPckRefCd());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cmb_pck_max_wgt", "cmbPckMaxWgt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ref_div_no", "refDivNo");
		this.hashFields.put("imdg_pck_mzd_cd", "imdgPckMzdCd");
		this.hashFields.put("lqd_max_wgt", "lqdMaxWgt");
		this.hashFields.put("regu_dp_no", "reguDpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pck_ref_cd", "pckRefCd");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("sub_seq", "subSeq");
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
	 * @return cmbPckMaxWgt
	 */
	public String getCmbPckMaxWgt() {
		return this.cmbPckMaxWgt;
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
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @return refDivNo
	 */
	public String getRefDivNo() {
		return this.refDivNo;
	}
	
	/**
	 * Column Info
	 * @return imdgPckMzdCd
	 */
	public String getImdgPckMzdCd() {
		return this.imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @return lqdMaxWgt
	 */
	public String getLqdMaxWgt() {
		return this.lqdMaxWgt;
	}
	
	/**
	 * Column Info
	 * @return reguDpNo
	 */
	public String getReguDpNo() {
		return this.reguDpNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return pckRefCd
	 */
	public String getPckRefCd() {
		return this.pckRefCd;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
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
	 * @param cmbPckMaxWgt
	 */
	public void setCmbPckMaxWgt(String cmbPckMaxWgt) {
		this.cmbPckMaxWgt = cmbPckMaxWgt;
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
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
	 * @param refDivNo
	 */
	public void setRefDivNo(String refDivNo) {
		this.refDivNo = refDivNo;
	}
	
	/**
	 * Column Info
	 * @param imdgPckMzdCd
	 */
	public void setImdgPckMzdCd(String imdgPckMzdCd) {
		this.imdgPckMzdCd = imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @param lqdMaxWgt
	 */
	public void setLqdMaxWgt(String lqdMaxWgt) {
		this.lqdMaxWgt = lqdMaxWgt;
	}
	
	/**
	 * Column Info
	 * @param reguDpNo
	 */
	public void setReguDpNo(String reguDpNo) {
		this.reguDpNo = reguDpNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param pckRefCd
	 */
	public void setPckRefCd(String pckRefCd) {
		this.pckRefCd = pckRefCd;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
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
		setCmbPckMaxWgt(JSPUtil.getParameter(request, prefix + "cmb_pck_max_wgt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRefDivNo(JSPUtil.getParameter(request, prefix + "ref_div_no", ""));
		setImdgPckMzdCd(JSPUtil.getParameter(request, prefix + "imdg_pck_mzd_cd", ""));
		setLqdMaxWgt(JSPUtil.getParameter(request, prefix + "lqd_max_wgt", ""));
		setReguDpNo(JSPUtil.getParameter(request, prefix + "regu_dp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPckRefCd(JSPUtil.getParameter(request, prefix + "pck_ref_cd", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckReguPkgMzdVO[]
	 */
	public ScgPckReguPkgMzdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckReguPkgMzdVO[]
	 */
	public ScgPckReguPkgMzdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckReguPkgMzdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cmbPckMaxWgt = (JSPUtil.getParameter(request, prefix	+ "cmb_pck_max_wgt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] refDivNo = (JSPUtil.getParameter(request, prefix	+ "ref_div_no", length));
			String[] imdgPckMzdCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_mzd_cd", length));
			String[] lqdMaxWgt = (JSPUtil.getParameter(request, prefix	+ "lqd_max_wgt", length));
			String[] reguDpNo = (JSPUtil.getParameter(request, prefix	+ "regu_dp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pckRefCd = (JSPUtil.getParameter(request, prefix	+ "pck_ref_cd", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckReguPkgMzdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cmbPckMaxWgt[i] != null)
					model.setCmbPckMaxWgt(cmbPckMaxWgt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (refDivNo[i] != null)
					model.setRefDivNo(refDivNo[i]);
				if (imdgPckMzdCd[i] != null)
					model.setImdgPckMzdCd(imdgPckMzdCd[i]);
				if (lqdMaxWgt[i] != null)
					model.setLqdMaxWgt(lqdMaxWgt[i]);
				if (reguDpNo[i] != null)
					model.setReguDpNo(reguDpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pckRefCd[i] != null)
					model.setPckRefCd(pckRefCd[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckReguPkgMzdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckReguPkgMzdVO[]
	 */
	public ScgPckReguPkgMzdVO[] getScgPckReguPkgMzdVOs(){
		ScgPckReguPkgMzdVO[] vos = (ScgPckReguPkgMzdVO[])models.toArray(new ScgPckReguPkgMzdVO[models.size()]);
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
		this.cmbPckMaxWgt = this.cmbPckMaxWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDivNo = this.refDivNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckMzdCd = this.imdgPckMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lqdMaxWgt = this.lqdMaxWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguDpNo = this.reguDpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefCd = this.pckRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
