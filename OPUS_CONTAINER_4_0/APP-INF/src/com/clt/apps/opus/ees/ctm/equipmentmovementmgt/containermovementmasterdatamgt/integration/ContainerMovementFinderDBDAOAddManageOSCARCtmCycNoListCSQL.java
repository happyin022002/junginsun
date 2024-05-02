/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOAddManageOSCARCtmCycNoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOAddManageOSCARCtmCycNoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOAddManageOSCARCtmCycNoListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("osca_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("osca_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edw_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOAddManageOSCARCtmCycNoListCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_BKG_CNTR" ).append("\n"); 
		query.append("            (BKG_NO," ).append("\n"); 
		query.append("            CNTR_NO," ).append("\n"); 
		query.append("            CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            CNMV_YR," ).append("\n"); 
		query.append("            CNMV_ID_NO," ).append("\n"); 
		query.append("            CNMV_CYC_NO," ).append("\n"); 
		query.append("            CNMV_STS_CD," ).append("\n"); 
		query.append("            RCV_TERM_CD," ).append("\n"); 
		query.append("            DE_TERM_CD," ).append("\n"); 
		query.append("            CNTR_VOL_QTY," ).append("\n"); 
		query.append("            DCGO_FLG," ).append("\n"); 
		query.append("            RC_FLG," ).append("\n"); 
		query.append("            BB_CGO_FLG," ).append("\n"); 
		query.append("            AWK_CGO_FLG," ).append("\n"); 
		query.append("            RD_CGO_FLG," ).append("\n"); 
		query.append("            HNGR_FLG," ).append("\n"); 
		query.append("            SOC_FLG," ).append("\n"); 
		query.append("            CNMV_EVNT_DT," ).append("\n"); 
		query.append("            CNTR_CFM_FLG," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT," ).append("\n"); 
		query.append("            EDW_UPD_DT," ).append("\n"); 
		query.append("            OSCA_CRE_DT," ).append("\n"); 
		query.append("            OSCA_UPD_DT," ).append("\n"); 
		query.append("            CYC_UPD_USR_ID," ).append("\n"); 
		query.append("            CYC_UPD_DT," ).append("\n"); 
		query.append("            MNL_INP_TP_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES (@[bkg_no]," ).append("\n"); 
		query.append("            @[cntr_no]," ).append("\n"); 
		query.append("            (SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM MST_CONTAINER" ).append("\n"); 
		query.append("            WHERE CNTR_NO=@[cntr_no])," ).append("\n"); 
		query.append("            NVL(@[cnmv_yr], '')," ).append("\n"); 
		query.append("            NVL(@[cnmv_id_no], '')," ).append("\n"); 
		query.append("            NVL(@[cnmv_cyc_no], '')," ).append("\n"); 
		query.append("            NVL(@[cnmv_sts_cd], '')," ).append("\n"); 
		query.append("            (SELECT RCV_TERM_CD" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT DE_TERM_CD" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            NVL(@[cntr_vol_qty], 1)," ).append("\n"); 
		query.append("            (SELECT DCGO_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT RC_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT BB_CGO_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT AWK_CGO_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT RD_CGO_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT HNGR_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            (SELECT SOC_FLG" ).append("\n"); 
		query.append("            FROM CTM_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no])," ).append("\n"); 
		query.append("            NVL(@[cnmv_evnt_dt], '')," ).append("\n"); 
		query.append("            NVL(@[cntr_cfm_flg], 'Y')," ).append("\n"); 
		query.append("            @[delt_usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[delt_usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            NVL(@[edw_upd_dt], '')," ).append("\n"); 
		query.append("            NVL(@[osca_cre_dt], '')," ).append("\n"); 
		query.append("            NVL(@[osca_upd_dt], '')," ).append("\n"); 
		query.append("            ''," ).append("\n"); 
		query.append("            ''," ).append("\n"); 
		query.append("            'M'" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}