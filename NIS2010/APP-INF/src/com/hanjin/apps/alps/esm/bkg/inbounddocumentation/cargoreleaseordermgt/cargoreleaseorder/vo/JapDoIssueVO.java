/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapDoIssueVO.java
*@FileTitle : JapDoIssueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.09.25 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDoRefVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapDoIssueVO extends AbstractValueObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3713374358489223620L;

	private Collection<JapDoIssueVO> models = new ArrayList<JapDoIssueVO>();
	
	private SignOnUserAccount acount = null;
	/* Column Info */
	private String focStatus = null;
	/* Column Info */
	private String oblCngFlg = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String oriOblRdemFlg = null;
	/* Column Info */
	private String aftOblRdemFlg = null;
	/* Column Info */
	private String lastRlseStsCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String newOblRdemKnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String oldOblRdemKnt = null;
	/* Column Info */
	private String focTp = null;	
	/* F.O.C가 'Y' 가 아닐경우 남기는 Remark */
	private String cgorRmk = null;

	/**
     * D/O Release Reference
     */
    private BkgDoRefVO refInfo = null;

    /**
     * B/L별 D/O의 STATUS
     */
    private DoRlseStsVO doRlseSts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapDoIssueVO() {}

	public JapDoIssueVO(String ibflag, String pagerows, String oriOblRdemFlg, String aftOblRdemFlg, String blNo, String focTp, String focStatus, String bkgNo, String cntrPrtFlg, String ofcCd, String userId, String rlseStsCd, String lastRlseStsCd, String oblCngFlg, String doCngEvntCd, String oldOblRdemKnt, String newOblRdemKnt,String cgorRmk) {
		this.focStatus = focStatus;
		this.oblCngFlg = oblCngFlg;
		this.cntrPrtFlg = cntrPrtFlg;
		this.oriOblRdemFlg = oriOblRdemFlg;
		this.aftOblRdemFlg = aftOblRdemFlg;
		this.lastRlseStsCd = lastRlseStsCd;
		this.blNo = blNo;
		this.newOblRdemKnt = newOblRdemKnt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.rlseStsCd = rlseStsCd;
		this.doCngEvntCd = doCngEvntCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.userId = userId;
		this.oldOblRdemKnt = oldOblRdemKnt;
		this.focTp = focTp;
		this.cgorRmk = cgorRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("foc_status", getFocStatus());
		this.hashColumns.put("obl_cng_flg", getOblCngFlg());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ori_obl_rdem_flg", getOriOblRdemFlg());
		this.hashColumns.put("aft_obl_rdem_flg", getAftOblRdemFlg());
		this.hashColumns.put("last_rlse_sts_cd", getLastRlseStsCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("new_obl_rdem_knt", getNewOblRdemKnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("old_obl_rdem_knt", getOldOblRdemKnt());
		this.hashColumns.put("foc_tp", getFocTp());
		this.hashColumns.put("cgor_rmk", getCgorRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("foc_status", "focStatus");
		this.hashFields.put("obl_cng_flg", "oblCngFlg");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ori_obl_rdem_flg", "oriOblRdemFlg");
		this.hashFields.put("aft_obl_rdem_flg", "aftOblRdemFlg");
		this.hashFields.put("last_rlse_sts_cd", "lastRlseStsCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("new_obl_rdem_knt", "newOblRdemKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("old_obl_rdem_knt", "oldOblRdemKnt");
		this.hashFields.put("foc_tp", "focTp");
		this.hashFields.put("cgor_rmk", "cgorRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return focStatus
	 */
	public String getFocStatus() {
		return this.focStatus;
	}
	
	/**
	 * Column Info
	 * @return oblCngFlg
	 */
	public String getOblCngFlg() {
		return this.oblCngFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return oriOblRdemFlg
	 */
	public String getOriOblRdemFlg() {
		return this.oriOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return aftOblRdemFlg
	 */
	public String getAftOblRdemFlg() {
		return this.aftOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return lastRlseStsCd
	 */
	public String getLastRlseStsCd() {
		return this.lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return newOblRdemKnt
	 */
	public String getNewOblRdemKnt() {
		return this.newOblRdemKnt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return oldOblRdemKnt
	 */
	public String getOldOblRdemKnt() {
		return this.oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return focTp
	 */
	public String getFocTp() {
		return this.focTp;
	}
	
	/**
	 * F.O.C 가 'Y'가 아닐경우 남기는 Remark
	 * @return cgor_rmk
	 */
	public String getCgorRmk() {
		return this.cgorRmk;
	}		
	
	/**
	 * Column Info
	 * @param focStatus
	 */
	public void setFocStatus(String focStatus) {
		this.focStatus = focStatus;
	}
	
	/**
	 * Column Info
	 * @param oblCngFlg
	 */
	public void setOblCngFlg(String oblCngFlg) {
		this.oblCngFlg = oblCngFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param oriOblRdemFlg
	 */
	public void setOriOblRdemFlg(String oriOblRdemFlg) {
		this.oriOblRdemFlg = oriOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param aftOblRdemFlg
	 */
	public void setAftOblRdemFlg(String aftOblRdemFlg) {
		this.aftOblRdemFlg = aftOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param lastRlseStsCd
	 */
	public void setLastRlseStsCd(String lastRlseStsCd) {
		this.lastRlseStsCd = lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param newOblRdemKnt
	 */
	public void setNewOblRdemKnt(String newOblRdemKnt) {
		this.newOblRdemKnt = newOblRdemKnt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param oldOblRdemKnt
	 */
	public void setOldOblRdemKnt(String oldOblRdemKnt) {
		this.oldOblRdemKnt = oldOblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param focTp
	 */
	public void setFocTp(String focTp) {
		this.focTp = focTp;
	}
	
	/**
	 * Column Info
	 * @param doNo
	 */
	public void setCgorRmk(String cgorRmk) {
		this.cgorRmk = cgorRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFocStatus(JSPUtil.getParameter(request, "foc_status", ""));
		setOblCngFlg(JSPUtil.getParameter(request, "obl_cng_flg", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setOriOblRdemFlg(JSPUtil.getParameter(request, "ori_obl_rdem_flg", ""));
		setAftOblRdemFlg(JSPUtil.getParameter(request, "aft_obl_rdem_flg", ""));
		setLastRlseStsCd(JSPUtil.getParameter(request, "last_rlse_sts_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setNewOblRdemKnt(JSPUtil.getParameter(request, "new_obl_rdem_knt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setOldOblRdemKnt(JSPUtil.getParameter(request, "old_obl_rdem_knt", ""));
		setFocTp(JSPUtil.getParameter(request, "foc_tp", ""));
		setCgorRmk(JSPUtil.getParameter(request, "cgor_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapDoIssueVO[]
	 */
	public JapDoIssueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapDoIssueVO[]
	 */
	public JapDoIssueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapDoIssueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] focStatus = (JSPUtil.getParameter(request, prefix	+ "foc_status", length));
			String[] oblCngFlg = (JSPUtil.getParameter(request, prefix	+ "obl_cng_flg", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] oriOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "ori_obl_rdem_flg", length));
			String[] aftOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "aft_obl_rdem_flg", length));
			String[] lastRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "last_rlse_sts_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] newOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "new_obl_rdem_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] oldOblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "old_obl_rdem_knt", length));
			String[] focTp = (JSPUtil.getParameter(request, prefix	+ "foc_tp", length));
			String[] cgorRmk = (JSPUtil.getParameter(request, prefix	+ "cgor_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapDoIssueVO();
				if (focStatus[i] != null)
					model.setFocStatus(focStatus[i]);
				if (oblCngFlg[i] != null)
					model.setOblCngFlg(oblCngFlg[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (oriOblRdemFlg[i] != null)
					model.setOriOblRdemFlg(oriOblRdemFlg[i]);
				if (aftOblRdemFlg[i] != null)
					model.setAftOblRdemFlg(aftOblRdemFlg[i]);
				if (lastRlseStsCd[i] != null)
					model.setLastRlseStsCd(lastRlseStsCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (newOblRdemKnt[i] != null)
					model.setNewOblRdemKnt(newOblRdemKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (oldOblRdemKnt[i] != null)
					model.setOldOblRdemKnt(oldOblRdemKnt[i]);
				if (focTp[i] != null)
					model.setFocTp(focTp[i]);
				if (cgorRmk[i] != null)
					model.setCgorRmk(cgorRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapDoIssueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapDoIssueVO[]
	 */
	public JapDoIssueVO[] getJapDoIssueVOs(){
		JapDoIssueVO[] vos = (JapDoIssueVO[])models.toArray(new JapDoIssueVO[models.size()]);
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
		this.focStatus = this.focStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCngFlg = this.oblCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriOblRdemFlg = this.oriOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftOblRdemFlg = this.aftOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastRlseStsCd = this.lastRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newOblRdemKnt = this.newOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOblRdemKnt = this.oldOblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.focTp = this.focTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorRmk = this.cgorRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @return the refInfo
	 */
	public BkgDoRefVO getRefInfo() {
		return refInfo;
	}

	/**
	 * @param refInfo the refInfo to set
	 */
	public void setRefInfo(BkgDoRefVO refInfo) {
		this.refInfo = refInfo;
	}

	/**
	 * @return the doRlseSts
	 */
	public DoRlseStsVO getDoRlseSts() {
		return doRlseSts;
	}

	/**
	 * @param doRlseSts the doRlseSts to set
	 */
	public void setDoRlseSts(DoRlseStsVO doRlseSts) {
		this.doRlseSts = doRlseSts;
	}
}
