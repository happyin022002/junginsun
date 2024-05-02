/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : QtyInfoForTroVO.java
*@FileTitle : QtyInfoForTroVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.10 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class QtyInfoForTroVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<QtyInfoForTroVO> models = new ArrayList<QtyInfoForTroVO>();
	
	/* Column Info */
	private String troQty = null;
	/* Column Info */
	private String troQtyCh = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String totalQty = null;
	/* Column Info */
	private String troQtyMh = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public QtyInfoForTroVO() {}

	public QtyInfoForTroVO(String ibflag, String pagerows, String cntrTpszCd, String totalQty, String troQty, String troQtyCh, String troQtyMh) {
		this.troQty = troQty;
		this.troQtyCh = troQtyCh;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.totalQty = totalQty;
		this.troQtyMh = troQtyMh;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tro_qty", getTroQty());
		this.hashColumns.put("tro_qty_ch", getTroQtyCh());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("tro_qty_mh", getTroQtyMh());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tro_qty", "troQty");
		this.hashFields.put("tro_qty_ch", "troQtyCh");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("tro_qty_mh", "troQtyMh");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return troQty
	 */
	public String getTroQty() {
		return this.troQty;
	}
	
	/**
	 * Column Info
	 * @return troQtyCh
	 */
	public String getTroQtyCh() {
		return this.troQtyCh;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
	}
	
	/**
	 * Column Info
	 * @return troQtyMh
	 */
	public String getTroQtyMh() {
		return this.troQtyMh;
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
	 * @param troQty
	 */
	public void setTroQty(String troQty) {
		this.troQty = troQty;
	}
	
	/**
	 * Column Info
	 * @param troQtyCh
	 */
	public void setTroQtyCh(String troQtyCh) {
		this.troQtyCh = troQtyCh;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Column Info
	 * @param troQtyMh
	 */
	public void setTroQtyMh(String troQtyMh) {
		this.troQtyMh = troQtyMh;
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
		setTroQty(JSPUtil.getParameter(request, "tro_qty", ""));
		setTroQtyCh(JSPUtil.getParameter(request, "tro_qty_ch", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTotalQty(JSPUtil.getParameter(request, "total_qty", ""));
		setTroQtyMh(JSPUtil.getParameter(request, "tro_qty_mh", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return QtyInfoForTroVO[]
	 */
	public QtyInfoForTroVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return QtyInfoForTroVO[]
	 */
	public QtyInfoForTroVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		QtyInfoForTroVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] troQty = (JSPUtil.getParameter(request, prefix	+ "tro_qty", length));
			String[] troQtyCh = (JSPUtil.getParameter(request, prefix	+ "tro_qty_ch", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] troQtyMh = (JSPUtil.getParameter(request, prefix	+ "tro_qty_mh", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new QtyInfoForTroVO();
				if (troQty[i] != null)
					model.setTroQty(troQty[i]);
				if (troQtyCh[i] != null)
					model.setTroQtyCh(troQtyCh[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (troQtyMh[i] != null)
					model.setTroQtyMh(troQtyMh[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getQtyInfoForTroVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return QtyInfoForTroVO[]
	 */
	public QtyInfoForTroVO[] getQtyInfoForTroVOs(){
		QtyInfoForTroVO[] vos = (QtyInfoForTroVO[])models.toArray(new QtyInfoForTroVO[models.size()]);
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
		this.troQty = this.troQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQtyCh = this.troQtyCh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQtyMh = this.troQtyMh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
