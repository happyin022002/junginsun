/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchVesselArrivalBlInfoRSQL.java
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

public class Eur24CustomsTransmissionDBDAOSearchVesselArrivalBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arrival Notice 화면의 IE347 전송을 위한 Bl Info 조회
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchVesselArrivalBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchVesselArrivalBlInfoRSQL").append("\n"); 
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
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("     , MVMT_REF_NO" ).append("\n"); 
		query.append("     , BKG_POL_CD" ).append("\n"); 
		query.append("     , BKG_POD_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , '' BL_ENTRY_LOC" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append(" WHERE (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD, MSG_SND_NO) " ).append("\n"); 
		query.append("       IN ( SELECT EB.VSL_CD, EB.SKD_VOY_NO, EB.SKD_DIR_CD, EB.BL_NO, EB.CSTMS_PORT_CD, MAX(EB.MSG_SND_NO)" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_EUR_BL EB, BKG_VVD BV, BKG_BOOKING BK" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND EB.BL_NO = BK.BKG_NO" ).append("\n"); 
		query.append("               AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("               AND EB.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("               AND EB.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND EB.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND EB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("               AND EB.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("               AND EB.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("               AND EB.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("               AND EB.POD_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("               AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             GROUP BY EB.VSL_CD, EB.SKD_VOY_NO, EB.SKD_DIR_CD, EB.BL_NO, EB.CSTMS_PORT_CD, EB.MSG_SND_NO )" ).append("\n"); 

	}
}