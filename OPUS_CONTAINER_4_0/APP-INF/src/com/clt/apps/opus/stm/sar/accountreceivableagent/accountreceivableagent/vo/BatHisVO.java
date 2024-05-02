/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BatHisVO.java
*@FileTitle : BatHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BatHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BatHisVO> models = new ArrayList<BatHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pgmSubSysCd = null;
	/* Column Info */
	private String applPgmNo = null;
	/* Column Info */
	private String batParaCtnt = null;
	/* Column Info */
	private String batStDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String batRsltCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String batPgmNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String batSeq = null;
	/* Column Info */
	private String batRsltDesc = null;
	/* Column Info */
	private String batEndDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BatHisVO() {}

	public BatHisVO(String ibflag, String pagerows, String batSeq, String pgmSubSysCd, String batPgmNo, String applPgmNo, String batParaCtnt, String batStDt, String batEndDt, String batRsltCd, String batRsltDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.pgmSubSysCd = pgmSubSysCd;
		this.applPgmNo = applPgmNo;
		this.batParaCtnt = batParaCtnt;
		this.batStDt = batStDt;
		this.creDt = creDt;
		this.batRsltCd = batRsltCd;
		this.pagerows = pagerows;
		this.batPgmNo = batPgmNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.batSeq = batSeq;
		this.batRsltDesc = batRsltDesc;
		this.batEndDt = batEndDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pgm_sub_sys_cd", getPgmSubSysCd());
		this.hashColumns.put("appl_pgm_no", getApplPgmNo());
		this.hashColumns.put("bat_para_ctnt", getBatParaCtnt());
		this.hashColumns.put("bat_st_dt", getBatStDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bat_rslt_cd", getBatRsltCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bat_pgm_no", getBatPgmNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bat_seq", getBatSeq());
		this.hashColumns.put("bat_rslt_desc", getBatRsltDesc());
		this.hashColumns.put("bat_end_dt", getBatEndDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pgm_sub_sys_cd", "pgmSubSysCd");
		this.hashFields.put("appl_pgm_no", "applPgmNo");
		this.hashFields.put("bat_para_ctnt", "batParaCtnt");
		this.hashFields.put("bat_st_dt", "batStDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bat_rslt_cd", "batRsltCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bat_pgm_no", "batPgmNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bat_seq", "batSeq");
		this.hashFields.put("bat_rslt_desc", "batRsltDesc");
		this.hashFields.put("bat_end_dt", "batEndDt");
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
	 * @return pgmSubSysCd
	 */
	public String getPgmSubSysCd() {
		return this.pgmSubSysCd;
	}
	
	/**
	 * Column Info
	 * @return applPgmNo
	 */
	public String getApplPgmNo() {
		return this.applPgmNo;
	}
	
	/**
	 * Column Info
	 * @return batParaCtnt
	 */
	public String getBatParaCtnt() {
		return this.batParaCtnt;
	}
	
	/**
	 * Column Info
	 * @return batStDt
	 */
	public String getBatStDt() {
		return this.batStDt;
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
	 * @return batRsltCd
	 */
	public String getBatRsltCd() {
		return this.batRsltCd;
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
	 * @return batPgmNo
	 */
	public String getBatPgmNo() {
		return this.batPgmNo;
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
	 * @return batSeq
	 */
	public String getBatSeq() {
		return this.batSeq;
	}
	
	/**
	 * Column Info
	 * @return batRsltDesc
	 */
	public String getBatRsltDesc() {
		return this.batRsltDesc;
	}
	
	/**
	 * Column Info
	 * @return batEndDt
	 */
	public String getBatEndDt() {
		return this.batEndDt;
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
	 * @param pgmSubSysCd
	 */
	public void setPgmSubSysCd(String pgmSubSysCd) {
		this.pgmSubSysCd = pgmSubSysCd;
	}
	
	/**
	 * Column Info
	 * @param applPgmNo
	 */
	public void setApplPgmNo(String applPgmNo) {
		this.applPgmNo = applPgmNo;
	}
	
	/**
	 * Column Info
	 * @param batParaCtnt
	 */
	public void setBatParaCtnt(String batParaCtnt) {
		this.batParaCtnt = batParaCtnt;
	}
	
	/**
	 * Column Info
	 * @param batStDt
	 */
	public void setBatStDt(String batStDt) {
		this.batStDt = batStDt;
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
	 * @param batRsltCd
	 */
	public void setBatRsltCd(String batRsltCd) {
		this.batRsltCd = batRsltCd;
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
	 * @param batPgmNo
	 */
	public void setBatPgmNo(String batPgmNo) {
		this.batPgmNo = batPgmNo;
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
	 * @param batSeq
	 */
	public void setBatSeq(String batSeq) {
		this.batSeq = batSeq;
	}
	
	/**
	 * Column Info
	 * @param batRsltDesc
	 */
	public void setBatRsltDesc(String batRsltDesc) {
		this.batRsltDesc = batRsltDesc;
	}
	
	/**
	 * Column Info
	 * @param batEndDt
	 */
	public void setBatEndDt(String batEndDt) {
		this.batEndDt = batEndDt;
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
		setPgmSubSysCd(JSPUtil.getParameter(request, prefix + "pgm_sub_sys_cd", ""));
		setApplPgmNo(JSPUtil.getParameter(request, prefix + "appl_pgm_no", ""));
		setBatParaCtnt(JSPUtil.getParameter(request, prefix + "bat_para_ctnt", ""));
		setBatStDt(JSPUtil.getParameter(request, prefix + "bat_st_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBatRsltCd(JSPUtil.getParameter(request, prefix + "bat_rslt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBatPgmNo(JSPUtil.getParameter(request, prefix + "bat_pgm_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBatSeq(JSPUtil.getParameter(request, prefix + "bat_seq", ""));
		setBatRsltDesc(JSPUtil.getParameter(request, prefix + "bat_rslt_desc", ""));
		setBatEndDt(JSPUtil.getParameter(request, prefix + "bat_end_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BatHisVO[]
	 */
	public BatHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BatHisVO[]
	 */
	public BatHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BatHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pgmSubSysCd = (JSPUtil.getParameter(request, prefix	+ "pgm_sub_sys_cd", length));
			String[] applPgmNo = (JSPUtil.getParameter(request, prefix	+ "appl_pgm_no", length));
			String[] batParaCtnt = (JSPUtil.getParameter(request, prefix	+ "bat_para_ctnt", length));
			String[] batStDt = (JSPUtil.getParameter(request, prefix	+ "bat_st_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] batRsltCd = (JSPUtil.getParameter(request, prefix	+ "bat_rslt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] batPgmNo = (JSPUtil.getParameter(request, prefix	+ "bat_pgm_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] batSeq = (JSPUtil.getParameter(request, prefix	+ "bat_seq", length));
			String[] batRsltDesc = (JSPUtil.getParameter(request, prefix	+ "bat_rslt_desc", length));
			String[] batEndDt = (JSPUtil.getParameter(request, prefix	+ "bat_end_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BatHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pgmSubSysCd[i] != null)
					model.setPgmSubSysCd(pgmSubSysCd[i]);
				if (applPgmNo[i] != null)
					model.setApplPgmNo(applPgmNo[i]);
				if (batParaCtnt[i] != null)
					model.setBatParaCtnt(batParaCtnt[i]);
				if (batStDt[i] != null)
					model.setBatStDt(batStDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (batRsltCd[i] != null)
					model.setBatRsltCd(batRsltCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (batPgmNo[i] != null)
					model.setBatPgmNo(batPgmNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (batSeq[i] != null)
					model.setBatSeq(batSeq[i]);
				if (batRsltDesc[i] != null)
					model.setBatRsltDesc(batRsltDesc[i]);
				if (batEndDt[i] != null)
					model.setBatEndDt(batEndDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBatHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BatHisVO[]
	 */
	public BatHisVO[] getBatHisVOs(){
		BatHisVO[] vos = (BatHisVO[])models.toArray(new BatHisVO[models.size()]);
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
		this.pgmSubSysCd = this.pgmSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applPgmNo = this.applPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batParaCtnt = this.batParaCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batStDt = this.batStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batRsltCd = this.batRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batPgmNo = this.batPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSeq = this.batSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batRsltDesc = this.batRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batEndDt = this.batEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
