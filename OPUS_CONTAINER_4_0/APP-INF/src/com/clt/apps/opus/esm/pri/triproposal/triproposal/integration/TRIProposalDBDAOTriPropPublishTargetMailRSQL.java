/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOTriPropPublishTargetMailRSQL.java
*@FileTitle : titl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.24 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOTriPropPublishTargetMailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRI Publish 시 메일 보내는 대상을 조회한다.
	  * </pre>
	  */
	public TRIProposalDBDAOTriPropPublishTargetMailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOTriPropPublishTargetMailRSQL").append("\n"); 
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
		query.append("SELECT  USR_EML" ).append("\n"); 
		query.append("FROM    COM_USER" ).append("\n"); 
		query.append("WHERE   USR_ID  IN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TRI_RQST_USR_ID" ).append("\n"); 
		query.append("        FROM    PRI_TRI_RT" ).append("\n"); 
		query.append("        WHERE   TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("        AND     AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  ( SELECT A.EMPE_CD FROM MDM_SLS_REP A WHERE A.SREP_CD = TA.RESPB_SREP_CD )  EMPE_CD" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  TM.TAA_PROP_NO" ).append("\n"); 
		query.append("                      , TM.AMDT_SEQ" ).append("\n"); 
		query.append("                      , TM.RESPB_SREP_CD" ).append("\n"); 
		query.append("                      , ROW_NUMBER() OVER ( PARTITION BY TM.TAA_PROP_NO ORDER BY TM.AMDT_SEQ DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM    PRI_TRI_RT TR" ).append("\n"); 
		query.append("                      , PRI_TAA_TRI_LIST TL" ).append("\n"); 
		query.append("                      , PRI_TAA_MN TM" ).append("\n"); 
		query.append("                WHERE   TL.TRI_PROP_NO  = TR.TRI_PROP_NO" ).append("\n"); 
		query.append("                AND     TM.TAA_PROP_NO  = TL.TAA_PROP_NO" ).append("\n"); 
		query.append("                AND     TM.AMDT_SEQ     = TL.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     TR.TRI_PROP_NO  = @[tri_prop_no]" ).append("\n"); 
		query.append("                AND     TR.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("                AND     TM.EXP_DT       >= TR.EFF_DT" ).append("\n"); 
		query.append("                )   TA" ).append("\n"); 
		query.append("        WHERE   TA.ROW_NUMBER  = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}