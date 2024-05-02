/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOUSQL.java
*@FileTitle : SDMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.01 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_atch_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_atch_file_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE OPF_STV_DMG_ATCH_FILE SET" ).append("\n"); 
		query.append("STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append(",	STV_DMG_PROC_CD = @[stv_dmg_proc_cd]" ).append("\n"); 
		query.append(",	STV_DMG_ATCH_FILE_TP_CD = @[stv_dmg_atch_file_tp_cd]" ).append("\n"); 
		query.append(",	STV_DMG_ATCH_FILE_SEQ = @[stv_dmg_atch_file_seq]" ).append("\n"); 
		query.append(",	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append(",	FILE_NM = @[file_nm]" ).append("\n"); 
		query.append(",	FILE_SAV_ID = @[file_sav_id]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("AND	STV_DMG_PROC_CD = @[stv_dmg_proc_cd]" ).append("\n"); 
		query.append("AND	STV_DMG_ATCH_FILE_TP_CD = @[stv_dmg_atch_file_tp_cd]" ).append("\n"); 
		query.append("AND STV_DMG_ATCH_FILE_SEQ = @[stv_dmg_atch_file_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}