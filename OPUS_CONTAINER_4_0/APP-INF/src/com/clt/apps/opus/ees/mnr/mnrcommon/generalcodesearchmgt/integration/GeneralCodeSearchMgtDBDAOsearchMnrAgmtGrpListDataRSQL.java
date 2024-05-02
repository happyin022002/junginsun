/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtGrpListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrAgmtGrpListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrAgmtGrpListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtGrpListDataRSQL").append("\n"); 
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
		query.append("SELECT DECODE(EQ_TP, 1, DECODE(COST_CD, 'RC', 'URC', COST_CD), 2, DECODE(COST_CD, 'RC', 'ZRC', COST_CD), 3, DECODE(COST_CD, 'RC', 'GRC', COST_CD)) COST_CD," ).append("\n"); 
		query.append("       DECODE(EQ_TP, 1, 'U-'||TT, 2, 'Z-'||TT, 3, 'G-'||TT) AS COST_CD_NM," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER (ORDER BY EQ_TP, TP) DP_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT DECODE(SUBSTR(A.COST_CD, 5, 2), 'RC', 'RC', A.COST_CD) COST_CD," ).append("\n"); 
		query.append("                       CASE WHEN A.COST_CD LIKE '%RC' THEN 'Repair' ELSE (SELECT DISTINCT MNR_CD_DESC" ).append("\n"); 
		query.append("                                                                            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                                                                           WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                                                                             AND PRNT_CD_ID LIKE '_G') END TT ," ).append("\n"); 
		query.append("               DECODE((SELECT MNR_ORD_TP_CD" ).append("\n"); 
		query.append("                         FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                        WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                          AND PRNT_CD_ID LIKE '_G'), 'LB', 1, 'TS', 2, 'QT', 3, 1) TP," ).append("\n"); 
		query.append("               DECODE((SELECT PRNT_CD_ID" ).append("\n"); 
		query.append("                         FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                        WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                          AND PRNT_CD_ID LIKE '_G'), 'UG', 1, 'ZG', 2, 'GG', 3, 1) EQ_TP" ).append("\n"); 
		query.append("          FROM MNR_AGMT_RT A, MNR_AGMT_HDR B" ).append("\n"); 
		query.append("         WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("#if(${eq_type} != 'A' && ${eq_type} != '')           " ).append("\n"); 
		query.append("           AND B.EQ_KND_CD = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}