/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOMdmSvbcScpCdVORSQL.java
*@FileTitle : TRI Creation &amp; Amendment - Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.30 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOMdmSvbcScpCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SVC_SCP_CD 조회
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOMdmSvbcScpCdVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOMdmSvbcScpCdVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD CD" ).append("\n"); 
		query.append(", SVC_SCP_NM NM" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD" ).append("\n"); 

	}
}