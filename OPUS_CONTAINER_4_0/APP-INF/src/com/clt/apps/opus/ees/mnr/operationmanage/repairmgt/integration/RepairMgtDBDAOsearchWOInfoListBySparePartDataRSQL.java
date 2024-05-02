/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RepairMgtDBDAOsearchWOInfoListBySparePartDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchWOInfoListBySparePartDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * work order history 조회
	  * </pre>
	  */
	public RepairMgtDBDAOsearchWOInfoListBySparePartDataRSQL(){
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
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchWOInfoListBySparePartDataRSQL").append("\n"); 
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
		query.append("SELECT  A.COST_OFC_CD AS ORD_ISS_OFC_CD" ).append("\n"); 
		query.append("	   ,A.SPR_PRT_SPL_TP_CD" ).append("\n"); 
		query.append("	   ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VSL_VVD" ).append("\n"); 
		query.append("	   ,A.SPR_PRT_SPL_YD_CD AS YD_CD" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("       ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT, @[cost_ofc_cd]),'yyyy-mm-dd') AS CRE_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   ,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,(SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID= 'CD00009' AND MNR_CD_ID=B.SPR_PRT_UT_TP_NM AND ROWNUM=1) SPR_UT_TP_NM" ).append("\n"); 
		query.append("	   ,B.SPR_PRT_NO" ).append("\n"); 
		query.append("	   ,C.SPR_PRT_NM" ).append("\n"); 
		query.append("	   ,B.RPR_QTY" ).append("\n"); 
		query.append("	   ,A.CURR_CD" ).append("\n"); 
		query.append("	   ,(A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ) AS MNR_ORD_SEQ" ).append("\n"); 
		query.append("	   ,B.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("	   ,B.SPR_PRT_UC_AMT * B.RPR_QTY AS TOTAL_AMT" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A,MNR_ORD_DTL B, MNR_RF_SPR_PRT_CD C" ).append("\n"); 
		query.append("WHERE A.MNR_ORD_OFC_CTY_CD= B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.MNR_ORD_SEQ=B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("  AND B.SPR_PRT_NO=C.SPR_PRT_NO(+)" ).append("\n"); 
		query.append("  AND A.MNR_GRP_TP_CD='RPR'" ).append("\n"); 
		query.append("  AND A.MNR_WO_TP_CD='RFS'" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.COST_OFC_CD =@[cost_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fromcal} != '' && ${tocal} != '') " ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cost_ofc_cd],TO_DATE(@[fromcal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cost_ofc_cd],TO_DATE(@[tocal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.CRE_DT BETWEEN TO_DATE(@[fromcal], 'YYYY-MM-DD') AND TO_DATE(@[tocal], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD =@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("AND A.SPR_PRT_SPL_YD_CD=@[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.SPR_PRT_SPL_TP_CD = C.SPR_PRT_SPL_TP_CD" ).append("\n"); 

	}
}