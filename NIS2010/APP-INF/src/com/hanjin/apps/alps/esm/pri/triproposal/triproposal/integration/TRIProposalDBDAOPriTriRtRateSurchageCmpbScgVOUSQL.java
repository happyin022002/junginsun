/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtRateSurchageCmpbScgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtRateSurchageCmpbScgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtRateSurchageCmpbScgVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtRateSurchageCmpbScgVOUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRI_RT RT" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT SUM(ADJ_SCG_USD_AMT)  AS ADJ_SCG_AMT" ).append("\n"); 
		query.append(",TRI_PROP_NO ,AMDT_SEQ" ).append("\n"); 
		query.append("FROM PRI_TRI_RT_SCG" ).append("\n"); 
		query.append("WHERE   TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("GROUP BY TRI_PROP_NO ,AMDT_SEQ" ).append("\n"); 
		query.append(") SCG" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("RT.TRI_PROP_NO               = SCG.TRI_PROP_NO" ).append("\n"); 
		query.append("AND RT.AMDT_SEQ          = SCG.AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("RT.PRS_SCG_AMT        =  SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append(", RT.PRS_RESPB_CMPB_AMT =  SCG.ADJ_SCG_AMT + RT.PROP_FRT_RT_AMT - RT.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append(", RT.PRS_PFIT_CMPB_AMT  =  SCG.ADJ_SCG_AMT + RT.PROP_FRT_RT_AMT - RT.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append(", RT.PRS_RESPB_OPB_AMT  =  SCG.ADJ_SCG_AMT + RT.PROP_FRT_RT_AMT - RT.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append(", RT.UPD_USR_ID            =  @[upd_usr_id]" ).append("\n"); 
		query.append(", RT.UPD_DT                =  SYSDATE" ).append("\n"); 

	}
}