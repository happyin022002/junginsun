/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchCalculationTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchCalculationTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCalculationType
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchCalculationTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("state_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchCalculationTypeRSQL").append("\n"); 
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
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    /*+ INDEX_DESC( DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("FROM    DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE    ( CNT_CD    =    @[cnt_cd]        OR    CNT_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( RGN_CD    =    @[rgn_cd]        OR    RGN_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( STE_CD    =    @[state_cd]      OR    STE_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( LOC_CD    =    @[loc_cd]        OR    LOC_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      IO_BND_CD   =    @[io_bnd]" ).append("\n"); 
		query.append("AND      (" ).append("\n"); 
		query.append("( EFF_DT <= TO_DATE (@[eff_dt], 'YYYYMMDD') AND EXP_DT IS NULL )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( EFF_DT <= TO_DATE (@[eff_dt], 'YYYYMMDD') AND EXP_DT > TO_DATE (@[eff_dt], 'YYYYMMDD') )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND        ROWNUM    =    1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    /*+ INDEX_DESC( DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("FROM    DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE    ( CNT_CD    =    @[cnt_cd]        OR    CNT_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( RGN_CD    =    @[rgn_cd]        OR    RGN_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( STE_CD    =    @[state_cd]      OR    STE_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      ( LOC_CD    =    @[loc_cd]        OR    LOC_CD        =    ' ' )" ).append("\n"); 
		query.append("AND      IO_BND_CD   =    @[io_bnd]" ).append("\n"); 
		query.append("AND      CALC_TP_SEQ            =    (" ).append("\n"); 
		query.append("SELECT   /*+ INDEX_DESC( D XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("D.CALC_TP_SEQ" ).append("\n"); 
		query.append("FROM    DMT_CALC_TP    D" ).append("\n"); 
		query.append("WHERE   ( D.CNT_CD   =    @[cnt_cd]        OR    D.CNT_CD    =    ' ' )" ).append("\n"); 
		query.append("AND     ( D.RGN_CD   =    @[rgn_cd]        OR    D.RGN_CD    =    ' ' )" ).append("\n"); 
		query.append("AND     ( D.STE_CD   =    @[state_cd]      OR    D.STE_CD    =    ' ' )" ).append("\n"); 
		query.append("AND     ( D.LOC_CD   =    @[loc_cd]        OR    D.LOC_CD    =    ' ' )" ).append("\n"); 
		query.append("AND     D.IO_BND_CD  =    @[io_bnd]" ).append("\n"); 
		query.append("AND        ROWNUM    =    1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND        ROWNUM            =    1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}