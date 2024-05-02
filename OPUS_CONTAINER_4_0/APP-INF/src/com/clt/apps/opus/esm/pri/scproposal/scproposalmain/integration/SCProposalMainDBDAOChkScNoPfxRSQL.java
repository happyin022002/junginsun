/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOChkScNoPfxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.06 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOChkScNoPfxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Number 의 Prefix의 정합성을 체크한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOChkScNoPfxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOChkScNoPfxRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT PF.SC_PFX_CD" ).append("\n"); 
		query.append("FROM PRI_SC_PFX PF" ).append("\n"); 
		query.append(", PRI_SC_PFX_MAPG MP" ).append("\n"); 
		query.append("WHERE PF.SC_PFX_CD = SUBSTR(@[sc_no], 1, 3)" ).append("\n"); 
		query.append("AND   PF.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   MP.SC_PFX_CD = PF.SC_PFX_CD" ).append("\n"); 
		query.append("AND   MP.SVC_SCP_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${txtArr})" ).append("\n"); 
		query.append("#if($velocityCount < $txtArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}