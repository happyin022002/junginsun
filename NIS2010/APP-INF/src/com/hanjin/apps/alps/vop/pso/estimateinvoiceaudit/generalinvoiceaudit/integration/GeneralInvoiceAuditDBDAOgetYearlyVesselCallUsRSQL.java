/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetYearlyVesselCallUsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetYearlyVesselCallUsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201533647] 해당 년동안 해당 vessel이  미국내 port에 calling하는 횟수
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetYearlyVesselCallUsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetYearlyVesselCallUsRSQL").append("\n"); 
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
		query.append("select nvl(count(*),0)" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("from vsk_bud_vsl_port_skd " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("from vsk_vsl_port_skd " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   where VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   and vps_port_cd like substr(@[yd_cd], 1, 2)||'%'" ).append("\n"); 
		query.append("   and NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("   and vps_etb_dt <= (select max(vps_etb_dt)" ).append("\n"); 
		query.append("                      #if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                      from vsk_bud_vsl_port_skd " ).append("\n"); 
		query.append("                      #else " ).append("\n"); 
		query.append("                      from vsk_vsl_port_skd " ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      where VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("                      and vps_port_cd = substr(@[yd_cd], 1, 5))" ).append("\n"); 
		query.append("and TURN_PORT_IND_CD IN ('N','Y')" ).append("\n"); 
		query.append("and to_char(vps_etb_dt,'YYYY') = (select max(to_char(vps_etb_dt,'YYYY'))" ).append("\n"); 
		query.append("                                  #if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                                  from vsk_bud_vsl_port_skd " ).append("\n"); 
		query.append("                                  #else " ).append("\n"); 
		query.append("                                  from vsk_vsl_port_skd " ).append("\n"); 
		query.append("                                  #end" ).append("\n"); 
		query.append("                                  where VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                  AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                  AND SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("                                  and vps_port_cd = substr(@[yd_cd], 1, 5))" ).append("\n"); 

	}
}