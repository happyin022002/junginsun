/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSoVO.java
*@FileTitle : CntrSoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.31  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrSoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrSoVO> models = new ArrayList<CntrSoVO>();
	
	/* Column Info */
	private String reqCnt = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String issCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String woSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String woOfcCtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrSoVO() {}

	public CntrSoVO(String ibflag, String pagerows, String woOfcCtyCd, String woSeq, String cntrNo, String cntrTpszCd, String bndCd, String reqCnt, String issCnt, String podCd, String delCd, String stsCd, String deTermCd) {
		this.reqCnt = reqCnt;
		this.bndCd = bndCd;
		this.delCd = delCd;
		this.issCnt = issCnt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.stsCd = stsCd;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.woSeq = woSeq;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.woOfcCtyCd = woOfcCtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("req_cnt", getReqCnt());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("iss_cnt", getIssCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wo_seq", getWoSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wo_ofc_cty_cd", getWoOfcCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("req_cnt", "reqCnt");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("iss_cnt", "issCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wo_seq", "woSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wo_ofc_cty_cd", "woOfcCtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reqCnt
	 */
	public String getReqCnt() {
		return this.reqCnt;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return issCnt
	 */
	public String getIssCnt() {
		return this.issCnt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return woSeq
	 */
	public String getWoSeq() {
		return this.woSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return woOfcCtyCd
	 */
	public String getWoOfcCtyCd() {
		return this.woOfcCtyCd;
	}
	

	/**
	 * Column Info
	 * @param reqCnt
	 */
	public void setReqCnt(String reqCnt) {
		this.reqCnt = reqCnt;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param issCnt
	 */
	public void setIssCnt(String issCnt) {
		this.issCnt = issCnt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param woSeq
	 */
	public void setWoSeq(String woSeq) {
		this.woSeq = woSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param woOfcCtyCd
	 */
	public void setWoOfcCtyCd(String woOfcCtyCd) {
		this.woOfcCtyCd = woOfcCtyCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReqCnt(JSPUtil.getParameter(request, "req_cnt", ""));
		setBndCd(JSPUtil.getParameter(request, "bnd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setIssCnt(JSPUtil.getParameter(request, "iss_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWoSeq(JSPUtil.getParameter(request, "wo_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWoOfcCtyCd(JSPUtil.getParameter(request, "wo_ofc_cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrSoVO[]
	 */
	public CntrSoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrSoVO[]
	 */
	public CntrSoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrSoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reqCnt = (JSPUtil.getParameter(request, prefix	+ "req_cnt", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] issCnt = (JSPUtil.getParameter(request, prefix	+ "iss_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] woSeq = (JSPUtil.getParameter(request, prefix	+ "wo_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] woOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrSoVO();
				if (reqCnt[i] != null)
					model.setReqCnt(reqCnt[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (issCnt[i] != null)
					model.setIssCnt(issCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (woSeq[i] != null)
					model.setWoSeq(woSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (woOfcCtyCd[i] != null)
					model.setWoOfcCtyCd(woOfcCtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrSoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrSoVO[]
	 */
	public CntrSoVO[] getCntrSoVOs(){
		CntrSoVO[] vos = (CntrSoVO[])models.toArray(new CntrSoVO[models.size()]);
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
		this.reqCnt = this.reqCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCnt = this.issCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woSeq = this.woSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCtyCd = this.woOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
