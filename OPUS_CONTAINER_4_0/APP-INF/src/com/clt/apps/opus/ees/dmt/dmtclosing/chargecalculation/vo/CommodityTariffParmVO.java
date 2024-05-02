/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityTariffParmVO.java
*@FileTitle : CommodityTariffParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommodityTariffParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityTariffParmVO> models = new ArrayList<CommodityTariffParmVO>();
	
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtTrfSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String trfSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityTariffParmVO() {}

	public CommodityTariffParmVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String cmdtCd, String cmdtTrfSeq) {
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.cmdtTrfSeq = cmdtTrfSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.trfSeq = trfSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_trf_seq", getCmdtTrfSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_trf_seq", "cmdtTrfSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("trf_seq", "trfSeq");
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
	 * @return cmdtTrfSeq
	 */
	public String getCmdtTrfSeq() {
		return this.cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
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
	 * @param cmdtTrfSeq
	 */
	public void setCmdtTrfSeq(String cmdtTrfSeq) {
		this.cmdtTrfSeq = cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCmdtTrfSeq(JSPUtil.getParameter(request, "cmdt_trf_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityTariffParmVO[]
	 */
	public CommodityTariffParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityTariffParmVO[]
	 */
	public CommodityTariffParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityTariffParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtTrfSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_trf_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityTariffParmVO();
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtTrfSeq[i] != null)
					model.setCmdtTrfSeq(cmdtTrfSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityTariffParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityTariffParmVO[]
	 */
	public CommodityTariffParmVO[] getCommodityTariffParmVOs(){
		CommodityTariffParmVO[] vos = (CommodityTariffParmVO[])models.toArray(new CommodityTariffParmVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTrfSeq = this.cmdtTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
