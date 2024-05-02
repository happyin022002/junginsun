/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IoRatioVO.java
*@FileTitle : IoRatioVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.30 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class IoRatioVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IoRatioVO> models = new ArrayList<IoRatioVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String turn = null;

    /* Column Info */
    private String obRto = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String rlaneDirCd = null;

    /* Column Info */
    private String ibRto = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String clptSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public IoRatioVO() {
    }

    public IoRatioVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String turn, String slanCd, String vpsPortCd, String rlaneDirCd, String obRto, String ibRto, String rlaneCd, String revYrmon, String clptIndSeq, String clptSeq) {
        this.vslCd = vslCd;
        this.turn = turn;
        this.obRto = obRto;
        this.revYrmon = revYrmon;
        this.skdVoyNo = skdVoyNo;
        this.rlaneCd = rlaneCd;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.ibflag = ibflag;
        this.slanCd = slanCd;
        this.rlaneDirCd = rlaneDirCd;
        this.ibRto = ibRto;
        this.clptIndSeq = clptIndSeq;
        this.clptSeq = clptSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("turn", getTurn());
        this.hashColumns.put("ob_rto", getObRto());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
        this.hashColumns.put("ib_rto", getIbRto());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("clpt_seq", getClptSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("turn", "turn");
        this.hashFields.put("ob_rto", "obRto");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
        this.hashFields.put("ib_rto", "ibRto");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("clpt_seq", "clptSeq");
        return this.hashFields;
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
	 * @return turn
	 */
    public String getTurn() {
        return this.turn;
    }

    /**
	 * Column Info
	 * @return obRto
	 */
    public String getObRto() {
        return this.obRto;
    }

    /**
	 * Column Info
	 * @return revYrmon
	 */
    public String getRevYrmon() {
        return this.revYrmon;
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
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return rlaneDirCd
	 */
    public String getRlaneDirCd() {
        return this.rlaneDirCd;
    }

    /**
	 * Column Info
	 * @return ibRto
	 */
    public String getIbRto() {
        return this.ibRto;
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
	 * @param turn
	 */
    public void setTurn(String turn) {
        this.turn = turn;
    }

    /**
	 * Column Info
	 * @param obRto
	 */
    public void setObRto(String obRto) {
        this.obRto = obRto;
    }

    /**
	 * Column Info
	 * @param revYrmon
	 */
    public void setRevYrmon(String revYrmon) {
        this.revYrmon = revYrmon;
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
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
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

    /**
	 * Column Info
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param rlaneDirCd
	 */
    public void setRlaneDirCd(String rlaneDirCd) {
        this.rlaneDirCd = rlaneDirCd;
    }

    /**
	 * Column Info
	 * @param ibRto
	 */
    public void setIbRto(String ibRto) {
        this.ibRto = ibRto;
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

    public void fromRequest(HttpServletRequest request, String prefix) {
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setTurn(JSPUtil.getParameter(request, prefix + "turn", ""));
        setObRto(JSPUtil.getParameter(request, prefix + "ob_rto", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setRlaneDirCd(JSPUtil.getParameter(request, prefix + "rlane_dir_cd", ""));
        setIbRto(JSPUtil.getParameter(request, prefix + "ib_rto", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IoRatioVO[]
	 */
    public IoRatioVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IoRatioVO[]
	 */
    public IoRatioVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IoRatioVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] turn = (JSPUtil.getParameter(request, prefix + "turn", length));
            String[] obRto = (JSPUtil.getParameter(request, prefix + "ob_rto", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix + "rlane_dir_cd", length));
            String[] ibRto = (JSPUtil.getParameter(request, prefix + "ib_rto", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
	    	String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IoRatioVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (turn[i] != null)
                    model.setTurn(turn[i]);
                if (obRto[i] != null)
                    model.setObRto(obRto[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (rlaneDirCd[i] != null)
                    model.setRlaneDirCd(rlaneDirCd[i]);
                if (ibRto[i] != null)
                    model.setIbRto(ibRto[i]);
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
        return getIoRatioVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IoRatioVO[]
	 */
    public IoRatioVO[] getIoRatioVOs() {
        IoRatioVO[] vos = (IoRatioVO[]) models.toArray(new IoRatioVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turn = this.turn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obRto = this.obRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneDirCd = this.rlaneDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibRto = this.ibRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
