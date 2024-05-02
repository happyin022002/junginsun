/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdiMsgToDLSVO.java
*@FileTitle : EdiMsgToDLSVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.10.08 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiMsgToDLSVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiMsgToDLSVO> models = new ArrayList<EdiMsgToDLSVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String voy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String dir = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiMsgToDLSVO() {}

	public EdiMsgToDLSVO(String ibflag, String pagerows, String vslCd, String voy, String dir, String polLoc, String lane, String vslNm, String cct, String etb, String etd) {
		this.etb = etb;
		this.vslCd = vslCd;
		this.voy = voy;
		this.ibflag = ibflag;
		this.polLoc = polLoc;
		this.dir = dir;
		this.etd = etd;
		this.vslNm = vslNm;
		this.cct = cct;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("voy", getVoy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("dir", getDir());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("voy", "voy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("dir", "dir");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return voy
	 */
	public String getVoy() {
		return this.voy;
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
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return dir
	 */
	public String getDir() {
		return this.dir;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param voy
	 */
	public void setVoy(String voy) {
		this.voy = voy;
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
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param dir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVoy(JSPUtil.getParameter(request, "voy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setDir(JSPUtil.getParameter(request, "dir", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setCct(JSPUtil.getParameter(request, "cct", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiMsgToDLSVO[]
	 */
	public EdiMsgToDLSVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiMsgToDLSVO[]
	 */
	public EdiMsgToDLSVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiMsgToDLSVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] voy = (JSPUtil.getParameter(request, prefix	+ "voy", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] dir = (JSPUtil.getParameter(request, prefix	+ "dir", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiMsgToDLSVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (voy[i] != null)
					model.setVoy(voy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (dir[i] != null)
					model.setDir(dir[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiMsgToDLSVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiMsgToDLSVO[]
	 */
	public EdiMsgToDLSVO[] getEdiMsgToDLSVOs(){
		EdiMsgToDLSVO[] vos = (EdiMsgToDLSVO[])models.toArray(new EdiMsgToDLSVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voy = this.voy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir = this.dir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
