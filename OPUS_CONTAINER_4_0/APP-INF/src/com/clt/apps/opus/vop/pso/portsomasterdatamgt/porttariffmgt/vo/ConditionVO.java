/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConditionVO.java
*@FileTitle : ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.23 박명종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConditionVO> models = new ArrayList<ConditionVO>();
	
	/* Column Info */
	private String objName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String objValue = null;
	/* Column Info */
	private String uom = null;
	/* Column Info */
	private String condition = null;
	/* Column Info */
	private String condid = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String lineNum = null;
	/* Column Info */
	private String conddes = null;
	/* Column Info */
	private String object = null;
	/* Column Info */
	private String operator = null;
	/* Page Number */
	private String pagerows = null;
	
	private String creUsrId = null;
	/* Column Info */
	private String objListNo = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConditionVO() {}

	public ConditionVO(String ibflag, String pagerows, String condition, String object, String uom, String operator, String objValue, String condid, String conddes, String objName, String lineNum, String seq, String creUsrId, String objListNo) {
		this.objName = objName;
		this.ibflag = ibflag;
		this.objValue = objValue;
		this.uom = uom;
		this.condition = condition;
		this.condid = condid;
		this.seq = seq;
		this.lineNum = lineNum;
		this.conddes = conddes;
		this.object = object;
		this.operator = operator;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.objListNo = objListNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obj_name", getObjName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obj_value", getObjValue());
		this.hashColumns.put("uom", getUom());
		this.hashColumns.put("condition", getCondition());
		this.hashColumns.put("condid", getCondid());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("line_num", getLineNum());
		this.hashColumns.put("conddes", getConddes());
		this.hashColumns.put("object", getObject());
		this.hashColumns.put("operator", getOperator());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("obj_list_no", getObjListNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obj_name", "objName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obj_value", "objValue");
		this.hashFields.put("uom", "uom");
		this.hashFields.put("condition", "condition");
		this.hashFields.put("condid", "condid");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("line_num", "lineNum");
		this.hashFields.put("conddes", "conddes");
		this.hashFields.put("object", "object");
		this.hashFields.put("operator", "operator");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("obj_list_no", "objListNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return objName
	 */
	public String getObjName() {
		return this.objName;
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
	 * @return objValue
	 */
	public String getObjValue() {
		return this.objValue;
	}
	
	/**
	 * Column Info
	 * @return uom
	 */
	public String getUom() {
		return this.uom;
	}
	
	/**
	 * Column Info
	 * @return condition
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Column Info
	 * @return condid
	 */
	public String getCondid() {
		return this.condid;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return lineNum
	 */
	public String getLineNum() {
		return this.lineNum;
	}
	
	/**
	 * Column Info
	 * @return conddes
	 */
	public String getConddes() {
		return this.conddes;
	}
	
	/**
	 * Column Info
	 * @return object
	 */
	public String getObject() {
		return this.object;
	}
	
	/**
	 * Column Info
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
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
	 * @param objName
	 */
	public void setObjName(String objName) {
		this.objName = objName;
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
	 * @param objValue
	 */
	public void setObjValue(String objValue) {
		this.objValue = objValue;
	}
	
	/**
	 * Column Info
	 * @param uom
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}
	
	/**
	 * Column Info
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Column Info
	 * @param condid
	 */
	public void setCondid(String condid) {
		this.condid = condid;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param lineNum
	 */
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	
	/**
	 * Column Info
	 * @param conddes
	 */
	public void setConddes(String conddes) {
		this.conddes = conddes;
	}
	
	/**
	 * Column Info
	 * @param object
	 */
	public void setObject(String object) {
		this.object = object;
	}
	
	/**
	 * Column Info
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
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
		setObjName(JSPUtil.getParameter(request, "obj_name", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setObjValue(JSPUtil.getParameter(request, "obj_value", ""));
		setUom(JSPUtil.getParameter(request, "uom", ""));
		setCondition(JSPUtil.getParameter(request, "condition", ""));
		setCondid(JSPUtil.getParameter(request, "condid", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLineNum(JSPUtil.getParameter(request, "line_num", ""));
		setConddes(JSPUtil.getParameter(request, "conddes", ""));
		setObject(JSPUtil.getParameter(request, "object", ""));
		setOperator(JSPUtil.getParameter(request, "operator", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setObjListNo(JSPUtil.getParameter(request, "obj_list_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] objName = (JSPUtil.getParameter(request, prefix	+ "obj_name".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] objValue = (JSPUtil.getParameter(request, prefix	+ "obj_value".trim(), length));
			String[] uom = (JSPUtil.getParameter(request, prefix	+ "uom".trim(), length));
			String[] condition = (JSPUtil.getParameter(request, prefix	+ "condition".trim(), length));
			String[] condid = (JSPUtil.getParameter(request, prefix	+ "condid".trim(), length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq".trim(), length));
			String[] lineNum = (JSPUtil.getParameter(request, prefix	+ "line_num".trim(), length));
			String[] conddes = (JSPUtil.getParameter(request, prefix	+ "conddes".trim(), length));
			String[] object = (JSPUtil.getParameter(request, prefix	+ "object".trim(), length));
			String[] operator = (JSPUtil.getParameter(request, prefix	+ "operator".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConditionVO();
				if (objName[i] != null)
					model.setObjName(objName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (objValue[i] != null)
					model.setObjValue(objValue[i]);
				if (uom[i] != null)
					model.setUom(uom[i]);
				if (condition[i] != null)
					model.setCondition(condition[i]);
				if (condid[i] != null)
					model.setCondid(condid[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (lineNum[i] != null)
					model.setLineNum(lineNum[i]);
				if (conddes[i] != null)
					model.setConddes(conddes[i]);
				if (object[i] != null)
					model.setObject(object[i]);
				if (operator[i] != null)
					model.setOperator(operator[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConditionVO[]
	 */
	public ConditionVO[] getConditionVOs(){
		ConditionVO[] vos = (ConditionVO[])models.toArray(new ConditionVO[models.size()]);
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
		this.objName = this.objName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objValue = this.objValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uom = this.uom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condition = this.condition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condid = this.condid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineNum = this.lineNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conddes = this.conddes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.object = this.object .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator = this.operator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the objListNo
	 */
	public String getObjListNo() {
		return objListNo;
	}

	/**
	 * @param objListNo the objListNo to set
	 */
	public void setObjListNo(String objListNo) {
		this.objListNo = objListNo;
	}
}
