/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropBlplAfilVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.15 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropBlplAfilVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Boiler Plate / Affiliate Select
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropBlplAfilVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropBlplAfilVORSQL").append("\n"); 
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
		query.append("SELECT @[prop_no] AS PROP_NO" ).append("\n"); 
		query.append("      ,@[amdt_seq] AS AMDT_SEQ" ).append("\n"); 
		query.append("      ,(SELECT SIGN(COUNT(A.BLPL_SEQ))" ).append("\n"); 
		query.append("        FROM PRI_SP_BLPL A" ).append("\n"); 
		query.append("        WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND   NOT EXISTS (SELECT 'X' FROM PRI_SP_BLPL B" ).append("\n"); 
		query.append("                          WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                          AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                          AND   B.SRC_INFO_CD IN ('GC','GM'))) AS BLPL_CHK" ).append("\n"); 
		query.append("      ,(SELECT SIGN(COUNT(AFIL_SEQ))" ).append("\n"); 
		query.append("        FROM PRI_SP_AFIL" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND   AMDT_SEQ = @[amdt_seq]) AS AFIL_CHK" ).append("\n"); 
		query.append("      ,(SELECT HD.PRC_PROP_CRE_TP_CD" ).append("\n"); 
		query.append("        FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("           , PRI_SP_HDR HD" ).append("\n"); 
		query.append("        WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND   MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND   HD.PROP_NO = MN.PROP_NO) AS PRC_PROP_CRE_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}