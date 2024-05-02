/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeCalculationDBDAOsearchDMTOfficeByApprovalOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOsearchDMTOfficeByApprovalOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Office의 산하 BA/BS DMT Office List
	  * </pre>
	  */
	public ChargeCalculationDBDAOsearchDMTOfficeByApprovalOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOsearchDMTOfficeByApprovalOfficeRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD,  OFC_ENG_NM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("#if (${rhq} == 'HAMUR')	" ).append("\n"); 
		query.append("      SELECT  OFC_CD,  OFC_ENG_NM --BB.BO 인 경우 자기 COCE만 " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("      AND SUBSTR(@[ofc_cd],4,2) IN ('BB', 'BO')" ).append("\n"); 
		query.append("      AND  OFC_CD <> AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT  DISTINCT O.OFC_CD,  O.OFC_ENG_NM --BB인 경우 하위 BS " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION  O, MDM_YARD Y " ).append("\n"); 
		query.append("      WHERE O.OFC_CD =  Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("      AND SUBSTR(@[ofc_cd],4,2) = 'BB'" ).append("\n"); 
		query.append("      AND O.PRNT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      AND O.OFC_CD <> O.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      AND NVL(O.DELT_FLG, 'N') <> 'Y'      " ).append("\n"); 
		query.append("      UNION ALL      " ).append("\n"); 
		query.append("      SELECT  DISTINCT MO.OFC_CD, MO.OFC_ENG_NM  --RHQ 아닌 일반OFFICE" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("          (SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("           FROM   MDM_YARD Y," ).append("\n"); 
		query.append("                 (SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("      			FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("      			WHERE NVL(DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("      			CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("      			START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      			) O" ).append("\n"); 
		query.append("           WHERE  Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("           AND    NVL(Y.DELT_FLG, 'N') <> 'Y') Y" ).append("\n"); 
		query.append("      WHERE MO.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("      AND   SUBSTR(Y.DMDT_OFC_CD, 4, 2) IN ('BA', 'BS')" ).append("\n"); 
		query.append("      AND   SUBSTR(@[ofc_cd],4,2) NOT IN ('BB', 'BO')" ).append("\n"); 
		query.append("      AND  NVL(MO.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND  NOT EXISTS (SELECT 'X' FROM MDM_ORGANIZATION M WHERE M.OFC_CD = M.AR_HD_QTR_OFC_CD AND M.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("      UNION ALL " ).append("\n"); 
		query.append("      SELECT  DISTINCT O.OFC_CD, O.OFC_ENG_NM -- RHQ " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION O, MDM_YARD Y" ).append("\n"); 
		query.append("      WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("      AND   O.AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD= @[ofc_cd] AND OFC_CD = AR_HD_QTR_OFC_CD)" ).append("\n"); 
		query.append("      AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND NVL(Y.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      SELECT  OFC_CD,  OFC_ENG_NM --BB.BO 인 경우 자기 COCE만 " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("      AND SUBSTR(@[ofc_cd],4,2) IN ('BB', 'BO')" ).append("\n"); 
		query.append("      AND  OFC_CD <> AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT  DISTINCT MO.OFC_CD, MO.OFC_ENG_NM  --RHQ 아닌 일반OFFICE" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("          (SELECT DISTINCT DMDT_OFC_CD" ).append("\n"); 
		query.append("           FROM   MDM_YARD Y," ).append("\n"); 
		query.append("                 (SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("      			FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("      			WHERE NVL(DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("      			CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("      			START WITH OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      			) O" ).append("\n"); 
		query.append("           WHERE  Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("           AND    NVL(Y.DELT_FLG, 'N') <> 'Y') Y" ).append("\n"); 
		query.append("      WHERE MO.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("      AND   SUBSTR(Y.DMDT_OFC_CD, 4, 2) IN ('BA', 'BS')" ).append("\n"); 
		query.append("      AND   SUBSTR(@[ofc_cd],4,2) NOT IN ('BB', 'BO')" ).append("\n"); 
		query.append("      AND  NVL(MO.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND  NOT EXISTS (SELECT 'X' FROM MDM_ORGANIZATION M WHERE M.OFC_CD = M.AR_HD_QTR_OFC_CD AND M.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("      UNION ALL " ).append("\n"); 
		query.append("      SELECT  DISTINCT O.OFC_CD, O.OFC_ENG_NM -- RHQ " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION O, MDM_YARD Y" ).append("\n"); 
		query.append("      WHERE O.OFC_CD = Y.DMDT_OFC_CD" ).append("\n"); 
		query.append("      AND   O.AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD= @[ofc_cd] AND OFC_CD = AR_HD_QTR_OFC_CD)" ).append("\n"); 
		query.append("      AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND NVL(Y.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT OFC_CD, OFC_ENG_NM FROM MDM_ORGANIZATION WHERE @[ofc_cd] ='TORBB' and OFC_CD IN ('MTRBS','VANBS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}