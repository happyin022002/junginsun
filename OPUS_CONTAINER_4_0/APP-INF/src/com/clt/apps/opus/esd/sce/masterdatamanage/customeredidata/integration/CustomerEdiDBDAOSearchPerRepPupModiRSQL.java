/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchPerRepPupModiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
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

public class CustomerEdiDBDAOSearchPerRepPupModiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPerRepPupModi
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchPerRepPupModiRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchPerRepPupModiRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.*" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(U.EDI_GRP_CD, NULL, '0', '1') EDI_GRP_CD" ).append("\n"); 
		query.append("             , CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("             , CGO.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("             , STS.EDI_STS_DESC" ).append("\n"); 
		query.append("             , STS.EDI_STS_SEQ" ).append("\n"); 
		query.append("          FROM EDI_USR_STS U" ).append("\n"); 
		query.append("             , EDI_GRP_CGO CGO" ).append("\n"); 
		query.append("             , EDI_CGO_STND_STS STS" ).append("\n"); 
		query.append("         WHERE U.EDI_STND_STS_CD(+) = CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("           AND U.CUST_EDI_STS_CD(+) = CGO.CUST_EDI_STS_CD" ).append("\n"); 
		query.append("           AND STS.EDI_STND_STS_CD = CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("           AND U.CRE_USR_ID(+) =  @[cre_usr_id]" ).append("\n"); 
		query.append("           AND U.EDI_GRP_CD(+) = @[edi_grp_cd]" ).append("\n"); 
		query.append("           AND CGO.EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("         ORDER BY STS.EDI_STS_SEQ" ).append("\n"); 
		query.append("             , CGO.EDI_STND_STS_CD" ).append("\n"); 
		query.append("             , STS.EDI_STS_DESC" ).append("\n"); 
		query.append("             , CGO.CUST_EDI_STS_CD ) A" ).append("\n"); 
		query.append(" ORDER BY A.EDI_STS_SEQ" ).append("\n"); 
		query.append("     , A.EDI_STND_STS_CD" ).append("\n"); 
		query.append("     , A.EDI_STS_DESC" ).append("\n"); 
		query.append("     , A.CUST_EDI_STS_CD " ).append("\n"); 

	}
}