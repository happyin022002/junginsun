/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAOSearchPreDispatchSentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreDispatchSentHistoryDBDAOSearchPreDispatchSentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPreDispatchSentHistory
	  * </pre>
	  */
	public PreDispatchSentHistoryDBDAOSearchPreDispatchSentHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.integration").append("\n"); 
		query.append("FileName : PreDispatchSentHistoryDBDAOSearchPreDispatchSentHistoryRSQL").append("\n"); 
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
		query.append("SELECT /*+ LEADING(B) USE_NL(B E A) */" ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     ,A.TRSP_SO_SEQ       " ).append("\n"); 
		query.append("     ,B.TRSP_DIS_REF_NO   " ).append("\n"); 
		query.append("     ,A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("     ,A.TRSP_WO_SEQ             " ).append("\n"); 
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
		query.append("AND   A.CRE_OFC_CD      = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("#if ( ${hid_frmdate} != '' && ${hid_todate} != '' )" ).append("\n"); 
		query.append("    #if ( ${rad_wonotic} == 'W' )" ).append("\n"); 
		query.append("        AND E.LOCL_CRE_DT BETWEEN TO_DATE(${hid_frmdate}, 'YYYYMMDD') AND TO_DATE(${hid_todate}, 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("    #elseif ( ${rad_wonotic} == 'L' )" ).append("\n"); 
		query.append("        AND B.DLY_DIS_SNT_DT BETWEEN TO_DATE(${hid_frmdate}, 'YYYYMMDD') AND TO_DATE(${hid_todate}, 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("    #elseif ( ${rad_wonotic} == 'N' )" ).append("\n"); 
		query.append("        AND C.CRE_DT BETWEEN TO_DATE(${hid_frmdate}, 'YYYYMMDD') AND TO_DATE(${hid_todate}, 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        AND C.CNTR_AVAL_NTC_UPD_FLG IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("    AND (A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ) in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_wo_no}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_wo_no.size()) " ).append("\n"); 
		query.append("		    (SUBSTR('$key',1,3),SUBSTR('$key',4))," ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("		    (SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO IN (" ).append("\n"); 
		query.append("    #foreach(${bkg_no} IN ${arr_bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("	        '${bkg_no}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       ,'${bkg_no}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_bill_no.size() > 0)" ).append("\n"); 
		query.append("AND A.BL_NO IN (" ).append("\n"); 
		query.append("    #foreach(${bill_no} IN ${arr_bill_no})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("	        '${bill_no}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       ,'${bill_no}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("AND A.EQ_NO IN (" ).append("\n"); 
		query.append("    #foreach(${cntr_no} IN ${arr_cntr_no})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("	        '${cntr_no}'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       ,'${cntr_no}'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${reference_no} != '' )" ).append("\n"); 
		query.append("AND B.TRSP_DIS_REF_NO = '${reference_no}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${wo_iss_ofc_cd} != '' )" ).append("\n"); 
		query.append("AND E.CRE_OFC_CD = '${wo_iss_ofc_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${combo_svc_provider} != '' )" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = ${combo_svc_provider}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.TRSP_DIS_REF_NO, C.TRSP_DIS_ISS_SEQ" ).append("\n"); 

	}
}