/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdEas0340ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-09
*@LastModifier : 최종혁
*@LastVersion : 1.2
* 2015-06-09 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.common.util.EasDefaultViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 최종혁
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdEas0340ViewAdapter extends EasDefaultViewAdapter {
 
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix, Event event)
	{
		FormCommand	 formcommand	= event.getFormCommand();
		StringBuilder sbufXML = new StringBuilder();
        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(vo.getMaxRows() > 0)
            totCnt = vo.getMaxRows();

        if( formcommand.isCommand(FormCommand.MULTI01) ){
        	sbufXML.append("<RESULT><TR-ALL> OK </TR-ALL></RESULT>");
        }else if( formcommand.isCommand(FormCommand.SEARCHLIST01) ){
        	String colName = "";
        	//boolean editableYn  = false;
        	sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
            for(int i = 0; i < realCnt; i++)
            {
                Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
                String sExpnAudStsCd = getNull(colValues.get("expn_aud_sts_cd")).toString();
                String sExpnAudStsCdFlg = sExpnAudStsCd.length()==1?"Y":"N";
                String sAutoAudStsCd = getNull(colValues.get("auto_aud_sts_cd")).toString();
                String sAutoAudStsCdFlg = "";
                String sSelAudCd = "";
                String sIbflag = "";
                String sInvDiffAmtFlg = getNull(colValues.get("inv_diff_amt_flg")).toString();
                String sNoAgmtFlg = getNull(colValues.get("no_agmt_flg")).toString();
                String sNoOptmRoutFlg = getNull(colValues.get("no_optm_rout_flg")).toString();
                String sExceedAvgFlg = getNull(colValues.get("exceed_avg_flg")).toString();
                String sBatProgStsCd = getNull(colValues.get("bat_prog_sts_cd")).toString();
                
                //미심사 건중 Auto Audit 상태가 S:Coincidence는 자동 체크하고 Select는 P:Coincidence로 표시한다.
                //미심사 건중 Auto Audit 상태가 F:Discrepancy는 자동 체크하고 Select는 E:Potential EAC로 표시한다.
                if ( (sAutoAudStsCd.equals("S") ) && sExpnAudStsCdFlg.equals("N") ) {
                	sAutoAudStsCdFlg = "1";
                	sSelAudCd = "P";
                	sIbflag = "I";
                }else if ( (sAutoAudStsCd.equals("F") ) && sExpnAudStsCdFlg.equals("N") ) {
                    	sAutoAudStsCdFlg = "1";
                    	sSelAudCd = "E";
                    	sIbflag = "I";
                }else{
                	sAutoAudStsCdFlg = "0";
                	sSelAudCd = "";
                	sIbflag = "";
                }
                
                sbufXML.append("\t<TR")
                          .append(sExpnAudStsCdFlg.equals("Y")?" COLOR='100,100,100'":"")
                          .append(sExpnAudStsCdFlg.equals("Y")?" BGCOLOR='245,235,245'":"")
                          .append(">");

                int colCnt = realColNms.length; 
                //심사 완료된 자료는 비활성화
//                if( sExpnAudStsCd.equals("P") ||  sExpnAudStsCd.equals("P") ) {
//                	editableYn = true;
//                } else {
//                	editableYn = true;
//                }
                
                for(int j = 0; j < colCnt ; j++) {
                	colName =  (String)realColNms[j];
                	if (colName.equals("chk")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sBatProgStsCd.equals("P")?" BGCOLOR='255, 190, 130'":"")
                				.append(">")
                				.append(sAutoAudStsCdFlg)
                				.append("</TD>").toString());
                	}else if (colName.equals("ibflag")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(">")
                				.append(sIbflag)
                				.append("</TD>").toString());
                	}else if (colName.equals("sel_aud_cd")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				//.append(editableYn?"":" EDIT='FALSE'")
                				.append("><![CDATA[")
                				.append(sSelAudCd)
                				.append("]]></TD>").toString());
                	}else if (colName.equals("inv_diff_amt")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sInvDiffAmtFlg.equals("Y")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("no_agmt_flg")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sNoAgmtFlg.equals("N")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("no_optm_rout_flg")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sNoOptmRoutFlg.equals("N")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("exceed_avg_diff_amt")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sExceedAvgFlg.equals("Y")?" COLOR='255, 0, 0'":"")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else{
                		if (getNull(colValues.get(realColNms[j])).toString().length()>0) {
                			sbufXML.append("<TD><![CDATA[");
                			sbufXML.append(getNull(colValues.get(realColNms[j])).toString());
                			sbufXML.append("]]></TD>");
                		}else{
                			sbufXML.append((new StringBuilder()).append("<TD></TD>"));
                		}
                	}
                }
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("</TR>\n").toString());
            }
        }else if( formcommand.isCommand(FormCommand.SEARCHLIST02) ){
        	String colName = "";
        	boolean editableYn  = false;
        	sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
            for(int i = 0; i < realCnt; i++)
            {
                Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();

                String sInvDiffAmtFlg = getNull(colValues.get("inv_diff_amt_flg")).toString();
                String sNoAgmtFlg = getNull(colValues.get("no_agmt_flg")).toString();
                String sNoOptmRoutFlg = getNull(colValues.get("no_optm_rout_flg")).toString();
                String sExceedAvgFlg = getNull(colValues.get("exceed_avg_flg")).toString();               
                String sInvDiffRto = getNull(colValues.get("inv_diff_rto")).toString();
                String sExceedAvgRto = getNull(colValues.get("exceed_avg_rto")).toString();
                String sEacIfFlg = getNull(colValues.get("eac_if_flg")).toString();
                //심사 완료된 자료는 비활성화
                if( sEacIfFlg.equals("Y") ) {
                	editableYn = false;
                } else {
                	editableYn = true;
                }
                
                sbufXML.append("\t<TR>");
                int colCnt = realColNms.length; 
                for(int j = 0; j < colCnt ; j++) {
                	colName =  (String)realColNms[j];
                	if (colName.equals("chk")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(editableYn?"":" EDIT='FALSE'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("inv_diff_amt")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sInvDiffAmtFlg.equals("Y")?" COLOR='255, 0, 0'" : sInvDiffRto.equals("")?" COLOR='0, 255, 0'" : " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("no_agmt_flg")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sNoAgmtFlg.equals("N")?" COLOR='255, 0, 0'" : " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("no_optm_rout_flg")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sNoOptmRoutFlg.equals("N")?" COLOR='255, 0, 0'" : " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("exceed_avg_diff_amt")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append(sExceedAvgFlg.equals("Y")?" COLOR='255, 0, 0'" : sExceedAvgRto.equals("")?" COLOR='0, 255, 0'" : " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("so_no")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append( " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("bkg_no")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append( " COLOR='0, 0, 255'")
                				.append(">")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("</TD>").toString());
                	}else if (colName.equals("etc_scg_nm")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append( " COLOR='0, 0, 255'")
                				.append("><![CDATA[")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("]]></TD>").toString());
                	}else if (colName.equals("inv_etc_scg_nm")) {
                		sbufXML.append((new StringBuilder())
                				.append("<TD")
                				.append( " COLOR='0, 0, 255'")
                				.append("><![CDATA[")
                				.append(JSPUtil.getNull(getNull(colValues.get(realColNms[j])).toString()))
                				.append("]]></TD>").toString());
                	}else{
                		if (getNull(colValues.get(realColNms[j])).toString().length()>0) {
                			sbufXML.append("<TD><![CDATA[");
                			sbufXML.append(getNull(colValues.get(realColNms[j])).toString());
                			sbufXML.append("]]></TD>");
                		}else{
                			sbufXML.append((new StringBuilder()).append("<TD></TD>"));
                		}
                	}
                }
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("</TR>\n").toString());
            }
        }else{
        	sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
            for(int i = 0; i < realCnt; i++)
            {
                Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
                sbufXML.append("\t<TR><![CDATA[");
                int colCnt = realColNms.length;
                for(int j = 0; j < colCnt - 1; j++)
                    sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
            }
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
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
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            if( formcommand.isCommand(FormCommand.MULTI) ){
              	sb.append("<RESULT><TR-ALL> OK </TR-ALL></RESULT>");
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
