/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPriLocationViaListVO.java
*@FileTitle : InPriLocationViaListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.26 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPriLocationViaListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPriLocationViaListVO> models = new ArrayList<InPriLocationViaListVO>();
	
	/* Column Info */
	private String application = null;
	/* Column Info */
	private String percent = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String oriViaDefCd = null;
	/* Column Info */
	private String destTermCd = null;
	/* Column Info */
	private String oriTermCd = null;
	/* Column Info */
	private String cargo = null;
	/* Column Info */
	private String currency = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String matchingPnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destLocDefCd = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String oriLocDefCd = null;
	/* Column Info */
	private String destViaDefCd = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPriLocationViaListVO() {}

	public InPriLocationViaListVO(String ibflag, String pagerows, String seq, String application, String oriLocDefCd, String oriTermCd, String destLocDefCd, String oriViaDefCd, String destViaDefCd, String destTermCd, String qttnNo, String qttnVerNo, String genSpclRtTpCd, String cmdtHdrSeq, String matchingPnt, String per, String cargo, String currency, String amount, String percent, String creUsrId, String updUsrId) {
		this.application = application;
		this.percent = percent;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.oriViaDefCd = oriViaDefCd;
		this.destTermCd = destTermCd;
		this.oriTermCd = oriTermCd;
		this.cargo = cargo;
		this.currency = currency;
		this.pagerows = pagerows;
		this.amount = amount;
		this.creUsrId = creUsrId;
		this.matchingPnt = matchingPnt;
		this.ibflag = ibflag;
		this.destLocDefCd = destLocDefCd;
		this.per = per;
		this.oriLocDefCd = oriLocDefCd;
		this.destViaDefCd = destViaDefCd;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.seq = seq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("application", getApplication());
		this.hashColumns.put("percent", getPercent());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("ori_via_def_cd", getOriViaDefCd());
		this.hashColumns.put("dest_term_cd", getDestTermCd());
		this.hashColumns.put("ori_term_cd", getOriTermCd());
		this.hashColumns.put("cargo", getCargo());
		this.hashColumns.put("currency", getCurrency());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("matching_pnt", getMatchingPnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_loc_def_cd", getDestLocDefCd());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("ori_loc_def_cd", getOriLocDefCd());
		this.hashColumns.put("dest_via_def_cd", getDestViaDefCd());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("application", "application");
		this.hashFields.put("percent", "percent");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("ori_via_def_cd", "oriViaDefCd");
		this.hashFields.put("dest_term_cd", "destTermCd");
		this.hashFields.put("ori_term_cd", "oriTermCd");
		this.hashFields.put("cargo", "cargo");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("matching_pnt", "matchingPnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_loc_def_cd", "destLocDefCd");
		this.hashFields.put("per", "per");
		this.hashFields.put("ori_loc_def_cd", "oriLocDefCd");
		this.hashFields.put("dest_via_def_cd", "destViaDefCd");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return application
	 */
	public String getApplication() {
		return this.application;
	}
	
	/**
	 * Column Info
	 * @return percent
	 */
	public String getPercent() {
		return this.percent;
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
	 * @return oriViaDefCd
	 */
	public String getOriViaDefCd() {
		return this.oriViaDefCd;
	}
	
	/**
	 * Column Info
	 * @return destTermCd
	 */
	public String getDestTermCd() {
		return this.destTermCd;
	}
	
	/**
	 * Column Info
	 * @return oriTermCd
	 */
	public String getOriTermCd() {
		return this.oriTermCd;
	}
	
	/**
	 * Column Info
	 * @return cargo
	 */
	public String getCargo() {
		return this.cargo;
	}
	
	/**
	 * Column Info
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return matchingPnt
	 */
	public String getMatchingPnt() {
		return this.matchingPnt;
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
	 * @return destLocDefCd
	 */
	public String getDestLocDefCd() {
		return this.destLocDefCd;
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
	 * @return oriLocDefCd
	 */
	public String getOriLocDefCd() {
		return this.oriLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destViaDefCd
	 */
	public String getDestViaDefCd() {
		return this.destViaDefCd;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param application
	 */
	public void setApplication(String application) {
		this.application = application;
	}
	
	/**
	 * Column Info
	 * @param percent
	 */
	public void setPercent(String percent) {
		this.percent = percent;
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
	 * @param oriViaDefCd
	 */
	public void setOriViaDefCd(String oriViaDefCd) {
		this.oriViaDefCd = oriViaDefCd;
	}
	
	/**
	 * Column Info
	 * @param destTermCd
	 */
	public void setDestTermCd(String destTermCd) {
		this.destTermCd = destTermCd;
	}
	
	/**
	 * Column Info
	 * @param oriTermCd
	 */
	public void setOriTermCd(String oriTermCd) {
		this.oriTermCd = oriTermCd;
	}
	
	/**
	 * Column Info
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Column Info
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param matchingPnt
	 */
	public void setMatchingPnt(String matchingPnt) {
		this.matchingPnt = matchingPnt;
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
	 * @param destLocDefCd
	 */
	public void setDestLocDefCd(String destLocDefCd) {
		this.destLocDefCd = destLocDefCd;
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
	 * @param oriLocDefCd
	 */
	public void setOriLocDefCd(String oriLocDefCd) {
		this.oriLocDefCd = oriLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destViaDefCd
	 */
	public void setDestViaDefCd(String destViaDefCd) {
		this.destViaDefCd = destViaDefCd;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setApplication(JSPUtil.getParameter(request, "application", ""));
		setPercent(JSPUtil.getParameter(request, "percent", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setOriViaDefCd(JSPUtil.getParameter(request, "ori_via_def_cd", ""));
		setDestTermCd(JSPUtil.getParameter(request, "dest_term_cd", ""));
		setOriTermCd(JSPUtil.getParameter(request, "ori_term_cd", ""));
		setCargo(JSPUtil.getParameter(request, "cargo", ""));
		setCurrency(JSPUtil.getParameter(request, "currency", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMatchingPnt(JSPUtil.getParameter(request, "matching_pnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDestLocDefCd(JSPUtil.getParameter(request, "dest_loc_def_cd", ""));
		setPer(JSPUtil.getParameter(request, "per", ""));
		setOriLocDefCd(JSPUtil.getParameter(request, "ori_loc_def_cd", ""));
		setDestViaDefCd(JSPUtil.getParameter(request, "dest_via_def_cd", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPriLocationViaListVO[]
	 */
	public InPriLocationViaListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPriLocationViaListVO[]
	 */
	public InPriLocationViaListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPriLocationViaListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] application = (JSPUtil.getParameter(request, prefix	+ "application", length));
			String[] percent = (JSPUtil.getParameter(request, prefix	+ "percent", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] oriViaDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_via_def_cd", length));
			String[] destTermCd = (JSPUtil.getParameter(request, prefix	+ "dest_term_cd", length));
			String[] oriTermCd = (JSPUtil.getParameter(request, prefix	+ "ori_term_cd", length));
			String[] cargo = (JSPUtil.getParameter(request, prefix	+ "cargo", length));
			String[] currency = (JSPUtil.getParameter(request, prefix	+ "currency", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] matchingPnt = (JSPUtil.getParameter(request, prefix	+ "matching_pnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] destLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_def_cd", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] oriLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_loc_def_cd", length));
			String[] destViaDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_via_def_cd", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPriLocationViaListVO();
				if (application[i] != null)
					model.setApplication(application[i]);
				if (percent[i] != null)
					model.setPercent(percent[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (oriViaDefCd[i] != null)
					model.setOriViaDefCd(oriViaDefCd[i]);
				if (destTermCd[i] != null)
					model.setDestTermCd(destTermCd[i]);
				if (oriTermCd[i] != null)
					model.setOriTermCd(oriTermCd[i]);
				if (cargo[i] != null)
					model.setCargo(cargo[i]);
				if (currency[i] != null)
					model.setCurrency(currency[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (matchingPnt[i] != null)
					model.setMatchingPnt(matchingPnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destLocDefCd[i] != null)
					model.setDestLocDefCd(destLocDefCd[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (oriLocDefCd[i] != null)
					model.setOriLocDefCd(oriLocDefCd[i]);
				if (destViaDefCd[i] != null)
					model.setDestViaDefCd(destViaDefCd[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPriLocationViaListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPriLocationViaListVO[]
	 */
	public InPriLocationViaListVO[] getInPriLocationViaListVOs(){
		InPriLocationViaListVO[] vos = (InPriLocationViaListVO[])models.toArray(new InPriLocationViaListVO[models.size()]);
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
		this.application = this.application .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.percent = this.percent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriViaDefCd = this.oriViaDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTermCd = this.destTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriTermCd = this.oriTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargo = this.cargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency = this.currency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchingPnt = this.matchingPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocDefCd = this.destLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocDefCd = this.oriLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaDefCd = this.destViaDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
