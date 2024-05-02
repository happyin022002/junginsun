/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0052ViewAdapter.java
*@FileTitle      : Portion Adjusted Figure Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.10.21
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.10.21 CSQ USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.controller.DefaultViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author CSQ USER
 * @see ViewAdapter 참조
 * @since CSQ USER
 */
public class EsmCsq0052ViewAdapter extends DefaultViewAdapter {
    /**
     *  EsmCsq0052ViewAdapter.<br>
     */
    public EsmCsq0052ViewAdapter(){
        super();
    }

    /**
     * VO List 를 Parsing 하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
     *
     * @param vos List<AbstractValueObject> List 객체
     * @param prefix String IBSheet savename's prefix
     * @return String <Data>태그 부분의 XML문자열
     * @exception
     */
    protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
        StringBuilder sbufXML = new StringBuilder();
        int totCnt  = vos.size();
        int realCnt = vos.size();

        sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");

        String cng_tp     = "";
        String gubun      = "";
        String trBgColor  = "";

        for(int i=0;i<realCnt;i++){
            Map<String, String> colValues = vos.get(i).getColumnValues();
            cng_tp        = getNull(colValues.get("csq_cng_tp_cd"));
            gubun         = getNull(colValues.get("gubun"));

            if ( !cng_tp.equals("I")) {
                trBgColor = "";
            } else {
                trBgColor = "BGCOLOR='255,255,255'";
            }

            sbufXML.append("<TR "+trBgColor+">");
            sbufXML.append("<TD></TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("bse_yr"))       + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("bse_qtr_cd"))   + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("ob_div_cd"))    + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("ofc_vw_cd"))   + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("trd_cd"))       + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("sub_trd_cd"))   + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("rlane_cd"))     + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("dir_cd"))       + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("conv_dir_cd"))  + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("bse_wk"))       + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("vvd"))          + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("rhq_cd"))       + "</TD>");
            if ( gubun.equals("RHQ")) {
            sbufXML.append("<TD>" + getNull(colValues.get("rgn_ofc_cd"))   + "</TD>");
            }
            sbufXML.append("<TD>" + getNull(colValues.get("lod_potn_rto")) + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("lod_qty"))      + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("rev_potn_rto")) + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("grs_rev"))      + "</TD>");
            sbufXML.append("<TD>" + getNull(colValues.get("csq_cng_tp_cd"))+ "</TD>");
            sbufXML.append("</TR>\n");
        }
        sbufXML.append("</DATA>\n");

        return sbufXML.toString();
    }

}