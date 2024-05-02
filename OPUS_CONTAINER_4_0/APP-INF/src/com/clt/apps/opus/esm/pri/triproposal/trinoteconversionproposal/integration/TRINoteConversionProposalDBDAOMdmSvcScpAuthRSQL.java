/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOMdmSvcScpAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 박형국
*@LastVersion : 1.0
* 2010.05.12 박형국
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOMdmSvcScpAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 작성권한 정보를 조회한다.
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOMdmSvcScpAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOMdmSvcScpAuthRSQL").append("\n"); 
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
		query.append("SELECT COUNT(SVC_SCP_CD) " ).append("\n"); 
		query.append("  FROM PRI_SVC_SCP_TRF" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD 	IN (" ).append("\n"); 
		query.append("		SELECT SVC_SCP_CD " ).append("\n"); 
		query.append("		  FROM PRI_AUTHORIZATION" ).append("\n"); 
		query.append("		 WHERE PRC_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("		   AND USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("		   AND EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("		   AND EXP_DT >= SYSDATE  )" ).append("\n"); 

	}
}