/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOModifyRtroactiveKindCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyRtroactiveKindCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT +1 이후 Contract No 변경여부를 기록한다.
	  * Work With Booking, Booking Status Report, Port Closing Report의 OFT Change after PCT (Retroactive Kind Code)
	  * * PCT가 현재시점 이후로 변경될 경우 RTRO_KND_CD를 리셋한다.
	  * </pre>
	  */
	public BlRatingDBDAOModifyRtroactiveKindCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyRtroactiveKindCdUSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SET    RTRO_KND_CD = CASE WHEN PORT_CLZ_DT +1 <= GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD) THEN NVL(@[rtro_knd_cd], RTRO_KND_CD)" ).append("\n"); 
		query.append("                          WHEN PORT_CLZ_DT > GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD) THEN NULL" ).append("\n"); 
		query.append("                     END," ).append("\n"); 
		query.append("       RTRO_REF_DT = CASE WHEN PORT_CLZ_DT <= GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD)" ).append("\n"); 
		query.append("                               AND @[rtro_knd_cd] IS NOT NULL THEN PORT_CLZ_DT" ).append("\n"); 
		query.append("                          ELSE RTRO_REF_DT" ).append("\n"); 
		query.append("                     END," ).append("\n"); 
		query.append("       RTRO_UPD_DT = CASE WHEN PORT_CLZ_DT <= GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD)" ).append("\n"); 
		query.append("                               AND @[rtro_knd_cd] IS NOT NULL THEN SYSDATE" ).append("\n"); 
		query.append("                          ELSE RTRO_UPD_DT" ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("WHERE B.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.SPLIT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.BKG_NO NOT IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                     FROM BKG_COD " ).append("\n"); 
		query.append("                     WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                     AND COD_STS_CD = 'F')" ).append("\n"); 

	}
}