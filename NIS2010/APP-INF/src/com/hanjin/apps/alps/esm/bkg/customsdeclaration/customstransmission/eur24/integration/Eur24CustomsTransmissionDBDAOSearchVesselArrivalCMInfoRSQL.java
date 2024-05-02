/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchVesselArrivalCMInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.09 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchVesselArrivalCMInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arrival Notice 화면의 IE347 전송을 위한 CM Info 조회
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchVesselArrivalCMInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchVesselArrivalCMInfoRSQL").append("\n"); 
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
		query.append("SELECT CM.CNTR_NO" ).append("\n"); 
		query.append("     , CM.CNTR_MF_SEQ" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER (ORDER BY CNTR_NO,CNTR_MF_SEQ) AS GOODS_ITEM_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_BL EB" ).append("\n"); 
		query.append("     , BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("     , BKG_VVD BV" ).append("\n"); 
		query.append("     , BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND EB.BL_NO = CM.BKG_NO" ).append("\n"); 
		query.append("   AND EB.BL_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("   AND (EB.BL_NO, EB.MSG_SND_NO) = ( SELECT BL_NO, MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                       FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("                                      WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                        --AND  MSG_SND_NO LIKE '%.344%'" ).append("\n"); 
		query.append("                                      GROUP BY BL_NO )  " ).append("\n"); 
		query.append("   AND CM.CNTR_NO > ' '                " ).append("\n"); 
		query.append("   AND CM.CNTR_MF_SEQ > 0" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND EB.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("   AND EB.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND EB.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND EB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND EB.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND EB.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND EB.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND EB.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 

	}
}