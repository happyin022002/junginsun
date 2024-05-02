/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgDpcsOfcTmVO.java
*@FileTitle : BkgDpcsOfcTmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.23
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.10.23 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgDpcsOfcTmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDpcsOfcTmVO> models = new ArrayList<BkgDpcsOfcTmVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String docWrkTmRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String docWrkStHrmnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String docWrkOvnFlg = null;
	/* Column Info */
	private String docWrkEndHrmnt = null;
	/* Column Info */
	private String convDocWrkEndHrmnt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String convDocWrkStHrmnt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDpcsOfcTmVO() {}

	public BkgDpcsOfcTmVO(String ibflag, String pagerows, String bkgOfcCd, String docWrkStHrmnt, String docWrkEndHrmnt, String docWrkOvnFlg, String docWrkTmRmk, String cntCd, String creUsrId, String creDt, String updUsrId, String updDt, String convDocWrkStHrmnt, String convDocWrkEndHrmnt) {
		this.bkgOfcCd = bkgOfcCd;
		this.updDt = updDt;
		this.docWrkTmRmk = docWrkTmRmk;
		this.creDt = creDt;
		this.docWrkStHrmnt = docWrkStHrmnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.docWrkOvnFlg = docWrkOvnFlg;
		this.docWrkEndHrmnt = docWrkEndHrmnt;
		this.convDocWrkEndHrmnt = convDocWrkEndHrmnt;
		this.cntCd = cntCd;
		this.convDocWrkStHrmnt = convDocWrkStHrmnt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("doc_wrk_tm_rmk", getDocWrkTmRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("doc_wrk_st_hrmnt", getDocWrkStHrmnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("doc_wrk_ovn_flg", getDocWrkOvnFlg());
		this.hashColumns.put("doc_wrk_end_hrmnt", getDocWrkEndHrmnt());
		this.hashColumns.put("conv_doc_wrk_end_hrmnt", getConvDocWrkEndHrmnt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("conv_doc_wrk_st_hrmnt", getConvDocWrkStHrmnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("doc_wrk_tm_rmk", "docWrkTmRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("doc_wrk_st_hrmnt", "docWrkStHrmnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("doc_wrk_ovn_flg", "docWrkOvnFlg");
		this.hashFields.put("doc_wrk_end_hrmnt", "docWrkEndHrmnt");
		this.hashFields.put("conv_doc_wrk_end_hrmnt", "convDocWrkEndHrmnt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("conv_doc_wrk_st_hrmnt", "convDocWrkStHrmnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return docWrkTmRmk
	 */
	public String getDocWrkTmRmk() {
		return this.docWrkTmRmk;
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
	 * @return docWrkStHrmnt
	 */
	public String getDocWrkStHrmnt() {
		return this.docWrkStHrmnt;
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
	 * @return docWrkOvnFlg
	 */
	public String getDocWrkOvnFlg() {
		return this.docWrkOvnFlg;
	}
	
	/**
	 * Column Info
	 * @return docWrkEndHrmnt
	 */
	public String getDocWrkEndHrmnt() {
		return this.docWrkEndHrmnt;
	}
	
	/**
	 * Column Info
	 * @return convDocWrkEndHrmnt
	 */
	public String getConvDocWrkEndHrmnt() {
		return this.convDocWrkEndHrmnt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return convDocWrkStHrmnt
	 */
	public String getConvDocWrkStHrmnt() {
		return this.convDocWrkStHrmnt;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param docWrkTmRmk
	 */
	public void setDocWrkTmRmk(String docWrkTmRmk) {
		this.docWrkTmRmk = docWrkTmRmk;
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
	 * @param docWrkStHrmnt
	 */
	public void setDocWrkStHrmnt(String docWrkStHrmnt) {
		this.docWrkStHrmnt = docWrkStHrmnt;
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
	 * @param docWrkOvnFlg
	 */
	public void setDocWrkOvnFlg(String docWrkOvnFlg) {
		this.docWrkOvnFlg = docWrkOvnFlg;
	}
	
	/**
	 * Column Info
	 * @param docWrkEndHrmnt
	 */
	public void setDocWrkEndHrmnt(String docWrkEndHrmnt) {
		this.docWrkEndHrmnt = docWrkEndHrmnt;
	}
	
	/**
	 * Column Info
	 * @param convDocWrkEndHrmnt
	 */
	public void setConvDocWrkEndHrmnt(String convDocWrkEndHrmnt) {
		this.convDocWrkEndHrmnt = convDocWrkEndHrmnt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param convDocWrkStHrmnt
	 */
	public void setConvDocWrkStHrmnt(String convDocWrkStHrmnt) {
		this.convDocWrkStHrmnt = convDocWrkStHrmnt;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDocWrkTmRmk(JSPUtil.getParameter(request, prefix + "doc_wrk_tm_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDocWrkStHrmnt(JSPUtil.getParameter(request, prefix + "doc_wrk_st_hrmnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDocWrkOvnFlg(JSPUtil.getParameter(request, prefix + "doc_wrk_ovn_flg", ""));
		setDocWrkEndHrmnt(JSPUtil.getParameter(request, prefix + "doc_wrk_end_hrmnt", ""));
		setConvDocWrkEndHrmnt(JSPUtil.getParameter(request, prefix + "conv_doc_wrk_end_hrmnt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setConvDocWrkStHrmnt(JSPUtil.getParameter(request, prefix + "conv_doc_wrk_st_hrmnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDpcsOfcTmVO[]
	 */
	public BkgDpcsOfcTmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDpcsOfcTmVO[]
	 */
	public BkgDpcsOfcTmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDpcsOfcTmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] docWrkTmRmk = (JSPUtil.getParameter(request, prefix	+ "doc_wrk_tm_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] docWrkStHrmnt = (JSPUtil.getParameter(request, prefix	+ "doc_wrk_st_hrmnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] docWrkOvnFlg = (JSPUtil.getParameter(request, prefix	+ "doc_wrk_ovn_flg", length));
			String[] docWrkEndHrmnt = (JSPUtil.getParameter(request, prefix	+ "doc_wrk_end_hrmnt", length));
			String[] convDocWrkEndHrmnt = (JSPUtil.getParameter(request, prefix	+ "conv_doc_wrk_end_hrmnt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] convDocWrkStHrmnt = (JSPUtil.getParameter(request, prefix	+ "conv_doc_wrk_st_hrmnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDpcsOfcTmVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (docWrkTmRmk[i] != null)
					model.setDocWrkTmRmk(docWrkTmRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (docWrkStHrmnt[i] != null)
					model.setDocWrkStHrmnt(docWrkStHrmnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (docWrkOvnFlg[i] != null)
					model.setDocWrkOvnFlg(docWrkOvnFlg[i]);
				if (docWrkEndHrmnt[i] != null)
					model.setDocWrkEndHrmnt(docWrkEndHrmnt[i]);
				if (convDocWrkEndHrmnt[i] != null)
					model.setConvDocWrkEndHrmnt(convDocWrkEndHrmnt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (convDocWrkStHrmnt[i] != null)
					model.setConvDocWrkStHrmnt(convDocWrkStHrmnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDpcsOfcTmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDpcsOfcTmVO[]
	 */
	public BkgDpcsOfcTmVO[] getBkgDpcsOfcTmVOs(){
		BkgDpcsOfcTmVO[] vos = (BkgDpcsOfcTmVO[])models.toArray(new BkgDpcsOfcTmVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docWrkTmRmk = this.docWrkTmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docWrkStHrmnt = this.docWrkStHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docWrkOvnFlg = this.docWrkOvnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docWrkEndHrmnt = this.docWrkEndHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDocWrkEndHrmnt = this.convDocWrkEndHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDocWrkStHrmnt = this.convDocWrkStHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
