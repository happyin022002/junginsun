/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOSearchMnrOnsiteInspectionHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOSearchMnrOnsiteInspectionHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Onsite Inspection History 조회
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOSearchMnrOnsiteInspectionHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOSearchMnrOnsiteInspectionHistoryRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 DISTINCT" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON') " ).append("\n"); 
		query.append("         A.YD_CD AS CD_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON1') " ).append("\n"); 
		query.append("         A.YD_CD||'('||A.VNDR_SEQ||')' AS CD_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,TO_CHAR(A.FLD_INSP_DT,'YYYY-MM-DD') AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_ONSITE_INSP_RSLT A" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON1') " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT WK_ST_DT, WK_END_DT FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR = TO_NUMBER(SUBSTR(@[searchkey], 1, 4))" ).append("\n"); 
		query.append("AND PLN_WK = TO_NUMBER(SUBSTR(@[searchkey], 5, 2))" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON') " ).append("\n"); 
		query.append(" 	WHERE A.VNDR_SEQ = TO_NUMBER(SUBSTR(@[searchkey], 1, 6))" ).append("\n"); 
		query.append("    AND   A.INSP_OFC_CD   = SUBSTR(@[searchkey], 7)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON1') " ).append("\n"); 
		query.append(" 	WHERE A.INSP_OFC_CD   IN (SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.DELT_FLG != 'Y' START WITH A.OFC_CD = SUBSTR(@[searchkey], 7, 5) CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD)" ).append("\n"); 
		query.append("    AND   A.FLD_INSP_DT BETWEEN TO_DATE(B.WK_ST_DT, 'YYYY-MM-DD')+0.0 AND TO_DATE(B.WK_END_DT, 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("    AND   A.VNDR_SEQ LIKE '%'||SUBSTR(@[searchkey], 12,5)||'%'" ).append("\n"); 
		query.append("    AND   A.FILE_SEQ != 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(A.FLD_INSP_DT,'YYYY-MM-DD') DESC" ).append("\n"); 

	}
}