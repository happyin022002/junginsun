/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.13
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.13 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lloyd, vessel name, ETA, ETD등 Vessel 정보를 조회해옴-local
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT @[d_type] AS D_TYPE" ).append("\n"); 
		query.append("      ,@[vvd_cd] AS VVD_CD" ).append("\n"); 
		query.append("      ,@[port_cd] AS PORT_CD" ).append("\n"); 
		query.append("      ,EUR_VSL_ID VSL_CD  --Vessel Code" ).append("\n"); 
		query.append("      ,VSL_ENG_NM           --Vessel Name" ).append("\n"); 
		query.append("      ,VSL_CNT_CD           --Vessel Flag" ).append("\n"); 
		query.append("      ,LLOYD_NO             --Lloyd code" ).append("\n"); 
		query.append("      ,CALL_SGN_NO          --Call Sign" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(ETA_DT, 'YYYYMMDD'), '')   AS ETA_D    --Arrival DATE" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(ETA_DT, 'HH24MI'), '')     AS ETA_T    --Arrival TIME" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(ETD_DT,'YYYYMMDD'),' ')    AS ETD_D    --Departure DATE" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(ETD_DT,'HH24MI'),' ')      AS ETD_T    --Departure TIME" ).append("\n"); 
		query.append("      ,BRTH_YD_CD                                         --Berth" ).append("\n"); 
		query.append("      ,BRTH_YD_NM AS YD_NM" ).append("\n"); 
		query.append("      ,NVL(SVC_RQST_NO, (SELECT MAX(VSL_CALL_REF_NO)" ).append("\n"); 
		query.append("                         FROM BKG_CSTMS_RTM_VSL" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         AND VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                         AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                         AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1))) AS SVC_RQST_NO -- CRN NO." ).append("\n"); 
		query.append("      ,'Y' AS LOCAL_DB_YN" ).append("\n"); 
		query.append("      ,NVL(SPCL_CGO_PRNR_CLZ_FLG,'N') AS SPCL_CGO_PRNR_CLZ_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(" FROM BKG_CSTMS_EUR_DG_VSL_SKD" ).append("\n"); 
		query.append("WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("  AND VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("  AND SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  AND PORT_CD           = @[port_cd]" ).append("\n"); 

	}
}