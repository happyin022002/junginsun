/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOmodifyNewHangerInventoryDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.02.05 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOmodifyNewHangerInventoryDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_MNR_0113] Search Invent List 항목을 수정
	  * 기존 [EES_MNR_0110] 를 대체함
	  * 업데이트 할 데이터가 없을 경우 데이터를 새로 생성
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOmodifyNewHangerInventoryDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_out_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intg_cd_val_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOmodifyNewHangerInventoryDataUSQL").append("\n"); 
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
		query.append(" MERGE INTO MNR_HNGR_MON_INVT A " ).append("\n"); 
		query.append(" USING DUAL" ).append("\n"); 
		query.append("    ON ( A.INVT_YRMON = @[invt_yrmon] AND A.OFC_CD = @[ofc_cd] AND A.MNR_HNGR_BAR_TP_CD = @[intg_cd_val_ctnt])" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET DE_HNGR_QTY = @[de_hngr_qty]" ).append("\n"); 
		query.append("             , OB_HNGR_QTY = @[ob_hngr_qty]" ).append("\n"); 
		query.append("             , REPO_OUT_HNGR_QTY = @[repo_out_hngr_qty]" ).append("\n"); 
		query.append("             , RPR_HNGR_QTY = @[rpr_hngr_qty]" ).append("\n"); 
		query.append("             , DISP_HNGR_QTY = @[disp_hngr_qty]" ).append("\n"); 
		query.append("             , INVT_RMK = @[invt_rmk]" ).append("\n"); 
		query.append("             , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("             , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT ( " ).append("\n"); 
		query.append("        INVT_YRMON" ).append("\n"); 
		query.append("      , OFC_CD" ).append("\n"); 
		query.append("      , MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("      , INVT_QTY" ).append("\n"); 
		query.append("      , DE_HNGR_QTY" ).append("\n"); 
		query.append("      , OB_HNGR_QTY" ).append("\n"); 
		query.append("      , REPO_OUT_HNGR_QTY" ).append("\n"); 
		query.append("      , RPR_HNGR_QTY" ).append("\n"); 
		query.append("      , DISP_HNGR_QTY" ).append("\n"); 
		query.append("      , INVT_RMK" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("        @[invt_yrmon]" ).append("\n"); 
		query.append("      , @[ofc_cd]" ).append("\n"); 
		query.append("      , @[intg_cd_val_ctnt]" ).append("\n"); 
		query.append("      , 0" ).append("\n"); 
		query.append("      , @[de_hngr_qty]" ).append("\n"); 
		query.append("      , @[ob_hngr_qty]" ).append("\n"); 
		query.append("      , @[repo_out_hngr_qty]" ).append("\n"); 
		query.append("      , @[rpr_hngr_qty]" ).append("\n"); 
		query.append("      , @[disp_hngr_qty]" ).append("\n"); 
		query.append("      , @[invt_rmk]" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}