/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOCheckExpDateForTariffMgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOCheckExpDateForTariffMgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Value Management 입력시 EXP_DT 체크
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOCheckExpDateForTariffMgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOCheckExpDateForTariffMgtRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, 'O', 'X') FLAG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT DECODE(X.YD_CHG_NO, @[yd_chg_no]," ).append("\n"); 
		query.append("                      CASE WHEN TO_DATE(@[exp_dt], 'YYYY-MM-DD') <  X.EFF_DT THEN 'X'    --EXP_DT가 EFF_DT 보다 클 경우 " ).append("\n"); 
		query.append("                           WHEN TO_DATE(@[exp_dt], 'YYYY-MM-DD') > NVL(LAG(X.EFF_DT) OVER(ORDER BY X.EFF_DT DESC), TO_DATE('9999-12-31','YYYY-MM-DD')) THEN 'X' --EXP_DT가 이전 EFF_DT보다 클 경우" ).append("\n"); 
		query.append("                           ELSE 'O'" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                      , 'O' " ).append("\n"); 
		query.append("                     ) FLAG" ).append("\n"); 
		query.append("        FROM   (SELECT DISTINCT A.YD_CHG_NO" ).append("\n"); 
		query.append("                               ,A.EFF_DT                       " ).append("\n"); 
		query.append("                               ,A.EXP_DT                       " ).append("\n"); 
		query.append("                               ,C.UPD_MNU_NO" ).append("\n"); 
		query.append("                FROM   PSO_YD_CHG     A" ).append("\n"); 
		query.append("                      ,PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("                      ,PSO_CHG_XPR    C" ).append("\n"); 
		query.append("                WHERE  1 = 1" ).append("\n"); 
		query.append("                AND    A.YD_CD = @[port_cd] || @[yd_cd]                  " ).append("\n"); 
		query.append("                AND    A.VNDR_SEQ = @[vndr_seq]                            " ).append("\n"); 
		query.append("                AND    A.LGS_COST_CD = @[cost_cd]                      " ).append("\n"); 
		query.append("                AND    A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("                AND    A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                AND    C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                AND    B.PSO_CHG_TP_CD = 'B'" ).append("\n"); 
		query.append("                ORDER  BY 2 DESC" ).append("\n"); 
		query.append("               ) X          " ).append("\n"); 
		query.append("        ORDER  BY X.EFF_DT DESC   " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE   FLAG = 'X'" ).append("\n"); 

	}
}