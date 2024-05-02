/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MergyVolProjConditionVO.java
*@FileTitle : MergyVolProjConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.09.04 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MergyVolProjConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MergyVolProjConditionVO> models = new ArrayList<MergyVolProjConditionVO>();
	
	/* Column Info */
	private String lodTtlQty = null;
	/* Column Info */
	private String totsum = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String fSectNo = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String header = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String portPairRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String portPairLodQty = null;
	/* Column Info */
	private String portPairQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dTmlCd = null;
	/* Column Info */
	private String prdCd = null;
	/* Column Info */
	private String rLaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String dNum = null;
	/* Column Info */
	private String dSectNo = null;
	/* Column Info */
	private String sLanCd = null;
	
	public String getSLanCd() {
		return sLanCd;
	}

	public void setSLanCd(String lanCd) {
		sLanCd = lanCd;
	}

	/*	dynamic column List */
	private List<HashMap<String, String>> VolProjList = null;
	/* iterator List Info */
	private List<HashMap<String, Object>> DynamicPodCd = new ArrayList<HashMap<String, Object>>();
	/* iterator Info */
	private String iterators = null;
	/* iterator List Info */
	private List<String> iteratorList = null;
	
	public String getFSectNo() {
		return fSectNo;
	}

	public void setFSectNo(String sectNo) {
		fSectNo = sectNo;
	}
	
	public String getPrdCd() {
		return prdCd;
	}

	public void setPrdCd(String prdCd) {
		this.prdCd = prdCd;
	}

	public String getRLaneCd() {
		return rLaneCd;
	}

	public void setRLaneCd(String laneCd) {
		rLaneCd = laneCd;
	}

	public String getDirCd() {
		return dirCd;
	}

	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	public String getDTmlCd() {
		return dTmlCd;
	}

	public void setDTmlCd(String tmlCd) {
		dTmlCd = tmlCd;
	}

	public String getDNum() {
		return dNum;
	}

	public void setDNum(String num) {
		dNum = num;
	}
	
	public String getDSectNo() {
		return dSectNo;
	}

	public void setDSectNo(String sectNo) {
		dSectNo = sectNo;
	}
	
	/** 등록 리스트 Setter */
	public void setVolProjList(List<HashMap<String, String>> list){	
		VolProjList = list;
	}	
	
	/** 등록 리스트 Getter */
	public List<HashMap<String, String>> getVolProjList(){	
		return VolProjList;
	}	
	
	public List<HashMap<String, Object>> getDynamicPodCd() {
		return DynamicPodCd;
	}

	public void setDynamicPodCd(List<HashMap<String, Object>> dynamicPodCd) {
		DynamicPodCd = dynamicPodCd;
	}
	
	public String getIterators() {
		return iterators;
	}

	public void setIterators(String iterators) {
		this.iterators = iterators;
	}

	public List<String> getIteratorList() {
		return iteratorList;
	}

	public void setIteratorList(List<String> iteratorList) {
		this.iteratorList = iteratorList;
	}

	/* iterator Info */
	private Integer iteratorCnt = null;	
	
	public Integer getIteratorCnt() {
		return iteratorCnt;
	}

	public void setIteratorCnt(Integer iteratorCnt) {
		this.iteratorCnt = iteratorCnt;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MergyVolProjConditionVO() {}

	public MergyVolProjConditionVO(String ibflag, String pagerows, String simDt, String simNo, String sectNo, String header, 
								   String totsum, String lodTtlQty, String polCd, String podCd, String trdCd, String portPairQty, 
								   String sLanCd, String prdCd, String rLaneCd, String dirCd,
								   String portPairLodQty, String portPairRto, String creUsrId, String updUsrId, String fSectNo) {
		this.lodTtlQty = lodTtlQty;
		this.totsum = totsum;
		this.simDt = simDt;
		this.trdCd = trdCd;
		this.sectNo = sectNo;
		this.simNo = simNo;
		this.header = header;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.portPairRto = portPairRto;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.portPairLodQty = portPairLodQty;
		this.portPairQty = portPairQty;
		this.updUsrId = updUsrId;
		this.sLanCd = sLanCd;
		this.prdCd = prdCd;
		this.rLaneCd = rLaneCd;
		this.dirCd = dirCd;
		this.fSectNo = fSectNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lod_ttl_qty", getLodTtlQty());
		this.hashColumns.put("totsum", getTotsum());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("port_pair_rto", getPortPairRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("port_pair_lod_qty", getPortPairLodQty());
		this.hashColumns.put("port_pair_qty", getPortPairQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("slan_cd", getSLanCd());
		this.hashColumns.put("f_sect_no", getFSectNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lod_ttl_qty", "lodTtlQty");
		this.hashFields.put("totsum", "totsum");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("header", "header");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("port_pair_rto", "portPairRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("port_pair_lod_qty", "portPairLodQty");
		this.hashFields.put("port_pair_qty", "portPairQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prd_cd", "prdCd");
		this.hashFields.put("rlane_cd", "rlaneCdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("slan_cd", "sLanCd");
		this.hashFields.put("f_sect_no", "fSectNo");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lodTtlQty
	 */
	public String getLodTtlQty() {
		return this.lodTtlQty;
	}
	
	/**
	 * Column Info
	 * @return totsum
	 */
	public String getTotsum() {
		return this.totsum;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return portPairRto
	 */
	public String getPortPairRto() {
		return this.portPairRto;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return portPairLodQty
	 */
	public String getPortPairLodQty() {
		return this.portPairLodQty;
	}
	
	/**
	 * Column Info
	 * @return portPairQty
	 */
	public String getPortPairQty() {
		return this.portPairQty;
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
	 * @param lodTtlQty
	 */
	public void setLodTtlQty(String lodTtlQty) {
		this.lodTtlQty = lodTtlQty;
	}
	
	/**
	 * Column Info
	 * @param totsum
	 */
	public void setTotsum(String totsum) {
		this.totsum = totsum;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param portPairRto
	 */
	public void setPortPairRto(String portPairRto) {
		this.portPairRto = portPairRto;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param portPairLodQty
	 */
	public void setPortPairLodQty(String portPairLodQty) {
		this.portPairLodQty = portPairLodQty;
	}
	
	/**
	 * Column Info
	 * @param portPairQty
	 */
	public void setPortPairQty(String portPairQty) {
		this.portPairQty = portPairQty;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLodTtlQty(JSPUtil.getParameter(request, "f_lod_ttl_qty", ""));
		setTotsum(JSPUtil.getParameter(request, "f_totsum", ""));
		setSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "f_trd_cd", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setHeader(JSPUtil.getParameter(request, "f_header", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPortPairRto(JSPUtil.getParameter(request, "port_pair_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPortPairLodQty(JSPUtil.getParameter(request, "port_pair_lod_qty", ""));
		setPortPairQty(JSPUtil.getParameter(request, "port_pair_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPrdCd(JSPUtil.getParameter(request,"f_prd_cd", ""));
		setRLaneCd(JSPUtil.getParameter(request,"f_rlane_cd", ""));
		setDirCd(JSPUtil.getParameter(request,"f_dir_cd", ""));
		setSLanCd(JSPUtil.getParameter(request,"param5", ""));
		setFSectNo(JSPUtil.getParameter(request,"f_sect_no",""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MergyVolProjConditionVO[]
	 */
	public MergyVolProjConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MergyVolProjConditionVO[]
	 */
	public MergyVolProjConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MergyVolProjConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lodTtlQty = (JSPUtil.getParameter(request, prefix	+ "f_lod_ttl_qty", length));
			String[] totsum = (JSPUtil.getParameter(request, prefix	+ "f_totsum", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "f_header", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] portPairRto = (JSPUtil.getParameter(request, prefix	+ "port_pair_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] portPairLodQty = (JSPUtil.getParameter(request, prefix	+ "port_pair_lod_qty", length));
			String[] portPairQty = (JSPUtil.getParameter(request, prefix	+ "port_pair_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fSectNo = (JSPUtil.getParameter(request, prefix	+ "f_sect_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MergyVolProjConditionVO();
				if (lodTtlQty[i] != null)
					model.setLodTtlQty(lodTtlQty[i]);
				if (totsum[i] != null)
					model.setTotsum(totsum[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (portPairRto[i] != null)
					model.setPortPairRto(portPairRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (portPairLodQty[i] != null)
					model.setPortPairLodQty(portPairLodQty[i]);
				if (portPairQty[i] != null)
					model.setPortPairQty(portPairQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fSectNo[i] != null)
					model.setFSectNo(fSectNo[i]);
				if (i==0) {
					//예외적인 처리--------------------------------------------------------------------START
					
					try {			
						
						String[] pod_cd = header[0].split("[|]");
						if(pod_cd.length > 0){
							HashMap<String, Object> hMap = null;
				            for(int j=0; j<pod_cd.length; j++){
				            	hMap = new HashMap<String, Object>();
				            	String[] pod_cd_temp = (JSPUtil.getParameter(request, pod_cd[j], length));
				            	hMap.put(pod_cd[j], pod_cd_temp);
				            	DynamicPodCd.add(hMap);
				            }
				            if(DynamicPodCd.size() > 0) {
				            	model.setDynamicPodCd(DynamicPodCd);
				            }
						}	
					} catch (Exception e) {
						return null;
					} 
					//예외적인 처리--------------------------------------------------------------------END						
				}
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMergyVolProjConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MergyVolProjConditionVO[]
	 */
	public MergyVolProjConditionVO[] getMergyVolProjConditionVOs(){
		MergyVolProjConditionVO[] vos = (MergyVolProjConditionVO[])models.toArray(new MergyVolProjConditionVO[models.size()]);
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
		this.lodTtlQty = this.lodTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totsum = this.totsum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPairRto = this.portPairRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPairLodQty = this.portPairLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPairQty = this.portPairQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdCd = this.prdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rLaneCd = this.rLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLanCd = this.sLanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").replaceAll("|", "");
		this.fSectNo = this.fSectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").replaceAll("|", "");
	}
	
	
	/*	테이블 컬럼의  등록 값을 저장하는  List */
	private List createList = null;	
	
	/** 등록 리스트 Getter */
	public List getMultiCreateList(){	
		return createList;
	}
	/** 등록 리스트 Setter */
	public void setMultiCreateList(List list){	
		createList = list;
	}		
}
