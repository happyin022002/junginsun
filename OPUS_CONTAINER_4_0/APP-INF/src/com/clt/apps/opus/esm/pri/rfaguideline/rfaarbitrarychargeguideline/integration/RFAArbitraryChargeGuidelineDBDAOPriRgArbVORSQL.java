/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAArbitraryChargeGuidelineDBDAOPriRgArbVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.16 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAArbitraryChargeGuidelineDBDAOPriRgArbVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * guideline 조회
	  * </pre>
	  */
	public RFAArbitraryChargeGuidelineDBDAOPriRgArbVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration").append("\n"); 
		query.append("FileName : RFAArbitraryChargeGuidelineDBDAOPriRgArbVORSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX(a XPKPRI_RG_ARB) */" ).append("\n"); 
		query.append("A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.GLINE_SEQ" ).append("\n"); 
		query.append(",A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",A.ARB_SEQ" ).append("\n"); 
		query.append(",B.LOC_NM AS LOC_DES" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append(",A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",A.MIN_CGO_WGT" ).append("\n"); 
		query.append(",A.MAX_CGO_WGT" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.FRT_RT_AMT" ).append("\n"); 
		query.append(",C.INTG_CD_VAL_DP_SEQ TERM_ORD" ).append("\n"); 
		query.append(",D.INTG_CD_VAL_DP_SEQ TRANS_ORD" ).append("\n"); 
		query.append("FROM    PRI_RG_ARB A" ).append("\n"); 
		query.append(",MDM_LOCATION B" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL C" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE	A.SVC_SCP_CD          = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND		A.GLINE_SEQ           = @[gline_seq]" ).append("\n"); 
		query.append("AND		A.ORG_DEST_TP_CD      = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND    	A.ROUT_PNT_LOC_DEF_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND     A.RCV_DE_TERM_CD = C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND     DECODE(A.ORG_DEST_TP_CD,'D','CD02071','CD02070') = C.INTG_CD_ID" ).append("\n"); 
		query.append("AND     A.PRC_TRSP_MOD_CD = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND     D.INTG_CD_ID(+) ='CD01720'" ).append("\n"); 
		query.append("ORDER BY A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(",TRANS_ORD NULLS FIRST" ).append("\n"); 
		query.append(",TERM_ORD" ).append("\n"); 
		query.append(",A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 

	}
}