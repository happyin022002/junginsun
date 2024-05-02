/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialListDetailVO.java
*@FileTitle : SpecialListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.08
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialListDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SpecialListDetailVO> models = new ArrayList<SpecialListDetailVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclIdDesc = null;
	/* Column Info */
	private String oldImdgUnNo = null;
	/* Column Info */
	private String anrSpclTpId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SpecialListDetailVO() {}

	public SpecialListDetailVO(String ibflag, String pagerows, String imdgUnNo, String oldImdgUnNo, String anrSpclTpId, String spclIdDesc) {
		this.ibflag = ibflag;
		this.spclIdDesc = spclIdDesc;
		this.oldImdgUnNo = oldImdgUnNo;
		this.anrSpclTpId = anrSpclTpId;
		this.imdgUnNo = imdgUnNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_id_desc", getSpclIdDesc());
		this.hashColumns.put("old_imdg_un_no", getOldImdgUnNo());
		this.hashColumns.put("anr_spcl_tp_id", getAnrSpclTpId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_id_desc", "spclIdDesc");
		this.hashFields.put("old_imdg_un_no", "oldImdgUnNo");
		this.hashFields.put("anr_spcl_tp_id", "anrSpclTpId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
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
	 * @return spclIdDesc
	 */
	public String getSpclIdDesc() {
		return this.spclIdDesc;
	}

	/**
	 * Column Info
	 * @return oldImdgUnNo
	 */
	public String getOldImdgUnNo() {
		return this.oldImdgUnNo;
	}

	/**
	 * Column Info
	 * @return anrSpclTpId
	 */
	public String getAnrSpclTpId() {
		return this.anrSpclTpId;
	}

	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @param spclIdDesc
	 */
	public void setSpclIdDesc(String spclIdDesc) {
		this.spclIdDesc = spclIdDesc;
	}

	/**
	 * Column Info
	 * @param oldImdgUnNo
	 */
	public void setOldImdgUnNo(String oldImdgUnNo) {
		this.oldImdgUnNo = oldImdgUnNo;
	}

	/**
	 * Column Info
	 * @param anrSpclTpId
	 */
	public void setAnrSpclTpId(String anrSpclTpId) {
		this.anrSpclTpId = anrSpclTpId;
	}

	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
		setSpclIdDesc(JSPUtil.getParameter(request, "spcl_id_desc", ""));
		setOldImdgUnNo(JSPUtil.getParameter(request, "old_imdg_un_no", ""));
		setAnrSpclTpId(JSPUtil.getParameter(request, "anr_spcl_tp_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialListDetailVO[]
	 */
	public SpecialListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SpecialListDetailVO[]
	 */
	public SpecialListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialListDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclIdDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_id_desc", length));
			String[] oldImdgUnNo = (JSPUtil.getParameter(request, prefix	+ "old_imdg_un_no", length));
			String[] anrSpclTpId = (JSPUtil.getParameter(request, prefix	+ "anr_spcl_tp_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SpecialListDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclIdDesc[i] != null)
					model.setSpclIdDesc(spclIdDesc[i]);
				if (oldImdgUnNo[i] != null)
					model.setOldImdgUnNo(oldImdgUnNo[i]);
				if (anrSpclTpId[i] != null)
					model.setAnrSpclTpId(anrSpclTpId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialListDetailVO[]
	 */
	public SpecialListDetailVO[] getSpecialListDetailVOs(){
		SpecialListDetailVO[] vos = (SpecialListDetailVO[])models.toArray(new SpecialListDetailVO[models.size()]);
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
		this.spclIdDesc = this.spclIdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldImdgUnNo = this.oldImdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrSpclTpId = this.anrSpclTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
