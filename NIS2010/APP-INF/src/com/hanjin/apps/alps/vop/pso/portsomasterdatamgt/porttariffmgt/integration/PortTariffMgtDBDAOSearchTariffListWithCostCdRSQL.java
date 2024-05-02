/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtDBDAOSearchTariffListWithCostCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.11.10 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtDBDAOSearchTariffListWithCostCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG 테이블에서 PortCd와 CostCd를 가지는 Tariff List를 조회한다.
	  * ---------------------------------------------------------------------------------
	  * CHM-201006949-01 박희동 신규
	  * </pre>
	  */
	public PortTariffMgtDBDAOSearchTariffListWithCostCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtDBDAOSearchTariffListWithCostCdRSQL").append("\n"); 
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
		query.append("T1.YD_CHG_NO" ).append("\n"); 
		query.append(",T1.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",T1.LGS_COST_CD" ).append("\n"); 
		query.append(",T1.YD_CD" ).append("\n"); 
		query.append(",(SELECT YD_NM FROM MDM_YARD WHERE YD_CD=T1.YD_CD) YD_NM" ).append("\n"); 
		query.append(",T1.VNDR_SEQ" ).append("\n"); 
		query.append(",T1.EFF_DT" ).append("\n"); 
		query.append(",T1.EXP_DT" ).append("\n"); 
		query.append(",T1.CURR_CD" ).append("\n"); 
		query.append(",T1.CPLS_FLG" ).append("\n"); 
		query.append(",T1.ORG_VNDR_NM" ).append("\n"); 
		query.append(",T1.RLT_AGMT_NO" ).append("\n"); 
		query.append(",T1.LST_FLG" ).append("\n"); 
		query.append(",T1.CRE_USR_ID" ).append("\n"); 
		query.append(",T1.CRE_DT" ).append("\n"); 
		query.append(",T1.UPD_USR_ID" ).append("\n"); 
		query.append(",T1.UPD_DT" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG T1" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    T1.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("AND    T1.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("AND    T1.LST_FLG='Y'" ).append("\n"); 

	}
}