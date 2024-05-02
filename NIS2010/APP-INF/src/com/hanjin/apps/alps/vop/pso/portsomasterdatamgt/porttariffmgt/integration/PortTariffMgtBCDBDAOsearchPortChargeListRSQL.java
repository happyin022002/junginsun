/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchPortChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchPortChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPortChargeList
	  * CHM-201327648 : Surcharge, dicount  포함 account code 붉은색으로 표시
	  * - Port tariff Inquiry(VOP_PSO_0036) 화면 가장 왼쪽 sheet에  Surcharge, dicount 포함하는 
	  *   sd_rw_cnt 추가 
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchPortChargeListRSQL(){
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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchPortChargeListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        YD_CD," ).append("\n"); 
		query.append("        ACCT_CD," ).append("\n"); 
		query.append("        LGS_COST_CD," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        VNDR_ABBR_NM," ).append("\n"); 
		query.append("        YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("        UPD_MNU_NO," ).append("\n"); 
		query.append("        PSO_CHG_TP_CD," ).append("\n"); 
		query.append("        SD_RW_CNT," ).append("\n"); 
		query.append("        YEAR," ).append("\n"); 
		query.append("        PORT_CD," ).append("\n"); 
		query.append("        EFF_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT   C1.YD_CD," ).append("\n"); 
		query.append("                   T.ACCT_CD," ).append("\n"); 
		query.append("                   C1.LGS_COST_CD," ).append("\n"); 
		query.append("                   C1.CURR_CD," ).append("\n"); 
		query.append("                   C1.VNDR_SEQ," ).append("\n"); 
		query.append("                   --V.VNDR_ABBR_NM," ).append("\n"); 
		query.append("                   V.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("                   --C1.YD_CHG_NO," ).append("\n"); 
		query.append("                   MAX (C1.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("                   C3.UPD_MNU_NO," ).append("\n"); 
		query.append("                   C2.PSO_CHG_TP_CD   PSO_CHG_TP_CD," ).append("\n"); 
		query.append("                   COUNT(T.ACCT_CD) OVER (PARTITION BY C1.YD_CD,T.ACCT_CD,C1.VNDR_SEQ  ORDER BY C1.YD_CD,T.ACCT_CD,C1.VNDR_SEQ ) AS SD_RW_CNT," ).append("\n"); 
		query.append("                   '' YEAR," ).append("\n"); 
		query.append("                   '' PORT_CD" ).append("\n"); 
		query.append("                  ,'' EFF_DT" ).append("\n"); 
		query.append("            FROM   PSO_YD_CHG C1," ).append("\n"); 
		query.append("                   PSO_YD_CHG_XPR C2," ).append("\n"); 
		query.append("                   PSO_CHG_XPR C3," ).append("\n"); 
		query.append("                   TES_LGS_COST T," ).append("\n"); 
		query.append("                   MDM_VENDOR V" ).append("\n"); 
		query.append("           WHERE       C1.YD_CHG_NO = C2.YD_CHG_NO" ).append("\n"); 
		query.append("                   AND C1.YD_CHG_VER_SEQ = C2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                   AND C2.CHG_XPR_NO = C3.CHG_XPR_NO" ).append("\n"); 
		query.append("                  --AND C2.PSO_CHG_TP_CD = 'B'" ).append("\n"); 
		query.append("                   AND T.LGS_COST_CD = C1.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND C1.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("                   --AND TO_CHAR (eff_dt, 'YYYY') = *year" ).append("\n"); 
		query.append("                   AND    EFF_DT <= TO_DATE(@[year] || '1231', 'YYYYMMDD')" ).append("\n"); 
		query.append("                   AND    EXP_DT >= TO_DATE(@[year] || '0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if( ${port_cd}!='')           " ).append("\n"); 
		query.append("        AND SUBSTR (C1.YD_CD, 1, 5) = @[port_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if( ${yd_cd}!='')" ).append("\n"); 
		query.append("                   AND SUBSTR (C1.YD_CD, 6) IN (#foreach( $key IN ${arr_yd_cd}) " ).append("\n"); 
		query.append("                                                    #if($velocityCount < $arr_yd_cd.size())" ).append("\n"); 
		query.append("                                                        '$key'," ).append("\n"); 
		query.append("                                                    #else" ).append("\n"); 
		query.append("                                                        '$key'" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                                #end)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if( ${acct_cd}!='' && ${acct_cd}!='All')  " ).append("\n"); 
		query.append("                   AND T.ACCT_CD IN (#foreach( $key IN ${arr_acct_cd}) " ).append("\n"); 
		query.append("                                                    #if($velocityCount < $arr_acct_cd.size())" ).append("\n"); 
		query.append("                                                        '$key'," ).append("\n"); 
		query.append("                                                    #else" ).append("\n"); 
		query.append("                                                        '$key'" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                                 #end)" ).append("\n"); 
		query.append("        #end            " ).append("\n"); 
		query.append("        GROUP BY   C1.YD_CD," ).append("\n"); 
		query.append("                   T.ACCT_CD," ).append("\n"); 
		query.append("                   C1.LGS_COST_CD," ).append("\n"); 
		query.append("                   C3.UPD_MNU_NO," ).append("\n"); 
		query.append("                   --C1.YD_CHG_NO," ).append("\n"); 
		query.append("                   C1.VNDR_SEQ," ).append("\n"); 
		query.append("                   V.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("                   C1.CURR_CD," ).append("\n"); 
		query.append("                   C2.PSO_CHG_TP_CD" ).append("\n"); 
		query.append("        ORDER  BY ACCT_CD" ).append("\n"); 
		query.append("                 ,LGS_COST_CD" ).append("\n"); 
		query.append("                 ,C1.YD_CD" ).append("\n"); 
		query.append("                 ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND A.PSO_CHG_TP_CD = 'B'" ).append("\n"); 
		query.append("    ORDER  BY ACCT_CD ,LGS_COST_CD ,YD_CD,VNDR_ABBR_NM" ).append("\n"); 

	}
}