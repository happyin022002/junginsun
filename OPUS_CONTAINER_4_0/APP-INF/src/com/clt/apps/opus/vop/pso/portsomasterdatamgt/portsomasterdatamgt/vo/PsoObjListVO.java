/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsoObjListVO.java
*@FileTitle : PsoObjListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.15 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
public class PsoObjListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PsoObjListVO> models = new ArrayList<PsoObjListVO>();

    private List<PsoObjListVO> list1 = new ArrayList<PsoObjListVO>();

    private List<PsoObjListVO> list2 = new ArrayList<PsoObjListVO>();

    private List<PsoObjListVO> list3 = new ArrayList<PsoObjListVO>();

    private List<PsoObjListVO> list4 = new ArrayList<PsoObjListVO>();

    /* Column Info */
    private String rn = null;

    /* Column Info */
    private String psoMeasUtCdDsp = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String psoOfcCd = null;

    /* Column Info */
    private String psoMeasUtCd = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String psoObjCdDsp = null;

    /* Column Info */
    private String objListNm = null;

    /* Column Info */
    private String objListNo = null;

    /* Column Info */
    private String psoObjCd = null;

    /* Column Info */
    private String rowNo = null;

    /* Column Info */
    private String psoObjListTpCd = null;

    /* Column Info */
    private String objListAbbrNm = null;

    /* Column Info */
    private String fomlUsedYn = null;

    /* Column Info */
    private String condUsedYn = null;

    /* Column Info */
    private String ydUsedYn = null;

    /* Column Info */
    private String dfltCtnt = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String ydLinkYn = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public PsoObjListVO() {
    }

    public PsoObjListVO(String ibflag, String pagerows, String rn, String objListNo, String psoObjCdDsp, String psoObjCd, String objListNm, String psoMeasUtCdDsp, String psoMeasUtCd, String psoOfcCd, String creUsrId, String rowNo, String creDt, String psoObjListTpCd, String objListAbbrNm, String fomlUsedYn, String condUsedYn, String ydUsedYn, String dfltCtnt, String diffRmk, String ydLinkYn) {
        this.rn = rn;
        this.psoMeasUtCdDsp = psoMeasUtCdDsp;
        this.creDt = creDt;
        this.psoOfcCd = psoOfcCd;
        this.psoMeasUtCd = psoMeasUtCd;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.creUsrId = creUsrId;
        this.psoObjCdDsp = psoObjCdDsp;
        this.objListNm = objListNm;
        this.objListNo = objListNo;
        this.psoObjCd = psoObjCd;
        this.rowNo = rowNo;
        this.psoObjListTpCd = psoObjListTpCd;
        this.objListAbbrNm = objListAbbrNm;
        this.fomlUsedYn = fomlUsedYn;
        this.condUsedYn = condUsedYn;
        this.ydUsedYn = ydUsedYn;
        this.dfltCtnt = dfltCtnt;
        this.diffRmk = diffRmk;
        this.ydLinkYn = ydLinkYn;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rn", getRn());
        this.hashColumns.put("pso_meas_ut_cd_dsp", getPsoMeasUtCdDsp());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("pso_ofc_cd", getPsoOfcCd());
        this.hashColumns.put("pso_meas_ut_cd", getPsoMeasUtCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("pso_obj_cd_dsp", getPsoObjCdDsp());
        this.hashColumns.put("obj_list_nm", getObjListNm());
        this.hashColumns.put("obj_list_no", getObjListNo());
        this.hashColumns.put("pso_obj_cd", getPsoObjCd());
        this.hashColumns.put("row_no", getRowNo());
        this.hashColumns.put("pso_obj_list_tp_cd", getPsoObjListTpCd());
        this.hashColumns.put("obj_list_abbr_nm", getObjListAbbrNm());
        this.hashColumns.put("foml_used_yn", getFomlUsedYn());
        this.hashColumns.put("cond_used_yn", getCondUsedYn());
        this.hashColumns.put("yd_used_yn", getYdUsedYn());
        this.hashColumns.put("dflt_ctnt", getDfltCtnt());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("yd_link_yn", getYdLinkYn());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rn", "rn");
        this.hashFields.put("pso_meas_ut_cd_dsp", "psoMeasUtCdDsp");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("pso_ofc_cd", "psoOfcCd");
        this.hashFields.put("pso_meas_ut_cd", "psoMeasUtCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("pso_obj_cd_dsp", "psoObjCdDsp");
        this.hashFields.put("obj_list_nm", "objListNm");
        this.hashFields.put("obj_list_no", "objListNo");
        this.hashFields.put("pso_obj_cd", "psoObjCd");
        this.hashFields.put("row_no", "rowNo");
        this.hashFields.put("pso_obj_list_tp_cd", "psoObjListTpCd");
        this.hashFields.put("obj_list_abbr_nm", "objListAbbrNm");
        this.hashFields.put("foml_used_yn", "fomlUsedYn");
        this.hashFields.put("cond_used_yn", "condUsedYn");
        this.hashFields.put("yd_used_yn", "ydUsedYn");
        this.hashFields.put("dflt_ctnt", "dfltCtnt");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("yd_link_yn", "ydLinkYn");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rn
	 */
    public String getRn() {
        return this.rn;
    }

    /**
	 * Column Info
	 * @return psoMeasUtCdDsp
	 */
    public String getPsoMeasUtCdDsp() {
        return this.psoMeasUtCdDsp;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return psoOfcCd
	 */
    public String getPsoOfcCd() {
        return this.psoOfcCd;
    }

    /**
	 * Column Info
	 * @return psoMeasUtCd
	 */
    public String getPsoMeasUtCd() {
        return this.psoMeasUtCd;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return psoObjCdDsp
	 */
    public String getPsoObjCdDsp() {
        return this.psoObjCdDsp;
    }

    /**
	 * Column Info
	 * @return objListNm
	 */
    public String getObjListNm() {
        return this.objListNm;
    }

    /**
	 * Column Info
	 * @return objListNo
	 */
    public String getObjListNo() {
        return this.objListNo;
    }

    /**
	 * Column Info
	 * @return psoObjCd
	 */
    public String getPsoObjCd() {
        return this.psoObjCd;
    }

    /**
	 * Column Info
	 * @return rowNo
	 */
    public String getRowNo() {
        return this.rowNo;
    }

    /**
	 * Column Info
	 * @return psoObjListTpCd
	 */
    public String getPsoObjListTpCd() {
        return this.psoObjListTpCd;
    }

    /**
	 * Column Info
	 * @return objListAbbrNm
	 */
    public String getObjListAbbrNm() {
        return this.objListAbbrNm;
    }

    /**
	 * Column Info
	 * @param rn
	 */
    public void setRn(String rn) {
        this.rn = rn;
    }

    /**
	 * Column Info
	 * @param psoMeasUtCdDsp
	 */
    public void setPsoMeasUtCdDsp(String psoMeasUtCdDsp) {
        this.psoMeasUtCdDsp = psoMeasUtCdDsp;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param psoOfcCd
	 */
    public void setPsoOfcCd(String psoOfcCd) {
        this.psoOfcCd = psoOfcCd;
    }

    /**
	 * Column Info
	 * @param psoMeasUtCd
	 */
    public void setPsoMeasUtCd(String psoMeasUtCd) {
        this.psoMeasUtCd = psoMeasUtCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param psoObjCdDsp
	 */
    public void setPsoObjCdDsp(String psoObjCdDsp) {
        this.psoObjCdDsp = psoObjCdDsp;
    }

    /**
	 * Column Info
	 * @param objListNm
	 */
    public void setObjListNm(String objListNm) {
        this.objListNm = objListNm;
    }

    /**
	 * Column Info
	 * @param objListNo
	 */
    public void setObjListNo(String objListNo) {
        this.objListNo = objListNo;
    }

    /**
	 * Column Info
	 * @param psoObjCd
	 */
    public void setPsoObjCd(String psoObjCd) {
        this.psoObjCd = psoObjCd;
    }

    /**
	 * Column Info
	 * @param rowNo
	 */
    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    /**
	 * Column Info
	 * @param psoObjListTpCd
	 */
    public void setPsoObjListTpCd(String psoObjListTpCd) {
        this.psoObjListTpCd = psoObjListTpCd;
    }

    /**
	 * Column Info
	 * @param objListAbbrNm
	 */
    public void setObjListAbbrNm(String objListAbbrNm) {
        this.objListAbbrNm = objListAbbrNm;
    }

    public void setFomlUsedYn(String fomlUsedYn) {
        this.fomlUsedYn = fomlUsedYn;
    }

    public String getFomlUsedYn() {
        return this.fomlUsedYn;
    }

    public void setCondUsedYn(String condUsedYn) {
        this.condUsedYn = condUsedYn;
    }

    public String getCondUsedYn() {
        return this.condUsedYn;
    }

    public void setYdUsedYn(String ydUsedYn) {
        this.ydUsedYn = ydUsedYn;
    }

    public String getYdUsedYn() {
        return this.ydUsedYn;
    }

    public void setDfltCtnt(String dfltCtnt) {
        this.dfltCtnt = dfltCtnt;
    }

    public String getDfltCtnt() {
        return this.dfltCtnt;
    }

    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    public String getDiffRmk() {
        return this.diffRmk;
    }

    public void setYdLinkYn(String ydLinkYn) {
        this.ydLinkYn = ydLinkYn;
    }

    public String getYdLinkYn() {
        return this.ydLinkYn;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setRn(JSPUtil.getParameter(request, "rn", ""));
        setPsoMeasUtCdDsp(JSPUtil.getParameter(request, "pso_meas_ut_cd_dsp", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setPsoOfcCd(JSPUtil.getParameter(request, "pso_ofc_cd", ""));
        setPsoMeasUtCd(JSPUtil.getParameter(request, "pso_meas_ut_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setPsoObjCdDsp(JSPUtil.getParameter(request, "pso_obj_cd_dsp", ""));
        setObjListNm(JSPUtil.getParameter(request, "obj_list_nm", ""));
        setObjListNo(JSPUtil.getParameter(request, "obj_list_no", ""));
        setPsoObjCd(JSPUtil.getParameter(request, "pso_obj_cd", ""));
        setRowNo(JSPUtil.getParameter(request, "row_no", ""));
        setPsoObjListTpCd(JSPUtil.getParameter(request, "pso_obj_list_tp_cd", ""));
        setObjListAbbrNm(JSPUtil.getParameter(request, "obj_list_abbr_nm", ""));
        setFomlUsedYn(JSPUtil.getParameter(request, "foml_used_yn", ""));
        setCondUsedYn(JSPUtil.getParameter(request, "cond_used_yn", ""));
        setYdUsedYn(JSPUtil.getParameter(request, "yd_used_yn", ""));
        setDfltCtnt(JSPUtil.getParameter(request, "dflt_ctnt", ""));
        setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
        setYdLinkYn(JSPUtil.getParameter(request, "yd_link_yn", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoObjListVO[]
	 */
    public PsoObjListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoObjListVO[]
	 */
    public PsoObjListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PsoObjListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rn = (JSPUtil.getParameter(request, prefix + "rn", length));
            String[] psoMeasUtCdDsp = (JSPUtil.getParameter(request, prefix + "pso_meas_ut_cd_dsp", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] psoOfcCd = (JSPUtil.getParameter(request, prefix + "pso_ofc_cd", length));
            String[] psoMeasUtCd = (JSPUtil.getParameter(request, prefix + "pso_meas_ut_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] psoObjCdDsp = (JSPUtil.getParameter(request, prefix + "pso_obj_cd_dsp", length));
            String[] objListNm = (JSPUtil.getParameter(request, prefix + "obj_list_nm", length));
            String[] objListNo = (JSPUtil.getParameter(request, prefix + "obj_list_no", length));
            String[] psoObjCd = (JSPUtil.getParameter(request, prefix + "pso_obj_cd", length));
            String[] rowNo = (JSPUtil.getParameter(request, prefix + "row_no", length));
            String[] psoObjListTpCd = (JSPUtil.getParameter(request, prefix + "pso_obj_list_tp_cd", length));
            String[] objListAbbrNm = (JSPUtil.getParameter(request, prefix + "obj_list_abbr_nm", length));
            String[] fomlUsedYn = (JSPUtil.getParameter(request, prefix + "foml_used_yn", length));
            String[] condUsedYn = (JSPUtil.getParameter(request, prefix + "cond_used_yn", length));
            String[] ydUsedYn = (JSPUtil.getParameter(request, prefix + "yd_used_yn", length));
            String[] dfltCtnt = (JSPUtil.getParameter(request, prefix + "dflt_ctnt", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] ydLinkYn = (JSPUtil.getParameter(request, prefix + "yd_link_yn", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PsoObjListVO();
                if (rn[i] != null)
                    model.setRn(rn[i]);
                if (psoMeasUtCdDsp[i] != null)
                    model.setPsoMeasUtCdDsp(psoMeasUtCdDsp[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (psoOfcCd[i] != null)
                    model.setPsoOfcCd(psoOfcCd[i]);
                if (psoMeasUtCd[i] != null)
                    model.setPsoMeasUtCd(psoMeasUtCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (psoObjCdDsp[i] != null)
                    model.setPsoObjCdDsp(psoObjCdDsp[i]);
                if (objListNm[i] != null)
                    model.setObjListNm(objListNm[i]);
                if (objListNo[i] != null)
                    model.setObjListNo(objListNo[i]);
                if (psoObjCd[i] != null)
                    model.setPsoObjCd(psoObjCd[i]);
                if (rowNo[i] != null)
                    model.setRowNo(rowNo[i]);
                if (psoObjListTpCd[i] != null)
                    model.setPsoObjListTpCd(psoObjListTpCd[i]);
                if (objListAbbrNm[i] != null)
                    model.setObjListAbbrNm(objListAbbrNm[i]);
                if (fomlUsedYn[i] != null)
                    model.setFomlUsedYn(fomlUsedYn[i]);
                if (condUsedYn[i] != null)
                    model.setCondUsedYn(condUsedYn[i]);
                if (ydUsedYn[i] != null)
                    model.setYdUsedYn(ydUsedYn[i]);
                if (dfltCtnt[i] != null)
                    model.setDfltCtnt(dfltCtnt[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (ydLinkYn[i] != null) 
		    		model.setYdLinkYn(ydLinkYn[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPsoObjListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PsoObjListVO[]
	 */
    public PsoObjListVO[] getPsoObjListVOs() {
        PsoObjListVO[] vos = (PsoObjListVO[]) models.toArray(new PsoObjListVO[models.size()]);
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
        this.rn = this.rn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoMeasUtCdDsp = this.psoMeasUtCdDsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoOfcCd = this.psoOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoMeasUtCd = this.psoMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoObjCdDsp = this.psoObjCdDsp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objListNm = this.objListNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objListNo = this.objListNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoObjCd = this.psoObjCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rowNo = this.rowNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psoObjListTpCd = this.psoObjListTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.objListAbbrNm = this.objListAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fomlUsedYn = this.fomlUsedYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.condUsedYn = this.condUsedYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydUsedYn = this.ydUsedYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dfltCtnt = this.dfltCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLinkYn = this.ydLinkYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }

    public void setList1(List<PsoObjListVO> list1) {
        this.list1 = list1;
    }

    public List<PsoObjListVO> getList1() {
        return list1;
    }

    public void setList2(List<PsoObjListVO> list2) {
        this.list2 = list2;
    }

    public List<PsoObjListVO> getList2() {
        return list2;
    }

    public void setList3(List<PsoObjListVO> list3) {
        this.list3 = list3;
    }

    public List<PsoObjListVO> getList3() {
        return list3;
    }

    public void setList4(List<PsoObjListVO> list4) {
        this.list4 = list4;
    }

    public List<PsoObjListVO> getList4() {
        return list4;
    }
}
