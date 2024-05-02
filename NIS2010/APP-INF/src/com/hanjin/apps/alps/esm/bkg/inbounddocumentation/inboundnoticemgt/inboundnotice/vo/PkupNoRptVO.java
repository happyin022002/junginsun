/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupNoRptVO.java
*@FileTitle : PkupNoRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.12.01 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNoRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNoRptVO> models = new ArrayList<PkupNoRptVO>();
	
	/* Column Info */
	private String pkupYdCdChkMsg = null;
	/* Column Info */
	private String pkupYdCdChkFlg = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String lstFreeDtChkFlg = null;
	/* Column Info */
	private String lstFreeDtChkMsg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blNoChkMsg = null;
	/* Column Info */
	private String pkupAvalDtChkFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNoChkMsg = null;
	/* Column Info */
	private String pkupAvalDtChkMsg = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* Column Info */
	private String cntrNoChkFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String blNoChkFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNoRptVO() {}

	public PkupNoRptVO(String ibflag, String pagerows, String chk, String cntrNo, String blNo, String pkupNo, String pkupAvalDt, String lstFreeDt, String pkupYdCd, String remark, String cntrNoChkFlg, String cntrNoChkMsg, String blNoChkFlg, String blNoChkMsg, String pkupYdCdChkFlg, String pkupYdCdChkMsg, String pkupAvalDtChkFlg, String pkupAvalDtChkMsg, String lstFreeDtChkFlg, String lstFreeDtChkMsg) {
		this.pkupYdCdChkMsg = pkupYdCdChkMsg;
		this.pkupYdCdChkFlg = pkupYdCdChkFlg;
		this.remark = remark;
		this.lstFreeDtChkFlg = lstFreeDtChkFlg;
		this.lstFreeDtChkMsg = lstFreeDtChkMsg;
		this.blNo = blNo;
		this.blNoChkMsg = blNoChkMsg;
		this.pkupAvalDtChkFlg = pkupAvalDtChkFlg;
		this.pagerows = pagerows;
		this.cntrNoChkMsg = cntrNoChkMsg;
		this.pkupAvalDtChkMsg = pkupAvalDtChkMsg;
		this.pkupYdCd = pkupYdCd;
		this.cntrNoChkFlg = cntrNoChkFlg;
		this.ibflag = ibflag;
		this.pkupAvalDt = pkupAvalDt;
		this.chk = chk;
		this.blNoChkFlg = blNoChkFlg;
		this.cntrNo = cntrNo;
		this.lstFreeDt = lstFreeDt;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkup_yd_cd_chk_msg", getPkupYdCdChkMsg());
		this.hashColumns.put("pkup_yd_cd_chk_flg", getPkupYdCdChkFlg());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("lst_free_dt_chk_flg", getLstFreeDtChkFlg());
		this.hashColumns.put("lst_free_dt_chk_msg", getLstFreeDtChkMsg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_no_chk_msg", getBlNoChkMsg());
		this.hashColumns.put("pkup_aval_dt_chk_flg", getPkupAvalDtChkFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no_chk_msg", getCntrNoChkMsg());
		this.hashColumns.put("pkup_aval_dt_chk_msg", getPkupAvalDtChkMsg());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("cntr_no_chk_flg", getCntrNoChkFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("bl_no_chk_flg", getBlNoChkFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkup_yd_cd_chk_msg", "pkupYdCdChkMsg");
		this.hashFields.put("pkup_yd_cd_chk_flg", "pkupYdCdChkFlg");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("lst_free_dt_chk_flg", "lstFreeDtChkFlg");
		this.hashFields.put("lst_free_dt_chk_msg", "lstFreeDtChkMsg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_no_chk_msg", "blNoChkMsg");
		this.hashFields.put("pkup_aval_dt_chk_flg", "pkupAvalDtChkFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no_chk_msg", "cntrNoChkMsg");
		this.hashFields.put("pkup_aval_dt_chk_msg", "pkupAvalDtChkMsg");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("cntr_no_chk_flg", "cntrNoChkFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("bl_no_chk_flg", "blNoChkFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("pkup_no", "pkupNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCdChkMsg
	 */
	public String getPkupYdCdChkMsg() {
		return this.pkupYdCdChkMsg;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCdChkFlg
	 */
	public String getPkupYdCdChkFlg() {
		return this.pkupYdCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDtChkFlg
	 */
	public String getLstFreeDtChkFlg() {
		return this.lstFreeDtChkFlg;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDtChkMsg
	 */
	public String getLstFreeDtChkMsg() {
		return this.lstFreeDtChkMsg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return blNoChkMsg
	 */
	public String getBlNoChkMsg() {
		return this.blNoChkMsg;
	}
	
	/**
	 * Column Info
	 * @return pkupAvalDtChkFlg
	 */
	public String getPkupAvalDtChkFlg() {
		return this.pkupAvalDtChkFlg;
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
	 * @return cntrNoChkMsg
	 */
	public String getCntrNoChkMsg() {
		return this.cntrNoChkMsg;
	}
	
	/**
	 * Column Info
	 * @return pkupAvalDtChkMsg
	 */
	public String getPkupAvalDtChkMsg() {
		return this.pkupAvalDtChkMsg;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNoChkFlg
	 */
	public String getCntrNoChkFlg() {
		return this.cntrNoChkFlg;
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
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return blNoChkFlg
	 */
	public String getBlNoChkFlg() {
		return this.blNoChkFlg;
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
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	

	/**
	 * Column Info
	 * @param pkupYdCdChkMsg
	 */
	public void setPkupYdCdChkMsg(String pkupYdCdChkMsg) {
		this.pkupYdCdChkMsg = pkupYdCdChkMsg;
	}
	
	/**
	 * Column Info
	 * @param pkupYdCdChkFlg
	 */
	public void setPkupYdCdChkFlg(String pkupYdCdChkFlg) {
		this.pkupYdCdChkFlg = pkupYdCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDtChkFlg
	 */
	public void setLstFreeDtChkFlg(String lstFreeDtChkFlg) {
		this.lstFreeDtChkFlg = lstFreeDtChkFlg;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDtChkMsg
	 */
	public void setLstFreeDtChkMsg(String lstFreeDtChkMsg) {
		this.lstFreeDtChkMsg = lstFreeDtChkMsg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blNoChkMsg
	 */
	public void setBlNoChkMsg(String blNoChkMsg) {
		this.blNoChkMsg = blNoChkMsg;
	}
	
	/**
	 * Column Info
	 * @param pkupAvalDtChkFlg
	 */
	public void setPkupAvalDtChkFlg(String pkupAvalDtChkFlg) {
		this.pkupAvalDtChkFlg = pkupAvalDtChkFlg;
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
	 * @param cntrNoChkMsg
	 */
	public void setCntrNoChkMsg(String cntrNoChkMsg) {
		this.cntrNoChkMsg = cntrNoChkMsg;
	}
	
	/**
	 * Column Info
	 * @param pkupAvalDtChkMsg
	 */
	public void setPkupAvalDtChkMsg(String pkupAvalDtChkMsg) {
		this.pkupAvalDtChkMsg = pkupAvalDtChkMsg;
	}
	
	/**
	 * Column Info
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNoChkFlg
	 */
	public void setCntrNoChkFlg(String cntrNoChkFlg) {
		this.cntrNoChkFlg = cntrNoChkFlg;
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
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param blNoChkFlg
	 */
	public void setBlNoChkFlg(String blNoChkFlg) {
		this.blNoChkFlg = blNoChkFlg;
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
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPkupYdCdChkMsg(JSPUtil.getParameter(request, "pkup_yd_cd_chk_msg", ""));
		setPkupYdCdChkFlg(JSPUtil.getParameter(request, "pkup_yd_cd_chk_flg", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setLstFreeDtChkFlg(JSPUtil.getParameter(request, "lst_free_dt_chk_flg", ""));
		setLstFreeDtChkMsg(JSPUtil.getParameter(request, "lst_free_dt_chk_msg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlNoChkMsg(JSPUtil.getParameter(request, "bl_no_chk_msg", ""));
		setPkupAvalDtChkFlg(JSPUtil.getParameter(request, "pkup_aval_dt_chk_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNoChkMsg(JSPUtil.getParameter(request, "cntr_no_chk_msg", ""));
		setPkupAvalDtChkMsg(JSPUtil.getParameter(request, "pkup_aval_dt_chk_msg", ""));
		setPkupYdCd(JSPUtil.getParameter(request, "pkup_yd_cd", ""));
		setCntrNoChkFlg(JSPUtil.getParameter(request, "cntr_no_chk_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, "pkup_aval_dt", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
		setBlNoChkFlg(JSPUtil.getParameter(request, "bl_no_chk_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setLstFreeDt(JSPUtil.getParameter(request, "lst_free_dt", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNoRptVO[]
	 */
	public PkupNoRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNoRptVO[]
	 */
	public PkupNoRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNoRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkupYdCdChkMsg = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd_chk_msg", length));
			String[] pkupYdCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd_chk_flg", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] lstFreeDtChkFlg = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt_chk_flg", length));
			String[] lstFreeDtChkMsg = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt_chk_msg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blNoChkMsg = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk_msg", length));
			String[] pkupAvalDtChkFlg = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt_chk_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNoChkMsg = (JSPUtil.getParameter(request, prefix	+ "cntr_no_chk_msg", length));
			String[] pkupAvalDtChkMsg = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt_chk_msg", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] cntrNoChkFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_no_chk_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] blNoChkFlg = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNoRptVO();
				if (pkupYdCdChkMsg[i] != null)
					model.setPkupYdCdChkMsg(pkupYdCdChkMsg[i]);
				if (pkupYdCdChkFlg[i] != null)
					model.setPkupYdCdChkFlg(pkupYdCdChkFlg[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (lstFreeDtChkFlg[i] != null)
					model.setLstFreeDtChkFlg(lstFreeDtChkFlg[i]);
				if (lstFreeDtChkMsg[i] != null)
					model.setLstFreeDtChkMsg(lstFreeDtChkMsg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blNoChkMsg[i] != null)
					model.setBlNoChkMsg(blNoChkMsg[i]);
				if (pkupAvalDtChkFlg[i] != null)
					model.setPkupAvalDtChkFlg(pkupAvalDtChkFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNoChkMsg[i] != null)
					model.setCntrNoChkMsg(cntrNoChkMsg[i]);
				if (pkupAvalDtChkMsg[i] != null)
					model.setPkupAvalDtChkMsg(pkupAvalDtChkMsg[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (cntrNoChkFlg[i] != null)
					model.setCntrNoChkFlg(cntrNoChkFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (blNoChkFlg[i] != null)
					model.setBlNoChkFlg(blNoChkFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNoRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNoRptVO[]
	 */
	public PkupNoRptVO[] getPkupNoRptVOs(){
		PkupNoRptVO[] vos = (PkupNoRptVO[])models.toArray(new PkupNoRptVO[models.size()]);
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
		this.pkupYdCdChkMsg = this.pkupYdCdChkMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCdChkFlg = this.pkupYdCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDtChkFlg = this.lstFreeDtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDtChkMsg = this.lstFreeDtChkMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChkMsg = this.blNoChkMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDtChkFlg = this.pkupAvalDtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoChkMsg = this.cntrNoChkMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDtChkMsg = this.pkupAvalDtChkMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoChkFlg = this.cntrNoChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChkFlg = this.blNoChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
