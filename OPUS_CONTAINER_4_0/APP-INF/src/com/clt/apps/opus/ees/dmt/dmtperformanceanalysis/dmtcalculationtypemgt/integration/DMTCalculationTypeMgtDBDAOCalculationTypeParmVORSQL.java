/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.24 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 황효근
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT calc_tp_seq, cnt_cd, rgn_cd, ste_cd, loc_cd, io_bnd_cd," ).append("\n"); 
		query.append("DECODE (dmdt_calc_tp_cd," ).append("\n"); 
		query.append("'C', 'Combined'," ).append("\n"); 
		query.append("'D', 'Dual'" ).append("\n"); 
		query.append(") dmdt_calc_tp_cd," ).append("\n"); 
		query.append("TO_CHAR (eff_dt, 'YYYYMMDD') eff_dt," ).append("\n"); 
		query.append("TO_CHAR (exp_dt, 'YYYYMMDD') exp_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("TO_CHAR (cre_dt, 'YYYYMMDD') cre_dt," ).append("\n"); 
		query.append("cre_ofc_cd," ).append("\n"); 
		query.append("upd_usr_id, upd_dt, upd_ofc_cd" ).append("\n"); 
		query.append("FROM dmt_calc_tp" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND cnt_cd = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_cd} != '')" ).append("\n"); 
		query.append("AND rgn_cd = @[rgn_cd]" ).append("\n"); 
		query.append("#elseif (${ste_cd} != '')" ).append("\n"); 
		query.append("AND ste_cd = @[ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_calc_tp_cd} != '')" ).append("\n"); 
		query.append("AND dmdt_calc_tp_cd = @[dmdt_calc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ( 1=0" ).append("\n"); 
		query.append("#if (${val_curr} != '')" ).append("\n"); 
		query.append("OR ( (TO_CHAR (SYSDATE, 'YYYYMMDD') BETWEEN TO_CHAR (eff_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_CHAR (exp_dt, 'YYYYMMDD'))" ).append("\n"); 
		query.append("OR (TO_CHAR (SYSDATE, 'YYYYMMDD') >= TO_CHAR (eff_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND EXP_DT IS NULL)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${val_tobe} != '')" ).append("\n"); 
		query.append("OR TO_CHAR (eff_dt, 'YYYYMMDD') > TO_CHAR (SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${val_exp} != '')" ).append("\n"); 
		query.append("OR TO_CHAR (exp_dt, 'YYYYMMDD') < TO_CHAR (SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CNT_CD, RGN_CD, STE_CD, LOC_CD, IO_BND_CD, EFF_DT" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration").append("\n"); 
		query.append("FileName : DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}