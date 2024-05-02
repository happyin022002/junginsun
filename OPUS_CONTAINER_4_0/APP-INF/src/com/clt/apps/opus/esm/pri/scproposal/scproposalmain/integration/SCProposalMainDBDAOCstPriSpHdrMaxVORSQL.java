/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOCstPriSpHdrMaxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.01 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOCstPriSpHdrMaxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C no Max 값을 구한다.
	  * 
	  * S/C No. 3월 한달간만 8자리로변경
	  * 
	  * yy -> 50  
	  * 
	  * SELECT MAP.SC_PFX_CD||TO_CHAR(SYSDATE,'YY')||(SELECT LPAD (MAX (SUBSTR (SC_NO, -3)) + 1, 3, '0') SC_NO
	  *          FROM   PRI_SP_HDR
	  *          WHERE  SC_NO LIKE MAP.SC_PFX_CD || TO_CHAR (SYSDATE, 'YY') || '%') SC_NO
	  * FROM   PRI_SC_PFX_MAPG MAP
	  *       ,MDM_ORGANIZATION ORG
	  *       ,MDM_LOCATION LOC
	  * WHERE  SVC_SCP_CD = @[svc_scp_cd]
	  * AND    ORG.OFC_CD = @[ofc_cd]
	  * AND    ORG.LOC_CD = LOC.LOC_CD
	  * AND    LOC.SCONTI_CD = MAP.SCONTI_CD
	  * </pre>
	  */
	public SCProposalMainDBDAOCstPriSpHdrMaxVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOCstPriSpHdrMaxVORSQL").append("\n"); 
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
		query.append("SELECT MAP.SC_PFX_CD||TO_CHAR(SYSDATE,'YY')||(SELECT LPAD (MAX (SUBSTR (SC_NO, -3)) + 1, 4, '0') SC_NO" ).append("\n"); 
		query.append("         FROM   PRI_SP_HDR" ).append("\n"); 
		query.append("         WHERE  SC_NO LIKE MAP.SC_PFX_CD || TO_CHAR(SYSDATE,'YY') || '%') SC_NO" ).append("\n"); 
		query.append("FROM   PRI_SC_PFX_MAPG MAP" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE  SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ORG.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    ORG.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND    LOC.SCONTI_CD = MAP.SCONTI_CD" ).append("\n"); 

	}
}