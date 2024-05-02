/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Main Knt
	  * </pre>
	  */
	public WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dvsnA",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dvsnB",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL").append("\n"); 
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
		query.append("select 'W' dvsn, count(1) cnt" ).append("\n"); 
		query.append("from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append("where a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("and CASE WHEN a.wo_opn_flg IS NULL THEN 'N' ELSE a.wo_opn_flg END <> 'Y'" ).append("\n"); 
		query.append("and CASE WHEN a.delt_flg   IS NULL THEN 'N' ELSE a.delt_flg END <> 'Y'" ).append("\n"); 
		query.append("and a.wo_iss_sts_cd in ('I','R')" ).append("\n"); 
		query.append("and CASE WHEN a.inter_use_flg IS NULL THEN 'N' ELSE a.inter_use_flg END <> 'Y'" ).append("\n"); 
		query.append("-- apnt_dt/de_dt set-up status 제외" ).append("\n"); 
		query.append("and 'NEW' = ( select decode(count(*), 0, 'NEW', 'OPEN')" ).append("\n"); 
		query.append("from trs_trsp_svc_ord" ).append("\n"); 
		query.append("where trsp_wo_ofc_cty_cd = a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("and trsp_wo_seq = a.trsp_wo_seq" ).append("\n"); 
		query.append("and (apnt_dt is not null or de_dt is not null)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND @[dvsnA] = 'Y'" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT 'I' dvsn,count(*) cnt" ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk INV" ).append("\n"); 
		query.append("WHERE INV.inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 
		query.append("AND INV.trsp_inv_aud_sts_cd IN ('RC')" ).append("\n"); 
		query.append("AND NVL(INV.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append("AND @[dvsnA] = 'Y'" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT 'R' dvsn, count(*) cnt" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append(",trs_trsp_rail_bil_vndr_set b" ).append("\n"); 
		query.append(",trs_trsp_edi_rail_ord c" ).append("\n"); 
		query.append("WHERE a.prov_vndr_seq = @[prov_vndr_seq]" ).append("\n"); 
		query.append("AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND a.locl_cre_dt BETWEEN TO_DATE(TO_CHAR(SYSDATE - 7, 'yyyymmdd') || '000000', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(SYSDATE, 'yyyymmdd') || '235959', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND b.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND b.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("AND c.trsp_so_ofc_cty_cd = b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("AND c.trsp_so_seq = b.trsp_so_seq" ).append("\n"); 
		query.append("AND trim(c.vndr_seq) = b.vndr_seq" ).append("\n"); 
		query.append("AND c.bil_iss_sts_cd = 'I'" ).append("\n"); 
		query.append("AND trim(c.bil_edi_rcv_rslt_cd) = 'A'" ).append("\n"); 
		query.append("AND NVL(c.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND c.bil_edi_rcv_rslt_dt BETWEEN TO_DATE(TO_CHAR(SYSDATE - 7, 'yyyymmdd') || '000000', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(SYSDATE, 'yyyymmdd') || '235959', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("AND @[dvsnB] = 'Y'" ).append("\n"); 

	}
}