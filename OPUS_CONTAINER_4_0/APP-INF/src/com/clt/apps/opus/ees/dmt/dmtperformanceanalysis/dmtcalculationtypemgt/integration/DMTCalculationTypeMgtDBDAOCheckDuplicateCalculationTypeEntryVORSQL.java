/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAOCheckDuplicateCalculationTypeEntryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.03.12 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationTypeMgtDBDAOCheckDuplicateCalculationTypeEntryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckDuplicateCalculationTypeEntryVO select
	  * </pre>
	  */
	public DMTCalculationTypeMgtDBDAOCheckDuplicateCalculationTypeEntryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration").append("\n"); 
		query.append("FileName : DMTCalculationTypeMgtDBDAOCheckDuplicateCalculationTypeEntryVORSQL").append("\n"); 
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
		query.append("SELECT CNT_CD" ).append("\n"); 
		query.append("  FROM  DMT_CALC_TP" ).append("\n"); 
		query.append(" WHERE CNT_CD	=	NVL(@[cnt_cd], ' ')" ).append("\n"); 
		query.append("   AND RGN_CD	=	NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("   AND STE_CD	=	NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("   AND LOC_CD	=	NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("   AND IO_BND_CD	=	NVL(@[io_bnd_cd], ' ')" ).append("\n"); 
		query.append("   AND ( ( TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT + .0 AND EXP_DT + 0.99999 ) OR (EXP_DT IS NULL ) ) " ).append("\n"); 

	}
}