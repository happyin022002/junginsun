/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceProviderManageDBDAOSearchMdmVendorIndiaInfoRSQL.java
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

public class ServiceProviderManageDBDAOSearchMdmVendorIndiaInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmVendorIndiaInfo
	  * </pre>
	  */
	public ServiceProviderManageDBDAOSearchMdmVendorIndiaInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderManageDBDAOSearchMdmVendorIndiaInfoRSQL").append("\n"); 
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
		query.append("     MV.VNDR_SEQ IDA_VNDR_SEQ" ).append("\n"); 
		query.append("    ,MV.VNDR_LGL_ENG_NM IDA_VNDR_NM" ).append("\n"); 
		query.append("    , (SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_CD" ).append("\n"); 
		query.append("    , (SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_NM" ).append("\n"); 
		query.append("    ,IDA_PAN_NO" ).append("\n"); 
		query.append("    ,IDA_GST_RGST_NO" ).append("\n"); 
		query.append("    ,IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append("    ,IDA_CNTC_PSON_NM" ).append("\n"); 
		query.append("    ,IDA_ALTN_RCVR_NM" ).append("\n"); 
		query.append("    ,IDA_VNDR_EML " ).append("\n"); 
		query.append("	,IDA_SPCL_ECN_ZN_DOC_NO" ).append("\n"); 
		query.append("	,IDA_SPCL_ECN_ZN_DOC_DESC" ).append("\n"); 
		query.append("	,IDA_CO_TYPE_CD" ).append("\n"); 
		query.append("	,IDA_GST_RGST_STS_CD" ).append("\n"); 
		query.append("	,IDA_GST_RGST_TP_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV         " ).append("\n"); 
		query.append("    , MDM_LOCATION ML" ).append("\n"); 
		query.append("    ,(   SELECT  X.VNDR_SEQ, " ).append("\n"); 
		query.append("                MAX(VNDR_EML) IDA_VNDR_EML" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("        	SELECT A.VNDR_SEQ," ).append("\n"); 
		query.append("               	    DECODE(CNTC_DIV_CD,'IDA',VNDR_EML,'') VNDR_EML" ).append("\n"); 
		query.append("        	FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("        	WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("            AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("        GROUP BY X.VNDR_SEQ " ).append("\n"); 
		query.append("    ) CP" ).append("\n"); 
		query.append("WHERE MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = CP.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND	MV.DELT_FLG = 'N'" ).append("\n"); 

	}
}