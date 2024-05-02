/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NetworkCostDBDAOSearchTrunkIPCPricingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.11.03 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchTrunkIPCPricingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
	  *                                                        - Trunk IPC Internal Pricing 화면 Retrieve 버튼적용 쿼리
	  * </pre>
	  */
	public NetworkCostDBDAOSearchTrunkIPCPricingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchTrunkIPCPricingRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	    DECODE(A.TRD_CD,NULL,'I','R') IBFLAG" ).append("\n"); 
		query.append("    ,	DECODE(A.TRD_CD,NULL,@[f_cost_yrmon],A.COST_YRMON) COST_YRMON" ).append("\n"); 
		query.append("    ,	ROWNUM NO" ).append("\n"); 
		query.append("    ,	B.TRD_CD" ).append("\n"); 
		query.append("    ,	DECODE(A.TRD_CD,NULL,0,A.INTER_PRC_UC_AMT) INTER_PRC_UC_AMT" ).append("\n"); 
		query.append("  FROM	COA_INTER_PRC_UT_COST A" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT	INTG_CD_VAL_CTNT AS TRD_CD" ).append("\n"); 
		query.append("			  FROM	COM_INTG_CD A," ).append("\n"); 
		query.append("			        COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("			 WHERE	A.INTG_CD_ID      =  B.INTG_CD_ID" ).append("\n"); 
		query.append("			   AND	A.INTG_CD_ID      = 'CD02765'" ).append("\n"); 
		query.append("			   AND	A.INTG_CD_USE_FLG = 'Y'" ).append("\n"); 
		query.append("		 ) B" ).append("\n"); 
		query.append(" WHERE	A.TRD_CD(+)     = B.TRD_CD" ).append("\n"); 
		query.append("   AND	A.COST_YRMON(+)	= @[f_cost_yrmon]" ).append("\n"); 
		query.append("   AND	A.DELT_FLG(+)   = 'N'" ).append("\n"); 

	}
}