/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaIsf5ResultVO.java
*@FileTitle : UsaIsf5ResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.23 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaIsf5ResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaIsf5ResultVO> models = new ArrayList<UsaIsf5ResultVO>();
	
	/* Column Info */
	private String addInfo = null;
	/* Column Info */
	private String addCt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String addInfo2 = null;
	/* Column Info */
	private String addCntry = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String fpod = null;
	/* Column Info */
	private String enttName = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaIsf5ResultVO() {}

	public UsaIsf5ResultVO(String ibflag, String pagerows, String enttName, String addInfo, String addInfo2, String addCt, String addCntry, String fpod, String del) {
		this.addInfo = addInfo;
		this.addCt = addCt;
		this.ibflag = ibflag;
		this.addInfo2 = addInfo2;
		this.addCntry = addCntry;
		this.del = del;
		this.fpod = fpod;
		this.enttName = enttName;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("add_info", getAddInfo());
		this.hashColumns.put("add_ct", getAddCt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("add_info_2", getAddInfo2());
		this.hashColumns.put("add_cntry", getAddCntry());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("fpod", getFpod());
		this.hashColumns.put("entt_name", getEnttName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("add_info", "addInfo");
		this.hashFields.put("add_ct", "addCt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("add_info_2", "addInfo2");
		this.hashFields.put("add_cntry", "addCntry");
		this.hashFields.put("del", "del");
		this.hashFields.put("fpod", "fpod");
		this.hashFields.put("entt_name", "enttName");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return addInfo
	 */
	public String getAddInfo() {
		return this.addInfo;
	}
	
	/**
	 * Column Info
	 * @return addCt
	 */
	public String getAddCt() {
		return this.addCt;
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
	 * @return addInfo2
	 */
	public String getAddInfo2() {
		return this.addInfo2;
	}
	
	/**
	 * Column Info
	 * @return addCntry
	 */
	public String getAddCntry() {
		return this.addCntry;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return fpod
	 */
	public String getFpod() {
		return this.fpod;
	}
	
	/**
	 * Column Info
	 * @return enttName
	 */
	public String getEnttName() {
		return this.enttName;
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
	 * @param addInfo
	 */
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	
	/**
	 * Column Info
	 * @param addCt
	 */
	public void setAddCt(String addCt) {
		this.addCt = addCt;
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
	 * @param addInfo2
	 */
	public void setAddInfo2(String addInfo2) {
		this.addInfo2 = addInfo2;
	}
	
	/**
	 * Column Info
	 * @param addCntry
	 */
	public void setAddCntry(String addCntry) {
		this.addCntry = addCntry;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param fpod
	 */
	public void setFpod(String fpod) {
		this.fpod = fpod;
	}
	
	/**
	 * Column Info
	 * @param enttName
	 */
	public void setEnttName(String enttName) {
		this.enttName = enttName;
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
		setAddInfo(JSPUtil.getParameter(request, "add_info", ""));
		setAddCt(JSPUtil.getParameter(request, "add_ct", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAddInfo2(JSPUtil.getParameter(request, "add_info_2", ""));
		setAddCntry(JSPUtil.getParameter(request, "add_cntry", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setFpod(JSPUtil.getParameter(request, "fpod", ""));
		setEnttName(JSPUtil.getParameter(request, "entt_name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaIsf5ResultVO[]
	 */
	public UsaIsf5ResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaIsf5ResultVO[]
	 */
	public UsaIsf5ResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaIsf5ResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] addInfo = (JSPUtil.getParameter(request, prefix	+ "add_info", length));
			String[] addCt = (JSPUtil.getParameter(request, prefix	+ "add_ct", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] addInfo2 = (JSPUtil.getParameter(request, prefix	+ "add_info_2", length));
			String[] addCntry = (JSPUtil.getParameter(request, prefix	+ "add_cntry", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] fpod = (JSPUtil.getParameter(request, prefix	+ "fpod", length));
			String[] enttName = (JSPUtil.getParameter(request, prefix	+ "entt_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaIsf5ResultVO();
				if (addInfo[i] != null)
					model.setAddInfo(addInfo[i]);
				if (addCt[i] != null)
					model.setAddCt(addCt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (addInfo2[i] != null)
					model.setAddInfo2(addInfo2[i]);
				if (addCntry[i] != null)
					model.setAddCntry(addCntry[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (fpod[i] != null)
					model.setFpod(fpod[i]);
				if (enttName[i] != null)
					model.setEnttName(enttName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaIsf5ResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaIsf5ResultVO[]
	 */
	public UsaIsf5ResultVO[] getUsaIsf5ResultVOs(){
		UsaIsf5ResultVO[] vos = (UsaIsf5ResultVO[])models.toArray(new UsaIsf5ResultVO[models.size()]);
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
		this.addInfo = this.addInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCt = this.addCt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addInfo2 = this.addInfo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCntry = this.addCntry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpod = this.fpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enttName = this.enttName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
