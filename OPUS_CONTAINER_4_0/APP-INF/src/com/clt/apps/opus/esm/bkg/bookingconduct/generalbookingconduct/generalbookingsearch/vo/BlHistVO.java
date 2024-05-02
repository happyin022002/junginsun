/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlHistVO.java
*@FileTitle : BlHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.11 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlHistVO> models = new ArrayList<BlHistVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String preCtntOrg = null;
	/* Column Info */
	private String crntCtntOrg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String hisDtlSeq = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String itemHdr = null;
	/* Column Info */
	private String preCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlHistVO() {}

	public BlHistVO(String ibflag, String pagerows, String hisSeq, String hisDtlSeq, String itemHdr, String hisCateNm, String preCtnt, String preCtntOrg, String crntCtnt, String crntCtntOrg, String creUsrId, String office, String creDt, String gmtDt, String corrNo) {
		this.office = office;
		this.gmtDt = gmtDt;
		this.corrNo = corrNo;
		this.creDt = creDt;
		this.crntCtnt = crntCtnt;
		this.preCtntOrg = preCtntOrg;
		this.crntCtntOrg = crntCtntOrg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.hisCateNm = hisCateNm;
		this.hisDtlSeq = hisDtlSeq;
		this.hisSeq = hisSeq;
		this.itemHdr = itemHdr;
		this.preCtnt = preCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("pre_ctnt_org", getPreCtntOrg());
		this.hashColumns.put("crnt_ctnt_org", getCrntCtntOrg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("his_dtl_seq", getHisDtlSeq());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("item_hdr", getItemHdr());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("pre_ctnt_org", "preCtntOrg");
		this.hashFields.put("crnt_ctnt_org", "crntCtntOrg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("his_dtl_seq", "hisDtlSeq");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("item_hdr", "itemHdr");
		this.hashFields.put("pre_ctnt", "preCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
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
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return preCtntOrg
	 */
	public String getPreCtntOrg() {
		return this.preCtntOrg;
	}
	
	/**
	 * Column Info
	 * @return crntCtntOrg
	 */
	public String getCrntCtntOrg() {
		return this.crntCtntOrg;
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
	 * @return hisCateNm
	 */
	public String getHisCateNm() {
		return this.hisCateNm;
	}
	
	/**
	 * Column Info
	 * @return hisDtlSeq
	 */
	public String getHisDtlSeq() {
		return this.hisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return itemHdr
	 */
	public String getItemHdr() {
		return this.itemHdr;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
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
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}
	
	/**
	 * Column Info
	 * @param preCtntOrg
	 */
	public void setPreCtntOrg(String preCtntOrg) {
		this.preCtntOrg = preCtntOrg;
	}
	
	/**
	 * Column Info
	 * @param crntCtntOrg
	 */
	public void setCrntCtntOrg(String crntCtntOrg) {
		this.crntCtntOrg = crntCtntOrg;
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
	 * @param hisCateNm
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}
	
	/**
	 * Column Info
	 * @param hisDtlSeq
	 */
	public void setHisDtlSeq(String hisDtlSeq) {
		this.hisDtlSeq = hisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param itemHdr
	 */
	public void setItemHdr(String itemHdr) {
		this.itemHdr = itemHdr;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
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
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrntCtnt(JSPUtil.getParameter(request, prefix + "crnt_ctnt", ""));
		setPreCtntOrg(JSPUtil.getParameter(request, prefix + "pre_ctnt_org", ""));
		setCrntCtntOrg(JSPUtil.getParameter(request, prefix + "crnt_ctnt_org", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHisCateNm(JSPUtil.getParameter(request, prefix + "his_cate_nm", ""));
		setHisDtlSeq(JSPUtil.getParameter(request, prefix + "his_dtl_seq", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setItemHdr(JSPUtil.getParameter(request, prefix + "item_hdr", ""));
		setPreCtnt(JSPUtil.getParameter(request, prefix + "pre_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlHistVO[]
	 */
	public BlHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlHistVO[]
	 */
	public BlHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] preCtntOrg = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt_org", length));
			String[] crntCtntOrg = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt_org", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm", length));
			String[] hisDtlSeq = (JSPUtil.getParameter(request, prefix	+ "his_dtl_seq", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] itemHdr = (JSPUtil.getParameter(request, prefix	+ "item_hdr", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlHistVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (preCtntOrg[i] != null)
					model.setPreCtntOrg(preCtntOrg[i]);
				if (crntCtntOrg[i] != null)
					model.setCrntCtntOrg(crntCtntOrg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (hisDtlSeq[i] != null)
					model.setHisDtlSeq(hisDtlSeq[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (itemHdr[i] != null)
					model.setItemHdr(itemHdr[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlHistVO[]
	 */
	public BlHistVO[] getBlHistVOs(){
		BlHistVO[] vos = (BlHistVO[])models.toArray(new BlHistVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtntOrg = this.preCtntOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtntOrg = this.crntCtntOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlSeq = this.hisDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemHdr = this.itemHdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
