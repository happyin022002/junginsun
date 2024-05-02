/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFSparePartInventoryMgtINVO.java
*@FileTitle : RFSparePartInventoryMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFSparePartInventoryMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFSparePartInventoryMgtINVO> models = new ArrayList<RFSparePartInventoryMgtINVO>();
	
	/* Column Info */
	private String tocal = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String sprTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dateGubun = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String fromcal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RFSparePartInventoryMgtINVO() {}

	public RFSparePartInventoryMgtINVO(String ibflag, String pagerows, String vslSlanCd, String dateGubun, String fromcal, String tocal, String sprTpCd, String vslCd) {
		this.tocal = tocal;
		this.vslCd = vslCd;
		this.sprTpCd = sprTpCd;
		this.ibflag = ibflag;
		this.dateGubun = dateGubun;
		this.vslSlanCd = vslSlanCd;
		this.fromcal = fromcal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tocal", getTocal());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("spr_tp_cd", getSprTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("date_gubun", getDateGubun());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("fromcal", getFromcal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tocal", "tocal");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("spr_tp_cd", "sprTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("date_gubun", "dateGubun");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("fromcal", "fromcal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tocal
	 */
	public String getTocal() {
		return this.tocal;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return sprTpCd
	 */
	public String getSprTpCd() {
		return this.sprTpCd;
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
	 * @return dateGubun
	 */
	public String getDateGubun() {
		return this.dateGubun;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return fromcal
	 */
	public String getFromcal() {
		return this.fromcal;
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
	 * @param tocal
	 */
	public void setTocal(String tocal) {
		this.tocal = tocal;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param sprTpCd
	 */
	public void setSprTpCd(String sprTpCd) {
		this.sprTpCd = sprTpCd;
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
	 * @param dateGubun
	 */
	public void setDateGubun(String dateGubun) {
		this.dateGubun = dateGubun;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param fromcal
	 */
	public void setFromcal(String fromcal) {
		this.fromcal = fromcal;
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
		setTocal(JSPUtil.getParameter(request, "tocal", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSprTpCd(JSPUtil.getParameter(request, "spr_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDateGubun(JSPUtil.getParameter(request, "date_gubun", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setFromcal(JSPUtil.getParameter(request, "fromcal", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFSparePartInventoryMgtINVO[]
	 */
	public RFSparePartInventoryMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFSparePartInventoryMgtINVO[]
	 */
	public RFSparePartInventoryMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFSparePartInventoryMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tocal = (JSPUtil.getParameter(request, prefix	+ "tocal", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] sprTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dateGubun = (JSPUtil.getParameter(request, prefix	+ "date_gubun", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] fromcal = (JSPUtil.getParameter(request, prefix	+ "fromcal", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFSparePartInventoryMgtINVO();
				if (tocal[i] != null)
					model.setTocal(tocal[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (sprTpCd[i] != null)
					model.setSprTpCd(sprTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dateGubun[i] != null)
					model.setDateGubun(dateGubun[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (fromcal[i] != null)
					model.setFromcal(fromcal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFSparePartInventoryMgtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFSparePartInventoryMgtINVO[]
	 */
	public RFSparePartInventoryMgtINVO[] getRFSparePartInventoryMgtINVOs(){
		RFSparePartInventoryMgtINVO[] vos = (RFSparePartInventoryMgtINVO[])models.toArray(new RFSparePartInventoryMgtINVO[models.size()]);
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
		this.tocal = this.tocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprTpCd = this.sprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateGubun = this.dateGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromcal = this.fromcal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
