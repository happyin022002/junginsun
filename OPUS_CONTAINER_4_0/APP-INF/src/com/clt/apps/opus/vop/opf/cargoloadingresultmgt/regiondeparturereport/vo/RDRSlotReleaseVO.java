/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRSlotReleaseVO.java
*@FileTitle : RDRSlotReleaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.08.07 이선영 
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

public class RDRSlotReleaseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRSlotReleaseVO> models = new ArrayList<RDRSlotReleaseVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String toCarrCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String fmCarrNm = null;
	/* Column Info */
	private String fmCarrCd = null;
	/* Column Info */
	private String toCarrNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRSlotReleaseVO() {}

	public RDRSlotReleaseVO(String ibflag, String pagerows, String fmCarrCd, String fmCarrNm, String toCarrCd, String toCarrNm, String teu, String weight, String type) {
		this.ibflag = ibflag;
		this.weight = weight;
		this.toCarrCd = toCarrCd;
		this.teu = teu;
		this.type = type;
		this.fmCarrNm = fmCarrNm;
		this.fmCarrCd = fmCarrCd;
		this.toCarrNm = toCarrNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("to_carr_cd", getToCarrCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("fm_carr_nm", getFmCarrNm());
		this.hashColumns.put("fm_carr_cd", getFmCarrCd());
		this.hashColumns.put("to_carr_nm", getToCarrNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("to_carr_cd", "toCarrCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("type", "type");
		this.hashFields.put("fm_carr_nm", "fmCarrNm");
		this.hashFields.put("fm_carr_cd", "fmCarrCd");
		this.hashFields.put("to_carr_nm", "toCarrNm");
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
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return fmCarrNm
	 */
	public String getFmCarrNm() {
		return this.fmCarrNm;
	}
	
	/**
	 * Column Info
	 * @return fmCarrCd
	 */
	public String getFmCarrCd() {
		return this.fmCarrCd;
	}
	
	/**
	 * Column Info
	 * @return toCarrNm
	 */
	public String getToCarrNm() {
		return this.toCarrNm;
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
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param fmCarrNm
	 */
	public void setFmCarrNm(String fmCarrNm) {
		this.fmCarrNm = fmCarrNm;
	}
	
	/**
	 * Column Info
	 * @param fmCarrCd
	 */
	public void setFmCarrCd(String fmCarrCd) {
		this.fmCarrCd = fmCarrCd;
	}
	
	/**
	 * Column Info
	 * @param toCarrNm
	 */
	public void setToCarrNm(String toCarrNm) {
		this.toCarrNm = toCarrNm;
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
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setToCarrCd(JSPUtil.getParameter(request, "to_carr_cd", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setFmCarrNm(JSPUtil.getParameter(request, "fm_carr_nm", ""));
		setFmCarrCd(JSPUtil.getParameter(request, "fm_carr_cd", ""));
		setToCarrNm(JSPUtil.getParameter(request, "to_carr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRSlotReleaseVO[]
	 */
	public RDRSlotReleaseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRSlotReleaseVO[]
	 */
	public RDRSlotReleaseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRSlotReleaseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] toCarrCd = (JSPUtil.getParameter(request, prefix	+ "to_carr_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] fmCarrNm = (JSPUtil.getParameter(request, prefix	+ "fm_carr_nm", length));
			String[] fmCarrCd = (JSPUtil.getParameter(request, prefix	+ "fm_carr_cd", length));
			String[] toCarrNm = (JSPUtil.getParameter(request, prefix	+ "to_carr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRSlotReleaseVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (toCarrCd[i] != null)
					model.setToCarrCd(toCarrCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (fmCarrNm[i] != null)
					model.setFmCarrNm(fmCarrNm[i]);
				if (fmCarrCd[i] != null)
					model.setFmCarrCd(fmCarrCd[i]);
				if (toCarrNm[i] != null)
					model.setToCarrNm(toCarrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRSlotReleaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRSlotReleaseVO[]
	 */
	public RDRSlotReleaseVO[] getRDRSlotReleaseVOs(){
		RDRSlotReleaseVO[] vos = (RDRSlotReleaseVO[])models.toArray(new RDRSlotReleaseVO[models.size()]);
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
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCarrCd = this.toCarrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCarrNm = this.fmCarrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCarrCd = this.fmCarrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCarrNm = this.toCarrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
