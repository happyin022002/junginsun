/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchBaseTariff2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.15 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchBaseTariff2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select formula의 tariff조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchBaseTariff2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchBaseTariff2RSQL").append("\n"); 
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
		query.append("SELECT  T22.DP_NO AS SEQ," ).append("\n"); 
		query.append("T21.CURR_CD currency" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  PSO_OBJ_CD" ).append("\n"); 
		query.append("FROM    PSO_OBJ_LIST" ).append("\n"); 
		query.append("WHERE   OBJ_LIST_NO  = T22.OBJ_LIST_NO" ).append("\n"); 
		query.append(") OBJECT" ).append("\n"); 
		query.append(",T22.OBJ_LIST_NO AS object_code" ).append("\n"); 
		query.append(",T22.OBJ_LIST_NO AS uom" ).append("\n"); 
		query.append(",PSO_TRF_TP_CD AS rate_code" ).append("\n"); 
		query.append(",T23.FM_VAL range_from, T23.TO_VAL  range_to , T23.TRF_RT_AMT rate_value" ).append("\n"); 
		query.append(",T23.COND_NO AS Condition,  T21.FOML_NO AS FORMULA_NO, T22.pso_trf_tp_cd , T23.PORT_TRF_NO, T23.TRF_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  T1.CURR_CD, T2.PSO_CHG_TP_CD,T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,T3.FOML_NO" ).append("\n"); 
		query.append(",T4.ROW_NO AS ROW_NO" ).append("\n"); 
		query.append(",MAX(DECODE(FOML_SEQ, 1, OBJ_LIST_NO)) AS OBJ_CD, MAX(DECODE(FOML_SEQ, 2, PSO_FOML_OPR_CD)) AS OPR, MAX(DECODE(FOML_SEQ, 3, OBJ_LIST_NO)) AS RATE" ).append("\n"); 
		query.append("FROM    PSO_YD_CHG T1,  PSO_YD_CHG_XPR T2,  PSO_CHG_XPR_DTL T3, PSO_FOML_DTL T4," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select  t2.acct_cd, t2.lgs_cost_cd, lgs_cost_full_nm" ).append("\n"); 
		query.append("from    pso_inv_ofc_cost t1, tes_lgs_cost t2" ).append("\n"); 
		query.append("where   t1.lgs_cost_cd = t2.lgs_cost_cd" ).append("\n"); 
		query.append("and     t1.ofc_cd      = @[ofc_cd]" ).append("\n"); 
		query.append("and     t2.acct_cd          <> '999999'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 
		query.append(")  T5" ).append("\n"); 
		query.append("WHERE   T1.YD_CHG_NO          = T2.YD_CHG_NO" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD          = T5.lgs_cost_cd" ).append("\n"); 
		query.append("--            AND     T1.LST_FLG          = 'Y'" ).append("\n"); 
		query.append("#if( ${port_cd} == '' )" ).append("\n"); 
		query.append("AND     T1.YD_CD            = @[combo1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     T1.YD_CD            = @[port_cd] || @[combo1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     T1.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("#if( ${acct_cd} == '')" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD      = @[combo3]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     T5.acct_cd         = @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--           AND     SYSDATE BETWEEN T1.EFF_DT AND  T1.EXP_DT" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = @[combo4]" ).append("\n"); 
		query.append("--AND     T1.eff_dt = to_date( *from_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--AND     T1.exp_dt = to_date( *to_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     T2.CHG_XPR_NO       = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("AND     T3.FOML_NO          = T4.FOML_NO" ).append("\n"); 
		query.append("GROUP BY T1.CURR_CD, T2.PSO_CHG_TP_CD,T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,COND_NO, T3.FOML_NO,T4.ROW_NO" ).append("\n"); 
		query.append(") T21, PSO_TARIFF T22, PSO_TRF_DTL T23" ).append("\n"); 
		query.append("WHERE   T21.CHG_XPR_NO      = T22.CHG_XPR_NO" ).append("\n"); 
		query.append("AND     T21.CHG_XPR_SEQ     = T22.CHG_XPR_SEQ" ).append("\n"); 
		query.append("AND     T22.PORT_TRF_NO     = T23.PORT_TRF_NO" ).append("\n"); 
		query.append("order by port_trf_no,trf_seq" ).append("\n"); 

	}
}