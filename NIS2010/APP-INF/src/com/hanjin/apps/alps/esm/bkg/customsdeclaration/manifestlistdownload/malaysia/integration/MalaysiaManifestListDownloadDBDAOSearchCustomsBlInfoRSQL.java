/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL").append("\n"); 
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
		query.append("SELECT    B.BL_NO" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.POR_CD" ).append("\n"); 
		query.append(",B.POL_CD" ).append("\n"); 
		query.append(",B.POD_CD" ).append("\n"); 
		query.append(",B.DEL_CD" ).append("\n"); 
		query.append(",B.RCV_TERM_CD" ).append("\n"); 
		query.append(",B.DE_TERM_CD" ).append("\n"); 
		query.append(",B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD TRNK_VVD" ).append("\n"); 
		query.append(",B.POL_CD TRNK_POL" ).append("\n"); 
		query.append(",B.POD_CD TRNK_POD" ).append("\n"); 
		query.append(",TRIM(D.CSTMS_DESC) DESCRIPTION      --특수문자 고려!   ,TRIM(D.CSTMS_DESC) DESCRIPTION" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(SUBSTR(D.CSTMS_DESC, 1, 70),'Y') DESCRIPTION2" ).append("\n"); 
		query.append(",D.PCK_QTY" ).append("\n"); 
		query.append(",D.PCK_TP_CD" ).append("\n"); 
		query.append(",D.ACT_WGT" ).append("\n"); 
		query.append(",D.WGT_UT_CD" ).append("\n"); 
		query.append(",D.MEAS_QTY" ).append("\n"); 
		query.append(",D.MEAS_UT_CD" ).append("\n"); 
		query.append(",B.DCGO_FLG" ).append("\n"); 
		query.append(",B.RD_CGO_FLG" ).append("\n"); 
		query.append(",B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",B.BB_CGO_FLG" ).append("\n"); 
		query.append(",V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",NVL((" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_CUST_TP_CD='C'" ).append("\n"); 
		query.append("AND BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("AND CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND CUST_NM IS NOT NULL" ).append("\n"); 
		query.append("AND CUST_ADDR IS NOT NULL" ).append("\n"); 
		query.append("),'N') CN_FLG    --consignee가 존재하는 가 존재하지 않는가 여부 찍기 (2012.06.26)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append(",'T' TS_TP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'L' TS_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM      BKG_VVD V, BKG_BOOKING B, BKG_BL_MK_DESC M, BKG_BL_DOC D" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       V.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND       V.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND       V.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_pod_cd} != '')" ).append("\n"); 
		query.append("AND       V.POD_CD = @[s_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("AND       V.POD_CD <> B.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       V.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_pol_cd} != '')" ).append("\n"); 
		query.append("AND       V.POL_CD = @[s_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("AND       V.POL_CD <> B.POL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       V.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_por_cd} != '')" ).append("\n"); 
		query.append("AND       B.POR_CD = @[s_trunk_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_pol_cd} != '')" ).append("\n"); 
		query.append("AND       B.POL_CD = @[s_trunk_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_pod_cd} != '')" ).append("\n"); 
		query.append("AND       B.POD_CD = @[s_trunk_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_del_cd} != '')" ).append("\n"); 
		query.append("AND       B.DEL_CD = @[s_trunk_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND       M.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("AND       M.MK_SEQ(+) = 1" ).append("\n"); 
		query.append("AND       D.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}