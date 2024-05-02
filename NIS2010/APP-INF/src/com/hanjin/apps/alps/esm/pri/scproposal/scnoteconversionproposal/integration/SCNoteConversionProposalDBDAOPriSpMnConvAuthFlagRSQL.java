/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCNoteConversionProposalDBDAOPriSpMnConvAuthFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.17 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriSpMnConvAuthFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * conversion 입력 가능/불가 확인하는 쿼리
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriSpMnConvAuthFlagRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriSpMnConvAuthFlagRSQL").append("\n"); 
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
		query.append("		SELECT  " ).append("\n"); 
		query.append("			DECODE(MN.PROP_SREP_CD,@[srep_cd],'Y','N') REQ_USR_FLG" ).append("\n"); 
		query.append("			,CASE WHEN @[ofc_cd] = 'PHXSA' or @[ofc_cd] = 'NYCRA' or @[ofc_cd] = 'SELCMA' or @[ofc_cd] = 'SELCMD' THEN 'Y'" ).append("\n"); 
		query.append("			 ELSE 'N' END as OFC_AUTH_YN" ).append("\n"); 
		query.append("		  FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("		 WHERE PROP_NO 	= @[prop_no]" ).append("\n"); 
		query.append("		   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}