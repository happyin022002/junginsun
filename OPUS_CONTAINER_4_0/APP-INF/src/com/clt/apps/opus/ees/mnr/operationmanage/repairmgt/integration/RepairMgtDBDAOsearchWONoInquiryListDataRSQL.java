/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOsearchWONoInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchWONoInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWONoInquiryListData select
	  * </pre>
	  */
	public RepairMgtDBDAOsearchWONoInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wotype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("currofccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqtype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchWONoInquiryListDataRSQL").append("\n"); 
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
		query.append("A.MNR_WO_TP_CD AS MNR_GRP_TP_CD" ).append("\n"); 
		query.append("#if (${currofccd} != '')" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.MNR_ORD_SND_DT, @[currofccd])  AS SendDt" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",   A.MNR_ORD_SND_DT  AS SendDt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",  CONCAT(A.MNR_ORD_OFC_CTY_CD, A.MNR_ORD_SEQ) AS WONo" ).append("\n"); 
		query.append(", (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ AND ROWNUM=1) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",  MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AS AGMT_SEQ" ).append("\n"); 
		query.append(",  (SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID= 'CD00016' AND MNR_CD_ID=A.TRSM_MOD_CD AND ROWNUM=1) AS TRSM_MOD_NM" ).append("\n"); 
		query.append(",  GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT,@[currofccd]) AS CRE_DT" ).append("\n"); 
		query.append(",  A.MNR_WRK_AMT" ).append("\n"); 
		query.append(",  MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(",  A.EQ_KND_CD" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if (${wotype} != '%')" ).append("\n"); 
		query.append("AND RTRIM(A.MNR_WO_TP_CD) = @[wotype]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eqtype} != '%')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD =  @[eqtype]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[currofccd],TO_DATE(@[fromcal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[currofccd],TO_DATE(@[tocal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#if (${currofccd} != '')" ).append("\n"); 
		query.append("AND RTRIM(A.COST_OFC_CD) = @[currofccd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}