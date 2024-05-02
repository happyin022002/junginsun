/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FixDELLocationVO.java
*@FileTitle : FixDELLocationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.02 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FixDELLocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FixDELLocationVO> models = new ArrayList<FixDELLocationVO>();
	
	/* Column Info */
	private String delRgnCd = null;
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String delSteCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FixDELLocationVO() {}

	public FixDELLocationVO(String ibflag, String pagerows, String delContiCd, String delCntCd, String delRgnCd, String delSteCd, String delCd, String msgCd, String msgDesc) {
		this.delRgnCd = delRgnCd;
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.msgDesc = msgDesc;
		this.delCntCd = delCntCd;
		this.delContiCd = delContiCd;
		this.delCd = delCd;
		this.delSteCd = delSteCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_rgn_cd", getDelRgnCd());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("del_ste_cd", getDelSteCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_rgn_cd", "delRgnCd");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("del_ste_cd", "delSteCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delRgnCd
	 */
	public String getDelRgnCd() {
		return this.delRgnCd;
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return delSteCd
	 */
	public String getDelSteCd() {
		return this.delSteCd;
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
	 * @param delRgnCd
	 */
	public void setDelRgnCd(String delRgnCd) {
		this.delRgnCd = delRgnCd;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param delSteCd
	 */
	public void setDelSteCd(String delSteCd) {
		this.delSteCd = delSteCd;
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
		setDelRgnCd(JSPUtil.getParameter(request, "del_rgn_cd", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setDelContiCd(JSPUtil.getParameter(request, "del_conti_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setDelSteCd(JSPUtil.getParameter(request, "del_ste_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FixDELLocationVO[]
	 */
	public FixDELLocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FixDELLocationVO[]
	 */
	public FixDELLocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FixDELLocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delRgnCd = (JSPUtil.getParameter(request, prefix	+ "del_rgn_cd".trim(), length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc".trim(), length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd".trim(), length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] delSteCd = (JSPUtil.getParameter(request, prefix	+ "del_ste_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new FixDELLocationVO();
				if (delRgnCd[i] != null)
					model.setDelRgnCd(delRgnCd[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (delSteCd[i] != null)
					model.setDelSteCd(delSteCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFixDELLocationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FixDELLocationVO[]
	 */
	public FixDELLocationVO[] getFixDELLocationVOs(){
		FixDELLocationVO[] vos = (FixDELLocationVO[])models.toArray(new FixDELLocationVO[models.size()]);
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
		this.delRgnCd = this.delRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSteCd = this.delSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
