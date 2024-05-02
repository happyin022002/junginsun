/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAOPriSpBlplExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.06 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateProposalDBDAOPriSpBlplExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * excel down
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAOPriSpBlplExcelVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAOPriSpBlplExcelVORSQL").append("\n"); 
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
		query.append("SELECT A.BLPL_TIT_NM" ).append("\n"); 
		query.append(",TO_CHAR(M.EFF_DT, 'YYYYMMDD')  EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(M.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append(",SRC.INTG_CD_VAL_DP_DESC SRC_INFO_DTL" ).append("\n"); 
		query.append(",STS.INTG_CD_VAL_DP_DESC PRC_PROG_STS_DTL" ).append("\n"); 
		query.append(",B.BLPL_CTNT" ).append("\n"); 
		query.append(",TO_CHAR(M.EFF_DT, 'YYYYMMDD') EFF2_DT" ).append("\n"); 
		query.append(",TO_CHAR(M.EXP_DT, 'YYYYMMDD') EXP2_DT" ).append("\n"); 
		query.append(",SRC1.INTG_CD_VAL_DP_DESC SRC_INFO_DTL1" ).append("\n"); 
		query.append(",STS1.INTG_CD_VAL_DP_DESC PRC_PROG_STS_DTL1" ).append("\n"); 
		query.append("FROM PRI_SP_BLPL A" ).append("\n"); 
		query.append(",PRI_SP_BLPL_CTNT B" ).append("\n"); 
		query.append(",PRI_SP_MN          M" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL    SRC" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL    STS" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL    SRC1" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL    STS1" ).append("\n"); 
		query.append("WHERE A.PROP_NO 		    = B.PROP_NO" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ 		    = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND   A.BLPL_SEQ 		    = B.BLPL_SEQ" ).append("\n"); 
		query.append("AND   M.PROP_NO             = A.PROP_NO" ).append("\n"); 
		query.append("AND   M.AMDT_SEQ            = @[amdt_seq]" ).append("\n"); 
		query.append("AND   SRC.INTG_CD_VAL_CTNT  = A.SRC_INFO_CD" ).append("\n"); 
		query.append("AND   SRC.INTG_CD_ID        = 'CD02064'" ).append("\n"); 
		query.append("AND   STS.INTG_CD_VAL_CTNT  = A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND   STS.INTG_CD_ID        = 'CD01719'" ).append("\n"); 
		query.append("AND   SRC1.INTG_CD_VAL_CTNT = B.SRC_INFO_CD" ).append("\n"); 
		query.append("AND   SRC1.INTG_CD_ID       = 'CD02064'" ).append("\n"); 
		query.append("AND   STS1.INTG_CD_VAL_CTNT = B.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("AND   STS1.INTG_CD_ID       = 'CD01719'" ).append("\n"); 
		query.append("AND   A.PROP_NO  			= @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ,B.BLPL_CTNT_SEQ" ).append("\n"); 

	}
}