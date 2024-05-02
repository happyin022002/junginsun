/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfTmlProdRptRsnCdVO.java
*@FileTitle : OpfTmlProdRptRsnCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfTmlProdRptRsnCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfTmlProdRptRsnCdVO> models = new ArrayList<OpfTmlProdRptRsnCdVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tdrRptRsnCd = null;
	/* Column Info */
	private String keyOfRemark = null;
	/* Column Info */
	private String tmlProdRptRsnDesc = null;
	/* Column Info */
	private String tmlProdRptRsnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpfTmlProdRptRsnCdVO() {}

	public OpfTmlProdRptRsnCdVO(String ibflag, String pagerows, String tmlProdRptRsnCd, String tmlProdRptRsnDesc, String tdrRptRsnCd, String keyOfRemark) {
		this.ibflag = ibflag;
		this.tdrRptRsnCd = tdrRptRsnCd;
		this.keyOfRemark = keyOfRemark;
		this.tmlProdRptRsnDesc = tmlProdRptRsnDesc;
		this.tmlProdRptRsnCd = tmlProdRptRsnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tdr_rpt_rsn_cd", getTdrRptRsnCd());
		this.hashColumns.put("key_of_remark", getKeyOfRemark());
		this.hashColumns.put("tml_prod_rpt_rsn_desc", getTmlProdRptRsnDesc());
		this.hashColumns.put("tml_prod_rpt_rsn_cd", getTmlProdRptRsnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tdr_rpt_rsn_cd", "tdrRptRsnCd");
		this.hashFields.put("key_of_remark", "keyOfRemark");
		this.hashFields.put("tml_prod_rpt_rsn_desc", "tmlProdRptRsnDesc");
		this.hashFields.put("tml_prod_rpt_rsn_cd", "tmlProdRptRsnCd");
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
	 * @return tdrRptRsnCd
	 */
	public String getTdrRptRsnCd() {
		return this.tdrRptRsnCd;
	}
	
	/**
	 * Column Info
	 * @return keyOfRemark
	 */
	public String getKeyOfRemark() {
		return this.keyOfRemark;
	}
	
	/**
	 * Column Info
	 * @return tmlProdRptRsnDesc
	 */
	public String getTmlProdRptRsnDesc() {
		return this.tmlProdRptRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return tmlProdRptRsnCd
	 */
	public String getTmlProdRptRsnCd() {
		return this.tmlProdRptRsnCd;
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
	 * @param tdrRptRsnCd
	 */
	public void setTdrRptRsnCd(String tdrRptRsnCd) {
		this.tdrRptRsnCd = tdrRptRsnCd;
	}
	
	/**
	 * Column Info
	 * @param keyOfRemark
	 */
	public void setKeyOfRemark(String keyOfRemark) {
		this.keyOfRemark = keyOfRemark;
	}
	
	/**
	 * Column Info
	 * @param tmlProdRptRsnDesc
	 */
	public void setTmlProdRptRsnDesc(String tmlProdRptRsnDesc) {
		this.tmlProdRptRsnDesc = tmlProdRptRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param tmlProdRptRsnCd
	 */
	public void setTmlProdRptRsnCd(String tmlProdRptRsnCd) {
		this.tmlProdRptRsnCd = tmlProdRptRsnCd;
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
		setTdrRptRsnCd(JSPUtil.getParameter(request, "tdr_rpt_rsn_cd", ""));
		setKeyOfRemark(JSPUtil.getParameter(request, "key_of_remark", ""));
		setTmlProdRptRsnDesc(JSPUtil.getParameter(request, "tml_prod_rpt_rsn_desc", ""));
		setTmlProdRptRsnCd(JSPUtil.getParameter(request, "tml_prod_rpt_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfTmlProdRptRsnCdVO[]
	 */
	public OpfTmlProdRptRsnCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfTmlProdRptRsnCdVO[]
	 */
	public OpfTmlProdRptRsnCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfTmlProdRptRsnCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tdrRptRsnCd = (JSPUtil.getParameter(request, prefix	+ "tdr_rpt_rsn_cd", length));
			String[] keyOfRemark = (JSPUtil.getParameter(request, prefix	+ "key_of_remark", length));
			String[] tmlProdRptRsnDesc = (JSPUtil.getParameter(request, prefix	+ "tml_prod_rpt_rsn_desc", length));
			String[] tmlProdRptRsnCd = (JSPUtil.getParameter(request, prefix	+ "tml_prod_rpt_rsn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfTmlProdRptRsnCdVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tdrRptRsnCd[i] != null)
					model.setTdrRptRsnCd(tdrRptRsnCd[i]);
				if (keyOfRemark[i] != null)
					model.setKeyOfRemark(keyOfRemark[i]);
				if (tmlProdRptRsnDesc[i] != null)
					model.setTmlProdRptRsnDesc(tmlProdRptRsnDesc[i]);
				if (tmlProdRptRsnCd[i] != null)
					model.setTmlProdRptRsnCd(tmlProdRptRsnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfTmlProdRptRsnCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfTmlProdRptRsnCdVO[]
	 */
	public OpfTmlProdRptRsnCdVO[] getOpfTmlProdRptRsnCdVOs(){
		OpfTmlProdRptRsnCdVO[] vos = (OpfTmlProdRptRsnCdVO[])models.toArray(new OpfTmlProdRptRsnCdVO[models.size()]);
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
		this.tdrRptRsnCd = this.tdrRptRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyOfRemark = this.keyOfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdRptRsnDesc = this.tmlProdRptRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdRptRsnCd = this.tmlProdRptRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
