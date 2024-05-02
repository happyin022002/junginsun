/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SimulationDBDAOFcmVslPortStndFuelOilCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOFcmVslPortStndFuelOilCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standard FOC 정보를 저장한다.
	  * 2014.05.28 [CHM-201430380] Standard FOC 칼럼 추가 및 조회 로직 수정
	  * </pre>
	  */
	public SimulationDBDAOFcmVslPortStndFuelOilCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_port_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnd_line_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_sea_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opmz_sea_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opmz_sea_spd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("opmz_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_port_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_port_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_port_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rvis_foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOFcmVslPortStndFuelOilCSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_VSL_PORT_STND_FUEL_OIL T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT @[vsl_cd]                  AS VSL_CD" ).append("\n"); 
		query.append("               ,@[skd_voy_no]              AS SKD_VOY_NO" ).append("\n"); 
		query.append("               ,@[skd_dir_cd]              AS SKD_DIR_CD" ).append("\n"); 
		query.append("               ,@[vps_port_cd]             AS VPS_PORT_CD" ).append("\n"); 
		query.append("               ,@[clpt_ind_seq]            AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("               ,@[vsl_slan_cd]             AS VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,@[yd_cd]                   AS YD_CD" ).append("\n"); 
		query.append("               ,@[init_foil_csm]           AS INIT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[rvis_foil_csm]           AS RVIS_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[trnd_line_foil_csm]      AS TRND_LINE_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[act_foil_csm]            AS ACT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[init_port_foil_csm]      AS INIT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[rvis_port_foil_csm]      AS RVIS_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[trnd_line_port_foil_csm] AS TRND_LINE_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[act_port_foil_csm]       AS ACT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,@[opmz_dist]               AS OPMZ_DIST" ).append("\n"); 
		query.append("               ,@[opmz_sea_spd]            AS OPMZ_SEA_SPD" ).append("\n"); 
		query.append("               ,@[pf_sea_tm_hrs]           AS PF_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,@[opmz_sea_tm_hrs]         AS OPMZ_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,@[cre_usr_id]              AS CRE_USR_ID" ).append("\n"); 
		query.append("               ,@[upd_usr_id]              AS UPD_USR_ID" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("                T.VSL_CD       = I.VSL_CD" ).append("\n"); 
		query.append("            AND T.SKD_VOY_NO   = I.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T.SKD_DIR_CD   = I.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T.VPS_PORT_CD  = I.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND T.CLPT_IND_SEQ = I.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET T.INIT_FOIL_CSM           = I.INIT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.RVIS_FOIL_CSM           = I.RVIS_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.TRND_LINE_FOIL_CSM      = I.TRND_LINE_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.ACT_FOIL_CSM            = I.ACT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.INIT_PORT_FOIL_CSM      = I.INIT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.RVIS_PORT_FOIL_CSM      = I.RVIS_PORT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.TRND_LINE_PORT_FOIL_CSM = I.TRND_LINE_PORT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.ACT_PORT_FOIL_CSM       = I.ACT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("          ,T.OPMZ_DIST               = I.OPMZ_DIST" ).append("\n"); 
		query.append("          ,T.OPMZ_SEA_SPD            = I.OPMZ_SEA_SPD" ).append("\n"); 
		query.append("          ,T.PF_SEA_TM_HRS           = I.PF_SEA_TM_HRS" ).append("\n"); 
		query.append("          ,T.OPMZ_SEA_TM_HRS         = I.OPMZ_SEA_TM_HRS" ).append("\n"); 
		query.append("          ,T.UPD_USR_ID              = I.UPD_USR_ID" ).append("\n"); 
		query.append("          ,T.UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("                T.VSL_CD" ).append("\n"); 
		query.append("               ,T.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,T.VPS_PORT_CD" ).append("\n"); 
		query.append("               ,T.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               ,T.VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,T.YD_CD" ).append("\n"); 
		query.append("               ,T.INIT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.RVIS_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.TRND_LINE_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.ACT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.INIT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.RVIS_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.TRND_LINE_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.ACT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,T.OPMZ_DIST" ).append("\n"); 
		query.append("               ,T.OPMZ_SEA_SPD" ).append("\n"); 
		query.append("               ,T.PF_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,T.OPMZ_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,T.CRE_USR_ID" ).append("\n"); 
		query.append("               ,T.CRE_DT" ).append("\n"); 
		query.append("               ,T.UPD_USR_ID" ).append("\n"); 
		query.append("               ,T.UPD_DT" ).append("\n"); 
		query.append("    ) VALUES (" ).append("\n"); 
		query.append("                I.VSL_CD" ).append("\n"); 
		query.append("               ,I.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,I.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,I.VPS_PORT_CD" ).append("\n"); 
		query.append("               ,I.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               ,I.VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,I.YD_CD" ).append("\n"); 
		query.append("               ,I.INIT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.RVIS_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.TRND_LINE_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.ACT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.INIT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.RVIS_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.TRND_LINE_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.ACT_PORT_FOIL_CSM" ).append("\n"); 
		query.append("               ,I.OPMZ_DIST" ).append("\n"); 
		query.append("               ,I.OPMZ_SEA_SPD" ).append("\n"); 
		query.append("               ,I.PF_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,I.OPMZ_SEA_TM_HRS" ).append("\n"); 
		query.append("               ,I.CRE_USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE" ).append("\n"); 
		query.append("               ,I.UPD_USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}