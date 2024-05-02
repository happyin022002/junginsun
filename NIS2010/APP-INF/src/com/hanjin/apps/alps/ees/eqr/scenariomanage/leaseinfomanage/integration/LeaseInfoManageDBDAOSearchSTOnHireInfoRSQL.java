/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAOSearchSTOnHireInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseInfoManageDBDAOSearchSTOnHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/T On Hire 조회
	  *  - EQR_SCNR_SHRT_TERM_ONH_COND
	  * </pre>
	  */
	public LeaseInfoManageDBDAOSearchSTOnHireInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration").append("\n"); 
		query.append("FileName : LeaseInfoManageDBDAOSearchSTOnHireInfoRSQL").append("\n"); 
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
		query.append("SELECT	MAX(DECODE ( RUMM , 1 ,ECC_CD)) ECC_CD" ).append("\n"); 
		query.append("#if (${arrtpsz} != '')" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , AVAL_CNTR_QTY ))		${key}AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , LFT_CHG_AMT))			${key}LFT_CHG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , PKUP_CHG_CR_AMT ))	${key}PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , DRYG_AMT))			${key}DRYG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , PD_COST_AMT))			${key}PD_COST_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , DFLT_USD_DYS))		${key}DFLT_USD_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SCNR_ID" ).append("\n"); 
		query.append(",DELSTATUS" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	 A.SCNR_ID" ).append("\n"); 
		query.append(",A.ECC_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.AVAL_CNTR_QTY" ).append("\n"); 
		query.append(",A.LFT_CHG_AMT" ).append("\n"); 
		query.append(",A.DRYG_AMT" ).append("\n"); 
		query.append(",A.PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append(",A.PD_COST_AMT" ).append("\n"); 
		query.append(",A.DFLT_USD_DYS" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(", CASE WHEN B.REPO_PLN_CRE_FLG = 'Y'" ).append("\n"); 
		query.append("OR  B.REPO_PLN_DTRB_FLG ='Y'" ).append("\n"); 
		query.append("OR  B.SCNR_AUTO_GEN_FLG ='Y'" ).append("\n"); 
		query.append("THEN 'FALSE'" ).append("\n"); 
		query.append("ELSE  'TRUE'" ).append("\n"); 
		query.append("END	DELSTATUS" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD,CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM	EQR_SCNR_SHRT_TERM_ONH_COND A , EQR_SCNR_MST B" ).append("\n"); 
		query.append("WHERE	A.SCNR_ID	= @[scnr_id]" ).append("\n"); 
		query.append("AND	A.SCNR_ID	= B.SCNR_ID(+)" ).append("\n"); 
		query.append("AND	b.DELT_FLG	= 'N'" ).append("\n"); 
		query.append("#if ($arrlocation.size() > 0 )" ).append("\n"); 
		query.append("AND	ECC_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arrtpsz} != '')" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpsz.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY  RUMM" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", DELSTATUS" ).append("\n"); 

	}
}