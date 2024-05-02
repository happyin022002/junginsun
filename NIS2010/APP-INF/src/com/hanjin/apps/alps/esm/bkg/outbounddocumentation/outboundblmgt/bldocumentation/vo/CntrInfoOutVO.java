/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrInfoVO.java
*@FileTitle : CntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.20 김영출
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김영출
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class CntrInfoOutVO {

    private static final long serialVersionUID = 1L;

    private Collection<CntrInfoOutVO> models = new ArrayList<CntrInfoOutVO>();

    /* Column Info */
    private List<CntrTpszQtyVO> cntrTpszQtys = null;
    /* Column Info */
    private CntrEtcInfoVO cntrEtcInfo = null;
    /* Column Info */
    private List<BkgCntrSealNoVO> cntrSealNos = null;
    /* Column Info */
    private List<RataBkgQtyVO> rataBkgQtys = null;
    /* Column Info */
    private List<ContainerVO> cntrs = null;
    /* Column Info */
    private CntrPkgWgtVO cntrPkgWgts = null;
    /* Status */
    private String ibflag = null;
    /* Page Number */
    private String pagerows = null;

    private String updUsrId = null;

    private String creUsrId = null;


    public CntrInfoOutVO() {}

    /**
     * Status
     * @return ibflag
     */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
     * Page Number
     * @return pagerows
     */
    public String getPagerows() {
        return this.pagerows;
    }


    /**
     * Status
     * @param ibflag
     */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
     * Page Number
     * @param pagerows
     */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
     *
     * @return
     */
    public String getUpdUsrId() {
        return updUsrId;
    }

    /**
     *
     * @return
     */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
     *
     * @return
     */
    public String getCreUsrId() {
        return creUsrId;
    }

    /**
     *
     * @return
     */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
     *
     * @return
     */
    public List<CntrTpszQtyVO> getCntrTpszQtys() {
        return cntrTpszQtys;
    }

    /**
     *
     * @return
     */
    public void setCntrTpszQtys(List<CntrTpszQtyVO> cntrTpszQtys) {
        this.cntrTpszQtys = cntrTpszQtys;
    }

    /**
     *
     * @return
     */
    public CntrEtcInfoVO getCntrEtcInfo() {
        return cntrEtcInfo;
    }

    /**
     *
     * @return
     */
    public void setCntrEtcInfo(CntrEtcInfoVO cntrEtcInfo) {
        this.cntrEtcInfo = cntrEtcInfo;
    }

    /**
     *
     * @return
     */
    public List<BkgCntrSealNoVO> getCntrSealNos() {
        return cntrSealNos;
    }

    /**
     *
     * @return
     */
    public void setCntrSealNos(List<BkgCntrSealNoVO> cntrSealNos) {
        this.cntrSealNos = cntrSealNos;
    }

    /**
     *
     * @return
     */
    public List<RataBkgQtyVO> getRataBkgQtys() {
        return rataBkgQtys;
    }

    /**
     *
     * @return
     */
    public void setRataBkgQtys(List<RataBkgQtyVO> rataBkgQtys) {
        this.rataBkgQtys = rataBkgQtys;
    }

    /**
     *
     * @return
     */
    public List<ContainerVO> getCntrs() {
        return cntrs;
    }

    /**
     *
     * @return
     */
    public void setCntrs(List<ContainerVO> cntrs) {
        this.cntrs = cntrs;
    }

    /**
     *
     * @return
     */
    public CntrPkgWgtVO getCntrPkgWgts() {
        return cntrPkgWgts;
    }

    /**
     *
     * @return
     */
    public void setCntrPkgWgts(CntrPkgWgtVO cntrPkgWgts) {
        this.cntrPkgWgts = cntrPkgWgts;
    }


    /**
     * 여러 VO Calss를 배열화 한다
     * @return CntrInfoOutVO[]
     */
    public CntrInfoOutVO[] getCntrInfoOutVOs(){
        CntrInfoOutVO[] vos = (CntrInfoOutVO[])models.toArray(new CntrInfoOutVO[models.size()]);
        return vos;
    }

    /**
     * VO Class의 내용을 String으로 변환
     */
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
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
     * 각 클래스 해당하는 필드 정보를 배열에 담는다
     * @param field
     * @param i
     * @return String[]
     */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try{
            arr = (String[]) field[i].get(this);
        }catch(Exception ex){
            arr = getFieldCatct(field, i, arr);
        }
        return arr;
    }

    /**
     * getField 에서 catch문에 대한 로직
     * @param field
     * @param i
     * @param arr
     * @return arr
     */
    private String[] getFieldCatct(Field[] field, int i, String[] arr) {
        try {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        } catch (IllegalAccessException e) {
            return null;
        }
        return arr;
    }

}
