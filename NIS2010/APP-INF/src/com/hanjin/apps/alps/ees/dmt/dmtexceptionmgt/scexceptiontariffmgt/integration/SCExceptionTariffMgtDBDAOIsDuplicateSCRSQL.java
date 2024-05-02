/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOIsDuplicateSCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOIsDuplicateSCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 S/C 가 기등록된 S/C 와 중복되는지를 조회하는쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOIsDuplicateSCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_fm_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOIsDuplicateSCRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(SC_GRP.SC_EXPT_GRP_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_SC_EXPT_GRP         SC_GRP" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_CVRG        SC_CVRG" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_ACT_CUST    SC_ACT_CUST" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_CMDT        SC_CMDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   SC_GRP.PROP_NO          	= @[prop_no]" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ  	= @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sc_expt_grp_seq} != '')" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ  	<> @[sc_expt_grp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.DMDT_TRF_CD      	= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(EFF_DT >= TO_DATE(@[eff_dt], 'YYYYMMDD') AND EFF_DT <= TO_DATE(@[exp_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(EFF_DT <= TO_DATE(@[eff_dt], 'YYYYMMDD') AND EXP_DT >= TO_DATE(@[eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SC_GRP.DMDT_CNTR_CGO_TP_CD 	= @[dmdt_cntr_cgo_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_FM_CONTI_CD	= NVL(@[sc_expt_fm_conti_cd], 	' ')" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_FM_CNT_CD	= NVL(@[sc_expt_fm_cnt_cd], 	' ')" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_FM_RGN_CD	= NVL(@[sc_expt_fm_rgn_cd], 	' ')" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_FM_STE_CD	= NVL(@[sc_expt_fm_ste_cd], 	' ')" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_FM_LOC_CD	= NVL(@[sc_expt_fm_loc_cd], 	' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.FNL_DEST_CNT_CD		= NVL(@[fnl_dest_cnt_cd], 		' ')" ).append("\n"); 
		query.append("AND SC_GRP.FNL_DEST_RGN_CD		= NVL(@[fnl_dest_rgn_cd], 		' ')" ).append("\n"); 
		query.append("AND SC_GRP.FNL_DEST_STE_CD		= NVL(@[fnl_dest_ste_cd], 		' ')" ).append("\n"); 
		query.append("AND SC_GRP.FNL_DEST_LOC_CD		= NVL(@[fnl_dest_loc_cd], 		' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rcv_de_term_cd} != '')" ).append("\n"); 
		query.append("AND SC_GRP.RCV_DE_TERM_CD 		= @[rcv_de_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SC_GRP.RCV_DE_TERM_CD 		IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.PROP_NO          = SC_CVRG.PROP_NO" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ  = SC_CVRG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ  = SC_CVRG.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(SC_CVRG.CNT_CD, SC_CVRG.RGN_CD, SC_CVRG.STE_CD, SC_CVRG.LOC_CD)" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $coverage in ${list_coverage} )" ).append("\n"); 
		query.append("#if($velocityCount < $list_coverage.size()) ($coverage), #else ($coverage) #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.PROP_NO          = SC_ACT_CUST.PROP_NO(+)" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ  = SC_ACT_CUST.SC_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ  = SC_ACT_CUST.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${act_cust_list} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(SC_ACT_CUST.CUST_CNT_CD, SC_ACT_CUST.CUST_SEQ)" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $act_cust in ${list_act_cust} )" ).append("\n"); 
		query.append("#if($velocityCount < $list_act_cust.size()) ($act_cust), #else ($act_cust) #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SC_ACT_CUST.CUST_CNT_CD IS NULL AND SC_ACT_CUST.CUST_SEQ IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SC_GRP.PROP_NO          = SC_CMDT.PROP_NO(+)" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ  = SC_CMDT.SC_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ  = SC_CMDT.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cmdt_list} != '')" ).append("\n"); 
		query.append("AND SC_CMDT.CMDT_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $cmdt in ${list_cmdt} )" ).append("\n"); 
		query.append("#if($velocityCount < $list_cmdt.size()) '$cmdt', #else '$cmdt' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SC_CMDT.CMDT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}