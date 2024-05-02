/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScenarioManageDBDAOMergeNISCurrentVesselSchedulePortCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.09.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAOMergeNISCurrentVesselSchedulePortCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_PORT_SKD 테이블에서 특정VVD의 정보를 EQR_SCNR_VSL_SKD 테이블에 입력/수정
	  * 
	  * 1. 수정이력
	  *    2012.09.19 
	  *    DOUBLE CALLING PORT 수정에서 오류가 발생할수 있는 SQL 수정
	  *    신용찬 수석
	  * </pre>
	  */
	public ScenarioManageDBDAOMergeNISCurrentVesselSchedulePortCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("User_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration").append("\n"); 
		query.append("FileName : ScenarioManageDBDAOMergeNISCurrentVesselSchedulePortCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_VSL_SKD A                               	     	 " ).append("\n"); 
		query.append("USING   (        														 " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            @[scnr_id]  SCNR_ID1,  -- EX) SCEN200824W001  						 " ).append("\n"); 
		query.append("            A.VSL_CD VSL_CD1,												 " ).append("\n"); 
		query.append("            A.SKD_VOY_NO  SKD_VOY_NO1,									 " ).append("\n"); 
		query.append("            A.SKD_DIR_CD  SKD_DIR_CD1,									 " ).append("\n"); 
		query.append("            A.VPS_PORT_CD,  -- VSL_LOC_CD									 " ).append("\n"); 
		query.append("            A.CLPT_IND_SEQ, -- VSL_CALL_IND_CD							 " ).append("\n"); 
		query.append("            A.CLPT_SEQ,     -- VSL_CALL_SEQ								 " ).append("\n"); 
		query.append("            A.VPS_ETA_DT,   -- VSL_ETA_DT									 " ).append("\n"); 
		query.append("            A.VPS_ETB_DT,   -- VSL_ETB_DT					  			     " ).append("\n"); 
		query.append("            A.VPS_ETD_DT,   -- VSL_ETD_DT									 " ).append("\n"); 
		query.append("            A.TURN_PORT_IND_CD, -- VSL_TURN_PORT_INFO_CD					 " ).append("\n"); 
		query.append("            A.TURN_SKD_VOY_NO,  -- VSL_TURN_VOY_NO						 " ).append("\n"); 
		query.append("            A.TURN_SKD_DIR_CD,  -- VSL_TURN_DIR_CD						 " ).append("\n"); 
		query.append("            A.TURN_CLPT_IND_SEQ,-- VSL_TURN_CALL_IND_CD					 " ).append("\n"); 
		query.append("            A.SLAN_CD,          -- VSL_SLAN_CD" ).append("\n"); 
		query.append("            A.YD_CD            -- YD_CD			09.12.29 YD정보를 넣기 위해 추가  By ChangeHoChae				 						 " ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("            ,VSK_VSL_SKD B												 " ).append("\n"); 
		query.append("        WHERE A.VSL_CD     = @[vsl_cd]    -- VSL_CD 입력값   EX) EME7					 " ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO = @[skd_voy_no] -- SKD VOY 입력값  EX) 0718						 " ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD = @[skd_dir_cd] -- SKD DIR 입력값  EX) N						 " ).append("\n"); 
		query.append("        AND   A.VPS_PORT_CD= @[vsl_loc_cd] -- 한진고객이 요청하지 않는 경우는 생략함			 												 " ).append("\n"); 
		query.append("        AND   A.SLAN_CD    =  @[vsl_slan_cd]	" ).append("\n"); 
		query.append("		AND   A.SLAN_CD    = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND   A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND NVL(SKD_CNG_STS_CD,'N') not in ('S')" ).append("\n"); 
		query.append("        AND A.VPS_ETD_DT BETWEEN (SELECT TO_DATE(WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[v_fm_wk] )" ).append("\n"); 
		query.append("                         AND     (SELECT TO_DATE(WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[v_to_wk] )											 " ).append("\n"); 
		query.append("        ) B																 " ).append("\n"); 
		query.append("ON      (      " ).append("\n"); 
		query.append("        A.SCNR_ID               = B.SCNR_ID1							 " ).append("\n"); 
		query.append("        AND  A.VSL_CD           = B.VSL_CD1 							 " ).append("\n"); 
		query.append("        AND  A.SKD_VOY_NO       = B.SKD_VOY_NO1							 " ).append("\n"); 
		query.append("        AND  A.SKD_DIR_CD       = B.SKD_DIR_CD1 						 " ).append("\n"); 
		query.append("        AND  A.VSL_LOC_CD       = B.VPS_PORT_CD 						 " ).append("\n"); 
		query.append("        AND  A.VSL_CALL_IND_CD  = B.CLPT_IND_SEQ						 					 " ).append("\n"); 
		query.append("        --AND  A.VSL_SLAN_CD      = B.SLAN_CD" ).append("\n"); 
		query.append("        )																	 " ).append("\n"); 
		query.append("WHEN MATCHED THEN    													  " ).append("\n"); 
		query.append("        UPDATE 	SET     														 " ).append("\n"); 
		query.append("            --A.VSL_CALL_IND_CD         = B.CLPT_IND_SEQ,			     " ).append("\n"); 
		query.append("            A.VSL_CALL_SEQ            = B.CLPT_SEQ,				     " ).append("\n"); 
		query.append("            A.VSL_ETA_DT              = B.VPS_ETA_DT,					 " ).append("\n"); 
		query.append("            A.VSL_ETB_DT              = B.VPS_ETB_DT,					 " ).append("\n"); 
		query.append("            A.VSL_ETD_DT              = B.VPS_ETD_DT,					 " ).append("\n"); 
		query.append("            A.VSL_TURN_PORT_INFO_CD   = B.TURN_PORT_IND_CD,			 " ).append("\n"); 
		query.append("            A.VSL_TURN_VOY_NO         = B.TURN_SKD_VOY_NO,				 " ).append("\n"); 
		query.append("            A.VSL_TURN_DIR_CD         = B.TURN_SKD_DIR_CD,				 " ).append("\n"); 
		query.append("            A.VSL_TURN_CALL_IND_CD    = B.TURN_CLPT_IND_SEQ," ).append("\n"); 
		query.append("            A.YD_CD                   = B.YD_CD,			 				 " ).append("\n"); 
		query.append("            A.DELT_FLG                = 'N',							 " ).append("\n"); 
		query.append("            A.UPD_USR_ID              =  @[User_id] ,							 " ).append("\n"); 
		query.append("            A.UPD_DT                  = SYSDATE" ).append("\n"); 

	}
}