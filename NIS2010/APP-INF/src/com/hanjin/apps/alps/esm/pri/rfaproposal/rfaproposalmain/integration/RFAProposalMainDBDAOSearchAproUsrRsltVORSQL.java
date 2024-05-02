/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchAproUsrRsltVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2016.04.25 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchAproUsrRsltVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAOSearchAproUsrRsltVO
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchAproUsrRsltVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchAproUsrRsltVORSQL").append("\n"); 
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
		query.append("SELECT PROG_USR_ID " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT C.*    " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        PRI_RP_HDR  A" ).append("\n"); 
		query.append("       ,PRI_RP_MN   B" ).append("\n"); 
		query.append("       ,PRI_RP_PROG C" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        A.PROP_NO  = B.PROP_NO " ).append("\n"); 
		query.append("    AND B.PROP_NO  = C.PROP_NO" ).append("\n"); 
		query.append("    AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("    AND C.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("    AND A.RFA_NO        =(SELECT A.MST_RFA_NO   FROM PRI_RP_HDR A, PRI_RP_MN B   WHERE A.PROP_NO  = B.PROP_NO AND B.PROP_NO = @[prop_no] AND B.AMDT_SEQ = @[amdt_seq] ) " ).append("\n"); 
		query.append("    AND B.AMDT_SEQ      =(SELECT A.MST_AMDT_SEQ FROM PRI_RP_HDR A, PRI_RP_MN B   WHERE A.PROP_NO  = B.PROP_NO AND B.PROP_NO = @[prop_no] AND B.AMDT_SEQ = @[amdt_seq] )" ).append("\n"); 
		query.append("    ORDER BY PROP_PROG_SEQ DESC" ).append("\n"); 
		query.append(") WHERE ROWNUM < 2" ).append("\n"); 

	}
}