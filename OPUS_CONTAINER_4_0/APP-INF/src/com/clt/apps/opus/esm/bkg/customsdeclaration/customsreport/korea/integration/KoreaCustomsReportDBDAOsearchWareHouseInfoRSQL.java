/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchWareHouseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchWareHouseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse (Bonded Area) Detail을 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchWareHouseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchWareHouseInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(CNT_CD, ' ') CNT_CD" ).append("\n"); 
		query.append("     , NVL(WH_CD, ' ') WH_CD" ).append("\n"); 
		query.append("     , NVL(WH_NM, ' ') WH_NM" ).append("\n"); 
		query.append("     , NVL(WH_ADDR, ' ') WH_ADDR" ).append("\n"); 
		query.append("     , NVL(LOC_CD, ' ') LOC_CD" ).append("\n"); 
		query.append("     , NVL(CSTMS_CD, ' ') CSTMS_CD" ).append("\n"); 
		query.append("     , NVL(PHN_NO, ' ') PHN_NO" ).append("\n"); 
		query.append("     , NVL(FAX_NO, ' ') FAX_NO" ).append("\n"); 
		query.append("     , NVL(PSON_NM, ' ') PSON_NM" ).append("\n"); 
		query.append("     , NVL(DIFF_RMK, ' ') DIFF_RMK" ).append("\n"); 
		query.append("  FROM BKG_WAREHOUSE" ).append("\n"); 
		query.append(" WHERE CNT_CD LIKE @[cnt_cd]" ).append("\n"); 
		query.append("#if(${wh_cd} != '')" ).append("\n"); 
		query.append("   AND WH_CD LIKE '%'||@[wh_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("   AND LOC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wh_nm} != '')" ).append("\n"); 
		query.append("   AND WH_NM LIKE '%'||@[wh_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cstms_cd} != '')" ).append("\n"); 
		query.append("   AND CSTMS_CD LIKE '%'||@[cstms_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}