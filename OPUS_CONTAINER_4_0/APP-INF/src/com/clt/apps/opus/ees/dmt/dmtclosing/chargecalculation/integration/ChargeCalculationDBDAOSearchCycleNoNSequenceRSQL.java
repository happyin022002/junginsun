/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.03.23 황효근
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

public class ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL").append("\n"); 
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
		query.append("SELECT  /*+ INDEX_DESC( DMT_CHG_CALC XPKDMT_CHG_CALC ) */" ).append("\n"); 
		query.append("CNTR_CYC_NO" ).append("\n"); 
		query.append(",DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID	= ( SELECT	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM 	COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE	CNT_CD = (	SELECT TRIM(SUBSTR(LOC_CD, 1, 2))" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND		CO_IND_CD = 'H')" ).append("\n"); 
		query.append("AND     CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_STS_CD	IN	('C', 'D', 'E', 'F', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chg_type} == 'G')" ).append("\n"); 
		query.append("AND     CHG_SEQ = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     CHG_SEQ > 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}