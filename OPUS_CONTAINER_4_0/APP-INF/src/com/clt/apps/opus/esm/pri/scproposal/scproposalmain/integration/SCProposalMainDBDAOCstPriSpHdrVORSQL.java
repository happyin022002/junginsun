/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCProposalMainDBDAOCstPriSpHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOCstPriSpHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추가 할 S/C Number를 조회한다.
	  * 
	  * SELECT   SC_PFX_CD || TO_CHAR(SYSDATE,'YY')|| LPAD (NUM, 4, '0') SC_NO
	  * FROM     (SELECT SC_NO
	  *                 , SUBSTR (SC_NO, -4) - ROWNUM CNT
	  *                 ,ROWNUM NUM
	  *                 ,INP.SC_PFX_CD
	  *           FROM   PRI_SP_HDR
	  *                 , (SELECT MAP.SC_PFX_CD
	  *                    FROM   PRI_SC_PFX_MAPG MAP
	  *                          ,MDM_ORGANIZATION ORG
	  *                          ,MDM_LOCATION LOC
	  *                    WHERE  SVC_SCP_CD = @[svc_scp_cd] --'TPE'
	  *                    AND    ORG.OFC_CD = @[ofc_cd]--'SELBB'
	  *                    AND    ORG.LOC_CD = LOC.LOC_CD
	  *                    AND    LOC.SCONTI_CD = MAP.SCONTI_CD) INP
	  *           WHERE  SC_NO LIKE INP.SC_PFX_CD || TO_CHAR(SYSDATE,'YY') || '%'
	  * 		  AND    LENGTH(SC_NO) = 9)
	  * WHERE    CNT <> 0
	  * AND      ROWNUM = 1
	  * ORDER BY CNT
	  * </pre>
	  */
	public SCProposalMainDBDAOCstPriSpHdrVORSQL(){
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
		query.append("FileName : SCProposalMainDBDAOCstPriSpHdrVORSQL").append("\n"); 
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
		query.append("SELECT MAP.SC_PFX_CD || TO_CHAR(SYSDATE,'YY')" ).append("\n"); 
		query.append("        ||NVL(LPAD(" ).append("\n"); 
		query.append("            (SELECT NUM" ).append("\n"); 
		query.append("             FROM   (" ).append("\n"); 
		query.append("                     SELECT ROWNUM AS NUM, SEQ" ).append("\n"); 
		query.append("                     FROM   (" ).append("\n"); 
		query.append("                             SELECT DISTINCT TO_NUMBER(SUBSTR(SC_NO, 6)) SEQ" ).append("\n"); 
		query.append("                             FROM   PRI_SP_HDR" ).append("\n"); 
		query.append("                             WHERE  TO_NUMBER(SUBSTR(SC_NO, 4)) >= TO_CHAR(SYSDATE,'YY')||'0001'" ).append("\n"); 
		query.append("                             AND    TO_NUMBER(SUBSTR(SC_NO, 6)) <> 0" ).append("\n"); 
		query.append("                             ORDER BY TO_NUMBER(SUBSTR(SC_NO, 6))" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("             WHERE NUM    <> SEQ" ).append("\n"); 
		query.append("             AND   ROWNUM = 1)  " ).append("\n"); 
		query.append("             ,4,0),'0001') SC_NO" ).append("\n"); 
		query.append("FROM   PRI_SC_PFX_MAPG MAP" ).append("\n"); 
		query.append("     ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("     ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE  SVC_SCP_CD = @[svc_scp_cd] --'TPE'" ).append("\n"); 
		query.append("AND    ORG.OFC_CD = @[ofc_cd]--'SELBB'" ).append("\n"); 
		query.append("AND    ORG.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND    LOC.SCONTI_CD = MAP.SCONTI_CD" ).append("\n"); 

	}
}