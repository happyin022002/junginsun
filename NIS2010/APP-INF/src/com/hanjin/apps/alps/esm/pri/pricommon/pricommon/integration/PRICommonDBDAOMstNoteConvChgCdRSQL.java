/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAOMstNoteConvChgCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOMstNoteConvChgCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA의 Route Note Conversion 코드를 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOMstNoteConvChgCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOMstNoteConvChgCdRSQL").append("\n"); 
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
		query.append("SELECT ' ' CD, ' \t' NM, '0' AS ODR FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- RAS 코드 삭제 요청." ).append("\n"); 
		query.append("--SELECT    A.NOTE_CONV_RULE_CD CD" ).append("\n"); 
		query.append("--        , A.NOTE_CONV_RULE_CD || '\t' || A.NOTE_CONV_RULE_NM NM" ).append("\n"); 
		query.append("--        , '1' AS ODR" ).append("\n"); 
		query.append("--	 FROM PRI_NOTE_CONV_RULE A" ).append("\n"); 
		query.append("--    	, PRI_NOTE_CONV_TP_RULE_MAPG B" ).append("\n"); 
		query.append("--	WHERE A.NOTE_CONV_RULE_CD = B.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("--	  AND B.PRC_CTRT_TP_CD = [etc1]" ).append("\n"); 
		query.append("--	  AND B.NOTE_CONV_TP_CD = [etc2]" ).append("\n"); 
		query.append("--      AND A.NOTE_CONV_RULE_CD = [etc3]" ).append("\n"); 
		query.append("--UNION ALL" ).append("\n"); 
		query.append("SELECT A1.CHG_CD AS CD" ).append("\n"); 
		query.append("      ,A1.CHG_CD || '\t' || B1.CHG_NM AS NM" ).append("\n"); 
		query.append("      , '2' AS ODR" ).append("\n"); 
		query.append("  FROM PRI_SCG_PRF A1" ).append("\n"); 
		query.append("      ,MDM_CHARGE B1" ).append("\n"); 
		query.append(" WHERE A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("   AND A1.SVC_SCP_CD = @[etc4]" ).append("\n"); 
		query.append("   AND B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY ODR" ).append("\n"); 

	}
}