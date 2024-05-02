/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProductCatalogInternalDetail
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL").append("\n"); 
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
		query.append("SELECT DECODE(nod_lnk_div_cd, 'N', org_nod_cd, org_nod_cd || ' -> ' || dest_nod_cd) node_link," ).append("\n"); 
		query.append("		'Planned' trans_st, " ).append("\n"); 
		query.append("		DECODE(trsp_mod_cd,'X','',trsp_mod_cd) trsp_mod_cd," ).append("\n"); 
		query.append("		LTRIM(TO_CHAR (TRUNC (tz_dwll_tm_hrs / 24, 0), '00'))" ).append("\n"); 
		query.append("		|| LTRIM (TO_CHAR (MOD (tz_dwll_tm_hrs, 24), '00')) fmt_tz_dwll_tm," ).append("\n"); 
		query.append("		TO_CHAR (arr_st_dt, 'MON DD HH24:MI') arr_time," ).append("\n"); 
		query.append("		TO_CHAR (dep_fsh_dt, 'MON DD HH24:MI') dep_time," ).append("\n"); 
		query.append("		CASE WHEN vsl_cd IS NOT NULL AND  skd_voy_no IS NOT NULL AND skd_dir_cd IS NOT NULL THEN vsl_slan_cd||'-'||vsl_cd || TRIM (TO_CHAR (skd_voy_no, '0000')) || skd_dir_cd" ).append("\n"); 
		query.append("  			 ELSE 'N'" ).append("\n"); 
		query.append("		END vvd,                                                                                 			" ).append("\n"); 
		query.append("		DECODE(TRIM(cnst_flg), 'X', '1', '3') remark_img, " ).append("\n"); 
		query.append("		DECODE(TRIM(cnst_flg), 'X','N',NULL,NULL,'Y') remark, " ).append("\n"); 
		query.append("		gen_aval_spc, d7_aval_spc, rf_aval_spc, pctl_no," ).append("\n"); 
		query.append("		pctl_seq, vsl_slan_cd,rout_org_nod_cd, rout_dest_nod_cd," ).append("\n"); 
		query.append("		CASE WHEN trsp_mod_cd IN ('WD', 'VD') AND nod_lnk_div_cd = 'L' AND vsl_slan_cd > ' ' THEN 'T'" ).append("\n"); 
		query.append("             ELSE 'F'" ).append("\n"); 
		query.append("		END AS vvd_gb," ).append("\n"); 
		query.append("		TO_CHAR (arr_st_dt, 'yyyymmddhh24miss') etd," ).append("\n"); 
		query.append("		TO_CHAR (dep_fsh_dt, 'yyyymmddhh24miss') etb," ).append("\n"); 
		query.append("		org_nod_cd, dest_nod_cd," ).append("\n"); 
		query.append("		pctl_wtr_div_cd, nod_lnk_div_cd, mty_yd_flg," ).append("\n"); 
		query.append("		CASE WHEN nod_lnk_div_cd='N' AND PCTL_IO_BND_CD='O' AND ORG_NOD_TP_CD ='Z' AND DEST_NOD_TP_CD ='Z' THEN   'Y'" ).append("\n"); 
		query.append("			 ELSE 'N'" ).append("\n"); 
		query.append("		END AS door_dt," ).append("\n"); 
		query.append("		TO_CHAR(max(dep_fsh_dt) over (partition by nod_lnk_div_cd,mty_yd_flg) ,'yyyymmddhh24miss')as delivery_dt," ).append("\n"); 
		query.append("		(SELECT" ).append("\n"); 
		query.append("			CASE WHEN max(DECODE(trsp_mod_cd,'WD',trsp_mod_cd,'')) = 'WD' THEN 'W'" ).append("\n"); 
		query.append("				 WHEN max(DECODE(trsp_mod_cd,'RD',trsp_mod_cd,'')) = 'RD' THEN 'R'" ).append("\n"); 
		query.append("				 WHEN max(DECODE(trsp_mod_cd,'TD',trsp_mod_cd,'')) = 'TD' THEN 'T'" ).append("\n"); 
		query.append("			END otm" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT trsp_mod_cd ,  row_number() over(partition by trsp_mod_cd order by trsp_mod_cd) no" ).append("\n"); 
		query.append("			FROM prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("			WHERE  pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("			AND pctl_io_bnd_cd ='O'" ).append("\n"); 
		query.append("			AND  nod_lnk_div_cd='L'" ).append("\n"); 
		query.append("			group by trsp_mod_cd" ).append("\n"); 
		query.append("			)	" ).append("\n"); 
		query.append("		) 	o_t_mode," ).append("\n"); 
		query.append("		(SELECT" ).append("\n"); 
		query.append("				CASE WHEN max(DECODE(trsp_mod_cd,'WD',trsp_mod_cd,'')) = 'WD' THEN 'W'" ).append("\n"); 
		query.append("					 WHEN max(DECODE(trsp_mod_cd,'RD',trsp_mod_cd,'')) = 'RD' THEN 'R'" ).append("\n"); 
		query.append("					 WHEN max(DECODE(trsp_mod_cd,'TD',trsp_mod_cd,'')) = 'TD' THEN 'T'" ).append("\n"); 
		query.append("				END itm" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT trsp_mod_cd ,  row_number() over(partition by trsp_mod_cd order by trsp_mod_cd) no" ).append("\n"); 
		query.append("				FROM prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("				WHERE  pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("				AND pctl_io_bnd_cd ='I'" ).append("\n"); 
		query.append("				AND  nod_lnk_div_cd='L'" ).append("\n"); 
		query.append("				group by trsp_mod_cd" ).append("\n"); 
		query.append("			)	" ).append("\n"); 
		query.append("		) 	i_t_mode,		" ).append("\n"); 
		query.append("  	 	(SELECT" ).append("\n"); 
		query.append("			min(pctl_seq)" ).append("\n"); 
		query.append("  			FROM prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("  			WHERE  pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("  			AND trsp_mod_cd in ('WD','VD')" ).append("\n"); 
		query.append("  			AND pctl_io_bnd_cd = 'T'		" ).append("\n"); 
		query.append("		) load_dt_pctl_seq," ).append("\n"); 
		query.append("		(SELECT min(pctl_seq)" ).append("\n"); 
		query.append("			FROM prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("  			WHERE  pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("  			AND pctl_io_bnd_cd = 'O'" ).append("\n"); 
		query.append("  			AND nod_lnk_div_cd = 'N'" ).append("\n"); 
		query.append("  			AND mty_yd_flg = 'N'		" ).append("\n"); 
		query.append("			AND org_nod_tp_cd <> 'Z'" ).append("\n"); 
		query.append("		) fl_rt_cy_pctl_seq                                 			" ).append("\n"); 
		query.append("FROM prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("WHERE ((pctl_no =  @[pctl_no]))" ).append("\n"); 
		query.append("ORDER BY pctl_seq" ).append("\n"); 

	}
}