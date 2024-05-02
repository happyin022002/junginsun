/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchRdContentsMainSubRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchRdContentsMainSubRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRdContentsMainSub
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchRdContentsMainSubRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchRdContentsMainSubRSQL").append("\n"); 
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
		query.append("SELECT SUM(CASE WHEN so.eq_knd_cd = 'U' AND SUBSTR(so.eq_tpsz_cd,2,1) = '2'" ).append("\n"); 
		query.append("        		  THEN 1" ).append("\n"); 
		query.append("      			 ELSE 0" ).append("\n"); 
		query.append("   			END) as total_20" ).append("\n"); 
		query.append("		,SUM(CASE WHEN so.eq_knd_cd = 'U'" ).append("\n"); 
		query.append("			        AND SUBSTR(so.eq_tpsz_cd,2,1) = '2'" ).append("\n"); 
		query.append("			      THEN 0" ).append("\n"); 
		query.append("			       ELSE 1" ).append("\n"); 
		query.append("		     END)  as total_40" ).append("\n"); 
		query.append("		,SUM(CASE WHEN so.eq_knd_cd = 'U'" ).append("\n"); 
		query.append("		   			THEN 1" ).append("\n"); 
		query.append("		  		  ELSE 0" ).append("\n"); 
		query.append("			  END) as total_qnt" ).append("\n"); 
		query.append("		,TO_CHAR(SUM(NVL(tmp.usd_ttl_amt,0))) as total_amt_usd" ).append("\n"); 
		query.append("		,TO_CHAR(SUM(NVL(tmp.bzc_amt, 0)+ NVL(tmp.nego_amt, 0)+NVL(tmp.etc_add_amt, 0)+NVL(tmp.fuel_scg_amt, 0)+NVL(tmp.scg_vat_amt, 0)+NVL(tmp.toll_fee_amt, 0))) as total_amt" ).append("\n"); 
		query.append("		,MAX(tmp.curr_cd) as curr_cd" ).append("\n"); 
		query.append("	FROM trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append("		,trs_trsp_svc_ord so " ).append("\n"); 
		query.append("   WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  	 AND tmp.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("  	 AND tmp.trsp_so_ofc_cty_cd = so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("  	 AND tmp.trsp_so_seq = so.trsp_so_seq" ).append("\n"); 
		query.append("  	 AND nvl(tmp.wo_cxl_flg,'N') = 'N'" ).append("\n"); 
		query.append("  	 AND so.hjl_no IS NULL" ).append("\n"); 

	}
}