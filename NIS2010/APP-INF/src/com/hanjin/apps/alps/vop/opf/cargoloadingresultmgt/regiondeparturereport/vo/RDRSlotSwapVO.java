/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRSlotSwapVO.java
*@FileTitle : RDRSlotSwapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.08.07 이선영 
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

public class RDRSlotSwapVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRSlotSwapVO> models = new ArrayList<RDRSlotSwapVO>();
	
	/* Column Info */
	private String fmVslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String toCarrCd = null;
	/* Column Info */
	private String toVslCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String fmCarrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRSlotSwapVO() {}

	public RDRSlotSwapVO(String ibflag, String pagerows, String fmCarrCd, String fmVslCd, String toCarrCd, String toVslCd, String teu, String weight) {
		this.fmVslCd = fmVslCd;
		this.ibflag = ibflag;
		this.weight = weight;
		this.toCarrCd = toCarrCd;
		this.toVslCd = toVslCd;
		this.teu = teu;
		this.fmCarrCd = fmCarrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_vsl_cd", getFmVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("to_carr_cd", getToCarrCd());
		this.hashColumns.put("to_vsl_cd", getToVslCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("fm_carr_cd", getFmCarrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_vsl_cd", "fmVslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("to_carr_cd", "toCarrCd");
		this.hashFields.put("to_vsl_cd", "toVslCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("fm_carr_cd", "fmCarrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmVslCd
	 */
	public String getFmVslCd() {
		return this.fmVslCd;
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
	 * @return toCarrCd
	 */
	public String getToCarrCd() {
		return this.toCarrCd;
	}
	
	/**
	 * Column Info
	 * @return toVslCd
	 */
	public String getToVslCd() {
		return this.toVslCd;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return fmCarrCd
	 */
	public String getFmCarrCd() {
		return this.fmCarrCd;
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
	 * @param fmVslCd
	 */
	public void setFmVslCd(String fmVslCd) {
		this.fmVslCd = fmVslCd;
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
	 * @param toCarrCd
	 */
	public void setToCarrCd(String toCarrCd) {
		this.toCarrCd = toCarrCd;
	}
	
	/**
	 * Column Info
	 * @param toVslCd
	 */
	public void setToVslCd(String toVslCd) {
		this.toVslCd = toVslCd;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param fmCarrCd
	 */
	public void setFmCarrCd(String fmCarrCd) {
		this.fmCarrCd = fmCarrCd;
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
		setFmVslCd(JSPUtil.getParameter(request, "fm_vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setToCarrCd(JSPUtil.getParameter(request, "to_carr_cd", ""));
		setToVslCd(JSPUtil.getParameter(request, "to_vsl_cd", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setFmCarrCd(JSPUtil.getParameter(request, "fm_carr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRSlotSwapVO[]
	 */
	public RDRSlotSwapVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRSlotSwapVO[]
	 */
	public RDRSlotSwapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRSlotSwapVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmVslCd = (JSPUtil.getParameter(request, prefix	+ "fm_vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] toCarrCd = (JSPUtil.getParameter(request, prefix	+ "to_carr_cd", length));
			String[] toVslCd = (JSPUtil.getParameter(request, prefix	+ "to_vsl_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] fmCarrCd = (JSPUtil.getParameter(request, prefix	+ "fm_carr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRSlotSwapVO();
				if (fmVslCd[i] != null)
					model.setFmVslCd(fmVslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (toCarrCd[i] != null)
					model.setToCarrCd(toCarrCd[i]);
				if (toVslCd[i] != null)
					model.setToVslCd(toVslCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (fmCarrCd[i] != null)
					model.setFmCarrCd(fmCarrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRSlotSwapVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRSlotSwapVO[]
	 */
	public RDRSlotSwapVO[] getRDRSlotSwapVOs(){
		RDRSlotSwapVO[] vos = (RDRSlotSwapVO[])models.toArray(new RDRSlotSwapVO[models.size()]);
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
		this.fmVslCd = this.fmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCarrCd = this.toCarrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVslCd = this.toVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCarrCd = this.fmCarrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
