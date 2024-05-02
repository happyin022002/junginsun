/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOMstRsltAcceptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOMstRsltAcceptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 accept되지 않은 data 조회
	  * </pre>
	  */
	public RFAProposalMainDBDAOMstRsltAcceptListRSQL(){
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
		query.append("FileName : RFAProposalMainDBDAOMstRsltAcceptListRSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("FROM   (SELECT 'MN' PROP_NO" ).append("\n"); 
		query.append("        FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("        WHERE  PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND    ACPT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    ROWNUM = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'SCP' PROP_NO" ).append("\n"); 
		query.append("        FROM   PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("        WHERE  PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND    ACPT_FLG = 'N'" ).append("\n"); 
		query.append("        AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    ROWNUM = 1" ).append("\n"); 
		query.append("        -- Note Conversion을 별도로 체크" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'NOTE' PROP_NO" ).append("\n"); 
		query.append("        FROM   PRI_RFA_NOTE_CONV" ).append("\n"); 
		query.append("        WHERE  PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("        AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND    PRC_PROG_STS_CD <> 'A'" ).append("\n"); 
		query.append("        AND    ROWNUM = 1)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}