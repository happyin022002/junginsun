/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BalDiffAcctVO.java
*@FileTitle : BalDiffAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.08.25 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BalDiffAcctVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BalDiffAcctVO> models = new ArrayList<BalDiffAcctVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String amount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String psoBztpCd = null;
	/* Column Info */
	private String cnlTzBztpCd = null;
	/* Page Number */
	private String pagerows = null;

	/* [2009.08.25:jmh] 추가 */
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String yyyymm = null;
	
	private BalDiffAcctMstVO balDiffAcctMstVO = null;
	private BalDiffAcctMstVO[] balDiffAcctMstVOs = null;
	private List<BalDiffAcctMstVO> balDiffAcctMstVOlist = null;
	
	private BalDiffAcctDtlVO balDiffAcctDtlVO = null;
	private BalDiffAcctDtlVO[] balDiffAcctDtlVOVOs = null;
	private List<BalDiffAcctDtlVO> balDiffAcctDtlVOlist = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BalDiffAcctVO() {}

	public BalDiffAcctVO(String ibflag, String pagerows, String amount, String vvd, String ydCd, String revYrmon, String psoBztpCd, String vndrSeq, String cnlTzBztpCd, String yyyymm, String locCd) {
		this.vvd = vvd;
		this.amount = amount;
		this.yyyymm = yyyymm;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.revYrmon = revYrmon;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.psoBztpCd = psoBztpCd;
		this.cnlTzBztpCd = cnlTzBztpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("yyyymm", getYyyymm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pso_bztp_cd", getPsoBztpCd());
		this.hashColumns.put("cnl_tz_bztp_cd", getCnlTzBztpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("yyyymm", "yyyymm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pso_bztp_cd", "psoBztpCd");
		this.hashFields.put("cnl_tz_bztp_cd", "cnlTzBztpCd");
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return yyyymm
	 */
	public String getYyyymm() {
		return this.yyyymm;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return psoBztpCd
	 */
	public String getPsoBztpCd() {
		return this.psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @return cnlTzBztpCd
	 */
	public String getCnlTzBztpCd() {
		return this.cnlTzBztpCd;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param yyyymm
	 */
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param psoBztpCd
	 */
	public void setPsoBztpCd(String psoBztpCd) {
		this.psoBztpCd = psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @param cnlTzBztpCd
	 */
	public void setCnlTzBztpCd(String cnlTzBztpCd) {
		this.cnlTzBztpCd = cnlTzBztpCd;
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
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setYyyymm(JSPUtil.getParameter(request, "yyyymm", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPsoBztpCd(JSPUtil.getParameter(request, "pso_bztp_cd", ""));
		setCnlTzBztpCd(JSPUtil.getParameter(request, "cnl_tz_bztp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BalDiffAcctVO[]
	 */
	public BalDiffAcctVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BalDiffAcctVO[]
	 */
	public BalDiffAcctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BalDiffAcctVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] yyyymm = (JSPUtil.getParameter(request, prefix	+ "yyyymm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] psoBztpCd = (JSPUtil.getParameter(request, prefix	+ "pso_bztp_cd", length));
			String[] cnlTzBztpCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bztp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BalDiffAcctVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (yyyymm[i] != null)
					model.setYyyymm(yyyymm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (psoBztpCd[i] != null)
					model.setPsoBztpCd(psoBztpCd[i]);
				if (cnlTzBztpCd[i] != null)
					model.setCnlTzBztpCd(cnlTzBztpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBalDiffAcctVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BalDiffAcctVO[]
	 */
	public BalDiffAcctVO[] getBalDiffAcctVOs(){
		BalDiffAcctVO[] vos = (BalDiffAcctVO[])models.toArray(new BalDiffAcctVO[models.size()]);
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
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyymm = this.yyyymm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoBztpCd = this.psoBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBztpCd = this.cnlTzBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the balDiffAcctMstVO
	 */
	public BalDiffAcctMstVO getBalDiffAcctMstVO() {
		return balDiffAcctMstVO;
	}

	/**
	 * @param balDiffAcctMstVO the balDiffAcctMstVO to set
	 */
	public void setBalDiffAcctMstVO(BalDiffAcctMstVO balDiffAcctMstVO) {
		this.balDiffAcctMstVO = balDiffAcctMstVO;
	}

	/**
	 * @return the balDiffAcctMstVOs
	 */
	public BalDiffAcctMstVO[] getBalDiffAcctMstVOs() {
		return balDiffAcctMstVOs;
	}

	/**
	 * @param balDiffAcctMstVOs the balDiffAcctMstVOs to set
	 */
	public void setBalDiffAcctMstVOs(BalDiffAcctMstVO[] balDiffAcctMstVOs) {
		this.balDiffAcctMstVOs = balDiffAcctMstVOs;
	}

	/**
	 * @return the balDiffAcctMstVOlist
	 */
	public List<BalDiffAcctMstVO> getBalDiffAcctMstVOlist() {
		return balDiffAcctMstVOlist;
	}

	/**
	 * @param balDiffAcctMstVOlist the balDiffAcctMstVOlist to set
	 */
	public void setBalDiffAcctMstVOlist(List<BalDiffAcctMstVO> balDiffAcctMstVOlist) {
		this.balDiffAcctMstVOlist = balDiffAcctMstVOlist;
	}

	/**
	 * @return the balDiffAcctDtlVO
	 */
	public BalDiffAcctDtlVO getBalDiffAcctDtlVO() {
		return balDiffAcctDtlVO;
	}

	/**
	 * @param balDiffAcctDtlVO the balDiffAcctDtlVO to set
	 */
	public void setBalDiffAcctDtlVO(BalDiffAcctDtlVO balDiffAcctDtlVO) {
		this.balDiffAcctDtlVO = balDiffAcctDtlVO;
	}

	/**
	 * @return the balDiffAcctDtlVOVOs
	 */
	public BalDiffAcctDtlVO[] getBalDiffAcctDtlVOVOs() {
		return balDiffAcctDtlVOVOs;
	}

	/**
	 * @param balDiffAcctDtlVOVOs the balDiffAcctDtlVOVOs to set
	 */
	public void setBalDiffAcctDtlVOVOs(BalDiffAcctDtlVO[] balDiffAcctDtlVOVOs) {
		this.balDiffAcctDtlVOVOs = balDiffAcctDtlVOVOs;
	}

	/**
	 * @return the balDiffAcctDtlVOlist
	 */
	public List<BalDiffAcctDtlVO> getBalDiffAcctDtlVOlist() {
		return balDiffAcctDtlVOlist;
	}

	/**
	 * @param balDiffAcctDtlVOlist the balDiffAcctDtlVOlist to set
	 */
	public void setBalDiffAcctDtlVOlist(List<BalDiffAcctDtlVO> balDiffAcctDtlVOlist) {
		this.balDiffAcctDtlVOlist = balDiffAcctDtlVOlist;
	}
}
