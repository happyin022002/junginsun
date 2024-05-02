/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaManifestListMctForBasicInfoVO.java
*@FileTitle : PanamaManifestListMctForBasicInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.15 김민정 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PanamaManifestListMctForBasicInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PanamaManifestListMctForBasicInfoVO> models = new ArrayList<PanamaManifestListMctForBasicInfoVO>();

    /* Column Info */
    private String headerSeq = null;

    /* Column Info */
    private String mcargo = null;

    /* Column Info */
    private String dgbulk = null;

    /* Column Info */
    private String mvmtSeq = null;

    /* Column Info */
    private String dgpackage = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String cargo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pnmVslOprCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslSlanNm = null;

    /* Column Info */
    private String pnmDestCd = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String pnmOrgCd = null;

    /* Column Info */
    private String mttanks = null;

    /* Column Info */
    private String vstNo = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String podCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PanamaManifestListMctForBasicInfoVO() {
    }

    public PanamaManifestListMctForBasicInfoVO(String ibflag, String pagerows, String vstNo, String vvdCd, String pnmOrgCd, String pnmDestCd, String mcargo, String pnmVslOprCd, String cargo, String mttanks, String dgbulk, String dgpackage, String mvmtSeq, String headerSeq, String vslSlanCd, String vslSlanNm, String polCd, String podCd) {
        this.headerSeq = headerSeq;
        this.mcargo = mcargo;
        this.dgbulk = dgbulk;
        this.mvmtSeq = mvmtSeq;
        this.dgpackage = dgpackage;
        this.vslSlanCd = vslSlanCd;
        this.cargo = cargo;
        this.pagerows = pagerows;
        this.pnmVslOprCd = pnmVslOprCd;
        this.ibflag = ibflag;
        this.vslSlanNm = vslSlanNm;
        this.pnmDestCd = pnmDestCd;
        this.vvdCd = vvdCd;
        this.pnmOrgCd = pnmOrgCd;
        this.mttanks = mttanks;
        this.vstNo = vstNo;
        this.polCd = polCd;
        this.podCd = podCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("header_seq", getHeaderSeq());
        this.hashColumns.put("mcargo", getMcargo());
        this.hashColumns.put("dgbulk", getDgbulk());
        this.hashColumns.put("mvmt_seq", getMvmtSeq());
        this.hashColumns.put("dgpackage", getDgpackage());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("cargo", getCargo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pnm_vsl_opr_cd", getPnmVslOprCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
        this.hashColumns.put("pnm_dest_cd", getPnmDestCd());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("pnm_org_cd", getPnmOrgCd());
        this.hashColumns.put("mttanks", getMttanks());
        this.hashColumns.put("vst_no", getVstNo());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pod_cd", getPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("header_seq", "headerSeq");
        this.hashFields.put("mcargo", "mcargo");
        this.hashFields.put("dgbulk", "dgbulk");
        this.hashFields.put("mvmt_seq", "mvmtSeq");
        this.hashFields.put("dgpackage", "dgpackage");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("cargo", "cargo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pnm_vsl_opr_cd", "pnmVslOprCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_slan_nm", "vslSlanNm");
        this.hashFields.put("pnm_dest_cd", "pnmDestCd");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("pnm_org_cd", "pnmOrgCd");
        this.hashFields.put("mttanks", "mttanks");
        this.hashFields.put("vst_no", "vstNo");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pod_cd", "podCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return headerSeq
	 */
    public String getHeaderSeq() {
        return this.headerSeq;
    }

    /**
	 * Column Info
	 * @return mcargo
	 */
    public String getMcargo() {
        return this.mcargo;
    }

    /**
	 * Column Info
	 * @return dgbulk
	 */
    public String getDgbulk() {
        return this.dgbulk;
    }

    /**
	 * Column Info
	 * @return mvmtSeq
	 */
    public String getMvmtSeq() {
        return this.mvmtSeq;
    }

    /**
	 * Column Info
	 * @return dgpackage
	 */
    public String getDgpackage() {
        return this.dgpackage;
    }

    /**
	 * Column Info
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 * Column Info
	 * @return cargo
	 */
    public String getCargo() {
        return this.cargo;
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
	 * @return pnmVslOprCd
	 */
    public String getPnmVslOprCd() {
        return this.pnmVslOprCd;
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
	 * @return vslSlanNm
	 */
    public String getVslSlanNm() {
        return this.vslSlanNm;
    }

    /**
	 * Column Info
	 * @return pnmDestCd
	 */
    public String getPnmDestCd() {
        return this.pnmDestCd;
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
	 * @return pnmOrgCd
	 */
    public String getPnmOrgCd() {
        return this.pnmOrgCd;
    }

    /**
	 * Column Info
	 * @return mttanks
	 */
    public String getMttanks() {
        return this.mttanks;
    }

    /**
	 * Column Info
	 * @return vstNo
	 */
    public String getVstNo() {
        return this.vstNo;
    }

    /**
	 * Column Info
	 * @param headerSeq
	 */
    public void setHeaderSeq(String headerSeq) {
        this.headerSeq = headerSeq;
    }

    /**
	 * Column Info
	 * @param mcargo
	 */
    public void setMcargo(String mcargo) {
        this.mcargo = mcargo;
    }

    /**
	 * Column Info
	 * @param dgbulk
	 */
    public void setDgbulk(String dgbulk) {
        this.dgbulk = dgbulk;
    }

    /**
	 * Column Info
	 * @param mvmtSeq
	 */
    public void setMvmtSeq(String mvmtSeq) {
        this.mvmtSeq = mvmtSeq;
    }

    /**
	 * Column Info
	 * @param dgpackage
	 */
    public void setDgpackage(String dgpackage) {
        this.dgpackage = dgpackage;
    }

    /**
	 * Column Info
	 * @param vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param cargo
	 */
    public void setCargo(String cargo) {
        this.cargo = cargo;
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
	 * @param pnmVslOprCd
	 */
    public void setPnmVslOprCd(String pnmVslOprCd) {
        this.pnmVslOprCd = pnmVslOprCd;
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
	 * @param vslSlanNm
	 */
    public void setVslSlanNm(String vslSlanNm) {
        this.vslSlanNm = vslSlanNm;
    }

    /**
	 * Column Info
	 * @param pnmDestCd
	 */
    public void setPnmDestCd(String pnmDestCd) {
        this.pnmDestCd = pnmDestCd;
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
	 * @param pnmOrgCd
	 */
    public void setPnmOrgCd(String pnmOrgCd) {
        this.pnmOrgCd = pnmOrgCd;
    }

    /**
	 * Column Info
	 * @param mttanks
	 */
    public void setMttanks(String mttanks) {
        this.mttanks = mttanks;
    }

    /**
	 * Column Info
	 * @param vstNo
	 */
    public void setVstNo(String vstNo) {
        this.vstNo = vstNo;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
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
        setHeaderSeq(JSPUtil.getParameter(request, prefix + "header_seq", ""));
        setMcargo(JSPUtil.getParameter(request, prefix + "mcargo", ""));
        setDgbulk(JSPUtil.getParameter(request, prefix + "dgbulk", ""));
        setMvmtSeq(JSPUtil.getParameter(request, prefix + "mvmt_seq", ""));
        setDgpackage(JSPUtil.getParameter(request, prefix + "dgpackage", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setCargo(JSPUtil.getParameter(request, prefix + "cargo", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPnmVslOprCd(JSPUtil.getParameter(request, prefix + "pnm_vsl_opr_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
        setPnmDestCd(JSPUtil.getParameter(request, prefix + "pnm_dest_cd", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setPnmOrgCd(JSPUtil.getParameter(request, prefix + "pnm_org_cd", ""));
        setMttanks(JSPUtil.getParameter(request, prefix + "mttanks", ""));
        setVstNo(JSPUtil.getParameter(request, prefix + "vst_no", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaManifestListMctForBasicInfoVO[]
	 */
    public PanamaManifestListMctForBasicInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaManifestListMctForBasicInfoVO[]
	 */
    public PanamaManifestListMctForBasicInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PanamaManifestListMctForBasicInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] headerSeq = (JSPUtil.getParameter(request, prefix + "header_seq", length));
            String[] mcargo = (JSPUtil.getParameter(request, prefix + "mcargo", length));
            String[] dgbulk = (JSPUtil.getParameter(request, prefix + "dgbulk", length));
            String[] mvmtSeq = (JSPUtil.getParameter(request, prefix + "mvmt_seq", length));
            String[] dgpackage = (JSPUtil.getParameter(request, prefix + "dgpackage", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] cargo = (JSPUtil.getParameter(request, prefix + "cargo", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pnmVslOprCd = (JSPUtil.getParameter(request, prefix + "pnm_vsl_opr_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslSlanNm = (JSPUtil.getParameter(request, prefix + "vsl_slan_nm", length));
            String[] pnmDestCd = (JSPUtil.getParameter(request, prefix + "pnm_dest_cd", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] pnmOrgCd = (JSPUtil.getParameter(request, prefix + "pnm_org_cd", length));
            String[] mttanks = (JSPUtil.getParameter(request, prefix + "mttanks", length));
            String[] vstNo = (JSPUtil.getParameter(request, prefix + "vst_no", length));
            for (int i = 0; i < length; i++) {
                model = new PanamaManifestListMctForBasicInfoVO();
                if (headerSeq[i] != null)
                    model.setHeaderSeq(headerSeq[i]);
                if (mcargo[i] != null)
                    model.setMcargo(mcargo[i]);
                if (dgbulk[i] != null)
                    model.setDgbulk(dgbulk[i]);
                if (mvmtSeq[i] != null)
                    model.setMvmtSeq(mvmtSeq[i]);
                if (dgpackage[i] != null)
                    model.setDgpackage(dgpackage[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (cargo[i] != null)
                    model.setCargo(cargo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pnmVslOprCd[i] != null)
                    model.setPnmVslOprCd(pnmVslOprCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslSlanNm[i] != null)
                    model.setVslSlanNm(vslSlanNm[i]);
                if (pnmDestCd[i] != null)
                    model.setPnmDestCd(pnmDestCd[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (pnmOrgCd[i] != null)
                    model.setPnmOrgCd(pnmOrgCd[i]);
                if (mttanks[i] != null)
                    model.setMttanks(mttanks[i]);
                if (vstNo[i] != null)
                    model.setVstNo(vstNo[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPanamaManifestListMctForBasicInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PanamaManifestListMctForBasicInfoVO[]
	 */
    public PanamaManifestListMctForBasicInfoVO[] getPanamaManifestListMctForBasicInfoVOs() {
        PanamaManifestListMctForBasicInfoVO[] vos = (PanamaManifestListMctForBasicInfoVO[]) models.toArray(new PanamaManifestListMctForBasicInfoVO[models.size()]);
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
        this.headerSeq = this.headerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mcargo = this.mcargo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgbulk = this.dgbulk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mvmtSeq = this.mvmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgpackage = this.dgpackage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cargo = this.cargo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmVslOprCd = this.pnmVslOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanNm = this.vslSlanNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmDestCd = this.pnmDestCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmOrgCd = this.pnmOrgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mttanks = this.mttanks.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vstNo = this.vstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
