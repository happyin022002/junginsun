/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOBalanceCreationChargeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.11
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.11 황효근
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

public class ChargeCalculationDBDAOBalanceCreationChargeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status가 F, C, I 이고, Balance Charge가 없거나 있일 경우 마지막 Balance Charge 이면서  To MVMT Status가 'DR' 인 Charge의 일부 정보를 조회한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOBalanceCreationChargeVORSQL(){
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
		query.append("FileName : ChargeCalculationDBDAOBalanceCreationChargeVORSQL").append("\n"); 
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
		query.append("SELECT	FM_MVMT_STS_CD," ).append("\n"); 
		query.append("TO_CHAR(FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT," ).append("\n"); 
		query.append("FM_MVMT_YD_CD," ).append("\n"); 
		query.append("TO_MVMT_STS_CD," ).append("\n"); 
		query.append("TO_CHAR(TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT," ).append("\n"); 
		query.append("TO_MVMT_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	SYS_AREA_GRP_ID		=	@[svr_id]" ).append("\n"); 
		query.append("AND		CNTR_NO				=	@[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO			=	@[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD			=	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD	=	@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ				=	@[chg_seq]" ).append("\n"); 
		query.append("AND		DMDT_CHG_STS_CD		IN	('F', 'C', 'I')" ).append("\n"); 
		query.append("AND		TO_MVMT_STS_CD		=	'DR'" ).append("\n"); 

	}
}