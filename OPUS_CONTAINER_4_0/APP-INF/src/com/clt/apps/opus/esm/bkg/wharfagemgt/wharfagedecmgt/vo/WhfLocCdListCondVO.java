/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WhfLocCdListCondVO.java
*@FileTitle : WhfLocCdListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.10 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WhfLocCdListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WhfLocCdListCondVO> models = new ArrayList<WhfLocCdListCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String whfPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String whfBndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WhfLocCdListCondVO() {}

	public WhfLocCdListCondVO(String ibflag, String pagerows, String vvd, String whfPolCd, String whfBndCd) {
		this.vvd = vvd;
		this.whfPolCd = whfPolCd;
		this.ibflag = ibflag;
		this.whfBndCd = whfBndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("whf_pol_cd", getWhfPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("whf_pol_cd", "whfPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return whfPolCd
	 */
	public String getWhfPolCd() {
		return this.whfPolCd;
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
	 * @return whfBndCd
	 */
	public String getWhfBndCd() {
		return this.whfBndCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param whfPolCd
	 */
	public void setWhfPolCd(String whfPolCd) {
		this.whfPolCd = whfPolCd;
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
	 * @param whfBndCd
	 */
	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setWhfPolCd(JSPUtil.getParameter(request, "whf_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWhfBndCd(JSPUtil.getParameter(request, "whf_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfBlListCondVO[]
	 */
	public WhfLocCdListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfBlListCondVO[]
	 */
	public WhfLocCdListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WhfLocCdListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] whfPolCd = (JSPUtil.getParameter(request, prefix	+ "whf_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new WhfLocCdListCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (whfPolCd[i] != null)
					model.setWhfPolCd(whfPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfBlListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfBlListCondVO[]
	 */
	public WhfLocCdListCondVO[] getKrWhfBlListCondVOs(){
		WhfLocCdListCondVO[] vos = (WhfLocCdListCondVO[])models.toArray(new WhfLocCdListCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfPolCd = this.whfPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
