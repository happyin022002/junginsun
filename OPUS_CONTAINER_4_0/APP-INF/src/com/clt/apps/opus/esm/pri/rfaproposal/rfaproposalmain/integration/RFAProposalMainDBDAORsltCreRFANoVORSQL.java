/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltCreRFANoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.03.26 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltCreRFANoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA NO 생성
	  * Office Prefix 3자리 + 연도 2자리 + A (Approval) + Sequence 4자리
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltCreRFANoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_ctrf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltCreRFANoVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       CASE WHEN NVL(@[trf_ctrf_flg],'N') = 'Y' THEN" ).append("\n"); 
		query.append("            'TRF'||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'A'||LPAD(NVL(MAX(SUBSTR(RFA_NO,-4)),0)+1,4,'0') " ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'A'||LPAD(NVL(MAX(SUBSTR(RFA_NO,-4)),0)+1,4,'0') " ).append("\n"); 
		query.append("        END RFA_NO" ).append("\n"); 
		query.append("  FROM PRI_RP_HDR" ).append("\n"); 
		query.append(" WHERE RFA_NO LIKE CASE WHEN NVL(@[trf_ctrf_flg],'N') = 'Y' THEN" ).append("\n"); 
		query.append("                        'TRF'||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'%'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                        SUBSTR(@[ofc_cd],0,3)||SUBSTR(TO_CHAR(SYSDATE,'YYYY'),-2)||'%'" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("   AND PRC_PROP_CRE_TP_CD <> 'I'" ).append("\n"); 

	}
}