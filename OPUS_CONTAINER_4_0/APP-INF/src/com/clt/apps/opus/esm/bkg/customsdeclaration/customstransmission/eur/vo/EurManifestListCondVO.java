/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurManifestListCondVO.java
*@FileTitle : EurManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.28 김보배 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EurManifestListCondVO extends ManifestListCondVO {

    private static final long serialVersionUID = 1L;

    private Collection<EurManifestListCondVO> models = new ArrayList<EurManifestListCondVO>();

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String receiverId = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String modeType = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String checkFrobSearch = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cargoType = null;
    
    /* Column Info */
    private String trnsMode = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public EurManifestListCondVO() {
    }

    public EurManifestListCondVO(String ibflag, String pagerows, String vvdCd, String podCd, String polCd, String blNo, String receiverId, String checkFrobSearch, String podYdCd, String polYdCd, String modeType, String cargoType, String trnsMode) {
        this.podCd = podCd;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.vvdCd = vvdCd;
        this.receiverId = receiverId;
        this.polYdCd = polYdCd;
        this.modeType = modeType;
        this.podYdCd = podYdCd;
        this.checkFrobSearch = checkFrobSearch;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.cargoType = cargoType;
        this.trnsMode = trnsMode;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("receiver_id", getReceiverId());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("mode_type", getModeType());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("check_frob_search", getCheckFrobSearch());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cargo_type", getCargoType());
        this.hashColumns.put("trns_mode", getTrnsMode());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("receiver_id", "receiverId");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("mode_type", "modeType");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("check_frob_search", "checkFrobSearch");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cargo_type", "cargoType");
        this.hashFields.put("trns_mode", "trnsMode");
        return this.hashFields;
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
	 * @return vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 * Column Info
	 * @return receiverId
	 */
    public String getReceiverId() {
        return this.receiverId;
    }

    /**
	 * Column Info
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 * Column Info
	 * @return modeType
	 */
    public String getModeType() {
        return this.modeType;
    }

    /**
	 * Column Info
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	 * Column Info
	 * @return checkFrobSearch
	 */
    public String getCheckFrobSearch() {
        return this.checkFrobSearch;
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
	 * @return trnsMode
	 */
    public String getTrnsMode() {
        return this.trnsMode;
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
	 * @param vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * Column Info
	 * @param receiverId
	 */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
	 * Column Info
	 * @param polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param modeType
	 */
    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    /**
	 * Column Info
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    /**
	 * Column Info
	 * @param checkFrobSearch
	 */
    public void setCheckFrobSearch(String checkFrobSearch) {
        this.checkFrobSearch = checkFrobSearch;
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
	 * Column Info
	 * @param cargoType
	 */
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    
    /**
	 * Column Info
	 * @param cargoType
	 */
    public String getCargoType() {
        return this.cargoType;
    }
    
    /**
	 * Column Info
	 * @param trnsMode
	 */
    public void setTrnsMode(String trnsMode) {
        this.trnsMode = trnsMode;
    }
    
    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setReceiverId(JSPUtil.getParameter(request, prefix + "receiver_id", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setModeType(JSPUtil.getParameter(request, prefix + "mode_type", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setCheckFrobSearch(JSPUtil.getParameter(request, prefix + "check_frob_search", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
        setTrnsMode(JSPUtil.getParameter(request, prefix + "trns_mode", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurManifestListCondVO[]
	 */
    public EurManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurManifestListCondVO[]
	 */
    public EurManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EurManifestListCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] receiverId = (JSPUtil.getParameter(request, prefix + "receiver_id", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] modeType = (JSPUtil.getParameter(request, prefix + "mode_type", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] checkFrobSearch = (JSPUtil.getParameter(request, prefix + "check_frob_search", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] trnsMode = (JSPUtil.getParameter(request, prefix + "trns_mode", length));
            for (int i = 0; i < length; i++) {
                model = new EurManifestListCondVO();
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (receiverId[i] != null)
                    model.setReceiverId(receiverId[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (modeType[i] != null)
                    model.setModeType(modeType[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (checkFrobSearch[i] != null)
                    model.setCheckFrobSearch(checkFrobSearch[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (trnsMode[i] != null)
                    model.setTrnsMode(trnsMode[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEurManifestListCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EurManifestListCondVO[]
	 */
    public EurManifestListCondVO[] getEurManifestListCondVOs() {
        EurManifestListCondVO[] vos = (EurManifestListCondVO[]) models.toArray(new EurManifestListCondVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.receiverId = this.receiverId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modeType = this.modeType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkFrobSearch = this.checkFrobSearch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cargoType = this.cargoType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnsMode = this.trnsMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

