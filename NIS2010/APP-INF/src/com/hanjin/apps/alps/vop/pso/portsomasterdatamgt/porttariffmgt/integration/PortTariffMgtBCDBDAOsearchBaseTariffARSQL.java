/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchBaseTariffARSQL.java
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

public class PortTariffMgtBCDBDAOsearchBaseTariffARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select formula의 base tariff조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchBaseTariffARSQL(){
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
		query.append("FileName : PortTariffMgtBCDBDAOsearchBaseTariffARSQL").append("\n"); 
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
		query.append("T21.COND_NO AS condition,  T21.FOML_NO AS FORMULA_NO" ).append("\n"); 
		query.append(", T22.FOML_DESC, T23.COND_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  T2.PSO_CHG_TP_CD,T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,T3.FOML_NO,T3.COND_NO" ).append("\n"); 
		query.append("FROM    PSO_YD_CHG T1,  PSO_YD_CHG_XPR T2,  PSO_CHG_XPR_DTL T3, PSO_FORMULA T4," ).append("\n"); 
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
		query.append("AND     T1.YD_CHG_VER_SEQ   = @[combo4]" ).append("\n"); 
		query.append("--AND     T1.eff_dt = to_date( *from_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--AND     T1.exp_dt = to_date( *to_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     T2.CHG_XPR_NO       = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("AND     T3.FOML_NO          = T4.FOML_NO" ).append("\n"); 
		query.append("GROUP BY T2.PSO_CHG_TP_CD,T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,COND_NO, T3.FOML_NO" ).append("\n"); 
		query.append("ORDER BY T3.CHG_XPR_NO, T3.CHG_XPR_SEQ" ).append("\n"); 
		query.append(") T21, PSO_FORMULA T22, PSO_CONDITION T23" ).append("\n"); 
		query.append("WHERE T21.FOML_NO = T22.FOML_NO" ).append("\n"); 
		query.append("AND   T21.COND_NO = T23.COND_NO(+)" ).append("\n"); 

	}
}