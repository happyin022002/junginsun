/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportItemVO.java
*@FileTitle : ReportItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.12.07 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

import java.lang.reflect.Field;
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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportItemVO> models = new ArrayList<ReportItemVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String itemNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ordSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sqlCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String tblNm = null;
	/* Column Info */
	private String bkgRptKndCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportItemVO() {}

	public ReportItemVO(String ibflag, String pagerows, String tblNm, String colNm, String itemNm, String rptId, String bkgRptKndCd, String ordSeq, String creUsrId, String creDt, String updUsrId, String updDt, String sqlCtnt) {
		this.updDt = updDt;
		this.colNm = colNm;
		this.itemNm = itemNm;
		this.creDt = creDt;
		this.ordSeq = ordSeq;
		this.pagerows = pagerows;
		this.sqlCtnt = sqlCtnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rptId = rptId;
		this.tblNm = tblNm;
		this.bkgRptKndCd = bkgRptKndCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("item_nm", getItemNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ord_seq", getOrdSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sql_ctnt", getSqlCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("tbl_nm", getTblNm());
		this.hashColumns.put("bkg_rpt_knd_cd", getBkgRptKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("item_nm", "itemNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ord_seq", "ordSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sql_ctnt", "sqlCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("tbl_nm", "tblNm");
		this.hashFields.put("bkg_rpt_knd_cd", "bkgRptKndCd");
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
	 * @return colNm
	 */
	public String getColNm() {
		return this.colNm;
	}
	
	/**
	 * Column Info
	 * @return itemNm
	 */
	public String getItemNm() {
		return this.itemNm;
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
	 * @return ordSeq
	 */
	public String getOrdSeq() {
		return this.ordSeq;
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
	 * @return sqlCtnt
	 */
	public String getSqlCtnt() {
		return this.sqlCtnt;
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
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
	}
	
	/**
	 * Column Info
	 * @return tblNm
	 */
	public String getTblNm() {
		return this.tblNm;
	}
	
	/**
	 * Column Info
	 * @return bkgRptKndCd
	 */
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
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
	 * @param colNm
	 */
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	
	/**
	 * Column Info
	 * @param itemNm
	 */
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
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
	 * @param ordSeq
	 */
	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
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
	 * @param sqlCtnt
	 */
	public void setSqlCtnt(String sqlCtnt) {
		this.sqlCtnt = sqlCtnt;
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
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	/**
	 * Column Info
	 * @param tblNm
	 */
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	
	/**
	 * Column Info
	 * @param bkgRptKndCd
	 */
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
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
		setColNm(JSPUtil.getParameter(request, "col_nm", ""));
		setItemNm(JSPUtil.getParameter(request, "item_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrdSeq(JSPUtil.getParameter(request, "ord_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSqlCtnt(JSPUtil.getParameter(request, "sql_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setTblNm(JSPUtil.getParameter(request, "tbl_nm", ""));
		setBkgRptKndCd(JSPUtil.getParameter(request, "bkg_rpt_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] colNm = (JSPUtil.getParameter(request, prefix	+ "col_nm", length));
			String[] itemNm = (JSPUtil.getParameter(request, prefix	+ "item_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ordSeq = (JSPUtil.getParameter(request, prefix	+ "ord_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sqlCtnt = (JSPUtil.getParameter(request, prefix	+ "sql_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id", length));
			String[] tblNm = (JSPUtil.getParameter(request, prefix	+ "tbl_nm", length));
			String[] bkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rpt_knd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportItemVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (itemNm[i] != null)
					model.setItemNm(itemNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ordSeq[i] != null)
					model.setOrdSeq(ordSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sqlCtnt[i] != null)
					model.setSqlCtnt(sqlCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (tblNm[i] != null)
					model.setTblNm(tblNm[i]);
				if (bkgRptKndCd[i] != null)
					model.setBkgRptKndCd(bkgRptKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportItemVO[]
	 */
	public ReportItemVO[] getReportItemVOs(){
		ReportItemVO[] vos = (ReportItemVO[])models.toArray(new ReportItemVO[models.size()]);
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
		this.colNm = this.colNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemNm = this.itemNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordSeq = this.ordSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqlCtnt = this.sqlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm = this.tblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRptKndCd = this.bkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
