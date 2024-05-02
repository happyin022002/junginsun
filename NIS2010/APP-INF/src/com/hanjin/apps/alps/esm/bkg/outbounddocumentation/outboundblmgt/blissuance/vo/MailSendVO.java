/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MailSendVO.java
*@FileTitle : MailSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.07 박준용
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MailSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MailSendVO> models = new ArrayList<MailSendVO>();
	
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
	private String batchFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String sndEml = null;
	/* Column Info */
	private String fileKey = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String tmplParam2 = null;
	/* Column Info */
	private String rcvEml = null;
	/* Column Info */
	private String tmplMrdPdf = null;
	/* Column Info */
	private String ccEml = null;
	/* Column Info */
	private String textContents = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MailSendVO() {}

	public MailSendVO(String ibflag, String pagerows, String sysCd, String tmplMrd, String batchFlg, String title, String contents, String tmplParam, String sndNm, String sndEml, String rcvEml, String crtUserId, String fileKey, String tmplMrdPdf, String ccEml, String textContents, String tmplParam2) {
		this.contents = contents;
		this.tmplMrd = tmplMrd;
		this.sndNm = sndNm;
		this.pagerows = pagerows;
		this.crtUserId = crtUserId;
		this.batchFlg = batchFlg;
		this.ibflag = ibflag;
		this.title = title;
		this.sndEml = sndEml;
		this.fileKey = fileKey;
		this.sysCd = sysCd;
		this.tmplParam = tmplParam;
		this.tmplParam2 = tmplParam2;
		this.rcvEml = rcvEml;
		this.tmplMrdPdf = tmplMrdPdf;
		this.ccEml = ccEml;
		this.textContents = textContents;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("snd_nm", getSndNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crt_user_id", getCrtUserId());
		this.hashColumns.put("batch_flg", getBatchFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("snd_eml", getSndEml());
		this.hashColumns.put("file_key", getFileKey());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("tmpl_param", getTmplParam());
		this.hashColumns.put("tmpl_param2", getTmplParam2());
		this.hashColumns.put("rcv_eml", getRcvEml());
		this.hashColumns.put("tmplMrdPdf", getTmplMrdPdf());
		this.hashColumns.put("ccEml", getCcEml());
		this.hashColumns.put("text_contents", getTextContents());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("contents", "contents");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("snd_nm", "sndNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crt_user_id", "crtUserId");
		this.hashFields.put("batch_flg", "batchFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("snd_eml", "sndEml");
		this.hashFields.put("file_key", "fileKey");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("tmpl_param", "tmplParam");
		this.hashFields.put("tmpl_param2", "tmplParam2");
		this.hashFields.put("rcv_eml", "rcvEml");
		this.hashFields.put("tmpl_mrd_pdf", "tmplMrdPdf");
		this.hashFields.put("cc_eml", "ccEml");
		this.hashFields.put("text_contents", "textContents");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmplMrdPdf
	 */
	public String getTmplMrdPdf() {
		return this.tmplMrdPdf;
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
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
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
	 * @return sndEml
	 */
	public String getSndEml() {
		return this.sndEml;
	}
	
	/**
	 * Column Info
	 * @return fileKey
	 */
	public String getFileKey() {
		return this.fileKey;
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
	 * @return tmplParam2
	 */
	public String getTmplParam2() {
		return this.tmplParam2;
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
	 * @return textContents
	 */
	public String getTextContents() {
		return this.textContents;
	}
	
	/**
	 * Column Info
	 * @param contents
	 */
	public void setTmplMrdPdf(String tmplMrdPdf) {
		this.tmplMrdPdf = tmplMrdPdf;
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
	 * @param batchFlg
	 */
	public void setBatchFlg(String batchFlg) {
		this.batchFlg = batchFlg;
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
	 * @param sndEml
	 */
	public void setSndEml(String sndEml) {
		this.sndEml = sndEml;
	}
	
	/**
	 * Column Info
	 * @param fileKey
	 */
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
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
	 * Column Info
	 * @param tmplParam2
	 */
	public void setTmplParam2(String tmplParam2) {
		this.tmplParam2 = tmplParam2;
	}
	
	/**
	 * Column Info
	 * @param rcvEml
	 */
	public void setRcvEml(String rcvEml) {
		this.rcvEml = rcvEml;
	}
	
	
	public String getCcEml() {
		return ccEml;
	}

	public void setCcEml(String ccEml) {
		this.ccEml = ccEml;
	}
	
	/**
	 * Column Info
	 * @param textContents
	 */
	public void setTextContents(String textContents) {
		this.textContents = textContents;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setContents(JSPUtil.getParameter(request, "contents", ""));
		setTmplMrd(JSPUtil.getParameter(request, "tmpl_mrd", ""));
		setSndNm(JSPUtil.getParameter(request, "snd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrtUserId(JSPUtil.getParameter(request, "crt_user_id", ""));
		setBatchFlg(JSPUtil.getParameter(request, "batch_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setSndEml(JSPUtil.getParameter(request, "snd_eml", ""));
		setFileKey(JSPUtil.getParameter(request, "file_key", ""));
		setSysCd(JSPUtil.getParameter(request, "sys_cd", ""));
		setTmplParam(JSPUtil.getParameter(request, "tmpl_param", ""));
		setTmplParam2(JSPUtil.getParameter(request, "tmpl_param2", ""));
		setRcvEml(JSPUtil.getParameter(request, "rcv_eml", ""));
		setTmplMrdPdf(JSPUtil.getParameter(request, "tmpl_mrd_pdf", ""));
		setCcEml(JSPUtil.getParameter(request, "cc_eml", ""));
		setTextContents(JSPUtil.getParameter(request, "text_contents", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MailSendVO[]
	 */
	public MailSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MailSendVO[]
	 */
	public MailSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MailSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd", length));
			String[] sndNm = (JSPUtil.getParameter(request, prefix	+ "snd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crtUserId = (JSPUtil.getParameter(request, prefix	+ "crt_user_id", length));
			String[] batchFlg = (JSPUtil.getParameter(request, prefix	+ "batch_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] sndEml = (JSPUtil.getParameter(request, prefix	+ "snd_eml", length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "file_key", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix	+ "tmpl_param", length));
			String[] tmplParam2 = (JSPUtil.getParameter(request, prefix	+ "tmpl_param2", length));
			String[] rcvEml = (JSPUtil.getParameter(request, prefix	+ "rcv_eml", length));
			String[] tmplMrdPdf = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd_pdf", length));
			String[] ccEml = (JSPUtil.getParameter(request, prefix	+ "cc_eml", length));
			String[] textContents = (JSPUtil.getParameter(request, prefix	+ "text_contents", length));
			
			for (int i = 0; i < length; i++) {
				model = new MailSendVO();
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
				if (batchFlg[i] != null)
					model.setBatchFlg(batchFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (sndEml[i] != null)
					model.setSndEml(sndEml[i]);
				if (fileKey[i] != null)
					model.setFileKey(fileKey[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				if (tmplParam2[i] != null)
					model.setTmplParam2(tmplParam2[i]);
				if (rcvEml[i] != null)
					model.setRcvEml(rcvEml[i]);
				if (tmplMrdPdf[i] != null)
					model.setTmplMrdPdf(tmplMrdPdf[i]);
				if (ccEml[i] != null)
					model.setCcEml(ccEml[i]);
				if (textContents[i] != null)
					model.setTextContents(ccEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMailSendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MailSendVO[]
	 */
	public MailSendVO[] getMailSendVOs(){
		MailSendVO[] vos = (MailSendVO[])models.toArray(new MailSendVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNm = this.sndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtUserId = this.crtUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchFlg = this.batchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndEml = this.sndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam2 = this.tmplParam2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEml = this.rcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrdPdf = this.tmplMrdPdf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEml = this.ccEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textContents = this.textContents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
