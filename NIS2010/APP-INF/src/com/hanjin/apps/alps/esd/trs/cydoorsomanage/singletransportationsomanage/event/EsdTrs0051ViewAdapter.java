/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdTrs0051ViewAdapter.java
*@FileTitle : EsdTrs0051ViewAdapter Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2011-11-02
*@LastModifier : 민정호
*@LastVersion : 1.2
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.01.06 민정호 1.1 [CHM_201108116] Single Transportaion S/O 관리(USA, EUR)
* 2011.11.02 민정호 1.2 [CHM-201114318] [TRS] 선택된 Row 표현 구분방식 변경 + D7 (AK) SPC cargo 표현로직 제거 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SoProcVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0051ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event)
	{
		int totCnt = 0;
		String strOfccd = "";
		StringBuilder sb = new StringBuilder();
		FormCommand	 formcommand	= event.getFormCommand();
		try{
			if( formcommand.isCommand(FormCommand.SEARCH19) ){
				SoProcVO listVO = new SoProcVO();
				sb.append("<DATA TOTAL='" + totCnt +"'>\n");

				for(int m=0; m<vos.size(); m++) {
					AbstractValueObject vo = (AbstractValueObject)vos.get(m) ;
					ObjectCloner.build(vo, listVO);
					sb.append("<TR>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getRtnValue()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustCntCd()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustSeq()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustAddrSeq()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPstCd()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryNm()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryAddr()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPhnNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryFaxNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustFctryPicNo()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustEml()) + "</TD>");
					sb.append("\n<TD>" + JSPUtil.getNull(listVO.getActCustRmk()) + "</TD>");
					sb.append("</TR> ");
				}
				sb.append("</DATA>\n");
			}else{
				SingleTransportationVO listVO = new SingleTransportationVO();
				event.getSignOnUserAccount().getOfc_cd();
				totCnt = vos.size();
				if( event.getSignOnUserAccount().getOfc_cd().length() > 2 ) {
					strOfccd = event.getSignOnUserAccount().getOfc_cd().substring(0,3);
				}
				event.getSignOnUserAccount().getOfc_cd();
				totCnt = vos.size();
				sb.append("<DATA TOTAL='" + totCnt +"'>\n");
				for(int m=0; m<vos.size(); m++) {
					AbstractValueObject vo = (AbstractValueObject)vos.get(m) ;
					ObjectCloner.build(vo, listVO);
					listVO.getTrspSoSeq();
					sb.append("<TR>");
					sb.append("\n<TD>" + strOfccd + "</TD>");
					sb.append("\n<TD>" + listVO.getTrspSoSeq() + "</TD>");
					sb.append("</TR> ");
				}
				sb.append("</DATA>\n");
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {
    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
//            String usr_id = event.getSignOnUserAccount().getUsr_id();
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            if( formcommand.isCommand(FormCommand.SEARCH10) ){ // W/O Issue
            	sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            	int colCount = realColNms.length;
            	String colName = "";
            	String sFcolor = "";

                String sTpsz = "";
                String sSpcl = "";
                float fLbsw  = 0;    //CNTR_LBS_WGT
                String sFmnd = "";
                String eq_no = "";
                String sbkg_sts_cd = "";

                boolean eq_seqp   = false;
                
                for(; rs.next(); )
            	{
                    sSpcl                 = JSPUtil.getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
                    sTpsz                 = JSPUtil.getNull(rs.getString("EQ_TPSZ_CD")); 
                    fLbsw                 = rs.getFloat("CNTR_LBS_WGT"); 
                    sFmnd                 = JSPUtil.getNull(rs.getString("fm_nod_cd"));
					eq_no 		          = JSPUtil.getNull(rs.getString("EQ_NO"));
					sbkg_sts_cd           = JSPUtil.getNull(rs.getString("BKG_STS_CD"));
                    
                    if( sFmnd.length() > 2 ) sFmnd = sFmnd.substring(0,2);

                    sFcolor = "";
                                        
                    if( sFmnd.equals("US") ) { 
                      if( ( sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0 ) ) ||  
                             (sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) ) || 
                             (sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) ) || 
                             (sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) )  ){ // 2009.03.11 추가 TP/SZ가 D2 이면서 38.000 LBS 이상 또는 D4/D5/D7 이면서 44.000 LBS 이상 데이터는  전체 row data를 파란색으로 표시                  
                          sFcolor = " COLOR='BLUE'";
                      }
                      
                      if ( sSpcl.equals("DG") || sSpcl.equals("RF") || ( sSpcl.equals("AK") && !sTpsz.equals("D7")) ) {   //2009.03.11 추가 CNTR의 special 정보중 DG/RF/AK 는 전체 row data를 빨간색으로 표시                    	  
                          sFcolor = " COLOR='RED'";
                      }                      
                    }

					if( "".equals(eq_no) && "X".equals(sbkg_sts_cd) ) {
						eq_seqp = true;
					} else {
						eq_seqp = false;
					}
					
                    sb.append((new StringBuilder())
                    		.append("\n<TR")
                    		.append(sFcolor))
                    		.append(">");
            		for(int j = 1; j < colCount+1; j++) {
            			colName = rs.getMetaData().getColumnName(j);
            			if (colName.equals("FM_NOD_CD") || colName.equals("FM_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("FM_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_CD") || colName.equals("VIA_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("VIA_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_CD") || colName.equals("TO_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("TO_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_CD") || colName.equals("DOR_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("DOR_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("FM_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("FM_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("FM_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("VIA_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("TO_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("DOR_NOD_YARD")))
            						.append("</TD>").toString());
            			} else if( colName.equals("DOR_SVC_TP_CD") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(" COMBO-TEXT='UNDECIDED|LIVE LOAD|LIVE UNLOAD|STREET TURN|DROP AND PICK'")
            						.append(" COMBO-CODE='UD|LL|LU|ST|DP'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			} else if( colName.equals("EQ_NO") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(eq_seqp?"TRUE":"FALSE").append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("TRSP_CRR_MOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append("<![CDATA[")
            						.append(JSPUtil.getNull(rs.getObject("TRSP_CRR_MOD_CD")))
            						.append("]]></TD>").toString());
            			}else if (colName.equals("SEALNO") || colName.equals("SEALNO2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append("<![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						.append("]]>")
            						.append("</TD>").toString());
            			}else if( colName.equals("SHPR_CUST_NM") || colName.equals("CNEE_CUST_NM") || colName.equals("NTFY_CUST_NM") 
            					|| colName.equals("SCREMARK") || colName.equals("SPCL_INSTR_RMK") || colName.equals("CMDT_NAME") 
            					|| colName.equals("DOR_DE_ADDR") || colName.equals("FCTRY_NM") || colName.equals("CNTC_PSON_PHN_NO") 
            					|| colName.equals("CNTC_PSON_FAX_NO") || colName.equals("CNTC_PSON_NM") || colName.equals("DOR_PST_CD") 
            					|| colName.equals("TRNS_RQST_RSN") || colName.equals("TRO_LOD_REF_NO") 
            					|| colName.equals("CNG_RSN_DESC") || colName.equals("CNG_RSN_DESC2")
            					) {		// 20100106 추가 : TRNS_RQST_RSN  
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append("><![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			}else if(colName.equals("INTER_RMK")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append("><![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			}else{
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append("FALSE").append("'")
            						.append(">")
            						//.append("<![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						//.append("]]>")
            						.append("</TD>").toString());
            			}
            		}
            		sb.append("</TR>");
            	}

                sb.append("\n</DATA>\n");
                return sb.toString();
            }else if( formcommand.isCommand(FormCommand.SEARCHLIST) ){ // W/O Not Issue
            	sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            	
            	int colCount = realColNms.length;
            	String colName = "";
            	String sFcolor = "";
            	
        		String sTrsp_crr_mod_cd = "";
        		String sTrsp_cost_dtl_mod_cd = "";
            	String sTpsz = "";
            	String sSpcl = "";
            	float fLbsw  = 0;    //CNTR_LBS_WGT
            	String sFmnd = "";
				String sTrsp_so_cmb_seq = "";
				String eq_no = "";
				String sbkg_sts_cd = "";

				boolean bCmb_seq  = false;
            	boolean bCrr_mod  = false;
            	boolean bTrsp_mod = false;
            	boolean eq_seqp = false;

            	for(; rs.next(); )
            	{
            		sTrsp_crr_mod_cd      = JSPUtil.getNull(rs.getString("TRSP_CRR_MOD_CD"));
            		sTrsp_cost_dtl_mod_cd = JSPUtil.getNull(rs.getString("TRSP_COST_DTL_MOD_CD"));
            		sSpcl                 = JSPUtil.getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
            		sTpsz                 = JSPUtil.getNull(rs.getString("EQ_TPSZ_CD")); 
            		fLbsw                 = rs.getFloat("CNTR_LBS_WGT"); 
            		sFmnd                 = JSPUtil.getNull(rs.getString("fm_nod_cd")); 
					sTrsp_so_cmb_seq      = JSPUtil.getNull(rs.getString("TRSP_SO_CMB_SEQ"));
					eq_no                 = JSPUtil.getNull(rs.getString("EQ_NO"));
					sbkg_sts_cd           = JSPUtil.getNull(rs.getString("BKG_STS_CD"));
            		
            		if( sFmnd.length() > 2 ) sFmnd = sFmnd.substring(0,2);

            		sFcolor = "";
            		if( sFmnd.equals("US") ) { 
            			if( ( sTpsz.equals("D2") && (Float.compare(fLbsw, 38000.0000F) >= 0 ) ) || 
            					(sTpsz.equals("D4") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) ) || 
            					(sTpsz.equals("D5") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) ) || 
            					(sTpsz.equals("D7") && (Float.compare(fLbsw, 44000.0000F) >= 0 ) )  ){ // 2009.03.11 추가 TP/SZ가 D2 이면서 38.000 LBS 이상 또는 D4/D5/D7 이면서 44.000 LBS 이상 데이터는  전체 row data를 파란색으로 표시                  
            				sFcolor = " COLOR='BLUE'";
            			}

            			if ( sSpcl.equals("DG") || sSpcl.equals("RF") || ( sSpcl.equals("AK") && !sTpsz.equals("D7"))  ) {   //2009.03.11 추가 CNTR의 special 정보중 DG/RF/AK 는 전체 row data를 빨간색으로 표시   
            				sFcolor = " COLOR='RED'";
            			}
            		}

					eq_seqp = false;
					//Combined로 묶인 경우는 수정이 불가능 해야 한다.
					if( sTrsp_so_cmb_seq.length() > 0 ) {
						bCmb_seq = true;
					} else {
						bCmb_seq = false;
					}
            		
            		//Transportation Mode가 Direct일 경우는 수정이 불가능해야 한다.
            		if( sTrsp_crr_mod_cd.indexOf("D") >= 0 ) {
            			bCrr_mod = true;
            		} else {
            			bCrr_mod = false;
            		}

            		if( sTrsp_cost_dtl_mod_cd.equals("DOOR") ) {
            			bTrsp_mod = false;
            		} else {
            			bTrsp_mod = true;
            		}
            		
					if( bCmb_seq ) {
						bCrr_mod = true;
						bTrsp_mod = true;
					}
					if( eq_no.equals("") && sbkg_sts_cd.equals("X") ) {
						eq_seqp = true;
					} else {
						eq_seqp = false;
					}

                    sb.append((new StringBuilder())
                    		.append("\n<TR")
                    		.append(sTrsp_crr_mod_cd.equals("WD")?" BGCOLOR='238,255,226'":"")
                    		.append(sFcolor))
                    		.append(">");

            		for(int j = 1; j < colCount+1; j++) {
            			colName = rs.getMetaData().getColumnName(j);

            			if (colName.equals("FM_NOD_CD") || colName.equals("FM_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCmb_seq?"FALSE":"").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("FM_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_CD") || colName.equals("VIA_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCrr_mod?"FALSE":"").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("VIA_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_CD") || colName.equals("TO_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCmb_seq?"FALSE":"").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("TO_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_CD") || colName.equals("DOR_NOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bTrsp_mod?"FALSE":"").append("'")
            						.append(">")
            						.append(getNull(rs.getObject("DOR_NOD_CD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("FM_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCmb_seq?"FALSE":"").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("FM_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("FM_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCrr_mod?"FALSE":"").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("VIA_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("VIA_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bCmb_seq?"FALSE":"").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("TO_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("TO_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_YARD")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bTrsp_mod?"FALSE":"").append("'")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("DOR_NOD_YARD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD>")
            						.append(JSPUtil.getNull(rs.getObject("DOR_NOD_YARD")))
            						.append("</TD>").toString());
            			}else if( colName.equals("SHPR_CUST_NM") || colName.equals("CNEE_CUST_NM") || colName.equals("NTFY_CUST_NM") 
            					|| colName.equals("SCREMARK") || colName.equals("SPCL_INSTR_RMK") || colName.equals("INTER_RMK")
            					|| colName.equals("TRNS_RQST_RSN") || colName.equals("TRO_LOD_REF_NO") 
            					|| colName.equals("CNG_RSN_DESC") || colName.equals("CNG_RSN_DESC2")
            					) {			// 20100106 추가 : TRNS_RQST_RSN
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append("><![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			}else if( colName.equals("CMDT_NAME") ) {	
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append("><![CDATA[")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			}else if( colName.equals("DOR_SVC_TP_CD") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bTrsp_mod?"FALSE":"").append("'")
            						.append(" COMBO-TEXT='UNDECIDED|LIVE LOAD|LIVE UNLOAD|STREET TURN|DROP AND PICK'")
            						.append(" COMBO-CODE='UD|LL|LU|ST|DP'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if( colName.equals("DOR_DE_ADDR") || colName.equals("FCTRY_NM") || colName.equals("CNTC_PSON_PHN_NO") 
            					|| colName.equals("CNTC_PSON_FAX_NO") || colName.equals("CNTC_PSON_NM") || colName.equals("DOR_PST_CD") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(bTrsp_mod?"FALSE":"").append("'")
            						.append("><![CDATA[")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("]]></TD>").toString());
            			}else if( colName.equals("LST_LOC_CD") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" COMBO-TEXT='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(" COMBO-CODE='").append(JSPUtil.getNull(rs.getObject(j))).append("'")
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			} else if( colName.equals("EQ_NO") ) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(" EDIT='").append(eq_seqp?"TRUE":"FALSE").append("'")
            						.append(sFcolor)
            						.append(">")
            						.append(JSPUtil.getNull(rs.getObject(j)))
            						.append("</TD>").toString());
            			}else if (colName.equals("TRSP_CRR_MOD_CD2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append("<![CDATA[")
            						.append(JSPUtil.getNull(rs.getObject("TRSP_CRR_MOD_CD")))
            						.append("]]></TD>").toString());
            			}else if (colName.equals("SEALNO")||colName.equals("SEALNO2")) {
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						.append("<![CDATA[")
            						.append(getNull(rs.getObject(j)))
            						.append("]]>")
            						.append("</TD>").toString());
            			}else{
            				sb.append((new StringBuilder())
            						.append("<TD")
            						.append(">")
            						//.append("<![CDATA[")
            						.append(getNull(rs.getObject(j)))
    						        //.append("]]>")
    						        .append("</TD>").toString());
            			}
            		}
            		sb.append("</TR>");
            	}

            	sb.append("\n</DATA>\n");
            	return sb.toString(); 
            }else{
            	sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            	int colCount = realColNms.length;
            	for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString()))
            	{
            		sb.append("\t<TR><![CDATA[");
            		for(int j = 1; j < colCount; j++)
            			sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());

            	}

            	sb.append("</DATA>\n");
            }
        }
        catch(SQLException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

}

