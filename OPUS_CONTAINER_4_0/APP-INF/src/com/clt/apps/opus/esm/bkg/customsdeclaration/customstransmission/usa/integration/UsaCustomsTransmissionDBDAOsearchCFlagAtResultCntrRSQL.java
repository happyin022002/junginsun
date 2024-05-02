/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlagAtResultCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.20 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlagAtResultCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlagAtResultCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlagAtResultCntrRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CSTMS_CLR_CD),'N') AS OLD_CNTR_CFLAG" ).append("\n"); 
		query.append("      ,MAX(CSTMS_RMK1) AS OLD_HOLD_REMARK" ).append("\n"); 
		query.append("      ,MAX(DECODE(C.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', 'H', 'A')) AS HOLD" ).append("\n"); 
		query.append("      ,MAX(DECODE(C.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', 'R', 'A')) AS REMV" ).append("\n"); 
		query.append("      ,'' AS IN_VVD" ).append("\n"); 
		query.append("      ,'' AS IN_POD" ).append("\n"); 
		query.append("      ,'' AS OLD_Cntr_C_Flag" ).append("\n"); 
		query.append("      ,'' AS qty69" ).append("\n"); 
		query.append("      ,'' AS irc_Qty" ).append("\n"); 
		query.append("      ,'' AS in_Bl" ).append("\n"); 
		query.append("      ,'' AS icr_Seq" ).append("\n"); 
		query.append("  FROM (SELECT R.CNT_CD, R.CSTMS_CLR_CD, R.CSTMS_RMK1" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CNTR_RSLT R" ).append("\n"); 
		query.append("         WHERE R.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND R.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND R.CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("           AND R.CSTMS_SEQ = (SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                              FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("                             WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                               AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                               AND CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("                               AND CSTMS_CLR_CD IS NOT NULL" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'US', NULL, NULL FROM DUAL" ).append("\n"); 
		query.append("       ) R" ).append("\n"); 
		query.append("      ,BKG_CSTMS_CD_CONV_CTNT C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND R.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("   AND C.ATTR_CTNT3(+) = @[icr_code]" ).append("\n"); 

	}
}