/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityExceptionParmVO.java
*@FileTitle : CommodityExceptionParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.19 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommodityExceptionParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityExceptionParmVO> models = new ArrayList<CommodityExceptionParmVO>();
	
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dttCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String efftDt = null;
	/* Column Info */
	private String dtnSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityExceptionParmVO() {}

	public CommodityExceptionParmVO(String ibflag, String pagerows, String svrId, String dttCode, String dtnSeq, String cmdtCd, String efftDt) {
		this.svrId = svrId;
		this.dttCode = dttCode;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.efftDt = efftDt;
		this.dtnSeq = dtnSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dtt_code", getDttCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("efft_dt", getEfftDt());
		this.hashColumns.put("dtn_seq", getDtnSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dtt_code", "dttCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("efft_dt", "efftDt");
		this.hashFields.put("dtn_seq", "dtnSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return dttCode
	 */
	public String getDttCode() {
		return this.dttCode;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return efftDt
	 */
	public String getEfftDt() {
		return this.efftDt;
	}
	
	/**
	 * Column Info
	 * @return dtnSeq
	 */
	public String getDtnSeq() {
		return this.dtnSeq;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param dttCode
	 */
	public void setDttCode(String dttCode) {
		this.dttCode = dttCode;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param efftDt
	 */
	public void setEfftDt(String efftDt) {
		this.efftDt = efftDt;
	}
	
	/**
	 * Column Info
	 * @param dtnSeq
	 */
	public void setDtnSeq(String dtnSeq) {
		this.dtnSeq = dtnSeq;
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
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setDttCode(JSPUtil.getParameter(request, "dtt_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setEfftDt(JSPUtil.getParameter(request, "efft_dt", ""));
		setDtnSeq(JSPUtil.getParameter(request, "dtn_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityExceptionParmVO[]
	 */
	public CommodityExceptionParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityExceptionParmVO[]
	 */
	public CommodityExceptionParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityExceptionParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] dttCode = (JSPUtil.getParameter(request, prefix	+ "dtt_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] efftDt = (JSPUtil.getParameter(request, prefix	+ "efft_dt", length));
			String[] dtnSeq = (JSPUtil.getParameter(request, prefix	+ "dtn_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityExceptionParmVO();
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dttCode[i] != null)
					model.setDttCode(dttCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (efftDt[i] != null)
					model.setEfftDt(efftDt[i]);
				if (dtnSeq[i] != null)
					model.setDtnSeq(dtnSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityExceptionParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityExceptionParmVO[]
	 */
	public CommodityExceptionParmVO[] getCommodityExceptionParmVOs(){
		CommodityExceptionParmVO[] vos = (CommodityExceptionParmVO[])models.toArray(new CommodityExceptionParmVO[models.size()]);
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
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dttCode = this.dttCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.efftDt = this.efftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtnSeq = this.dtnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
