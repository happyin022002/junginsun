/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRRfMainTradeVO.java
*@FileTitle : RDRRfMainTradeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.08.05 이선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRRfMainTradeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRRfMainTradeVO> models = new ArrayList<RDRRfMainTradeVO>();
	
	/* Column Info */
	private String qty20 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String qty40 = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRRfMainTradeVO() {}

	public RDRRfMainTradeVO(String ibflag, String pagerows, String oprCd, String pol, String pod, String qty20, String qty40) {
		this.qty20 = qty20;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.pol = pol;
		this.qty40 = qty40;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty_20", getQty20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("qty_40", getQty40());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty_20", "qty20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("qty_40", "qty40");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qty20
	 */
	public String getQty20() {
		return this.qty20;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return qty40
	 */
	public String getQty40() {
		return this.qty40;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param qty20
	 */
	public void setQty20(String qty20) {
		this.qty20 = qty20;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param qty40
	 */
	public void setQty40(String qty40) {
		this.qty40 = qty40;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setQty20(JSPUtil.getParameter(request, "qty_20", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setQty40(JSPUtil.getParameter(request, "qty_40", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRRfMainTradeVO[]
	 */
	public RDRRfMainTradeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRRfMainTradeVO[]
	 */
	public RDRRfMainTradeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRRfMainTradeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty_20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] qty40 = (JSPUtil.getParameter(request, prefix	+ "qty_40", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRRfMainTradeVO();
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (qty40[i] != null)
					model.setQty40(qty40[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRRfMainTradeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRRfMainTradeVO[]
	 */
	public RDRRfMainTradeVO[] getRDRRfMainTradeVOs(){
		RDRRfMainTradeVO[] vos = (RDRRfMainTradeVO[])models.toArray(new RDRRfMainTradeVO[models.size()]);
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
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty40 = this.qty40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
