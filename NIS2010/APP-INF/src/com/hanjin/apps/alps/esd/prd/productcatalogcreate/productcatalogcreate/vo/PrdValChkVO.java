/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdValChkVO.java
*@FileTitle : PrdValChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2009.08.22 이재위 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author 정선용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdValChkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdValChkVO> models = new ArrayList<PrdValChkVO>();
	
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String pcno = null;
	/* Column Info */
	private String valChkcd = null;
	/* Column Info */
	private String remark = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdValChkVO() {}

	public PrdValChkVO(String ibflag, String remark, String valChkcd, String pcno) {
		this.ibflag = ibflag;
		this.pcno = pcno;
		this.valChkcd = valChkcd;
		this.remark = remark;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pctl_no", getPcno());
		this.hashColumns.put("rout_val_chk_cd", getValChkcd());
		this.hashColumns.put("etc_rmk", getRemark());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pctl_no", "pcno");
		this.hashFields.put("rout_val_chk_cd", "valChkcd");
		this.hashFields.put("etc_rmk", "remark");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return pcno
	 */
	public String getPcno() {
		return this.pcno;
	}
	
	/**
	 * Column Info
	 * @return valChkcd
	 */
	public String getValChkcd() {
		return this.valChkcd;
	}
	
	/**
	 * Page Number
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param pcno
	 */
	public void setPcno(String pcno) {
		this.pcno = pcno;
	}

	
	/**
	 * Column Info
	 * @param valChkcd
	 */
	public void setValChkcd(String valChkcd) {
		this.valChkcd = valChkcd;
	}
	
	/**
	 * Page Number
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPcno(JSPUtil.getParameter(request, "pctl_no", ""));
		setValChkcd(JSPUtil.getParameter(request, "rout_val_chk_cd", ""));
		setRemark(JSPUtil.getParameter(request, "etc_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdValChkVO[]
	 */
	public PrdValChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	
	public PrdValChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdValChkVO model = null;

		int length = 0;
		try {

			String[] pcno = request.getParameterValues("pctl_no");
			String[] valChkcd = request.getParameterValues("rout_val_chk_cd");
			length = pcno.length;
			for (int i = 0; i < length; i++) {
				model = new PrdValChkVO();
				if (pcno[i] != null)
					model.setPcno(pcno[i]);
				if (valChkcd[i] != null)
					model.setValChkcd(valChkcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdValChkVOs();
	}
	/**
	 * VO 배열을 반환
	 * @return PrdValChkVO[]
	 */
	public PrdValChkVO[] getPrdValChkVOs(){
		PrdValChkVO[] vos = (PrdValChkVO[])models.toArray(new PrdValChkVO[models.size()]);
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
		this.pcno = this.pcno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valChkcd = this.valChkcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
