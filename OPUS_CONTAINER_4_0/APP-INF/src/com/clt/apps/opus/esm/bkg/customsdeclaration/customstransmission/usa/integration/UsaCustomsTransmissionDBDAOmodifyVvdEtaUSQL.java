/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOmodifyVvdEtaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOmodifyVvdEtaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, BKG_CSTMS_ADV_VVD_ARR에 갱신.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOmodifyVvdEtaUSQL(){
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
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snd_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt_format",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOmodifyVvdEtaUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_VVD_ARR V" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("        EDA_UPD_DT = GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, 'USNYC')," ).append("\n"); 
		query.append("        OFC_CD = @[snd_usr_ofc_cd]," ).append("\n"); 
		query.append("        UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	V.CNT_CD = 'US'" ).append("\n"); 
		query.append("    AND V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    AND V.ETA_DT = TO_DATE(@[eta_dt], @[eta_dt_format])" ).append("\n"); 

	}
}