/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRBbVO.java
*@FileTitle : RDRBbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.30 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRBbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRBbVO> models = new ArrayList<RDRBbVO>();
	
	/* Column Info */
	private String dml = null;
	/* Column Info */
	private String dmh = null;
	/* Column Info */
	private String cellNo = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String typeSize = null;
	/* Column Info */
	private String dmb = null;
	/* Column Info */
	private String fmWork = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String toWork = null;
	/* Column Info */
	private String crane = null;
	/* Column Info */
	private String slot = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRBbVO() {}

	public RDRBbVO(String ibflag, String pagerows, String oprCd, String pol, String pod, String cntrNo, String typeSize, String cellNo, String dml, String dmb, String dmh, String weight, String unit, String slot, String crane, String fmWork, String toWork) {
		this.dml = dml;
		this.dmh = dmh;
		this.cellNo = cellNo;
		this.weight = weight;
		this.typeSize = typeSize;
		this.dmb = dmb;
		this.fmWork = fmWork;
		this.pagerows = pagerows;
		this.unit = unit;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.toWork = toWork;
		this.crane = crane;
		this.slot = slot;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dml", getDml());
		this.hashColumns.put("dmh", getDmh());
		this.hashColumns.put("cell_no", getCellNo());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("type_size", getTypeSize());
		this.hashColumns.put("dmb", getDmb());
		this.hashColumns.put("fm_work", getFmWork());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("to_work", getToWork());
		this.hashColumns.put("crane", getCrane());
		this.hashColumns.put("slot", getSlot());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dml", "dml");
		this.hashFields.put("dmh", "dmh");
		this.hashFields.put("cell_no", "cellNo");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("type_size", "typeSize");
		this.hashFields.put("dmb", "dmb");
		this.hashFields.put("fm_work", "fmWork");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("to_work", "toWork");
		this.hashFields.put("crane", "crane");
		this.hashFields.put("slot", "slot");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dml
	 */
	public String getDml() {
		return this.dml;
	}
	
	/**
	 * Column Info
	 * @return dmh
	 */
	public String getDmh() {
		return this.dmh;
	}
	
	/**
	 * Column Info
	 * @return cellNo
	 */
	public String getCellNo() {
		return this.cellNo;
	}
	
	/**
	 * Column Info
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
	}
	
	/**
	 * Column Info
	 * @return typeSize
	 */
	public String getTypeSize() {
		return this.typeSize;
	}
	
	/**
	 * Column Info
	 * @return dmb
	 */
	public String getDmb() {
		return this.dmb;
	}
	
	/**
	 * Column Info
	 * @return fmWork
	 */
	public String getFmWork() {
		return this.fmWork;
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
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return toWork
	 */
	public String getToWork() {
		return this.toWork;
	}
	
	/**
	 * Column Info
	 * @return crane
	 */
	public String getCrane() {
		return this.crane;
	}
	
	/**
	 * Column Info
	 * @return slot
	 */
	public String getSlot() {
		return this.slot;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param dml
	 */
	public void setDml(String dml) {
		this.dml = dml;
	}
	
	/**
	 * Column Info
	 * @param dmh
	 */
	public void setDmh(String dmh) {
		this.dmh = dmh;
	}
	
	/**
	 * Column Info
	 * @param cellNo
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	
	/**
	 * Column Info
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/**
	 * Column Info
	 * @param typeSize
	 */
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
	
	/**
	 * Column Info
	 * @param dmb
	 */
	public void setDmb(String dmb) {
		this.dmb = dmb;
	}
	
	/**
	 * Column Info
	 * @param fmWork
	 */
	public void setFmWork(String fmWork) {
		this.fmWork = fmWork;
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
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param toWork
	 */
	public void setToWork(String toWork) {
		this.toWork = toWork;
	}
	
	/**
	 * Column Info
	 * @param crane
	 */
	public void setCrane(String crane) {
		this.crane = crane;
	}
	
	/**
	 * Column Info
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDml(JSPUtil.getParameter(request, "dml", ""));
		setDmh(JSPUtil.getParameter(request, "dmh", ""));
		setCellNo(JSPUtil.getParameter(request, "cell_no", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setTypeSize(JSPUtil.getParameter(request, "type_size", ""));
		setDmb(JSPUtil.getParameter(request, "dmb", ""));
		setFmWork(JSPUtil.getParameter(request, "fm_work", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUnit(JSPUtil.getParameter(request, "unit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setToWork(JSPUtil.getParameter(request, "to_work", ""));
		setCrane(JSPUtil.getParameter(request, "crane", ""));
		setSlot(JSPUtil.getParameter(request, "slot", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRBbVO[]
	 */
	public RDRBbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRBbVO[]
	 */
	public RDRBbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRBbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dml = (JSPUtil.getParameter(request, prefix	+ "dml", length));
			String[] dmh = (JSPUtil.getParameter(request, prefix	+ "dmh", length));
			String[] cellNo = (JSPUtil.getParameter(request, prefix	+ "cell_no", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] typeSize = (JSPUtil.getParameter(request, prefix	+ "type_size", length));
			String[] dmb = (JSPUtil.getParameter(request, prefix	+ "dmb", length));
			String[] fmWork = (JSPUtil.getParameter(request, prefix	+ "fm_work", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] toWork = (JSPUtil.getParameter(request, prefix	+ "to_work", length));
			String[] crane = (JSPUtil.getParameter(request, prefix	+ "crane", length));
			String[] slot = (JSPUtil.getParameter(request, prefix	+ "slot", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRBbVO();
				if (dml[i] != null)
					model.setDml(dml[i]);
				if (dmh[i] != null)
					model.setDmh(dmh[i]);
				if (cellNo[i] != null)
					model.setCellNo(cellNo[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (typeSize[i] != null)
					model.setTypeSize(typeSize[i]);
				if (dmb[i] != null)
					model.setDmb(dmb[i]);
				if (fmWork[i] != null)
					model.setFmWork(fmWork[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (toWork[i] != null)
					model.setToWork(toWork[i]);
				if (crane[i] != null)
					model.setCrane(crane[i]);
				if (slot[i] != null)
					model.setSlot(slot[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRBbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRBbVO[]
	 */
	public RDRBbVO[] getRDRBbVOs(){
		RDRBbVO[] vos = (RDRBbVO[])models.toArray(new RDRBbVO[models.size()]);
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
		this.dml = this.dml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmh = this.dmh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellNo = this.cellNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSize = this.typeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmb = this.dmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWork = this.fmWork .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWork = this.toWork .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crane = this.crane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slot = this.slot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
