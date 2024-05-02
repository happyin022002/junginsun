/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStsList
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchStsListRSQL").append("\n"); 
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
		query.append("#if(${edi_grp_cd} != '')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("             CGO.EDI_STND_STS_CD  STND_CD      			                            " ).append("\n"); 
		query.append("             , STS.EDI_STS_DESC CS_DESC                                    " ).append("\n"); 
		query.append("             , max(CGO.CUST_EDI_STS_CD)  CUST_CD                                 " ).append("\n"); 
		query.append("      FROM EDI_GROUP GRP, EDI_GRP_CGO CGO  , EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("      WHERE " ).append("\n"); 
		query.append("      1=1" ).append("\n"); 
		query.append("      AND GRP.EDI_GRP_CD =   @[edi_grp_cd]                                              " ).append("\n"); 
		query.append("      AND GRP.EDI_GRP_CD = CGO.EDI_GRP_CD                                       " ).append("\n"); 
		query.append("      AND GRP.CO_DIV_CD = CGO.CO_DIV_CD                                    " ).append("\n"); 
		query.append("      AND CGO.EDI_STND_STS_CD   = STS.EDI_STND_STS_CD                      " ).append("\n"); 
		query.append("      AND CGO.CO_DIV_CD = STS.CO_DIV_CD   " ).append("\n"); 
		query.append("      GROUP BY STS.EDI_STS_SEQ, CGO.EDI_STND_STS_CD, STS.EDI_STS_DESC-- ,CGO.CUST_EDI_STS_CD       " ).append("\n"); 
		query.append("      ORDER BY STS.EDI_STS_SEQ, CGO.EDI_STND_STS_CD, STS.EDI_STS_DESC-- ,CGO.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--In order not to search any data!" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("             CGO.EDI_STND_STS_CD  STND_CD      			                            " ).append("\n"); 
		query.append("             , STS.EDI_STS_DESC CS_DESC                                    " ).append("\n"); 
		query.append("             , CGO.CUST_EDI_STS_CD  CUST_CD                                 " ).append("\n"); 
		query.append("      FROM EDI_GROUP GRP, EDI_GRP_CGO CGO  , EDI_CGO_STND_STS STS " ).append("\n"); 
		query.append("      WHERE ROWNUM < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}