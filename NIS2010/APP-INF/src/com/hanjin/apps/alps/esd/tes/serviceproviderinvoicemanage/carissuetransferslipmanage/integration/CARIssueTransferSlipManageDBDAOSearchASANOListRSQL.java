/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchASANOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.29 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchASANOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchASANOList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchASANOListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchASANOListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(ASA_NO,'|')),'|') asanostring" ).append("\n"); 
		query.append(",LTRIM(MAX(SYS_CONNECT_BY_PATH(asa_curr_cd,'|')),'|') asacurrcdstring" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ASA_NO, ROWNUM ROW_ID, asa_curr_cd" ).append("\n"); 
		query.append("FROM   AR_AGN_STMT_AGMT" ).append("\n"); 
		query.append("WHERE  EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("AND    AC_EFF_DT IS NULL" ).append("\n"); 
		query.append("AND    ASA_CLZ_DT IS NULL" ).append("\n"); 
		query.append("AND    ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND    ASA_OFC_CD IN ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE  ( SUBSTR(LOC_CD, 1, 2) = 'CN'" ).append("\n"); 
		query.append("AND    OFC_CD = @[ofc_cd] )" ).append("\n"); 
		query.append("OR     AR_OFC_CD = (SELECT AR_OFC_CD FROM   MDM_ORGANIZATION WHERE  OFC_CD = @[ofc_cd]) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}