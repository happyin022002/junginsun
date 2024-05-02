/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchCallYdIndSeqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCallYdIndSeqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCallYdIndSeqList
	  * </pre>
	  */
	public TESCommonDBDAOSearchCallYdIndSeqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCallYdIndSeqListRSQL").append("\n"); 
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
		query.append("#if (${vsl_cd} == 'CNTC') " ).append("\n"); 
		query.append("SELECT '1' CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    (SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(CALL_YD_IND_SEQ,'|')),'|')" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT ROWNUM ROW_ID," ).append("\n"); 
		query.append("               V.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND     V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND     V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND     V.VPS_PORT_CD = SUBSTR(@[yd_cd],0,5)" ).append("\n"); 
		query.append("		AND		V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("    START WITH ROW_ID = 1    " ).append("\n"); 
		query.append("    ) CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}