/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanSearchBlMarksDescVO.java
*@FileTitle : TaiwanSearchBlMarksDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.04 임재택 
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

public class TaiwanSearchBlMarksDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanSearchBlMarksDescVO> models = new ArrayList<TaiwanSearchBlMarksDescVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmpstr5 = null;
	/* Column Info */
	private String tmpstr4 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaiwanSearchBlMarksDescVO() {}

	public TaiwanSearchBlMarksDescVO(String ibflag, String pagerows, String tmpstr4, String tmpstr5) {
		this.ibflag = ibflag;
		this.tmpstr5 = tmpstr5;
		this.tmpstr4 = tmpstr4;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmpstr5", getTmpstr5());
		this.hashColumns.put("tmpstr4", getTmpstr4());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmpstr5", "tmpstr5");
		this.hashFields.put("tmpstr4", "tmpstr4");
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
	 * @return tmpstr5
	 */
	public String getTmpstr5() {
		return this.tmpstr5;
	}
	
	/**
	 * Column Info
	 * @return tmpstr4
	 */
	public String getTmpstr4() {
		return this.tmpstr4;
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
	 * @param tmpstr5
	 */
	public void setTmpstr5(String tmpstr5) {
		this.tmpstr5 = tmpstr5;
	}
	
	/**
	 * Column Info
	 * @param tmpstr4
	 */
	public void setTmpstr4(String tmpstr4) {
		this.tmpstr4 = tmpstr4;
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
		setTmpstr5(JSPUtil.getParameter(request, "tmpstr5", ""));
		setTmpstr4(JSPUtil.getParameter(request, "tmpstr4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanSearchBlMarksDescVO[]
	 */
	public TaiwanSearchBlMarksDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanSearchBlMarksDescVO[]
	 */
	public TaiwanSearchBlMarksDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanSearchBlMarksDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmpstr5 = (JSPUtil.getParameter(request, prefix	+ "tmpstr5", length));
			String[] tmpstr4 = (JSPUtil.getParameter(request, prefix	+ "tmpstr4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanSearchBlMarksDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmpstr5[i] != null)
					model.setTmpstr5(tmpstr5[i]);
				if (tmpstr4[i] != null)
					model.setTmpstr4(tmpstr4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanSearchBlMarksDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanSearchBlMarksDescVO[]
	 */
	public TaiwanSearchBlMarksDescVO[] getTaiwanSearchBlMarksDescVOs(){
		TaiwanSearchBlMarksDescVO[] vos = (TaiwanSearchBlMarksDescVO[])models.toArray(new TaiwanSearchBlMarksDescVO[models.size()]);
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
		this.tmpstr5 = this.tmpstr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr4 = this.tmpstr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
