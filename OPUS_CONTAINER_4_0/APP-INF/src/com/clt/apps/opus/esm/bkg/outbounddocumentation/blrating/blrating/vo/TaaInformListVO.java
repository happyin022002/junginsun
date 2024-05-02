/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaaInformListVO.java
*@FileTitle : TaaInformListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.07.06 김태경
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaaInformListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TaaInformListVO> models = new ArrayList<TaaInformListVO>();

	/* Column Info */
	private String nt = null;
	/* Column Info */
	private String commodityDescription = null;
	/* Column Info */
	private String qTy = null;
	/* Column Info */
	private String ntV = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String rd = null;
	/* Column Info */
	private String dCall = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String transMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtl = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pt = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TaaInformListVO() {}

	public TaaInformListVO(String ibflag, String pagerows, String pt, String commodityDescription, String por, String pol, String pod, String del, String dCall, String rd, String per, String cgoTp, String cur, String amount, String transMode, String qTy, String dtl, String ntV, String nt) {
		this.nt = nt;
		this.commodityDescription = commodityDescription;
		this.qTy = qTy;
		this.ntV = ntV;
		this.por = por;
		this.rd = rd;
		this.dCall = dCall;
		this.pagerows = pagerows;
		this.amount = amount;
		this.transMode = transMode;
		this.ibflag = ibflag;
		this.dtl = dtl;
		this.per = per;
		this.pol = pol;
		this.pt = pt;
		this.cgoTp = cgoTp;
		this.cur = cur;
		this.del = del;
		this.pod = pod;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nt", getNt());
		this.hashColumns.put("commodity_description", getCommodityDescription());
		this.hashColumns.put("q_ty", getQTy());
		this.hashColumns.put("nt_v", getNtV());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("rd", getRd());
		this.hashColumns.put("d_call", getDCall());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtl", getDtl());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pt", getPt());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nt", "nt");
		this.hashFields.put("commodity_description", "commodityDescription");
		this.hashFields.put("q_ty", "qTy");
		this.hashFields.put("nt_v", "ntV");
		this.hashFields.put("por", "por");
		this.hashFields.put("rd", "rd");
		this.hashFields.put("d_call", "dCall");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtl", "dtl");
		this.hashFields.put("per", "per");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pt", "pt");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return nt
	 */
	public String getNt() {
		return this.nt;
	}

	/**
	 * Column Info
	 * @return commodityDescription
	 */
	public String getCommodityDescription() {
		return this.commodityDescription;
	}

	/**
	 * Column Info
	 * @return qTy
	 */
	public String getQTy() {
		return this.qTy;
	}

	/**
	 * Column Info
	 * @return ntV
	 */
	public String getNtV() {
		return this.ntV;
	}

	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}

	/**
	 * Column Info
	 * @return rd
	 */
	public String getRd() {
		return this.rd;
	}

	/**
	 * Column Info
	 * @return dCall
	 */
	public String getDCall() {
		return this.dCall;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}

	/**
	 * Column Info
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return dtl
	 */
	public String getDtl() {
		return this.dtl;
	}

	/**
	 * Column Info
	 * @return per
	 */
	public String getPer() {
		return this.per;
	}

	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * @return pt
	 */
	public String getPt() {
		return this.pt;
	}

	/**
	 * Column Info
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}

	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}

	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}

	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}


	/**
	 * Column Info
	 * @param nt
	 */
	public void setNt(String nt) {
		this.nt = nt;
	}

	/**
	 * Column Info
	 * @param commodityDescription
	 */
	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	/**
	 * Column Info
	 * @param qTy
	 */
	public void setQTy(String qTy) {
		this.qTy = qTy;
	}

	/**
	 * Column Info
	 * @param ntV
	 */
	public void setNtV(String ntV) {
		this.ntV = ntV;
	}

	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}

	/**
	 * Column Info
	 * @param rd
	 */
	public void setRd(String rd) {
		this.rd = rd;
	}

	/**
	 * Column Info
	 * @param dCall
	 */
	public void setDCall(String dCall) {
		this.dCall = dCall;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * Column Info
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param dtl
	 */
	public void setDtl(String dtl) {
		this.dtl = dtl;
	}

	/**
	 * Column Info
	 * @param per
	 */
	public void setPer(String per) {
		this.per = per;
	}

	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * @param pt
	 */
	public void setPt(String pt) {
		this.pt = pt;
	}

	/**
	 * Column Info
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}

	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}

	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}

	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNt(JSPUtil.getParameter(request, "nt", ""));
		setCommodityDescription(JSPUtil.getParameter(request, "commodity_description", ""));
		setQTy(JSPUtil.getParameter(request, "q_ty", ""));
		setNtV(JSPUtil.getParameter(request, "nt_v", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setRd(JSPUtil.getParameter(request, "rd", ""));
		setDCall(JSPUtil.getParameter(request, "d_call", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setTransMode(JSPUtil.getParameter(request, "trans_mode", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDtl(JSPUtil.getParameter(request, "dtl", ""));
		setPer(JSPUtil.getParameter(request, "per", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPt(JSPUtil.getParameter(request, "pt", ""));
		setCgoTp(JSPUtil.getParameter(request, "cgo_tp", ""));
		setCur(JSPUtil.getParameter(request, "cur", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaaInformListVO[]
	 */
	public TaaInformListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TaaInformListVO[]
	 */
	public TaaInformListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaaInformListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] nt = (JSPUtil.getParameter(request, prefix	+ "nt", length));
			String[] commodityDescription = (JSPUtil.getParameter(request, prefix	+ "commodity_description", length));
			String[] qTy = (JSPUtil.getParameter(request, prefix	+ "q_ty", length));
			String[] ntV = (JSPUtil.getParameter(request, prefix	+ "nt_v", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] rd = (JSPUtil.getParameter(request, prefix	+ "rd", length));
			String[] dCall = (JSPUtil.getParameter(request, prefix	+ "d_call", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtl = (JSPUtil.getParameter(request, prefix	+ "dtl", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pt = (JSPUtil.getParameter(request, prefix	+ "pt", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix	+ "cgo_tp", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));

			for (int i = 0; i < length; i++) {
				model = new TaaInformListVO();
				if (nt[i] != null)
					model.setNt(nt[i]);
				if (commodityDescription[i] != null)
					model.setCommodityDescription(commodityDescription[i]);
				if (qTy[i] != null)
					model.setQTy(qTy[i]);
				if (ntV[i] != null)
					model.setNtV(ntV[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (rd[i] != null)
					model.setRd(rd[i]);
				if (dCall[i] != null)
					model.setDCall(dCall[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtl[i] != null)
					model.setDtl(dtl[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pt[i] != null)
					model.setPt(pt[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaaInformListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaaInformListVO[]
	 */
	public TaaInformListVO[] getTaaInformListVOs(){
		TaaInformListVO[] vos = (TaaInformListVO[])models.toArray(new TaaInformListVO[models.size()]);
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
		this.nt = this.nt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodityDescription = this.commodityDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qTy = this.qTy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntV = this.ntV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd = this.rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCall = this.dCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtl = this.dtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pt = this.pt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
