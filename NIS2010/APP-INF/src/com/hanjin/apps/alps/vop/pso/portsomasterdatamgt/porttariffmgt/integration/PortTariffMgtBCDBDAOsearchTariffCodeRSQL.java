/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchTariffCodeRSQL.java
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

public class PortTariffMgtBCDBDAOsearchTariffCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tariff list의 코드를 가져온다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchTariffCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchTariffCodeRSQL").append("\n"); 
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
		query.append("SELECT  T1.YD_CHG_NO, T1.YD_CHG_VER_SEQ ,T2.PSO_CHG_TP_CD," ).append("\n"); 
		query.append("T2.YD_CHG_XPR_NO," ).append("\n"); 
		query.append("T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,COND_NO, T3.FOML_NO" ).append("\n"); 
		query.append("FROM    PSO_YD_CHG T1,  PSO_YD_CHG_XPR T2,  PSO_CHG_XPR_DTL T3" ).append("\n"); 
		query.append("WHERE   T1.YD_CHG_NO        = T2.YD_CHG_NO" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("--            AND     T1.LST_FLG          = 'Y'" ).append("\n"); 
		query.append("AND     T1.YD_CD            = @[port_cd] || @[combo1]" ).append("\n"); 
		query.append("AND     T1.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD      = @[combo3]" ).append("\n"); 
		query.append("AND     T1.YD_CHG_VER_SEQ   = @[combo4]" ).append("\n"); 
		query.append("--AND     T1.eff_dt = to_date( *from_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--AND     T1.exp_dt = to_date( *to_date ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("--           AND     SYSDATE BETWEEN T1.EFF_DT AND  T1.EXP_DT" ).append("\n"); 
		query.append("AND     T2.CHG_XPR_NO       = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("GROUP BY T1.YD_CHG_NO, T1.YD_CHG_VER_SEQ , T2.PSO_CHG_TP_CD,T2.YD_CHG_XPR_NO," ).append("\n"); 
		query.append("T3.CHG_XPR_NO, T3.CHG_XPR_SEQ,COND_NO, T3.FOML_NO" ).append("\n"); 

	}
}