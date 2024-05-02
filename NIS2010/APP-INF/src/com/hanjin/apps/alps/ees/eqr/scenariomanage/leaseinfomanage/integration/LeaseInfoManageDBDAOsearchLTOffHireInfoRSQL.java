/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAOsearchLTOffHireInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.05 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseInfoManageDBDAOsearchLTOffHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    EQR_SCNR_LONG_TERM_OFFH_COND 테이블 데이터 조회
	  * </pre>
	  */
	public LeaseInfoManageDBDAOsearchLTOffHireInfoRSQL(){
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
		query.append("FileName : LeaseInfoManageDBDAOsearchLTOffHireInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE ( rumm , 1 ,ECC_CD)) ECC_CD" ).append("\n"); 
		query.append(",CTRT_OFC_CTY_CD||CTRT_SEQ   CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append("#foreach( $key in ${prefix})" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , AVAL_OFFH_QTY ))    ${key}AVAL_OFFH_QTY" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , LTOF_CHG_AMT))      ${key}LTOF_CHG_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , DRFF_CHG_CR_AMT ))  ${key}DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , DRYG_AMT))          ${key}DRYG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SCNR_ID" ).append("\n"); 
		query.append(",delstatus" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT    	 a.SCNR_ID" ).append("\n"); 
		query.append(",a.ECC_CD" ).append("\n"); 
		query.append(",a.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",a.CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append(",a.CTRT_SEQ" ).append("\n"); 
		query.append(",a.AVAL_OFFH_QTY" ).append("\n"); 
		query.append(",a.LTOF_CHG_AMT" ).append("\n"); 
		query.append(",a.DRYG_AMT" ).append("\n"); 
		query.append(",a.DRFF_CHG_CR_AMT" ).append("\n"); 
		query.append(",a.UPD_USR_ID" ).append("\n"); 
		query.append(",a.UPD_DT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN b.REPO_PLN_CRE_FLG = 'Y' or  b.REPO_PLN_DTRB_FLG ='Y' or b.SCNR_AUTO_GEN_FLG ='Y' THEN" ).append("\n"); 
		query.append("'FALSE'" ).append("\n"); 
		query.append("ELSE  'TRUE'" ).append("\n"); 
		query.append("END	delstatus" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY ECC_CD,CTRT_OFC_CTY_CD , CTRT_SEQ, CNTR_TPSZ_CD ORDER BY ROWNUM) rumm" ).append("\n"); 
		query.append("FROM EQR_SCNR_LONG_TERM_OFFH_COND a, EQR_SCNR_MST b" ).append("\n"); 
		query.append("WHERE a.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND a.SCNR_ID = b.SCNR_ID(+)" ).append("\n"); 
		query.append("AND b.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc} !='')" ).append("\n"); 
		query.append("AND ECC_CD IN (" ).append("\n"); 
		query.append("#if ($ecc_perfix.size() > 0 )" ).append("\n"); 
		query.append("#foreach( $key in ${ecc_perfix})" ).append("\n"); 
		query.append("#if($velocityCount < $ecc_perfix.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prefix} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach( $key in ${prefix})" ).append("\n"); 
		query.append("#if($velocityCount < $prefix.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY rumm" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append(", CTRT_SEQ" ).append("\n"); 
		query.append(",delstatus" ).append("\n"); 

	}
}