/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaContainerInfoVO.java
*@FileTitle : UsaContainerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.17 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaContainerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaContainerInfoVO> models = new ArrayList<UsaContainerInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String buf3 = null;
	/* Column Info */
	private String buf32 = null;	
	/* Column Info */
	private String buf33 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaContainerInfoVO() {}

	public UsaContainerInfoVO(String ibflag, String pagerows, String blNo, String buf3, String cntrNo, String buf32, String buf33) {
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.blNo = blNo;
		this.buf3 = buf3;
		this.buf32 = buf32;		
		this.buf33 = buf33;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("buf3", getBuf3());
		this.hashColumns.put("buf32", getBuf32());		
		this.hashColumns.put("buf33", getBuf33());		
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("buf3", "buf3");
		this.hashFields.put("buf32", "buf32");		
		this.hashFields.put("buf33", "buf33");
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return buf3
	 */
	public String getBuf3() {
		return this.buf3;
	}

	/**
	 * Column Info
	 * @return buf32
	 */
	public String getBuf32() {
		return this.buf32;
	}

	/**
	 * Column Info
	 * @return buf33
	 */
	public String getBuf33() {
		return this.buf33;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param buf3
	 */
	public void setBuf3(String buf3) {
		this.buf3 = buf3;
	}

	/**
	 * Column Info
	 * @param buf32
	 */
	public void setBuf32(String buf32) {
		this.buf32 = buf32;
	}

	/**
	 * Column Info
	 * @param buf33
	 */
	public void setBuf33(String buf33) {
		this.buf33 = buf33;
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
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBuf3(JSPUtil.getParameter(request, "buf3", ""));
		setBuf32(JSPUtil.getParameter(request, "buf32", ""));		
		setBuf33(JSPUtil.getParameter(request, "buf33", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaContainerInfoVO[]
	 */
	public UsaContainerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaContainerInfoVO[]
	 */
	public UsaContainerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaContainerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] buf3 = (JSPUtil.getParameter(request, prefix	+ "buf3", length));
			String[] buf32 = (JSPUtil.getParameter(request, prefix	+ "buf32", length));			
			String[] buf33 = (JSPUtil.getParameter(request, prefix	+ "buf33", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaContainerInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (buf3[i] != null)
					model.setBuf3(buf3[i]);
				if (buf32[i] != null)
					model.setBuf32(buf32[i]);				
				if (buf33[i] != null)
					model.setBuf33(buf33[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaContainerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaContainerInfoVO[]
	 */
	public UsaContainerInfoVO[] getUsaContainerInfoVOs(){
		UsaContainerInfoVO[] vos = (UsaContainerInfoVO[])models.toArray(new UsaContainerInfoVO[models.size()]);
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
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf3 = this.buf3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf32 = this.buf32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.buf33 = this.buf33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
