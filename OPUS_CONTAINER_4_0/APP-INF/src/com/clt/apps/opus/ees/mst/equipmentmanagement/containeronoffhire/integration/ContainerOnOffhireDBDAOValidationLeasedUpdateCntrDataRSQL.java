/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOValidationLeasedUpdateCntrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.07 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOValidationLeasedUpdateCntrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationLeasedUpdateCntrData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOValidationLeasedUpdateCntrDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOValidationLeasedUpdateCntrDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS " ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 NVL (CNTR_NO, '') CNTR_NO," ).append("\n"); 
		query.append("                 @[hire_date] HIRE_DATE," ).append("\n"); 
		query.append("                 @[cntr_no3] CNTR_NO3" ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  COUNT(1)||'' AS RESSTR" ).append("\n"); 
		query.append("FROM MST_CNTR_PRE_STS A, PARAM P" ).append("\n"); 
		query.append("WHERE A.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("AND   A.CNTR_PRE_STS_CD =  (SELECT AA.CNTR_STS_CD" ).append("\n"); 
		query.append("                            FROM MST_CONTAINER AA" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                            ##${cntr_no3}" ).append("\n"); 
		query.append("                            #if ($cntr_no3.length() == 0) " ).append("\n"); 
		query.append("                            AND   AA.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            ##${cntr_no3}" ).append("\n"); 
		query.append("                            #if ($cntr_no3.length() != 0) " ).append("\n"); 
		query.append("                             AND   AA.CNTR_NO = MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(SUBSTR(P.CNTR_NO, 1, 10))" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CASE WHEN TRUNC(A.CNMV_DT) >= TO_DATE(P.HIRE_DATE,'YYYY-MM-DD HH24:MI') THEN 'E'" ).append("\n"); 
		query.append("       ELSE '' END RESSTR  " ).append("\n"); 
		query.append("FROM MST_CONTAINER A, PARAM P" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("##${cntr_no3}" ).append("\n"); 
		query.append("#if ($cntr_no3.length() == 0) " ).append("\n"); 
		query.append("AND   A.CNTR_NO      = P.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${cntr_no3}" ).append("\n"); 
		query.append("#if ($cntr_no3.length() != 0) " ).append("\n"); 
		query.append("AND   A.CNTR_NO      = MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(SUBSTR(P.CNTR_NO, 1, 10))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}