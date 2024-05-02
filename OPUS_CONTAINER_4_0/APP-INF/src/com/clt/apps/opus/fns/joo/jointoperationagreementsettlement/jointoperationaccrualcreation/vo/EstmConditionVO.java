/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstmConditionVO.java
*@FileTitle : EstmConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.17 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EstmConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EstmConditionVO> models = new ArrayList<EstmConditionVO>();

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String revYrmonFr = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String estmCondFlg = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String diffOption = null;

    /* Column Info */
    private String joStlJbCd = null;

    /* Column Info */
    private String revYrmonTo = null;

    /* Column Info */
    private String joStlItmCds = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String voyDaysCd = null;

    /* Column Info */
    private String chkInclude = null;

    /* Column Info */
    private String joStlItmFlg = null;

    /* Column Info */
    private String pageNo = null;

    /* Column Info */
    private String creFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public EstmConditionVO() {
    }

    public EstmConditionVO(String ibflag, String pagerows, String exeYrmon, String revYrmonFr, String revYrmonTo, String reDivrCd, String trdCd, String rlaneCd, String joCrrCd, String joStlJbCd, String diffOption, String vvd, String estmCondFlg, String joStlItmCds, String joStlItmCd, String voyDaysCd, String chkInclude, String joStlItmFlg, String pageNo, String creFlg) {
        this.exeYrmon = exeYrmon;
        this.trdCd = trdCd;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.pagerows = pagerows;
        this.vvd = vvd;
        this.revYrmonFr = revYrmonFr;
        this.ibflag = ibflag;
        this.estmCondFlg = estmCondFlg;
        this.reDivrCd = reDivrCd;
        this.diffOption = diffOption;
        this.joStlJbCd = joStlJbCd;
        this.revYrmonTo = revYrmonTo;
        this.joStlItmCds = joStlItmCds;
        this.joStlItmCd = joStlItmCd;
        this.voyDaysCd = voyDaysCd;
        this.chkInclude = chkInclude;
        this.joStlItmFlg = joStlItmFlg;
        this.pageNo = pageNo;
        this.creFlg = creFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("rev_yrmon_fr", getRevYrmonFr());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("estm_cond_flg", getEstmCondFlg());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("diff_option", getDiffOption());
        this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
        this.hashColumns.put("rev_yrmon_to", getRevYrmonTo());
        this.hashColumns.put("jo_stl_itm_cds", getJoStlItmCds());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("voy_days_cd", getVoyDaysCd());
        this.hashColumns.put("chk_include", getChkInclude());
        this.hashColumns.put("jo_stl_itm_flg", getJoStlItmFlg());
        this.hashColumns.put("page_no", getPageNo());
        this.hashColumns.put("cre_flg", getCreFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("rev_yrmon_fr", "revYrmonFr");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("estm_cond_flg", "estmCondFlg");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("diff_option", "diffOption");
        this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
        this.hashFields.put("rev_yrmon_to", "revYrmonTo");
        this.hashFields.put("jo_stl_itm_cds", "joStlItmCds");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("voy_days_cd", "voyDaysCd");
        this.hashFields.put("chk_include", "chkInclude");
        this.hashFields.put("jo_stl_itm_flg", "joStlItmFlg");
        this.hashFields.put("page_no", "pageNo");
        this.hashFields.put("cre_flg", "creFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return exeYrmon
	 */
    public String getExeYrmon() {
        return this.exeYrmon;
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
	 * @return joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 * Column Info
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return revYrmonFr
	 */
    public String getRevYrmonFr() {
        return this.revYrmonFr;
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
	 * @return estmCondFlg
	 */
    public String getEstmCondFlg() {
        return this.estmCondFlg;
    }

    /**
	 * Column Info
	 * @return reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 * Column Info
	 * @return diffOption
	 */
    public String getDiffOption() {
        return this.diffOption;
    }

    /**
	 * Column Info
	 * @return joStlJbCd
	 */
    public String getJoStlJbCd() {
        return this.joStlJbCd;
    }

    /**
	 * Column Info
	 * @return revYrmonTo
	 */
    public String getRevYrmonTo() {
        return this.revYrmonTo;
    }

    /**
	 * Column Info
	 * @param exeYrmon
	 */
    public void setExeYrmon(String exeYrmon) {
        this.exeYrmon = exeYrmon;
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
	 * @param joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * Column Info
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param revYrmonFr
	 */
    public void setRevYrmonFr(String revYrmonFr) {
        this.revYrmonFr = revYrmonFr;
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
	 * @param estmCondFlg
	 */
    public void setEstmCondFlg(String estmCondFlg) {
        this.estmCondFlg = estmCondFlg;
    }

    /**
	 * Column Info
	 * @param reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * Column Info
	 * @param diffOption
	 */
    public void setDiffOption(String diffOption) {
        this.diffOption = diffOption;
    }

    /**
	 * Column Info
	 * @param joStlJbCd
	 */
    public void setJoStlJbCd(String joStlJbCd) {
        this.joStlJbCd = joStlJbCd;
    }

    /**
	 * Column Info
	 * @param revYrmonTo
	 */
    public void setRevYrmonTo(String revYrmonTo) {
        this.revYrmonTo = revYrmonTo;
    }

    public void setJoStlItmCds(String joStlItmCds) {
        this.joStlItmCds = joStlItmCds;
    }

    public String getJoStlItmCds() {
        return this.joStlItmCds;
    }

    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    public void setVoyDaysCd(String voyDaysCd) {
        this.voyDaysCd = voyDaysCd;
    }

    public String getVoyDaysCd() {
        return this.voyDaysCd;
    }

    public void setChkInclude(String chkInclude) {
        this.chkInclude = chkInclude;
    }

    public String getChkInclude() {
        return this.chkInclude;
    }

    public void setJoStlItmFlg(String joStlItmFlg) {
        this.joStlItmFlg = joStlItmFlg;
    }

    public String getJoStlItmFlg() {
        return this.joStlItmFlg;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setCreFlg(String creFlg) {
        this.creFlg = creFlg;
    }

    public String getCreFlg() {
        return this.creFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
        setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
        setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setRevYrmonFr(JSPUtil.getParameter(request, "rev_yrmon_fr", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setEstmCondFlg(JSPUtil.getParameter(request, "estm_cond_flg", ""));
        setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
        setDiffOption(JSPUtil.getParameter(request, "diff_option", ""));
        setJoStlJbCd(JSPUtil.getParameter(request, "jo_stl_jb_cd", ""));
        setRevYrmonTo(JSPUtil.getParameter(request, "rev_yrmon_to", ""));
        setJoStlItmCds(JSPUtil.getParameter(request, "jo_stl_itm_cds", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
        setVoyDaysCd(JSPUtil.getParameter(request, "voy_days_cd", ""));
        setChkInclude(JSPUtil.getParameter(request, "chk_include", ""));
        setJoStlItmFlg(JSPUtil.getParameter(request, "jo_stl_itm_flg", ""));
        setPageNo(JSPUtil.getParameter(request, "page_no", ""));
        setCreFlg(JSPUtil.getParameter(request, "cre_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmConditionVO[]
	 */
    public EstmConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmConditionVO[]
	 */
    public EstmConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EstmConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] revYrmonFr = (JSPUtil.getParameter(request, prefix + "rev_yrmon_fr", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] estmCondFlg = (JSPUtil.getParameter(request, prefix + "estm_cond_flg", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] diffOption = (JSPUtil.getParameter(request, prefix + "diff_option", length));
            String[] joStlJbCd = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", length));
            String[] revYrmonTo = (JSPUtil.getParameter(request, prefix + "rev_yrmon_to", length));
            String[] joStlItmCds = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cds", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] voyDaysCd = (JSPUtil.getParameter(request, prefix + "voy_days_cd", length));
            String[] chkInclude = (JSPUtil.getParameter(request, prefix + "chk_include", length));
            String[] joStlItmFlg = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_flg", length));
            String[] pageNo = (JSPUtil.getParameter(request, prefix + "page_no", length));
            String[] creFlg = (JSPUtil.getParameter(request, prefix + "cre_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EstmConditionVO();
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (revYrmonFr[i] != null)
                    model.setRevYrmonFr(revYrmonFr[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (estmCondFlg[i] != null)
                    model.setEstmCondFlg(estmCondFlg[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (diffOption[i] != null)
                    model.setDiffOption(diffOption[i]);
                if (joStlJbCd[i] != null)
                    model.setJoStlJbCd(joStlJbCd[i]);
                if (revYrmonTo[i] != null)
                    model.setRevYrmonTo(revYrmonTo[i]);
                if (joStlItmCds[i] != null)
                    model.setJoStlItmCds(joStlItmCds[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (voyDaysCd[i] != null)
                    model.setVoyDaysCd(voyDaysCd[i]);
                if (chkInclude[i] != null)
                    model.setChkInclude(chkInclude[i]);
                if (joStlItmFlg[i] != null)
                    model.setJoStlItmFlg(joStlItmFlg[i]);
                if (pageNo[i] != null)
                    model.setPageNo(pageNo[i]);
                if (creFlg[i] != null) 
		    		model.setCreFlg(creFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEstmConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return EstmConditionVO[]
	 */
    public EstmConditionVO[] getEstmConditionVOs() {
        EstmConditionVO[] vos = (EstmConditionVO[]) models.toArray(new EstmConditionVO[models.size()]);
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
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmonFr = this.revYrmonFr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCondFlg = this.estmCondFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffOption = this.diffOption.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbCd = this.joStlJbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmonTo = this.revYrmonTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCds = this.joStlItmCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voyDaysCd = this.voyDaysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkInclude = this.chkInclude.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmFlg = this.joStlItmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageNo = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creFlg = this.creFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
