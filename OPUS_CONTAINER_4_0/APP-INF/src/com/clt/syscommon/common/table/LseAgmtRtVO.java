/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseAgmtRtVO.java
*@FileTitle : LseAgmtRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.08 노정용 
* 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LseAgmtRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LseAgmtRtVO> models = new ArrayList<LseAgmtRtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndChgAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String n1stChgAmt = null;
	/* Column Info */
	private String cntrRntlChgTpCd = null;
	/* Column Info */
	private String agmtChgDys = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String genRmk = null;
	/* Column Info */
	private String agmtChgVal = null;
	/* Column Info */
	private String updUsrId = null;
	/*	Column Info	*/
	private  String	 eqLocTpCd   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LseAgmtRtVO() {}

	public LseAgmtRtVO(String updDt,String cntrSpecNo,String agmtSeq,String creDt,String n2ndChgAmt,String pagerows,String creUsrId,String ibflag,String locCd,String n1stChgAmt,String cntrRntlChgTpCd,String agmtChgDys,String agmtCtyCd,String cntrTpszCd,String genRmk,String agmtChgVal,String updUsrId,String eqLocTpCd)	{
		this.updDt  = updDt ;
		this.cntrSpecNo  = cntrSpecNo ;
		this.agmtSeq  = agmtSeq ;
		this.creDt  = creDt ;
		this.n2ndChgAmt  = n2ndChgAmt ;
		this.pagerows  = pagerows ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.locCd  = locCd ;
		this.n1stChgAmt  = n1stChgAmt ;
		this.cntrRntlChgTpCd  = cntrRntlChgTpCd ;
		this.agmtChgDys  = agmtChgDys ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.genRmk  = genRmk ;
		this.agmtChgVal  = agmtChgVal ;
		this.updUsrId  = updUsrId ;
		this.eqLocTpCd  = eqLocTpCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("n2nd_chg_amt", getN2ndChgAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("n1st_chg_amt", getN1stChgAmt());		
		this.hashColumns.put("cntr_rntl_chg_tp_cd", getCntrRntlChgTpCd());		
		this.hashColumns.put("agmt_chg_dys", getAgmtChgDys());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("gen_rmk", getGenRmk());		
		this.hashColumns.put("agmt_chg_val", getAgmtChgVal());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("eq_loc_tp_cd", getEqLocTpCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_chg_amt", "n2ndChgAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("n1st_chg_amt", "n1stChgAmt");
		this.hashFields.put("cntr_rntl_chg_tp_cd", "cntrRntlChgTpCd");
		this.hashFields.put("agmt_chg_dys", "agmtChgDys");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("gen_rmk", "genRmk");
		this.hashFields.put("agmt_chg_val", "agmtChgVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_loc_tp_cd", "eqLocTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndChgAmt
	 */
	public String getN2ndChgAmt() {
		return this.n2ndChgAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return n1stChgAmt
	 */
	public String getN1stChgAmt() {
		return this.n1stChgAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrRntlChgTpCd
	 */
	public String getCntrRntlChgTpCd() {
		return this.cntrRntlChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtChgDys
	 */
	public String getAgmtChgDys() {
		return this.agmtChgDys;
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
	 * @return agmtChgVal
	 */
	public String getAgmtChgVal() {
		return this.agmtChgVal;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndChgAmt
	 */
	public void setN2ndChgAmt(String n2ndChgAmt) {
		this.n2ndChgAmt = n2ndChgAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param n1stChgAmt
	 */
	public void setN1stChgAmt(String n1stChgAmt) {
		this.n1stChgAmt = n1stChgAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrRntlChgTpCd
	 */
	public void setCntrRntlChgTpCd(String cntrRntlChgTpCd) {
		this.cntrRntlChgTpCd = cntrRntlChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtChgDys
	 */
	public void setAgmtChgDys(String agmtChgDys) {
		this.agmtChgDys = agmtChgDys;
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
	 * @param agmtChgVal
	 */
	public void setAgmtChgVal(String agmtChgVal) {
		this.agmtChgVal = agmtChgVal;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	* Column Info
	* @param  eqLocTpCd
	*/
	public void	setEqLocTpCd( String	eqLocTpCd ) {
		this.eqLocTpCd =	eqLocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	eqLocTpCd
	 */
	 public	 String	getEqLocTpCd() {
		 return	this.eqLocTpCd;
	 } 
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN2ndChgAmt(JSPUtil.getParameter(request, "n2nd_chg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setN1stChgAmt(JSPUtil.getParameter(request, "n1st_chg_amt", ""));
		setCntrRntlChgTpCd(JSPUtil.getParameter(request, "cntr_rntl_chg_tp_cd", ""));
		setAgmtChgDys(JSPUtil.getParameter(request, "agmt_chg_dys", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setGenRmk(JSPUtil.getParameter(request, "gen_rmk", ""));
		setAgmtChgVal(JSPUtil.getParameter(request, "agmt_chg_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEqLocTpCd(JSPUtil.getParameter(request,	 "eq_loc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LseAgmtRtVO[]
	 */
	public LseAgmtRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LseAgmtRtVO[]
	 */
	public LseAgmtRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LseAgmtRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] n2ndChgAmt = (JSPUtil.getParameter(request, prefix	+ "n2nd_chg_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] n1stChgAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_chg_amt".trim(), length));
			String[] cntrRntlChgTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rntl_chg_tp_cd".trim(), length));
			String[] agmtChgDys = (JSPUtil.getParameter(request, prefix	+ "agmt_chg_dys".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] genRmk = (JSPUtil.getParameter(request, prefix	+ "gen_rmk".trim(), length));
			String[] agmtChgVal = (JSPUtil.getParameter(request, prefix	+ "agmt_chg_val".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] eqLocTpCd =	(JSPUtil.getParameter(request, prefix +	"eq_loc_tp_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new LseAgmtRtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndChgAmt[i] != null)
					model.setN2ndChgAmt(n2ndChgAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (n1stChgAmt[i] != null)
					model.setN1stChgAmt(n1stChgAmt[i]);
				if (cntrRntlChgTpCd[i] != null)
					model.setCntrRntlChgTpCd(cntrRntlChgTpCd[i]);
				if (agmtChgDys[i] != null)
					model.setAgmtChgDys(agmtChgDys[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (genRmk[i] != null)
					model.setGenRmk(genRmk[i]);
				if (agmtChgVal[i] != null)
					model.setAgmtChgVal(agmtChgVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if ( eqLocTpCd[i] !=	null)
					model.setEqLocTpCd( eqLocTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLseAgmtRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LseAgmtRtVO[]
	 */
	public LseAgmtRtVO[] getLseAgmtRtVOs(){
		LseAgmtRtVO[] vos = (LseAgmtRtVO[])models.toArray(new LseAgmtRtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndChgAmt = this.n2ndChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stChgAmt = this.n1stChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRntlChgTpCd = this.cntrRntlChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtChgDys = this.agmtChgDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genRmk = this.genRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtChgVal = this.agmtChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocTpCd =	this.eqLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
