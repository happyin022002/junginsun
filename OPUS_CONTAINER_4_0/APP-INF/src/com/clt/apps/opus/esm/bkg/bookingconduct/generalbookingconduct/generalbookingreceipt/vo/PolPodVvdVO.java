/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PolPodVvdVO.java
*@FileTitle : PolPodVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.01 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PolPodVvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PolPodVvdVO> models = new ArrayList<PolPodVvdVO>();

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String bkgVvdCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String bkgNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public PolPodVvdVO() {
    }

    public PolPodVvdVO(String ibflag, String pagerows, String polCd, String polYdCd, String podCd, String podYdCd, String polClptIndSeq, String podClptIndSeq, String bkgVvdCd, String vslPrePstCd, String slanCd, String bkgNo) {
        this.podCd = podCd;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.polYdCd = polYdCd;
        this.podClptIndSeq = podClptIndSeq;
        this.polClptIndSeq = polClptIndSeq;
        this.vslPrePstCd = vslPrePstCd;
        this.podYdCd = podYdCd;
        this.bkgVvdCd = bkgVvdCd;
        this.slanCd = slanCd;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
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
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
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
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 * Column Info
	 * @return podClptIndSeq
	 */
    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    /**
	 * Column Info
	 * @return polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    /**
	 * Column Info
	 * @return vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
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
	 * @return bkgVvdCd
	 */
    public String getBkgVvdCd() {
        return this.bkgVvdCd;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
	 * @param polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param podClptIndSeq
	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * Column Info
	 * @param polClptIndSeq
	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * Column Info
	 * @param vslPrePstCd
	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
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
	 * @param bkgVvdCd
	 */
    public void setBkgVvdCd(String bkgVvdCd) {
        this.bkgVvdCd = bkgVvdCd;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, "pol_clpt_ind_seq", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
        setBkgVvdCd(JSPUtil.getParameter(request, "bkg_vvd_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PolPodVvdVO[]
	 */
    public PolPodVvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PolPodVvdVO[]
	 */
    public PolPodVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PolPodVvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd".trim(), length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd".trim(), length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq".trim(), length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq".trim(), length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd".trim(), length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd".trim(), length));
            String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix + "bkg_vvd_cd".trim(), length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PolPodVvdVO();
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (bkgVvdCd[i] != null)
                    model.setBkgVvdCd(bkgVvdCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null) 
		    		model.setBkgNo(bkgNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPolPodVvdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PolPodVvdVO[]
	 */
    public PolPodVvdVO[] getPolPodVvdVOs() {
        PolPodVvdVO[] vos = (PolPodVvdVO[]) models.toArray(new PolPodVvdVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
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
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgVvdCd = this.bkgVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
