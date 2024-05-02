/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrfChgVO.java
*@FileTitle : TrfChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.05.26 김민정 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.vo;

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
public class TrfChgVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TrfChgVO> models = new ArrayList<TrfChgVO>();

    /* Column Info */
    private String apply = null;

    /* Column Info */
    private String pcChg = null;

    /* Column Info */
    private String d20Init = null;

    /* Column Info */
    private String d40Init = null;

    /* Column Info */
    private String d45Tot = null;

    /* Column Info */
    private String d20Tot = null;

    /* Column Info */
    private String d70Init = null;

    /* Column Info */
    private String chgCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pctlNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String d40 = null;

    /* Column Info */
    private String d70 = null;

    /* Column Info */
    private String d20 = null;

    /* Column Info */
    private String d45 = null;

    /* Column Info */
    private String pc = null;

    /* Column Info */
    private String d70Tot = null;

    /* Column Info */
    private String d45Init = null;

    /* Column Info */
    private String ratAsQty = null;

    /* Column Info */
    private String d40Tot = null;

    /* Column Info */
    private String svcScpCd = null;
    
    /* Column Info */
    private String lvl = null;    
    private String lvl2 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public TrfChgVO() {
    }

    public TrfChgVO(String ibflag, String pagerows, String pctlNo, String chgCd, String pcChg, String apply, String ratAsQty, String pc, String d20, String d40, String d45, String d70, String d20Init, String d40Init, String d45Init, String d70Init, String d20Tot, String d40Tot, String d45Tot, String d70Tot, String svcScpCd, String lvl, String lvl2) {
        this.apply = apply;
        this.pcChg = pcChg;
        this.d20Init = d20Init;
        this.d40Init = d40Init;
        this.d45Tot = d45Tot;
        this.d20Tot = d20Tot;
        this.d70Init = d70Init;
        this.chgCd = chgCd;
        this.pagerows = pagerows;
        this.pctlNo = pctlNo;
        this.ibflag = ibflag;
        this.d40 = d40;
        this.d70 = d70;
        this.d20 = d20;
        this.d45 = d45;
        this.pc = pc;
        this.d70Tot = d70Tot;
        this.d45Init = d45Init;
        this.ratAsQty = ratAsQty;
        this.d40Tot = d40Tot;
        this.svcScpCd = svcScpCd;
        
        this.lvl = lvl;
        this.lvl2 = lvl2;
       
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("apply", getApply());
        this.hashColumns.put("pc_chg", getPcChg());
        this.hashColumns.put("d20_init", getD20Init());
        this.hashColumns.put("d40_init", getD40Init());
        this.hashColumns.put("d45_tot", getD45Tot());
        this.hashColumns.put("d20_tot", getD20Tot());
        this.hashColumns.put("d70_init", getD70Init());
        this.hashColumns.put("chg_cd", getChgCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("d40", getD40());
        this.hashColumns.put("d70", getD70());
        this.hashColumns.put("d20", getD20());
        this.hashColumns.put("d45", getD45());
        this.hashColumns.put("pc", getPc());
        this.hashColumns.put("d70_tot", getD70Tot());
        this.hashColumns.put("d45_init", getD45Init());
        this.hashColumns.put("rat_as_qty", getRatAsQty());
        this.hashColumns.put("d40_tot", getD40Tot());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        
        this.hashColumns.put("lvl", getLvl());
        this.hashColumns.put("lvl2", getLvl2());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("apply", "apply");
        this.hashFields.put("pc_chg", "pcChg");
        this.hashFields.put("d20_init", "d20Init");
        this.hashFields.put("d40_init", "d40Init");
        this.hashFields.put("d45_tot", "d45Tot");
        this.hashFields.put("d20_tot", "d20Tot");
        this.hashFields.put("d70_init", "d70Init");
        this.hashFields.put("chg_cd", "chgCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("d40", "d40");
        this.hashFields.put("d70", "d70");
        this.hashFields.put("d20", "d20");
        this.hashFields.put("d45", "d45");
        this.hashFields.put("pc", "pc");
        this.hashFields.put("d70_tot", "d70Tot");
        this.hashFields.put("d45_init", "d45Init");
        this.hashFields.put("rat_as_qty", "ratAsQty");
        this.hashFields.put("d40_tot", "d40Tot");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        
        this.hashFields.put("lvl", "lvl");
        this.hashFields.put("lvl2", "lvl2");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return apply
	 */
    public String getApply() {
        return this.apply;
    }

    /**
	 * Column Info
	 * @return pcChg
	 */
    public String getPcChg() {
        return this.pcChg;
    }

    /**
	 * Column Info
	 * @return d20Init
	 */
    public String getD20Init() {
        return this.d20Init;
    }

    /**
	 * Column Info
	 * @return d40Init
	 */
    public String getD40Init() {
        return this.d40Init;
    }

    /**
	 * Column Info
	 * @return d45Tot
	 */
    public String getD45Tot() {
        return this.d45Tot;
    }

    /**
	 * Column Info
	 * @return d20Tot
	 */
    public String getD20Tot() {
        return this.d20Tot;
    }

    /**
	 * Column Info
	 * @return d70Init
	 */
    public String getD70Init() {
        return this.d70Init;
    }

    /**
	 * Column Info
	 * @return chgCd
	 */
    public String getChgCd() {
        return this.chgCd;
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
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
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
	 * @return d40
	 */
    public String getD40() {
        return this.d40;
    }

    /**
	 * Column Info
	 * @return d70
	 */
    public String getD70() {
        return this.d70;
    }

    /**
	 * Column Info
	 * @return d20
	 */
    public String getD20() {
        return this.d20;
    }

    /**
	 * Column Info
	 * @return d45
	 */
    public String getD45() {
        return this.d45;
    }

    /**
	 * Column Info
	 * @return pc
	 */
    public String getPc() {
        return this.pc;
    }

    /**
	 * Column Info
	 * @return d70Tot
	 */
    public String getD70Tot() {
        return this.d70Tot;
    }

    /**
	 * Column Info
	 * @return d45Init
	 */
    public String getD45Init() {
        return this.d45Init;
    }

    /**
	 * Column Info
	 * @return ratAsQty
	 */
    public String getRatAsQty() {
        return this.ratAsQty;
    }

    /**
	 * Column Info
	 * @return d40Tot
	 */
    public String getD40Tot() {
        return this.d40Tot;
    }
    
    /**
	 * Column Info
	 * @return lvl
	 */
    public String getLvl() {
        return this.lvl;
    }
    
    /**
	 * Column Info
	 * @return lvl2
	 */
    public String getLvl2() {
        return this.lvl2;
    }    

    /**
	 * Column Info
	 * @param apply
	 */
    public void setApply(String apply) {
        this.apply = apply;
    }

    /**
	 * Column Info
	 * @param pcChg
	 */
    public void setPcChg(String pcChg) {
        this.pcChg = pcChg;
    }

    /**
	 * Column Info
	 * @param d20Init
	 */
    public void setD20Init(String d20Init) {
        this.d20Init = d20Init;
    }

    /**
	 * Column Info
	 * @param d40Init
	 */
    public void setD40Init(String d40Init) {
        this.d40Init = d40Init;
    }

    /**
	 * Column Info
	 * @param d45Tot
	 */
    public void setD45Tot(String d45Tot) {
        this.d45Tot = d45Tot;
    }

    /**
	 * Column Info
	 * @param d20Tot
	 */
    public void setD20Tot(String d20Tot) {
        this.d20Tot = d20Tot;
    }

    /**
	 * Column Info
	 * @param d70Init
	 */
    public void setD70Init(String d70Init) {
        this.d70Init = d70Init;
    }

    /**
	 * Column Info
	 * @param chgCd
	 */
    public void setChgCd(String chgCd) {
        this.chgCd = chgCd;
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
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
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
	 * @param d40
	 */
    public void setD40(String d40) {
        this.d40 = d40;
    }

    /**
	 * Column Info
	 * @param d70
	 */
    public void setD70(String d70) {
        this.d70 = d70;
    }

    /**
	 * Column Info
	 * @param d20
	 */
    public void setD20(String d20) {
        this.d20 = d20;
    }

    /**
	 * Column Info
	 * @param d45
	 */
    public void setD45(String d45) {
        this.d45 = d45;
    }

    /**
	 * Column Info
	 * @param pc
	 */
    public void setPc(String pc) {
        this.pc = pc;
    }

    /**
	 * Column Info
	 * @param d70Tot
	 */
    public void setD70Tot(String d70Tot) {
        this.d70Tot = d70Tot;
    }

    /**
	 * Column Info
	 * @param d45Init
	 */
    public void setD45Init(String d45Init) {
        this.d45Init = d45Init;
    }

    /**
	 * Column Info
	 * @param ratAsQty
	 */
    public void setRatAsQty(String ratAsQty) {
        this.ratAsQty = ratAsQty;
    }

    /**
	 * Column Info
	 * @param d40Tot
	 */
    public void setD40Tot(String d40Tot) {
        this.d40Tot = d40Tot;
    }

    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    public String getSvcScpCd() {
        return this.svcScpCd;
    }
    
    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
    
    public void setLvl2(String lvl2) {
        this.lvl2 = lvl2;
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
        setApply(JSPUtil.getParameter(request, prefix + "apply", ""));
        setPcChg(JSPUtil.getParameter(request, prefix + "pc_chg", ""));
        setD20Init(JSPUtil.getParameter(request, prefix + "d20_init", ""));
        setD40Init(JSPUtil.getParameter(request, prefix + "d40_init", ""));
        setD45Tot(JSPUtil.getParameter(request, prefix + "d45_tot", ""));
        setD20Tot(JSPUtil.getParameter(request, prefix + "d20_tot", ""));
        setD70Init(JSPUtil.getParameter(request, prefix + "d70_init", ""));
        setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setD40(JSPUtil.getParameter(request, prefix + "d40", ""));
        setD70(JSPUtil.getParameter(request, prefix + "d70", ""));
        setD20(JSPUtil.getParameter(request, prefix + "d20", ""));
        setD45(JSPUtil.getParameter(request, prefix + "d45", ""));
        setPc(JSPUtil.getParameter(request, prefix + "pc", ""));
        setD70Tot(JSPUtil.getParameter(request, prefix + "d70_tot", ""));
        setD45Init(JSPUtil.getParameter(request, prefix + "d45_init", ""));
        setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
        setD40Tot(JSPUtil.getParameter(request, prefix + "d40_tot", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        
        setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
        setLvl2(JSPUtil.getParameter(request, prefix + "lvl2", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrfChgVO[]
	 */
    public TrfChgVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrfChgVO[]
	 */
    public TrfChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TrfChgVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] apply = (JSPUtil.getParameter(request, prefix + "apply", length));
            String[] pcChg = (JSPUtil.getParameter(request, prefix + "pc_chg", length));
            String[] d20Init = (JSPUtil.getParameter(request, prefix + "d20_init", length));
            String[] d40Init = (JSPUtil.getParameter(request, prefix + "d40_init", length));
            String[] d45Tot = (JSPUtil.getParameter(request, prefix + "d45_tot", length));
            String[] d20Tot = (JSPUtil.getParameter(request, prefix + "d20_tot", length));
            String[] d70Init = (JSPUtil.getParameter(request, prefix + "d70_init", length));
            String[] chgCd = (JSPUtil.getParameter(request, prefix + "chg_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] d40 = (JSPUtil.getParameter(request, prefix + "d40", length));
            String[] d70 = (JSPUtil.getParameter(request, prefix + "d70", length));
            String[] d20 = (JSPUtil.getParameter(request, prefix + "d20", length));
            String[] d45 = (JSPUtil.getParameter(request, prefix + "d45", length));
            String[] pc = (JSPUtil.getParameter(request, prefix + "pc", length));
            String[] d70Tot = (JSPUtil.getParameter(request, prefix + "d70_tot", length));
            String[] d45Init = (JSPUtil.getParameter(request, prefix + "d45_init", length));
            String[] ratAsQty = (JSPUtil.getParameter(request, prefix + "rat_as_qty", length));
            String[] d40Tot = (JSPUtil.getParameter(request, prefix + "d40_tot", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            
            String[] lvl = (JSPUtil.getParameter(request, prefix + "lvl", length));
            String[] lvl2 = (JSPUtil.getParameter(request, prefix + "lvl2", length));
            for (int i = 0; i < length; i++) {
                model = new TrfChgVO();
                if (apply[i] != null)
                    model.setApply(apply[i]);
                if (pcChg[i] != null)
                    model.setPcChg(pcChg[i]);
                if (d20Init[i] != null)
                    model.setD20Init(d20Init[i]);
                if (d40Init[i] != null)
                    model.setD40Init(d40Init[i]);
                if (d45Tot[i] != null)
                    model.setD45Tot(d45Tot[i]);
                if (d20Tot[i] != null)
                    model.setD20Tot(d20Tot[i]);
                if (d70Init[i] != null)
                    model.setD70Init(d70Init[i]);
                if (chgCd[i] != null)
                    model.setChgCd(chgCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (d40[i] != null)
                    model.setD40(d40[i]);
                if (d70[i] != null)
                    model.setD70(d70[i]);
                if (d20[i] != null)
                    model.setD20(d20[i]);
                if (d45[i] != null)
                    model.setD45(d45[i]);
                if (pc[i] != null)
                    model.setPc(pc[i]);
                if (d70Tot[i] != null)
                    model.setD70Tot(d70Tot[i]);
                if (d45Init[i] != null)
                    model.setD45Init(d45Init[i]);
                if (ratAsQty[i] != null)
                    model.setRatAsQty(ratAsQty[i]);
                if (d40Tot[i] != null)
                    model.setD40Tot(d40Tot[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                
                if (lvl[i] != null)
                    model.setLvl(lvl[i]);
                if (lvl2[i] != null)
                    model.setLvl2(lvl2[i]);                
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTrfChgVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TrfChgVO[]
	 */
    public TrfChgVO[] getTrfChgVOs() {
        TrfChgVO[] vos = (TrfChgVO[]) models.toArray(new TrfChgVO[models.size()]);
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
        this.apply = this.apply.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pcChg = this.pcChg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d20Init = this.d20Init.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d40Init = this.d40Init.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d45Tot = this.d45Tot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d20Tot = this.d20Tot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d70Init = this.d70Init.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCd = this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d40 = this.d40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d70 = this.d70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d20 = this.d20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d45 = this.d45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pc = this.pc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d70Tot = this.d70Tot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d45Init = this.d45Init.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratAsQty = this.ratAsQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.d40Tot = this.d40Tot.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        
        this.lvl = this.lvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lvl2 = this.lvl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        
    }
}
