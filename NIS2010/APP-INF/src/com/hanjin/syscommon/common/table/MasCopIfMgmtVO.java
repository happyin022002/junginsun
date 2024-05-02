/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasCopIfMgmtVO.java
*@FileTitle : MasCopIfMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
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
public class MasCopIfMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasCopIfMgmtVO> models = new ArrayList<MasCopIfMgmtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String costIfMnlRmk = null;
	/* Column Info */
	private String masMnlBatCd = null;
	/* Column Info */
	private String costIfRmk = null;
	/* Column Info */
	private String masBatSeq = null;
	/* Column Info */
	private String masDyBatDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String masMnlBatDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String masMnlBatSeq = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String masBatDt = null;
	/* Column Info */
	private String masDyBatCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costIfDyRmk = null;
	/* Column Info */
	private String masBatCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String masDyBatSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasCopIfMgmtVO() {}

	public MasCopIfMgmtVO(String ibflag, String pagerows, String bkgNo, String masBatCd, String masBatSeq, String masBatDt, String masDyBatCd, String masDyBatSeq, String masDyBatDt, String masMnlBatCd, String masMnlBatSeq, String masMnlBatDt, String costIfRmk, String costIfDyRmk, String costIfMnlRmk, String costWk, String costYrmon, String slsYrmon, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.costIfMnlRmk = costIfMnlRmk;
		this.masMnlBatCd = masMnlBatCd;
		this.costIfRmk = costIfRmk;
		this.masBatSeq = masBatSeq;
		this.masDyBatDt = masDyBatDt;
		this.creDt = creDt;
		this.masMnlBatDt = masMnlBatDt;
		this.pagerows = pagerows;
		this.masMnlBatSeq = masMnlBatSeq;
		this.slsYrmon = slsYrmon;
		this.masBatDt = masBatDt;
		this.masDyBatCd = masDyBatCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.costYrmon = costYrmon;
		this.costWk = costWk;
		this.costIfDyRmk = costIfDyRmk;
		this.masBatCd = masBatCd;
		this.updUsrId = updUsrId;
		this.masDyBatSeq = masDyBatSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cost_if_mnl_rmk", getCostIfMnlRmk());
		this.hashColumns.put("mas_mnl_bat_cd", getMasMnlBatCd());
		this.hashColumns.put("cost_if_rmk", getCostIfRmk());
		this.hashColumns.put("mas_bat_seq", getMasBatSeq());
		this.hashColumns.put("mas_dy_bat_dt", getMasDyBatDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mas_mnl_bat_dt", getMasMnlBatDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mas_mnl_bat_seq", getMasMnlBatSeq());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("mas_bat_dt", getMasBatDt());
		this.hashColumns.put("mas_dy_bat_cd", getMasDyBatCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_if_dy_rmk", getCostIfDyRmk());
		this.hashColumns.put("mas_bat_cd", getMasBatCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mas_dy_bat_seq", getMasDyBatSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_if_mnl_rmk", "costIfMnlRmk");
		this.hashFields.put("mas_mnl_bat_cd", "masMnlBatCd");
		this.hashFields.put("cost_if_rmk", "costIfRmk");
		this.hashFields.put("mas_bat_seq", "masBatSeq");
		this.hashFields.put("mas_dy_bat_dt", "masDyBatDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mas_mnl_bat_dt", "masMnlBatDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mas_mnl_bat_seq", "masMnlBatSeq");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("mas_bat_dt", "masBatDt");
		this.hashFields.put("mas_dy_bat_cd", "masDyBatCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_if_dy_rmk", "costIfDyRmk");
		this.hashFields.put("mas_bat_cd", "masBatCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mas_dy_bat_seq", "masDyBatSeq");
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
	 * @return costIfMnlRmk
	 */
	public String getCostIfMnlRmk() {
		return this.costIfMnlRmk;
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
	 * @return costIfRmk
	 */
	public String getCostIfRmk() {
		return this.costIfRmk;
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
	 * @return masDyBatDt
	 */
	public String getMasDyBatDt() {
		return this.masDyBatDt;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return masBatDt
	 */
	public String getMasBatDt() {
		return this.masBatDt;
	}
	
	/**
	 * Column Info
	 * @return masDyBatCd
	 */
	public String getMasDyBatCd() {
		return this.masDyBatCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return costIfDyRmk
	 */
	public String getCostIfDyRmk() {
		return this.costIfDyRmk;
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
	 * @return masDyBatSeq
	 */
	public String getMasDyBatSeq() {
		return this.masDyBatSeq;
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
	 * @param costIfMnlRmk
	 */
	public void setCostIfMnlRmk(String costIfMnlRmk) {
		this.costIfMnlRmk = costIfMnlRmk;
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
	 * @param costIfRmk
	 */
	public void setCostIfRmk(String costIfRmk) {
		this.costIfRmk = costIfRmk;
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
	 * @param masDyBatDt
	 */
	public void setMasDyBatDt(String masDyBatDt) {
		this.masDyBatDt = masDyBatDt;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param masBatDt
	 */
	public void setMasBatDt(String masBatDt) {
		this.masBatDt = masBatDt;
	}
	
	/**
	 * Column Info
	 * @param masDyBatCd
	 */
	public void setMasDyBatCd(String masDyBatCd) {
		this.masDyBatCd = masDyBatCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param costIfDyRmk
	 */
	public void setCostIfDyRmk(String costIfDyRmk) {
		this.costIfDyRmk = costIfDyRmk;
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
	 * Column Info
	 * @param masDyBatSeq
	 */
	public void setMasDyBatSeq(String masDyBatSeq) {
		this.masDyBatSeq = masDyBatSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCostIfMnlRmk(JSPUtil.getParameter(request, "cost_if_mnl_rmk", ""));
		setMasMnlBatCd(JSPUtil.getParameter(request, "mas_mnl_bat_cd", ""));
		setCostIfRmk(JSPUtil.getParameter(request, "cost_if_rmk", ""));
		setMasBatSeq(JSPUtil.getParameter(request, "mas_bat_seq", ""));
		setMasDyBatDt(JSPUtil.getParameter(request, "mas_dy_bat_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMasMnlBatDt(JSPUtil.getParameter(request, "mas_mnl_bat_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMasMnlBatSeq(JSPUtil.getParameter(request, "mas_mnl_bat_seq", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setMasBatDt(JSPUtil.getParameter(request, "mas_bat_dt", ""));
		setMasDyBatCd(JSPUtil.getParameter(request, "mas_dy_bat_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCostIfDyRmk(JSPUtil.getParameter(request, "cost_if_dy_rmk", ""));
		setMasBatCd(JSPUtil.getParameter(request, "mas_bat_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMasDyBatSeq(JSPUtil.getParameter(request, "mas_dy_bat_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasCopIfMgmtVO[]
	 */
	public MasCopIfMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasCopIfMgmtVO[]
	 */
	public MasCopIfMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasCopIfMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] costIfMnlRmk = (JSPUtil.getParameter(request, prefix	+ "cost_if_mnl_rmk", length));
			String[] masMnlBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_cd", length));
			String[] costIfRmk = (JSPUtil.getParameter(request, prefix	+ "cost_if_rmk", length));
			String[] masBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_bat_seq", length));
			String[] masDyBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_dy_bat_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] masMnlBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] masMnlBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_mnl_bat_seq", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] masBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_bat_dt", length));
			String[] masDyBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_dy_bat_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costIfDyRmk = (JSPUtil.getParameter(request, prefix	+ "cost_if_dy_rmk", length));
			String[] masBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_bat_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] masDyBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_dy_bat_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasCopIfMgmtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (costIfMnlRmk[i] != null)
					model.setCostIfMnlRmk(costIfMnlRmk[i]);
				if (masMnlBatCd[i] != null)
					model.setMasMnlBatCd(masMnlBatCd[i]);
				if (costIfRmk[i] != null)
					model.setCostIfRmk(costIfRmk[i]);
				if (masBatSeq[i] != null)
					model.setMasBatSeq(masBatSeq[i]);
				if (masDyBatDt[i] != null)
					model.setMasDyBatDt(masDyBatDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (masMnlBatDt[i] != null)
					model.setMasMnlBatDt(masMnlBatDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (masMnlBatSeq[i] != null)
					model.setMasMnlBatSeq(masMnlBatSeq[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (masBatDt[i] != null)
					model.setMasBatDt(masBatDt[i]);
				if (masDyBatCd[i] != null)
					model.setMasDyBatCd(masDyBatCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costIfDyRmk[i] != null)
					model.setCostIfDyRmk(costIfDyRmk[i]);
				if (masBatCd[i] != null)
					model.setMasBatCd(masBatCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (masDyBatSeq[i] != null)
					model.setMasDyBatSeq(masDyBatSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasCopIfMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasCopIfMgmtVO[]
	 */
	public MasCopIfMgmtVO[] getMasCopIfMgmtVOs(){
		MasCopIfMgmtVO[] vos = (MasCopIfMgmtVO[])models.toArray(new MasCopIfMgmtVO[models.size()]);
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
		this.costIfMnlRmk = this.costIfMnlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatCd = this.masMnlBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costIfRmk = this.costIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatSeq = this.masBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masDyBatDt = this.masDyBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatDt = this.masMnlBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masMnlBatSeq = this.masMnlBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatDt = this.masBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masDyBatCd = this.masDyBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costIfDyRmk = this.costIfDyRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatCd = this.masBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masDyBatSeq = this.masDyBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
