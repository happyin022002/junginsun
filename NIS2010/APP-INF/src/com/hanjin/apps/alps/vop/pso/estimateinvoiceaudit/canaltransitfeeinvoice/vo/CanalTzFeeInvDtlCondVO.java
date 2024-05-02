/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzFeeInvDtlCondVO.java
*@FileTitle : CanalTzFeeInvDtlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.19 김진일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeInvDtlCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeInvDtlCondVO> models = new ArrayList<CanalTzFeeInvDtlCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sysXprDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltXprDesc = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String calcAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeInvDtlCondVO() {}

	public CanalTzFeeInvDtlCondVO(String ibflag, String pagerows, String vvd, String ydCd, String callSeq, String revYrmon, String vndrSeq, String calcAmt, String dfltXprDesc, String sysXprDesc, String sts) {
		this.vvd = vvd;
		this.sysXprDesc = sysXprDesc;
		this.ibflag = ibflag;
		this.dfltXprDesc = dfltXprDesc;
		this.revYrmon = revYrmon;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.sts = sts;
		this.callSeq = callSeq;
		this.calcAmt = calcAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sys_xpr_desc", getSysXprDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_xpr_desc", getDfltXprDesc());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sys_xpr_desc", "sysXprDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_xpr_desc", "dfltXprDesc");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sysXprDesc
	 */
	public String getSysXprDesc() {
		return this.sysXprDesc;
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
	 * @return dfltXprDesc
	 */
	public String getDfltXprDesc() {
		return this.dfltXprDesc;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sysXprDesc
	 */
	public void setSysXprDesc(String sysXprDesc) {
		this.sysXprDesc = sysXprDesc;
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
	 * @param dfltXprDesc
	 */
	public void setDfltXprDesc(String dfltXprDesc) {
		this.dfltXprDesc = dfltXprDesc;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSysXprDesc(JSPUtil.getParameter(request, "sys_xpr_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDfltXprDesc(JSPUtil.getParameter(request, "dflt_xpr_desc", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setCallSeq(JSPUtil.getParameter(request, "call_seq", ""));
		setCalcAmt(JSPUtil.getParameter(request, "calc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeInvDtlCondVO[]
	 */
	public CanalTzFeeInvDtlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeInvDtlCondVO[]
	 */
	public CanalTzFeeInvDtlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeInvDtlCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sysXprDesc = (JSPUtil.getParameter(request, prefix	+ "sys_xpr_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_xpr_desc", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeInvDtlCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sysXprDesc[i] != null)
					model.setSysXprDesc(sysXprDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltXprDesc[i] != null)
					model.setDfltXprDesc(dfltXprDesc[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeInvDtlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeInvDtlCondVO[]
	 */
	public CanalTzFeeInvDtlCondVO[] getCanalTzFeeInvDtlCondVOs(){
		CanalTzFeeInvDtlCondVO[] vos = (CanalTzFeeInvDtlCondVO[])models.toArray(new CanalTzFeeInvDtlCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysXprDesc = this.sysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltXprDesc = this.dfltXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
