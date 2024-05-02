/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SendMtyRlseOrdVO.java
*@FileTitle : SendMtyRlseOrdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendMtyRlseOrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendMtyRlseOrdVO> models = new ArrayList<SendMtyRlseOrdVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String rcvInfo = null;
	/* Column Info */
	private String contents = null;
	/* Column Info */
	private String tmplMrd = null;
	/* Column Info */
	private String sndNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crtUserId = null;
	/* Column Info */
	private String yardType = null;
	/* Column Info */
	private String batchFlg = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String sndEml = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String rcvEml = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String tmplParam = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendMtyRlseOrdVO() {}

	public SendMtyRlseOrdVO(String ibflag, String pagerows, String sysCd, String tmplMrd, String office, String batchFlg, String title, String rcvInfo, String tmplParam, String crtUserId, String contents, String sndNm, String sndEml, String rcvEml, String bkgNo, String ntcFaxNo, String ntcEml, String diffRmk, String yard, String yardType) {
		this.office = office;
		this.yard = yard;
		this.rcvInfo = rcvInfo;
		this.contents = contents;
		this.tmplMrd = tmplMrd;
		this.sndNm = sndNm;
		this.pagerows = pagerows;
		this.crtUserId = crtUserId;
		this.yardType = yardType;
		this.batchFlg = batchFlg;
		this.ntcEml = ntcEml;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.title = title;
		this.diffRmk = diffRmk;
		this.sndEml = sndEml;
		this.ntcFaxNo = ntcFaxNo;
		this.rcvEml = rcvEml;
		this.sysCd = sysCd;
		this.tmplParam = tmplParam;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("rcv_info", getRcvInfo());
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("snd_nm", getSndNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crt_user_id", getCrtUserId());
		this.hashColumns.put("yard_type", getYardType());
		this.hashColumns.put("batch_flg", getBatchFlg());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("snd_eml", getSndEml());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("rcv_eml", getRcvEml());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("tmpl_param", getTmplParam());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("rcv_info", "rcvInfo");
		this.hashFields.put("contents", "contents");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("snd_nm", "sndNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crt_user_id", "crtUserId");
		this.hashFields.put("yard_type", "yardType");
		this.hashFields.put("batch_flg", "batchFlg");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("snd_eml", "sndEml");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("rcv_eml", "rcvEml");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("tmpl_param", "tmplParam");
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
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return rcvInfo
	 */
	public String getRcvInfo() {
		return this.rcvInfo;
	}
	
	/**
	 * Column Info
	 * @return contents
	 */
	public String getContents() {
		return this.contents;
	}
	
	/**
	 * Column Info
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
	}
	
	/**
	 * Column Info
	 * @return sndNm
	 */
	public String getSndNm() {
		return this.sndNm;
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
	 * @return crtUserId
	 */
	public String getCrtUserId() {
		return this.crtUserId;
	}
	
	/**
	 * Column Info
	 * @return yardType
	 */
	public String getYardType() {
		return this.yardType;
	}
	
	/**
	 * Column Info
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return sndEml
	 */
	public String getSndEml() {
		return this.sndEml;
	}
	
	/**
	 * Column Info
	 * @return ntcFaxNo
	 */
	public String getNtcFaxNo() {
		return this.ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return rcvEml
	 */
	public String getRcvEml() {
		return this.rcvEml;
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
	 * @return tmplParam
	 */
	public String getTmplParam() {
		return this.tmplParam;
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
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param rcvInfo
	 */
	public void setRcvInfo(String rcvInfo) {
		this.rcvInfo = rcvInfo;
	}
	
	/**
	 * Column Info
	 * @param contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	/**
	 * Column Info
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}
	
	/**
	 * Column Info
	 * @param sndNm
	 */
	public void setSndNm(String sndNm) {
		this.sndNm = sndNm;
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
	 * @param crtUserId
	 */
	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}
	
	/**
	 * Column Info
	 * @param yardType
	 */
	public void setYardType(String yardType) {
		this.yardType = yardType;
	}
	
	/**
	 * Column Info
	 * @param batchFlg
	 */
	public void setBatchFlg(String batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param sndEml
	 */
	public void setSndEml(String sndEml) {
		this.sndEml = sndEml;
	}
	
	/**
	 * Column Info
	 * @param ntcFaxNo
	 */
	public void setNtcFaxNo(String ntcFaxNo) {
		this.ntcFaxNo = ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param rcvEml
	 */
	public void setRcvEml(String rcvEml) {
		this.rcvEml = rcvEml;
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
	 * @param tmplParam
	 */
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
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
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setRcvInfo(JSPUtil.getParameter(request, prefix + "rcv_info", ""));
		setContents(JSPUtil.getParameter(request, prefix + "contents", ""));
		setTmplMrd(JSPUtil.getParameter(request, prefix + "tmpl_mrd", ""));
		setSndNm(JSPUtil.getParameter(request, prefix + "snd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCrtUserId(JSPUtil.getParameter(request, prefix + "crt_user_id", ""));
		setYardType(JSPUtil.getParameter(request, prefix + "yard_type", ""));
		setBatchFlg(JSPUtil.getParameter(request, prefix + "batch_flg", ""));
		setNtcEml(JSPUtil.getParameter(request, prefix + "ntc_eml", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setSndEml(JSPUtil.getParameter(request, prefix + "snd_eml", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, prefix + "ntc_fax_no", ""));
		setRcvEml(JSPUtil.getParameter(request, prefix + "rcv_eml", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setTmplParam(JSPUtil.getParameter(request, prefix + "tmpl_param", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendMtyRlseOrdVO[]
	 */
	public SendMtyRlseOrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendMtyRlseOrdVO[]
	 */
	public SendMtyRlseOrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendMtyRlseOrdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] rcvInfo = (JSPUtil.getParameter(request, prefix	+ "rcv_info", length));
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd", length));
			String[] sndNm = (JSPUtil.getParameter(request, prefix	+ "snd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crtUserId = (JSPUtil.getParameter(request, prefix	+ "crt_user_id", length));
			String[] yardType = (JSPUtil.getParameter(request, prefix	+ "yard_type", length));
			String[] batchFlg = (JSPUtil.getParameter(request, prefix	+ "batch_flg", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] sndEml = (JSPUtil.getParameter(request, prefix	+ "snd_eml", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] rcvEml = (JSPUtil.getParameter(request, prefix	+ "rcv_eml", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix	+ "tmpl_param", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendMtyRlseOrdVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (rcvInfo[i] != null)
					model.setRcvInfo(rcvInfo[i]);
				if (contents[i] != null)
					model.setContents(contents[i]);
				if (tmplMrd[i] != null)
					model.setTmplMrd(tmplMrd[i]);
				if (sndNm[i] != null)
					model.setSndNm(sndNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crtUserId[i] != null)
					model.setCrtUserId(crtUserId[i]);
				if (yardType[i] != null)
					model.setYardType(yardType[i]);
				if (batchFlg[i] != null)
					model.setBatchFlg(batchFlg[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (sndEml[i] != null)
					model.setSndEml(sndEml[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (rcvEml[i] != null)
					model.setRcvEml(rcvEml[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendMtyRlseOrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendMtyRlseOrdVO[]
	 */
	public SendMtyRlseOrdVO[] getSendMtyRlseOrdVOs(){
		SendMtyRlseOrdVO[] vos = (SendMtyRlseOrdVO[])models.toArray(new SendMtyRlseOrdVO[models.size()]);
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
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInfo = this.rcvInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNm = this.sndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtUserId = this.crtUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardType = this.yardType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchFlg = this.batchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndEml = this.sndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEml = this.rcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
