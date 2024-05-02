/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOBookingContainerByOfficeTransferCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.02.11 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOBookingContainerByOfficeTransferCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOBookingContainerByOfficeTransferCSQL(){
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
		params.put("fm_svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOBookingContainerByOfficeTransferCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_CYC_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",ESTM_TM_OF_ARR_DT" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",RFA_NO" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",DCGO_FLG" ).append("\n"); 
		query.append(",RC_FLG" ).append("\n"); 
		query.append(",BB_CGO_FLG" ).append("\n"); 
		query.append(",AWK_CGO_FLG" ).append("\n"); 
		query.append(",RD_CGO_FLG" ).append("\n"); 
		query.append(",SOC_FLG" ).append("\n"); 
		query.append(",CNTR_PRT_FLG" ).append("\n"); 
		query.append(",ADV_SHTG_CD" ).append("\n"); 
		query.append(",DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",BKG_CNTR_QTY" ).append("\n"); 
		query.append(",SLS_OFC_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(	SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT TRIM(SUBSTR(LOC_CD, 1, 2))" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[to_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'	)" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_CYC_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",ESTM_TM_OF_ARR_DT" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",RFA_NO" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",DCGO_FLG" ).append("\n"); 
		query.append(",RC_FLG" ).append("\n"); 
		query.append(",BB_CGO_FLG" ).append("\n"); 
		query.append(",AWK_CGO_FLG" ).append("\n"); 
		query.append(",RD_CGO_FLG" ).append("\n"); 
		query.append(",SOC_FLG" ).append("\n"); 
		query.append(",CNTR_PRT_FLG" ).append("\n"); 
		query.append(",ADV_SHTG_CD" ).append("\n"); 
		query.append(",DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",BKG_CNTR_QTY" ).append("\n"); 
		query.append(",SLS_OFC_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID	= @[fm_svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 

	}
}