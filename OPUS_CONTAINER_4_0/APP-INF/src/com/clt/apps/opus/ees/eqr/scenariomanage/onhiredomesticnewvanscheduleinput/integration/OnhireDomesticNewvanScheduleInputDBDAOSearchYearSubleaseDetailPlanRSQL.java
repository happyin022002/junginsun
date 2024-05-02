/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleaseDetailPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.23 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleaseDetailPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_slse + eqr_slse_perf 테이블의 데이터 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleaseDetailPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleaseDetailPlanRSQL").append("\n"); 
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
		query.append("e.fm_rcc_cd" ).append("\n"); 
		query.append(", e.fm_ecc_cd" ).append("\n"); 
		query.append(", e.to_ecc_cd" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append(", to_char(NVL(ROUND(sum(slse_rto)/16,2),0),'990.99')||'%'" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#foreach( ${key} in ${arr})" ).append("\n"); 
		query.append("SUM (DECODE (pln_yrwk, ${key}, cntr_vol_qty)) s2_${key}_cntr_vol_qty," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MAX (scnr_id)" ).append("\n"); 
		query.append(", MAX(timegap) timegap" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if(${type} == 'R')" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${fmToAt}== '1')" ).append("\n"); 
		query.append("#if(${fmTypeBy} == 'R')" ).append("\n"); 
		query.append("rcc_cd" ).append("\n"); 
		query.append("#elseif(${fmTypeBy} == 'C')" ).append("\n"); 
		query.append("cnt_cd" ).append("\n"); 
		query.append("#elseif(${fmTypeBy} == 'L')" ).append("\n"); 
		query.append("lcc_cd" ).append("\n"); 
		query.append("#elseif(${fmTypeBy} == 'E' || ${fmTypeBy} == '')" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${atTypeBy} == 'R')" ).append("\n"); 
		query.append("rcc_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'C')" ).append("\n"); 
		query.append("cnt_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'L')" ).append("\n"); 
		query.append("lcc_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'E' || ${atTypeBy} == '')" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("a.fm_ecc_cd = ecc_cd" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 
		query.append(") fm_ecc_cd" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if(${fmToAt}== '1')" ).append("\n"); 
		query.append("#if(${toTypeBy} == 'R')" ).append("\n"); 
		query.append("rcc_cd" ).append("\n"); 
		query.append("#elseif(${toTypeBy} == 'C')" ).append("\n"); 
		query.append("cnt_cd" ).append("\n"); 
		query.append("#elseif(${toTypeBy} == 'L')" ).append("\n"); 
		query.append("lcc_cd" ).append("\n"); 
		query.append("#elseif(${toTypeBy} == 'E' || ${toTypeBy} == '')" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${atTypeBy} == 'R')" ).append("\n"); 
		query.append("rcc_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'C')" ).append("\n"); 
		query.append("cnt_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'L')" ).append("\n"); 
		query.append("lcc_cd" ).append("\n"); 
		query.append("#elseif(${atTypeBy} == 'E' || ${atTypeBy} == '')" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("a.to_ecc_cd = ecc_cd" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 
		query.append(") to_ecc_cd" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("rcc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("a.fm_ecc_cd = ecc_cd" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 
		query.append(") fm_rcc_cd" ).append("\n"); 
		query.append(", a.cntr_tpsz_cd" ).append("\n"); 
		query.append(", pln_mon" ).append("\n"); 
		query.append(", MAX(cntr_vol_qty) cntr_vol_qty" ).append("\n"); 
		query.append(", slse_rto" ).append("\n"); 
		query.append(", a.pln_yrwk" ).append("\n"); 
		query.append(", a.scnr_id" ).append("\n"); 
		query.append(", DECODE(a.cre_dt, a.upd_dt, 'N', 'Y') timegap" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_scnr_slse a" ).append("\n"); 
		query.append(", eqr_wk_prd b" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#if(${type} == 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${fmToAt} == '1')" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${fmEccCd} != '')" ).append("\n"); 
		query.append("#if(${fmType} == 'R')" ).append("\n"); 
		query.append("AND rcc_cd" ).append("\n"); 
		query.append("#elseif(${fmType} == 'L')" ).append("\n"); 
		query.append("AND lcc_cd" ).append("\n"); 
		query.append("#elseif(${fmType} == 'E')" ).append("\n"); 
		query.append("AND ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${toEccCd} != '')" ).append("\n"); 
		query.append("#if(${toType} == 'R')" ).append("\n"); 
		query.append("AND rcc_cd" ).append("\n"); 
		query.append("#elseif(${toType} == 'L')" ).append("\n"); 
		query.append("AND lcc_cd" ).append("\n"); 
		query.append("#elseif(${toType} == 'E')" ).append("\n"); 
		query.append("AND ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrToEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrToEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") d," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") d," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${toEccCd} != '' )" ).append("\n"); 
		query.append("#if(${toType} == 'R')" ).append("\n"); 
		query.append("AND rcc_cd" ).append("\n"); 
		query.append("#elseif(${toType} == 'L')" ).append("\n"); 
		query.append("AND lcc_cd" ).append("\n"); 
		query.append("#elseif(${toType} == 'E')" ).append("\n"); 
		query.append("AND ecc_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("eqr_slse_perf e" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("a.pln_yrwk = b.pln_yr || b.pln_wk" ).append("\n"); 
		query.append("AND a.fm_ecc_cd = e.fm_ecc_cd(+)" ).append("\n"); 
		query.append("AND a.to_ecc_cd = e.to_ecc_cd(+)" ).append("\n"); 
		query.append("AND a.cntr_tpsz_cd = e.cntr_tpsz_cd(+)" ).append("\n"); 
		query.append("#if(${type} == 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${fmToAt} == '1')" ).append("\n"); 
		query.append("AND a.fm_ecc_cd = c.ecc_cd AND a.to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${atType} != '')" ).append("\n"); 
		query.append("AND (a.fm_ecc_cd = c.ecc_cd OR a.to_ecc_cd = c.ecc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND a.pln_yrwk between @[fmPln] and @[toPln]" ).append("\n"); 
		query.append("AND a.scnr_id = @[scnrId]" ).append("\n"); 
		query.append("#if(${type} == 'R')" ).append("\n"); 
		query.append("AND a.fm_ecc_cd in ( SELECT ecc_cd FROM eqr_ecc_mst WHERE rcc_cd = @[rcc_cd] and DELT_FLG = 'N' )" ).append("\n"); 
		query.append("#elseif(${cntrTpszCd} != '')" ).append("\n"); 
		query.append("AND a.cntr_tpsz_cd IN(" ).append("\n"); 
		query.append("#foreach($key IN ${arrCntrTpszCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrCntrTpszCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("a.fm_ecc_cd" ).append("\n"); 
		query.append(", a.to_ecc_cd" ).append("\n"); 
		query.append(", a.cntr_tpsz_cd" ).append("\n"); 
		query.append(", pln_mon" ).append("\n"); 
		query.append(", pln_yrwk" ).append("\n"); 
		query.append(", slse_rto" ).append("\n"); 
		query.append(", a.scnr_id" ).append("\n"); 
		query.append(", a.cre_dt" ).append("\n"); 
		query.append(", a.upd_dt" ).append("\n"); 
		query.append(") e" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("e.fm_rcc_cd" ).append("\n"); 
		query.append(", e.fm_ecc_cd" ).append("\n"); 
		query.append(", e.to_ecc_cd" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("e.fm_rcc_cd" ).append("\n"); 
		query.append(", e.fm_ecc_cd" ).append("\n"); 
		query.append(", e.to_ecc_cd" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 

	}
}