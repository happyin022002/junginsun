/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeByOfficeTransferUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.02 
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

public class ChargeCalculationDBDAOChargeByOfficeTransferUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeByOfficeTransferUSQL(){
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
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChargeCalculationDBDAOChargeByOfficeTransferUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_CHG_CALC" ).append("\n"); 
		query.append("SET	 SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT TRIM(SUBSTR(LOC_CD, 1, 2))" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[to_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'	)" ).append("\n"); 
		query.append(",OFC_CD		= @[to_ofc_cd]" ).append("\n"); 
		query.append(",OFC_RHQ_CD	= (" ).append("\n"); 
		query.append("SELECT	OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("FROM	DMT_OFC_LVL_V" ).append("\n"); 
		query.append("WHERE	OFC_N8TH_LVL_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",UPD_DT		= NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(",UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_OFC_CD	= @[upd_ofc_cd]" ).append("\n"); 
		query.append(",OFC_TRNS_FLG	= 'Y'           /* Office Transfer Mark */" ).append("\n"); 
		query.append(",OFC_TRNS_RHQ_CNG_FLG =	'N'		/* Office Transfer to other RHQ Indicator */" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND	CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("AND CNTR_CYC_NO			= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND DMDT_TRF_CD			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND DMDT_CHG_LOC_DIV_CD	= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND CHG_SEQ				= @[chg_seq]" ).append("\n"); 
		query.append("AND	(DMDT_CHG_STS_CD ='F' OR DMDT_CHG_STS_CD = 'L' OR DMDT_CHG_STS_CD = 'N')" ).append("\n"); 

	}
}