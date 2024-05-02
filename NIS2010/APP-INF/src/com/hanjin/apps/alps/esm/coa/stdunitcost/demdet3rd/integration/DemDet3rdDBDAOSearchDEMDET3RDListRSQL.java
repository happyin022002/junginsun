/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemDet3rdDBDAOSearchDEMDET3RDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2011.10.12   [CHM-201113735-01]
	  * 기존 vol.incentive standard cost code에 물리는 source code 계정이 늘어남에 따라 기존에 사용했던 standard code와 동일한 계정만 화면에 보여주기 위하여 조건 추가
	  * AND     A.STND_COST_CD = B.COA_COST_SRC_CD
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.demdet3rd.integration").append("\n"); 
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
		query.append("SELECT  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,A.STND_COST_CD" ).append("\n"); 
		query.append("       ,C.STND_COST_NM" ).append("\n"); 
		query.append("       ,B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("       ,B.COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append("       ,DECODE(A.COST_ASS_BSE_CD, 'F', A.UC_AMT, NVL(A.TTL_DMDT_AMT,0)/NVL(A.BKG_VOL_QTY,0)) UC_AMT" ).append("\n"); 
		query.append("       ,A.TTL_DMDT_AMT" ).append("\n"); 
		query.append("       ,A.BKG_VOL_QTY" ).append("\n"); 
		query.append("       ,A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("       ,D.INTG_CD_VAL_DP_DESC COST_ASS_BSE_NM" ).append("\n"); 
		query.append("FROM  COA_DMDT_N3RD_PTY A" ).append("\n"); 
		query.append("     ,COA_COST_SRC_ACCT B" ).append("\n"); 
		query.append("     ,COA_STND_ACCT C" ).append("\n"); 
		query.append("     ,COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE A.COST_YRMON  = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND   D.INTG_CD_ID  = 'CD00201'" ).append("\n"); 
		query.append("AND   A.STND_COST_CD = C.STND_COST_CD" ).append("\n"); 
		query.append("AND   A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("AND   A.STND_COST_CD = B.COA_COST_SRC_CD --201110월 이전만 사용 (STND CD와 동일한 SRC CD만 사용하였음)" ).append("\n"); 
		query.append("AND   A.COST_ASS_BSE_CD = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD, C.STND_COST_NM, B.COA_COST_SRC_CD_NM" ).append("\n"); 

	}
}