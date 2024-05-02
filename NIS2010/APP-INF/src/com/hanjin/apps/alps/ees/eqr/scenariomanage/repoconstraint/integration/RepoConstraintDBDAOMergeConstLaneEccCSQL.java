/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAOMergeConstLaneEccCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoConstraintDBDAOMergeConstLaneEccCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0138 Constraint by Lane/ECC>
	  * EQR_SCNR_PORT_DCHG_CNST  테이블 데이터 수정
	  * 
	  * <Change History>
	  * 1	2009.08.12	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public RepoConstraintDBDAOMergeConstLaneEccCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnst_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration").append("\n"); 
		query.append("FileName : RepoConstraintDBDAOMergeConstLaneEccCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_PORT_DCHG_CNST A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id]  AS SCNR_ID" ).append("\n"); 
		query.append(",@[vsl_lane_cd]  AS LANE_CD" ).append("\n"); 
		query.append(",@[vsl_loc_cd]  AS LOC_CD" ).append("\n"); 
		query.append(",@[cnst_cntr_tpsz_cd]  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON    (" ).append("\n"); 
		query.append("A.VSL_LANE_CD 			= B.LANE_CD" ).append("\n"); 
		query.append("AND  A.VSL_LOC_CD  			= B.LOC_CD" ).append("\n"); 
		query.append("AND  A.CNST_CNTR_TPSZ_CD   	= B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  A.SCNR_ID   	        = B.SCNR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    	 A.CNTR_VOL_QTY  = @[cntr_vol_qty] ," ).append("\n"); 
		query.append("A.UPD_USR_ID    = @[upd_usr_id] ," ).append("\n"); 
		query.append("A.UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.SCNR_ID      ," ).append("\n"); 
		query.append("A.VSL_LANE_CD  ," ).append("\n"); 
		query.append("A.VSL_LOC_CD   ," ).append("\n"); 
		query.append("A.CNST_CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("A.CNTR_VOL_QTY ," ).append("\n"); 
		query.append("A.CRE_USR_ID   ," ).append("\n"); 
		query.append("A.CRE_DT       ," ).append("\n"); 
		query.append("A.UPD_USR_ID   ," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append(") VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[scnr_id]," ).append("\n"); 
		query.append("@[vsl_lane_cd]," ).append("\n"); 
		query.append("@[vsl_loc_cd]," ).append("\n"); 
		query.append("@[cnst_cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[cntr_vol_qty]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}