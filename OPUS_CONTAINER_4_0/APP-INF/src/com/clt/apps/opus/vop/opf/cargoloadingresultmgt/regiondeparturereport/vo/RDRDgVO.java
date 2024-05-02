/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRDgVO.java
*@FileTitle : RDRDgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.08.06 이선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRDgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRDgVO> models = new ArrayList<RDRDgVO>();
	
	/* Column Info */
	private String imo = null;
	/* Column Info */
	private String cellNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String typeSize = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRDgVO() {}

	public RDRDgVO(String ibflag, String pagerows, String oprCd, String pol, String pod, String cntrNo, String typeSize, String cellNo, String imo, String unNo, String weight) {
		this.imo = imo;
		this.cellNo = cellNo;
		this.ibflag = ibflag;
		this.weight = weight;
		this.typeSize = typeSize;
		this.oprCd = oprCd;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.unNo = unNo;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imo", getImo());
		this.hashColumns.put("cell_no", getCellNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("type_size", getTypeSize());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imo", "imo");
		this.hashFields.put("cell_no", "cellNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("type_size", "typeSize");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imo
	 */
	public String getImo() {
		return this.imo;
	}
	
	/**
	 * Column Info
	 * @return cellNo
	 */
	public String getCellNo() {
		return this.cellNo;
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
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param imo
	 */
	public void setImo(String imo) {
		this.imo = imo;
	}
	
	/**
	 * Column Info
	 * @param cellNo
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
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
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setImo(JSPUtil.getParameter(request, "imo", ""));
		setCellNo(JSPUtil.getParameter(request, "cell_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setTypeSize(JSPUtil.getParameter(request, "type_size", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setUnNo(JSPUtil.getParameter(request, "un_no", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRDgVO[]
	 */
	public RDRDgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRDgVO[]
	 */
	public RDRDgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRDgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imo = (JSPUtil.getParameter(request, prefix	+ "imo", length));
			String[] cellNo = (JSPUtil.getParameter(request, prefix	+ "cell_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] typeSize = (JSPUtil.getParameter(request, prefix	+ "type_size", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRDgVO();
				if (imo[i] != null)
					model.setImo(imo[i]);
				if (cellNo[i] != null)
					model.setCellNo(cellNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (typeSize[i] != null)
					model.setTypeSize(typeSize[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRDgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRDgVO[]
	 */
	public RDRDgVO[] getRDRDgVOs(){
		RDRDgVO[] vos = (RDRDgVO[])models.toArray(new RDRDgVO[models.size()]);
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
		this.imo = this.imo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellNo = this.cellNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSize = this.typeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
