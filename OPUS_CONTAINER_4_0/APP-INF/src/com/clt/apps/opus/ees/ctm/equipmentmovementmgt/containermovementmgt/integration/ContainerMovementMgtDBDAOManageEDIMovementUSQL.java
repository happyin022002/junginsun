/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOManageEDIMovementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOManageEDIMovementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOManageEDIMovementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_full_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rty_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_unflg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOManageEDIMovementUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("   SET MVMT_EDI_RSLT_CD = @[mvmt_edi_rslt_cd]" ).append("\n"); 
		query.append("       ,MVMT_EDI_RMK = REPLACE(@[mvmt_edi_rmk], '^#^', CHR(39))" ).append("\n"); 
		query.append("#if (${edi_ui_yn} == 'Y')" ).append("\n"); 
		query.append("       ,CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("       ,EVNT_YD_CD = @[evnt_yd_cd]" ).append("\n"); 
		query.append("       ,BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       ,CRNT_VSL_CD = @[crnt_vsl_cd]" ).append("\n"); 
		query.append("       ,CRNT_SKD_VOY_NO = @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("       ,CRNT_SKD_DIR_CD = @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("       ,EDI_MVMT_STS_CD = @[edi_mvmt_sts_cd]" ).append("\n"); 
		query.append("       ,CNTR_FULL_STS_CD = @[cntr_full_sts_cd]" ).append("\n"); 
		query.append("       ,RTY_KNT = @[rty_knt]" ).append("\n"); 
		query.append("       ,UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(DECODE (@[evnt_yd_cd], '', DECODE (@[mvmt_edi_msg_area_cd], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''), SUBSTR(@[evnt_yd_cd], 1, 5)))" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("       ,CNMV_RMK = REPLACE(@[cnmv_rmk], '^#^', CHR(39))" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       ,CNTR_DMG_FLG = @[cntr_dmg_flg]" ).append("\n"); 
		query.append("       ,DMG_FLG_DT = NVL(TO_DATE (@[dmg_flg_dt], 'YYYYMMDDHH24MISS'),'')" ).append("\n"); 
		query.append("       ,DMG_UNFLG_DT = NVL(TO_DATE (@[dmg_unflg_dt], 'YYYYMMDDHH24MISS'),'')" ).append("\n"); 
		query.append("       ,MTY_REPO_NO = CASE WHEN MTY_REPO_NO IS NOT NULL THEN @[mty_pln_no]" ).append("\n"); 
		query.append("                  	 END" ).append("\n"); 
		query.append("       ,MTY_PLN_NO = CASE WHEN MTY_PLN_NO IS NOT NULL THEN @[mty_pln_no]" ).append("\n"); 
		query.append("                     	 WHEN MTY_REPO_NO IS NULL AND MTY_PLN_NO IS NULL THEN @[mty_pln_no]" ).append("\n"); 
		query.append("               		END" ).append("\n"); 
		query.append(" #if (${cre_locl_dt} == '')" ).append("\n"); 
		query.append("       ,CRE_LOCL_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', CRE_DT, SUBSTR(@[evnt_yd_cd], 1, 5))" ).append("\n"); 
		query.append("       ,IDX_CRE_LOCL_DT = NVL(SUBSTR( TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', CRE_DT, SUBSTR(@[evnt_yd_cd], 1, 5)), 'YYYYMMDDHH24MISS'), 1, 8), '00000000')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_SEQ = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("   AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("   AND MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]" ).append("\n"); 

	}
}