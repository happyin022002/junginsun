/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanSearchVesselVO.java
*@FileTitle : TaiwanSearchVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.20 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaiwanSearchVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanSearchVesselVO> models = new ArrayList<TaiwanSearchVesselVO>();
	
	/* Column Info */
	private String vslFullname = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaiwanSearchVesselVO() {}

	public TaiwanSearchVesselVO(String ibflag, String pagerows, String vslCallsign, String vslLloydcode, String vslFullname) {
		this.vslFullname = vslFullname;
		this.ibflag = ibflag;
		this.vslCallsign = vslCallsign;
		this.vslLloydcode = vslLloydcode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
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
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
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
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
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
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
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
		setVslFullname(JSPUtil.getParameter(request, "vsl_fullname", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCallsign(JSPUtil.getParameter(request, "vsl_callsign", ""));
		setVslLloydcode(JSPUtil.getParameter(request, "vsl_lloydcode", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanSearchVesselVO[]
	 */
	public TaiwanSearchVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanSearchVesselVO[]
	 */
	public TaiwanSearchVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanSearchVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanSearchVesselVO();
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanSearchVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanSearchVesselVO[]
	 */
	public TaiwanSearchVesselVO[] getTaiwanSearchVesselVOs(){
		TaiwanSearchVesselVO[] vos = (TaiwanSearchVesselVO[])models.toArray(new TaiwanSearchVesselVO[models.size()]);
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
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
