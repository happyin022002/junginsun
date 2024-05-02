/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderMainDBDAOSearchSoBasicAndFuelAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOSearchSoBasicAndFuelAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOSearchSoBasicAndFuelAmt
	  * </pre>
	  */
	public WorkOrderMainDBDAOSearchSoBasicAndFuelAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOSearchSoBasicAndFuelAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(S.BZC_AMT, 0) + NVL(S.NEGO_AMT, 0) BZC_AMT" ).append("\n"); 
		query.append("      ,S.FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,(SELECT SUM(NVL(X.SCG_AMT, 0))" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SCG_DTL X" ).append("\n"); 
		query.append("         WHERE X.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND X.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND SUBSTR(X.LGS_COST_CD, 3, 2) = 'FU') AS SCG_AMT" ).append("\n"); 
		query.append("      ,NVL(D.FUEL_RTO, 0.00) FUEL_RTO" ).append("\n"); 
		query.append("      ,'S' || DECODE(S.CGO_TP_CD, 'F', 'C', 'M', 'M') || 'FU' || S.TRSP_CRR_MOD_CD AS FUEL_LGS_COST_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("      ,TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append(" WHERE S.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND S.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND S.TRSP_SO_SEQ = D.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND SUBSTR(D.LGS_COST_CD(+), 3, 2) = 'FU'" ).append("\n"); 
		query.append("   AND D.SCG_DTL_SEQ(+) = 1" ).append("\n"); 

	}
}