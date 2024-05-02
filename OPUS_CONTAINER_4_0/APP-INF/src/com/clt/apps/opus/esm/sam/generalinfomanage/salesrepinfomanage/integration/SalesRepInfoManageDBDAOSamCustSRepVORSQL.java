/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRepInfoManageDBDAOSamCustSRepVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.23 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepInfoManageDBDAOSamCustSRepVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep 정보 조회
	  * </pre>
	  */
	public SalesRepInfoManageDBDAOSamCustSRepVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_office",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration").append("\n"); 
		query.append("FileName : SalesRepInfoManageDBDAOSamCustSRepVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT C.SREP_CD" ).append("\n"); 
		query.append("      ,C.SREP_EML" ).append("\n"); 
		query.append("      ,C.SREP_NM" ).append("\n"); 
		query.append("      ,C.EMPE_CD" ).append("\n"); 
		query.append("      ,C.OFC_CD" ).append("\n"); 
		query.append("      ,C.OFC_TEAM_CD" ).append("\n"); 
		query.append("      ,NVL2(C.IB_SREP_FLG,'Y','N') IB" ).append("\n"); 
		query.append("	  ,NVL2(C.OB_SREP_FLG,'Y','N') OB" ).append("\n"); 
		query.append("      ,C.DELT_FLG" ).append("\n"); 
		query.append("	  ,'' OPEN_PAGE" ).append("\n"); 
		query.append("	  ,'' CUST_OFFICE" ).append("\n"); 
		query.append("      ,'' CUST_CD" ).append("\n"); 
		query.append("	  ,'' CUST_STATUS" ).append("\n"); 
		query.append("#if(${cust_cd} != ''|| ${cust_status} != '')      " ).append("\n"); 
		query.append("	  ,DD.SREP_PRMRY_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM MDM_SLS_REP C" ).append("\n"); 
		query.append("#if(${cust_cd} != ''|| ${cust_status} != '')" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("          SELECT A.CUST_CNT_CD" ).append("\n"); 
		query.append("                ,A.CUST_SEQ" ).append("\n"); 
		query.append("                ,A.CUST_STS_CD" ).append("\n"); 
		query.append("                ,B.SREP_CD" ).append("\n"); 
		query.append("                ,B.SREP_PRMRY_FLG" ).append("\n"); 
		query.append("            FROM SAM_CUST_SLS_REP_INFO B" ).append("\n"); 
		query.append("                ,MDM_CUSTOMER A" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("             AND A.CUST_CNT_CD = B.CUST_CNT_CD(+)  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("            #if(${cust_cd} != '')" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if(${cust_status} == 'A')" ).append("\n"); 
		query.append("            AND A.CUST_STS_CD = 'A'" ).append("\n"); 
		query.append("            #elseif(${cust_status} == 'I')" ).append("\n"); 
		query.append("            AND A.CUST_STS_CD = 'D'" ).append("\n"); 
		query.append("            #end            " ).append("\n"); 
		query.append("          ) DD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${cust_office} != '')" ).append("\n"); 
		query.append("AND C.OFC_CD = @[cust_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != ''|| ${cust_status} != '')" ).append("\n"); 
		query.append("AND C.SREP_CD = DD.SREP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.SREP_CD" ).append("\n"); 

	}
}