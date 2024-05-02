/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAORsltBlplGcCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.08.03 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateProposalDBDAORsltBlplGcCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 두 테이블에서 SRC_INFO_CD가 GC가 아닌 데이터의 count와
	  * Guideline과 copy된 데이터의 갯수가 일치 하는지 조회한다.
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAORsltBlplGcCntVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAORsltBlplGcCntVORSQL").append("\n"); 
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
		query.append("SELECT  (SELECT COUNT(*)  FROM PRI_SP_BLPL WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD <> 'GC') AS BLPL_CNT" ).append("\n"); 
		query.append("       , (SELECT COUNT(*) FROM PRI_SP_BLPL_CTNT WHERE PROP_NO = @[prop_no]  AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD <> 'GC' ) AS BLPL_CTNT_CNT" ).append("\n"); 
		query.append(" 	   , (SELECT COUNT(*) FROM PRI_SP_BLPL WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD = 'GC' ) - (SELECT COUNT(*) FROM PRI_SG_BLPL WHERE  BLPL_HDR_SEQ = (SELECT BLPL_HDR_SEQ FROM PRI_SP_MN WHERE PROP_NO =  @[prop_no]  AND AMDT_SEQ = @[amdt_seq] )) AS BLPL_MNS_CNT" ).append("\n"); 
		query.append(" 	   , (SELECT COUNT(*) FROM PRI_SP_BLPL_CTNT WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD = 'GC' ) - (SELECT  COUNT(*) FROM PRI_SG_BLPL_CTNT WHERE  BLPL_HDR_SEQ = (SELECT BLPL_HDR_SEQ FROM PRI_SP_MN WHERE PROP_NO =  @[prop_no]  AND AMDT_SEQ = @[amdt_seq] )) AS BLPL_CTNT_MNS_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}