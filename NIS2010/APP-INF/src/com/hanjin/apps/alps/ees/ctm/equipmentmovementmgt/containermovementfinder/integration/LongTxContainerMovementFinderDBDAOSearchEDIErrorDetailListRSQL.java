/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOSearchEDIErrorDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIErrorDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorDetailListRSQL").append("\n"); 
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
		query.append("SELECT E.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("E.EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("E.EDI_GATE_IO_CD," ).append("\n"); 
		query.append("E.EVNT_YD_CD," ).append("\n"); 
		query.append("TO_CHAR (E.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT," ).append("\n"); 
		query.append("TO_CHAR (E.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("DECODE (R.EDI_RMK, NULL, 'There is no error MSG history', R.EDI_RMK) AS MVMT_EDI_RMK" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG E," ).append("\n"); 
		query.append("CTM_EDI_RSLT_RMK R," ).append("\n"); 
		query.append("MST_CONTAINER C" ).append("\n"); 
		query.append("WHERE E.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#if (${rcc} == '' || ${rcc} == 'ALL')" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_AREA_CD IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = SUBSTR (@[rcc], 0, 2)" ).append("\n"); 
		query.append("AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${source_radio} == \"DOM\")" ).append("\n"); 
		query.append("AND SUBSTR (E.EDI_MVMT_STS_CD, 0, 1) = 'C'" ).append("\n"); 
		query.append("#elseif (${source_radio} == \"ITN\")" ).append("\n"); 
		query.append("AND SUBSTR (E.EDI_MVMT_STS_CD, 0, 1) != 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND E.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("AND E.MVMT_EDI_TP_CD = R.MVMT_EDI_TP_CD(+)" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_TP_ID = R.MVMT_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_AREA_CD = R.MVMT_EDI_MSG_AREA_CD(+)" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_YRMONDY = R.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("AND E.MVMT_EDI_MSG_SEQ = R.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 
		query.append("AND R.RTY_KNT(+) = 0" ).append("\n"); 
		query.append("AND E.EVNT_YD_CD = @[yard]" ).append("\n"); 
		query.append("#if (${divide} == \"corr_err\")" ).append("\n"); 
		query.append("AND E.MVMT_EDI_RSLT_CD = 'N'" ).append("\n"); 
		query.append("#elseif (${divide} == \"corr_ok\")" ).append("\n"); 
		query.append("AND E.MVMT_EDI_RSLT_CD = 'Y'" ).append("\n"); 
		query.append("#elseif (${divide} == \"corr_ttl\" || ${divide} == \"init_ttl\")" ).append("\n"); 
		query.append("AND E.MVMT_EDI_RSLT_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("#elseif (${divide} == \"init_err\")" ).append("\n"); 
		query.append("AND E.MVMT_EDI_RSLT_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("AND ((E.RTY_KNT = 0 AND E.MVMT_EDI_RSLT_CD = 'N') OR (E.RTY_KNT > 0))" ).append("\n"); 
		query.append("#elseif (${divide} == \"init_ok\")" ).append("\n"); 
		query.append("AND E.RTY_KNT = 0 AND E.MVMT_EDI_RSLT_CD = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}