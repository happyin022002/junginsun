/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpMnCpHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.04 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpMnCpHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s/c copy 의 Boiler plate, Affilate 의 record 건수
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpMnCpHdrVORSQL(){
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
		query.append("SELECT (" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM  PRI_SP_AFIL" ).append("\n"); 
		query.append("WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") AFIL_CNT" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM  PRI_SP_BLPL" ).append("\n"); 
		query.append("WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") BLPL_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpMnCpHdrVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}