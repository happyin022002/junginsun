/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BbSplitVO.java
*@FileTitle : BbSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.17 최영희
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BbSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BbSplitVO> models = new ArrayList<BbSplitVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BbSplitVO() {}

	public BbSplitVO(String ibflag, String pagerows, String bbCgoSeq, String cmdtNm, String dimLen, String dimWdt, String dimHgt, String cgoWgt) {
		this.ibflag = ibflag;
		this.dimWdt = dimWdt;
		this.dimLen = dimLen;
		this.bbCgoSeq = bbCgoSeq;
		this.dimHgt = dimHgt;
		this.cmdtNm = cmdtNm;
		this.cgoWgt = cgoWgt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cgo_wgt", "cgoWgt");
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
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}

	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}

	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}

	/**
	 * Column Info
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}

	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
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
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}

	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}

	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}

	/**
	 * Column Info
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
	}

	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}

	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
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
		setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, "bb_cgo_seq", ""));
		setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BbSplitVO[]
	 */
	public BbSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BbSplitVO[]
	 */
	public BbSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BbSplitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new BbSplitVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBbSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BbSplitVO[]
	 */
	public BbSplitVO[] getBbSplitVOs(){
		BbSplitVO[] vos = (BbSplitVO[])models.toArray(new BbSplitVO[models.size()]);
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
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
