/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRenewal2017RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRenewal2017RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRenewal2017RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpContainerRenewal2017RSQL").append("\n"); 
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
		query.append("SELECT --117 CNTR NO" ).append("\n"); 
		query.append("       RPAD(NVL(CNTR_NO, ' '), 12, ' ') AS DATA00," ).append("\n"); 
		query.append("       --118 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(NVL(UPPER(CNTR_SEAL_NO), ' '), 15, ' ') AS DATA01," ).append("\n"); 
		query.append("       --119 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(' ', 15, ' ') AS DATA02," ).append("\n"); 
		query.append("       --120 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(' ', 15, ' ') AS DATA03," ).append("\n"); 
		query.append("       --121 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(' ', 15, ' ') AS DATA04," ).append("\n"); 
		query.append("       --122 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(' ', 15, ' ') AS DATA05," ).append("\n"); 
		query.append("       --123 Seal NO (반복6)" ).append("\n"); 
		query.append("       RPAD(' ', 15, ' ') AS DATA06," ).append("\n"); 
		query.append("       --124 Empty/Full CNTR 표시" ).append("\n"); 
		query.append("       RPAD(DECODE(NVL(FULL_MTY_CD, ' '), 'M', '4', '5'), 3, ' ') AS DATA07," ).append("\n"); 
		query.append("       --125 CNTR 사이즈코드  (2)  M" ).append("\n"); 
		query.append("       NVL((SELECT SUBSTR(CNTR_TPSZ_ISO_CD, 1, 2)" ).append("\n"); 
		query.append("              FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("             WHERE CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1)," ).append("\n"); 
		query.append("            DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', '22', '3', '25', '4', '42', '5', '45', '6', '92', '7', '95', '8', '92', '9', '45', '95')) AS DATA08," ).append("\n"); 
		query.append("       --126 CNTR 타입코드  (2)   M" ).append("\n"); 
		query.append("       DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'D', 'GP', 'R', 'RT', 'O', 'UT', 'S', 'UT', 'F', 'PF', 'A', 'PF', 'P', 'PF', 'T', 'TN', 'GP') AS DATA09," ).append("\n"); 
		query.append("       --127 DEL Term  (2)   C" ).append("\n"); 
		query.append("       DECODE(NVL(DE_TERM_CD, ' '), 'Y', '51', 'S', '52', 'D', '53', '  ') AS DATA10," ).append("\n"); 
		query.append("       --128 컨테이너 소유 형태 코드  (3)   M" ).append("\n"); 
		query.append("       RPAD(NVL(JP_CNTR_OWNR_CD, '2'), 3, ' ') AS DATA11," ).append("\n"); 
		query.append("       --129 밴닝 형태 코드  (3)   C" ).append("\n"); 
		query.append("       DECODE(NVL(RCV_TERM_CD, ' '), 'S', '1  ', '4  ') AS DATA12," ).append("\n"); 
		query.append("       --130 컨테이너 조약적용 식별  (1)   M" ).append("\n"); 
		query.append("       '1' AS DATA13," ).append("\n"); 
		query.append("       --131 도매 컨테이너 자동추출 대상외 식별  (1)   C" ).append("\n"); 
		query.append("       ' ' AS DATA14" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_CNTR CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND JP_CSTMS_CNTR_STS_CD = 'A'" ).append("\n"); 

	}
}