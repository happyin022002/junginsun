/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeRsltAnalGRPVO.java
*@FileTitle : OnTimeRsltAnalGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.17 정명훈 
* 1.0 Creation
*
* History
 * 2012.08.14 진마리아 CHM-201219281-01 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
 * 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdRsltVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OnTimeRsltAnalGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OnTimeRsltAnalGRPVO> models = new ArrayList<OnTimeRsltAnalGRPVO>();
	
	
	/* Column Info */
	private String vslSlanCd = "";
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Result Exist Info */
	private String exist = null;
	/* Column Info */
	private String actCrrCd = null;

	/* Column Info */
	private String lanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actInpYrmon = null;
	
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	

	
	/* Other VOs Info */
	private List<VskActPortSkdVO> 	vskActPortSkdVOs 	= null;
	private List<VskVslPortSkdVO> 	vskVslPortSkdVOs 	= null;
	private List<VskVslSkdRsltVO> 	vskVslSkdRsltVOs 	= null;
	private List<SkdResultVO> 		skdResultVOs 		= null;
	private String[] pfEtbDts = null;
	
	private String[] bfrPfEtdDts = null;
	
	private String[] pfEtdDts = null;
	private String[] clptSeq = null;
	private String creUsrId = null;
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OnTimeRsltAnalGRPVO() {}

	//public OnTimeRsltAnalVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, VskActPortSkdVO vskActPortSkdVO, VskVslPortSkdVO vskVslPortSkdVO, VskVslSkdRsltVO vskVslSkdRsltVO) {
	public OnTimeRsltAnalGRPVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String vslSlanCd, String actCrrCd, String lanCd, String skdDirCd, String actInpYrmon, String vpsPortCd, String clptIndSeq) {
		this.voyNo = voyNo;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.dirCd = dirCd;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.actCrrCd = actCrrCd;

		this.lanCd = lanCd;
		this.skdDirCd = skdDirCd;
		this.actInpYrmon = actInpYrmon;
		
		this.vpsPortCd = vpsPortCd;
		this.clptIndSeq = clptIndSeq;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("lan_cd", getLanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_inp_yrmon", getActInpYrmon());
		
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());


		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("lan_cd", "lanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_inp_yrmon", "actInpYrmon");
		
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");


		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
	}
	
	
	/**
	 * Service Lane Code
	 * @return lanCd
	 */
	public String getLanCd() {
		return this.lanCd;
	}
	
	/**
	 * Direction Code
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * Column Info
	 * @return actInpYrmon
	 */
	public String getActInpYrmon() {
		return this.actInpYrmon;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
	}
	
	
	/**
	 * Service Lane Code 
	 * @param lanCd
	 */
	public void setLanCd(String lanCd) {
		this.lanCd =  lanCd;
	}
	
	/**
	 * Direction Code 
	 * @param lanCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd =  skdDirCd;
	}

	/**
	 * Active Month 
	 * @param actInpYrmon
	 */
	public void setActInpYrmon(String actInpYrmon) {
		this.actInpYrmon =  actInpYrmon;
	}
	
	/**
	 * Active Month 
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd =  vpsPortCd;
	}
	
	/**
	 * Active Month 
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq =  clptIndSeq;
	}
	
	/**
	 * @return vskActPortSkdVOs
	 */
	public List<VskActPortSkdVO> getVskActPortSkdVOs() {
		return vskActPortSkdVOs;
	}

	/**
	 * @param List<VskActPortSkdVO> vskActPortSkdVOs
	 */
	public void setVskActPortSkdVOs(List<VskActPortSkdVO> vskActPortSkdVOs) {
		this.vskActPortSkdVOs = vskActPortSkdVOs;
	}

	/**
	 * @return vskVslPortSkdVOs
	 */
	public List<VskVslPortSkdVO> getVskVslPortSkdVOs() {
		return vskVslPortSkdVOs;
	}

	/**
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 */
	public void setVskVslPortSkdVOs(List<VskVslPortSkdVO> vskVslPortSkdVOs) {
		this.vskVslPortSkdVOs = vskVslPortSkdVOs;
	}
	
	/**
	 * @return vskVslSkdRsltVOs
	 */
	public List<VskVslSkdRsltVO> getVskVslSkdRsltVOs() {
		return vskVslSkdRsltVOs;
	}

	/**
	 * @param List<VskVslSkdRsltVO> vskVslSkdRsltVOs
	 */
	public void setVskVslSkdRsltVOs(List<VskVslSkdRsltVO> vskVslSkdRsltVOs) {
		this.vskVslSkdRsltVOs = vskVslSkdRsltVOs;
	}

	/**
	 * @return skdResultVOs
	 */
	public List<SkdResultVO> getSkdResultVOs() {
		return skdResultVOs;
	}

	/**
	 * @param List<SkdResultVO> skdResultVOs
	 */
	public void setSkdResultVOs(List<SkdResultVO> skdResultVOs) {
		this.skdResultVOs = skdResultVOs;
	}
	
	/**
	 * @return pfEtbDts
	 */
	public String[] getPfEtbDts(){
		return pfEtbDts;
	}
	
	/**
	 * @return skdResultVOs
	 */
	public void setPfEtbDts(String[] pfEtbDts){
		this.pfEtbDts = pfEtbDts;
	}
	
	/**
	 * @return pfEtdDts
	 */
	public String[] getPfEtdDts(){
		return pfEtdDts;
	}	
	
	/**
	 * @return bfrPfEtdDts
	 */
	public String[] getBfrPfEtdDts(){
		return bfrPfEtdDts;
	}
	
	/**
	 * @param bfrPfEtdDts
	 */
	public void setPfEtdDts(String[] pfEtdDts){
		this.pfEtdDts = pfEtdDts;
	}
	
	/**
	 * @param bfrPfEtdDts
	 */
	public void setBfrPfEtdDts(String[] bfrPfEtdDts){
		this.bfrPfEtdDts = bfrPfEtdDts;
	}
	
	/**
	 * @return clptSeq
	 */
	public String[] getClptSeq(){
		return clptSeq;
	}
	
	/**
	 * @param clptSeq
	 */
	public void setClptSeq(String[] clptSeq){
		this.clptSeq = clptSeq;
	}
	
	/**
	 * @return bfrPfEtdDts
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return bfrPfEtdDts
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	
	/**
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return String
	 */
	public String getExist(){
		return exist;
	}
	
	/**
	 * @param boolean flag
	 */
	public void setExist(String exist){
		this.exist = exist;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActCrrCd(JSPUtil.getParameter(request, "act_crr_cd", ""));
		
		setLanCd(JSPUtil.getParameter(request, "lan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setActInpYrmon(JSPUtil.getParameter(request, "act_inp_yrmon", ""));
		
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OnTimeRsltAnalVO[]
	 */
	public OnTimeRsltAnalGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OnTimeRsltAnalVO[]
	 */
	public OnTimeRsltAnalGRPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OnTimeRsltAnalGRPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));

			String[] lanCd = (JSPUtil.getParameter(request, prefix	+ "lan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actInpYrmon = (JSPUtil.getParameter(request, prefix	+ "act_inp_yrmon", length));
			
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));

			
			for (int i = 0; i < length; i++) {
				model = new OnTimeRsltAnalGRPVO();
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				
				if (lanCd[i] != null)
					model.setLanCd(lanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actInpYrmon[i] != null)
					model.setActInpYrmon(actInpYrmon[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnTimeRsltAnalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OnTimeRsltAnalVO[]
	 */
	public OnTimeRsltAnalGRPVO[] getOnTimeRsltAnalVOs(){
		OnTimeRsltAnalGRPVO[] vos = (OnTimeRsltAnalGRPVO[])models.toArray(new OnTimeRsltAnalGRPVO[models.size()]);
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
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.lanCd = this.lanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpYrmon = this.actInpYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
