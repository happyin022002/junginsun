/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOMdmCntrTpSzVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.25 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOMdmCntrTpSzVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingUtilDBDAOMdmCntrTpSzVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("cntr_sz_cd," ).append("\n"); 
		query.append("cntr_tp_cd," ).append("\n"); 
		query.append("cntr_tpsz_lodg_wgt," ).append("\n"); 
		query.append("cntr_tpsz_lodg_capa," ).append("\n"); 
		query.append("cntr_tpsz_tare_wgt," ).append("\n"); 
		query.append("cntr_tpsz_desc," ).append("\n"); 
		query.append("cntr_tpsz_rmk," ).append("\n"); 
		query.append("cntr_tpsz_psa_cd," ).append("\n"); 
		query.append("cntr_tpsz_iso_cd," ).append("\n"); 
		query.append("modi_cntr_tpsz_cd," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("eai_evnt_dt," ).append("\n"); 
		query.append("cntr_tpsz_grp_cd," ).append("\n"); 
		query.append("rpt_dp_seq," ).append("\n"); 
		query.append("aciac_div_cd" ).append("\n"); 
		query.append("from mdm_cntr_tp_sz" ).append("\n"); 
		query.append("where	1=1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("and cntr_tpsz_cd = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by cntr_tpsz_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOMdmCntrTpSzVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}