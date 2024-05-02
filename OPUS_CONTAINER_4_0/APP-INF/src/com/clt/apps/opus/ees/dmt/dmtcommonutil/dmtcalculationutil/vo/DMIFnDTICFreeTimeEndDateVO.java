/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMIFnDTICFreeTimeEndDateVO.java
*@FileTitle : DMIFnDTICFreeTimeEndDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.03 최성환 
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

public class DMIFnDTICFreeTimeEndDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DMIFnDTICFreeTimeEndDateVO> models = new ArrayList<DMIFnDTICFreeTimeEndDateVO>();
	
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String dticFtOver = null;
	/* Column Info */
	private String dmifFtEnd = null;
	/* Column Info */
	private String dticFtEnd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DMIFnDTICFreeTimeEndDateVO() {}

	public DMIFnDTICFreeTimeEndDateVO(String ibflag, String pagerows, String dmifFtEnd, String dticFtEnd, String dticFtOver, String msgCd, String msgDesc) {
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.msgDesc = msgDesc;
		this.dticFtOver = dticFtOver;
		this.dmifFtEnd = dmifFtEnd;
		this.dticFtEnd = dticFtEnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("dtic_ft_over", getDticFtOver());
		this.hashColumns.put("dmif_ft_end", getDmifFtEnd());
		this.hashColumns.put("dtic_ft_end", getDticFtEnd());
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
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("dtic_ft_over", "dticFtOver");
		this.hashFields.put("dmif_ft_end", "dmifFtEnd");
		this.hashFields.put("dtic_ft_end", "dticFtEnd");
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return dticFtOver
	 */
	public String getDticFtOver() {
		return this.dticFtOver;
	}
	
	/**
	 * Column Info
	 * @return dmifFtEnd
	 */
	public String getDmifFtEnd() {
		return this.dmifFtEnd;
	}
	
	/**
	 * Column Info
	 * @return dticFtEnd
	 */
	public String getDticFtEnd() {
		return this.dticFtEnd;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param dticFtOver
	 */
	public void setDticFtOver(String dticFtOver) {
		this.dticFtOver = dticFtOver;
	}
	
	/**
	 * Column Info
	 * @param dmifFtEnd
	 */
	public void setDmifFtEnd(String dmifFtEnd) {
		this.dmifFtEnd = dmifFtEnd;
	}
	
	/**
	 * Column Info
	 * @param dticFtEnd
	 */
	public void setDticFtEnd(String dticFtEnd) {
		this.dticFtEnd = dticFtEnd;
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
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setDticFtOver(JSPUtil.getParameter(request, "dtic_ft_over", ""));
		setDmifFtEnd(JSPUtil.getParameter(request, "dmif_ft_end", ""));
		setDticFtEnd(JSPUtil.getParameter(request, "dtic_ft_end", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DMIFnDTICFreeTimeEndDateVO[]
	 */
	public DMIFnDTICFreeTimeEndDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DMIFnDTICFreeTimeEndDateVO[]
	 */
	public DMIFnDTICFreeTimeEndDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DMIFnDTICFreeTimeEndDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] dticFtOver = (JSPUtil.getParameter(request, prefix	+ "dtic_ft_over", length));
			String[] dmifFtEnd = (JSPUtil.getParameter(request, prefix	+ "dmif_ft_end", length));
			String[] dticFtEnd = (JSPUtil.getParameter(request, prefix	+ "dtic_ft_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DMIFnDTICFreeTimeEndDateVO();
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (dticFtOver[i] != null)
					model.setDticFtOver(dticFtOver[i]);
				if (dmifFtEnd[i] != null)
					model.setDmifFtEnd(dmifFtEnd[i]);
				if (dticFtEnd[i] != null)
					model.setDticFtEnd(dticFtEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDMIFnDTICFreeTimeEndDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DMIFnDTICFreeTimeEndDateVO[]
	 */
	public DMIFnDTICFreeTimeEndDateVO[] getDMIFnDTICFreeTimeEndDateVOs(){
		DMIFnDTICFreeTimeEndDateVO[] vos = (DMIFnDTICFreeTimeEndDateVO[])models.toArray(new DMIFnDTICFreeTimeEndDateVO[models.size()]);
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
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticFtOver = this.dticFtOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifFtEnd = this.dmifFtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticFtEnd = this.dticFtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
