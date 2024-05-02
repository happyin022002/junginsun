/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesRepInfoManageDBDAOSearchMdmSrepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.29
*@LastModifier : 이관샨 
*@LastVersion : 1.0
* 2011.07.29 이관샨 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Kuan Sian
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepInfoManageDBDAOSearchMdmSrepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 팝업 시 Sales Rep 조회
	  * </pre>
	  */
	public SalesRepInfoManageDBDAOSearchMdmSrepRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration ").append("\n"); 
		query.append("FileName : SalesRepInfoManageDBDAOSearchMdmSrepRSQL").append("\n"); 
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
		query.append("SELECT C.SREP_EML" ).append("\n"); 
		query.append("      ,C.SREP_NM" ).append("\n"); 
		query.append("      ,C.EMPE_CD" ).append("\n"); 
		query.append("      ,C.OFC_CD" ).append("\n"); 
		query.append("      ,C.OFC_TEAM_CD" ).append("\n"); 
		query.append("      ,C.IB_SREP_FLG||C.OB_SREP_FLG RL" ).append("\n"); 
		query.append("      ,C.SREP_STS_CD" ).append("\n"); 
		query.append("	  ,C.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("      ,MDM_SLS_REP C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND A.SREP_CD = C.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_office} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD = @[cust_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_status} == 'A')" ).append("\n"); 
		query.append("AND A.CUST_STS_CD = 'A'" ).append("\n"); 
		query.append("#elseif(${cust_status} == 'I')" ).append("\n"); 
		query.append("AND A.CUST_STS_CD = 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  C.SREP_EML" ).append("\n"); 
		query.append("      ,C.SREP_NM" ).append("\n"); 
		query.append("      ,C.EMPE_CD" ).append("\n"); 
		query.append("      ,C.OFC_CD" ).append("\n"); 
		query.append("      ,C.OFC_TEAM_CD" ).append("\n"); 
		query.append("      ,C.IB_SREP_FLG||C.OB_SREP_FLG " ).append("\n"); 
		query.append("      ,C.SREP_STS_CD" ).append("\n"); 
		query.append("      ,C.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.SREP_CD" ).append("\n"); 

	}
}