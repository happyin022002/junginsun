/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FlatFileDtlVO.java
*@FileTitle : FlatFileDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.15 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FlatFileDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FlatFileDtlVO> models = new ArrayList<FlatFileDtlVO>();
	
	/* Column Info */
	private String damTpCd = null;
	/* Column Info */
	private String compntCd = null;
	/* Column Info */
	private String manHour = null;
	/* Column Info */
	private String lineNo = null;
	/* Column Info */
	private String damLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String matrlCost = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String meaUnitSpec = null;
	/* Column Info */
	private String respon = null;
	/* Column Info */
	private String reprMethCd = null;
	/* Column Info */
	private String compntMatCd = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String quantity = null;
	/* Column Info */
	private String labRate = null;
	/* Column Info */
	private String dimWid = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FlatFileDtlVO() {}

	public FlatFileDtlVO(String ibflag, String pagerows, String lineNo, String damLocCd, String compntCd, String damTpCd, String compntMatCd, String reprMethCd, String quantity, String meaUnitSpec, String dimLen, String dimWid, String manHour, String labRate, String matrlCost, String respon) {
		this.damTpCd = damTpCd;
		this.compntCd = compntCd;
		this.manHour = manHour;
		this.lineNo = lineNo;
		this.damLocCd = damLocCd;
		this.pagerows = pagerows;
		this.matrlCost = matrlCost;
		this.ibflag = ibflag;
		this.meaUnitSpec = meaUnitSpec;
		this.respon = respon;
		this.reprMethCd = reprMethCd;
		this.compntMatCd = compntMatCd;
		this.dimLen = dimLen;
		this.quantity = quantity;
		this.labRate = labRate;
		this.dimWid = dimWid;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dam_tp_cd", getDamTpCd());
		this.hashColumns.put("compnt_cd", getCompntCd());
		this.hashColumns.put("man_hour", getManHour());
		this.hashColumns.put("line_no", getLineNo());
		this.hashColumns.put("dam_loc_cd", getDamLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("matrl_cost", getMatrlCost());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mea_unit_spec", getMeaUnitSpec());
		this.hashColumns.put("respon", getRespon());
		this.hashColumns.put("repr_meth_cd", getReprMethCd());
		this.hashColumns.put("compnt_mat_cd", getCompntMatCd());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("quantity", getQuantity());
		this.hashColumns.put("lab_rate", getLabRate());
		this.hashColumns.put("dim_wid", getDimWid());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dam_tp_cd", "damTpCd");
		this.hashFields.put("compnt_cd", "compntCd");
		this.hashFields.put("man_hour", "manHour");
		this.hashFields.put("line_no", "lineNo");
		this.hashFields.put("dam_loc_cd", "damLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("matrl_cost", "matrlCost");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mea_unit_spec", "meaUnitSpec");
		this.hashFields.put("respon", "respon");
		this.hashFields.put("repr_meth_cd", "reprMethCd");
		this.hashFields.put("compnt_mat_cd", "compntMatCd");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("quantity", "quantity");
		this.hashFields.put("lab_rate", "labRate");
		this.hashFields.put("dim_wid", "dimWid");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return damTpCd
	 */
	public String getDamTpCd() {
		return this.damTpCd;
	}
	
	/**
	 * Column Info
	 * @return compntCd
	 */
	public String getCompntCd() {
		return this.compntCd;
	}
	
	/**
	 * Column Info
	 * @return manHour
	 */
	public String getManHour() {
		return this.manHour;
	}
	
	/**
	 * Column Info
	 * @return lineNo
	 */
	public String getLineNo() {
		return this.lineNo;
	}
	
	/**
	 * Column Info
	 * @return damLocCd
	 */
	public String getDamLocCd() {
		return this.damLocCd;
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
	 * @return matrlCost
	 */
	public String getMatrlCost() {
		return this.matrlCost;
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
	 * @return meaUnitSpec
	 */
	public String getMeaUnitSpec() {
		return this.meaUnitSpec;
	}
	
	/**
	 * Column Info
	 * @return respon
	 */
	public String getRespon() {
		return this.respon;
	}
	
	/**
	 * Column Info
	 * @return reprMethCd
	 */
	public String getReprMethCd() {
		return this.reprMethCd;
	}
	
	/**
	 * Column Info
	 * @return compntMatCd
	 */
	public String getCompntMatCd() {
		return this.compntMatCd;
	}
	
	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}
	
	/**
	 * Column Info
	 * @return quantity
	 */
	public String getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Column Info
	 * @return labRate
	 */
	public String getLabRate() {
		return this.labRate;
	}
	
	/**
	 * Column Info
	 * @return dimWid
	 */
	public String getDimWid() {
		return this.dimWid;
	}
	

	/**
	 * Column Info
	 * @param damTpCd
	 */
	public void setDamTpCd(String damTpCd) {
		this.damTpCd = damTpCd;
	}
	
	/**
	 * Column Info
	 * @param compntCd
	 */
	public void setCompntCd(String compntCd) {
		this.compntCd = compntCd;
	}
	
	/**
	 * Column Info
	 * @param manHour
	 */
	public void setManHour(String manHour) {
		this.manHour = manHour;
	}
	
	/**
	 * Column Info
	 * @param lineNo
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	
	/**
	 * Column Info
	 * @param damLocCd
	 */
	public void setDamLocCd(String damLocCd) {
		this.damLocCd = damLocCd;
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
	 * @param matrlCost
	 */
	public void setMatrlCost(String matrlCost) {
		this.matrlCost = matrlCost;
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
	 * @param meaUnitSpec
	 */
	public void setMeaUnitSpec(String meaUnitSpec) {
		this.meaUnitSpec = meaUnitSpec;
	}
	
	/**
	 * Column Info
	 * @param respon
	 */
	public void setRespon(String respon) {
		this.respon = respon;
	}
	
	/**
	 * Column Info
	 * @param reprMethCd
	 */
	public void setReprMethCd(String reprMethCd) {
		this.reprMethCd = reprMethCd;
	}
	
	/**
	 * Column Info
	 * @param compntMatCd
	 */
	public void setCompntMatCd(String compntMatCd) {
		this.compntMatCd = compntMatCd;
	}
	
	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}
	
	/**
	 * Column Info
	 * @param quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Column Info
	 * @param labRate
	 */
	public void setLabRate(String labRate) {
		this.labRate = labRate;
	}
	
	/**
	 * Column Info
	 * @param dimWid
	 */
	public void setDimWid(String dimWid) {
		this.dimWid = dimWid;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDamTpCd(JSPUtil.getParameter(request, "dam_tp_cd", ""));
		setCompntCd(JSPUtil.getParameter(request, "compnt_cd", ""));
		setManHour(JSPUtil.getParameter(request, "man_hour", ""));
		setLineNo(JSPUtil.getParameter(request, "line_no", ""));
		setDamLocCd(JSPUtil.getParameter(request, "dam_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMatrlCost(JSPUtil.getParameter(request, "matrl_cost", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMeaUnitSpec(JSPUtil.getParameter(request, "mea_unit_spec", ""));
		setRespon(JSPUtil.getParameter(request, "respon", ""));
		setReprMethCd(JSPUtil.getParameter(request, "repr_meth_cd", ""));
		setCompntMatCd(JSPUtil.getParameter(request, "compnt_mat_cd", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setQuantity(JSPUtil.getParameter(request, "quantity", ""));
		setLabRate(JSPUtil.getParameter(request, "lab_rate", ""));
		setDimWid(JSPUtil.getParameter(request, "dim_wid", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlatFileDtlVO[]
	 */
	public FlatFileDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FlatFileDtlVO[]
	 */
	public FlatFileDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FlatFileDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] damTpCd = (JSPUtil.getParameter(request, prefix	+ "dam_tp_cd", length));
			String[] compntCd = (JSPUtil.getParameter(request, prefix	+ "compnt_cd", length));
			String[] manHour = (JSPUtil.getParameter(request, prefix	+ "man_hour", length));
			String[] lineNo = (JSPUtil.getParameter(request, prefix	+ "line_no", length));
			String[] damLocCd = (JSPUtil.getParameter(request, prefix	+ "dam_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] matrlCost = (JSPUtil.getParameter(request, prefix	+ "matrl_cost", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] meaUnitSpec = (JSPUtil.getParameter(request, prefix	+ "mea_unit_spec", length));
			String[] respon = (JSPUtil.getParameter(request, prefix	+ "respon", length));
			String[] reprMethCd = (JSPUtil.getParameter(request, prefix	+ "repr_meth_cd", length));
			String[] compntMatCd = (JSPUtil.getParameter(request, prefix	+ "compnt_mat_cd", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] quantity = (JSPUtil.getParameter(request, prefix	+ "quantity", length));
			String[] labRate = (JSPUtil.getParameter(request, prefix	+ "lab_rate", length));
			String[] dimWid = (JSPUtil.getParameter(request, prefix	+ "dim_wid", length));
			
			for (int i = 0; i < length; i++) {
				model = new FlatFileDtlVO();
				if (damTpCd[i] != null)
					model.setDamTpCd(damTpCd[i]);
				if (compntCd[i] != null)
					model.setCompntCd(compntCd[i]);
				if (manHour[i] != null)
					model.setManHour(manHour[i]);
				if (lineNo[i] != null)
					model.setLineNo(lineNo[i]);
				if (damLocCd[i] != null)
					model.setDamLocCd(damLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (matrlCost[i] != null)
					model.setMatrlCost(matrlCost[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (meaUnitSpec[i] != null)
					model.setMeaUnitSpec(meaUnitSpec[i]);
				if (respon[i] != null)
					model.setRespon(respon[i]);
				if (reprMethCd[i] != null)
					model.setReprMethCd(reprMethCd[i]);
				if (compntMatCd[i] != null)
					model.setCompntMatCd(compntMatCd[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (quantity[i] != null)
					model.setQuantity(quantity[i]);
				if (labRate[i] != null)
					model.setLabRate(labRate[i]);
				if (dimWid[i] != null)
					model.setDimWid(dimWid[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFlatFileDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FlatFileDtlVO[]
	 */
	public FlatFileDtlVO[] getFlatFileDtlVOs(){
		FlatFileDtlVO[] vos = (FlatFileDtlVO[])models.toArray(new FlatFileDtlVO[models.size()]);
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
		this.damTpCd = this.damTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compntCd = this.compntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHour = this.manHour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineNo = this.lineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damLocCd = this.damLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matrlCost = this.matrlCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaUnitSpec = this.meaUnitSpec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respon = this.respon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reprMethCd = this.reprMethCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compntMatCd = this.compntMatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quantity = this.quantity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labRate = this.labRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWid = this.dimWid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
