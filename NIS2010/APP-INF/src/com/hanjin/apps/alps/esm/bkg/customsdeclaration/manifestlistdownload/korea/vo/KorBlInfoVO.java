/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBlInfoCondVO.java
*@FileTitle : KorBlInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.17 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see BlInfoVO
 */

public class KorBlInfoVO extends BlInfoVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBlInfoVO> models = new ArrayList<KorBlInfoVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */ 
	private String mode = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String podLoc = null;
	/* Page Number */
	private String pagerows = null;
	
	// 처리결과를 담는 객체
	private String cgoSpec = null;
	private KorCorrTransVO korCorrTransVO = null;
	private KorCntrCorrVO[] korCntrCorrVOs = null;
	private KorCustCorrVO korCustCorrVO = null;
	private KorExpCorrVO[] korExpCorrVOs = null;
	private KorCorrListVO[] korCorrListVOs = null;
	private KorAmendInfoVO korAmendInfoVO = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBlInfoVO() {}

	public KorBlInfoVO(String ibflag, String pagerows, String blNo, String ioBndCd, String polCd, String podCd, String vvd, String mrnNo, String cstmsDeclTpCd, String mode, String polLoc, String podLoc, String cgoSpec) {
		this.vvd = vvd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.ioBndCd = ioBndCd;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.mode = mode;
		this.podLoc = podLoc;
		this.polLoc = polLoc;
		this.cgoSpec = cgoSpec;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("mode", getMode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_spec", getCgoSpec());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("cgo_spec", "cgoSpec");
		return this.hashFields;
	}
	
	/**
	 * @return the polLoc
	 */
	public String getPolLoc() {
		return polLoc;
	}

	/**
	 * @param polLoc the polLoc to set
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}

	/**
	 * @return the podLoc
	 */
	public String getPodLoc() {
		return podLoc;
	}

	/**
	 * @param podLoc the podLoc to set
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the korAmendInfoVO
	 */
	public KorAmendInfoVO getKorAmendInfoVO() {
		return korAmendInfoVO;
	}

	/**
	 * @param korAmendInfoVO the korAmendInfoVO to set
	 */
	public void setKorAmendInfoVO(KorAmendInfoVO korAmendInfoVO) {
		this.korAmendInfoVO = korAmendInfoVO;
	}

	/**
	 * @return the cgoSpec
	 */
	public String getCgoSpec() {
		return cgoSpec;
	}

	/**
	 * @param cgoSpec the cgoSpec to set
	 */
	public void setCgoSpec(String cgoSpec) {
		this.cgoSpec = cgoSpec;
	}

	/**
	 * @return the korCorrTransVO
	 */
	public KorCorrTransVO getKorCorrTransVO() {
		return korCorrTransVO;
	}

	/**
	 * @param korCorrTransVO the korCorrTransVO to set
	 */
	public void setKorCorrTransVO(KorCorrTransVO korCorrTransVO) {
		this.korCorrTransVO = korCorrTransVO;
	}

	/**
	 * @return the korCntrCorrVOs
	 */
	public KorCntrCorrVO[] getKorCntrCorrVOs() {
		return korCntrCorrVOs;
	}

	/**
	 * @param korCntrCorrVOs the korCntrCorrVOs to set
	 */
	public void setKorCntrCorrVOs(KorCntrCorrVO[] korCntrCorrVOs) {
		this.korCntrCorrVOs = korCntrCorrVOs;
	}

	/**
	 * @return the korCustCorrVO
	 */
	public KorCustCorrVO getKorCustCorrVO() {
		return korCustCorrVO;
	}

	/**
	 * @param korCustCorrVO the korCustCorrVO to set
	 */
	public void setKorCustCorrVO(KorCustCorrVO korCustCorrVO) {
		this.korCustCorrVO = korCustCorrVO;
	}

	/**
	 * @return the korExpCorrVOs
	 */
	public KorExpCorrVO[] getKorExpCorrVOs() {
		return korExpCorrVOs;
	}

	/**
	 * @param korExpCorrVOs the korExpCorrVOs to set
	 */
	public void setKorExpCorrVOs(KorExpCorrVO[] korExpCorrVOs) {
		this.korExpCorrVOs = korExpCorrVOs;
	}

	/**
	 * @return the korCorrListVOs
	 */
	public KorCorrListVO[] getKorCorrListVOs() {
		return korCorrListVOs;
	}

	/**
	 * @param korCorrListVOs the korCorrListVOs to set
	 */
	public void setKorCorrListVOs(KorCorrListVO[] korCorrListVOs) {
		this.korCorrListVOs = korCorrListVOs;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMode(JSPUtil.getParameter(request, "mode", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setCgoSpec(JSPUtil.getParameter(request, "cgo_spec", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBlInfoCondVO[]
	 */
	public KorBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBlInfoCondVO[]
	 */
	public KorBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] cgoSpec = (JSPUtil.getParameter(request, prefix	+ "cgo_spec", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBlInfoVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoSpec[i] != null)
					model.setCgoSpec(cgoSpec[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBlInfoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBlInfoCondVO[]
	 */
	public KorBlInfoVO[] getKorBlInfoCondVOs(){
		KorBlInfoVO[] vos = (KorBlInfoVO[])models.toArray(new KorBlInfoVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSpec = this.cgoSpec.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
