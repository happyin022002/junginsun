/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondtionOpertionVO.java
*@FileTitle : CondtionOpertionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.05 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondtionOpertionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondtionOpertionVO> models = new ArrayList<CondtionOpertionVO>();
	
	/* Column Info */
	private String intgCdValDesc = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String intgCdValCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondtionOpertionVO() {}

	public CondtionOpertionVO(String ibflag, String pagerows, String intgCdValCtnt, String intgCdValDesc) {
		this.intgCdValDesc = intgCdValDesc;
		this.ibflag = ibflag;
		this.intgCdValCtnt = intgCdValCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("intg_cd_val_desc", getIntgCdValDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("intg_cd_val_desc", "intgCdValDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDesc
	 */
	public String getIntgCdValDesc() {
		return this.intgCdValDesc;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return intgCdValCtnt
	 */
	public String getIntgCdValCtnt() {
		return this.intgCdValCtnt;
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
	 * @param intgCdValDesc
	 */
	public void setIntgCdValDesc(String intgCdValDesc) {
		this.intgCdValDesc = intgCdValDesc;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param intgCdValCtnt
	 */
	public void setIntgCdValCtnt(String intgCdValCtnt) {
		this.intgCdValCtnt = intgCdValCtnt;
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
		setIntgCdValDesc(JSPUtil.getParameter(request, "intg_cd_val_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIntgCdValCtnt(JSPUtil.getParameter(request, "intg_cd_val_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondtionOpertionVO[]
	 */
	public CondtionOpertionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondtionOpertionVO[]
	 */
	public CondtionOpertionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondtionOpertionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] intgCdValDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_ctnt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondtionOpertionVO();
				if (intgCdValDesc[i] != null)
					model.setIntgCdValDesc(intgCdValDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (intgCdValCtnt[i] != null)
					model.setIntgCdValCtnt(intgCdValCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondtionOpertionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondtionOpertionVO[]
	 */
	public CondtionOpertionVO[] getCondtionOpertionVOs(){
		CondtionOpertionVO[] vos = (CondtionOpertionVO[])models.toArray(new CondtionOpertionVO[models.size()]);
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
		this.intgCdValDesc = this.intgCdValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValCtnt = this.intgCdValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}