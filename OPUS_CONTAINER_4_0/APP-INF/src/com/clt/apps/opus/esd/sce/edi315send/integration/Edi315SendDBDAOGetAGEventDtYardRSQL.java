/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetAGEventDtYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.03.16 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetAGEventDtYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAGEventDtYard
	  * </pre>
	  */
	public Edi315SendDBDAOGetAGEventDtYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetAGEventDtYardRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("            SELECT H.COP_NO, H.BKG_NO, H.CNTR_NO, H.POD_NOD_CD" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.ACT_CD, 'Y', D.ACT_CD_LAG) ACT_CD" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.ACT_STS_CD, 'Y', D.ACT_STS_CD_LAG) ACT_STS_CD" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.EDI_MSG_TP_CD, 'Y', D.EDI_MSG_TP_CD_LAG) EDI_MSG_TP_CD" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.STND_EDI_STS_CD, 'Y', D.STND_EDI_STS_CD_LAG) CURR_STS" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', TO_CHAR(D.ESTM_DT,'YYYYMMDDHH24MISS'), 'Y', TO_CHAR(D.ESTM_DT_LAG,'YYYYMMDDHH24MISS')) CURR_EVENT_DT" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.COP_DTL_SEQ, 'Y', D.COP_DTL_SEQ_LAG) CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append("                 , DECODE(B.DE_TERM_CD, 'D', D.NOD_CD, 'Y', D.NOD_CD_LAG) CURR_EVENT_YARD" ).append("\n"); 
		query.append("                 , B.DE_TERM_CD" ).append("\n"); 
		query.append("              FROM (SELECT /*+ INDEX_ASC(DTL XPKSCE_COP_DTL) */ " ).append("\n"); 
		query.append("                           DTL.COP_NO, DTL.ACT_CD, DTL.ACT_STS_CD, DTL.EDI_MSG_TP_CD, DTL.STND_EDI_STS_CD" ).append("\n"); 
		query.append("	                      ,(CASE WHEN TO_CHAR(DTL.ESTM_DT,'mi') >= '01' AND TO_CHAR(DTL.ESTM_DT,'mi') <= '30' " ).append("\n"); 
		query.append("    	                              THEN DTL.ESTM_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(DTL.ESTM_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("        	                     WHEN TO_CHAR(DTL.ESTM_DT,'mi') >= '31' AND TO_CHAR(DTL.ESTM_DT,'mi') <= '59' " ).append("\n"); 
		query.append("            	                      THEN DTL.ESTM_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(DTL.ESTM_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                	             ELSE DTL.ESTM_DT " ).append("\n"); 
		query.append("                    	    END) ESTM_DT " ).append("\n"); 
		query.append("                          ,DTL.COP_DTL_SEQ, DTL.NOD_CD" ).append("\n"); 
		query.append("                          ,LAG(ACT_CD) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) ACT_CD_LAG" ).append("\n"); 
		query.append("                          ,LAG(ACT_STS_CD) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) ACT_STS_CD_LAG" ).append("\n"); 
		query.append("                          ,LAG(EDI_MSG_TP_CD) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) EDI_MSG_TP_CD_LAG" ).append("\n"); 
		query.append("                          ,LAG(STND_EDI_STS_CD) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) STND_EDI_STS_CD_LAG" ).append("\n"); 
		query.append("                          ,LAG(CASE WHEN TO_CHAR(DTL.ESTM_DT,'mi') >= '01' AND TO_CHAR(DTL.ESTM_DT,'mi') <= '30' " ).append("\n"); 
		query.append("    	                              THEN DTL.ESTM_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(DTL.ESTM_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("        	                     WHEN TO_CHAR(DTL.ESTM_DT,'mi') >= '31' AND TO_CHAR(DTL.ESTM_DT,'mi') <= '59' " ).append("\n"); 
		query.append("            	                      THEN DTL.ESTM_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(DTL.ESTM_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                	             ELSE DTL.ESTM_DT " ).append("\n"); 
		query.append("                    	    END) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) ESTM_DT_LAG" ).append("\n"); 
		query.append("                          ,LAG(COP_DTL_SEQ) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) COP_DTL_SEQ_LAG" ).append("\n"); 
		query.append("                          ,LAG(NOD_CD) OVER (ORDER BY DTL.COP_NO, DTL.COP_DTL_SEQ) NOD_CD_LAG" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL DTL " ).append("\n"); 
		query.append("                     WHERE DTL.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                   ) D" ).append("\n"); 
		query.append("                 , SCE_COP_HDR H" ).append("\n"); 
		query.append("                 , BKG_BOOKING B" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND D.ACT_CD LIKE CASE WHEN B.DE_TERM_CD = 'D' THEN  'FITZAD%'" ).append("\n"); 
		query.append("                                      ELSE 'FI%DO' END" ).append("\n"); 
		query.append("               AND D.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("               AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             ORDER BY D.COP_DTL_SEQ DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  WHERE ROWNUM = 1" ).append("\n"); 

	}
}