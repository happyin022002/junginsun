/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DemDet3rdDBDAOSearchDEMDET3RDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.03.22 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDet3rdDBDAOSearchDEMDET3RDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _DMDT_N3RD_PTY, _COST_SRC_ACCT, _STND_ACCT, COM_INTG_CD_DTL  테이블의 데이터 조회   
	  * </pre>
	  */
	public DemDet3rdDBDAOSearchDEMDET3RDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration").append("\n"); 
		query.append("FileName : DemDet3rdDBDAOSearchDEMDET3RDListRSQL").append("\n"); 
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
		query.append("SELECT	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, A.STND_COST_CD" ).append("\n"); 
		query.append("		, C.STND_COST_NM" ).append("\n"); 
		query.append("		, DECODE(A.COST_ASS_BSE_CD, 'F', A.UC_AMT, decode(NVL(A.BKG_VOL_QTY,0),0,0,NVL(A.TTL_DMDT_AMT,0)/NVL(A.BKG_VOL_QTY,0))) UC_AMT" ).append("\n"); 
		query.append("		, A.TTL_DMDT_AMT" ).append("\n"); 
		query.append("		, A.BKG_VOL_QTY" ).append("\n"); 
		query.append("		, A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("FROM 	COA_DMDT_N3RD_PTY A," ).append("\n"); 
		query.append("		COA_STND_ACCT C" ).append("\n"); 
		query.append("WHERE	A.COST_YRMON  = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND		A.STND_COST_CD = C.STND_COST_CD" ).append("\n"); 
		query.append("AND 	A.STND_COST_CD != '75000000'" ).append("\n"); 
		query.append("ORDER	BY CNTR_TPSZ_CD, C.STND_COST_NM" ).append("\n"); 

	}
}