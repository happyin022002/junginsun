/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0111ConditionVO.java
*@FileTitle : EesEqr0111ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.05 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0111ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0111ConditionVO> models = new ArrayList<EesEqr0111ConditionVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String scnrflag = null;
	/* Column Info */
	private String scnrseq = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String etbewk = null;
	/* Column Info */
	private String scnryrwk = null;
	/* Column Info */
	private String cocd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info searchVesselSchedulePortInfo 에서 사용 */
	private String vslSlanCd02 = null;
	/* Column Info */
	private String etbeyr = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String skdUsdIndCd = null;
	/* Column Info */
	private String scnr2yrwk = null;
	/* Column Info */
	private String etbsyr = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String edittype = null;
	/* Column Info */
	private String etbswk = null;
	/* Column Info */
	private String scnr2seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0111ConditionVO() {}

	public EesEqr0111ConditionVO(String ibflag, String pagerows, String vvd, String scnrId, String vslCd, String skdVoyNo, String skdDirCd, String skdUsdIndCd, String vslSlanCd, String userId, String edittype, String scnryrwk, String scnrseq, String scnr2yrwk, String scnr2seq, String etbsyr, String etbswk, String etbeyr, String etbewk, String scnrflag, String cocd) {

		this.vslCd = vslCd;
		this.scnrflag = scnrflag;
		this.scnrseq = scnrseq;
		this.scnrId = scnrId;
		this.etbewk = etbewk;
		this.scnryrwk = scnryrwk;
		this.cocd = cocd;
		this.skdVoyNo = skdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.etbeyr = etbeyr;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.skdUsdIndCd = skdUsdIndCd;
		this.scnr2yrwk = scnr2yrwk;
		this.etbsyr = etbsyr;
		this.userId = userId;
		this.edittype = edittype;
		this.etbswk = etbswk;
		this.scnr2seq = scnr2seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("scnrflag", getScnrflag());
		this.hashColumns.put("scnrseq", getScnrseq());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("etbewk", getEtbewk());
		this.hashColumns.put("scnryrwk", getScnryrwk());
		this.hashColumns.put("cocd", getCocd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("etbeyr", getEtbeyr());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_usd_ind_cd", getSkdUsdIndCd());
		this.hashColumns.put("scnr2yrwk", getScnr2yrwk());
		this.hashColumns.put("etbsyr", getEtbsyr());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("edittype", getEdittype());
		this.hashColumns.put("etbswk", getEtbswk());
		this.hashColumns.put("scnr2seq", getScnr2seq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("scnrflag", "scnrflag");
		this.hashFields.put("scnrseq", "scnrseq");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("etbewk", "etbewk");
		this.hashFields.put("scnryrwk", "scnryrwk");
		this.hashFields.put("cocd", "cocd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("etbeyr", "etbeyr");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_usd_ind_cd", "skdUsdIndCd");
		this.hashFields.put("scnr2yrwk", "scnr2yrwk");
		this.hashFields.put("etbsyr", "etbsyr");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("edittype", "edittype");
		this.hashFields.put("etbswk", "etbswk");
		this.hashFields.put("scnr2seq", "scnr2seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return scnrflag
	 */
	public String getScnrflag() {
		return this.scnrflag;
	}
	
	/**
	 * Column Info
	 * @return scnrseq
	 */
	public String getScnrseq() {
		return this.scnrseq;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return etbewk
	 */
	public String getEtbewk() {
		return this.etbewk;
	}
	
	/**
	 * Column Info
	 * @return scnryrwk
	 */
	public String getScnryrwk() {
		return this.scnryrwk;
	}
	
	/**
	 * Column Info
	 * @return cocd
	 */
	public String getCocd() {
		return this.cocd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return etbeyr
	 */
	public String getEtbeyr() {
		return this.etbeyr;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return skdUsdIndCd
	 */
	public String getSkdUsdIndCd() {
		return this.skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @return scnr2yrwk
	 */
	public String getScnr2yrwk() {
		return this.scnr2yrwk;
	}
	
	/**
	 * Column Info
	 * @return etbsyr
	 */
	public String getEtbsyr() {
		return this.etbsyr;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return edittype
	 */
	public String getEdittype() {
		return this.edittype;
	}
	
	/**
	 * Column Info
	 * @return etbswk
	 */
	public String getEtbswk() {
		return this.etbswk;
	}
	
	/**
	 * Column Info
	 * @return scnr2seq
	 */
	public String getScnr2seq() {
		return this.scnr2seq;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param scnrflag
	 */
	public void setScnrflag(String scnrflag) {
		this.scnrflag = scnrflag;
	}
	
	/**
	 * Column Info
	 * @param scnrseq
	 */
	public void setScnrseq(String scnrseq) {
		this.scnrseq = scnrseq;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param etbewk
	 */
	public void setEtbewk(String etbewk) {
		this.etbewk = etbewk;
	}
	
	/**
	 * Column Info
	 * @param scnryrwk
	 */
	public void setScnryrwk(String scnryrwk) {
		this.scnryrwk = scnryrwk;
	}
	
	/**
	 * Column Info
	 * @param cocd
	 */
	public void setCocd(String cocd) {
		this.cocd = cocd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param etbeyr
	 */
	public void setEtbeyr(String etbeyr) {
		this.etbeyr = etbeyr;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param skdUsdIndCd
	 */
	public void setSkdUsdIndCd(String skdUsdIndCd) {
		this.skdUsdIndCd = skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @param scnr2yrwk
	 */
	public void setScnr2yrwk(String scnr2yrwk) {
		this.scnr2yrwk = scnr2yrwk;
	}
	
	/**
	 * Column Info
	 * @param etbsyr
	 */
	public void setEtbsyr(String etbsyr) {
		this.etbsyr = etbsyr;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param edittype
	 */
	public void setEdittype(String edittype) {
		this.edittype = edittype;
	}
	
	/**
	 * Column Info
	 * @param etbswk
	 */
	public void setEtbswk(String etbswk) {
		this.etbswk = etbswk;
	}
	
	/**
	 * Column Info
	 * @param scnr2seq
	 */
	public void setScnr2seq(String scnr2seq) {
		this.scnr2seq = scnr2seq;
	}
	
	
	
	public String getVslSlanCd02() {
		return vslSlanCd02;
	}

	public void setVslSlanCd02(String vslSlanCd02) {
		this.vslSlanCd02 = vslSlanCd02;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setScnrflag(JSPUtil.getParameter(request, "scnrFlag", ""));
		setScnrseq(JSPUtil.getParameter(request, "seq", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setEtbewk(JSPUtil.getParameter(request, "etbEWk", ""));
		setScnryrwk(JSPUtil.getParameter(request, "yyyyww", ""));
		setCocd(JSPUtil.getParameter(request, "coCd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vslSlanCd", ""));
		setVslSlanCd02(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setEtbeyr(JSPUtil.getParameter(request, "etbEYr", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSkdUsdIndCd(JSPUtil.getParameter(request, "skd_usd_ind_cd", ""));
		setScnr2yrwk(JSPUtil.getParameter(request, "yyyyww2", ""));
		setEtbsyr(JSPUtil.getParameter(request, "etbSYr", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setEdittype(JSPUtil.getParameter(request, "editType", ""));
		setEtbswk(JSPUtil.getParameter(request, "etbSWk", ""));
		setScnr2seq(JSPUtil.getParameter(request, "seq2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0111ConditionVO[]
	 */
	public EesEqr0111ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0111ConditionVO[]
	 */
	public EesEqr0111ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0111ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] scnrflag = (JSPUtil.getParameter(request, prefix	+ "scnrFlag", length));
			String[] scnrseq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] etbewk = (JSPUtil.getParameter(request, prefix	+ "etbEWk", length));
			String[] scnryrwk = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] cocd = (JSPUtil.getParameter(request, prefix	+ "coCd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] etbeyr = (JSPUtil.getParameter(request, prefix	+ "etbEYr", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] skdUsdIndCd = (JSPUtil.getParameter(request, prefix	+ "skd_usd_ind_cd", length));
			String[] scnr2yrwk = (JSPUtil.getParameter(request, prefix	+ "yyyyww2", length));
			String[] etbsyr = (JSPUtil.getParameter(request, prefix	+ "etbsyr", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] edittype = (JSPUtil.getParameter(request, prefix	+ "editType", length));
			String[] etbswk = (JSPUtil.getParameter(request, prefix	+ "etbSWk", length));
			String[] scnr2seq = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0111ConditionVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (scnrflag[i] != null)
					model.setScnrflag(scnrflag[i]);
				if (scnrseq[i] != null)
					model.setScnrseq(scnrseq[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (etbewk[i] != null)
					model.setEtbewk(etbewk[i]);
				if (scnryrwk[i] != null)
					model.setScnryrwk(scnryrwk[i]);
				if (cocd[i] != null)
					model.setCocd(cocd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (etbeyr[i] != null)
					model.setEtbeyr(etbeyr[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdUsdIndCd[i] != null)
					model.setSkdUsdIndCd(skdUsdIndCd[i]);
				if (scnr2yrwk[i] != null)
					model.setScnr2yrwk(scnr2yrwk[i]);
				if (etbsyr[i] != null)
					model.setEtbsyr(etbsyr[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (edittype[i] != null)
					model.setEdittype(edittype[i]);
				if (etbswk[i] != null)
					model.setEtbswk(etbswk[i]);
				if (scnr2seq[i] != null)
					model.setScnr2seq(scnr2seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0111ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0111ConditionVO[]
	 */
	public EesEqr0111ConditionVO[] getEesEqr0111ConditionVOs(){
		EesEqr0111ConditionVO[] vos = (EesEqr0111ConditionVO[])models.toArray(new EesEqr0111ConditionVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrflag = this.scnrflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrseq = this.scnrseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbewk = this.etbewk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnryrwk = this.scnryrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocd = this.cocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbeyr = this.etbeyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUsdIndCd = this.skdUsdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnr2yrwk = this.scnr2yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbsyr = this.etbsyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edittype = this.edittype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbswk = this.etbswk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnr2seq = this.scnr2seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
