/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.07.12 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Full Cntr Request (Cntr List)화면에 대한 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL").append("\n"); 
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
		query.append("SELECT 'Y' io_flag                                                                                                             " ).append("\n"); 
		query.append("                   ,a.trsp_so_ofc_cty_cd so_ofc_cty_cd                                                                                      " ).append("\n"); 
		query.append("                   ,TO_CHAR(a.trsp_so_seq)  so_seq                                                                                          " ).append("\n"); 
		query.append("                   ,a.eq_no cntr_no                                                                                                         " ).append("\n"); 
		query.append("                   ,a.eq_tpsz_cd cntr_tpsz_cd                                                                                               " ).append("\n"); 
		query.append("                   ,b.cntr_tpsz_rmk cntr_tpsz_nm                                                                                            " ).append("\n"); 
		query.append("                   ,TO_CHAR(a.pck_qty) pkg_qty                                                                                              " ).append("\n"); 
		query.append("                   ,TO_CHAR(a.cntr_wgt) wgt_qty                                                                                             " ).append("\n"); 
		query.append("                   ,a.auto_xpt_sys_cd                                                                                                       " ).append("\n"); 
		query.append("                   ,a.auto_xpt_sys_no                                                                                                       " ).append("\n"); 
		query.append("                   ,'' remark_desc                                                                                                          " ).append("\n"); 
		query.append("                   ,'1' bkg_qty                                                                                                             " ).append("\n"); 
		query.append("                   ,NVL(a.blk_flg, 'N') bulk_flag                                                                                           " ).append("\n"); 
		query.append("                   ,NVL(a.stel_wire_flg,'N') steel_flag                                                                                     " ).append("\n"); 
		query.append("                   ,NVL(a.coil_shp_flg, 'N') coil_flag                                                                                      " ).append("\n"); 
		query.append("                   ,NVL(a.fumg_flg, 'N') fum_flag                                                                                           " ).append("\n"); 
		query.append("                   ,NVL(a.spnd_flg, 'N') spnd_flg                                                                                           " ).append("\n"); 
		query.append("                   ,'N' dvsn" ).append("\n"); 
		query.append("				   ,DECODE(e.TARE_WGT, NULL, (" ).append("\n"); 
		query.append("        				SELECT TO_CHAR(ROUND((CNTR_TPSZ_TARE_WGT) * 2.2046, 0))" ).append("\n"); 
		query.append("        				FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("        				WHERE CNTR_TPSZ_CD = d.CNTR_TPSZ_CD ), TO_CHAR(ROUND((e.TARE_WGT) * 2.2046, 0))) tare_wgt" ).append("\n"); 
		query.append("               FROM (SELECT trsp_so_ofc_cty_cd                                                                                              " ).append("\n"); 
		query.append("                           ,trsp_so_seq                                                                                                     " ).append("\n"); 
		query.append("                           ,(CASE                                                                                                           " ).append("\n"); 
		query.append("                                WHEN trsp_so_sts_cd = 'C' AND delt_flg = 'Y'                                                                " ).append("\n"); 
		query.append("                                   THEN 'N'                                                                                                 " ).append("\n"); 
		query.append("                                WHEN (trsp_so_sts_cd IN('C', 'R') AND delt_flg = 'Y') OR (cxl_rqst_flg = 'Y' AND cxl_rqst_rjct_flg = 'N')   " ).append("\n"); 
		query.append("                                   THEN 'N'                                                                                                 " ).append("\n"); 
		query.append("                                WHEN trsp_so_sts_cd = 'I' AND delt_flg = 'Y'                                                                " ).append("\n"); 
		query.append("                                   THEN 'N'                                                                                                 " ).append("\n"); 
		query.append("                                ELSE 'Y'                                                                                                    " ).append("\n"); 
		query.append("                             END                                                                                                            " ).append("\n"); 
		query.append("                            ) status_cd                                                                                                     " ).append("\n"); 
		query.append("                       FROM trs_trsp_rail_bil_ord a                                                                                         " ).append("\n"); 
		query.append("                      WHERE bkg_no = UPPER(@[bkg_no])                                                                                                      " ).append("\n"); 
		query.append("                      ) x                                                                                             " ).append("\n"); 
		query.append("                   ,trs_trsp_rail_bil_ord a                                                                                                 " ).append("\n"); 
		query.append("                   ,mdm_cntr_tp_sz b                                                                                                        " ).append("\n"); 
		query.append("                   ,sce_cop_hdr c" ).append("\n"); 
		query.append("				   ,MST_CONTAINER d" ).append("\n"); 
		query.append("                   ,MST_CNTR_SPEC e                                                                                                        	" ).append("\n"); 
		query.append("              WHERE a.trsp_so_ofc_cty_cd = x.trsp_so_ofc_cty_cd                                                                             " ).append("\n"); 
		query.append("                AND a.trsp_so_seq = x.trsp_so_seq                                                                                           " ).append("\n"); 
		query.append("                AND a.eq_tpsz_cd = b.cntr_tpsz_cd                                                                                           " ).append("\n"); 
		query.append("                AND x.status_cd = 'Y'                                                                                                       " ).append("\n"); 
		query.append("                AND c.cop_no(+) = a.cop_no" ).append("\n"); 
		query.append("				AND d.CNTR_SPEC_NO = e.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("  				AND a.eq_no = d.CNTR_NO(+)" ).append("\n"); 
		query.append("            UNION ALL  " ).append("\n"); 
		query.append("             SELECT  /*+ leading(a b c)*/                                                                                                   " ).append("\n"); 
		query.append("                      'N'                                                                                                                   " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,a.cntr_tpsz_cd                                                                                                        " ).append("\n"); 
		query.append("                     ,MAX(c.cntr_tpsz_rmk) cntr_tpsz_nm                                                                                     " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,TO_CHAR(COUNT(*)) cntr_qty                                                                                            " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,''                                                                                                                    " ).append("\n"); 
		query.append("                     ,(select max(dvsn)														" ).append("\n"); 
		query.append("                   	   from                                                       		" ).append("\n"); 
		query.append("                   			(SELECT 		DISTINCT(SUBSTR((POL_NOD_CD), 1,2)) dvsn    	" ).append("\n"); 
		query.append("                   			   FROM		SCE_COP_HDR 					        		" ).append("\n"); 
		query.append("                   			  WHERE 		BKG_NO 	 		= UPPER(@[bkg_no])        				" ).append("\n"); 
		query.append("                   			  						" ).append("\n"); 
		query.append("                   			 )                                                     		" ).append("\n"); 
		query.append("                   	   where rownum = 1) dvsn	" ).append("\n"); 
		query.append("					 ,''	                                	" ).append("\n"); 
		query.append("                 FROM sce_cop_hdr a                                                                                                         " ).append("\n"); 
		query.append("                     ,sce_pln_so_list b                                                                                                    " ).append("\n"); 
		query.append("                     ,mdm_cntr_tp_sz c                                                                                                      " ).append("\n"); 
		query.append("                WHERE a.cop_no = b.cop_no                                                                                                   " ).append("\n"); 
		query.append("                  AND a.cntr_tpsz_cd = c.cntr_tpsz_cd                                                                                       " ).append("\n"); 
		query.append("                  AND a.cop_sts_cd IN ('C', 'T', 'F')                                                                                       " ).append("\n"); 
		query.append("                  AND 'P' = decode(a.cop_no,a.mst_cop_no,'P','X')                                                                                           " ).append("\n"); 
		query.append("                  AND a.bkg_no = UPPER(@[bkg_no])                                                                                                           " ).append("\n"); 
		query.append("                  AND SUBSTR(b.pctl_io_bnd_cd, 1, 1) = 'O'                                                                                  " ).append("\n"); 
		query.append("                  AND b.trsp_mod_cd = 'RD'                                                                                                  " ).append("\n"); 
		query.append("                  AND b.trsp_so_sts_cd = 'P'                                                                                                " ).append("\n"); 
		query.append("             GROUP BY a.cntr_tpsz_cd                                                                                                        " ).append("\n"); 
		query.append("             ORDER BY so_ofc_cty_cd, so_seq" ).append("\n"); 

	}
}