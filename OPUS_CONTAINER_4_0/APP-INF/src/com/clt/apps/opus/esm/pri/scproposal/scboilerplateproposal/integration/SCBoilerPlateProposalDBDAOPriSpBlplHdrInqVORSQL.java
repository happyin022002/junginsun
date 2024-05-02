/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAOPriSpBlplHdrInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
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

public class SCBoilerPlateProposalDBDAOPriSpBlplHdrInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Proposal Boiler Plate Header Inquiry
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAOPriSpBlplHdrInqVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdr_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration ").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAOPriSpBlplHdrInqVORSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",BLPL_NM" ).append("\n"); 
		query.append(",BLPL_HDR_SEQ" ).append("\n"); 
		query.append(",BLPL_REF_YR" ).append("\n"); 
		query.append(",'' HDR_EFF_DT" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL_HDR" ).append("\n"); 
		query.append("WHERE TO_DATE(@[hdr_eff_dt],'yyyy-MM-dd') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("AND CFM_FLG = 'Y'" ).append("\n"); 

	}
}