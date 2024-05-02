/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAOSearch01PreDispatchSentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.11.01 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreDispatchSentHistoryDBDAOSearch01PreDispatchSentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search01PreDispatchSentHistory
	  * </pre>
	  */
	public PreDispatchSentHistoryDBDAOSearch01PreDispatchSentHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_dis_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration").append("\n"); 
		query.append("FileName : PreDispatchSentHistoryDBDAOSearch01PreDispatchSentHistoryRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     ,A.TRSP_SO_SEQ       " ).append("\n"); 
		query.append("     ,B.TRSP_DIS_REF_NO   " ).append("\n"); 
		query.append("     ,A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("     ,A.TRSP_WO_SEQ       " ).append("\n"); 
		query.append("     ,A.VNDR_SEQ VNDR_SEQ " ).append("\n"); 
		query.append("     ,D.VNDR_ABBR_NM      " ).append("\n"); 
		query.append("     ,TO_CHAR(C.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') SNT_DT" ).append("\n"); 
		query.append("     ,C.TRSP_DIS_ISS_SEQ" ).append("\n"); 
		query.append("     ,C.DIS_N1ST_FAX_NO " ).append("\n"); 
		query.append("     ,C.DIS_N2ND_FAX_NO " ).append("\n"); 
		query.append("     ,C.DIS_N3RD_FAX_NO " ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959', FAX1.FAX_PROC_STS_CD) DIS_N1ST_FAX_RSLT_FLG" ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959', FAX2.FAX_PROC_STS_CD) DIS_N2ND_FAX_RSLT_FLG" ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959', FAX3.FAX_PROC_STS_CD) DIS_N3RD_FAX_RSLT_FLG" ).append("\n"); 
		query.append("     ,C.DIS_N1ST_EML" ).append("\n"); 
		query.append("     ,C.DIS_N2ND_EML" ).append("\n"); 
		query.append("     ,C.DIS_N3RD_EML" ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960', EML1.EML_PROC_STS_CD) DIS_N1ST_EML_RSLT_FLG" ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960', EML2.EML_PROC_STS_CD) DIS_N2ND_EML_RSLT_FLG" ).append("\n"); 
		query.append("     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960', EML3.EML_PROC_STS_CD) DIS_N3RD_EML_RSLT_FLG" ).append("\n"); 
		query.append("     ,TO_CHAR(B.DLY_DIS_SNT_DT, 'YYYY-MM-DD HH24:MI:SS') DLY_DIS_SNT_DT" ).append("\n"); 
		query.append("     ,DECODE(C.CNTR_AVAL_NTC_UPD_FLG ,'Y', TO_CHAR(C.CRE_DT, 'YYYY-MM-DD HH24:MI:SS')) TRSP_CNTR_AVAL_SNT_DT" ).append("\n"); 
		query.append("FROM  TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("    , TRS_TRSP_DIS_MST B" ).append("\n"); 
		query.append("    , TRS_TRSP_DIS_HIS C" ).append("\n"); 
		query.append("    , MDM_VENDOR D" ).append("\n"); 
		query.append("    , TRS_TRSP_WRK_ORD E" ).append("\n"); 
		query.append("    , COM_FAX_SND_INFO FAX1" ).append("\n"); 
		query.append("    , COM_FAX_SND_INFO FAX2" ).append("\n"); 
		query.append("    , COM_FAX_SND_INFO FAX3" ).append("\n"); 
		query.append("    , COM_EML_SND_INFO EML1" ).append("\n"); 
		query.append("    , COM_EML_SND_INFO EML2" ).append("\n"); 
		query.append("    , COM_EML_SND_INFO EML3" ).append("\n"); 
		query.append("    , MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD  = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ         = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   A.TRSP_WO_OFC_CTY_CD  = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.TRSP_WO_SEQ         = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_SO_OFC_CTY_CD  = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   B.TRSP_SO_SEQ         = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_WO_OFC_CTY_CD  = C.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   B.TRSP_WO_SEQ         = C.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_DIS_REF_NO     = C.TRSP_DIS_REF_NO" ).append("\n"); 
		query.append("AND   A.TRSP_WO_OFC_CTY_CD  = E.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.TRSP_WO_SEQ         = E.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND   C.DIS_N1ST_FAX_SND_NO = FAX1.FAX_SND_NO(+)" ).append("\n"); 
		query.append("AND   C.DIS_N2ND_FAX_SND_NO = FAX2.FAX_SND_NO(+)" ).append("\n"); 
		query.append("AND   C.DIS_N3RD_FAX_SND_NO = FAX3.FAX_SND_NO(+)" ).append("\n"); 
		query.append("AND   C.DIS_N1ST_EML_SND_NO = EML1.EML_SND_NO(+)" ).append("\n"); 
		query.append("AND   C.DIS_N2ND_EML_SND_NO = EML2.EML_SND_NO(+)" ).append("\n"); 
		query.append("AND   C.DIS_N3RD_EML_SND_NO = EML3.EML_SND_NO(+)" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_WO_CXL_FLG IS NULL" ).append("\n"); 
		query.append("AND   A.TRSP_CRR_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD  = 'I'" ).append("\n"); 
		query.append("AND   A.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("AND   LOC.LOC_CD   = SUBSTR(A.FM_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("AND   LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("AND   LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ        = @[trsp_so_seq] " ).append("\n"); 
		query.append("AND   A.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd] " ).append("\n"); 
		query.append("AND   A.TRSP_WO_SEQ        = @[trsp_wo_seq] " ).append("\n"); 
		query.append("AND   B.TRSP_DIS_REF_NO    = @[trsp_dis_ref_no] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.TRSP_DIS_ISS_SEQ" ).append("\n"); 

	}
}