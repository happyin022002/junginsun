/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchOfficeYardsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchOfficeYardsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfficeYards
	  * 
	  * 2014.05.30 박다은 [CHM-201430328] [PSO] Port Charge invoice Creation 기능 개선
	  * 2015.08.17 김기원 CHM-201537022  조직 코드 변경
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchOfficeYardsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchOfficeYardsRSQL").append("\n"); 
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
		query.append("SELECT YD_CD1," ).append("\n"); 
		query.append("       YD_CD2," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       CRE_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                 DECODE((SELECT DISTINCT DECODE(OFC_CD,'SELSC','SELSC',PRNT_OFC_CD )" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND OFC_CD = @[ofc_cd] ),'SELSC',DECODE(T1.YD_CD,'KRPUSHN',1,''),'')  FLAG" ).append("\n"); 
		query.append("                ,T1.YD_CD YD_CD1" ).append("\n"); 
		query.append("                ,T2.YD_NM YD_CD2" ).append("\n"); 
		query.append("                ,T4.AP_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                ,T4.AR_CURR_CD CURR_CD" ).append("\n"); 
		query.append("                ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("          FROM PSO_INV_OFC_YD T1, MDM_YARD T2, MDM_ORGANIZATION T4" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND T1.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND T1.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("           AND T2.OFC_CD = T4.OFC_CD" ).append("\n"); 
		query.append("           AND T4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append(" ORDER BY DECODE(FLAG,NULL,YD_CD1,99)" ).append("\n"); 

	}
}