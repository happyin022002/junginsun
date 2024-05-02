/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgBlNoDupChkVO.java
*@FileTitle : BkgBlNoDupChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.23 김영출
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김영출
 * @since J2EE 1.5
 */

public class CmCopyVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CmCopyVO> models = new ArrayList<CmCopyVO>();

    /* Status */
    private String ibflag = null;
    /* Column Info */
    private String mfCfmFlg = null;
    /* Column Info */
    private String bkgNoSplit = null;
    /* Column Info */
    private String cntrNo = null;
    /* Column Info */
    private String bkgNo = null;
    /* Page Number */
    private String pagerows = null;
    /* Column Info */
    private String cntrTpszCd = null;

    /*  hashColumnInpo  */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*  hashFildInpo    */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CmCopyVO() {}

    public CmCopyVO(String ibflag, String pagerows, String bkgNo, String bkgNoSplit, String cntrNo, String cntrTpszCd, String mfCfmFlg) {
        this.ibflag = ibflag;
        this.mfCfmFlg = mfCfmFlg;
        this.bkgNoSplit = bkgNoSplit;
        this.cntrNo = cntrNo;
        this.bkgNo = bkgNo;
        this.pagerows = pagerows;
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
     * hashColumnInpo
     * @return HashMap
     */
    public HashMap<String, String> getColumnValues(){
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("mf_cfm_flg", getMfCfmFlg());
        this.hashColumns.put("bkg_no_split", getBkgNoSplit());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        return this.hashColumns;
    }

    /**
     * hashFildInpo
     * @return
     */
    public HashMap<String, String> getFieldNames(){
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("mf_cfm_flg", "mfCfmFlg");
        this.hashFields.put("bkg_no_split", "bkgNoSplit");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        return this.hashFields;
    }

    public String getIbflag() {
        return this.ibflag;
    }
    public String getMfCfmFlg() {
        return this.mfCfmFlg;
    }
    public String getBkgNoSplit() {
        return this.bkgNoSplit;
    }
    public String getCntrNo() {
        return this.cntrNo;
    }
    public String getBkgNo() {
        return this.bkgNo;
    }
    public String getPagerows() {
        return this.pagerows;
    }
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
        //this.ibflag=true;
    }
    public void setMfCfmFlg(String mfCfmFlg) {
        this.mfCfmFlg = mfCfmFlg;
        //this.mfCfmFlg=true;
    }
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
        //this.bkgNoSplit=true;
    }
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
        //this.cntrNo=true;
    }
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
        //this.bkgNo=true;
    }
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
        //this.pagerows=true;
    }
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
        //this.cntrTpszCd=true;
    }
    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setMfCfmFlg(JSPUtil.getParameter(request, "mf_cfm_flg", ""));
        setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
        setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
    }

    public CmCopyVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public CmCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CmCopyVO model = null;

        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if(tmp == null)
            return null;

        int length = request.getParameterValues(prefix + "ibflag").length;

        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] mfCfmFlg = (JSPUtil.getParameter(request, prefix   + "mf_cfm_flg".trim(), length));
            String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix + "bkg_no_split".trim(), length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no".trim(), length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix  + "bkg_no".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix   + "pagerows".trim(), length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd".trim(), length));

            for (int i = 0; i < length; i++) {
                model = new CmCopyVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (mfCfmFlg[i] != null)
                    model.setMfCfmFlg(mfCfmFlg[i]);
                if (bkgNoSplit[i] != null)
                    model.setBkgNoSplit(bkgNoSplit[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                models.add(model);
            }

        } catch (Exception e) {}
        return getCmCopyVOs();
    }

    public CmCopyVO[] getCmCopyVOs(){
        CmCopyVO[] vos = (CmCopyVO[])models.toArray(new CmCopyVO[models.size()]);
        return vos;
    }

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
        } catch (Exception ex) {}
        return ret.toString();
    }

    /**
     * 각 클래스 해당하는 필드 정보를 배열에 담는다
     * @param field
     * @param i
     * @return String[]
     * @throws IllegalAccessException
     */
    private String[] getField(Field[] field, int i) throws IllegalAccessException {
        String[] arr;
        try{
            arr = (String[]) field[i].get(this);
        }catch(Exception ex){
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }

    /**
    * DataFormat 설정
    */
    public void onDataFormat(){
        this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfCfmFlg = this.mfCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
