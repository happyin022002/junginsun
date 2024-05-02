/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCntrRlseOrderEdiYdVO.java
*@FileTitle : FullCntrRlseOrderEdiYdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.24 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FullCntrRlseOrderEdiYdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderEdiYdVO> models = new ArrayList<FullCntrRlseOrderEdiYdVO>();
	
	/* Column Info */
	private String sendId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sysDate = null;
	/* Column Info */
	private String receiverId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseOrderEdiYdVO() {}

	public FullCntrRlseOrderEdiYdVO(String ibflag, String pagerows, String sendId, String receiverId, String sysDate) {
		this.sendId = sendId;
		this.ibflag = ibflag;
		this.sysDate = sysDate;
		this.receiverId = receiverId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("send_id", getSendId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sys_date", getSysDate());
		this.hashColumns.put("receiver_id", getReceiverId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("send_id", "sendId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sys_date", "sysDate");
		this.hashFields.put("receiver_id", "receiverId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sendId
	 */
	public String getSendId() {
		return this.sendId;
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
	 * @return sysDate
	 */
	public String getSysDate() {
		return this.sysDate;
	}
	
	/**
	 * Column Info
	 * @return receiverId
	 */
	public String getReceiverId() {
		return this.receiverId;
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
	 * @param sendId
	 */
	public void setSendId(String sendId) {
		this.sendId = sendId;
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
	 * @param sysDate
	 */
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	
	/**
	 * Column Info
	 * @param receiverId
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
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
		setSendId(JSPUtil.getParameter(request, "send_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSysDate(JSPUtil.getParameter(request, "sys_date", ""));
		setReceiverId(JSPUtil.getParameter(request, "receiver_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseOrderEdiYdVO[]
	 */
	public FullCntrRlseOrderEdiYdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseOrderEdiYdVO[]
	 */
	public FullCntrRlseOrderEdiYdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrderEdiYdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sendId = (JSPUtil.getParameter(request, prefix	+ "send_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sysDate = (JSPUtil.getParameter(request, prefix	+ "sys_date", length));
			String[] receiverId = (JSPUtil.getParameter(request, prefix	+ "receiver_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrderEdiYdVO();
				if (sendId[i] != null)
					model.setSendId(sendId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sysDate[i] != null)
					model.setSysDate(sysDate[i]);
				if (receiverId[i] != null)
					model.setReceiverId(receiverId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseOrderEdiYdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseOrderEdiYdVO[]
	 */
	public FullCntrRlseOrderEdiYdVO[] getFullCntrRlseOrderEdiYdVOs(){
		FullCntrRlseOrderEdiYdVO[] vos = (FullCntrRlseOrderEdiYdVO[])models.toArray(new FullCntrRlseOrderEdiYdVO[models.size()]);
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
		this.sendId = this.sendId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDate = this.sysDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverId = this.receiverId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
