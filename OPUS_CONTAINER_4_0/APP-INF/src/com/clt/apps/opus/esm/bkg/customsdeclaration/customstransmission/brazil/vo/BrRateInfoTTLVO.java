/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrRateInfoTTLVO.java
*@FileTitle : BrRateInfoTTLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.27 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrRateInfoTTLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrRateInfoTTLVO> models = new ArrayList<BrRateInfoTTLVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = "";
	/* Column Info */
	private String cctTotal = "";
	/* Column Info */
	private String totalCur = "";
	/* Column Info */
	private String ppdTotal = "";
	/* Page Number */
	private String pagerows = "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrRateInfoTTLVO() {}

	public BrRateInfoTTLVO(String ibflag, String pagerows, String ppdTotal, String cctTotal, String totalCur) {
		this.ibflag = ibflag;
		this.cctTotal = cctTotal;
		this.totalCur = totalCur;
		this.ppdTotal = ppdTotal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cct_total", getCctTotal());
		this.hashColumns.put("total_cur", getTotalCur());
		this.hashColumns.put("ppd_total", getPpdTotal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cct_total", "cctTotal");
		this.hashFields.put("total_cur", "totalCur");
		this.hashFields.put("ppd_total", "ppdTotal");
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
	 * @return cctTotal
	 */
	public String getCctTotal() {
		return this.cctTotal;
	}
	
	/**
	 * Column Info
	 * @return totalCur
	 */
	public String getTotalCur() {
		return this.totalCur;
	}
	
	/**
	 * Column Info
	 * @return ppdTotal
	 */
	public String getPpdTotal() {
		return this.ppdTotal;
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
	 * @param cctTotal
	 */
	public void setCctTotal(String cctTotal) {
		this.cctTotal = cctTotal;
	}
	
	/**
	 * Column Info
	 * @param totalCur
	 */
	public void setTotalCur(String totalCur) {
		this.totalCur = totalCur;
	}
	
	/**
	 * Column Info
	 * @param ppdTotal
	 */
	public void setPpdTotal(String ppdTotal) {
		this.ppdTotal = ppdTotal;
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
		setCctTotal(JSPUtil.getParameter(request, "cct_total", ""));
		setTotalCur(JSPUtil.getParameter(request, "total_cur", ""));
		setPpdTotal(JSPUtil.getParameter(request, "ppd_total", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrRateInfoTTLVO[]
	 */
	public BrRateInfoTTLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrRateInfoTTLVO[]
	 */
	public BrRateInfoTTLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrRateInfoTTLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cctTotal = (JSPUtil.getParameter(request, prefix	+ "cct_total".trim(), length));
			String[] totalCur = (JSPUtil.getParameter(request, prefix	+ "total_cur".trim(), length));
			String[] ppdTotal = (JSPUtil.getParameter(request, prefix	+ "ppd_total".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BrRateInfoTTLVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cctTotal[i] != null)
					model.setCctTotal(cctTotal[i]);
				if (totalCur[i] != null)
					model.setTotalCur(totalCur[i]);
				if (ppdTotal[i] != null)
					model.setPpdTotal(ppdTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrRateInfoTTLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrRateInfoTTLVO[]
	 */
	public BrRateInfoTTLVO[] getBrRateInfoTTLVOs(){
		BrRateInfoTTLVO[] vos = (BrRateInfoTTLVO[])models.toArray(new BrRateInfoTTLVO[models.size()]);
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
		this.cctTotal = this.cctTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCur = this.totalCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdTotal = this.ppdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
