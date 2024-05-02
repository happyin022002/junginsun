/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstCntrSpecVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMstCntrSpecVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstCntrSpecVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opn_dor_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frack_clps_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opntp_roof_opn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opn_dor_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opntp_rear_hdr_opn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tare",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("opntp_intr_hgt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_grs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_ldb_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tnk_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_ldb_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frack_bed_tik_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstCntrSpecVOUSQL").append("\n"); 
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
		query.append("UPDATE MST_CNTR_SPEC SET " ).append("\n"); 
		query.append("	LOD_CAPA     = NVL(@[lod_capa],0)" ).append("\n"); 
		query.append(",	CNTR_GRS_WGT = NVL(@[cntr_grs],0)" ).append("\n"); 
		query.append(",	TARE_WGT     = NVL(@[tare],0)" ).append("\n"); 
		query.append(",	INTER_LEN    = NVL(@[inter_len],0)" ).append("\n"); 
		query.append(",	INTER_WDT    = NVL(@[inter_wdt],0)" ).append("\n"); 
		query.append(",	INTER_HGT    = NVL(@[inter_hgt],0)" ).append("\n"); 
		query.append(",	XTER_LEN     = NVL(@[xter_len],0)" ).append("\n"); 
		query.append(",	XTER_WDT     = NVL(@[xter_wdt],0)" ).append("\n"); 
		query.append(",	XTER_HGT     = NVL(@[xter_hgt],0)" ).append("\n"); 
		query.append(",	OPN_DOR_WDT  = NVL(@[opn_dor_wdt],0)" ).append("\n"); 
		query.append(",	OPN_DOR_HGT  = NVL(@[opn_dor_hgt],0)" ).append("\n"); 
		query.append(",	RC_LDB_CAPA  = NVL(@[rc_ldb_capa],0)" ).append("\n"); 
		query.append(",	RC_LDB_HGT   = NVL(@[rc_ldb_hgt],0)" ).append("\n"); 
		query.append(",	TNK_CAPA     = NVL(@[tnk_capa],0)" ).append("\n"); 
		query.append(",	DIFF_RMK     = @[diff_rmk]" ).append("\n"); 
		query.append(",	UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT       = SYSDATE" ).append("\n"); 
		query.append(",	FRACK_CLPS_CTNT   		= @[frack_clps_ctnt]" ).append("\n"); 
		query.append(",	FRACK_BED_TIK_CTNT  	= @[frack_bed_tik_ctnt]" ).append("\n"); 
		query.append(",	OPNTP_ROOF_OPN_CTNT 	= @[opntp_roof_opn_ctnt]" ).append("\n"); 
		query.append(",	OPNTP_INTR_HGT_CTNT   	= @[opntp_intr_hgt_ctnt]" ).append("\n"); 
		query.append(",	OPNTP_REAR_HDR_OPN_CTNT = @[opntp_rear_hdr_opn_ctnt] " ).append("\n"); 
		query.append("#if(${own_cntr_flg} == 'S')" ).append("\n"); 
		query.append(",	VNDR_SEQ				= ''" ).append("\n"); 
		query.append(",	CNTR_MTRL_CD			= ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	VNDR_SEQ				= @[vndr_seq2]" ).append("\n"); 
		query.append(",	CNTR_MTRL_CD			= @[cntr_mtrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CNTR_SPEC_NO = @[cntr_spec_no]" ).append("\n"); 

	}
}