/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddTermChangeDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddTermChangeDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddTermChangeData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddTermChangeDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddTermChangeDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_TERM_CNG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     TERM_CNG_SEQ" ).append("\n"); 
		query.append("    ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,AGMT_FM_DT" ).append("\n"); 
		query.append("    ,AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,AGMT_SEQ" ).append("\n"); 
		query.append("    ,FM_AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,FM_AGMT_SEQ" ).append("\n"); 
		query.append("    ,CNTR_QTY" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" TERM_CNG_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYYMMDD') 			 AS AGMT_FM_DT" ).append("\n"); 
		query.append(",@[aft_agmt_cty_cd]  AS AGMT_CTY_CD" ).append("\n"); 
		query.append(",@[aft_agmt_seq]     AS AGMT_SEQ    " ).append("\n"); 
		query.append(",@[cur_agmt_cty_cd]  AS FM_AGMT_CTY_CD" ).append("\n"); 
		query.append(",@[cur_agmt_seq]     AS FM_AGMT_SEQ" ).append("\n"); 
		query.append(",COUNT(TERM_CNG_SEQ) AS CNTR_QTY" ).append("\n"); 
		query.append(",@[cre_usr_id]		 AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE			 AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]		 AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE			 AS UPD_DT" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${seq_set} != '') " ).append("\n"); 
		query.append("AND A.TERM_CNG_SEQ IN (" ).append("\n"); 
		query.append("		#foreach($seqset in ${vel_seq_set})  " ).append("\n"); 
		query.append("			'$seqset',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.TERM_CNG_SEQ, A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}