/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOModifyPortTimeKPIListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.07.10 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOModifyPortTimeKPIListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 KPI 정보를 변경 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOModifyPortTimeKPIListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_lft_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_kpi_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt_yy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dul_cyc_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_tml_prod_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stm_in_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stm_out_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_crn_prod_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_crn_prod_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt_md",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt_md",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_stay_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dep_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_op_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt_yy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cntr_mv_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kpi_tgt_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_arr_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstwg_hrs",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOModifyPortTimeKPIListUSQL").append("\n"); 
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
		query.append("#if(${tab_chk}=='KPI'||${tab_chk}=='')" ).append("\n"); 
		query.append("UPDATE  OPF_PORT_TM_KPI" ).append("\n"); 
		query.append("SET     FM_EFF_DT         = TO_DATE(REPLACE(@[fm_eff_dt_yy]||@[fm_eff_dt_md], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      , TO_EFF_DT         = TO_DATE(REPLACE(@[to_eff_dt_yy]||@[to_eff_dt_md], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      , TTL_CNTR_MV_KNT   = NVL(@[ttl_cntr_mv_knt]  , 0)" ).append("\n"); 
		query.append("      , STM_IN_HRS        = NVL(@[stm_in_hrs]       , 0)" ).append("\n"); 
		query.append("      , VSL_ARR_HRS       = NVL(@[vsl_arr_hrs]      , 0) --05" ).append("\n"); 
		query.append("      , TML_OP_HRS        = NVL(@[tml_op_hrs]       , 0)" ).append("\n"); 
		query.append("      , VSL_DEP_HRS       = NVL(@[vsl_dep_hrs]      , 0)" ).append("\n"); 
		query.append("      , STM_OUT_HRS       = NVL(@[stm_out_hrs]      , 0)" ).append("\n"); 
		query.append("      , PORT_STAY_HRS     = NVL(@[port_stay_hrs]    , 0)" ).append("\n"); 
		query.append("      , GRS_TML_PROD_HRS  = NVL(@[grs_tml_prod_hrs] , 0) --10" ).append("\n"); 
		query.append("      , GRS_CRN_PROD_HRS  = NVL(@[grs_crn_prod_hrs] , 0)" ).append("\n"); 
		query.append("      , NET_CRN_PROD_HRS  = NVL(@[net_crn_prod_hrs] , 0)" ).append("\n"); 
		query.append("      , TWN_LFT_HRS       = NVL(@[twn_lft_hrs]      , 0)" ).append("\n"); 
		query.append("      , DUL_CYC_HRS       = NVL(@[dul_cyc_hrs]      , 0)" ).append("\n"); 
		query.append("      , RSTWG_HRS         = NVL(@[rstwg_hrs]        , 0) --15" ).append("\n"); 
		query.append("      , UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     KPI_TGT_YR        = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("AND     SLAN_CD           = @[slan_cd]" ).append("\n"); 
		query.append("AND     VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     KPI_VER_SEQ       = @[kpi_ver_seq]" ).append("\n"); 
		query.append("AND     PORT_KPI_DIR_CD   = NVL(@[port_kpi_dir_cd], 'A')" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ      = NVL(@[clpt_ind_seq], 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_chk}=='BSEL')" ).append("\n"); 
		query.append("UPDATE  OPF_PORT_TM_BSEL" ).append("\n"); 
		query.append("SET     FM_EFF_DT         = TO_DATE(REPLACE(@[fm_eff_dt_yy]||@[fm_eff_dt_md], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      , TO_EFF_DT         = TO_DATE(REPLACE(@[to_eff_dt_yy]||@[to_eff_dt_md], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("      , TTL_CNTR_MV_KNT   = NVL(@[ttl_cntr_mv_knt]  , 0)" ).append("\n"); 
		query.append("      , STM_IN_HRS        = NVL(@[stm_in_hrs]       , 0)" ).append("\n"); 
		query.append("      , VSL_ARR_HRS       = NVL(@[vsl_arr_hrs]      , 0) --05" ).append("\n"); 
		query.append("      , TML_OP_HRS        = NVL(@[tml_op_hrs]       , 0)" ).append("\n"); 
		query.append("      , VSL_DEP_HRS       = NVL(@[vsl_dep_hrs]      , 0)" ).append("\n"); 
		query.append("      , STM_OUT_HRS       = NVL(@[stm_out_hrs]      , 0)" ).append("\n"); 
		query.append("      , PORT_STAY_HRS     = NVL(@[port_stay_hrs]    , 0)" ).append("\n"); 
		query.append("      , GRS_TML_PROD_HRS  = NVL(@[grs_tml_prod_hrs] , 0) --10" ).append("\n"); 
		query.append("      , GRS_CRN_PROD_HRS  = NVL(@[grs_crn_prod_hrs] , 0)" ).append("\n"); 
		query.append("      , NET_CRN_PROD_HRS  = NVL(@[net_crn_prod_hrs] , 0)" ).append("\n"); 
		query.append("      , TWN_LFT_HRS       = NVL(@[twn_lft_hrs]      , 0)" ).append("\n"); 
		query.append("      , DUL_CYC_HRS       = NVL(@[dul_cyc_hrs]      , 0)" ).append("\n"); 
		query.append("      , RSTWG_HRS         = NVL(@[rstwg_hrs]        , 0) --15" ).append("\n"); 
		query.append("      , UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BSEL_YR           = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("AND     SLAN_CD           = @[slan_cd]" ).append("\n"); 
		query.append("AND     VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     PORT_BSEL_DIR_CD  = NVL(@[port_kpi_dir_cd], 'A')" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ      = NVL(@[clpt_ind_seq], 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}