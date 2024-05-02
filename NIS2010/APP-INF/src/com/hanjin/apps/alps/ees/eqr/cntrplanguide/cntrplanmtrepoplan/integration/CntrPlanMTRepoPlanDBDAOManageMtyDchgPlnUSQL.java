/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MtyDchgPln 저장
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_shw_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_MTY_DCHG_PLN V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (    V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND V.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("        POL_YD_CD = @[pol_yd_cd], " ).append("\n"); 
		query.append("        POD_YD_CD = @[pod_yd_cd]," ).append("\n"); 
		query.append("        MTY_PLN_SHW_FLG = @[mty_pln_shw_flg]," ).append("\n"); 
		query.append("        UPD_USR_ID =  @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        POL_YD_CD," ).append("\n"); 
		query.append("        POD_YD_CD," ).append("\n"); 
		query.append("        MTY_PLN_SHW_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("    	UPD_USR_ID," ).append("\n"); 
		query.append("    	UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[pol_yd_cd]," ).append("\n"); 
		query.append("        @[pod_yd_cd]," ).append("\n"); 
		query.append("        @[mty_pln_shw_flg]," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}