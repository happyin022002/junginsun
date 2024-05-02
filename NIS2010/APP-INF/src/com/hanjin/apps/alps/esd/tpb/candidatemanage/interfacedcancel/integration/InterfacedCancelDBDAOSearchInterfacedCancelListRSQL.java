/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfacedCancelDBDAOSearchInterfacedCancelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfacedCancelDBDAOSearchInterfacedCancelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InterfacedCancelDBDAOSearchInterfacedCancelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.integration").append("\n"); 
		query.append("FileName : InterfacedCancelDBDAOSearchInterfacedCancelListRSQL").append("\n"); 
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
		query.append("SELECT NVL(D.OFC_CD,C.IF_OFC_CD) OFC_CD" ).append("\n"); 
		query.append(",C.SO_NO" ).append("\n"); 
		query.append(",TPB_GET_USD_AMT_FNC(C.IF_AMT,C.IF_CURR_CD,TPB_GET_LCL_DATE_FNC(C.CRE_DT,C.OFC_CD)) IF_AMT_USD" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(D.CRE_DT,D.OFC_CD),'YYYY-MM-DD HH24:MI') ORG_IF_DT" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(C.CRE_DT,C.OFC_CD),'YYYY-MM-DD HH24:MI') CXL_IF_DT" ).append("\n"); 
		query.append(",NVL((SELECT INTG_CD_VAL_DP_DESC FROM TPB_OTS_GRP_STS, COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00588' AND OTS_STS_CD = INTG_CD_VAL_CTNT AND N3PTY_NO = D.N3PTY_NO AND OTS_STS_LST_FLG ='Y')" ).append("\n"); 
		query.append(",CASE WHEN C.SO_NO = D.SO_NO AND C.IF_OFC_CD = D.IF_OFC_CD AND C.SRC_IF_SEQ_NO = D.SRC_IF_SEQ_NO AND C.IF_AMT = D.IF_AMT" ).append("\n"); 
		query.append("THEN 'CANDIDATE' ELSE 'HAVE NEVER INTERFACED' END ) OTS_STS" ).append("\n"); 
		query.append(",TPB_GET_USD_AMT_FNC(D.OTS_AMT,D.CFM_CURR_CD,TPB_GET_LCL_DATE_FNC(D.CFM_DT,D.OFC_CD)) OTS_AMT_USD" ).append("\n"); 
		query.append(",TPB_GET_USD_AMT_FNC(D.INV_AMT,D.CFM_CURR_CD,TPB_GET_LCL_DATE_FNC(D.CFM_DT,D.OFC_CD)) INV_AMT_USD" ).append("\n"); 
		query.append(",CASE WHEN (SELECT COUNT(1) FROM TPB_OTS_DTL WHERE N3PTY_NO = D.N3PTY_NO) > 1 THEN 'Y' ELSE 'N' END GRP_FLG" ).append("\n"); 
		query.append(",D.OTS_DTL_SEQ ORG_SEQ" ).append("\n"); 
		query.append(",C.OTS_DTL_SEQ CXL_SEQ" ).append("\n"); 
		query.append(",D.N3PTY_NO" ).append("\n"); 
		query.append(",DECODE((SELECT OTS_STS_CD FROM TPB_OTS_GRP_STS WHERE N3PTY_NO = D.N3PTY_NO AND OTS_STS_LST_FLG ='Y')" ).append("\n"); 
		query.append(",NULL, 'Y', 'O', 'Y', 'N') EDITABLE" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL C" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT IF_OFC_CD,IF_AMT,CRE_DT,OTS_DTL_SEQ,SRC_IF_SEQ_NO" ).append("\n"); 
		query.append(",N3PTY_NO,OFC_CD,CFM_DT,CFM_CURR_CD,INV_AMT,OTS_AMT,IF_CURR_CD,SO_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("WHERE CXL_FLG IS NULL" ).append("\n"); 
		query.append("AND N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE C.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND C.CXL_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.SO_NO = D.SO_NO (+)" ).append("\n"); 
		query.append("AND C.IF_OFC_CD = D.IF_OFC_CD (+)" ).append("\n"); 
		query.append("AND C.SRC_IF_SEQ_NO = D.SRC_IF_SEQ_NO (+)" ).append("\n"); 
		query.append("AND C.IF_AMT = D.IF_AMT (+)" ).append("\n"); 
		query.append("AND NVL(D.OFC_CD,C.IF_OFC_CD) IN (" ).append("\n"); 
		query.append("SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '')" ).append("\n"); 
		query.append("AND N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY C.OTS_DTL_SEQ" ).append("\n"); 

	}
}