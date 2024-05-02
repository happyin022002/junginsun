/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RowSearchEmptyMasterVO.java
*@FileTitle : RowSearchEmptyMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.25 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RowSearchEmptyMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RowSearchEmptyMasterVO> models = new ArrayList<RowSearchEmptyMasterVO>();
	
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String destLocType = null;
	/* Column Info */
	private String wrsMtyCmdtCd = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String inlndRoutJuncNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String inlndRoutInvBilPattCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String orgLocType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RowSearchEmptyMasterVO() {}

	public RowSearchEmptyMasterVO(String ibflag, String pagerows, String rn, String routOrgNodCd, String routDestNodCd, String orgLoc, String orgLocType, String destLoc, String destLocType, String routSeq, String prioSeq, String inlndRoutInvBilPattCd, String routPlnCd, String creUsrId, String creOfcCd, String creDt, String inlndRoutRmk, String railCrrTpCd, String inlndRoutJuncNm, String wrsMtyCmdtCd) {
		this.rn = rn;
		this.railCrrTpCd = railCrrTpCd;
		this.creDt = creDt;
		this.destLocType = destLocType;
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
		this.routOrgNodCd = routOrgNodCd;
		this.destLoc = destLoc;
		this.routPlnCd = routPlnCd;
		this.inlndRoutJuncNm = inlndRoutJuncNm;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.inlndRoutRmk = inlndRoutRmk;
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.routDestNodCd = routDestNodCd;
		this.prioSeq = prioSeq;
		this.orgLoc = orgLoc;
		this.orgLocType = orgLocType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dest_loc_type", getDestLocType());
		this.hashColumns.put("wrs_mty_cmdt_cd", getWrsMtyCmdtCd());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("inlnd_rout_junc_nm", getInlndRoutJuncNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("inlnd_rout_inv_bil_patt_cd", getInlndRoutInvBilPattCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("org_loc_type", getOrgLocType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rn", "rn");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dest_loc_type", "destLocType");
		this.hashFields.put("wrs_mty_cmdt_cd", "wrsMtyCmdtCd");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("inlnd_rout_junc_nm", "inlndRoutJuncNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("inlnd_rout_inv_bil_patt_cd", "inlndRoutInvBilPattCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("org_loc_type", "orgLocType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return railCrrTpCd
	 */
	public String getRailCrrTpCd() {
		return this.railCrrTpCd;
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
	 * @return destLocType
	 */
	public String getDestLocType() {
		return this.destLocType;
	}
	
	/**
	 * Column Info
	 * @return wrsMtyCmdtCd
	 */
	public String getWrsMtyCmdtCd() {
		return this.wrsMtyCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutJuncNm
	 */
	public String getInlndRoutJuncNm() {
		return this.inlndRoutJuncNm;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutInvBilPattCd
	 */
	public String getInlndRoutInvBilPattCd() {
		return this.inlndRoutInvBilPattCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
	}
	
	/**
	 * Column Info
	 * @return orgLocType
	 */
	public String getOrgLocType() {
		return this.orgLocType;
	}
	

	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param railCrrTpCd
	 */
	public void setRailCrrTpCd(String railCrrTpCd) {
		this.railCrrTpCd = railCrrTpCd;
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
	 * @param destLocType
	 */
	public void setDestLocType(String destLocType) {
		this.destLocType = destLocType;
	}
	
	/**
	 * Column Info
	 * @param wrsMtyCmdtCd
	 */
	public void setWrsMtyCmdtCd(String wrsMtyCmdtCd) {
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutJuncNm
	 */
	public void setInlndRoutJuncNm(String inlndRoutJuncNm) {
		this.inlndRoutJuncNm = inlndRoutJuncNm;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutInvBilPattCd
	 */
	public void setInlndRoutInvBilPattCd(String inlndRoutInvBilPattCd) {
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
	}
	
	/**
	 * Column Info
	 * @param orgLocType
	 */
	public void setOrgLocType(String orgLocType) {
		this.orgLocType = orgLocType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDestLocType(JSPUtil.getParameter(request, "dest_loc_type", ""));
		setWrsMtyCmdtCd(JSPUtil.getParameter(request, "wrs_mty_cmdt_cd", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setInlndRoutJuncNm(JSPUtil.getParameter(request, "inlnd_rout_junc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setInlndRoutInvBilPattCd(JSPUtil.getParameter(request, "inlnd_rout_inv_bil_patt_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setOrgLocType(JSPUtil.getParameter(request, "org_loc_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RowSearchEmptyMasterVO[]
	 */
	public RowSearchEmptyMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RowSearchEmptyMasterVO[]
	 */
	public RowSearchEmptyMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RowSearchEmptyMasterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_crr_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] destLocType = (JSPUtil.getParameter(request, prefix	+ "dest_loc_type", length));
			String[] wrsMtyCmdtCd = (JSPUtil.getParameter(request, prefix	+ "wrs_mty_cmdt_cd", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix	+ "rout_pln_cd", length));
			String[] inlndRoutJuncNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_junc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk", length));
			String[] inlndRoutInvBilPattCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_inv_bil_patt_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] orgLocType = (JSPUtil.getParameter(request, prefix	+ "org_loc_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new RowSearchEmptyMasterVO();
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (destLocType[i] != null)
					model.setDestLocType(destLocType[i]);
				if (wrsMtyCmdtCd[i] != null)
					model.setWrsMtyCmdtCd(wrsMtyCmdtCd[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (inlndRoutJuncNm[i] != null)
					model.setInlndRoutJuncNm(inlndRoutJuncNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (inlndRoutInvBilPattCd[i] != null)
					model.setInlndRoutInvBilPattCd(inlndRoutInvBilPattCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (orgLocType[i] != null)
					model.setOrgLocType(orgLocType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRowSearchEmptyMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RowSearchEmptyMasterVO[]
	 */
	public RowSearchEmptyMasterVO[] getRowSearchEmptyMasterVOs(){
		RowSearchEmptyMasterVO[] vos = (RowSearchEmptyMasterVO[])models.toArray(new RowSearchEmptyMasterVO[models.size()]);
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
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocType = this.destLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsMtyCmdtCd = this.wrsMtyCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutJuncNm = this.inlndRoutJuncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInvBilPattCd = this.inlndRoutInvBilPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocType = this.orgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
