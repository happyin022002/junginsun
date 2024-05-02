/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodLastHistoryVO.java
*@FileTitle : CodLastHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.19 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodLastHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodLastHistoryVO> models = new ArrayList<CodLastHistoryVO>();
	
	/* Column Info */
	private String updateBy = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codHisSeq = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String updateOfc = null;
	/* Column Info */
	private String nowRead = null;
	/* Column Info */
	private String previous = null;
	/* Column Info */
	private String codStsCd = null;
	/* Column Info */
	private String codHisDtlSeq = null;
	/* Column Info */
	private String updateDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodLastHistoryVO() {}

	public CodLastHistoryVO(String ibflag, String pagerows, String codStsCd, String updateDate, String updateBy, String updateOfc, String previous, String nowRead, String bkgNo, String codRqstSeq, String codHisSeq, String codHisDtlSeq) {
		this.updateBy = updateBy;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.codHisSeq = codHisSeq;
		this.codRqstSeq = codRqstSeq;
		this.updateOfc = updateOfc;
		this.nowRead = nowRead;
		this.previous = previous;
		this.codStsCd = codStsCd;
		this.codHisDtlSeq = codHisDtlSeq;
		this.updateDate = updateDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("update_by", getUpdateBy());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cod_his_seq", getCodHisSeq());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("update_ofc", getUpdateOfc());
		this.hashColumns.put("now_read", getNowRead());
		this.hashColumns.put("previous", getPrevious());
		this.hashColumns.put("cod_sts_cd", getCodStsCd());
		this.hashColumns.put("cod_his_dtl_seq", getCodHisDtlSeq());
		this.hashColumns.put("update_date", getUpdateDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("update_by", "updateBy");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cod_his_seq", "codHisSeq");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("update_ofc", "updateOfc");
		this.hashFields.put("now_read", "nowRead");
		this.hashFields.put("previous", "previous");
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("cod_his_dtl_seq", "codHisDtlSeq");
		this.hashFields.put("update_date", "updateDate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updateBy
	 */
	public String getUpdateBy() {
		return this.updateBy;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return codHisSeq
	 */
	public String getCodHisSeq() {
		return this.codHisSeq;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return updateOfc
	 */
	public String getUpdateOfc() {
		return this.updateOfc;
	}
	
	/**
	 * Column Info
	 * @return nowRead
	 */
	public String getNowRead() {
		return this.nowRead;
	}
	
	/**
	 * Column Info
	 * @return previous
	 */
	public String getPrevious() {
		return this.previous;
	}
	
	/**
	 * Column Info
	 * @return codStsCd
	 */
	public String getCodStsCd() {
		return this.codStsCd;
	}
	
	/**
	 * Column Info
	 * @return codHisDtlSeq
	 */
	public String getCodHisDtlSeq() {
		return this.codHisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return this.updateDate;
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
	 * @param updateBy
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param codHisSeq
	 */
	public void setCodHisSeq(String codHisSeq) {
		this.codHisSeq = codHisSeq;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param updateOfc
	 */
	public void setUpdateOfc(String updateOfc) {
		this.updateOfc = updateOfc;
	}
	
	/**
	 * Column Info
	 * @param nowRead
	 */
	public void setNowRead(String nowRead) {
		this.nowRead = nowRead;
	}
	
	/**
	 * Column Info
	 * @param previous
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	
	/**
	 * Column Info
	 * @param codStsCd
	 */
	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
	}
	
	/**
	 * Column Info
	 * @param codHisDtlSeq
	 */
	public void setCodHisDtlSeq(String codHisDtlSeq) {
		this.codHisDtlSeq = codHisDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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
		setUpdateBy(JSPUtil.getParameter(request, "update_by", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCodHisSeq(JSPUtil.getParameter(request, "cod_his_seq", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq", ""));
		setUpdateOfc(JSPUtil.getParameter(request, "update_ofc", ""));
		setNowRead(JSPUtil.getParameter(request, "now_read", ""));
		setPrevious(JSPUtil.getParameter(request, "previous", ""));
		setCodStsCd(JSPUtil.getParameter(request, "cod_sts_cd", ""));
		setCodHisDtlSeq(JSPUtil.getParameter(request, "cod_his_dtl_seq", ""));
		setUpdateDate(JSPUtil.getParameter(request, "update_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodLastHistoryVO[]
	 */
	public CodLastHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodLastHistoryVO[]
	 */
	public CodLastHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodLastHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updateBy = (JSPUtil.getParameter(request, prefix	+ "update_by", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codHisSeq = (JSPUtil.getParameter(request, prefix	+ "cod_his_seq", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] updateOfc = (JSPUtil.getParameter(request, prefix	+ "update_ofc", length));
			String[] nowRead = (JSPUtil.getParameter(request, prefix	+ "now_read", length));
			String[] previous = (JSPUtil.getParameter(request, prefix	+ "previous", length));
			String[] codStsCd = (JSPUtil.getParameter(request, prefix	+ "cod_sts_cd", length));
			String[] codHisDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cod_his_dtl_seq", length));
			String[] updateDate = (JSPUtil.getParameter(request, prefix	+ "update_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodLastHistoryVO();
				if (updateBy[i] != null)
					model.setUpdateBy(updateBy[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codHisSeq[i] != null)
					model.setCodHisSeq(codHisSeq[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (updateOfc[i] != null)
					model.setUpdateOfc(updateOfc[i]);
				if (nowRead[i] != null)
					model.setNowRead(nowRead[i]);
				if (previous[i] != null)
					model.setPrevious(previous[i]);
				if (codStsCd[i] != null)
					model.setCodStsCd(codStsCd[i]);
				if (codHisDtlSeq[i] != null)
					model.setCodHisDtlSeq(codHisDtlSeq[i]);
				if (updateDate[i] != null)
					model.setUpdateDate(updateDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodLastHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodLastHistoryVO[]
	 */
	public CodLastHistoryVO[] getCodLastHistoryVOs(){
		CodLastHistoryVO[] vos = (CodLastHistoryVO[])models.toArray(new CodLastHistoryVO[models.size()]);
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
		this.updateBy = this.updateBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codHisSeq = this.codHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateOfc = this.updateOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nowRead = this.nowRead .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previous = this.previous .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codStsCd = this.codStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codHisDtlSeq = this.codHisDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateDate = this.updateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
