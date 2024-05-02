/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeRsltAnalGRPVO.java
*@FileTitle : OnTimeRsltAnalGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.17 정명훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdRsltVO;

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
	/* Other VOs Info */
	private List<VskActPortSkdVO> vskActPortSkdVOs = null;
	private List<VskVslPortSkdVO> vskVslPortSkdVOs = null;
	private List<VskVslSkdRsltVO> vskVslSkdRsltVOs = null;
	private List<SkdResultVO> skdResultVOs = null;
	private String[] pfEtbDts = null;
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
	public OnTimeRsltAnalGRPVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String vslSlanCd) {
		this.voyNo = voyNo;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.dirCd = dirCd;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
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
	 * @return the vskActPortSkdVO
	 */
	public List<VskActPortSkdVO> getVskActPortSkdVOs() {
		return vskActPortSkdVOs;
	}

	/**
	 * @param vskActPortSkdVO the vskActPortSkdVO to set
	 */
	public void setVskActPortSkdVOs(List<VskActPortSkdVO> vskActPortSkdVOs) {
		this.vskActPortSkdVOs = vskActPortSkdVOs;
	}

	/**
	 * @return the vskVslPortSkdVO
	 */
	public List<VskVslPortSkdVO> getVskVslPortSkdVOs() {
		return vskVslPortSkdVOs;
	}

	/**
	 * @param vskVslPortSkdVO the vskVslPortSkdVO to set
	 */
	public void setVskVslPortSkdVOs(List<VskVslPortSkdVO> vskVslPortSkdVOs) {
		this.vskVslPortSkdVOs = vskVslPortSkdVOs;
	}
	
	/**
	 * @return List<VskVslSkdRsltVO>
	 */
	public List<VskVslSkdRsltVO> getVskVslSkdRsltVOs() {
		return vskVslSkdRsltVOs;
	}

	/**
	 * @param vskVslSkdRsltVOs the vskVslSkdRsltVO to set
	 */
	public void setVskVslSkdRsltVOs(List<VskVslSkdRsltVO> vskVslSkdRsltVOs) {
		this.vskVslSkdRsltVOs = vskVslSkdRsltVOs;
	}

	/**
	 * @return the SkdResultVO
	 */
	public List<SkdResultVO> getSkdResultVOs() {
		return skdResultVOs;
	}

	/**
	 * @param skdResultVOs the vskVslSkdRsltVO to set
	 */
	public void setSkdResultVOs(List<SkdResultVO> skdResultVOs) {
		this.skdResultVOs = skdResultVOs;
	}
	
	public String[] getPfEtbDts(){
		return pfEtbDts;
	}
	
	public void setPfEtbDts(String[] pfEtbDts){
		this.pfEtbDts = pfEtbDts;
	}
	
	public String[] getPfEtdDts(){
		return pfEtdDts;
	}
	
	public void setPfEtdDts(String[] pfEtdDts){
		this.pfEtdDts = pfEtdDts;
	}
	
	public String[] getClptSeq(){
		return clptSeq;
	}
	
	public void setClptSeq(String[] clptSeq){
		this.clptSeq = clptSeq;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

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
	}
}
