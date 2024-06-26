/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RjctSndrRcvrVO.java
*@FileTitle : RjctSndrRcvrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RjctSndrRcvrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RjctSndrRcvrVO> models = new ArrayList<RjctSndrRcvrVO>();
	
	/* Column Info */
	private String flatFileType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvId = null;
	/* Column Info */
	private String sndrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RjctSndrRcvrVO() {}

	public RjctSndrRcvrVO(String ibflag, String pagerows, String rcvId, String sndrId, String flatFileType) {
		this.flatFileType = flatFileType;
		this.ibflag = ibflag;
		this.rcvId = rcvId;
		this.sndrId = sndrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flat_file_type", getFlatFileType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_id", getRcvId());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flat_file_type", "flatFileType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return flatFileType
	 */
	public String getFlatFileType() {
		return this.flatFileType;
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
	 * @return rcvId
	 */
	public String getRcvId() {
		return this.rcvId;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
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
	 * @param flatFileType
	 */
	public void setFlatFileType(String flatFileType) {
		this.flatFileType = flatFileType;
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
	 * @param rcvId
	 */
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
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
		setFlatFileType(JSPUtil.getParameter(request, "flat_file_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvId(JSPUtil.getParameter(request, "rcv_id", ""));
		setSndrId(JSPUtil.getParameter(request, "sndr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RjctSndrRcvrVO[]
	 */
	public RjctSndrRcvrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RjctSndrRcvrVO[]
	 */
	public RjctSndrRcvrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RjctSndrRcvrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] flatFileType = (JSPUtil.getParameter(request, prefix	+ "flat_file_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvId = (JSPUtil.getParameter(request, prefix	+ "rcv_id", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RjctSndrRcvrVO();
				if (flatFileType[i] != null)
					model.setFlatFileType(flatFileType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvId[i] != null)
					model.setRcvId(rcvId[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRjctSndrRcvrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RjctSndrRcvrVO[]
	 */
	public RjctSndrRcvrVO[] getRjctSndrRcvrVOs(){
		RjctSndrRcvrVO[] vos = (RjctSndrRcvrVO[])models.toArray(new RjctSndrRcvrVO[models.size()]);
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
		this.flatFileType = this.flatFileType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvId = this.rcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
