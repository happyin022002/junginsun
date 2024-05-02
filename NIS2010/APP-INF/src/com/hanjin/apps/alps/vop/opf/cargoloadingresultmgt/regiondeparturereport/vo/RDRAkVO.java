/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRAkVO.java
*@FileTitle : RDRAkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.22 이선영 
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

public class RDRAkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRAkVO> models = new ArrayList<RDRAkVO>();
	
	/* Column Info */
	private String cellNo = null;
	/* Column Info */
	private String os = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String typeSize = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String voidTeu = null;
	/* Column Info */
	private String oprCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovf = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oa = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String oh = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRAkVO() {}

	public RDRAkVO(String ibflag, String pagerows, String oprCd, String pol, String pod, String cntrNo, String typeSize, String cellNo, String ovf, String oa, String op, String os, String oh, String voidTeu, String weight) {
		this.cellNo = cellNo;
		this.os = os;
		this.weight = weight;
		this.typeSize = typeSize;
		this.op = op;
		this.voidTeu = voidTeu;
		this.oprCd = oprCd;
		this.pagerows = pagerows;
		this.ovf = ovf;
		this.ibflag = ibflag;
		this.oa = oa;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.pod = pod;
		this.oh = oh;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cell_no", getCellNo());
		this.hashColumns.put("os", getOs());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("type_size", getTypeSize());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("void_teu", getVoidTeu());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oa", getOa());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("oh", getOh());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cell_no", "cellNo");
		this.hashFields.put("os", "os");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("type_size", "typeSize");
		this.hashFields.put("op", "op");
		this.hashFields.put("void_teu", "voidTeu");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oa", "oa");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("oh", "oh");
		return this.hashFields;
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
	 * @return os
	 */
	public String getOs() {
		return this.os;
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
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return voidTeu
	 */
	public String getVoidTeu() {
		return this.voidTeu;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
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
	 * @return ovf
	 */
	public String getOvf() {
		return this.ovf;
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
	 * @return oa
	 */
	public String getOa() {
		return this.oa;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return oh
	 */
	public String getOh() {
		return this.oh;
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
	 * @param os
	 */
	public void setOs(String os) {
		this.os = os;
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
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param voidTeu
	 */
	public void setVoidTeu(String voidTeu) {
		this.voidTeu = voidTeu;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
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
	 * @param ovf
	 */
	public void setOvf(String ovf) {
		this.ovf = ovf;
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
	 * @param oa
	 */
	public void setOa(String oa) {
		this.oa = oa;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param oh
	 */
	public void setOh(String oh) {
		this.oh = oh;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCellNo(JSPUtil.getParameter(request, "cell_no", ""));
		setOs(JSPUtil.getParameter(request, "os", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setTypeSize(JSPUtil.getParameter(request, "type_size", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setVoidTeu(JSPUtil.getParameter(request, "void_teu", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOvf(JSPUtil.getParameter(request, "ovf", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOa(JSPUtil.getParameter(request, "oa", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setOh(JSPUtil.getParameter(request, "oh", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRAkVO[]
	 */
	public RDRAkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRAkVO[]
	 */
	public RDRAkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRAkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cellNo = (JSPUtil.getParameter(request, prefix	+ "cell_no", length));
			String[] os = (JSPUtil.getParameter(request, prefix	+ "os", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] typeSize = (JSPUtil.getParameter(request, prefix	+ "type_size", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] voidTeu = (JSPUtil.getParameter(request, prefix	+ "void_teu", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oa = (JSPUtil.getParameter(request, prefix	+ "oa", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] oh = (JSPUtil.getParameter(request, prefix	+ "oh", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRAkVO();
				if (cellNo[i] != null)
					model.setCellNo(cellNo[i]);
				if (os[i] != null)
					model.setOs(os[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (typeSize[i] != null)
					model.setTypeSize(typeSize[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (voidTeu[i] != null)
					model.setVoidTeu(voidTeu[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovf[i] != null)
					model.setOvf(ovf[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oa[i] != null)
					model.setOa(oa[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (oh[i] != null)
					model.setOh(oh[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRAkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRAkVO[]
	 */
	public RDRAkVO[] getRDRAkVOs(){
		RDRAkVO[] vos = (RDRAkVO[])models.toArray(new RDRAkVO[models.size()]);
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
		this.cellNo = this.cellNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.os = this.os .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSize = this.typeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidTeu = this.voidTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oa = this.oa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oh = this.oh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
