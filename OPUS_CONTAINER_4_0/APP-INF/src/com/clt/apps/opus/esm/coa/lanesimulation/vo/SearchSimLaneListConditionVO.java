/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimLaneListConditionVO.java
*@FileTitle : SearchSimLaneListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.12 윤진영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimLaneListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimLaneListConditionVO> models = new ArrayList<SearchSimLaneListConditionVO>();
	
	/* Column Info */
	private String fSimDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fSlanCd = null;
	/* Column Info */
	private String tname = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String fSimNo = null;
	/* Column Info */
	private String fPrdCd = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fDirCd = null;	
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String fSectNo = null;
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String nextPortCd = null;
	/* Column Info */
	private String portArr = null;
	/* Column Info */
	private String yardArr = null;	
	/* Column Info */
	private String portStr = null;
	/* Column Info */
	private String fHeader = null;
	/* Column Info */
	private String fDeptCd = null;
	/* Column Info */
	private String fDeptCd1 = null;
	/* Column Info */
	private String fDeptCd2 = null;
	/* Column Info */
	private String fSim = null;
	/* Column Info */
	private String fUsrId = null;
	
	/*
	 *  조회조건용  
	 */
	/* Column Info */
	private String minSpeed = null;	
	/* Column Info */
	private String maxSpeed = null;
	/* Column Info */
	private String frmDuration = null;
	/* Column Info */
	private String toDuration = null;
	/* Column Info */
	private String vesselClass1 = null;	
	/* Column Info */
	private String vesselClass1Cnt = null;	
	/* Column Info */
	private String vesselClass2 = null;
	/* Column Info */
	private String vesselClass2Cnt = null;	
	/* Column Info */
	private String vesselClass3 = null;
	/* Column Info */
	private String vesselClass3Cnt = null;	
	/* Column Info */
	private String frequency = null;
	/* Column Info */
	private String firstPortETBNo = null;	
	/* Column Info */
	private String firstPortETBDay = null;	
	/* Column Info */
	private String firstPortETBTime = null;	

	public String getYardArr() {
		return yardArr;
	}
	public void setYardArr(String yardArr) {
		this.yardArr = yardArr;
	}	
	public String getMinSpeed() {
		return minSpeed;
	}
	public void setMinSpeed(String minSpeed) {
		this.minSpeed = minSpeed;
	}


	public String getMaxSpeed() {
		return maxSpeed;
	}

	public String getFHeader() {
		return fHeader;
	}
	
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public String getFrmDuration() {
		return frmDuration;
	}


	public void setFrmDuration(String frmDuration) {
		this.frmDuration = frmDuration;
	}


	public String getToDuration() {
		return toDuration;
	}


	public void setToDuration(String toDuration) {
		this.toDuration = toDuration;
	}


	public String getVesselClass1() {
		return vesselClass1;
	}


	public void setVesselClass1(String vesselClass1) {
		this.vesselClass1 = vesselClass1;
	}


	public String getVesselClass1Cnt() {
		return vesselClass1Cnt;
	}


	public void setVesselClass1Cnt(String vesselClass1Cnt) {
		this.vesselClass1Cnt = vesselClass1Cnt;
	}


	public String getVesselClass2() {
		return vesselClass2;
	}


	public void setVesselClass2(String vesselClass2) {
		this.vesselClass2 = vesselClass2;
	}


	public String getVesselClass2Cnt() {
		return vesselClass2Cnt;
	}


	public void setVesselClass2Cnt(String vesselClass2Cnt) {
		this.vesselClass2Cnt = vesselClass2Cnt;
	}


	public String getVesselClass3() {
		return vesselClass3;
	}


	public void setVesselClass3(String vesselClass3) {
		this.vesselClass3 = vesselClass3;
	}


	public String getVesselClass3Cnt() {
		return vesselClass3Cnt;
	}


	public void setVesselClass3Cnt(String vesselClass3Cnt) {
		this.vesselClass3Cnt = vesselClass3Cnt;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public String getFirstPortETBNo() {
		return firstPortETBNo;
	}


	public void setFirstPortETBNo(String firstPortETBNo) {
		this.firstPortETBNo = firstPortETBNo;
	}


	public String getFirstPortETBDay() {
		return firstPortETBDay;
	}


	public void setFirstPortETBDay(String firstPortETBDay) {
		this.firstPortETBDay = firstPortETBDay;
	}


	public String getFirstPortETBTime() {
		return firstPortETBTime;
	}


	public void setFirstPortETBTime(String firstPortETBTime) {
		this.firstPortETBTime = firstPortETBTime;
	}
	
	public String getPortStr() {
		return portStr;
	}


	public void setPortStr(String portStr) {
		this.portStr = portStr;
	}


	public String getPortArr() {
		return portArr;
	}


	public void setPortArr(String portArr) {
		this.portArr = portArr;
	}


	public String getNextPortCd() {
		return nextPortCd;
	}


	public void setNextPortCd(String nextPortCd) {
		this.nextPortCd = nextPortCd;
	}


	public String getTmlCd() {
		return tmlCd;
	}


	public String getYardCd() {
		return yardCd;
	}

	public void setFHeader(String header) {
		fHeader = header;
	}	
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getPortDys() {
		return portDys;
	}

	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}

	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}

	
	public String getFDeptCd() {
		return fDeptCd;
	}
	public void setFDeptCd(String deptCd) {
		fDeptCd = deptCd;
	}
	

	public String getFDeptCd1() {
		return fDeptCd1;
	}
	public void setFDeptCd1(String deptCd1) {
		fDeptCd1 = deptCd1;
	}
	public String getFDeptCd2() {
		return fDeptCd2;
	}
	public void setFDeptCd2(String deptCd2) {
		fDeptCd2 = deptCd2;
	}
	
	public String getFSim() {
		return fSim;
	}
	public void setFSim(String sim) {
		fSim = sim;
	}
	
	public String getFUsrId() {
		return fUsrId;
	}
	public void setFUsrId(String usrId) {
		fUsrId = usrId;
	}



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimLaneListConditionVO() {}

	public SearchSimLaneListConditionVO(String ibflag, String pagerows, String fSlanCd, String fSimDt, String fSimNo, String sectNo, String tname, String fPrdCd, String fTrdCd,String fRlaneCd,String fDirCd,String fSectNo,String portDys,String fDeptCd,String fDeptCd1,String fDeptCd2,String fSim,String fUsrId) {
		this.fSimDt = fSimDt;
		this.ibflag = ibflag;
		this.fSlanCd = fSlanCd;
		this.tname = tname;
		this.sectNo = sectNo;
		this.fSimNo = fSimNo;
		this.fPrdCd = fPrdCd;
		this.fTrdCd = fTrdCd;
		this.fRlaneCd = fRlaneCd;
		this.fDirCd = fDirCd;
		this.pagerows = pagerows;
		this.fSectNo = fSectNo;
		this.portDys = portDys;
		this.fDeptCd = fDeptCd;
		this.fDeptCd1 = fDeptCd1;
		this.fDeptCd2 = fDeptCd2;
		this.fSim = fSim;
		this.fUsrId = fUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_sim_dt", getFSimDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_slan_cd", getFSlanCd());
		this.hashColumns.put("tname", getTname());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("f_sim_no", getFSimNo());
		this.hashColumns.put("f_prd_cd", getFPrdCd());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_sect_no", getFSectNo());
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("next_port_cd", getNextPortCd());
		this.hashColumns.put("port_arr", getPortArr());
		this.hashColumns.put("yard_arr", getPortArr());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("port_str", getPortStr());
		this.hashColumns.put("f_dept_cd", getFDeptCd());
		this.hashColumns.put("f_dept_cd1", getFDeptCd1());
		this.hashColumns.put("f_dept_cd2", getFDeptCd2());
		this.hashColumns.put("f_sim", getFSim());
		this.hashColumns.put("f_usr_id", getFUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_sim_dt", "fSimDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_slan_cd", "fSlanCd");
		this.hashFields.put("tname", "tname");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("f_sim_no", "fSimNo");
		this.hashFields.put("f_prd_cd", "fPrdCd");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_sect_no", "fSectNo");
		this.hashFields.put("port_dys", getPortDys());
		this.hashFields.put("tml_cd", getTmlCd());
		this.hashFields.put("next_port_cd", getNextPortCd());
		this.hashFields.put("port_arr", getPortArr());
		this.hashFields.put("yard_arr", getPortArr());
		this.hashFields.put("port_cd", getPortCd());
		this.hashFields.put("port_str", getPortStr());
		this.hashFields.put("f_dept_cd", "fDeptCd");
		this.hashFields.put("f_dept_cd1", "fDeptCd1");
		this.hashFields.put("f_dept_cd2", "fDeptCd2");
		this.hashFields.put("f_sim", "fSim");
		this.hashFields.put("f_usr_id", "fUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fSimDt
	 */
	public String getFSectNo() {
		return fSectNo;
	}
	/**
	 * Column Info
	 * @return fSimDt
	 */
	public void setFSectNo(String fSectNo) {
		this.fSectNo = fSectNo;
	}
	public String getFSimDt() {
		return this.fSimDt;
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
	 * @return fSlanCd
	 */
	public String getFSlanCd() {
		return this.fSlanCd;
	}
	
	/**
	 * Column Info
	 * @return tname
	 */
	public String getTname() {
		return this.tname;
	}
	
	/**
	 * Column Info
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFSimNo() {
		return this.fSimNo;
	}
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFPrdCd() {
		return this.fPrdCd;
	}
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
	}
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
	}
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFDirCd() {
		return this.fDirCd;
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
	 * @param fSimDt
	 */
	public void setFSimDt(String fSimDt) {
		this.fSimDt = fSimDt;
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
	 * @param fSlanCd
	 */
	public void setFSlanCd(String fSlanCd) {
		this.fSlanCd = fSlanCd;
	}
	
	/**
	 * Column Info
	 * @param tname
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	/**
	 * Column Info
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFSimNo(String fSimNo) {
		this.fSimNo = fSimNo;
	}
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFPrdCd(String fPrdCd) {
		this.fPrdCd = fPrdCd;
	}
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
	}
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
	}
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
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
		setFSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFSlanCd(JSPUtil.getParameter(request, "f_slan_cd", ""));
		setTname(JSPUtil.getParameter(request, "tname", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setFSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setFPrdCd(JSPUtil.getParameter(request, "f_prd_cd", ""));
		setFTrdCd(JSPUtil.getParameter(request, "f_trd_cd", ""));
		setFRlaneCd(JSPUtil.getParameter(request, "f_rlane_cd", ""));
		setFDirCd(JSPUtil.getParameter(request, "f_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFSectNo(JSPUtil.getParameter(request, "f_sect_no", ""));
		setFHeader(JSPUtil.getParameter(request, "f_header", ""));
		setPortDys(JSPUtil.getParameter(request, "port_dys", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setYardCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPortArr(JSPUtil.getParameter(request, "f_port_arr", ""));
		setYardArr(JSPUtil.getParameter(request, "f_yard_arr", ""));
		setFDeptCd(JSPUtil.getParameter(request, "f_dept_cd", ""));
		setFDeptCd1(JSPUtil.getParameter(request, "f_dept_cd1", ""));
		setFDeptCd2(JSPUtil.getParameter(request, "f_dept_cd2", ""));
		setFSim(JSPUtil.getParameter(request, "f_sim", ""));
		setFUsrId(JSPUtil.getParameter(request, "f_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimLaneListConditionVO[]
	 */
	public SearchSimLaneListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimLaneListConditionVO[]
	 */
	public SearchSimLaneListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimLaneListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fSimDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fSlanCd = (JSPUtil.getParameter(request, prefix	+ "f_slan_cd", length));
			String[] tname = (JSPUtil.getParameter(request, prefix	+ "tname", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] fSimNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] fPrdCd = (JSPUtil.getParameter(request, prefix	+ "f_prd_cd", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fSectNo = (JSPUtil.getParameter(request, prefix	+ "f_sect_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] fDeptCd = (JSPUtil.getParameter(request, prefix	+ "f_dept_cd", length));
			String[] fDeptCd1 = (JSPUtil.getParameter(request, prefix	+ "f_dept_cd1", length));
			String[] fDeptCd2 = (JSPUtil.getParameter(request, prefix	+ "f_dept_cd2", length));
			String[] fSim 	= (JSPUtil.getParameter(request, prefix	+ "f_sim", length));
			String[] fUsrId 	= (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimLaneListConditionVO();
				if (fSimDt[i] != null)
					model.setFSimDt(fSimDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fSlanCd[i] != null)
					model.setFSlanCd(fSlanCd[i]);
				if (tname[i] != null)
					model.setTname(tname[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (fSimNo[i] != null)
					model.setFSimNo(fSimNo[i]);
				if (fPrdCd[i] != null)
					model.setFPrdCd(fPrdCd[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fSectNo[i] != null)
					model.setFSectNo(fSectNo[i]);
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);	
				if (fDeptCd[i] != null)
					model.setFDeptCd(fDeptCd[i]);	
				if (fDeptCd1[i] != null)
					model.setFDeptCd1(fDeptCd1[i]);	
				if (fDeptCd2[i] != null)
					model.setFDeptCd2(fDeptCd2[i]);	
				if (fSim[i] != null)
					model.setFSimNo(fSim[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimLaneListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimLaneListConditionVO[]
	 */
	public SearchSimLaneListConditionVO[] getSearchSimLaneListConditionVOs(){
		SearchSimLaneListConditionVO[] vos = (SearchSimLaneListConditionVO[])models.toArray(new SearchSimLaneListConditionVO[models.size()]);
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
		this.fSimDt = this.fSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlanCd = this.fSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").replace("|", "");
		this.tname = this.tname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimNo = this.fSimNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPrdCd = this.fPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSectNo = this.fSectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeptCd = this.fDeptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeptCd1 = this.fDeptCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeptCd2 = this.fDeptCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	//추가
	private DBRowSet dbRowSet = null;

	public DBRowSet getDbRowSet() {
		return dbRowSet;
	}
	public void setDbRowSet(DBRowSet dbRowSet) {
		this.dbRowSet = dbRowSet;
	}
	
	
}
