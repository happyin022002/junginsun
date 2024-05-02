/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasBkgCostCalcVO.java
*@FileTitle : MasBkgCostCalcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
* History
* 2009-09-30 임옥영 COA 배치 수행시 필요한 컬럼 추가
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MasBkgCostCalcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasBkgCostCalcVO> models = new ArrayList<MasBkgCostCalcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String masMnlBatCd = null;
	/* Column Info */
	private String masBatSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String masBatRmk = null;
	/* Column Info */
	private String masMnlBatDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String masMnlBatSeq = null;
	/* Column Info */
	private String masBatDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String masMnlBatRmk = null;
	/* Column Info */
	private String masBatCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* 추가 Bookin Status Code */
	private String bkgStsCd = null;
	/* 추가 Start Product Catalogue Code */
	private String startPctlNo = null;
	/* 추가 End Product Catalogue Code */
	private String endPctlNo = null;
	/* 추가 기준년월 cost yrmonth */
	private String costYrmon = null;
	/* 추가 갯수 */
	private String cnt  =  null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasBkgCostCalcVO() {}

	public MasBkgCostCalcVO(String ibflag, String pagerows, String bkgNo, String masBatCd, String masBatSeq, String masBatDt, String masBatRmk, String masMnlBatCd, String masMnlBatSeq, String masMnlBatDt, String masMnlBatRmk, String creUsrId, String creDt, String updUsrId, String updDt, String bkgStsCd, String startPctlNo, String endPctlNo, String costYrmon, String cnt) {
		this.updDt = updDt;
		this.masMnlBatCd = masMnlBatCd;
		this.masBatSeq = masBatSeq;
		this.creDt = creDt;
		this.masBatRmk = masBatRmk;
		this.masMnlBatDt = masMnlBatDt;
		this.pagerows = pagerows;
		this.masMnlBatSeq = masMnlBatSeq;
		this.masBatDt = masBatDt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.masMnlBatRmk = masMnlBatRmk;
		this.masBatCd = masBatCd;
		this.updUsrId = updUsrId;
		//추가컬럼
		this.bkgStsCd = bkgStsCd;
		this.startPctlNo = startPctlNo;
		this.endPctlNo = endPctlNo;
		this.costYrmon = costYrmon;
		this.cnt = cnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mas_mnl_bat_cd", getMasMnlBatCd());
		this.hashColumns.put("mas_bat_seq", getMasBatSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mas_bat_rmk", getMasBatRmk());
		this.hashColumns.put("mas_mnl_bat_dt", getMasMnlBatDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mas_mnl_bat_seq", getMasMnlBatSeq());
		this.hashColumns.put("mas_bat_dt", getMasBatDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mas_mnl_bat_rmk", getMasMnlBatRmk());
		this.hashColumns.put("mas_bat_cd", getMasBatCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		//추가컬럼
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("start_pctl_no", getStartPctlNo());
		this.hashColumns.put("end_pctl_no", getEndPctlNo());
		this.hashColumns.put("cost_yrmon", getCostYrmon());		
		this.hashColumns.put("cnt", getCnt());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mas_mnl_bat_cd", "masMnlBatCd");
		this.hashFields.put("mas_bat_seq", "masBatSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mas_bat_rmk", "masBatRmk");
		this.hashFields.put("mas_mnl_bat_dt", "masMnlBatDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mas_mnl_bat_seq", "masMnlBatSeq");
		this.hashFields.put("mas_bat_dt", "masBatDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mas_mnl_bat_rmk", "masMnlBatRmk");
		this.hashFields.put("mas_bat_cd", "masBatCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		//추가컬럼
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("start_pctl_no", "startPctlNo");
		this.hashFields.put("end_pctl_no", "endPctlNo");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cnt", "cnt");

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
	 * @return masMnlBatCd
	 */
	public String getMasMnlBatCd() {
		return this.masMnlBatCd;
	}
	
	/**
	 * Column Info
	 * @return masBatSeq
	 */
	public String getMasBatSeq() {
		return this.masBatSeq;
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
	 * @return masBatRmk
	 */
	public String getMasBatRmk() {
		return this.masBatRmk;
	}
	
	/**
	 * Column Info
	 * @return masMnlBatDt
	 */
	public String getMasMnlBatDt() {
		return this.masMnlBatDt;
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
	 * @return masMnlBatSeq
	 */
	public String getMasMnlBatSeq() {
		return this.masMnlBatSeq;
	}
	
	/**
	 * Column Info
	 * @return masBatDt
	 */
	public String getMasBatDt() {
		return this.masBatDt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return masMnlBatRmk
	 */
	public String getMasMnlBatRmk() {
		return this.masMnlBatRmk;
	}
	
	/**
	 * Column Info
	 * @return masBatCd
	 */
	public String getMasBatCd() {
		return this.masBatCd;
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
	 * @param masMnlBatCd
	 */
	public void setMasMnlBatCd(String masMnlBatCd) {
		this.masMnlBatCd = masMnlBatCd;
	}
	
	/**
	 * Column Info
	 * @param masBatSeq
	 */
	public void setMasBatSeq(String masBatSeq) {
		this.masBatSeq = masBatSeq;
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
	 * @param masBatRmk
	 */
	public void setMasBatRmk(String masBatRmk) {
		this.masBatRmk = masBatRmk;
	}
	
	/**
	 * Column Info
	 * @param masMnlBatDt
	 */
	public void setMasMnlBatDt(String masMnlBatDt) {
		this.masMnlBatDt = masMnlBatDt;
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
	 * @param masMnlBatSeq
	 */
	public void setMasMnlBatSeq(String masMnlBatSeq) {
		this.masMnlBatSeq = masMnlBatSeq;
	}
	
	/**
	 * Column Info
	 * @param masBatDt
	 */
	public void setMasBatDt(String masBatDt) {
		this.masBatDt = masBatDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param masMnlBatRmk
	 */
	public void setMasMnlBatRmk(String masMnlBatRmk) {
		this.masMnlBatRmk = masMnlBatRmk;
	}
	
	/**
	 * Column Info
	 * @param masBatCd
	 */
	public void setMasBatCd(String masBatCd) {
		this.masBatCd = masBatCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
		
	/**
	 * @return the bkgStsCd
	 */
	public String getBkgStsCd() {
		return bkgStsCd;
	}

	/**
	 * @param bkgStsCd the bkgStsCd to set
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * @return the startPctlNo
	 */
	public String getStartPctlNo() {
		return startPctlNo;
	}

	/**
	 * @param startPctlNo the startPctlNo to set
	 */
	public void setStartPctlNo(String startPctlNo) {
		this.startPctlNo = startPctlNo;
	}

	/**
	 * @return the endPctlNo
	 */
	public String getEndPctlNo() {
		return endPctlNo;
	}

	/**
	 * @param endPctlNo the endPctlNo to set
	 */
	public void setEndPctlNo(String endPctlNo) {
		this.endPctlNo = endPctlNo;
	}

	/**
	 * @return the costYrmon
	 */
	public String getCostYrmon() {
		return costYrmon;
	}

	/**
	 * @param costYrmon the costYrmon to set
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * @param cnt the cnt to set
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMasMnlBatCd(JSPUtil.getParameter(request, "mas_mnl_bat_cd", ""));
		setMasBatSeq(JSPUtil.getParameter(request, "mas_bat_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMasBatRmk(JSPUtil.getParameter(request, "mas_bat_rmk", ""));
		setMasMnlBatDt(JSPUtil.getParameter(request, "mas_mnl_bat_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMasMnlBatSeq(JSPUtil.getParameter(request, "mas_mnl_bat_seq", ""));
		setMasBatDt(JSPUtil.getParameter(request, "mas_bat_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMasMnlBatRmk(JSPUtil.getParameter(request, "mas_mnl_bat_rmk", ""));
		setMasBatCd(JSPUtil.getParameter(request, "mas_bat_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		//추가컬럼
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setStartPctlNo(JSPUtil.getParameter(request, "start_pctl_no", ""));
		setEndPctlNo(JSPUtil.getParameter(request, "end_pctl_no", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasBkgCostCalcVO[]
	 */
	public MasBkgCostCalcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasBkgCostCalcVO[]
	 */
	public MasBkgCostCalcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasBkgCostCalcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] masMnlBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_cd", length));
			String[] masBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_bat_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] masBatRmk = (JSPUtil.getParameter(request, prefix	+ "mas_bat_rmk", length));
			String[] masMnlBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] masMnlBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_seq", length));
			String[] masBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_bat_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] masMnlBatRmk = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_rmk", length));
			String[] masBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_bat_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));		
			//추가컬럼
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] startPctlNo = (JSPUtil.getParameter(request, prefix	+ "start_pctl_no", length));
			String[] endPctlNo = (JSPUtil.getParameter(request, prefix	+ "end_pctl_no", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));

			for (int i = 0; i < length; i++) {
				model = new MasBkgCostCalcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (masMnlBatCd[i] != null)
					model.setMasMnlBatCd(masMnlBatCd[i]);
				if (masBatSeq[i] != null)
					model.setMasBatSeq(masBatSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (masBatRmk[i] != null)
					model.setMasBatRmk(masBatRmk[i]);
				if (masMnlBatDt[i] != null)
					model.setMasMnlBatDt(masMnlBatDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (masMnlBatSeq[i] != null)
					model.setMasMnlBatSeq(masMnlBatSeq[i]);
				if (masBatDt[i] != null)
					model.setMasBatDt(masBatDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (masMnlBatRmk[i] != null)
					model.setMasMnlBatRmk(masMnlBatRmk[i]);
				if (masBatCd[i] != null)
					model.setMasBatCd(masBatCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				//추가컬럼
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (startPctlNo[i] != null)
					model.setStartPctlNo(startPctlNo[i]);
				if (endPctlNo[i] != null)
					model.setEndPctlNo(endPctlNo[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasBkgCostCalcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasBkgCostCalcVO[]
	 */
	public MasBkgCostCalcVO[] getMasBkgCostCalcVOs(){
		MasBkgCostCalcVO[] vos = (MasBkgCostCalcVO[])models.toArray(new MasBkgCostCalcVO[models.size()]);
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
		this.masMnlBatCd = this.masMnlBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatSeq = this.masBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatRmk = this.masBatRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatDt = this.masMnlBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatSeq = this.masMnlBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatDt = this.masBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatRmk = this.masMnlBatRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatCd = this.masBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//추가컬럼
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startPctlNo = this.startPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPctlNo = this.endPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
