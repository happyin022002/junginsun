/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchOfmMiHiHeaderFooterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchOfmMiHiHeaderFooterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim OFM 생성용 헤더 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchOfmMiHiHeaderFooterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lloyd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchOfmMiHiHeaderFooterRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	'$$$MSGSTART & SMLM & SHACUST & CAMIR & '||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC'),'ddmmrrhh24miss')||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_LLOYDCODE | '||@[vsl_lloyd]||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_FULLNAME | ' ||substr(@[vsl_eng_nm],1,23)||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_VOYAGE | '	  ||substr(@[vvd],5,4)||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_DIRECTION | '||substr(@[vvd],9,1)||CHR(10)||" ).append("\n"); 
		query.append("	'VSL_FLAG | '	  ||@[vsl_flag]||CHR(10)||" ).append("\n"); 
		query.append("	'BL_COUNT | '	  ||@[bl_cnt]||CHR(10)||" ).append("\n"); 
		query.append("	'POL_LOC | '	  ||@[pol_name]||CHR(10)||" ).append("\n"); 
		query.append("	'POL_ETD | '	  ||@[vps_etd_dt]||CHR(10)||" ).append("\n"); 
		query.append("	'POD_LOC | '	  ||@[pod_name]||CHR(10)||" ).append("\n"); 
		query.append("	'POD_ETA | '	  ||@[vps_eta_dt]||CHR(10) HEADER," ).append("\n"); 
		query.append("	'' FOOTER" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}