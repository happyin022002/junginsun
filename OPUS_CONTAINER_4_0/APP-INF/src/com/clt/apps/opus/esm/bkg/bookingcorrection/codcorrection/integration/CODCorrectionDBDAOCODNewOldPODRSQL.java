/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CODCorrectionDBDAOCODNewOldPODRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2015.10.15 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOCODNewOldPODRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD의 NEW POD CD, OLD POD CD SELECT
	  * </pre>
	  */
	public CODCorrectionDBDAOCODNewOldPODRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOCODNewOldPODRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("(SELECT    ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = @[new_pod_cd]" ).append("\n"); 
		query.append(") AS NEW_POD_FULL_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT    ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = @[old_pod_cd]" ).append("\n"); 
		query.append(") AS OLD_POD_FULL_NM," ).append("\n"); 
		query.append("(SELECT     ML.LOC_NM" ).append("\n"); 
		query.append("FROM        MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE       ML.LOC_CD    = @[old_pol_cd]" ).append("\n"); 
		query.append(") AS OLD_POL_FULL_NM," ).append("\n"); 
		query.append("(SELECT MAX(OB_CSSM_VOY_NO) " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD    = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = substr(@[vvd],9)" ).append("\n"); 
		query.append(") AS OB_CSSM_VOY_NO," ).append("\n"); 
		query.append("(SELECT MAX(MDM.VSL_ENG_NM)" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR MDM" ).append("\n"); 
		query.append("	,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("WHERE MDM.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("AND VSK.VSL_CD    = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND VSK.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND VSK.SKD_DIR_CD  = substr(@[vvd],9)" ).append("\n"); 
		query.append(") AS VSL_ENG_NM," ).append("\n"); 
		query.append("(SELECT CASE WHEN VS.ACT_CRR_CD IS NOT NULL AND LENGTH(LTRIM(RTRIM(VS.ACT_CRR_CD))) > 0 THEN " ).append("\n"); 
		query.append("                  VS.ACT_CRR_CD" ).append("\n"); 
		query.append("       WHEN  VS.ACT_CRR_CD IS NULL OR LENGTH(LTRIM(RTRIM(VS.ACT_CRR_CD))) = 0 THEN" ).append("\n"); 
		query.append("            (SELECT VC.CRR_CD" ).append("\n"); 
		query.append("             FROM   MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("             WHERE  VC.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       ELSE  ''" ).append("\n"); 
		query.append("       END  CARRIER_CD" ).append("\n"); 
		query.append("FROM      VSK_VSL_SKD    VS " ).append("\n"); 
		query.append("WHERE     1=1" ).append("\n"); 
		query.append("#if(${vvd} !='')" ).append("\n"); 
		query.append("AND		  VS.VSL_CD      = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND       VS.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND       VS.SKD_DIR_CD  = substr(@[vvd],9)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AS CARRIER_CD," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'YYYY/MM/DD') eml_dt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}