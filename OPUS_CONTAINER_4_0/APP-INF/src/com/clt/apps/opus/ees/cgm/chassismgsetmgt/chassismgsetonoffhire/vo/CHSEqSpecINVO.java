/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEqSpecINVO.java
*@FileTitle : CHSEqSpecINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.07
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.07 박의수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 박의수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSEqSpecINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSEqSpecINVO> models = new ArrayList<CHSEqSpecINVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mgstFuelCapa = null;
	/* Column Info */
	private String chssTtlDimLen = null;
	/* Column Info */
	private String mgstVltgCapa = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String chssPayldWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssTtlDimHgt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String eqSpecNoIns = null;	
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chssTtlDimWdt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSEqSpecINVO() {}

	/**
	 * CHSEqSpecINVO
	 * @param ibflag
	 * @param pagerows
	 * @param eqSpecNo
	 * @param eqSpecNoIns
	 * @param eqKndCd
	 * @param eqTpszCd
	 * @param vndrSeq
	 * @param chssTareWgt
	 * @param chssPayldWgt
	 * @param chssTtlDimLen
	 * @param chssTtlDimWdt
	 * @param chssTtlDimHgt
	 * @param mgstVltgCapa
	 * @param mgstFuelCapa
	 * @param creUsrId
	 * @param creDt
	 * @param updUsrId
	 * @param updDt
	 */
	public CHSEqSpecINVO(String ibflag, String pagerows, String eqSpecNo, String eqSpecNoIns, String eqKndCd, String eqTpszCd, String vndrSeq, String chssTareWgt, String chssPayldWgt, String chssTtlDimLen, String chssTtlDimWdt, String chssTtlDimHgt, String mgstVltgCapa, String mgstFuelCapa, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.mgstFuelCapa = mgstFuelCapa;
		this.chssTtlDimLen = chssTtlDimLen;
		this.mgstVltgCapa = mgstVltgCapa;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.chssPayldWgt = chssPayldWgt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chssTtlDimHgt = chssTtlDimHgt;
		this.vndrSeq = vndrSeq;
		this.eqSpecNo = eqSpecNo;
		this.eqSpecNoIns = eqSpecNoIns;
		this.chssTareWgt = chssTareWgt;
		this.updUsrId = updUsrId;
		this.chssTtlDimWdt = chssTtlDimWdt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mgst_fuel_capa", getMgstFuelCapa());
		this.hashColumns.put("chss_ttl_dim_len", getChssTtlDimLen());
		this.hashColumns.put("mgst_vltg_capa", getMgstVltgCapa());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("chss_payld_wgt", getChssPayldWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_ttl_dim_hgt", getChssTtlDimHgt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("eq_spec_no_ins", getEqSpecNoIns());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chss_ttl_dim_wdt", getChssTtlDimWdt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mgst_fuel_capa", "mgstFuelCapa");
		this.hashFields.put("chss_ttl_dim_len", "chssTtlDimLen");
		this.hashFields.put("mgst_vltg_capa", "mgstVltgCapa");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("chss_payld_wgt", "chssPayldWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_ttl_dim_hgt", "chssTtlDimHgt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("eq_spec_no_ins", "eqSpecNoIns");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chss_ttl_dim_wdt", "chssTtlDimWdt");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mgstFuelCapa
	 */
	public String getMgstFuelCapa() {
		return this.mgstFuelCapa;
	}
	
	/**
	 * Column Info
	 * @return chssTtlDimLen
	 */
	public String getChssTtlDimLen() {
		return this.chssTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @return mgstVltgCapa
	 */
	public String getMgstVltgCapa() {
		return this.mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return chssPayldWgt
	 */
	public String getChssPayldWgt() {
		return this.chssPayldWgt;
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
	 * @return chssTtlDimHgt
	 */
	public String getChssTtlDimHgt() {
		return this.chssTtlDimHgt;
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
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
	}

	/**
	 * Column Info
	 * @return eqSpecNoIns
	 */
	public String getEqSpecNoIns() {
		return this.eqSpecNoIns;
	}
	
	/**
	 * Column Info
	 * @return chssTareWgt
	 */
	public String getChssTareWgt() {
		return this.chssTareWgt;
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
	 * @return chssTtlDimWdt
	 */
	public String getChssTtlDimWdt() {
		return this.chssTtlDimWdt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mgstFuelCapa
	 */
	public void setMgstFuelCapa(String mgstFuelCapa) {
		this.mgstFuelCapa = mgstFuelCapa;
	}
	
	/**
	 * Column Info
	 * @param chssTtlDimLen
	 */
	public void setChssTtlDimLen(String chssTtlDimLen) {
		this.chssTtlDimLen = chssTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @param mgstVltgCapa
	 */
	public void setMgstVltgCapa(String mgstVltgCapa) {
		this.mgstVltgCapa = mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param chssPayldWgt
	 */
	public void setChssPayldWgt(String chssPayldWgt) {
		this.chssPayldWgt = chssPayldWgt;
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
	 * @param chssTtlDimHgt
	 */
	public void setChssTtlDimHgt(String chssTtlDimHgt) {
		this.chssTtlDimHgt = chssTtlDimHgt;
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
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNoIns
	 */
	public void setEqSpecNoIns(String eqSpecNoIns) {
		this.eqSpecNoIns = eqSpecNoIns;
	}
	
	/**
	 * Column Info
	 * @param chssTareWgt
	 */
	public void setChssTareWgt(String chssTareWgt) {
		this.chssTareWgt = chssTareWgt;
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
	 * @param chssTtlDimWdt
	 */
	public void setChssTtlDimWdt(String chssTtlDimWdt) {
		this.chssTtlDimWdt = chssTtlDimWdt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMgstFuelCapa(JSPUtil.getParameter(request, "mgst_fuel_capa", ""));
		setChssTtlDimLen(JSPUtil.getParameter(request, "chss_ttl_dim_len", ""));
		setMgstVltgCapa(JSPUtil.getParameter(request, "mgst_vltg_capa", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setChssPayldWgt(JSPUtil.getParameter(request, "chss_payld_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChssTtlDimHgt(JSPUtil.getParameter(request, "chss_ttl_dim_hgt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setEqSpecNoIns(JSPUtil.getParameter(request, "eq_spec_no_ins", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChssTtlDimWdt(JSPUtil.getParameter(request, "chss_ttl_dim_wdt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEqSpecINVO[]
	 */
	public CHSEqSpecINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEqSpecINVO[]
	 */
	public CHSEqSpecINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSEqSpecINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] mgstFuelCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_fuel_capa".trim(), length));
			String[] chssTtlDimLen = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_len".trim(), length));
			String[] mgstVltgCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_vltg_capa".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd".trim(), length));
			String[] chssPayldWgt = (JSPUtil.getParameter(request, prefix	+ "chss_payld_wgt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] chssTtlDimHgt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_hgt".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no".trim(), length));
			String[] eqSpecNoIns = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no_ins".trim(), length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] chssTtlDimWdt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_wdt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSEqSpecINVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mgstFuelCapa[i] != null)
					model.setMgstFuelCapa(mgstFuelCapa[i]);
				if (chssTtlDimLen[i] != null)
					model.setChssTtlDimLen(chssTtlDimLen[i]);
				if (mgstVltgCapa[i] != null)
					model.setMgstVltgCapa(mgstVltgCapa[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (chssPayldWgt[i] != null)
					model.setChssPayldWgt(chssPayldWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssTtlDimHgt[i] != null)
					model.setChssTtlDimHgt(chssTtlDimHgt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (eqSpecNoIns[i] != null)
					model.setEqSpecNoIns(eqSpecNoIns[i]);				
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chssTtlDimWdt[i] != null)
					model.setChssTtlDimWdt(chssTtlDimWdt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEqSpecINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEqSpecINVO[]
	 */
	public CHSEqSpecINVO[] getCHSEqSpecINVOs(){
		CHSEqSpecINVO[] vos = (CHSEqSpecINVO[])models.toArray(new CHSEqSpecINVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstFuelCapa = this.mgstFuelCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimLen = this.chssTtlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstVltgCapa = this.mgstVltgCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPayldWgt = this.chssPayldWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimHgt = this.chssTtlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNoIns = this.eqSpecNoIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimWdt = this.chssTtlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
