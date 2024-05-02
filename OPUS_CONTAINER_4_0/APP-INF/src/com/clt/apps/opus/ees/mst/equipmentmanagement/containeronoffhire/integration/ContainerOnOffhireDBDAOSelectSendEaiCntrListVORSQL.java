/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSelectSendEaiCntrListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSelectSendEaiCntrListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectSendEaiCntrListVO
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSelectSendEaiCntrListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_invst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_cng_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_aqz_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSelectSendEaiCntrListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    'FNS026-0001' LIFID" ).append("\n"); 
		query.append("   ,A.EAI_IF_NO SEQ" ).append("\n"); 
		query.append("   ,A.IF_TTL_ROW_KNT TOTAL_COUNT" ).append("\n"); 
		query.append("   ,A.IF_SEQ RNUM" ).append("\n"); 
		query.append("   ,'OPUS_GAAP_BOOK' BOOK_TYPE_CODE" ).append("\n"); 
		query.append("   , A.CNTR_TPSZ_CD ASSET_DESCRIPTION" ).append("\n"); 
		query.append("   ,'A' ASSET_TYPE" ).append("\n"); 
		query.append("   #if (${hid_type} == '0')" ).append("\n"); 
		query.append("   , (SELECT FA_CATE_CD " ).append("\n"); 
		query.append("      FROM MST_FA_CATE " ).append("\n"); 
		query.append("      WHERE EQ_TPSZ_CD = A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      AND   FA_CATE_MTRL_CD = A.CNTR_MTRL_CD) CATEGORY_SEGMENT  " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${hid_type} == '1') " ).append("\n"); 
		query.append("   , (SELECT SUBSTR(CA.FA_CATE_CD,1,11)||" ).append("\n"); 
		query.append("           LTRIM(TO_CHAR(TO_NUMBER(SUBSTR(CA.FA_CATE_CD,12)) - " ).append("\n"); 
		query.append("           ROUND(MONTHS_BETWEEN" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("           TO_DATE(TO_CHAR(MH.CNTR_STS_EVNT_DT,'YYYYMM'),'YYYYMM')," ).append("\n"); 
		query.append("           TO_DATE(TO_CHAR(DECODE(LA.DPC_VAL_FLG, 'Y', MH.CNTR_STS_EVNT_DT, NVL(A.MFT_DT,MH.CNTR_STS_EVNT_DT)),'YYYYMM'),'YYYYMM')" ).append("\n"); 
		query.append("           )  / 12 ),'00'))                                    " ).append("\n"); 
		query.append("    FROM LSE_AGREEMENT LA, MST_FA_CATE CA, MST_CNTR_STS_HIS MH" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND   A.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND   A.AGMT_SEQ = LA.AGMT_SEQ" ).append("\n"); 
		query.append("    AND   A.CNTR_TPSZ_CD = CA.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    AND   A.CNTR_MTRL_CD = CA.FA_CATE_MTRL_CD" ).append("\n"); 
		query.append("    AND   A.CNTR_NO = MH.CNTR_NO" ).append("\n"); 
		query.append("    AND   A.ONH_STS_SEQ = MH.CNTR_STS_SEQ) CATEGORY_SEGMENT" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   ,@[cntr_aqz_amt] COST" ).append("\n"); 
		query.append("   ,'CNTR' LOCATION_SEGMENT" ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE,'YYYYMMDD') DATE_PLACED_IN_SERVICE" ).append("\n"); 
		query.append("   ,A.CNTR_NO TAG_NUMBER" ).append("\n"); 
		query.append("   ,@[cntr_curr_cd] ATTRIBUTE1" ).append("\n"); 
		query.append("   ,@[cntr_aqz_amt] ATTRIBUTE2" ).append("\n"); 
		query.append("   ,@[cntr_invst_no] ATTRIBUTE3" ).append("\n"); 
		query.append("   ,A.FA_IF_GRP_SEQ_NO ATTRIBUTE4" ).append("\n"); 
		query.append("   ,'LSE' CREATED_BY" ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE,'YYYYMMDD') CREATION_DATE" ).append("\n"); 
		query.append("   ,'LSE' LAST_UPDATED_BY" ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE,'YYYYMMDD') LAST_UPDATE_DATE" ).append("\n"); 
		query.append("   #if (${hid_type} == '0')" ).append("\n"); 
		query.append("   ,B.VNDR_LGL_ENG_NM MANUFACTURER" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${hid_type} == '1') " ).append("\n"); 
		query.append("   ,'Free Purchase' MANUFACTURER" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   ,TO_CHAR(A.MFT_DT, 'YYYYMMDD') ATTRIBUTE21" ).append("\n"); 
		query.append("   #if (${hid_type} == '0')" ).append("\n"); 
		query.append("   ,REPLACE(@[de_yrmon], '-','') ACQ_MTH" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${hid_type} == '1') " ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE, 'YYYYMM') ACQ_MTH" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   MST_CONTAINER A," ).append("\n"); 
		query.append("   MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1 = 1   " ).append("\n"); 
		query.append("#if (${hid_type} == '0') " ).append("\n"); 
		query.append("AND A.LOT_PLN_YR    = @[lot_pln_yr]" ).append("\n"); 
		query.append("AND A.LOT_LOC_CD    = @[lot_loc_cd]" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD  = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND A.LOT_SEQ       = @[lot_seq]" ).append("\n"); 
		query.append("AND A.LSTM_CD = 'OW'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hid_type} == '1') " ).append("\n"); 
		query.append("AND A.TERM_CNG_SEQ = @[term_cng_seq]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY A.IF_SEQ" ).append("\n"); 

	}
}