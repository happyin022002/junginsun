/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT A.MSG_SND_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.SND_DT, 'YYYY-MM-DD HH24:MI') AS SND_DT," ).append("\n"); 
		query.append("       A.SND_USR_ID," ).append("\n"); 
		query.append("       A.MSG_FUNC_ID," ).append("\n"); 
		query.append("       A.PSA_DG_DECL_TP_CD," ).append("\n"); 
		query.append("       A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("       A.PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PSA_DG_SND A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${snd_dt_from} != '')" ).append("\n"); 
		query.append("   AND A.SND_DT BETWEEN TO_DATE(REPLACE(@[snd_dt_from], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[snd_dt_to], '-', ''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY MSG_SND_NO DESC," ).append("\n"); 
		query.append("       SND_DT DESC," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       PORT_CD" ).append("\n"); 

	}
}