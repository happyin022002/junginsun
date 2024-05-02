/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SamsungEDISendVO.java
 *@FileTitle : SamsungEDISendVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 박정진
 *@LastVersion : 1.0
 * 2009.10.05 박정진 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungEDISendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungEDISendVO> models = new ArrayList<SamsungEDISendVO>();
	
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String msgNo = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String updUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungEDISendVO() {}
	
	public SamsungEDISendVO(String msgId, String msgNo, String blSrcNo, String updUsrId) {
		this.msgId = msgId;
		this.msgNo = msgNo;
		this.blSrcNo = blSrcNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("msg_no", getMsgNo());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("msg_no", "msgNo");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	private List<String> samsungEDISendBLNoList = null;
	
	private SamsungEDISendBLVO samsungEDISendBL = null;

	private List<SamsungEDISendChargeVO> samsungEDISendChargeList = null;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public List<String> getSamsungEDISendBLNoList() {
		return samsungEDISendBLNoList;
	}

	public void setSamsungEDISendBLNoList(List<String> samsungEDISendBLNoList) {
		this.samsungEDISendBLNoList = samsungEDISendBLNoList;
	}

	public SamsungEDISendBLVO getSamsungEDISendBL() {
		return samsungEDISendBL;
	}

	public void setSamsungEDISendBL(SamsungEDISendBLVO samsungEDISendBL) {
		this.samsungEDISendBL = samsungEDISendBL;
	}

	public List<SamsungEDISendChargeVO> getSamsungEDISendChargeList() {
		return samsungEDISendChargeList;
	}

	public void setSamsungEDISendChargeList(List<SamsungEDISendChargeVO> samsungEDISendChargeList) {
		this.samsungEDISendChargeList = samsungEDISendChargeList;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setMsgNo(JSPUtil.getParameter(request, "msg_no", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungEDISendBLVO[]
	 */
	public SamsungEDISendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungEDISendBLVO[]
	 */
	public SamsungEDISendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungEDISendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] msgNo = (JSPUtil.getParameter(request, prefix	+ "msg_no", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungEDISendVO();
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (msgNo[i] != null)
					model.setMsgNo(msgNo[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungEDISendVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return SamsungEDISendVO[]
	 */
	public SamsungEDISendVO[] getSamsungEDISendVOs(){
		SamsungEDISendVO[] vos = (SamsungEDISendVO[])models.toArray(new SamsungEDISendVO[models.size()]);
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
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNo = this.msgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
