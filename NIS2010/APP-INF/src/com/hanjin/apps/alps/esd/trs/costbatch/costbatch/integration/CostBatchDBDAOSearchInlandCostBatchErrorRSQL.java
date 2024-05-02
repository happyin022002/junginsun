/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOSearchInlandCostBatchErrorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOSearchInlandCostBatchErrorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.30 변종건 [CHM-201217633] Inland Cost Batch Error Inquiry
	  * </pre>
	  */
	public CostBatchDBDAOSearchInlandCostBatchErrorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOSearchInlandCostBatchErrorRSQL").append("\n"); 
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
		query.append("SELECT  COST_TRF_NO" ).append("\n"); 
		query.append(", SUBSTR(PORT_NOD_CD,1,5)||'-'||SUBSTR(LOC_NOD_CD,1,5) PORT_LOC" ).append("\n"); 
		query.append(", DECODE(RCV_DE_TERM_CD,'D','DR','CY') RCV_DE_TERM_CD" ).append("\n"); 
		query.append(", PORT_NOD_CD" ).append("\n"); 
		query.append(", HUB_NOD_CD" ).append("\n"); 
		query.append(", LOC_NOD_CD" ).append("\n"); 
		query.append(", TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(", COST_ERR_CD" ).append("\n"); 
		query.append(", SUBSTR(ERR_DESC, 1, DECODE(INSTR(ERR_DESC, '#', 1, 1) -1,-1,LENGTH(ERR_DESC),INSTR(ERR_DESC, '#', 1, 1) -1) ) ERR_DESC" ).append("\n"); 
		query.append("FROM    TRS_INLND_COST_TRF" ).append("\n"); 
		query.append("WHERE   COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("AND     COST_ERR_CD IS NOT NULL" ).append("\n"); 

	}
}