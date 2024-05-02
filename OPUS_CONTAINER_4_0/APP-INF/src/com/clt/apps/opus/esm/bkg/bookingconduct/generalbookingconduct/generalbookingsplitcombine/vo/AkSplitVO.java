/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AkSplitVO.java
*@FileTitle : AkSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AkSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AkSplitVO> models = new ArrayList<AkSplitVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AkSplitVO() {}

	public AkSplitVO(String ibflag, String pagerows, String awkCgoSeq, String cntrNo, String cmdtNm, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String grsWgt) {
		this.ibflag = ibflag;
		this.ttlDimWdt = ttlDimWdt;
		this.cntrNo = cntrNo;
		this.ttlDimLen = ttlDimLen;
		this.awkCgoSeq = awkCgoSeq;
		this.ttlDimHgt = ttlDimHgt;
		this.grsWgt = grsWgt;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
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
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
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
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTtlDimWdt(JSPUtil.getParameter(request, "ttl_dim_wdt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTtlDimLen(JSPUtil.getParameter(request, "ttl_dim_len", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, "ttl_dim_hgt", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AkSplitVO[]
	 */
	public AkSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AkSplitVO[]
	 */
	public AkSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AkSplitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AkSplitVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAkSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AkSplitVO[]
	 */
	public AkSplitVO[] getAkSplitVOs(){
		AkSplitVO[] vos = (AkSplitVO[])models.toArray(new AkSplitVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
