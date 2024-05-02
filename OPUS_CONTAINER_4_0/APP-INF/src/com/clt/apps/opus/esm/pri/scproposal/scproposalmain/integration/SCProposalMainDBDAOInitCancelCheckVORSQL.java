/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOInitCancelCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.20 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOInitCancelCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * init Cancel시 Dem/Det 데이터를 조회한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOInitCancelCheckVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOInitCancelCheckVORSQL").append("\n"); 
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
		query.append("SELECT   COUNT( * )  ETC1" ).append("\n"); 
		query.append("FROM     DMT_SC_EXPT_VER" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND SC_EXPT_VER_SEQ = (SELECT     /*+ INDEX_DESC(A XPKDMT_SC_EXPT_VER) */" ).append("\n"); 
		query.append("                                  SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                            FROM     DMT_SC_EXPT_VER A" ).append("\n"); 
		query.append("                            WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("     AND DMDT_EXPT_VER_STS_CD IN ('A', 'L', 'R')" ).append("\n"); 

	}
}