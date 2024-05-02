/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingDBDAOUpdateNewLaneOfficeCmcbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.06.12 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOUpdateNewLaneOfficeCmcbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Lane - Office의 Cmcb를 업데이트한다.
	  * </pre>
	  */
	public OfficeMappingDBDAOUpdateNewLaneOfficeCmcbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pa_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration ").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOUpdateNewLaneOfficeCmcbUSQL").append("\n"); 
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
		query.append("UPDATE SQM_QTA_NEW_LANE_OFC_COST" ).append("\n"); 
		query.append("   SET PA_CM_UC_AMT = @[pa_cm_uc_amt] " ).append("\n"); 
		query.append("      ,RA_CM_UC_AMT = @[ra_cm_uc_amt]" ).append("\n"); 
		query.append("      ,UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT       = SYSDATE " ).append("\n"); 
		query.append("WHERE BSE_TP_CD     = @[bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR        = @[bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD    = DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 
		query.append("  AND OFC_VW_CD     = DECODE(@[ofc_vw_cd],'LOADING','L','CONTRACT','C')" ).append("\n"); 
		query.append("  AND TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("  AND DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("  AND RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("  AND RHQ_CD        = @[rhq_cd]" ).append("\n"); 
		query.append("  AND RGN_OFC_CD    = @[rgn_ofc_cd]" ).append("\n"); 

	}
}