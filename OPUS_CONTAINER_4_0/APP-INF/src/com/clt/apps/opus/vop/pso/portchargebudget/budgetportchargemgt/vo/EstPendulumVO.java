/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EstPendulumVO.java
*@FileTitle : EstPendulumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EstPendulumVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EstPendulumVO> models = new ArrayList<EstPendulumVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String turnPortFlg = null;

    /* Column Info */
    private String turnPortIndCd = null;

    /* Column Info */
    private String rlaneDirCd = null;

    /* Column Info */
    private String ibBnd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String pendTurnPortIndCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String pfTurnPortIndCd = null;

    /* Column Info */
    private String oriRevYrmon = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String clptSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public EstPendulumVO() {
    }

    public EstPendulumVO(String ibflag, String pagerows, String ydCd, String turnPortFlg, String turnPortIndCd, String rlaneDirCd, String ibBnd, String slanCd, String vpsEtdDt, String pendTurnPortIndCd, String vslCd, String skdVoyNo, String skdDirCd, String exeYrmon, String rlaneCd, String revYrmon, String pfTurnPortIndCd, String oriRevYrmon, String clptIndSeq, String clptSeq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ydCd = ydCd;
        this.turnPortFlg = turnPortFlg;
        this.turnPortIndCd = turnPortIndCd;
        this.rlaneDirCd = rlaneDirCd;
        this.ibBnd = ibBnd;
        this.slanCd = slanCd;
        this.vpsEtdDt = vpsEtdDt;
        this.pendTurnPortIndCd = pendTurnPortIndCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.exeYrmon = exeYrmon;
        this.rlaneCd = rlaneCd;
        this.revYrmon = revYrmon;
        this.pfTurnPortIndCd = pfTurnPortIndCd;
        this.oriRevYrmon = oriRevYrmon;
        this.clptIndSeq = clptIndSeq;
        this.clptSeq = clptSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("turn_port_flg", getTurnPortFlg());
        this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
        this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
        this.hashColumns.put("ib_bnd", getIbBnd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("pend_turn_port_ind_cd", getPendTurnPortIndCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("pf_turn_port_ind_cd", getPfTurnPortIndCd());
        this.hashColumns.put("ori_rev_yrmon", getOriRevYrmon());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("clpt_seq", getClptSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("turn_port_flg", "turnPortFlg");
        this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
        this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
        this.hashFields.put("ib_bnd", "ibBnd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("pend_turn_port_ind_cd", "pendTurnPortIndCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("pf_turn_port_ind_cd", "pfTurnPortIndCd");
        this.hashFields.put("ori_rev_yrmon", "oriRevYrmon");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("clpt_seq", "clptSeq");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * 
	 * @return String ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 *
	 * @param String turnPortFlg
	 */
    public void setTurnPortFlg(String turnPortFlg) {
        this.turnPortFlg = turnPortFlg;
    }

    /**
	 * 
	 * @return String turnPortFlg
	 */
    public String getTurnPortFlg() {
        return this.turnPortFlg;
    }

    /**
	 *
	 * @param String turnPortIndCd
	 */
    public void setTurnPortIndCd(String turnPortIndCd) {
        this.turnPortIndCd = turnPortIndCd;
    }

    /**
	 * 
	 * @return String turnPortIndCd
	 */
    public String getTurnPortIndCd() {
        return this.turnPortIndCd;
    }

    /**
	 *
	 * @param String rlaneDirCd
	 */
    public void setRlaneDirCd(String rlaneDirCd) {
        this.rlaneDirCd = rlaneDirCd;
    }

    /**
	 * 
	 * @return String rlaneDirCd
	 */
    public String getRlaneDirCd() {
        return this.rlaneDirCd;
    }

    /**
	 *
	 * @param String ibBnd
	 */
    public void setIbBnd(String ibBnd) {
        this.ibBnd = ibBnd;
    }

    /**
	 * 
	 * @return String ibBnd
	 */
    public String getIbBnd() {
        return this.ibBnd;
    }

    /**
	 *
	 * @param String slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * 
	 * @return String slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 *
	 * @param String vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * 
	 * @return String vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 *
	 * @param String pendTurnPortIndCd
	 */
    public void setPendTurnPortIndCd(String pendTurnPortIndCd) {
        this.pendTurnPortIndCd = pendTurnPortIndCd;
    }

    /**
	 * 
	 * @return String pendTurnPortIndCd
	 */
    public String getPendTurnPortIndCd() {
        return this.pendTurnPortIndCd;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String exeYrmon
	 */
    public void setExeYrmon(String exeYrmon) {
        this.exeYrmon = exeYrmon;
    }

    /**
	 * 
	 * @return String exeYrmon
	 */
    public String getExeYrmon() {
        return this.exeYrmon;
    }

    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    public String getRlaneCd() {
        return this.rlaneCd;
    }

    public void setRevYrmon(String revYrmon) {
        this.revYrmon = revYrmon;
    }

    public String getRevYrmon() {
        return this.revYrmon;
    }

    public void setPfTurnPortIndCd(String pfTurnPortIndCd) {
        this.pfTurnPortIndCd = pfTurnPortIndCd;
    }

    public String getPfTurnPortIndCd() {
        return this.pfTurnPortIndCd;
    }

    public void setOriRevYrmon(String oriRevYrmon) {
        this.oriRevYrmon = oriRevYrmon;
    }

    public String getOriRevYrmon() {
        return this.oriRevYrmon;
    }

    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    public String getClptSeq() {
        return this.clptSeq;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
        setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
        setRlaneDirCd(JSPUtil.getParameter(request, prefix + "rlane_dir_cd", ""));
        setIbBnd(JSPUtil.getParameter(request, prefix + "ib_bnd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setPendTurnPortIndCd(JSPUtil.getParameter(request, prefix + "pend_turn_port_ind_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setPfTurnPortIndCd(JSPUtil.getParameter(request, prefix + "pf_turn_port_ind_cd", ""));
        setOriRevYrmon(JSPUtil.getParameter(request, prefix + "ori_rev_yrmon", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstPendulumVO[]
	 */
    public EstPendulumVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstPendulumVO[]
	 */
    public EstPendulumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EstPendulumVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] turnPortFlg = (JSPUtil.getParameter(request, prefix + "turn_port_flg", length));
            String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", length));
            String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix + "rlane_dir_cd", length));
            String[] ibBnd = (JSPUtil.getParameter(request, prefix + "ib_bnd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] pendTurnPortIndCd = (JSPUtil.getParameter(request, prefix + "pend_turn_port_ind_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] pfTurnPortIndCd = (JSPUtil.getParameter(request, prefix + "pf_turn_port_ind_cd", length));
            String[] oriRevYrmon = (JSPUtil.getParameter(request, prefix + "ori_rev_yrmon", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EstPendulumVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (turnPortFlg[i] != null)
                    model.setTurnPortFlg(turnPortFlg[i]);
                if (turnPortIndCd[i] != null)
                    model.setTurnPortIndCd(turnPortIndCd[i]);
                if (rlaneDirCd[i] != null)
                    model.setRlaneDirCd(rlaneDirCd[i]);
                if (ibBnd[i] != null)
                    model.setIbBnd(ibBnd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (pendTurnPortIndCd[i] != null)
                    model.setPendTurnPortIndCd(pendTurnPortIndCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (pfTurnPortIndCd[i] != null)
                    model.setPfTurnPortIndCd(pfTurnPortIndCd[i]);
                if (oriRevYrmon[i] != null)
                    model.setOriRevYrmon(oriRevYrmon[i]);
                if (clptIndSeq[i] != null) 
		    		model.setClptIndSeq(clptIndSeq[i]);
				if (clptSeq[i] != null) 
		    		model.setClptSeq(clptSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEstPendulumVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EstPendulumVO[]
	 */
    public EstPendulumVO[] getEstPendulumVOs() {
        EstPendulumVO[] vos = (EstPendulumVO[]) models.toArray(new EstPendulumVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortFlg = this.turnPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortIndCd = this.turnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneDirCd = this.rlaneDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibBnd = this.ibBnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pendTurnPortIndCd = this.pendTurnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfTurnPortIndCd = this.pfTurnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oriRevYrmon = this.oriRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
