/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanByRCCDOLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.06.13 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOOffHirePlanByRCCDOLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off-hire Plan by RCC 화면에서 DOL 조회
	  * 
	  * 2011.06.13 나상보 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanByRCCDOLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOOffHirePlanByRCCDOLRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN OFFH_LOC_CD IS NULL THEN 0" ).append("\n"); 
		query.append("            WHEN AGMT_NO IS NULL THEN 1" ).append("\n"); 
		query.append("            ELSE 2" ).append("\n"); 
		query.append("       END AS LEVEL_NO" ).append("\n"); 
		query.append("     , OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append("     , NVL(OFFH_LOC_CD, ' ') AS OFFH_LOC_CD" ).append("\n"); 
		query.append("     , NVL(AGMT_NO, ' ')     AS AGMT_NO" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name='CNTR'+$velocityCount+'_QTY')" ).append("\n"); 
		query.append("     , $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT @[loc_cd] AS OFFH_RGN_LOC_CD" ).append("\n"); 
		query.append("#if ( ${loc_tp} == '1' )" ).append("\n"); 
		query.append("              , C.LCC_CD AS OFFH_LOC_CD" ).append("\n"); 
		query.append("#elseif ( ${loc_tp} == '2' )" ).append("\n"); 
		query.append("              , C.SCC_CD AS OFFH_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              , B.AGMT_CTY_CD || LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name='CNTR'+$velocityCount+'_QTY')" ).append("\n"); 
		query.append("              , SUM(DECODE(A.CNTR_TPSZ_CD, '$key', A.AGMT_CHG_VAL, 0)) AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         FROM   LSE_AGMT_RT    A" ).append("\n"); 
		query.append("              ,(SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD" ).append("\n"); 
		query.append("                FROM    LSE_AGREEMENT A," ).append("\n"); 
		query.append("                        MST_CONTAINER B" ).append("\n"); 
		query.append("                WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     A.AGMT_SEQ = B.AGMT_SEQ        " ).append("\n"); 
		query.append("                AND    (B.ACIAC_DIV_CD = 'A' OR  (B.ACIAC_DIV_CD = 'I' " ).append("\n"); 
		query.append("                AND     B.CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("                GROUP BY A.AGMT_CTY_CD, A.AGMT_SEQ, A.LSTM_CD" ).append("\n"); 
		query.append("                ) B        " ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("         WHERE  A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND    A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("         AND    B.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${loc_tp} == '1' )" ).append("\n"); 
		query.append("         AND    C.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif ( ${loc_tp} == '2' )" ).append("\n"); 
		query.append("         AND    C.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND    A.CNTR_RNTL_CHG_TP_CD = 'DOCV'" ).append("\n"); 
		query.append("         AND    A.LOC_CD = C.SCC_CD" ).append("\n"); 
		query.append("         GROUP  BY ROLLUP (" ).append("\n"); 
		query.append("#if ( ${loc_tp} == '1' )" ).append("\n"); 
		query.append("                           C.LCC_CD" ).append("\n"); 
		query.append("#elseif ( ${loc_tp} == '2' )" ).append("\n"); 
		query.append("                           C.SCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         , B.AGMT_CTY_CD || LPAD(B.AGMT_SEQ, 6, '0')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER  BY OFFH_RGN_LOC_CD, NVL(OFFH_LOC_CD, ' '), NVL(AGMT_NO, ' ')" ).append("\n"); 

	}
}