/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesTrfCondVO.java
*@FileTitle : TesTrfCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.11  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesTrfCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesTrfCondVO> models = new ArrayList<TesTrfCondVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String errRmk = null;
	/* Column Info */
	private String tmlAwkCgoCondTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String condSysDesc = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String condFxFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String condCreStsCd = null;
	/* Column Info */
	private String condCreTpCd = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String rowNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String condNm = null;
	/* Column Info */
	private String condDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesTrfCondVO() {}

	public TesTrfCondVO(String ibflag, String pagerows, String condNo, String condNm, String condDesc, String condSysDesc, String tmlAwkCgoCondTpCd, String condCreTpCd, String condCreStsCd, String condFxFlg, String rowNo, String deltFlg, String deltDt, String errRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.errRmk = errRmk;
		this.tmlAwkCgoCondTpCd = tmlAwkCgoCondTpCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.condSysDesc = condSysDesc;
		this.deltDt = deltDt;
		this.condFxFlg = condFxFlg;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.condCreStsCd = condCreStsCd;
		this.condCreTpCd = condCreTpCd;
		this.condNo = condNo;
		this.rowNo = rowNo;
		this.updUsrId = updUsrId;
		this.condNm = condNm;
		this.condDesc = condDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("err_rmk", getErrRmk());
		this.hashColumns.put("tml_awk_cgo_cond_tp_cd", getTmlAwkCgoCondTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cond_sys_desc", getCondSysDesc());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("cond_fx_flg", getCondFxFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cond_cre_sts_cd", getCondCreStsCd());
		this.hashColumns.put("cond_cre_tp_cd", getCondCreTpCd());
		this.hashColumns.put("cond_no", getCondNo());
		this.hashColumns.put("row_no", getRowNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cond_nm", getCondNm());
		this.hashColumns.put("cond_desc", getCondDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("err_rmk", "errRmk");
		this.hashFields.put("tml_awk_cgo_cond_tp_cd", "tmlAwkCgoCondTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cond_sys_desc", "condSysDesc");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("cond_fx_flg", "condFxFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cond_cre_sts_cd", "condCreStsCd");
		this.hashFields.put("cond_cre_tp_cd", "condCreTpCd");
		this.hashFields.put("cond_no", "condNo");
		this.hashFields.put("row_no", "rowNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cond_nm", "condNm");
		this.hashFields.put("cond_desc", "condDesc");
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
	 * @return errRmk
	 */
	public String getErrRmk() {
		return this.errRmk;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkCgoCondTpCd
	 */
	public String getTmlAwkCgoCondTpCd() {
		return this.tmlAwkCgoCondTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return condSysDesc
	 */
	public String getCondSysDesc() {
		return this.condSysDesc;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return condFxFlg
	 */
	public String getCondFxFlg() {
		return this.condFxFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return condCreStsCd
	 */
	public String getCondCreStsCd() {
		return this.condCreStsCd;
	}
	
	/**
	 * Column Info
	 * @return condCreTpCd
	 */
	public String getCondCreTpCd() {
		return this.condCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
	}
	
	/**
	 * Column Info
	 * @return rowNo
	 */
	public String getRowNo() {
		return this.rowNo;
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
	 * @return condNm
	 */
	public String getCondNm() {
		return this.condNm;
	}
	
	/**
	 * Column Info
	 * @return condDesc
	 */
	public String getCondDesc() {
		return this.condDesc;
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
	 * @param errRmk
	 */
	public void setErrRmk(String errRmk) {
		this.errRmk = errRmk;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkCgoCondTpCd
	 */
	public void setTmlAwkCgoCondTpCd(String tmlAwkCgoCondTpCd) {
		this.tmlAwkCgoCondTpCd = tmlAwkCgoCondTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param condSysDesc
	 */
	public void setCondSysDesc(String condSysDesc) {
		this.condSysDesc = condSysDesc;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param condFxFlg
	 */
	public void setCondFxFlg(String condFxFlg) {
		this.condFxFlg = condFxFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param condCreStsCd
	 */
	public void setCondCreStsCd(String condCreStsCd) {
		this.condCreStsCd = condCreStsCd;
	}
	
	/**
	 * Column Info
	 * @param condCreTpCd
	 */
	public void setCondCreTpCd(String condCreTpCd) {
		this.condCreTpCd = condCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
	}
	
	/**
	 * Column Info
	 * @param rowNo
	 */
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param condNm
	 */
	public void setCondNm(String condNm) {
		this.condNm = condNm;
	}
	
	/**
	 * Column Info
	 * @param condDesc
	 */
	public void setCondDesc(String condDesc) {
		this.condDesc = condDesc;
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
		setErrRmk(JSPUtil.getParameter(request, prefix + "err_rmk", ""));
		setTmlAwkCgoCondTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_cond_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCondSysDesc(JSPUtil.getParameter(request, prefix + "cond_sys_desc", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setCondFxFlg(JSPUtil.getParameter(request, prefix + "cond_fx_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCondCreStsCd(JSPUtil.getParameter(request, prefix + "cond_cre_sts_cd", ""));
		setCondCreTpCd(JSPUtil.getParameter(request, prefix + "cond_cre_tp_cd", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setRowNo(JSPUtil.getParameter(request, prefix + "row_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCondNm(JSPUtil.getParameter(request, prefix + "cond_nm", ""));
		setCondDesc(JSPUtil.getParameter(request, prefix + "cond_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesTrfCondVO[]
	 */
	public TesTrfCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesTrfCondVO[]
	 */
	public TesTrfCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesTrfCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] errRmk = (JSPUtil.getParameter(request, prefix	+ "err_rmk", length));
			String[] tmlAwkCgoCondTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_cond_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] condSysDesc = (JSPUtil.getParameter(request, prefix	+ "cond_sys_desc", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] condFxFlg = (JSPUtil.getParameter(request, prefix	+ "cond_fx_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] condCreStsCd = (JSPUtil.getParameter(request, prefix	+ "cond_cre_sts_cd", length));
			String[] condCreTpCd = (JSPUtil.getParameter(request, prefix	+ "cond_cre_tp_cd", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] rowNo = (JSPUtil.getParameter(request, prefix	+ "row_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] condNm = (JSPUtil.getParameter(request, prefix	+ "cond_nm", length));
			String[] condDesc = (JSPUtil.getParameter(request, prefix	+ "cond_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesTrfCondVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (errRmk[i] != null)
					model.setErrRmk(errRmk[i]);
				if (tmlAwkCgoCondTpCd[i] != null)
					model.setTmlAwkCgoCondTpCd(tmlAwkCgoCondTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (condSysDesc[i] != null)
					model.setCondSysDesc(condSysDesc[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (condFxFlg[i] != null)
					model.setCondFxFlg(condFxFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (condCreStsCd[i] != null)
					model.setCondCreStsCd(condCreStsCd[i]);
				if (condCreTpCd[i] != null)
					model.setCondCreTpCd(condCreTpCd[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (rowNo[i] != null)
					model.setRowNo(rowNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (condNm[i] != null)
					model.setCondNm(condNm[i]);
				if (condDesc[i] != null)
					model.setCondDesc(condDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesTrfCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesTrfCondVO[]
	 */
	public TesTrfCondVO[] getTesTrfCondVOs(){
		TesTrfCondVO[] vos = (TesTrfCondVO[])models.toArray(new TesTrfCondVO[models.size()]);
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
		this.errRmk = this.errRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoCondTpCd = this.tmlAwkCgoCondTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condSysDesc = this.condSysDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condFxFlg = this.condFxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condCreStsCd = this.condCreStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condCreTpCd = this.condCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNo = this.rowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNm = this.condNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condDesc = this.condDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
