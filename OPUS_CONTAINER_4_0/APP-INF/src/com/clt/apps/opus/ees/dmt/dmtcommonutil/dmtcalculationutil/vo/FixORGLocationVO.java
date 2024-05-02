/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FixORGLocationVO.java
*@FileTitle : FixORGLocationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FixORGLocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FixORGLocationVO> models = new ArrayList<FixORGLocationVO>();
	
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgCntCd = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String orgContiCd = null;
	/* Column Info */
	private String orgRgnCd = null;
	/* Column Info */
	private String orgSteCd = null;
	/* Column Info */
	private String orgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FixORGLocationVO() {}

	public FixORGLocationVO(String ibflag, String pagerows, String orgContiCd, String orgCntCd, String orgRgnCd, String orgSteCd, String orgCd, String msgCd, String msgDesc) {
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.orgCntCd = orgCntCd;
		this.msgDesc = msgDesc;
		this.orgContiCd = orgContiCd;
		this.orgRgnCd = orgRgnCd;
		this.orgSteCd = orgSteCd;
		this.orgCd = orgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_cnt_cd", getOrgCntCd());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("org_conti_cd", getOrgContiCd());
		this.hashColumns.put("org_rgn_cd", getOrgRgnCd());
		this.hashColumns.put("org_ste_cd", getOrgSteCd());
		this.hashColumns.put("org_cd", getOrgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_cnt_cd", "orgCntCd");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("org_conti_cd", "orgContiCd");
		this.hashFields.put("org_rgn_cd", "orgRgnCd");
		this.hashFields.put("org_ste_cd", "orgSteCd");
		this.hashFields.put("org_cd", "orgCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
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
	 * @return orgCntCd
	 */
	public String getOrgCntCd() {
		return this.orgCntCd;
	}
	
	/**
	 * Column Info
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return orgContiCd
	 */
	public String getOrgContiCd() {
		return this.orgContiCd;
	}
	
	/**
	 * Column Info
	 * @return orgRgnCd
	 */
	public String getOrgRgnCd() {
		return this.orgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return orgSteCd
	 */
	public String getOrgSteCd() {
		return this.orgSteCd;
	}
	
	/**
	 * Column Info
	 * @return orgCd
	 */
	public String getOrgCd() {
		return this.orgCd;
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
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
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
	 * @param orgCntCd
	 */
	public void setOrgCntCd(String orgCntCd) {
		this.orgCntCd = orgCntCd;
	}
	
	/**
	 * Column Info
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param orgContiCd
	 */
	public void setOrgContiCd(String orgContiCd) {
		this.orgContiCd = orgContiCd;
	}
	
	/**
	 * Column Info
	 * @param orgRgnCd
	 */
	public void setOrgRgnCd(String orgRgnCd) {
		this.orgRgnCd = orgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param orgSteCd
	 */
	public void setOrgSteCd(String orgSteCd) {
		this.orgSteCd = orgSteCd;
	}
	
	/**
	 * Column Info
	 * @param orgCd
	 */
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
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
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgCntCd(JSPUtil.getParameter(request, "org_cnt_cd", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setOrgContiCd(JSPUtil.getParameter(request, "org_conti_cd", ""));
		setOrgRgnCd(JSPUtil.getParameter(request, "org_rgn_cd", ""));
		setOrgSteCd(JSPUtil.getParameter(request, "org_ste_cd", ""));
		setOrgCd(JSPUtil.getParameter(request, "org_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FixORGLocationVO[]
	 */
	public FixORGLocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FixORGLocationVO[]
	 */
	public FixORGLocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FixORGLocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgCntCd = (JSPUtil.getParameter(request, prefix	+ "org_cnt_cd", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] orgContiCd = (JSPUtil.getParameter(request, prefix	+ "org_conti_cd", length));
			String[] orgRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_rgn_cd", length));
			String[] orgSteCd = (JSPUtil.getParameter(request, prefix	+ "org_ste_cd", length));
			String[] orgCd = (JSPUtil.getParameter(request, prefix	+ "org_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FixORGLocationVO();
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgCntCd[i] != null)
					model.setOrgCntCd(orgCntCd[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (orgContiCd[i] != null)
					model.setOrgContiCd(orgContiCd[i]);
				if (orgRgnCd[i] != null)
					model.setOrgRgnCd(orgRgnCd[i]);
				if (orgSteCd[i] != null)
					model.setOrgSteCd(orgSteCd[i]);
				if (orgCd[i] != null)
					model.setOrgCd(orgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFixORGLocationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FixORGLocationVO[]
	 */
	public FixORGLocationVO[] getFixORGLocationVOs(){
		FixORGLocationVO[] vos = (FixORGLocationVO[])models.toArray(new FixORGLocationVO[models.size()]);
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
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntCd = this.orgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgContiCd = this.orgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRgnCd = this.orgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSteCd = this.orgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCd = this.orgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
