/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COABatchParameterVO.java
*@FileTitle : COABatchParameterVO, COA배치 수행에 필요한 Parameter 모음
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
* ------------------------------------------------------------------------------------------------
* 2013.01.16 성미영 [CHM-201322341] [CHM-201322341] [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
*                                  aoc_bat_seq 를 추가
=========================================================*/

package com.hanjin.apps.alps.esm.coa.common.vo;

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
public class CoaBatchParameterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaBatchParameterVO> models = new ArrayList<CoaBatchParameterVO>();
	
	/*
	errMsg
	bkg_no
	start_pctl_no
	end_pctl_no
	cost_yrmon
	user_id
	aoc_bat_seq
	del_para
	outparam varchar
	outparam number
	*/	
	/* Booking Number */
	private String bkgNo = null;
	/* Start Product Catalogue Code */
	private String startPctlNo = null;
	/* End Product Catalogue Code */
	private String endPctlNo = null;
	/* 기준년월 cost yrmonth */
	private String costYrmon = null;	
	/* Create OR Update OR Execute User ID */
	private String usrId = null;
	/* aocBatSeq */
	private String aocBatSeq = null;
	/* Delete Parameter */
	private String delPara = null;
	/* OutParameter  OracleTypes.VARCHAR*/
	private String outParaVarchar = null;
	/* OutParameter  OracleTypes.NUMBER*/
	private String outParaNumber = null; 

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoaBatchParameterVO() {}

	/**
	 * @param bkgNo
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param costYrmon
	 * @param usrId
	 * @param delPara
	 * @param outParaVarchar
	 * @param outParaNumber
	 */
	public CoaBatchParameterVO(String bkgNo, String startPctlNo,
			String endPctlNo, String costYrmon, String usrId, String delPara,
			String outParaVarchar, String outParaNumber) {
		this.bkgNo = bkgNo;
		this.startPctlNo = startPctlNo;
		this.endPctlNo = endPctlNo;
		this.costYrmon = costYrmon;
		this.usrId = usrId;
		this.delPara = delPara;
		this.outParaVarchar = outParaVarchar;
		this.outParaNumber = outParaNumber;
	}
	
	/**
	 * @param bkgNo
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param costYrmon
	 * @param usrId
	 * @param aocBatSeq 
	 * @param delPara
	 * @param outParaVarchar
	 * @param outParaNumber
	 */
	public CoaBatchParameterVO(String bkgNo, String startPctlNo,
			String endPctlNo, String costYrmon, String usrId, String aocBatSeq, String delPara,
			String outParaVarchar, String outParaNumber) {
		this.bkgNo = bkgNo;
		this.startPctlNo = startPctlNo;
		this.endPctlNo = endPctlNo;
		this.costYrmon = costYrmon;
		this.usrId = usrId;
		this.aocBatSeq = aocBatSeq;		
		this.delPara = delPara;
		this.outParaVarchar = outParaVarchar;
		this.outParaNumber = outParaNumber;
	}	
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){		
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("start_pctl_no", getStartPctlNo());
		this.hashColumns.put("end_pctl_no", getEndPctlNo());
		this.hashColumns.put("cost_yrmon", getCostYrmon());				
		this.hashColumns.put("del_para", getDelPara());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("aoc_bat_seq", getAocBatSeq());		
		this.hashColumns.put("out_para_varchar", getOutParaVarchar());
		this.hashColumns.put("out_para_number", getOutParaNumber());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("start_pctl_no", "startPctlNo");
		this.hashFields.put("end_pctl_no", "endPctlNo");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("del_para", "delPara");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("aoc_bat_seq", "aocBatSeq");		
		this.hashFields.put("out_para_varchar", "outParaVarchar");
		this.hashFields.put("out_para_number", "outParaNumber");

		return this.hashFields;
	}


	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}

	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	
	/**
	 * @return the aocBatSeq
	 */
	public String getAocBatSeq() {
		return aocBatSeq;
	}

	/**
	 * @param aocBatSeq the aocBatSeq to set
	 */
	public void setAocBatSeq(String aocBatSeq) {
		this.aocBatSeq = aocBatSeq;
	}	
	
	/**
	 * @return the delPara
	 */
	public String getDelPara() {
		return delPara;
	}

	/**
	 * @param delPara the delPara to set
	 */
	public void setDelPara(String delPara) {
		this.delPara = delPara;
	}

	/**
	 * @return the outParaVarchar
	 */
	public String getOutParaVarchar() {
		return outParaVarchar;
	}

	/**
	 * @param outParaVarchar the outParaVarchar to set
	 */
	public void setOutParaVarchar(String outParaVarchar) {
		this.outParaVarchar = outParaVarchar;
	}

	/**
	 * @return the outParaNumber
	 */
	public String getOutParaNumber() {
		return outParaNumber;
	}

	/**
	 * @param outParaNumber the outParaNumber to set
	 */
	public void setOutParaNumber(String outParaNumber) {
		this.outParaNumber = outParaNumber;
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaBatchParameterVO[]
	 */
	public CoaBatchParameterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaBatchParameterVO[]
	 */
	public CoaBatchParameterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaBatchParameterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] startPctlNo = (JSPUtil.getParameter(request, prefix	+ "start_pctl_no", length));
			String[] endPctlNo = (JSPUtil.getParameter(request, prefix	+ "end_pctl_no", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] delPara = (JSPUtil.getParameter(request, prefix	+ "del_para", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] aocBatSeq = (JSPUtil.getParameter(request, prefix	+ "aoc_bat_seq", length));			
			String[] outParaVarchar = (JSPUtil.getParameter(request, prefix	+ "out_para_varchar", length));
			String[] outParaNumber = (JSPUtil.getParameter(request, prefix	+ "out_para_number", length));

			for (int i = 0; i < length; i++) {
				model = new CoaBatchParameterVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (startPctlNo[i] != null)
					model.setStartPctlNo(startPctlNo[i]);
				if (endPctlNo[i] != null)
					model.setEndPctlNo(endPctlNo[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (delPara[i] != null)
					model.setDelPara(delPara[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (aocBatSeq[i] != null)
					model.setAocBatSeq(aocBatSeq[i]);				
				if (outParaVarchar[i] != null)
					model.setOutParaVarchar(outParaVarchar[i]);
				if (outParaNumber[i] != null)
					model.setOutParaNumber(outParaNumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaBatchParameterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaBatchParameterVO[]
	 */
	public CoaBatchParameterVO[] getCoaBatchParameterVOs(){
		CoaBatchParameterVO[] vos = (CoaBatchParameterVO[])models.toArray(new CoaBatchParameterVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startPctlNo = this.startPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPctlNo = this.endPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aocBatSeq = this.aocBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.delPara = this.delPara .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outParaVarchar = this.outParaVarchar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outParaNumber = this.outParaNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
