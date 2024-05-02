/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstPriRpScpRtCgoSpecVO.java
*@FileTitle : CstPriRpScpRtCgoSpecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.02 김재연 
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

public class CstPriRpScpRtCgoSpecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstPriRpScpRtCgoSpecVO> models = new ArrayList<CstPriRpScpRtCgoSpecVO>();
	
	/* Column Info */
	private String actCgoWdt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String actCgoLen = null;
	/* Column Info */
	private String cgoSpecRmk = null;
	/* Column Info */
	private String actCgoWgt = null;
	/* Column Info */
	private String unittype = null;
	/* Column Info */
	private String actCgoHgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstPriRpScpRtCgoSpecVO() {}

	public CstPriRpScpRtCgoSpecVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String actCgoLen, String actCgoWdt, String actCgoHgt, String actCgoWgt, String cgoSpecRmk, String unittype) {
		this.actCgoWdt = actCgoWdt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.rtSeq = rtSeq;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.actCgoLen = actCgoLen;
		this.cgoSpecRmk = cgoSpecRmk;
		this.actCgoWgt = actCgoWgt;
		this.unittype = unittype;
		this.actCgoHgt = actCgoHgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cgo_wdt", getActCgoWdt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("act_cgo_len", getActCgoLen());
		this.hashColumns.put("cgo_spec_rmk", getCgoSpecRmk());
		this.hashColumns.put("act_cgo_wgt", getActCgoWgt());
		this.hashColumns.put("unittype", getUnittype());
		this.hashColumns.put("act_cgo_hgt", getActCgoHgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cgo_wdt", "actCgoWdt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("act_cgo_len", "actCgoLen");
		this.hashFields.put("cgo_spec_rmk", "cgoSpecRmk");
		this.hashFields.put("act_cgo_wgt", "actCgoWgt");
		this.hashFields.put("unittype", "unittype");
		this.hashFields.put("act_cgo_hgt", "actCgoHgt");
		return this.hashFields;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @return cgoSpecRmk
	 */
	public String getCgoSpecRmk() {
		return this.cgoSpecRmk;
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
	 * @return unittype
	 */
	public String getUnittype() {
		return this.unittype;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
	 * @param cgoSpecRmk
	 */
	public void setCgoSpecRmk(String cgoSpecRmk) {
		this.cgoSpecRmk = cgoSpecRmk;
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
	 * @param unittype
	 */
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	
	/**
	 * Column Info
	 * @param actCgoHgt
	 */
	public void setActCgoHgt(String actCgoHgt) {
		this.actCgoHgt = actCgoHgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCgoWdt(JSPUtil.getParameter(request, "act_cgo_wdt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setActCgoLen(JSPUtil.getParameter(request, "act_cgo_len", ""));
		setCgoSpecRmk(JSPUtil.getParameter(request, "cgo_spec_rmk", ""));
		setActCgoWgt(JSPUtil.getParameter(request, "act_cgo_wgt", ""));
		setUnittype(JSPUtil.getParameter(request, "unittype", ""));
		setActCgoHgt(JSPUtil.getParameter(request, "act_cgo_hgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriRpScpRtCgoSpecVO[]
	 */
	public CstPriRpScpRtCgoSpecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstPriRpScpRtCgoSpecVO[]
	 */
	public CstPriRpScpRtCgoSpecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstPriRpScpRtCgoSpecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCgoWdt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_wdt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] actCgoLen = (JSPUtil.getParameter(request, prefix	+ "act_cgo_len", length));
			String[] cgoSpecRmk = (JSPUtil.getParameter(request, prefix	+ "cgo_spec_rmk", length));
			String[] actCgoWgt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_wgt", length));
			String[] unittype = (JSPUtil.getParameter(request, prefix	+ "unittype", length));
			String[] actCgoHgt = (JSPUtil.getParameter(request, prefix	+ "act_cgo_hgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstPriRpScpRtCgoSpecVO();
				if (actCgoWdt[i] != null)
					model.setActCgoWdt(actCgoWdt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (actCgoLen[i] != null)
					model.setActCgoLen(actCgoLen[i]);
				if (cgoSpecRmk[i] != null)
					model.setCgoSpecRmk(cgoSpecRmk[i]);
				if (actCgoWgt[i] != null)
					model.setActCgoWgt(actCgoWgt[i]);
				if (unittype[i] != null)
					model.setUnittype(unittype[i]);
				if (actCgoHgt[i] != null)
					model.setActCgoHgt(actCgoHgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstPriRpScpRtCgoSpecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstPriRpScpRtCgoSpecVO[]
	 */
	public CstPriRpScpRtCgoSpecVO[] getCstPriRpScpRtCgoSpecVOs(){
		CstPriRpScpRtCgoSpecVO[] vos = (CstPriRpScpRtCgoSpecVO[])models.toArray(new CstPriRpScpRtCgoSpecVO[models.size()]);
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
		this.actCgoWdt = this.actCgoWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoLen = this.actCgoLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSpecRmk = this.cgoSpecRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoWgt = this.actCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unittype = this.unittype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCgoHgt = this.actCgoHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
