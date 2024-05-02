/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeTransferStatusByOfficeTransferUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeTransferStatusByOfficeTransferUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyChargeTransferStatusByOfficeTransfer
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeTransferStatusByOfficeTransferUSQL(){
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
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChargeCalculationDBDAOChargeTransferStatusByOfficeTransferUSQL").append("\n"); 
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
		query.append("--UPDATE	DMT_CHG_CALC" ).append("\n"); 
		query.append("--SET		DMDT_CHG_STS_CD	= 'T'	/* Transferred */" ).append("\n"); 
		query.append("DELETE FROM DMT_CHG_CALC A" ).append("\n"); 
		query.append("WHERE	A.SYS_AREA_GRP_ID	= @[fm_svr_id]" ).append("\n"); 
		query.append("AND		A.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		A.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		A.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		A.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		A.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND		EXISTS ( SELECT 'X' FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("                  WHERE SYS_AREA_GRP_ID = (" ).append("\n"); 
		query.append("                                        SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                        FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                        WHERE   CNT_CD      = (" ).append("\n"); 
		query.append("                                                              SELECT  TRIM(SUBSTR(LOC_CD, 1, 2))" ).append("\n"); 
		query.append("                                                              FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                              WHERE   OFC_CD      = @[to_ofc_cd]" ).append("\n"); 
		query.append("                                                              ) " ).append("\n"); 
		query.append("                                        AND     CO_IND_CD   = 'H'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                    AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                    AND CNTR_CYC_NO = A.CNTR_CYC_NO" ).append("\n"); 
		query.append("					AND DMDT_TRF_CD = A.DMDT_TRF_CD" ).append("\n"); 
		query.append("					AND DMDT_CHG_LOC_DIV_CD = A.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					AND CHG_SEQ = A.CHG_SEQ )" ).append("\n"); 

	}
}