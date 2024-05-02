/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostCodeINVO.java
*@FileTitle : CostCodeINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.08.17 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CostCodeINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CostCodeINVO> models = new ArrayList<CostCodeINVO>();
	
	/* Column Info */
	private String cmpoCd = null;
	/* Column Info */
	private String tpSz = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String offFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CostCodeINVO() {}

	public CostCodeINVO(String ibflag, String pagerows, String tpSz, String cmpoCd, String offFlg) {
		this.cmpoCd = cmpoCd;
		this.tpSz = tpSz;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.offFlg = offFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmpo_cd", getCmpoCd());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("off_flg", getOffFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmpo_cd", "cmpoCd");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("off_flg", "offFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmpoCd
	 */
	public String getCmpoCd() {
		return this.cmpoCd;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return offFlg
	 */
	public String getOffFlg() {
		return this.offFlg;
	}
	
	/**
	 * Column Info
	 * @param cmpoCd
	 */
	public void setCmpoCd(String cmpoCd) {
		this.cmpoCd = cmpoCd;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param offFlg
	 */
	public void setOffFlg(String offFlg) {
		this.offFlg = offFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmpoCd(JSPUtil.getParameter(request, "cmpo_cd", ""));
		setTpSz(JSPUtil.getParameter(request, "tp_sz", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOffFlg(JSPUtil.getParameter(request, "off_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CostCodeINVO[]
	 */
	public CostCodeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CostCodeINVO[]
	 */
	public CostCodeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CostCodeINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmpoCd = (JSPUtil.getParameter(request, prefix	+ "cmpo_cd", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] offFlg = (JSPUtil.getParameter(request, prefix	+ "off_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CostCodeINVO();
				if (cmpoCd[i] != null)
					model.setCmpoCd(cmpoCd[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (offFlg[i] != null)
					model.setOffFlg(offFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCostCodeINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CostCodeINVO[]
	 */
	public CostCodeINVO[] getCostCodeINVOs(){
		CostCodeINVO[] vos = (CostCodeINVO[])models.toArray(new CostCodeINVO[models.size()]);
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
		this.cmpoCd = this.cmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offFlg = this.offFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
