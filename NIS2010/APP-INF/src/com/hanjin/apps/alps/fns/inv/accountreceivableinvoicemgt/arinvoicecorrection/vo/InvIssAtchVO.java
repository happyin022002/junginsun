/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvIssAtchVO.java
*@FileTitle : InvIssAtchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.07 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvIssAtchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvIssAtchVO> models = new ArrayList<InvIssAtchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String text3 = null;
	/* Column Info */
	private String text4 = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String text1 = null;
	/* Column Info */
	private String text2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String highLight4 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String highLight2 = null;
	/* Column Info */
	private String invIssCtnt = null;
	/* Column Info */
	private String highLight3 = null;
	/* Column Info */
	private String highLight1 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String txtNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fontBoldFlg = null;
	/* Column Info */
	private String btnEvent = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String searchOption = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvIssAtchVO() {}

	public InvIssAtchVO(String ibflag, String pagerows, String vvd, String portCd, String arOfcCd, String subject, String text1, String highLight1, String text2, String highLight2, String text3, String highLight3, String text4, String highLight4, String vslCd, String skdVoyNo, String skdDirCd, String txtNo, String invIssCtnt, String fontBoldFlg, String creUsrId, String updUsrId, String btnEvent, String custCntCd, String custSeq, String searchOption) {
		this.vslCd = vslCd;
		this.text3 = text3;
		this.text4 = text4;
		this.subject = subject;
		this.text1 = text1;
		this.text2 = text2;
		this.skdVoyNo = skdVoyNo;
		this.highLight4 = highLight4;
		this.skdDirCd = skdDirCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.highLight2 = highLight2;
		this.invIssCtnt = invIssCtnt;
		this.highLight3 = highLight3;
		this.highLight1 = highLight1;
		this.portCd = portCd;
		this.txtNo = txtNo;
		this.updUsrId = updUsrId;
		this.fontBoldFlg = fontBoldFlg;
		this.btnEvent = btnEvent;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.searchOption = searchOption;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("text3", getText3());
		this.hashColumns.put("text4", getText4());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("text1", getText1());
		this.hashColumns.put("text2", getText2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("high_light4", getHighLight4());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("high_light2", getHighLight2());
		this.hashColumns.put("inv_iss_ctnt", getInvIssCtnt());
		this.hashColumns.put("high_light3", getHighLight3());
		this.hashColumns.put("high_light1", getHighLight1());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("txt_no", getTxtNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("font_bold_flg", getFontBoldFlg());
		this.hashColumns.put("btn_event", getBtnEvent());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("search_option", getSearchOption());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("text3", "text3");
		this.hashFields.put("text4", "text4");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("text1", "text1");
		this.hashFields.put("text2", "text2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("high_light4", "highLight4");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("high_light2", "highLight2");
		this.hashFields.put("inv_iss_ctnt", "invIssCtnt");
		this.hashFields.put("high_light3", "highLight3");
		this.hashFields.put("high_light1", "highLight1");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("txt_no", "txtNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("font_bold_flg", "fontBoldFlg");
		this.hashFields.put("btn_event", "btnEvent");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("search_option", "searchOption");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return text3
	 */
	public String getText3() {
		return this.text3;
	}
	
	/**
	 * Column Info
	 * @return text4
	 */
	public String getText4() {
		return this.text4;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return text1
	 */
	public String getText1() {
		return this.text1;
	}
	
	/**
	 * Column Info
	 * @return text2
	 */
	public String getText2() {
		return this.text2;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return highLight4
	 */
	public String getHighLight4() {
		return this.highLight4;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return highLight2
	 */
	public String getHighLight2() {
		return this.highLight2;
	}
	
	/**
	 * Column Info
	 * @return invIssCtnt
	 */
	public String getInvIssCtnt() {
		return this.invIssCtnt;
	}
	
	/**
	 * Column Info
	 * @return highLight3
	 */
	public String getHighLight3() {
		return this.highLight3;
	}
	
	/**
	 * Column Info
	 * @return highLight1
	 */
	public String getHighLight1() {
		return this.highLight1;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return txtNo
	 */
	public String getTxtNo() {
		return this.txtNo;
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
	 * @return fontBoldFlg
	 */
	public String getFontBoldFlg() {
		return this.fontBoldFlg;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param text3
	 */
	public void setText3(String text3) {
		this.text3 = text3;
	}
	
	/**
	 * Column Info
	 * @param text4
	 */
	public void setText4(String text4) {
		this.text4 = text4;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param text1
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}
	
	/**
	 * Column Info
	 * @param text2
	 */
	public void setText2(String text2) {
		this.text2 = text2;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param highLight4
	 */
	public void setHighLight4(String highLight4) {
		this.highLight4 = highLight4;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param highLight2
	 */
	public void setHighLight2(String highLight2) {
		this.highLight2 = highLight2;
	}
	
	/**
	 * Column Info
	 * @param invIssCtnt
	 */
	public void setInvIssCtnt(String invIssCtnt) {
		this.invIssCtnt = invIssCtnt;
	}
	
	/**
	 * Column Info
	 * @param highLight3
	 */
	public void setHighLight3(String highLight3) {
		this.highLight3 = highLight3;
	}
	
	/**
	 * Column Info
	 * @param highLight1
	 */
	public void setHighLight1(String highLight1) {
		this.highLight1 = highLight1;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param txtNo
	 */
	public void setTxtNo(String txtNo) {
		this.txtNo = txtNo;
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
	 * @param fontBoldFlg
	 */
	public void setFontBoldFlg(String fontBoldFlg) {
		this.fontBoldFlg = fontBoldFlg;
	}
	
	public String getBtnEvent() {
		return btnEvent;
	}

	public void setBtnEvent(String btnEvent) {
		this.btnEvent = btnEvent;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setText3(JSPUtil.getParameter(request, "text3", ""));
		setText4(JSPUtil.getParameter(request, "text4", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setText1(JSPUtil.getParameter(request, "text1", ""));
		setText2(JSPUtil.getParameter(request, "text2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setHighLight4(JSPUtil.getParameter(request, "high_light4", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHighLight2(JSPUtil.getParameter(request, "high_light2", ""));
		setInvIssCtnt(JSPUtil.getParameter(request, "inv_iss_ctnt", ""));
		setHighLight3(JSPUtil.getParameter(request, "high_light3", ""));
		setHighLight1(JSPUtil.getParameter(request, "high_light1", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setTxtNo(JSPUtil.getParameter(request, "txt_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFontBoldFlg(JSPUtil.getParameter(request, "font_bold_flg", ""));
		setBtnEvent(JSPUtil.getParameter(request, "btn_event", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSearchOption(JSPUtil.getParameter(request, "search_option", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvIssAtchVO[]
	 */
	public InvIssAtchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvIssAtchVO[]
	 */
	public InvIssAtchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvIssAtchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] text3 = (JSPUtil.getParameter(request, prefix	+ "text3", length));
			String[] text4 = (JSPUtil.getParameter(request, prefix	+ "text4", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] text1 = (JSPUtil.getParameter(request, prefix	+ "text1", length));
			String[] text2 = (JSPUtil.getParameter(request, prefix	+ "text2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] highLight4 = (JSPUtil.getParameter(request, prefix	+ "high_light4", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] highLight2 = (JSPUtil.getParameter(request, prefix	+ "high_light2", length));
			String[] invIssCtnt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_ctnt", length));
			String[] highLight3 = (JSPUtil.getParameter(request, prefix	+ "high_light3", length));
			String[] highLight1 = (JSPUtil.getParameter(request, prefix	+ "high_light1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] txtNo = (JSPUtil.getParameter(request, prefix	+ "txt_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fontBoldFlg = (JSPUtil.getParameter(request, prefix	+ "font_bold_flg", length));
			String[] btnEvent = (JSPUtil.getParameter(request, prefix	+ "btn_event", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvIssAtchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (text3[i] != null)
					model.setText3(text3[i]);
				if (text4[i] != null)
					model.setText4(text4[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (text1[i] != null)
					model.setText1(text1[i]);
				if (text2[i] != null)
					model.setText2(text2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (highLight4[i] != null)
					model.setHighLight4(highLight4[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (highLight2[i] != null)
					model.setHighLight2(highLight2[i]);
				if (invIssCtnt[i] != null)
					model.setInvIssCtnt(invIssCtnt[i]);
				if (highLight3[i] != null)
					model.setHighLight3(highLight3[i]);
				if (highLight1[i] != null)
					model.setHighLight1(highLight1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (txtNo[i] != null)
					model.setTxtNo(txtNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fontBoldFlg[i] != null)
					model.setFontBoldFlg(fontBoldFlg[i]);
				if (btnEvent[i] != null)
					model.setBtnEvent(btnEvent[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvIssAtchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvIssAtchVO[]
	 */
	public InvIssAtchVO[] getInvIssAtchVOs(){
		InvIssAtchVO[] vos = (InvIssAtchVO[])models.toArray(new InvIssAtchVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.text3 = this.text3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.text4 = this.text4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.text1 = this.text1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.text2 = this.text2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highLight4 = this.highLight4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highLight2 = this.highLight2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCtnt = this.invIssCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highLight3 = this.highLight3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highLight1 = this.highLight1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtNo = this.txtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fontBoldFlg = this.fontBoldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btnEvent = this.btnEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
