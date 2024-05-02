/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOOfficeNRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOOfficeNRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOOfficeNRHQRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOOfficeNRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOOfficeNRHQRSQL").append("\n"); 
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
		query.append("SELECT   D.FM_OFC_CD" ).append("\n"); 
		query.append(",D.TO_OFC_CD" ).append("\n"); 
		query.append("--O.OFC_N3RD_LVL_CD                /* RHQ Office code */" ).append("\n"); 
		query.append("FROM    DMT_OFC_TRNS_HIS    D" ).append("\n"); 
		query.append("--DMT_OFC_LCL_V       O" ).append("\n"); 
		query.append("WHERE   D.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		D.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		D.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		D.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		D.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		D.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("--AND     D.TO_OFC_CD = O.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("--AND     OFC_KND_CD  = 6" ).append("\n"); 
		query.append("AND     D.OFC_TRNS_SEQ = (" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC( DMT_OFC_TRNS_HIS XPKDD_OFC_TRANS ) */" ).append("\n"); 
		query.append("OFC_TRNS_SEQ" ).append("\n"); 
		query.append("FROM    DMT_OFC_TRNS_HIS" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}