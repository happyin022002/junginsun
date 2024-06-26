/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtVOClosePrevExpDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.03.10 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtVOClosePrevExpDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRI_RT Publish
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtVOClosePrevExpDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtVOClosePrevExpDtUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRI_RT SET " ).append("\n"); 
		query.append("	EXP_DT = TO_DATE(@[eff_dt],'YYYY-MM-DD') - 1" ).append("\n"); 
		query.append("WHERE	TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 

	}
}