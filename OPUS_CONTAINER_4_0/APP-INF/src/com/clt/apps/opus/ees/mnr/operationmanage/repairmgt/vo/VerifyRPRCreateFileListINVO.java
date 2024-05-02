/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VerifyRPRCreateFileListINVO.java
*@FileTitle : VerifyRPRCreateFileListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 손흥식
*@LastVersion : 1.0
* 2009.10.05 손흥식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손흥식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VerifyRPRCreateFileListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VerifyRPRCreateFileListINVO> models = new ArrayList<VerifyRPRCreateFileListINVO>();
	
	/* Column Info */
	private String inpMsg3 = null;
	/* Column Info */
	private String dmgFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VerifyRPRCreateFileListINVO() {}

	public VerifyRPRCreateFileListINVO(String ibflag, String pagerows, String dmgFlag, String vndrSeq, String tmpSeq, String eqType, String costOfcCd, String inpMsg3) {
		this.inpMsg3 = inpMsg3;
		this.dmgFlag = dmgFlag;
		this.ibflag = ibflag;
		this.costOfcCd = costOfcCd;
		this.vndrSeq = vndrSeq;
		this.tmpSeq = tmpSeq;
		this.eqType = eqType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_msg3", getInpMsg3());
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inp_msg3", "inpMsg3");
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inpMsg3
	 */
	public String getInpMsg3() {
		return this.inpMsg3;
	}
	
	/**
	 * Column Info
	 * @return dmgFlag
	 */
	public String getDmgFlag() {
		return this.dmgFlag;
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
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
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @param inpMsg3
	 */
	public void setInpMsg3(String inpMsg3) {
		this.inpMsg3 = inpMsg3;
	}
	
	/**
	 * Column Info
	 * @param dmgFlag
	 */
	public void setDmgFlag(String dmgFlag) {
		this.dmgFlag = dmgFlag;
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
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
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
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInpMsg3(JSPUtil.getParameter(request, "inp_msg3", ""));
		setDmgFlag(JSPUtil.getParameter(request, "dmg_flag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VerifyRPRCreateFileListINVO[]
	 */
	public VerifyRPRCreateFileListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VerifyRPRCreateFileListINVO[]
	 */
	public VerifyRPRCreateFileListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VerifyRPRCreateFileListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inpMsg3 = (JSPUtil.getParameter(request, prefix	+ "inp_msg3", length));
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VerifyRPRCreateFileListINVO();
				if (inpMsg3[i] != null)
					model.setInpMsg3(inpMsg3[i]);
				if (dmgFlag[i] != null)
					model.setDmgFlag(dmgFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVerifyRPRCreateFileListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VerifyRPRCreateFileListINVO[]
	 */
	public VerifyRPRCreateFileListINVO[] getVerifyRPRCreateFileListINVOs(){
		VerifyRPRCreateFileListINVO[] vos = (VerifyRPRCreateFileListINVO[])models.toArray(new VerifyRPRCreateFileListINVO[models.size()]);
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
		this.inpMsg3 = this.inpMsg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
