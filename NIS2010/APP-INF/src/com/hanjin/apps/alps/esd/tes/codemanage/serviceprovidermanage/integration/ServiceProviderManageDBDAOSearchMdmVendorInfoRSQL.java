/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceProviderManageDBDAOSearchMdmVendorInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderManageDBDAOSearchMdmVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmVendorInfo
	  * </pre>
	  */
	public ServiceProviderManageDBDAOSearchMdmVendorInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderManageDBDAOSearchMdmVendorInfoRSQL").append("\n"); 
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
		query.append("SELECT  MV.VNDR_SEQ " ).append("\n"); 
		query.append("        ,MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		, (SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_CD" ).append("\n"); 
		query.append("		, (SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_NM" ).append("\n"); 
		query.append("        ,MV.VNDR_CNT_CD" ).append("\n"); 
		query.append("		,MV.ZIP_CD" ).append("\n"); 
		query.append("        ,MV.ENG_ADDR" ).append("\n"); 
		query.append("        ,MV.LOC_CD" ).append("\n"); 
		query.append("        ,MV.OFC_CD" ).append("\n"); 
		query.append("        ,CP.PHN_NO" ).append("\n"); 
		query.append("        ,CP.FAX_NO" ).append("\n"); 
		query.append("        ,CP.VNDR_EML" ).append("\n"); 
		query.append("        ,MV.VNDR_ABBR_NM" ).append("\n"); 
		query.append("        ,MV.RGST_NO " ).append("\n"); 
		query.append("        ,MV.CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,DECODE(MV.PAY_TERM_TP_CD,'I','Invoice Issued','R','Invoice Received') PAY_TERM_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(MV.GEN_PAY_TERM_CD,'0','Immediate Payment','D+'||MV.GEN_PAY_TERM_CD||' Payment') GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV," ).append("\n"); 
		query.append("    (   SELECT  X.VNDR_SEQ, " ).append("\n"); 
		query.append("                MAX(PHN_NO) PHN_NO, " ).append("\n"); 
		query.append("                MAX(FAX_NO) FAX_NO, " ).append("\n"); 
		query.append("                MAX(VNDR_EML) VNDR_EML" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        	SELECT A.VNDR_SEQ, " ).append("\n"); 
		query.append("               		DECODE(CNTC_DIV_CD,'PHN',B.PHN_NO,'') PHN_NO," ).append("\n"); 
		query.append("              		DECODE(CNTC_DIV_CD,'FAX',B.FAX_NO,'') FAX_NO," ).append("\n"); 
		query.append("               		DECODE(CNTC_DIV_CD,'EMAIL',VNDR_EML,'') VNDR_EML" ).append("\n"); 
		query.append("        	FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("        	WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("			#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("			AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("        GROUP BY X.VNDR_SEQ " ).append("\n"); 
		query.append("    ) CP, MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE MV.VNDR_SEQ = CP.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_CNT_CD = 'IN'" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("AND (SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) = @[ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	  MV.DELT_FLG = 'N'" ).append("\n"); 

	}
}