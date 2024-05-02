/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoTrfAtchFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoTrfAtchFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPsoTrfAtchFileList
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoTrfAtchFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoTrfAtchFileListRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         RANK() OVER(PARTITION BY YD_CHG_NO  ORDER BY UPD_DT DESC) AS RANK_CD," ).append("\n"); 
		query.append("         A.* FROM (" ).append("\n"); 
		query.append("         SELECT  T1.YD_CHG_NO" ).append("\n"); 
		query.append("               ,T1.ATCH_FILE_DIV_CD" ).append("\n"); 
		query.append("               ,T2.FILE_SAV_ID" ).append("\n"); 
		query.append("               ,T2.FILE_UPLD_NM     AS FILE_NM" ).append("\n"); 
		query.append("               ,T2.FILE_SZ_CAPA     AS FILE_SIZE" ).append("\n"); 
		query.append("               ,T2.FILE_PATH_URL    AS FILE_PATH" ).append("\n"); 
		query.append("               ,TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD')   AS UPD_DT" ).append("\n"); 
		query.append("               ,DECODE(T1.CTRT_SCR_FLG, 'Y', 1, 0) AS CTRT_SCR_FLG" ).append("\n"); 
		query.append("         FROM  PSO_TRF_ATCH_FILE T1" ).append("\n"); 
		query.append("               ,COM_UPLD_FILE T2" ).append("\n"); 
		query.append("         WHERE  T1.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("           AND  T1.ATCH_FILE_DIV_CD = @[atch_file_div_cd]" ).append("\n"); 
		query.append("           AND  T1.FILE_SAVE_ID = T2.FILE_SAV_ID" ).append("\n"); 
		query.append("           AND  T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if(${atchFileAuth} != 'Y') " ).append("\n"); 
		query.append("   		   AND  T1.CTRT_SCR_FLG = 'N' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        ORDER BY T2.UPD_DT DESC" ).append("\n"); 
		query.append("    ) A " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RANK_CD = 1" ).append("\n"); 

	}
}