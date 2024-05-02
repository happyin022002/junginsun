/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlCaDetailListVO.java
*@FileTitle : BlCaDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.11.24 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCaDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCaDetailListVO> models = new ArrayList<BlCaDetailListVO>();
	
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String corrUsrId = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String content = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String corrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCaDetailListVO() {}

	public BlCaDetailListVO(String ibflag, String pagerows, String corrOfcCd, String corrUsrId, String usrEml, String corrDt, String corrNo, String bkgNo, String hisCateNm, String preCtnt, String crntCtnt, String title, String content) {
		this.corrDt = corrDt;
		this.corrNo = corrNo;
		this.corrUsrId = corrUsrId;
		this.crntCtnt = crntCtnt;
		this.pagerows = pagerows;
		this.content = content;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.title = title;
		this.hisCateNm = hisCateNm;
		this.usrEml = usrEml;
		this.preCtnt = preCtnt;
		this.corrOfcCd = corrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("content", "content");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("title", "title");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
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
	 * @return corrUsrId
	 */
	public String getCorrUsrId() {
		return this.corrUsrId;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
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
	 * @return content
	 */
	public String getContent() {
		return this.content;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
	}
	

	/**
	 * Column Info
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
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
	 * @param corrUsrId
	 */
	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCorrDt(JSPUtil.getParameter(request, "corr_dt", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setCorrUsrId(JSPUtil.getParameter(request, "corr_usr_id", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setContent(JSPUtil.getParameter(request, "content", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setHisCateNm(JSPUtil.getParameter(request, "his_cate_nm", ""));
		setUsrEml(JSPUtil.getParameter(request, "usr_eml", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, "corr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCaDetailListVO[]
	 */
	public BlCaDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCaDetailListVO[]
	 */
	public BlCaDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCaDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCaDetailListVO();
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCaDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCaDetailListVO[]
	 */
	public BlCaDetailListVO[] getBlCaDetailListVOs(){
		BlCaDetailListVO[] vos = (BlCaDetailListVO[])models.toArray(new BlCaDetailListVO[models.size()]);
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
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
