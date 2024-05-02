/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOsearchRDRLaneYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.09 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOsearchRDRLaneYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * lane cd 유무 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOsearchRDRLaneYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOsearchRDRLaneYnRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("FROM   (SELECT ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("                ORDER BY A.VSL_SLAN_CD ASC) no," ).append("\n"); 
		query.append("               A.VSL_SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_SLAN_NM," ).append("\n"); 
		query.append("               A.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("               A.CO_CD" ).append("\n"); 
		query.append("        FROM   MDM_VSL_SVC_LANE A --, JOO_CRR_AUTH AUTH" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("--        AND    A.VSL_SLAN_CD = SUBSTR(AUTH.RLANE_CD,1,3)" ).append("\n"); 
		query.append("--        AND    AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("--        AND    AUTH.AUTH_OFC_CD = ofc_cd" ).append("\n"); 
		query.append("        AND    A.VSL_SLAN_CD LIKE '%' || @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("        AND    NVL(A.DELT_FLG, 'N') <> 'Y' ) A" ).append("\n"); 
		query.append("WHERE NO BETWEEN 1 AND 50" ).append("\n"); 

	}
}