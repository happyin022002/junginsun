/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TAAProposalDBDAOCheckOfcSrepDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.22
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2011.08.22 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOCheckOfcSrepDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Confirm 이후 Sales Rep 정보의 변경 유무 체크
	  * * 2011.08.17 송호진 [CHM-201112868-01] 최초 생성 - SCProposalMainDBDAOChkOfcSrepDiffRSQL 참조
	  * </pre>
	  */
	public TAAProposalDBDAOCheckOfcSrepDiffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("respb_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOCheckOfcSrepDiffRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(1) AS CNT" ).append("\n"); 
		query.append("  FROM  PRI_TAA_MN" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  CFM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND  TAA_PROP_NO  = @[taa_prop_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  RESPB_SREP_CD <> @[respb_srep_cd]" ).append("\n"); 

	}
}