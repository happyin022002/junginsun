/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SysClearVO.java
*@FileTitle : SysClearVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.02 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SysClearVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SysClearVO> models = new ArrayList<SysClearVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String removeYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ifNo1 = null;
	/* Column Info */
	private String ifNo2 = null;
	/* Column Info */
	private String ifNo3 = null;
	/* Column Info */
	private String ifNo4 = null;
	/* Column Info */
	private String ifNo5 = null;
	/* Column Info */
	private String ifNo6 = null;
	/* Column Info */
	private List<SysClearIfNoVO> sysClearIfNoVO;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SysClearVO() {}

	public SysClearVO(String ibflag, String pagerows, String ofcCd, String blNo, String vvdCd, String custCd, String userId, String otsSmryCd, String revTpCd, String currCd, String chgAmt, String arIfNo, String removeYn, String updUsrId, String ifNo1, String ifNo2,String ifNo3, String ifNo4,String ifNo5,String ifNo6) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.custCd = custCd;
		this.userId = userId;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.otsSmryCd = otsSmryCd;
		this.revTpCd = revTpCd;
		this.currCd = currCd;
		this.chgAmt = chgAmt;
		this.arIfNo = arIfNo;
		this.removeYn = removeYn;
		this.updUsrId = updUsrId;
		this.ifNo1 = ifNo1;
		this.ifNo2 = ifNo2;
		this.ifNo3 = ifNo3;
		this.ifNo4 = ifNo4;
		this.ifNo5 = ifNo5;
		this.ifNo6 = ifNo6;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("remove_yn", getRemoveYn());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("if_no1", getIfNo1());
		this.hashColumns.put("if_no2", getIfNo2());
		this.hashColumns.put("if_no3", getIfNo3());
		this.hashColumns.put("if_no4", getIfNo4());
		this.hashColumns.put("if_no5", getIfNo5());
		this.hashColumns.put("if_no6", getIfNo6());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("remove_yn", "removeYn");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("if_no1", "ifNo1");
		this.hashFields.put("if_no2", "ifNo2");
		this.hashFields.put("if_no3", "ifNo3");
		this.hashFields.put("if_no4", "ifNo4");
		this.hashFields.put("if_no5", "ifNo5");
		this.hashFields.put("if_no6", "ifNo6");
		
		return this.hashFields;
	}
	
	
	
	/**
	 * @return the ifNo5
	 */
	public String getIfNo5() {
		return ifNo5;
	}

	/**
	 * @param ifNo5 the ifNo5 to set
	 */
	public void setIfNo5(String ifNo5) {
		this.ifNo5 = ifNo5;
	}

	/**
	 * @return the ifNo6
	 */
	public String getIfNo6() {
		return ifNo6;
	}

	/**
	 * @param ifNo6 the ifNo6 to set
	 */
	public void setIfNo6(String ifNo6) {
		this.ifNo6 = ifNo6;
	}

	/**
	 * @return the ifNo1
	 */
	public String getIfNo1() {
		return ifNo1;
	}

	/**
	 * @param ifNo1 the ifNo1 to set
	 */
	public void setIfNo1(String ifNo1) {
		this.ifNo1 = ifNo1;
	}

	/**
	 * @return the ifNo2
	 */
	public String getIfNo2() {
		return ifNo2;
	}

	/**
	 * @param ifNo2 the ifNo2 to set
	 */
	public void setIfNo2(String ifNo2) {
		this.ifNo2 = ifNo2;
	}

	/**
	 * @return the ifNo3
	 */
	public String getIfNo3() {
		return ifNo3;
	}

	/**
	 * @param ifNo3 the ifNo3 to set
	 */
	public void setIfNo3(String ifNo3) {
		this.ifNo3 = ifNo3;
	}

	/**
	 * @return the ifNo4
	 */
	public String getIfNo4() {
		return ifNo4;
	}

	/**
	 * @param ifNo4 the ifNo4 to set
	 */
	public void setIfNo4(String ifNo4) {
		this.ifNo4 = ifNo4;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	public String getRevTpCd() {
		return revTpCd;
	}

	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getChgAmt() {
		return chgAmt;
	}

	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}

	public String getArIfNo() {
		return arIfNo;
	}

	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	public String getRemoveYn() {
		return removeYn;
	}

	public void setRemoveYn(String removeYn) {
		this.removeYn = removeYn;
	}

	public List<SysClearIfNoVO> getSysClearIfNoVO() {
		return sysClearIfNoVO;
	}

	public void setSysClearIfNoVO(List<SysClearIfNoVO> sysClearIfNoVO) {
		this.sysClearIfNoVO = sysClearIfNoVO;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setRemoveYn(JSPUtil.getParameter(request, "remove_yn", ""));
		setIfNo1(JSPUtil.getParameter(request, "if_no1", ""));
		setIfNo2(JSPUtil.getParameter(request, "if_no2", ""));
		setIfNo3(JSPUtil.getParameter(request, "if_no3", ""));
		setIfNo4(JSPUtil.getParameter(request, "if_no4", ""));
		setIfNo5(JSPUtil.getParameter(request, "if_no5", ""));
		setIfNo6(JSPUtil.getParameter(request, "if_no6", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SysClearVO[]
	 */
	public SysClearVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SysClearVO[]
	 */
	public SysClearVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SysClearVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] removeYn = (JSPUtil.getParameter(request, prefix	+ "remove_yn", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ifNo1 = (JSPUtil.getParameter(request, prefix	+ "if_no1", length));
			String[] ifNo2 = (JSPUtil.getParameter(request, prefix	+ "if_no2", length));
			String[] ifNo3 = (JSPUtil.getParameter(request, prefix	+ "if_no3", length));
			String[] ifNo4 = (JSPUtil.getParameter(request, prefix	+ "if_no4", length));
			String[] ifNo5 = (JSPUtil.getParameter(request, prefix	+ "if_no5", length));
			String[] ifNo6 = (JSPUtil.getParameter(request, prefix	+ "if_no6", length));
			
			for (int i = 0; i < length; i++) {
				model = new SysClearVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (removeYn[i] != null)
					model.setRemoveYn(removeYn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ifNo1[i] != null)
					model.setIfNo1(ifNo1[i]);
				if (ifNo2[i] != null)
					model.setIfNo2(ifNo2[i]);
				if (ifNo3[i] != null)
					model.setIfNo3(ifNo3[i]);
				if (ifNo4[i] != null)
					model.setIfNo4(ifNo4[i]);
				if (ifNo5[i] != null)
					model.setIfNo5(ifNo5[i]);
				if (ifNo6[i] != null)
					model.setIfNo6(ifNo6[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSysClearVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SysClearVO[]
	 */
	public SysClearVO[] getSysClearVOs(){
		SysClearVO[] vos = (SysClearVO[])models.toArray(new SysClearVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.removeYn = this.removeYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo1 = this.ifNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo2 = this.ifNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo3 = this.ifNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo4 = this.ifNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo5 = this.ifNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo6 = this.ifNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
