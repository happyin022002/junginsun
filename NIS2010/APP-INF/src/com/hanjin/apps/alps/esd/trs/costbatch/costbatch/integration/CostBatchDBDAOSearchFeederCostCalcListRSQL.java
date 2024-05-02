/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOSearchFeederCostCalcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.20 
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

public class CostBatchDBDAOSearchFeederCostCalcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.21 변종건 [CHM-201217633] Ocean Feeder Cost Batch Creation
	  * </pre>
	  */
	public CostBatchDBDAOSearchFeederCostCalcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOSearchFeederCostCalcListRSQL").append("\n"); 
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
		query.append("SELECT  C.RHQ_CD" ).append("\n"); 
		query.append(", D.COST_TRF_NO" ).append("\n"); 
		query.append(", D.STS_CD" ).append("\n"); 
		query.append(", D.STS_NM" ).append("\n"); 
		query.append(", D.CURR_CD" ).append("\n"); 
		query.append(", DECODE(D.PROG_RATIO,NULL,'',TO_CHAR(D.PROG_RATIO)||'%') PROG_RATIO" ).append("\n"); 
		query.append(", D.LOCL_CRE_DT CRE_DT" ).append("\n"); 
		query.append(", D.CRE_USR_ID" ).append("\n"); 
		query.append(", D.LOCL_UPD_DT UPD_DT" ).append("\n"); 
		query.append(", D.UPD_USR_ID" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT   INTG_CD_VAL_DESC AS RHQ_CD" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID = 'CD00961'" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND      INTG_CD_VAL_DESC IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT  A.RHQ_CD" ).append("\n"); 
		query.append(", B.COST_TRF_NO" ).append("\n"); 
		query.append(", DECODE(A.BAT_PROG_STS_CD,'B',B.COST_TRF_STS_CD,A.BAT_PROG_STS_CD) STS_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE   INTG_CD_ID = 'CD03047'" ).append("\n"); 
		query.append("AND     INTG_CD_VAL_CTNT = DECODE(A.BAT_PROG_STS_CD,'B',B.COST_TRF_STS_CD,A.BAT_PROG_STS_CD)" ).append("\n"); 
		query.append("AND     ROWNUM <= 1" ).append("\n"); 
		query.append(") STS_NM" ).append("\n"); 
		query.append(", B.CURR_CD" ).append("\n"); 
		query.append(", FLOOR(DECODE(A.BAT_PROG_TTL_KNT,0,1,(A.BAT_PROG_KNT / A.BAT_PROG_TTL_KNT)) * 100) PROG_RATIO" ).append("\n"); 
		query.append(", TO_CHAR(B.LOCL_CRE_DT,'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE  CU.USR_ID = B.CRE_USR_ID ) CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(B.LOCL_UPD_DT,'YYYY-MM-DD HH24:MI:SS') LOCL_UPD_DT" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE  CU.USR_ID = B.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append("FROM    TRS_COST_TRF_BAT A" ).append("\n"); 
		query.append(", TRS_FDR_COST_TRF_HDR B" ).append("\n"); 
		query.append("WHERE   A.COST_TRF_BAT_SEQ = B.COST_TRF_BAT_SEQ(+)" ).append("\n"); 
		query.append("AND     A.PGM_NO = 'ESD_TRS_B005'" ).append("\n"); 
		query.append("AND     A.COST_TRF_BAT_SEQ IN (" ).append("\n"); 
		query.append("SELECT  MAX(COST_TRF_BAT_SEQ)" ).append("\n"); 
		query.append("FROM    TRS_COST_TRF_BAT" ).append("\n"); 
		query.append("WHERE   RHQ_CD = A.RHQ_CD AND PGM_NO = 'ESD_TRS_B005'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     A.RHQ_CD IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   C.RHQ_CD = D.RHQ_CD(+)" ).append("\n"); 

	}
}