/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpBlplHeaderVO.java
*@FileTitle : RsltPriSpBlplHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.18 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpBlplHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpBlplHeaderVO> models = new ArrayList<RsltPriSpBlplHeaderVO>();
	
	/* Column Info */
	private String blplNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrEffDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String blplRefYr = null;
	/* Column Info */
	private String blplHdrSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpBlplHeaderVO() {}

	public RsltPriSpBlplHeaderVO(String ibflag, String pagerows, String effDt, String expDt, String blplNm, String blplHdrSeq, String blplRefYr, String hdrEffDt) {
		this.blplNm = blplNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.hdrEffDt = hdrEffDt;
		this.expDt = expDt;
		this.blplRefYr = blplRefYr;
		this.blplHdrSeq = blplHdrSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blpl_nm", getBlplNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_eff_dt", getHdrEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("blpl_ref_yr", getBlplRefYr());
		this.hashColumns.put("blpl_hdr_seq", getBlplHdrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blpl_nm", "blplNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_eff_dt", "hdrEffDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("blpl_ref_yr", "blplRefYr");
		this.hashFields.put("blpl_hdr_seq", "blplHdrSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blplNm
	 */
	public String getBlplNm() {
		return this.blplNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return hdrEffDt
	 */
	public String getHdrEffDt() {
		return this.hdrEffDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return blplRefYr
	 */
	public String getBlplRefYr() {
		return this.blplRefYr;
	}
	
	/**
	 * Column Info
	 * @return blplHdrSeq
	 */
	public String getBlplHdrSeq() {
		return this.blplHdrSeq;
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
	 * @param blplNm
	 */
	public void setBlplNm(String blplNm) {
		this.blplNm = blplNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param hdrEffDt
	 */
	public void setHdrEffDt(String hdrEffDt) {
		this.hdrEffDt = hdrEffDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param blplRefYr
	 */
	public void setBlplRefYr(String blplRefYr) {
		this.blplRefYr = blplRefYr;
	}
	
	/**
	 * Column Info
	 * @param blplHdrSeq
	 */
	public void setBlplHdrSeq(String blplHdrSeq) {
		this.blplHdrSeq = blplHdrSeq;
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
		setBlplNm(JSPUtil.getParameter(request, "blpl_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHdrEffDt(JSPUtil.getParameter(request, "hdr_eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setBlplRefYr(JSPUtil.getParameter(request, "blpl_ref_yr", ""));
		setBlplHdrSeq(JSPUtil.getParameter(request, "blpl_hdr_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpBlplHeaderVO[]
	 */
	public RsltPriSpBlplHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpBlplHeaderVO[]
	 */
	public RsltPriSpBlplHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpBlplHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blplNm = (JSPUtil.getParameter(request, prefix	+ "blpl_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrEffDt = (JSPUtil.getParameter(request, prefix	+ "hdr_eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] blplRefYr = (JSPUtil.getParameter(request, prefix	+ "blpl_ref_yr", length));
			String[] blplHdrSeq = (JSPUtil.getParameter(request, prefix	+ "blpl_hdr_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpBlplHeaderVO();
				if (blplNm[i] != null)
					model.setBlplNm(blplNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrEffDt[i] != null)
					model.setHdrEffDt(hdrEffDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (blplRefYr[i] != null)
					model.setBlplRefYr(blplRefYr[i]);
				if (blplHdrSeq[i] != null)
					model.setBlplHdrSeq(blplHdrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpBlplHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpBlplHeaderVO[]
	 */
	public RsltPriSpBlplHeaderVO[] getRsltPriSpBlplHeaderVOs(){
		RsltPriSpBlplHeaderVO[] vos = (RsltPriSpBlplHeaderVO[])models.toArray(new RsltPriSpBlplHeaderVO[models.size()]);
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
		this.blplNm = this.blplNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrEffDt = this.hdrEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplRefYr = this.blplRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeq = this.blplHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
