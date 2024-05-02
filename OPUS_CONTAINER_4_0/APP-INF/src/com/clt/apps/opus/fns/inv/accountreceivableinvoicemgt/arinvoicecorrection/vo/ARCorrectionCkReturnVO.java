/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARCorrectionCkReturnVO.java
*@FileTitle : ARCorrectionCkReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.09 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARCorrectionCkReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARCorrectionCkReturnVO> models = new ArrayList<ARCorrectionCkReturnVO>();
	
	/* Column Info */
	private String zoneIoc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String effectiveDt = null;
	/* Column Info */
	private String revTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARCorrectionCkReturnVO() {}

	public ARCorrectionCkReturnVO(String ibflag, String pagerows, String revTpCd, String revSrcCd, String zoneIoc, String effectiveDt) {
		this.zoneIoc = zoneIoc;
		this.ibflag = ibflag;
		this.revSrcCd = revSrcCd;
		this.effectiveDt = effectiveDt;
		this.revTpCd = revTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("zone_ioc", getZoneIoc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("effective_dt", getEffectiveDt());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("zone_ioc", "zoneIoc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("effective_dt", "effectiveDt");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return zoneIoc
	 */
	public String getZoneIoc() {
		return this.zoneIoc;
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
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return effectiveDt
	 */
	public String getEffectiveDt() {
		return this.effectiveDt;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
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
	 * @param zoneIoc
	 */
	public void setZoneIoc(String zoneIoc) {
		this.zoneIoc = zoneIoc;
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
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param effectiveDt
	 */
	public void setEffectiveDt(String effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
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
		setZoneIoc(JSPUtil.getParameter(request, "zone_ioc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setEffectiveDt(JSPUtil.getParameter(request, "effective_dt", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARCorrectionCkReturnVO[]
	 */
	public ARCorrectionCkReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARCorrectionCkReturnVO[]
	 */
	public ARCorrectionCkReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARCorrectionCkReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] zoneIoc = (JSPUtil.getParameter(request, prefix	+ "zone_ioc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] effectiveDt = (JSPUtil.getParameter(request, prefix	+ "effective_dt", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARCorrectionCkReturnVO();
				if (zoneIoc[i] != null)
					model.setZoneIoc(zoneIoc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (effectiveDt[i] != null)
					model.setEffectiveDt(effectiveDt[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARCorrectionCkReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARCorrectionCkReturnVO[]
	 */
	public ARCorrectionCkReturnVO[] getARCorrectionCkReturnVOs(){
		ARCorrectionCkReturnVO[] vos = (ARCorrectionCkReturnVO[])models.toArray(new ARCorrectionCkReturnVO[models.size()]);
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
		this.zoneIoc = this.zoneIoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effectiveDt = this.effectiveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
