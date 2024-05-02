/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOAddAproHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOAddAproHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History 테이블에 이력을 등록한다.
	  * </pre>
	  */
	public EacMgtDBDAOAddAproHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_apro_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOAddAproHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_APRO_STEP(EAC_NO" ).append("\n"); 
		query.append("                                    , APRO_STEP_SEQ" ).append("\n"); 
		query.append("                                    , APRO_OFC_CD" ).append("\n"); 
		query.append("                                    , APRO_USR_ID" ).append("\n"); 
		query.append("                                    , EAC_STS_CD" ).append("\n"); 
		query.append("                                    , LOCL_CRE_DT" ).append("\n"); 
		query.append("                                    , EAC_APRO_RSN" ).append("\n"); 
		query.append("                                    , CRE_USR_ID" ).append("\n"); 
		query.append("                                    , CRE_DT" ).append("\n"); 
		query.append("                                    , UPD_USR_ID" ).append("\n"); 
		query.append("                                    , UPD_DT" ).append("\n"); 
		query.append("                                    )VALUES(" ).append("\n"); 
		query.append("                                     @[eac_no]       " ).append("\n"); 
		query.append("                                    , NVL((SELECT MAX(APRO_STEP_SEQ)" ).append("\n"); 
		query.append("                                           FROM EAS_EXPN_AUD_CS_APRO_STEP" ).append("\n"); 
		query.append("                                           WHERE EAC_NO = @[eac_no]), 0) + 1" ).append("\n"); 
		query.append("                                    ,@[ofc_cd]  " ).append("\n"); 
		query.append("                                    ,@[usr_id]  " ).append("\n"); 
		query.append("                                    ,@[eac_sts_cd]   " ).append("\n"); 
		query.append("                                    , globaldate_pkg.time_local_ofc_fnc(@[ofc_cd]) " ).append("\n"); 
		query.append("                                    ,@[eac_apro_rsn] " ).append("\n"); 
		query.append("                                    ,@[usr_id]   " ).append("\n"); 
		query.append("                                    ,SYSDATE" ).append("\n"); 
		query.append("                                    ,@[usr_id]   " ).append("\n"); 
		query.append("                                    ,SYSDATE" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}