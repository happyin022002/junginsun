/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlCntClauseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.07.24 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlCntClauseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select BL Country Clause from BKG_BL_CLUZ_STUP
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlCntClauseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlCntClauseRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	LISTAGG(CMDT_DESC, CHR(13)||CHR(10)) WITHIN GROUP (ORDER BY ORD) AS CMDT_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT	CMDT_DESC" ).append("\n"); 
		query.append("            ,CASE 	WHEN ORG_CNT_CD = @[por_cnt_cd] THEN 1" ).append("\n"); 
		query.append("                    WHEN ORG_CNT_CD = @[pol_cnt_cd] THEN 2" ).append("\n"); 
		query.append("                    WHEN ORG_CNT_CD = @[pod_cnt_cd] THEN 3" ).append("\n"); 
		query.append("                    ELSE 4 END AS ORD" ).append("\n"); 
		query.append("    FROM	BKG_BL_CLUZ_STUP" ).append("\n"); 
		query.append("    WHERE	0=0" ).append("\n"); 
		query.append("    AND		(" ).append("\n"); 
		query.append("            (ORG_CNT_CD = @[por_cnt_cd] AND POR_APPL_FLG = 'Y')" ).append("\n"); 
		query.append("        OR	(ORG_CNT_CD = @[pol_cnt_cd] AND POL_APPL_FLG = 'Y')" ).append("\n"); 
		query.append("        OR	(ORG_CNT_CD = @[pod_cnt_cd] AND POD_APPL_FLG = 'Y')" ).append("\n"); 
		query.append("        OR	(ORG_CNT_CD = @[del_cnt_cd] AND DEL_APPL_FLG = 'Y')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}