/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailInvoiceInquiryCorrectionDBDAOSearchRailInvoiceInquiryCorrectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceInquiryCorrectionDBDAOSearchRailInvoiceInquiryCorrectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRailInvoiceInquiryCorrectionList
	  * </pre>
	  */
	public RailInvoiceInquiryCorrectionDBDAOSearchRailInvoiceInquiryCorrectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("statusCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comboSvcProvider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ivcCreUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invCreOfc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : RailInvoiceInquiryCorrectionDBDAOSearchRailInvoiceInquiryCorrectionListRSQL").append("\n"); 
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
		query.append("       A.TRSP_INV_AUD_STS_CD ," ).append("\n"); 
		query.append("       (SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD) FROM DUAL ) TRSP_INV_AUD_STS_NM ," ).append("\n"); 
		query.append("       DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') INV_HLD_FLG ," ).append("\n"); 
		query.append("       A.INV_NO ," ).append("\n"); 
		query.append("       A.INV_VNDR_SEQ ," ).append("\n"); 
		query.append("       B.VNDR_LGL_ENG_NM INV_VNDR_NM ," ).append("\n"); 
		query.append("       NVL(C.CURR_CD, A.INV_CURR_CD) CURR_CD ," ).append("\n"); 
		query.append("       SUM(NVL(C.FUEL_SCG_AMT,0)) FUEL_SCG_AMT ," ).append("\n"); 
		query.append("       SUM(NVL(C.BZC_AMT,0)+NVL(C.FUEL_SCG_AMT,0)+NVL(C.OVR_WGT_SCG_AMT,0)+NVL(C.HZD_MTRL_SCG_AMT,0)+NVL(C.ETC_ADD_AMT,0)) WO_TOT_AMT ," ).append("\n"); 
		query.append("       A.INV_CURR_CD ," ).append("\n"); 
		query.append("       A.INV_BZC_AMT ," ).append("\n"); 
		query.append("       A.INV_TTL_AMT ," ).append("\n"); 
		query.append("       TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT ," ).append("\n"); 
		query.append("       TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT ," ).append("\n"); 
		query.append("       TO_CHAR(A.PAY_DT, 'YYYYMMDD') PAY_DT ," ).append("\n"); 
		query.append("       A.GL_DT GL_DT ," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'YYYYMMDD') UPD_DT ," ).append("\n"); 
		query.append("       A.CSR_NO ," ).append("\n"); 
		query.append("       A.INV_PAY_MZD_CD ," ).append("\n"); 
		query.append("       A.INV_CHK_TRNS_NO ," ).append("\n"); 
		query.append("       '' INV_REMARK ," ).append("\n"); 
		query.append("       A.CRE_OFC_CD ," ).append("\n"); 
		query.append("       A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("       TRS_TRSP_RAIL_INV_WRK A ," ).append("\n"); 
		query.append("       MDM_VENDOR B ," ).append("\n"); 
		query.append("       TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("WHERE  A.INV_VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.INV_NO = C.INV_NO(+)" ).append("\n"); 
		query.append("AND    A.INV_VNDR_SEQ = C.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${fmdate} != '' )" ).append("\n"); 
		query.append("		#if(${dateCd} == 'IS')" ).append("\n"); 
		query.append("			AND A.INV_ISS_DT BETWEEN TO_DATE(@[fmdate],'YYYYMMDD') AND TO_DATE(@[todate],'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("		#elseif(${dateCd} == 'PD')" ).append("\n"); 
		query.append("			AND A.PAY_DT     BETWEEN TO_DATE(@[fmdate],'YYYYMMDD') AND TO_DATE(@[todate],'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("		#elseif(${dateCd} == 'GL')" ).append("\n"); 
		query.append("			AND A.GL_DT      BETWEEN TO_DATE(@[fmdate],'YYYYMMDD') AND TO_DATE(@[todate],'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("		#elseif(${dateCd} == 'SU')" ).append("\n"); 
		query.append("			AND A.LOCL_UPD_DT	BETWEEN TO_DATE(@[fmdate],'YYYYMMDD') AND TO_DATE(@[todate],'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND A.INV_RCV_DT BETWEEN TO_DATE(@[fmdate],'YYYYMMDD') AND TO_DATE(@[todate],'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${statusCd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.TRSP_INV_AUD_STS_CD = @[statusCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${holdCd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.INV_HLD_FLG         = @[holdCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${comboSvcProvider} != '')" ).append("\n"); 
		query.append("	#if(${spTp} == 'wo')" ).append("\n"); 
		query.append("		AND C.VNDR_SEQ     = @[comboSvcProvider]" ).append("\n"); 
		query.append("	#elseif(${spTp} == 'py')" ).append("\n"); 
		query.append("		AND A.INV_VNDR_SEQ = @[comboSvcProvider]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($noCd.size() > 0)" ).append("\n"); 
		query.append("	#if(${noTp} == 'iv')" ).append("\n"); 
		query.append("		AND A.INV_NO IN (" ).append("\n"); 
		query.append("			#foreach($key IN ${noCd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)						" ).append("\n"); 
		query.append("					'$key'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					, '$key'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		AND A.CSR_NO IN (" ).append("\n"); 
		query.append("			#foreach($key IN ${noCd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)						" ).append("\n"); 
		query.append("					'$key'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					, '$key'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${invCreOfc} != '')" ).append("\n"); 
		query.append("	AND A.CRE_OFC_CD = @[invCreOfc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ivcCreUsrId} != '')" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = @[ivcCreUsrId]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        A.TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("        DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') ," ).append("\n"); 
		query.append("        A.INV_NO ," ).append("\n"); 
		query.append("        A.INV_VNDR_SEQ ," ).append("\n"); 
		query.append("        B.VNDR_LGL_ENG_NM ," ).append("\n"); 
		query.append("        NVL(C.CURR_CD, A.INV_CURR_CD) ," ).append("\n"); 
		query.append("        A.INV_CURR_CD ," ).append("\n"); 
		query.append("        A.INV_BZC_AMT ," ).append("\n"); 
		query.append("        A.INV_TTL_AMT ," ).append("\n"); 
		query.append("        TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') ," ).append("\n"); 
		query.append("        TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') ," ).append("\n"); 
		query.append("        TO_CHAR(A.PAY_DT, 'YYYYMMDD') ," ).append("\n"); 
		query.append("        A.GL_DT ," ).append("\n"); 
		query.append("        TO_CHAR(A.UPD_DT, 'YYYYMMDD') ," ).append("\n"); 
		query.append("        A.CSR_NO ," ).append("\n"); 
		query.append("        A.INV_PAY_MZD_CD ," ).append("\n"); 
		query.append("        A.INV_CHK_TRNS_NO ," ).append("\n"); 
		query.append("        A.CRE_OFC_CD ," ).append("\n"); 
		query.append("        A.CRE_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${amountVerifyCd} == 'T')" ).append("\n"); 
		query.append("	HAVING" ).append("\n"); 
		query.append("		NVL(SUM(BZC_AMT+FUEL_SCG_AMT+NEGO_AMT+OVR_WGT_SCG_AMT),0) = SUM(INV_TTL_AMT)" ).append("\n"); 
		query.append("#elseif(${amountVerifyCd} == 'F')" ).append("\n"); 
		query.append("	HAVING" ).append("\n"); 
		query.append("		NVL(SUM(BZC_AMT+FUEL_SCG_AMT+NEGO_AMT+OVR_WGT_SCG_AMT),0) <> SUM(INV_TTL_AMT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}