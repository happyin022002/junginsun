/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoMrdIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoMrdIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 출력폼 설정을 위한 정보 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoMrdIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoMrdIdRSQL").append("\n"); 
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
		query.append("SELECT  CTNT.ATTR_CTNT4  || '@@' || CTNT.ATTR_CTNT5||CTNT.ATTR_CTNT6      AS MRD_ID  -- MRD_ID " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("     SELECT FOM.DO_FOM_PRV_CD                                             AS FOM_CD     -- 출력 FORM의 종류 (DO-D/O FORM, BL-B/L FORM, EU-EU FORM)" ).append("\n"); 
		query.append("          , CASE WHEN USR.CONTI_CD IN ('AF','EN','AW','AE') THEN USR.CONTI_CD" ).append("\n"); 
		query.append("                 ELSE '*' END                                             AS CONTI_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , CASE WHEN USR.CNT_CD IN ('KR','JP','IN','VN')   THEN USR.CNT_CD" ).append("\n"); 
		query.append("                 ELSE '*' END                                             AS CNT_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("     FROM BKG_DO_FOM FOM, ( SELECT  MDM.CNT_CD    AS CNT_CD" ).append("\n"); 
		query.append("                                  , ORG.OFC_CD    AS OFC_CD" ).append("\n"); 
		query.append("                                  , MDM.SCONTI_CD AS CONTI_CD" ).append("\n"); 
		query.append("                            FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                                ,MDM_LOCATION     LOC" ).append("\n"); 
		query.append("                                ,MDM_COUNTRY      MDM                           " ).append("\n"); 
		query.append("                            WHERE ORG.OFC_CD    = @[ofc_cd]   " ).append("\n"); 
		query.append("                            AND   LOC.LOC_CD(+) = ORG.LOC_CD   " ).append("\n"); 
		query.append("                            AND   MDM.CNT_CD(+) = LOC.CNT_CD ) USR" ).append("\n"); 
		query.append("     WHERE FOM.OFC_CD = USR.OFC_CD" ).append("\n"); 
		query.append(") DO_FOM_SUB" ).append("\n"); 
		query.append(" ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("WHERE CTNT.HRD_CDG_ID='DO_MRD_ID'  " ).append("\n"); 
		query.append("  AND CTNT.ATTR_CTNT1 = NVL(DO_FOM_SUB.CONTI_CD,'*')    -- CONTINENT CODE" ).append("\n"); 
		query.append("  AND CTNT.ATTR_CTNT2 = NVL(DO_FOM_SUB.CNT_CD,'*')      -- COUNTRY CODE" ).append("\n"); 
		query.append("  AND CTNT.ATTR_CTNT3 = DO_FOM_SUB.FOM_CD" ).append("\n"); 

	}
}