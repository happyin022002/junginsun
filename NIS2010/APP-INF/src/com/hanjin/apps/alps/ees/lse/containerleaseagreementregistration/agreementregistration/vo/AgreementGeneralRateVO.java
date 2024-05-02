/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementGeneralRateVO.java
*@FileTitle : AgreementGeneralRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.04 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementGeneralRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgreementGeneralRateVO> models = new ArrayList<AgreementGeneralRateVO>();
	
	/* Column Info */
	private String replValue = null;
	/* Column Info */
	private String purPrice = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String qty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String purPeriod = null;
	/* Column Info */
	private String gateIn = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String genRmk = null;
	/* Column Info */
	private String gateOut = null;
	/* Column Info */
	private String cntrSpecNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public AgreementGeneralRateVO() {}

	/**
	 * Constructor
	 */
	public AgreementGeneralRateVO(String ibflag, String pagerows, String agmtCtyCd, String agmtSeq, String locCd, String cntrTpszCd, String qty
			                    , String replValue, String purPrice, String purPeriod, String gateIn, String gateOut, String genRmk, String cntrSpecNo) {
		this.replValue = replValue;
		this.purPrice = purPrice;
		this.agmtSeq = agmtSeq;
		this.qty = qty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.purPeriod = purPeriod;
		this.gateIn = gateIn;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.genRmk = genRmk;
		this.gateOut = gateOut;
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repl_value", getReplValue());
		this.hashColumns.put("pur_price", getPurPrice());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pur_period", getPurPeriod());
		this.hashColumns.put("gate_in", getGateIn());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("gen_rmk", getGenRmk());
		this.hashColumns.put("gate_out", getGateOut());
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repl_value", "replValue");
		this.hashFields.put("pur_price", "purPrice");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pur_period", "purPeriod");
		this.hashFields.put("gate_in", "gateIn");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("gen_rmk", "genRmk");
		this.hashFields.put("gate_out", "gateOut");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return replValue
	 */
	public String getReplValue() {
		return this.replValue;
	}
	
	/**
	 * Column Info
	 * @return purPrice
	 */
	public String getPurPrice() {
		return this.purPrice;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return purPeriod
	 */
	public String getPurPeriod() {
		return this.purPeriod;
	}
	
	/**
	 * Column Info
	 * @return gateIn
	 */
	public String getGateIn() {
		return this.gateIn;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return genRmk
	 */
	public String getGenRmk() {
		return this.genRmk;
	}
	
	/**
	 * Column Info
	 * @return gateOut
	 */
	public String getGateOut() {
		return this.gateOut;
	}
	

	/**
	 * Column Info
	 * @param replValue
	 */
	public void setReplValue(String replValue) {
		this.replValue = replValue;
	}
	
	/**
	 * Column Info
	 * @param purPrice
	 */
	public void setPurPrice(String purPrice) {
		this.purPrice = purPrice;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param purPeriod
	 */
	public void setPurPeriod(String purPeriod) {
		this.purPeriod = purPeriod;
	}
	
	/**
	 * Column Info
	 * @param gateIn
	 */
	public void setGateIn(String gateIn) {
		this.gateIn = gateIn;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param genRmk
	 */
	public void setGenRmk(String genRmk) {
		this.genRmk = genRmk;
	}
	
	/**
	 * Column Info
	 * @param gateOut
	 */
	public void setGateOut(String gateOut) {
		this.gateOut = gateOut;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReplValue(JSPUtil.getParameter(request, "repl_value", ""));
		setPurPrice(JSPUtil.getParameter(request, "pur_price", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setPurPeriod(JSPUtil.getParameter(request, "pur_period", ""));
		setGateIn(JSPUtil.getParameter(request, "gate_in", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setGenRmk(JSPUtil.getParameter(request, "gen_rmk", ""));
		setGateOut(JSPUtil.getParameter(request, "gate_out", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementGeneralRateVO[]
	 */
	public AgreementGeneralRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementGeneralRateVO[]
	 */
	public AgreementGeneralRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementGeneralRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] replValue = (JSPUtil.getParameter(request, prefix	+ "repl_value".trim(), length));
			String[] purPrice = (JSPUtil.getParameter(request, prefix	+ "pur_price".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] purPeriod = (JSPUtil.getParameter(request, prefix	+ "pur_period".trim(), length));
			String[] gateIn = (JSPUtil.getParameter(request, prefix	+ "gate_in".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] genRmk = (JSPUtil.getParameter(request, prefix	+ "gen_rmk".trim(), length));
			String[] gateOut = (JSPUtil.getParameter(request, prefix	+ "gate_out".trim(), length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AgreementGeneralRateVO();
				if (replValue[i] != null)
					model.setReplValue(replValue[i]);
				if (purPrice[i] != null)
					model.setPurPrice(purPrice[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (purPeriod[i] != null)
					model.setPurPeriod(purPeriod[i]);
				if (gateIn[i] != null)
					model.setGateIn(gateIn[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (genRmk[i] != null)
					model.setGenRmk(genRmk[i]);
				if (gateOut[i] != null)
					model.setGateOut(gateOut[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementGeneralRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementGeneralRateVO[]
	 */
	public AgreementGeneralRateVO[] getAgreementGeneralRateVOs(){
		AgreementGeneralRateVO[] vos = (AgreementGeneralRateVO[])models.toArray(new AgreementGeneralRateVO[models.size()]);
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
		this.replValue = this.replValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purPrice = this.purPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purPeriod = this.purPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIn = this.gateIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genRmk = this.genRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateOut = this.gateOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}

	public String getCntrSpecNo() {
		return cntrSpecNo;
	}
}
