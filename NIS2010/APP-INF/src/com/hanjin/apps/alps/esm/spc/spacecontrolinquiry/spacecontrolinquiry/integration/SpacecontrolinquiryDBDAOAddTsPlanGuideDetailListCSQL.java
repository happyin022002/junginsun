/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide detail]을 [insert]합니다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_port_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_port_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_pol_list_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_crr_list_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_pod_list_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_port_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pln_cfm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_port_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_port_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOAddTsPlanGuideDetailListCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_TS_PLN_GID_DTL " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            PLN_SEQ" ).append("\n"); 
		query.append("          , REP_TRD_CD" ).append("\n"); 
		query.append("          , REP_SUB_TRD_CD" ).append("\n"); 
		query.append("          , RLANE_CD" ).append("\n"); 
		query.append("          , VVD_CD" ).append("\n"); 
		query.append("          , IRR_PORT_CD" ).append("\n"); 
		query.append("          , IRR_YD_CD" ).append("\n"); 
		query.append("          , DIR_CD" ).append("\n"); 
		query.append("          , IOC_CD" ).append("\n"); 
		query.append("          , CNTR_FULL_FLG" ).append("\n"); 
		query.append("          , CNTR_MTY_FLG" ).append("\n"); 
		query.append("          , MLT_CRR_LIST_CTNT" ).append("\n"); 
		query.append("          , MLT_POL_LIST_CTNT" ).append("\n"); 
		query.append("          , N1ST_PORT_ETD_DT" ).append("\n"); 
		query.append("          , N1ST_RLANE_CD" ).append("\n"); 
		query.append("          , N1ST_VVD_CD" ).append("\n"); 
		query.append("          , N1ST_PORT_ETB_DT" ).append("\n"); 
		query.append("          , N1ST_POD_CD" ).append("\n"); 
		query.append("          , N1ST_POD_YD_CD" ).append("\n"); 
		query.append("          , N2ND_POL_CD" ).append("\n"); 
		query.append("          , N2ND_POL_YD_CD" ).append("\n"); 
		query.append("          , N2ND_PORT_ETD_DT" ).append("\n"); 
		query.append("          , N2ND_RLANE_CD" ).append("\n"); 
		query.append("          , N2ND_VVD_CD" ).append("\n"); 
		query.append("          , N2ND_PORT_ETB_DT" ).append("\n"); 
		query.append("          , N2ND_POD_CD" ).append("\n"); 
		query.append("          , N2ND_POD_YD_CD" ).append("\n"); 
		query.append("          , N3RD_POL_CD" ).append("\n"); 
		query.append("          , N3RD_POL_YD_CD" ).append("\n"); 
		query.append("          , N3RD_PORT_ETD_DT" ).append("\n"); 
		query.append("          , N3RD_RLANE_CD" ).append("\n"); 
		query.append("          , N3RD_VVD_CD" ).append("\n"); 
		query.append("          , N3RD_PORT_ETB_DT" ).append("\n"); 
		query.append("          , N3RD_POD_CD" ).append("\n"); 
		query.append("          , N3RD_POD_YD_CD" ).append("\n"); 
		query.append("          , N4TH_POL_CD" ).append("\n"); 
		query.append("          , N4TH_POL_YD_CD" ).append("\n"); 
		query.append("          , N4TH_PORT_ETD_DT" ).append("\n"); 
		query.append("          , N4TH_RLANE_CD" ).append("\n"); 
		query.append("          , N4TH_VVD_CD" ).append("\n"); 
		query.append("          , N4TH_PORT_ETB_DT" ).append("\n"); 
		query.append("          , N4TH_POD_CD" ).append("\n"); 
		query.append("          , N4TH_POD_YD_CD" ).append("\n"); 
		query.append("          , N5TH_POL_CD" ).append("\n"); 
		query.append("          , N5TH_POL_YD_CD" ).append("\n"); 
		query.append("          , N5TH_PORT_ETD_DT" ).append("\n"); 
		query.append("          , N5TH_RLANE_CD" ).append("\n"); 
		query.append("          , N5TH_VVD_CD" ).append("\n"); 
		query.append("          , N5TH_PORT_ETB_DT" ).append("\n"); 
		query.append("          , MLT_POD_LIST_CTNT" ).append("\n"); 
		query.append("          , TS_PLN_CFM_STS_CD" ).append("\n"); 
		query.append("          , TS_RMK" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("VALUES ( " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("           SELECT NVL(MAX(PLN_SEQ),0)+1" ).append("\n"); 
		query.append("            FROM  SPC_TS_PLN_GID_DTL" ).append("\n"); 
		query.append("            WHERE REP_TRD_CD     = @[rep_trd_cd]" ).append("\n"); 
		query.append("            AND   REP_SUB_TRD_CD = @[rep_sub_trd_cd]" ).append("\n"); 
		query.append("            AND   RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("            AND   VVD_CD         = @[vvd_cd]" ).append("\n"); 
		query.append("            AND   IRR_PORT_CD    = @[irr_port_cd]" ).append("\n"); 
		query.append("            AND   IRR_YD_CD      = @[irr_yd_cd]" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("          ,@[rep_trd_cd]" ).append("\n"); 
		query.append("          ,@[rep_sub_trd_cd]" ).append("\n"); 
		query.append("          ,@[rlane_cd]" ).append("\n"); 
		query.append("          ,@[vvd_cd]" ).append("\n"); 
		query.append("          ,@[irr_port_cd]" ).append("\n"); 
		query.append("          ,@[irr_yd_cd]" ).append("\n"); 
		query.append("          ,@[dir_cd]" ).append("\n"); 
		query.append("          ,@[ioc_cd]" ).append("\n"); 
		query.append("          ,DECODE(@[cntr_full_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("          ,DECODE(@[cntr_mty_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("          ,@[mlt_crr_list_ctnt]" ).append("\n"); 
		query.append("          ,@[mlt_pol_list_ctnt]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n1st_port_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n1st_rlane_cd]" ).append("\n"); 
		query.append("          ,@[n1st_vvd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n1st_port_etb_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n1st_pod_cd]" ).append("\n"); 
		query.append("          ,@[n1st_pod_yd_cd]" ).append("\n"); 
		query.append("          ,@[n2nd_pol_cd]" ).append("\n"); 
		query.append("          ,@[n2nd_pol_yd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n2nd_port_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n2nd_rlane_cd]" ).append("\n"); 
		query.append("          ,@[n2nd_vvd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n2nd_port_etb_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n2nd_pod_cd]" ).append("\n"); 
		query.append("          ,@[n2nd_pod_yd_cd]" ).append("\n"); 
		query.append("          ,@[n3rd_pol_cd]" ).append("\n"); 
		query.append("          ,@[n3rd_pol_yd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n3rd_port_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n3rd_rlane_cd]" ).append("\n"); 
		query.append("          ,@[n3rd_vvd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n3rd_port_etb_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n3rd_pod_cd]" ).append("\n"); 
		query.append("          ,@[n3rd_pod_yd_cd]" ).append("\n"); 
		query.append("          ,@[n4th_pol_cd]" ).append("\n"); 
		query.append("          ,@[n4th_pol_yd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n4th_port_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n4th_rlane_cd]" ).append("\n"); 
		query.append("          ,@[n4th_vvd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n4th_port_etb_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n4th_pod_cd]" ).append("\n"); 
		query.append("          ,@[n4th_pod_yd_cd]" ).append("\n"); 
		query.append("          ,@[n5th_pol_cd]" ).append("\n"); 
		query.append("          ,@[n5th_pol_yd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n5th_port_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[n5th_rlane_cd]" ).append("\n"); 
		query.append("          ,@[n5th_vvd_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[n5th_port_etb_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[mlt_pod_list_ctnt]" ).append("\n"); 
		query.append("          ,@[ts_pln_cfm_sts_cd]" ).append("\n"); 
		query.append("          ,@[ts_rmk]" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,sysdate" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,sysdate " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}