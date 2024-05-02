/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSLongStaydaysEnvINVO.java
*@FileTitle : CHSLongStaydaysEnvINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.22 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSLongStaydaysEnvINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSLongStaydaysEnvINVO> models = new ArrayList<CHSLongStaydaysEnvINVO>();
	
	/* Column Info */
	private String n2ndInqFmDys = null;
	/* Column Info */
	private String n5thInqToDys = null;
	/* Column Info */
	private String stayDysInpUsrId = null;
	/* Column Info */
	private String n4thInqFmDys = null;
	/* Column Info */
	private String n3rdInqFmDys = null;
	/* Column Info */
	private String n3rdInqToDys = null;
	/* Column Info */
	private String n4thInqToDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n1stInqFmDys = null;
	/* Column Info */
	private String n2ndInqToDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1stInqToDys = null;
	/* Column Info */
	private String n5thInqFmDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSLongStaydaysEnvINVO() {}

	public CHSLongStaydaysEnvINVO(String ibflag, String pagerows, String stayDysInpUsrId, String n1stInqFmDys, String n1stInqToDys, String n2ndInqFmDys, String n2ndInqToDys, String n3rdInqFmDys, String n3rdInqToDys, String n4thInqFmDys, String n4thInqToDys, String n5thInqFmDys, String n5thInqToDys) {
		this.n2ndInqFmDys = n2ndInqFmDys;
		this.n5thInqToDys = n5thInqToDys;
		this.stayDysInpUsrId = stayDysInpUsrId;
		this.n4thInqFmDys = n4thInqFmDys;
		this.n3rdInqFmDys = n3rdInqFmDys;
		this.n3rdInqToDys = n3rdInqToDys;
		this.n4thInqToDys = n4thInqToDys;
		this.pagerows = pagerows;
		this.n1stInqFmDys = n1stInqFmDys;
		this.n2ndInqToDys = n2ndInqToDys;
		this.ibflag = ibflag;
		this.n1stInqToDys = n1stInqToDys;
		this.n5thInqFmDys = n5thInqFmDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_inq_fm_dys", getN2ndInqFmDys());
		this.hashColumns.put("n5th_inq_to_dys", getN5thInqToDys());
		this.hashColumns.put("stay_dys_inp_usr_id", getStayDysInpUsrId());
		this.hashColumns.put("n4th_inq_fm_dys", getN4thInqFmDys());
		this.hashColumns.put("n3rd_inq_fm_dys", getN3rdInqFmDys());
		this.hashColumns.put("n3rd_inq_to_dys", getN3rdInqToDys());
		this.hashColumns.put("n4th_inq_to_dys", getN4thInqToDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n1st_inq_fm_dys", getN1stInqFmDys());
		this.hashColumns.put("n2nd_inq_to_dys", getN2ndInqToDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1st_inq_to_dys", getN1stInqToDys());
		this.hashColumns.put("n5th_inq_fm_dys", getN5thInqFmDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n2nd_inq_fm_dys", "n2ndInqFmDys");
		this.hashFields.put("n5th_inq_to_dys", "n5thInqToDys");
		this.hashFields.put("stay_dys_inp_usr_id", "stayDysInpUsrId");
		this.hashFields.put("n4th_inq_fm_dys", "n4thInqFmDys");
		this.hashFields.put("n3rd_inq_fm_dys", "n3rdInqFmDys");
		this.hashFields.put("n3rd_inq_to_dys", "n3rdInqToDys");
		this.hashFields.put("n4th_inq_to_dys", "n4thInqToDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n1st_inq_fm_dys", "n1stInqFmDys");
		this.hashFields.put("n2nd_inq_to_dys", "n2ndInqToDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1st_inq_to_dys", "n1stInqToDys");
		this.hashFields.put("n5th_inq_fm_dys", "n5thInqFmDys");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n2ndInqFmDys
	 */
	public String getN2ndInqFmDys() {
		return this.n2ndInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return n5thInqToDys
	 */
	public String getN5thInqToDys() {
		return this.n5thInqToDys;
	}
	
	/**
	 * Column Info
	 * @return stayDysInpUsrId
	 */
	public String getStayDysInpUsrId() {
		return this.stayDysInpUsrId;
	}
	
	/**
	 * Column Info
	 * @return n4thInqFmDys
	 */
	public String getN4thInqFmDys() {
		return this.n4thInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return n3rdInqFmDys
	 */
	public String getN3rdInqFmDys() {
		return this.n3rdInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return n3rdInqToDys
	 */
	public String getN3rdInqToDys() {
		return this.n3rdInqToDys;
	}
	
	/**
	 * Column Info
	 * @return n4thInqToDys
	 */
	public String getN4thInqToDys() {
		return this.n4thInqToDys;
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
	 * @return n1stInqFmDys
	 */
	public String getN1stInqFmDys() {
		return this.n1stInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return n2ndInqToDys
	 */
	public String getN2ndInqToDys() {
		return this.n2ndInqToDys;
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
	 * @return n1stInqToDys
	 */
	public String getN1stInqToDys() {
		return this.n1stInqToDys;
	}
	
	/**
	 * Column Info
	 * @return n5thInqFmDys
	 */
	public String getN5thInqFmDys() {
		return this.n5thInqFmDys;
	}
	

	/**
	 * Column Info
	 * @param n2ndInqFmDys
	 */
	public void setN2ndInqFmDys(String n2ndInqFmDys) {
		this.n2ndInqFmDys = n2ndInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param n5thInqToDys
	 */
	public void setN5thInqToDys(String n5thInqToDys) {
		this.n5thInqToDys = n5thInqToDys;
	}
	
	/**
	 * Column Info
	 * @param stayDysInpUsrId
	 */
	public void setStayDysInpUsrId(String stayDysInpUsrId) {
		this.stayDysInpUsrId = stayDysInpUsrId;
	}
	
	/**
	 * Column Info
	 * @param n4thInqFmDys
	 */
	public void setN4thInqFmDys(String n4thInqFmDys) {
		this.n4thInqFmDys = n4thInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param n3rdInqFmDys
	 */
	public void setN3rdInqFmDys(String n3rdInqFmDys) {
		this.n3rdInqFmDys = n3rdInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param n3rdInqToDys
	 */
	public void setN3rdInqToDys(String n3rdInqToDys) {
		this.n3rdInqToDys = n3rdInqToDys;
	}
	
	/**
	 * Column Info
	 * @param n4thInqToDys
	 */
	public void setN4thInqToDys(String n4thInqToDys) {
		this.n4thInqToDys = n4thInqToDys;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param n1stInqFmDys
	 */
	public void setN1stInqFmDys(String n1stInqFmDys) {
		this.n1stInqFmDys = n1stInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param n2ndInqToDys
	 */
	public void setN2ndInqToDys(String n2ndInqToDys) {
		this.n2ndInqToDys = n2ndInqToDys;
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
	 * @param n1stInqToDys
	 */
	public void setN1stInqToDys(String n1stInqToDys) {
		this.n1stInqToDys = n1stInqToDys;
	}
	
	/**
	 * Column Info
	 * @param n5thInqFmDys
	 */
	public void setN5thInqFmDys(String n5thInqFmDys) {
		this.n5thInqFmDys = n5thInqFmDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN2ndInqFmDys(JSPUtil.getParameter(request, "n2nd_inq_fm_dys", ""));
		setN5thInqToDys(JSPUtil.getParameter(request, "n5th_inq_to_dys", ""));
		setStayDysInpUsrId(JSPUtil.getParameter(request, "stay_dys_inp_usr_id", ""));
		setN4thInqFmDys(JSPUtil.getParameter(request, "n4th_inq_fm_dys", ""));
		setN3rdInqFmDys(JSPUtil.getParameter(request, "n3rd_inq_fm_dys", ""));
		setN3rdInqToDys(JSPUtil.getParameter(request, "n3rd_inq_to_dys", ""));
		setN4thInqToDys(JSPUtil.getParameter(request, "n4th_inq_to_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN1stInqFmDys(JSPUtil.getParameter(request, "n1st_inq_fm_dys", ""));
		setN2ndInqToDys(JSPUtil.getParameter(request, "n2nd_inq_to_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN1stInqToDys(JSPUtil.getParameter(request, "n1st_inq_to_dys", ""));
		setN5thInqFmDys(JSPUtil.getParameter(request, "n5th_inq_fm_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSLongStaydaysEnvINVO[]
	 */
	public CHSLongStaydaysEnvINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSLongStaydaysEnvINVO[]
	 */
	public CHSLongStaydaysEnvINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSLongStaydaysEnvINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n2ndInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n2nd_inq_fm_dys", length));
			String[] n5thInqToDys = (JSPUtil.getParameter(request, prefix	+ "n5th_inq_to_dys", length));
			String[] stayDysInpUsrId = (JSPUtil.getParameter(request, prefix	+ "stay_dys_inp_usr_id", length));
			String[] n4thInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n4th_inq_fm_dys", length));
			String[] n3rdInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n3rd_inq_fm_dys", length));
			String[] n3rdInqToDys = (JSPUtil.getParameter(request, prefix	+ "n3rd_inq_to_dys", length));
			String[] n4thInqToDys = (JSPUtil.getParameter(request, prefix	+ "n4th_inq_to_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n1stInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n1st_inq_fm_dys", length));
			String[] n2ndInqToDys = (JSPUtil.getParameter(request, prefix	+ "n2nd_inq_to_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n1stInqToDys = (JSPUtil.getParameter(request, prefix	+ "n1st_inq_to_dys", length));
			String[] n5thInqFmDys = (JSPUtil.getParameter(request, prefix	+ "n5th_inq_fm_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSLongStaydaysEnvINVO();
				if (n2ndInqFmDys[i] != null)
					model.setN2ndInqFmDys(n2ndInqFmDys[i]);
				if (n5thInqToDys[i] != null)
					model.setN5thInqToDys(n5thInqToDys[i]);
				if (stayDysInpUsrId[i] != null)
					model.setStayDysInpUsrId(stayDysInpUsrId[i]);
				if (n4thInqFmDys[i] != null)
					model.setN4thInqFmDys(n4thInqFmDys[i]);
				if (n3rdInqFmDys[i] != null)
					model.setN3rdInqFmDys(n3rdInqFmDys[i]);
				if (n3rdInqToDys[i] != null)
					model.setN3rdInqToDys(n3rdInqToDys[i]);
				if (n4thInqToDys[i] != null)
					model.setN4thInqToDys(n4thInqToDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n1stInqFmDys[i] != null)
					model.setN1stInqFmDys(n1stInqFmDys[i]);
				if (n2ndInqToDys[i] != null)
					model.setN2ndInqToDys(n2ndInqToDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1stInqToDys[i] != null)
					model.setN1stInqToDys(n1stInqToDys[i]);
				if (n5thInqFmDys[i] != null)
					model.setN5thInqFmDys(n5thInqFmDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSLongStaydaysEnvINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSLongStaydaysEnvINVO[]
	 */
	public CHSLongStaydaysEnvINVO[] getCHSLongStaydaysEnvINVOs(){
		CHSLongStaydaysEnvINVO[] vos = (CHSLongStaydaysEnvINVO[])models.toArray(new CHSLongStaydaysEnvINVO[models.size()]);
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
		this.n2ndInqFmDys = this.n2ndInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thInqToDys = this.n5thInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDysInpUsrId = this.stayDysInpUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thInqFmDys = this.n4thInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdInqFmDys = this.n3rdInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdInqToDys = this.n3rdInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thInqToDys = this.n4thInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInqFmDys = this.n1stInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInqToDys = this.n2ndInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInqToDys = this.n1stInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thInqFmDys = this.n5thInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
