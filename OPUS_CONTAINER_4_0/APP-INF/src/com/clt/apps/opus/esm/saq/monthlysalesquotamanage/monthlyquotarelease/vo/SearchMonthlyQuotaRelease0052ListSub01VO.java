/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaRelease0052ListSub01VO.java
*@FileTitle : SearchMonthlyQuotaRelease0052ListSub01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.28 주선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.vo;

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
 * @author 주선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaRelease0052ListSub01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaRelease0052ListSub01VO> models = new ArrayList<SearchMonthlyQuotaRelease0052ListSub01VO>();
	
	/* Column Info */
	private String mqtaRlseVerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String saqTgtGrpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mqtaVerNo = null;
	/* Column Info */
	private String glineVerNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaRelease0052ListSub01VO() {}

	public SearchMonthlyQuotaRelease0052ListSub01VO(String ibflag, String pagerows, String mqtaRlseVerNo, String saqTgtGrpCd, String trdCd, String dirCd, String mqtaVerNo, String glineVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
		this.ibflag = ibflag;
		this.saqTgtGrpCd = saqTgtGrpCd;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.mqtaVerNo = mqtaVerNo;
		this.glineVerNo = glineVerNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mqta_rlse_ver_no", getMqtaRlseVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("saq_tgt_grp_cd", getSaqTgtGrpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mqta_ver_no", getMqtaVerNo());
		this.hashColumns.put("gline_ver_no", getGlineVerNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mqta_rlse_ver_no", "mqtaRlseVerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("saq_tgt_grp_cd", "saqTgtGrpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mqta_ver_no", "mqtaVerNo");
		this.hashFields.put("gline_ver_no", "glineVerNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mqtaRlseVerNo
	 */
	public String getMqtaRlseVerNo() {
		return this.mqtaRlseVerNo;
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
	 * @return saqTgtGrpCd
	 */
	public String getSaqTgtGrpCd() {
		return this.saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return mqtaVerNo
	 */
	public String getMqtaVerNo() {
		return this.mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @return glineVerNo
	 */
	public String getGlineVerNo() {
		return this.glineVerNo;
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
	 * @param mqtaRlseVerNo
	 */
	public void setMqtaRlseVerNo(String mqtaRlseVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
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
	 * @param saqTgtGrpCd
	 */
	public void setSaqTgtGrpCd(String saqTgtGrpCd) {
		this.saqTgtGrpCd = saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param mqtaVerNo
	 */
	public void setMqtaVerNo(String mqtaVerNo) {
		this.mqtaVerNo = mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @param glineVerNo
	 */
	public void setGlineVerNo(String glineVerNo) {
		this.glineVerNo = glineVerNo;
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
		setMqtaRlseVerNo(JSPUtil.getParameter(request, "mqta_rlse_ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSaqTgtGrpCd(JSPUtil.getParameter(request, "saq_tgt_grp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setMqtaVerNo(JSPUtil.getParameter(request, "mqta_ver_no", ""));
		setGlineVerNo(JSPUtil.getParameter(request, "gline_ver_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaRelease0052ListSub01VO[]
	 */
	public SearchMonthlyQuotaRelease0052ListSub01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaRelease0052ListSub01VO[]
	 */
	public SearchMonthlyQuotaRelease0052ListSub01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaRelease0052ListSub01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mqtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_rlse_ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] saqTgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "saq_tgt_grp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_no", length));
			String[] glineVerNo = (JSPUtil.getParameter(request, prefix	+ "gline_ver_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaRelease0052ListSub01VO();
				if (mqtaRlseVerNo[i] != null)
					model.setMqtaRlseVerNo(mqtaRlseVerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (saqTgtGrpCd[i] != null)
					model.setSaqTgtGrpCd(saqTgtGrpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mqtaVerNo[i] != null)
					model.setMqtaVerNo(mqtaVerNo[i]);
				if (glineVerNo[i] != null)
					model.setGlineVerNo(glineVerNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaRelease0052ListSub01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaRelease0052ListSub01VO[]
	 */
	public SearchMonthlyQuotaRelease0052ListSub01VO[] getSearchMonthlyQuotaRelease0052ListSub01VOs(){
		SearchMonthlyQuotaRelease0052ListSub01VO[] vos = (SearchMonthlyQuotaRelease0052ListSub01VO[])models.toArray(new SearchMonthlyQuotaRelease0052ListSub01VO[models.size()]);
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
		this.mqtaRlseVerNo = this.mqtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqTgtGrpCd = this.saqTgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerNo = this.mqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineVerNo = this.glineVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
