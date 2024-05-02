/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfCodDvsFeeBoxBlVO.java
*@FileTitle : OpfCodDvsFeeBoxBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfCodDvsFeeBoxBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfCodDvsFeeBoxBlVO> models = new ArrayList<OpfCodDvsFeeBoxBlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dvsFeeTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dvsFeeAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private  String	 dvsFeeTpCdBoxBl   =  null;
	/*	Column Info	*/
	private  String	 dvsFeeAmtBoxBl   =  null;
	/*	Column Info	*/
	private  String	 dvsFeeAmtBoxBlXch   =  null;
	/*	Column Info	*/
	private  String	 dvsFeeAmtXch   =  null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpfCodDvsFeeBoxBlVO() {}

	public OpfCodDvsFeeBoxBlVO(String updDt,String contiCd,String creUsrId,String ibflag,String dvsFeeTpCd,String deltFlg,String creDt,String dvsFeeAmt,String updUsrId,String pagerows,String dvsFeeTpCdBoxBl,String dvsFeeAmtBoxBl,String dvsFeeAmtBoxBlXch,String dvsFeeAmtXch)	{
		this.updDt  = updDt ;
		this.contiCd  = contiCd ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.dvsFeeTpCd  = dvsFeeTpCd ;
		this.deltFlg  = deltFlg ;
		this.creDt  = creDt ;
		this.dvsFeeAmt  = dvsFeeAmt ;
		this.updUsrId  = updUsrId ;
		this.pagerows  = pagerows ;
		this.dvsFeeTpCdBoxBl  = dvsFeeTpCdBoxBl ;
		this.dvsFeeAmtBoxBl  = dvsFeeAmtBoxBl ;
		this.dvsFeeAmtBoxBlXch  = dvsFeeAmtBoxBlXch ;
		this.dvsFeeAmtXch  = dvsFeeAmtXch ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dvs_fee_tp_cd", getDvsFeeTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dvs_fee_amt", getDvsFeeAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dvs_fee_tp_cd_box_bl", getDvsFeeTpCdBoxBl());		
		this.hashColumns.put("dvs_fee_amt_box_bl", getDvsFeeAmtBoxBl());	
		this.hashColumns.put("dvs_fee_amt_box_bl_xch", getDvsFeeAmtBoxBlXch());		
		this.hashColumns.put("dvs_fee_amt_xch", getDvsFeeAmtXch());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dvs_fee_tp_cd", "dvsFeeTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dvs_fee_amt", "dvsFeeAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dvs_fee_tp_cd_box_bl", "dvsFeeTpCdBoxBl");
		this.hashFields.put("dvs_fee_amt_box_bl", "dvsFeeAmtBoxBl");
		this.hashFields.put("dvs_fee_amt_box_bl_xch", "dvsFeeAmtBoxBlXch");
		this.hashFields.put("dvs_fee_amt_xch", "dvsFeeAmtXch");
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
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return dvsFeeTpCd
	 */
	public String getDvsFeeTpCd() {
		return this.dvsFeeTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return dvsFeeAmt
	 */
	public String getDvsFeeAmt() {
		return this.dvsFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param dvsFeeTpCd
	 */
	public void setDvsFeeTpCd(String dvsFeeTpCd) {
		this.dvsFeeTpCd = dvsFeeTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param dvsFeeAmt
	 */
	public void setDvsFeeAmt(String dvsFeeAmt) {
		this.dvsFeeAmt = dvsFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	* @param  dvsFeeTpCdBoxBl
	*/
	public void	setDvsFeeTpCdBoxBl( String	dvsFeeTpCdBoxBl ) {
		this.dvsFeeTpCdBoxBl =	dvsFeeTpCdBoxBl;
	}
 
	/**
	 * Column Info
	 * @return	dvsFeeTpCdBoxBl
	 */
	 public	String	getDvsFeeTpCdBoxBl() {
		 return	this.dvsFeeTpCdBoxBl;
	 } 
 	/**
	* Column Info
	* @param  dvsFeeAmtBoxBl
	*/
	public void	setDvsFeeAmtBoxBl( String	dvsFeeAmtBoxBl ) {
		this.dvsFeeAmtBoxBl =	dvsFeeAmtBoxBl;
	}
	/**
	* Column Info
	* @param  dvsFeeAmtBoxBlXch
	*/
	public void	setDvsFeeAmtBoxBlXch( String	dvsFeeAmtBoxBlXch ) {
		this.dvsFeeAmtBoxBlXch =	dvsFeeAmtBoxBlXch;
	}
 
	/**
	 * Column Info
	 * @return	dvsFeeAmtBoxBlXch
	 */
	 public	String	getDvsFeeAmtBoxBlXch() {
		 return	this.dvsFeeAmtBoxBlXch;
	 } 
 	/**
	* Column Info
	* @param  dvsFeeAmtXch
	*/
	public void	setDvsFeeAmtXch( String	dvsFeeAmtXch ) {
		this.dvsFeeAmtXch =	dvsFeeAmtXch;
	}
 
	/**
	 * Column Info
	 * @return	dvsFeeAmtXch
	 */
	 public	String	getDvsFeeAmtXch() {
		 return	this.dvsFeeAmtXch;
	 } 
	
	/**
	 * Column Info
	 * @return	dvsFeeAmtBoxBl
	 */
	 public	String	getDvsFeeAmtBoxBl() {
		 return	this.dvsFeeAmtBoxBl;
	 } 
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDvsFeeTpCd(JSPUtil.getParameter(request, "dvs_fee_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDvsFeeAmt(JSPUtil.getParameter(request, "dvs_fee_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDvsFeeTpCdBoxBl(JSPUtil.getParameter(request,	"dvs_fee_tp_cd_box_bl", ""));
		setDvsFeeAmtBoxBl(JSPUtil.getParameter(request,	"dvs_fee_amt_box_bl", ""));
		setDvsFeeAmtBoxBlXch(JSPUtil.getParameter(request,	"dvs_fee_amt_box_bl_xch", ""));
		setDvsFeeAmtXch(JSPUtil.getParameter(request,	"dvs_fee_amt_xch", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfCodDvsFeeBoxBlVO[]
	 */
	public OpfCodDvsFeeBoxBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfCodDvsFeeBoxBlVO[]
	 */
	public OpfCodDvsFeeBoxBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfCodDvsFeeBoxBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dvsFeeTpCd = (JSPUtil.getParameter(request, prefix	+ "dvs_fee_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dvsFeeAmt = (JSPUtil.getParameter(request, prefix	+ "dvs_fee_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dvsFeeTpCdBoxBl =	(JSPUtil.getParameter(request, prefix +	"dvs_fee_tp_cd_box_bl".trim(),	length));
			String[] dvsFeeAmtBoxBl =	(JSPUtil.getParameter(request, prefix +	"dvs_fee_amt_box_bl".trim(),	length));
			String[] dvsFeeAmtBoxBlXch =	(JSPUtil.getParameter(request, prefix +	"dvs_fee_amt_box_bl_xch".trim(),	length));
			String[] dvsFeeAmtXch =	(JSPUtil.getParameter(request, prefix +	"dvs_fee_amt_xch".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfCodDvsFeeBoxBlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dvsFeeTpCd[i] != null)
					model.setDvsFeeTpCd(dvsFeeTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dvsFeeAmt[i] != null)
					model.setDvsFeeAmt(dvsFeeAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if ( dvsFeeTpCdBoxBl[i] !=	null)
					model.setDvsFeeTpCdBoxBl( dvsFeeTpCdBoxBl[i]);
				if ( dvsFeeAmtBoxBl[i] !=	null)
					model.setDvsFeeAmtBoxBl( dvsFeeAmtBoxBl[i]);
				if ( dvsFeeAmtBoxBlXch[i] !=	null)
					model.setDvsFeeAmtBoxBlXch( dvsFeeAmtBoxBlXch[i]);
				if ( dvsFeeAmtXch[i] !=	null)
					model.setDvsFeeAmtXch( dvsFeeAmtXch[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfCodDvsFeeBoxBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfCodDvsFeeBoxBlVO[]
	 */
	public OpfCodDvsFeeBoxBlVO[] getOpfCodDvsFeeBoxBlVOs(){
		OpfCodDvsFeeBoxBlVO[] vos = (OpfCodDvsFeeBoxBlVO[])models.toArray(new OpfCodDvsFeeBoxBlVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeTpCd = this.dvsFeeTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeAmt = this.dvsFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeTpCdBoxBl =	this.dvsFeeTpCdBoxBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeAmtBoxBl =	this.dvsFeeAmtBoxBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeAmtBoxBlXch =	this.dvsFeeAmtBoxBlXch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvsFeeAmtXch =	this.dvsFeeAmtXch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
