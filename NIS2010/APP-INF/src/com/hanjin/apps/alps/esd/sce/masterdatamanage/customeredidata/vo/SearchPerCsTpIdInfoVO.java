/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPerCsTpIdInfoVO.java
*@FileTitle : SearchPerCsTpIdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.25 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerCsTpIdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerCsTpIdInfoVO> models = new ArrayList<SearchPerCsTpIdInfoVO>();
	
	/* Column Info */
	private String ediSts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csDesc = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String tpId = null;
	/* Column Info */
	private String csGrpId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPerCsTpIdInfoVO() {}

	public SearchPerCsTpIdInfoVO(String ibflag, String pagerows, String csGrpId, String tpId, String csDesc, String custCd, String ediSts) {
		this.ediSts = ediSts;
		this.ibflag = ibflag;
		this.csDesc = csDesc;
		this.custCd = custCd;
		this.tpId = tpId;
		this.csGrpId = csGrpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cs_desc", getCsDesc());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("tp_id", getTpId());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cs_desc", "csDesc");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("tp_id", "tpId");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
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
	 * @return csDesc
	 */
	public String getCsDesc() {
		return this.csDesc;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return tpId
	 */
	public String getTpId() {
		return this.tpId;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
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
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
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
	 * @param csDesc
	 */
	public void setCsDesc(String csDesc) {
		this.csDesc = csDesc;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param tpId
	 */
	public void setTpId(String tpId) {
		this.tpId = tpId;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
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
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCsDesc(JSPUtil.getParameter(request, "cs_desc", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setTpId(JSPUtil.getParameter(request, "tp_id", ""));
		setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerCsTpIdInfoVO[]
	 */
	public SearchPerCsTpIdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerCsTpIdInfoVO[]
	 */
	public SearchPerCsTpIdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerCsTpIdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] csDesc = (JSPUtil.getParameter(request, prefix	+ "cs_desc", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] tpId = (JSPUtil.getParameter(request, prefix	+ "tp_id", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerCsTpIdInfoVO();
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (csDesc[i] != null)
					model.setCsDesc(csDesc[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (tpId[i] != null)
					model.setTpId(tpId[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerCsTpIdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerCsTpIdInfoVO[]
	 */
	public SearchPerCsTpIdInfoVO[] getSearchPerCsTpIdInfoVOs(){
		SearchPerCsTpIdInfoVO[] vos = (SearchPerCsTpIdInfoVO[])models.toArray(new SearchPerCsTpIdInfoVO[models.size()]);
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
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csDesc = this.csDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpId = this.tpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
