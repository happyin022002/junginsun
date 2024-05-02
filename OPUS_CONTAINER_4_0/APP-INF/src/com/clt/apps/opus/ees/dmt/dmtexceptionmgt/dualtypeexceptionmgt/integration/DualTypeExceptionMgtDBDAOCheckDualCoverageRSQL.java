/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Coverage 가 Dual Coverage 인지를 체크하기 위한 조회용 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL(){
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
		params.put("dul_expt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOCheckDualCoverageRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(*)" ).append("\n"); 
		query.append("FROM	DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE	DMDT_CALC_TP_CD = 'D'" ).append("\n"); 
		query.append("	AND	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("	AND DECODE(RGN_CD, ' ', NVL(@[rgn_cd], ' '), RGN_CD) = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("	AND DECODE(STE_CD, ' ', NVL(@[ste_cd], ' '), STE_CD) = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("	AND DECODE(LOC_CD, ' ', NVL(@[loc_cd], ' '), LOC_CD) = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("    AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("    AND EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${dul_expt_exp_dt} != '') " ).append("\n"); 
		query.append("    AND NVL(EXP_DT, TO_DATE(@[dul_expt_exp_dt], 'YYYYMMDD')) >= TO_DATE(@[dul_expt_exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND EXP_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}