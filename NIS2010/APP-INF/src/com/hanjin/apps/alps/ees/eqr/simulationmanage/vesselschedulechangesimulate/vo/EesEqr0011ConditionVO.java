/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0011ConditionVO.java
*@FileTitle : EesEqr0011ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo;

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

public class EesEqr0011ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0011ConditionVO> models = new ArrayList<EesEqr0011ConditionVO>();
	
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String repoPlnId2 = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String etbSWk = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String runIdNo = null;
	/* Column Info */
	private String newscnrid = null;
	/* Column Info */
	private String etbEYr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etbSYr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String seq2 = null;
	/* Column Info */
	private String yyyyww2 = null;
	/* Column Info */
	private String etbEWk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0011ConditionVO() {}

	public EesEqr0011ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String etbsyr, String etbswk, String etbeyr, String etbewk, String cocd, String vslslancd, String vvd, String repoplnid2, String scnrId, String newscnrid, String yyyyww2, String seq2, String runIdNo) {
		this.vslSlanCd = vslslancd;
		this.repoPlnId2 = repoplnid2;
		this.scnrId = scnrId;
		this.etbEWk = etbewk;
		this.coCd = cocd;
		this.runIdNo = runIdNo;
		this.newscnrid = newscnrid;
		this.etbEYr = etbeyr;
		this.pagerows = pagerows;
		this.yyyyww = yyyyww;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.etbSYr = etbsyr;
		this.seq = seq;
		this.seq2 = seq2;
		this.yyyyww2 = yyyyww2;
		this.etbSWk = etbswk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vslSlanCd", getVslslancd());
		this.hashColumns.put("repoPlnId2", getRepoplnid2());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("etbEWk", getEtbewk());
		this.hashColumns.put("coCd", getCocd());
		this.hashColumns.put("run_id_no", getRunIdNo());
		this.hashColumns.put("newscnrid", getNewscnrid());
		this.hashColumns.put("etbeyr", getEtbeyr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etbsyr", getEtbsyr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("seq2", getSeq2());
		this.hashColumns.put("yyyyww2", getYyyyww2());
		this.hashColumns.put("etbswk", getEtbswk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vslslancd", "vslslancd");
		this.hashFields.put("repoplnid2", "repoplnid2");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("etbewk", "etbewk");
		this.hashFields.put("cocd", "cocd");
		this.hashFields.put("run_id_no", "runIdNo");
		this.hashFields.put("newscnrid", "newscnrid");
		this.hashFields.put("etbeyr", "etbeyr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etbsyr", "etbsyr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("seq2", "seq2");
		this.hashFields.put("yyyyww2", "yyyyww2");
		this.hashFields.put("etbswk", "etbswk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslslancd
	 */
	public String getVslslancd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return repoplnid2
	 */
	public String getRepoplnid2() {
		return this.repoPlnId2;
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
		return this.etbEWk;
	}
	
	/**
	 * Column Info
	 * @return cocd
	 */
	public String getCocd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return runIdNo
	 */
	public String getRunIdNo() {
		return this.runIdNo;
	}
	
	/**
	 * Column Info
	 * @return newscnrid
	 */
	public String getNewscnrid() {
		return this.newscnrid;
	}
	
	/**
	 * Column Info
	 * @return etbeyr
	 */
	public String getEtbeyr() {
		return this.etbEYr;
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
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return etbsyr
	 */
	public String getEtbsyr() {
		return this.etbSYr;
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
	 * @return seq2
	 */
	public String getSeq2() {
		return this.seq2;
	}
	
	/**
	 * Column Info
	 * @return yyyyww2
	 */
	public String getYyyyww2() {
		return this.yyyyww2;
	}
	
	/**
	 * Column Info
	 * @return etbswk
	 */
	public String getEtbswk() {
		return this.etbSWk;
	}
	

	/**
	 * Column Info
	 * @param vslslancd
	 */
	public void setVslslancd(String vslslancd) {
		this.vslSlanCd = vslslancd;
	}
	
	/**
	 * Column Info
	 * @param repoplnid2
	 */
	public void setRepoplnid2(String repoplnid2) {
		this.repoPlnId2 = repoplnid2;
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
		this.etbEWk = etbewk;
	}
	
	/**
	 * Column Info
	 * @param cocd
	 */
	public void setCocd(String cocd) {
		this.coCd = cocd;
	}
	
	/**
	 * Column Info
	 * @param runIdNo
	 */
	public void setRunIdNo(String runIdNo) {
		this.runIdNo = runIdNo;
	}
	
	/**
	 * Column Info
	 * @param newscnrid
	 */
	public void setNewscnrid(String newscnrid) {
		this.newscnrid = newscnrid;
	}
	
	/**
	 * Column Info
	 * @param etbeyr
	 */
	public void setEtbeyr(String etbeyr) {
		this.etbEYr = etbeyr;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param etbsyr
	 */
	public void setEtbsyr(String etbsyr) {
		this.etbSYr = etbsyr;
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
	 * @param seq2
	 */
	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}
	
	/**
	 * Column Info
	 * @param yyyyww2
	 */
	public void setYyyyww2(String yyyyww2) {
		this.yyyyww2 = yyyyww2;
	}
	
	/**
	 * Column Info
	 * @param etbswk
	 */
	public void setEtbswk(String etbswk) {
		this.etbSWk = etbswk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslslancd(JSPUtil.getParameter(request, "vslSlanCd", ""));
		setRepoplnid2(JSPUtil.getParameter(request, "repoPlnId2", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setEtbewk(JSPUtil.getParameter(request, "etbEWk", ""));
		setCocd(JSPUtil.getParameter(request, "coCd", ""));
		setRunIdNo(JSPUtil.getParameter(request, "run_id_no", ""));
		setNewscnrid(JSPUtil.getParameter(request, "newScnrId", ""));
		setEtbeyr(JSPUtil.getParameter(request, "etbEYr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtbsyr(JSPUtil.getParameter(request, "etbSYr", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setSeq2(JSPUtil.getParameter(request, "seq2", ""));
		setYyyyww2(JSPUtil.getParameter(request, "yyyyww2", ""));
		setEtbswk(JSPUtil.getParameter(request, "etbSWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0011ConditionVO[]
	 */
	public EesEqr0011ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0011ConditionVO[]
	 */
	public EesEqr0011ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0011ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslslancd = (JSPUtil.getParameter(request, prefix	+ "vslSlanCd", length));
			String[] repoplnid2 = (JSPUtil.getParameter(request, prefix	+ "repoPlnId2", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] etbewk = (JSPUtil.getParameter(request, prefix	+ "etbEWk", length));
			String[] cocd = (JSPUtil.getParameter(request, prefix	+ "coCd", length));
			String[] runIdNo = (JSPUtil.getParameter(request, prefix	+ "run_id_no", length));
			String[] newscnrid = (JSPUtil.getParameter(request, prefix	+ "newScnrId", length));
			String[] etbeyr = (JSPUtil.getParameter(request, prefix	+ "etbEYr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etbsyr = (JSPUtil.getParameter(request, prefix	+ "etbSYr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] seq2 = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			String[] yyyyww2 = (JSPUtil.getParameter(request, prefix	+ "yyyyww2", length));
			String[] etbswk = (JSPUtil.getParameter(request, prefix	+ "etbSWk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0011ConditionVO();
				if (vslslancd[i] != null)
					model.setVslslancd(vslslancd[i]);
				if (repoplnid2[i] != null)
					model.setRepoplnid2(repoplnid2[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (etbewk[i] != null)
					model.setEtbewk(etbewk[i]);
				if (cocd[i] != null)
					model.setCocd(cocd[i]);
				if (runIdNo[i] != null)
					model.setRunIdNo(runIdNo[i]);
				if (newscnrid[i] != null)
					model.setNewscnrid(newscnrid[i]);
				if (etbeyr[i] != null)
					model.setEtbeyr(etbeyr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etbsyr[i] != null)
					model.setEtbsyr(etbsyr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (seq2[i] != null)
					model.setSeq2(seq2[i]);
				if (yyyyww2[i] != null)
					model.setYyyyww2(yyyyww2[i]);
				if (etbswk[i] != null)
					model.setEtbswk(etbswk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0011ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0011ConditionVO[]
	 */
	public EesEqr0011ConditionVO[] getEesEqr0011ConditionVOs(){
		EesEqr0011ConditionVO[] vos = (EesEqr0011ConditionVO[])models.toArray(new EesEqr0011ConditionVO[models.size()]);
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
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId2 = this.repoPlnId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbEWk = this.etbEWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runIdNo = this.runIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newscnrid = this.newscnrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbEYr = this.etbEYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbSYr = this.etbSYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq2 = this.seq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww2 = this.yyyyww2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbSWk = this.etbSWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
