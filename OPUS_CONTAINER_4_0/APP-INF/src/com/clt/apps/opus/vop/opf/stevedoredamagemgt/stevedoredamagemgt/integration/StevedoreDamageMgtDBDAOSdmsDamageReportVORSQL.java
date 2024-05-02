/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSdmsDamageReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.09.08 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SunyoungLee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSdmsDamageReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SdmsDamageReportVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSdmsDamageReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_prt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_stl_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_prt_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_respb_pty_kwn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpr_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_oshp_cntr_blk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_cmpn_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_evnt_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSdmsDamageReportVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${group_by} == 'A')" ).append("\n"); 
		query.append("TO_CHAR(H.STV_DMG_EVNT_DT, 'YYYYMM') AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'B')" ).append("\n"); 
		query.append("DECODE(VSL_OSHP_CNTR_BLK_TP_CD, 'CO', 'Container Own Ship'," ).append("\n"); 
		query.append("'CC', 'Container Charter Ship', 'BO', 'Bulk Own Ship') AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'C')" ).append("\n"); 
		query.append("SUBSTR(H.VPS_PORT_CD,1,2) AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'D')" ).append("\n"); 
		query.append("H.VPS_PORT_CD AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'E')" ).append("\n"); 
		query.append("V.VSL_SLAN_CD AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'F')" ).append("\n"); 
		query.append("H.VSL_CD AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'G')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_PRT_CATE_CD, 'HULL', 'Hull', 'MATL', 'Material', 'Machinary') AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'H')" ).append("\n"); 
		query.append("D.STV_DMG_PRT_CD AS GRP," ).append("\n"); 
		query.append("#elseif (${group_by} == 'I')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_RESPB_PTY_KWN_FLG, 'Y', 'Known', 'Unknown') AS GRP," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("COUNT(D.STV_DMG_NO)                              DMG_CNT," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_REQ_CATE_CD,'R',1,0))       REP_CNT," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_REQ_CATE_CD,'S',1,0))       SUP_CNT," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_REQ_CATE_CD,'Q',1,0))       QUO_CNT," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_RESPB_PTY_KWN_FLG,'N',1,0)) UNK_CNT," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_PRT_CATE_CD,'HULL',1,0))    HULL," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_PRT_CATE_CD,'MATL',1,0))    MATL," ).append("\n"); 
		query.append("SUM(DECODE(D.STV_DMG_PRT_CATE_CD,'MACH',1,0))    MACH" ).append("\n"); 
		query.append("FROM   OPF_STV_DMG H,      OPF_STV_DMG_DTL D, OPF_STV_DMG_RPR R," ).append("\n"); 
		query.append("OPF_STV_DMG_CMPN C, OPF_STV_DMG_STL S, VSK_VSL_SKD V" ).append("\n"); 
		query.append("WHERE  H.STV_DMG_EVNT_DT BETWEEN TO_DATE(@[stv_dmg_evnt_dt_from],'YYYY-MM-DD') --:fm_dt" ).append("\n"); 
		query.append("AND     LAST_DAY(TO_DATE(@[stv_dmg_evnt_dt_to],'YYYY-MM-DD')) + 0.99999  --:to_dt" ).append("\n"); 
		query.append("#if (${vsl_oshp_cntr_blk_tp_cd} != '' && ${vsl_oshp_cntr_blk_tp_cd} != 'All')" ).append("\n"); 
		query.append("AND    H.VSL_OSHP_CNTR_BLK_TP_CD          = @[vsl_oshp_cntr_blk_tp_cd]    --:vel_catagory" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${loc_cd} != 'All')" ).append("\n"); 
		query.append("AND    SUBSTR(H.VPS_PORT_CD,1,2)          = @[loc_cd]    --:cnt_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '' && ${vps_port_cd} != 'All')" ).append("\n"); 
		query.append("AND    H.VPS_PORT_CD                      = @[vps_port_cd] --:port_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '' && ${vsl_cd} != 'All')" ).append("\n"); 
		query.append("AND    H.VSL_CD                           = @[vsl_cd]  --:vessel" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.STV_DMG_NO  = D.STV_DMG_NO(+)" ).append("\n"); 
		query.append("#if (${stv_dmg_prt_cate_cd} != '' && ${stv_dmg_prt_cate_cd} != 'All')" ).append("\n"); 
		query.append("AND    D.STV_DMG_PRT_CATE_CD              = @[stv_dmg_prt_cate_cd]  --:dmg_catagory" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stv_dmg_prt_cd} != '' && ${stv_dmg_prt_cd} != 'All')" ).append("\n"); 
		query.append("AND    D.STV_DMG_PRT_CD                   = @[stv_dmg_prt_cd]  --:dmg_part" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stv_dmg_tp_cd} != '' && ${stv_dmg_tp_cd} != 'All')" ).append("\n"); 
		query.append("AND    D.STV_DMG_TP_CD                    = @[stv_dmg_tp_cd]  --:dmg_type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stv_dmg_respb_pty_kwn_flg} != '' && ${stv_dmg_respb_pty_kwn_flg} != 'All')" ).append("\n"); 
		query.append("AND    D.STV_DMG_RESPB_PTY_KWN_FLG        = @[stv_dmg_respb_pty_kwn_flg]  --:resp_party" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stv_dmg_step_cd} != '' && ${stv_dmg_step_cd} != 'All')" ).append("\n"); 
		query.append("AND    NVL(D.STV_DMG_REQ_CATE_CD,' ')     = @[stv_dmg_step_cd] --:damage" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.STV_DMG_NO  = R.STV_DMG_NO(+)" ).append("\n"); 
		query.append("AND    NVL(R.STV_DMG_RPR_SEQ,1) = DECODE(R.STV_DMG_RPR_SEQ,NULL,1,( SELECT MAX(STV_DMG_RPR_SEQ)" ).append("\n"); 
		query.append("FROM   OPF_STV_DMG_RPR" ).append("\n"); 
		query.append("WHERE  STV_DMG_NO = H.STV_DMG_NO ))" ).append("\n"); 
		query.append("#if (${stv_dmg_rpr_proc_sts_cd} != '' && ${stv_dmg_rpr_proc_sts_cd} != 'All')" ).append("\n"); 
		query.append("AND    NVL(R.STV_DMG_RPR_PROC_STS_CD,' ') = @[stv_dmg_rpr_proc_sts_cd] --:repair" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.STV_DMG_NO  = C.STV_DMG_NO(+)" ).append("\n"); 
		query.append("#if (${stv_dmg_cmpn_proc_sts_cd} != '' && ${stv_dmg_cmpn_proc_sts_cd} != 'All')" ).append("\n"); 
		query.append("AND    NVL(C.STV_DMG_CMPN_PROC_STS_CD,' ') = @[stv_dmg_cmpn_proc_sts_cd] --:compensation" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.STV_DMG_NO  = S.STV_DMG_NO(+)" ).append("\n"); 
		query.append("#if (${stv_dmg_stl_proc_sts_cd} != '' && ${stv_dmg_stl_proc_sts_cd} != 'All')" ).append("\n"); 
		query.append("AND    NVL(S.STV_DMG_STL_PROC_STS_CD,' ') = @[stv_dmg_stl_proc_sts_cd] --:settlement" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("AND    H.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    H.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${slane_cd} != '' && ${slane_cd} != 'All')" ).append("\n"); 
		query.append("AND    V.VSL_SLAN_CD                      = @[slane_cd] --:lane" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if (${group_by} == 'A')" ).append("\n"); 
		query.append("TO_CHAR(H.STV_DMG_EVNT_DT, 'YYYYMM')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'B')" ).append("\n"); 
		query.append("DECODE(H.VSL_OSHP_CNTR_BLK_TP_CD, 'CO', 'Container Own Ship'," ).append("\n"); 
		query.append("'CC', 'Container Charter Ship', 'BO', 'Bulk Own Ship')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'C')" ).append("\n"); 
		query.append("SUBSTR(H.VPS_PORT_CD,1,2)" ).append("\n"); 
		query.append("#elseif (${group_by} == 'D')" ).append("\n"); 
		query.append("H.VPS_PORT_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'E')" ).append("\n"); 
		query.append("V.VSL_SLAN_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'F')" ).append("\n"); 
		query.append("H.VSL_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'G')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_PRT_CATE_CD, 'HULL', 'Hull', 'MATL', 'Material', 'Machinary')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'H')" ).append("\n"); 
		query.append("D.STV_DMG_PRT_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'I')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_RESPB_PTY_KWN_FLG, 'Y', 'Known', 'Unknown')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${group_by} == 'A')" ).append("\n"); 
		query.append("TO_CHAR(H.STV_DMG_EVNT_DT, 'YYYYMM')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'B')" ).append("\n"); 
		query.append("DECODE(H.VSL_OSHP_CNTR_BLK_TP_CD, 'CO', 'Container Own Ship'," ).append("\n"); 
		query.append("'CC', 'Container Charter Ship', 'BO', 'Bulk Own Ship')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'C')" ).append("\n"); 
		query.append("SUBSTR(H.VPS_PORT_CD,1,2)" ).append("\n"); 
		query.append("#elseif (${group_by} == 'D')" ).append("\n"); 
		query.append("H.VPS_PORT_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'E')" ).append("\n"); 
		query.append("V.VSL_SLAN_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'F')" ).append("\n"); 
		query.append("H.VSL_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'G')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_PRT_CATE_CD, 'HULL', 'Hull', 'MATL', 'Material', 'Machinary')" ).append("\n"); 
		query.append("#elseif (${group_by} == 'H')" ).append("\n"); 
		query.append("D.STV_DMG_PRT_CD" ).append("\n"); 
		query.append("#elseif (${group_by} == 'I')" ).append("\n"); 
		query.append("DECODE(D.STV_DMG_RESPB_PTY_KWN_FLG, 'Y', 'Known', 'Unknown')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}