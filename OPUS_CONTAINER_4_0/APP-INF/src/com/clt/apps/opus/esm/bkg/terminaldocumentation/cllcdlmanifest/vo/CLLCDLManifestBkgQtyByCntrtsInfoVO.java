/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestBkgQtyByCntrtsInfoVO.java
*@FileTitle : CLLCDLManifestBkgQtyByCntrtsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.10
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestBkgQtyByCntrtsInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestBkgQtyByCntrtsInfoVO> models = new ArrayList<CLLCDLManifestBkgQtyByCntrtsInfoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inQty = null;
	/* Column Info */
	private String inFeu = null;
	/* Column Info */
	private String inTeu = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestBkgQtyByCntrtsInfoVO() {}

	public CLLCDLManifestBkgQtyByCntrtsInfoVO(String ibflag, String pagerows, String inTeu, String inFeu, String inQty) {
		this.ibflag = ibflag;
		this.inQty = inQty;
		this.inFeu = inFeu;
		this.inTeu = inTeu;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_qty", getInQty());
		this.hashColumns.put("in_feu", getInFeu());
		this.hashColumns.put("in_teu", getInTeu());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_qty", "inQty");
		this.hashFields.put("in_feu", "inFeu");
		this.hashFields.put("in_teu", "inTeu");
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
	 * @return inQty
	 */
	public String getInQty() {
		return this.inQty;
	}

	/**
	 * Column Info
	 * @return inFeu
	 */
	public String getInFeu() {
		return this.inFeu;
	}

	/**
	 * Column Info
	 * @return inTeu
	 */
	public String getInTeu() {
		return this.inTeu;
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
	 * @param inQty
	 */
	public void setInQty(String inQty) {
		this.inQty = inQty;
	}

	/**
	 * Column Info
	 * @param inFeu
	 */
	public void setInFeu(String inFeu) {
		this.inFeu = inFeu;
	}

	/**
	 * Column Info
	 * @param inTeu
	 */
	public void setInTeu(String inTeu) {
		this.inTeu = inTeu;
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
		setInQty(JSPUtil.getParameter(request, "in_qty", ""));
		setInFeu(JSPUtil.getParameter(request, "in_feu", ""));
		setInTeu(JSPUtil.getParameter(request, "in_teu", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestBkgQtyByCntrtsInfoVO[]
	 */
	public CLLCDLManifestBkgQtyByCntrtsInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestBkgQtyByCntrtsInfoVO[]
	 */
	public CLLCDLManifestBkgQtyByCntrtsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestBkgQtyByCntrtsInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inQty = (JSPUtil.getParameter(request, prefix	+ "in_qty", length));
			String[] inFeu = (JSPUtil.getParameter(request, prefix	+ "in_feu", length));
			String[] inTeu = (JSPUtil.getParameter(request, prefix	+ "in_teu", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestBkgQtyByCntrtsInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inQty[i] != null)
					model.setInQty(inQty[i]);
				if (inFeu[i] != null)
					model.setInFeu(inFeu[i]);
				if (inTeu[i] != null)
					model.setInTeu(inTeu[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestBkgQtyByCntrtsInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestBkgQtyByCntrtsInfoVO[]
	 */
	public CLLCDLManifestBkgQtyByCntrtsInfoVO[] getCLLCDLManifestBkgQtyByCntrtsInfoVOs(){
		CLLCDLManifestBkgQtyByCntrtsInfoVO[] vos = (CLLCDLManifestBkgQtyByCntrtsInfoVO[])models.toArray(new CLLCDLManifestBkgQtyByCntrtsInfoVO[models.size()]);
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
		this.inQty = this.inQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFeu = this.inFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTeu = this.inTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}