/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MstMgmtDBDAOSearchOfcKndCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchOfcKndCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 USER OFC_CD 의 OFC_KND_CD 정보를 조회한다.
	  * </pre>
	  */
	public MstMgmtDBDAOSearchOfcKndCdRSQL(){
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
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchOfcKndCdRSQL").append("\n"); 
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
		query.append("SELECT OFC_LVL OFC_KND_CD, OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.OFC_CD OFC_CD," ).append("\n"); 
		query.append("       L1 OFC_LVL," ).append("\n"); 
		query.append("       DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD) HO ," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, B.OFC_CD, 3, C.OFC_CD, 4, D.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("         ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD)" ).append("\n"); 
		query.append("       END AS RHQ ," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, B.OFC_CD, 4, C.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("         ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD)" ).append("\n"); 
		query.append("       END AS BB_AA ," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD) = DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, B.OFC_CD) THEN NULL" ).append("\n"); 
		query.append("         ELSE DECODE(A.L1, 1, A.OFC_CD, 2, A.OFC_CD, 3, A.OFC_CD, 4, A.OFC_CD)" ).append("\n"); 
		query.append("       END AS SUB_BB ," ).append("\n"); 
		query.append("       A.OFC_ENG_NM ," ).append("\n"); 
		query.append("       A.DEL AS STATUS" ).append("\n"); 
		query.append("  FROM (SELECT OFC_CD ," ).append("\n"); 
		query.append("               OFC_ENG_NM," ).append("\n"); 
		query.append("               LOC_CD ," ).append("\n"); 
		query.append("               PRNT_OFC_CD ," ).append("\n"); 
		query.append("               DELT_FLG DEL ," ).append("\n"); 
		query.append("               A.OFC_KND_CD OFC_KIND ," ).append("\n"); 
		query.append("               LEVEL L1" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION A START WITH A.OFC_CD = COM_CONSTANTMGR_PKG.COM_getHeadOfficeCode_FNC() CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD ) A ," ).append("\n"); 
		query.append("       MDM_ORGANIZATION B ," ).append("\n"); 
		query.append("       MDM_ORGANIZATION C ," ).append("\n"); 
		query.append("       MDM_ORGANIZATION D" ).append("\n"); 
		query.append(" WHERE A.PRNT_OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("   AND B.PRNT_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("   AND C.PRNT_OFC_CD = D.OFC_CD(+))" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}