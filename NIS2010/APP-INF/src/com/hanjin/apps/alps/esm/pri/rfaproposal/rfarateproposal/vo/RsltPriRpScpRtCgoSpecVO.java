/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRpScpRtCgoSpecVO.java
*@FileTitle : RsltPriRpScpRtCgoSpecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.07 김재연 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRpScpRtCgoSpecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRpScpRtCgoSpecVO> models = new ArrayList<RsltPriRpScpRtCgoSpecVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String actCgoWdt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cntrWdt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String cntrHgt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoSpecRmk = null;
	/* Column Info */
	private String actCgoLen = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String actCgoWgt = null;
	/* Column Info */
	private String actCgoHgt = null;
	/* Column Info */
	private String cntrLen = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRpScpRtCgoSpecVO() {}

	public RsltPriRpScpRtCgoSpecVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String ratUtCd, String cntrLen, String cntrWdt, String cntrHgt, String cntrWgt, String actCgoLen, String actCgoWdt, String actCgoHgt, String actCgoWgt, String cgoSpecRmk) {
		this.cntrWgt = cntrWgt;
		this.actCgoWdt = actCgoWdt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.cntrWdt = cntrWdt;
		this.ratUtCd = ratUtCd;
		this.cntrHgt = cntrHgt;
		this.rtSeq = rtSeq;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.cgoSpecRmk = cgoSpecRmk;
		this.actCgoLen = actCgoLen;
		this.propNo = propNo;
		this.actCgoWgt = actCgoWgt;
		this.actCgoHgt = actCgoHgt;
		this.cntrLen = cntrLen;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("act_cgo_wdt", getActCgoWdt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cntr_wdt", getCntrWdt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cntr_hgt", getCntrHgt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_spec_rmk", getCgoSpecRmk());
		this.hashColumns.put("act_cgo_len", getActCgoLen());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("act_cgo_wgt", getActCgoWgt());
		this.hashColumns.put("act_cgo_hgt", getActCgoHgt());
		this.hashColumns.put("cntr_len", getCntrLen());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("act_cgo_wdt", "actCgoWdt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cntr_wdt", "cntrWdt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cntr_hgt", "cntrHgt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_spec_rmk", "cgoSpecRmk");
		this.hashFields.put("act_cgo_len", "actCgoLen");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("act_cgo_wgt", "actCgoWgt");
		this.hashFields.put("act_cgo_hgt", "actCgoHgt");
		this.hashFields.put("cntr_len", "cntrLen");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return actCgoWdt
	 */
	public String getActCgoWdt() {
		return this.actCgoWdt;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWdt
	 */
	public String getCntrWdt() {
		return this.cntrWdt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHgt
	 */
	public String getCntrHgt() {
		return this.cntrHgt;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return cgoSpecRmk
	 */
	public String getCgoSpecRmk() {
		return this.cgoSpecRmk;
	}
	
	/**
	 * Column Info
	 * @return actCgoLen
	 */
	public String getActCgoLen() {
		return this.actCgoLen;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return actCgoWgt
	 */
	public String getActCgoWgt() {
		return this.actCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return actCgoHgt
	 */
	public String getActCgoHgt() {
		return this.actCgoHgt;
	}
	
	/**
	 * Column Info
	 * @return cntrLen
	 */
	public String getCntrLen() {
		return this.cntrLen;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param actCgoWdt
	 */
	public void setActCgoWdt(String actCgoWdt) {
		this.actCgoWdt = actCgoWdt;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWdt
	 */
	public void setCntrWdt(String cntrWdt) {
		this.cntrWdt = cntrWdt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHgt
	 */
	public void setCntrHgt(String cntrHgt) {
		this.cntrHgt = cntrHgt;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param cgoSpecRmk
	 */
	public void setCgoSpecRmk(String cgoSpecRmk) {
		this.cgoSpecRmk = cgoSpecRmk;
	}
	
	/**
	 * Column Info
	 * @param actCgoLen
	 */
	public void setActCgoLen(String actCgoLen) {
		this.actCgoLen = actCgoLen;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param actCgoWgt
	 */
	public void setActCgoWgt(String actCgoWgt) {
		this.actCgoWgt = actCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param actCgoHgt
	 */
	public void setActCgoHgt(String actCgoHgt) {
		this.actCgoHgt = actCgoHgt;
	}
	
	/**
	 * Column Info
	 * @param cntrLen
	 */
	public void setCntrLen(String cntrLen) {
		this.cntrLen = cntrLen;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setActCgoWdt(JSPUtil.getParameter(request, "act_cgo_wdt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCntrWdt(JSPUtil.getParameter(request, "cntr_wdt", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setCntrHgt(JSPUtil.getParameter(request, "cntr_hgt", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoSpecRmk(JSPUtil.getParameter(request, "cgo_spec_rmk", ""));
		setActCgoLen(JSPUtil.getParameter(request, "act_cgo_len", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setActCgoWgt(JSPUtil.getParameter(request, "act_cgo_wgt", ""));
		setActCgoHgt(JSPUtil.getParameter(request, "act_cgo_hgt", ""));
		setCntrLen(JSPUtil.getParameter(request, "cntr_len", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRpScpRtCgoSpecVO[]
	 */
	public RsltPriRpScpRtCgoSpecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRpScpRtCgoSpecVO[]
	 */
	public RsltPriRpScpRtCgoSpecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRpScpRtCgoSpecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] actCgoWdt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_wdt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cntrWdt = (JSPUtil.getParameter(request, prefix	+ "cntr_wdt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] cntrHgt = (JSPUtil.getParameter(request, prefix	+ "cntr_hgt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoSpecRmk = (JSPUtil.getParameter(request, prefix	+ "cgo_spec_rmk", length));
			String[] actCgoLen = (JSPUtil.getParameter(request, prefix	+ "act_cgo_len", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] actCgoWgt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_wgt", length));
			String[] actCgoHgt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_hgt", length));
			String[] cntrLen = (JSPUtil.getParameter(request, prefix	+ "cntr_len", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRpScpRtCgoSpecVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (actCgoWdt[i] != null)
					model.setActCgoWdt(actCgoWdt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cntrWdt[i] != null)
					model.setCntrWdt(cntrWdt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (cntrHgt[i] != null)
					model.setCntrHgt(cntrHgt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoSpecRmk[i] != null)
					model.setCgoSpecRmk(cgoSpecRmk[i]);
				if (actCgoLen[i] != null)
					model.setActCgoLen(actCgoLen[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (actCgoWgt[i] != null)
					model.setActCgoWgt(actCgoWgt[i]);
				if (actCgoHgt[i] != null)
					model.setActCgoHgt(actCgoHgt[i]);
				if (cntrLen[i] != null)
					model.setCntrLen(cntrLen[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRpScpRtCgoSpecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRpScpRtCgoSpecVO[]
	 */
	public RsltPriRpScpRtCgoSpecVO[] getRsltPriRpScpRtCgoSpecVOs(){
		RsltPriRpScpRtCgoSpecVO[] vos = (RsltPriRpScpRtCgoSpecVO[])models.toArray(new RsltPriRpScpRtCgoSpecVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoWdt = this.actCgoWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWdt = this.cntrWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHgt = this.cntrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSpecRmk = this.cgoSpecRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoLen = this.actCgoLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoWgt = this.actCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoHgt = this.actCgoHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLen = this.cntrLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
