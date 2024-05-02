/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchTrspLegNmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchTrspLegNmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRSP_LEG_NM Search.
	  * </pre>
	  */
	public Edi315SendDBDAOSearchTrspLegNmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchTrspLegNmInfoRSQL").append("\n"); 
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
		query.append("SELECT SEQ" ).append("\n"); 
		query.append("      , CASE WHEN ACTIVITY_IND1 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'N' AND ACTIVITY_IND4 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'N' AND ACTIVITY_IND4 = 'N' AND ACTIVITY_IND5 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N' END ACTIVITY_IND" ).append("\n"); 
		query.append("       , TRANS_MODE      " ).append("\n"); 
		query.append("  FROM (SELECT SCD.COP_DTL_SEQ SEQ" ).append("\n"); 
		query.append("               , CASE WHEN @[edi_sts_cd] = 'D' OR @[edi_sts_cd] = 'AG'  -- COP에 없는 I/B Delivery Case 처리" ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                   NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.ACT_CD = 'FITZAD'-- 상수" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ), 'N')  ELSE 'N' END ACTIVITY_IND1   " ).append("\n"); 
		query.append("             , CASE WHEN (SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.STND_EDI_STS_CD = @[edi_sts_cd] /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) " ).append("\n"); 
		query.append("               IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND2-- 0715 로직 변경" ).append("\n"); 
		query.append("              , CASE WHEN (SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.ACT_CD = @[edi_sts_cd] /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) " ).append("\n"); 
		query.append("               IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND3-- 0715 로직 변경" ).append("\n"); 
		query.append("               , CASE  WHEN (SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND SUBSTR(A.STND_EDI_STS_CD, 1,1) = SUBSTR(@[edi_sts_cd], 1,1) /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) " ).append("\n"); 
		query.append("               IS NULL THEN 'N' ELSE 'Y'  END ACTIVITY_IND4" ).append("\n"); 
		query.append("               , CASE  WHEN (SELECT DECODE(ACT_STS_CD,'F','Y','N')" ).append("\n"); 
		query.append("                          FROM SCE_COP_DTL" ).append("\n"); 
		query.append("                         WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                           AND COP_DTL_SEQ = ( SELECT COP_DTL_SEQ" ).append("\n"); 
		query.append("                                                  FROM(SELECT ROW_NUMBER() OVER(PARTITION BY B.CNTR_NO ORDER BY C.COP_DTL_SEQ DESC) RN" ).append("\n"); 
		query.append("                                                             ,COP_DTL_SEQ" ).append("\n"); 
		query.append("                                                          FROM SCE_COP_HDR B" ).append("\n"); 
		query.append("                                                             , SCE_COP_DTL C" ).append("\n"); 
		query.append("                                                         WHERE B.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                                                           AND B.COP_STS_CD IN ('C','T','F')" ).append("\n"); 
		query.append("                                                           AND B.COP_NO = C.COP_NO" ).append("\n"); 
		query.append("                                                           AND C.ACT_STS_CD = 'F' " ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                                                 WHERE RN = 1" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                           AND COP_DTL_SEQ = SCD.COP_DTL_SEQ ) " ).append("\n"); 
		query.append("               IS NULL THEN 'N'  ELSE 'Y'  END ACTIVITY_IND5 -- 0729 로직 변경" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(SCD.ACT_CD, 3,1),'W','F',SUBSTR(SCD.ACT_CD, 3,1)) AS TRANS_MODE" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("             , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("         WHERE SCH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND SCH.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("           AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("           AND SCD.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("           AND SUBSTR(SCD.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5)" ).append("\n"); 
		query.append("         ORDER BY ACTIVITY_IND1 desc, ACTIVITY_IND2 desc,  ACTIVITY_IND3 desc, ACTIVITY_IND4 desc, ACTIVITY_IND5 desc" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("WHERE CASE WHEN ACTIVITY_IND1 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'N' AND ACTIVITY_IND4 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'N' AND ACTIVITY_IND4 = 'N' AND ACTIVITY_IND5 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N' END = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = '1'" ).append("\n"); 

	}
}