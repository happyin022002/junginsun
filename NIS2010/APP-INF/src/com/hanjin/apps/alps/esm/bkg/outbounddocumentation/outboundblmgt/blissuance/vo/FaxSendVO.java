/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxSendVO.java
*@FileTitle : FaxSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.04 박준용
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

public class FaxSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FaxSendVO> models = new ArrayList<FaxSendVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String batchFlg = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvInfo = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String tmplMrd = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String crtUserId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FaxSendVO() {}

	public FaxSendVO(String ibflag, String pagerows, String sysCd, String tmplMrd, String batchFlg, String title, String tmplParam, String rcvInfo, String office, String crtUserId) {
		this.office = office;
		this.batchFlg = batchFlg;
		this.title = title;
		this.ibflag = ibflag;
		this.rcvInfo = rcvInfo;
		this.tmplParam = tmplParam;
		this.tmplMrd = tmplMrd;
		this.sysCd = sysCd;
		this.crtUserId = crtUserId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("batch_flg", getBatchFlg());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_info", getRcvInfo());
		this.hashColumns.put("tmpl_param", getTmplParam());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("crt_user_id", getCrtUserId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("batch_flg", "batchFlg");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_info", "rcvInfo");
		this.hashFields.put("tmpl_param", "tmplParam");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("crt_user_id", "crtUserId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return rcvInfo
	 */
	public String getRcvInfo() {
		return this.rcvInfo;
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
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
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
	 * @return crtUserId
	 */
	public String getCrtUserId() {
		return this.crtUserId;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param rcvInfo
	 */
	public void setRcvInfo(String rcvInfo) {
		this.rcvInfo = rcvInfo;
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
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
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
	 * @param crtUserId
	 */
	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setBatchFlg(JSPUtil.getParameter(request, "batch_flg", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvInfo(JSPUtil.getParameter(request, "rcv_info", ""));
		setTmplParam(JSPUtil.getParameter(request, "tmpl_param", ""));
		setTmplMrd(JSPUtil.getParameter(request, "tmpl_mrd", ""));
		setSysCd(JSPUtil.getParameter(request, "sys_cd", ""));
		setCrtUserId(JSPUtil.getParameter(request, "crt_user_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FaxSendVO[]
	 */
	public FaxSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FaxSendVO[]
	 */
	public FaxSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FaxSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] batchFlg = (JSPUtil.getParameter(request, prefix	+ "batch_flg", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvInfo = (JSPUtil.getParameter(request, prefix	+ "rcv_info", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix	+ "tmpl_param", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] crtUserId = (JSPUtil.getParameter(request, prefix	+ "crt_user_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FaxSendVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (batchFlg[i] != null)
					model.setBatchFlg(batchFlg[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvInfo[i] != null)
					model.setRcvInfo(rcvInfo[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				if (tmplMrd[i] != null)
					model.setTmplMrd(tmplMrd[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (crtUserId[i] != null)
					model.setCrtUserId(crtUserId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFaxSendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FaxSendVO[]
	 */
	public FaxSendVO[] getFaxSendVOs(){
		FaxSendVO[] vos = (FaxSendVO[])models.toArray(new FaxSendVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchFlg = this.batchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInfo = this.rcvInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtUserId = this.crtUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
