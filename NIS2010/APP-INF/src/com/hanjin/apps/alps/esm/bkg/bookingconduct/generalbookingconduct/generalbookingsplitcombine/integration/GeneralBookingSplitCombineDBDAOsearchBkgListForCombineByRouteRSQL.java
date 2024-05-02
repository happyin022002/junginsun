/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.07.09 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForCombineByRoute
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByRouteRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("        , BK.BL_NO" ).append("\n"); 
		query.append("        , BK.BKG_STS_CD" ).append("\n"); 
		query.append("        , REPLACE(CUST.CUST_NM, CHR(13)||CHR(10), ' ') CUST_NM " ).append("\n"); 
		query.append("        , BK.POR_CD" ).append("\n"); 
		query.append("        , SUBSTR(BK.POR_NOD_CD, 6, 2) POR_NOD_CD" ).append("\n"); 
		query.append("        , BK.POL_CD" ).append("\n"); 
		query.append("        , SUBSTR(BK.POL_NOD_CD, 6, 2) POL_NOD_CD" ).append("\n"); 
		query.append("        , BK.POD_CD" ).append("\n"); 
		query.append("        , SUBSTR(BK.POD_NOD_CD, 6, 2) POD_NOD_CD" ).append("\n"); 
		query.append("        , BK.DEL_CD" ).append("\n"); 
		query.append("        , SUBSTR(BK.DEL_NOD_CD, 6, 2) DEL_NOD_CD" ).append("\n"); 
		query.append("--        , BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(SUM(CNTR_VOL_QTY),'990.99'))" ).append("\n"); 
		query.append("--                                 FROM BKG_CONTAINER" ).append("\n"); 
		query.append("--                                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("--                                GROUP BY CNTR_TPSZ_CD)) CNTR_VOL" ).append("\n"); 
		query.append("		, (SELECT TO_CHAR(C.BKG_CZ_DESC) FROM BKG_CNTR_CZ C WHERE C.BKG_NO = BK.BKG_NO AND C.BKG_CZ_STS_CD = 'CQ') CNTR_VOL" ).append("\n"); 
		query.append("        , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("		, CUST.CUST_CNT_CD||CUST.CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("		, BL.BDR_FLG" ).append("\n"); 
		query.append("		, (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER BROKER WHERE BROKER.BKG_CUST_TP_CD = 'B' AND BROKER.BKG_NO = BK.BKG_NO) BROKER" ).append("\n"); 
		query.append("		, BK.BKG_OFC_CD " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("		, BKG_BL_DOC BL" ).append("\n"); 
		query.append("        , BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("        , BKG_VVD VVD" ).append("\n"); 
		query.append("		, BKG_BL_ISS ISS" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO            = CUST.BKG_NO " ).append("\n"); 
		query.append("   AND BK.BKG_NO			= BL.BKG_NO" ).append("\n"); 
		query.append("   AND CUST.BKG_CUST_TP_CD  = 'S' " ).append("\n"); 
		query.append("   AND BK.BKG_NO            = ISS.BKG_NO(+)  " ).append("\n"); 
		query.append("   AND BK.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BK.POL_CD            = VVD.POL_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD   IN ('S', 'T')" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD        <> 'X'             --cancel 제외" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD     <> 'P'             --empty repo 제외 " ).append("\n"); 
		query.append("   AND nvl(ISS.OBL_ISS_FLG(+), 'N')      = 'N' --B/L ISSUE 되면 제외" ).append("\n"); 
		query.append("   AND NVL(BK.SPLIT_RSN_CD, 'X') <> 'M'        --memo split mst 제외  " ).append("\n"); 
		query.append("   AND BK.ADV_SHTG_CD IS NULL" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} !='')" ).append("\n"); 
		query.append("   --shpper cnt_cd 입력시 " ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} !='')" ).append("\n"); 
		query.append("   --shpper cust Seq 입력시   " ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} !='')" ).append("\n"); 
		query.append("   --shpper cust name 입력시   " ).append("\n"); 
		query.append("   AND UPPER(CUST.CUST_NM) LIKE UPPER(@[cust_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("   --vvd 입력 mandatory" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("   --pol 입력 <- hitchment check시 mandatory가 아님" ).append("\n"); 
		query.append("   AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_nod_cd} !='')" ).append("\n"); 
		query.append("   --node 입력시   " ).append("\n"); 
		query.append("   AND BK.POL_NOD_CD = @[pol_cd]||@[pol_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} !='')" ).append("\n"); 
		query.append("   --pod 입력 mandatory" ).append("\n"); 
		query.append("   AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_nod_cd} !='')" ).append("\n"); 
		query.append("   --node 입력시   " ).append("\n"); 
		query.append("   AND BK.POD_NOD_CD = @[pod_cd]||@[pod_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} !='')" ).append("\n"); 
		query.append("   --del 입력시" ).append("\n"); 
		query.append("   AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_nod_cd} !='')" ).append("\n"); 
		query.append("   --node 입력시   " ).append("\n"); 
		query.append("   AND BK.DEL_NOD_CD = @[del_cd]||@[del_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}