/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EtaVO.java
*@FileTitle : EtaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.10 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EtaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EtaVO> models = new ArrayList<EtaVO>();
	
	/* Column Info */
	private String minRrmmddh = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxRrmmddh = null;
	/* Column Info */
	private String maxMmddrr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EtaVO() {}

	public EtaVO(String ibflag, String pagerows, String maxMmddrr, String maxRrmmddh, String minRrmmddh) {
		this.minRrmmddh = minRrmmddh;
		this.ibflag = ibflag;
		this.maxRrmmddh = maxRrmmddh;
		this.maxMmddrr = maxMmddrr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("min_rrmmddh", getMinRrmmddh());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_rrmmddh", getMaxRrmmddh());
		this.hashColumns.put("max_mmddrr", getMaxMmddrr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("min_rrmmddh", "minRrmmddh");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_rrmmddh", "maxRrmmddh");
		this.hashFields.put("max_mmddrr", "maxMmddrr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return minRrmmddh
	 */
	public String getMinRrmmddh() {
		return this.minRrmmddh;
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
	 * @return maxRrmmddh
	 */
	public String getMaxRrmmddh() {
		return this.maxRrmmddh;
	}
	
	/**
	 * Column Info
	 * @return maxMmddrr
	 */
	public String getMaxMmddrr() {
		return this.maxMmddrr;
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
	 * @param minRrmmddh
	 */
	public void setMinRrmmddh(String minRrmmddh) {
		this.minRrmmddh = minRrmmddh;
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
	 * @param maxRrmmddh
	 */
	public void setMaxRrmmddh(String maxRrmmddh) {
		this.maxRrmmddh = maxRrmmddh;
	}
	
	/**
	 * Column Info
	 * @param maxMmddrr
	 */
	public void setMaxMmddrr(String maxMmddrr) {
		this.maxMmddrr = maxMmddrr;
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
		setMinRrmmddh(JSPUtil.getParameter(request, "min_rrmmddh", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMaxRrmmddh(JSPUtil.getParameter(request, "max_rrmmddh", ""));
		setMaxMmddrr(JSPUtil.getParameter(request, "max_mmddrr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EtaVO[]
	 */
	public EtaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EtaVO[]
	 */
	public EtaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EtaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] minRrmmddh = (JSPUtil.getParameter(request, prefix	+ "min_rrmmddh", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxRrmmddh = (JSPUtil.getParameter(request, prefix	+ "max_rrmmddh", length));
			String[] maxMmddrr = (JSPUtil.getParameter(request, prefix	+ "max_mmddrr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EtaVO();
				if (minRrmmddh[i] != null)
					model.setMinRrmmddh(minRrmmddh[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxRrmmddh[i] != null)
					model.setMaxRrmmddh(maxRrmmddh[i]);
				if (maxMmddrr[i] != null)
					model.setMaxMmddrr(maxMmddrr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEtaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EtaVO[]
	 */
	public EtaVO[] getEtaVOs(){
		EtaVO[] vos = (EtaVO[])models.toArray(new EtaVO[models.size()]);
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
		this.minRrmmddh = this.minRrmmddh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRrmmddh = this.maxRrmmddh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxMmddrr = this.maxMmddrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
