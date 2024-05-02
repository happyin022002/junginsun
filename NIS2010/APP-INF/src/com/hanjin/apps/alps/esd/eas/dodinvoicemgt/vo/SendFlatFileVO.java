/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SendFlatFileVO.java
*@FileTitle : SendFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.30  
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class SendFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendFlatFileVO> models = new ArrayList<SendFlatFileVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String queueNm = null;
	/* Column Info */
	private String flatFile = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendFlatFileVO() {}

	public SendFlatFileVO(String ibflag, String pagerows, String flatFile, String queueNm) {
		this.ibflag = ibflag;
		this.queueNm = queueNm;
		this.flatFile = flatFile;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("queue_nm", getQueueNm());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("queue_nm", "queueNm");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("sender_id", "senderId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return queueNm
	 */
	public String getQueueNm() {
		return this.queueNm;
	}
	
	/**
	 * Column Info
	 * @return flatFile
	 */
	public String getFlatFile() {
		return this.flatFile;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param queueNm
	 */
	public void setQueueNm(String queueNm) {
		this.queueNm = queueNm;
	}
	
	/**
	 * Column Info
	 * @param flatFile
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQueueNm(JSPUtil.getParameter(request, "queue_nm", ""));
		setFlatFile(JSPUtil.getParameter(request, "flat_file", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendFlatFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] queueNm = (JSPUtil.getParameter(request, prefix	+ "queue_nm", length));
			//String[] rcvId = (JSPUtil.getParameter(request, prefix	+ "rcv_id", length));
			String[] flatFile = (JSPUtil.getParameter(request, prefix	+ "flat_file", length));
			//String[] senderId = (JSPUtil.getParameter(request, prefix	+ "sender_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendFlatFileVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (queueNm[i] != null)
					model.setQueueNm(queueNm[i]);
				if (flatFile[i] != null)
					model.setFlatFile(flatFile[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[] getSendFlatFileVOs(){
		SendFlatFileVO[] vos = (SendFlatFileVO[])models.toArray(new SendFlatFileVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueNm = this.queueNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile = this.flatFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
