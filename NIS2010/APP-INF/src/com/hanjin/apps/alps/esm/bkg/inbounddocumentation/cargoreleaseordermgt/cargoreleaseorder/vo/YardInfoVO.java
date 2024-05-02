/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YardInfoVO.java
*@FileTitle : YardInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.24 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class YardInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YardInfoVO> models = new ArrayList<YardInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blTp = null;
	/* Column Info */
	private String discLoc2 = null;
	/* Column Info */
	private String discLoc1 = null;
	/* Column Info */
	private String bndTp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public YardInfoVO() {}

	public YardInfoVO(String ibflag, String pagerows, String discLoc2, String discLoc1, String blTp, String bndTp) {
		this.ibflag = ibflag;
		this.blTp = blTp;
		this.discLoc2 = discLoc2;
		this.discLoc1 = discLoc1;
		this.bndTp = bndTp;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("disc_loc2", getDiscLoc2());
		this.hashColumns.put("disc_loc1", getDiscLoc1());
		this.hashColumns.put("bnd_tp", getBndTp());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("disc_loc2", "discLoc2");
		this.hashFields.put("disc_loc1", "discLoc1");
		this.hashFields.put("bnd_tp", "bndTp");
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
	 * @return blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}
	
	/**
	 * Column Info
	 * @return discLoc2
	 */
	public String getDiscLoc2() {
		return this.discLoc2;
	}
	
	/**
	 * Column Info
	 * @return discLoc1
	 */
	public String getDiscLoc1() {
		return this.discLoc1;
	}
	
	/**
	 * Column Info
	 * @return bndTp
	 */
	public String getBndTp() {
		return this.bndTp;
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
	 * @param blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	
	/**
	 * Column Info
	 * @param discLoc2
	 */
	public void setDiscLoc2(String discLoc2) {
		this.discLoc2 = discLoc2;
	}
	
	/**
	 * Column Info
	 * @param discLoc1
	 */
	public void setDiscLoc1(String discLoc1) {
		this.discLoc1 = discLoc1;
	}
	
	/**
	 * Column Info
	 * @param bndTp
	 */
	public void setBndTp(String bndTp) {
		this.bndTp = bndTp;
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
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));
		setDiscLoc2(JSPUtil.getParameter(request, "disc_loc2", ""));
		setDiscLoc1(JSPUtil.getParameter(request, "disc_loc1", ""));
		setBndTp(JSPUtil.getParameter(request, "bnd_tp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardInfoVO[]
	 */
	public YardInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardInfoVO[]
	 */
	public YardInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YardInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] discLoc2 = (JSPUtil.getParameter(request, prefix	+ "disc_loc2", length));
			String[] discLoc1 = (JSPUtil.getParameter(request, prefix	+ "disc_loc1", length));
			String[] bndTp = (JSPUtil.getParameter(request, prefix	+ "bnd_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new YardInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (discLoc2[i] != null)
					model.setDiscLoc2(discLoc2[i]);
				if (discLoc1[i] != null)
					model.setDiscLoc1(discLoc1[i]);
				if (bndTp[i] != null)
					model.setBndTp(bndTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYardInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return YardInfoVO[]
	 */
	public YardInfoVO[] getYardInfoVOs(){
		YardInfoVO[] vos = (YardInfoVO[])models.toArray(new YardInfoVO[models.size()]);
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
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discLoc2 = this.discLoc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discLoc1 = this.discLoc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndTp = this.bndTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
