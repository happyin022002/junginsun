/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOAddPortTimeKPIVersionListCSQL.java
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

public class PortTimePerformanceMgtDBDAOAddPortTimeKPIVersionListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 KPI 정보를 등록 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOAddPortTimeKPIVersionListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("grs_crn_prod_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_eff_dt_yy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstwg_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("net_crn_prod_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_cntr_mv_knt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOAddPortTimeKPIVersionListCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_PORT_TM_KPI" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  KPI_TGT_YR        " ).append("\n"); 
		query.append(", SLAN_CD           " ).append("\n"); 
		query.append(", VPS_PORT_CD       " ).append("\n"); 
		query.append(", KPI_VER_SEQ       " ).append("\n"); 
		query.append(", FM_EFF_DT          --05" ).append("\n"); 
		query.append(", TO_EFF_DT         " ).append("\n"); 
		query.append(", TTL_CNTR_MV_KNT   " ).append("\n"); 
		query.append(", STM_IN_HRS        " ).append("\n"); 
		query.append(", VSL_ARR_HRS       " ).append("\n"); 
		query.append(", TML_OP_HRS         --10" ).append("\n"); 
		query.append(", VSL_DEP_HRS       " ).append("\n"); 
		query.append(", STM_OUT_HRS       " ).append("\n"); 
		query.append(", PORT_STAY_HRS     " ).append("\n"); 
		query.append(", GRS_TML_PROD_HRS  " ).append("\n"); 
		query.append(", GRS_CRN_PROD_HRS   --15" ).append("\n"); 
		query.append(", NET_CRN_PROD_HRS  " ).append("\n"); 
		query.append(", TWN_LFT_HRS       " ).append("\n"); 
		query.append(", DUL_CYC_HRS       " ).append("\n"); 
		query.append(", RSTWG_HRS         " ).append("\n"); 
		query.append(", CRE_USR_ID         --20" ).append("\n"); 
		query.append(", CRE_DT            " ).append("\n"); 
		query.append(", UPD_USR_ID        " ).append("\n"); 
		query.append(", UPD_DT            " ).append("\n"); 
		query.append(", PORT_KPI_DIR_CD" ).append("\n"); 
		query.append(", CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[kpi_tgt_yr]              " ).append("\n"); 
		query.append(", @[slan_cd]" ).append("\n"); 
		query.append(", @[vps_port_cd]" ).append("\n"); 
		query.append(", @[kpi_ver_seq]             " ).append("\n"); 
		query.append(", TO_DATE(@[fm_eff_dt_yy]||@[fm_eff_dt_md], 'YYYYMMDD')                    --05" ).append("\n"); 
		query.append(", TO_DATE(@[to_eff_dt_yy]||@[to_eff_dt_md], 'YYYYMMDD')               " ).append("\n"); 
		query.append(", NVL(@[ttl_cntr_mv_knt]  , 0)        " ).append("\n"); 
		query.append(", NVL(@[stm_in_hrs]       , 0)        " ).append("\n"); 
		query.append(", NVL(@[vsl_arr_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[tml_op_hrs]       , 0)    --10" ).append("\n"); 
		query.append(", NVL(@[vsl_dep_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[stm_out_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[port_stay_hrs]    , 0)        " ).append("\n"); 
		query.append(", NVL(@[grs_tml_prod_hrs] , 0)        " ).append("\n"); 
		query.append(", NVL(@[grs_crn_prod_hrs] , 0)    --15" ).append("\n"); 
		query.append(", NVL(@[net_crn_prod_hrs] , 0)        " ).append("\n"); 
		query.append(", NVL(@[twn_lft_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[dul_cyc_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[rstwg_hrs]        , 0)        " ).append("\n"); 
		query.append(", @[cre_usr_id]                   --20" ).append("\n"); 
		query.append(", SYSDATE                  " ).append("\n"); 
		query.append(", @[upd_usr_id]              " ).append("\n"); 
		query.append(", SYSDATE                  " ).append("\n"); 
		query.append(", NVL(@[port_kpi_dir_cd] , 'A')" ).append("\n"); 
		query.append(", NVL(@[clpt_ind_seq]    , '1')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_chk}=='BSEL')" ).append("\n"); 
		query.append("INSERT INTO OPF_PORT_TM_BSEL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  BSEL_YR        " ).append("\n"); 
		query.append(", SLAN_CD           " ).append("\n"); 
		query.append(", VPS_PORT_CD       " ).append("\n"); 
		query.append(", BSEL_VER_SEQ       " ).append("\n"); 
		query.append(", FM_EFF_DT          --05" ).append("\n"); 
		query.append(", TO_EFF_DT         " ).append("\n"); 
		query.append(", TTL_CNTR_MV_KNT   " ).append("\n"); 
		query.append(", STM_IN_HRS        " ).append("\n"); 
		query.append(", VSL_ARR_HRS       " ).append("\n"); 
		query.append(", TML_OP_HRS         --10" ).append("\n"); 
		query.append(", VSL_DEP_HRS       " ).append("\n"); 
		query.append(", STM_OUT_HRS       " ).append("\n"); 
		query.append(", PORT_STAY_HRS     " ).append("\n"); 
		query.append(", GRS_TML_PROD_HRS  " ).append("\n"); 
		query.append(", GRS_CRN_PROD_HRS   --15" ).append("\n"); 
		query.append(", NET_CRN_PROD_HRS  " ).append("\n"); 
		query.append(", TWN_LFT_HRS       " ).append("\n"); 
		query.append(", DUL_CYC_HRS       " ).append("\n"); 
		query.append(", RSTWG_HRS         " ).append("\n"); 
		query.append(", CRE_USR_ID         --20" ).append("\n"); 
		query.append(", CRE_DT            " ).append("\n"); 
		query.append(", UPD_USR_ID        " ).append("\n"); 
		query.append(", UPD_DT            " ).append("\n"); 
		query.append(", PORT_BSEL_DIR_CD" ).append("\n"); 
		query.append(", CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[kpi_tgt_yr]              " ).append("\n"); 
		query.append(", @[slan_cd]" ).append("\n"); 
		query.append(", @[vps_port_cd]" ).append("\n"); 
		query.append(", 1             " ).append("\n"); 
		query.append(", TO_DATE(@[fm_eff_dt_yy]||@[fm_eff_dt_md], 'YYYYMMDD')                    --05" ).append("\n"); 
		query.append(", TO_DATE(@[to_eff_dt_yy]||@[to_eff_dt_md], 'YYYYMMDD')               " ).append("\n"); 
		query.append(", NVL(@[ttl_cntr_mv_knt]  , 0)        " ).append("\n"); 
		query.append(", NVL(@[stm_in_hrs]       , 0)        " ).append("\n"); 
		query.append(", NVL(@[vsl_arr_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[tml_op_hrs]       , 0)    --10" ).append("\n"); 
		query.append(", NVL(@[vsl_dep_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[stm_out_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[port_stay_hrs]    , 0)        " ).append("\n"); 
		query.append(", NVL(@[grs_tml_prod_hrs] , 0)        " ).append("\n"); 
		query.append(", NVL(@[grs_crn_prod_hrs] , 0)    --15" ).append("\n"); 
		query.append(", NVL(@[net_crn_prod_hrs] , 0)        " ).append("\n"); 
		query.append(", NVL(@[twn_lft_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[dul_cyc_hrs]      , 0)        " ).append("\n"); 
		query.append(", NVL(@[rstwg_hrs]        , 0)        " ).append("\n"); 
		query.append(", @[cre_usr_id]                   --20" ).append("\n"); 
		query.append(", SYSDATE                  " ).append("\n"); 
		query.append(", @[upd_usr_id]              " ).append("\n"); 
		query.append(", SYSDATE                  " ).append("\n"); 
		query.append(", NVL(@[port_kpi_dir_cd] , 'A')" ).append("\n"); 
		query.append(", NVL(@[clpt_ind_seq]    , '1')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}