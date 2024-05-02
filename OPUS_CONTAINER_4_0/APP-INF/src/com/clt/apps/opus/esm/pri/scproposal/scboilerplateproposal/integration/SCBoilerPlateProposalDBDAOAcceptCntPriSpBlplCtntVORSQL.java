/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAOAcceptCntPriSpBlplCtntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.31 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateProposalDBDAOAcceptCntPriSpBlplCtntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Init 이 아닌 데이터를 조회한다.
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAOAcceptCntPriSpBlplCtntVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration ").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAOAcceptCntPriSpBlplCtntVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CD" ).append("\n"); 
		query.append("FROM PRI_SP_BLPL_CTNT" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   PRC_PROG_STS_CD     = 'A' " ).append("\n"); 
		query.append("AND   BLPL_SEQ IN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach($key IN ${txtArr}) " ).append("\n"); 
		query.append("#if($velocityCount < $txtArr.size()) " ).append("\n"); 
		query.append("'$key', " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("'$key' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}