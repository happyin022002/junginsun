/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchBaseConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.10 정명훈
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

public class PortTariffMgtBCDBDAOsearchBaseConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * base tariff의 condition을 조회한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchBaseConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PortTariffMgtBCDBDAOsearchBaseConditionRSQL").append("\n"); 
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
		query.append("t22.cond_no, t22.condition , t22.object," ).append("\n"); 
		query.append("t22.uom , t22.operator, t22.obj_value, t22.row_no line_num, '10' seq" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  COND_NO" ).append("\n"); 
		query.append("FROM    PSO_YD_CHG T1,  PSO_YD_CHG_XPR T2,  PSO_CHG_XPR_DTL T3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select  t2.acct_cd, t2.lgs_cost_cd, lgs_cost_full_nm" ).append("\n"); 
		query.append("from    pso_inv_ofc_cost t1, tes_lgs_cost t2" ).append("\n"); 
		query.append("where    t1.lgs_cost_cd = t2.lgs_cost_cd" ).append("\n"); 
		query.append("and     t1.ofc_cd      = @[ofc_cd]" ).append("\n"); 
		query.append("and     t2.acct_cd          <> '999999'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 
		query.append(")  T4" ).append("\n"); 
		query.append("WHERE   T1.YD_CHG_NO        = T2.YD_CHG_NO" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD      = T4.lgs_cost_cd" ).append("\n"); 
		query.append("--AND     T1.LST_FLG          = 'Y'" ).append("\n"); 
		query.append("#if( ${port_cd} == '' )" ).append("\n"); 
		query.append("AND     T1.YD_CD            = @[combo1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     T1.YD_CD            = @[port_cd] || @[combo1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     T1.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${org_vndr_nm} != '' )" ).append("\n"); 
		query.append("AND     T1.ORG_VNDR_NM            LIKE '%' || @[org_vndr_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${acct_cd} == '')" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD      = @[combo3]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     T4.acct_cd          = @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = @[combo4]" ).append("\n"); 
		query.append("AND     T1.eff_dt = to_date( @[from_date] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     T1.exp_dt = to_date( @[to_date] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--           AND     SYSDATE BETWEEN T1.EFF_DT AND  T1.EXP_DT" ).append("\n"); 
		query.append("AND     T2.CHG_XPR_NO       = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("GROUP BY T2.PSO_CHG_TP_CD,T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,T3.coND_NO" ).append("\n"); 
		query.append(") T21 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("t1.cond_no, t1.c1 condition , t2.PSO_OBJ_CD object, t2.OBJ_LIST_NO uom , t1.c3 operator, t1.c4 obj_value, t1.row_no row_no" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   row_no," ).append("\n"); 
		query.append("MAX(cond_no) cond_no ," ).append("\n"); 
		query.append("MAX(DECODE (row_no," ).append("\n"); 
		query.append("1, NULL," ).append("\n"); 
		query.append("DECODE (MOD (cond_seq, 4), 0, pso_cond_opr_cd)))" ).append("\n"); 
		query.append("c1," ).append("\n"); 
		query.append("MAX(DECODE (row_no," ).append("\n"); 
		query.append("1, DECODE (cond_seq, 1, obj_list_no)," ).append("\n"); 
		query.append("DECODE (MOD (cond_seq, 4), 1, obj_list_no)))" ).append("\n"); 
		query.append("c2," ).append("\n"); 
		query.append("MAX(DECODE (row_no," ).append("\n"); 
		query.append("1, DECODE (cond_seq, 2, pso_cond_opr_cd )," ).append("\n"); 
		query.append("DECODE (MOD (cond_seq, 4), 2, pso_cond_opr_cd )))" ).append("\n"); 
		query.append("c3," ).append("\n"); 
		query.append("MAX(DECODE (row_no," ).append("\n"); 
		query.append("1, DECODE (cond_seq, 3, cond_opr_val_ctnt)," ).append("\n"); 
		query.append("DECODE (MOD (cond_seq, 4), 3, cond_opr_val_ctnt)))" ).append("\n"); 
		query.append("c4" ).append("\n"); 
		query.append("FROM   pso_cond_dtl" ).append("\n"); 
		query.append("GROUP BY   cond_no,row_no" ).append("\n"); 
		query.append("order by  cond_no,row_no" ).append("\n"); 
		query.append(") t1, pso_obj_list t2" ).append("\n"); 
		query.append("where t1.c2 = t2.obj_list_no" ).append("\n"); 
		query.append(") t22" ).append("\n"); 
		query.append("where t21.cond_no = t22.cond_no" ).append("\n"); 

	}
}