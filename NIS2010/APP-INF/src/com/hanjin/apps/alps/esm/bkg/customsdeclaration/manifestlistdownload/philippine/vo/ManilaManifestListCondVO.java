/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaManifestListCondVO.java
*@FileTitle : ManilaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.01  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ManilaManifestListCondVO extends ManifestListCondVO {

    private static final long serialVersionUID = 1L;

    private Collection<ManilaManifestListCondVO> models = new ArrayList<ManilaManifestListCondVO>();

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String regNo = null;

    /* Column Info */
    private String sheetgubun = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String flatFile = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ManilaManifestListCondVO() {
    }

    public ManilaManifestListCondVO(String ibflag, String pagerows, String vslCd, String polCd, String podCd, String regNo, String skdDirCd, String skdVoyNo, String sheetgubun, String flatFile) {
        this.podCd = podCd;
        this.vslCd = vslCd;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.skdVoyNo = skdVoyNo;
        this.regNo = regNo;
        this.sheetgubun = sheetgubun;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.flatFile = flatFile;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("reg_no", getRegNo());
        this.hashColumns.put("sheetgubun", getSheetgubun());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("flat_file", getFlatFile());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("reg_no", "regNo");
        this.hashFields.put("sheetgubun", "sheetgubun");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("flat_file", "flatFile");
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return regNo
	 */
    public String getRegNo() {
        return this.regNo;
    }

    /**
	 * Column Info
	 * @return sheetgubun
	 */
    public String getSheetgubun() {
        return this.sheetgubun;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
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
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param regNo
	 */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
	 * Column Info
	 * @param sheetgubun
	 */
    public void setSheetgubun(String sheetgubun) {
        this.sheetgubun = sheetgubun;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setFlatFile(String flatFile) {
        this.flatFile = flatFile;
    }

    public String getFlatFile() {
        return this.flatFile;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setRegNo(JSPUtil.getParameter(request, prefix + "reg_no", ""));
        setSheetgubun(JSPUtil.getParameter(request, prefix + "sheetgubun", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFlatFile(JSPUtil.getParameter(request, prefix + "flat_file", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaManifestListCondVO[]
	 */
    public ManilaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaManifestListCondVO[]
	 */
    public ManilaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ManilaManifestListCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] regNo = (JSPUtil.getParameter(request, prefix + "reg_no", length));
            String[] sheetgubun = (JSPUtil.getParameter(request, prefix + "sheetgubun", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] flatFile = (JSPUtil.getParameter(request, prefix + "flat_file", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ManilaManifestListCondVO();
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (regNo[i] != null)
                    model.setRegNo(regNo[i]);
                if (sheetgubun[i] != null)
                    model.setSheetgubun(sheetgubun[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (flatFile[i] != null) 
		    		model.setFlatFile(flatFile[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getManilaManifestListCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ManilaManifestListCondVO[]
	 */
    public ManilaManifestListCondVO[] getManilaManifestListCondVOs() {
        ManilaManifestListCondVO[] vos = (ManilaManifestListCondVO[]) models.toArray(new ManilaManifestListCondVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.regNo = this.regNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sheetgubun = this.sheetgubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flatFile = this.flatFile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
